package com.qq.p035e.comm.net.rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import com.qq.p035e.comm.C4048a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.qq.e.comm.net.rr.a */
public final class C4063a {
    private static final byte[] f13534a;
    private static Cipher f13535b;
    private static Cipher f13536c;
    private static byte[] f13537d;

    /* renamed from: com.qq.e.comm.net.rr.a.a */
    static class C4061a extends Exception {
        public C4061a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.qq.e.comm.net.rr.a.b */
    public static class C4062b extends Exception {
        public C4062b(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        f13534a = new byte[]{(byte) 91, (byte) -62};
        f13535b = null;
        f13536c = null;
        f13537d = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized Cipher m16585a() {
        Cipher cipher;
        synchronized (C4063a.class) {
            if (f13535b != null) {
                cipher = f13535b;
            } else {
                try {
                    cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                    cipher.init(1, new SecretKeySpec(f13537d, "AES"));
                    f13535b = cipher;
                    cipher = f13535b;
                } catch (Throwable e) {
                    throw new C4061a("Fail To Init Cipher", e);
                }
            }
        }
        return cipher;
    }

    public static byte[] m16586a(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f13534a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(C4063a.m16589c(C4048a.m16541a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new C4062b("Exception while packaging byte array", e);
        }
    }

    private static synchronized Cipher m16587b() {
        Cipher cipher;
        synchronized (C4063a.class) {
            if (f13536c != null) {
                cipher = f13536c;
            } else {
                try {
                    cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                    cipher.init(2, new SecretKeySpec(f13537d, "AES"));
                    f13536c = cipher;
                    cipher = f13536c;
                } catch (Throwable e) {
                    throw new C4061a("Fail To Init Cipher", e);
                }
            }
        }
        return cipher;
    }

    @TargetApi(9)
    public static byte[] m16588b(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            throw new C4062b("S2SS Package FormatError", null);
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[4];
            dataInputStream.read(bArr2);
            if (f13534a[0] == bArr2[0] && f13534a[1] == bArr2[1] && 1 == bArr2[2] && 2 == bArr2[3]) {
                return C4048a.m16544b(C4063a.m16590d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new C4062b("S2SS Package Magic/Version FormatError", null);
        } catch (Throwable e) {
            throw new C4062b("Exception while packaging byte array", e);
        }
    }

    private static byte[] m16589c(byte[] bArr) {
        try {
            return C4063a.m16585a().doFinal(bArr);
        } catch (Throwable e) {
            throw new C4061a("Exception While encrypt byte array", e);
        }
    }

    private static byte[] m16590d(byte[] bArr) {
        try {
            return C4063a.m16587b().doFinal(bArr);
        } catch (Throwable e) {
            throw new C4061a("Exception While dencrypt byte array", e);
        }
    }
}
