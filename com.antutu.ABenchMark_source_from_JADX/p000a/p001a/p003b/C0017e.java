package p000a.p001a.p003b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.a.b.e */
public final class C0017e extends RuntimeException {
    private static final Method f67a;
    private IOException f68b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            declaredMethod = null;
        }
        f67a = declaredMethod;
    }

    public C0017e(IOException iOException) {
        super(iOException);
        this.f68b = iOException;
    }

    private void m63a(IOException iOException, IOException iOException2) {
        if (f67a != null) {
            try {
                f67a.invoke(iOException, new Object[]{iOException2});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
    }

    public IOException m64a() {
        return this.f68b;
    }

    public void m65a(IOException iOException) {
        m63a(iOException, this.f68b);
        this.f68b = iOException;
    }
}
