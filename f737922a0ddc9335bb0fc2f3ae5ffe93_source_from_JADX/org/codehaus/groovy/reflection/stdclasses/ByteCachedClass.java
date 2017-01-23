package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.ClassInfo;

public class ByteCachedClass extends NumberCachedClass {
    private boolean we;

    public ByteCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
