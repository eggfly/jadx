package com.xiaomi.stats;

import com.antutu.redacc.C1692R;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.thrift.C4452a;
import com.xiaomi.smack.C4462c;
import com.xiaomi.smack.C4477p;
import java.net.UnknownHostException;

/* renamed from: com.xiaomi.stats.d */
final class C4506d {

    /* renamed from: com.xiaomi.stats.d.a */
    static class C4505a {
        C4452a f15489a;
        String f15490b;

        C4505a() {
        }
    }

    static C4505a m18678a(Exception exception) {
        Throwable a;
        C4506d.m18682e(exception);
        if ((exception instanceof C4477p) && ((C4477p) exception).m18566a() != null) {
            a = ((C4477p) exception).m18566a();
        }
        C4505a c4505a = new C4505a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        message = a.getClass().getSimpleName() + ":" + message;
        int a2 = C4462c.m18486a(a);
        if (a2 != 0) {
            c4505a.f15489a = C4452a.m18406a(a2 + C4452a.GSLB_REQUEST_SUCCESS.m18407a());
        }
        if (c4505a.f15489a == null) {
            c4505a.f15489a = C4452a.GSLB_TCP_ERR_OTHER;
        }
        if (c4505a.f15489a == C4452a.GSLB_TCP_ERR_OTHER) {
            c4505a.f15490b = message;
        }
        return c4505a;
    }

    static C4505a m18679b(Exception exception) {
        Throwable a;
        C4506d.m18682e(exception);
        if ((exception instanceof C4477p) && ((C4477p) exception).m18566a() != null) {
            a = ((C4477p) exception).m18566a();
        }
        C4505a c4505a = new C4505a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        int a2 = C4462c.m18486a(a);
        message = a.getClass().getSimpleName() + ":" + message;
        if (a2 != 0) {
            c4505a.f15489a = C4452a.m18406a(a2 + C4452a.CONN_SUCCESS.m18407a());
            if (c4505a.f15489a == C4452a.CONN_BOSH_ERR) {
                Throwable cause = a.getCause();
                if (cause != null && (cause instanceof UnknownHostException)) {
                    c4505a.f15489a = C4452a.CONN_BOSH_UNKNOWNHOST;
                }
            }
        } else {
            c4505a.f15489a = C4452a.CONN_XMPP_ERR;
        }
        if (c4505a.f15489a == C4452a.CONN_TCP_ERR_OTHER || c4505a.f15489a == C4452a.CONN_XMPP_ERR || c4505a.f15489a == C4452a.CONN_BOSH_ERR) {
            c4505a.f15490b = message;
        }
        return c4505a;
    }

    static C4505a m18680c(Exception exception) {
        Throwable a;
        C4506d.m18682e(exception);
        if ((exception instanceof C4477p) && ((C4477p) exception).m18566a() != null) {
            a = ((C4477p) exception).m18566a();
        }
        C4505a c4505a = new C4505a();
        String message = a.getMessage();
        if (a.getCause() != null) {
            message = a.getCause().getMessage();
        }
        int a2 = C4462c.m18486a(a);
        String str = a.getClass().getSimpleName() + ":" + message;
        switch (a2) {
            case Constants.COMMAND_ELECTION /*105*/:
                c4505a.f15489a = C4452a.BIND_TCP_READ_TIMEOUT;
                break;
            case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                c4505a.f15489a = C4452a.BIND_TCP_CONNRESET;
                break;
            case C1692R.styleable.AppCompatTheme_spinnerStyle /*110*/:
                c4505a.f15489a = C4452a.BIND_TCP_BROKEN_PIPE;
                break;
            case 199:
                c4505a.f15489a = C4452a.BIND_TCP_ERR;
                break;
            case 499:
                c4505a.f15489a = C4452a.BIND_BOSH_ERR;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    c4505a.f15489a = C4452a.BIND_BOSH_ITEM_NOT_FOUND;
                    break;
                }
                break;
            default:
                c4505a.f15489a = C4452a.BIND_XMPP_ERR;
                break;
        }
        if (c4505a.f15489a == C4452a.BIND_TCP_ERR || c4505a.f15489a == C4452a.BIND_XMPP_ERR || c4505a.f15489a == C4452a.BIND_BOSH_ERR) {
            c4505a.f15490b = str;
        }
        return c4505a;
    }

    static C4505a m18681d(Exception exception) {
        Throwable a;
        C4506d.m18682e(exception);
        if ((exception instanceof C4477p) && ((C4477p) exception).m18566a() != null) {
            a = ((C4477p) exception).m18566a();
        }
        C4505a c4505a = new C4505a();
        String message = a.getMessage();
        int a2 = C4462c.m18486a(a);
        String str = a.getClass().getSimpleName() + ":" + message;
        switch (a2) {
            case Constants.COMMAND_ELECTION /*105*/:
                c4505a.f15489a = C4452a.CHANNEL_TCP_READTIMEOUT;
                break;
            case C1692R.styleable.AppCompatTheme_seekBarStyle /*109*/:
                c4505a.f15489a = C4452a.CHANNEL_TCP_CONNRESET;
                break;
            case C1692R.styleable.AppCompatTheme_spinnerStyle /*110*/:
                c4505a.f15489a = C4452a.CHANNEL_TCP_BROKEN_PIPE;
                break;
            case 199:
                c4505a.f15489a = C4452a.CHANNEL_TCP_ERR;
                break;
            case 499:
                c4505a.f15489a = C4452a.CHANNEL_BOSH_EXCEPTION;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    c4505a.f15489a = C4452a.CHANNEL_BOSH_ITEMNOTFIND;
                    break;
                }
                break;
            default:
                c4505a.f15489a = C4452a.CHANNEL_XMPPEXCEPTION;
                break;
        }
        if (c4505a.f15489a == C4452a.CHANNEL_TCP_ERR || c4505a.f15489a == C4452a.CHANNEL_XMPPEXCEPTION || c4505a.f15489a == C4452a.CHANNEL_BOSH_EXCEPTION) {
            c4505a.f15490b = str;
        }
        return c4505a;
    }

    private static void m18682e(Exception exception) {
        if (exception == null) {
            throw new NullPointerException();
        }
    }
}
