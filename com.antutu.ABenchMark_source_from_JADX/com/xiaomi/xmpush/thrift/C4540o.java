package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
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

/* renamed from: com.xiaomi.xmpush.thrift.o */
public class C4540o implements Serializable, Cloneable, C4454a<C4540o, C4539a> {
    public static final Map<C4539a, C4601b> f15994l;
    private static final C4615j f15995m;
    private static final C4609b f15996n;
    private static final C4609b f15997o;
    private static final C4609b f15998p;
    private static final C4609b f15999q;
    private static final C4609b f16000r;
    private static final C4609b f16001s;
    private static final C4609b f16002t;
    private static final C4609b f16003u;
    private static final C4609b f16004v;
    private static final C4609b f16005w;
    private static final C4609b f16006x;
    public String f16007a;
    public C4532k f16008b;
    public String f16009c;
    public String f16010d;
    public String f16011e;
    public C4538n f16012f;
    public long f16013g;
    public String f16014h;
    public String f16015i;
    public List<String> f16016j;
    public String f16017k;
    private BitSet f16018y;

    /* renamed from: com.xiaomi.xmpush.thrift.o.a */
    public enum C4539a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        CMD_NAME((short) 5, "cmdName"),
        REQUEST((short) 6, "request"),
        ERROR_CODE((short) 7, Constants.KEY_ERROR_CODE),
        REASON((short) 8, "reason"),
        PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
        CMD_ARGS((short) 10, "cmdArgs"),
        CATEGORY((short) 12, "category");
        
        private static final Map<String, C4539a> f15990l;
        private final short f15992m;
        private final String f15993n;

        static {
            f15990l = new HashMap();
            Iterator it = EnumSet.allOf(C4539a.class).iterator();
            while (it.hasNext()) {
                C4539a c4539a = (C4539a) it.next();
                f15990l.put(c4539a.m18977a(), c4539a);
            }
        }

        private C4539a(short s, String str) {
            this.f15992m = s;
            this.f15993n = str;
        }

        public String m18977a() {
            return this.f15993n;
        }
    }

    static {
        f15995m = new C4615j("XmPushActionCommandResult");
        f15996n = new C4609b("debug", (byte) 11, (short) 1);
        f15997o = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15998p = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15999q = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16000r = new C4609b("cmdName", (byte) 11, (short) 5);
        f16001s = new C4609b("request", (byte) 12, (short) 6);
        f16002t = new C4609b(Constants.KEY_ERROR_CODE, (byte) 10, (short) 7);
        f16003u = new C4609b("reason", (byte) 11, (short) 8);
        f16004v = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
        f16005w = new C4609b("cmdArgs", (byte) 15, (short) 10);
        f16006x = new C4609b("category", (byte) 11, (short) 12);
        Map enumMap = new EnumMap(C4539a.class);
        enumMap.put(C4539a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4539a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4539a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4539a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4539a.CMD_NAME, new C4601b("cmdName", (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4539a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, C4538n.class)));
        enumMap.put(C4539a.ERROR_CODE, new C4601b(Constants.KEY_ERROR_CODE, (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4539a.REASON, new C4601b("reason", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4539a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4539a.CMD_ARGS, new C4601b("cmdArgs", (byte) 2, new C4602d((byte) 15, new C4599c((byte) 11))));
        enumMap.put(C4539a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        f15994l = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4540o.class, f15994l);
    }

    public C4540o() {
        this.f16018y = new BitSet(1);
    }

    public void m18978a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18990h()) {
                    m18997o();
                    return;
                }
                throw new C4612f("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16007a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16008b = new C4532k();
                    this.f16008b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16009c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16010d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16011e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16012f = new C4538n();
                    this.f16012f.m18959a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16013g = c4607e.m19334t();
                    m18979a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16014h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16015i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != 15) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4610c l = c4607e.m19326l();
                    this.f16016j = new ArrayList(l.f16479b);
                    for (int i = 0; i < l.f16479b; i++) {
                        this.f16016j.add(c4607e.m19336v());
                    }
                    c4607e.m19327m();
                    break;
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16017k = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18979a(boolean z) {
        this.f16018y.set(0, z);
    }

    public boolean m18980a() {
        return this.f16007a != null;
    }

    public boolean m18981a(C4540o c4540o) {
        if (c4540o == null) {
            return false;
        }
        boolean a = m18980a();
        boolean a2 = c4540o.m18980a();
        if ((a || a2) && (!a || !a2 || !this.f16007a.equals(c4540o.f16007a))) {
            return false;
        }
        a = m18984b();
        a2 = c4540o.m18984b();
        if ((a || a2) && (!a || !a2 || !this.f16008b.m18904a(c4540o.f16008b))) {
            return false;
        }
        a = m18985c();
        a2 = c4540o.m18985c();
        if ((a || a2) && (!a || !a2 || !this.f16009c.equals(c4540o.f16009c))) {
            return false;
        }
        a = m18986d();
        a2 = c4540o.m18986d();
        if ((a || a2) && (!a || !a2 || !this.f16010d.equals(c4540o.f16010d))) {
            return false;
        }
        a = m18988f();
        a2 = c4540o.m18988f();
        if ((a || a2) && (!a || !a2 || !this.f16011e.equals(c4540o.f16011e))) {
            return false;
        }
        a = m18989g();
        a2 = c4540o.m18989g();
        if (((a || a2) && (!a || !a2 || !this.f16012f.m18961a(c4540o.f16012f))) || this.f16013g != c4540o.f16013g) {
            return false;
        }
        a = m18991i();
        a2 = c4540o.m18991i();
        if ((a || a2) && (!a || !a2 || !this.f16014h.equals(c4540o.f16014h))) {
            return false;
        }
        a = m18992j();
        a2 = c4540o.m18992j();
        if ((a || a2) && (!a || !a2 || !this.f16015i.equals(c4540o.f16015i))) {
            return false;
        }
        a = m18994l();
        a2 = c4540o.m18994l();
        if ((a || a2) && (!a || !a2 || !this.f16016j.equals(c4540o.f16016j))) {
            return false;
        }
        a = m18996n();
        a2 = c4540o.m18996n();
        return !(a || a2) || (a && a2 && this.f16017k.equals(c4540o.f16017k));
    }

    public int m18982b(C4540o c4540o) {
        if (!getClass().equals(c4540o.getClass())) {
            return getClass().getName().compareTo(c4540o.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18980a()).compareTo(Boolean.valueOf(c4540o.m18980a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18980a()) {
            compareTo = C4593b.m19284a(this.f16007a, c4540o.f16007a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18984b()).compareTo(Boolean.valueOf(c4540o.m18984b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18984b()) {
            compareTo = C4593b.m19283a(this.f16008b, c4540o.f16008b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18985c()).compareTo(Boolean.valueOf(c4540o.m18985c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18985c()) {
            compareTo = C4593b.m19284a(this.f16009c, c4540o.f16009c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18986d()).compareTo(Boolean.valueOf(c4540o.m18986d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18986d()) {
            compareTo = C4593b.m19284a(this.f16010d, c4540o.f16010d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18988f()).compareTo(Boolean.valueOf(c4540o.m18988f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18988f()) {
            compareTo = C4593b.m19284a(this.f16011e, c4540o.f16011e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18989g()).compareTo(Boolean.valueOf(c4540o.m18989g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18989g()) {
            compareTo = C4593b.m19283a(this.f16012f, c4540o.f16012f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18990h()).compareTo(Boolean.valueOf(c4540o.m18990h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18990h()) {
            compareTo = C4593b.m19282a(this.f16013g, c4540o.f16013g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18991i()).compareTo(Boolean.valueOf(c4540o.m18991i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18991i()) {
            compareTo = C4593b.m19284a(this.f16014h, c4540o.f16014h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18992j()).compareTo(Boolean.valueOf(c4540o.m18992j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18992j()) {
            compareTo = C4593b.m19284a(this.f16015i, c4540o.f16015i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18994l()).compareTo(Boolean.valueOf(c4540o.m18994l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18994l()) {
            compareTo = C4593b.m19286a(this.f16016j, c4540o.f16016j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18996n()).compareTo(Boolean.valueOf(c4540o.m18996n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18996n()) {
            compareTo = C4593b.m19284a(this.f16017k, c4540o.f16017k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public void m18983b(C4607e c4607e) {
        m18997o();
        c4607e.m19313a(f15995m);
        if (this.f16007a != null && m18980a()) {
            c4607e.m19310a(f15996n);
            c4607e.m19308a(this.f16007a);
            c4607e.m19316b();
        }
        if (this.f16008b != null && m18984b()) {
            c4607e.m19310a(f15997o);
            this.f16008b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16009c != null) {
            c4607e.m19310a(f15998p);
            c4607e.m19308a(this.f16009c);
            c4607e.m19316b();
        }
        if (this.f16010d != null) {
            c4607e.m19310a(f15999q);
            c4607e.m19308a(this.f16010d);
            c4607e.m19316b();
        }
        if (this.f16011e != null) {
            c4607e.m19310a(f16000r);
            c4607e.m19308a(this.f16011e);
            c4607e.m19316b();
        }
        if (this.f16012f != null && m18989g()) {
            c4607e.m19310a(f16001s);
            this.f16012f.m18964b(c4607e);
            c4607e.m19316b();
        }
        c4607e.m19310a(f16002t);
        c4607e.m19307a(this.f16013g);
        c4607e.m19316b();
        if (this.f16014h != null && m18991i()) {
            c4607e.m19310a(f16003u);
            c4607e.m19308a(this.f16014h);
            c4607e.m19316b();
        }
        if (this.f16015i != null && m18992j()) {
            c4607e.m19310a(f16004v);
            c4607e.m19308a(this.f16015i);
            c4607e.m19316b();
        }
        if (this.f16016j != null && m18994l()) {
            c4607e.m19310a(f16005w);
            c4607e.m19311a(new C4610c((byte) 11, this.f16016j.size()));
            for (String a : this.f16016j) {
                c4607e.m19308a(a);
            }
            c4607e.m19319e();
            c4607e.m19316b();
        }
        if (this.f16017k != null && m18996n()) {
            c4607e.m19310a(f16006x);
            c4607e.m19308a(this.f16017k);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public boolean m18984b() {
        return this.f16008b != null;
    }

    public boolean m18985c() {
        return this.f16009c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18982b((C4540o) obj);
    }

    public boolean m18986d() {
        return this.f16010d != null;
    }

    public String m18987e() {
        return this.f16011e;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4540o)) ? m18981a((C4540o) obj) : false;
    }

    public boolean m18988f() {
        return this.f16011e != null;
    }

    public boolean m18989g() {
        return this.f16012f != null;
    }

    public boolean m18990h() {
        return this.f16018y.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18991i() {
        return this.f16014h != null;
    }

    public boolean m18992j() {
        return this.f16015i != null;
    }

    public List<String> m18993k() {
        return this.f16016j;
    }

    public boolean m18994l() {
        return this.f16016j != null;
    }

    public String m18995m() {
        return this.f16017k;
    }

    public boolean m18996n() {
        return this.f16017k != null;
    }

    public void m18997o() {
        if (this.f16009c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16010d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f16011e == null) {
            throw new C4612f("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCommandResult(");
        Object obj2 = 1;
        if (m18980a()) {
            stringBuilder.append("debug:");
            if (this.f16007a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16007a);
            }
            obj2 = null;
        }
        if (m18984b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16008b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16008b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16009c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16009c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16010d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16010d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("cmdName:");
        if (this.f16011e == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16011e);
        }
        if (m18989g()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f16012f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16012f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("errorCode:");
        stringBuilder.append(this.f16013g);
        if (m18991i()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f16014h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16014h);
            }
        }
        if (m18992j()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16015i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16015i);
            }
        }
        if (m18994l()) {
            stringBuilder.append(", ");
            stringBuilder.append("cmdArgs:");
            if (this.f16016j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16016j);
            }
        }
        if (m18996n()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f16017k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16017k);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
