package org.codehaus.groovy.reflection;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.groovy.util.TripleKeyHashMap;

public class ReflectionCache {
    static final CachedClass DW;
    public static final CachedClass FH;
    public static final CachedClass Hw;
    static TripleKeyHashMap j6;
    private static Map v5;

    static {
        v5 = new HashMap();
        v5.put(Byte.TYPE, Byte.class);
        v5.put(Boolean.TYPE, Boolean.class);
        v5.put(Character.TYPE, Character.class);
        v5.put(Double.TYPE, Double.class);
        v5.put(Float.TYPE, Float.class);
        v5.put(Integer.TYPE, Integer.class);
        v5.put(Long.TYPE, Long.class);
        v5.put(Short.TYPE, Short.class);
        j6 = new TripleKeyHashMap();
        DW = j6(String.class);
        FH = j6(Object.class);
        Hw = j6(Object[].class);
    }

    static void j6(Class cls, Class cls2) {
    }

    public static boolean DW(Class cls, Class cls2) {
        if (cls == cls2) {
            return true;
        }
        return cls.isAssignableFrom(cls2);
    }

    public static CachedClass j6(Class cls) {
        if (cls == null) {
            return null;
        }
        return ClassInfo.j6(cls).j6();
    }
}
