package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.viewpagerindicator.C4273R;
import java.io.Serializable;
import java.nio.ByteBuffer;
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

/* renamed from: com.xiaomi.xmpush.thrift.s */
public class C4548s implements Serializable, Cloneable, C4454a<C4548s, C4547a> {
    public static final Map<C4547a, C4601b> f16090l;
    private static final C4615j f16091m;
    private static final C4609b f16092n;
    private static final C4609b f16093o;
    private static final C4609b f16094p;
    private static final C4609b f16095q;
    private static final C4609b f16096r;
    private static final C4609b f16097s;
    private static final C4609b f16098t;
    private static final C4609b f16099u;
    private static final C4609b f16100v;
    private static final C4609b f16101w;
    private static final C4609b f16102x;
    public String f16103a;
    public C4532k f16104b;
    public String f16105c;
    public String f16106d;
    public String f16107e;
    public boolean f16108f;
    public String f16109g;
    public Map<String, String> f16110h;
    public String f16111i;
    public String f16112j;
    public ByteBuffer f16113k;
    private BitSet f16114y;

    /* renamed from: com.xiaomi.xmpush.thrift.s.a */
    public enum C4547a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        TYPE((short) 5, C4233j.f14402y),
        REQUIRE_ACK((short) 6, "requireAck"),
        PAYLOAD((short) 7, "payload"),
        EXTRA((short) 8, "extra"),
        PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 10, "category"),
        BINARY_EXTRA((short) 14, "binaryExtra");
        
        private static final Map<String, C4547a> f16086l;
        private final short f16088m;
        private final String f16089n;

        static {
            f16086l = new HashMap();
            Iterator it = EnumSet.allOf(C4547a.class).iterator();
            while (it.hasNext()) {
                C4547a c4547a = (C4547a) it.next();
                f16086l.put(c4547a.m19047a(), c4547a);
            }
        }

        private C4547a(short s, String str) {
            this.f16088m = s;
            this.f16089n = str;
        }

        public String m19047a() {
            return this.f16089n;
        }
    }

    static {
        f16091m = new C4615j("XmPushActionNotification");
        f16092n = new C4609b("debug", (byte) 11, (short) 1);
        f16093o = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16094p = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16095q = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16096r = new C4609b(C4233j.f14402y, (byte) 11, (short) 5);
        f16097s = new C4609b("requireAck", (byte) 2, (short) 6);
        f16098t = new C4609b("payload", (byte) 11, (short) 7);
        f16099u = new C4609b("extra", (byte) 13, (short) 8);
        f16100v = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
        f16101w = new C4609b("category", (byte) 11, (short) 10);
        f16102x = new C4609b("binaryExtra", (byte) 11, (short) 14);
        Map enumMap = new EnumMap(C4547a.class);
        enumMap.put(C4547a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4547a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4547a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.TYPE, new C4601b(C4233j.f14402y, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.REQUIRE_ACK, new C4601b("requireAck", (byte) 1, new C4599c((byte) 2)));
        enumMap.put(C4547a.PAYLOAD, new C4601b("payload", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.EXTRA, new C4601b("extra", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4547a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4547a.BINARY_EXTRA, new C4601b("binaryExtra", (byte) 2, new C4599c((byte) 11)));
        f16090l = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4548s.class, f16090l);
    }

    public C4548s() {
        this.f16114y = new BitSet(1);
        this.f16108f = true;
    }

    public C4548s(String str, boolean z) {
        this();
        this.f16105c = str;
        this.f16108f = z;
        m19059b(true);
    }

    public C4548s m19048a(String str) {
        this.f16105c = str;
        return this;
    }

    public C4548s m19049a(ByteBuffer byteBuffer) {
        this.f16113k = byteBuffer;
        return this;
    }

    public C4548s m19050a(Map<String, String> map) {
        this.f16110h = map;
        return this;
    }

    public C4548s m19051a(boolean z) {
        this.f16108f = z;
        m19059b(true);
        return this;
    }

    public C4548s m19052a(byte[] bArr) {
        m19049a(ByteBuffer.wrap(bArr));
        return this;
    }

    public void m19053a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m19066f()) {
                    m19074n();
                    return;
                }
                throw new C4612f("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16103a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16104b = new C4532k();
                    this.f16104b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16105c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16106d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16107e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16108f = c4607e.m19330p();
                    m19059b(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16109g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4611d j = c4607e.m19324j();
                    this.f16110h = new HashMap(j.f16482c * 2);
                    for (int i = 0; i < j.f16482c; i++) {
                        this.f16110h.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16111i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16112j = c4607e.m19336v();
                        break;
                    }
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16113k = c4607e.m19337w();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m19054a() {
        return this.f16103a != null;
    }

    public boolean m19055a(C4548s c4548s) {
        if (c4548s == null) {
            return false;
        }
        boolean a = m19054a();
        boolean a2 = c4548s.m19054a();
        if ((a || a2) && (!a || !a2 || !this.f16103a.equals(c4548s.f16103a))) {
            return false;
        }
        a = m19060b();
        a2 = c4548s.m19060b();
        if ((a || a2) && (!a || !a2 || !this.f16104b.m18904a(c4548s.f16104b))) {
            return false;
        }
        a = m19062c();
        a2 = c4548s.m19062c();
        if ((a || a2) && (!a || !a2 || !this.f16105c.equals(c4548s.f16105c))) {
            return false;
        }
        a = m19064d();
        a2 = c4548s.m19064d();
        if ((a || a2) && (!a || !a2 || !this.f16106d.equals(c4548s.f16106d))) {
            return false;
        }
        a = m19065e();
        a2 = c4548s.m19065e();
        if (((a || a2) && (!a || !a2 || !this.f16107e.equals(c4548s.f16107e))) || this.f16108f != c4548s.f16108f) {
            return false;
        }
        a = m19067g();
        a2 = c4548s.m19067g();
        if ((a || a2) && (!a || !a2 || !this.f16109g.equals(c4548s.f16109g))) {
            return false;
        }
        a = m19069i();
        a2 = c4548s.m19069i();
        if ((a || a2) && (!a || !a2 || !this.f16110h.equals(c4548s.f16110h))) {
            return false;
        }
        a = m19070j();
        a2 = c4548s.m19070j();
        if ((a || a2) && (!a || !a2 || !this.f16111i.equals(c4548s.f16111i))) {
            return false;
        }
        a = m19071k();
        a2 = c4548s.m19071k();
        if ((a || a2) && (!a || !a2 || !this.f16112j.equals(c4548s.f16112j))) {
            return false;
        }
        a = m19073m();
        a2 = c4548s.m19073m();
        return !(a || a2) || (a && a2 && this.f16113k.equals(c4548s.f16113k));
    }

    public int m19056b(C4548s c4548s) {
        if (!getClass().equals(c4548s.getClass())) {
            return getClass().getName().compareTo(c4548s.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19054a()).compareTo(Boolean.valueOf(c4548s.m19054a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19054a()) {
            compareTo = C4593b.m19284a(this.f16103a, c4548s.f16103a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19060b()).compareTo(Boolean.valueOf(c4548s.m19060b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19060b()) {
            compareTo = C4593b.m19283a(this.f16104b, c4548s.f16104b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19062c()).compareTo(Boolean.valueOf(c4548s.m19062c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19062c()) {
            compareTo = C4593b.m19284a(this.f16105c, c4548s.f16105c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19064d()).compareTo(Boolean.valueOf(c4548s.m19064d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19064d()) {
            compareTo = C4593b.m19284a(this.f16106d, c4548s.f16106d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19065e()).compareTo(Boolean.valueOf(c4548s.m19065e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19065e()) {
            compareTo = C4593b.m19284a(this.f16107e, c4548s.f16107e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19066f()).compareTo(Boolean.valueOf(c4548s.m19066f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19066f()) {
            compareTo = C4593b.m19290a(this.f16108f, c4548s.f16108f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19067g()).compareTo(Boolean.valueOf(c4548s.m19067g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19067g()) {
            compareTo = C4593b.m19284a(this.f16109g, c4548s.f16109g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19069i()).compareTo(Boolean.valueOf(c4548s.m19069i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19069i()) {
            compareTo = C4593b.m19287a(this.f16110h, c4548s.f16110h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19070j()).compareTo(Boolean.valueOf(c4548s.m19070j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19070j()) {
            compareTo = C4593b.m19284a(this.f16111i, c4548s.f16111i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19071k()).compareTo(Boolean.valueOf(c4548s.m19071k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19071k()) {
            compareTo = C4593b.m19284a(this.f16112j, c4548s.f16112j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19073m()).compareTo(Boolean.valueOf(c4548s.m19073m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19073m()) {
            compareTo = C4593b.m19283a(this.f16113k, c4548s.f16113k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4548s m19057b(String str) {
        this.f16106d = str;
        return this;
    }

    public void m19058b(C4607e c4607e) {
        m19074n();
        c4607e.m19313a(f16091m);
        if (this.f16103a != null && m19054a()) {
            c4607e.m19310a(f16092n);
            c4607e.m19308a(this.f16103a);
            c4607e.m19316b();
        }
        if (this.f16104b != null && m19060b()) {
            c4607e.m19310a(f16093o);
            this.f16104b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16105c != null) {
            c4607e.m19310a(f16094p);
            c4607e.m19308a(this.f16105c);
            c4607e.m19316b();
        }
        if (this.f16106d != null && m19064d()) {
            c4607e.m19310a(f16095q);
            c4607e.m19308a(this.f16106d);
            c4607e.m19316b();
        }
        if (this.f16107e != null && m19065e()) {
            c4607e.m19310a(f16096r);
            c4607e.m19308a(this.f16107e);
            c4607e.m19316b();
        }
        c4607e.m19310a(f16097s);
        c4607e.m19315a(this.f16108f);
        c4607e.m19316b();
        if (this.f16109g != null && m19067g()) {
            c4607e.m19310a(f16098t);
            c4607e.m19308a(this.f16109g);
            c4607e.m19316b();
        }
        if (this.f16110h != null && m19069i()) {
            c4607e.m19310a(f16099u);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f16110h.size()));
            for (Entry entry : this.f16110h.entrySet()) {
                c4607e.m19308a((String) entry.getKey());
                c4607e.m19308a((String) entry.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (this.f16111i != null && m19070j()) {
            c4607e.m19310a(f16100v);
            c4607e.m19308a(this.f16111i);
            c4607e.m19316b();
        }
        if (this.f16112j != null && m19071k()) {
            c4607e.m19310a(f16101w);
            c4607e.m19308a(this.f16112j);
            c4607e.m19316b();
        }
        if (this.f16113k != null && m19073m()) {
            c4607e.m19310a(f16102x);
            c4607e.m19309a(this.f16113k);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m19059b(boolean z) {
        this.f16114y.set(0, z);
    }

    public boolean m19060b() {
        return this.f16104b != null;
    }

    public C4548s m19061c(String str) {
        this.f16107e = str;
        return this;
    }

    public boolean m19062c() {
        return this.f16105c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19056b((C4548s) obj);
    }

    public C4548s m19063d(String str) {
        this.f16111i = str;
        return this;
    }

    public boolean m19064d() {
        return this.f16106d != null;
    }

    public boolean m19065e() {
        return this.f16107e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4548s)) ? m19055a((C4548s) obj) : false;
    }

    public boolean m19066f() {
        return this.f16114y.get(0);
    }

    public boolean m19067g() {
        return this.f16109g != null;
    }

    public Map<String, String> m19068h() {
        return this.f16110h;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m19069i() {
        return this.f16110h != null;
    }

    public boolean m19070j() {
        return this.f16111i != null;
    }

    public boolean m19071k() {
        return this.f16112j != null;
    }

    public byte[] m19072l() {
        m19049a(C4593b.m19296c(this.f16113k));
        return this.f16113k.array();
    }

    public boolean m19073m() {
        return this.f16113k != null;
    }

    public void m19074n() {
        if (this.f16105c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionNotification(");
        Object obj2 = 1;
        if (m19054a()) {
            stringBuilder.append("debug:");
            if (this.f16103a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16103a);
            }
            obj2 = null;
        }
        if (m19060b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16104b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16104b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16105c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16105c);
        }
        if (m19064d()) {
            stringBuilder.append(", ");
            stringBuilder.append("appId:");
            if (this.f16106d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16106d);
            }
        }
        if (m19065e()) {
            stringBuilder.append(", ");
            stringBuilder.append("type:");
            if (this.f16107e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16107e);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("requireAck:");
        stringBuilder.append(this.f16108f);
        if (m19067g()) {
            stringBuilder.append(", ");
            stringBuilder.append("payload:");
            if (this.f16109g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16109g);
            }
        }
        if (m19069i()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.f16110h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16110h);
            }
        }
        if (m19070j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16111i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16111i);
            }
        }
        if (m19071k()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16112j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16112j);
            }
        }
        if (m19073m()) {
            stringBuilder.append(", ");
            stringBuilder.append("binaryExtra:");
            if (this.f16113k == null) {
                stringBuilder.append("null");
            } else {
                C4593b.m19293a(this.f16113k, stringBuilder);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
