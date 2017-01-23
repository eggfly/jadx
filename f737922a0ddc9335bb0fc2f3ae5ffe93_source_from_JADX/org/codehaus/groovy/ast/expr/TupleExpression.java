package org.codehaus.groovy.ast.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TupleExpression extends Expression implements Iterable<Expression> {
    private List<Expression> DW;

    public TupleExpression() {
        this(0);
    }

    public TupleExpression(int i) {
        this.DW = new ArrayList(i);
    }

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder("(");
        Object obj = 1;
        for (Expression expression : this.DW) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(expression.j6());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public String toString() {
        return super.toString() + this.DW;
    }

    public Iterator<Expression> iterator() {
        return Collections.unmodifiableList(this.DW).iterator();
    }
}
