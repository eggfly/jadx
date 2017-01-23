package com.igexin.push.util;

import com.umeng.message.proguard.C4218e;
import java.io.UnsupportedEncodingException;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.igexin.push.util.h */
public class C3929h {
    static final /* synthetic */ boolean f13197a;

    static {
        f13197a = !C3929h.class.desiredAssertionStatus();
    }

    private C3929h() {
    }

    public static byte[] m16176a(byte[] bArr, int i) {
        return C3929h.m16177a(bArr, 0, bArr.length, i);
    }

    public static byte[] m16177a(byte[] bArr, int i, int i2, int i3) {
        C3931j c3931j = new C3931j(i3, new byte[((i2 * 3) / 4)]);
        if (!c3931j.m16181a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c3931j.b == c3931j.a.length) {
            return c3931j.a;
        } else {
            Object obj = new byte[c3931j.b];
            System.arraycopy(c3931j.a, 0, obj, 0, c3931j.b);
            return obj;
        }
    }

    public static String m16178b(byte[] bArr, int i) {
        try {
            return new String(C3929h.m16180c(bArr, i), C4218e.f14337b);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] m16179b(byte[] bArr, int i, int i2, int i3) {
        C3932k c3932k = new C3932k(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c3932k.f13209d) {
            switch (i2 % 3) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    i4 += 2;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c3932k.f13210e && i2 > 0) {
            i4 += (c3932k.f13211f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c3932k.a = new byte[i4];
        c3932k.m16182a(bArr, i, i2, true);
        if (f13197a || c3932k.b == i4) {
            return c3932k.a;
        }
        throw new AssertionError();
    }

    public static byte[] m16180c(byte[] bArr, int i) {
        return C3929h.m16179b(bArr, 0, bArr.length, i);
    }
}
