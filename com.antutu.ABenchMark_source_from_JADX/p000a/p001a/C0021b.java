package p000a.p001a;

/* renamed from: a.a.b */
public abstract class C0021b implements Runnable {
    protected final String f90b;

    public C0021b(String str, Object... objArr) {
        this.f90b = C0037c.m153a(str, objArr);
    }

    protected abstract void m92b();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f90b);
        try {
            m92b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
