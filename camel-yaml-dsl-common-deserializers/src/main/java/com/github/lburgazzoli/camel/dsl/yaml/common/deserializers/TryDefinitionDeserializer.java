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

import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlProperty;
import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlType;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializationContext;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver;
import org.apache.camel.model.CatchDefinition;
import org.apache.camel.model.FinallyDefinition;
import org.apache.camel.model.TryDefinition;
import org.snakeyaml.engine.v2.nodes.Node;

@YamlType(
    nodes = "do-try",
    types = TryDefinition.class,
    order = YamlDeserializerResolver.ORDER_DEFAULT,
    properties = {
        @YamlProperty(name = "__extends", type = "ref:org.apache.camel.model.TryDefinition"),
        @YamlProperty(name = "do-catch", type = "object:org.apache.camel.model.CatchDefinition"),
        @YamlProperty(name = "do-finally", type = "object:org.apache.camel.model.FinallyDefinition")
    }
)
public class TryDefinitionDeserializer extends ModelDeserializers.TryDefinitionDeserializer {
    @Override
    protected void handleUnknownProperty(TryDefinition target, String propertyKey, String propertyName, Node value) {
        switch (propertyKey) {
            case "do-catch": {
                YamlDeserializationContext dc = getDeserializationContext(value);
                CatchDefinition definition = dc.construct(propertyKey, value, CatchDefinition.class);

                target.addOutput(definition);
                break;
            }
            case "do-finally": {
                YamlDeserializationContext dc = getDeserializationContext(value);
                FinallyDefinition definition = dc.construct(propertyKey, value, FinallyDefinition.class);

                target.addOutput(definition);
                break;
            }
            default:
                super.handleUnknownProperty(target, propertyKey, propertyName, value);
                break;

        }
    }
}
