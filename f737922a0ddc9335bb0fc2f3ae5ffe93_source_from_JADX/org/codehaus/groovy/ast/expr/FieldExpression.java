package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;

public class FieldExpression extends Expression {
    private final FieldNode DW;

    public String Zo() {
        return this.DW.t_();
    }

    public String j6() {
        return "this." + this.DW.t_();
    }

    public void DW(ClassNode classNode) {
        super.DW(classNode);
        this.DW.DW(classNode);
    }

    public ClassNode s_() {
        return this.DW.s_();
    }

    public String toString() {
        return "field(" + s_() + " " + Zo() + ")";
    }
}
