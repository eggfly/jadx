package anet.channel.p018b;

import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: anet.channel.b.b */
public class C0653b {
    private static final Class<? extends C0650a>[] f2185c;
    Map<Class, C0650a> f2186a;
    CopyOnWriteArrayList<C0650a> f2187b;

    /* renamed from: anet.channel.b.b.a */
    private static class C0652a {
        static C0653b f2184a;

        static {
            f2184a = new C0653b();
        }

        private C0652a() {
        }
    }

    static {
        f2185c = new Class[]{C0654c.class};
    }

    private C0653b() {
        this.f2186a = new HashMap();
        this.f2187b = new CopyOnWriteArrayList();
        m2768b();
    }

    public static C0653b m2767a() {
        return C0652a.f2184a;
    }

    private void m2768b() {
        for (int i = 0; i < f2185c.length; i++) {
            try {
                this.f2186a.put(f2185c[i], f2185c[i].newInstance());
            } catch (Throwable e) {
                ALog.m2961e("awcn.EventHandlerManager", "instantiate plugin failed.", null, e, new Object[0]);
            }
        }
        this.f2187b.addAll(this.f2186a.values());
    }

    public <T> T m2769a(int i, Object... objArr) {
        Iterator it = this.f2187b.iterator();
        T t = null;
        while (it.hasNext()) {
            t = ((C0650a) it.next()).m2766a(i, objArr);
            if (t != C0650a.f2182a) {
                break;
            }
        }
        return (t == C0650a.f2182a || t == C0650a.f2183b) ? null : t;
    }
}
