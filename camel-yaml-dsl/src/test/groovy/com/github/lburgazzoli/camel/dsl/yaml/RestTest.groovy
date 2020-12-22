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
package com.github.lburgazzoli.camel.dsl.yaml


import com.github.lburgazzoli.camel.dsl.yaml.support.YamlTestSupport
import org.apache.camel.model.ToDefinition
import org.apache.camel.model.rest.RestDefinition
import org.apache.camel.model.rest.VerbDefinition

class RestTest extends YamlTestSupport {

    def "load rest (to)"() {
        when:
            loadRoutes '''
                - beans:
                  - name: myRestConsumerFactory
                    type: com.github.lburgazzoli.camel.dsl.yaml.support.MockRestConsumerFactory
                - rest:
                    verb:
                      - method: get
                        uri: "/foo"
                        type: com.github.lburgazzoli.camel.dsl.yaml.support.model.MyFooBar
                        out-type: com.github.lburgazzoli.camel.dsl.yaml.support.model.MyBean
                        to: "direct:bar"
                - from:
                    uri: 'direct:bar'
                    steps:
                      - to: 'mock:bar'          
            '''
        then:
            context.restDefinitions.size() == 1

            with(context.restDefinitions[0], RestDefinition) {
                verbs.size() == 1

                with(verbs[0], VerbDefinition) {
                    uri == '/foo'
                    type == 'com.github.lburgazzoli.camel.dsl.yaml.support.model.MyFooBar'
                    outType == 'com.github.lburgazzoli.camel.dsl.yaml.support.model.MyBean'

                    with(to, ToDefinition) {
                        endpointUri == 'direct:bar'
                    }
                }
            }
    }

    def "load rest (route)"() {
        when:
            loadRoutes '''
                - beans:
                  - name: myRestConsumerFactory
                    type: com.github.lburgazzoli.camel.dsl.yaml.support.MockRestConsumerFactory
                - rest:
                    verb:
                      - method: get
                        uri: "/foo"
                        type: com.github.lburgazzoli.camel.dsl.yaml.support.model.MyFooBar
                        out-type: com.github.lburgazzoli.camel.dsl.yaml.support.model.MyBean
                        steps:
                          - to: "direct:bar"
                - from:
                    uri: 'direct:bar'
                    steps:
                      - to: 'mock:bar'
            '''
        then:
            context.restDefinitions.size() == 1

            with(context.restDefinitions[0], RestDefinition) {
                verbs.size() == 1

                with(verbs[0], VerbDefinition) {
                    uri == '/foo'
                    type == 'com.github.lburgazzoli.camel.dsl.yaml.support.model.MyFooBar'
                    outType == 'com.github.lburgazzoli.camel.dsl.yaml.support.model.MyBean'

                    with (route.outputs[0], ToDefinition) {
                        endpointUri  == 'direct:bar'
                    }
                }
            }
    }
}
