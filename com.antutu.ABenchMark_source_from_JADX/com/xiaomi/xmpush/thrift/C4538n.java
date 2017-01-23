package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4602d;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4610c;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.n */
public class C4538n implements Serializable, Cloneable, C4454a<C4538n, C4537a> {
    public static final Map<C4537a, C4601b> f15961i;
    private static final C4615j f15962j;
    private static final C4609b f15963k;
    private static final C4609b f15964l;
    private static final C4609b f15965m;
    private static final C4609b f15966n;
    private static final C4609b f15967o;
    private static final C4609b f15968p;
    private static final C4609b f15969q;
    private static final C4609b f15970r;
    public String f15971a;
    public C4532k f15972b;
    public String f15973c;
    public String f15974d;
    public String f15975e;
    public List<String> f15976f;
    public String f15977g;
    public String f15978h;

    /* renamed from: com.xiaomi.xmpush.thrift.n.a */
    public enum C4537a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        CMD_NAME((short) 5, "cmdName"),
        CMD_ARGS((short) 6, "cmdArgs"),
        PACKAGE_NAME((short) 7, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 9, "category");
        
        private static final Map<String, C4537a> f15957i;
        private final short f15959j;
        private final String f15960k;

        static {
            f15957i = new HashMap();
            Iterator it = EnumSet.allOf(C4537a.class).iterator();
            while (it.hasNext()) {
                C4537a c4537a = (C4537a) it.next();
                f15957i.put(c4537a.m18957a(), c4537a);
            }
        }

        private C4537a(short s, String str) {
            this.f15959j = s;
            this.f15960k = str;
        }

        public String m18957a() {
            return this.f15960k;
        }
    }

    static {
        f15962j = new C4615j("XmPushActionCommand");
        f15963k = new C4609b("debug", (byte) 11, (short) 1);
        f15964l = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15965m = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15966n = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15967o = new C4609b("cmdName", (byte) 11, (short) 5);
        f15968p = new C4609b("cmdArgs", (byte) 15, (short) 6);
        f15969q = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 7);
        f15970r = new C4609b("category", (byte) 11, (short) 9);
        Map enumMap = new EnumMap(C4537a.class);
        enumMap.put(C4537a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4537a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4537a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4537a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4537a.CMD_NAME, new C4601b("cmdName", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4537a.CMD_ARGS, new C4601b("cmdArgs", (byte) 2, new C4602d((byte) 15, new C4599c((byte) 11))));
        enumMap.put(C4537a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4537a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f15961i = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4538n.class, f15961i);
    }

    public C4538n m18958a(String str) {
        this.f15973c = str;
        return this;
    }

    public void m18959a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18976i();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15971a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15972b = new C4532k();
                    this.f15972b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15973c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15974d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15975e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f15976f = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        this.f15976f.add(c4607e.m19336v());
                    }
                    c4607e.m19327m();
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15977g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15978h = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m18960a() {
        return this.f15971a != null;
    }

    public boolean m18961a(C4538n c4538n) {
        if (c4538n == null) {
            return false;
        }
        boolean a = m18960a();
        boolean a2 = c4538n.m18960a();
        if ((a || a2) && (!a || !a2 || !this.f15971a.equals(c4538n.f15971a))) {
            return false;
        }
        a = m18965b();
        a2 = c4538n.m18965b();
        if ((a || a2) && (!a || !a2 || !this.f15972b.m18904a(c4538n.f15972b))) {
            return false;
        }
        a = m18967c();
        a2 = c4538n.m18967c();
        if ((a || a2) && (!a || !a2 || !this.f15973c.equals(c4538n.f15973c))) {
            return false;
        }
        a = m18969d();
        a2 = c4538n.m18969d();
        if ((a || a2) && (!a || !a2 || !this.f15974d.equals(c4538n.f15974d))) {
            return false;
        }
        a = m18971e();
        a2 = c4538n.m18971e();
        if ((a || a2) && (!a || !a2 || !this.f15975e.equals(c4538n.f15975e))) {
            return false;
        }
        a = m18973f();
        a2 = c4538n.m18973f();
        if ((a || a2) && (!a || !a2 || !this.f15976f.equals(c4538n.f15976f))) {
            return false;
        }
        a = m18974g();
        a2 = c4538n.m18974g();
        if ((a || a2) && (!a || !a2 || !this.f15977g.equals(c4538n.f15977g))) {
            return false;
        }
        a = m18975h();
        a2 = c4538n.m18975h();
        return !(a || a2) || (a && a2 && this.f15978h.equals(c4538n.f15978h));
    }

    public int m18962b(C4538n c4538n) {
        if (!getClass().equals(c4538n.getClass())) {
            return getClass().getName().compareTo(c4538n.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18960a()).compareTo(Boolean.valueOf(c4538n.m18960a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18960a()) {
            compareTo = C4593b.m19284a(this.f15971a, c4538n.f15971a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18965b()).compareTo(Boolean.valueOf(c4538n.m18965b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18965b()) {
            compareTo = C4593b.m19283a(this.f15972b, c4538n.f15972b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18967c()).compareTo(Boolean.valueOf(c4538n.m18967c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18967c()) {
            compareTo = C4593b.m19284a(this.f15973c, c4538n.f15973c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18969d()).compareTo(Boolean.valueOf(c4538n.m18969d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18969d()) {
            compareTo = C4593b.m19284a(this.f15974d, c4538n.f15974d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18971e()).compareTo(Boolean.valueOf(c4538n.m18971e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18971e()) {
            compareTo = C4593b.m19284a(this.f15975e, c4538n.f15975e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18973f()).compareTo(Boolean.valueOf(c4538n.m18973f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18973f()) {
            compareTo = C4593b.m19286a(this.f15976f, c4538n.f15976f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18974g()).compareTo(Boolean.valueOf(c4538n.m18974g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18974g()) {
            compareTo = C4593b.m19284a(this.f15977g, c4538n.f15977g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18975h()).compareTo(Boolean.valueOf(c4538n.m18975h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18975h()) {
            compareTo = C4593b.m19284a(this.f15978h, c4538n.f15978h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4538n m18963b(String str) {
        this.f15974d = str;
        return this;
    }

    public void m18964b(C4607e c4607e) {
        m18976i();
        c4607e.m19313a(f15962j);
        if (this.f15971a != null && m18960a()) {
            c4607e.m19310a(f15963k);
            c4607e.m19308a(this.f15971a);
            c4607e.m19316b();
        }
        if (this.f15972b != null && m18965b()) {
            c4607e.m19310a(f15964l);
            this.f15972b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15973c != null) {
            c4607e.m19310a(f15965m);
            c4607e.m19308a(this.f15973c);
            c4607e.m19316b();
        }
        if (this.f15974d != null) {
            c4607e.m19310a(f15966n);
            c4607e.m19308a(this.f15974d);
            c4607e.m19316b();
        }
        if (this.f15975e != null) {
            c4607e.m19310a(f15967o);
            c4607e.m19308a(this.f15975e);
            c4607e.m19316b();
        }
        if (this.f15976f != null && m18973f()) {
            c4607e.m19310a(f15968p);
            c4607e.m19311a(new C4610c((byte) 11, this.f15976f.size()));
            for (String a : this.f15976f) {
                c4607e.m19308a(a);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        if (this.f15977g != null && m18974g()) {
            c4607e.m19310a(f15969q);
            c4607e.m19308a(this.f15977g);
            c4607e.m19316b();
        }
        if (this.f15978h != null && m18975h()) {
            c4607e.m19310a(f15970r);
            c4607e.m19308a(this.f15978h);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18965b() {
        return this.f15972b != null;
    }

    public C4538n m18966c(String str) {
        this.f15975e = str;
        return this;
    }

    public boolean m18967c() {
        return this.f15973c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18962b((C4538n) obj);
    }

    public void m18968d(String str) {
        if (this.f15976f == null) {
            this.f15976f = new ArrayList();
        }
        this.f15976f.add(str);
    }

    public boolean m18969d() {
        return this.f15974d != null;
    }

    public C4538n m18970e(String str) {
        this.f15977g = str;
        return this;
    }

    public boolean m18971e() {
        return this.f15975e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4538n)) ? m18961a((C4538n) obj) : false;
    }

    public C4538n m18972f(String str) {
        this.f15978h = str;
        return this;
    }

    public boolean m18973f() {
        return this.f15976f != null;
    }

    public boolean m18974g() {
        return this.f15977g != null;
    }

    public boolean m18975h() {
        return this.f15978h != null;
    }

    public int hashCode() {
        return 0;
    }

    public void m18976i() {
        if (this.f15973c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15974d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f15975e == null) {
            throw new C4612f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCommand(");
        Object obj2 = 1;
        if (m18960a()) {
            stringBuilder.append("debug:");
            if (this.f15971a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15971a);
            }
            obj2 = null;
        }
        if (m18965b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15972b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15972b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15973c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15973c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15974d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15974d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("cmdName:");
        if (this.f15975e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15975e);
        }
        if (m18973f()) {
            stringBuilder.append(", ");
            stringBuilder.append("cmdArgs:");
            if (this.f15976f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15976f);
            }
        }
        if (m18974g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15977g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15977g);
            }
        }
        if (m18975h()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f15978h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15978h);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
