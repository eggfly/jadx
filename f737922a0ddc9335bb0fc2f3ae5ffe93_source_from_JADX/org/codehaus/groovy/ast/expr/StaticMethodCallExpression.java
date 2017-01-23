package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;

public class StaticMethodCallExpression extends Expression implements MethodCall {
    private ClassNode DW;
    private String FH;
    private Expression Hw;

    public String j6() {
        return Zo().tp() + "." + this.FH + this.Hw.j6();
    }

    public String toString() {
        return super.toString() + "[" + Zo().tp() + "#" + this.FH + " arguments: " + this.Hw + "]";
    }

    public ClassNode Zo() {
        return this.DW;
    }
}
