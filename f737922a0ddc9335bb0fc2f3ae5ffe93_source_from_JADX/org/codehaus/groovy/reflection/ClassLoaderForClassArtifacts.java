package org.codehaus.groovy.reflection;

import java.lang.ref.SoftReference;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicInteger;
import org.codehaus.groovy.runtime.callsite.GroovySunClassLoader;

public class ClassLoaderForClassArtifacts extends ClassLoader {
    private final AtomicInteger DW;
    public final SoftReference<Class> j6;

    class 1 implements PrivilegedAction<Class> {
        final /* synthetic */ byte[] DW;
        final /* synthetic */ ClassLoaderForClassArtifacts FH;
        final /* synthetic */ String j6;

        public /* synthetic */ Object run() {
            return j6();
        }

        public Class j6() {
            return this.FH.j6(this.j6, this.DW);
        }
    }

    public ClassLoaderForClassArtifacts(Class cls) {
        super(cls.getClassLoader());
        this.DW = new AtomicInteger(-1);
        this.j6 = new SoftReference(cls);
    }

    public Class j6(String str, byte[] bArr) {
        Class defineClass = defineClass(str, bArr, 0, bArr.length, ((Class) this.j6.get()).getProtectionDomain());
        resolveClass(defineClass);
        return defineClass;
    }

    public Class loadClass(String str) {
        Class findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        if (GroovySunClassLoader.sunVM != null) {
            findLoadedClass = GroovySunClassLoader.sunVM.j6(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
        }
        return super.loadClass(str);
    }
}
