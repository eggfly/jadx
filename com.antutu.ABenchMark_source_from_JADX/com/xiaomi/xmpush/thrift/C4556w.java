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

/* renamed from: com.xiaomi.xmpush.thrift.w */
public class C4556w implements Serializable, Cloneable, C4454a<C4556w, C4555a> {
    public static final Map<C4555a, C4601b> f16264i;
    private static final C4615j f16265j;
    private static final C4609b f16266k;
    private static final C4609b f16267l;
    private static final C4609b f16268m;
    private static final C4609b f16269n;
    private static final C4609b f16270o;
    private static final C4609b f16271p;
    private static final C4609b f16272q;
    private static final C4609b f16273r;
    public String f16274a;
    public C4532k f16275b;
    public String f16276c;
    public String f16277d;
    public C4554v f16278e;
    public long f16279f;
    public String f16280g;
    public String f16281h;
    private BitSet f16282s;

    /* renamed from: com.xiaomi.xmpush.thrift.w.a */
    public enum C4555a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        REQUEST((short) 5, "request"),
        ERROR_CODE((short) 6, Constants.KEY_ERROR_CODE),
        REASON((short) 7, "reason"),
        CATEGORY((short) 8, "category");
        
        private static final Map<String, C4555a> f16260i;
        private final short f16262j;
        private final String f16263k;

        static {
            f16260i = new HashMap();
            Iterator it = EnumSet.allOf(C4555a.class).iterator();
            while (it.hasNext()) {
                C4555a c4555a = (C4555a) it.next();
                f16260i.put(c4555a.m19154a(), c4555a);
            }
        }

        private C4555a(short s, String str) {
            this.f16262j = s;
            this.f16263k = str;
        }

        public String m19154a() {
            return this.f16263k;
        }
    }

    static {
        f16265j = new C4615j("XmPushActionSendFeedbackResult");
        f16266k = new C4609b("debug", (byte) 11, (short) 1);
        f16267l = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16268m = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16269n = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16270o = new C4609b("request", (byte) 12, (short) 5);
        f16271p = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 6);
        f16272q = new C4609b("reason", (byte) 11, (short) 7);
        f16273r = new C4609b("category", (byte) 11, (short) 8);
        Map enumMap = new EnumMap(C4555a.class);
        enumMap.put(C4555a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4555a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4555a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4555a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4555a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, C4554v.class)));
        enumMap.put(C4555a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4555a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4555a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f16264i = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4556w.class, f16264i);
    }

    public C4556w() {
        this.f16282s = new BitSet(1);
    }

    public void m19155a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m19165f()) {
                    m19168i();
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
                        this.f16274a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16275b = new C4532k();
                    this.f16275b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16276c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16277d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16278e = new C4554v();
                    this.f16278e.m19143a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16279f = c4607e.m19334t();
                    m19156a(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16280g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16281h = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19156a(boolean z) {
        this.f16282s.set(0, z);
    }

    public boolean m19157a() {
        return this.f16274a != null;
    }

    public boolean m19158a(C4556w c4556w) {
        if (c4556w == null) {
            return false;
        }
        boolean a = m19157a();
        boolean a2 = c4556w.m19157a();
        if ((a || a2) && (!a || !a2 || !this.f16274a.equals(c4556w.f16274a))) {
            return false;
        }
        a = m19161b();
        a2 = c4556w.m19161b();
        if ((a || a2) && (!a || !a2 || !this.f16275b.m18904a(c4556w.f16275b))) {
            return false;
        }
        a = m19162c();
        a2 = c4556w.m19162c();
        if ((a || a2) && (!a || !a2 || !this.f16276c.equals(c4556w.f16276c))) {
            return false;
        }
        a = m19163d();
        a2 = c4556w.m19163d();
        if ((a || a2) && (!a || !a2 || !this.f16277d.equals(c4556w.f16277d))) {
            return false;
        }
        a = m19164e();
        a2 = c4556w.m19164e();
        if (((a || a2) && (!a || !a2 || !this.f16278e.m19145a(c4556w.f16278e))) || this.f16279f != c4556w.f16279f) {
            return false;
        }
        a = m19166g();
        a2 = c4556w.m19166g();
        if ((a || a2) && (!a || !a2 || !this.f16280g.equals(c4556w.f16280g))) {
            return false;
        }
        a = m19167h();
        a2 = c4556w.m19167h();
        return !(a || a2) || (a && a2 && this.f16281h.equals(c4556w.f16281h));
    }

    public int m19159b(C4556w c4556w) {
        if (!getClass().equals(c4556w.getClass())) {
            return getClass().getName().compareTo(c4556w.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19157a()).compareTo(Boolean.valueOf(c4556w.m19157a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19157a()) {
            compareTo = C4593b.m19284a(this.f16274a, c4556w.f16274a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19161b()).compareTo(Boolean.valueOf(c4556w.m19161b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19161b()) {
            compareTo = C4593b.m19283a(this.f16275b, c4556w.f16275b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19162c()).compareTo(Boolean.valueOf(c4556w.m19162c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19162c()) {
            compareTo = C4593b.m19284a(this.f16276c, c4556w.f16276c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19163d()).compareTo(Boolean.valueOf(c4556w.m19163d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19163d()) {
            compareTo = C4593b.m19284a(this.f16277d, c4556w.f16277d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19164e()).compareTo(Boolean.valueOf(c4556w.m19164e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19164e()) {
            compareTo = C4593b.m19283a(this.f16278e, c4556w.f16278e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19165f()).compareTo(Boolean.valueOf(c4556w.m19165f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19165f()) {
            compareTo = C4593b.m19282a(this.f16279f, c4556w.f16279f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19166g()).compareTo(Boolean.valueOf(c4556w.m19166g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19166g()) {
            compareTo = C4593b.m19284a(this.f16280g, c4556w.f16280g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19167h()).compareTo(Boolean.valueOf(c4556w.m19167h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19167h()) {
            compareTo = C4593b.m19284a(this.f16281h, c4556w.f16281h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19160b(C4607e c4607e) {
        m19168i();
        c4607e.m19313a(f16265j);
        if (this.f16274a != null && m19157a()) {
            c4607e.m19310a(f16266k);
            c4607e.m19308a(this.f16274a);
            c4607e.m19316b();
        }
        if (this.f16275b != null && m19161b()) {
            c4607e.m19310a(f16267l);
            this.f16275b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16276c != null) {
            c4607e.m19310a(f16268m);
            c4607e.m19308a(this.f16276c);
            c4607e.m19316b();
        }
        if (this.f16277d != null) {
            c4607e.m19310a(f16269n);
            c4607e.m19308a(this.f16277d);
            c4607e.m19316b();
        }
        if (this.f16278e != null && m19164e()) {
            c4607e.m19310a(f16270o);
            this.f16278e.m19147b(c4607e);
            c4607e.m19316b();
        }
        c4607e.m19310a(f16271p);
        c4607e.m19307a(this.f16279f);
        c4607e.m19316b();
        if (this.f16280g != null && m19166g()) {
            c4607e.m19310a(f16272q);
            c4607e.m19308a(this.f16280g);
            c4607e.m19316b();
        }
        if (this.f16281h != null && m19167h()) {
            c4607e.m19310a(f16273r);
            c4607e.m19308a(this.f16281h);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19161b() {
        return this.f16275b != null;
    }

    public boolean m19162c() {
        return this.f16276c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19159b((C4556w) obj);
    }

    public boolean m19163d() {
        return this.f16277d != null;
    }

    public boolean m19164e() {
        return this.f16278e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4556w)) ? m19158a((C4556w) obj) : false;
    }

    public boolean m19165f() {
        return this.f16282s.get(0);
    }

    public boolean m19166g() {
        return this.f16280g != null;
    }

    public boolean m19167h() {
        return this.f16281h != null;
    }

    public int hashCode() {
        return 0;
    }

    public void m19168i() {
        if (this.f16276c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16277d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendFeedbackResult(");
        Object obj2 = 1;
        if (m19157a()) {
            stringBuilder.append("debug:");
            if (this.f16274a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16274a);
            }
            obj2 = null;
        }
        if (m19161b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16275b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16275b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16276c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16276c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16277d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16277d);
        }
        if (m19164e()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f16278e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16278e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.f16279f);
        if (m19166g()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f16280g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16280g);
            }
        }
        if (m19167h()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16281h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16281h);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
