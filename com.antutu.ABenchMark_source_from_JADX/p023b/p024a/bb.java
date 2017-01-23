package p023b.p024a;

import java.io.ByteArrayOutputStream;
import p023b.p024a.bi.C0843a;

/* renamed from: b.a.bb */
public class bb {
    private final ByteArrayOutputStream f2736a;
    private final by f2737b;
    private bm f2738c;

    public bb() {
        this(new C0843a());
    }

    public bb(bo boVar) {
        this.f2736a = new ByteArrayOutputStream();
        this.f2737b = new by(this.f2736a);
        this.f2738c = boVar.m3490a(this.f2737b);
    }

    public byte[] m3488a(aw awVar) {
        this.f2736a.reset();
        awVar.m3096b(this.f2738c);
        return this.f2736a.toByteArray();
    }
}
