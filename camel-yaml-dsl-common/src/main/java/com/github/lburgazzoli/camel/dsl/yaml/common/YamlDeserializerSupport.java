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
package com.github.lburgazzoli.camel.dsl.yaml.common;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.lburgazzoli.camel.dsl.yaml.common.exception.UnsupportedNodeTypeException;
import com.github.lburgazzoli.camel.dsl.yaml.common.exception.YamlConstructException;
import org.apache.camel.CamelContext;
import org.apache.camel.util.StringHelper;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.NodeType;
import org.snakeyaml.engine.v2.nodes.ScalarNode;
import org.snakeyaml.engine.v2.nodes.SequenceNode;

public class YamlDeserializerSupport {

    public static Class<?> asClass(String val) throws YamlConstructException {
        try {
            return Class.forName(val);
        } catch (ClassNotFoundException e) {
            throw new YamlConstructException("Unable to load class " + val, e);
        }
    }

    public static Class<?>[] asClassArray(String val) throws YamlConstructException {
        String[] values = val.split(" ");
        Class<?>[] cls = new Class<?>[values.length];
        for (int i = 0; i < values.length; i++) {
            cls[i] = asClass(values[i]);
        }
        return cls;
    }

    public static byte[] asByteArray(String val) {
        return Base64.getDecoder().decode(val);
    }

    public static List<String> asStringList(String val) {
        return List.of(val.split(" "));
    }

    public static Set<String> asStringSet(String val) {
        return Set.of(val.split(" "));
    }

    public static byte[] asByteArray(Node node) {
        return asByteArray(asText(node));
    }

    public static Class<?> asClass(Node node) {
        return asClass(asText(node));
    }

    public static List<String> asStringList(Node node) {
        List<String> answer;

        if (node.getNodeType() == NodeType.SCALAR) {
            answer = asStringList(asText(node));
        } else if (node.getNodeType() == NodeType.SEQUENCE) {
            answer = new ArrayList<>();
            for(Node item: asSequenceNode(node).getValue()) {
                answer.add(asText(item));
            }
        } else {
            throw new UnsupportedNodeTypeException(node);
        }

        return answer;
    }

    public static Set<String> asStringSet(Node node) {
        return asStringSet(asText(node));
    }

    public static Class<?>[] asClassArray(Node node) throws YamlConstructException {
        return asClassArray(asText(node));
    }

    public static String asText(Node node) throws YamlConstructException {
        if (node.getNodeType() != NodeType.SCALAR) {
            throw new IllegalArgumentException("Node is not SCALAR");
        }

        return ((ScalarNode)node).getValue();
    }

    public static Map<String, Object> asMap(Node node) {
        final MappingNode mn = asMappingNode(node);
        final Map<String, Object> answer = new HashMap<>();

        for (NodeTuple tuple : mn.getValue()) {
            final String key = asText(tuple.getKeyNode());
            final Node val = tuple.getValueNode();

            switch (val.getNodeType()) {
                case SCALAR:
                    answer.put(StringHelper.dashToCamelCase(key), asText(val));
                    break;
                case MAPPING:
                    answer.put(StringHelper.dashToCamelCase(key), asMap(val));
                    break;
                default:
                    throw new UnsupportedNodeTypeException(node);
            }
        }

        return answer;
    }

    public static Map<String, Object> asScalarMap(Node node) {
        final MappingNode mn = asMappingNode(node);
        final Map<String, Object> answer = new HashMap<>();

        for (NodeTuple tuple : mn.getValue()) {
            final String key = asText(tuple.getKeyNode());
            final Node val = tuple.getValueNode();

            switch (val.getNodeType()) {
                case SCALAR:
                    answer.put(StringHelper.dashToCamelCase(key), asText(val));
                    break;
                default:
                    throw new UnsupportedNodeTypeException(node);
            }
        }

        return answer;
    }

    public static boolean asBoolean(Node node) throws YamlConstructException {
        return Boolean.parseBoolean(asText(node));
    }

    public static int asInt(Node node) throws YamlConstructException {
        return Integer.parseInt(asText(node));
    }

    public static long asLong(Node node) throws YamlConstructException {
        return Long.parseLong(asText(node));
    }

    public static double asDouble(Node node) throws YamlConstructException {
        return Double.parseDouble(asText(node));
    }

    public static MappingNode asMappingNode(Node node) throws YamlConstructException {
        if (node == null) {
            return null;
        }

        if (node.getNodeType() != NodeType.MAPPING) {
            throw new IllegalArgumentException("Node is not MAPPING");
        }

        return (MappingNode)node;
    }

    public static SequenceNode asSequenceNode(Node node) throws YamlConstructException {
        if (node == null) {
            return null;
        }

        if (node.getNodeType() != NodeType.SEQUENCE) {
            throw new IllegalArgumentException("Node is not MAPPING");
        }

        return (SequenceNode)node;
    }

    public static Node getNamedNode(MappingNode node, String name) throws YamlConstructException {
        if (node == null) {
            return null;
        }

        for (NodeTuple tuple: node.getValue()) {
            if (name.equals(asText(tuple.getKeyNode()))) {
                return tuple.getValueNode();
            }
        }

        return null;
    }

    public static Map<String, Node> getNamedNodes(MappingNode node) throws YamlConstructException {
        if (node == null) {
            return Map.of();
        }
        if (node .getValue().isEmpty()) {
            return Map.of();
        }

        YamlDeserializationContext res = (YamlDeserializationContext)node.getProperty(YamlDeserializationContext.class.getName());
        Map<String, Node> answer = new HashMap<>();
        for (NodeTuple tuple: node.getValue()) {
            String key = asText(tuple.getKeyNode());
            Node val = tuple.getValueNode();

            if (key != null && val != null) {
                if (res != null) {
                    val.setProperty(YamlDeserializationContext.class.getName(), res);
                }
                answer.put(key, val);
            }
        }

        return answer;
    }

    public static MappingNode getNamedMappingNode(MappingNode node, String name) throws YamlConstructException {
        return asMappingNode(getNamedNode(node, name));
    }

    public static SequenceNode getNamedSequenceNode(MappingNode node, String name) throws YamlConstructException {
        return asSequenceNode(getNamedNode(node, name));
    }

    public static <T> List<T> asNestedList(Node node, Class<T> type) throws YamlConstructException {
        List<T> answer = new ArrayList<>();
        asNestedCollection(node, type, answer);

        return answer;
    }

    public static <T> List<T> asFlatList(Node node, Class<T> type) throws YamlConstructException {
        List<T> answer = new ArrayList<>();
        asFlatCollection(node, type, answer);

        return answer;
    }

    public static <T> Set<T> asNestedSet(Node node, Class<T> type) throws YamlConstructException {
        Set<T> answer = new HashSet<>();
        asNestedCollection(node, type, answer);

        return answer;
    }

    public static <T> Set<T> asFlatSet(Node node, Class<T> type) throws YamlConstructException {
        Set<T> answer = new HashSet<>();
        asFlatCollection(node, type, answer);

        return answer;
    }

    public static <T> void asNestedCollection(Node node, Class<T> type, Collection<T> collection) throws YamlConstructException {
        asCollection(node, type, collection, false);
    }

    public static <T> void asFlatCollection(Node node, Class<T> type, Collection<T> collection) throws YamlConstructException {
        asCollection(node, type, collection, true);
    }

    private static <T> void asCollection(Node node, Class<T> type, Collection<T> collection, boolean flat) throws YamlConstructException {
        if (node.getNodeType() != NodeType.SEQUENCE) {
            throw new UnsupportedOperationException("Unable to parse no array node");
        }

        YamlDeserializationContext dc = getDeserializationContext(node);
        if (dc == null) {
            throw new IllegalArgumentException("Unable to find YamlConstructor");
        }

        for (Node element: asSequenceNode(node).getValue()) {
            final Node val = setDeserializationContext(element, dc);
            final T instance;

            if (flat) {
                instance = asType(val, type);
            } else {
                ConstructNode cn = dc.mandatoryResolve(val);
                instance = type.cast(cn.construct(val));
            }

            collection.add(instance);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T asType(Node node, Class<T> type) throws YamlConstructException {
        YamlDeserializationContext resolver = (YamlDeserializationContext)node.getProperty(YamlDeserializationContext.class.getName());
        if (resolver == null) {
            throw new IllegalArgumentException("Unable to find YamlConstructor");
        }
        ConstructNode construct = resolver.resolve(type);
        if (construct == null) {
            throw new IllegalArgumentException("Unable to determine constructor for type: " + type.getName());
        }

        return (T)construct.construct(node);
    }

    public static String asEndpoint(Node node) {
        return asEndpoint(
            asMappingNode(node)
        );
    }

    public static String asEndpoint(MappingNode node){
        final YamlDeserializationContext dc = getDeserializationContext(node);
        final CamelContext cc = dc.getCamelContext();

        String uri = null;
        Map<String, Object> properties = null;

        for (NodeTuple tuple : node.getValue()) {
            final String key = YamlDeserializerSupport.asText(tuple.getKeyNode());
            final Node val = tuple.getValueNode();

            setDeserializationContext(val, dc);

            switch (key) {
                case "uri":
                    uri = YamlDeserializerSupport.asText(val);
                    break;
                case "properties":
                    properties = YamlDeserializerSupport.asScalarMap(tuple.getValueNode());
                    break;
            }
        }

        return YamlSupport.createEndpointUri(cc, uri, properties);
    }

    public static YamlDeserializationContext getDeserializationContext(Node node) {
        return (YamlDeserializationContext)node.getProperty(YamlDeserializationContext.class.getName());
    }

    public static Node setDeserializationContext(Node node, YamlDeserializationContext context) {
        node.setProperty(YamlDeserializationContext.class.getName(), context);
        return node;
    }
}
