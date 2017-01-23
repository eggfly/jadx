package anet.channel;

import android.content.Context;
import anet.channel.C0665e.C0664a;
import anet.channel.entity.C0666a;
import anet.channel.entity.C0667d;
import anet.channel.entity.C0670e;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.AccsSession;
import anet.channel.session.C0692e;
import anet.channel.session.C0696i;
import anet.channel.strategy.C0734n;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IHRStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.C0748i;
import anet.channel.util.HttpConstant;
import com.taobao.accs.internal.C4103b;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: anet.channel.b */
public class C0655b {
    public static final String HR_SERIAL = "serial";
    public static final String HR_SERIAL_CONN = "serialConn";
    public static final String HR_SERIAL_ONLY = "serialOnly";
    private static final int f2190a;

    /* renamed from: anet.channel.b.1 */
    static /* synthetic */ class C06491 {
        static final /* synthetic */ int[] f2181a;

        static {
            f2181a = new int[EventType.values().length];
            try {
                f2181a[EventType.AUTH_SUCC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2181a[EventType.AUTH_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2181a[EventType.CONNECT_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        f2190a = (EventType.AUTH_SUCC.getType() | EventType.AUTH_FAIL.getType()) | EventType.CONNECT_FAIL.getType();
    }

    private static Session m2773a(IConnStrategy iConnStrategy, String str) {
        Context context = GlobalAppRuntimeInfo.getContext();
        C0666a c0666a = new C0666a(C0734n.m2951a(iConnStrategy.getConnType().isSSL() ? HttpConstant.HTTPS : HttpConstant.HTTP, str), C0748i.m2987a(), iConnStrategy);
        ConnType connType = iConnStrategy.getConnType();
        Session c0692e = (connType.equals(ConnType.HTTP) || connType.equals(ConnType.HTTPS)) ? new C0692e(context, c0666a) : c0666a.m2802f() ? new AccsSession(context, c0666a) : new C0696i(context, c0666a);
        if (c0692e != null) {
            c0692e.setIsHorseRide(true);
        }
        return c0692e;
    }

    public static void m2774a() {
        Map hRStrategyMap = StrategyCenter.getInstance().getHRStrategyMap();
        if (hRStrategyMap != null && !hRStrategyMap.isEmpty()) {
            for (Entry entry : hRStrategyMap.entrySet()) {
                IHRStrategy iHRStrategy = (IHRStrategy) entry.getValue();
                String hRStrategy = iHRStrategy.getHRStrategy();
                long currentTimeMillis = System.currentTimeMillis();
                if ((HR_SERIAL.equals(hRStrategy) || HR_SERIAL_ONLY.equals(hRStrategy)) && currentTimeMillis - iHRStrategy.getLastHRTime() > iHRStrategy.getHRInterval() && iHRStrategy.getHrNum() > 0) {
                    if (ALog.isPrintLog(1)) {
                        ALog.m2960d("awcn.HorseRide", "horse ride for this host", null, C4103b.ELECTION_KEY_HOST, entry.getKey());
                    }
                    C0655b.m2777a((String) entry.getKey(), iHRStrategy.getHrNum());
                }
            }
        }
    }

    private static void m2777a(String str, int i) {
        List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str);
        if (connStrategyListByHost != null && !connStrategyListByHost.isEmpty()) {
            if (connStrategyListByHost.size() > i) {
                Collections.shuffle(connStrategyListByHost);
            }
            int i2 = 0;
            for (IConnStrategy a : connStrategyListByHost) {
                int i3;
                Session a2 = C0655b.m2773a(a, str);
                if (a2 != null) {
                    C0655b.m2778b(a2);
                    a2.connect();
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                if (i3 < i) {
                    i2 = i3;
                } else {
                    return;
                }
            }
        }
    }

    private static void m2778b(Session session) {
        session.registerEventcb(f2190a, new C0661c(System.currentTimeMillis()));
    }

    private static void m2779b(C0670e c0670e, C0667d c0667d) {
        c0670e.f2223a = false;
        if (c0667d != null) {
            c0670e.d = c0667d.f2218d;
            c0670e.e = c0667d.f2219e;
        }
    }

    private static void m2780c(Session session) {
        List<Session> a = C0664a.f2207a.m2793a(session.getHost());
        if (a != null) {
            for (Session sameSession : a) {
                if (sameSession.sameSession(session)) {
                    return;
                }
            }
        }
        session.close();
    }
}
