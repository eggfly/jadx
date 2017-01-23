package com.igexin.push.util;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import anet.channel.security.ISecurity;
import com.igexin.p158b.p159a.p160a.C3658a;
import com.igexin.p158b.p159a.p161b.C3687f;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.push.core.C3855g;
import com.igexin.push.extension.mod.SecurityUtils;
import com.igexin.push.p182d.p185c.C3878b;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.security.MessageDigest;

public class EncryptUtils {
    private static final String f13186a;
    private static boolean f13187b;
    private static int f13188c;
    private static byte[] f13189d;
    private static byte[] f13190e;
    public static String errorMsg;

    static {
        f13186a = EncryptUtils.class.getName();
        errorMsg = BuildConfig.FLAVOR;
        try {
            if (SecurityUtils.f13167b) {
                f13189d = initSocketAESKey();
                f13190e = initHttpAESKey();
                boolean z = (f13189d == null || f13190e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
                f13187b = z;
            }
        } catch (Throwable th) {
            C3688a.m15097b(f13186a + "|load so error = " + th.toString());
            f13187b = false;
            errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = SecurityUtils.f13168c;
        }
        if (f13187b) {
            C3688a.m15097b(f13186a + "|load so success ~~~~~~~");
            return;
        }
        C3688a.m15097b(f13186a + "|load so error ++++++++");
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = "value = null, normal error";
        }
    }

    public static byte[] aesDecHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16075c(f13190e, bArr, bArr2);
    }

    public static byte[] aesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16079g(f13189d, bArr, bArr2);
    }

    public static byte[] aesEncHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16074b(f13190e, bArr, bArr2);
    }

    public static byte[] aesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16078f(f13189d, bArr, bArr2);
    }

    public static byte[] altAesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16085m(bArr, bArr2);
    }

    public static byte[] altAesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m16084l(bArr, bArr2);
    }

    public static byte[] getBytesEncrypted(byte[] bArr) {
        return C3658a.m14938d(bArr, C3855g.f12939C);
    }

    public static byte[] getHttpAESKey() {
        return SecurityUtils.m16076d(f13190e);
    }

    public static String getHttpGTCV() {
        byte[] httpAESKey = getHttpAESKey();
        byte[] bytes = C3937p.m16190a(16).getBytes();
        byte[] bArr = new byte[(bytes.length + httpAESKey.length)];
        int a = C3687f.m15077a(bytes, 0, bArr, 0, bytes.length);
        int a2 = C3687f.m15077a(httpAESKey, 0, bArr, a, httpAESKey.length) + a;
        return C3929h.m16178b(bArr, 2);
    }

    public static String getHttpSignature(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        int a = C3687f.m15077a(bytes, 0, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            a += C3687f.m15077a(bArr, 0, bArr2, a, bArr.length);
        }
        return C3929h.m16178b(sha1(bArr2), 2);
    }

    public static byte[] getIV(byte[] bArr) {
        return md5(bArr);
    }

    public static int getPacketId() {
        int i = f13188c;
        f13188c = i + 1;
        return i;
    }

    public static byte[] getRSAKeyId() {
        return SecurityUtils.m16082j();
    }

    public static byte[] getSocketAESKey() {
        return SecurityUtils.m16080h(f13189d);
    }

    public static byte[] getSocketSignature(C3878b c3878b, int i, int i2) {
        byte[] bArr = new byte[(c3878b.f13044a + 11)];
        int a = C3687f.m15074a(i, bArr, 0);
        a += C3687f.m15074a(i2, bArr, a);
        a += C3687f.m15084b((short) c3878b.f13044a, bArr, a);
        a += C3687f.m15088c(c3878b.f13045b, bArr, a);
        a += C3687f.m15077a(c3878b.f13048e, 0, bArr, a, c3878b.f13044a);
        return sha1(bArr);
    }

    public static String getVersion() {
        byte[] k = SecurityUtils.m16083k();
        return k != null ? new String(k) : null;
    }

    public static byte[] initHttpAESKey() {
        return SecurityUtils.m16073a();
    }

    public static byte[] initSocketAESKey() {
        return SecurityUtils.m16077e();
    }

    public static boolean isLoadSuccess() {
        return f13187b;
    }

    public static byte[] md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean reset() {
        try {
            if (SecurityUtils.f13167b) {
                f13189d = initSocketAESKey();
                f13190e = initHttpAESKey();
                boolean z = (f13189d == null || f13190e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
                f13187b = z;
            }
        } catch (Throwable th) {
            C3688a.m15097b(f13186a + "|load so error = " + th.toString());
            f13187b = false;
        }
        if (f13187b) {
            C3688a.m15097b(f13186a + "|load so success ~~~~~~~");
        } else {
            C3688a.m15097b(f13186a + "|load so error ++++++++");
        }
        return f13187b;
    }

    public static byte[] rsaEnc(byte[] bArr) {
        int length = bArr.length;
        if (length <= 214) {
            return SecurityUtils.m16081i(bArr);
        }
        int i = length % Constants.COMMAND_HANDSHAKE == 0 ? length / Constants.COMMAND_HANDSHAKE : (length / Constants.COMMAND_HANDSHAKE) + 1;
        byte[] bArr2 = new byte[(i * AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 < i + -1 ? Constants.COMMAND_HANDSHAKE : length - (i2 * Constants.COMMAND_HANDSHAKE);
            byte[] bArr3 = new byte[i4];
            C3687f.m15077a(bArr, i2 * Constants.COMMAND_HANDSHAKE, bArr3, 0, i4);
            byte[] i5 = SecurityUtils.m16081i(bArr3);
            i3 += C3687f.m15077a(i5, 0, bArr2, i3, i5.length);
            i2++;
        }
        return bArr2;
    }

    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
