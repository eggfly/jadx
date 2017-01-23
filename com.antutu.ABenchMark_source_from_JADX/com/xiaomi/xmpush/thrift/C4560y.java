package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
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

/* renamed from: com.xiaomi.xmpush.thrift.y */
public class C4560y implements Serializable, Cloneable, C4454a<C4560y, C4559a> {
    public static final Map<C4559a, C4601b> f16337h;
    private static final C4615j f16338i;
    private static final C4609b f16339j;
    private static final C4609b f16340k;
    private static final C4609b f16341l;
    private static final C4609b f16342m;
    private static final C4609b f16343n;
    private static final C4609b f16344o;
    private static final C4609b f16345p;
    public String f16346a;
    public C4532k f16347b;
    public String f16348c;
    public String f16349d;
    public String f16350e;
    public String f16351f;
    public String f16352g;

    /* renamed from: com.xiaomi.xmpush.thrift.y.a */
    public enum C4559a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        TOPIC((short) 5, "topic"),
        PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 7, "category");
        
        private static final Map<String, C4559a> f16333h;
        private final short f16335i;
        private final String f16336j;

        static {
            f16333h = new HashMap();
            Iterator it = EnumSet.allOf(C4559a.class).iterator();
            while (it.hasNext()) {
                C4559a c4559a = (C4559a) it.next();
                f16333h.put(c4559a.m19195a(), c4559a);
            }
        }

        private C4559a(short s, String str) {
            this.f16335i = s;
            this.f16336j = str;
        }

        public String m19195a() {
            return this.f16336j;
        }
    }

    static {
        f16338i = new C4615j("XmPushActionSubscription");
        f16339j = new C4609b("debug", (byte) 11, (short) 1);
        f16340k = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16341l = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16342m = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16343n = new C4609b("topic", (byte) 11, (short) 5);
        f16344o = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
        f16345p = new C4609b("category", (byte) 11, (short) 7);
        Map enumMap = new EnumMap(C4559a.class);
        enumMap.put(C4559a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4559a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4559a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4559a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4559a.TOPIC, new C4601b("topic", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4559a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4559a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f16337h = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4560y.class, f16337h);
    }

    public C4560y m19196a(String str) {
        this.f16348c = str;
        return this;
    }

    public void m19197a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19212h();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16346a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16347b = new C4532k();
                    this.f16347b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16348c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16349d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16350e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16351f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16352g = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m19198a() {
        return this.f16346a != null;
    }

    public boolean m19199a(C4560y c4560y) {
        if (c4560y == null) {
            return false;
        }
        boolean a = m19198a();
        boolean a2 = c4560y.m19198a();
        if ((a || a2) && (!a || !a2 || !this.f16346a.equals(c4560y.f16346a))) {
            return false;
        }
        a = m19203b();
        a2 = c4560y.m19203b();
        if ((a || a2) && (!a || !a2 || !this.f16347b.m18904a(c4560y.f16347b))) {
            return false;
        }
        a = m19205c();
        a2 = c4560y.m19205c();
        if ((a || a2) && (!a || !a2 || !this.f16348c.equals(c4560y.f16348c))) {
            return false;
        }
        a = m19207d();
        a2 = c4560y.m19207d();
        if ((a || a2) && (!a || !a2 || !this.f16349d.equals(c4560y.f16349d))) {
            return false;
        }
        a = m19209e();
        a2 = c4560y.m19209e();
        if ((a || a2) && (!a || !a2 || !this.f16350e.equals(c4560y.f16350e))) {
            return false;
        }
        a = m19210f();
        a2 = c4560y.m19210f();
        if ((a || a2) && (!a || !a2 || !this.f16351f.equals(c4560y.f16351f))) {
            return false;
        }
        a = m19211g();
        a2 = c4560y.m19211g();
        return !(a || a2) || (a && a2 && this.f16352g.equals(c4560y.f16352g));
    }

    public int m19200b(C4560y c4560y) {
        if (!getClass().equals(c4560y.getClass())) {
            return getClass().getName().compareTo(c4560y.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19198a()).compareTo(Boolean.valueOf(c4560y.m19198a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19198a()) {
            compareTo = C4593b.m19284a(this.f16346a, c4560y.f16346a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19203b()).compareTo(Boolean.valueOf(c4560y.m19203b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19203b()) {
            compareTo = C4593b.m19283a(this.f16347b, c4560y.f16347b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19205c()).compareTo(Boolean.valueOf(c4560y.m19205c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19205c()) {
            compareTo = C4593b.m19284a(this.f16348c, c4560y.f16348c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19207d()).compareTo(Boolean.valueOf(c4560y.m19207d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19207d()) {
            compareTo = C4593b.m19284a(this.f16349d, c4560y.f16349d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19209e()).compareTo(Boolean.valueOf(c4560y.m19209e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19209e()) {
            compareTo = C4593b.m19284a(this.f16350e, c4560y.f16350e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19210f()).compareTo(Boolean.valueOf(c4560y.m19210f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19210f()) {
            compareTo = C4593b.m19284a(this.f16351f, c4560y.f16351f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19211g()).compareTo(Boolean.valueOf(c4560y.m19211g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19211g()) {
            compareTo = C4593b.m19284a(this.f16352g, c4560y.f16352g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4560y m19201b(String str) {
        this.f16349d = str;
        return this;
    }

    public void m19202b(C4607e c4607e) {
        m19212h();
        c4607e.m19313a(f16338i);
        if (this.f16346a != null && m19198a()) {
            c4607e.m19310a(f16339j);
            c4607e.m19308a(this.f16346a);
            c4607e.m19316b();
        }
        if (this.f16347b != null && m19203b()) {
            c4607e.m19310a(f16340k);
            this.f16347b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16348c != null) {
            c4607e.m19310a(f16341l);
            c4607e.m19308a(this.f16348c);
            c4607e.m19316b();
        }
        if (this.f16349d != null) {
            c4607e.m19310a(f16342m);
            c4607e.m19308a(this.f16349d);
            c4607e.m19316b();
        }
        if (this.f16350e != null) {
            c4607e.m19310a(f16343n);
            c4607e.m19308a(this.f16350e);
            c4607e.m19316b();
        }
        if (this.f16351f != null && m19210f()) {
            c4607e.m19310a(f16344o);
            c4607e.m19308a(this.f16351f);
            c4607e.m19316b();
        }
        if (this.f16352g != null && m19211g()) {
            c4607e.m19310a(f16345p);
            c4607e.m19308a(this.f16352g);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19203b() {
        return this.f16347b != null;
    }

    public C4560y m19204c(String str) {
        this.f16350e = str;
        return this;
    }

    public boolean m19205c() {
        return this.f16348c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19200b((C4560y) obj);
    }

    public C4560y m19206d(String str) {
        this.f16351f = str;
        return this;
    }

    public boolean m19207d() {
        return this.f16349d != null;
    }

    public C4560y m19208e(String str) {
        this.f16352g = str;
        return this;
    }

    public boolean m19209e() {
        return this.f16350e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4560y)) ? m19199a((C4560y) obj) : false;
    }

    public boolean m19210f() {
        return this.f16351f != null;
    }

    public boolean m19211g() {
        return this.f16352g != null;
    }

    public void m19212h() {
        if (this.f16348c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16349d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f16350e == null) {
            throw new C4612f("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSubscription(");
        Object obj2 = 1;
        if (m19198a()) {
            stringBuilder.append("debug:");
            if (this.f16346a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16346a);
            }
            obj2 = null;
        }
        if (m19203b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16347b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16347b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16348c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16348c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16349d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16349d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("topic:");
        if (this.f16350e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16350e);
        }
        if (m19210f()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16351f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16351f);
            }
        }
        if (m19211g()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16352g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16352g);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
