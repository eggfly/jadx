package org.codehaus.groovy.tools;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

public class RootLoader extends URLClassLoader {
    private Map<String, Class> j6;

    protected synchronized Class loadClass(String str, boolean z) {
        Class findLoadedClass;
        findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            findLoadedClass = (Class) this.j6.get(str);
            if (findLoadedClass == null) {
                try {
                    findLoadedClass = j6(str);
                } catch (ClassNotFoundException e) {
                }
                if (findLoadedClass == null) {
                    findLoadedClass = super.loadClass(str, z);
                }
                if (z) {
                    resolveClass(findLoadedClass);
                }
            }
        }
        return findLoadedClass;
    }

    public URL getResource(String str) {
        URL findResource = findResource(str);
        if (findResource == null) {
            return super.getResource(str);
        }
        return findResource;
    }

    public void addURL(URL url) {
        super.addURL(url);
    }

    private Class j6(String str) {
        return super.findClass(str);
    }

    protected Class findClass(String str) {
        throw new ClassNotFoundException(str);
    }
}
