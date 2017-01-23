package org.codehaus.groovy.util;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.GeneratedClosure;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

public class StringUtil implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ ClassInfo FH;
    public static /* synthetic */ long j6;
    private static /* synthetic */ SoftReference v5;
    private transient /* synthetic */ MetaClass Hw;

    class _expandHyphen_closure2 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[2];
            j6(strArr);
            return new CallSiteArray(_expandHyphen_closure2.class, strArr);
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
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.util.StringUtil._expandHyphen_closure2.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "join";
            strArr[1] = "doCall";
        }
    }

    class _tr_closure1 extends Closure implements GeneratedClosure {
        private static /* synthetic */ SoftReference j6;

        static {
            j6();
        }

        private static /* synthetic */ CallSiteArray DW() {
            String[] strArr = new String[3];
            j6(strArr);
            return new CallSiteArray(_tr_closure1.class, strArr);
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
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.util.StringUtil._tr_closure1.FH():org.codehaus.groovy.runtime.callsite.CallSite[]");
        }

        public static /* synthetic */ void j6() {
            FH();
            j6 = null;
        }

        private static /* synthetic */ void j6(String[] strArr) {
            strArr[0] = "contains";
            strArr[1] = "getAt";
            strArr[2] = "lastIndexOf";
        }
    }

    static {
        DW();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627145L).longValue();
    }

    public StringUtil() {
        Hw();
        this.Hw = j6();
    }

    public static /* synthetic */ void DW() {
        Hw();
        v5 = null;
    }

    private static /* synthetic */ CallSiteArray FH() {
        String[] strArr = new String[11];
        j6(strArr);
        return new CallSiteArray(StringUtil.class, strArr);
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
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.util.StringUtil.Hw():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "expandHyphen";
        strArr[1] = "expandHyphen";
        strArr[2] = "padRight";
        strArr[3] = "size";
        strArr[4] = "getAt";
        strArr[5] = "minus";
        strArr[6] = "size";
        strArr[7] = "join";
        strArr[8] = "collect";
        strArr[9] = "contains";
        strArr[10] = "replaceAll";
    }

    protected /* synthetic */ MetaClass j6() {
        if (getClass() != StringUtil.class) {
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
