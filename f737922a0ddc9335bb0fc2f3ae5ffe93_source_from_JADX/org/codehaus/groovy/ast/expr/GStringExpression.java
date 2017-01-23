package org.codehaus.groovy.ast.expr;

import java.util.List;

public class GStringExpression extends Expression {
    private String DW;
    private List<ConstantExpression> FH;
    private List<Expression> Hw;

    public String toString() {
        return super.toString() + "[strings: " + this.FH + " values: " + this.Hw + "]";
    }

    public String j6() {
        return this.DW;
    }
}
