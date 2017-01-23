package p023b.p024a;

/* renamed from: b.a.ca */
public abstract class ca {
    public abstract int m3626a(byte[] bArr, int i, int i2);

    public void m3627a(int i) {
    }

    public void m3628b(byte[] bArr) {
        m3629b(bArr, 0, bArr.length);
    }

    public abstract void m3629b(byte[] bArr, int i, int i2);

    public byte[] m3630b() {
        return null;
    }

    public int m3631c() {
        return 0;
    }

    public int m3632d() {
        return -1;
    }

    public int m3633d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = m3626a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new cb("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }
}
