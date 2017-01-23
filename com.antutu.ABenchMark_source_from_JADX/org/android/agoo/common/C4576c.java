package org.android.agoo.common;

import anet.channel.security.ISecurity;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: org.android.agoo.common.c */
public final class C4576c {
    private static byte[] f16400a;
    private static ThreadLocal<Cipher> f16401b;
    private static final AlgorithmParameterSpec f16402c;
    private static final SecureRandom f16403d;

    static {
        f16400a = new byte[]{(byte) 82, (byte) 22, (byte) 50, (byte) 44, (byte) -16, (byte) 124, (byte) -40, (byte) -114, (byte) -87, (byte) -40, (byte) 37, (byte) 23, (byte) -56, (byte) 23, (byte) -33, (byte) 75};
        f16401b = new ThreadLocal();
        f16402c = new IvParameterSpec(f16400a);
        f16403d = new SecureRandom();
    }

    private static final Cipher m19252a() {
        Cipher cipher = (Cipher) f16401b.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                f16401b.set(cipher);
            } catch (Throwable e) {
                throw new RuntimeException("get Chipher error:" + e.getMessage(), e);
            } catch (Throwable e2) {
                throw new RuntimeException("get Chipher error:" + e2.getMessage(), e2);
            }
        }
        return cipher;
    }

    private static final Cipher m19253a(SecretKeySpec secretKeySpec, byte[] bArr, int i) {
        Cipher a = C4576c.m19252a();
        try {
            a.init(i, secretKeySpec, new IvParameterSpec(bArr), f16403d);
            return a;
        } catch (Throwable e) {
            throw new RuntimeException("init Chipher error:" + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new RuntimeException("init Chipher error:" + e2.getMessage(), e2);
        } catch (Throwable e22) {
            throw new RuntimeException("init Chipher error:" + e22.getMessage(), e22);
        }
    }

    public static byte[] m19254a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static final byte[] m19255a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("md5 value Throwable", th);
        }
    }

    public static final byte[] m19256a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2) {
        try {
            return C4576c.m19253a(secretKeySpec, bArr2, 2).doFinal(bArr);
        } catch (Throwable e) {
            throw new IllegalArgumentException("AES decrypt error:" + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("AES decrypt error:" + e2.getMessage(), e2);
        }
    }

    public static byte[] m19257a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            return instance.doFinal(bArr2);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("HmacSHA1 Throwable", th);
        }
    }
}
