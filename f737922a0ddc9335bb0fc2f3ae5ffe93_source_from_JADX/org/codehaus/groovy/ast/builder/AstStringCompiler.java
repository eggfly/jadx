package org.codehaus.groovy.ast.builder;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

class AstStringCompiler implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ ClassInfo FH;
    public static /* synthetic */ long j6;
    private static /* synthetic */ SoftReference v5;
    private transient /* synthetic */ MetaClass Hw;

    class _compile_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[6];
            j6(strArr);
            return new CallSiteArray(_compile_closure1.class, strArr);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static /* synthetic */ org.codehaus.groovy.runtime.callsite.CallSite[] FH() {
            /*
            r0 = j6;
            if (r0 == 0) goto L_0x000e;
        L_0x0004:
            r0 = j6;
            r0 = r0.get();
            r0 = (org.codehaus.groovy.runtime.callsite.CallSiteArray) r0;
            if (r0 != 0) goto L_0x0019;
        L_0x000e:
            r0 = DW();
            r1 = new java.lang.ref.SoftReference;
            r1.<init>(r0);
            j6 = r1;
        L_0x0019:
            r0 = r0.array;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.ast.builder.AstStringCompiler._compile_closure1.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "statementBlock";
            strArr[1] = "add";
            strArr[2] = "statementBlock";
            strArr[3] = "each";
            strArr[4] = "classes";
            strArr[5] = "doCall";
        }
    }

    class _compile_closure1_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[4];
            j6(strArr);
            return new CallSiteArray(_compile_closure1_closure2.class, strArr);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static /* synthetic */ org.codehaus.groovy.runtime.callsite.CallSite[] FH() {
            /*
            r0 = j6;
            if (r0 == 0) goto L_0x000e;
        L_0x0004:
            r0 = j6;
            r0 = r0.get();
            r0 = (org.codehaus.groovy.runtime.callsite.CallSiteArray) r0;
            if (r0 != 0) goto L_0x0019;
        L_0x000e:
            r0 = DW();
            r1 = new java.lang.ref.SoftReference;
            r1.<init>(r0);
            j6 = r1;
        L_0x0019:
            r0 = r0.array;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.ast.builder.AstStringCompiler._compile_closure1_closure2.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "name";
            strArr[1] = "leftShift";
            strArr[2] = "name";
            strArr[3] = "leftShift";
        }
    }

    static {
        DW();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627465L).longValue();
    }

    public AstStringCompiler() {
        Hw();
        this.Hw = j6();
    }

    public static /* synthetic */ void DW() {
        Hw();
        v5 = null;
    }

    private static /* synthetic */ CallSiteArray FH() {
        String[] strArr = new String[15];
        j6(strArr);
        return new CallSiteArray(AstStringCompiler.class, strArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ org.codehaus.groovy.runtime.callsite.CallSite[] Hw() {
        /*
        r0 = v5;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = v5;
        r0 = r0.get();
        r0 = (org.codehaus.groovy.runtime.callsite.CallSiteArray) r0;
        if (r0 != 0) goto L_0x0019;
    L_0x000e:
        r0 = FH();
        r1 = new java.lang.ref.SoftReference;
        r1.<init>(r0);
        v5 = r1;
    L_0x0019:
        r0 = r0.array;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.ast.builder.AstStringCompiler.Hw():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "plus";
        strArr[1] = "currentTimeMillis";
        strArr[2] = "<$constructor$>";
        strArr[3] = "<$constructor$>";
        strArr[4] = "plus";
        strArr[5] = "<$constructor$>";
        strArr[6] = "DEFAULT";
        strArr[7] = "codeSource";
        strArr[8] = "addSource";
        strArr[9] = "getName";
        strArr[10] = "compile";
        strArr[11] = "getPhaseNumber";
        strArr[12] = "inject";
        strArr[13] = "modules";
        strArr[14] = "ast";
    }

    protected /* synthetic */ MetaClass j6() {
        if (getClass() != AstStringCompiler.class) {
            return ScriptBytecodeAdapter.initMetaClass(this);
        }
        ClassInfo classInfo = FH;
        if (classInfo == null) {
            classInfo = ClassInfo.j6(getClass());
            FH = classInfo;
        }
        return classInfo.v5();
    }
}
