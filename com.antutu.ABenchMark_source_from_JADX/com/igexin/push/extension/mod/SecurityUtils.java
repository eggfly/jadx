package com.igexin.push.extension.mod;

import com.igexin.p156a.C3650c;
import com.igexin.p158b.p159a.p167c.C3688a;
import com.igexin.sdk.PushService;
import com.xiaomi.pushsdk.BuildConfig;

public class SecurityUtils {
    public static final String f13166a;
    public static boolean f13167b;
    public static String f13168c;

    static {
        f13166a = SecurityUtils.class.getName();
        f13168c = BuildConfig.FLAVOR;
        try {
            C3688a.m15097b(f13166a + "|load so by system start #######");
            System.loadLibrary("getuiext2");
            f13167b = true;
            C3688a.m15097b(f13166a + "|load so by system success ^_^");
        } catch (UnsatisfiedLinkError e) {
            C3688a.m15097b(f13166a + "|load so by system error = " + e.getMessage());
            f13168c = e.getMessage() + " + ";
            C3688a.m15097b(f13166a + "|load so by new start !!");
            if (PushService.context == null) {
                C3688a.m15097b(f13166a + "|load so by new context = null ~~~~");
                f13167b = false;
                f13168c = e.getMessage();
                return;
            }
            C3650c.m14906a(null).m14916a().m14924b().m14921a(PushService.context, "getuiext2", null, new C3911a());
        } catch (Throwable th) {
            C3688a.m15097b(f13166a + "|load so error not UnsatisfiedLinkError");
            C3688a.m15097b(f13166a + "|load so error e = " + th.getMessage());
            f13167b = false;
            f13168c += th.toString() + " + " + th.getMessage();
        }
    }

    public static native byte[] m16073a();

    public static native byte[] m16074b(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] m16075c(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] m16076d(byte[] bArr);

    public static native byte[] m16077e();

    public static native byte[] m16078f(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] m16079g(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] m16080h(byte[] bArr);

    public static native byte[] m16081i(byte[] bArr);

    public static native byte[] m16082j();

    public static native byte[] m16083k();

    public static native byte[] m16084l(byte[] bArr, byte[] bArr2);

    public static native byte[] m16085m(byte[] bArr, byte[] bArr2);
}
