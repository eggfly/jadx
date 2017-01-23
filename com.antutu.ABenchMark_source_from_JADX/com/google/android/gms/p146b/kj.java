package com.google.android.gms.p146b;

/* renamed from: com.google.android.gms.b.kj */
public final class kj implements Cloneable {
    private static final kk f11619a;
    private boolean f11620b;
    private int[] f11621c;
    private kk[] f11622d;
    private int f11623e;

    static {
        f11619a = new kk();
    }

    kj() {
        this(10);
    }

    kj(int i) {
        this.f11620b = false;
        int b = m13681b(i);
        this.f11621c = new int[b];
        this.f11622d = new kk[b];
        this.f11623e = 0;
    }

    private boolean m13679a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m13680a(kk[] kkVarArr, kk[] kkVarArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!kkVarArr[i2].equals(kkVarArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m13681b(int i) {
        return m13682c(i * 4) / 4;
    }

    private int m13682c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private void m13683d() {
        int i = this.f11623e;
        int[] iArr = this.f11621c;
        kk[] kkVarArr = this.f11622d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            kk kkVar = kkVarArr[i3];
            if (kkVar != f11619a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    kkVarArr[i2] = kkVar;
                    kkVarArr[i3] = null;
                }
                i2++;
            }
        }
        this.f11620b = false;
        this.f11623e = i2;
    }

    int m13684a() {
        if (this.f11620b) {
            m13683d();
        }
        return this.f11623e;
    }

    kk m13685a(int i) {
        if (this.f11620b) {
            m13683d();
        }
        return this.f11622d[i];
    }

    public boolean m13686b() {
        return m13684a() == 0;
    }

    public final kj m13687c() {
        int i = 0;
        int a = m13684a();
        kj kjVar = new kj(a);
        System.arraycopy(this.f11621c, 0, kjVar.f11621c, 0, a);
        while (i < a) {
            if (this.f11622d[i] != null) {
                kjVar.f11622d[i] = this.f11622d[i].m13691b();
            }
            i++;
        }
        kjVar.f11623e = a;
        return kjVar;
    }

    public /* synthetic */ Object clone() {
        return m13687c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kj)) {
            return false;
        }
        kj kjVar = (kj) obj;
        return m13684a() != kjVar.m13684a() ? false : m13679a(this.f11621c, kjVar.f11621c, this.f11623e) && m13680a(this.f11622d, kjVar.f11622d, this.f11623e);
    }

    public int hashCode() {
        if (this.f11620b) {
            m13683d();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.f11623e; i2++) {
            i = (((i * 31) + this.f11621c[i2]) * 31) + this.f11622d[i2].hashCode();
        }
        return i;
    }
}
