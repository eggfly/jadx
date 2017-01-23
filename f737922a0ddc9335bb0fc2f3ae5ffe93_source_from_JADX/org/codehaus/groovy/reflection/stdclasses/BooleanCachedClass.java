package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.ClassInfo;

public class BooleanCachedClass extends CachedClass {
    private boolean we;

    public BooleanCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
