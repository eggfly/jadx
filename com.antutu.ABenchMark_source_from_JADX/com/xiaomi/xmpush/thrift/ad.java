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

public class ad implements Serializable, Cloneable, C4454a<ad, C4517a> {
    public static final Map<C4517a, C4601b> f15632k;
    private static final C4615j f15633l;
    private static final C4609b f15634m;
    private static final C4609b f15635n;
    private static final C4609b f15636o;
    private static final C4609b f15637p;
    private static final C4609b f15638q;
    private static final C4609b f15639r;
    private static final C4609b f15640s;
    private static final C4609b f15641t;
    private static final C4609b f15642u;
    private static final C4609b f15643v;
    public String f15644a;
    public C4532k f15645b;
    public String f15646c;
    public String f15647d;
    public ac f15648e;
    public long f15649f;
    public String f15650g;
    public String f15651h;
    public String f15652i;
    public String f15653j;
    private BitSet f15654w;

    /* renamed from: com.xiaomi.xmpush.thrift.ad.a */
    public enum C4517a {
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
        
        private static final Map<String, C4517a> f15628k;
        private final short f15630l;
        private final String f15631m;

        static {
            f15628k = new HashMap();
            Iterator it = EnumSet.allOf(C4517a.class).iterator();
            while (it.hasNext()) {
                C4517a c4517a = (C4517a) it.next();
                f15628k.put(c4517a.m18772a(), c4517a);
            }
        }

        private C4517a(short s, String str) {
            this.f15630l = s;
            this.f15631m = str;
        }

        public String m18772a() {
            return this.f15631m;
        }
    }

    static {
        f15633l = new C4615j("XmPushActionUnSubscriptionResult");
        f15634m = new C4609b("debug", (byte) 11, (short) 1);
        f15635n = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15636o = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15637p = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15638q = new C4609b("request", (byte) 12, (short) 5);
        f15639r = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 6);
        f15640s = new C4609b("reason", (byte) 11, (short) 7);
        f15641t = new C4609b("topic", (byte) 11, (short) 8);
        f15642u = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
        f15643v = new C4609b("category", (byte) 11, (short) 10);
        Map enumMap = new EnumMap(C4517a.class);
        enumMap.put(C4517a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4517a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4517a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4517a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4517a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, ac.class)));
        enumMap.put(C4517a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4517a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4517a.TOPIC, new C4601b("topic", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4517a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4517a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f15632k = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(ad.class, f15632k);
    }

    public ad() {
        this.f15654w = new BitSet(1);
    }

    public void m18773a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18790m();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15644a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15645b = new C4532k();
                    this.f15645b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15646c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15647d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15648e = new ac();
                    this.f15648e.m18756a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15649f = c4607e.m19334t();
                    m18774a(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15650g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15651h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15652i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15653j = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18774a(boolean z) {
        this.f15654w.set(0, z);
    }

    public boolean m18775a() {
        return this.f15644a != null;
    }

    public boolean m18776a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        boolean a = m18775a();
        boolean a2 = adVar.m18775a();
        if ((a || a2) && (!a || !a2 || !this.f15644a.equals(adVar.f15644a))) {
            return false;
        }
        a = m18779b();
        a2 = adVar.m18779b();
        if ((a || a2) && (!a || !a2 || !this.f15645b.m18904a(adVar.f15645b))) {
            return false;
        }
        a = m18780c();
        a2 = adVar.m18780c();
        if ((a || a2) && (!a || !a2 || !this.f15646c.equals(adVar.f15646c))) {
            return false;
        }
        a = m18781d();
        a2 = adVar.m18781d();
        if ((a || a2) && (!a || !a2 || !this.f15647d.equals(adVar.f15647d))) {
            return false;
        }
        a = m18782e();
        a2 = adVar.m18782e();
        if ((a || a2) && (!a || !a2 || !this.f15648e.m18758a(adVar.f15648e))) {
            return false;
        }
        a = m18783f();
        a2 = adVar.m18783f();
        if ((a || a2) && (!a || !a2 || this.f15649f != adVar.f15649f)) {
            return false;
        }
        a = m18784g();
        a2 = adVar.m18784g();
        if ((a || a2) && (!a || !a2 || !this.f15650g.equals(adVar.f15650g))) {
            return false;
        }
        a = m18786i();
        a2 = adVar.m18786i();
        if ((a || a2) && (!a || !a2 || !this.f15651h.equals(adVar.f15651h))) {
            return false;
        }
        a = m18787j();
        a2 = adVar.m18787j();
        if ((a || a2) && (!a || !a2 || !this.f15652i.equals(adVar.f15652i))) {
            return false;
        }
        a = m18789l();
        a2 = adVar.m18789l();
        return !(a || a2) || (a && a2 && this.f15653j.equals(adVar.f15653j));
    }

    public int m18777b(ad adVar) {
        if (!getClass().equals(adVar.getClass())) {
            return getClass().getName().compareTo(adVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18775a()).compareTo(Boolean.valueOf(adVar.m18775a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18775a()) {
            compareTo = C4593b.m19284a(this.f15644a, adVar.f15644a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18779b()).compareTo(Boolean.valueOf(adVar.m18779b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18779b()) {
            compareTo = C4593b.m19283a(this.f15645b, adVar.f15645b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18780c()).compareTo(Boolean.valueOf(adVar.m18780c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18780c()) {
            compareTo = C4593b.m19284a(this.f15646c, adVar.f15646c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18781d()).compareTo(Boolean.valueOf(adVar.m18781d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18781d()) {
            compareTo = C4593b.m19284a(this.f15647d, adVar.f15647d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18782e()).compareTo(Boolean.valueOf(adVar.m18782e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18782e()) {
            compareTo = C4593b.m19283a(this.f15648e, adVar.f15648e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18783f()).compareTo(Boolean.valueOf(adVar.m18783f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18783f()) {
            compareTo = C4593b.m19282a(this.f15649f, adVar.f15649f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18784g()).compareTo(Boolean.valueOf(adVar.m18784g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18784g()) {
            compareTo = C4593b.m19284a(this.f15650g, adVar.f15650g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18786i()).compareTo(Boolean.valueOf(adVar.m18786i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18786i()) {
            compareTo = C4593b.m19284a(this.f15651h, adVar.f15651h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18787j()).compareTo(Boolean.valueOf(adVar.m18787j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18787j()) {
            compareTo = C4593b.m19284a(this.f15652i, adVar.f15652i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18789l()).compareTo(Boolean.valueOf(adVar.m18789l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18789l()) {
            compareTo = C4593b.m19284a(this.f15653j, adVar.f15653j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18778b(C4607e c4607e) {
        m18790m();
        c4607e.m19313a(f15633l);
        if (this.f15644a != null && m18775a()) {
            c4607e.m19310a(f15634m);
            c4607e.m19308a(this.f15644a);
            c4607e.m19316b();
        }
        if (this.f15645b != null && m18779b()) {
            c4607e.m19310a(f15635n);
            this.f15645b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15646c != null) {
            c4607e.m19310a(f15636o);
            c4607e.m19308a(this.f15646c);
            c4607e.m19316b();
        }
        if (this.f15647d != null && m18781d()) {
            c4607e.m19310a(f15637p);
            c4607e.m19308a(this.f15647d);
            c4607e.m19316b();
        }
        if (this.f15648e != null && m18782e()) {
            c4607e.m19310a(f15638q);
            this.f15648e.m18761b(c4607e);
            c4607e.m19316b();
        }
        if (m18783f()) {
            c4607e.m19310a(f15639r);
            c4607e.m19307a(this.f15649f);
            c4607e.m19316b();
        }
        if (this.f15650g != null && m18784g()) {
            c4607e.m19310a(f15640s);
            c4607e.m19308a(this.f15650g);
            c4607e.m19316b();
        }
        if (this.f15651h != null && m18786i()) {
            c4607e.m19310a(f15641t);
            c4607e.m19308a(this.f15651h);
            c4607e.m19316b();
        }
        if (this.f15652i != null && m18787j()) {
            c4607e.m19310a(f15642u);
            c4607e.m19308a(this.f15652i);
            c4607e.m19316b();
        }
        if (this.f15653j != null && m18789l()) {
            c4607e.m19310a(f15643v);
            c4607e.m19308a(this.f15653j);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18779b() {
        return this.f15645b != null;
    }

    public boolean m18780c() {
        return this.f15646c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18777b((ad) obj);
    }

    public boolean m18781d() {
        return this.f15647d != null;
    }

    public boolean m18782e() {
        return this.f15648e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ad)) ? m18776a((ad) obj) : false;
    }

    public boolean m18783f() {
        return this.f15654w.get(0);
    }

    public boolean m18784g() {
        return this.f15650g != null;
    }

    public String m18785h() {
        return this.f15651h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18786i() {
        return this.f15651h != null;
    }

    public boolean m18787j() {
        return this.f15652i != null;
    }

    public String m18788k() {
        return this.f15653j;
    }

    public boolean m18789l() {
        return this.f15653j != null;
    }

    public void m18790m() {
        if (this.f15646c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnSubscriptionResult(");
        Object obj2 = 1;
        if (m18775a()) {
            stringBuilder.append("debug:");
            if (this.f15644a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15644a);
            }
            obj2 = null;
        }
        if (m18779b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15645b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15645b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15646c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15646c);
        }
        if (m18781d()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            if (this.f15647d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15647d);
            }
        }
        if (m18782e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f15648e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15648e);
            }
        }
        if (m18783f()) {
            stringBuilder.append(", ");
            stringBuilder.append("errorCode:");
            stringBuilder.append(this.f15649f);
        }
        if (m18784g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f15650g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15650g);
            }
        }
        if (m18786i()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f15651h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15651h);
            }
        }
        if (m18787j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15652i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15652i);
            }
        }
        if (m18789l()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f15653j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15653j);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
