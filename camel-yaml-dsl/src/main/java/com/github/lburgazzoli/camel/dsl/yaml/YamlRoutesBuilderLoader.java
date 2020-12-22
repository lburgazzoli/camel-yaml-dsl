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
package com.github.lburgazzoli.camel.dsl.yaml;

import java.io.InputStream;
import java.util.List;

import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializationContext;
import com.github.lburgazzoli.camel.dsl.yaml.common.deserializers.CustomResolver;
import com.github.lburgazzoli.camel.dsl.yaml.common.deserializers.EndpointProducerDeserializersResolver;
import com.github.lburgazzoli.camel.dsl.yaml.common.deserializers.ModelDeserializersResolver;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.ErrorHandlerBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.FromDefinition;
import org.apache.camel.model.OnExceptionDefinition;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.rest.RestDefinition;
import org.apache.camel.model.rest.VerbDefinition;
import org.apache.camel.spi.CamelContextCustomizer;
import org.apache.camel.spi.Resource;
import org.apache.camel.spi.RoutesBuilderLoader;
import org.apache.camel.spi.annotations.JdkService;
import org.apache.camel.support.RoutesBuilderLoaderSupport;
import org.apache.camel.support.service.ServiceHelper;
import org.apache.camel.util.ObjectHelper;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

@JdkService(RoutesBuilderLoader.FACTORY_GROUP + "/" + YamlRoutesBuilderLoader.EXTENSION)
public class YamlRoutesBuilderLoader extends RoutesBuilderLoaderSupport {
    public static final String EXTENSION = "yaml";

    private LoadSettings settings;
    private YamlDeserializationContext constructor;

    public YamlRoutesBuilderLoader() {
    }

    @Override
    public String getSupportedExtension() {
        return EXTENSION;
    }

    @Override
    protected void doBuild() throws Exception {
        super.doBuild();

        this.settings = LoadSettings.builder().build();
        this.constructor = new YamlDeserializationContext(settings);
        this.constructor.setCamelContext(getCamelContext());
        this.constructor.addResolvers(new CustomResolver());
        this.constructor.addResolvers(new ModelDeserializersResolver());
        this.constructor.addResolvers(new EndpointProducerDeserializersResolver());
    }

    @Override
    protected void doStart() throws Exception {
        super.doStart();

        ServiceHelper.startService(this.constructor);
    }

    @Override
    protected void doStop() throws Exception {
        super.doStop();

        ServiceHelper.stopService(this.constructor);

        this.constructor = null;
        this.settings = null;
    }

    @Override
    public RoutesBuilder loadRoutesBuilder(Resource resource) throws Exception {
        ObjectHelper.notNull(constructor, "constructor");
        ObjectHelper.notNull(settings, "settings");

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                Load load = new Load(settings, constructor);
                try (InputStream is = resource.getInputStream()) {
                    for (Object item : (List<?>) load.loadFromInputStream(is)) {
                        configure(item);
                    }
                }
            }

            private void configure(Object item) {
                if (item instanceof FromDefinition) {
                    getRouteCollection().route().setInput((FromDefinition) item);
                } else if (item instanceof RouteDefinition) {
                    getRouteCollection().route((RouteDefinition) item);
                } else if (item instanceof RestDefinition) {
                    RestDefinition definition = (RestDefinition) item;
                    for (VerbDefinition verb: definition.getVerbs()) {
                        verb.setRest(definition);
                    }
                    getRestCollection().rest(definition);
                } else if (item instanceof CamelContextCustomizer) {
                    ((CamelContextCustomizer) item).configure(getCamelContext());
                } else if (item instanceof OnExceptionDefinition) {
                    if (!getRouteCollection().getRoutes().isEmpty()) {
                        throw new IllegalArgumentException("onException must be defined before any routes in the RouteBuilder");
                    }
                    getRouteCollection().getOnExceptions().add((OnExceptionDefinition)item);
                } else if (item instanceof ErrorHandlerBuilder) {
                    if (!getRouteCollection().getRoutes().isEmpty()) {
                        throw new IllegalArgumentException("errorHandler must be defined before any routes in the RouteBuilder");
                    }
                    errorHandler((ErrorHandlerBuilder)item);
                }
            }
        };
    }

}
