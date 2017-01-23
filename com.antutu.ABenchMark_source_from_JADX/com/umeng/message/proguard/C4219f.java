package com.umeng.message.proguard;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.umeng.message.proguard.f */
public class C4219f {
    public static int f14342a;

    public static String m17254a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Inflater inflater = new Inflater();
        byte[] bArr2 = new byte[100];
        inflater.setInput(bArr, 0, bArr.length);
        StringBuilder stringBuilder = new StringBuilder();
        while (!inflater.needsInput()) {
            stringBuilder.append(new String(bArr2, 0, inflater.inflate(bArr2), str));
        }
        inflater.end();
        return stringBuilder.toString();
    }

    public static byte[] m17255a(String str, String str2) {
        Throwable th;
        if (C4230g.m17282d(str)) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(str.getBytes(str2));
        deflater.finish();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        f14342a = 0;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr);
                    f14342a += deflate;
                    byteArrayOutputStream.write(bArr, 0, deflate);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            deflater.end();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            byteArrayOutputStream = null;
            th = th4;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }
}
