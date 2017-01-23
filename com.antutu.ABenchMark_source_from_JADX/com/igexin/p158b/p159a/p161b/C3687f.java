package com.igexin.p158b.p159a.p161b;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.LinearLayoutManager;
import anet.channel.util.HttpConstant;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.igexin.b.a.b.f */
public final class C3687f {
    public static int m15074a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & MotionEventCompat.ACTION_MASK);
        bArr[i2 + 1] = (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK);
        bArr[i2 + 2] = (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK);
        bArr[i2 + 3] = (byte) (i & MotionEventCompat.ACTION_MASK);
        return 4;
    }

    public static int m15075a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 7] = (byte) ((int) (255 & j));
        return 8;
    }

    public static int m15076a(byte[] bArr, int i) {
        return bArr[i] & MotionEventCompat.ACTION_MASK;
    }

    public static int m15077a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr, i, bArr2, i2, i3);
        return i3;
    }

    public static String m15078a(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!strArr[0].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append(strArr[0]).append(HttpConstant.SCHEME_SPLIT);
        }
        if (!strArr[1].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append(strArr[1]);
        }
        if (!strArr[2].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append(':').append(strArr[2]);
        }
        if (!strArr[3].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append(strArr[3]);
            if (!strArr[3].equals("/")) {
                stringBuilder.append('/');
            }
        }
        if (!strArr[4].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append(strArr[4]);
        }
        if (!strArr[5].equals(BuildConfig.FLAVOR)) {
            stringBuilder.append('?').append(strArr[5]);
        }
        return stringBuilder.toString();
    }

    private static void m15079a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void m15080a(InputStream inputStream, OutputStream outputStream, int i) {
        OutputStream c3682a = new C3682a(outputStream, i);
        C3687f.m15079a(inputStream, c3682a);
        c3682a.m15041a();
    }

    public static byte[] m15081a(int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        do {
            i2 = ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) << 24) | i4;
            i >>>= 7;
            i5++;
            if (i > 0) {
                i4 = (i2 >>> 8) | LinearLayoutManager.INVALID_OFFSET;
                continue;
            } else {
                i4 = i2;
                continue;
            }
        } while (i > 0);
        byte[] bArr = new byte[i5];
        i2 = 24;
        while (i3 < i5) {
            bArr[i3] = (byte) (i4 >>> i2);
            i2 -= 8;
            i3++;
        }
        return bArr;
    }

    public static byte[] m15082a(byte[] bArr) {
        return C3687f.m15090c(bArr);
    }

    public static String[] m15083a(String str) {
        int i;
        int indexOf;
        StringBuilder stringBuilder = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        for (i = 0; i < 6; i++) {
            strArr[i] = BuildConfig.FLAVOR;
        }
        i = str.indexOf(":");
        if (i > 0) {
            strArr[0] = str.substring(0, i);
            stringBuilder.delete(0, i + 1);
        } else if (i == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (stringBuilder.length() >= 2 && stringBuilder.charAt(0) == '/' && stringBuilder.charAt(1) == '/') {
            stringBuilder.delete(0, 2);
            indexOf = stringBuilder.toString().indexOf(47);
            if (indexOf < 0) {
                indexOf = stringBuilder.length();
            }
            if (indexOf != 0) {
                i = stringBuilder.toString().indexOf(58);
                if (i < 0) {
                    i = indexOf;
                } else if (i > indexOf) {
                    throw new IllegalArgumentException("url format error - port");
                } else {
                    strArr[2] = stringBuilder.toString().substring(i + 1, indexOf);
                }
                strArr[1] = stringBuilder.toString().substring(0, i);
                stringBuilder.delete(0, indexOf);
            }
        }
        if (stringBuilder.length() > 0) {
            String stringBuilder2 = stringBuilder.toString();
            indexOf = stringBuilder2.lastIndexOf(47);
            if (indexOf > 0) {
                strArr[3] = stringBuilder2.substring(0, indexOf);
            } else if (indexOf == 0) {
                if (stringBuilder2.indexOf(63) > 0) {
                    throw new IllegalArgumentException("url format error - path");
                }
                strArr[3] = stringBuilder2;
                return strArr;
            }
            if (indexOf < stringBuilder2.length() - 1) {
                stringBuilder2 = stringBuilder2.substring(indexOf + 1, stringBuilder2.length());
                indexOf = stringBuilder2.indexOf(63);
                if (indexOf >= 0) {
                    strArr[4] = stringBuilder2.substring(0, indexOf);
                    strArr[5] = stringBuilder2.substring(indexOf + 1);
                } else {
                    strArr[4] = stringBuilder2;
                }
            }
        } else {
            strArr[3] = "/";
        }
        return strArr;
    }

    public static int m15084b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK);
        bArr[i2 + 1] = (byte) (i & MotionEventCompat.ACTION_MASK);
        return 2;
    }

    public static short m15085b(byte[] bArr, int i) {
        return (short) (((bArr[i] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 1] & MotionEventCompat.ACTION_MASK));
    }

    public static byte[] m15086b(int i) {
        return new byte[]{(byte) ((i >> 24) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 16) & MotionEventCompat.ACTION_MASK), (byte) ((i >> 8) & MotionEventCompat.ACTION_MASK), (byte) (i & MotionEventCompat.ACTION_MASK)};
    }

    public static byte[] m15087b(byte[] bArr) {
        return C3687f.m15092d(bArr);
    }

    public static int m15088c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        return 1;
    }

    public static int m15089c(byte[] bArr, int i) {
        return ((bArr[i] & MotionEventCompat.ACTION_MASK) << 8) | (bArr[i + 1] & MotionEventCompat.ACTION_MASK);
    }

    public static byte[] m15090c(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        byte[] bArr2 = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr2 = byteArrayOutputStream.toByteArray();
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            gZIPOutputStream = bArr2;
            th = th4;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr2;
    }

    public static int m15091d(byte[] bArr, int i) {
        return ((((bArr[i] & MotionEventCompat.ACTION_MASK) << 24) | ((bArr[i + 1] & MotionEventCompat.ACTION_MASK) << 16)) | ((bArr[i + 2] & MotionEventCompat.ACTION_MASK) << 8)) | (bArr[i + 3] & MotionEventCompat.ACTION_MASK);
    }

    public static byte[] m15092d(byte[] bArr) {
        Throwable th;
        byte[] bArr2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = gZIPInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(read);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e2) {
                    }
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e3) {
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = bArr2;
                th = th4;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e6) {
                }
                throw th;
            }
        } catch (Throwable th32) {
            gZIPInputStream = bArr2;
            byte[] bArr3 = bArr2;
            th = th32;
            byteArrayOutputStream = bArr3;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return bArr2;
    }

    public static long m15093e(byte[] bArr, int i) {
        return ((((((((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48)) | ((((long) bArr[i + 2]) & 255) << 40)) | ((((long) bArr[i + 3]) & 255) << 32)) | ((((long) bArr[i + 4]) & 255) << 24)) | ((((long) bArr[i + 5]) & 255) << 16)) | ((((long) bArr[i + 6]) & 255) << 8)) | (((long) bArr[i + 7]) & 255);
    }

    public static byte[] m15094f(byte[] bArr, int i) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            C3687f.m15080a(byteArrayInputStream, byteArrayOutputStream, i);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th4) {
            }
            byteArrayOutputStream.close();
        }
    }
}
