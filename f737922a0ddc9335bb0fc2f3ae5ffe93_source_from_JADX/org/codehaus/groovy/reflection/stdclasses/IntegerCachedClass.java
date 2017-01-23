package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.ClassInfo;

public class IntegerCachedClass extends NumberCachedClass {
    private boolean we;

    public IntegerCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
