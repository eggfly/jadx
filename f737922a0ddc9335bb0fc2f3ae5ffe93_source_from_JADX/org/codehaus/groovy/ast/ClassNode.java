package org.codehaus.groovy.ast;

import groovyjarjarasm.asm.Opcodes;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.vmplugin.VMPluginFactory;

public class ClassNode extends AnnotatedNode implements Opcodes {
    public static final ClassNode[] DW;
    public static final ClassNode FH;
    public static final ClassNode Hw;
    private MethodNode BT;
    private MixinNode[] EQ;
    private MapOfLists J0;
    private List<MethodNode> J8;
    private boolean Mr;
    private Map<String, FieldNode> QX;
    private ClassNode U2;
    protected Class VH;
    private LinkedList<FieldNode> Ws;
    private ModuleNode XL;
    protected Object Zo;
    private boolean a8;
    private CompileUnit aM;
    private GenericsType[] er;
    private boolean gW;
    private String gn;
    private boolean j3;
    private ClassNode lg;
    private ClassNode rN;
    private ClassNode[] tp;
    private int u7;
    protected boolean v5;
    private List<ConstructorNode> we;
    private boolean yS;

    private static class MapOfLists {
        private Map<Object, List<MethodNode>> j6;

        private MapOfLists() {
            this.j6 = new HashMap();
        }

        public List<MethodNode> j6(Object obj) {
            return (List) this.j6.get(obj);
        }

        public List<MethodNode> DW(Object obj) {
            List<MethodNode> j6 = j6(obj);
            if (j6 == null) {
                return Collections.emptyList();
            }
            return j6;
        }

        public void j6(Object obj, MethodNode methodNode) {
            if (this.j6.containsKey(obj)) {
                j6(obj).add(methodNode);
                return;
            }
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(methodNode);
            this.j6.put(obj, arrayList);
        }
    }

    static {
        DW = new ClassNode[0];
        FH = new ClassNode(Object.class);
        Hw = new ClassNode(Object.class);
    }

    public ClassNode Zo() {
        return this.rN == null ? this : this.rN.Zo();
    }

    public void DW(ClassNode classNode) {
        if (this.v5) {
            throw new GroovyBugError("tried to set a redirect for a primary ClassNode (" + tp() + "->" + classNode.tp() + ").");
        }
        if (classNode != null) {
            classNode = classNode.Zo();
        }
        if (classNode != this) {
            this.rN = classNode;
        }
    }

    public ClassNode VH() {
        if (this.rN != null) {
            ClassNode VH = Zo().VH();
            VH.lg = this;
            return VH;
        } else if (this.VH != null) {
            return new ClassNode(Array.newInstance(this.VH, 0).getClass(), this);
        } else {
            return new ClassNode(this);
        }
    }

    private ClassNode(ClassNode classNode) {
        this(classNode.tp() + "[]", 1, ClassHelper.DW);
        this.lg = classNode.Zo();
        this.v5 = false;
    }

    private ClassNode(Class cls, ClassNode classNode) {
        this(cls);
        this.lg = classNode;
        this.v5 = false;
    }

    public ClassNode(Class cls) {
        this(cls.getName(), cls.getModifiers(), null, null, MixinNode.gn);
        this.VH = cls;
        this.a8 = false;
        CompileUnit QX = QX();
        if (QX != null) {
            QX.j6(this);
        }
        this.v5 = false;
    }

    private void gW() {
        synchronized (this.Zo) {
            if (this.rN != null) {
                throw new GroovyBugError("lazyClassInit called on a proxy ClassNode, that must not happen.A redirect() call is missing somewhere!");
            } else if (this.a8) {
            } else {
                VMPluginFactory.j6().j6(this.aM, this);
                this.a8 = true;
            }
        }
    }

    public ClassNode(String str, int i, ClassNode classNode) {
        this(str, i, classNode, DW, MixinNode.gn);
    }

    public ClassNode(String str, int i, ClassNode classNode, ClassNode[] classNodeArr, MixinNode[] mixinNodeArr) {
        this.j3 = false;
        this.Mr = false;
        this.Zo = new Object();
        this.a8 = true;
        this.lg = null;
        this.rN = null;
        this.er = null;
        this.yS = false;
        this.BT = null;
        this.gn = str;
        this.u7 = i;
        this.U2 = classNode;
        this.tp = classNodeArr;
        this.EQ = mixinNodeArr;
        this.v5 = true;
        if (classNode != null) {
            this.yS = classNode.er();
        }
        if (!(this.yS || classNodeArr == null)) {
            for (ClassNode er : classNodeArr) {
                boolean z = this.yS || er.er();
                this.yS = z;
                if (this.yS) {
                    break;
                }
            }
        }
        this.J0 = new MapOfLists();
        this.J8 = new ArrayList();
    }

    public ClassNode[] gn() {
        if (!Zo().a8) {
            Zo().gW();
        }
        if (this.rN != null) {
            return Zo().gn();
        }
        return this.tp;
    }

    public void j6(ClassNode[] classNodeArr) {
        if (this.rN != null) {
            Zo().j6(classNodeArr);
        } else {
            this.tp = classNodeArr;
        }
    }

    public List<MethodNode> u7() {
        if (!Zo().a8) {
            Zo().gW();
        }
        if (this.rN != null) {
            return Zo().u7();
        }
        return this.J8;
    }

    public String tp() {
        return Zo().gn;
    }

    public String EQ() {
        return this.gn;
    }

    public int we() {
        return Zo().u7;
    }

    public ModuleNode J0() {
        return Zo().XL;
    }

    public PackageNode J8() {
        return J0() == null ? null : J0().Zo();
    }

    public void j6(FieldNode fieldNode) {
        ClassNode Zo = Zo();
        fieldNode.j6(Zo);
        fieldNode.FH(Zo);
        if (Zo.Ws == null) {
            Zo.Ws = new LinkedList();
        }
        if (Zo.QX == null) {
            Zo.QX = new HashMap();
        }
        Zo.Ws.add(fieldNode);
        Zo.QX.put(fieldNode.t_(), fieldNode);
    }

    public void j6(ConstructorNode constructorNode) {
        constructorNode.j6(this);
        ClassNode Zo = Zo();
        if (Zo.we == null) {
            Zo.we = new ArrayList();
        }
        Zo.we.add(constructorNode);
    }

    public ConstructorNode j6(int i, Parameter[] parameterArr, ClassNode[] classNodeArr, Statement statement) {
        ConstructorNode constructorNode = new ConstructorNode(i, parameterArr, classNodeArr, statement);
        j6(constructorNode);
        return constructorNode;
    }

    public void j6(MethodNode methodNode) {
        methodNode.j6(this);
        Zo().J8.add(methodNode);
        Zo().J0.j6(methodNode.u7(), methodNode);
    }

    public MethodNode j6(String str, int i, ClassNode classNode, Parameter[] parameterArr, ClassNode[] classNodeArr, Statement statement) {
        MethodNode j6 = j6(str, parameterArr);
        if (j6 != null) {
            return j6;
        }
        j6 = new MethodNode(str, i, classNode, parameterArr, classNodeArr, statement);
        j6(j6);
        return j6;
    }

    public boolean equals(Object obj) {
        if (this.rN != null) {
            return Zo().equals(obj);
        }
        if (obj instanceof ClassNode) {
            return ((ClassNode) obj).j6().equals(j6());
        }
        return false;
    }

    public int hashCode() {
        if (this.rN != null) {
            return Zo().hashCode();
        }
        return tp().hashCode();
    }

    public ClassNode Ws() {
        return null;
    }

    public List<MethodNode> j6(String str) {
        if (!Zo().a8) {
            Zo().gW();
        }
        if (this.rN != null) {
            return Zo().j6(str);
        }
        return this.J0.DW(str);
    }

    public MethodNode j6(String str, Parameter[] parameterArr) {
        for (MethodNode methodNode : j6(str)) {
            if (j6(methodNode.tp(), parameterArr)) {
                return methodNode;
            }
        }
        return null;
    }

    public void FH(ClassNode classNode) {
        this.U2 = classNode;
    }

    public CompileUnit QX() {
        if (this.rN != null) {
            return Zo().QX();
        }
        if (this.aM == null && this.XL != null) {
            this.aM = this.XL.gn();
        }
        return this.aM;
    }

    protected boolean j6(Parameter[] parameterArr, Parameter[] parameterArr2) {
        if (parameterArr.length != parameterArr2.length) {
            return false;
        }
        for (int i = 0; i < parameterArr.length; i++) {
            if (!parameterArr[i].s_().equals(parameterArr2[i].s_())) {
                return false;
            }
        }
        return true;
    }

    public boolean XL() {
        return Zo().Mr;
    }

    public String toString() {
        return DW(true);
    }

    public String DW(boolean z) {
        if (Mr()) {
            return this.lg.DW(z) + "[]";
        }
        String tp = tp();
        if (this.gW) {
            tp = EQ();
        }
        if (!(this.gW || this.er == null)) {
            String str = tp + " <";
            for (int i = 0; i < this.er.length; i++) {
                if (i != 0) {
                    str = str + ", ";
                }
                str = str + j6(this.er[i], z);
            }
            tp = str + ">";
        }
        if (this.rN == null || !z) {
            return tp;
        }
        return tp + " -> " + Zo().toString();
    }

    private String j6(GenericsType genericsType, boolean z) {
        String VH = genericsType.VH();
        if (genericsType.Zo() != null) {
            VH = VH + " extends ";
            for (int i = 0; i < genericsType.Zo().length; i++) {
                ClassNode classNode = genericsType.Zo()[i];
                if (classNode.equals(this)) {
                    VH = VH + classNode.tp();
                } else {
                    VH = VH + classNode.DW(z);
                }
                if (i + 1 < genericsType.Zo().length) {
                    VH = VH + " & ";
                }
            }
            return VH;
        } else if (genericsType.u7() == null) {
            return VH;
        } else {
            ClassNode u7 = genericsType.u7();
            if (u7.equals(this)) {
                return VH + " super " + u7.tp();
            }
            return VH + " super " + u7;
        }
    }

    public boolean aM() {
        return (we() & 512) > 0;
    }

    public boolean j3() {
        return Zo().VH != null || (this.lg != null && this.lg.j3());
    }

    public boolean Mr() {
        return this.lg != null;
    }

    public ClassNode U2() {
        return this.lg;
    }

    public Class a8() {
        Class cls = Zo().VH;
        if (cls != null) {
            return cls;
        }
        ClassNode classNode = Zo().lg;
        if (classNode == null || !classNode.j3()) {
            throw new GroovyBugError("ClassNode#getTypeClass for " + tp() + " is called before the type class is set ");
        }
        DW(classNode.VH());
        return Zo().VH;
    }

    public GenericsType[] lg() {
        return this.er;
    }

    public void j6(GenericsType[] genericsTypeArr) {
        boolean z = this.yS || genericsTypeArr != null;
        this.yS = z;
        this.er = genericsTypeArr;
    }

    public void FH(boolean z) {
        boolean z2 = this.yS || z;
        this.yS = z2;
        this.gW = z;
    }

    public boolean rN() {
        return this.gW;
    }

    public boolean er() {
        return this.yS;
    }

    public void Hw(boolean z) {
        this.yS = z;
    }

    public ClassNode yS() {
        if (ClassHelper.DW(this)) {
            return this;
        }
        ClassNode classNode = new ClassNode(this.gn, this.u7, this.U2, null, null);
        classNode.v5 = false;
        classNode.DW(Zo());
        if (Mr()) {
            classNode.lg = Zo().U2();
        }
        return classNode;
    }

    public String j6() {
        return tp();
    }
}
