package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.syntax.Token;

public class BinaryExpression extends Expression {
    private Expression DW;
    private Expression FH;
    private final Token Hw;

    public String toString() {
        return super.toString() + "[" + this.DW + this.Hw + this.FH + "]";
    }

    public String j6() {
        if (this.Hw.DW() == 30) {
            return this.DW.j6() + "[" + this.FH.j6() + "]";
        }
        return "(" + this.DW.j6() + " " + this.Hw.u7() + " " + this.FH.j6() + ")";
    }
}
