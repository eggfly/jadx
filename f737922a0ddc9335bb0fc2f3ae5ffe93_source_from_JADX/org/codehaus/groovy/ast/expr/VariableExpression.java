package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.Variable;

public class VariableExpression extends Expression implements Variable {
    public static final VariableExpression DW;
    public static final VariableExpression FH;
    boolean Hw;
    private boolean VH;
    private String Zo;
    private Variable gn;
    private final ClassNode u7;
    boolean v5;

    static {
        DW = new VariableExpression("this", ClassHelper.j6);
        FH = new VariableExpression("super", ClassHelper.j6);
    }

    public VariableExpression(String str, ClassNode classNode) {
        this.VH = false;
        this.Hw = false;
        this.v5 = false;
        this.Zo = str;
        this.u7 = classNode;
        DW(ClassHelper.j6(classNode));
    }

    public String j6() {
        return this.Zo;
    }

    public String t_() {
        return this.Zo;
    }

    public String toString() {
        return super.toString() + "[variable: " + this.Zo + (u_() ? "" : " type: " + s_()) + "]";
    }

    public void DW(ClassNode classNode) {
        super.DW(classNode);
        this.VH = (ClassHelper.j6 == classNode ? 1 : 0) | this.VH;
    }

    public boolean u_() {
        if (this.gn == null || this.gn == this) {
            return this.VH;
        }
        return this.gn.u_();
    }

    public ClassNode s_() {
        if (this.gn == null || this.gn == this) {
            return super.s_();
        }
        return this.gn.s_();
    }
}
