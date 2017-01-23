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
import org.android.agoo.common.C4575b;
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

public class aa implements Serializable, Cloneable, C4454a<aa, C4514a> {
    public static final Map<C4514a, C4601b> f15538k;
    private static final C4615j f15539l;
    private static final C4609b f15540m;
    private static final C4609b f15541n;
    private static final C4609b f15542o;
    private static final C4609b f15543p;
    private static final C4609b f15544q;
    private static final C4609b f15545r;
    private static final C4609b f15546s;
    private static final C4609b f15547t;
    private static final C4609b f15548u;
    private static final C4609b f15549v;
    public String f15550a;
    public C4532k f15551b;
    public String f15552c;
    public String f15553d;
    public String f15554e;
    public String f15555f;
    public String f15556g;
    public String f15557h;
    public String f15558i;
    public String f15559j;

    /* renamed from: com.xiaomi.xmpush.thrift.aa.a */
    public enum C4514a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        REG_ID((short) 5, "regId"),
        APP_VERSION((short) 6, Constants.KEY_APP_VERSION),
        PACKAGE_NAME((short) 7, Constants.KEY_PACKAGE_NAME),
        TOKEN((short) 8, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID((short) 9, C4575b.KEY_DEVICE_TOKEN),
        ALIAS_NAME((short) 10, "aliasName");
        
        private static final Map<String, C4514a> f15534k;
        private final short f15536l;
        private final String f15537m;

        static {
            f15534k = new HashMap();
            Iterator it = EnumSet.allOf(C4514a.class).iterator();
            while (it.hasNext()) {
                C4514a c4514a = (C4514a) it.next();
                f15534k.put(c4514a.m18718a(), c4514a);
            }
        }

        private C4514a(short s, String str) {
            this.f15536l = s;
            this.f15537m = str;
        }

        public String m18718a() {
            return this.f15537m;
        }
    }

    static {
        f15539l = new C4615j("XmPushActionUnRegistration");
        f15540m = new C4609b("debug", (byte) 11, (short) 1);
        f15541n = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15542o = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15543p = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15544q = new C4609b("regId", (byte) 11, (short) 5);
        f15545r = new C4609b(Constants.KEY_APP_VERSION, (byte) 11, (short) 6);
        f15546s = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 7);
        f15547t = new C4609b(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, (byte) 11, (short) 8);
        f15548u = new C4609b(C4575b.KEY_DEVICE_TOKEN, (byte) 11, (short) 9);
        f15549v = new C4609b("aliasName", (byte) 11, (short) 10);
        Map enumMap = new EnumMap(C4514a.class);
        enumMap.put(C4514a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4514a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4514a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4514a.REG_ID, new C4601b("regId", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.APP_VERSION, new C4601b(Constants.KEY_APP_VERSION, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.TOKEN, new C4601b(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.DEVICE_ID, new C4601b(C4575b.KEY_DEVICE_TOKEN, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4514a.ALIAS_NAME, new C4601b("aliasName", (byte) 2, new C4599c((byte) 11)));
        f15538k = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(aa.class, f15538k);
    }

    public aa m18719a(String str) {
        this.f15552c = str;
        return this;
    }

    public void m18720a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18738k();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15550a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15551b = new C4532k();
                    this.f15551b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15552c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15553d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15554e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15555f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15556g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15557h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15558i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15559j = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m18721a() {
        return this.f15550a != null;
    }

    public boolean m18722a(aa aaVar) {
        if (aaVar == null) {
            return false;
        }
        boolean a = m18721a();
        boolean a2 = aaVar.m18721a();
        if ((a || a2) && (!a || !a2 || !this.f15550a.equals(aaVar.f15550a))) {
            return false;
        }
        a = m18726b();
        a2 = aaVar.m18726b();
        if ((a || a2) && (!a || !a2 || !this.f15551b.m18904a(aaVar.f15551b))) {
            return false;
        }
        a = m18728c();
        a2 = aaVar.m18728c();
        if ((a || a2) && (!a || !a2 || !this.f15552c.equals(aaVar.f15552c))) {
            return false;
        }
        a = m18730d();
        a2 = aaVar.m18730d();
        if ((a || a2) && (!a || !a2 || !this.f15553d.equals(aaVar.f15553d))) {
            return false;
        }
        a = m18732e();
        a2 = aaVar.m18732e();
        if ((a || a2) && (!a || !a2 || !this.f15554e.equals(aaVar.f15554e))) {
            return false;
        }
        a = m18733f();
        a2 = aaVar.m18733f();
        if ((a || a2) && (!a || !a2 || !this.f15555f.equals(aaVar.f15555f))) {
            return false;
        }
        a = m18734g();
        a2 = aaVar.m18734g();
        if ((a || a2) && (!a || !a2 || !this.f15556g.equals(aaVar.f15556g))) {
            return false;
        }
        a = m18735h();
        a2 = aaVar.m18735h();
        if ((a || a2) && (!a || !a2 || !this.f15557h.equals(aaVar.f15557h))) {
            return false;
        }
        a = m18736i();
        a2 = aaVar.m18736i();
        if ((a || a2) && (!a || !a2 || !this.f15558i.equals(aaVar.f15558i))) {
            return false;
        }
        a = m18737j();
        a2 = aaVar.m18737j();
        return !(a || a2) || (a && a2 && this.f15559j.equals(aaVar.f15559j));
    }

    public int m18723b(aa aaVar) {
        if (!getClass().equals(aaVar.getClass())) {
            return getClass().getName().compareTo(aaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18721a()).compareTo(Boolean.valueOf(aaVar.m18721a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18721a()) {
            compareTo = C4593b.m19284a(this.f15550a, aaVar.f15550a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18726b()).compareTo(Boolean.valueOf(aaVar.m18726b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18726b()) {
            compareTo = C4593b.m19283a(this.f15551b, aaVar.f15551b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18728c()).compareTo(Boolean.valueOf(aaVar.m18728c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18728c()) {
            compareTo = C4593b.m19284a(this.f15552c, aaVar.f15552c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18730d()).compareTo(Boolean.valueOf(aaVar.m18730d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18730d()) {
            compareTo = C4593b.m19284a(this.f15553d, aaVar.f15553d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18732e()).compareTo(Boolean.valueOf(aaVar.m18732e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18732e()) {
            compareTo = C4593b.m19284a(this.f15554e, aaVar.f15554e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18733f()).compareTo(Boolean.valueOf(aaVar.m18733f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18733f()) {
            compareTo = C4593b.m19284a(this.f15555f, aaVar.f15555f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18734g()).compareTo(Boolean.valueOf(aaVar.m18734g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18734g()) {
            compareTo = C4593b.m19284a(this.f15556g, aaVar.f15556g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18735h()).compareTo(Boolean.valueOf(aaVar.m18735h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18735h()) {
            compareTo = C4593b.m19284a(this.f15557h, aaVar.f15557h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18736i()).compareTo(Boolean.valueOf(aaVar.m18736i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18736i()) {
            compareTo = C4593b.m19284a(this.f15558i, aaVar.f15558i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18737j()).compareTo(Boolean.valueOf(aaVar.m18737j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18737j()) {
            compareTo = C4593b.m19284a(this.f15559j, aaVar.f15559j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public aa m18724b(String str) {
        this.f15553d = str;
        return this;
    }

    public void m18725b(C4607e c4607e) {
        m18738k();
        c4607e.m19313a(f15539l);
        if (this.f15550a != null && m18721a()) {
            c4607e.m19310a(f15540m);
            c4607e.m19308a(this.f15550a);
            c4607e.m19316b();
        }
        if (this.f15551b != null && m18726b()) {
            c4607e.m19310a(f15541n);
            this.f15551b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15552c != null) {
            c4607e.m19310a(f15542o);
            c4607e.m19308a(this.f15552c);
            c4607e.m19316b();
        }
        if (this.f15553d != null) {
            c4607e.m19310a(f15543p);
            c4607e.m19308a(this.f15553d);
            c4607e.m19316b();
        }
        if (this.f15554e != null && m18732e()) {
            c4607e.m19310a(f15544q);
            c4607e.m19308a(this.f15554e);
            c4607e.m19316b();
        }
        if (this.f15555f != null && m18733f()) {
            c4607e.m19310a(f15545r);
            c4607e.m19308a(this.f15555f);
            c4607e.m19316b();
        }
        if (this.f15556g != null && m18734g()) {
            c4607e.m19310a(f15546s);
            c4607e.m19308a(this.f15556g);
            c4607e.m19316b();
        }
        if (this.f15557h != null && m18735h()) {
            c4607e.m19310a(f15547t);
            c4607e.m19308a(this.f15557h);
            c4607e.m19316b();
        }
        if (this.f15558i != null && m18736i()) {
            c4607e.m19310a(f15548u);
            c4607e.m19308a(this.f15558i);
            c4607e.m19316b();
        }
        if (this.f15559j != null && m18737j()) {
            c4607e.m19310a(f15549v);
            c4607e.m19308a(this.f15559j);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18726b() {
        return this.f15551b != null;
    }

    public aa m18727c(String str) {
        this.f15554e = str;
        return this;
    }

    public boolean m18728c() {
        return this.f15552c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18723b((aa) obj);
    }

    public aa m18729d(String str) {
        this.f15556g = str;
        return this;
    }

    public boolean m18730d() {
        return this.f15553d != null;
    }

    public aa m18731e(String str) {
        this.f15557h = str;
        return this;
    }

    public boolean m18732e() {
        return this.f15554e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof aa)) ? m18722a((aa) obj) : false;
    }

    public boolean m18733f() {
        return this.f15555f != null;
    }

    public boolean m18734g() {
        return this.f15556g != null;
    }

    public boolean m18735h() {
        return this.f15557h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18736i() {
        return this.f15558i != null;
    }

    public boolean m18737j() {
        return this.f15559j != null;
    }

    public void m18738k() {
        if (this.f15552c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15553d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionUnRegistration(");
        Object obj2 = 1;
        if (m18721a()) {
            stringBuilder.append("debug:");
            if (this.f15550a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15550a);
            }
            obj2 = null;
        }
        if (m18726b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15551b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15551b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15552c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15552c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15553d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15553d);
        }
        if (m18732e()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            if (this.f15554e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15554e);
            }
        }
        if (m18733f()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersion:");
            if (this.f15555f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15555f);
            }
        }
        if (m18734g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15556g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15556g);
            }
        }
        if (m18735h()) {
            stringBuilder.append(", ");
            stringBuilder.append("token:");
            if (this.f15557h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15557h);
            }
        }
        if (m18736i()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            if (this.f15558i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15558i);
            }
        }
        if (m18737j()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.f15559j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15559j);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
