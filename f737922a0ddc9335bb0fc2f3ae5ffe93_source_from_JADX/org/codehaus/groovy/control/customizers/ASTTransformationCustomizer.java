package org.codehaus.groovy.control.customizers;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.transform.CompilationUnitAware;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

public class ASTTransformationCustomizer extends CompilationCustomizer implements GroovyObject, CompilationUnitAware {
    public static /* synthetic */ long DW;
    private static /* synthetic */ SoftReference FH;
    public static /* synthetic */ long j6;

    class _setAnnotationParameters_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[25];
            j6(strArr);
            return new CallSiteArray(_setAnnotationParameters_closure1.class, strArr);
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
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.control.customizers.ASTTransformationCustomizer._setAnnotationParameters_closure1.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "getMethod";
            strArr[1] = "classNode";
            strArr[2] = "annotationNode";
            strArr[3] = "<$constructor$>";
            strArr[4] = "name";
            strArr[5] = "classNode";
            strArr[6] = "annotationNode";
            strArr[7] = "<$constructor$>";
            strArr[8] = "plus";
            strArr[9] = "setLineNumber";
            strArr[10] = "setLastLineNumber";
            strArr[11] = "addMember";
            strArr[12] = "annotationNode";
            strArr[13] = "addMember";
            strArr[14] = "annotationNode";
            strArr[15] = "<$constructor$>";
            strArr[16] = "make";
            strArr[17] = "addMember";
            strArr[18] = "annotationNode";
            strArr[19] = "<$constructor$>";
            strArr[20] = "collect";
            strArr[21] = "addMember";
            strArr[22] = "annotationNode";
            strArr[23] = "<$constructor$>";
            strArr[24] = "doCall";
        }
    }

    class _setAnnotationParameters_closure1_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[3];
            j6(strArr);
            return new CallSiteArray(_setAnnotationParameters_closure1_closure2.class, strArr);
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
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.control.customizers.ASTTransformationCustomizer._setAnnotationParameters_closure1_closure2.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "<$constructor$>";
            strArr[1] = "make";
            strArr[2] = "<$constructor$>";
        }
    }

    static {
        j6();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627913L).longValue();
    }

    private static /* synthetic */ CallSiteArray FH() {
        String[] strArr = new String[71];
        j6(strArr);
        return new CallSiteArray(ASTTransformationCustomizer.class, strArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ org.codehaus.groovy.runtime.callsite.CallSite[] Hw() {
        /*
        r0 = FH;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = FH;
        r0 = r0.get();
        r0 = (org.codehaus.groovy.runtime.callsite.CallSiteArray) r0;
        if (r0 != 0) goto L_0x0019;
    L_0x000e:
        r0 = FH();
        r1 = new java.lang.ref.SoftReference;
        r1.<init>(r0);
        FH = r1;
    L_0x0019:
        r0 = r0.array;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.control.customizers.ASTTransformationCustomizer.Hw():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    public static /* synthetic */ void j6() {
        Hw();
        FH = null;
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "findPhase";
        strArr[1] = "findASTTranformationClass";
        strArr[2] = "newInstance";
        strArr[3] = "<$constructor$>";
        strArr[4] = "make";
        strArr[5] = "classLoader";
        strArr[6] = "findPhase";
        strArr[7] = "findASTTranformationClass";
        strArr[8] = "newInstance";
        strArr[9] = "<$constructor$>";
        strArr[10] = "make";
        strArr[11] = "setAnnotationParameters";
        strArr[12] = "classLoader";
        strArr[13] = "findPhase";
        strArr[14] = "findASTTranformationClass";
        strArr[15] = "newInstance";
        strArr[16] = "<$constructor$>";
        strArr[17] = "make";
        strArr[18] = "classLoader";
        strArr[19] = "findPhase";
        strArr[20] = "findPhase";
        strArr[21] = "findASTTranformationClass";
        strArr[22] = "newInstance";
        strArr[23] = "<$constructor$>";
        strArr[24] = "make";
        strArr[25] = "setAnnotationParameters";
        strArr[26] = "classLoader";
        strArr[27] = "setAnnotationParameters";
        strArr[28] = "getAnnotation";
        strArr[29] = "<$constructor$>";
        strArr[30] = "<$constructor$>";
        strArr[31] = "classes";
        strArr[32] = "value";
        strArr[33] = "plus";
        strArr[34] = "length";
        strArr[35] = "length";
        strArr[36] = "<$constructor$>";
        strArr[37] = "plus";
        strArr[38] = "length";
        strArr[39] = "length";
        strArr[40] = "<$constructor$>";
        strArr[41] = "getAt";
        strArr[42] = "forName";
        strArr[43] = "getAt";
        strArr[44] = "classLoader";
        strArr[45] = "forName";
        strArr[46] = "classLoader";
        strArr[47] = "forName";
        strArr[48] = "classLoader";
        strArr[49] = "<$constructor$>";
        strArr[50] = "<$constructor$>";
        strArr[51] = "class";
        strArr[52] = "getAnnotation";
        strArr[53] = "<$constructor$>";
        strArr[54] = "plus";
        strArr[55] = "name";
        strArr[56] = "<$constructor$>";
        strArr[57] = "plus";
        strArr[58] = "name";
        strArr[59] = "phase";
        strArr[60] = "findASTTranformationClass";
        strArr[61] = "findPhase";
        strArr[62] = "newInstance";
        strArr[63] = "findASTTranformationClass";
        strArr[64] = "findPhase";
        strArr[65] = "newInstance";
        strArr[66] = "each";
        strArr[67] = "visit";
        strArr[68] = "visit";
        strArr[69] = "visit";
        strArr[70] = "visit";
    }
}
