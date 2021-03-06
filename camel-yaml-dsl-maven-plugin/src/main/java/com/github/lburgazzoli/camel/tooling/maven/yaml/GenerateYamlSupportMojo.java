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


import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.github.lburgazzoli.camel.tooling.maven.yaml.suport.IndexerSupport;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import org.apache.camel.util.AntPathMatcher;
import org.apache.camel.util.function.Suppliers;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.jboss.jandex.AnnotationInstance;
import org.jboss.jandex.AnnotationTarget;
import org.jboss.jandex.AnnotationValue;
import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;
import org.jboss.jandex.FieldInfo;
import org.jboss.jandex.IndexView;
import org.jboss.jandex.MethodInfo;
import org.jboss.jandex.Type;

public abstract class GenerateYamlSupportMojo extends AbstractMojo {

    public static final DotName LIST_CLASS =
        DotName.createSimple("java.util.List");
    public static final DotName SET_CLASS =
        DotName.createSimple("java.util.Set");
    public static final DotName STRING_CLASS =
        DotName.createSimple("java.lang.String");
    public static final DotName CLASS_CLASS =
        DotName.createSimple("java.lang.Class");

    public static final DotName XML_ROOT_ELEMENT_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlRootElement");
    public static final DotName XML_TYPE_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlType");
    public static final DotName XML_ENUM_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlEnum");
    public static final DotName XML_VALUE_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlValue");
    public static final DotName XML_ATTRIBUTE_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlAttribute");
    public static final DotName XML_VALUE_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlValue");
    public static final DotName XML_ELEMENT_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlElement");
    public static final DotName XML_ELEMENT_REF_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlElementRef");
    public static final DotName XML_ELEMENTS_ANNOTATION_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlElements");
    public static final DotName XML_TRANSIENT_CLASS =
        DotName.createSimple("javax.xml.bind.annotation.XmlTransient");

    public static final DotName METADATA_ANNOTATION =
        DotName.createSimple("org.apache.camel.spi.Metadata");

    public static final DotName ERROR_HANDLER_CLASS =
        DotName.createSimple("org.apache.camel.builder.ErrorHandlerBuilder");

    public static final DotName EXPRESSION_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.language.ExpressionDefinition");
    public static final DotName EXPRESSION_SUBELEMENT_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.ExpressionSubElementDefinition");
    public static final DotName HAS_EXPRESSION_TYPE_CLASS =
        DotName.createSimple("org.apache.camel.model.HasExpressionType");
    public static final DotName DATAFORMAT_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.DataFormatDefinition");
    public static final DotName MARSHAL_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.MarshalDefinition");
    public static final DotName UNMARSHAL_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.UnmarshalDefinition");

    public static final DotName EXPRESSION_NODE_CLASS =
        DotName.createSimple("org.apache.camel.model.ExpressionNode");
    public static final DotName OUTPUT_NODE_CLASS =
        DotName.createSimple("org.apache.camel.model.OutputNode");
    public static final DotName LOAD_BALANCE_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.LoadBalancerDefinition");

    public static final DotName PROCESSOR_DEFINITION_CLASS =
        DotName.createSimple("org.apache.camel.model.ProcessorDefinition");

    public static final DotName ERROR_HANDLER_BUILDER_CLASS =
        DotName.createSimple("org.apache.camel.builder.ErrorHandlerBuilder");
    public static final DotName ERROR_HANDLER_BUILDER_REF_CLASS =
        DotName.createSimple("org.apache.camel.builder.ErrorHandlerBuilderRef");

    public static final DotName YAML_TYPE_ANNOTATION =
        DotName.createSimple("com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlType");
    public static final DotName YAML_IN_ANNOTATION =
        DotName.createSimple("com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlIn");
    public static final DotName YAML_OUT_ANNOTATION =
        DotName.createSimple("com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlOut");


    public static final ClassName CN_DESERIALIZER_RESOLVER =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.common", "YamlDeserializerResolver");
    public static final ClassName CN_DESERIALIZER_SUPPORT =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.common", "YamlDeserializerSupport");
    public static final ClassName CN_DESERIALIZER_BASE =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.common", "YamlDeserializerBase");
    public static final ClassName CN_YAML_TYPE =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.annotations", "YamlType");
    public static final ClassName CN_YAML_PROPERTY =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.annotations", "YamlProperty");
    public static final ClassName CN_YAML_IN =
        ClassName.get("com.github.lburgazzoli.camel.dsl.yaml.annotations", "YamlIn");
    public static final ClassName CN_EXPRESSION_DEFINITION =
        ClassName.get("org.apache.camel.model.language", "ExpressionDefinition");

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    protected MavenProject project;
    @Parameter
    protected List<String> bannedDefinitions;

    protected final Supplier<IndexView> view;

    GenerateYamlSupportMojo() {
        this.view = Suppliers.memorize(() -> IndexerSupport.get(project));
    }

    // **************************
    //
    // Indexer
    //
    // **************************

    protected Stream<ClassInfo> implementors(DotName type) {
        return view.get().getAllKnownImplementors(type).stream();
    }

    protected Stream<ClassInfo> annotated(DotName type) {
        return view.get().getAnnotations(type).stream()
            .map(AnnotationInstance::target)
            .filter(t -> t.kind() == AnnotationTarget.Kind.CLASS)
            .map(AnnotationTarget::asClass)
            .filter(ci -> !isBanned(ci));
    }

    protected Map<String, ClassInfo> elementsOf(DotName type) {
        Map<String, ClassInfo> answer = new TreeMap<>();

        for (ClassInfo ci: view.get().getAllKnownSubclasses(type)) {
            AnnotationInstance instance = ci.classAnnotation(XML_ROOT_ELEMENT_ANNOTATION_CLASS);
            if (instance != null) {
                AnnotationValue name = instance.value("name");
                if (name != null) {
                    answer.put(name.asString(), ci);
                }
            }
        }

        return Collections.unmodifiableMap(answer);
    }

    protected static boolean hasAnnotation(ClassInfo target, DotName annotationName) {
        return target.classAnnotation(annotationName) != null;
    }

    protected static boolean hasAnnotation(FieldInfo target, DotName annotationName) {
        return target.annotation(annotationName) != null;
    }

    protected static boolean hasAnnotationValue(ClassInfo target, DotName annotationName, String name) {
        return annotationValue(
            target.classAnnotation(annotationName),
            name
        ).isPresent();
    }
    protected static Optional<AnnotationValue> annotationValue(AnnotationInstance instance, String name) {
        return instance != null
            ? Optional.ofNullable(instance.value(name))
            : Optional.empty();
    }

    protected static Optional<AnnotationValue> annotationValue(ClassInfo target, DotName annotationName, String name) {
        return annotationValue(
            target.classAnnotation(annotationName),
            name
        );
    }

    protected static Optional<AnnotationValue> annotationValue(FieldInfo target, DotName annotationName, String name) {
        return annotationValue(
            target.annotation(annotationName),
            name
        );
    }

    protected static Optional<AnnotationValue> annotationValue(MethodInfo target, DotName annotationName, String name) {
        return annotationValue(
            target.annotation(annotationName),
            name
        );
    }

    // **************************
    //
    // Class loading
    //
    // **************************

    protected Class<?> loadClass(ClassInfo ci) {
        return loadClass(ci.name().toString());
    }

    protected Class<?> loadClass(String className) {
        try {
            return IndexerSupport.getClassLoader(project).loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // **************************
    //
    // Helpers
    //
    // **************************

    /**
     * Combines the given items assuming they can be also composed
     * by comma separated elements.
     *
     * @param items the items
     * @return a stream of individual items
     */
    protected static Stream<String> combine(String... items) {
        Set<String> answer = new TreeSet<>();

        for (String item: items) {
            if (item == null) {
                continue;
            }

            String[] elements = item.split(",");
            for (String element: elements) {
                answer.add(element);
            }
        }

        return answer.stream();
    }

    protected Stream<ClassInfo> all() {
        return Stream.of(XML_ROOT_ELEMENT_ANNOTATION_CLASS, XML_TYPE_CLASS)
            .map(view.get()::getAnnotations)
            .flatMap(Collection::stream)
                .map(AnnotationInstance::target)
                .filter(at -> at.kind() == AnnotationTarget.Kind.CLASS)
                .map(AnnotationTarget::asClass)
                .filter(ci -> (ci.flags() & Modifier.ABSTRACT) == 0)
                .filter(ci -> !isBanned(ci))
                .filter(ci -> !ci.isEnum())
                .sorted(Comparator.comparing(o -> o.name().toString()))
                .distinct();
    }

    /**
     * Load all the models.
     */
    protected Map<String, ClassInfo> models() {
        Map<String, ClassInfo> answer = new TreeMap<>();

        annotated(XML_ROOT_ELEMENT_ANNOTATION_CLASS)
            .forEach(
                i -> {
                    AnnotationInstance meta = i.classAnnotation(METADATA_ANNOTATION);
                    AnnotationInstance root = i.classAnnotation(XML_ROOT_ELEMENT_ANNOTATION_CLASS);

                    if (meta == null || root == null) {
                        return;
                    }

                    AnnotationValue name = root.value("name");
                    AnnotationValue label = meta.value("label");

                    if (name == null || label == null) {
                        return;
                    }

                    if (bannedDefinitions != null) {
                        for (String bannedDefinition: bannedDefinitions) {
                            if (AntPathMatcher.INSTANCE.match(bannedDefinition.replace('.', '/'), i.name().toString('/'))) {
                                getLog().debug("Skipping definition: " + i.name().toString());
                                return;
                            }
                        }
                    }

                    Set<String> labels = Set.of(label.asString().split(",", -1));
                    if (labels.contains("eip")) {
                        answer.put(name.asString(), i);
                    }
                }
            );

        return answer;
    }

    /**
     * Load all the definitions.
     */
    protected Set<ClassInfo> definitions() {
        final Set<ClassInfo> discovered = new LinkedHashSet<>();
        final Set<ClassInfo> answer = new LinkedHashSet<>();

        models().values()
            .forEach(
                i -> {
                    discovered.add(i);
                }
            );

        for (ClassInfo type: discovered) {
            answer.addAll(definitions(type));
            if ((type.flags() & Modifier.ABSTRACT) == 0) {
                answer.add(type);
            }
        }

        return answer;
    }

    /**
     * Load all the definitions.
     */
    protected Set<ClassInfo> definitions(ClassInfo ci) {
        final Set<ClassInfo> types = new LinkedHashSet<>();

        for (FieldInfo fi : ci.fields()) {
            if (hasAnnotation(fi, XML_ELEMENTS_ANNOTATION_CLASS)) {
                AnnotationInstance[] elements = fi.annotation(XML_ELEMENTS_ANNOTATION_CLASS).value().asNestedArray();

                for (AnnotationInstance element: elements) {
                    AnnotationValue type = element.value("type");

                    if (type != null) {
                        ClassInfo fti = view.get().getClassByName(fi.type().name());
                        types.addAll(definitions(fti));
                        if ((fti.flags() & Modifier.ABSTRACT) == 0) {
                            types.add(fti);
                        }
                    }
                }
            }

            if (!hasAnnotation(fi, XML_ELEMENT_ANNOTATION_CLASS) &&
                !hasAnnotation(fi, XML_ELEMENTS_ANNOTATION_CLASS)) {
                continue;
            }
            if (fi.type().name().toString().startsWith("java.")) {
                continue;
            }
            if (fi.type().name().toString().startsWith("sun.")) {
                continue;
            }
            if (fi.type().kind() == Type.Kind.PARAMETERIZED_TYPE) {
                // TODO: support
                continue;
            }

            ClassInfo fti = view.get().getClassByName(fi.type().name());
            if (fti != null) {
                types.addAll(definitions(fti));
                if ((fti.flags() & Modifier.ABSTRACT) == 0) {
                    types.add(fti);
                }
            }
        }

        DotName superName = ci.superName();
        if (superName != null) {
            ClassInfo sci = view.get().getClassByName(superName);
            if (sci != null) {
                types.addAll(definitions(sci));
                if ((sci.flags() & Modifier.ABSTRACT) == 0) {
                    types.add(sci);
                }
            }
        }

        return types;
    }

    protected Set<FieldInfo> fields(ClassInfo ci) {
        Set<FieldInfo> fields = new TreeSet<>(Comparator.comparing(FieldInfo::name));

        ClassInfo current = ci;
        while (current != null) {
            fields.addAll(current.fields());

            DotName superName = current.superName();
            if (superName == null) {
                break;
            }

            current = view.get().getClassByName(superName);
        }

        return fields;
    }

    protected Set<MethodInfo> methods(ClassInfo ci) {
        Set<MethodInfo> methods = new TreeSet<>(Comparator.comparing(MethodInfo::name));

        ClassInfo current = ci;
        while (current != null) {
            methods.addAll(current.methods());

            DotName superName = current.superName();
            if (superName == null) {
                break;
            }

            current = view.get().getClassByName(superName);
        }

        return methods;
    }


    @SafeVarargs
    protected final <T> Optional<T> firstPresent(Optional<T>... optionals) {
        for (Optional<T> optional: optionals) {
            if (optional.isPresent()) {
                return optional;
            }
        }

        return Optional.empty();
    }

    protected String fieldName(FieldInfo field) {
        return firstPresent(
            annotationValue(field, XML_VALUE_ANNOTATION_CLASS, "name")
                .map(AnnotationValue::asString)
                .filter(value -> !"##default".equals(value)),
            annotationValue(field, XML_ATTRIBUTE_ANNOTATION_CLASS, "name")
                .map(AnnotationValue::asString)
                .filter(value -> !"##default".equals(value)),
            annotationValue(field, XML_ELEMENT_ANNOTATION_CLASS, "name")
                .map(AnnotationValue::asString)
                .filter(value -> !"##default".equals(value))
        ).orElseGet(field::name);
    }

    protected boolean isRequired(FieldInfo fi) {
        return firstPresent(
            annotationValue(fi, METADATA_ANNOTATION, "required")
                .map(AnnotationValue::asBoolean),
            annotationValue(fi, XML_VALUE_ANNOTATION_CLASS, "required")
                .map(AnnotationValue::asBoolean)
        ).orElse(false);
    }

    protected boolean extendsType(ClassInfo ci, DotName superType) {
        if (ci == null) {
            return false;
        }
        if (ci.name().equals(superType)) {
            return true;
        }

        DotName superName = ci.superName();
        if (superName != null) {
            return extendsType(
                view.get().getClassByName(superName),
                superType);
        }

        return false;
    }

    protected boolean implementType(ClassInfo ci, DotName interfaceType) {
        if (ci == null) {
            return false;
        }
        if (ci.name().equals(interfaceType)) {
            return true;
        }

        for (DotName name : ci.interfaceNames()) {
            if (name.equals(interfaceType)) {
                return true;
            }
        }

        DotName superName = ci.superName();
        if (superName != null) {
            return implementType(
                view.get().getClassByName(superName),
                interfaceType);
        }

        return false;
    }

    // ***********************************
    //
    // YamlProperty
    //
    // ***********************************

    protected static AnnotationSpec yamlProperty(String name, String type) {
        return yamlProperty(name, type, false);
    }

    protected static AnnotationSpec yamlProperty(String name, String type, boolean required) {
        AnnotationSpec.Builder builder = AnnotationSpec.builder(CN_YAML_PROPERTY);
        builder.addMember("name", "$S", name);
        builder.addMember("type", "$S", type);
        if (required) {
            builder.addMember("required", "$L", required);
        }

        return builder.build();
    }

    protected static AnnotationSpec yamlPropertyWithFormat(String name, String type, String format) {
        return yamlPropertyWithFormat(name, type, format, false);
    }

    protected static AnnotationSpec yamlPropertyWithFormat(String name, String type, String format, boolean required) {
        AnnotationSpec.Builder builder = AnnotationSpec.builder(CN_YAML_PROPERTY);
        builder.addMember("name", "$S", name);
        builder.addMember("type", "$S", type);
        builder.addMember("format", "$S", format);

        if (required) {
            builder.addMember("required", "$L", required);
        }

        return builder.build();
    }

    protected static AnnotationSpec yamlPropertyWithSubtype(String name, String type, String subType) {
        return yamlPropertyWithSubtype(name, type , subType, false);
    }

    protected static AnnotationSpec yamlPropertyWithSubtype(String name, String type, String subType, boolean required) {
        return yamlProperty(name, type + ":" + subType, required);
    }

    protected static int getYamlTypeOrder(ClassInfo ci) {
        return annotationValue(ci, YAML_TYPE_ANNOTATION, "order").map(AnnotationValue::asInt).orElse(Integer.MAX_VALUE);
    }

    protected boolean isBanned(ClassInfo ci) {
        if (bannedDefinitions != null) {
            for (String bannedDefinition: bannedDefinitions) {
                if (AntPathMatcher.INSTANCE.match(bannedDefinition.replace('.', '/'), ci.name().toString('/'))) {
                    getLog().debug("Skipping definition: " + ci.name().toString());
                    return true;
                }
            }
        }

        return false;
    }
}
