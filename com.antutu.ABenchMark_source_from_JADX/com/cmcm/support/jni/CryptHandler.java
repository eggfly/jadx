package com.cmcm.support.jni;

import com.cmcm.support.p118c.C2208a;

public class CryptHandler {
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            bArr3 = C2208a.m8284b(bArr2, bArr, bArr, CIPHER_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr3;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            bArr3 = C2208a.m8283a(bArr2, bArr, bArr, CIPHER_ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bArr3;
    }
}
