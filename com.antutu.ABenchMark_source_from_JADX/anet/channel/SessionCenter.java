package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.C0665e.C0664a;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.entity.ENV;
import anet.channel.p019c.C0660c;
import anet.channel.session.AccsSession;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.C0736a;
import anet.channel.util.C0748i;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.umeng.message.common.C4209a;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.List;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

public class SessionCenter implements INetworkStatusChangeListener {
    public static final boolean ALIYUN_OPEN = false;
    public static boolean SECURITYGUARD_OFF = false;
    public static final String TAG = "awcn.SessionCenter";
    private static Context mContext;
    private static AccsFrameCb mDataChannelCb;
    private static boolean mInit;
    long enterBackgroundTime;
    boolean foreGroundCheckRunning;

    /* renamed from: anet.channel.SessionCenter.1 */
    class C06391 implements Runnable {
        C06391() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r5 = this;
            r4 = 0;
            r0 = anet.channel.SessionCenter.this;	 Catch:{ Exception -> 0x0030 }
            r0 = r0.enterBackgroundTime;	 Catch:{ Exception -> 0x0030 }
            r2 = 0;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 == 0) goto L_0x0028;
        L_0x000b:
            r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0030 }
            r2 = anet.channel.SessionCenter.this;	 Catch:{ Exception -> 0x0030 }
            r2 = r2.enterBackgroundTime;	 Catch:{ Exception -> 0x0030 }
            r0 = r0 - r2;
            r2 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x0028;
        L_0x001b:
            r0 = anet.channel.AccsSessionManager.getInstance();	 Catch:{ Exception -> 0x0030 }
            r1 = 1;
            r0.forceCloseSession(r1);	 Catch:{ Exception -> 0x0030 }
        L_0x0023:
            r0 = anet.channel.SessionCenter.this;
            r0.foreGroundCheckRunning = r4;
        L_0x0027:
            return;
        L_0x0028:
            r0 = anet.channel.AccsSessionManager.getInstance();	 Catch:{ Exception -> 0x0030 }
            r0.checkAndStartAccsSession();	 Catch:{ Exception -> 0x0030 }
            goto L_0x0023;
        L_0x0030:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x0039 }
            r0 = anet.channel.SessionCenter.this;
            r0.foreGroundCheckRunning = r4;
            goto L_0x0027;
        L_0x0039:
            r0 = move-exception;
            r1 = anet.channel.SessionCenter.this;
            r1.foreGroundCheckRunning = r4;
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionCenter.1.run():void");
        }
    }

    /* renamed from: anet.channel.SessionCenter.2 */
    class C06402 implements Runnable {
        C06402() {
        }

        public void run() {
            ALog.m2960d(SessionCenter.TAG, "horse serial ride start", null, new Object[0]);
            C0655b.m2774a();
        }
    }

    private static class SingletonHolder {
        static SessionCenter instance;

        static {
            instance = new SessionCenter();
        }

        private SingletonHolder() {
        }
    }

    static {
        SECURITYGUARD_OFF = ALIYUN_OPEN;
        mInit = ALIYUN_OPEN;
    }

    private SessionCenter() {
        this.enterBackgroundTime = 0;
        this.foreGroundCheckRunning = ALIYUN_OPEN;
    }

    public static SessionCenter getInstance() {
        return SingletonHolder.instance;
    }

    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    mContext = context.getApplicationContext();
                    GlobalAppRuntimeInfo.setContext(mContext);
                    GlobalAppRuntimeInfo.setAppKey(str);
                    if (mInit) {
                        ALog.m2960d(TAG, "SessionCenter has init", null, new Object[0]);
                    } else {
                        StrategyCenter.getInstance().initialize();
                        C0736a.m2966a();
                        NetworkStatusHelper.m2841a(getInstance());
                        AppMonitor.getInstance().register();
                        mInit = true;
                        ALog.m2960d(TAG, "init start", null, new Object[0]);
                    }
                }
            }
            ALog.m2962e(TAG, "init failed,input param null or empty !", null, "context", context, C4209a.f14204g, str);
            throw new RuntimeException("init failed,input param null or empty ");
        }
    }

    public static synchronized void init(Context context, String str, String str2) {
        synchronized (SessionCenter.class) {
            GlobalAppRuntimeInfo.setTtid(str2);
            init(context, str);
        }
    }

    public static synchronized void init(Context context, String str, String str2, String str3) {
        synchronized (SessionCenter.class) {
            if (context != null) {
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str3))) {
                    GlobalAppRuntimeInfo.setTtid(str2);
                    GlobalAppRuntimeInfo.setAppSecret(str3);
                    init(context, str);
                }
            }
            ALog.m2962e(TAG, "init failed,input param null or empty !", null, "context", context, C4209a.f14204g, str, "secret", str3);
            throw new RuntimeException("init failed,input param null or empty ");
        }
    }

    private void reCreateSession() {
        ALog.m2960d(TAG, "[reCreateSession]", null, new Object[0]);
        List<SessionRequest> a = C0664a.f2207a.m2790a();
        if (a.isEmpty()) {
            ALog.m2963i(TAG, "recreate session failed: infos is empty", null, new Object[0]);
        } else {
            for (SessionRequest sessionRequest : a) {
                ALog.m2960d(TAG, "network change, try re create ", null, BuildConfig.FLAVOR);
                sessionRequest.m2752b(null);
            }
        }
        AccsSessionManager.getInstance().checkAndStartAccsSession();
    }

    private void updateAccsFrameCb(ConnType connType) {
        List a = C0664a.f2207a.m2792a(connType);
        if (a != null) {
            ALog.m2963i(TAG, "sessions:" + a.size(), null, new Object[0]);
            for (int i = 0; i < a.size(); i++) {
                Session session = (Session) a.get(i);
                if (session instanceof AccsSession) {
                    ((AccsSession) session).setFrameCb(mDataChannelCb);
                }
            }
            return;
        }
        ALog.m2963i(TAG, "sessions:null", null, new Object[0]);
    }

    public void background() {
        if (!GlobalAppRuntimeInfo.isAppBackground()) {
            ALog.m2960d(TAG, "[enterBackground]", null, new Object[0]);
            GlobalAppRuntimeInfo.setBackground(true);
            this.enterBackgroundTime = System.currentTimeMillis();
            if (mInit) {
                try {
                    C0660c.m2783a(new C06402());
                    StrategyCenter.getInstance().saveData();
                    if ("OPPO".equalsIgnoreCase(Build.BRAND)) {
                        AccsSessionManager.getInstance().forceCloseSession(ALIYUN_OPEN);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            ALog.m2962e(TAG, "enterBackground not inited!", null, new Object[0]);
        }
    }

    @Deprecated
    public void enterBackground() {
        background();
    }

    @Deprecated
    public void enterForeground() {
        forground();
    }

    public void forground() {
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            ALog.m2963i(TAG, "[enterForeground]", null, new Object[0]);
            GlobalAppRuntimeInfo.setBackground(ALIYUN_OPEN);
            if (mContext != null && !this.foreGroundCheckRunning) {
                this.foreGroundCheckRunning = true;
                if (mInit) {
                    try {
                        C0660c.m2783a(new C06391());
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                ALog.m2962e(TAG, "enterForeground not inited!", null, new Object[0]);
            }
        }
    }

    public Session get(String str, long j) {
        return get(str, null, j);
    }

    public Session get(String str, TypeLevel typeLevel, long j) {
        Session session = null;
        try {
            session = getInternal(str, typeLevel, j);
        } catch (Throwable e) {
            ALog.m2961e(TAG, "[Get]param url is invaild, return null", session, e, "url", str);
        } catch (Throwable e2) {
            ALog.m2961e(TAG, "[Get]get session timeout exception return null", session, e2, "url", str);
        } catch (NoNetworkException e3) {
            ALog.m2962e(TAG, "[Get]get session no network return null", session, "url", str);
        } catch (NoAvailStrategyException e4) {
            ALog.m2962e(TAG, "[Get]get session no strategy", session, "url", str);
        } catch (Throwable e22) {
            ALog.m2961e(TAG, "[Get]get session exception return null", session, e22, "url", str);
        }
        return session;
    }

    public AccsFrameCb getDataChannelCb() {
        return mDataChannelCb;
    }

    protected Session getInternal(String str, long j) {
        return getInternal(str, null, j);
    }

    protected Session getInternal(String str, TypeLevel typeLevel, long j) {
        if (mInit) {
            ALog.m2960d(TAG, "getInternal", null, "u", str, "TypeClass", typeLevel, "timeout", Long.valueOf(j));
            String[] parseURL = StringUtils.parseURL(str);
            if (parseURL == null) {
                throw new InvalidParameterException("param url invalid. url:" + str);
            }
            String schemeByHost = AwcnConfig.isSSLEnabled() ? StrategyCenter.getInstance().getSchemeByHost(parseURL[1]) : HttpConstant.HTTP;
            String cNameByHost = StrategyCenter.getInstance().getCNameByHost(parseURL[1]);
            SessionRequest a = SessionRequest.m2736a(C0734n.m2951a(schemeByHost != null ? schemeByHost : parseURL[0], cNameByHost != null ? cNameByHost : parseURL[1]));
            Session a2 = C0664a.f2207a.m2789a(a, typeLevel);
            if (a2 != null) {
                ALog.m2960d(TAG, "get internal hit cache session", null, "session", a2);
                return a2;
            }
            a.m2748a(mContext, typeLevel, C0748i.m2987a());
            if (j <= 0) {
                return a2;
            }
            a.m2747a(j);
            a2 = C0664a.f2207a.m2789a(a, typeLevel);
            if (a2 != null) {
                return a2;
            }
            throw new ConnectException();
        }
        ALog.m2962e(TAG, "getInternal not inited!", null, new Object[0]);
        return null;
    }

    public Session getThrowsException(String str, long j) {
        return getInternal(str, j);
    }

    public Session getThrowsException(String str, TypeLevel typeLevel, long j) {
        return getInternal(str, typeLevel, j);
    }

    public void onNetworkStatusChanged(NetworkStatus networkStatus) {
        ALog.m2960d(TAG, "onNetworkStatusChanged", null, "networkStatus", networkStatus);
        reCreateSession();
    }

    public boolean setDataReceiveCb(AccsFrameCb accsFrameCb) {
        ALog.m2963i(TAG, "setDataReceiveCb", null, "AccsFrameCb", accsFrameCb);
        mDataChannelCb = accsFrameCb;
        updateAccsFrameCb(ConnType.H2_ACCS_0RTT);
        updateAccsFrameCb(ConnType.H2_ACCS_1RTT);
        updateAccsFrameCb(ConnType.ACCS_0RTT);
        updateAccsFrameCb(ConnType.ACCS_1RTT);
        return true;
    }

    public synchronized void switchEnv(ENV env) {
        int i = 0;
        synchronized (this) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.m2963i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent instance = SpdyAgent.getInstance(mContext, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
                    if (env != ENV.TEST) {
                        i = 1;
                    }
                    instance.switchAccsServer(i);
                    AccsSessionManager.getInstance().forceCloseSession(true);
                }
            } catch (Throwable th) {
                ALog.m2961e(TAG, "switch env error.", null, th, new Object[0]);
            }
        }
    }
}
