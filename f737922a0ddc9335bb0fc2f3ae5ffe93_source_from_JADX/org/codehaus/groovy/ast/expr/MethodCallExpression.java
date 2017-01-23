package org.codehaus.groovy.ast.expr;

public class MethodCallExpression extends Expression implements MethodCall {
    public static final Expression DW;
    private Expression FH;
    private Expression Hw;
    private boolean VH;
    private boolean Zo;
    private Expression v5;

    static {
        DW = new TupleExpression();
    }

    public String j6() {
        String j6 = this.FH.j6();
        String j62 = this.Hw.j6();
        return j6 + (this.Zo ? "*" : "") + (this.VH ? "?" : "") + "." + j62 + this.v5.j6();
    }

    public String toString() {
        return super.toString() + "[object: " + this.FH + " method: " + this.Hw + " arguments: " + this.v5 + "]";
    }
}
