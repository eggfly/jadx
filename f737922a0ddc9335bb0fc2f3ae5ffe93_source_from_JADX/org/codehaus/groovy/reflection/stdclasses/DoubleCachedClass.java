package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.ClassInfo;

public class DoubleCachedClass extends NumberCachedClass {
    private boolean we;

    public DoubleCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
