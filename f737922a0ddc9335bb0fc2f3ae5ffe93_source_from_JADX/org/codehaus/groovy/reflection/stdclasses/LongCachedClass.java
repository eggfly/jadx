package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.ClassInfo;

public class LongCachedClass extends NumberCachedClass {
    private boolean we;

    public LongCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
