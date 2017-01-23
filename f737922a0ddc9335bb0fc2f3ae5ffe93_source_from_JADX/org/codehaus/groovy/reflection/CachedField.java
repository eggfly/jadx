package org.codehaus.groovy.reflection;

import groovy.lang.MetaProperty;
import java.lang.reflect.Field;

public class CachedField extends MetaProperty {
    public final Field j6;

    public CachedField(Field field) {
        super(field.getName(), field.getType());
        this.j6 = field;
    }
}
