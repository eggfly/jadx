package anet.channel.session;

import android.content.Context;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.Session.Status;
import anet.channel.entity.C0666a;
import anet.channel.entity.ConnType;
import anet.channel.p019c.C0660c;
import anet.channel.request.Cancelable;
import anet.channel.request.FutureCancelable;
import anet.channel.request.Request;
import anet.channel.request.Request.Builder;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.C0734n;
import anet.channel.util.ALog;
import anet.channel.util.C0746g;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.internal.C4103b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: anet.channel.session.e */
public class C0692e extends Session {
    public static Set<String> f2274a;

    static {
        f2274a = new HashSet();
    }

    public C0692e(Context context, C0666a c0666a) {
        super(context, c0666a, c0666a.m2799c());
        if (this.mConnStrategy == null) {
            ConnType connType = (this.mHost == null || !this.mHost.startsWith(HttpConstant.HTTPS)) ? ConnType.HTTP : ConnType.HTTPS;
            this.mConnType = connType;
        }
    }

    public static boolean m2829a(String str, String str2, int i) {
        return f2274a.contains(StringUtils.buildString(str, str2, String.valueOf(i)));
    }

    public void close() {
        notifyStatus(Status.DISCONNECTED, null);
    }

    public void close(boolean z) {
        this.autoReCreate = false;
        close();
    }

    protected void connect() {
        try {
            ALog.m2963i("awcn.HttpSession", "HttpSession connect", null, C4103b.ELECTION_KEY_HOST, this.mHost);
            Request build = new Builder().setUrl(this.mHost).build();
            build.setDnsOptimize(this.mIp, this.mPort);
            C0660c.m2784a(new C0693f(this, build), 7);
        } catch (Throwable th) {
            ALog.m2961e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    protected Runnable getRecvTimeOutRunnable() {
        return null;
    }

    public boolean isAvailable() {
        return this.mStatus == Status.AUTH_SUCC;
    }

    public void ping(boolean z) {
    }

    public Cancelable request(Request request, RequestCb requestCb) {
        FutureCancelable futureCancelable = FutureCancelable.NULL;
        RequestStatistic requestStatistic = request != null ? request.rs : new RequestStatistic(C0734n.m2957e(this.mHost), null);
        requestStatistic.setConnType(this.mConnType);
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), requestStatistic);
            }
            return futureCancelable;
        }
        try {
            request.setDnsOptimize(this.mIp, this.mPort);
            requestStatistic.start = System.currentTimeMillis();
            return new FutureCancelable(C0660c.m2784a(new C0694g(this, request, requestCb), C0746g.m2983a(request.getUrl())), request.getSeq());
        } catch (Throwable th) {
            if (requestCb != null) {
                requestCb.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, th.toString()), requestStatistic);
            }
            return futureCancelable;
        }
    }
}
