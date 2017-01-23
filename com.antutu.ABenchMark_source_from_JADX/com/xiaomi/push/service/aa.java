package com.xiaomi.push.service;

import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import com.viewpagerindicator.C4273R;
import com.xiaomi.mipush.sdk.Constants;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public abstract class aa {
    public static String f14974A;
    public static String f14975B;
    public static String f14976C;
    public static String f14977a;
    public static String f14978b;
    public static String f14979c;
    public static String f14980d;
    public static String f14981e;
    public static String f14982f;
    public static String f14983g;
    public static String f14984h;
    public static String f14985i;
    public static String f14986j;
    public static String f14987k;
    public static String f14988l;
    public static String f14989m;
    public static String f14990n;
    public static String f14991o;
    public static String f14992p;
    public static String f14993q;
    public static String f14994r;
    public static String f14995s;
    public static String f14996t;
    public static String f14997u;
    public static String f14998v;
    public static String f14999w;
    public static String f15000x;
    public static String f15001y;
    public static String f15002z;

    static {
        f14977a = MessageService.MSG_DB_NOTIFY_REACHED;
        f14978b = MessageService.MSG_DB_NOTIFY_CLICK;
        f14979c = MessageService.MSG_DB_NOTIFY_DISMISS;
        f14980d = "com.xiaomi.push.OPEN_CHANNEL";
        f14981e = "com.xiaomi.push.SEND_MESSAGE";
        f14982f = "com.xiaomi.push.SEND_IQ";
        f14983g = "com.xiaomi.push.BATCH_SEND_MESSAGE";
        f14984h = "com.xiaomi.push.SEND_PRES";
        f14985i = "com.xiaomi.push.CLOSE_CHANNEL";
        f14986j = "com.xiaomi.push.FORCE_RECONN";
        f14987k = "com.xiaomi.push.RESET_CONN";
        f14988l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
        f14989m = "com.xiaomi.push.SEND_STATS";
        f14990n = "com.xiaomi.push.CHANGE_HOST";
        f14991o = "com.xiaomi.push.PING_TIMER";
        f14992p = "ext_user_id";
        f14993q = "ext_chid";
        f14994r = "ext_sid";
        f14995s = "ext_token";
        f14996t = "ext_auth_method";
        f14997u = "ext_security";
        f14998v = "ext_kick";
        f14999w = "ext_client_attr";
        f15000x = "ext_cloud_attr";
        f15001y = "ext_pkg_name";
        f15002z = "ext_notify_id";
        f14974A = "ext_notify_type";
        f14975B = "ext_session";
        f14976C = "sig";
    }

    public static String m18107a(int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                return "ERROR_OK";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "ERROR_NETWORK_FAILED";
            case SpdyProtocol.QUIC /*4*/:
                return "ERROR_ACCESS_DENIED";
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                return "ERROR_AUTH_FAILED";
            case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                return "ERROR_MULTI_LOGIN";
            case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                return "ERROR_SERVER_ERROR";
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                return "ERROR_RECEIVE_TIMEOUT";
            case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                return "ERROR_READ_ERROR";
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                return "ERROR_SEND_ERROR";
            case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                return "ERROR_RESET";
            case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                return "ERROR_NO_CLIENT";
            case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                return "ERROR_SERVER_STREAM";
            case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                return "ERROR_THREAD_BLOCK";
            case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                return "ERROR_SERVICE_DESTROY";
            case SpdyProtocol.CUSTOM /*16*/:
                return "ERROR_SESSION_CHANGED";
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                return "ERROR_READ_TIMEOUT";
            case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                return "ERROR_CONNECTIING_TIMEOUT";
            case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                return "ERROR_USER_BLOCKED";
            case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                return "ERROR_REDIRECT";
            case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                return "ERROR_BIND_TIMEOUT";
            case C4209a.f14215r /*22*/:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i);
        }
    }
}
