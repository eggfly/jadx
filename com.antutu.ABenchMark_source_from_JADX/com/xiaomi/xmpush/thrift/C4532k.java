package com.xiaomi.xmpush.thrift;

import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
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

/* renamed from: com.xiaomi.xmpush.thrift.k */
public class C4532k implements Serializable, Cloneable, C4454a<C4532k, C4531a> {
    public static final Map<C4531a, C4601b> f15865f;
    private static final C4615j f15866g;
    private static final C4609b f15867h;
    private static final C4609b f15868i;
    private static final C4609b f15869j;
    private static final C4609b f15870k;
    private static final C4609b f15871l;
    public long f15872a;
    public String f15873b;
    public String f15874c;
    public String f15875d;
    public boolean f15876e;
    private BitSet f15877m;

    /* renamed from: com.xiaomi.xmpush.thrift.k.a */
    public enum C4531a {
        CHANNEL_ID((short) 1, "channelId"),
        USER_ID((short) 2, "userId"),
        SERVER((short) 3, "server"),
        RESOURCE((short) 4, "resource"),
        IS_PREVIEW((short) 5, "isPreview");
        
        private static final Map<String, C4531a> f15861f;
        private final short f15863g;
        private final String f15864h;

        static {
            f15861f = new HashMap();
            Iterator it = EnumSet.allOf(C4531a.class).iterator();
            while (it.hasNext()) {
                C4531a c4531a = (C4531a) it.next();
                f15861f.put(c4531a.m18900a(), c4531a);
            }
        }

        private C4531a(short s, String str) {
            this.f15863g = s;
            this.f15864h = str;
        }

        public String m18900a() {
            return this.f15864h;
        }
    }

    static {
        f15866g = new C4615j("Target");
        f15867h = new C4609b("channelId", (byte) 10, (short) 1);
        f15868i = new C4609b("userId", (byte) 11, (short) 2);
        f15869j = new C4609b("server", (byte) 11, (short) 3);
        f15870k = new C4609b("resource", (byte) 11, (short) 4);
        f15871l = new C4609b("isPreview", (byte) 2, (short) 5);
        Map enumMap = new EnumMap(C4531a.class);
        enumMap.put(C4531a.CHANNEL_ID, new C4601b("channelId", (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4531a.USER_ID, new C4601b("userId", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4531a.SERVER, new C4601b("server", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4531a.RESOURCE, new C4601b("resource", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4531a.IS_PREVIEW, new C4601b("isPreview", (byte) 2, new C4599c((byte) 2)));
        f15865f = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4532k.class, f15865f);
    }

    public C4532k() {
        this.f15877m = new BitSet(2);
        this.f15872a = 5;
        this.f15874c = "xiaomi.com";
        this.f15875d = BuildConfig.FLAVOR;
        this.f15876e = false;
    }

    public void m18901a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18903a()) {
                    m18912f();
                    return;
                }
                throw new C4612f("Required field 'channelId' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15872a = c4607e.m19334t();
                    m18902a(true);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15873b = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15874c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15875d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15876e = c4607e.m19330p();
                    m18907b(true);
                    break;
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18902a(boolean z) {
        this.f15877m.set(0, z);
    }

    public boolean m18903a() {
        return this.f15877m.get(0);
    }

    public boolean m18904a(C4532k c4532k) {
        if (c4532k == null || this.f15872a != c4532k.f15872a) {
            return false;
        }
        boolean b = m18908b();
        boolean b2 = c4532k.m18908b();
        if ((b || b2) && (!b || !b2 || !this.f15873b.equals(c4532k.f15873b))) {
            return false;
        }
        b = m18909c();
        b2 = c4532k.m18909c();
        if ((b || b2) && (!b || !b2 || !this.f15874c.equals(c4532k.f15874c))) {
            return false;
        }
        b = m18910d();
        b2 = c4532k.m18910d();
        if ((b || b2) && (!b || !b2 || !this.f15875d.equals(c4532k.f15875d))) {
            return false;
        }
        b = m18911e();
        b2 = c4532k.m18911e();
        return !(b || b2) || (b && b2 && this.f15876e == c4532k.f15876e);
    }

    public int m18905b(C4532k c4532k) {
        if (!getClass().equals(c4532k.getClass())) {
            return getClass().getName().compareTo(c4532k.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18903a()).compareTo(Boolean.valueOf(c4532k.m18903a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18903a()) {
            compareTo = C4593b.m19282a(this.f15872a, c4532k.f15872a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18908b()).compareTo(Boolean.valueOf(c4532k.m18908b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18908b()) {
            compareTo = C4593b.m19284a(this.f15873b, c4532k.f15873b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18909c()).compareTo(Boolean.valueOf(c4532k.m18909c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18909c()) {
            compareTo = C4593b.m19284a(this.f15874c, c4532k.f15874c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18910d()).compareTo(Boolean.valueOf(c4532k.m18910d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18910d()) {
            compareTo = C4593b.m19284a(this.f15875d, c4532k.f15875d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18911e()).compareTo(Boolean.valueOf(c4532k.m18911e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18911e()) {
            compareTo = C4593b.m19290a(this.f15876e, c4532k.f15876e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18906b(C4607e c4607e) {
        m18912f();
        c4607e.m19313a(f15866g);
        c4607e.m19310a(f15867h);
        c4607e.m19307a(this.f15872a);
        c4607e.m19316b();
        if (this.f15873b != null) {
            c4607e.m19310a(f15868i);
            c4607e.m19308a(this.f15873b);
            c4607e.m19316b();
        }
        if (this.f15874c != null && m18909c()) {
            c4607e.m19310a(f15869j);
            c4607e.m19308a(this.f15874c);
            c4607e.m19316b();
        }
        if (this.f15875d != null && m18910d()) {
            c4607e.m19310a(f15870k);
            c4607e.m19308a(this.f15875d);
            c4607e.m19316b();
        }
        if (m18911e()) {
            c4607e.m19310a(f15871l);
            c4607e.m19315a(this.f15876e);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18907b(boolean z) {
        this.f15877m.set(1, z);
    }

    public boolean m18908b() {
        return this.f15873b != null;
    }

    public boolean m18909c() {
        return this.f15874c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18905b((C4532k) obj);
    }

    public boolean m18910d() {
        return this.f15875d != null;
    }

    public boolean m18911e() {
        return this.f15877m.get(1);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4532k)) ? m18904a((C4532k) obj) : false;
    }

    public void m18912f() {
        if (this.f15873b == null) {
            throw new C4612f("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Target(");
        stringBuilder.append("channelId:");
        stringBuilder.append(this.f15872a);
        stringBuilder.append(", ");
        stringBuilder.append("userId:");
        if (this.f15873b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15873b);
        }
        if (m18909c()) {
            stringBuilder.append(", ");
            stringBuilder.append("server:");
            if (this.f15874c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15874c);
            }
        }
        if (m18910d()) {
            stringBuilder.append(", ");
            stringBuilder.append("resource:");
            if (this.f15875d == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15875d);
            }
        }
        if (m18911e()) {
            stringBuilder.append(", ");
            stringBuilder.append("isPreview:");
            stringBuilder.append(this.f15876e);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
