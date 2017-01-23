package com.cmcm.support.p116a;

import com.umeng.message.proguard.C4233j;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.cmcm.support.a.b */
public abstract class C2189b {
    private static final byte[] f7582a;
    private static final byte[] f7583b;

    static {
        int i;
        f7582a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f7583b = new byte[SpdyProtocol.SLIGHTSSLV2];
        for (i = 0; i < SpdyProtocol.SLIGHTSSLV2; i++) {
            f7583b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            f7583b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            f7583b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            f7583b[i] = (byte) ((i - 48) + 52);
        }
        f7583b[43] = (byte) 62;
        f7583b[47] = (byte) 63;
    }

    private static boolean m8231a(byte b) {
        return b == 61 ? true : (b < null || b >= 128) ? false : f7583b[b] != -1;
    }

    public static byte[] m8232a(String str) {
        int i = 0;
        if (str == null) {
            throw new IllegalArgumentException("Data must be not null");
        }
        String b = C2189b.m8233b(str);
        if (b.length() < 4) {
            throw new IllegalArgumentException("Wrong base64 (length: " + b.length() + C4233j.f14397t);
        }
        byte[] bArr = b.charAt(b.length() + -2) == '=' ? new byte[((((b.length() / 4) - 1) * 3) + 1)] : b.charAt(b.length() + -1) == '=' ? new byte[((((b.length() / 4) - 1) * 3) + 2)] : new byte[((b.length() / 4) * 3)];
        for (int i2 = 0; i2 < b.length() - 4; i2 += 4) {
            byte b2 = f7583b[b.charAt(i2)];
            byte b3 = f7583b[b.charAt(i2 + 1)];
            byte b4 = f7583b[b.charAt(i2 + 2)];
            byte b5 = f7583b[b.charAt(i2 + 3)];
            bArr[i] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i + 2] = (byte) ((b4 << 6) | b5);
            i += 3;
        }
        if (b.charAt(b.length() - 2) == '=') {
            bArr[bArr.length - 1] = (byte) ((f7583b[b.charAt(b.length() - 4)] << 2) | (f7583b[b.charAt(b.length() - 3)] >> 4));
        } else if (b.charAt(b.length() - 1) == '=') {
            r1 = f7583b[b.charAt(b.length() - 4)];
            r2 = f7583b[b.charAt(b.length() - 3)];
            r3 = f7583b[b.charAt(b.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((r1 << 2) | (r2 >> 4));
            bArr[bArr.length - 1] = (byte) ((r2 << 4) | (r3 >> 2));
        } else {
            r1 = f7583b[b.charAt(b.length() - 4)];
            r2 = f7583b[b.charAt(b.length() - 3)];
            b2 = f7583b[b.charAt(b.length() - 2)];
            r3 = f7583b[b.charAt(b.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((r1 << 2) | (r2 >> 4));
            bArr[bArr.length - 2] = (byte) ((r2 << 4) | (b2 >> 2));
            bArr[bArr.length - 1] = (byte) ((b2 << 6) | r3);
        }
        return bArr;
    }

    private static String m8233b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (C2189b.m8231a((byte) str.charAt(i))) {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }
}
