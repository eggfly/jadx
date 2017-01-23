package org.codehaus.groovy.ast.expr;

public class MapEntryExpression extends Expression {
    private Expression DW;
    private Expression FH;

    public String toString() {
        return super.toString() + "(key: " + this.DW + ", value: " + this.FH + ")";
    }

    public Expression Zo() {
        return this.DW;
    }

    public Expression VH() {
        return this.FH;
    }
}
