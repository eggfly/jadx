package com.xiaomi.mistatistic.sdk.controller;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.b */
public class C0549b {
    private static KeyGenerator f4703a;
    private static Cipher f4704b;

    static {
        try {
            f4703a = KeyGenerator.getInstance("AES");
            f4703a.init(128);
            f4704b = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] m6350b(String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(C0549b.m6349a(str2), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] bytes = str.getBytes("utf-8");
            instance.init(1, secretKeySpec);
            return instance.doFinal(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] m6349a(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public static String m6347a(String str, String str2) {
        return C0549b.m6348a(C0549b.m6350b(str, str2));
    }

    public static String m6348a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            while (toHexString.length() < 2) {
                toHexString = "0" + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }
}
