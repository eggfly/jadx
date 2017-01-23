package com.xiaomi.xmpush.thrift;

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
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.g */
public class C4525g implements Serializable, Cloneable, C4454a<C4525g, C4524a> {
    public static final Map<C4524a, C4601b> f15760h;
    private static final C4615j f15761i;
    private static final C4609b f15762j;
    private static final C4609b f15763k;
    private static final C4609b f15764l;
    private static final C4609b f15765m;
    private static final C4609b f15766n;
    private static final C4609b f15767o;
    private static final C4609b f15768p;
    public int f15769a;
    public int f15770b;
    public boolean f15771c;
    public int f15772d;
    public long f15773e;
    public String f15774f;
    public boolean f15775g;
    private BitSet f15776q;

    /* renamed from: com.xiaomi.xmpush.thrift.g.a */
    public enum C4524a {
        KEY((short) 1, "key"),
        TYPE((short) 2, C4233j.f14402y),
        CLEAR((short) 3, "clear"),
        INT_VALUE((short) 4, "intValue"),
        LONG_VALUE((short) 5, "longValue"),
        STRING_VALUE((short) 6, "stringValue"),
        BOOL_VALUE((short) 7, "boolValue");
        
        private static final Map<String, C4524a> f15756h;
        private final short f15758i;
        private final String f15759j;

        static {
            f15756h = new HashMap();
            Iterator it = EnumSet.allOf(C4524a.class).iterator();
            while (it.hasNext()) {
                C4524a c4524a = (C4524a) it.next();
                f15756h.put(c4524a.m18810a(), c4524a);
            }
        }

        private C4524a(short s, String str) {
            this.f15758i = s;
            this.f15759j = str;
        }

        public String m18810a() {
            return this.f15759j;
        }
    }

    static {
        f15761i = new C4615j("OnlineConfigItem");
        f15762j = new C4609b("key", (byte) 8, (short) 1);
        f15763k = new C4609b(C4233j.f14402y, (byte) 8, (short) 2);
        f15764l = new C4609b("clear", (byte) 2, (short) 3);
        f15765m = new C4609b("intValue", (byte) 8, (short) 4);
        f15766n = new C4609b("longValue", (byte) 10, (short) 5);
        f15767o = new C4609b("stringValue", (byte) 11, (short) 6);
        f15768p = new C4609b("boolValue", (byte) 2, (short) 7);
        Map enumMap = new EnumMap(C4524a.class);
        enumMap.put(C4524a.KEY, new C4601b("key", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4524a.TYPE, new C4601b(C4233j.f14402y, (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4524a.CLEAR, new C4601b("clear", (byte) 2, new C4599c((byte) 2)));
        enumMap.put(C4524a.INT_VALUE, new C4601b("intValue", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4524a.LONG_VALUE, new C4601b("longValue", (byte) 2, new C4599c((byte) 10)));
        enumMap.put(C4524a.STRING_VALUE, new C4601b("stringValue", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4524a.BOOL_VALUE, new C4601b("boolValue", (byte) 2, new C4599c((byte) 2)));
        f15760h = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4525g.class, f15760h);
    }

    public C4525g() {
        this.f15776q = new BitSet(6);
    }

    public int m18811a() {
        return this.f15769a;
    }

    public void m18812a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m18834n();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15769a = c4607e.m19333s();
                    m18813a(true);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15770b = c4607e.m19333s();
                    m18817b(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15771c = c4607e.m19330p();
                    m18820c(true);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15772d = c4607e.m19333s();
                    m18821d(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15773e = c4607e.m19334t();
                    m18823e(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15774f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15775g = c4607e.m19330p();
                    m18826f(true);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18813a(boolean z) {
        this.f15776q.set(0, z);
    }

    public boolean m18814a(C4525g c4525g) {
        if (c4525g == null) {
            return false;
        }
        boolean b = m18818b();
        boolean b2 = c4525g.m18818b();
        if ((b || b2) && (!b || !b2 || this.f15769a != c4525g.f15769a)) {
            return false;
        }
        b = m18822d();
        b2 = c4525g.m18822d();
        if ((b || b2) && (!b || !b2 || this.f15770b != c4525g.f15770b)) {
            return false;
        }
        b = m18824e();
        b2 = c4525g.m18824e();
        if ((b || b2) && (!b || !b2 || this.f15771c != c4525g.f15771c)) {
            return false;
        }
        b = m18827g();
        b2 = c4525g.m18827g();
        if ((b || b2) && (!b || !b2 || this.f15772d != c4525g.f15772d)) {
            return false;
        }
        b = m18829i();
        b2 = c4525g.m18829i();
        if ((b || b2) && (!b || !b2 || this.f15773e != c4525g.f15773e)) {
            return false;
        }
        b = m18831k();
        b2 = c4525g.m18831k();
        if ((b || b2) && (!b || !b2 || !this.f15774f.equals(c4525g.f15774f))) {
            return false;
        }
        b = m18833m();
        b2 = c4525g.m18833m();
        return !(b || b2) || (b && b2 && this.f15775g == c4525g.f15775g);
    }

    public int m18815b(C4525g c4525g) {
        if (!getClass().equals(c4525g.getClass())) {
            return getClass().getName().compareTo(c4525g.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18818b()).compareTo(Boolean.valueOf(c4525g.m18818b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18818b()) {
            compareTo = C4593b.m19281a(this.f15769a, c4525g.f15769a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18822d()).compareTo(Boolean.valueOf(c4525g.m18822d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18822d()) {
            compareTo = C4593b.m19281a(this.f15770b, c4525g.f15770b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18824e()).compareTo(Boolean.valueOf(c4525g.m18824e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18824e()) {
            compareTo = C4593b.m19290a(this.f15771c, c4525g.f15771c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18827g()).compareTo(Boolean.valueOf(c4525g.m18827g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18827g()) {
            compareTo = C4593b.m19281a(this.f15772d, c4525g.f15772d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18829i()).compareTo(Boolean.valueOf(c4525g.m18829i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18829i()) {
            compareTo = C4593b.m19282a(this.f15773e, c4525g.f15773e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18831k()).compareTo(Boolean.valueOf(c4525g.m18831k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18831k()) {
            compareTo = C4593b.m19284a(this.f15774f, c4525g.f15774f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18833m()).compareTo(Boolean.valueOf(c4525g.m18833m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18833m()) {
            compareTo = C4593b.m19290a(this.f15775g, c4525g.f15775g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18816b(C4607e c4607e) {
        m18834n();
        c4607e.m19313a(f15761i);
        if (m18818b()) {
            c4607e.m19310a(f15762j);
            c4607e.m19306a(this.f15769a);
            c4607e.m19316b();
        }
        if (m18822d()) {
            c4607e.m19310a(f15763k);
            c4607e.m19306a(this.f15770b);
            c4607e.m19316b();
        }
        if (m18824e()) {
            c4607e.m19310a(f15764l);
            c4607e.m19315a(this.f15771c);
            c4607e.m19316b();
        }
        if (m18827g()) {
            c4607e.m19310a(f15765m);
            c4607e.m19306a(this.f15772d);
            c4607e.m19316b();
        }
        if (m18829i()) {
            c4607e.m19310a(f15766n);
            c4607e.m19307a(this.f15773e);
            c4607e.m19316b();
        }
        if (this.f15774f != null && m18831k()) {
            c4607e.m19310a(f15767o);
            c4607e.m19308a(this.f15774f);
            c4607e.m19316b();
        }
        if (m18833m()) {
            c4607e.m19310a(f15768p);
            c4607e.m19315a(this.f15775g);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18817b(boolean z) {
        this.f15776q.set(1, z);
    }

    public boolean m18818b() {
        return this.f15776q.get(0);
    }

    public int m18819c() {
        return this.f15770b;
    }

    public void m18820c(boolean z) {
        this.f15776q.set(2, z);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18815b((C4525g) obj);
    }

    public void m18821d(boolean z) {
        this.f15776q.set(3, z);
    }

    public boolean m18822d() {
        return this.f15776q.get(1);
    }

    public void m18823e(boolean z) {
        this.f15776q.set(4, z);
    }

    public boolean m18824e() {
        return this.f15776q.get(2);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4525g)) ? m18814a((C4525g) obj) : false;
    }

    public int m18825f() {
        return this.f15772d;
    }

    public void m18826f(boolean z) {
        this.f15776q.set(5, z);
    }

    public boolean m18827g() {
        return this.f15776q.get(3);
    }

    public long m18828h() {
        return this.f15773e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18829i() {
        return this.f15776q.get(4);
    }

    public String m18830j() {
        return this.f15774f;
    }

    public boolean m18831k() {
        return this.f15774f != null;
    }

    public boolean m18832l() {
        return this.f15775g;
    }

    public boolean m18833m() {
        return this.f15776q.get(5);
    }

    public void m18834n() {
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("OnlineConfigItem(");
        Object obj2 = 1;
        if (m18818b()) {
            stringBuilder.append("key:");
            stringBuilder.append(this.f15769a);
            obj2 = null;
        }
        if (m18822d()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("type:");
            stringBuilder.append(this.f15770b);
            obj2 = null;
        }
        if (m18824e()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("clear:");
            stringBuilder.append(this.f15771c);
            obj2 = null;
        }
        if (m18827g()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("intValue:");
            stringBuilder.append(this.f15772d);
            obj2 = null;
        }
        if (m18829i()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("longValue:");
            stringBuilder.append(this.f15773e);
            obj2 = null;
        }
        if (m18831k()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("stringValue:");
            if (this.f15774f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15774f);
            }
        } else {
            obj = obj2;
        }
        if (m18833m()) {
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("boolValue:");
            stringBuilder.append(this.f15775g);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
