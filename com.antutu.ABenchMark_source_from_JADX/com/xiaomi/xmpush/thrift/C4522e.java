package com.xiaomi.xmpush.thrift;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
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
import org.apache.thrift.meta_data.C4600a;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4602d;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4610c;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.e */
public class C4522e implements Serializable, Cloneable, C4454a<C4522e, C4521a> {
    public static final Map<C4521a, C4601b> f15712d;
    private static final C4615j f15713e;
    private static final C4609b f15714f;
    private static final C4609b f15715g;
    private static final C4609b f15716h;
    public int f15717a;
    public List<C4525g> f15718b;
    public C4519c f15719c;
    private BitSet f15720i;

    /* renamed from: com.xiaomi.xmpush.thrift.e.a */
    public enum C4521a {
        VERSION((short) 1, Constants.SP_KEY_VERSION),
        CONFIG_ITEMS((short) 2, "configItems"),
        TYPE((short) 3, C4233j.f14402y);
        
        private static final Map<String, C4521a> f15708d;
        private final short f15710e;
        private final String f15711f;

        static {
            f15708d = new HashMap();
            Iterator it = EnumSet.allOf(C4521a.class).iterator();
            while (it.hasNext()) {
                C4521a c4521a = (C4521a) it.next();
                f15708d.put(c4521a.m18798a(), c4521a);
            }
        }

        private C4521a(short s, String str) {
            this.f15710e = s;
            this.f15711f = str;
        }

        public String m18798a() {
            return this.f15711f;
        }
    }

    static {
        f15713e = new C4615j("NormalConfig");
        f15714f = new C4609b(Constants.SP_KEY_VERSION, (byte) 8, (short) 1);
        f15715g = new C4609b("configItems", (byte) 15, (short) 2);
        f15716h = new C4609b(C4233j.f14402y, (byte) 8, (short) 3);
        Map enumMap = new EnumMap(C4521a.class);
        enumMap.put(C4521a.VERSION, new C4601b(Constants.SP_KEY_VERSION, (byte) 1, new C4599c((byte) 8)));
        enumMap.put(C4521a.CONFIG_ITEMS, new C4601b("configItems", (byte) 1, new C4602d((byte) 15, new C4604f((byte) 12, C4525g.class))));
        enumMap.put(C4521a.TYPE, new C4601b(C4233j.f14402y, (byte) 1, new C4600a((byte) 16, C4519c.class)));
        f15712d = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4522e.class, f15712d);
    }

    public C4522e() {
        this.f15720i = new BitSet(1);
    }

    public int m18799a() {
        return this.f15717a;
    }

    public void m18800a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18805b()) {
                    m18809f();
                    return;
                }
                throw new C4612f("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15717a = c4607e.m19333s();
                    m18801a(true);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f15718b = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        C4525g c4525g = new C4525g();
                        c4525g.m18812a(c4607e);
                        this.f15718b.add(c4525g);
                    }
                    c4607e.m19327m();
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15719c = C4519c.m18795a(c4607e.m19333s());
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18801a(boolean z) {
        this.f15720i.set(0, z);
    }

    public boolean m18802a(C4522e c4522e) {
        if (c4522e == null || this.f15717a != c4522e.f15717a) {
            return false;
        }
        boolean c = m18806c();
        boolean c2 = c4522e.m18806c();
        if ((c || c2) && (!c || !c2 || !this.f15718b.equals(c4522e.f15718b))) {
            return false;
        }
        c = m18808e();
        c2 = c4522e.m18808e();
        return !(c || c2) || (c && c2 && this.f15719c.equals(c4522e.f15719c));
    }

    public int m18803b(C4522e c4522e) {
        if (!getClass().equals(c4522e.getClass())) {
            return getClass().getName().compareTo(c4522e.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18805b()).compareTo(Boolean.valueOf(c4522e.m18805b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18805b()) {
            compareTo = C4593b.m19281a(this.f15717a, c4522e.f15717a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18806c()).compareTo(Boolean.valueOf(c4522e.m18806c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18806c()) {
            compareTo = C4593b.m19286a(this.f15718b, c4522e.f15718b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18808e()).compareTo(Boolean.valueOf(c4522e.m18808e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18808e()) {
            compareTo = C4593b.m19283a(this.f15719c, c4522e.f15719c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18804b(C4607e c4607e) {
        m18809f();
        c4607e.m19313a(f15713e);
        c4607e.m19310a(f15714f);
        c4607e.m19306a(this.f15717a);
        c4607e.m19316b();
        if (this.f15718b != null) {
            c4607e.m19310a(f15715g);
            c4607e.m19311a(new C4610c((byte) 12, this.f15718b.size()));
            for (C4525g b : this.f15718b) {
                b.m18816b(c4607e);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        if (this.f15719c != null) {
            c4607e.m19310a(f15716h);
            c4607e.m19306a(this.f15719c.m18796a());
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18805b() {
        return this.f15720i.get(0);
    }

    public boolean m18806c() {
        return this.f15718b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18803b((C4522e) obj);
    }

    public C4519c m18807d() {
        return this.f15719c;
    }

    public boolean m18808e() {
        return this.f15719c != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4522e)) ? m18802a((C4522e) obj) : false;
    }

    public void m18809f() {
        if (this.f15718b == null) {
            throw new C4612f("Required field 'configItems' was not present! Struct: " + toString());
        } else if (this.f15719c == null) {
            throw new C4612f("Required field 'type' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NormalConfig(");
        stringBuilder.append("version:");
        stringBuilder.append(this.f15717a);
        stringBuilder.append(", ");
        stringBuilder.append("configItems:");
        if (this.f15718b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15718b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        if (this.f15719c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15719c);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
