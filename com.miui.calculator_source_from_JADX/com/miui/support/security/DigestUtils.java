package com.miui.support.security;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class DigestUtils {
    protected DigestUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static byte[] m5235a(CharSequence charSequence, String str) {
        return m5236a(charSequence.toString().getBytes(), str);
    }

    public static byte[] m5236a(byte[] bArr, String str) {
        try {
            return m5234a(new ByteArrayInputStream(bArr), str);
        } catch (Throwable e) {
            throw new RuntimeException("IO exception happend in ByteArrayInputStream", e);
        }
    }

    public static byte[] m5234a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    return instance.digest();
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        }
    }
}
