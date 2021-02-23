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
package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import java.util.Map;

import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlProperty;
import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlType;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlSupport;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerBase;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializationContext;
import org.apache.camel.model.SagaActionUriDefinition;
import org.apache.camel.model.ToDefinition;
import org.apache.camel.util.ObjectHelper;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;

@YamlType(
    types = SagaActionUriDefinition.class,
    order = YamlDeserializerResolver.ORDER_DEFAULT,
    properties = {
        @YamlProperty(name = "uri", type = "string", required = true)
    }
)
public class SagaActionUriDefinitionDeserializer extends YamlDeserializerBase<SagaActionUriDefinition> {
    public SagaActionUriDefinitionDeserializer() {
        super(SagaActionUriDefinition.class);
    }

    @Override
    protected SagaActionUriDefinition newInstance() {
        return new SagaActionUriDefinition();
    }

    @Override
    protected SagaActionUriDefinition newInstance(String value) {
        return new SagaActionUriDefinition(value);
    }

    @Override
    protected void setProperties(SagaActionUriDefinition target, MappingNode node){
        final YamlDeserializationContext dc = getDeserializationContext(node);

        String uri = null;
        Map<String, Object> properties = null;

        for (NodeTuple tuple : node.getValue()) {
            final String key = YamlDeserializerSupport.asText(tuple.getKeyNode());
            final Node val = tuple.getValueNode();

            setDeserializationContext(val, dc);

            switch (key) {
                case YamlDeserializerBase.STEPS_NODE:
                    setSteps(target, YamlDeserializerSupport.asSequenceNode(val));
                    break;
                case "uri":
                    uri = YamlDeserializerSupport.asText(val);
                    break;
                case "properties":
                    properties = YamlDeserializerSupport.asScalarMap(tuple.getValueNode());
                    break;
                default:
                    ConstructNode cn = EndpointProducerDeserializersResolver.resolveEndpointConstructor(key);
                    if (cn != null) {
                        if (uri != null || properties != null) {
                            throw new IllegalArgumentException("uri and properties are not supported when using Endpoint DSL ");
                        }
                        target.setUri(((ToDefinition)cn.construct(val)).getEndpointUri());
                    } else {
                        throw new IllegalArgumentException("Unsupported field: " + key);
                    }
            }
        }

        if (target.getUri() == null) {
            ObjectHelper.notNull("uri", "The uri must set");

            target.setUri(
                YamlSupport.createEndpointUri(dc.getCamelContext(), uri, properties)
            );
        }
    }
}
