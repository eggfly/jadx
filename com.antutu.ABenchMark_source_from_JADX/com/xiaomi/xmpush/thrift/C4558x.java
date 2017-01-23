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
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4603e;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4611d;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.x */
public class C4558x implements Serializable, Cloneable, C4454a<C4558x, C4557a> {
    public static final Map<C4557a, C4601b> f16299m;
    private static final C4615j f16300n;
    private static final C4609b f16301o;
    private static final C4609b f16302p;
    private static final C4609b f16303q;
    private static final C4609b f16304r;
    private static final C4609b f16305s;
    private static final C4609b f16306t;
    private static final C4609b f16307u;
    private static final C4609b f16308v;
    private static final C4609b f16309w;
    private static final C4609b f16310x;
    private static final C4609b f16311y;
    private static final C4609b f16312z;
    private BitSet f16313A;
    public String f16314a;
    public C4532k f16315b;
    public String f16316c;
    public String f16317d;
    public String f16318e;
    public String f16319f;
    public String f16320g;
    public C4527h f16321h;
    public boolean f16322i;
    public Map<String, String> f16323j;
    public String f16324k;
    public String f16325l;

    /* renamed from: com.xiaomi.xmpush.thrift.x.a */
    public enum C4557a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        PACKAGE_NAME((short) 5, Constants.KEY_PACKAGE_NAME),
        TOPIC((short) 6, "topic"),
        ALIAS_NAME((short) 7, "aliasName"),
        MESSAGE((short) 8, C4233j.f14376C),
        NEED_ACK((short) 9, "needAck"),
        PARAMS((short) 10, "params"),
        CATEGORY((short) 11, "category"),
        USER_ACCOUNT((short) 12, "userAccount");
        
        private static final Map<String, C4557a> f16295m;
        private final short f16297n;
        private final String f16298o;

        static {
            f16295m = new HashMap();
            Iterator it = EnumSet.allOf(C4557a.class).iterator();
            while (it.hasNext()) {
                C4557a c4557a = (C4557a) it.next();
                f16295m.put(c4557a.m19169a(), c4557a);
            }
        }

        private C4557a(short s, String str) {
            this.f16297n = s;
            this.f16298o = str;
        }

        public String m19169a() {
            return this.f16298o;
        }
    }

    static {
        f16300n = new C4615j("XmPushActionSendMessage");
        f16301o = new C4609b("debug", (byte) 11, (short) 1);
        f16302p = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16303q = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16304r = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16305s = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 5);
        f16306t = new C4609b("topic", (byte) 11, (short) 6);
        f16307u = new C4609b("aliasName", (byte) 11, (short) 7);
        f16308v = new C4609b(C4233j.f14376C, (byte) 12, (short) 8);
        f16309w = new C4609b("needAck", (byte) 2, (short) 9);
        f16310x = new C4609b("params", (byte) 13, (short) 10);
        f16311y = new C4609b("category", (byte) 11, (short) 11);
        f16312z = new C4609b("userAccount", (byte) 11, (short) 12);
        Map enumMap = new EnumMap(C4557a.class);
        enumMap.put(C4557a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4557a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4557a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4557a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4557a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4557a.TOPIC, new C4601b("topic", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4557a.ALIAS_NAME, new C4601b("aliasName", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4557a.MESSAGE, new C4601b(C4233j.f14376C, (byte) 2, new C4604f((byte) 12, C4527h.class)));
        enumMap.put(C4557a.NEED_ACK, new C4601b("needAck", (byte) 2, new C4599c((byte) 2)));
        enumMap.put(C4557a.PARAMS, new C4601b("params", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4557a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4557a.USER_ACCOUNT, new C4601b("userAccount", (byte) 2, new C4599c((byte) 11)));
        f16299m = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4558x.class, f16299m);
    }

    public C4558x() {
        this.f16313A = new BitSet(1);
        this.f16322i = true;
    }

    public void m19170a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19194t();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16314a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16315b = new C4532k();
                    this.f16315b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16316c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16317d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16318e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16319f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16320g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16321h = new C4527h();
                    this.f16321h.m18836a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16322i = c4607e.m19330p();
                    m19171a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4611d j = c4607e.m19324j();
                    this.f16323j = new HashMap(j.f16482c * 2);
                    for (int i = 0; i < j.f16482c; i++) {
                        this.f16323j.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16324k = c4607e.m19336v();
                        break;
                    }
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16325l = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19171a(boolean z) {
        this.f16313A.set(0, z);
    }

    public boolean m19172a() {
        return this.f16314a != null;
    }

    public boolean m19173a(C4558x c4558x) {
        if (c4558x == null) {
            return false;
        }
        boolean a = m19172a();
        boolean a2 = c4558x.m19172a();
        if ((a || a2) && (!a || !a2 || !this.f16314a.equals(c4558x.f16314a))) {
            return false;
        }
        a = m19176b();
        a2 = c4558x.m19176b();
        if ((a || a2) && (!a || !a2 || !this.f16315b.m18904a(c4558x.f16315b))) {
            return false;
        }
        a = m19178d();
        a2 = c4558x.m19178d();
        if ((a || a2) && (!a || !a2 || !this.f16316c.equals(c4558x.f16316c))) {
            return false;
        }
        a = m19180f();
        a2 = c4558x.m19180f();
        if ((a || a2) && (!a || !a2 || !this.f16317d.equals(c4558x.f16317d))) {
            return false;
        }
        a = m19181g();
        a2 = c4558x.m19181g();
        if ((a || a2) && (!a || !a2 || !this.f16318e.equals(c4558x.f16318e))) {
            return false;
        }
        a = m19183i();
        a2 = c4558x.m19183i();
        if ((a || a2) && (!a || !a2 || !this.f16319f.equals(c4558x.f16319f))) {
            return false;
        }
        a = m19185k();
        a2 = c4558x.m19185k();
        if ((a || a2) && (!a || !a2 || !this.f16320g.equals(c4558x.f16320g))) {
            return false;
        }
        a = m19187m();
        a2 = c4558x.m19187m();
        if ((a || a2) && (!a || !a2 || !this.f16321h.m18839a(c4558x.f16321h))) {
            return false;
        }
        a = m19188n();
        a2 = c4558x.m19188n();
        if ((a || a2) && (!a || !a2 || this.f16322i != c4558x.f16322i)) {
            return false;
        }
        a = m19189o();
        a2 = c4558x.m19189o();
        if ((a || a2) && (!a || !a2 || !this.f16323j.equals(c4558x.f16323j))) {
            return false;
        }
        a = m19191q();
        a2 = c4558x.m19191q();
        if ((a || a2) && (!a || !a2 || !this.f16324k.equals(c4558x.f16324k))) {
            return false;
        }
        a = m19193s();
        a2 = c4558x.m19193s();
        return !(a || a2) || (a && a2 && this.f16325l.equals(c4558x.f16325l));
    }

    public int m19174b(C4558x c4558x) {
        if (!getClass().equals(c4558x.getClass())) {
            return getClass().getName().compareTo(c4558x.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19172a()).compareTo(Boolean.valueOf(c4558x.m19172a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19172a()) {
            compareTo = C4593b.m19284a(this.f16314a, c4558x.f16314a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19176b()).compareTo(Boolean.valueOf(c4558x.m19176b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19176b()) {
            compareTo = C4593b.m19283a(this.f16315b, c4558x.f16315b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19178d()).compareTo(Boolean.valueOf(c4558x.m19178d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19178d()) {
            compareTo = C4593b.m19284a(this.f16316c, c4558x.f16316c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19180f()).compareTo(Boolean.valueOf(c4558x.m19180f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19180f()) {
            compareTo = C4593b.m19284a(this.f16317d, c4558x.f16317d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19181g()).compareTo(Boolean.valueOf(c4558x.m19181g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19181g()) {
            compareTo = C4593b.m19284a(this.f16318e, c4558x.f16318e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19183i()).compareTo(Boolean.valueOf(c4558x.m19183i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19183i()) {
            compareTo = C4593b.m19284a(this.f16319f, c4558x.f16319f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19185k()).compareTo(Boolean.valueOf(c4558x.m19185k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19185k()) {
            compareTo = C4593b.m19284a(this.f16320g, c4558x.f16320g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19187m()).compareTo(Boolean.valueOf(c4558x.m19187m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19187m()) {
            compareTo = C4593b.m19283a(this.f16321h, c4558x.f16321h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19188n()).compareTo(Boolean.valueOf(c4558x.m19188n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19188n()) {
            compareTo = C4593b.m19290a(this.f16322i, c4558x.f16322i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19189o()).compareTo(Boolean.valueOf(c4558x.m19189o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19189o()) {
            compareTo = C4593b.m19287a(this.f16323j, c4558x.f16323j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19191q()).compareTo(Boolean.valueOf(c4558x.m19191q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19191q()) {
            compareTo = C4593b.m19284a(this.f16324k, c4558x.f16324k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19193s()).compareTo(Boolean.valueOf(c4558x.m19193s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19193s()) {
            compareTo = C4593b.m19284a(this.f16325l, c4558x.f16325l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19175b(C4607e c4607e) {
        m19194t();
        c4607e.m19313a(f16300n);
        if (this.f16314a != null && m19172a()) {
            c4607e.m19310a(f16301o);
            c4607e.m19308a(this.f16314a);
            c4607e.m19316b();
        }
        if (this.f16315b != null && m19176b()) {
            c4607e.m19310a(f16302p);
            this.f16315b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16316c != null) {
            c4607e.m19310a(f16303q);
            c4607e.m19308a(this.f16316c);
            c4607e.m19316b();
        }
        if (this.f16317d != null) {
            c4607e.m19310a(f16304r);
            c4607e.m19308a(this.f16317d);
            c4607e.m19316b();
        }
        if (this.f16318e != null && m19181g()) {
            c4607e.m19310a(f16305s);
            c4607e.m19308a(this.f16318e);
            c4607e.m19316b();
        }
        if (this.f16319f != null && m19183i()) {
            c4607e.m19310a(f16306t);
            c4607e.m19308a(this.f16319f);
            c4607e.m19316b();
        }
        if (this.f16320g != null && m19185k()) {
            c4607e.m19310a(f16307u);
            c4607e.m19308a(this.f16320g);
            c4607e.m19316b();
        }
        if (this.f16321h != null && m19187m()) {
            c4607e.m19310a(f16308v);
            this.f16321h.m18842b(c4607e);
            c4607e.m19316b();
        }
        if (m19188n()) {
            c4607e.m19310a(f16309w);
            c4607e.m19315a(this.f16322i);
            c4607e.m19316b();
        }
        if (this.f16323j != null && m19189o()) {
            c4607e.m19310a(f16310x);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f16323j.size()));
            for (Entry entry : this.f16323j.entrySet()) {
                c4607e.m19308a((String) entry.getKey());
                c4607e.m19308a((String) entry.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (this.f16324k != null && m19191q()) {
            c4607e.m19310a(f16311y);
            c4607e.m19308a(this.f16324k);
            c4607e.m19316b();
        }
        if (this.f16325l != null && m19193s()) {
            c4607e.m19310a(f16312z);
            c4607e.m19308a(this.f16325l);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19176b() {
        return this.f16315b != null;
    }

    public String m19177c() {
        return this.f16316c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19174b((C4558x) obj);
    }

    public boolean m19178d() {
        return this.f16316c != null;
    }

    public String m19179e() {
        return this.f16317d;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4558x)) ? m19173a((C4558x) obj) : false;
    }

    public boolean m19180f() {
        return this.f16317d != null;
    }

    public boolean m19181g() {
        return this.f16318e != null;
    }

    public String m19182h() {
        return this.f16319f;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m19183i() {
        return this.f16319f != null;
    }

    public String m19184j() {
        return this.f16320g;
    }

    public boolean m19185k() {
        return this.f16320g != null;
    }

    public C4527h m19186l() {
        return this.f16321h;
    }

    public boolean m19187m() {
        return this.f16321h != null;
    }

    public boolean m19188n() {
        return this.f16313A.get(0);
    }

    public boolean m19189o() {
        return this.f16323j != null;
    }

    public String m19190p() {
        return this.f16324k;
    }

    public boolean m19191q() {
        return this.f16324k != null;
    }

    public String m19192r() {
        return this.f16325l;
    }

    public boolean m19193s() {
        return this.f16325l != null;
    }

    public void m19194t() {
        if (this.f16316c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16317d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendMessage(");
        Object obj2 = 1;
        if (m19172a()) {
            stringBuilder.append("debug:");
            if (this.f16314a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16314a);
            }
            obj2 = null;
        }
        if (m19176b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16315b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16315b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16316c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16316c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16317d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16317d);
        }
        if (m19181g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16318e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16318e);
            }
        }
        if (m19183i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f16319f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16319f);
            }
        }
        if (m19185k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.f16320g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16320g);
            }
        }
        if (m19187m()) {
            stringBuilder.append(", ");
            stringBuilder.append("message:");
            if (this.f16321h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16321h);
            }
        }
        if (m19188n()) {
            stringBuilder.append(", ");
            stringBuilder.append("needAck:");
            stringBuilder.append(this.f16322i);
        }
        if (m19189o()) {
            stringBuilder.append(", ");
            stringBuilder.append("params:");
            if (this.f16323j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16323j);
            }
        }
        if (m19191q()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16324k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16324k);
            }
        }
        if (m19193s()) {
            stringBuilder.append(", ");
            stringBuilder.append("userAccount:");
            if (this.f16325l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16325l);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
