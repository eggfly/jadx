package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassNode;

public class ClassExpression extends Expression {
    public ClassExpression(ClassNode classNode) {
        super.DW(classNode);
    }

    public String j6() {
        return s_().tp();
    }

    public String toString() {
        return super.toString() + "[type: " + s_().tp() + "]";
    }
}
