package org.codehaus.groovy.reflection.stdclasses;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.reflection.CachedClass;
import org.codehaus.groovy.reflection.ClassInfo;
import org.codehaus.groovy.transform.trait.Traits.Implemented;

public class CachedSAMClass extends CachedClass {
    private final Method we;

    static class 1 implements PrivilegedAction<Method[]> {
        final /* synthetic */ Class j6;

        1(Class cls) {
            this.j6 = cls;
        }

        public /* synthetic */ Object run() {
            return j6();
        }

        public Method[] j6() {
            return this.j6.getDeclaredMethods();
        }
    }

    public CachedSAMClass(Class cls, ClassInfo classInfo) {
        super(cls, classInfo);
        this.we = j6(cls);
        if (this.we == null) {
            throw new GroovyBugError("assigned method should not have been null!");
        }
    }

    private static Method[] DW(Class cls) {
        try {
            Method[] methodArr = (Method[]) AccessController.doPrivileged(new 1(cls));
            if (methodArr != null) {
                return methodArr;
            }
        } catch (AccessControlException e) {
        }
        return new Method[0];
    }

    private static void j6(Class cls, List<Method> list) {
        int i = 0;
        if (cls != null && Modifier.isAbstract(cls.getModifiers())) {
            j6(cls.getSuperclass(), (List) list);
            for (Class j6 : cls.getInterfaces()) {
                j6(j6, (List) list);
            }
            Method[] DW = DW(cls);
            int length = DW.length;
            while (i < length) {
                Method method = DW[i];
                if (!Modifier.isPrivate(method.getModifiers()) && Modifier.isAbstract(method.getModifiers())) {
                    list.add(method);
                }
                i++;
            }
        }
    }

    private static boolean j6(Class cls, Method method) {
        if (cls == method.getDeclaringClass()) {
            return false;
        }
        try {
            Method method2 = cls.getMethod(method.getName(), method.getParameterTypes());
            int modifiers = method2.getModifiers() & 1034;
            if ((method2.getModifiers() & 5) != 0 && modifiers == 0) {
                return true;
            }
        } catch (NoSuchMethodException e) {
        }
        if (cls != Object.class) {
            return j6(cls.getSuperclass(), method);
        }
        return false;
    }

    private static Method j6(List<Method> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (Method) list.get(0);
        }
        Method method = (Method) list.remove(0);
        for (Method method2 : list) {
            if (method.getName().equals(method2.getName())) {
                if (!Arrays.equals(method.getParameterTypes(), method2.getParameterTypes())) {
                }
            }
            return null;
        }
        return method;
    }

    public static Method j6(Class<?> cls) {
        if (!Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        if (cls.isInterface()) {
            Method method = null;
            for (Method method2 : cls.getMethods()) {
                if (Modifier.isAbstract(method2.getModifiers()) && method2.getAnnotation(Implemented.class) == null) {
                    try {
                        Object.class.getMethod(method2.getName(), method2.getParameterTypes());
                    } catch (NoSuchMethodException e) {
                        if (method != null) {
                            return null;
                        }
                        method = method2;
                    }
                }
            }
            return method;
        }
        List linkedList = new LinkedList();
        j6((Class) cls, linkedList);
        if (linkedList.isEmpty()) {
            return null;
        }
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            if (j6((Class) cls, (Method) listIterator.next())) {
                listIterator.remove();
            }
        }
        return j6(linkedList);
    }
}
