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

public class ab implements Serializable, Cloneable, C4454a<ab, C4515a> {
    public static final Map<C4515a, C4601b> f15572i;
    private static final C4615j f15573j;
    private static final C4609b f15574k;
    private static final C4609b f15575l;
    private static final C4609b f15576m;
    private static final C4609b f15577n;
    private static final C4609b f15578o;
    private static final C4609b f15579p;
    private static final C4609b f15580q;
    private static final C4609b f15581r;
    public String f15582a;
    public C4532k f15583b;
    public String f15584c;
    public String f15585d;
    public aa f15586e;
    public long f15587f;
    public String f15588g;
    public String f15589h;
    private BitSet f15590s;

    /* renamed from: com.xiaomi.xmpush.thrift.ab.a */
    public enum C4515a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        REQUEST((short) 5, "request"),
        ERROR_CODE((short) 6, Constants.KEY_ERROR_CODE),
        REASON((short) 7, "reason"),
        PACKAGE_NAME((short) 8, Constants.KEY_PACKAGE_NAME);
        
        private static final Map<String, C4515a> f15568i;
        private final short f15570j;
        private final String f15571k;

        static {
            f15568i = new HashMap();
            Iterator it = EnumSet.allOf(C4515a.class).iterator();
            while (it.hasNext()) {
                C4515a c4515a = (C4515a) it.next();
                f15568i.put(c4515a.m18739a(), c4515a);
            }
        }

        private C4515a(short s, String str) {
            this.f15570j = s;
            this.f15571k = str;
        }

        public String m18739a() {
            return this.f15571k;
        }
    }

    static {
        f15573j = new C4615j("XmPushActionUnRegistrationResult");
        f15574k = new C4609b("debug", (byte) 11, (short) 1);
        f15575l = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15576m = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15577n = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15578o = new C4609b("request", (byte) 12, (short) 5);
        f15579p = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 6);
        f15580q = new C4609b("reason", (byte) 11, (short) 7);
        f15581r = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 8);
        Map enumMap = new EnumMap(C4515a.class);
        enumMap.put(C4515a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4515a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4515a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4515a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4515a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, aa.class)));
        enumMap.put(C4515a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4515a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4515a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        f15572i = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(ab.class, f15572i);
    }

    public ab() {
        this.f15590s = new BitSet(1);
    }

    public void m18740a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18750f()) {
                    m18753i();
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
                        this.f15582a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15583b = new C4532k();
                    this.f15583b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15584c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15585d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15586e = new aa();
                    this.f15586e.m18720a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15587f = c4607e.m19334t();
                    m18741a(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15588g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15589h = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18741a(boolean z) {
        this.f15590s.set(0, z);
    }

    public boolean m18742a() {
        return this.f15582a != null;
    }

    public boolean m18743a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        boolean a = m18742a();
        boolean a2 = abVar.m18742a();
        if ((a || a2) && (!a || !a2 || !this.f15582a.equals(abVar.f15582a))) {
            return false;
        }
        a = m18746b();
        a2 = abVar.m18746b();
        if ((a || a2) && (!a || !a2 || !this.f15583b.m18904a(abVar.f15583b))) {
            return false;
        }
        a = m18747c();
        a2 = abVar.m18747c();
        if ((a || a2) && (!a || !a2 || !this.f15584c.equals(abVar.f15584c))) {
            return false;
        }
        a = m18748d();
        a2 = abVar.m18748d();
        if ((a || a2) && (!a || !a2 || !this.f15585d.equals(abVar.f15585d))) {
            return false;
        }
        a = m18749e();
        a2 = abVar.m18749e();
        if (((a || a2) && (!a || !a2 || !this.f15586e.m18722a(abVar.f15586e))) || this.f15587f != abVar.f15587f) {
            return false;
        }
        a = m18751g();
        a2 = abVar.m18751g();
        if ((a || a2) && (!a || !a2 || !this.f15588g.equals(abVar.f15588g))) {
            return false;
        }
        a = m18752h();
        a2 = abVar.m18752h();
        return !(a || a2) || (a && a2 && this.f15589h.equals(abVar.f15589h));
    }

    public int m18744b(ab abVar) {
        if (!getClass().equals(abVar.getClass())) {
            return getClass().getName().compareTo(abVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18742a()).compareTo(Boolean.valueOf(abVar.m18742a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18742a()) {
            compareTo = C4593b.m19284a(this.f15582a, abVar.f15582a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18746b()).compareTo(Boolean.valueOf(abVar.m18746b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18746b()) {
            compareTo = C4593b.m19283a(this.f15583b, abVar.f15583b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18747c()).compareTo(Boolean.valueOf(abVar.m18747c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18747c()) {
            compareTo = C4593b.m19284a(this.f15584c, abVar.f15584c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18748d()).compareTo(Boolean.valueOf(abVar.m18748d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18748d()) {
            compareTo = C4593b.m19284a(this.f15585d, abVar.f15585d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18749e()).compareTo(Boolean.valueOf(abVar.m18749e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18749e()) {
            compareTo = C4593b.m19283a(this.f15586e, abVar.f15586e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18750f()).compareTo(Boolean.valueOf(abVar.m18750f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18750f()) {
            compareTo = C4593b.m19282a(this.f15587f, abVar.f15587f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18751g()).compareTo(Boolean.valueOf(abVar.m18751g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18751g()) {
            compareTo = C4593b.m19284a(this.f15588g, abVar.f15588g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18752h()).compareTo(Boolean.valueOf(abVar.m18752h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18752h()) {
            compareTo = C4593b.m19284a(this.f15589h, abVar.f15589h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18745b(C4607e c4607e) {
        m18753i();
        c4607e.m19313a(f15573j);
        if (this.f15582a != null && m18742a()) {
            c4607e.m19310a(f15574k);
            c4607e.m19308a(this.f15582a);
            c4607e.m19316b();
        }
        if (this.f15583b != null && m18746b()) {
            c4607e.m19310a(f15575l);
            this.f15583b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15584c != null) {
            c4607e.m19310a(f15576m);
            c4607e.m19308a(this.f15584c);
            c4607e.m19316b();
        }
        if (this.f15585d != null) {
            c4607e.m19310a(f15577n);
            c4607e.m19308a(this.f15585d);
            c4607e.m19316b();
        }
        if (this.f15586e != null && m18749e()) {
            c4607e.m19310a(f15578o);
            this.f15586e.m18725b(c4607e);
            c4607e.m19316b();
        }
        c4607e.m19310a(f15579p);
        c4607e.m19307a(this.f15587f);
        c4607e.m19316b();
        if (this.f15588g != null && m18751g()) {
            c4607e.m19310a(f15580q);
            c4607e.m19308a(this.f15588g);
            c4607e.m19316b();
        }
        if (this.f15589h != null && m18752h()) {
            c4607e.m19310a(f15581r);
            c4607e.m19308a(this.f15589h);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18746b() {
        return this.f15583b != null;
    }

    public boolean m18747c() {
        return this.f15584c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18744b((ab) obj);
    }

    public boolean m18748d() {
        return this.f15585d != null;
    }

    public boolean m18749e() {
        return this.f15586e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ab)) ? m18743a((ab) obj) : false;
    }

    public boolean m18750f() {
        return this.f15590s.get(0);
    }

    public boolean m18751g() {
        return this.f15588g != null;
    }

    public boolean m18752h() {
        return this.f15589h != null;
    }

    public int hashCode() {
        return 0;
    }

    public void m18753i() {
        if (this.f15584c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15585d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnRegistrationResult(");
        Object obj2 = 1;
        if (m18742a()) {
            stringBuilder.append("debug:");
            if (this.f15582a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15582a);
            }
            obj2 = null;
        }
        if (m18746b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15583b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15583b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15584c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15584c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15585d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15585d);
        }
        if (m18749e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f15586e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15586e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.f15587f);
        if (m18751g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f15588g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15588g);
            }
        }
        if (m18752h()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15589h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15589h);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
