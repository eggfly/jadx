package org.codehaus.groovy.ast.expr;

import java.util.List;

public class ArrayExpression extends Expression {
    private List<Expression> DW;

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Object obj = 1;
        for (Expression expression : this.DW) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(expression.j6());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String toString() {
        return super.toString() + this.DW;
    }
}
