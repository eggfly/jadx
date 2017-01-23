package com.google.android.gms.p146b;

/* renamed from: com.google.android.gms.b.kh */
public abstract class kh<M extends kh<M>> extends km {
    protected kj f11614a;

    public M m13670a() {
        kh khVar = (kh) super.d_();
        kl.m13696a(this, khVar);
        return khVar;
    }

    public void m13671a(kg kgVar) {
        if (this.f11614a != null) {
            for (int i = 0; i < this.f11614a.m13684a(); i++) {
                this.f11614a.m13685a(i).m13690a(kgVar);
            }
        }
    }

    protected int m13672b() {
        int i = 0;
        if (this.f11614a == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f11614a.m13684a()) {
            i2 += this.f11614a.m13685a(i).m13689a();
            i++;
        }
        return i2;
    }

    public /* synthetic */ Object clone() {
        return m13670a();
    }

    public /* synthetic */ km d_() {
        return m13670a();
    }
}
