package com.umeng.message.proguard;

import com.umeng.message.util.HttpRequest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.umeng.message.proguard.b */
public class C4215b {
    private static byte[] f14303a;
    private static byte[] f14304b;

    static {
        f14303a = "uLi4/f4+Pb39.T19".getBytes();
        f14304b = "nmeug.f9/Om+L823".getBytes();
    }

    public static String m17207a(String str) {
        String str2 = "uLi4/f4+Pb39.T19";
        if (str2 != null && str2.length() == 16) {
            f14303a = str2.getBytes();
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(f14303a, "AES"), new IvParameterSpec(f14304b));
        return C4217c.m17244d(instance.doFinal(str.getBytes(HttpRequest.f14548a)));
    }

    public static String m17208a(String str, String str2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(f14303a, "AES"), new IvParameterSpec(f14304b));
        return new String(instance.doFinal(C4217c.m17241b(str)), str2);
    }

    public static String m17209a(String... strArr) {
        String str;
        String str2;
        String str3 = null;
        if (strArr.length == 2) {
            str = strArr[0];
            str2 = strArr[1];
        } else if (strArr.length == 3) {
            str = strArr[0];
            str2 = strArr[1];
            str3 = strArr[2];
        } else {
            str2 = null;
            str = null;
        }
        if (str3 != null && str3.length() == 16) {
            f14303a = str3.getBytes();
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(f14303a, "AES"), new IvParameterSpec(f14304b));
        return C4217c.m17244d(instance.doFinal(str.getBytes(str2)));
    }

    public static String m17210b(String str, String str2) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec("uLi4/f4+Pb39.T19".getBytes(), "AES"), new IvParameterSpec(f14304b));
        return new String(instance.doFinal(C4217c.m17241b(str)), str2);
    }
}
