package org.apache.thrift.transport;

/* renamed from: org.apache.thrift.transport.c */
public final class C4621c extends C4618d {
    private byte[] f16497a;
    private int f16498b;
    private int f16499c;

    public int m19396a(byte[] bArr, int i, int i2) {
        int c = m19402c();
        if (i2 > c) {
            i2 = c;
        }
        if (i2 > 0) {
            System.arraycopy(this.f16497a, this.f16498b, bArr, i, i2);
            m19397a(i2);
        }
        return i2;
    }

    public void m19397a(int i) {
        this.f16498b += i;
    }

    public void m19398a(byte[] bArr) {
        m19403c(bArr, 0, bArr.length);
    }

    public byte[] m19399a() {
        return this.f16497a;
    }

    public int m19400b() {
        return this.f16498b;
    }

    public void m19401b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public int m19402c() {
        return this.f16499c - this.f16498b;
    }

    public void m19403c(byte[] bArr, int i, int i2) {
        this.f16497a = bArr;
        this.f16498b = i;
        this.f16499c = i + i2;
    }
}
