package org.codehaus.groovy.ast;

import groovyjarjarasm.asm.Opcodes;
import org.codehaus.groovy.ast.stmt.Statement;

public class MethodNode extends AnnotatedNode implements Opcodes {
    String DW;
    private final ClassNode[] EQ;
    private final String FH;
    private int Hw;
    private GenericsType[] J0;
    private boolean J8;
    private boolean VH;
    private Parameter[] Zo;
    private Statement gn;
    private VariableScope tp;
    private boolean u7;
    private ClassNode v5;
    private final boolean we;

    public MethodNode(String str, int i, ClassNode classNode, Parameter[] parameterArr, ClassNode[] classNodeArr, Statement statement) {
        boolean z = false;
        this.VH = false;
        this.J0 = null;
        this.FH = str;
        this.Hw = i;
        this.gn = statement;
        DW(classNode);
        j6(new VariableScope());
        j6(parameterArr);
        this.J8 = false;
        this.EQ = classNodeArr;
        if (str != null && str.equals("<clinit>")) {
            z = true;
        }
        this.we = z;
    }

    public String Zo() {
        if (this.DW == null) {
            StringBuilder stringBuilder = new StringBuilder(this.FH.length() + (this.Zo.length * 10));
            stringBuilder.append(this.v5.tp());
            stringBuilder.append(' ');
            stringBuilder.append(this.FH);
            stringBuilder.append('(');
            for (int i = 0; i < this.Zo.length; i++) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(FH(this.Zo[i].s_()));
            }
            stringBuilder.append(')');
            this.DW = stringBuilder.toString();
        }
        return this.DW;
    }

    private static String FH(ClassNode classNode) {
        int i = 0;
        if (!classNode.Mr()) {
            return classNode.tp();
        }
        int i2 = 0;
        while (classNode.Mr()) {
            i2++;
            classNode = classNode.U2();
        }
        StringBuilder stringBuilder = new StringBuilder(classNode.tp().length() + (i2 * 2));
        stringBuilder.append(classNode.tp());
        while (i < i2) {
            stringBuilder.append("[]");
            i++;
        }
        return stringBuilder.toString();
    }

    private void J8() {
        this.DW = null;
    }

    public Statement VH() {
        return this.gn;
    }

    public void j6(Statement statement) {
        this.gn = statement;
    }

    public int gn() {
        return this.Hw;
    }

    public String u7() {
        return this.FH;
    }

    public Parameter[] tp() {
        return this.Zo;
    }

    public void j6(Parameter[] parameterArr) {
        J8();
        VariableScope variableScope = new VariableScope();
        this.Zo = parameterArr;
        if (parameterArr != null && parameterArr.length > 0) {
            for (Variable variable : parameterArr) {
                if (variable.Zo()) {
                    this.VH = true;
                }
                variable.DW(we());
                variableScope.j6(variable);
            }
        }
        j6(variableScope);
    }

    public ClassNode EQ() {
        return this.v5;
    }

    public void j6(VariableScope variableScope) {
        this.tp = variableScope;
        variableScope.j6(we());
    }

    public boolean we() {
        return (this.Hw & 8) != 0;
    }

    public String toString() {
        return "MethodNode@" + hashCode() + "[" + Zo() + "]";
    }

    public void DW(ClassNode classNode) {
        J8();
        this.u7 = (ClassHelper.j6 == classNode ? 1 : 0) | this.u7;
        this.v5 = classNode;
        if (classNode == null) {
            this.v5 = ClassHelper.DW;
        }
    }

    public ClassNode[] J0() {
        return this.EQ;
    }

    public void j6(GenericsType[] genericsTypeArr) {
        J8();
        this.J0 = genericsTypeArr;
    }

    public void DW(boolean z) {
        this.J8 = z;
    }

    public String j6() {
        String j6 = AstToTextHelper.j6(this.v5);
        return AstToTextHelper.j6(this.Hw) + " " + j6 + " " + this.FH + "(" + AstToTextHelper.j6(this.Zo) + ") " + AstToTextHelper.j6(this.EQ) + " { ... }";
    }
}
