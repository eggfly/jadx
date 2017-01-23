package org.codehaus.groovy.ast;

import groovyjarjarasm.asm.Opcodes;
import org.codehaus.groovy.ast.expr.Expression;

public class FieldNode extends AnnotatedNode implements Opcodes, Variable {
    private String DW;
    private int FH;
    private ClassNode Hw;
    private boolean VH;
    private Expression Zo;
    private ClassNode gn;
    private ClassNode v5;

    public FieldNode(String str, int i, ClassNode classNode, ClassNode classNode2, Expression expression) {
        this.gn = ClassHelper.j6;
        this.DW = str;
        this.FH = i;
        this.Hw = classNode;
        if (this.Hw == ClassHelper.j6 && expression != null) {
            DW(expression.s_());
        }
        DW(classNode);
        this.gn = classNode;
        this.v5 = classNode2;
        this.Zo = expression;
    }

    public String t_() {
        return this.DW;
    }

    public ClassNode s_() {
        return this.Hw;
    }

    public void DW(ClassNode classNode) {
        this.Hw = classNode;
        this.gn = classNode;
        this.VH = (classNode == ClassHelper.j6 ? 1 : 0) | this.VH;
    }

    public boolean u_() {
        return this.VH;
    }

    public void FH(ClassNode classNode) {
        this.v5 = classNode;
    }
}
