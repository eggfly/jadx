package p023b.p024a;

/* renamed from: b.a.bz */
public final class bz extends ca {
    private byte[] f2796a;
    private int f2797b;
    private int f2798c;

    public int m3636a(byte[] bArr, int i, int i2) {
        int d = m3644d();
        if (i2 > d) {
            i2 = d;
        }
        if (i2 > 0) {
            System.arraycopy(this.f2796a, this.f2797b, bArr, i, i2);
            m3638a(i2);
        }
        return i2;
    }

    public void m3637a() {
        this.f2796a = null;
    }

    public void m3638a(int i) {
        this.f2797b += i;
    }

    public void m3639a(byte[] bArr) {
        m3643c(bArr, 0, bArr.length);
    }

    public void m3640b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public byte[] m3641b() {
        return this.f2796a;
    }

    public int m3642c() {
        return this.f2797b;
    }

    public void m3643c(byte[] bArr, int i, int i2) {
        this.f2796a = bArr;
        this.f2797b = i;
        this.f2798c = i + i2;
    }

    public int m3644d() {
        return this.f2798c - this.f2797b;
    }
}
