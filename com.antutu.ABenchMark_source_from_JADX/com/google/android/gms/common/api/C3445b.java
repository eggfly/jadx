package com.google.android.gms.common.api;

import anet.channel.util.HttpConstant;
import com.handmark.pulltorefresh.library.C3628R;
import com.viewpagerindicator.C4273R;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.common.api.b */
public class C3445b {
    public static String m14243a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STAGE_NOT_SEND /*-1*/:
                return "SUCCESS_CACHE";
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return HttpConstant.SUCCESS;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "SERVICE_MISSING";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "SERVICE_DISABLED";
            case SpdyProtocol.QUIC /*4*/:
                return "SIGN_IN_REQUIRED";
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return "INVALID_ACCOUNT";
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return "RESOLUTION_REQUIRED";
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return "NETWORK_ERROR";
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return "INTERNAL_ERROR";
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return "SERVICE_INVALID";
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return "DEVELOPER_ERROR";
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return "LICENSE_CHECK_FAILED";
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return "ERROR";
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return "INTERRUPTED";
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return "TIMEOUT";
            case SpdyProtocol.CUSTOM /*16*/:
                return "CANCELED";
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return "API_NOT_CONNECTED";
            case 3000:
                return "AUTH_API_INVALID_CREDENTIALS";
            case 3001:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case 3002:
                return "AUTH_API_CLIENT_ERROR";
            case 3003:
                return "AUTH_API_SERVER_ERROR";
            case 3004:
                return "AUTH_TOKEN_ERROR";
            case 3005:
                return "AUTH_URL_RESOLUTION";
            default:
                return "unknown status code: " + i;
        }
    }
}
