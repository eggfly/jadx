package p023b.p024a;

import android.support.v4.view.MotionEventCompat;
import anet.channel.security.ISecurity;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.security.MessageDigest;

/* renamed from: b.a.an */
public class an {
    public static final String f2679a;

    static {
        f2679a = System.getProperty("line.separator");
    }

    public static String m3369a(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[IXAdIOUtils.BUFFER_SIZE];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static String m3370a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.reset();
            instance.update(bytes);
            bytes = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", BuildConfig.FLAVOR);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3371a(java.lang.String r5, int r6) {
        /*
        r0 = "";
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0044 }
        if (r1 != 0) goto L_0x0048;
    L_0x0008:
        r2 = 0;
        r1 = r5.length();	 Catch:{ Exception -> 0x0044 }
        if (r1 >= r6) goto L_0x0040;
    L_0x000f:
        r1 = r5.length();	 Catch:{ Exception -> 0x0044 }
    L_0x0013:
        r1 = r5.substring(r2, r1);	 Catch:{ Exception -> 0x0044 }
        r0 = "UTF-8";
        r0 = r1.getBytes(r0);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0049 }
        r2 = r6;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0022:
        if (r1 <= r6) goto L_0x0048;
    L_0x0024:
        r2 = r2 + -1;
        r3 = 0;
        r1 = r5.length();	 Catch:{ Exception -> 0x0044 }
        if (r2 <= r1) goto L_0x0042;
    L_0x002d:
        r1 = r5.length();	 Catch:{ Exception -> 0x0044 }
    L_0x0031:
        r1 = r5.substring(r3, r1);	 Catch:{ Exception -> 0x0044 }
        r0 = "UTF-8";
        r0 = r1.getBytes(r0);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0049 }
        r4 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0022;
    L_0x0040:
        r1 = r6;
        goto L_0x0013;
    L_0x0042:
        r1 = r2;
        goto L_0x0031;
    L_0x0044:
        r1 = move-exception;
    L_0x0045:
        p023b.p024a.ap.m3385a(r1);
    L_0x0048:
        return r0;
    L_0x0049:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.an.a(java.lang.String, int):java.lang.String");
    }

    public static void m3372a(File file, String str) {
        an.m3373a(file, str.getBytes());
    }

    public static void m3373a(File file, byte[] bArr) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            an.m3374a(fileOutputStream);
        }
    }

    public static void m3374a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static String m3375b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & MotionEventCompat.ACTION_MASK));
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            ap.m3387b("helper", "getMD5 error", e);
            return BuildConfig.FLAVOR;
        }
    }

    public static byte[] m3376b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[IXAdIOUtils.BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void m3377c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
