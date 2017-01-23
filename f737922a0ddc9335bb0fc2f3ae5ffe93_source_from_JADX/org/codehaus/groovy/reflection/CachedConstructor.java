package org.codehaus.groovy.reflection;

import java.lang.reflect.Constructor;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class CachedConstructor extends ParameterTypes {
    public final Constructor DW;
    CachedClass j6;

    class 1 implements PrivilegedAction {
        final /* synthetic */ CachedConstructor DW;
        final /* synthetic */ Constructor j6;

        1(CachedConstructor cachedConstructor, Constructor constructor) {
            this.DW = cachedConstructor;
            this.j6 = constructor;
        }

        public Object run() {
            this.j6.setAccessible(true);
            return null;
        }
    }

    public CachedConstructor(CachedClass cachedClass, Constructor constructor) {
        this.DW = constructor;
        this.j6 = cachedClass;
        try {
            AccessController.doPrivileged(new 1(this, constructor));
        } catch (SecurityException e) {
        }
    }
}
