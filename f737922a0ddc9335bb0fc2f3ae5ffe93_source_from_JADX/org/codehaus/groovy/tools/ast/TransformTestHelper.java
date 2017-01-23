package org.codehaus.groovy.tools.ast;

import groovy.lang.GroovyObject;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

public class TransformTestHelper implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ SoftReference FH;
    public static /* synthetic */ long j6;

    static {
        j6();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627510L).longValue();
    }

    private static /* synthetic */ CallSiteArray DW() {
        String[] strArr = new String[4];
        j6(strArr);
        return new CallSiteArray(TransformTestHelper.class, strArr);
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
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.tools.ast.TransformTestHelper.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    public static /* synthetic */ void j6() {
        FH();
        FH = null;
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "<$constructor$>";
        strArr[1] = "parseClass";
        strArr[2] = "<$constructor$>";
        strArr[3] = "parseClass";
    }
}
