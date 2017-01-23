package org.codehaus.groovy.ast.stmt;

import org.codehaus.groovy.ast.expr.Expression;

public class ExpressionStatement extends Statement {
    private Expression j6;

    public String j6() {
        return toString();
    }

    public String toString() {
        return super.toString() + "[expression:" + this.j6 + "]";
    }
}
