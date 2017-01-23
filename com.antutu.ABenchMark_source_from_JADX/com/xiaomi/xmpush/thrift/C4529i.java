package com.xiaomi.xmpush.thrift;

import com.igexin.download.Downloads;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
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
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4611d;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.i */
public class C4529i implements Serializable, Cloneable, C4454a<C4529i, C4528a> {
    public static final Map<C4528a, C4601b> f15824m;
    private static final C4615j f15825n;
    private static final C4609b f15826o;
    private static final C4609b f15827p;
    private static final C4609b f15828q;
    private static final C4609b f15829r;
    private static final C4609b f15830s;
    private static final C4609b f15831t;
    private static final C4609b f15832u;
    private static final C4609b f15833v;
    private static final C4609b f15834w;
    private static final C4609b f15835x;
    private static final C4609b f15836y;
    private static final C4609b f15837z;
    private BitSet f15838A;
    public String f15839a;
    public long f15840b;
    public String f15841c;
    public String f15842d;
    public String f15843e;
    public int f15844f;
    public String f15845g;
    public int f15846h;
    public int f15847i;
    public Map<String, String> f15848j;
    public Map<String, String> f15849k;
    public boolean f15850l;

    /* renamed from: com.xiaomi.xmpush.thrift.i.a */
    public enum C4528a {
        ID((short) 1, AgooConstants.MESSAGE_ID),
        MESSAGE_TS((short) 2, "messageTs"),
        TOPIC((short) 3, "topic"),
        TITLE((short) 4, Downloads.COLUMN_TITLE),
        DESCRIPTION((short) 5, Downloads.COLUMN_DESCRIPTION),
        NOTIFY_TYPE((short) 6, "notifyType"),
        URL((short) 7, "url"),
        PASS_THROUGH((short) 8, "passThrough"),
        NOTIFY_ID((short) 9, "notifyId"),
        EXTRA((short) 10, "extra"),
        INTERNAL((short) 11, "internal"),
        IGNORE_REG_INFO((short) 12, "ignoreRegInfo");
        
        private static final Map<String, C4528a> f15820m;
        private final short f15822n;
        private final String f15823o;

        static {
            f15820m = new HashMap();
            Iterator it = EnumSet.allOf(C4528a.class).iterator();
            while (it.hasNext()) {
                C4528a c4528a = (C4528a) it.next();
                f15820m.put(c4528a.m18855a(), c4528a);
            }
        }

        private C4528a(short s, String str) {
            this.f15822n = s;
            this.f15823o = str;
        }

        public String m18855a() {
            return this.f15823o;
        }
    }

    static {
        f15825n = new C4615j("PushMetaInfo");
        f15826o = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 1);
        f15827p = new C4609b("messageTs", (byte) 10, (short) 2);
        f15828q = new C4609b("topic", (byte) 11, (short) 3);
        f15829r = new C4609b(Downloads.COLUMN_TITLE, (byte) 11, (short) 4);
        f15830s = new C4609b(Downloads.COLUMN_DESCRIPTION, (byte) 11, (short) 5);
        f15831t = new C4609b("notifyType", (byte) 8, (short) 6);
        f15832u = new C4609b("url", (byte) 11, (short) 7);
        f15833v = new C4609b("passThrough", (byte) 8, (short) 8);
        f15834w = new C4609b("notifyId", (byte) 8, (short) 9);
        f15835x = new C4609b("extra", (byte) 13, (short) 10);
        f15836y = new C4609b("internal", (byte) 13, (short) 11);
        f15837z = new C4609b("ignoreRegInfo", (byte) 2, (short) 12);
        Map enumMap = new EnumMap(C4528a.class);
        enumMap.put(C4528a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4528a.MESSAGE_TS, new C4601b("messageTs", (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4528a.TOPIC, new C4601b("topic", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4528a.TITLE, new C4601b(Downloads.COLUMN_TITLE, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4528a.DESCRIPTION, new C4601b(Downloads.COLUMN_DESCRIPTION, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4528a.NOTIFY_TYPE, new C4601b("notifyType", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4528a.URL, new C4601b("url", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4528a.PASS_THROUGH, new C4601b("passThrough", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4528a.NOTIFY_ID, new C4601b("notifyId", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4528a.EXTRA, new C4601b("extra", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4528a.INTERNAL, new C4601b("internal", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4528a.IGNORE_REG_INFO, new C4601b("ignoreRegInfo", (byte) 2, new C4599c((byte) 2)));
        f15824m = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4529i.class, f15824m);
    }

    public C4529i() {
        this.f15838A = new BitSet(5);
        this.f15850l = false;
    }

    public C4529i(C4529i c4529i) {
        Map hashMap;
        this.f15838A = new BitSet(5);
        this.f15838A.clear();
        this.f15838A.or(c4529i.f15838A);
        if (c4529i.m18873c()) {
            this.f15839a = c4529i.f15839a;
        }
        this.f15840b = c4529i.f15840b;
        if (c4529i.m18880g()) {
            this.f15841c = c4529i.f15841c;
        }
        if (c4529i.m18882i()) {
            this.f15842d = c4529i.f15842d;
        }
        if (c4529i.m18884k()) {
            this.f15843e = c4529i.f15843e;
        }
        this.f15844f = c4529i.f15844f;
        if (c4529i.m18887n()) {
            this.f15845g = c4529i.f15845g;
        }
        this.f15846h = c4529i.f15846h;
        this.f15847i = c4529i.f15847i;
        if (c4529i.m18893t()) {
            hashMap = new HashMap();
            for (Entry entry : c4529i.f15848j.entrySet()) {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.f15848j = hashMap;
        }
        if (c4529i.m18894u()) {
            hashMap = new HashMap();
            for (Entry entry2 : c4529i.f15849k.entrySet()) {
                hashMap.put((String) entry2.getKey(), (String) entry2.getValue());
            }
            this.f15849k = hashMap;
        }
        this.f15850l = c4529i.f15850l;
    }

    public C4529i m18856a() {
        return new C4529i(this);
    }

    public C4529i m18857a(int i) {
        this.f15844f = i;
        m18869b(true);
        return this;
    }

    public C4529i m18858a(String str) {
        this.f15839a = str;
        return this;
    }

    public C4529i m18859a(Map<String, String> map) {
        this.f15848j = map;
        return this;
    }

    public void m18860a(String str, String str2) {
        if (this.f15848j == null) {
            this.f15848j = new HashMap();
        }
        this.f15848j.put(str, str2);
    }

    public void m18861a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18878e()) {
                    m18897x();
                    return;
                }
                throw new C4612f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            C4611d j;
            int i;
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15839a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15840b = c4607e.m19334t();
                    m18862a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15841c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15842d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15843e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15844f = c4607e.m19333s();
                    m18869b(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15845g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15846h = c4607e.m19333s();
                    m18872c(true);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15847i = c4607e.m19333s();
                    m18876d(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    j = c4607e.m19324j();
                    this.f15848j = new HashMap(j.f16482c * 2);
                    for (i = 0; i < j.f16482c; i++) {
                        this.f15848j.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    if (h.f16476b != (byte) 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    j = c4607e.m19324j();
                    this.f15849k = new HashMap(j.f16482c * 2);
                    for (i = 0; i < j.f16482c; i++) {
                        this.f15849k.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15850l = c4607e.m19330p();
                    m18877e(true);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18862a(boolean z) {
        this.f15838A.set(0, z);
    }

    public boolean m18863a(C4529i c4529i) {
        if (c4529i == null) {
            return false;
        }
        boolean c = m18873c();
        boolean c2 = c4529i.m18873c();
        if (((c || c2) && (!c || !c2 || !this.f15839a.equals(c4529i.f15839a))) || this.f15840b != c4529i.f15840b) {
            return false;
        }
        c = m18880g();
        c2 = c4529i.m18880g();
        if ((c || c2) && (!c || !c2 || !this.f15841c.equals(c4529i.f15841c))) {
            return false;
        }
        c = m18882i();
        c2 = c4529i.m18882i();
        if ((c || c2) && (!c || !c2 || !this.f15842d.equals(c4529i.f15842d))) {
            return false;
        }
        c = m18884k();
        c2 = c4529i.m18884k();
        if ((c || c2) && (!c || !c2 || !this.f15843e.equals(c4529i.f15843e))) {
            return false;
        }
        c = m18886m();
        c2 = c4529i.m18886m();
        if ((c || c2) && (!c || !c2 || this.f15844f != c4529i.f15844f)) {
            return false;
        }
        c = m18887n();
        c2 = c4529i.m18887n();
        if ((c || c2) && (!c || !c2 || !this.f15845g.equals(c4529i.f15845g))) {
            return false;
        }
        c = m18889p();
        c2 = c4529i.m18889p();
        if ((c || c2) && (!c || !c2 || this.f15846h != c4529i.f15846h)) {
            return false;
        }
        c = m18891r();
        c2 = c4529i.m18891r();
        if ((c || c2) && (!c || !c2 || this.f15847i != c4529i.f15847i)) {
            return false;
        }
        c = m18893t();
        c2 = c4529i.m18893t();
        if ((c || c2) && (!c || !c2 || !this.f15848j.equals(c4529i.f15848j))) {
            return false;
        }
        c = m18894u();
        c2 = c4529i.m18894u();
        if ((c || c2) && (!c || !c2 || !this.f15849k.equals(c4529i.f15849k))) {
            return false;
        }
        c = m18896w();
        c2 = c4529i.m18896w();
        return !(c || c2) || (c && c2 && this.f15850l == c4529i.f15850l);
    }

    public int m18864b(C4529i c4529i) {
        if (!getClass().equals(c4529i.getClass())) {
            return getClass().getName().compareTo(c4529i.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18873c()).compareTo(Boolean.valueOf(c4529i.m18873c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18873c()) {
            compareTo = C4593b.m19284a(this.f15839a, c4529i.f15839a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18878e()).compareTo(Boolean.valueOf(c4529i.m18878e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18878e()) {
            compareTo = C4593b.m19282a(this.f15840b, c4529i.f15840b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18880g()).compareTo(Boolean.valueOf(c4529i.m18880g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18880g()) {
            compareTo = C4593b.m19284a(this.f15841c, c4529i.f15841c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18882i()).compareTo(Boolean.valueOf(c4529i.m18882i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18882i()) {
            compareTo = C4593b.m19284a(this.f15842d, c4529i.f15842d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18884k()).compareTo(Boolean.valueOf(c4529i.m18884k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18884k()) {
            compareTo = C4593b.m19284a(this.f15843e, c4529i.f15843e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18886m()).compareTo(Boolean.valueOf(c4529i.m18886m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18886m()) {
            compareTo = C4593b.m19281a(this.f15844f, c4529i.f15844f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18887n()).compareTo(Boolean.valueOf(c4529i.m18887n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18887n()) {
            compareTo = C4593b.m19284a(this.f15845g, c4529i.f15845g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18889p()).compareTo(Boolean.valueOf(c4529i.m18889p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18889p()) {
            compareTo = C4593b.m19281a(this.f15846h, c4529i.f15846h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18891r()).compareTo(Boolean.valueOf(c4529i.m18891r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18891r()) {
            compareTo = C4593b.m19281a(this.f15847i, c4529i.f15847i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18893t()).compareTo(Boolean.valueOf(c4529i.m18893t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18893t()) {
            compareTo = C4593b.m19287a(this.f15848j, c4529i.f15848j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18894u()).compareTo(Boolean.valueOf(c4529i.m18894u()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18894u()) {
            compareTo = C4593b.m19287a(this.f15849k, c4529i.f15849k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18896w()).compareTo(Boolean.valueOf(c4529i.m18896w()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18896w()) {
            compareTo = C4593b.m19290a(this.f15850l, c4529i.f15850l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4529i m18865b(int i) {
        this.f15846h = i;
        m18872c(true);
        return this;
    }

    public C4529i m18866b(String str) {
        this.f15841c = str;
        return this;
    }

    public String m18867b() {
        return this.f15839a;
    }

    public void m18868b(C4607e c4607e) {
        m18897x();
        c4607e.m19313a(f15825n);
        if (this.f15839a != null) {
            c4607e.m19310a(f15826o);
            c4607e.m19308a(this.f15839a);
            c4607e.m19316b();
        }
        c4607e.m19310a(f15827p);
        c4607e.m19307a(this.f15840b);
        c4607e.m19316b();
        if (this.f15841c != null && m18880g()) {
            c4607e.m19310a(f15828q);
            c4607e.m19308a(this.f15841c);
            c4607e.m19316b();
        }
        if (this.f15842d != null && m18882i()) {
            c4607e.m19310a(f15829r);
            c4607e.m19308a(this.f15842d);
            c4607e.m19316b();
        }
        if (this.f15843e != null && m18884k()) {
            c4607e.m19310a(f15830s);
            c4607e.m19308a(this.f15843e);
            c4607e.m19316b();
        }
        if (m18886m()) {
            c4607e.m19310a(f15831t);
            c4607e.m19306a(this.f15844f);
            c4607e.m19316b();
        }
        if (this.f15845g != null && m18887n()) {
            c4607e.m19310a(f15832u);
            c4607e.m19308a(this.f15845g);
            c4607e.m19316b();
        }
        if (m18889p()) {
            c4607e.m19310a(f15833v);
            c4607e.m19306a(this.f15846h);
            c4607e.m19316b();
        }
        if (m18891r()) {
            c4607e.m19310a(f15834w);
            c4607e.m19306a(this.f15847i);
            c4607e.m19316b();
        }
        if (this.f15848j != null && m18893t()) {
            c4607e.m19310a(f15835x);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f15848j.size()));
            for (Entry entry : this.f15848j.entrySet()) {
                c4607e.m19308a((String) entry.getKey());
                c4607e.m19308a((String) entry.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (this.f15849k != null && m18894u()) {
            c4607e.m19310a(f15836y);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f15849k.size()));
            for (Entry entry2 : this.f15849k.entrySet()) {
                c4607e.m19308a((String) entry2.getKey());
                c4607e.m19308a((String) entry2.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (m18896w()) {
            c4607e.m19310a(f15837z);
            c4607e.m19315a(this.f15850l);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18869b(boolean z) {
        this.f15838A.set(1, z);
    }

    public C4529i m18870c(int i) {
        this.f15847i = i;
        m18876d(true);
        return this;
    }

    public C4529i m18871c(String str) {
        this.f15842d = str;
        return this;
    }

    public void m18872c(boolean z) {
        this.f15838A.set(2, z);
    }

    public boolean m18873c() {
        return this.f15839a != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18864b((C4529i) obj);
    }

    public long m18874d() {
        return this.f15840b;
    }

    public C4529i m18875d(String str) {
        this.f15843e = str;
        return this;
    }

    public void m18876d(boolean z) {
        this.f15838A.set(3, z);
    }

    public void m18877e(boolean z) {
        this.f15838A.set(4, z);
    }

    public boolean m18878e() {
        return this.f15838A.get(0);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4529i)) ? m18863a((C4529i) obj) : false;
    }

    public String m18879f() {
        return this.f15841c;
    }

    public boolean m18880g() {
        return this.f15841c != null;
    }

    public String m18881h() {
        return this.f15842d;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18882i() {
        return this.f15842d != null;
    }

    public String m18883j() {
        return this.f15843e;
    }

    public boolean m18884k() {
        return this.f15843e != null;
    }

    public int m18885l() {
        return this.f15844f;
    }

    public boolean m18886m() {
        return this.f15838A.get(1);
    }

    public boolean m18887n() {
        return this.f15845g != null;
    }

    public int m18888o() {
        return this.f15846h;
    }

    public boolean m18889p() {
        return this.f15838A.get(2);
    }

    public int m18890q() {
        return this.f15847i;
    }

    public boolean m18891r() {
        return this.f15838A.get(3);
    }

    public Map<String, String> m18892s() {
        return this.f15848j;
    }

    public boolean m18893t() {
        return this.f15848j != null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PushMetaInfo(");
        stringBuilder.append("id:");
        if (this.f15839a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15839a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("messageTs:");
        stringBuilder.append(this.f15840b);
        if (m18880g()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f15841c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15841c);
            }
        }
        if (m18882i()) {
            stringBuilder.append(", ");
            stringBuilder.append("title:");
            if (this.f15842d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15842d);
            }
        }
        if (m18884k()) {
            stringBuilder.append(", ");
            stringBuilder.append("description:");
            if (this.f15843e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15843e);
            }
        }
        if (m18886m()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyType:");
            stringBuilder.append(this.f15844f);
        }
        if (m18887n()) {
            stringBuilder.append(", ");
            stringBuilder.append("url:");
            if (this.f15845g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15845g);
            }
        }
        if (m18889p()) {
            stringBuilder.append(", ");
            stringBuilder.append("passThrough:");
            stringBuilder.append(this.f15846h);
        }
        if (m18891r()) {
            stringBuilder.append(", ");
            stringBuilder.append("notifyId:");
            stringBuilder.append(this.f15847i);
        }
        if (m18893t()) {
            stringBuilder.append(", ");
            stringBuilder.append("extra:");
            if (this.f15848j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15848j);
            }
        }
        if (m18894u()) {
            stringBuilder.append(", ");
            stringBuilder.append("internal:");
            if (this.f15849k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15849k);
            }
        }
        if (m18896w()) {
            stringBuilder.append(", ");
            stringBuilder.append("ignoreRegInfo:");
            stringBuilder.append(this.f15850l);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }

    public boolean m18894u() {
        return this.f15849k != null;
    }

    public boolean m18895v() {
        return this.f15850l;
    }

    public boolean m18896w() {
        return this.f15838A.get(4);
    }

    public void m18897x() {
        if (this.f15839a == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
