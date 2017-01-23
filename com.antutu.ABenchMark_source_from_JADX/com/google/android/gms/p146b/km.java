package com.google.android.gms.p146b;

/* renamed from: com.google.android.gms.b.km */
public abstract class km {
    protected volatile int f9108S;

    public km() {
        this.f9108S = -1;
    }

    public static final void m10115a(km kmVar, byte[] bArr, int i, int i2) {
        try {
            kg a = kg.m13623a(bArr, i, i2);
            kmVar.m10117a(a);
            a.m13659b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m10116a(km kmVar) {
        byte[] bArr = new byte[kmVar.m10120e()];
        km.m10115a(kmVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void m10117a(kg kgVar) {
    }

    protected int m10118b() {
        return 0;
    }

    public /* synthetic */ Object clone() {
        return d_();
    }

    public int m10119d() {
        if (this.f9108S < 0) {
            m10120e();
        }
        return this.f9108S;
    }

    public km d_() {
        return (km) super.clone();
    }

    public int m10120e() {
        int b = m10118b();
        this.f9108S = b;
        return b;
    }

    public String toString() {
        return kn.m13701a(this);
    }
}
