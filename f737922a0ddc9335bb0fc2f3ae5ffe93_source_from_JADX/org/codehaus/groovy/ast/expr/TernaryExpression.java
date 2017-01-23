package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;

public class TernaryExpression extends Expression {
    private BooleanExpression DW;
    private Expression FH;
    private Expression Hw;

    public String toString() {
        return super.toString() + "[" + this.DW + " ? " + this.FH + " : " + this.Hw + "]";
    }

    public String j6() {
        return "(" + this.DW.j6() + ") ? " + this.FH.j6() + " : " + this.Hw.j6();
    }

    public ClassNode s_() {
        return ClassHelper.DW;
    }
}
