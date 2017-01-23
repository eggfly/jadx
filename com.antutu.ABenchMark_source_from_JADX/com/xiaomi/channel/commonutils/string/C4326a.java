package com.xiaomi.channel.commonutils.string;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.channel.commonutils.string.a */
public class C4326a {
    private static final String f14770a;
    private static char[] f14771b;
    private static byte[] f14772c;

    static {
        int i;
        int i2 = 0;
        f14770a = System.getProperty("line.separator");
        f14771b = new char[64];
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            f14771b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            f14771b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            f14771b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        f14771b[i3] = '+';
        i3 = i + 1;
        f14771b[i] = '/';
        f14772c = new byte[SpdyProtocol.SLIGHTSSLV2];
        for (int i4 = 0; i4 < f14772c.length; i4++) {
            f14772c[i4] = (byte) -1;
        }
        while (i2 < 64) {
            f14772c[f14771b[i2]] = (byte) i2;
            i2++;
        }
    }

    public static byte[] m17731a(String str) {
        return C4326a.m17732a(str.toCharArray());
    }

    public static byte[] m17732a(char[] cArr) {
        return C4326a.m17733a(cArr, 0, cArr.length);
    }

    public static byte[] m17733a(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            char c = cArr[i];
            int i9 = i8 + 1;
            char c2 = cArr[i8];
            if (i9 < i4) {
                i8 = i9 + 1;
                i6 = cArr[i9];
                i9 = i8;
            } else {
                i6 = 65;
            }
            if (i9 < i4) {
                i8 = i9 + 1;
                i9 = cArr[i9];
                i7 = i8;
            } else {
                i7 = i9;
                i9 = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || i6 > TransportMediator.KEYCODE_MEDIA_PAUSE || i9 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = f14772c[c];
            byte b2 = f14772c[c2];
            byte b3 = f14772c[i6];
            byte b4 = f14772c[i9];
            if (b < null || b2 < null || b3 < null || b4 < null) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i8 = (b << 2) | (b2 >>> 4);
            int i10 = ((b2 & 15) << 4) | (b3 >>> 2);
            i6 = ((b3 & 3) << 6) | b4;
            i9 = i5 + 1;
            bArr[i5] = (byte) i8;
            if (i9 < i3) {
                i8 = i9 + 1;
                bArr[i9] = (byte) i10;
            } else {
                i8 = i9;
            }
            if (i8 < i3) {
                i9 = i8 + 1;
                bArr[i8] = (byte) i6;
            } else {
                i9 = i8;
            }
            i5 = i9;
            i = i7;
        }
        return bArr;
    }

    public static char[] m17734a(byte[] bArr) {
        return C4326a.m17735a(bArr, 0, bArr.length);
    }

    public static char[] m17735a(byte[] bArr, int i, int i2) {
        int i3 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            int i9 = bArr[i] & MotionEventCompat.ACTION_MASK;
            if (i8 < i4) {
                i6 = bArr[i8] & MotionEventCompat.ACTION_MASK;
                i8++;
            } else {
                i6 = 0;
            }
            if (i8 < i4) {
                i7 = i8 + 1;
                i8 = bArr[i8] & MotionEventCompat.ACTION_MASK;
            } else {
                i7 = i8;
                i8 = 0;
            }
            int i10 = i9 >>> 2;
            i9 = ((i9 & 3) << 4) | (i6 >>> 4);
            i6 = ((i6 & 15) << 2) | (i8 >>> 6);
            int i11 = i8 & 63;
            i8 = i5 + 1;
            cArr[i5] = f14771b[i10];
            i5 = i8 + 1;
            cArr[i8] = f14771b[i9];
            cArr[i5] = i5 < i3 ? f14771b[i6] : '=';
            i6 = i5 + 1;
            cArr[i6] = i6 < i3 ? f14771b[i11] : '=';
            i5 = i6 + 1;
            i = i7;
        }
        return cArr;
    }
}
