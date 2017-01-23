package com.xiaomi.market.sdk;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Coder {
    private static final String[] f4543a;

    static {
        f4543a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    static final String m6150a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return m6151a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final java.lang.String m6149a(java.io.File r6) {
        /*
        r0 = 0;
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0023 }
        r2.<init>(r6);	 Catch:{ FileNotFoundException -> 0x0023 }
        r3 = "MD5";
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ NoSuchAlgorithmException -> 0x001b, IOException -> 0x003e }
    L_0x0010:
        r4 = r2.read(r1);	 Catch:{ NoSuchAlgorithmException -> 0x001b, IOException -> 0x003e }
        if (r4 <= 0) goto L_0x0028;
    L_0x0016:
        r5 = 0;
        r3.update(r1, r5, r4);	 Catch:{ NoSuchAlgorithmException -> 0x001b, IOException -> 0x003e }
        goto L_0x0010;
    L_0x001b:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x004b }
        r2.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0022:
        return r0;
    L_0x0023:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x0028:
        r2.close();	 Catch:{ IOException -> 0x0034 }
    L_0x002b:
        r0 = r3.digest();
        r0 = m6151a(r0);
        goto L_0x0022;
    L_0x0034:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x002b;
    L_0x0039:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x003e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x004b }
        r2.close();	 Catch:{ IOException -> 0x0046 }
        goto L_0x0022;
    L_0x0046:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x004b:
        r0 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0050 }
    L_0x004f:
        throw r0;
    L_0x0050:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.market.sdk.Coder.a(java.io.File):java.lang.String");
    }

    private static String m6151a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a : bArr) {
            stringBuffer.append(m6148a(a));
        }
        return stringBuffer.toString();
    }

    private static String m6148a(byte b) {
        if (b < null) {
            b += 256;
        }
        return f4543a[b / 16] + f4543a[b % 16];
    }
}
