package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.AnnotatedNode;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;

public abstract class Expression extends AnnotatedNode {
    private ClassNode DW;

    public Expression() {
        this.DW = ClassHelper.j6;
    }

    public ClassNode s_() {
        return this.DW;
    }

    public void DW(ClassNode classNode) {
        this.DW = classNode;
    }
}
