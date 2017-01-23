package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;

public class ConstructorCallExpression extends Expression implements MethodCall {
    private final Expression DW;

    public String j6() {
        String str;
        if (Zo()) {
            str = "super ";
        } else if (VH()) {
            str = "this ";
        } else {
            str = "new " + s_().tp();
        }
        return str + this.DW.j6();
    }

    public String toString() {
        return super.toString() + "[type: " + s_() + " arguments: " + this.DW + "]";
    }

    public boolean Zo() {
        return s_() == ClassNode.Hw;
    }

    public boolean VH() {
        return s_() == ClassNode.FH;
    }
}
