package org.codehaus.groovy.ast;

import org.codehaus.groovy.ast.expr.Expression;

public class Parameter extends AnnotatedNode implements Variable {
    public static final Parameter[] DW;
    private ClassNode FH;
    private final String Hw;
    private boolean VH;
    private Expression Zo;
    private boolean gn;
    private ClassNode tp;
    private boolean u7;
    private boolean v5;

    static {
        DW = new Parameter[0];
    }

    public Parameter(ClassNode classNode, String str) {
        this.u7 = false;
        this.tp = ClassHelper.j6;
        this.Hw = str;
        DW(classNode);
        this.tp = classNode;
        this.VH = false;
    }

    public String toString() {
        return super.toString() + "[name:" + this.Hw + (this.FH == null ? "" : " type: " + this.FH.tp()) + ", hasDefaultValue: " + Zo() + "]";
    }

    public String t_() {
        return this.Hw;
    }

    public ClassNode s_() {
        return this.FH;
    }

    public void DW(ClassNode classNode) {
        this.FH = classNode;
        this.v5 = (classNode == ClassHelper.j6 ? 1 : 0) | this.v5;
    }

    public boolean Zo() {
        return this.VH;
    }

    public Expression VH() {
        return this.Zo;
    }

    public void DW(boolean z) {
        this.gn = z;
    }

    public boolean u_() {
        return this.v5;
    }
}
