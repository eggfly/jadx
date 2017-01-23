package org.codehaus.groovy.tools.ast;

import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.control.CompilationUnit.PrimaryClassNodeOperation;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

class TestHarnessOperation extends PrimaryClassNodeOperation implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ SoftReference FH;
    public static /* synthetic */ long j6;

    static {
        j6();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627803L).longValue();
    }

    private static /* synthetic */ CallSiteArray DW() {
        String[] strArr = new String[1];
        strArr[0] = "visit";
        return new CallSiteArray(TestHarnessOperation.class, strArr);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static /* synthetic */ org.codehaus.groovy.runtime.callsite.CallSite[] FH() {
        /*
        r0 = FH;
        if (r0 == 0) goto L_0x000e;
    L_0x0004:
        r0 = FH;
        r0 = r0.get();
        r0 = (org.codehaus.groovy.runtime.callsite.CallSiteArray) r0;
        if (r0 != 0) goto L_0x0019;
    L_0x000e:
        r0 = DW();
        r1 = new java.lang.ref.SoftReference;
        r1.<init>(r0);
        FH = r1;
    L_0x0019:
        r0 = r0.array;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.tools.ast.TestHarnessOperation.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    public static /* synthetic */ void j6() {
        FH();
        FH = null;
    }
}
