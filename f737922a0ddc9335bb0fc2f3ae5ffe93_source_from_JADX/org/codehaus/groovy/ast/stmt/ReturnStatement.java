package org.codehaus.groovy.ast.stmt;

import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;

public class ReturnStatement extends Statement {
    public static final ReturnStatement j6;
    private Expression DW;

    static {
        j6 = new ReturnStatement(ConstantExpression.DW);
    }

    public ReturnStatement(Expression expression) {
        this.DW = expression;
    }

    public String j6() {
        return "return " + this.DW.j6();
    }
}
