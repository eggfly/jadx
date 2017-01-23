package p023b.p024a;

import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.ad */
public class ad implements aw<ad, C0785e>, Serializable, Cloneable {
    public static final Map<C0785e, bc> f2552d;
    private static final bs f2553e;
    private static final bj f2554f;
    private static final bj f2555g;
    private static final bj f2556h;
    private static final Map<Class<? extends bu>, bv> f2557i;
    public String f2558a;
    public long f2559b;
    public int f2560c;
    private byte f2561j;

    /* renamed from: b.a.ad.a */
    private static class C0781a extends bw<ad> {
        private C0781a() {
        }

        public void m3115a(bm bmVar, ad adVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (!adVar.m3142c()) {
                        throw new bn("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    } else if (adVar.m3144e()) {
                        adVar.m3145f();
                        return;
                    } else {
                        throw new bn("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        adVar.f2558a = bmVar.m3521v();
                        adVar.m3137a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != 10) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        adVar.f2559b = bmVar.m3519t();
                        adVar.m3140b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        adVar.f2560c = bmVar.m3518s();
                        adVar.m3141c(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3116a(bm bmVar, aw awVar) {
            m3117b(bmVar, (ad) awVar);
        }

        public void m3117b(bm bmVar, ad adVar) {
            adVar.m3145f();
            bmVar.m3498a(ad.f2553e);
            if (adVar.f2558a != null) {
                bmVar.m3495a(ad.f2554f);
                bmVar.m3499a(adVar.f2558a);
                bmVar.m3501b();
            }
            bmVar.m3495a(ad.f2555g);
            bmVar.m3494a(adVar.f2559b);
            bmVar.m3501b();
            bmVar.m3495a(ad.f2556h);
            bmVar.m3493a(adVar.f2560c);
            bmVar.m3501b();
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3118b(bm bmVar, aw awVar) {
            m3115a(bmVar, (ad) awVar);
        }
    }

    /* renamed from: b.a.ad.b */
    private static class C0782b implements bv {
        private C0782b() {
        }

        public C0781a m3119a() {
            return new C0781a();
        }

        public /* synthetic */ bu m3120b() {
            return m3119a();
        }
    }

    /* renamed from: b.a.ad.c */
    private static class C0783c extends bx<ad> {
        private C0783c() {
        }

        public void m3121a(bm bmVar, ad adVar) {
            bt btVar = (bt) bmVar;
            btVar.m3590a(adVar.f2558a);
            btVar.m3585a(adVar.f2559b);
            btVar.m3584a(adVar.f2560c);
        }

        public void m3123b(bm bmVar, ad adVar) {
            bt btVar = (bt) bmVar;
            adVar.f2558a = btVar.m3613v();
            adVar.m3137a(true);
            adVar.f2559b = btVar.m3611t();
            adVar.m3140b(true);
            adVar.f2560c = btVar.m3610s();
            adVar.m3141c(true);
        }
    }

    /* renamed from: b.a.ad.d */
    private static class C0784d implements bv {
        private C0784d() {
        }

        public C0783c m3125a() {
            return new C0783c();
        }

        public /* synthetic */ bu m3126b() {
            return m3125a();
        }
    }

    /* renamed from: b.a.ad.e */
    public enum C0785e {
        IDENTITY((short) 1, "identity"),
        TS((short) 2, MsgConstant.KEY_TS),
        VERSION((short) 3, Constants.SP_KEY_VERSION);
        
        private static final Map<String, C0785e> f2548d;
        private final short f2550e;
        private final String f2551f;

        static {
            f2548d = new HashMap();
            Iterator it = EnumSet.allOf(C0785e.class).iterator();
            while (it.hasNext()) {
                C0785e c0785e = (C0785e) it.next();
                f2548d.put(c0785e.m3127a(), c0785e);
            }
        }

        private C0785e(short s, String str) {
            this.f2550e = s;
            this.f2551f = str;
        }

        public String m3127a() {
            return this.f2551f;
        }
    }

    static {
        f2553e = new bs("IdSnapshot");
        f2554f = new bj("identity", (byte) 11, (short) 1);
        f2555g = new bj(MsgConstant.KEY_TS, (byte) 10, (short) 2);
        f2556h = new bj(Constants.SP_KEY_VERSION, (byte) 8, (short) 3);
        f2557i = new HashMap();
        f2557i.put(bw.class, new C0782b());
        f2557i.put(bx.class, new C0784d());
        Map enumMap = new EnumMap(C0785e.class);
        enumMap.put(C0785e.IDENTITY, new bc("identity", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0785e.TS, new bc(MsgConstant.KEY_TS, (byte) 1, new bd((byte) 10)));
        enumMap.put(C0785e.VERSION, new bc(Constants.SP_KEY_VERSION, (byte) 1, new bd((byte) 8)));
        f2552d = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ad.class, f2552d);
    }

    public ad() {
        this.f2561j = (byte) 0;
    }

    public ad m3132a(int i) {
        this.f2560c = i;
        m3141c(true);
        return this;
    }

    public ad m3133a(long j) {
        this.f2559b = j;
        m3140b(true);
        return this;
    }

    public ad m3134a(String str) {
        this.f2558a = str;
        return this;
    }

    public String m3135a() {
        return this.f2558a;
    }

    public void m3136a(bm bmVar) {
        ((bv) f2557i.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3137a(boolean z) {
        if (!z) {
            this.f2558a = null;
        }
    }

    public long m3138b() {
        return this.f2559b;
    }

    public void m3139b(bm bmVar) {
        ((bv) f2557i.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3140b(boolean z) {
        this.f2561j = au.m3450a(this.f2561j, 0, z);
    }

    public void m3141c(boolean z) {
        this.f2561j = au.m3450a(this.f2561j, 1, z);
    }

    public boolean m3142c() {
        return au.m3452a(this.f2561j, 0);
    }

    public int m3143d() {
        return this.f2560c;
    }

    public boolean m3144e() {
        return au.m3452a(this.f2561j, 1);
    }

    public void m3145f() {
        if (this.f2558a == null) {
            throw new bn("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.f2558a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2558a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f2559b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.f2560c);
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
