package org.codehaus.groovy.reflection.stdclasses;

import groovy.lang.GString;
import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.ClassInfo;

public class StringCachedClass extends CachedClass {
    private static final Class J0;
    private static final Class we;

    static {
        we = String.class;
        J0 = GString.class;
    }

    public StringCachedClass(ClassInfo classInfo) {
        super(we, classInfo);
    }
}
