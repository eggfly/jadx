package org.codehaus.groovy.reflection;

import java.util.HashSet;
import java.util.Set;

public class ReflectionUtils {
    private static final ClassContextHelper DW;
    private static final Set<String> j6;

    private static class ClassContextHelper extends SecurityManager {
        private ClassContextHelper() {
        }

        public Class[] getClassContext() {
            return super.getClassContext();
        }
    }

    static {
        j6 = new HashSet();
        j6.add("groovy.lang");
        j6.add("org.codehaus.groovy.reflection");
        j6.add("org.codehaus.groovy.runtime.callsite");
        j6.add("org.codehaus.groovy.runtime.metaclass");
        j6.add("org.codehaus.groovy.runtime");
        j6.add("sun.reflect");
        j6.add("java.lang.invoke");
        j6.add("org.codehaus.groovy.vmplugin.v7");
        DW = new ClassContextHelper();
    }
}
