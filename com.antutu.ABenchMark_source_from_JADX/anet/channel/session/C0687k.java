package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.Session.Status;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0666a;
import anet.channel.entity.C0667d;
import anet.channel.entity.C0668b;
import anet.channel.entity.C0669c;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.monitor.C0676a;
import anet.channel.p017a.C0644a;
import anet.channel.p017a.C0646b.C0645a;
import anet.channel.p018b.C0653b;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.request.TnetCancelable;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0734n;
import anet.channel.util.ALog;
import anet.channel.util.C0739d;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.taobao.accs.internal.C4103b;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import org.android.spdy.TnetStatusCode;

/* renamed from: anet.channel.session.k */
public abstract class C0687k extends Session implements SessionCb {
    private static final String TAG = "awcn.TnetSpdySession";
    protected SpdyAgent mAgent;
    protected long mConnectedTime;
    protected volatile boolean mHasUnrevPing;
    protected long mLastPingTime;
    protected SpdySession mSession;
    private int requestTimeoutCount;

    /* renamed from: anet.channel.session.k.a */
    private class C0698a extends C0685b {
        final /* synthetic */ C0687k f2283a;
        private Request f2284b;
        private RequestCb f2285c;
        private long f2286d;
        private long f2287e;
        private long f2288f;

        public C0698a(C0687k c0687k, Request request, RequestCb requestCb) {
            this.f2283a = c0687k;
            this.f2286d = 0;
            this.f2287e = 0;
            this.f2288f = 0;
            this.f2284b = request;
            this.f2285c = requestCb;
            this.f2286d = System.currentTimeMillis();
        }

        private void m2838a(SuperviseData superviseData) {
            long j = 0;
            try {
                if (this.f2287e > 0 && this.f2286d > 0) {
                    this.f2284b.rs.serverRT = this.f2288f;
                    RequestStatistic requestStatistic = this.f2284b.rs;
                    if (this.f2284b.rs.firstDataTime != 0) {
                        j = this.f2287e - this.f2284b.rs.firstDataTime;
                    }
                    requestStatistic.recDataTime = j;
                    this.f2284b.rs.waitingTime = this.f2287e - this.f2286d;
                    if (superviseData != null) {
                        this.f2284b.rs.firstDataTime = superviseData.responseStart - superviseData.sendStart;
                        this.f2284b.rs.oneWayTime = superviseData.responseEnd - superviseData.sendStart;
                        this.f2284b.rs.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                        this.f2284b.rs.sendBeforeTime = superviseData.sendStart - this.f2286d;
                        this.f2284b.rs.sendDataTime = superviseData.sendEnd - superviseData.sendStart;
                        this.f2284b.rs.sendDataSize = (long) (superviseData.bodySize + superviseData.compressSize);
                        this.f2284b.rs.recDataSize = (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                        SessionStatistic sessionStatistic = this.f2283a.mSessionStat;
                        sessionStatistic.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                        sessionStatistic = this.f2283a.mSessionStat;
                        sessionStatistic.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                    }
                }
            } catch (Exception e) {
            }
        }

        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
            ALog.m2960d(C0687k.TAG, "spdyDataChunkRecvCB", this.f2283a.mSeq, "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            if (this.f2285c != null) {
                C0644a a = C0645a.f2174a.m2764a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f2285c.onDataReceive(a, z);
            }
            this.f2283a.handleCallbacks(EventType.DATA_RECEIVE, null);
        }

        public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(C0739d.m2973b(map, HttpConstant.STATUS));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            if (parseInt > 0) {
                this.f2284b.rs.ret = true;
                this.f2283a.requestTimeoutCount = 0;
            }
            ALog.m2960d(C0687k.TAG, "spdyOnStreamResponse", this.f2283a.mSeq, "httpStatusCode:", Integer.valueOf(parseInt));
            if (this.f2285c != null) {
                this.f2285c.onResponseCode(parseInt, C0739d.m2969a((Map) map));
            }
            this.f2283a.handleCallbacks(EventType.HEADER_RECEIVE, null);
            try {
                this.f2288f = Long.parseLong(C0739d.m2973b(map, "s-rt"));
            } catch (NumberFormatException e2) {
            }
            if (C0734n.m2955c(C0734n.m2957e(this.f2283a.mHost))) {
                C0653b.m2767a().m2769a(0, Integer.valueOf(parseInt));
            }
        }

        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
            ALog.m2960d(C0687k.TAG, "spdyStreamCloseCallback", this.f2283a.mSeq, "streamId", Long.valueOf(j));
            this.f2287e = System.currentTimeMillis();
            m2838a(superviseData);
            String str = HttpConstant.SUCCESS;
            if (i != 0) {
                if (i != TnetStatusCode.EASY_REASON_CANCEL) {
                    str = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, "statusCode=" + i);
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, str, this.f2284b.rs, null));
                }
                ALog.m2962e(C0687k.TAG, "spdyStreamCloseCallback error", this.f2283a.mSeq, "status code", Integer.valueOf(i));
            }
            if (this.f2285c != null) {
                this.f2285c.onFinish(i, str, this.f2284b.rs);
            }
            if (i == TnetStatusCode.EASY_REASON_SESSION_TIMEOUT) {
                if (C0687k.access$504(this.f2283a) >= (C0676a.m2806a().m2812b() == 1 ? 3 : 2)) {
                    this.f2283a.close(true);
                }
            }
            if (i <= TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR && i > -4000) {
                C0653b.m2767a().m2769a(3, this.f2284b.getHost());
            }
        }
    }

    public C0687k(Context context, C0666a c0666a, ConnType connType) {
        super(context, c0666a, connType);
        this.mHasUnrevPing = false;
        this.mConnectedTime = 0;
        this.requestTimeoutCount = 0;
        init();
    }

    static /* synthetic */ int access$504(C0687k c0687k) {
        int i = c0687k.requestTimeoutCount + 1;
        c0687k.requestTimeoutCount = i;
        return i;
    }

    private void init() {
        try {
            SpdyAgent.enableDebug = false;
            this.mAgent = SpdyAgent.getInstance(this.mContext, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            this.mAgent.setAccsSslCallback(new C0699l(this));
        } catch (Throwable e) {
            ALog.m2961e(TAG, "Init failed.", null, e, new Object[0]);
        }
    }

    protected void auth() {
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i) {
        if (ALog.isPrintLog(2)) {
            ALog.m2963i(TAG, this.mHost + " ping receive " + i, this.mSeq, new Object[0]);
        }
    }

    public void close() {
        ALog.m2962e(TAG, "force close!", this.mSeq, "session", this);
        notifyStatus(Status.DISCONNECTING, null);
        try {
            if (this.mSession != null) {
                this.mSession.closeSession();
            }
        } catch (Exception e) {
        }
    }

    protected void connect() {
        if (this.mStatus != Status.CONNECTING && this.mStatus != Status.CONNECTED && this.mStatus != Status.AUTH_SUCC) {
            try {
                if (this.mAgent != null) {
                    ALog.m2962e(TAG, "[connect]", this.mSeq, C4103b.ELECTION_KEY_HOST, this.mHost, "connect ", this.mIp + ":" + this.mPort, "sessionId", String.valueOf(System.currentTimeMillis()), "SpdyProtocol,", this.mConnType.toProtocol(), "proxyIp,", this.mProxyIp, "proxyPort,", Integer.valueOf(this.mProxyPort));
                    SessionInfo sessionInfo = new SessionInfo(this.mIp, this.mPort, this.mHost, this.mProxyIp, this.mProxyPort, r6, this, this.mConnType.getTnetConType());
                    sessionInfo.setConnectionTimeoutMs(this.mConnTimeout);
                    sessionInfo.setPubKeySeqNum(this.mConnType.getTnetPublicKey());
                    this.mSession = this.mAgent.createSession(sessionInfo);
                    if (this.mSession.getRefCount() > 1) {
                        ALog.m2962e(TAG, "get session ref count > 1!!!", this.mSeq, new Object[0]);
                        notifyStatus(Status.CONNECTED, new C0668b(EventType.CONNECTED));
                        auth();
                        return;
                    }
                    notifyStatus(Status.CONNECTING, null);
                    this.mLastPingTime = System.currentTimeMillis();
                    this.mSessionStat.isProxy = (!TextUtils.isEmpty(this.mProxyIp)) + BuildConfig.FLAVOR;
                    this.mSessionStat.isTunnel = "false";
                    this.mSessionStat.isBackground = GlobalAppRuntimeInfo.isAppBackground();
                    this.mConnectedTime = 0;
                }
            } catch (Throwable th) {
                notifyStatus(Status.CONNETFAIL, null);
                ALog.m2961e(TAG, "connect exception ", this.mSeq, th, new Object[0]);
            }
        }
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        return Utils.SecurityGuardGetSslTicket2(this.mContext, spdySession.getDomain());
    }

    public boolean isAvailable() {
        return this.mStatus == Status.AUTH_SUCC;
    }

    protected void onDisconnect() {
        this.mHasUnrevPing = false;
    }

    public void ping(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.m2960d(TAG, "ping", this.mSeq, C4103b.ELECTION_KEY_HOST, this.mHost, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.mSession == null) {
                    if (this.mSessionStat != null) {
                        this.mSessionStat.closeReason = "session null";
                    }
                    ALog.m2962e(TAG, this.mHost + " session null", this.mSeq, new Object[0]);
                    close();
                } else if (this.mStatus == Status.CONNECTED || this.mStatus == Status.AUTH_SUCC) {
                    handleCallbacks(EventType.PING_SEND, null);
                    this.mHasUnrevPing = true;
                    SessionStatistic sessionStatistic = this.mSessionStat;
                    sessionStatistic.ppkgCount++;
                    this.mSession.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.m2960d(TAG, this.mHost + " submit ping ms:" + (System.currentTimeMillis() - this.mLastPingTime) + " force:" + z, this.mSeq, new Object[0]);
                    }
                    setPingTimeout();
                    this.mLastPingTime = System.currentTimeMillis();
                }
            } catch (Throwable e) {
                ALog.m2961e(TAG, "ping", this.mSeq, e, new Object[0]);
            }
        }
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return Utils.SecurityGuardPutSslTicket2(this.mContext, spdySession.getDomain(), bArr);
    }

    public Cancelable request(Request request, RequestCb requestCb) {
        Cancelable tnetCancelable;
        SpdyErrorException e;
        Exception e2;
        TnetCancelable tnetCancelable2 = TnetCancelable.NULL;
        RequestStatistic requestStatistic = request != null ? request.rs : new RequestStatistic(C0734n.m2957e(this.mHost), null);
        requestStatistic.setConnType(this.mConnType);
        requestStatistic.setIPAndPort(this.mIp, this.mPort);
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), requestStatistic);
            }
            return tnetCancelable2;
        }
        try {
            if (this.mSession == null || !isAvailable()) {
                requestCb.onFinish(ErrorConstant.ERROR_SESSION_INVALID, "Session\u4e0d\u53ef\u7528", request.rs);
                return tnetCancelable2;
            }
            requestStatistic.start = System.currentTimeMillis();
            request.addHeader(":host", request.getHost());
            if (ALog.isPrintLog(2)) {
                ALog.m2963i(TAG, BuildConfig.FLAVOR, request.getSeq(), "request URL", request.getUrlString());
                ALog.m2963i(TAG, BuildConfig.FLAVOR, request.getSeq(), "request headers", request.getHeaders());
            }
            URL url = request.getUrl();
            SpdyRequest spdyRequest = (TextUtils.isEmpty(this.mProxyIp) || this.mProxyPort <= 0) ? new SpdyRequest(url, request.getMethod().toString(), RequestPriority.DEFAULT_PRIORITY, request.getReadTimeout(), request.getConnectTimeout()) : new SpdyRequest(url, url.getHost(), url.getPort(), this.mProxyIp, this.mProxyPort, request.getMethod().toString(), RequestPriority.DEFAULT_PRIORITY, request.getReadTimeout(), request.getConnectTimeout(), 0);
            spdyRequest.addHeaders(request.getHeaders());
            int submitRequest = this.mSession.submitRequest(spdyRequest, new SpdyDataProvider(request.getBody()), this, new C0698a(this, request, requestCb));
            if (ALog.isPrintLog(1)) {
                ALog.m2960d(TAG, BuildConfig.FLAVOR, request.getSeq(), "streamId", Integer.valueOf(submitRequest));
            }
            tnetCancelable = new TnetCancelable(this.mSession, submitRequest, request.getSeq());
            try {
                SessionStatistic sessionStatistic = this.mSessionStat;
                sessionStatistic.requestCount++;
                sessionStatistic = this.mSessionStat;
                sessionStatistic.stdRCount++;
                this.mLastPingTime = System.currentTimeMillis();
                return tnetCancelable;
            } catch (SpdyErrorException e3) {
                e = e3;
                if (e.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE || e.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_STATUS_ERR) {
                    ALog.m2962e(TAG, "Send request on closed session!!!", this.mSeq, new Object[0]);
                    notifyStatus(Status.DISCONNECTED, new C0669c(EventType.DISCONNECTED, false, TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE, "Session is closed!"));
                }
                requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, e.toString()), requestStatistic);
                return tnetCancelable;
            } catch (Exception e4) {
                e2 = e4;
                requestCb.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, e2.toString()), requestStatistic);
                return tnetCancelable;
            }
        } catch (SpdyErrorException e5) {
            e = e5;
            Object obj = tnetCancelable2;
            ALog.m2962e(TAG, "Send request on closed session!!!", this.mSeq, new Object[0]);
            notifyStatus(Status.DISCONNECTED, new C0669c(EventType.DISCONNECTED, false, TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE, "Session is closed!"));
            requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, e.toString()), requestStatistic);
            return tnetCancelable;
        } catch (Exception e6) {
            e2 = e6;
            tnetCancelable = tnetCancelable2;
            requestCb.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, e2.toString()), requestStatistic);
            return tnetCancelable;
        }
    }

    public void sendCustomFrame(int i, byte[] bArr, int i2) {
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.m2963i(TAG, "ping receive", this.mSeq, HttpConstant.HOST, this.mHost, AgooConstants.MESSAGE_ID, Long.valueOf(j));
        }
        if (j >= 0) {
            this.mHasUnrevPing = false;
            handleCallbacks(EventType.PIND_RECEIVE, null);
        }
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.m2962e(TAG, "spdySessionCloseCallback", this.mSeq, " errorCode:", Integer.valueOf(i));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Throwable e) {
                ALog.m2961e(TAG, "[spdySessionCloseCallback]session clean up failed!", null, e, new Object[0]);
            }
        }
        notifyStatus(Status.DISCONNECTED, new C0669c(EventType.DISCONNECTED, false, i, TextUtils.isEmpty(this.mSessionStat.closeReason) ? "tnet close error:" + i : this.mSessionStat.closeReason + ":" + this.mSessionStat.errorCode));
        if (superviseConnectInfo != null) {
            this.mSessionStat.requestCount = (long) superviseConnectInfo.reused_counter;
            this.mSessionStat.liveTime = (long) superviseConnectInfo.keepalive_period_second;
        }
        if (this.mSessionStat.errorCode == 0) {
            this.mSessionStat.errorCode = (long) i;
        }
        this.mSessionStat.lastPingInterval = (int) (System.currentTimeMillis() - this.mLastPingTime);
        if (!this.isHorseRide) {
            AppMonitor.getInstance().commitStat(this.mSessionStat);
            AppMonitor.getInstance().commitAlarm(this.mSessionStat.getAlarmObject());
        }
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        C0667d c0668b = new C0668b(EventType.CONNECTED);
        c0668b.f2220a = (long) superviseConnectInfo.connectTime;
        c0668b.f2221b = (long) superviseConnectInfo.handshakeTime;
        this.mSessionStat.connectionTime = (long) superviseConnectInfo.connectTime;
        this.mSessionStat.sslTime = (long) superviseConnectInfo.handshakeTime;
        this.mSessionStat.sslCalTime = (long) superviseConnectInfo.doHandshakeTime;
        this.mSessionStat.netType = NetworkStatusHelper.m2843b();
        this.mConnectedTime = System.currentTimeMillis();
        notifyStatus(Status.CONNECTED, c0668b);
        auth();
        ALog.m2962e(TAG, "spdySessionConnectCB connect", this.mSeq, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime:", Integer.valueOf(superviseConnectInfo.handshakeTime));
    }

    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Throwable e) {
                ALog.m2961e(TAG, "[spdySessionFailedError]session clean up failed!", null, e, new Object[0]);
            }
        }
        notifyStatus(Status.CONNETFAIL, new C0667d(EventType.CONNECT_FAIL, i, "tnet connect fail"));
        ALog.m2962e(TAG, null, this.mSeq, " errorId:", Integer.valueOf(i));
        this.mSessionStat.errorCode = (long) i;
        this.mSessionStat.ret = 0;
        this.mSessionStat.netType = NetworkStatusHelper.m2843b();
        if (!this.isHorseRide) {
            AppMonitor.getInstance().commitStat(this.mSessionStat);
            AppMonitor.getInstance().commitAlarm(this.mSessionStat.getAlarmObject());
        }
    }
}
