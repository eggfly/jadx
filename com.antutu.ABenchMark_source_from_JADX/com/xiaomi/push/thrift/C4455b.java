package com.xiaomi.push.thrift;

import com.taobao.accs.internal.C4103b;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.push.thrift.b */
public class C4455b implements Serializable, Cloneable, C4454a<C4455b, C4453a> {
    public static final Map<C4453a, C4601b> f15260k;
    private static final C4615j f15261l;
    private static final C4609b f15262m;
    private static final C4609b f15263n;
    private static final C4609b f15264o;
    private static final C4609b f15265p;
    private static final C4609b f15266q;
    private static final C4609b f15267r;
    private static final C4609b f15268s;
    private static final C4609b f15269t;
    private static final C4609b f15270u;
    private static final C4609b f15271v;
    public byte f15272a;
    public int f15273b;
    public int f15274c;
    public String f15275d;
    public String f15276e;
    public int f15277f;
    public String f15278g;
    public String f15279h;
    public int f15280i;
    public int f15281j;
    private BitSet f15282w;

    /* renamed from: com.xiaomi.push.thrift.b.a */
    public enum C4453a {
        CHID((short) 1, "chid"),
        TYPE((short) 2, C4233j.f14402y),
        VALUE((short) 3, "value"),
        CONNPT((short) 4, "connpt"),
        HOST((short) 5, C4103b.ELECTION_KEY_HOST),
        SUBVALUE((short) 6, "subvalue"),
        ANNOTATION((short) 7, "annotation"),
        USER((short) 8, "user"),
        TIME((short) 9, C4233j.f14377D),
        CLIENT_IP((short) 10, "clientIp");
        
        private static final Map<String, C4453a> f15256k;
        private final short f15258l;
        private final String f15259m;

        static {
            f15256k = new HashMap();
            Iterator it = EnumSet.allOf(C4453a.class).iterator();
            while (it.hasNext()) {
                C4453a c4453a = (C4453a) it.next();
                f15256k.put(c4453a.m18408a(), c4453a);
            }
        }

        private C4453a(short s, String str) {
            this.f15258l = s;
            this.f15259m = str;
        }

        public String m18408a() {
            return this.f15259m;
        }
    }

    static {
        f15261l = new C4615j("StatsEvent");
        f15262m = new C4609b("chid", (byte) 3, (short) 1);
        f15263n = new C4609b(C4233j.f14402y, (byte) 8, (short) 2);
        f15264o = new C4609b("value", (byte) 8, (short) 3);
        f15265p = new C4609b("connpt", (byte) 11, (short) 4);
        f15266q = new C4609b(C4103b.ELECTION_KEY_HOST, (byte) 11, (short) 5);
        f15267r = new C4609b("subvalue", (byte) 8, (short) 6);
        f15268s = new C4609b("annotation", (byte) 11, (short) 7);
        f15269t = new C4609b("user", (byte) 11, (short) 8);
        f15270u = new C4609b(C4233j.f14377D, (byte) 8, (short) 9);
        f15271v = new C4609b("clientIp", (byte) 8, (short) 10);
        Map enumMap = new EnumMap(C4453a.class);
        enumMap.put(C4453a.CHID, new C4601b("chid", (byte) 1, new C4599c((byte) 3)));
        enumMap.put(C4453a.TYPE, new C4601b(C4233j.f14402y, (byte) 1, new C4599c((byte) 8)));
        enumMap.put(C4453a.VALUE, new C4601b("value", (byte) 1, new C4599c((byte) 8)));
        enumMap.put(C4453a.CONNPT, new C4601b("connpt", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4453a.HOST, new C4601b(C4103b.ELECTION_KEY_HOST, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4453a.SUBVALUE, new C4601b("subvalue", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4453a.ANNOTATION, new C4601b("annotation", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4453a.USER, new C4601b("user", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4453a.TIME, new C4601b(C4233j.f14377D, (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4453a.CLIENT_IP, new C4601b("clientIp", (byte) 2, new C4599c((byte) 8)));
        f15260k = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4455b.class, f15260k);
    }

    public C4455b() {
        this.f15282w = new BitSet(6);
    }

    public C4455b(C4455b c4455b) {
        this.f15282w = new BitSet(6);
        this.f15282w.clear();
        this.f15282w.or(c4455b.f15282w);
        this.f15272a = c4455b.f15272a;
        this.f15273b = c4455b.f15273b;
        this.f15274c = c4455b.f15274c;
        if (c4455b.m18431d()) {
            this.f15275d = c4455b.f15275d;
        }
        if (c4455b.m18434e()) {
            this.f15276e = c4455b.f15276e;
        }
        this.f15277f = c4455b.f15277f;
        if (c4455b.m18437g()) {
            this.f15278g = c4455b.f15278g;
        }
        if (c4455b.m18438h()) {
            this.f15279h = c4455b.f15279h;
        }
        this.f15280i = c4455b.f15280i;
        this.f15281j = c4455b.f15281j;
    }

    public C4455b m18411a(byte b) {
        this.f15272a = b;
        m18415a(true);
        return this;
    }

    public C4455b m18412a(int i) {
        this.f15273b = i;
        m18422b(true);
        return this;
    }

    public C4455b m18413a(String str) {
        this.f15275d = str;
        return this;
    }

    public void m18414a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (!m18416a()) {
                    throw new C4612f("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!m18423b()) {
                    throw new C4612f("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (m18427c()) {
                    m18441k();
                    return;
                } else {
                    throw new C4612f("Required field 'value' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 3) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15272a = c4607e.m19331q();
                    m18415a(true);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15273b = c4607e.m19333s();
                    m18422b(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15274c = c4607e.m19333s();
                    m18426c(true);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15275d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15276e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15277f = c4607e.m19333s();
                    m18430d(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15278g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15279h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15280i = c4607e.m19333s();
                    m18433e(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15281j = c4607e.m19333s();
                    m18435f(true);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18415a(boolean z) {
        this.f15282w.set(0, z);
    }

    public boolean m18416a() {
        return this.f15282w.get(0);
    }

    public boolean m18417a(C4455b c4455b) {
        if (c4455b == null || this.f15272a != c4455b.f15272a || this.f15273b != c4455b.f15273b || this.f15274c != c4455b.f15274c) {
            return false;
        }
        boolean d = m18431d();
        boolean d2 = c4455b.m18431d();
        if ((d || d2) && (!d || !d2 || !this.f15275d.equals(c4455b.f15275d))) {
            return false;
        }
        d = m18434e();
        d2 = c4455b.m18434e();
        if ((d || d2) && (!d || !d2 || !this.f15276e.equals(c4455b.f15276e))) {
            return false;
        }
        d = m18436f();
        d2 = c4455b.m18436f();
        if ((d || d2) && (!d || !d2 || this.f15277f != c4455b.f15277f)) {
            return false;
        }
        d = m18437g();
        d2 = c4455b.m18437g();
        if ((d || d2) && (!d || !d2 || !this.f15278g.equals(c4455b.f15278g))) {
            return false;
        }
        d = m18438h();
        d2 = c4455b.m18438h();
        if ((d || d2) && (!d || !d2 || !this.f15279h.equals(c4455b.f15279h))) {
            return false;
        }
        d = m18439i();
        d2 = c4455b.m18439i();
        if ((d || d2) && (!d || !d2 || this.f15280i != c4455b.f15280i)) {
            return false;
        }
        d = m18440j();
        d2 = c4455b.m18440j();
        return !(d || d2) || (d && d2 && this.f15281j == c4455b.f15281j);
    }

    public int m18418b(C4455b c4455b) {
        if (!getClass().equals(c4455b.getClass())) {
            return getClass().getName().compareTo(c4455b.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18416a()).compareTo(Boolean.valueOf(c4455b.m18416a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18416a()) {
            compareTo = C4593b.m19280a(this.f15272a, c4455b.f15272a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18423b()).compareTo(Boolean.valueOf(c4455b.m18423b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18423b()) {
            compareTo = C4593b.m19281a(this.f15273b, c4455b.f15273b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18427c()).compareTo(Boolean.valueOf(c4455b.m18427c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18427c()) {
            compareTo = C4593b.m19281a(this.f15274c, c4455b.f15274c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18431d()).compareTo(Boolean.valueOf(c4455b.m18431d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18431d()) {
            compareTo = C4593b.m19284a(this.f15275d, c4455b.f15275d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18434e()).compareTo(Boolean.valueOf(c4455b.m18434e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18434e()) {
            compareTo = C4593b.m19284a(this.f15276e, c4455b.f15276e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18436f()).compareTo(Boolean.valueOf(c4455b.m18436f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18436f()) {
            compareTo = C4593b.m19281a(this.f15277f, c4455b.f15277f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18437g()).compareTo(Boolean.valueOf(c4455b.m18437g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18437g()) {
            compareTo = C4593b.m19284a(this.f15278g, c4455b.f15278g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18438h()).compareTo(Boolean.valueOf(c4455b.m18438h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18438h()) {
            compareTo = C4593b.m19284a(this.f15279h, c4455b.f15279h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18439i()).compareTo(Boolean.valueOf(c4455b.m18439i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18439i()) {
            compareTo = C4593b.m19281a(this.f15280i, c4455b.f15280i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18440j()).compareTo(Boolean.valueOf(c4455b.m18440j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18440j()) {
            compareTo = C4593b.m19281a(this.f15281j, c4455b.f15281j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4455b m18419b(int i) {
        this.f15274c = i;
        m18426c(true);
        return this;
    }

    public C4455b m18420b(String str) {
        this.f15276e = str;
        return this;
    }

    public void m18421b(C4607e c4607e) {
        m18441k();
        c4607e.m19313a(f15261l);
        c4607e.m19310a(f15262m);
        c4607e.m19305a(this.f15272a);
        c4607e.m19316b();
        c4607e.m19310a(f15263n);
        c4607e.m19306a(this.f15273b);
        c4607e.m19316b();
        c4607e.m19310a(f15264o);
        c4607e.m19306a(this.f15274c);
        c4607e.m19316b();
        if (this.f15275d != null) {
            c4607e.m19310a(f15265p);
            c4607e.m19308a(this.f15275d);
            c4607e.m19316b();
        }
        if (this.f15276e != null && m18434e()) {
            c4607e.m19310a(f15266q);
            c4607e.m19308a(this.f15276e);
            c4607e.m19316b();
        }
        if (m18436f()) {
            c4607e.m19310a(f15267r);
            c4607e.m19306a(this.f15277f);
            c4607e.m19316b();
        }
        if (this.f15278g != null && m18437g()) {
            c4607e.m19310a(f15268s);
            c4607e.m19308a(this.f15278g);
            c4607e.m19316b();
        }
        if (this.f15279h != null && m18438h()) {
            c4607e.m19310a(f15269t);
            c4607e.m19308a(this.f15279h);
            c4607e.m19316b();
        }
        if (m18439i()) {
            c4607e.m19310a(f15270u);
            c4607e.m19306a(this.f15280i);
            c4607e.m19316b();
        }
        if (m18440j()) {
            c4607e.m19310a(f15271v);
            c4607e.m19306a(this.f15281j);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18422b(boolean z) {
        this.f15282w.set(1, z);
    }

    public boolean m18423b() {
        return this.f15282w.get(1);
    }

    public C4455b m18424c(int i) {
        this.f15277f = i;
        m18430d(true);
        return this;
    }

    public C4455b m18425c(String str) {
        this.f15278g = str;
        return this;
    }

    public void m18426c(boolean z) {
        this.f15282w.set(2, z);
    }

    public boolean m18427c() {
        return this.f15282w.get(2);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18418b((C4455b) obj);
    }

    public C4455b m18428d(int i) {
        this.f15280i = i;
        m18433e(true);
        return this;
    }

    public C4455b m18429d(String str) {
        this.f15279h = str;
        return this;
    }

    public void m18430d(boolean z) {
        this.f15282w.set(3, z);
    }

    public boolean m18431d() {
        return this.f15275d != null;
    }

    public C4455b m18432e(int i) {
        this.f15281j = i;
        m18435f(true);
        return this;
    }

    public void m18433e(boolean z) {
        this.f15282w.set(4, z);
    }

    public boolean m18434e() {
        return this.f15276e != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4455b)) ? m18417a((C4455b) obj) : false;
    }

    public void m18435f(boolean z) {
        this.f15282w.set(5, z);
    }

    public boolean m18436f() {
        return this.f15282w.get(3);
    }

    public boolean m18437g() {
        return this.f15278g != null;
    }

    public boolean m18438h() {
        return this.f15279h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18439i() {
        return this.f15282w.get(4);
    }

    public boolean m18440j() {
        return this.f15282w.get(5);
    }

    public void m18441k() {
        if (this.f15275d == null) {
            throw new C4612f("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsEvent(");
        stringBuilder.append("chid:");
        stringBuilder.append(this.f15272a);
        stringBuilder.append(", ");
        stringBuilder.append("type:");
        stringBuilder.append(this.f15273b);
        stringBuilder.append(", ");
        stringBuilder.append("value:");
        stringBuilder.append(this.f15274c);
        stringBuilder.append(", ");
        stringBuilder.append("connpt:");
        if (this.f15275d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15275d);
        }
        if (m18434e()) {
            stringBuilder.append(", ");
            stringBuilder.append("host:");
            if (this.f15276e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15276e);
            }
        }
        if (m18436f()) {
            stringBuilder.append(", ");
            stringBuilder.append("subvalue:");
            stringBuilder.append(this.f15277f);
        }
        if (m18437g()) {
            stringBuilder.append(", ");
            stringBuilder.append("annotation:");
            if (this.f15278g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15278g);
            }
        }
        if (m18438h()) {
            stringBuilder.append(", ");
            stringBuilder.append("user:");
            if (this.f15279h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15279h);
            }
        }
        if (m18439i()) {
            stringBuilder.append(", ");
            stringBuilder.append("time:");
            stringBuilder.append(this.f15280i);
        }
        if (m18440j()) {
            stringBuilder.append(", ");
            stringBuilder.append("clientIp:");
            stringBuilder.append(this.f15281j);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
