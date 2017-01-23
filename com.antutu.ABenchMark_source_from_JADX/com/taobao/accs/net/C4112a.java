package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.HttpConstant;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.client.AccsConfig;
import com.taobao.accs.client.AccsConfig.SECURITY_TYPE;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.C4089a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.C4097b;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.Message.C4094b;
import com.taobao.accs.ut.statistics.C4132c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C4136b;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.LinkedHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.taobao.accs.net.a */
public abstract class C4112a {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;
    private static volatile C4112a f13755f;
    private static final byte[] f13756i;
    protected int f13757a;
    protected Context f13758b;
    protected C4097b f13759c;
    protected int f13760d;
    protected LinkedHashMap<Integer, Message> f13761e;
    private long f13762g;
    private volatile boolean f13763h;
    private Runnable f13764j;
    private ScheduledFuture<?> f13765k;

    static {
        f13755f = null;
        f13756i = new byte[0];
    }

    protected C4112a(Context context, int i) {
        this.f13760d = 0;
        this.f13762g = 0;
        this.f13763h = false;
        this.f13761e = new BaseConnection$1(this);
        this.f13757a = i;
        this.f13758b = context.getApplicationContext();
        this.f13759c = C4097b.m16732a(context);
        this.f13759c.f13692b = this.f13757a;
        C4089a.m16688a().schedule(new C4113b(this), 5000, TimeUnit.MILLISECONDS);
        m16808a(this.f13758b);
    }

    public static C4112a m16803a(Context context, int i) {
        if (f13755f == null || !f13755f.m16817b()) {
            synchronized (f13756i) {
                if (f13755f == null || !f13755f.m16817b()) {
                    if (i == 0) {
                        f13755f = new C4124l(context, i);
                    } else {
                        f13755f = new C4120i(context, i);
                    }
                }
            }
        }
        return f13755f;
    }

    public static String m16804a(Context context, String str) {
        String str2 = "https://" + (TextUtils.isEmpty(str) ? BuildConfig.FLAVOR : str) + AccsConfig.ACCS_CENTER_HOSTS[0];
        try {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder append = stringBuilder.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = BuildConfig.FLAVOR;
            }
            append.append(str);
            stringBuilder.append(AccsConfig.ACCS_CENTER_HOSTS[UtilityImpl.getMode(context)]);
            str2 = stringBuilder.toString();
        } catch (Throwable th) {
            ALog.m16902e("InAppConnection", "getHost", th, new Object[0]);
        }
        return str2;
    }

    public static String m16805b(Context context) {
        String str = AccsConfig.ACCS_CHANNEL_HOSTS[UtilityImpl.getMode(context)];
        ALog.m16904i("SpdyConnection", "getChannelHost:" + str, new Object[0]);
        return str == null ? BuildConfig.FLAVOR : str;
    }

    protected String m16806a(int i) {
        switch (i) {
            case INAPP /*1*/:
                return "CONNECTED";
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return "CONNECTING";
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                return "DISCONNECTED";
            case SpdyProtocol.QUIC /*4*/:
                return "DISCONNECTING";
            default:
                return "DISCONNECTED";
        }
    }

    public abstract void m16807a();

    protected void m16808a(Context context) {
        if (!this.f13763h) {
            try {
                ENV env = ENV.ONLINE;
                env = UtilityImpl.isDebugMode(context) ? ENV.TEST : UtilityImpl.isPreviewMode(context) ? ENV.PREPARE : ENV.ONLINE;
                if (AccsConfig.mSecurityType == SECURITY_TYPE.SECURITY_OFF) {
                    SessionCenter.init(context, UtilityImpl.getAppkey(context), UtilityImpl.getTtId(context), GlobalClientInfo.getInstance(this.f13758b).getAppSecret());
                } else {
                    SessionCenter.init(context, UtilityImpl.getAppkey(context));
                }
                SessionCenter.getInstance().switchEnv(env);
                ALog.m16904i(m16820e(), "init awcn success", new Object[0]);
                this.f13763h = true;
            } catch (Throwable th) {
                ALog.m16902e(m16820e(), "initAwcn", th, new Object[0]);
            }
        }
    }

    protected abstract void m16809a(Message message, boolean z);

    protected void m16810a(String str, long j) {
        C4089a.m16688a().schedule(new C4114c(this, str), j, TimeUnit.MILLISECONDS);
    }

    protected abstract void m16811a(String str, String str2);

    public abstract void m16812a(boolean z, boolean z2);

    protected boolean m16813a(Message message, int i) {
        Throwable th;
        boolean z = true;
        try {
            if (message.retryTimes > 3) {
                return false;
            }
            message.retryTimes += INAPP;
            message.delyTime = (long) i;
            ALog.m16903e(m16820e(), "reSend dataid:" + message.dataId + " retryTimes:" + message.retryTimes, new Object[0]);
            m16816b(message, true);
            try {
                if (message.getNetPermanceMonitor() == null) {
                    return true;
                }
                message.getNetPermanceMonitor().take_date = 0;
                message.getNetPermanceMonitor().to_tnet_date = 0;
                message.getNetPermanceMonitor().retry_times = message.retryTimes;
                if (message.retryTimes != INAPP) {
                    return true;
                }
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                return true;
            } catch (Throwable th2) {
                th = th2;
                this.f13759c.m16750a(message, -8);
                ALog.m16902e(m16820e(), "reSend error", th, new Object[0]);
                return z;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            this.f13759c.m16750a(message, -8);
            ALog.m16902e(m16820e(), "reSend error", th, new Object[0]);
            return z;
        }
    }

    public abstract boolean m16814a(String str);

    protected void m16815b(int i) {
        if (i < 0) {
            ALog.m16903e(m16820e(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i));
            Message message = (Message) this.f13761e.get(Integer.valueOf(i));
            if (message != null) {
                m16813a(message, (int) BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                C4136b.m16916a(AgooConstants.MESSAGE_SOURCE_ACCS, BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public void m16816b(Message message, boolean z) {
        if (message.isAck || UtilityImpl.isNetworkConnected(this.f13758b)) {
            long a = message.getType() != 2 ? this.f13759c.f13694d.m16768a(message.serviceId, message.bizId) : 0;
            if (a == -1) {
                ALog.m16903e(m16820e(), "servier limit high. dataId:" + message.dataId, new Object[0]);
                this.f13759c.m16750a(message, (int) ErrorCode.SERVIER_HIGH_LIMIT);
                return;
            } else if (a == -1000) {
                ALog.m16903e(m16820e(), "servier limit high for brush. dataId:" + message.dataId, new Object[0]);
                this.f13759c.m16750a(message, (int) ErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
                return;
            } else {
                if (a > 0) {
                    if (System.currentTimeMillis() > this.f13762g) {
                        message.delyTime = a;
                    } else {
                        message.delyTime = (a + this.f13762g) - System.currentTimeMillis();
                    }
                    this.f13762g = System.currentTimeMillis() + message.delyTime;
                    ALog.m16903e(m16820e(), "send message, " + C4094b.m16700b(message.getType()) + " delay:" + message.delyTime + " dataId:" + message.dataId, new Object[0]);
                } else if (ALog.isPrintLog(Level.D)) {
                    ALog.m16901d(m16820e(), "send message, " + C4094b.m16700b(message.getType()) + " delay:" + message.delyTime + " dataId:" + message.dataId, new Object[0]);
                }
                try {
                    if (message.isTimeOut()) {
                        this.f13759c.m16750a(message, -9);
                        return;
                    } else {
                        m16809a(message, z);
                        return;
                    }
                } catch (RejectedExecutionException e) {
                    this.f13759c.m16750a(message, (int) ErrorCode.MESSAGE_QUEUE_FULL);
                    ALog.m16903e(m16820e(), "msg queue full", "size", Integer.valueOf(C4089a.m16690b().getQueue().size()));
                    return;
                }
            }
        }
        ALog.m16903e(m16820e(), "no network:" + message.dataId, new Object[0]);
        this.f13759c.m16750a(message, -13);
    }

    public abstract boolean m16817b();

    public abstract void m16818c();

    public abstract C4132c m16819d();

    protected abstract String m16820e();

    public void m16821f() {
    }

    protected void m16822g() {
        if (this.f13764j == null) {
            this.f13764j = new C4115d(this);
        }
        m16823h();
        this.f13765k = C4089a.m16688a().schedule(this.f13764j, HttpConstant.RECV_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    protected void m16823h() {
        if (this.f13765k != null) {
            this.f13765k.cancel(true);
        }
    }
}
