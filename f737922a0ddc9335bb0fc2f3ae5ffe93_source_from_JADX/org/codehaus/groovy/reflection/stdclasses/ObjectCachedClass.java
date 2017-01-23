package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.ClassInfo;

public class ObjectCachedClass extends CachedClass {
    public ObjectCachedClass(ClassInfo classInfo) {
        super(Object.class, classInfo);
    }

    public synchronized CachedClass j6() {
        return null;
    }
}
