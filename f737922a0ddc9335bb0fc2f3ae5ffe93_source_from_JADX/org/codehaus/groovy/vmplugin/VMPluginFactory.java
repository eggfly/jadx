package org.codehaus.groovy.vmplugin;

public class VMPluginFactory {
    private static VMPlugin j6;

    static {
        j6 = j6("java.util.Objects", "org.codehaus.groovy.vmplugin.v7.Java7");
        if (j6 == null) {
            j6 = j6("javax.script.ScriptEngine", "org.codehaus.groovy.vmplugin.v6.Java6");
        }
        if (j6 == null) {
            j6 = j6("java.lang.annotation.Annotation", "org.codehaus.groovy.vmplugin.v5.Java5");
        }
    }

    public static VMPlugin j6() {
        return j6;
    }

    private static VMPlugin j6(String str, String str2) {
        try {
            ClassLoader classLoader = VMPluginFactory.class.getClassLoader();
            classLoader.loadClass(str);
            return (VMPlugin) classLoader.loadClass(str2).newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}
