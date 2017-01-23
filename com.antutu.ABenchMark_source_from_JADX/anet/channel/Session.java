package anet.channel;

import android.content.Context;
import anet.channel.entity.C0666a;
import anet.channel.entity.C0667d;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.p019c.C0660c;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import com.umeng.message.MsgConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

public abstract class Session implements Comparable<Session> {
    private static final String TAG = "awcn.Session";
    protected boolean autoReCreate;
    protected boolean isHorseRide;
    protected IConnStrategy mConnStrategy;
    protected int mConnTimeout;
    protected ConnType mConnType;
    protected Context mContext;
    Map<EventCb, Integer> mEventCallBacks;
    protected String mHost;
    protected String mIp;
    private boolean mIsConnTimeOut;
    protected int mPort;
    protected String mProxyIp;
    protected int mProxyPort;
    Runnable mRecvTimeOutRunnable;
    protected int mReqTimeout;
    protected String mSeq;
    public SessionStatistic mSessionStat;
    protected Status mStatus;
    private ScheduledFuture<?> timeoutTaskFuture;
    protected boolean tryNextWhenFail;

    /* renamed from: anet.channel.Session.1 */
    static /* synthetic */ class C06381 {
        static final /* synthetic */ int[] f2156a;

        static {
            f2156a = new int[Status.values().length];
            try {
                f2156a[Status.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2156a[Status.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2156a[Status.DISCONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2156a[Status.CONNETFAIL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2156a[Status.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2156a[Status.AUTHING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2156a[Status.AUTH_SUCC.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2156a[Status.AUTH_FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public enum Status {
        CONNECTED,
        CONNECTING,
        CONNETFAIL,
        AUTHING,
        AUTH_SUCC,
        AUTH_FAIL,
        DISCONNECTED,
        DISCONNECTING
    }

    public Session(Context context, C0666a c0666a, ConnType connType) {
        this.mEventCallBacks = new LinkedHashMap();
        this.mIsConnTimeOut = false;
        this.mStatus = Status.DISCONNECTED;
        this.autoReCreate = false;
        this.tryNextWhenFail = true;
        this.mContext = context.getApplicationContext();
        this.mIp = c0666a.m2797a();
        this.mPort = c0666a.m2798b();
        this.mConnType = connType;
        this.mHost = c0666a.m2803g();
        this.mReqTimeout = c0666a.m2801e();
        this.mConnTimeout = c0666a.m2800d();
        this.mConnStrategy = c0666a.f2212a;
        this.mSessionStat = new SessionStatistic(c0666a);
        this.mSessionStat.retryTimes = (long) c0666a.f2213b;
        SessionStatistic sessionStatistic = this.mSessionStat;
        SessionStatistic.maxRetryTime = c0666a.f2214c;
        this.mSeq = c0666a.m2805i();
    }

    public static void configTnetALog(Context context, String str, int i, int i2) {
        SpdyAgent instance = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (instance == null || !SpdyAgent.checkLoadSucc()) {
            ALog.m2962e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
            return;
        }
        instance.configLogFile(str, i, i2);
    }

    protected void cancelTimeout() {
        if (this.mRecvTimeOutRunnable != null && this.timeoutTaskFuture != null) {
            this.timeoutTaskFuture.cancel(true);
        }
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z) {
        this.autoReCreate = z;
        close();
    }

    public int compareTo(Session session) {
        return ConnType.compare(this.mConnType, session.mConnType);
    }

    protected void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.mConnStrategy;
    }

    public ConnType getConnType() {
        return this.mConnType;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getIp() {
        return this.mIp;
    }

    public int getPort() {
        return this.mPort;
    }

    protected abstract Runnable getRecvTimeOutRunnable();

    protected void handleCallbacks(EventType eventType, C0667d c0667d) {
        C0660c.m2783a(new C0662d(this, eventType, c0667d));
    }

    public abstract boolean isAvailable();

    protected synchronized void notifyStatus(Status status, C0667d c0667d) {
        ALog.m2962e(TAG, "notifyStatus", this.mSeq, MsgConstant.KEY_STATUS, status.name());
        if (!status.equals(this.mStatus)) {
            this.mStatus = status;
            switch (C06381.f2156a[this.mStatus.ordinal()]) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    handleCallbacks(EventType.CONNECTED, c0667d);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    handleCallbacks(EventType.CONNECT_FAIL, c0667d);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    onDisconnect();
                    if (!this.mIsConnTimeOut) {
                        handleCallbacks(EventType.DISCONNECTED, c0667d);
                        break;
                    }
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    handleCallbacks(EventType.AUTH_SUCC, c0667d);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    handleCallbacks(EventType.AUTH_FAIL, c0667d);
                    break;
                default:
                    break;
            }
        }
        ALog.m2963i(TAG, "ignore notifyStatus", this.mSeq, new Object[0]);
    }

    protected void onDisconnect() {
    }

    public void ping(boolean z) {
    }

    public void registerEventcb(int i, EventCb eventCb) {
        if (this.mEventCallBacks != null) {
            this.mEventCallBacks.put(eventCb, Integer.valueOf(i));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public boolean sameSession(Session session) {
        return session != null && this.mIp != null && this.mPort == session.mPort && this.mConnType == session.mConnType && this.mIp.equals(session.mIp);
    }

    public void sendCustomFrame(int i, byte[] bArr, int i2) {
    }

    public void setIsHorseRide(boolean z) {
        this.isHorseRide = z;
    }

    protected void setPingTimeout() {
        if (this.mRecvTimeOutRunnable == null) {
            this.mRecvTimeOutRunnable = getRecvTimeOutRunnable();
        }
        cancelTimeout();
        if (this.mRecvTimeOutRunnable != null) {
            this.timeoutTaskFuture = C0660c.m2786a(this.mRecvTimeOutRunnable, HttpConstant.RECV_TIMEOUT, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session[");
        stringBuilder.append(this.mSeq).append('|').append(this.mConnType).append(']');
        return stringBuilder.toString();
    }

    protected void unReceiveEventCb(EventCb eventCb) {
        if (this.mEventCallBacks != null) {
            this.mEventCallBacks.remove(eventCb);
        }
    }
}
