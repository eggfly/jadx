package com.igexin.push.p182d.p185c;

import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.igexin.p158b.p159a.p165d.C3665a;
import com.umeng.message.proguard.C4218e;
import com.umeng.message.util.HttpRequest;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.igexin.push.d.c.e */
public abstract class C3876e extends C3665a {
    public int f13034i;
    public byte f13035j;
    public byte f13036k;

    public C3876e() {
        this.f13036k = (byte) 11;
    }

    protected int m15944a(String str) {
        return str.equals(HttpRequest.f14548a) ? 1 : str.equals(C4218e.f14338c) ? 2 : str.equals(C4218e.f14339d) ? 16 : str.equals(C4218e.f14340e) ? 17 : str.equals("GBK") ? 25 : str.equals("GB2312") ? 26 : str.equals("GB18030") ? 27 : str.equals(C4218e.f14336a) ? 33 : 1;
    }

    protected String m15945a(byte b) {
        switch (b & 63) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return HttpRequest.f14548a;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return C4218e.f14338c;
            case SpdyProtocol.CUSTOM /*16*/:
                return C4218e.f14339d;
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return C4218e.f14340e;
            case C2279R.styleable.ActionBar_popupTheme /*25*/:
                return "GBK";
            case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                return "GB2312";
            case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                return "GB18030";
            case jni.SID_CPU_MULTI /*33*/:
                return C4218e.f14336a;
            default:
                return HttpRequest.f14548a;
        }
    }

    public abstract void m15946a(byte[] bArr);

    public int m15947b() {
        return this.f13034i;
    }

    public abstract byte[] m15948d();
}
