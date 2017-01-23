package cn.sharesdk.framework.utils;

import android.support.v4.media.TransportMediator;
import cn.sharesdk.framework.Platform;

/* renamed from: cn.sharesdk.framework.utils.b */
public class C0976b extends C0975e {
    private static final char[] f3346a;
    private static final char[] f3347b;
    private final boolean f3348c;
    private final boolean[] f3349d;

    static {
        f3346a = new char[]{'+'};
        f3347b = "0123456789ABCDEF".toCharArray();
    }

    public C0976b(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        } else {
            this.f3348c = z;
            this.f3349d = C0976b.m4370a(str);
        }
    }

    private static boolean[] m4370a(String str) {
        int i;
        int i2 = 0;
        char[] toCharArray = str.toCharArray();
        int i3 = 122;
        for (char max : toCharArray) {
            i3 = Math.max(max, i3);
        }
        boolean[] zArr = new boolean[(i3 + 1)];
        for (i = 48; i <= 57; i++) {
            zArr[i] = true;
        }
        for (i = 65; i <= 90; i++) {
            zArr[i] = true;
        }
        for (i = 97; i <= 122; i++) {
            zArr[i] = true;
        }
        i = toCharArray.length;
        while (i2 < i) {
            zArr[toCharArray[i2]] = true;
            i2++;
        }
        return zArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected int m4371a(java.lang.CharSequence r3, int r4, int r5) {
        /*
        r2 = this;
    L_0x0000:
        if (r4 >= r5) goto L_0x0011;
    L_0x0002:
        r0 = r3.charAt(r4);
        r1 = r2.f3349d;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0011;
    L_0x000b:
        r1 = r2.f3349d;
        r0 = r1[r0];
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r4;
    L_0x0012:
        r4 = r4 + 1;
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.b.a(java.lang.CharSequence, int, int):int");
    }

    protected char[] m4372a(int i) {
        if (i < this.f3349d.length && this.f3349d[i]) {
            return null;
        }
        if (i == 32 && this.f3348c) {
            return f3346a;
        }
        if (i <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
            return new char[]{'%', f3347b[i & 15], f3347b[i >>> 4]};
        } else if (i <= 2047) {
            r0 = new char[6];
            r0[0] = '%';
            r0[3] = '%';
            r0[5] = f3347b[i & 15];
            r1 = i >>> 4;
            r0[4] = f3347b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[2] = f3347b[r1 & 15];
            r0[1] = f3347b[(r1 >>> 4) | 12];
            return r0;
        } else if (i <= Platform.CUSTOMER_ACTION_MASK) {
            r0 = new char[9];
            r1 = i >>> 4;
            r0[7] = f3347b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[5] = f3347b[r1 & 15];
            r1 >>>= 4;
            r0[4] = f3347b[(r1 & 3) | 8];
            r0[2] = f3347b[r1 >>> 2];
            return r0;
        } else if (i <= 1114111) {
            r0 = new char[12];
            r1 = i >>> 4;
            r0[10] = f3347b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[8] = f3347b[r1 & 15];
            r1 >>>= 4;
            r0[7] = f3347b[(r1 & 3) | 8];
            r1 >>>= 2;
            r0[5] = f3347b[r1 & 15];
            r1 >>>= 4;
            r0[4] = f3347b[(r1 & 3) | 8];
            r0[2] = f3347b[(r1 >>> 2) & 7];
            return r0;
        } else {
            throw new IllegalArgumentException("Invalid unicode character value " + i);
        }
    }

    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= this.f3349d.length || !this.f3349d[charAt]) {
                return m4368a(str, i);
            }
        }
        return str;
    }
}
