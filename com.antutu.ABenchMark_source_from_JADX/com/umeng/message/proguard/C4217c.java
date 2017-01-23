package com.umeng.message.proguard;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.math.BigInteger;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.umeng.message.proguard.c */
public class C4217c extends C4216d {
    static final byte[] f14322a;
    private static final int f14323m = 6;
    private static final int f14324n = 3;
    private static final int f14325o = 4;
    private static final byte[] f14326p;
    private static final byte[] f14327q;
    private static final byte[] f14328r;
    private static final int f14329s = 63;
    private final byte[] f14330t;
    private final byte[] f14331u;
    private final byte[] f14332v;
    private final int f14333w;
    private final int f14334x;
    private int f14335y;

    static {
        f14322a = new byte[]{(byte) 13, (byte) 10};
        f14326p = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f14327q = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        f14328r = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) 62, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51};
    }

    public C4217c() {
        this(0);
    }

    public C4217c(int i) {
        this(i, f14322a);
    }

    public C4217c(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public C4217c(int i, byte[] bArr, boolean z) {
        super(f14324n, f14325o, i, bArr == null ? 0 : bArr.length);
        this.f14331u = f14328r;
        if (bArr == null) {
            this.f14334x = f14325o;
            this.f14332v = null;
        } else if (m17231n(bArr)) {
            throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + C4214a.m17205f(bArr) + "]");
        } else if (i > 0) {
            this.f14334x = bArr.length + f14325o;
            this.f14332v = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f14332v, 0, bArr.length);
        } else {
            this.f14334x = f14325o;
            this.f14332v = null;
        }
        this.f14333w = this.f14334x - 1;
        this.f14330t = z ? f14327q : f14326p;
    }

    public C4217c(boolean z) {
        this(76, f14322a, z);
    }

    public static boolean m17233a(byte b) {
        return b == 61 || (b >= null && b < f14328r.length && f14328r[b] != -1);
    }

    public static boolean m17234a(String str) {
        return C4217c.m17240b(C4214a.m17206f(str));
    }

    public static boolean m17235a(byte[] bArr) {
        return C4217c.m17240b(bArr);
    }

    public static byte[] m17236a(BigInteger bigInteger) {
        if (bigInteger != null) {
            return C4217c.m17237a(C4217c.m17242b(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static byte[] m17237a(byte[] bArr, boolean z) {
        return C4217c.m17238a(bArr, z, false);
    }

    public static byte[] m17238a(byte[] bArr, boolean z, boolean z2) {
        return C4217c.m17239a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] m17239a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C4217c c4217c = z ? new C4217c(z2) : new C4217c(0, f14322a, z2);
        long o = c4217c.m17232o(bArr);
        if (o <= ((long) i)) {
            return c4217c.m17229l(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + o + ") than the specified maximum size of " + i);
    }

    public static boolean m17240b(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            if (!C4217c.m17233a(bArr[i]) && !C4216d.m17212c(bArr[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static byte[] m17241b(String str) {
        return new C4217c().m17224c(str);
    }

    static byte[] m17242b(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> f14324n) << f14324n;
        Object toByteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return toByteArray;
        }
        int i = 0;
        int length = toByteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            i = 1;
            length--;
        }
        Object obj = new byte[(bitLength / 8)];
        System.arraycopy(toByteArray, i, obj, (bitLength / 8) - length, length);
        return obj;
    }

    public static byte[] m17243c(byte[] bArr) {
        return C4217c.m17237a(bArr, false);
    }

    public static String m17244d(byte[] bArr) {
        return C4214a.m17205f(C4217c.m17237a(bArr, false));
    }

    public static byte[] m17245e(byte[] bArr) {
        return C4217c.m17238a(bArr, false, true);
    }

    public static String m17246f(byte[] bArr) {
        return C4214a.m17205f(C4217c.m17238a(bArr, false, true));
    }

    public static byte[] m17247g(byte[] bArr) {
        return C4217c.m17237a(bArr, true);
    }

    public static byte[] m17248h(byte[] bArr) {
        return new C4217c().m17228k(bArr);
    }

    public static BigInteger m17249i(byte[] bArr) {
        return new BigInteger(1, C4217c.m17248h(bArr));
    }

    void m17250a(byte[] bArr, int i, int i2) {
        if (!this.j) {
            int i3;
            int i4;
            if (i2 < 0) {
                this.j = true;
                if (this.l != 0 || this.g != 0) {
                    m17215a(this.f14334x);
                    i3 = this.i;
                    byte[] bArr2;
                    switch (this.l) {
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                            bArr2 = this.h;
                            i4 = this.i;
                            this.i = i4 + 1;
                            bArr2[i4] = this.f14330t[(this.f14335y >> 2) & f14329s];
                            bArr2 = this.h;
                            i4 = this.i;
                            this.i = i4 + 1;
                            bArr2[i4] = this.f14330t[(this.f14335y << f14325o) & f14329s];
                            if (this.f14330t == f14326p) {
                                bArr2 = this.h;
                                i4 = this.i;
                                this.i = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                bArr2 = this.h;
                                i4 = this.i;
                                this.i = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                break;
                            }
                            break;
                        case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                            bArr2 = this.h;
                            i4 = this.i;
                            this.i = i4 + 1;
                            bArr2[i4] = this.f14330t[(this.f14335y >> 10) & f14329s];
                            bArr2 = this.h;
                            i4 = this.i;
                            this.i = i4 + 1;
                            bArr2[i4] = this.f14330t[(this.f14335y >> f14325o) & f14329s];
                            bArr2 = this.h;
                            i4 = this.i;
                            this.i = i4 + 1;
                            bArr2[i4] = this.f14330t[(this.f14335y << 2) & f14329s];
                            if (this.f14330t == f14326p) {
                                bArr2 = this.h;
                                i4 = this.i;
                                this.i = i4 + 1;
                                bArr2[i4] = (byte) 61;
                                break;
                            }
                            break;
                    }
                    this.k = (this.i - i3) + this.k;
                    if (this.g > 0 && this.k > 0) {
                        System.arraycopy(this.f14332v, 0, this.h, this.i, this.f14332v.length);
                        this.i += this.f14332v.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            while (i5 < i2) {
                m17215a(this.f14334x);
                this.l = (this.l + 1) % f14324n;
                i4 = i + 1;
                i3 = bArr[i];
                if (i3 < 0) {
                    i3 += AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                }
                this.f14335y = i3 + (this.f14335y << 8);
                if (this.l == 0) {
                    byte[] bArr3 = this.h;
                    int i6 = this.i;
                    this.i = i6 + 1;
                    bArr3[i6] = this.f14330t[(this.f14335y >> 18) & f14329s];
                    bArr3 = this.h;
                    i6 = this.i;
                    this.i = i6 + 1;
                    bArr3[i6] = this.f14330t[(this.f14335y >> 12) & f14329s];
                    bArr3 = this.h;
                    i6 = this.i;
                    this.i = i6 + 1;
                    bArr3[i6] = this.f14330t[(this.f14335y >> f14323m) & f14329s];
                    bArr3 = this.h;
                    i6 = this.i;
                    this.i = i6 + 1;
                    bArr3[i6] = this.f14330t[this.f14335y & f14329s];
                    this.k += f14325o;
                    if (this.g > 0 && this.g <= this.k) {
                        System.arraycopy(this.f14332v, 0, this.h, this.i, this.f14332v.length);
                        this.i += this.f14332v.length;
                        this.k = 0;
                    }
                }
                i5++;
                i = i4;
            }
        }
    }

    public boolean m17251a() {
        return this.f14330t == f14327q;
    }

    void m17252b(byte[] bArr, int i, int i2) {
        if (!this.j) {
            int i3;
            if (i2 < 0) {
                this.j = true;
            }
            int i4 = 0;
            while (i4 < i2) {
                m17215a(this.f14333w);
                i3 = i + 1;
                byte b = bArr[i];
                if (b == 61) {
                    this.j = true;
                    break;
                }
                if (b >= null && b < f14328r.length) {
                    b = f14328r[b];
                    if (b >= null) {
                        this.l = (this.l + 1) % f14325o;
                        this.f14335y = b + (this.f14335y << f14323m);
                        if (this.l == 0) {
                            byte[] bArr2 = this.h;
                            int i5 = this.i;
                            this.i = i5 + 1;
                            bArr2[i5] = (byte) ((this.f14335y >> 16) & MotionEventCompat.ACTION_MASK);
                            bArr2 = this.h;
                            i5 = this.i;
                            this.i = i5 + 1;
                            bArr2[i5] = (byte) ((this.f14335y >> 8) & MotionEventCompat.ACTION_MASK);
                            bArr2 = this.h;
                            i5 = this.i;
                            this.i = i5 + 1;
                            bArr2[i5] = (byte) (this.f14335y & MotionEventCompat.ACTION_MASK);
                        }
                    }
                }
                i4++;
                i = i3;
            }
            if (this.j && this.l != 0) {
                m17215a(this.f14333w);
                byte[] bArr3;
                switch (this.l) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        this.f14335y >>= f14325o;
                        bArr3 = this.h;
                        i3 = this.i;
                        this.i = i3 + 1;
                        bArr3[i3] = (byte) (this.f14335y & MotionEventCompat.ACTION_MASK);
                    case f14324n /*3*/:
                        this.f14335y >>= 2;
                        bArr3 = this.h;
                        i3 = this.i;
                        this.i = i3 + 1;
                        bArr3[i3] = (byte) ((this.f14335y >> 8) & MotionEventCompat.ACTION_MASK);
                        bArr3 = this.h;
                        i3 = this.i;
                        this.i = i3 + 1;
                        bArr3[i3] = (byte) (this.f14335y & MotionEventCompat.ACTION_MASK);
                    default:
                }
            }
        }
    }

    protected boolean m17253b(byte b) {
        return b >= null && b < this.f14331u.length && this.f14331u[b] != -1;
    }
}
