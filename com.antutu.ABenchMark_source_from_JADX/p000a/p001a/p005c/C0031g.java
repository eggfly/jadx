package p000a.p001a.p005c;

import java.util.List;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0014i;
import p000a.C0130r;
import p000a.C0139x;
import p000a.C0143z;
import p000a.p001a.p003b.C0020g;

/* renamed from: a.a.c.g */
public final class C0031g implements C0030a {
    private final List<C0001s> f99a;
    private final C0020g f100b;
    private final C0025c f101c;
    private final C0014i f102d;
    private final int f103e;
    private final C0139x f104f;
    private int f105g;

    public C0031g(List<C0001s> list, C0020g c0020g, C0025c c0025c, C0014i c0014i, int i, C0139x c0139x) {
        this.f99a = list;
        this.f102d = c0014i;
        this.f100b = c0020g;
        this.f101c = c0025c;
        this.f103e = i;
        this.f104f = c0139x;
    }

    private boolean m119a(C0130r c0130r) {
        return c0130r.m598f().equals(this.f102d.m44a().m458a().m444a().m598f()) && c0130r.m599g() == this.f102d.m44a().m458a().m444a().m599g();
    }

    public C0139x m120a() {
        return this.f104f;
    }

    public C0143z m121a(C0139x c0139x) {
        return m122a(c0139x, this.f100b, this.f101c, this.f102d);
    }

    public C0143z m122a(C0139x c0139x, C0020g c0020g, C0025c c0025c, C0014i c0014i) {
        if (this.f103e >= this.f99a.size()) {
            throw new AssertionError();
        }
        this.f105g++;
        if (this.f101c != null && !m119a(c0139x.m661a())) {
            throw new IllegalStateException("network interceptor " + this.f99a.get(this.f103e - 1) + " must retain the same host and port");
        } else if (this.f101c == null || this.f105g <= 1) {
            Object c0031g = new C0031g(this.f99a, c0020g, c0025c, c0014i, this.f103e + 1, c0139x);
            C0001s c0001s = (C0001s) this.f99a.get(this.f103e);
            C0143z a = c0001s.m0a(c0031g);
            if (c0025c != null && this.f103e + 1 < this.f99a.size() && c0031g.f105g != 1) {
                throw new IllegalStateException("network interceptor " + c0001s + " must call proceed() exactly once");
            } else if (a != null) {
                return a;
            } else {
                throw new NullPointerException("interceptor " + c0001s + " returned null");
            }
        } else {
            throw new IllegalStateException("network interceptor " + this.f99a.get(this.f103e - 1) + " must call proceed() exactly once");
        }
    }

    public C0020g m123b() {
        return this.f100b;
    }

    public C0025c m124c() {
        return this.f101c;
    }
}
