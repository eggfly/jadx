package org.codehaus.groovy.reflection;

import com.aide.uidesigner.ProxyTextView;
import groovyjarjarasm.asm.ClassWriter;
import groovyjarjarasm.asm.MethodVisitor;
import groovyjarjarasm.asm.Opcodes;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public class SunClassLoader extends ClassLoader implements Opcodes {
    protected static final SunClassLoader DW;
    protected final Map<String, Class> j6;

    static class 1 implements PrivilegedAction<SunClassLoader> {
        1() {
        }

        public /* synthetic */ Object run() {
            return j6();
        }

        public SunClassLoader j6() {
            try {
                return new SunClassLoader();
            } catch (Throwable th) {
                return null;
            }
        }
    }

    static {
        SunClassLoader sunClassLoader;
        try {
            sunClassLoader = (SunClassLoader) AccessController.doPrivileged(new 1());
        } catch (Throwable th) {
            sunClassLoader = null;
        }
        DW = sunClassLoader;
    }

    protected SunClassLoader() {
        super(SunClassLoader.class.getClassLoader());
        this.j6 = new HashMap();
        this.j6.put("sun.reflect.MagicAccessorImpl", ClassLoader.getSystemClassLoader().loadClass("sun.reflect.MagicAccessorImpl"));
        j6();
    }

    private void j6() {
        ClassWriter classWriter = new ClassWriter(1);
        classWriter.visit(48, 1, "sun/reflect/GroovyMagic", null, "sun/reflect/MagicAccessorImpl", null);
        MethodVisitor visitMethod = classWriter.visitMethod(1, "<init>", "()V", null, null);
        visitMethod.visitCode();
        visitMethod.visitVarInsn(25, 0);
        visitMethod.visitMethodInsn(183, "sun/reflect/MagicAccessorImpl", "<init>", "()V", false);
        visitMethod.visitInsn(ProxyTextView.INPUTTYPE_textFilter);
        visitMethod.visitMaxs(0, 0);
        visitMethod.visitEnd();
        classWriter.visitEnd();
        j6(classWriter.toByteArray(), "sun.reflect.GroovyMagic");
    }

    protected void j6(byte[] bArr, String str) {
        this.j6.put(str, defineClass(str, bArr, 0, bArr.length));
    }

    protected synchronized Class loadClass(String str, boolean z) {
        Class cls;
        cls = (Class) this.j6.get(str);
        if (cls == null) {
            try {
                cls = super.loadClass(str, z);
            } catch (ClassNotFoundException e) {
                cls = getClass().getClassLoader().loadClass(str);
            }
        }
        return cls;
    }

    public Class j6(String str) {
        return (Class) this.j6.get(str);
    }
}
