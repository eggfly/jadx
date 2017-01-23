package org.codehaus.groovy.ast.expr;

public class PropertyExpression extends Expression {
    private Expression DW;
    private Expression FH;
    private boolean Hw;
    private boolean VH;
    private boolean Zo;
    private boolean v5;

    public PropertyExpression(Expression expression, String str) {
        this(expression, new ConstantExpression(str), false);
    }

    public PropertyExpression(Expression expression, Expression expression2, boolean z) {
        this.Hw = false;
        this.v5 = false;
        this.Zo = false;
        this.VH = false;
        this.DW = expression;
        this.FH = expression2;
        this.v5 = z;
    }

    public String j6() {
        String j6 = this.DW.j6();
        return j6 + (VH() ? "*" : "") + (Zo() ? "?" : "") + "." + this.FH.j6();
    }

    public boolean Zo() {
        return this.v5;
    }

    public boolean VH() {
        return this.Hw;
    }

    public String toString() {
        return super.toString() + "[object: " + this.DW + " property: " + this.FH + "]";
    }
}
