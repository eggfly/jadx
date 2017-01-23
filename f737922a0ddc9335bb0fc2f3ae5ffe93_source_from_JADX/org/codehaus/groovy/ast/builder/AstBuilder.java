package org.codehaus.groovy.ast.builder;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

public class AstBuilder implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ ClassInfo FH;
    public static /* synthetic */ long j6;
    private static /* synthetic */ SoftReference v5;
    private transient /* synthetic */ MetaClass Hw;

    class _buildFromBlock_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[2];
            j6(strArr);
            return new CallSiteArray(_buildFromBlock_closure1.class, strArr);
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
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.ast.builder.AstBuilder._buildFromBlock_closure1.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "getAt";
            strArr[1] = "statements";
        }
    }

    static {
        DW();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627495L).longValue();
    }

    public AstBuilder() {
        Hw();
        this.Hw = j6();
    }

    public static /* synthetic */ void DW() {
        Hw();
        v5 = null;
    }

    private static /* synthetic */ CallSiteArray FH() {
        String[] strArr = new String[25];
        j6(strArr);
        return new CallSiteArray(AstBuilder.class, strArr);
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
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.ast.builder.AstBuilder.Hw():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "<$constructor$>";
        strArr[1] = "trim";
        strArr[2] = "<$constructor$>";
        strArr[3] = "trim";
        strArr[4] = "<$constructor$>";
        strArr[5] = "compile";
        strArr[6] = "<$constructor$>";
        strArr[7] = "trim";
        strArr[8] = "<$constructor$>";
        strArr[9] = "trim";
        strArr[10] = "<$constructor$>";
        strArr[11] = "plus";
        strArr[12] = "currentTimeMillis";
        strArr[13] = "compile";
        strArr[14] = "<$constructor$>";
        strArr[15] = "collect";
        strArr[16] = "<$constructor$>";
        strArr[17] = "<$constructor$>";
        strArr[18] = "<$constructor$>";
        strArr[19] = "expression";
        strArr[20] = "CLASS_GENERATION";
        strArr[21] = "CLASS_GENERATION";
        strArr[22] = "CLASS_GENERATION";
        strArr[23] = "CLASS_GENERATION";
        strArr[24] = "CLASS_GENERATION";
    }

    protected /* synthetic */ MetaClass j6() {
        if (getClass() != AstBuilder.class) {
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
