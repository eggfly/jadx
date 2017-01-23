package org.codehaus.groovy.ast;

import groovy.lang.Closure;
import groovy.lang.GString;
import groovy.lang.GroovyInterceptable;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyObjectSupport;
import groovy.lang.MetaClass;
import groovy.lang.Range;
import groovy.lang.Reference;
import groovy.lang.Script;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.util.ManagedConcurrentMap;
import org.codehaus.groovy.util.ReferenceBundle;
import org.codehaus.groovy.vmplugin.VMPluginFactory;

public class ClassHelper {
    public static final ClassNode BT;
    public static final ClassNode DW;
    public static final ClassNode EQ;
    public static final ClassNode FH;
    public static final ClassNode Hw;
    private static final String[] I;
    public static final ClassNode J0;
    public static final ClassNode J8;
    public static final ClassNode KD;
    public static final ClassNode Mr;
    private static final Class[] Mz;
    public static final ClassNode P8;
    public static final ClassNode QX;
    public static final ClassNode SI;
    public static final ClassNode Sf;
    public static final ClassNode U2;
    public static final ClassNode VH;
    public static final ClassNode Ws;
    public static final ClassNode XL;
    public static final ClassNode Zo;
    public static final ClassNode a8;
    public static final ClassNode aM;
    private static ClassNode[] ca;
    public static final ClassNode cb;
    public static final ClassNode cn;
    public static final ClassNode dx;
    public static final ClassNode ef;
    public static final ClassNode ei;
    public static final ClassNode er;
    protected static final ClassNode[] g3;
    public static final ClassNode gW;
    public static final ClassNode gn;
    public static final ClassNode j3;
    public static final ClassNode j6;
    public static final ClassNode lg;
    public static final ClassNode nw;
    public static final ClassNode rN;
    public static final ClassNode ro;
    public static final ClassNode sG;
    public static final ClassNode sh;
    public static final ClassNode tp;
    public static final ClassNode u7;
    public static final ClassNode v5;
    public static final ClassNode vJ;
    public static final ClassNode vy;
    public static final ClassNode we;
    public static final ClassNode yS;

    static class ClassHelperCache {
        static ManagedConcurrentMap<Class, SoftReference<ClassNode>> j6;

        ClassHelperCache() {
        }

        static {
            j6 = new ManagedConcurrentMap(ReferenceBundle.Hw());
        }
    }

    static {
        Mz = new Class[]{Object.class, Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Double.TYPE, Float.TYPE, Void.TYPE, Closure.class, GString.class, List.class, Map.class, Range.class, Pattern.class, Script.class, String.class, Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Double.class, Float.class, BigDecimal.class, BigInteger.class, Number.class, Void.class, Reference.class, Class.class, MetaClass.class, Iterator.class, GeneratedClosure.class, GroovyObjectSupport.class};
        I = new String[]{"", "boolean", "char", "byte", "short", "int", "long", "double", "float", "void"};
        j6 = j6(Object.class);
        DW = j6;
        FH = j6(Void.TYPE);
        Hw = j6(Closure.class);
        v5 = j6(GString.class);
        Zo = FH(List.class);
        VH = FH(Map.class);
        gn = j6(Range.class);
        u7 = j6(Pattern.class);
        tp = j6(String.class);
        EQ = j6(Script.class);
        we = FH(Reference.class);
        J0 = j6(Boolean.TYPE);
        J8 = j6(Character.TYPE);
        Ws = j6(Byte.TYPE);
        QX = j6(Integer.TYPE);
        XL = j6(Long.TYPE);
        aM = j6(Short.TYPE);
        j3 = j6(Double.TYPE);
        Mr = j6(Float.TYPE);
        U2 = j6(Byte.class);
        a8 = j6(Short.class);
        lg = j6(Integer.class);
        rN = j6(Long.class);
        er = j6(Character.class);
        yS = j6(Float.class);
        gW = j6(Double.class);
        BT = j6(Boolean.class);
        vy = j6(BigInteger.class);
        P8 = j6(BigDecimal.class);
        ei = j6(Number.class);
        nw = j6(Void.class);
        SI = j6(MetaClass.class);
        KD = j6(Iterator.class);
        ro = FH(Class.class);
        cn = FH(Comparable.class);
        sh = FH(GeneratedClosure.class);
        cb = FH(GroovyObjectSupport.class);
        dx = FH(GroovyObject.class);
        sG = FH(GroovyInterceptable.class);
        ef = new ClassNode("java.lang.Enum", 0, DW);
        Sf = new ClassNode("java.lang.annotation.Annotation", 0, DW);
        vJ = new ClassNode("java.lang.annotation.ElementType", 0, ef);
        ef.v5 = false;
        Sf.v5 = false;
        ca = new ClassNode[]{DW, J0, J8, Ws, aM, QX, XL, j3, Mr, FH, Hw, v5, Zo, VH, gn, u7, EQ, tp, BT, er, U2, a8, lg, rN, gW, yS, P8, vy, ei, nw, we, ro, SI, KD, sh, cb, dx, sG, ef, Sf};
        g3 = new ClassNode[0];
    }

    public static ClassNode j6(Class cls) {
        ClassNode classNode;
        SoftReference softReference = (SoftReference) ClassHelperCache.j6.j6((Object) cls);
        if (softReference != null) {
            classNode = (ClassNode) softReference.get();
            if (classNode != null) {
                return classNode;
            }
        }
        classNode = new ClassNode(cls);
        ClassHelperCache.j6.DW(cls, new SoftReference(classNode));
        VMPluginFactory.j6().j6(classNode);
        return classNode;
    }

    public static ClassNode DW(Class cls) {
        return j6(cls, true);
    }

    public static ClassNode j6(Class cls, boolean z) {
        for (int i = 0; i < Mz.length; i++) {
            if (cls == Mz[i]) {
                return ca[i];
            }
        }
        if (cls.isArray()) {
            return j6(cls.getComponentType(), z).VH();
        }
        return DW(cls, z);
    }

    public static ClassNode FH(Class cls) {
        return DW(cls, true);
    }

    public static ClassNode DW(Class cls, boolean z) {
        if (cls.isArray()) {
            return DW(cls.getComponentType(), z).VH();
        }
        ClassNode j6 = j6(cls);
        if (z) {
            return j6;
        }
        ClassNode j62 = j6(cls.getName());
        j62.DW(j6);
        return j62;
    }

    public static ClassNode j6(String str) {
        ClassNode classNode = new ClassNode(str, 1, DW);
        classNode.v5 = false;
        return classNode;
    }

    public static ClassNode j6(ClassNode classNode) {
        ClassNode Zo = classNode.Zo();
        if (!DW(Zo)) {
            return Zo;
        }
        if (Zo == J0) {
            return BT;
        }
        if (Zo == Ws) {
            return U2;
        }
        if (Zo == J8) {
            return er;
        }
        if (Zo == aM) {
            return a8;
        }
        if (Zo == QX) {
            return lg;
        }
        if (Zo == XL) {
            return rN;
        }
        if (Zo == Mr) {
            return yS;
        }
        if (Zo == j3) {
            return gW;
        }
        if (Zo == FH) {
            return nw;
        }
        return Zo;
    }

    public static boolean DW(ClassNode classNode) {
        return classNode == J0 || classNode == J8 || classNode == Ws || classNode == aM || classNode == QX || classNode == XL || classNode == Mr || classNode == j3 || classNode == FH;
    }
}
