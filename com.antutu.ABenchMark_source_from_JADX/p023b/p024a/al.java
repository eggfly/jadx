package p023b.p024a;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.al */
public class al {
    public static int f2677a;

    public static byte[] m3327a(byte[] bArr) {
        Throwable th;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        f2677a = 0;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f2677a += deflate;
                    byteArrayOutputStream.write(bArr2, 0, deflate);
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
