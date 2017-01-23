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

/* renamed from: com.xiaomi.xmpush.thrift.u */
public class C4552u implements Serializable, Cloneable, C4454a<C4552u, C4551a> {
    public static final Map<C4551a, C4601b> f16205k;
    private static final C4615j f16206l;
    private static final C4609b f16207m;
    private static final C4609b f16208n;
    private static final C4609b f16209o;
    private static final C4609b f16210p;
    private static final C4609b f16211q;
    private static final C4609b f16212r;
    private static final C4609b f16213s;
    private static final C4609b f16214t;
    private static final C4609b f16215u;
    private static final C4609b f16216v;
    public String f16217a;
    public C4532k f16218b;
    public String f16219c;
    public String f16220d;
    public C4550t f16221e;
    public long f16222f;
    public String f16223g;
    public String f16224h;
    public String f16225i;
    public String f16226j;
    private BitSet f16227w;

    /* renamed from: com.xiaomi.xmpush.thrift.u.a */
    public enum C4551a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        REQUEST((short) 5, "request"),
        ERROR_CODE((short) 6, Constants.KEY_ERROR_CODE),
        REASON((short) 7, "reason"),
        REG_ID((short) 8, "regId"),
        REG_SECRET((short) 9, "regSecret"),
        PACKAGE_NAME((short) 10, Constants.KEY_PACKAGE_NAME);
        
        private static final Map<String, C4551a> f16201k;
        private final short f16203l;
        private final String f16204m;

        static {
            f16201k = new HashMap();
            Iterator it = EnumSet.allOf(C4551a.class).iterator();
            while (it.hasNext()) {
                C4551a c4551a = (C4551a) it.next();
                f16201k.put(c4551a.m19125a(), c4551a);
            }
        }

        private C4551a(short s, String str) {
            this.f16203l = s;
            this.f16204m = str;
        }

        public String m19125a() {
            return this.f16204m;
        }
    }

    static {
        f16206l = new C4615j("XmPushActionRegistrationResult");
        f16207m = new C4609b("debug", (byte) 11, (short) 1);
        f16208n = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16209o = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16210p = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16211q = new C4609b("request", (byte) 12, (short) 5);
        f16212r = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 6);
        f16213s = new C4609b("reason", (byte) 11, (short) 7);
        f16214t = new C4609b("regId", (byte) 11, (short) 8);
        f16215u = new C4609b("regSecret", (byte) 11, (short) 9);
        f16216v = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 10);
        Map enumMap = new EnumMap(C4551a.class);
        enumMap.put(C4551a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4551a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4551a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4551a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4551a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, C4550t.class)));
        enumMap.put(C4551a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4551a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4551a.REG_ID, new C4601b("regId", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4551a.REG_SECRET, new C4601b("regSecret", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4551a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        f16205k = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4552u.class, f16205k);
    }

    public C4552u() {
        this.f16227w = new BitSet(1);
    }

    public void m19126a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m19136f()) {
                    m19141k();
                    return;
                }
                throw new C4612f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16217a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16218b = new C4532k();
                    this.f16218b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16219c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16220d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16221e = new C4550t();
                    this.f16221e.m19079a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16222f = c4607e.m19334t();
                    m19127a(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16223g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16224h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16225i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16226j = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19127a(boolean z) {
        this.f16227w.set(0, z);
    }

    public boolean m19128a() {
        return this.f16217a != null;
    }

    public boolean m19129a(C4552u c4552u) {
        if (c4552u == null) {
            return false;
        }
        boolean a = m19128a();
        boolean a2 = c4552u.m19128a();
        if ((a || a2) && (!a || !a2 || !this.f16217a.equals(c4552u.f16217a))) {
            return false;
        }
        a = m19132b();
        a2 = c4552u.m19132b();
        if ((a || a2) && (!a || !a2 || !this.f16218b.m18904a(c4552u.f16218b))) {
            return false;
        }
        a = m19133c();
        a2 = c4552u.m19133c();
        if ((a || a2) && (!a || !a2 || !this.f16219c.equals(c4552u.f16219c))) {
            return false;
        }
        a = m19134d();
        a2 = c4552u.m19134d();
        if ((a || a2) && (!a || !a2 || !this.f16220d.equals(c4552u.f16220d))) {
            return false;
        }
        a = m19135e();
        a2 = c4552u.m19135e();
        if (((a || a2) && (!a || !a2 || !this.f16221e.m19082a(c4552u.f16221e))) || this.f16222f != c4552u.f16222f) {
            return false;
        }
        a = m19137g();
        a2 = c4552u.m19137g();
        if ((a || a2) && (!a || !a2 || !this.f16223g.equals(c4552u.f16223g))) {
            return false;
        }
        a = m19138h();
        a2 = c4552u.m19138h();
        if ((a || a2) && (!a || !a2 || !this.f16224h.equals(c4552u.f16224h))) {
            return false;
        }
        a = m19139i();
        a2 = c4552u.m19139i();
        if ((a || a2) && (!a || !a2 || !this.f16225i.equals(c4552u.f16225i))) {
            return false;
        }
        a = m19140j();
        a2 = c4552u.m19140j();
        return !(a || a2) || (a && a2 && this.f16226j.equals(c4552u.f16226j));
    }

    public int m19130b(C4552u c4552u) {
        if (!getClass().equals(c4552u.getClass())) {
            return getClass().getName().compareTo(c4552u.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19128a()).compareTo(Boolean.valueOf(c4552u.m19128a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19128a()) {
            compareTo = C4593b.m19284a(this.f16217a, c4552u.f16217a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19132b()).compareTo(Boolean.valueOf(c4552u.m19132b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19132b()) {
            compareTo = C4593b.m19283a(this.f16218b, c4552u.f16218b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19133c()).compareTo(Boolean.valueOf(c4552u.m19133c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19133c()) {
            compareTo = C4593b.m19284a(this.f16219c, c4552u.f16219c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19134d()).compareTo(Boolean.valueOf(c4552u.m19134d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19134d()) {
            compareTo = C4593b.m19284a(this.f16220d, c4552u.f16220d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19135e()).compareTo(Boolean.valueOf(c4552u.m19135e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19135e()) {
            compareTo = C4593b.m19283a(this.f16221e, c4552u.f16221e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19136f()).compareTo(Boolean.valueOf(c4552u.m19136f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19136f()) {
            compareTo = C4593b.m19282a(this.f16222f, c4552u.f16222f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19137g()).compareTo(Boolean.valueOf(c4552u.m19137g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19137g()) {
            compareTo = C4593b.m19284a(this.f16223g, c4552u.f16223g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19138h()).compareTo(Boolean.valueOf(c4552u.m19138h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19138h()) {
            compareTo = C4593b.m19284a(this.f16224h, c4552u.f16224h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19139i()).compareTo(Boolean.valueOf(c4552u.m19139i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19139i()) {
            compareTo = C4593b.m19284a(this.f16225i, c4552u.f16225i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19140j()).compareTo(Boolean.valueOf(c4552u.m19140j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19140j()) {
            compareTo = C4593b.m19284a(this.f16226j, c4552u.f16226j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19131b(C4607e c4607e) {
        m19141k();
        c4607e.m19313a(f16206l);
        if (this.f16217a != null && m19128a()) {
            c4607e.m19310a(f16207m);
            c4607e.m19308a(this.f16217a);
            c4607e.m19316b();
        }
        if (this.f16218b != null && m19132b()) {
            c4607e.m19310a(f16208n);
            this.f16218b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16219c != null) {
            c4607e.m19310a(f16209o);
            c4607e.m19308a(this.f16219c);
            c4607e.m19316b();
        }
        if (this.f16220d != null) {
            c4607e.m19310a(f16210p);
            c4607e.m19308a(this.f16220d);
            c4607e.m19316b();
        }
        if (this.f16221e != null && m19135e()) {
            c4607e.m19310a(f16211q);
            this.f16221e.m19086b(c4607e);
            c4607e.m19316b();
        }
        c4607e.m19310a(f16212r);
        c4607e.m19307a(this.f16222f);
        c4607e.m19316b();
        if (this.f16223g != null && m19137g()) {
            c4607e.m19310a(f16213s);
            c4607e.m19308a(this.f16223g);
            c4607e.m19316b();
        }
        if (this.f16224h != null && m19138h()) {
            c4607e.m19310a(f16214t);
            c4607e.m19308a(this.f16224h);
            c4607e.m19316b();
        }
        if (this.f16225i != null && m19139i()) {
            c4607e.m19310a(f16215u);
            c4607e.m19308a(this.f16225i);
            c4607e.m19316b();
        }
        if (this.f16226j != null && m19140j()) {
            c4607e.m19310a(f16216v);
            c4607e.m19308a(this.f16226j);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19132b() {
        return this.f16218b != null;
    }

    public boolean m19133c() {
        return this.f16219c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19130b((C4552u) obj);
    }

    public boolean m19134d() {
        return this.f16220d != null;
    }

    public boolean m19135e() {
        return this.f16221e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4552u)) ? m19129a((C4552u) obj) : false;
    }

    public boolean m19136f() {
        return this.f16227w.get(0);
    }

    public boolean m19137g() {
        return this.f16223g != null;
    }

    public boolean m19138h() {
        return this.f16224h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m19139i() {
        return this.f16225i != null;
    }

    public boolean m19140j() {
        return this.f16226j != null;
    }

    public void m19141k() {
        if (this.f16219c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16220d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionRegistrationResult(");
        Object obj2 = 1;
        if (m19128a()) {
            stringBuilder.append("debug:");
            if (this.f16217a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16217a);
            }
            obj2 = null;
        }
        if (m19132b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16218b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16218b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16219c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16219c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16220d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16220d);
        }
        if (m19135e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f16221e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16221e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.f16222f);
        if (m19137g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f16223g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16223g);
            }
        }
        if (m19138h()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            if (this.f16224h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16224h);
            }
        }
        if (m19139i()) {
            stringBuilder.append(", ");
            stringBuilder.append("regSecret:");
            if (this.f16225i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16225i);
            }
        }
        if (m19140j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16226j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16226j);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
