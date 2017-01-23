package com.xiaomi.xmpush.thrift;

import com.google.analytics.tracking.android.ModelFields;
import com.handmark.pulltorefresh.library.C3628R;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import com.viewpagerindicator.C4273R;
import java.io.Serializable;
import java.util.BitSet;
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

/* renamed from: com.xiaomi.xmpush.thrift.l */
public class C4534l implements Serializable, Cloneable, C4454a<C4534l, C4533a> {
    private static final C4609b f15899A;
    private static final C4609b f15900B;
    private static final C4609b f15901C;
    private static final C4609b f15902D;
    private static final C4609b f15903E;
    private static final C4609b f15904F;
    private static final C4609b f15905G;
    private static final C4609b f15906H;
    private static final C4609b f15907I;
    private static final C4609b f15908J;
    public static final Map<C4533a, C4601b> f15909r;
    private static final C4615j f15910s;
    private static final C4609b f15911t;
    private static final C4609b f15912u;
    private static final C4609b f15913v;
    private static final C4609b f15914w;
    private static final C4609b f15915x;
    private static final C4609b f15916y;
    private static final C4609b f15917z;
    private BitSet f15918K;
    public String f15919a;
    public C4532k f15920b;
    public String f15921c;
    public String f15922d;
    public long f15923e;
    public String f15924f;
    public String f15925g;
    public C4558x f15926h;
    public String f15927i;
    public String f15928j;
    public boolean f15929k;
    public String f15930l;
    public String f15931m;
    public String f15932n;
    public short f15933o;
    public String f15934p;
    public String f15935q;

    /* renamed from: com.xiaomi.xmpush.thrift.l.a */
    public enum C4533a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        MESSAGE_TS((short) 5, "messageTs"),
        TOPIC((short) 6, "topic"),
        ALIAS_NAME((short) 7, "aliasName"),
        REQUEST((short) 8, "request"),
        PACKAGE_NAME((short) 9, Constants.KEY_PACKAGE_NAME),
        CATEGORY((short) 10, "category"),
        IS_ONLINE((short) 11, "isOnline"),
        REG_ID((short) 12, "regId"),
        CALLBACK_URL((short) 13, "callbackUrl"),
        USER_ACCOUNT((short) 14, "userAccount"),
        DEVICE_STATUS((short) 15, "deviceStatus"),
        IMEI_MD5((short) 20, "imeiMd5"),
        DEVICE_ID((short) 21, C4575b.KEY_DEVICE_TOKEN);
        
        private static final Map<String, C4533a> f15895r;
        private final short f15897s;
        private final String f15898t;

        static {
            f15895r = new HashMap();
            Iterator it = EnumSet.allOf(C4533a.class).iterator();
            while (it.hasNext()) {
                C4533a c4533a = (C4533a) it.next();
                f15895r.put(c4533a.m18913a(), c4533a);
            }
        }

        private C4533a(short s, String str) {
            this.f15897s = s;
            this.f15898t = str;
        }

        public String m18913a() {
            return this.f15898t;
        }
    }

    static {
        f15910s = new C4615j("XmPushActionAckMessage");
        f15911t = new C4609b("debug", (byte) 11, (short) 1);
        f15912u = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f15913v = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f15914w = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f15915x = new C4609b("messageTs", (byte) 10, (short) 5);
        f15916y = new C4609b("topic", (byte) 11, (short) 6);
        f15917z = new C4609b("aliasName", (byte) 11, (short) 7);
        f15899A = new C4609b("request", (byte) 12, (short) 8);
        f15900B = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 9);
        f15901C = new C4609b("category", (byte) 11, (short) 10);
        f15902D = new C4609b("isOnline", (byte) 2, (short) 11);
        f15903E = new C4609b("regId", (byte) 11, (short) 12);
        f15904F = new C4609b("callbackUrl", (byte) 11, (short) 13);
        f15905G = new C4609b("userAccount", (byte) 11, (short) 14);
        f15906H = new C4609b("deviceStatus", (byte) 6, (short) 15);
        f15907I = new C4609b("imeiMd5", (byte) 11, (short) 20);
        f15908J = new C4609b(C4575b.KEY_DEVICE_TOKEN, (byte) 11, (short) 21);
        Map enumMap = new EnumMap(C4533a.class);
        enumMap.put(C4533a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4533a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4533a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4533a.MESSAGE_TS, new C4601b("messageTs", (byte) 1, new C4599c((byte) 10)));
        enumMap.put(C4533a.TOPIC, new C4601b("topic", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.ALIAS_NAME, new C4601b("aliasName", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.REQUEST, new C4601b("request", (byte) 2, new C4604f((byte) 12, C4558x.class)));
        enumMap.put(C4533a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.CATEGORY, new C4601b("category", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.IS_ONLINE, new C4601b("isOnline", (byte) 2, new C4599c((byte) 2)));
        enumMap.put(C4533a.REG_ID, new C4601b("regId", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.CALLBACK_URL, new C4601b("callbackUrl", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.USER_ACCOUNT, new C4601b("userAccount", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.DEVICE_STATUS, new C4601b("deviceStatus", (byte) 2, new C4599c((byte) 6)));
        enumMap.put(C4533a.IMEI_MD5, new C4601b("imeiMd5", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4533a.DEVICE_ID, new C4601b(C4575b.KEY_DEVICE_TOKEN, (byte) 2, new C4599c((byte) 11)));
        f15909r = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4534l.class, f15909r);
    }

    public C4534l() {
        this.f15918K = new BitSet(3);
        this.f15929k = false;
    }

    public C4534l m18914a(long j) {
        this.f15923e = j;
        m18918a(true);
        return this;
    }

    public C4534l m18915a(String str) {
        this.f15921c = str;
        return this;
    }

    public C4534l m18916a(short s) {
        this.f15933o = s;
        m18927c(true);
        return this;
    }

    public void m18917a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                if (m18931e()) {
                    m18944r();
                    return;
                }
                throw new C4612f("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15919a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15920b = new C4532k();
                    this.f15920b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15921c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15922d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != 10) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15923e = c4607e.m19334t();
                    m18918a(true);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15924f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15925g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15926h = new C4558x();
                    this.f15926h.m19170a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15927i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15928j = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15929k = c4607e.m19330p();
                    m18924b(true);
                    break;
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15930l = c4607e.m19336v();
                        break;
                    }
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15931m = c4607e.m19336v();
                        break;
                    }
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15932n = c4607e.m19336v();
                        break;
                    }
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    if (h.f16476b != 6) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f15933o = c4607e.m19332r();
                    m18927c(true);
                    break;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15934p = c4607e.m19336v();
                        break;
                    }
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f15935q = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m18918a(boolean z) {
        this.f15918K.set(0, z);
    }

    public boolean m18919a() {
        return this.f15919a != null;
    }

    public boolean m18920a(C4534l c4534l) {
        if (c4534l == null) {
            return false;
        }
        boolean a = m18919a();
        boolean a2 = c4534l.m18919a();
        if ((a || a2) && (!a || !a2 || !this.f15919a.equals(c4534l.f15919a))) {
            return false;
        }
        a = m18925b();
        a2 = c4534l.m18925b();
        if ((a || a2) && (!a || !a2 || !this.f15920b.m18904a(c4534l.f15920b))) {
            return false;
        }
        a = m18928c();
        a2 = c4534l.m18928c();
        if ((a || a2) && (!a || !a2 || !this.f15921c.equals(c4534l.f15921c))) {
            return false;
        }
        a = m18930d();
        a2 = c4534l.m18930d();
        if (((a || a2) && (!a || !a2 || !this.f15922d.equals(c4534l.f15922d))) || this.f15923e != c4534l.f15923e) {
            return false;
        }
        a = m18932f();
        a2 = c4534l.m18932f();
        if ((a || a2) && (!a || !a2 || !this.f15924f.equals(c4534l.f15924f))) {
            return false;
        }
        a = m18933g();
        a2 = c4534l.m18933g();
        if ((a || a2) && (!a || !a2 || !this.f15925g.equals(c4534l.f15925g))) {
            return false;
        }
        a = m18934h();
        a2 = c4534l.m18934h();
        if ((a || a2) && (!a || !a2 || !this.f15926h.m19173a(c4534l.f15926h))) {
            return false;
        }
        a = m18935i();
        a2 = c4534l.m18935i();
        if ((a || a2) && (!a || !a2 || !this.f15927i.equals(c4534l.f15927i))) {
            return false;
        }
        a = m18936j();
        a2 = c4534l.m18936j();
        if ((a || a2) && (!a || !a2 || !this.f15928j.equals(c4534l.f15928j))) {
            return false;
        }
        a = m18937k();
        a2 = c4534l.m18937k();
        if ((a || a2) && (!a || !a2 || this.f15929k != c4534l.f15929k)) {
            return false;
        }
        a = m18938l();
        a2 = c4534l.m18938l();
        if ((a || a2) && (!a || !a2 || !this.f15930l.equals(c4534l.f15930l))) {
            return false;
        }
        a = m18939m();
        a2 = c4534l.m18939m();
        if ((a || a2) && (!a || !a2 || !this.f15931m.equals(c4534l.f15931m))) {
            return false;
        }
        a = m18940n();
        a2 = c4534l.m18940n();
        if ((a || a2) && (!a || !a2 || !this.f15932n.equals(c4534l.f15932n))) {
            return false;
        }
        a = m18941o();
        a2 = c4534l.m18941o();
        if ((a || a2) && (!a || !a2 || this.f15933o != c4534l.f15933o)) {
            return false;
        }
        a = m18942p();
        a2 = c4534l.m18942p();
        if ((a || a2) && (!a || !a2 || !this.f15934p.equals(c4534l.f15934p))) {
            return false;
        }
        a = m18943q();
        a2 = c4534l.m18943q();
        return !(a || a2) || (a && a2 && this.f15935q.equals(c4534l.f15935q));
    }

    public int m18921b(C4534l c4534l) {
        if (!getClass().equals(c4534l.getClass())) {
            return getClass().getName().compareTo(c4534l.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m18919a()).compareTo(Boolean.valueOf(c4534l.m18919a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18919a()) {
            compareTo = C4593b.m19284a(this.f15919a, c4534l.f15919a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18925b()).compareTo(Boolean.valueOf(c4534l.m18925b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18925b()) {
            compareTo = C4593b.m19283a(this.f15920b, c4534l.f15920b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18928c()).compareTo(Boolean.valueOf(c4534l.m18928c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18928c()) {
            compareTo = C4593b.m19284a(this.f15921c, c4534l.f15921c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18930d()).compareTo(Boolean.valueOf(c4534l.m18930d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18930d()) {
            compareTo = C4593b.m19284a(this.f15922d, c4534l.f15922d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18931e()).compareTo(Boolean.valueOf(c4534l.m18931e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18931e()) {
            compareTo = C4593b.m19282a(this.f15923e, c4534l.f15923e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18932f()).compareTo(Boolean.valueOf(c4534l.m18932f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18932f()) {
            compareTo = C4593b.m19284a(this.f15924f, c4534l.f15924f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18933g()).compareTo(Boolean.valueOf(c4534l.m18933g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18933g()) {
            compareTo = C4593b.m19284a(this.f15925g, c4534l.f15925g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18934h()).compareTo(Boolean.valueOf(c4534l.m18934h()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18934h()) {
            compareTo = C4593b.m19283a(this.f15926h, c4534l.f15926h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18935i()).compareTo(Boolean.valueOf(c4534l.m18935i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18935i()) {
            compareTo = C4593b.m19284a(this.f15927i, c4534l.f15927i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18936j()).compareTo(Boolean.valueOf(c4534l.m18936j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18936j()) {
            compareTo = C4593b.m19284a(this.f15928j, c4534l.f15928j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18937k()).compareTo(Boolean.valueOf(c4534l.m18937k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18937k()) {
            compareTo = C4593b.m19290a(this.f15929k, c4534l.f15929k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18938l()).compareTo(Boolean.valueOf(c4534l.m18938l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18938l()) {
            compareTo = C4593b.m19284a(this.f15930l, c4534l.f15930l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18939m()).compareTo(Boolean.valueOf(c4534l.m18939m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18939m()) {
            compareTo = C4593b.m19284a(this.f15931m, c4534l.f15931m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18940n()).compareTo(Boolean.valueOf(c4534l.m18940n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18940n()) {
            compareTo = C4593b.m19284a(this.f15932n, c4534l.f15932n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18941o()).compareTo(Boolean.valueOf(c4534l.m18941o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18941o()) {
            compareTo = C4593b.m19289a(this.f15933o, c4534l.f15933o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18942p()).compareTo(Boolean.valueOf(c4534l.m18942p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18942p()) {
            compareTo = C4593b.m19284a(this.f15934p, c4534l.f15934p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m18943q()).compareTo(Boolean.valueOf(c4534l.m18943q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m18943q()) {
            compareTo = C4593b.m19284a(this.f15935q, c4534l.f15935q);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4534l m18922b(String str) {
        this.f15922d = str;
        return this;
    }

    public void m18923b(C4607e c4607e) {
        m18944r();
        c4607e.m19313a(f15910s);
        if (this.f15919a != null && m18919a()) {
            c4607e.m19310a(f15911t);
            c4607e.m19308a(this.f15919a);
            c4607e.m19316b();
        }
        if (this.f15920b != null && m18925b()) {
            c4607e.m19310a(f15912u);
            this.f15920b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15921c != null) {
            c4607e.m19310a(f15913v);
            c4607e.m19308a(this.f15921c);
            c4607e.m19316b();
        }
        if (this.f15922d != null) {
            c4607e.m19310a(f15914w);
            c4607e.m19308a(this.f15922d);
            c4607e.m19316b();
        }
        c4607e.m19310a(f15915x);
        c4607e.m19307a(this.f15923e);
        c4607e.m19316b();
        if (this.f15924f != null && m18932f()) {
            c4607e.m19310a(f15916y);
            c4607e.m19308a(this.f15924f);
            c4607e.m19316b();
        }
        if (this.f15925g != null && m18933g()) {
            c4607e.m19310a(f15917z);
            c4607e.m19308a(this.f15925g);
            c4607e.m19316b();
        }
        if (this.f15926h != null && m18934h()) {
            c4607e.m19310a(f15899A);
            this.f15926h.m19175b(c4607e);
            c4607e.m19316b();
        }
        if (this.f15927i != null && m18935i()) {
            c4607e.m19310a(f15900B);
            c4607e.m19308a(this.f15927i);
            c4607e.m19316b();
        }
        if (this.f15928j != null && m18936j()) {
            c4607e.m19310a(f15901C);
            c4607e.m19308a(this.f15928j);
            c4607e.m19316b();
        }
        if (m18937k()) {
            c4607e.m19310a(f15902D);
            c4607e.m19315a(this.f15929k);
            c4607e.m19316b();
        }
        if (this.f15930l != null && m18938l()) {
            c4607e.m19310a(f15903E);
            c4607e.m19308a(this.f15930l);
            c4607e.m19316b();
        }
        if (this.f15931m != null && m18939m()) {
            c4607e.m19310a(f15904F);
            c4607e.m19308a(this.f15931m);
            c4607e.m19316b();
        }
        if (this.f15932n != null && m18940n()) {
            c4607e.m19310a(f15905G);
            c4607e.m19308a(this.f15932n);
            c4607e.m19316b();
        }
        if (m18941o()) {
            c4607e.m19310a(f15906H);
            c4607e.m19314a(this.f15933o);
            c4607e.m19316b();
        }
        if (this.f15934p != null && m18942p()) {
            c4607e.m19310a(f15907I);
            c4607e.m19308a(this.f15934p);
            c4607e.m19316b();
        }
        if (this.f15935q != null && m18943q()) {
            c4607e.m19310a(f15908J);
            c4607e.m19308a(this.f15935q);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m18924b(boolean z) {
        this.f15918K.set(1, z);
    }

    public boolean m18925b() {
        return this.f15920b != null;
    }

    public C4534l m18926c(String str) {
        this.f15924f = str;
        return this;
    }

    public void m18927c(boolean z) {
        this.f15918K.set(2, z);
    }

    public boolean m18928c() {
        return this.f15921c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m18921b((C4534l) obj);
    }

    public C4534l m18929d(String str) {
        this.f15925g = str;
        return this;
    }

    public boolean m18930d() {
        return this.f15922d != null;
    }

    public boolean m18931e() {
        return this.f15918K.get(0);
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4534l)) ? m18920a((C4534l) obj) : false;
    }

    public boolean m18932f() {
        return this.f15924f != null;
    }

    public boolean m18933g() {
        return this.f15925g != null;
    }

    public boolean m18934h() {
        return this.f15926h != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean m18935i() {
        return this.f15927i != null;
    }

    public boolean m18936j() {
        return this.f15928j != null;
    }

    public boolean m18937k() {
        return this.f15918K.get(1);
    }

    public boolean m18938l() {
        return this.f15930l != null;
    }

    public boolean m18939m() {
        return this.f15931m != null;
    }

    public boolean m18940n() {
        return this.f15932n != null;
    }

    public boolean m18941o() {
        return this.f15918K.get(2);
    }

    public boolean m18942p() {
        return this.f15934p != null;
    }

    public boolean m18943q() {
        return this.f15935q != null;
    }

    public void m18944r() {
        if (this.f15921c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f15922d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionAckMessage(");
        Object obj2 = 1;
        if (m18919a()) {
            stringBuilder.append("debug:");
            if (this.f15919a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15919a);
            }
            obj2 = null;
        }
        if (m18925b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f15920b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15920b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f15921c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15921c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f15922d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f15922d);
        }
        stringBuilder.append(", ");
        stringBuilder.append("messageTs:");
        stringBuilder.append(this.f15923e);
        if (m18932f()) {
            stringBuilder.append(", ");
            stringBuilder.append("topic:");
            if (this.f15924f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15924f);
            }
        }
        if (m18933g()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.f15925g == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15925g);
            }
        }
        if (m18934h()) {
            stringBuilder.append(", ");
            stringBuilder.append("request:");
            if (this.f15926h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15926h);
            }
        }
        if (m18935i()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f15927i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15927i);
            }
        }
        if (m18936j()) {
            stringBuilder.append(", ");
            stringBuilder.append("category:");
            if (this.f15928j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15928j);
            }
        }
        if (m18937k()) {
            stringBuilder.append(", ");
            stringBuilder.append("isOnline:");
            stringBuilder.append(this.f15929k);
        }
        if (m18938l()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            if (this.f15930l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15930l);
            }
        }
        if (m18939m()) {
            stringBuilder.append(", ");
            stringBuilder.append("callbackUrl:");
            if (this.f15931m == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15931m);
            }
        }
        if (m18940n()) {
            stringBuilder.append(", ");
            stringBuilder.append("userAccount:");
            if (this.f15932n == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15932n);
            }
        }
        if (m18941o()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceStatus:");
            stringBuilder.append(this.f15933o);
        }
        if (m18942p()) {
            stringBuilder.append(", ");
            stringBuilder.append("imeiMd5:");
            if (this.f15934p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15934p);
            }
        }
        if (m18943q()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            if (this.f15935q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f15935q);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
