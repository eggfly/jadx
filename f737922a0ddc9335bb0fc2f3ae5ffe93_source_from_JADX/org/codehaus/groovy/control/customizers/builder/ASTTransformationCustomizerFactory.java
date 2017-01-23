package org.codehaus.groovy.control.customizers.builder;

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import groovy.util.AbstractFactory;
import java.lang.ref.SoftReference;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter;
import org.codehaus.groovy.runtime.callsite.CallSiteArray;

public class ASTTransformationCustomizerFactory extends AbstractFactory implements GroovyObject {
    public static /* synthetic */ long DW;
    private static /* synthetic */ ClassInfo FH;
    public static /* synthetic */ long j6;
    private static /* synthetic */ SoftReference v5;
    private transient /* synthetic */ MetaClass Hw;

    static {
        DW();
        DW = Long.valueOf(0).longValue();
        j6 = Long.valueOf(1402495627795L).longValue();
    }

    public ASTTransformationCustomizerFactory() {
        Hw();
        this.Hw = j6();
    }

    public static /* synthetic */ void DW() {
        Hw();
        v5 = null;
    }

    private static /* synthetic */ CallSiteArray FH() {
        String[] strArr = new String[2];
        j6(strArr);
        return new CallSiteArray(ASTTransformationCustomizerFactory.class, strArr);
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
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.control.customizers.builder.ASTTransformationCustomizerFactory.Hw():org.codehaus.groovy.runtime.callsite.CallSite[]");
    }

    private static /* synthetic */ void j6(String[] strArr) {
        strArr[0] = "<$constructor$>";
        strArr[1] = "<$constructor$>";
    }

    protected /* synthetic */ MetaClass j6() {
        if (getClass() != ASTTransformationCustomizerFactory.class) {
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
