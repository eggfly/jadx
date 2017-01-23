package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.CachedMethod;
import org.codehaus.groovy.reflection.ClassInfo;

public class CachedClosureClass extends CachedClass {
    private final int J0;
    private final Class[] we;

    public CachedClosureClass(Class cls, ClassInfo classInfo) {
        super(cls, classInfo);
        CachedMethod[] Hw = Hw();
        int i = -1;
        Class[] clsArr = null;
        int length = Hw.length;
        int i2 = 0;
        while (i2 < length) {
            Class[] nativeParameterTypes;
            int length2;
            CachedMethod cachedMethod = Hw[i2];
            if ("doCall".equals(cachedMethod.j6())) {
                nativeParameterTypes = cachedMethod.getNativeParameterTypes();
                if (nativeParameterTypes.length > i) {
                    length2 = nativeParameterTypes.length;
                    i2++;
                    i = length2;
                    clsArr = nativeParameterTypes;
                }
            }
            nativeParameterTypes = clsArr;
            length2 = i;
            i2++;
            i = length2;
            clsArr = nativeParameterTypes;
        }
        this.J0 = Math.max(i, 0);
        this.we = clsArr;
    }
}
