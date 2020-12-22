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
package com.github.lburgazzoli.camel.dsl.yaml.quarkus.it;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.camel.util.IOHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class YamlRoutesBuilderLoaderTest {
    @ParameterizedTest
    @ValueSource(strings = {"/routes.yaml", "/routes_with_endpoint.yaml"})
    public void testLoadRoutes(String location) throws IOException {
        String code;

        try (InputStream is = YamlRoutesBuilderLoaderTest.class.getResourceAsStream(location)) {
            code = IOHelper.loadText(is);
        }

        JsonPath p = RestAssured.given()
            .contentType(MediaType.TEXT_PLAIN)
            .accept(MediaType.APPLICATION_JSON)
            .body(code)
            .post("/test/load-routes/routes.yaml")
            .then()
                .statusCode(200)
            .extract()
                .body()
                .jsonPath();

        assertThat(p.getList("components", String.class))
            .contains("direct");
        assertThat(p.getList("routes", String.class))
            .contains("yaml");
        assertThat(p.getList("endpoints", String.class))
            .contains("direct://from", "direct://to");
    }
}
