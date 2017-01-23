package org.codehaus.groovy.reflection.stdclasses;

import org.codehaus.groovy.reflection.ClassInfo;

public class BigDecimalCachedClass extends DoubleCachedClass {
    public BigDecimalCachedClass(Class cls, ClassInfo classInfo) {
        super(cls, classInfo, true);
    }
}
