package p000a.p001a.p003b;

import org.android.spdy.SpdyRequest;
import p000a.C0001s;
import p000a.C0001s.C0030a;
import p000a.C0134u;
import p000a.C0139x;
import p000a.C0143z;
import p000a.p001a.p005c.C0031g;

/* renamed from: a.a.b.a */
public final class C0011a implements C0001s {
    public final C0134u f47a;

    public C0011a(C0134u c0134u) {
        this.f47a = c0134u;
    }

    public C0143z m38a(C0030a c0030a) {
        C0031g c0031g = (C0031g) c0030a;
        C0139x a = c0031g.m120a();
        C0020g b = c0031g.m123b();
        return c0031g.m122a(a, b, b.m84a(this.f47a, !a.m663b().equals(SpdyRequest.GET_METHOD)), b.m88b());
    }
}
