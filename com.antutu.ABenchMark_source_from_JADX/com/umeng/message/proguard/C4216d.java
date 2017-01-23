package com.umeng.message.proguard;

import com.viewpagerindicator.C4273R;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.umeng.message.proguard.d */
public abstract class C4216d {
    private static final int f14305a = 2;
    public static final int f14306b = 76;
    public static final int f14307c = 64;
    protected static final int f14308d = 255;
    protected static final byte f14309e = (byte) 61;
    private static final int f14310m = 8192;
    protected final byte f14311f;
    protected final int f14312g;
    protected byte[] f14313h;
    protected int f14314i;
    protected boolean f14315j;
    protected int f14316k;
    protected int f14317l;
    private final int f14318n;
    private final int f14319o;
    private final int f14320p;
    private int f14321q;

    protected C4216d(int i, int i2, int i3, int i4) {
        this.f14311f = f14309e;
        this.f14318n = i;
        this.f14319o = i2;
        int i5 = (i3 <= 0 || i4 <= 0) ? 0 : (i3 / i2) * i2;
        this.f14312g = i5;
        this.f14320p = i4;
    }

    private void m17211a() {
        if (this.f14313h == null) {
            this.f14313h = new byte[m17225d()];
            this.f14314i = 0;
            this.f14321q = 0;
            return;
        }
        Object obj = new byte[(this.f14313h.length * f14305a)];
        System.arraycopy(this.f14313h, 0, obj, 0, this.f14313h.length);
        this.f14313h = obj;
    }

    protected static boolean m17212c(byte b) {
        switch (b) {
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
            case C4574a.ORDERED /*32*/:
                return true;
            default:
                return false;
        }
    }

    private void m17213e() {
        this.f14313h = null;
        this.f14314i = 0;
        this.f14321q = 0;
        this.f14316k = 0;
        this.f14317l = 0;
        this.f14315j = false;
    }

    public Object m17214a(Object obj) {
        if (obj instanceof byte[]) {
            return m17229l((byte[]) obj);
        }
        throw new Exception("Parameter supplied to Base-N encode is not a byte[]");
    }

    protected void m17215a(int i) {
        if (this.f14313h == null || this.f14313h.length < this.f14314i + i) {
            m17211a();
        }
    }

    abstract void m17216a(byte[] bArr, int i, int i2);

    public Object m17217b(Object obj) {
        if (obj instanceof byte[]) {
            return m17228k((byte[]) obj);
        }
        if (obj instanceof String) {
            return m17224c((String) obj);
        }
        throw new Exception("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    abstract void m17218b(byte[] bArr, int i, int i2);

    boolean m17219b() {
        return this.f14313h != null;
    }

    protected abstract boolean m17220b(byte b);

    public boolean m17221b(byte[] bArr, boolean z) {
        int i = 0;
        while (i < bArr.length) {
            if (!m17220b(bArr[i])) {
                if (!z) {
                    return false;
                }
                if (!(bArr[i] == 61 || C4216d.m17212c(bArr[i]))) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    int m17222c() {
        return this.f14313h != null ? this.f14314i - this.f14321q : 0;
    }

    int m17223c(byte[] bArr, int i, int i2) {
        if (this.f14313h == null) {
            return this.f14315j ? -1 : 0;
        } else {
            int min = Math.min(m17222c(), i2);
            System.arraycopy(this.f14313h, this.f14321q, bArr, i, min);
            this.f14321q += min;
            if (this.f14321q < this.f14314i) {
                return min;
            }
            this.f14313h = null;
            return min;
        }
    }

    public byte[] m17224c(String str) {
        return m17228k(C4214a.m17206f(str));
    }

    protected int m17225d() {
        return f14310m;
    }

    public boolean m17226d(String str) {
        return m17221b(C4214a.m17206f(str), true);
    }

    public String m17227j(byte[] bArr) {
        return C4214a.m17205f(m17229l(bArr));
    }

    public byte[] m17228k(byte[] bArr) {
        m17213e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        m17218b(bArr, 0, bArr.length);
        m17218b(bArr, 0, -1);
        bArr = new byte[this.f14314i];
        m17223c(bArr, 0, bArr.length);
        return bArr;
    }

    public byte[] m17229l(byte[] bArr) {
        m17213e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        m17216a(bArr, 0, bArr.length);
        m17216a(bArr, 0, -1);
        bArr = new byte[(this.f14314i - this.f14321q)];
        m17223c(bArr, 0, bArr.length);
        return bArr;
    }

    public String m17230m(byte[] bArr) {
        return C4214a.m17205f(m17229l(bArr));
    }

    protected boolean m17231n(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        int i = 0;
        while (i < bArr.length) {
            if (61 == bArr[i] || m17220b(bArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public long m17232o(byte[] bArr) {
        long length = ((long) (((bArr.length + this.f14318n) - 1) / this.f14318n)) * ((long) this.f14319o);
        return this.f14312g > 0 ? length + ((((((long) this.f14312g) + length) - 1) / ((long) this.f14312g)) * ((long) this.f14320p)) : length;
    }
}
