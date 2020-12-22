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
package com.github.lburgazzoli.camel.tooling.maven.yaml;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import com.github.lburgazzoli.camel.tooling.maven.yaml.suport.ToolingSupport;
import com.github.lburgazzoli.camel.tooling.maven.yaml.suport.TypeSpecHolder;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import org.apache.camel.catalog.CamelCatalog;
import org.apache.camel.catalog.DefaultCamelCatalog;
import org.apache.camel.tooling.model.ComponentModel;
import org.apache.camel.util.StringHelper;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationValue;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.FieldInfo;
import org.jboss.jandex.MethodInfo;
import org.jboss.jandex.ParameterizedType;
import org.jboss.jandex.Type;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.Node;

@Mojo(
    name = "generate-yaml-deserializers",
    inheritByDefault = false,
    defaultPhase = LifecyclePhase.GENERATE_SOURCES,
    requiresDependencyResolution = ResolutionScope.COMPILE,
    threadSafe = true)
public class GenerateYamlDeserializersMojo extends GenerateYamlSupportMojo {
    @Parameter(defaultValue = "com.github.lburgazzoli.camel.dsl.yaml.support.deserializers")
    protected String packageName;
    @Parameter(defaultValue = "${project.basedir}/src/generated/java")
    protected File sourcesOutputDir;
    @Parameter(defaultValue = "${project.basedir}/src/generated/resources")
    protected File resourcesOutputDir;

    @Override
    public void execute() throws MojoFailureException {
        try {
            JavaFile.builder(packageName, generateExpressionDeserializers())
                .indent("    ")
                .build()
                .writeTo(sourcesOutputDir.toPath());

            for (TypeSpec type: generateEndpointProducer()) {
                JavaFile.builder(packageName, type)
                    .indent("    ")
                    .build()
                    .writeTo(sourcesOutputDir.toPath());
            }
            for (TypeSpec type: generateEndpointConsumer()) {
                JavaFile.builder(packageName, type)
                    .indent("    ")
                    .build()
                    .writeTo(sourcesOutputDir.toPath());
            }
            for (TypeSpec type: generateDeserializers()) {
                JavaFile.builder(packageName, type)
                    .indent("    ")
                    .build()
                    .writeTo(sourcesOutputDir.toPath());
            }
        } catch (Exception e) {
            throw new MojoFailureException(e.getMessage(), e);
        }
    }

    private TypeSpec generateExpressionDeserializers() {
        TypeSpec.Builder type = TypeSpec.classBuilder("ExpressionDeserializers");
        type.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        type.superclass(CN_DESERIALIZER_SUPPORT);

        // add private constructor
        type.addMethod(MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PRIVATE)
            .build());

        // parser
        type.addMethod(MethodSpec.methodBuilder("constructExpressionType")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(Node.class, "node")
            .returns(CN_EXPRESSION_DEFINITION)
            .addCode(
                CodeBlock.builder()
                    .addStatement("var mn = asMappingNode(node)")
                    .beginControlFlow("if (mn.getValue().size() != 1)")
                        .addStatement("return null")
                    .endControlFlow()
                    .addStatement("var nt = mn.getValue().get(0)")
                    .addStatement("var dc = getDeserializationContext(node)")
                    .addStatement("var key = asText(nt.getKeyNode())")
                    .addStatement("var val = setDeserializationContext(nt.getValueNode(), dc)")
                    .addStatement("return constructExpressionType(key, val)")
                    .build())
            .build());

        CodeBlock.Builder cb = CodeBlock.builder();
        cb.beginControlFlow("switch(id)");

        elementsOf(EXPRESSION_DEFINITION_CLASS).entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(
                e -> {
                    cb.beginControlFlow("case $S:", e.getKey());
                    cb.addStatement("return asType(node, $L.class)", e.getValue().name().toString());
                    cb.endControlFlow();

                    if (!e.getKey().equals(StringHelper.camelCaseToDash(e.getKey()))) {
                        cb.beginControlFlow("case $S:", StringHelper.camelCaseToDash(e.getKey()));
                        cb.addStatement("return asType(node, $L.class)", e.getValue().name().toString());
                        cb.endControlFlow();
                    }
                }
            );

        cb.beginControlFlow("case \"expression\":");
        cb.addStatement("return constructExpressionType(node)");
        cb.endControlFlow();

        cb.beginControlFlow("case \"expression-type\":");
        cb.addStatement("return constructExpressionType(node)");
        cb.endControlFlow();

        cb.endControlFlow();

        cb.addStatement("return null");

        type.addMethod(MethodSpec.methodBuilder("constructExpressionType")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addParameter(String.class, "id")
            .addParameter(Node.class, "node")
            .returns(CN_EXPRESSION_DEFINITION)
            .addCode(cb.build())
            .build());


        //
        // ExpressionDefinitionDeserializers
        //
        AnnotationSpec.Builder edAnnotation = AnnotationSpec.builder(CN_YAML_TYPE);
        edAnnotation.addMember("types", "org.apache.camel.model.language.ExpressionDefinition.class");
        edAnnotation.addMember("order", "com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1");

        elementsOf(EXPRESSION_DEFINITION_CLASS).entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(
                e -> {
                    edAnnotation.addMember(
                        "properties",
                        "$L",
                        yamlPropertyWithSubtype(
                            e.getKey(),
                            "object",
                            e.getValue().name().toString())
                    );

                    if (!e.getKey().equals(StringHelper.camelCaseToDash(e.getKey()))) {
                        edAnnotation.addMember(
                            "properties",
                            "$L",
                            yamlPropertyWithSubtype(
                                StringHelper.camelCaseToDash(e.getKey()),
                                "object",
                                e.getValue().name().toString())
                        );
                    }
                }
            );

        type.addType(
            TypeSpec.classBuilder("ExpressionDefinitionDeserializers")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addSuperinterface(ConstructNode.class)
                .addAnnotation(edAnnotation.build())
                .addMethod(
                    MethodSpec.methodBuilder("construct")
                        .addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .addParameter(Node.class, "node")
                        .returns(Object.class)
                        .addStatement("return constructExpressionType(node)")
                        .build())
                .build()
        );


        //
        // ExpressionSubElementDefinitionDeserializers
        //
        AnnotationSpec.Builder esdAnnotation = AnnotationSpec.builder(CN_YAML_TYPE);
        esdAnnotation.addMember("types", "org.apache.camel.model.ExpressionSubElementDefinition.class");
        esdAnnotation.addMember("order", "com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1");

        elementsOf(EXPRESSION_DEFINITION_CLASS).entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(
                e -> {
                    esdAnnotation.addMember(
                        "properties",
                        "$L",
                        yamlPropertyWithSubtype(
                            e.getKey(),
                            "object",
                            e.getValue().name().toString())
                    );

                    if (!e.getKey().equals(StringHelper.camelCaseToDash(e.getKey()))) {
                        esdAnnotation.addMember(
                            "properties",
                            "$L",
                            yamlPropertyWithSubtype(
                                StringHelper.camelCaseToDash(e.getKey()),
                                "object",
                                e.getValue().name().toString())
                        );
                    }
                }
            );

        type.addType(
            TypeSpec.classBuilder("ExpressionSubElementDefinitionDeserializers")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addSuperinterface(ConstructNode.class)
                .addAnnotation(esdAnnotation.build())
                .addMethod(
                    MethodSpec.methodBuilder("construct")
                        .addModifiers(Modifier.PUBLIC)
                        .addAnnotation(Override.class)
                        .addParameter(Node.class, "node")
                        .returns(Object.class)
                        .addStatement("var val = constructExpressionType(node)")
                        .addStatement("return new org.apache.camel.model.ExpressionSubElementDefinition(val)")
                        .build())
                .build()
        );

        return type.build();
    }

    private Collection<TypeSpec> generateDeserializers() {
        TypeSpec.Builder deserializers = TypeSpec.classBuilder("ModelDeserializers");
        deserializers.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        deserializers.superclass(CN_DESERIALIZER_SUPPORT);

        // add private constructor
        deserializers.addMethod(MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PRIVATE)
            .build());

        CodeBlock.Builder constructors = CodeBlock.builder();
        constructors.beginControlFlow("switch(id)");

        all()
            .filter(ci -> {
                return !ci.name().equals(EXPRESSION_DEFINITION_CLASS)
                    && !ci.name().equals(EXPRESSION_SUBELEMENT_DEFINITION_CLASS);
            })
            .map(this::generateParser)
            .sorted(Comparator.comparing(o -> o.type.name))
            .collect(Collectors.toList())
            .forEach(holder -> {
                // add inner classes
                deserializers.addType(holder.type);

                if (holder.attributes.containsKey("node")) {
                    constructors.addStatement(
                        "case $S: return new ModelDeserializers.$L()", holder.attributes.get("node"), holder.type.name);
                }
                if (holder.attributes.containsKey("type")) {
                    constructors.addStatement(
                        "case $S: return new ModelDeserializers.$L()", holder.attributes.get("type"), holder.type.name);
                }
            }
        );

        constructors.endControlFlow();
        constructors.addStatement("return null");

        // resolve
        TypeSpec.Builder resolver = TypeSpec.classBuilder("ModelDeserializersResolver");
        resolver.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        resolver.addSuperinterface(CN_DESERIALIZER_RESOLVER);

        resolver.addMethod(
            MethodSpec.methodBuilder("getOrder")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(int.class)
                .addStatement("return YamlDeserializerResolver.ORDER_LOWEST - 1")
                .build());
        resolver.addMethod(
            MethodSpec.methodBuilder("resolve")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(String.class, "id")
                .returns(ConstructNode.class)
                .addCode(constructors.build())
                .build());

        return List.of(
            deserializers.build(),
            resolver.build()
        );
    }

    public final Collection<TypeSpec> generateEndpointConsumer() {
        return generateEndpoint(
            "EndpointConsumerDeserializers",
            component -> !component.isProducerOnly(),
            ClassName.get(
                "com.github.lburgazzoli.camel.dsl.yaml.common.deserializers",
                "EndpointDeserializers.From"),
            false
        );
    }

    public final Collection<TypeSpec> generateEndpointProducer() {
        return generateEndpoint(
            "EndpointProducerDeserializers",
            component -> !component.isConsumerOnly(),
            ClassName.get(
                "com.github.lburgazzoli.camel.dsl.yaml.common.deserializers",
                "EndpointDeserializers.To"),
            true
        );
    }

    public final Collection<TypeSpec> generateEndpoint(
            String className,
            Predicate<ComponentModel> componentFilter,
            TypeName superClass,
            boolean annotate) {

        TypeSpec.Builder deserializers = TypeSpec.classBuilder(className);
        deserializers.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        deserializers.superclass(CN_DESERIALIZER_SUPPORT);

        // add private constructor
        deserializers.addMethod(MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PRIVATE)
            .build());

        TypeSpec.Builder resolver = TypeSpec.classBuilder(className + "Resolver");
        resolver.addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        resolver.addSuperinterface(CN_DESERIALIZER_RESOLVER);

        CodeBlock.Builder sw = CodeBlock.builder();
        sw.beginControlFlow("switch(id)");

        CamelCatalog catalog = new DefaultCamelCatalog();
        catalog.findComponentNames().stream()
            .map(catalog::componentModel)
            .filter(componentFilter)
            .flatMap(component -> ToolingSupport.combine(component.getScheme(), component.getAlternativeSchemes()))
            .sorted()
            .distinct()
            .forEach(scheme -> {
                String name = scheme.replace('+','-');
                name = StringHelper.capitalize(name, true);


                TypeSpec.Builder deserializer = TypeSpec.classBuilder(name)
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .superclass(superClass)
                    .addMethod(
                        MethodSpec.constructorBuilder()
                            .addModifiers(Modifier.PUBLIC)
                            .addStatement("super($S)", scheme)
                            .build());

                if (annotate) {
                    deserializer.addAnnotation(
                        AnnotationSpec.builder(CN_YAML_TYPE)
                            .addMember("nodes", "$S", scheme)
                            .build());
                }

                deserializers.addType(deserializer.build());

                sw.addStatement("case $S: return new $L.$L()", scheme, className, name);
            });

        sw.endControlFlow();
        sw.addStatement("return null");

        resolver.addMethod(
            MethodSpec.methodBuilder("getOrder")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .returns(int.class)
                .addStatement("return YamlDeserializerResolver.ORDER_LOWEST")
                .build());
        resolver.addMethod(
            MethodSpec.methodBuilder("resolve")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(String.class, "id")
                .returns(ConstructNode.class)
                .addCode(sw.build())
                .build());

        return List.of(
            deserializers.build(),
            resolver.build()
        );
    }

    private TypeSpecHolder generateParser(ClassInfo info) {
        final ClassName targetType = ClassName.get(info.name().prefix().toString(), info.name().withoutPackagePrefix());
        final TypeSpec.Builder builder = TypeSpec.classBuilder(info.simpleName() + "Deserializer");
        final Map<String, String> attributes = new HashMap<>();
        final List<AnnotationSpec> properties = new ArrayList<>();
        final AnnotationSpec.Builder yamlTypeAnnotation = AnnotationSpec.builder(CN_YAML_TYPE);

        builder.addModifiers(Modifier.PUBLIC, Modifier.STATIC);
        builder.superclass(ParameterizedTypeName.get(CN_DESERIALIZER_BASE, targetType));
        attributes.put("type", info.name().toString());

        //TODO: add an option on Camel's definitions to distinguish between IN/OUT types
        if (info.name().toString().equals("org.apache.camel.model.OnExceptionDefinition")) {
            builder.addAnnotation(CN_YAML_IN);
        }
        if (info.name().toString().equals("org.apache.camel.model.rest.RestDefinition")) {
            builder.addAnnotation(CN_YAML_IN);
        }

        //
        // Constructors
        //
        builder.addMethod(MethodSpec.constructorBuilder()
            .addModifiers(Modifier.PUBLIC)
            .addStatement("super($L.class)", info.simpleName())
            .build());

        //
        // T handledTypeInstance();
        //
        builder.addMethod(MethodSpec.methodBuilder("newInstance")
            .addAnnotation(AnnotationSpec.builder(Override.class).build())
            .addModifiers(Modifier.PROTECTED)
            .returns(targetType)
            .addCode(
                CodeBlock.builder()
                    .addStatement("return new $L()", info.simpleName())
                    .build())
            .build());

        //
        // T handledTypeInstance(String value);
        //
        for (MethodInfo ctor: info.constructors()) {
            if (ctor.parameters().size() == 1 && ctor.parameters().get(0).name().equals(STRING_CLASS)) {
                if ((ctor.flags() & java.lang.reflect.Modifier.PUBLIC) == 0) {
                    break;
                }

                yamlTypeAnnotation.addMember("inline", "true");

                builder
                    .addMethod(MethodSpec.methodBuilder("newInstance")
                    .addAnnotation(AnnotationSpec.builder(Override.class).build())
                    .addModifiers(Modifier.PROTECTED)
                    .addParameter(String.class, "value")
                    .returns(targetType)
                    .addCode(
                        CodeBlock.builder()
                            .addStatement("return new $L(value)", info.simpleName())
                            .build())
                    .build());
                break;
            }
        }

        //
        // Generate setProperty body
        //
        CodeBlock.Builder setProperty = CodeBlock.builder();
        setProperty.beginControlFlow("switch(propertyKey)");

        for (FieldInfo field : fields(info)) {
            generateSetValue(setProperty, field, properties);
        }

        if (implementType(info, OUTPUT_NODE_CLASS)) {
            setProperty.beginControlFlow("case \"steps\":");
            setProperty.addStatement("setSteps(target, asSequenceNode(node))");
            setProperty.addStatement("break");
            setProperty.endControlFlow();

            properties.add(
                yamlProperty(
                    "steps",
                    "array:step")
            );
        }

        if (implementType(info, HAS_EXPRESSION_TYPE_CLASS)) {
            setProperty.beginControlFlow("default:");
            setProperty.addStatement("var ed = target.getExpressionType()");
            setProperty.beginControlFlow("if (ed != null)");
            setProperty.addStatement("throw new com.github.lburgazzoli.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, \"an expression has already been configured (\" + ed + \")\")");
            setProperty.endControlFlow();
            setProperty.addStatement("ed = ExpressionDeserializers.constructExpressionType(propertyKey, node)");
            setProperty.beginControlFlow("if (ed != null)");
            setProperty.addStatement("target.setExpressionType(ed)");
            setProperty.nextControlFlow("else");
            setProperty.addStatement("return false");
            setProperty.endControlFlow();
            setProperty.endControlFlow();


            if (!extendsType(info, EXPRESSION_DEFINITION_CLASS)) {
                properties.add(
                    yamlProperty(
                        "__extends",
                        "object:org.apache.camel.model.language.ExpressionDefinition")
                );
            }
        } else {
            setProperty.beginControlFlow("default:");
            setProperty.addStatement("return false");
            setProperty.endControlFlow();
        }

        setProperty.endControlFlow();
        setProperty.addStatement("return true");

        //
        // setProperty(T target, String propertyKey, String propertyName, Node value) throws Exception
        //
        builder
            .addMethod(MethodSpec.methodBuilder("setProperty")
            .addAnnotation(AnnotationSpec.builder(Override.class).build())
            .addModifiers(Modifier.PROTECTED)
            .addParameter(targetType, "target")
            .addParameter(String.class, "propertyKey")
            .addParameter(String.class, "propertyName")
            .addParameter(Node.class, "node")
            .returns(boolean.class)
            .addCode(setProperty.build())
            .build());

        //
        // YamlType
        //
        yamlTypeAnnotation.addMember("types", "$L.class", info.name().toString());
        yamlTypeAnnotation.addMember("order", "com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1", info.name().toString());

        annotationValue(info, XML_ROOT_ELEMENT_ANNOTATION_CLASS, "name")
            .map(AnnotationValue::asString)
            .filter(value -> !"##default".equals(value))
            .map(StringHelper::camelCaseToDash)
            .ifPresent(v -> {
                yamlTypeAnnotation.addMember("nodes", "$S", v);
                attributes.put("node", v);
            });

        for (AnnotationSpec spec: properties) {
            yamlTypeAnnotation.addMember("properties", "$L", spec);
        }

        builder.addAnnotation(yamlTypeAnnotation.build());

        return new TypeSpecHolder(builder.build(), attributes);
    }

    private void generateSetValue(CodeBlock.Builder cb, FieldInfo field, Collection<AnnotationSpec> annotations) {
        if(hasAnnotation(field, XML_TRANSIENT_CLASS)) {
            ClassInfo ci = view.get().getClassByName(field.type().name());
            if (ci == null) {
                return;
            }

            switch (ci.name().toString()) {
                case "org.apache.camel.model.OnFallbackDefinition":
                    break;
                default:
                    return;
            }
        }

        //
        // XmlElements
        //
        if (hasAnnotation(field, XML_ELEMENTS_ANNOTATION_CLASS)) {
            AnnotationInstance[] elements = field.annotation(XML_ELEMENTS_ANNOTATION_CLASS).value().asNestedArray();

            if (elements.length > 1) {
                //TODO: org.apache.camel.model.cloud.ServiceCallExpressionConfiguration#expressionConfiguration is
                //      wrongly defined and need to be fixed
                cb.beginControlFlow("case $S:", StringHelper.camelCaseToDash(field.name()).toLowerCase(Locale.US));
                cb.addStatement("var val = asMappingNode(node)");
                cb.addStatement("setProperties(target, val)");
                cb.addStatement("break");
                cb.endControlFlow();
            }

            if (field.type().name().equals(LIST_CLASS)) {
                for (AnnotationInstance element : elements) {
                    AnnotationValue name = element.value("name");
                    AnnotationValue type = element.value("type");

                    if (name != null && type != null) {
                        String fieldName = StringHelper.camelCaseToDash(name.asString()).toLowerCase(Locale.US);

                        cb.beginControlFlow("case $S:", fieldName);
                        cb.addStatement("var val = asType(node, $L.class)", type.asString());
                        cb.addStatement("var existing = target.get$L()", StringHelper.capitalize(field.name()));
                        cb.beginControlFlow("if (existing == null)");
                        cb.addStatement("existing = new java.util.ArrayList<>()");
                        cb.endControlFlow();
                        cb.addStatement("existing.add(val)");
                        cb.addStatement("target.set$L(existing)", StringHelper.capitalize(field.name()));
                        cb.addStatement("break");
                        cb.endControlFlow();

                        annotations.add(
                            yamlPropertyWithSubtype(
                                fieldName,
                                "object",
                                type.asString(),
                                isRequired(field))
                        );
                    }
                }
            } else {
                for (AnnotationInstance element : elements) {
                    AnnotationValue name = element.value("name");
                    AnnotationValue type = element.value("type");

                    if (name != null && type != null) {
                        String fieldName = StringHelper.camelCaseToDash(name.asString()).toLowerCase(Locale.US);

                        cb.beginControlFlow("case $S:", fieldName);
                        cb.addStatement("var val = asType(node, $L.class)", type.asString());
                        cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                        cb.addStatement("break");
                        cb.endControlFlow();

                        annotations.add(
                            yamlPropertyWithSubtype(
                                fieldName,
                                "object",
                                type.asString(),
                                isRequired(field))
                        );
                    }
                }
            }

            return;
        }

        //
        // Skip elements with unsupported annotations.
        //
        if (!hasAnnotation(field, XML_ATTRIBUTE_ANNOTATION_CLASS) &&
            !hasAnnotation(field, XML_VALUE_ANNOTATION_CLASS) &&
            !hasAnnotation(field, XML_ELEMENT_ANNOTATION_CLASS) &&
            !hasAnnotation(field, XML_ELEMENT_REF_ANNOTATION_CLASS) &&
            !hasAnnotation(field, XML_TRANSIENT_CLASS)) {
            return;
        }

        final String fieldName = StringHelper.camelCaseToDash(fieldName(field)).toLowerCase(Locale.US);

        //
        // Parametrized
        //
        if (field.type().kind() == Type.Kind.PARAMETERIZED_TYPE) {
            ParameterizedType parameterized = field.type().asParameterizedType();

            if (!parameterized.name().equals(CLASS_CLASS) && parameterized.arguments().size() == 1) {
                final Type parametrizedType = parameterized.arguments().get(0);
                if (parametrizedType.name().equals(PROCESSOR_DEFINITION_CLASS)) {
                    return;
                }

                switch (parameterized.name().toString()) {
                    case "java.util.List":
                        if (parametrizedType.name().equals(STRING_CLASS)) {
                            cb.beginControlFlow("case $S:", fieldName);
                            cb.addStatement("var val = asStringList(node)");
                            cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                            cb.addStatement("break");
                            cb.endControlFlow();

                            annotations.add(
                                yamlPropertyWithSubtype(fieldName, "array", "string", isRequired(field))
                            );
                        } else {
                            ClassInfo ci = view.get().getClassByName(parametrizedType.name());

                            String name = firstPresent(
                                annotationValue(field, XML_VALUE_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(field, XML_ATTRIBUTE_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(field, XML_ELEMENT_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(ci, XML_ROOT_ELEMENT_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value))
                            ).orElseGet(field::name);

                            cb.beginControlFlow("case $S:", StringHelper.camelCaseToDash(name).toLowerCase(Locale.US));
                            cb.addStatement("var val = asFlatList(node, $L.class)", parametrizedType.name().toString());
                            cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                            cb.addStatement("break");
                            cb.endControlFlow();

                            annotations.add(
                                yamlPropertyWithSubtype(fieldName, "array", parametrizedType.name().toString(), isRequired(field))
                            );
                        }
                        return;
                    case "java.util.Set":
                        if (parametrizedType.name().equals(STRING_CLASS)) {
                            cb.beginControlFlow("case $S:", fieldName);
                            cb.addStatement("var val = asStringSet(node)");
                            cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                            cb.addStatement("break");
                            cb.endControlFlow();

                            annotations.add(
                                yamlPropertyWithSubtype(fieldName, "array", "string", isRequired(field))
                            );
                        } else {
                            ClassInfo ci = view.get().getClassByName(parametrizedType.name());

                            String name = firstPresent(
                                annotationValue(field, XML_VALUE_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(field, XML_ATTRIBUTE_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(field, XML_ELEMENT_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value)),
                                annotationValue(ci, XML_ROOT_ELEMENT_ANNOTATION_CLASS, "name")
                                    .map(AnnotationValue::asString)
                                    .filter(value -> !"##default".equals(value))
                            ).orElseGet(field::name);

                            cb.beginControlFlow("case $S:", StringHelper.camelCaseToDash(name).toLowerCase(Locale.US));
                            cb.addStatement("var val = asFlatSet(node, $L.class)", parametrizedType.name().toString());
                            cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                            cb.addStatement("break");
                            cb.endControlFlow();

                            annotations.add(
                                yamlPropertyWithSubtype(fieldName, "array", parametrizedType.name().toString(), isRequired(field))
                            );
                        }
                        return;
                    default:
                        throw new UnsupportedOperationException("Unable to handle field: " + field.name() + " with type: " + field.type().name());
                }
            }
        }

        //
        // Others
        //
        cb.beginControlFlow("case $S:", fieldName);

        ClassInfo c = view.get().getClassByName(field.type().name());
        if (c != null && c.isEnum()) {
            cb.addStatement("target.set$L($L.valueOf(asText(node)))", StringHelper.capitalize(field.name()), field.type().name().toString());
            cb.addStatement("break");

            AnnotationSpec.Builder builder = AnnotationSpec.builder(CN_YAML_PROPERTY);
            builder.addMember("name", "$S", fieldName);
            builder.addMember("type", "$S", "enum");

            if (isRequired(field)) {
                builder.addMember("required", "$L", isRequired(field));
            }

            List<FieldInfo> fields = c.fields();
            for (int i = 1; i< fields.size(); i++) {
                builder.addMember("values", "$S", fields.get(i).name());
            }

            annotations.add(builder.build());
        } else {
            switch (field.type().name().toString()) {
                case "[B":
                    cb.addStatement("var val = asByteArray(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");

                    annotations.add(
                        yamlPropertyWithFormat(fieldName, "string", "binary", isRequired(field))
                    );
                    break;
                case "Z":
                    cb.addStatement("var val = asBoolean(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "boolean", isRequired(field)));
                    break;
                case "I":
                    cb.addStatement("var val = asInt(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "number", isRequired(field)));
                    break;
                case "J":
                    cb.addStatement("var val = asLong(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "number", isRequired(field)));
                    break;
                case "D":
                    cb.addStatement("var val = asDouble(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "number", isRequired(field)));
                    break;
                case "java.lang.String":
                    cb.addStatement("var val = asText(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");

                    String javaType = annotationValue(field, METADATA_ANNOTATION, "javaType")
                        .map(AnnotationValue::asString)
                        .orElse("string");

                    switch (javaType) {
                        case "java.lang.Boolean":
                            annotations.add(yamlProperty(fieldName, "boolean", isRequired(field)));
                            break;
                        case "java.lang.Integer":
                        case "java.lang.Short":
                        case "java.lang.Long":
                        case "java.lang.Float":
                        case "java.lang.Double":
                            annotations.add(yamlProperty(fieldName, "number", isRequired(field)));
                            break;
                        default:
                            annotations.add(yamlProperty(fieldName, "string", isRequired(field)));
                    }

                    break;
                case "java.lang.Class":
                    cb.addStatement("var val = asClass(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "string", isRequired(field)));
                    break;
                case "[Ljava.lang.Class;":
                    cb.addStatement("var val = asClassArray(node)");
                    cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                    cb.addStatement("break");
                    break;
                case "java.lang.Integer":
                case "java.lang.Short":
                case "java.lang.Long":
                case "java.lang.Float":
                case "java.lang.Double":
                    cb.addStatement("var val = asText(node)");
                    cb.addStatement("target.set$L($L.valueOf(val))", StringHelper.capitalize(field.name()), field.type().name().toString());
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "number", isRequired(field)));
                    break;
                case "java.lang.Boolean":
                    cb.addStatement("var val = asText(node)");
                    cb.addStatement("target.set$L($L.valueOf(val))", StringHelper.capitalize(field.name()), field.type().name().toString());
                    cb.addStatement("break");
                    annotations.add(yamlProperty(fieldName, "boolean", isRequired(field)));
                    break;
                default:
                    if (field.type().kind() == Type.Kind.CLASS) {
                        cb.addStatement("var val = asType(node, $L.class)", field.type().name().toString());
                        cb.addStatement("target.set$L(val)", StringHelper.capitalize(field.name()));
                        cb.addStatement("break");

                        annotations.add(
                            yamlPropertyWithSubtype(fieldName, "object", field.type().name().toString(), isRequired(field))
                        );
                    } else {
                        throw new UnsupportedOperationException("Unable to handle field: " + field.name() + " with type: " + field.type().name());
                    }
            }
        }

        cb.endControlFlow();
    }
}