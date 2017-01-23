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

/* renamed from: com.xiaomi.xmpush.thrift.z */
public class C4562z implements Serializable, Cloneable, C4454a<C4562z, C4561a> {
    public static final Map<C4561a, C4601b> f16367k;
    private static final C4615j f16368l;
    private static final C4609b f16369m;
    private static final C4609b f16370n;
    private static final C4609b f16371o;
    private static final C4609b f16372p;
    private static final C4609b f16373q;
    private static final C4609b f16374r;
    private static final C4609b f16375s;
    private static final C4609b f16376t;
    private static final C4609b f16377u;
    private static final C4609b f16378v;
    public String f16379a;
    public C4532k f16380b;
    public String f16381c;
    public String f16382d;
    public C4560y f16383e;
    public long f16384f;
    public String f16385g;
    public String f16386h;
    public String f16387i;
    public String f16388j;
    private BitSet f16389w;

    /* renamed from: com.xiaomi.xmpush.thrift.z.a */
    public enum C4561a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        REQUEST((short) 5, "request"),
        ERROR_CODE((short) 6, Constants.KEY_ERROR_CODE),
        REASON((short) 7, "reason"),
        TOPIC((short) 8, "topic"),
        PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 10, "category");
        
        private static final Map<String, C4561a> f16363k;
        private final short f16365l;
        private final String f16366m;

        static {
            f16363k = new HashMap();
            Iterator it = EnumSet.allOf(C4561a.class).iterator();
            while (it.hasNext()) {
                C4561a c4561a = (C4561a) it.next();
                f16363k.put(c4561a.m19213a(), c4561a);
            }
        }

        private C4561a(short s, String str) {
            this.f16365l = s;
            this.f16366m = str;
        }

        public String m19213a() {
            return this.f16366m;
        }
    }

    static {
        f16368l = new C4615j("XmPushActionSubscriptionResult");
        f16369m = new C4609b("debug", (byte) 11, (short) 1);
        f16370n = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16371o = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16372p = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16373q = new C4609b("request", (byte) 12, (short) 5);
        f16374r = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 6);
        f16375s = new C4609b("reason", (byte) 11, (short) 7);
        f16376t = new C4609b("topic", (byte) 11, (short) 8);
        f16377u = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
        f16378v = new C4609b("category", (byte) 11, (short) 10);
        Map enumMap = new EnumMap(C4561a.class);
        enumMap.put(C4561a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4561a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4561a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4561a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4561a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, C4560y.class)));
        enumMap.put(C4561a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4561a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4561a.TOPIC, new C4601b("topic", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4561a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4561a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f16367k = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4562z.class, f16367k);
    }

    public C4562z() {
        this.f16389w = new BitSet(1);
    }

    public void m19214a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19231m();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16379a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16380b = new C4532k();
                    this.f16380b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16381c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16382d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16383e = new C4560y();
                    this.f16383e.m19197a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16384f = c4607e.m19334t();
                    m19215a(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16385g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16386h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16387i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16388j = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19215a(boolean z) {
        this.f16389w.set(0, z);
    }

    public boolean m19216a() {
        return this.f16379a != null;
    }

    public boolean m19217a(C4562z c4562z) {
        if (c4562z == null) {
            return false;
        }
        boolean a = m19216a();
        boolean a2 = c4562z.m19216a();
        if ((a || a2) && (!a || !a2 || !this.f16379a.equals(c4562z.f16379a))) {
            return false;
        }
        a = m19220b();
        a2 = c4562z.m19220b();
        if ((a || a2) && (!a || !a2 || !this.f16380b.m18904a(c4562z.f16380b))) {
            return false;
        }
        a = m19221c();
        a2 = c4562z.m19221c();
        if ((a || a2) && (!a || !a2 || !this.f16381c.equals(c4562z.f16381c))) {
            return false;
        }
        a = m19222d();
        a2 = c4562z.m19222d();
        if ((a || a2) && (!a || !a2 || !this.f16382d.equals(c4562z.f16382d))) {
            return false;
        }
        a = m19223e();
        a2 = c4562z.m19223e();
        if ((a || a2) && (!a || !a2 || !this.f16383e.m19199a(c4562z.f16383e))) {
            return false;
        }
        a = m19224f();
        a2 = c4562z.m19224f();
        if ((a || a2) && (!a || !a2 || this.f16384f != c4562z.f16384f)) {
            return false;
        }
        a = m19225g();
        a2 = c4562z.m19225g();
        if ((a || a2) && (!a || !a2 || !this.f16385g.equals(c4562z.f16385g))) {
            return false;
        }
        a = m19227i();
        a2 = c4562z.m19227i();
        if ((a || a2) && (!a || !a2 || !this.f16386h.equals(c4562z.f16386h))) {
            return false;
        }
        a = m19228j();
        a2 = c4562z.m19228j();
        if ((a || a2) && (!a || !a2 || !this.f16387i.equals(c4562z.f16387i))) {
            return false;
        }
        a = m19230l();
        a2 = c4562z.m19230l();
        return !(a || a2) || (a && a2 && this.f16388j.equals(c4562z.f16388j));
    }

    public int m19218b(C4562z c4562z) {
        if (!getClass().equals(c4562z.getClass())) {
            return getClass().getName().compareTo(c4562z.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19216a()).compareTo(Boolean.valueOf(c4562z.m19216a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19216a()) {
            compareTo = C4593b.m19284a(this.f16379a, c4562z.f16379a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19220b()).compareTo(Boolean.valueOf(c4562z.m19220b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19220b()) {
            compareTo = C4593b.m19283a(this.f16380b, c4562z.f16380b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19221c()).compareTo(Boolean.valueOf(c4562z.m19221c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19221c()) {
            compareTo = C4593b.m19284a(this.f16381c, c4562z.f16381c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19222d()).compareTo(Boolean.valueOf(c4562z.m19222d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19222d()) {
            compareTo = C4593b.m19284a(this.f16382d, c4562z.f16382d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19223e()).compareTo(Boolean.valueOf(c4562z.m19223e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19223e()) {
            compareTo = C4593b.m19283a(this.f16383e, c4562z.f16383e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19224f()).compareTo(Boolean.valueOf(c4562z.m19224f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19224f()) {
            compareTo = C4593b.m19282a(this.f16384f, c4562z.f16384f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19225g()).compareTo(Boolean.valueOf(c4562z.m19225g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19225g()) {
            compareTo = C4593b.m19284a(this.f16385g, c4562z.f16385g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19227i()).compareTo(Boolean.valueOf(c4562z.m19227i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19227i()) {
            compareTo = C4593b.m19284a(this.f16386h, c4562z.f16386h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19228j()).compareTo(Boolean.valueOf(c4562z.m19228j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19228j()) {
            compareTo = C4593b.m19284a(this.f16387i, c4562z.f16387i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19230l()).compareTo(Boolean.valueOf(c4562z.m19230l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19230l()) {
            compareTo = C4593b.m19284a(this.f16388j, c4562z.f16388j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19219b(C4607e c4607e) {
        m19231m();
        c4607e.m19313a(f16368l);
        if (this.f16379a != null && m19216a()) {
            c4607e.m19310a(f16369m);
            c4607e.m19308a(this.f16379a);
            c4607e.m19316b();
        }
        if (this.f16380b != null && m19220b()) {
            c4607e.m19310a(f16370n);
            this.f16380b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16381c != null) {
            c4607e.m19310a(f16371o);
            c4607e.m19308a(this.f16381c);
            c4607e.m19316b();
        }
        if (this.f16382d != null && m19222d()) {
            c4607e.m19310a(f16372p);
            c4607e.m19308a(this.f16382d);
            c4607e.m19316b();
        }
        if (this.f16383e != null && m19223e()) {
            c4607e.m19310a(f16373q);
            this.f16383e.m19202b(c4607e);
            c4607e.m19316b();
        }
        if (m19224f()) {
            c4607e.m19310a(f16374r);
            c4607e.m19307a(this.f16384f);
            c4607e.m19316b();
        }
        if (this.f16385g != null && m19225g()) {
            c4607e.m19310a(f16375s);
            c4607e.m19308a(this.f16385g);
            c4607e.m19316b();
        }
        if (this.f16386h != null && m19227i()) {
            c4607e.m19310a(f16376t);
            c4607e.m19308a(this.f16386h);
            c4607e.m19316b();
        }
        if (this.f16387i != null && m19228j()) {
            c4607e.m19310a(f16377u);
            c4607e.m19308a(this.f16387i);
            c4607e.m19316b();
        }
        if (this.f16388j != null && m19230l()) {
            c4607e.m19310a(f16378v);
            c4607e.m19308a(this.f16388j);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19220b() {
        return this.f16380b != null;
    }

    public boolean m19221c() {
        return this.f16381c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19218b((C4562z) obj);
    }

    public boolean m19222d() {
        return this.f16382d != null;
    }

    public boolean m19223e() {
        return this.f16383e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4562z)) ? m19217a((C4562z) obj) : false;
    }

    public boolean m19224f() {
        return this.f16389w.get(0);
    }

    public boolean m19225g() {
        return this.f16385g != null;
    }

    public String m19226h() {
        return this.f16386h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m19227i() {
        return this.f16386h != null;
    }

    public boolean m19228j() {
        return this.f16387i != null;
    }

    public String m19229k() {
        return this.f16388j;
    }

    public boolean m19230l() {
        return this.f16388j != null;
    }

    public void m19231m() {
        if (this.f16381c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSubscriptionResult(");
        Object obj2 = 1;
        if (m19216a()) {
            stringBuilder.append("debug:");
            if (this.f16379a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16379a);
            }
            obj2 = null;
        }
        if (m19220b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16380b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16380b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16381c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16381c);
        }
        if (m19222d()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            if (this.f16382d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16382d);
            }
        }
        if (m19223e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f16383e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16383e);
            }
        }
        if (m19224f()) {
            stringBuilder.append(", ");
            stringBuilder.append("errorCode:");
            stringBuilder.append(this.f16384f);
        }
        if (m19225g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f16385g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16385g);
            }
        }
        if (m19227i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f16386h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16386h);
            }
        }
        if (m19228j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16387i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16387i);
            }
        }
        if (m19230l()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16388j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16388j);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
