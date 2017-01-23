package com.google.android.gms.p146b;

import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.b.jm */
public final class jm {
    public static long m13559a(InputStream inputStream, OutputStream outputStream, boolean z) {
        return jm.m13560a(inputStream, outputStream, z, IXAdIOUtils.BUFFER_SIZE);
    }

    public static long m13560a(InputStream inputStream, OutputStream outputStream, boolean z, int i) {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    jm.m13561a((Closeable) inputStream);
                    jm.m13561a((Closeable) outputStream);
                }
            }
        }
        return j;
    }

    public static void m13561a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] m13562a(InputStream inputStream) {
        return jm.m13563a(inputStream, true);
    }

    public static byte[] m13563a(InputStream inputStream, boolean z) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jm.m13559a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
