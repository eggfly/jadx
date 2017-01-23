package org.codehaus.groovy.reflection;

import groovy.lang.MetaMethod;
import java.io.Serializable;

public abstract class GeneratedMetaMethod extends MetaMethod {

    public static class DgmMethodRecord implements Serializable {
        private static final Class[] j6;

        static {
            j6 = new Class[]{Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Double.TYPE, Float.TYPE, Void.TYPE, boolean[].class, char[].class, byte[].class, short[].class, int[].class, long[].class, double[].class, float[].class, Object[].class, String[].class, Class[].class, Byte[].class, CharSequence[].class};
        }
    }

    public static class Proxy extends GeneratedMetaMethod {
    }
}
