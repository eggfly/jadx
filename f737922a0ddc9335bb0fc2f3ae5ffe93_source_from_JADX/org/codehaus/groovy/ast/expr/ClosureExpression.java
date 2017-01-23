package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.AstToTextHelper;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.runtime.InvokerHelper;

public class ClosureExpression extends Expression {
    private Parameter[] DW;
    private Statement FH;

    public String toString() {
        return super.toString() + InvokerHelper.toString(this.DW) + "{ " + this.FH + " }";
    }

    public String j6() {
        String j6 = AstToTextHelper.j6(this.DW);
        if (j6.length() > 0) {
            return "{ " + j6 + " -> ... }";
        }
        return "{ -> ... }";
    }
}
