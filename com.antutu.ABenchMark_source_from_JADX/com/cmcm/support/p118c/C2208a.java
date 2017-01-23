package com.cmcm.support.p118c;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.cmcm.support.c.a */
public class C2208a {
    private static Key m8282a(byte[] bArr) {
        return new SecretKeySpec(bArr, "AES");
    }

    public static byte[] m8283a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        Cipher instance = Cipher.getInstance(str);
        instance.init(1, C2208a.m8282a(bArr2), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    public static byte[] m8284b(byte[] bArr, byte[] bArr2, byte[] bArr3, String str) {
        Cipher instance = Cipher.getInstance(str);
        instance.init(2, C2208a.m8282a(bArr2), new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }
}
