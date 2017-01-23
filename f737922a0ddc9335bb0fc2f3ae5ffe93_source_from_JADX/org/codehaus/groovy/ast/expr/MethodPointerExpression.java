package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;

public class MethodPointerExpression extends Expression {
    private Expression DW;
    private Expression FH;

    public String j6() {
        if (this.DW == null) {
            return "&" + this.FH;
        }
        return this.DW.j6() + ".&" + this.FH.j6();
    }

    public ClassNode s_() {
        return ClassHelper.Hw.yS();
    }
}
