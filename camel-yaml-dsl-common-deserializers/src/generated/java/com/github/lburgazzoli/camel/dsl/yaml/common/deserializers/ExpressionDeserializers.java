package com.github.lburgazzoli.camel.dsl.yaml.common.deserializers;

import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlProperty;
import com.github.lburgazzoli.camel.dsl.yaml.annotations.YamlType;
import com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerSupport;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.apache.camel.model.language.ExpressionDefinition;
import org.snakeyaml.engine.v2.api.ConstructNode;
import org.snakeyaml.engine.v2.nodes.Node;

public final class ExpressionDeserializers extends YamlDeserializerSupport {
    private ExpressionDeserializers() {
    }

    public static ExpressionDefinition constructExpressionType(Node node) {
        var mn = asMappingNode(node);
        if (mn.getValue().size() != 1) {
            return null;
        }
        var nt = mn.getValue().get(0);
        var dc = getDeserializationContext(node);
        var key = asText(nt.getKeyNode());
        var val = setDeserializationContext(nt.getValueNode(), dc);
        return constructExpressionType(key, val);
    }

    public static ExpressionDefinition constructExpressionType(String id, Node node) {
        switch(id) {
            case "constant": {
                return asType(node, org.apache.camel.model.language.ConstantExpression.class);
            }
            case "csimple": {
                return asType(node, org.apache.camel.model.language.CSimpleExpression.class);
            }
            case "datasonnet": {
                return asType(node, org.apache.camel.model.language.DatasonnetExpression.class);
            }
            case "exchangeProperty": {
                return asType(node, org.apache.camel.model.language.ExchangePropertyExpression.class);
            }
            case "exchange-property": {
                return asType(node, org.apache.camel.model.language.ExchangePropertyExpression.class);
            }
            case "groovy": {
                return asType(node, org.apache.camel.model.language.GroovyExpression.class);
            }
            case "header": {
                return asType(node, org.apache.camel.model.language.HeaderExpression.class);
            }
            case "hl7terser": {
                return asType(node, org.apache.camel.model.language.Hl7TerserExpression.class);
            }
            case "joor": {
                return asType(node, org.apache.camel.model.language.JoorExpression.class);
            }
            case "jsonpath": {
                return asType(node, org.apache.camel.model.language.JsonPathExpression.class);
            }
            case "language": {
                return asType(node, org.apache.camel.model.language.LanguageExpression.class);
            }
            case "method": {
                return asType(node, org.apache.camel.model.language.MethodCallExpression.class);
            }
            case "mvel": {
                return asType(node, org.apache.camel.model.language.MvelExpression.class);
            }
            case "ognl": {
                return asType(node, org.apache.camel.model.language.OgnlExpression.class);
            }
            case "ref": {
                return asType(node, org.apache.camel.model.language.RefExpression.class);
            }
            case "simple": {
                return asType(node, org.apache.camel.model.language.SimpleExpression.class);
            }
            case "spel": {
                return asType(node, org.apache.camel.model.language.SpELExpression.class);
            }
            case "tokenize": {
                return asType(node, org.apache.camel.model.language.TokenizerExpression.class);
            }
            case "xpath": {
                return asType(node, org.apache.camel.model.language.XPathExpression.class);
            }
            case "xquery": {
                return asType(node, org.apache.camel.model.language.XQueryExpression.class);
            }
            case "xtokenize": {
                return asType(node, org.apache.camel.model.language.XMLTokenizerExpression.class);
            }
            case "expression": {
                return constructExpressionType(node);
            }
            case "expression-type": {
                return constructExpressionType(node);
            }
        }
        return null;
    }

    @YamlType(
            types = org.apache.camel.model.language.ExpressionDefinition.class,
            order = com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "constant", type = "object:org.apache.camel.model.language.ConstantExpression"),
                    @YamlProperty(name = "csimple", type = "object:org.apache.camel.model.language.CSimpleExpression"),
                    @YamlProperty(name = "datasonnet", type = "object:org.apache.camel.model.language.DatasonnetExpression"),
                    @YamlProperty(name = "exchangeProperty", type = "object:org.apache.camel.model.language.ExchangePropertyExpression"),
                    @YamlProperty(name = "exchange-property", type = "object:org.apache.camel.model.language.ExchangePropertyExpression"),
                    @YamlProperty(name = "groovy", type = "object:org.apache.camel.model.language.GroovyExpression"),
                    @YamlProperty(name = "header", type = "object:org.apache.camel.model.language.HeaderExpression"),
                    @YamlProperty(name = "hl7terser", type = "object:org.apache.camel.model.language.Hl7TerserExpression"),
                    @YamlProperty(name = "joor", type = "object:org.apache.camel.model.language.JoorExpression"),
                    @YamlProperty(name = "jsonpath", type = "object:org.apache.camel.model.language.JsonPathExpression"),
                    @YamlProperty(name = "language", type = "object:org.apache.camel.model.language.LanguageExpression"),
                    @YamlProperty(name = "method", type = "object:org.apache.camel.model.language.MethodCallExpression"),
                    @YamlProperty(name = "mvel", type = "object:org.apache.camel.model.language.MvelExpression"),
                    @YamlProperty(name = "ognl", type = "object:org.apache.camel.model.language.OgnlExpression"),
                    @YamlProperty(name = "ref", type = "object:org.apache.camel.model.language.RefExpression"),
                    @YamlProperty(name = "simple", type = "object:org.apache.camel.model.language.SimpleExpression"),
                    @YamlProperty(name = "spel", type = "object:org.apache.camel.model.language.SpELExpression"),
                    @YamlProperty(name = "tokenize", type = "object:org.apache.camel.model.language.TokenizerExpression"),
                    @YamlProperty(name = "xpath", type = "object:org.apache.camel.model.language.XPathExpression"),
                    @YamlProperty(name = "xquery", type = "object:org.apache.camel.model.language.XQueryExpression"),
                    @YamlProperty(name = "xtokenize", type = "object:org.apache.camel.model.language.XMLTokenizerExpression")
            }
    )
    public static class ExpressionDefinitionDeserializers implements ConstructNode {
        @Override
        public Object construct(Node node) {
            return constructExpressionType(node);
        }
    }

    @YamlType(
            types = org.apache.camel.model.ExpressionSubElementDefinition.class,
            order = com.github.lburgazzoli.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "constant", type = "object:org.apache.camel.model.language.ConstantExpression"),
                    @YamlProperty(name = "csimple", type = "object:org.apache.camel.model.language.CSimpleExpression"),
                    @YamlProperty(name = "datasonnet", type = "object:org.apache.camel.model.language.DatasonnetExpression"),
                    @YamlProperty(name = "exchangeProperty", type = "object:org.apache.camel.model.language.ExchangePropertyExpression"),
                    @YamlProperty(name = "exchange-property", type = "object:org.apache.camel.model.language.ExchangePropertyExpression"),
                    @YamlProperty(name = "groovy", type = "object:org.apache.camel.model.language.GroovyExpression"),
                    @YamlProperty(name = "header", type = "object:org.apache.camel.model.language.HeaderExpression"),
                    @YamlProperty(name = "hl7terser", type = "object:org.apache.camel.model.language.Hl7TerserExpression"),
                    @YamlProperty(name = "joor", type = "object:org.apache.camel.model.language.JoorExpression"),
                    @YamlProperty(name = "jsonpath", type = "object:org.apache.camel.model.language.JsonPathExpression"),
                    @YamlProperty(name = "language", type = "object:org.apache.camel.model.language.LanguageExpression"),
                    @YamlProperty(name = "method", type = "object:org.apache.camel.model.language.MethodCallExpression"),
                    @YamlProperty(name = "mvel", type = "object:org.apache.camel.model.language.MvelExpression"),
                    @YamlProperty(name = "ognl", type = "object:org.apache.camel.model.language.OgnlExpression"),
                    @YamlProperty(name = "ref", type = "object:org.apache.camel.model.language.RefExpression"),
                    @YamlProperty(name = "simple", type = "object:org.apache.camel.model.language.SimpleExpression"),
                    @YamlProperty(name = "spel", type = "object:org.apache.camel.model.language.SpELExpression"),
                    @YamlProperty(name = "tokenize", type = "object:org.apache.camel.model.language.TokenizerExpression"),
                    @YamlProperty(name = "xpath", type = "object:org.apache.camel.model.language.XPathExpression"),
                    @YamlProperty(name = "xquery", type = "object:org.apache.camel.model.language.XQueryExpression"),
                    @YamlProperty(name = "xtokenize", type = "object:org.apache.camel.model.language.XMLTokenizerExpression")
            }
    )
    public static class ExpressionSubElementDefinitionDeserializers implements ConstructNode {
        @Override
        public Object construct(Node node) {
            var val = constructExpressionType(node);
            return new org.apache.camel.model.ExpressionSubElementDefinition(val);
        }
    }
}
