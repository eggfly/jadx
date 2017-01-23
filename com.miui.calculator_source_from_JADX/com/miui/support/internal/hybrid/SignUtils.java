package com.miui.support.internal.hybrid;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SignUtils {
    private SignUtils() {
    }

    public static PublicKey m4084a(KeySpec keySpec) {
        return KeyFactory.getInstance("RSA").generatePublic(keySpec);
    }

    public static PublicKey m4083a(String str, int i) {
        return m4084a(new X509EncodedKeySpec(Base64.decode(str, i)));
    }

    public static PublicKey m4082a(String str) {
        return m4083a(str, 0);
    }

    public static boolean m4087a(byte[] bArr, PublicKey publicKey, byte[] bArr2, String str) {
        Signature instance = Signature.getInstance(str);
        instance.initVerify(publicKey);
        instance.update(bArr);
        return instance.verify(bArr2);
    }

    public static boolean m4086a(String str, PublicKey publicKey, String str2, String str3) {
        return m4087a(str.getBytes(), publicKey, Base64.decode(str2, 2), str3);
    }

    public static boolean m4085a(String str, PublicKey publicKey, String str2) {
        return m4086a(str, publicKey, str2, "SHA1withRSA");
    }
}
