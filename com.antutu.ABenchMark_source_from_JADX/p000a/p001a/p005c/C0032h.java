package p000a.p001a.p005c;

import okio.BufferedSource;
import org.apache.http.entity.mime.MIME;
import p000a.C0127q;
import p000a.C0131t;
import p000a.aa;

/* renamed from: a.a.c.h */
public final class C0032h extends aa {
    private final C0127q f106a;
    private final BufferedSource f107b;

    public C0032h(C0127q c0127q, BufferedSource bufferedSource) {
        this.f106a = c0127q;
        this.f107b = bufferedSource;
    }

    public C0131t m132a() {
        String a = this.f106a.m550a(MIME.CONTENT_TYPE);
        return a != null ? C0131t.m607a(a) : null;
    }

    public long m133b() {
        return C0028e.m106a(this.f106a);
    }

    public BufferedSource m134c() {
        return this.f107b;
    }
}
