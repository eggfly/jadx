package com.xiaomi.xmpush.thrift;

import anet.channel.C0655b;
import com.facebook.ads.C2279R;
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
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.C4575b;
import org.android.spdy.SpdyProtocol;
import org.apache.thrift.C4454a;
import org.apache.thrift.C4593b;
import org.apache.thrift.meta_data.C4599c;
import org.apache.thrift.meta_data.C4600a;
import org.apache.thrift.meta_data.C4601b;
import org.apache.thrift.meta_data.C4603e;
import org.apache.thrift.meta_data.C4604f;
import org.apache.thrift.protocol.C4607e;
import org.apache.thrift.protocol.C4609b;
import org.apache.thrift.protocol.C4611d;
import org.apache.thrift.protocol.C4612f;
import org.apache.thrift.protocol.C4613h;
import org.apache.thrift.protocol.C4615j;

/* renamed from: com.xiaomi.xmpush.thrift.t */
public class C4550t implements Serializable, Cloneable, C4454a<C4550t, C4549a> {
    private static final C4609b f16142A;
    private static final C4609b f16143B;
    private static final C4609b f16144C;
    private static final C4609b f16145D;
    private static final C4609b f16146E;
    private static final C4609b f16147F;
    private static final C4609b f16148G;
    private static final C4609b f16149H;
    private static final C4609b f16150I;
    private static final C4609b f16151J;
    private static final C4609b f16152K;
    private static final C4609b f16153L;
    private static final C4609b f16154M;
    private static final C4609b f16155N;
    private static final C4609b f16156O;
    private static final C4609b f16157P;
    private static final C4609b f16158Q;
    private static final C4609b f16159R;
    private static final C4609b f16160S;
    private static final C4609b f16161T;
    private static final C4609b f16162U;
    private static final C4609b f16163V;
    public static final Map<C4549a, C4601b> f16164x;
    private static final C4615j f16165y;
    private static final C4609b f16166z;
    private BitSet f16167W;
    public String f16168a;
    public C4532k f16169b;
    public String f16170c;
    public String f16171d;
    public String f16172e;
    public String f16173f;
    public String f16174g;
    public String f16175h;
    public String f16176i;
    public String f16177j;
    public String f16178k;
    public String f16179l;
    public int f16180m;
    public int f16181n;
    public String f16182o;
    public String f16183p;
    public String f16184q;
    public String f16185r;
    public int f16186s;
    public C4530j f16187t;
    public Map<String, String> f16188u;
    public boolean f16189v;
    public String f16190w;

    /* renamed from: com.xiaomi.xmpush.thrift.t.a */
    public enum C4549a {
        DEBUG((short) 1, "debug"),
        TARGET((short) 2, Constants.KEY_TARGET),
        ID((short) 3, AgooConstants.MESSAGE_ID),
        APP_ID((short) 4, ModelFields.APP_ID),
        APP_VERSION((short) 5, Constants.KEY_APP_VERSION),
        PACKAGE_NAME((short) 6, Constants.KEY_PACKAGE_NAME),
        TOKEN((short) 7, com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN),
        DEVICE_ID((short) 8, C4575b.KEY_DEVICE_TOKEN),
        ALIAS_NAME((short) 9, "aliasName"),
        SDK_VERSION((short) 10, Constants.KEY_SDK_VERSION),
        REG_ID((short) 11, "regId"),
        PUSH_SDK_VERSION_NAME((short) 12, "pushSdkVersionName"),
        PUSH_SDK_VERSION_CODE((short) 13, "pushSdkVersionCode"),
        APP_VERSION_CODE((short) 14, Constants.KEY_APP_VERSION_CODE),
        ANDROID_ID((short) 15, "androidId"),
        IMEI((short) 16, Constants.KEY_IMEI),
        SERIAL((short) 17, C0655b.HR_SERIAL),
        IMEI_MD5((short) 18, "imeiMd5"),
        SPACE_ID((short) 19, "spaceId"),
        REASON((short) 20, "reason"),
        CONNECTION_ATTRS((short) 100, "connectionAttrs"),
        CLEAN_OLD_REG_INFO((short) 101, "cleanOldRegInfo"),
        OLD_REG_ID((short) 102, "oldRegId");
        
        private static final Map<String, C4549a> f16139x;
        private final short f16140y;
        private final String f16141z;

        static {
            f16139x = new HashMap();
            Iterator it = EnumSet.allOf(C4549a.class).iterator();
            while (it.hasNext()) {
                C4549a c4549a = (C4549a) it.next();
                f16139x.put(c4549a.m19075a(), c4549a);
            }
        }

        private C4549a(short s, String str) {
            this.f16140y = s;
            this.f16141z = str;
        }

        public String m19075a() {
            return this.f16141z;
        }
    }

    static {
        f16165y = new C4615j("XmPushActionRegistration");
        f16166z = new C4609b("debug", (byte) 11, (short) 1);
        f16142A = new C4609b(Constants.KEY_TARGET, (byte) 12, (short) 2);
        f16143B = new C4609b(AgooConstants.MESSAGE_ID, (byte) 11, (short) 3);
        f16144C = new C4609b(ModelFields.APP_ID, (byte) 11, (short) 4);
        f16145D = new C4609b(Constants.KEY_APP_VERSION, (byte) 11, (short) 5);
        f16146E = new C4609b(Constants.KEY_PACKAGE_NAME, (byte) 11, (short) 6);
        f16147F = new C4609b(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, (byte) 11, (short) 7);
        f16148G = new C4609b(C4575b.KEY_DEVICE_TOKEN, (byte) 11, (short) 8);
        f16149H = new C4609b("aliasName", (byte) 11, (short) 9);
        f16150I = new C4609b(Constants.KEY_SDK_VERSION, (byte) 11, (short) 10);
        f16151J = new C4609b("regId", (byte) 11, (short) 11);
        f16152K = new C4609b("pushSdkVersionName", (byte) 11, (short) 12);
        f16153L = new C4609b("pushSdkVersionCode", (byte) 8, (short) 13);
        f16154M = new C4609b(Constants.KEY_APP_VERSION_CODE, (byte) 8, (short) 14);
        f16155N = new C4609b("androidId", (byte) 11, (short) 15);
        f16156O = new C4609b(Constants.KEY_IMEI, (byte) 11, (short) 16);
        f16157P = new C4609b(C0655b.HR_SERIAL, (byte) 11, (short) 17);
        f16158Q = new C4609b("imeiMd5", (byte) 11, (short) 18);
        f16159R = new C4609b("spaceId", (byte) 8, (short) 19);
        f16160S = new C4609b("reason", (byte) 8, (short) 20);
        f16161T = new C4609b("connectionAttrs", (byte) 13, (short) 100);
        f16162U = new C4609b("cleanOldRegInfo", (byte) 2, (short) 101);
        f16163V = new C4609b("oldRegId", (byte) 11, (short) 102);
        Map enumMap = new EnumMap(C4549a.class);
        enumMap.put(C4549a.DEBUG, new C4601b("debug", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.TARGET, new C4601b(Constants.KEY_TARGET, (byte) 2, new C4604f((byte) 12, C4532k.class)));
        enumMap.put(C4549a.ID, new C4601b(AgooConstants.MESSAGE_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4549a.APP_ID, new C4601b(ModelFields.APP_ID, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4549a.APP_VERSION, new C4601b(Constants.KEY_APP_VERSION, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.PACKAGE_NAME, new C4601b(Constants.KEY_PACKAGE_NAME, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.TOKEN, new C4601b(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_TOKEN, (byte) 1, new C4599c((byte) 11)));
        enumMap.put(C4549a.DEVICE_ID, new C4601b(C4575b.KEY_DEVICE_TOKEN, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.ALIAS_NAME, new C4601b("aliasName", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.SDK_VERSION, new C4601b(Constants.KEY_SDK_VERSION, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.REG_ID, new C4601b("regId", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.PUSH_SDK_VERSION_NAME, new C4601b("pushSdkVersionName", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.PUSH_SDK_VERSION_CODE, new C4601b("pushSdkVersionCode", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4549a.APP_VERSION_CODE, new C4601b(Constants.KEY_APP_VERSION_CODE, (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4549a.ANDROID_ID, new C4601b("androidId", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.IMEI, new C4601b(Constants.KEY_IMEI, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.SERIAL, new C4601b(C0655b.HR_SERIAL, (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.IMEI_MD5, new C4601b("imeiMd5", (byte) 2, new C4599c((byte) 11)));
        enumMap.put(C4549a.SPACE_ID, new C4601b("spaceId", (byte) 2, new C4599c((byte) 8)));
        enumMap.put(C4549a.REASON, new C4601b("reason", (byte) 2, new C4600a((byte) 16, C4530j.class)));
        enumMap.put(C4549a.CONNECTION_ATTRS, new C4601b("connectionAttrs", (byte) 2, new C4603e((byte) 13, new C4599c((byte) 11), new C4599c((byte) 11))));
        enumMap.put(C4549a.CLEAN_OLD_REG_INFO, new C4601b("cleanOldRegInfo", (byte) 2, new C4599c((byte) 2)));
        enumMap.put(C4549a.OLD_REG_ID, new C4601b("oldRegId", (byte) 2, new C4599c((byte) 11)));
        f16164x = Collections.unmodifiableMap(enumMap);
        C4601b.m19301a(C4550t.class, f16164x);
    }

    public C4550t() {
        this.f16167W = new BitSet(4);
        this.f16189v = false;
    }

    public C4550t m19076a(int i) {
        this.f16180m = i;
        m19080a(true);
        return this;
    }

    public C4550t m19077a(C4530j c4530j) {
        this.f16187t = c4530j;
        return this;
    }

    public C4550t m19078a(String str) {
        this.f16170c = str;
        return this;
    }

    public void m19079a(C4607e c4607e) {
        c4607e.m19320f();
        while (true) {
            C4609b h = c4607e.m19322h();
            if (h.f16476b == null) {
                c4607e.m19321g();
                m19124z();
                return;
            }
            switch (h.f16477c) {
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16168a = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (h.f16476b != 12) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16169b = new C4532k();
                    this.f16169b.m18901a(c4607e);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16170c = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.QUIC /*4*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16171d = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16172e = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16173f = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16174g = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16175h = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16176i = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16177j = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.PUBKEY_PSEQ_OPEN /*11*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16178k = c4607e.m19336v();
                        break;
                    }
                case com.xiaomi.mipush.sdk.Constants.UPLOAD_NOTIFICATION_INFO_JOB_ID /*12*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16179l = c4607e.m19336v();
                        break;
                    }
                case C4273R.styleable.TitlePageIndicator_titlePadding /*13*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16180m = c4607e.m19333s();
                    m19080a(true);
                    break;
                case C4273R.styleable.TitlePageIndicator_topPadding /*14*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16181n = c4607e.m19333s();
                    m19087b(true);
                    break;
                case C3628R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling /*15*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16182o = c4607e.m19336v();
                        break;
                    }
                case SpdyProtocol.CUSTOM /*16*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16183p = c4607e.m19336v();
                        break;
                    }
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16184q = c4607e.m19336v();
                        break;
                    }
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16185r = c4607e.m19336v();
                        break;
                    }
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16186s = c4607e.m19333s();
                    m19091c(true);
                    break;
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    if (h.f16476b != (byte) 8) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16187t = C4530j.m18898a(c4607e.m19333s());
                        break;
                    }
                case Constants.COMMAND_SEND_DATA /*100*/:
                    if (h.f16476b != 13) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    C4611d j = c4607e.m19324j();
                    this.f16188u = new HashMap(j.f16482c * 2);
                    for (int i = 0; i < j.f16482c; i++) {
                        this.f16188u.put(c4607e.m19336v(), c4607e.m19336v());
                    }
                    c4607e.m19325k();
                    break;
                case Constants.COMMAND_RECEIVE_DATA /*101*/:
                    if (h.f16476b != 2) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    }
                    this.f16189v = c4607e.m19330p();
                    m19095d(true);
                    break;
                case Constants.COMMAND_SEND_STATIST /*102*/:
                    if (h.f16476b != (byte) 11) {
                        C4613h.m19377a(c4607e, h.f16476b);
                        break;
                    } else {
                        this.f16190w = c4607e.m19336v();
                        break;
                    }
                default:
                    C4613h.m19377a(c4607e, h.f16476b);
                    break;
            }
            c4607e.m19323i();
        }
    }

    public void m19080a(boolean z) {
        this.f16167W.set(0, z);
    }

    public boolean m19081a() {
        return this.f16168a != null;
    }

    public boolean m19082a(C4550t c4550t) {
        if (c4550t == null) {
            return false;
        }
        boolean a = m19081a();
        boolean a2 = c4550t.m19081a();
        if ((a || a2) && (!a || !a2 || !this.f16168a.equals(c4550t.f16168a))) {
            return false;
        }
        a = m19088b();
        a2 = c4550t.m19088b();
        if ((a || a2) && (!a || !a2 || !this.f16169b.m18904a(c4550t.f16169b))) {
            return false;
        }
        a = m19092c();
        a2 = c4550t.m19092c();
        if ((a || a2) && (!a || !a2 || !this.f16170c.equals(c4550t.f16170c))) {
            return false;
        }
        a = m19097e();
        a2 = c4550t.m19097e();
        if ((a || a2) && (!a || !a2 || !this.f16171d.equals(c4550t.f16171d))) {
            return false;
        }
        a = m19099f();
        a2 = c4550t.m19099f();
        if ((a || a2) && (!a || !a2 || !this.f16172e.equals(c4550t.f16172e))) {
            return false;
        }
        a = m19101g();
        a2 = c4550t.m19101g();
        if ((a || a2) && (!a || !a2 || !this.f16173f.equals(c4550t.f16173f))) {
            return false;
        }
        a = m19105i();
        a2 = c4550t.m19105i();
        if ((a || a2) && (!a || !a2 || !this.f16174g.equals(c4550t.f16174g))) {
            return false;
        }
        a = m19107j();
        a2 = c4550t.m19107j();
        if ((a || a2) && (!a || !a2 || !this.f16175h.equals(c4550t.f16175h))) {
            return false;
        }
        a = m19109k();
        a2 = c4550t.m19109k();
        if ((a || a2) && (!a || !a2 || !this.f16176i.equals(c4550t.f16176i))) {
            return false;
        }
        a = m19110l();
        a2 = c4550t.m19110l();
        if ((a || a2) && (!a || !a2 || !this.f16177j.equals(c4550t.f16177j))) {
            return false;
        }
        a = m19111m();
        a2 = c4550t.m19111m();
        if ((a || a2) && (!a || !a2 || !this.f16178k.equals(c4550t.f16178k))) {
            return false;
        }
        a = m19112n();
        a2 = c4550t.m19112n();
        if ((a || a2) && (!a || !a2 || !this.f16179l.equals(c4550t.f16179l))) {
            return false;
        }
        a = m19113o();
        a2 = c4550t.m19113o();
        if ((a || a2) && (!a || !a2 || this.f16180m != c4550t.f16180m)) {
            return false;
        }
        a = m19114p();
        a2 = c4550t.m19114p();
        if ((a || a2) && (!a || !a2 || this.f16181n != c4550t.f16181n)) {
            return false;
        }
        a = m19115q();
        a2 = c4550t.m19115q();
        if ((a || a2) && (!a || !a2 || !this.f16182o.equals(c4550t.f16182o))) {
            return false;
        }
        a = m19116r();
        a2 = c4550t.m19116r();
        if ((a || a2) && (!a || !a2 || !this.f16183p.equals(c4550t.f16183p))) {
            return false;
        }
        a = m19117s();
        a2 = c4550t.m19117s();
        if ((a || a2) && (!a || !a2 || !this.f16184q.equals(c4550t.f16184q))) {
            return false;
        }
        a = m19118t();
        a2 = c4550t.m19118t();
        if ((a || a2) && (!a || !a2 || !this.f16185r.equals(c4550t.f16185r))) {
            return false;
        }
        a = m19119u();
        a2 = c4550t.m19119u();
        if ((a || a2) && (!a || !a2 || this.f16186s != c4550t.f16186s)) {
            return false;
        }
        a = m19120v();
        a2 = c4550t.m19120v();
        if ((a || a2) && (!a || !a2 || !this.f16187t.equals(c4550t.f16187t))) {
            return false;
        }
        a = m19121w();
        a2 = c4550t.m19121w();
        if ((a || a2) && (!a || !a2 || !this.f16188u.equals(c4550t.f16188u))) {
            return false;
        }
        a = m19122x();
        a2 = c4550t.m19122x();
        if ((a || a2) && (!a || !a2 || this.f16189v != c4550t.f16189v)) {
            return false;
        }
        a = m19123y();
        a2 = c4550t.m19123y();
        return !(a || a2) || (a && a2 && this.f16190w.equals(c4550t.f16190w));
    }

    public int m19083b(C4550t c4550t) {
        if (!getClass().equals(c4550t.getClass())) {
            return getClass().getName().compareTo(c4550t.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m19081a()).compareTo(Boolean.valueOf(c4550t.m19081a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19081a()) {
            compareTo = C4593b.m19284a(this.f16168a, c4550t.f16168a);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19088b()).compareTo(Boolean.valueOf(c4550t.m19088b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19088b()) {
            compareTo = C4593b.m19283a(this.f16169b, c4550t.f16169b);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19092c()).compareTo(Boolean.valueOf(c4550t.m19092c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19092c()) {
            compareTo = C4593b.m19284a(this.f16170c, c4550t.f16170c);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19097e()).compareTo(Boolean.valueOf(c4550t.m19097e()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19097e()) {
            compareTo = C4593b.m19284a(this.f16171d, c4550t.f16171d);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19099f()).compareTo(Boolean.valueOf(c4550t.m19099f()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19099f()) {
            compareTo = C4593b.m19284a(this.f16172e, c4550t.f16172e);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19101g()).compareTo(Boolean.valueOf(c4550t.m19101g()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19101g()) {
            compareTo = C4593b.m19284a(this.f16173f, c4550t.f16173f);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19105i()).compareTo(Boolean.valueOf(c4550t.m19105i()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19105i()) {
            compareTo = C4593b.m19284a(this.f16174g, c4550t.f16174g);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19107j()).compareTo(Boolean.valueOf(c4550t.m19107j()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19107j()) {
            compareTo = C4593b.m19284a(this.f16175h, c4550t.f16175h);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19109k()).compareTo(Boolean.valueOf(c4550t.m19109k()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19109k()) {
            compareTo = C4593b.m19284a(this.f16176i, c4550t.f16176i);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19110l()).compareTo(Boolean.valueOf(c4550t.m19110l()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19110l()) {
            compareTo = C4593b.m19284a(this.f16177j, c4550t.f16177j);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19111m()).compareTo(Boolean.valueOf(c4550t.m19111m()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19111m()) {
            compareTo = C4593b.m19284a(this.f16178k, c4550t.f16178k);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19112n()).compareTo(Boolean.valueOf(c4550t.m19112n()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19112n()) {
            compareTo = C4593b.m19284a(this.f16179l, c4550t.f16179l);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19113o()).compareTo(Boolean.valueOf(c4550t.m19113o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19113o()) {
            compareTo = C4593b.m19281a(this.f16180m, c4550t.f16180m);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19114p()).compareTo(Boolean.valueOf(c4550t.m19114p()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19114p()) {
            compareTo = C4593b.m19281a(this.f16181n, c4550t.f16181n);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19115q()).compareTo(Boolean.valueOf(c4550t.m19115q()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19115q()) {
            compareTo = C4593b.m19284a(this.f16182o, c4550t.f16182o);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19116r()).compareTo(Boolean.valueOf(c4550t.m19116r()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19116r()) {
            compareTo = C4593b.m19284a(this.f16183p, c4550t.f16183p);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19117s()).compareTo(Boolean.valueOf(c4550t.m19117s()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19117s()) {
            compareTo = C4593b.m19284a(this.f16184q, c4550t.f16184q);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19118t()).compareTo(Boolean.valueOf(c4550t.m19118t()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19118t()) {
            compareTo = C4593b.m19284a(this.f16185r, c4550t.f16185r);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19119u()).compareTo(Boolean.valueOf(c4550t.m19119u()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19119u()) {
            compareTo = C4593b.m19281a(this.f16186s, c4550t.f16186s);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19120v()).compareTo(Boolean.valueOf(c4550t.m19120v()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19120v()) {
            compareTo = C4593b.m19283a(this.f16187t, c4550t.f16187t);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19121w()).compareTo(Boolean.valueOf(c4550t.m19121w()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19121w()) {
            compareTo = C4593b.m19287a(this.f16188u, c4550t.f16188u);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19122x()).compareTo(Boolean.valueOf(c4550t.m19122x()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19122x()) {
            compareTo = C4593b.m19290a(this.f16189v, c4550t.f16189v);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        compareTo = Boolean.valueOf(m19123y()).compareTo(Boolean.valueOf(c4550t.m19123y()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m19123y()) {
            compareTo = C4593b.m19284a(this.f16190w, c4550t.f16190w);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public C4550t m19084b(int i) {
        this.f16181n = i;
        m19087b(true);
        return this;
    }

    public C4550t m19085b(String str) {
        this.f16171d = str;
        return this;
    }

    public void m19086b(C4607e c4607e) {
        m19124z();
        c4607e.m19313a(f16165y);
        if (this.f16168a != null && m19081a()) {
            c4607e.m19310a(f16166z);
            c4607e.m19308a(this.f16168a);
            c4607e.m19316b();
        }
        if (this.f16169b != null && m19088b()) {
            c4607e.m19310a(f16142A);
            this.f16169b.m18906b(c4607e);
            c4607e.m19316b();
        }
        if (this.f16170c != null) {
            c4607e.m19310a(f16143B);
            c4607e.m19308a(this.f16170c);
            c4607e.m19316b();
        }
        if (this.f16171d != null) {
            c4607e.m19310a(f16144C);
            c4607e.m19308a(this.f16171d);
            c4607e.m19316b();
        }
        if (this.f16172e != null && m19099f()) {
            c4607e.m19310a(f16145D);
            c4607e.m19308a(this.f16172e);
            c4607e.m19316b();
        }
        if (this.f16173f != null && m19101g()) {
            c4607e.m19310a(f16146E);
            c4607e.m19308a(this.f16173f);
            c4607e.m19316b();
        }
        if (this.f16174g != null) {
            c4607e.m19310a(f16147F);
            c4607e.m19308a(this.f16174g);
            c4607e.m19316b();
        }
        if (this.f16175h != null && m19107j()) {
            c4607e.m19310a(f16148G);
            c4607e.m19308a(this.f16175h);
            c4607e.m19316b();
        }
        if (this.f16176i != null && m19109k()) {
            c4607e.m19310a(f16149H);
            c4607e.m19308a(this.f16176i);
            c4607e.m19316b();
        }
        if (this.f16177j != null && m19110l()) {
            c4607e.m19310a(f16150I);
            c4607e.m19308a(this.f16177j);
            c4607e.m19316b();
        }
        if (this.f16178k != null && m19111m()) {
            c4607e.m19310a(f16151J);
            c4607e.m19308a(this.f16178k);
            c4607e.m19316b();
        }
        if (this.f16179l != null && m19112n()) {
            c4607e.m19310a(f16152K);
            c4607e.m19308a(this.f16179l);
            c4607e.m19316b();
        }
        if (m19113o()) {
            c4607e.m19310a(f16153L);
            c4607e.m19306a(this.f16180m);
            c4607e.m19316b();
        }
        if (m19114p()) {
            c4607e.m19310a(f16154M);
            c4607e.m19306a(this.f16181n);
            c4607e.m19316b();
        }
        if (this.f16182o != null && m19115q()) {
            c4607e.m19310a(f16155N);
            c4607e.m19308a(this.f16182o);
            c4607e.m19316b();
        }
        if (this.f16183p != null && m19116r()) {
            c4607e.m19310a(f16156O);
            c4607e.m19308a(this.f16183p);
            c4607e.m19316b();
        }
        if (this.f16184q != null && m19117s()) {
            c4607e.m19310a(f16157P);
            c4607e.m19308a(this.f16184q);
            c4607e.m19316b();
        }
        if (this.f16185r != null && m19118t()) {
            c4607e.m19310a(f16158Q);
            c4607e.m19308a(this.f16185r);
            c4607e.m19316b();
        }
        if (m19119u()) {
            c4607e.m19310a(f16159R);
            c4607e.m19306a(this.f16186s);
            c4607e.m19316b();
        }
        if (this.f16187t != null && m19120v()) {
            c4607e.m19310a(f16160S);
            c4607e.m19306a(this.f16187t.m18899a());
            c4607e.m19316b();
        }
        if (this.f16188u != null && m19121w()) {
            c4607e.m19310a(f16161T);
            c4607e.m19312a(new C4611d((byte) 11, (byte) 11, this.f16188u.size()));
            for (Entry entry : this.f16188u.entrySet()) {
                c4607e.m19308a((String) entry.getKey());
                c4607e.m19308a((String) entry.getValue());
            }
            c4607e.m19318d();
            c4607e.m19316b();
        }
        if (m19122x()) {
            c4607e.m19310a(f16162U);
            c4607e.m19315a(this.f16189v);
            c4607e.m19316b();
        }
        if (this.f16190w != null && m19123y()) {
            c4607e.m19310a(f16163V);
            c4607e.m19308a(this.f16190w);
            c4607e.m19316b();
        }
        c4607e.m19317c();
        c4607e.m19304a();
    }

    public void m19087b(boolean z) {
        this.f16167W.set(1, z);
    }

    public boolean m19088b() {
        return this.f16169b != null;
    }

    public C4550t m19089c(int i) {
        this.f16186s = i;
        m19091c(true);
        return this;
    }

    public C4550t m19090c(String str) {
        this.f16172e = str;
        return this;
    }

    public void m19091c(boolean z) {
        this.f16167W.set(2, z);
    }

    public boolean m19092c() {
        return this.f16170c != null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m19083b((C4550t) obj);
    }

    public C4550t m19093d(String str) {
        this.f16173f = str;
        return this;
    }

    public String m19094d() {
        return this.f16171d;
    }

    public void m19095d(boolean z) {
        this.f16167W.set(3, z);
    }

    public C4550t m19096e(String str) {
        this.f16174g = str;
        return this;
    }

    public boolean m19097e() {
        return this.f16171d != null;
    }

    public boolean equals(Object obj) {
        return (obj != null && (obj instanceof C4550t)) ? m19082a((C4550t) obj) : false;
    }

    public C4550t m19098f(String str) {
        this.f16175h = str;
        return this;
    }

    public boolean m19099f() {
        return this.f16172e != null;
    }

    public C4550t m19100g(String str) {
        this.f16179l = str;
        return this;
    }

    public boolean m19101g() {
        return this.f16173f != null;
    }

    public C4550t m19102h(String str) {
        this.f16182o = str;
        return this;
    }

    public String m19103h() {
        return this.f16174g;
    }

    public int hashCode() {
        return 0;
    }

    public C4550t m19104i(String str) {
        this.f16183p = str;
        return this;
    }

    public boolean m19105i() {
        return this.f16174g != null;
    }

    public C4550t m19106j(String str) {
        this.f16184q = str;
        return this;
    }

    public boolean m19107j() {
        return this.f16175h != null;
    }

    public C4550t m19108k(String str) {
        this.f16185r = str;
        return this;
    }

    public boolean m19109k() {
        return this.f16176i != null;
    }

    public boolean m19110l() {
        return this.f16177j != null;
    }

    public boolean m19111m() {
        return this.f16178k != null;
    }

    public boolean m19112n() {
        return this.f16179l != null;
    }

    public boolean m19113o() {
        return this.f16167W.get(0);
    }

    public boolean m19114p() {
        return this.f16167W.get(1);
    }

    public boolean m19115q() {
        return this.f16182o != null;
    }

    public boolean m19116r() {
        return this.f16183p != null;
    }

    public boolean m19117s() {
        return this.f16184q != null;
    }

    public boolean m19118t() {
        return this.f16185r != null;
    }

    public String toString() {
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder("XmPushActionRegistration(");
        Object obj2 = 1;
        if (m19081a()) {
            stringBuilder.append("debug:");
            if (this.f16168a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16168a);
            }
            obj2 = null;
        }
        if (m19088b()) {
            if (obj2 == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("target:");
            if (this.f16169b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16169b);
            }
        } else {
            obj = obj2;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("id:");
        if (this.f16170c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16170c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("appId:");
        if (this.f16171d == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16171d);
        }
        if (m19099f()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersion:");
            if (this.f16172e == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16172e);
            }
        }
        if (m19101g()) {
            stringBuilder.append(", ");
            stringBuilder.append("packageName:");
            if (this.f16173f == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16173f);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("token:");
        if (this.f16174g == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f16174g);
        }
        if (m19107j()) {
            stringBuilder.append(", ");
            stringBuilder.append("deviceId:");
            if (this.f16175h == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16175h);
            }
        }
        if (m19109k()) {
            stringBuilder.append(", ");
            stringBuilder.append("aliasName:");
            if (this.f16176i == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16176i);
            }
        }
        if (m19110l()) {
            stringBuilder.append(", ");
            stringBuilder.append("sdkVersion:");
            if (this.f16177j == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16177j);
            }
        }
        if (m19111m()) {
            stringBuilder.append(", ");
            stringBuilder.append("regId:");
            if (this.f16178k == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16178k);
            }
        }
        if (m19112n()) {
            stringBuilder.append(", ");
            stringBuilder.append("pushSdkVersionName:");
            if (this.f16179l == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16179l);
            }
        }
        if (m19113o()) {
            stringBuilder.append(", ");
            stringBuilder.append("pushSdkVersionCode:");
            stringBuilder.append(this.f16180m);
        }
        if (m19114p()) {
            stringBuilder.append(", ");
            stringBuilder.append("appVersionCode:");
            stringBuilder.append(this.f16181n);
        }
        if (m19115q()) {
            stringBuilder.append(", ");
            stringBuilder.append("androidId:");
            if (this.f16182o == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16182o);
            }
        }
        if (m19116r()) {
            stringBuilder.append(", ");
            stringBuilder.append("imei:");
            if (this.f16183p == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16183p);
            }
        }
        if (m19117s()) {
            stringBuilder.append(", ");
            stringBuilder.append("serial:");
            if (this.f16184q == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16184q);
            }
        }
        if (m19118t()) {
            stringBuilder.append(", ");
            stringBuilder.append("imeiMd5:");
            if (this.f16185r == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16185r);
            }
        }
        if (m19119u()) {
            stringBuilder.append(", ");
            stringBuilder.append("spaceId:");
            stringBuilder.append(this.f16186s);
        }
        if (m19120v()) {
            stringBuilder.append(", ");
            stringBuilder.append("reason:");
            if (this.f16187t == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16187t);
            }
        }
        if (m19121w()) {
            stringBuilder.append(", ");
            stringBuilder.append("connectionAttrs:");
            if (this.f16188u == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16188u);
            }
        }
        if (m19122x()) {
            stringBuilder.append(", ");
            stringBuilder.append("cleanOldRegInfo:");
            stringBuilder.append(this.f16189v);
        }
        if (m19123y()) {
            stringBuilder.append(", ");
            stringBuilder.append("oldRegId:");
            if (this.f16190w == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f16190w);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }

    public boolean m19119u() {
        return this.f16167W.get(2);
    }

    public boolean m19120v() {
        return this.f16187t != null;
    }

    public boolean m19121w() {
        return this.f16188u != null;
    }

    public boolean m19122x() {
        return this.f16167W.get(3);
    }

    public boolean m19123y() {
        return this.f16190w != null;
    }

    public void m19124z() {
        if (this.f16170c == null) {
            throw new C4612f("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f16171d == null) {
            throw new C4612f("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f16174g == null) {
            throw new C4612f("Required field 'token' was not present! Struct: " + toString());
        }
    }
}
