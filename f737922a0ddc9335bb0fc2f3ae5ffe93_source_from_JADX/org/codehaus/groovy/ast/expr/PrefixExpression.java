package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.syntax.Token;

public class PrefixExpression extends Expression {
    private Token DW;
    private Expression FH;

    public String toString() {
        return super.toString() + "[" + this.DW + this.FH + "]";
    }

    public String j6() {
        return "(" + this.DW.u7() + this.FH.j6() + ")";
    }

    public ClassNode s_() {
        return this.FH.s_();
    }
}
