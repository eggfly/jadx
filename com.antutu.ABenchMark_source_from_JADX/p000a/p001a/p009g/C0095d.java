package p000a.p001a.p009g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.a.g.d */
class C0095d<T> {
    private final Class<?> f354a;
    private final String f355b;
    private final Class[] f356c;

    public C0095d(Class<?> cls, String str, Class... clsArr) {
        this.f354a = cls;
        this.f355b = str;
        this.f356c = clsArr;
    }

    private Method m416a(Class<?> cls) {
        if (this.f355b == null) {
            return null;
        }
        Method a = C0095d.m417a(cls, this.f355b, this.f356c);
        return (a == null || this.f354a == null || this.f354a.isAssignableFrom(a.getReturnType())) ? a : null;
    }

    private static Method m417a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                return (method.getModifiers() & 1) == 0 ? null : method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    public Object m418a(T t, Object... objArr) {
        Object obj = null;
        Method a = m416a(t.getClass());
        if (a != null) {
            try {
                obj = a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
            }
        }
        return obj;
    }

    public boolean m419a(T t) {
        return m416a(t.getClass()) != null;
    }

    public Object m420b(T t, Object... objArr) {
        try {
            return m418a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object m421c(T t, Object... objArr) {
        Object a = m416a(t.getClass());
        if (a == null) {
            throw new AssertionError("Method " + this.f355b + " not supported for object " + t);
        }
        try {
            return a.invoke(t, objArr);
        } catch (Throwable e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object m422d(T t, Object... objArr) {
        try {
            return m421c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }
}
