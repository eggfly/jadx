package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.syntax.Token;

public class PostfixExpression extends Expression {
    private Token DW;
    private Expression FH;

    public String toString() {
        return super.toString() + "[" + this.FH + this.DW + "]";
    }

    public String j6() {
        return "(" + this.FH.j6() + this.DW.u7() + ")";
    }

    public ClassNode s_() {
        return this.FH.s_();
    }
}
