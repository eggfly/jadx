package org.android.agoo.common;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;

/* renamed from: org.android.agoo.common.a */
public class C4574a {
    public static final int DECODE = 0;
    public static final int DONT_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    private static final byte[] f16393a;
    private static final byte[] f16394b;
    private static final byte[] f16395c;
    private static final byte[] f16396d;
    private static final byte[] f16397e;
    private static final byte[] f16398f;

    static {
        f16393a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f16394b = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
        f16395c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        f16396d = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
        f16397e = new byte[]{(byte) 45, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 95, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};
        f16398f = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) -9, (byte) -9, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 37, (byte) -9, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) 62, (byte) 63, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    }

    private static final int m19235a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] a = C4574a.m19236a(i3);
        if (bArr[i + GZIP] == (byte) 61) {
            bArr2[i2] = (byte) ((((a[bArr[i + ENCODE]] & MotionEventCompat.ACTION_MASK) << 12) | ((a[bArr[i]] & MotionEventCompat.ACTION_MASK) << 18)) >>> URL_SAFE);
            return ENCODE;
        } else if (bArr[i + 3] == (byte) 61) {
            r0 = ((a[bArr[i + GZIP]] & MotionEventCompat.ACTION_MASK) << 6) | (((a[bArr[i]] & MotionEventCompat.ACTION_MASK) << 18) | ((a[bArr[i + ENCODE]] & MotionEventCompat.ACTION_MASK) << 12));
            bArr2[i2] = (byte) (r0 >>> URL_SAFE);
            bArr2[i2 + ENCODE] = (byte) (r0 >>> DONT_BREAK_LINES);
            return GZIP;
        } else {
            try {
                r0 = (a[bArr[i + 3]] & MotionEventCompat.ACTION_MASK) | ((((a[bArr[i]] & MotionEventCompat.ACTION_MASK) << 18) | ((a[bArr[i + ENCODE]] & MotionEventCompat.ACTION_MASK) << 12)) | ((a[bArr[i + GZIP]] & MotionEventCompat.ACTION_MASK) << 6));
                bArr2[i2] = (byte) (r0 >> URL_SAFE);
                bArr2[i2 + ENCODE] = (byte) (r0 >> DONT_BREAK_LINES);
                bArr2[i2 + GZIP] = (byte) r0;
                return 3;
            } catch (Throwable th) {
                return -1;
            }
        }
    }

    private static final byte[] m19236a(int i) {
        return (i & URL_SAFE) == URL_SAFE ? f16396d : (i & ORDERED) == ORDERED ? f16398f : f16394b;
    }

    public static final byte[] m19237a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes(HttpRequest.f14548a);
        } catch (Throwable th) {
            bytes = str.getBytes();
        }
        return C4574a.m19238a(bytes, NO_OPTIONS, bytes.length, i);
    }

    public static final byte[] m19238a(byte[] bArr, int i, int i2, int i3) {
        int i4;
        byte[] a = C4574a.m19236a(i3);
        Object obj = new byte[((i2 * 3) / 4)];
        byte[] bArr2 = new byte[4];
        int i5 = i;
        int i6 = NO_OPTIONS;
        int i7 = NO_OPTIONS;
        while (i5 < i + i2) {
            byte b = (byte) (bArr[i5] & TransportMediator.KEYCODE_MEDIA_PAUSE);
            byte b2 = a[b];
            if (b2 < -5) {
                return null;
            }
            if (b2 >= -1) {
                i4 = i6 + ENCODE;
                bArr2[i6] = b;
                if (i4 > 3) {
                    i4 = C4574a.m19235a(bArr2, NO_OPTIONS, obj, i7, i3) + i7;
                    if (b == 61) {
                        break;
                    }
                    i6 = i4;
                    i4 = NO_OPTIONS;
                } else {
                    i6 = i7;
                }
            } else {
                i4 = i6;
                i6 = i7;
            }
            i5 += ENCODE;
            i7 = i6;
            i6 = i4;
        }
        i4 = i7;
        Object obj2 = new byte[i4];
        System.arraycopy(obj, NO_OPTIONS, obj2, NO_OPTIONS, i4);
        return obj2;
    }
}
