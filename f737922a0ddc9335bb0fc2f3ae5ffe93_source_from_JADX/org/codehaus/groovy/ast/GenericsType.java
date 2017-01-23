package org.codehaus.groovy.ast;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class GenericsType extends ASTNode {
    private final ClassNode DW;
    private ClassNode FH;
    private String Hw;
    private boolean VH;
    private boolean Zo;
    private final ClassNode[] j6;
    private boolean v5;

    private class GenericsTypeMatcher {
    }

    public GenericsType(ClassNode classNode, ClassNode[] classNodeArr, ClassNode classNode2) {
        this.FH = classNode;
        this.Hw = classNode.rN() ? classNode.EQ() : classNode.tp();
        this.j6 = classNodeArr;
        this.DW = classNode2;
        this.v5 = classNode.rN();
        this.Zo = false;
    }

    public GenericsType(ClassNode classNode) {
        this(classNode, null, null);
    }

    public String toString() {
        return j6(new HashSet());
    }

    private String j6(Set<String> set) {
        if (this.v5) {
            set.add(this.Hw);
        }
        String j6 = this.VH ? "?" : (this.FH == null || this.v5) ? this.Hw : j6(this.FH, set);
        if (this.j6 != null) {
            if (this.v5 && this.j6.length == 1 && !this.j6[0].rN() && this.j6[0].tp().equals("java.lang.Object")) {
                return j6;
            }
            String str = j6 + " extends ";
            for (int i = 0; i < this.j6.length; i++) {
                str = str + j6(this.j6[i], set);
                if (i + 1 < this.j6.length) {
                    str = str + " & ";
                }
            }
            return str;
        } else if (this.DW != null) {
            return j6 + " super " + j6(this.DW, set);
        } else {
            return j6;
        }
    }

    private String j6(ClassNode classNode, Set<String> set) {
        StringBuilder stringBuilder = new StringBuilder();
        if (classNode.Mr()) {
            stringBuilder.append(classNode.U2().tp());
            stringBuilder.append("[]");
        } else if (classNode.Zo() instanceof InnerClassNode) {
            InnerClassNode innerClassNode = (InnerClassNode) classNode.Zo();
            String tp = innerClassNode.Ws().tp();
            if (Modifier.isStatic(innerClassNode.we()) || innerClassNode.aM()) {
                stringBuilder.append(innerClassNode.Ws().tp());
            } else {
                stringBuilder.append(j6(innerClassNode.Ws(), new HashSet()));
            }
            stringBuilder.append(".");
            stringBuilder.append(classNode.tp().substring(tp.length() + 1));
        } else {
            stringBuilder.append(classNode.tp());
        }
        GenericsType[] lg = classNode.lg();
        if (lg == null || lg.length == 0) {
            return stringBuilder.toString();
        }
        if (lg.length == 1 && lg[0].gn() && classNode.tp().equals("java.lang.Object")) {
            return lg[0].VH();
        }
        stringBuilder.append("<");
        for (int i = 0; i < lg.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }
            GenericsType genericsType = lg[i];
            if (genericsType.gn() && set.contains(genericsType.VH())) {
                stringBuilder.append(genericsType.VH());
            } else {
                stringBuilder.append(genericsType.j6((Set) set));
            }
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public ClassNode[] Zo() {
        return this.j6;
    }

    public String VH() {
        return this.Hw;
    }

    public boolean gn() {
        return this.v5;
    }

    public void j6(boolean z) {
        this.v5 = z;
        this.FH.FH(z);
    }

    public void j6(String str) {
        this.Hw = str;
    }

    public void DW(boolean z) {
        this.VH = z;
    }

    public ClassNode u7() {
        return this.DW;
    }
}
