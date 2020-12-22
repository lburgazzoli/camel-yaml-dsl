/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.lburgazzoli.camel.dsl.yaml.common;

import java.util.Locale;

import org.apache.camel.model.Block;
import org.apache.camel.model.OutputNode;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.util.StringHelper;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.NodeType;
import org.snakeyaml.engine.v2.nodes.ScalarNode;
import org.snakeyaml.engine.v2.nodes.SequenceNode;

public abstract class YamlDeserializerBase<T> extends YamlDeserializerSupport implements ConstructNode {
    public static final String STEPS_NODE = "steps";

    private final Class<T> type;

    public YamlDeserializerBase(Class<T> type) {
        this.type = type;
    }

    public Class<T> getType() {
        return type;
    }

    @Override
    public Object construct(Node node) {
        final T target;

        if (node.getNodeType() == NodeType.SCALAR) {
            ScalarNode mn = (ScalarNode)node;
            target = newInstance(mn.getValue());
        } else if (node.getNodeType() == NodeType.MAPPING) {
            MappingNode mn = (MappingNode)node;
            target = newInstance();

            setProperties(target, mn);
        } else {
            throw new IllegalArgumentException("Unsupported node type: " + node);
        }

        return target;
    }

    /**
     * Creates a Java instance of the expected type.
     *
     * @return the instance.
     */
    protected abstract T newInstance();

    /**
     * Creates a Java instance of the expected type from a string.
     *
     * @return the instance.
     */
    protected T newInstance(String value) {
        throw new IllegalArgumentException("Unsupported " + value);
    }

    /**
     * Set a property to the given target.
     *
     * @param target the target object
     * @param propertyKey the normalized property key
     * @param propertyName the name of the property as defined in the YAML
     * @param value the value of the property as {@link Node}
     */
    protected boolean setProperty(T target, String propertyKey, String propertyName, Node value) {
        return false;
    }

    /**
     * Set properties from a YAML node to the given target.
     *
     * @param node the node
     * @param target the target object
     */
    protected void setProperties(T target, MappingNode node) {
        YamlDeserializationContext dc = getDeserializationContext(node);

        for (NodeTuple tuple : node.getValue()) {
            final ScalarNode key = (ScalarNode)tuple.getKeyNode();
            final String propertyName = StringHelper.camelCaseToDash(key.getValue()).toLowerCase(Locale.US);
            final Node val = tuple.getValueNode();

            setDeserializationContext(val, dc);

            if (!setProperty(target, propertyName, key.getValue(), val)) {
                handleUnknownProperty(target, propertyName, key.getValue(), val);
            }
        }
    }

    /**
     * Set the output {@link ProcessorDefinition} to the given target.
     *
     * @param steps the steps
     * @param target the target object
     * @throws IllegalArgumentException if the target does not support outputs
     */
    protected void setSteps(T target, SequenceNode steps) {
        YamlDeserializationContext dc = getDeserializationContext(steps);

        for (Node step: steps.getValue()) {
            setDeserializationContext(step, dc);

            addStep(target, step);
        }
    }

    /**
     * Add an {@link ProcessorDefinition} to the given target.
     *
     * @param step the step
     * @param target the target object
     * @throws IllegalArgumentException if the target does not support outputs
     */
    protected void addStep(T target, Node step) {
        if (!(target instanceof OutputNode)) {
            throw new IllegalArgumentException("The " + target.getClass().getName() + " does not support processing steps");
        }

        YamlDeserializationContext dc = getDeserializationContext(step);
        ConstructNode constructor = dc.mandatoryResolve(step);
        ProcessorDefinition<?> proc = (ProcessorDefinition<?>)constructor.construct(step);

        ((Block)target).addOutput(proc);
    }

    protected void handleUnknownProperty(T target, String propertyKey, String propertyName, Node value) {
        throw new IllegalArgumentException("Unsupported field: " + propertyName + " on " + target.getClass().getName());
    }
}
