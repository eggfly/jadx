package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.ClassInfo;

public class CharacterCachedClass extends CachedClass {
    private boolean we;

    public CharacterCachedClass(Class cls, ClassInfo classInfo, boolean z) {
        super(cls, classInfo);
        this.we = z;
    }
}
