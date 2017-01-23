package p023b.p024a;

import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.bp */
public class bp {
    private static int f2790a;

    static {
        f2790a = Integer.MAX_VALUE;
    }

    public static void m3616a(bm bmVar, byte b) {
        bp.m3617a(bmVar, b, f2790a);
    }

    public static void m3617a(bm bmVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new ba("Maximum skip depth exceeded");
        }
        switch (b) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                bmVar.m3515p();
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                bmVar.m3516q();
            case SpdyProtocol.QUIC /*4*/:
                bmVar.m3520u();
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                bmVar.m3517r();
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                bmVar.m3518s();
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                bmVar.m3519t();
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                bmVar.m3522w();
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                bmVar.m3505f();
                while (true) {
                    bj h = bmVar.m3507h();
                    if (h.f2782b == null) {
                        bmVar.m3506g();
                        return;
                    } else {
                        bp.m3617a(bmVar, h.f2782b, i - 1);
                        bmVar.m3508i();
                    }
                }
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                bl j = bmVar.m3509j();
                while (i2 < j.f2788c) {
                    bp.m3617a(bmVar, j.f2786a, i - 1);
                    bp.m3617a(bmVar, j.f2787b, i - 1);
                    i2++;
                }
                bmVar.m3510k();
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                bq n = bmVar.m3513n();
                while (i2 < n.f2792b) {
                    bp.m3617a(bmVar, n.f2791a, i - 1);
                    i2++;
                }
                bmVar.m3514o();
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                bk l = bmVar.m3511l();
                while (i2 < l.f2785b) {
                    bp.m3617a(bmVar, l.f2784a, i - 1);
                    i2++;
                }
                bmVar.m3512m();
            default:
        }
    }
}
