package p023b.p024a;

import p023b.p024a.bi.C0843a;

/* renamed from: b.a.ay */
public class ay {
    private final bm f2725a;
    private final bz f2726b;

    public ay() {
        this(new C0843a());
    }

    public ay(bo boVar) {
        this.f2726b = new bz();
        this.f2725a = boVar.m3490a(this.f2726b);
    }

    public void m3468a(aw awVar, byte[] bArr) {
        try {
            this.f2726b.m3639a(bArr);
            awVar.m3095a(this.f2725a);
        } finally {
            this.f2726b.m3637a();
            this.f2725a.m3523x();
        }
    }
}
