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

public class ac implements Serializable, Cloneable, C4454a<ac, C4516a> {
    public static final Map<C4516a, C4601b> f15602h;
    private static final C4615j f15603i;
    private static final C4609b f15604j;
    private static final C4609b f15605k;
    private static final C4609b f15606l;
    private static final C4609b f15607m;
    private static final C4609b f15608n;
    private static final C4609b f15609o;
    private static final C4609b f15610p;
    public String f15611a;
    public C4532k f15612b;
    public String f15613c;
    public String f15614d;
    public String f15615e;
    public String f15616f;
    public String f15617g;

    /* renamed from: com.xiaomi.xmpush.thrift.ac.a */
    public enum C4516a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        TOPIC((short) 5, "topic"),
        PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 7, "category");
        
        private static final Map<String, C4516a> f15598h;
        private final short f15600i;
        private final String f15601j;

        static {
            f15598h = new HashMap();
            Iterator it = EnumSet.allOf(C4516a.class).iterator();
            while (it.hasNext()) {
                C4516a c4516a = (C4516a) it.next();
                f15598h.put(c4516a.m18754a(), c4516a);
            }
        }

        private C4516a(short s, String str) {
            this.f15600i = s;
            this.f15601j = str;
        }

        public String m18754a() {
            return this.f15601j;
        }
    }

    static {
        f15603i = new C4615j("XmPushActionUnSubscription");
        f15604j = new C4609b("debug", (byte) 11, (short) 1);
        f15605k = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15606l = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15607m = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15608n = new C4609b("topic", (byte) 11, (short) 5);
        f15609o = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
        f15610p = new C4609b("category", (byte) 11, (short) 7);
        Map enumMap = new EnumMap(C4516a.class);
        enumMap.put(C4516a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4516a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4516a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4516a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4516a.TOPIC, new C4601b("topic", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4516a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4516a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f15602h = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(ac.class, f15602h);
    }

    public ac m18755a(String str) {
        this.f15613c = str;
        return this;
    }

    public void m18756a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18771h();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15611a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15612b = new C4532k();
                    this.f15612b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15613c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15614d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15615e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15616f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15617g = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m18757a() {
        return this.f15611a != null;
    }

    public boolean m18758a(ac acVar) {
        if (acVar == null) {
            return false;
        }
        boolean a = m18757a();
        boolean a2 = acVar.m18757a();
        if ((a || a2) && (!a || !a2 || !this.f15611a.equals(acVar.f15611a))) {
            return false;
        }
        a = m18762b();
        a2 = acVar.m18762b();
        if ((a || a2) && (!a || !a2 || !this.f15612b.m18904a(acVar.f15612b))) {
            return false;
        }
        a = m18764c();
        a2 = acVar.m18764c();
        if ((a || a2) && (!a || !a2 || !this.f15613c.equals(acVar.f15613c))) {
            return false;
        }
        a = m18766d();
        a2 = acVar.m18766d();
        if ((a || a2) && (!a || !a2 || !this.f15614d.equals(acVar.f15614d))) {
            return false;
        }
        a = m18768e();
        a2 = acVar.m18768e();
        if ((a || a2) && (!a || !a2 || !this.f15615e.equals(acVar.f15615e))) {
            return false;
        }
        a = m18769f();
        a2 = acVar.m18769f();
        if ((a || a2) && (!a || !a2 || !this.f15616f.equals(acVar.f15616f))) {
            return false;
        }
        a = m18770g();
        a2 = acVar.m18770g();
        return !(a || a2) || (a && a2 && this.f15617g.equals(acVar.f15617g));
    }

    public int m18759b(ac acVar) {
        if (!getClass().equals(acVar.getClass())) {
            return getClass().getName().compareTo(acVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18757a()).compareTo(Boolean.valueOf(acVar.m18757a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18757a()) {
            compareTo = C4593b.m19284a(this.f15611a, acVar.f15611a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18762b()).compareTo(Boolean.valueOf(acVar.m18762b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18762b()) {
            compareTo = C4593b.m19283a(this.f15612b, acVar.f15612b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18764c()).compareTo(Boolean.valueOf(acVar.m18764c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18764c()) {
            compareTo = C4593b.m19284a(this.f15613c, acVar.f15613c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18766d()).compareTo(Boolean.valueOf(acVar.m18766d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18766d()) {
            compareTo = C4593b.m19284a(this.f15614d, acVar.f15614d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18768e()).compareTo(Boolean.valueOf(acVar.m18768e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18768e()) {
            compareTo = C4593b.m19284a(this.f15615e, acVar.f15615e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18769f()).compareTo(Boolean.valueOf(acVar.m18769f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18769f()) {
            compareTo = C4593b.m19284a(this.f15616f, acVar.f15616f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18770g()).compareTo(Boolean.valueOf(acVar.m18770g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18770g()) {
            compareTo = C4593b.m19284a(this.f15617g, acVar.f15617g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public ac m18760b(String str) {
        this.f15614d = str;
        return this;
    }

    public void m18761b(C4607e c4607e) {
        m18771h();
        c4607e.m19313a(f15603i);
        if (this.f15611a != null && m18757a()) {
            c4607e.m19310a(f15604j);
            c4607e.m19308a(this.f15611a);
            c4607e.m19316b();
        }
        if (this.f15612b != null && m18762b()) {
            c4607e.m19310a(f15605k);
            this.f15612b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15613c != null) {
            c4607e.m19310a(f15606l);
            c4607e.m19308a(this.f15613c);
            c4607e.m19316b();
        }
        if (this.f15614d != null) {
            c4607e.m19310a(f15607m);
            c4607e.m19308a(this.f15614d);
            c4607e.m19316b();
        }
        if (this.f15615e != null) {
            c4607e.m19310a(f15608n);
            c4607e.m19308a(this.f15615e);
            c4607e.m19316b();
        }
        if (this.f15616f != null && m18769f()) {
            c4607e.m19310a(f15609o);
            c4607e.m19308a(this.f15616f);
            c4607e.m19316b();
        }
        if (this.f15617g != null && m18770g()) {
            c4607e.m19310a(f15610p);
            c4607e.m19308a(this.f15617g);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18762b() {
        return this.f15612b != null;
    }

    public ac m18763c(String str) {
        this.f15615e = str;
        return this;
    }

    public boolean m18764c() {
        return this.f15613c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18759b((ac) obj);
    }

    public ac m18765d(String str) {
        this.f15616f = str;
        return this;
    }

    public boolean m18766d() {
        return this.f15614d != null;
    }

    public ac m18767e(String str) {
        this.f15617g = str;
        return this;
    }

    public boolean m18768e() {
        return this.f15615e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof ac)) ? m18758a((ac) obj) : false;
    }

    public boolean m18769f() {
        return this.f15616f != null;
    }

    public boolean m18770g() {
        return this.f15617g != null;
    }

    public void m18771h() {
        if (this.f15613c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15614d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f15615e == null) {
            throw new C4612f("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnSubscription(");
        Object obj2 = 1;
        if (m18757a()) {
            stringBuilder.append("debug:");
            if (this.f15611a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15611a);
            }
            obj2 = null;
        }
        if (m18762b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15612b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15612b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15613c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15613c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15614d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15614d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("topic:");
        if (this.f15615e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15615e);
        }
        if (m18769f()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15616f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15616f);
            }
        }
        if (m18770g()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f15617g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15617g);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
