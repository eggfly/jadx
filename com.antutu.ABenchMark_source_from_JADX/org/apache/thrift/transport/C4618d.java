package org.apache.thrift.transport;

/* renamed from: org.apache.thrift.transport.d */
public abstract class C4618d {
    public abstract int m19385a(byte[] bArr, int i, int i2);

    public void m19386a(int i) {
    }

    public byte[] m19387a() {
        return null;
    }

    public int m19388b() {
        return 0;
    }

    public abstract void m19389b(byte[] bArr, int i, int i2);

    public int m19390c() {
        return -1;
    }

    public int m19391d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = m19385a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new C4622e("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += a;
        }
        return i3;
    }
}
