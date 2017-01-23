package org.codehaus.groovy.ast.expr;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.ast.VariableScope;

public class ClosureListExpression extends ListExpression {
    private VariableScope DW;

    public ClosureListExpression(List<Expression> list) {
        super(list);
        this.DW = new VariableScope();
    }

    public ClosureListExpression() {
        this(new ArrayList(3));
    }

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder("(");
        Object obj = 1;
        for (Expression expression : Zo()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("; ");
            }
            stringBuilder.append(expression.j6());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
