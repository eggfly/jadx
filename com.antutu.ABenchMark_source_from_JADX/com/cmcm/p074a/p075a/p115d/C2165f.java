package com.cmcm.p074a.p075a.p115d;

import android.support.v4.view.MotionEventCompat;
import java.util.Arrays;

/* renamed from: com.cmcm.a.a.d.f */
public class C2165f {
    static final C2165f f7523a;
    private static final char[] f7524f;
    private static final char[] f7525g;
    private final byte[] f7526b;
    private final int f7527c;
    private final boolean f7528d;
    private final boolean f7529e;

    static {
        f7524f = new char[]{'0', 'K', 'a', 'j', 'D', '7', 'A', 'Z', 'c', 'F', '2', 'Q', 'n', 'P', 'r', '5', 'f', 'w', 'i', 'H', 'R', 'N', 'y', 'g', 'm', 'u', 'p', 'U', 'T', 'I', 'X', 'x', '6', '9', 'B', 'W', 'b', '-', 'h', 'M', 'C', 'G', 'J', 'o', '_', 'V', '8', 'E', 's', 'k', 'z', '1', 'Y', 'd', 'v', 'L', '3', '4', 'l', 'e', 't', 'q', 'S', 'O'};
        f7525g = f7524f;
        f7523a = new C2165f(false, null, -1, true);
    }

    private C2165f(boolean z, byte[] bArr, int i, boolean z2) {
        this.f7528d = z;
        this.f7526b = bArr;
        this.f7527c = i;
        this.f7529e = z2;
    }

    private int m8158a(int i) {
        int i2;
        if (this.f7529e) {
            i2 = ((i + 2) / 3) * 4;
        } else {
            i2 = i % 3;
            i2 = (i2 == 0 ? 0 : i2 + 1) + ((i / 3) * 4);
        }
        return this.f7527c > 0 ? i2 + (((i2 - 1) / this.f7527c) * this.f7526b.length) : i2;
    }

    private int m8159a(byte[] bArr, int i, int i2, byte[] bArr2) {
        char[] cArr = this.f7528d ? f7525g : f7524f;
        int i3 = ((i2 - i) / 3) * 3;
        int i4 = i + i3;
        if (this.f7527c > 0 && i3 > (this.f7527c / 4) * 3) {
            i3 = (this.f7527c / 4) * 3;
        }
        int i5 = 0;
        int i6 = i;
        while (i6 < i4) {
            i = Math.min(i6 + i3, i4);
            int i7 = i5;
            int i8 = i6;
            while (i8 < i) {
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                i9 = ((bArr[i9] & MotionEventCompat.ACTION_MASK) << 8) | ((bArr[i8] & MotionEventCompat.ACTION_MASK) << 16);
                i8 = i10 + 1;
                i9 |= bArr[i10] & MotionEventCompat.ACTION_MASK;
                i10 = i7 + 1;
                bArr2[i7] = (byte) cArr[(i9 >>> 18) & 63];
                i7 = i10 + 1;
                bArr2[i10] = (byte) cArr[(i9 >>> 12) & 63];
                i10 = i7 + 1;
                bArr2[i7] = (byte) cArr[(i9 >>> 6) & 63];
                i7 = i10 + 1;
                bArr2[i10] = (byte) cArr[i9 & 63];
            }
            i7 = ((i - i6) / 3) * 4;
            i5 += i7;
            if (i7 == this.f7527c && i < i2) {
                byte[] bArr3 = this.f7526b;
                i9 = bArr3.length;
                i7 = 0;
                while (i7 < i9) {
                    i8 = i5 + 1;
                    bArr2[i5] = bArr3[i7];
                    i7++;
                    i5 = i8;
                }
            }
            i6 = i;
        }
        if (i6 >= i2) {
            return i5;
        }
        i3 = i6 + 1;
        i7 = bArr[i6] & MotionEventCompat.ACTION_MASK;
        i8 = i5 + 1;
        bArr2[i5] = (byte) cArr[i7 >> 2];
        if (i3 == i2) {
            i3 = i8 + 1;
            bArr2[i8] = (byte) cArr[(i7 << 4) & 63];
            if (this.f7529e) {
                i5 = i3 + 1;
                bArr2[i3] = (byte) 61;
                int i11 = i5 + 1;
                bArr2[i5] = (byte) 61;
                return i11;
            }
        }
        i5 = i3 + 1;
        i5 = bArr[i3] & MotionEventCompat.ACTION_MASK;
        i6 = i8 + 1;
        bArr2[i8] = (byte) cArr[((i7 << 4) & 63) | (i5 >> 4)];
        i3 = i6 + 1;
        bArr2[i6] = (byte) cArr[(i5 << 2) & 63];
        if (this.f7529e) {
            i11 = i3 + 1;
            bArr2[i3] = (byte) 61;
            return i11;
        }
        return i3;
    }

    public byte[] m8160a(byte[] bArr) {
        byte[] bArr2 = new byte[m8158a(bArr.length)];
        int a = m8159a(bArr, 0, bArr.length, bArr2);
        return a != bArr2.length ? Arrays.copyOf(bArr2, a) : bArr2;
    }

    public String m8161b(byte[] bArr) {
        byte[] a = m8160a(bArr);
        return new String(a, 0, 0, a.length);
    }
}
