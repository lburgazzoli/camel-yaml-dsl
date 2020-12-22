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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.CamelContext;
import org.apache.camel.Consume;
import org.apache.camel.ExtendedCamelContext;
import org.apache.camel.spi.Resource;

@Path("/test")
@ApplicationScoped
public class YamlRoutesBuilderLoaderApplication {
    @Inject
    CamelContext context;

    @POST
    @Path("/load-routes/{name}")
    @Consume(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject loadRoutes(@PathParam("name") String name, String code) throws Exception {
        context.adapt(ExtendedCamelContext.class).getRoutesLoader().loadRoutes(
            Resource.fromString(name, code)
        );

        return Json.createObjectBuilder()
            .add("components", extractComponents(context))
            .add("routes", extractRoutes(context))
            .add("endpoints", extractEndpoints(context))
            .build();
    }


    public static JsonArrayBuilder extractComponents(CamelContext context) {
        JsonArrayBuilder answer = Json.createArrayBuilder();
        context.getComponentNames().forEach(answer::add);

        return answer;
    }

    public static JsonArrayBuilder extractRoutes(CamelContext context) {
        JsonArrayBuilder answer = Json.createArrayBuilder();
        context.getRoutes().forEach(r -> answer.add(r.getId()));

        return answer;
    }

    public static JsonArrayBuilder extractEndpoints(CamelContext context) {
        JsonArrayBuilder answer = Json.createArrayBuilder();
        context.getEndpoints().forEach(e -> answer.add(e.getEndpointUri()));

        return answer;
    }
}
