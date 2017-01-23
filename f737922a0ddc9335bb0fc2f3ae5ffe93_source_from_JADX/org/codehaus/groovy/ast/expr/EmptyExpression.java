package org.codehaus.groovy.ast.expr;

public class EmptyExpression extends Expression {
    public static final EmptyExpression DW;

    static {
        DW = new EmptyExpression();
    }
}
