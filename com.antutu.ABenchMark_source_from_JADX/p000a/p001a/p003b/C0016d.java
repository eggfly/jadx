package p000a.p001a.p003b;

import java.util.LinkedHashSet;
import java.util.Set;
import p000a.ab;

/* renamed from: a.a.b.d */
public final class C0016d {
    private final Set<ab> f66a;

    public C0016d() {
        this.f66a = new LinkedHashSet();
    }

    public synchronized void m60a(ab abVar) {
        this.f66a.add(abVar);
    }

    public synchronized void m61b(ab abVar) {
        this.f66a.remove(abVar);
    }

    public synchronized boolean m62c(ab abVar) {
        return this.f66a.contains(abVar);
    }
}
