package org.codehaus.groovy.ast.expr;

public class RangeExpression extends Expression {
    private Expression DW;
    private Expression FH;
    private boolean Hw;

    public boolean Zo() {
        return this.Hw;
    }

    public String j6() {
        return "(" + this.DW.j6() + (!Zo() ? "..<" : "..") + this.FH.j6() + ")";
    }
}
