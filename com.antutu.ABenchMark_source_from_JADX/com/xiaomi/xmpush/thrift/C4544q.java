package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4602d;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4610c;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.q */
public class C4544q implements Serializable, Cloneable, C4454a<C4544q, C4543a> {
    public static final Map<C4543a, C4601b> f16055b;
    private static final C4615j f16056c;
    private static final C4609b f16057d;
    public List<C4525g> f16058a;

    /* renamed from: com.xiaomi.xmpush.thrift.q.a */
    public enum C4543a {
        CUSTOM_CONFIGS((short) 1, "customConfigs");
        
        private static final Map<String, C4543a> f16051b;
        private final short f16053c;
        private final String f16054d;

        static {
            f16051b = new HashMap();
            Iterator it = EnumSet.allOf(C4543a.class).iterator();
            while (it.hasNext()) {
                C4543a c4543a = (C4543a) it.next();
                f16051b.put(c4543a.m19028a(), c4543a);
            }
        }

        private C4543a(short s, String str) {
            this.f16053c = s;
            this.f16054d = str;
        }

        public String m19028a() {
            return this.f16054d;
        }
    }

    static {
        f16056c = new C4615j("XmPushActionCustomConfig");
        f16057d = new C4609b("customConfigs", (byte) 15, (short) 1);
        Map enumMap = new EnumMap(C4543a.class);
        enumMap.put(C4543a.CUSTOM_CONFIGS, new C4601b("customConfigs", (byte) 1, new C4602d((byte) 15, new C4604f((byte) 12, C4525g.class))));
        f16055b = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4544q.class, f16055b);
    }

    public List<C4525g> m19029a() {
        return this.f16058a;
    }

    public void m19030a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19035c();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f16058a = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        C4525g c4525g = new C4525g();
                        c4525g.m18812a(c4607e);
                        this.f16058a.add(c4525g);
                    }
                    c4607e.m19327m();
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m19031a(C4544q c4544q) {
        if (c4544q == null) {
            return false;
        }
        boolean b = m19034b();
        boolean b2 = c4544q.m19034b();
        return !(b || b2) || (b && b2 && this.f16058a.equals(c4544q.f16058a));
    }

    public int m19032b(C4544q c4544q) {
        if (!getClass().equals(c4544q.getClass())) {
            return getClass().getName().compareTo(c4544q.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19034b()).compareTo(Boolean.valueOf(c4544q.m19034b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19034b()) {
            compareTo = C4593b.m19286a(this.f16058a, c4544q.f16058a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19033b(C4607e c4607e) {
        m19035c();
        c4607e.m19313a(f16056c);
        if (this.f16058a != null) {
            c4607e.m19310a(f16057d);
            c4607e.m19311a(new C4610c((byte) 12, this.f16058a.size()));
            for (C4525g b : this.f16058a) {
                b.m18816b(c4607e);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19034b() {
        return this.f16058a != null;
    }

    public void m19035c() {
        if (this.f16058a == null) {
            throw new C4612f("Required field 'customConfigs' was not present! Struct: " + toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19032b((C4544q) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4544q)) ? m19031a((C4544q) obj) : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCustomConfig(");
        stringBuilder.append("customConfigs:");
        if (this.f16058a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16058a);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
