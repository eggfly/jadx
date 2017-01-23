package com.p105c.p106a.p107a.p108a;

import com.xiaomi.pushsdk.BuildConfig;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.c.a.a.a.a */
public class C2084a {
    public static String m7789a(String str, String str2) {
        byte[] a;
        try {
            a = C2084a.m7793a(C2084a.m7795b(str.getBytes()), str2.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            a = null;
        }
        return a != null ? C2084a.m7790a(a) : null;
    }

    public static String m7790a(byte[] bArr) {
        if (bArr == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            C2084a.m7791a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    private static void m7791a(StringBuffer stringBuffer, byte b) {
        String str = "0123456789ABCDEF";
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }

    public static byte[] m7792a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    private static byte[] m7793a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance.doFinal(bArr2);
    }

    public static String m7794b(String str, String str2) {
        try {
            return new String(C2084a.m7796b(C2084a.m7795b(str.getBytes()), C2084a.m7792a(str2)));
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] m7795b(byte[] bArr) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        instance2.setSeed(bArr);
        instance.init(SpdyProtocol.SLIGHTSSLV2, instance2);
        return instance.generateKey().getEncoded();
    }

    private static byte[] m7796b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
        return instance.doFinal(bArr2);
    }
}
