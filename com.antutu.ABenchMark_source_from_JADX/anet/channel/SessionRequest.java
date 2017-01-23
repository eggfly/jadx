package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.C0665e.C0664a;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.C0666a;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.entity.EventType;
import anet.channel.p019c.C0660c;
import anet.channel.session.AccsSession;
import anet.channel.session.C0692e;
import anet.channel.session.C0696i;
import anet.channel.statist.AlarmObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.C0748i;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.taobao.accs.utl.C4135a;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.android.agoo.intent.IntentUtil;

public class SessionRequest {
    private static Map<String, SessionRequest> f2165c;
    volatile boolean f2166a;
    volatile Session f2167b;
    private String f2168d;
    private volatile Future f2169e;
    private Object f2170f;

    /* renamed from: anet.channel.SessionRequest.1 */
    static /* synthetic */ class C06411 {
        static final /* synthetic */ int[] f2157a;

        static {
            f2157a = new int[EventType.values().length];
            try {
                f2157a[EventType.AUTH_SUCC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2157a[EventType.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2157a[EventType.CONNECT_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private interface IConnCb {
        void onDisConnect(Session session, long j, EventType eventType);

        void onFailed(Session session, long j, EventType eventType, int i);

        void onSuccess(Session session, long j);
    }

    /* renamed from: anet.channel.SessionRequest.a */
    class C0642a implements IConnCb {
        boolean f2158a;
        final /* synthetic */ SessionRequest f2159b;
        private Context f2160c;
        private List<C0666a> f2161d;
        private C0666a f2162e;

        C0642a(SessionRequest sessionRequest, Context context, List<C0666a> list, C0666a c0666a) {
            this.f2159b = sessionRequest;
            this.f2158a = false;
            this.f2160c = context;
            this.f2161d = list;
            this.f2162e = c0666a;
        }

        public void onDisConnect(Session session, long j, EventType eventType) {
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.m2960d("awcn.SessionRequest", "Connect Disconnect", this.f2162e.m2805i(), "session", session, C4103b.ELECTION_KEY_HOST, this.f2159b.m2746a(), "appIsBg", Boolean.valueOf(isAppBackground), "isHandleFinish", Boolean.valueOf(this.f2158a));
            C0664a.f2207a.m2795b(this.f2159b, session);
            if (!this.f2158a) {
                this.f2158a = true;
                if (!session.autoReCreate) {
                    return;
                }
                if (isAppBackground) {
                    ALog.m2962e("awcn.SessionRequest", "app background,return", this.f2162e.m2805i(), "session", session);
                } else if (NetworkStatusHelper.m2846e()) {
                    try {
                        ALog.m2960d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f2162e.m2805i(), new Object[0]);
                        C0660c.m2786a(new C0673h(this, session), (long) ((Math.random() * 10.0d) * 1000.0d), TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                    }
                } else {
                    ALog.m2962e("awcn.SessionRequest", "no network,return", this.f2162e.m2805i(), "session", session);
                }
            }
        }

        public void onFailed(Session session, long j, EventType eventType, int i) {
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.SessionRequest", "Connect failed", this.f2162e.m2805i(), "session", session, C4103b.ELECTION_KEY_HOST, this.f2159b.m2746a(), "isHandleFinish", Boolean.valueOf(this.f2158a));
            }
            if (!this.f2158a) {
                this.f2158a = true;
                C0664a.f2207a.m2795b(this.f2159b, session);
                if (!session.tryNextWhenFail) {
                    return;
                }
                if (!NetworkStatusHelper.m2846e()) {
                    this.f2159b.m2751b();
                } else if (this.f2161d.size() > 0) {
                    if (ALog.isPrintLog(1)) {
                        ALog.m2960d("awcn.SessionRequest", "use next strategy to create session", this.f2162e.m2805i(), C4103b.ELECTION_KEY_HOST, this.f2159b.m2746a());
                    }
                    C0666a c0666a = (C0666a) this.f2161d.remove(0);
                    this.f2159b.m2739a(this.f2160c, c0666a, new C0642a(this.f2159b, this.f2160c, this.f2161d, c0666a), c0666a.m2805i());
                } else {
                    if (ALog.isPrintLog(1)) {
                        ALog.m2960d("awcn.SessionRequest", "strategy has used up,finish", this.f2162e.m2805i(), C4103b.ELECTION_KEY_HOST, this.f2159b.m2746a());
                    }
                    this.f2159b.m2751b();
                    if (EventType.CONNECT_FAIL.equals(eventType) && i != -2613 && i != -2601) {
                        AlarmObject alarmObject = new AlarmObject();
                        alarmObject.module = "networkPrefer";
                        alarmObject.modulePoint = "policy";
                        alarmObject.arg = this.f2159b.f2168d;
                        alarmObject.errorCode = String.valueOf(i);
                        alarmObject.isSuccess = false;
                        AppMonitor.getInstance().commitAlarm(alarmObject);
                    }
                }
            }
        }

        public void onSuccess(Session session, long j) {
            ALog.m2960d("awcn.SessionRequest", "Connect Success", this.f2162e.m2805i(), "session", session, C4103b.ELECTION_KEY_HOST, this.f2159b.m2746a());
            try {
                C0664a.f2207a.m2794a(this.f2159b, session);
                if (session != null && (session instanceof AccsSession)) {
                    ((AccsSession) session).setFrameCb(SessionCenter.getInstance().getDataChannelCb());
                    ALog.m2960d("awcn.SessionRequest", "set Framecb success", null, "session", session);
                }
                AlarmObject alarmObject = new AlarmObject();
                alarmObject.module = "networkPrefer";
                alarmObject.modulePoint = "policy";
                alarmObject.arg = this.f2159b.f2168d;
                alarmObject.isSuccess = true;
                AppMonitor.getInstance().commitAlarm(alarmObject);
            } catch (Throwable e) {
                ALog.m2961e("awcn.SessionRequest", "[onSuccess]:", this.f2162e.m2805i(), e, new Object[0]);
            } finally {
                this.f2159b.m2751b();
            }
        }
    }

    /* renamed from: anet.channel.SessionRequest.b */
    private class C0643b implements Runnable {
        String f2163a;
        final /* synthetic */ SessionRequest f2164b;

        C0643b(SessionRequest sessionRequest, String str) {
            this.f2164b = sessionRequest;
            this.f2163a = null;
            this.f2163a = str;
        }

        public void run() {
            if (this.f2164b.f2166a) {
                ALog.m2962e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f2163a, new Object[0]);
                if (this.f2164b.f2167b != null) {
                    this.f2164b.f2167b.tryNextWhenFail = false;
                    this.f2164b.f2167b.close();
                }
                this.f2164b.m2745b(false);
            }
        }
    }

    static {
        f2165c = new HashMap();
    }

    private SessionRequest(String str) {
        this.f2166a = false;
        this.f2170f = new Object();
        this.f2168d = str;
    }

    protected static SessionRequest m2736a(String str) {
        SessionRequest sessionRequest;
        ALog.m2960d("awcn.SessionRequest", "SessionRequest build", null, "key", str);
        String toLowerCase = str.toLowerCase(Locale.US);
        synchronized (f2165c) {
            sessionRequest = (SessionRequest) f2165c.get(toLowerCase);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(toLowerCase);
                f2165c.put(toLowerCase, sessionRequest);
            } else {
                ALog.m2960d("awcn.SessionRequest", "hit cached SessionRequest", null, "key", toLowerCase, "info", sessionRequest);
            }
        }
        return sessionRequest;
    }

    private List<IConnStrategy> m2737a(TypeLevel typeLevel, String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        try {
            String[] parseURL = StringUtils.parseURL(m2746a());
            if (parseURL == null) {
                return Collections.EMPTY_LIST;
            }
            list = StrategyCenter.getInstance().getConnStrategyListByHost(parseURL[1]);
            if (!list.isEmpty()) {
                boolean equalsIgnoreCase = HttpConstant.HTTPS.equalsIgnoreCase(parseURL[0]);
                ListIterator listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    IConnStrategy iConnStrategy = (IConnStrategy) listIterator.next();
                    if (!(iConnStrategy.getConnType().isSSL() == equalsIgnoreCase && (typeLevel == null || iConnStrategy.getConnType().getTypeLevel() == typeLevel))) {
                        listIterator.remove();
                    }
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.m2960d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", list);
            }
            return list;
        } catch (Throwable th) {
            Throwable th2 = th;
            List<IConnStrategy> list2 = list;
            ALog.m2961e("awcn.SessionRequest", BuildConfig.FLAVOR, str, th2, new Object[0]);
            return list2;
        }
    }

    private List<C0666a> m2738a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<C0666a> arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            IConnStrategy iConnStrategy = (IConnStrategy) list.get(i2);
            int retryTimes = iConnStrategy.getRetryTimes();
            int i3 = 0;
            while (i3 <= retryTimes) {
                int i4 = i + 1;
                C0666a c0666a = new C0666a(m2746a(), str + "_" + i4, iConnStrategy);
                c0666a.f2213b = i3;
                c0666a.f2214c = retryTimes;
                arrayList.add(c0666a);
                i3++;
                i = i4;
            }
        }
        return arrayList;
    }

    private void m2739a(Context context, C0666a c0666a, IConnCb iConnCb, String str) {
        if (c0666a.m2799c().isHttpType()) {
            this.f2167b = new C0692e(context, c0666a);
        } else if (c0666a.m2802f()) {
            this.f2167b = new AccsSession(context, c0666a);
        } else {
            this.f2167b = new C0696i(context, c0666a);
        }
        ALog.m2960d("awcn.SessionRequest", "create connection...", str, HttpConstant.HOST, m2746a(), "Type", c0666a.m2799c(), "IP", c0666a.m2797a(), "Port", Integer.valueOf(c0666a.m2798b()), "heartbeat", Integer.valueOf(c0666a.m2804h()), "session", this.f2167b);
        m2740a(this.f2167b, iConnCb, System.currentTimeMillis());
        this.f2167b.connect();
    }

    private void m2740a(Session session, IConnCb iConnCb, long j) {
        if (iConnCb != null) {
            session.registerEventcb(EventType.ALL.getType(), new C0671f(this, iConnCb, j));
            session.registerEventcb(((EventType.CONNECTED.getType() | EventType.CONNECT_FAIL.getType()) | EventType.AUTH_SUCC.getType()) | EventType.AUTH_FAIL.getType(), new C0672g(this, session));
        }
    }

    protected static void m2741a(SessionRequest sessionRequest) {
        synchronized (f2165c) {
            f2165c.remove(sessionRequest);
        }
    }

    private void m2745b(boolean z) {
        this.f2166a = z;
        if (!z) {
            if (this.f2169e != null) {
                this.f2169e.cancel(true);
                this.f2169e = null;
            }
            this.f2167b = null;
        }
    }

    protected String m2746a() {
        return this.f2168d;
    }

    protected void m2747a(long j) {
        ALog.m2960d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j));
        if (j > 0) {
            synchronized (this.f2170f) {
                long currentTimeMillis = System.currentTimeMillis() + j;
                while (this.f2166a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= currentTimeMillis) {
                        break;
                    }
                    this.f2170f.wait(currentTimeMillis - currentTimeMillis2);
                }
                if (this.f2166a) {
                    throw new TimeoutException();
                }
            }
        }
    }

    protected synchronized void m2748a(Context context, TypeLevel typeLevel, String str) {
        if (C0664a.f2207a.m2789a(this, typeLevel) != null) {
            ALog.m2960d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = C0748i.m2987a();
            }
            ALog.m2960d("awcn.SessionRequest", "SessionRequest start", str, C4103b.ELECTION_KEY_HOST, this.f2168d, C4233j.f14402y, typeLevel);
            if (this.f2166a) {
                ALog.m2960d("awcn.SessionRequest", "session is connecting, return", str, C4103b.ELECTION_KEY_HOST, m2746a());
            } else {
                m2745b(true);
                this.f2169e = C0660c.m2786a(new C0643b(this, str), 45, TimeUnit.SECONDS);
                if (NetworkStatusHelper.m2846e()) {
                    List a = m2737a(typeLevel, str);
                    if (a.isEmpty()) {
                        ALog.m2962e("awcn.SessionRequest", "no strategy\uff0ccan't create session", str, C4103b.ELECTION_KEY_HOST, this.f2168d, C4233j.f14402y, typeLevel);
                        m2751b();
                        throw new NoAvailStrategyException(this);
                    }
                    if (typeLevel == TypeLevel.HTTP) {
                        ListIterator listIterator = a.listIterator();
                        while (listIterator.hasNext()) {
                            IConnStrategy iConnStrategy = (IConnStrategy) listIterator.next();
                            if (C0692e.m2829a(this.f2168d, iConnStrategy.getIp(), iConnStrategy.getPort())) {
                                listIterator.remove();
                            }
                        }
                        if (a.isEmpty()) {
                            ALog.m2963i("awcn.SessionRequest", "all http strategies are removed.", null, new Object[0]);
                            m2751b();
                        }
                    }
                    a = m2738a(a, str);
                    try {
                        C0666a c0666a = (C0666a) a.remove(0);
                        m2739a(context, c0666a, new C0642a(this, context, a, c0666a), c0666a.m2805i());
                    } catch (Throwable th) {
                        m2751b();
                    }
                } else {
                    if (ALog.isPrintLog(1)) {
                        ALog.m2960d("awcn.SessionRequest", "network is not available\uff0ccan't create session", str, "NetworkStatusHelper.isConnected()", Boolean.valueOf(NetworkStatusHelper.m2846e()));
                    }
                    m2751b();
                    throw new NoNetworkException(this);
                }
            }
        }
    }

    protected void m2749a(String str, boolean z, int i, String str2) {
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context != null && C0734n.m2955c(C0734n.m2957e(str))) {
            String str3 = Constants.ACTION_RECEIVE;
            String str4 = IntentUtil.AGOO_COMMAND;
            String str5 = Constants.KEY_ERROR_CODE;
            String str6 = Constants.KEY_ERROR_DETAIL;
            String str7 = Constants.KEY_CONNECT_AVAILABLE;
            String str8 = C4103b.ELECTION_KEY_HOST;
            String str9 = Constants.KEY_TYPE_INAPP;
            String str10 = Constants.KEY_CENTER_HOST;
            try {
                URL url = new URL(str);
                Intent intent = new Intent(str3);
                intent.setPackage(context.getPackageName());
                intent.setClassName(context, C4135a.msgService);
                intent.putExtra(str4, Constants.COMMAND_CONNECT_INFO);
                intent.putExtra(str8, C0734n.m2951a(url.getProtocol(), url.getHost()));
                intent.putExtra(str10, C0734n.m2952a(url.getHost()));
                if (!z) {
                    intent.putExtra(str5, i);
                    intent.putExtra(str6, str2);
                }
                intent.putExtra(str7, z);
                intent.putExtra(str9, true);
                context.startService(intent);
            } catch (Throwable th) {
                ALog.m2961e("awcn.SessionRequest", "sendConnectInfoBroadCastToAccs", null, th, new Object[0]);
            }
        }
    }

    protected void m2750a(boolean z) {
        ALog.m2960d("awcn.SessionRequest", "closeSessions", null, C4103b.ELECTION_KEY_HOST, this.f2168d, "autoCreate", Boolean.valueOf(z));
        List<Session> a = C0664a.f2207a.m2791a(this);
        if (a != null) {
            for (Session session : a) {
                if (session != null) {
                    session.close(z);
                }
            }
        }
    }

    protected void m2751b() {
        m2745b(false);
        synchronized (this.f2170f) {
            this.f2170f.notifyAll();
        }
    }

    protected void m2752b(String str) {
        ALog.m2960d("awcn.SessionRequest", "reCreateSession", str, C4103b.ELECTION_KEY_HOST, this.f2168d);
        m2750a(true);
    }
}
