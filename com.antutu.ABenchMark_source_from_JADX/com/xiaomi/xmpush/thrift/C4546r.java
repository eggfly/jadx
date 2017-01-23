package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
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
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4602d;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4610c;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.r */
public class C4546r implements Serializable, Cloneable, C4454a<C4546r, C4545a> {
    public static final Map<C4545a, C4601b> f16066d;
    private static final C4615j f16067e;
    private static final C4609b f16068f;
    private static final C4609b f16069g;
    private static final C4609b f16070h;
    public List<C4522e> f16071a;
    public long f16072b;
    public String f16073c;
    private BitSet f16074i;

    /* renamed from: com.xiaomi.xmpush.thrift.r.a */
    public enum C4545a {
        NORMAL_CONFIGS((short) 1, "normalConfigs"),
        APP_ID((short) 4, ModelFields.APP_ID),
        PACKAGE_NAME((short) 5, Constants.KEY_PACKAGE_NAME);
        
        private static final Map<String, C4545a> f16062d;
        private final short f16064e;
        private final String f16065f;

        static {
            f16062d = new HashMap();
            Iterator it = EnumSet.allOf(C4545a.class).iterator();
            while (it.hasNext()) {
                C4545a c4545a = (C4545a) it.next();
                f16062d.put(c4545a.m19036a(), c4545a);
            }
        }

        private C4545a(short s, String str) {
            this.f16064e = s;
            this.f16065f = str;
        }

        public String m19036a() {
            return this.f16065f;
        }
    }

    static {
        f16067e = new C4615j("XmPushActionNormalConfig");
        f16068f = new C4609b("normalConfigs", (byte) 15, (short) 1);
        f16069g = new C4609b(ModelFields.APP_ID, (byte) 10, (short) 4);
        f16070h = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 5);
        Map enumMap = new EnumMap(C4545a.class);
        enumMap.put(C4545a.NORMAL_CONFIGS, new C4601b("normalConfigs", (byte) 1, new C4602d((byte) 15, new C4604f((byte) 12, C4522e.class))));
        enumMap.put(C4545a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4545a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        f16066d = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4546r.class, f16066d);
    }

    public C4546r() {
        this.f16074i = new BitSet(1);
    }

    public List<C4522e> m19037a() {
        return this.f16071a;
    }

    public void m19038a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19046e();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f16071a = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        C4522e c4522e = new C4522e();
                        c4522e.m18800a(c4607e);
                        this.f16071a.add(c4522e);
                    }
                    c4607e.m19327m();
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16072b = c4607e.m19334t();
                    m19039a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16073c = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19039a(boolean z) {
        this.f16074i.set(0, z);
    }

    public boolean m19040a(C4546r c4546r) {
        if (c4546r == null) {
            return false;
        }
        boolean b = m19043b();
        boolean b2 = c4546r.m19043b();
        if ((b || b2) && (!b || !b2 || !this.f16071a.equals(c4546r.f16071a))) {
            return false;
        }
        b = m19044c();
        b2 = c4546r.m19044c();
        if ((b || b2) && (!b || !b2 || this.f16072b != c4546r.f16072b)) {
            return false;
        }
        b = m19045d();
        b2 = c4546r.m19045d();
        return !(b || b2) || (b && b2 && this.f16073c.equals(c4546r.f16073c));
    }

    public int m19041b(C4546r c4546r) {
        if (!getClass().equals(c4546r.getClass())) {
            return getClass().getName().compareTo(c4546r.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19043b()).compareTo(Boolean.valueOf(c4546r.m19043b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19043b()) {
            compareTo = C4593b.m19286a(this.f16071a, c4546r.f16071a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19044c()).compareTo(Boolean.valueOf(c4546r.m19044c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19044c()) {
            compareTo = C4593b.m19282a(this.f16072b, c4546r.f16072b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19045d()).compareTo(Boolean.valueOf(c4546r.m19045d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19045d()) {
            compareTo = C4593b.m19284a(this.f16073c, c4546r.f16073c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19042b(C4607e c4607e) {
        m19046e();
        c4607e.m19313a(f16067e);
        if (this.f16071a != null) {
            c4607e.m19310a(f16068f);
            c4607e.m19311a(new C4610c((byte) 12, this.f16071a.size()));
            for (C4522e b : this.f16071a) {
                b.m18804b(c4607e);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        if (m19044c()) {
            c4607e.m19310a(f16069g);
            c4607e.m19307a(this.f16072b);
            c4607e.m19316b();
        }
        if (this.f16073c != null && m19045d()) {
            c4607e.m19310a(f16070h);
            c4607e.m19308a(this.f16073c);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19043b() {
        return this.f16071a != null;
    }

    public boolean m19044c() {
        return this.f16074i.get(0);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19041b((C4546r) obj);
    }

    public boolean m19045d() {
        return this.f16073c != null;
    }

    public void m19046e() {
        if (this.f16071a == null) {
            throw new C4612f("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4546r)) ? m19040a((C4546r) obj) : false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionNormalConfig(");
        stringBuilder.append("normalConfigs:");
        if (this.f16071a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16071a);
        }
        if (m19044c()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            stringBuilder.append(this.f16072b);
        }
        if (m19045d()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16073c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16073c);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
