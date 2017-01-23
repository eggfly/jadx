package com.facebook.ads.internal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.facebook.ads.internal.util.n */
public class C2506n {

    /* renamed from: com.facebook.ads.internal.util.n.a */
    public enum C2505a {
        UNKNOWN(0),
        NONE(0),
        MOBILE_INTERNET(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4);
        
        public final int f8615g;

        private C2505a(int i) {
            this.f8615g = i;
        }
    }

    public static C2505a m9508a(Context context) {
        if (context.checkCallingOrSelfPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) != 0) {
            return C2505a.UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return C2505a.NONE;
        }
        if (activeNetworkInfo.getType() != 0) {
            return C2505a.MOBILE_INTERNET;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
            case SpdyProtocol.QUIC /*4*/:
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return C2505a.MOBILE_2G;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return C2505a.MOBILE_3G;
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return C2505a.MOBILE_4G;
            default:
                return C2505a.UNKNOWN;
        }
    }
}
