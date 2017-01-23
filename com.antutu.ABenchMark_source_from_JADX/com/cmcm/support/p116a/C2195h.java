package com.cmcm.support.p116a;

import anet.channel.security.ISecurity;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.cmcm.support.a.h */
public class C2195h {
    protected static char[] f7591a;
    protected static MessageDigest f7592b;

    static {
        f7591a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f7592b = null;
        try {
            f7592b = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static String m8258a(byte[] bArr) {
        return C2195h.m8259a(bArr, 0, bArr.length);
    }

    private static String m8259a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            C2195h.m8260a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void m8260a(byte b, StringBuffer stringBuffer) {
        char c = f7591a[(b & 240) >> 4];
        char c2 = f7591a[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
