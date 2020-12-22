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

import java.util.HashMap;
import java.util.Map;

import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializationContext;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlSupport;
import com.github.lburgazzoli.camel.dsl.yaml.common.exception.UnsupportedNodeTypeException;
import org.apache.camel.model.FromDefinition;
import org.apache.camel.model.ToDefinition;
import org.apache.camel.util.StringHelper;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.NodeType;

public final class EndpointDeserializers {
    private EndpointDeserializers() {
    }

    private static String creteEndpointUri(String scheme, Node node) {
        switch (node.getNodeType()) {
            case SCALAR:
                return scheme + ':' + YamlDeserializerSupport.asText(node);
            case MAPPING:
                final YamlDeserializationContext dc = YamlDeserializerSupport.getDeserializationContext(node);
                final MappingNode bn = YamlDeserializerSupport.asMappingNode(node);
                final Map<String, Object> parameters = new HashMap<>();

                for (NodeTuple tuple : bn.getValue()) {
                    final String key = YamlDeserializerSupport.asText(tuple.getKeyNode());
                    final Node val = tuple.getValueNode();

                    if (val.getNodeType() == NodeType.SCALAR) {
                        parameters.put(StringHelper.dashToCamelCase(key), YamlDeserializerSupport.asText(val));
                    } else {
                        throw new UnsupportedNodeTypeException(node);
                    }
                }

                return YamlSupport.createEndpointUri(dc.getCamelContext(), scheme, parameters);
            default:
                throw new UnsupportedNodeTypeException(node);
        }
    }

    public static class From implements ConstructNode {
        private final String scheme;

        public From(String scheme) {
            this.scheme = scheme;
        }

        @Override
        public Object construct(Node node) {
            return new FromDefinition(creteEndpointUri(scheme, node));
        }
    }

    public static class To implements ConstructNode {
        private final String scheme;

        public To(String scheme) {
            this.scheme = scheme;
        }

        @Override
        public Object construct(Node node) {
            return new ToDefinition(creteEndpointUri(scheme, node));
        }
    }
}
