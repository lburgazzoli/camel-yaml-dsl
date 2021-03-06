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
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializationContext;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlSupport;
import org.apache.camel.model.FromDefinition;
import org.apache.camel.util.ObjectHelper;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.NodeType;

import static com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport.asScalarMap;
import static com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport.asText;
import static com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport.getDeserializationContext;
import static com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport.setDeserializationContext;

@YamlType(
    inline = true,
    types = FromDefinition.class,
    order = YamlDeserializerResolver.ORDER_DEFAULT,
    properties = {
        @YamlProperty(name = "uri", type = "string", required = true),
        @YamlProperty(name = "properties", type = "object")
    }
)
public class FromDefinitionDeserializer implements ConstructNode {
    @Override
    public Object construct(Node node) {
        return constructFromDefinition(node);
    }

    public static FromDefinition constructFromDefinition(Node node) {
        if (node.getNodeType() == NodeType.SCALAR) {
            return new FromDefinition(asText(node));
        } else if (node.getNodeType() == NodeType.MAPPING) {
            final MappingNode mn = (MappingNode) node;
            final YamlDeserializationContext dc = getDeserializationContext(node);

            String uri = null;
            Map<String, Object> properties = null;

            for (NodeTuple tuple : mn.getValue()) {
                final String key = asText(tuple.getKeyNode());
                final Node val = tuple.getValueNode();

                setDeserializationContext(val, dc);

                switch (key) {
                    case "uri":
                        uri = asText(val);
                        break;
                    case "properties":
                        properties = asScalarMap(tuple.getValueNode());
                        break;
                    default:
                        ConstructNode cn = EndpointConsumerDeserializersResolver.resolveEndpointConstructor(key);
                        if (cn != null) {
                            if (uri != null || properties != null) {
                                throw new IllegalArgumentException("uri and properties are not supported when using Endpoint DSL ");
                            }
                            return (FromDefinition) cn.construct(val);
                        } else {
                            throw new IllegalArgumentException("Unsupported field: " + key);
                        }
                }

                ObjectHelper.notNull("uri", "The uri must set");
            }

            return new FromDefinition(
                YamlSupport.createEndpointUri(dc.getCamelContext(), uri, properties)
            );
        }

        return null;
    }
}
