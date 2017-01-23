package p023b.p024a;

import android.content.Context;
import anet.channel.security.ISecurity;
import com.facebook.ads.AdError;
import com.umeng.analytics.C4156a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.ak */
public class ak {
    private static final byte[] f2676a;

    static {
        f2676a = new byte[]{(byte) 10, (byte) 1, (byte) 11, (byte) 5, (byte) 4, (byte) 15, (byte) 7, (byte) 9, (byte) 23, (byte) 3, (byte) 1, (byte) 6, (byte) 8, (byte) 12, (byte) 13, (byte) 91};
    }

    public static int m3320a(int i, String str) {
        int i2 = 0;
        if (((double) new Random().nextFloat()) < 0.001d) {
            if (str == null) {
                ap.m3384a("--->", "null signature..");
            }
            try {
                i2 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception e) {
            }
            return (i2 | SpdyProtocol.SLIGHTSSLV2) * AdError.NETWORK_ERROR_CODE;
        }
        i2 = new Random().nextInt(i);
        return (i2 > 255000 || i2 < 128000) ? i2 : 127000;
    }

    public static String m3321a(Throwable th) {
        String str = null;
        if (th != null) {
            try {
                Writer stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    cause.printStackTrace(printWriter);
                }
                str = stringWriter.toString();
                printWriter.close();
                stringWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String m3322a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static boolean m3323a(Context context, byte[] bArr) {
        long length = (long) bArr.length;
        if (length <= C4156a.f13960v) {
            return false;
        }
        at.m3424a(context).m3447g();
        ci.m3705a(context).m3731a(length, System.currentTimeMillis(), C4156a.f13957s);
        return true;
    }

    public static byte[] m3324a(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i + 2), 16).intValue();
                }
            }
        }
        return bArr;
    }

    public static byte[] m3325a(byte[] bArr, byte[] bArr2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f2676a));
        return instance.doFinal(bArr);
    }

    public static byte[] m3326b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
