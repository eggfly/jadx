package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;

public class CastExpression extends Expression {
    private final Expression DW;

    public String toString() {
        return super.toString() + "[(" + s_().tp() + ") " + this.DW + "]";
    }

    public String j6() {
        return "(" + s_() + ") " + this.DW.j6();
    }

    public void DW(ClassNode classNode) {
        super.DW(classNode);
    }
}
