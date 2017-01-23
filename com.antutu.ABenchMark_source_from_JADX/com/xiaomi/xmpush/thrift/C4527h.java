package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.h */
public class C4527h implements Serializable, Cloneable, C4454a<C4527h, C4526a> {
    public static final Map<C4526a, C4601b> f15789i;
    private static final C4615j f15790j;
    private static final C4609b f15791k;
    private static final C4609b f15792l;
    private static final C4609b f15793m;
    private static final C4609b f15794n;
    private static final C4609b f15795o;
    private static final C4609b f15796p;
    private static final C4609b f15797q;
    private static final C4609b f15798r;
    public C4532k f15799a;
    public String f15800b;
    public String f15801c;
    public String f15802d;
    public long f15803e;
    public long f15804f;
    public String f15805g;
    public String f15806h;
    private BitSet f15807s;

    /* renamed from: com.xiaomi.xmpush.thrift.h.a */
    public enum C4526a {
        TO((short) 1, "to"),
        ID((short) 2, AgooConstants.MESSAGE_ID),
        APP_ID((short) 3, ModelFields.APP_ID),
        PAYLOAD((short) 4, "payload"),
        CREATE_AT((short) 5, "createAt"),
        TTL((short) 6, "ttl"),
        COLLAPSE_KEY((short) 7, "collapseKey"),
        PACKAGE_NAME((short) 8, Constants.KEY_PACKAGE_NAME);
        
        private static final Map<String, C4526a> f15785i;
        private final short f15787j;
        private final String f15788k;

        static {
            f15785i = new HashMap();
            Iterator it = EnumSet.allOf(C4526a.class).iterator();
            while (it.hasNext()) {
                C4526a c4526a = (C4526a) it.next();
                f15785i.put(c4526a.m18835a(), c4526a);
            }
        }

        private C4526a(short s, String str) {
            this.f15787j = s;
            this.f15788k = str;
        }

        public String m18835a() {
            return this.f15788k;
        }
    }

    static {
        f15790j = new C4615j("PushMessage");
        f15791k = new C4609b("to", (byte) 12, (short) 1);
        f15792l = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 2);
        f15793m = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 3);
        f15794n = new C4609b("payload", (byte) 11, (short) 4);
        f15795o = new C4609b("createAt", (byte) 10, (short) 5);
        f15796p = new C4609b("ttl", (byte) 10, (short) 6);
        f15797q = new C4609b("collapseKey", (byte) 11, (short) 7);
        f15798r = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 8);
        Map enumMap = new EnumMap(C4526a.class);
        enumMap.put(C4526a.TO, new C4601b("to", (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4526a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4526a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4526a.PAYLOAD, new C4601b("payload", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4526a.CREATE_AT, new C4601b("createAt", (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4526a.TTL, new C4601b("ttl", (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4526a.COLLAPSE_KEY, new C4601b("collapseKey", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4526a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        f15789i = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4527h.class, f15789i);
    }

    public C4527h() {
        this.f15807s = new BitSet(2);
    }

    public void m18836a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18854m();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15799a = new C4532k();
                    this.f15799a.m18901a(c4607e);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15800b = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15801c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15802d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15803e = c4607e.m19334t();
                    m18837a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15804f = c4607e.m19334t();
                    m18843b(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15805g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15806h = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18837a(boolean z) {
        this.f15807s.set(0, z);
    }

    public boolean m18838a() {
        return this.f15799a != null;
    }

    public boolean m18839a(C4527h c4527h) {
        if (c4527h == null) {
            return false;
        }
        boolean a = m18838a();
        boolean a2 = c4527h.m18838a();
        if ((a || a2) && (!a || !a2 || !this.f15799a.m18904a(c4527h.f15799a))) {
            return false;
        }
        a = m18844c();
        a2 = c4527h.m18844c();
        if ((a || a2) && (!a || !a2 || !this.f15800b.equals(c4527h.f15800b))) {
            return false;
        }
        a = m18846e();
        a2 = c4527h.m18846e();
        if ((a || a2) && (!a || !a2 || !this.f15801c.equals(c4527h.f15801c))) {
            return false;
        }
        a = m18848g();
        a2 = c4527h.m18848g();
        if ((a || a2) && (!a || !a2 || !this.f15802d.equals(c4527h.f15802d))) {
            return false;
        }
        a = m18850i();
        a2 = c4527h.m18850i();
        if ((a || a2) && (!a || !a2 || this.f15803e != c4527h.f15803e)) {
            return false;
        }
        a = m18851j();
        a2 = c4527h.m18851j();
        if ((a || a2) && (!a || !a2 || this.f15804f != c4527h.f15804f)) {
            return false;
        }
        a = m18852k();
        a2 = c4527h.m18852k();
        if ((a || a2) && (!a || !a2 || !this.f15805g.equals(c4527h.f15805g))) {
            return false;
        }
        a = m18853l();
        a2 = c4527h.m18853l();
        return !(a || a2) || (a && a2 && this.f15806h.equals(c4527h.f15806h));
    }

    public int m18840b(C4527h c4527h) {
        if (!getClass().equals(c4527h.getClass())) {
            return getClass().getName().compareTo(c4527h.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18838a()).compareTo(Boolean.valueOf(c4527h.m18838a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18838a()) {
            compareTo = C4593b.m19283a(this.f15799a, c4527h.f15799a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18844c()).compareTo(Boolean.valueOf(c4527h.m18844c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18844c()) {
            compareTo = C4593b.m19284a(this.f15800b, c4527h.f15800b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18846e()).compareTo(Boolean.valueOf(c4527h.m18846e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18846e()) {
            compareTo = C4593b.m19284a(this.f15801c, c4527h.f15801c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18848g()).compareTo(Boolean.valueOf(c4527h.m18848g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18848g()) {
            compareTo = C4593b.m19284a(this.f15802d, c4527h.f15802d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18850i()).compareTo(Boolean.valueOf(c4527h.m18850i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18850i()) {
            compareTo = C4593b.m19282a(this.f15803e, c4527h.f15803e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18851j()).compareTo(Boolean.valueOf(c4527h.m18851j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18851j()) {
            compareTo = C4593b.m19282a(this.f15804f, c4527h.f15804f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18852k()).compareTo(Boolean.valueOf(c4527h.m18852k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18852k()) {
            compareTo = C4593b.m19284a(this.f15805g, c4527h.f15805g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18853l()).compareTo(Boolean.valueOf(c4527h.m18853l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18853l()) {
            compareTo = C4593b.m19284a(this.f15806h, c4527h.f15806h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public String m18841b() {
        return this.f15800b;
    }

    public void m18842b(C4607e c4607e) {
        m18854m();
        c4607e.m19313a(f15790j);
        if (this.f15799a != null && m18838a()) {
            c4607e.m19310a(f15791k);
            this.f15799a.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15800b != null) {
            c4607e.m19310a(f15792l);
            c4607e.m19308a(this.f15800b);
            c4607e.m19316b();
        }
        if (this.f15801c != null) {
            c4607e.m19310a(f15793m);
            c4607e.m19308a(this.f15801c);
            c4607e.m19316b();
        }
        if (this.f15802d != null) {
            c4607e.m19310a(f15794n);
            c4607e.m19308a(this.f15802d);
            c4607e.m19316b();
        }
        if (m18850i()) {
            c4607e.m19310a(f15795o);
            c4607e.m19307a(this.f15803e);
            c4607e.m19316b();
        }
        if (m18851j()) {
            c4607e.m19310a(f15796p);
            c4607e.m19307a(this.f15804f);
            c4607e.m19316b();
        }
        if (this.f15805g != null && m18852k()) {
            c4607e.m19310a(f15797q);
            c4607e.m19308a(this.f15805g);
            c4607e.m19316b();
        }
        if (this.f15806h != null && m18853l()) {
            c4607e.m19310a(f15798r);
            c4607e.m19308a(this.f15806h);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18843b(boolean z) {
        this.f15807s.set(1, z);
    }

    public boolean m18844c() {
        return this.f15800b != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18840b((C4527h) obj);
    }

    public String m18845d() {
        return this.f15801c;
    }

    public boolean m18846e() {
        return this.f15801c != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4527h)) ? m18839a((C4527h) obj) : false;
    }

    public String m18847f() {
        return this.f15802d;
    }

    public boolean m18848g() {
        return this.f15802d != null;
    }

    public long m18849h() {
        return this.f15803e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18850i() {
        return this.f15807s.get(0);
    }

    public boolean m18851j() {
        return this.f15807s.get(1);
    }

    public boolean m18852k() {
        return this.f15805g != null;
    }

    public boolean m18853l() {
        return this.f15806h != null;
    }

    public void m18854m() {
        if (this.f15800b == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15801c == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f15802d == null) {
            throw new C4612f("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushMessage(");
        Object obj = 1;
        if (m18838a()) {
            stringBuilder.append("to:");
            if (this.f15799a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15799a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15800b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15800b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15801c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15801c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("payload:");
        if (this.f15802d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15802d);
        }
        if (m18850i()) {
            stringBuilder.append(", ");
            stringBuilder.append("createAt:");
            stringBuilder.append(this.f15803e);
        }
        if (m18851j()) {
            stringBuilder.append(", ");
            stringBuilder.append("ttl:");
            stringBuilder.append(this.f15804f);
        }
        if (m18852k()) {
            stringBuilder.append(", ");
            stringBuilder.append("collapseKey:");
            if (this.f15805g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15805g);
            }
        }
        if (m18853l()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15806h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15806h);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
