package com.xiaomi.push.thrift;

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
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4602d;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4610c;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.push.thrift.c */
public class C4457c implements Serializable, Cloneable, C4454a<C4457c, C4456a> {
    public static final Map<C4456a, C4601b> f15290d;
    private static final C4615j f15291e;
    private static final C4609b f15292f;
    private static final C4609b f15293g;
    private static final C4609b f15294h;
    public String f15295a;
    public String f15296b;
    public List<C4455b> f15297c;

    /* renamed from: com.xiaomi.push.thrift.c.a */
    public enum C4456a {
        UUID((short) 1, "uuid"),
        OPERATOR((short) 2, "operator"),
        EVENTS((short) 3, "events");
        
        private static final Map<String, C4456a> f15286d;
        private final short f15288e;
        private final String f15289f;

        static {
            f15286d = new HashMap();
            Iterator it = EnumSet.allOf(C4456a.class).iterator();
            while (it.hasNext()) {
                C4456a c4456a = (C4456a) it.next();
                f15286d.put(c4456a.m18442a(), c4456a);
            }
        }

        private C4456a(short s, String str) {
            this.f15288e = s;
            this.f15289f = str;
        }

        public String m18442a() {
            return this.f15289f;
        }
    }

    static {
        f15291e = new C4615j("StatsEvents");
        f15292f = new C4609b("uuid", (byte) 11, (short) 1);
        f15293g = new C4609b("operator", (byte) 11, (short) 2);
        f15294h = new C4609b("events", (byte) 15, (short) 3);
        Map enumMap = new EnumMap(C4456a.class);
        enumMap.put(C4456a.UUID, new C4601b("uuid", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4456a.OPERATOR, new C4601b("operator", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4456a.EVENTS, new C4601b("events", (byte) 1, new C4602d((byte) 15, new C4604f((byte) 12, C4455b.class))));
        f15290d = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4457c.class, f15290d);
    }

    public C4457c(String str, List<C4455b> list) {
        this();
        this.f15295a = str;
        this.f15297c = list;
    }

    public C4457c m18443a(String str) {
        this.f15296b = str;
        return this;
    }

    public void m18444a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18451d();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15295a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15296b = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f15297c = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        C4455b c4455b = new C4455b();
                        c4455b.m18414a(c4607e);
                        this.f15297c.add(c4455b);
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

    public boolean m18445a() {
        return this.f15295a != null;
    }

    public boolean m18446a(C4457c c4457c) {
        if (c4457c == null) {
            return false;
        }
        boolean a = m18445a();
        boolean a2 = c4457c.m18445a();
        if ((a || a2) && (!a || !a2 || !this.f15295a.equals(c4457c.f15295a))) {
            return false;
        }
        a = m18449b();
        a2 = c4457c.m18449b();
        if ((a || a2) && (!a || !a2 || !this.f15296b.equals(c4457c.f15296b))) {
            return false;
        }
        a = m18450c();
        a2 = c4457c.m18450c();
        return !(a || a2) || (a && a2 && this.f15297c.equals(c4457c.f15297c));
    }

    public int m18447b(C4457c c4457c) {
        if (!getClass().equals(c4457c.getClass())) {
            return getClass().getName().compareTo(c4457c.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18445a()).compareTo(Boolean.valueOf(c4457c.m18445a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18445a()) {
            compareTo = C4593b.m19284a(this.f15295a, c4457c.f15295a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18449b()).compareTo(Boolean.valueOf(c4457c.m18449b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18449b()) {
            compareTo = C4593b.m19284a(this.f15296b, c4457c.f15296b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18450c()).compareTo(Boolean.valueOf(c4457c.m18450c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18450c()) {
            compareTo = C4593b.m19286a(this.f15297c, c4457c.f15297c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18448b(C4607e c4607e) {
        m18451d();
        c4607e.m19313a(f15291e);
        if (this.f15295a != null) {
            c4607e.m19310a(f15292f);
            c4607e.m19308a(this.f15295a);
            c4607e.m19316b();
        }
        if (this.f15296b != null && m18449b()) {
            c4607e.m19310a(f15293g);
            c4607e.m19308a(this.f15296b);
            c4607e.m19316b();
        }
        if (this.f15297c != null) {
            c4607e.m19310a(f15294h);
            c4607e.m19311a(new C4610c((byte) 12, this.f15297c.size()));
            for (C4455b b : this.f15297c) {
                b.m18421b(c4607e);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18449b() {
        return this.f15296b != null;
    }

    public boolean m18450c() {
        return this.f15297c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18447b((C4457c) obj);
    }

    public void m18451d() {
        if (this.f15295a == null) {
            throw new C4612f("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f15297c == null) {
            throw new C4612f("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4457c)) ? m18446a((C4457c) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvents(");
        stringBuilder.append("uuid:");
        if (this.f15295a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15295a);
        }
        if (m18449b()) {
            stringBuilder.append(", ");
            stringBuilder.append("operator:");
            if (this.f15296b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15296b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("events:");
        if (this.f15297c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15297c);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
