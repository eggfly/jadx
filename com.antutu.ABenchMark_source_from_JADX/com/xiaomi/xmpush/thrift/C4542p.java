package com.xiaomi.xmpush.thrift;

import com.igexin.sdk.PushConsts;
import com.qq.p035e.comm.pi.ACTD;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.nio.ByteBuffer;
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
import org.apache.thrift.meta_data.C4600a;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.p */
public class C4542p implements Serializable, Cloneable, C4454a<C4542p, C4541a> {
    public static final Map<C4541a, C4601b> f16031i;
    private static final C4615j f16032j;
    private static final C4609b f16033k;
    private static final C4609b f16034l;
    private static final C4609b f16035m;
    private static final C4609b f16036n;
    private static final C4609b f16037o;
    private static final C4609b f16038p;
    private static final C4609b f16039q;
    private static final C4609b f16040r;
    public C4513a f16041a;
    public boolean f16042b;
    public boolean f16043c;
    public ByteBuffer f16044d;
    public String f16045e;
    public String f16046f;
    public C4532k f16047g;
    public C4529i f16048h;
    private BitSet f16049s;

    /* renamed from: com.xiaomi.xmpush.thrift.p.a */
    public enum C4541a {
        ACTION((short) 1, PushConsts.CMD_ACTION),
        ENCRYPT_ACTION((short) 2, "encryptAction"),
        IS_REQUEST((short) 3, "isRequest"),
        PUSH_ACTION((short) 4, "pushAction"),
        APPID((short) 5, ACTD.APPID_KEY),
        PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
        TARGET((short) 7, Constants.KEY_TARGET),
        META_INFO((short) 8, "metaInfo");
        
        private static final Map<String, C4541a> f16027i;
        private final short f16029j;
        private final String f16030k;

        static {
            f16027i = new HashMap();
            Iterator it = EnumSet.allOf(C4541a.class).iterator();
            while (it.hasNext()) {
                C4541a c4541a = (C4541a) it.next();
                f16027i.put(c4541a.m18998a(), c4541a);
            }
        }

        private C4541a(short s, String str) {
            this.f16029j = s;
            this.f16030k = str;
        }

        public String m18998a() {
            return this.f16030k;
        }
    }

    static {
        f16032j = new C4615j("XmPushActionContainer");
        f16033k = new C4609b(PushConsts.CMD_ACTION, (byte) 8, (short) 1);
        f16034l = new C4609b("encryptAction", (byte) 2, (short) 2);
        f16035m = new C4609b("isRequest", (byte) 2, (short) 3);
        f16036n = new C4609b("pushAction", (byte) 11, (short) 4);
        f16037o = new C4609b(ACTD.APPID_KEY, (byte) 11, (short) 5);
        f16038p = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
        f16039q = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 7);
        f16040r = new C4609b("metaInfo", (byte) 12, (short) 8);
        Map enumMap = new EnumMap(C4541a.class);
        enumMap.put(C4541a.ACTION, new C4601b(PushConsts.CMD_ACTION, (byte) 1, new C4600a((byte) 16, C4513a.class)));
        enumMap.put(C4541a.ENCRYPT_ACTION, new C4601b("encryptAction", (byte) 1, new C4599c((byte) 2)));
        enumMap.put(C4541a.IS_REQUEST, new C4601b("isRequest", (byte) 1, new C4599c((byte) 2)));
        enumMap.put(C4541a.PUSH_ACTION, new C4601b("pushAction", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4541a.APPID, new C4601b(ACTD.APPID_KEY, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4541a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4541a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 1, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4541a.META_INFO, new C4601b("metaInfo", (byte) 2, new C4604f((byte) 12, C4529i.class)));
        f16031i = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4542p.class, f16031i);
    }

    public C4542p() {
        this.f16049s = new BitSet(2);
        this.f16042b = true;
        this.f16043c = true;
    }

    public C4513a m18999a() {
        return this.f16041a;
    }

    public C4542p m19000a(C4513a c4513a) {
        this.f16041a = c4513a;
        return this;
    }

    public C4542p m19001a(C4529i c4529i) {
        this.f16048h = c4529i;
        return this;
    }

    public C4542p m19002a(C4532k c4532k) {
        this.f16047g = c4532k;
        return this;
    }

    public C4542p m19003a(String str) {
        this.f16045e = str;
        return this;
    }

    public C4542p m19004a(ByteBuffer byteBuffer) {
        this.f16044d = byteBuffer;
        return this;
    }

    public C4542p m19005a(boolean z) {
        this.f16042b = z;
        m19011b(true);
        return this;
    }

    public void m19006a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (!m19016d()) {
                    throw new C4612f("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (m19017e()) {
                    m19027o();
                    return;
                } else {
                    throw new C4612f("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16041a = C4513a.m18716a(c4607e.m19333s());
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16042b = c4607e.m19330p();
                    m19011b(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16043c = c4607e.m19330p();
                    m19015d(true);
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16044d = c4607e.m19337w();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16045e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16046f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16047g = new C4532k();
                    this.f16047g.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16048h = new C4529i();
                    this.f16048h.m18861a(c4607e);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public boolean m19007a(C4542p c4542p) {
        if (c4542p == null) {
            return false;
        }
        boolean b = m19012b();
        boolean b2 = c4542p.m19012b();
        if (((b || b2) && (!b || !b2 || !this.f16041a.equals(c4542p.f16041a))) || this.f16042b != c4542p.f16042b || this.f16043c != c4542p.f16043c) {
            return false;
        }
        b = m19019g();
        b2 = c4542p.m19019g();
        if ((b || b2) && (!b || !b2 || !this.f16044d.equals(c4542p.f16044d))) {
            return false;
        }
        b = m19021i();
        b2 = c4542p.m19021i();
        if ((b || b2) && (!b || !b2 || !this.f16045e.equals(c4542p.f16045e))) {
            return false;
        }
        b = m19023k();
        b2 = c4542p.m19023k();
        if ((b || b2) && (!b || !b2 || !this.f16046f.equals(c4542p.f16046f))) {
            return false;
        }
        b = m19024l();
        b2 = c4542p.m19024l();
        if ((b || b2) && (!b || !b2 || !this.f16047g.m18904a(c4542p.f16047g))) {
            return false;
        }
        b = m19026n();
        b2 = c4542p.m19026n();
        return !(b || b2) || (b && b2 && this.f16048h.m18863a(c4542p.f16048h));
    }

    public int m19008b(C4542p c4542p) {
        if (!getClass().equals(c4542p.getClass())) {
            return getClass().getName().compareTo(c4542p.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19012b()).compareTo(Boolean.valueOf(c4542p.m19012b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19012b()) {
            compareTo = C4593b.m19283a(this.f16041a, c4542p.f16041a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19016d()).compareTo(Boolean.valueOf(c4542p.m19016d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19016d()) {
            compareTo = C4593b.m19290a(this.f16042b, c4542p.f16042b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19017e()).compareTo(Boolean.valueOf(c4542p.m19017e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19017e()) {
            compareTo = C4593b.m19290a(this.f16043c, c4542p.f16043c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19019g()).compareTo(Boolean.valueOf(c4542p.m19019g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19019g()) {
            compareTo = C4593b.m19283a(this.f16044d, c4542p.f16044d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19021i()).compareTo(Boolean.valueOf(c4542p.m19021i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19021i()) {
            compareTo = C4593b.m19284a(this.f16045e, c4542p.f16045e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19023k()).compareTo(Boolean.valueOf(c4542p.m19023k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19023k()) {
            compareTo = C4593b.m19284a(this.f16046f, c4542p.f16046f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19024l()).compareTo(Boolean.valueOf(c4542p.m19024l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19024l()) {
            compareTo = C4593b.m19283a(this.f16047g, c4542p.f16047g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19026n()).compareTo(Boolean.valueOf(c4542p.m19026n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19026n()) {
            compareTo = C4593b.m19283a(this.f16048h, c4542p.f16048h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4542p m19009b(String str) {
        this.f16046f = str;
        return this;
    }

    public void m19010b(C4607e c4607e) {
        m19027o();
        c4607e.m19313a(f16032j);
        if (this.f16041a != null) {
            c4607e.m19310a(f16033k);
            c4607e.m19306a(this.f16041a.m18717a());
            c4607e.m19316b();
        }
        c4607e.m19310a(f16034l);
        c4607e.m19315a(this.f16042b);
        c4607e.m19316b();
        c4607e.m19310a(f16035m);
        c4607e.m19315a(this.f16043c);
        c4607e.m19316b();
        if (this.f16044d != null) {
            c4607e.m19310a(f16036n);
            c4607e.m19309a(this.f16044d);
            c4607e.m19316b();
        }
        if (this.f16045e != null && m19021i()) {
            c4607e.m19310a(f16037o);
            c4607e.m19308a(this.f16045e);
            c4607e.m19316b();
        }
        if (this.f16046f != null && m19023k()) {
            c4607e.m19310a(f16038p);
            c4607e.m19308a(this.f16046f);
            c4607e.m19316b();
        }
        if (this.f16047g != null) {
            c4607e.m19310a(f16039q);
            this.f16047g.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16048h != null && m19026n()) {
            c4607e.m19310a(f16040r);
            this.f16048h.m18868b(c4607e);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m19011b(boolean z) {
        this.f16049s.set(0, z);
    }

    public boolean m19012b() {
        return this.f16041a != null;
    }

    public C4542p m19013c(boolean z) {
        this.f16043c = z;
        m19015d(true);
        return this;
    }

    public boolean m19014c() {
        return this.f16042b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19008b((C4542p) obj);
    }

    public void m19015d(boolean z) {
        this.f16049s.set(1, z);
    }

    public boolean m19016d() {
        return this.f16049s.get(0);
    }

    public boolean m19017e() {
        return this.f16049s.get(1);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4542p)) ? m19007a((C4542p) obj) : false;
    }

    public byte[] m19018f() {
        m19004a(C4593b.m19296c(this.f16044d));
        return this.f16044d.array();
    }

    public boolean m19019g() {
        return this.f16044d != null;
    }

    public String m19020h() {
        return this.f16045e;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m19021i() {
        return this.f16045e != null;
    }

    public String m19022j() {
        return this.f16046f;
    }

    public boolean m19023k() {
        return this.f16046f != null;
    }

    public boolean m19024l() {
        return this.f16047g != null;
    }

    public C4529i m19025m() {
        return this.f16048h;
    }

    public boolean m19026n() {
        return this.f16048h != null;
    }

    public void m19027o() {
        if (this.f16041a == null) {
            throw new C4612f("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f16044d == null) {
            throw new C4612f("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f16047g == null) {
            throw new C4612f("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionContainer(");
        stringBuilder.append("action:");
        if (this.f16041a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16041a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("encryptAction:");
        stringBuilder.append(this.f16042b);
        stringBuilder.append(", ");
        stringBuilder.append("isRequest:");
        stringBuilder.append(this.f16043c);
        stringBuilder.append(", ");
        stringBuilder.append("pushAction:");
        if (this.f16044d == null) {
            stringBuilder.append("null");
        } else {
            C4593b.m19293a(this.f16044d, stringBuilder);
        }
        if (m19021i()) {
            stringBuilder.append(", ");
            stringBuilder.append("appid:");
            if (this.f16045e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16045e);
            }
        }
        if (m19023k()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16046f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16046f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("target:");
        if (this.f16047g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16047g);
        }
        if (m19026n()) {
            stringBuilder.append(", ");
            stringBuilder.append("metaInfo:");
            if (this.f16048h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16048h);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
