package org.codehaus.groovy.ast.expr;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.ast.ClassHelper;

public class ListExpression extends Expression {
    private List<Expression> DW;
    private boolean FH;

    public ListExpression() {
        this(new ArrayList());
    }

    public ListExpression(List<Expression> list) {
        this.FH = false;
        this.DW = list;
        DW(ClassHelper.Zo);
    }

    public void j6(Expression expression) {
        this.DW.add(expression);
    }

    public List<Expression> Zo() {
        return this.DW;
    }

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
