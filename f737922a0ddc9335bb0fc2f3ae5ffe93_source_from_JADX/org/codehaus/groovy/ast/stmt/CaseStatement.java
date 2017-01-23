package org.codehaus.groovy.ast.stmt;

import org.codehaus.groovy.ast.expr.Expression;

public class CaseStatement extends Statement {
    private Expression DW;
    private Statement j6;

    public String toString() {
        return super.toString() + "[expression: " + this.DW + "; code: " + this.j6 + "]";
    }
}
