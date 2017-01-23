package org.codehaus.groovy.ast.stmt;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.ast.VariableScope;

public class BlockStatement extends Statement {
    private VariableScope DW;
    private List<Statement> j6;

    public BlockStatement() {
        this(new ArrayList(), new VariableScope());
    }

    public BlockStatement(List<Statement> list, VariableScope variableScope) {
        this.j6 = new ArrayList();
        this.j6 = list;
        this.DW = variableScope;
    }

    public String toString() {
        return super.toString() + this.j6;
    }

    public String j6() {
        StringBuilder stringBuilder = new StringBuilder("{ ");
        Object obj = 1;
        for (Statement statement : this.j6) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("; ");
            }
            stringBuilder.append(statement.j6());
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
