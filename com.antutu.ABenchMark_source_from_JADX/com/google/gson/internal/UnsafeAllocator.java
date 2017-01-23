package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {

    /* renamed from: com.google.gson.internal.UnsafeAllocator.1 */
    static class C35871 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        C35871(Method method, Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$allocateInstance.invoke(this.val$unsafe, new Object[]{cls});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.2 */
    static class C35882 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        C35882(Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$newInstance.invoke(null, new Object[]{cls, Integer.valueOf(this.val$constructorId)});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.3 */
    static class C35893 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        C35893(Method method) {
            this.val$newInstance = method;
        }

        public <T> T newInstance(Class<T> cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.val$newInstance.invoke(null, new Object[]{cls, Object.class});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.4 */
    static class C35904 extends UnsafeAllocator {
        C35904() {
        }

        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    private static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static UnsafeAllocator create() {
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C35871(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new C35882(declaredMethod2, intValue);
            } catch (Exception e2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new C35893(declaredMethod3);
                } catch (Exception e3) {
                    return new C35904();
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls);
}
