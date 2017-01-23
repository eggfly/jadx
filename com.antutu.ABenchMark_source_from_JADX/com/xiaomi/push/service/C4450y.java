package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.utl.UtilityImpl;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.push.service.XMPushService.C4387b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.xiaomi.push.service.y */
public class C4450y {
    private static C4450y f15190a;
    private ConcurrentHashMap<String, HashMap<String, C4448b>> f15191b;
    private List<C4404a> f15192c;

    /* renamed from: com.xiaomi.push.service.y.a */
    public interface C4404a {
        void m18170a();
    }

    /* renamed from: com.xiaomi.push.service.y.b */
    public static class C4448b {
        public String f15169a;
        public String f15170b;
        public String f15171c;
        public String f15172d;
        public boolean f15173e;
        public String f15174f;
        public String f15175g;
        public String f15176h;
        public String f15177i;
        public String f15178j;
        public C4407b f15179k;
        public Context f15180l;
        C4449c f15181m;
        private int f15182n;
        private List<C4405a> f15183o;
        private XMPushService f15184p;
        private C4387b f15185q;

        /* renamed from: com.xiaomi.push.service.y.b.a */
        public interface C4405a {
            void m18176a(C4449c c4449c, C4449c c4449c2, int i);
        }

        public C4448b() {
            this.f15181m = C4449c.unbind;
            this.f15182n = 0;
            this.f15183o = new ArrayList();
            this.f15185q = new C4387b(this);
        }

        public C4448b(XMPushService xMPushService) {
            this.f15181m = C4449c.unbind;
            this.f15182n = 0;
            this.f15183o = new ArrayList();
            this.f15185q = new C4387b(this);
            this.f15184p = xMPushService;
            m18387a(new C4451z(this));
        }

        public long m18385a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f15182n + 1) * 15)));
        }

        public String m18386a(int i) {
            switch (i) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    return "OPEN";
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    return "CLOSE";
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    return "KICK";
                default:
                    return UtilityImpl.NET_TYPE_UNKNOWN;
            }
        }

        public void m18387a(C4405a c4405a) {
            synchronized (this.f15183o) {
                this.f15183o.add(c4405a);
            }
        }

        public void m18388a(C4449c c4449c, int i, int i2, String str, String str2) {
            boolean z = true;
            synchronized (this.f15183o) {
                for (C4405a a : this.f15183o) {
                    a.m18176a(this.f15181m, c4449c, i2);
                }
            }
            if (this.f15181m != c4449c) {
                C4302b.m17649a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", new Object[]{this.f15181m, c4449c, m18386a(i), aa.m18107a(i2), str, str2, this.f15176h}));
                this.f15181m = c4449c;
            }
            if (this.f15179k == null) {
                C4302b.m17654d("status changed while the client dispatcher is missing");
            } else if (i == 2) {
                this.f15179k.m18186a(this.f15180l, this, i2);
            } else if (i == 3) {
                this.f15179k.m18187a(this.f15180l, this, str2, str);
            } else if (i == 1) {
                if (c4449c != C4449c.binded) {
                    z = false;
                }
                if (!z && "wait".equals(str2)) {
                    this.f15182n++;
                } else if (z) {
                    this.f15182n = 0;
                }
                this.f15179k.m18188a(this.f15180l, this, z, i2, str);
            }
        }

        public void m18389b(C4405a c4405a) {
            synchronized (this.f15183o) {
                this.f15183o.remove(c4405a);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.y.c */
    public enum C4449c {
        unbind,
        binding,
        binded
    }

    private C4450y() {
        this.f15191b = new ConcurrentHashMap();
        this.f15192c = new ArrayList();
    }

    public static synchronized C4450y m18390a() {
        C4450y c4450y;
        synchronized (C4450y.class) {
            if (f15190a == null) {
                f15190a = new C4450y();
            }
            c4450y = f15190a;
        }
        return c4450y;
    }

    private String m18391d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public synchronized void m18392a(Context context) {
        for (HashMap values : this.f15191b.values()) {
            for (C4448b a : values.values()) {
                a.m18388a(C4449c.unbind, 1, 3, null, null);
            }
        }
    }

    public synchronized void m18393a(Context context, int i) {
        for (HashMap values : this.f15191b.values()) {
            for (C4448b a : values.values()) {
                a.m18388a(C4449c.unbind, 2, i, null, null);
            }
        }
    }

    public synchronized void m18394a(C4404a c4404a) {
        this.f15192c.add(c4404a);
    }

    public synchronized void m18395a(C4448b c4448b) {
        HashMap hashMap = (HashMap) this.f15191b.get(c4448b.f15176h);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f15191b.put(c4448b.f15176h, hashMap);
        }
        hashMap.put(m18391d(c4448b.f15170b), c4448b);
        for (C4404a a : this.f15192c) {
            a.m18170a();
        }
    }

    public synchronized void m18396a(String str) {
        HashMap hashMap = (HashMap) this.f15191b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.f15191b.remove(str);
        }
        for (C4404a a : this.f15192c) {
            a.m18170a();
        }
    }

    public synchronized void m18397a(String str, String str2) {
        HashMap hashMap = (HashMap) this.f15191b.get(str);
        if (hashMap != null) {
            hashMap.remove(m18391d(str2));
            if (hashMap.isEmpty()) {
                this.f15191b.remove(str);
            }
        }
        for (C4404a a : this.f15192c) {
            a.m18170a();
        }
    }

    public synchronized C4448b m18398b(String str, String str2) {
        HashMap hashMap;
        hashMap = (HashMap) this.f15191b.get(str);
        return hashMap == null ? null : (C4448b) hashMap.get(m18391d(str2));
    }

    public synchronized ArrayList<C4448b> m18399b() {
        ArrayList<C4448b> arrayList;
        arrayList = new ArrayList();
        for (HashMap values : this.f15191b.values()) {
            arrayList.addAll(values.values());
        }
        return arrayList;
    }

    public synchronized List<String> m18400b(String str) {
        List<String> arrayList;
        arrayList = new ArrayList();
        for (HashMap values : this.f15191b.values()) {
            for (C4448b c4448b : values.values()) {
                if (str.equals(c4448b.f15169a)) {
                    arrayList.add(c4448b.f15176h);
                }
            }
        }
        return arrayList;
    }

    public synchronized int m18401c() {
        return this.f15191b.size();
    }

    public synchronized Collection<C4448b> m18402c(String str) {
        return !this.f15191b.containsKey(str) ? new ArrayList() : ((HashMap) ((HashMap) this.f15191b.get(str)).clone()).values();
    }

    public synchronized void m18403d() {
        this.f15191b.clear();
    }

    public synchronized void m18404e() {
        this.f15192c.clear();
    }
}
