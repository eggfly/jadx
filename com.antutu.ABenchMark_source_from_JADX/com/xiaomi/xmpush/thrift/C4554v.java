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

/* renamed from: com.xiaomi.xmpush.thrift.v */
public class C4554v implements Serializable, Cloneable, C4454a<C4554v, C4553a> {
    public static final Map<C4553a, C4601b> f16238g;
    private static final C4615j f16239h;
    private static final C4609b f16240i;
    private static final C4609b f16241j;
    private static final C4609b f16242k;
    private static final C4609b f16243l;
    private static final C4609b f16244m;
    private static final C4609b f16245n;
    public String f16246a;
    public C4532k f16247b;
    public String f16248c;
    public String f16249d;
    public Map<String, String> f16250e;
    public String f16251f;

    /* renamed from: com.xiaomi.xmpush.thrift.v.a */
    public enum C4553a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        FEEDBACKS((short) 5, "feedbacks"),
        CATEGORY((short) 6, "category");
        
        private static final Map<String, C4553a> f16234g;
        private final short f16236h;
        private final String f16237i;

        static {
            f16234g = new HashMap();
            Iterator it = EnumSet.allOf(C4553a.class).iterator();
            while (it.hasNext()) {
                C4553a c4553a = (C4553a) it.next();
                f16234g.put(c4553a.m19142a(), c4553a);
            }
        }

        private C4553a(short s, String str) {
            this.f16236h = s;
            this.f16237i = str;
        }

        public String m19142a() {
            return this.f16237i;
        }
    }

    static {
        f16239h = new C4615j("XmPushActionSendFeedback");
        f16240i = new C4609b("debug", (byte) 11, (short) 1);
        f16241j = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16242k = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16243l = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16244m = new C4609b("feedbacks", (byte) 13, (short) 5);
        f16245n = new C4609b("category", (byte) 11, (short) 6);
        Map enumMap = new EnumMap(C4553a.class);
        enumMap.put(C4553a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4553a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4553a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4553a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4553a.FEEDBACKS, new C4601b("feedbacks", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4553a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f16238g = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4554v.class, f16238g);
    }

    public void m19143a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19153g();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16246a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16247b = new C4532k();
                    this.f16247b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16248c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16249d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4611d j = c4607e.m19324j();
                    this.f16250e = new HashMap(j.f16482c * 2);
                    for (int i = 0; i < j.f16482c; i++) {
                        this.f16250e.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16251f = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m19144a() {
        return this.f16246a != null;
    }

    public boolean m19145a(C4554v c4554v) {
        if (c4554v == null) {
            return false;
        }
        boolean a = m19144a();
        boolean a2 = c4554v.m19144a();
        if ((a || a2) && (!a || !a2 || !this.f16246a.equals(c4554v.f16246a))) {
            return false;
        }
        a = m19148b();
        a2 = c4554v.m19148b();
        if ((a || a2) && (!a || !a2 || !this.f16247b.m18904a(c4554v.f16247b))) {
            return false;
        }
        a = m19149c();
        a2 = c4554v.m19149c();
        if ((a || a2) && (!a || !a2 || !this.f16248c.equals(c4554v.f16248c))) {
            return false;
        }
        a = m19150d();
        a2 = c4554v.m19150d();
        if ((a || a2) && (!a || !a2 || !this.f16249d.equals(c4554v.f16249d))) {
            return false;
        }
        a = m19151e();
        a2 = c4554v.m19151e();
        if ((a || a2) && (!a || !a2 || !this.f16250e.equals(c4554v.f16250e))) {
            return false;
        }
        a = m19152f();
        a2 = c4554v.m19152f();
        return !(a || a2) || (a && a2 && this.f16251f.equals(c4554v.f16251f));
    }

    public int m19146b(C4554v c4554v) {
        if (!getClass().equals(c4554v.getClass())) {
            return getClass().getName().compareTo(c4554v.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19144a()).compareTo(Boolean.valueOf(c4554v.m19144a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19144a()) {
            compareTo = C4593b.m19284a(this.f16246a, c4554v.f16246a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19148b()).compareTo(Boolean.valueOf(c4554v.m19148b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19148b()) {
            compareTo = C4593b.m19283a(this.f16247b, c4554v.f16247b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19149c()).compareTo(Boolean.valueOf(c4554v.m19149c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19149c()) {
            compareTo = C4593b.m19284a(this.f16248c, c4554v.f16248c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19150d()).compareTo(Boolean.valueOf(c4554v.m19150d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19150d()) {
            compareTo = C4593b.m19284a(this.f16249d, c4554v.f16249d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19151e()).compareTo(Boolean.valueOf(c4554v.m19151e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19151e()) {
            compareTo = C4593b.m19287a(this.f16250e, c4554v.f16250e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19152f()).compareTo(Boolean.valueOf(c4554v.m19152f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19152f()) {
            compareTo = C4593b.m19284a(this.f16251f, c4554v.f16251f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m19147b(C4607e c4607e) {
        m19153g();
        c4607e.m19313a(f16239h);
        if (this.f16246a != null && m19144a()) {
            c4607e.m19310a(f16240i);
            c4607e.m19308a(this.f16246a);
            c4607e.m19316b();
        }
        if (this.f16247b != null && m19148b()) {
            c4607e.m19310a(f16241j);
            this.f16247b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16248c != null) {
            c4607e.m19310a(f16242k);
            c4607e.m19308a(this.f16248c);
            c4607e.m19316b();
        }
        if (this.f16249d != null) {
            c4607e.m19310a(f16243l);
            c4607e.m19308a(this.f16249d);
            c4607e.m19316b();
        }
        if (this.f16250e != null && m19151e()) {
            c4607e.m19310a(f16244m);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f16250e.size()));
            for (Entry entry : this.f16250e.entrySet()) {
                c4607e.m19308a((String) entry.getKey());
                c4607e.m19308a((String) entry.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (this.f16251f != null && m19152f()) {
            c4607e.m19310a(f16245n);
            c4607e.m19308a(this.f16251f);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m19148b() {
        return this.f16247b != null;
    }

    public boolean m19149c() {
        return this.f16248c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19146b((C4554v) obj);
    }

    public boolean m19150d() {
        return this.f16249d != null;
    }

    public boolean m19151e() {
        return this.f16250e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4554v)) ? m19145a((C4554v) obj) : false;
    }

    public boolean m19152f() {
        return this.f16251f != null;
    }

    public void m19153g() {
        if (this.f16248c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16249d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionSendFeedback(");
        Object obj2 = 1;
        if (m19144a()) {
            stringBuilder.append("debug:");
            if (this.f16246a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16246a);
            }
            obj2 = null;
        }
        if (m19148b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16247b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16247b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16248c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16248c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16249d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16249d);
        }
        if (m19151e()) {
            stringBuilder.append(", ");
            stringBuilder.append("feedbacks:");
            if (this.f16250e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16250e);
            }
        }
        if (m19152f()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16251f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16251f);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
