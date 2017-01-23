package org.apache.thrift.protocol;

import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4597f;

/* renamed from: org.apache.thrift.protocol.h */
public class C4613h {
    private static int f16484a;

    static {
        f16484a = Integer.MAX_VALUE;
    }

    public static void m19377a(C4607e c4607e, byte b) {
        C4613h.m19378a(c4607e, b, f16484a);
    }

    public static void m19378a(C4607e c4607e, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new C4597f("Maximum skip depth exceeded");
        }
        switch (b) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                c4607e.m19330p();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                c4607e.m19331q();
            case SpdyProtocol.QUIC /*4*/:
                c4607e.m19335u();
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                c4607e.m19332r();
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                c4607e.m19333s();
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                c4607e.m19334t();
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                c4607e.m19337w();
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                c4607e.m19320f();
                while (true) {
                    C4609b h = c4607e.m19322h();
                    if (h.f16476b == null) {
                        c4607e.m19321g();
                        return;
                    } else {
                        C4613h.m19378a(c4607e, h.f16476b, i - 1);
                        c4607e.m19323i();
                    }
                }
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                C4611d j = c4607e.m19324j();
                while (i2 < j.f16482c) {
                    C4613h.m19378a(c4607e, j.f16480a, i - 1);
                    C4613h.m19378a(c4607e, j.f16481b, i - 1);
                    i2++;
                }
                c4607e.m19325k();
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                C4614i n = c4607e.m19328n();
                while (i2 < n.f16486b) {
                    C4613h.m19378a(c4607e, n.f16485a, i - 1);
                    i2++;
                }
                c4607e.m19329o();
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                C4610c l = c4607e.m19326l();
                while (i2 < l.f16479b) {
                    C4613h.m19378a(c4607e, l.f16478a, i - 1);
                    i2++;
                }
                c4607e.m19327m();
            default:
        }
    }
}
