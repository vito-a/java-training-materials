package org.example;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SPELSample {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression1 = parser.parseExpression("new String('Please parse me').toUpperCase()");
        System.out.println(expression1.getValue());
    }
}
