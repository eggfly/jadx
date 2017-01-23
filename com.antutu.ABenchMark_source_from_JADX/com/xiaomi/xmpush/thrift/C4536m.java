package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.m */
public class C4536m implements Serializable, Cloneable, C4454a<C4536m, C4535a> {
    public static final Map<C4535a, C4601b> f15942c;
    private static final C4615j f15943d;
    private static final C4609b f15944e;
    private static final C4609b f15945f;
    public int f15946a;
    public int f15947b;
    private BitSet f15948g;

    /* renamed from: com.xiaomi.xmpush.thrift.m.a */
    public enum C4535a {
        MISC_CONFIG_VERSION((short) 1, "miscConfigVersion"),
        PLUGIN_CONFIG_VERSION((short) 2, "pluginConfigVersion");
        
        private static final Map<String, C4535a> f15938c;
        private final short f15940d;
        private final String f15941e;

        static {
            f15938c = new HashMap();
            Iterator it = EnumSet.allOf(C4535a.class).iterator();
            while (it.hasNext()) {
                C4535a c4535a = (C4535a) it.next();
                f15938c.put(c4535a.m18945a(), c4535a);
            }
        }

        private C4535a(short s, String str) {
            this.f15940d = s;
            this.f15941e = str;
        }

        public String m18945a() {
            return this.f15941e;
        }
    }

    static {
        f15943d = new C4615j("XmPushActionCheckClientInfo");
        f15944e = new C4609b("miscConfigVersion", (byte) 8, (short) 1);
        f15945f = new C4609b("pluginConfigVersion", (byte) 8, (short) 2);
        Map enumMap = new EnumMap(C4535a.class);
        enumMap.put(C4535a.MISC_CONFIG_VERSION, new C4601b("miscConfigVersion", (byte) 1, new C4599c((byte) 8)));
        enumMap.put(C4535a.PLUGIN_CONFIG_VERSION, new C4601b("pluginConfigVersion", (byte) 1, new C4599c((byte) 8)));
        f15942c = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4536m.class, f15942c);
    }

    public C4536m() {
        this.f15948g = new BitSet(2);
    }

    public C4536m m18946a(int i) {
        this.f15946a = i;
        m18948a(true);
        return this;
    }

    public void m18947a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (!m18949a()) {
                    throw new C4612f("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
                } else if (m18955b()) {
                    m18956c();
                    return;
                } else {
                    throw new C4612f("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15946a = c4607e.m19333s();
                    m18948a(true);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15947b = c4607e.m19333s();
                    m18954b(true);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18948a(boolean z) {
        this.f15948g.set(0, z);
    }

    public boolean m18949a() {
        return this.f15948g.get(0);
    }

    public boolean m18950a(C4536m c4536m) {
        return c4536m != null && this.f15946a == c4536m.f15946a && this.f15947b == c4536m.f15947b;
    }

    public int m18951b(C4536m c4536m) {
        if (!getClass().equals(c4536m.getClass())) {
            return getClass().getName().compareTo(c4536m.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18949a()).compareTo(Boolean.valueOf(c4536m.m18949a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18949a()) {
            compareTo = C4593b.m19281a(this.f15946a, c4536m.f15946a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18955b()).compareTo(Boolean.valueOf(c4536m.m18955b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18955b()) {
            compareTo = C4593b.m19281a(this.f15947b, c4536m.f15947b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4536m m18952b(int i) {
        this.f15947b = i;
        m18954b(true);
        return this;
    }

    public void m18953b(C4607e c4607e) {
        m18956c();
        c4607e.m19313a(f15943d);
        c4607e.m19310a(f15944e);
        c4607e.m19306a(this.f15946a);
        c4607e.m19316b();
        c4607e.m19310a(f15945f);
        c4607e.m19306a(this.f15947b);
        c4607e.m19316b();
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18954b(boolean z) {
        this.f15948g.set(1, z);
    }

    public boolean m18955b() {
        return this.f15948g.get(1);
    }

    public void m18956c() {
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18951b((C4536m) obj);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4536m)) ? m18950a((C4536m) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCheckClientInfo(");
        stringBuilder.append("miscConfigVersion:");
        stringBuilder.append(this.f15946a);
        stringBuilder.append(", ");
        stringBuilder.append("pluginConfigVersion:");
        stringBuilder.append(this.f15947b);
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
