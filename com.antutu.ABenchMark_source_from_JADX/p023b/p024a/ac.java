package p023b.p024a;

import anet.channel.strategy.dispatch.C0714a;
import com.umeng.message.MsgConstant;
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

/* renamed from: b.a.ac */
public class ac implements aw<ac, C0779e>, Serializable, Cloneable {
    public static final Map<C0779e, bc> f2532e;
    private static final bs f2533f;
    private static final bj f2534g;
    private static final bj f2535h;
    private static final bj f2536i;
    private static final bj f2537j;
    private static final Map<Class<? extends bu>, bv> f2538k;
    public String f2539a;
    public String f2540b;
    public String f2541c;
    public long f2542d;
    private byte f2543l;
    private C0779e[] f2544m;

    /* renamed from: b.a.ac.a */
    private static class C0775a extends bw<ac> {
        private C0775a() {
        }

        public void m3081a(bm bmVar, ac acVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (acVar.m3110b()) {
                        acVar.m3112c();
                        return;
                    }
                    throw new bn("Required field 'ts' was not found in serialized data! Struct: " + toString());
                }
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        acVar.f2539a = bmVar.m3521v();
                        acVar.m3105a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        acVar.f2540b = bmVar.m3521v();
                        acVar.m3109b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        acVar.f2541c = bmVar.m3521v();
                        acVar.m3113c(true);
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        if (h.f2782b != 10) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        acVar.f2542d = bmVar.m3519t();
                        acVar.m3114d(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3082a(bm bmVar, aw awVar) {
            m3083b(bmVar, (ac) awVar);
        }

        public void m3083b(bm bmVar, ac acVar) {
            acVar.m3112c();
            bmVar.m3498a(ac.f2533f);
            if (acVar.f2539a != null) {
                bmVar.m3495a(ac.f2534g);
                bmVar.m3499a(acVar.f2539a);
                bmVar.m3501b();
            }
            if (acVar.f2540b != null && acVar.m3106a()) {
                bmVar.m3495a(ac.f2535h);
                bmVar.m3499a(acVar.f2540b);
                bmVar.m3501b();
            }
            if (acVar.f2541c != null) {
                bmVar.m3495a(ac.f2536i);
                bmVar.m3499a(acVar.f2541c);
                bmVar.m3501b();
            }
            bmVar.m3495a(ac.f2537j);
            bmVar.m3494a(acVar.f2542d);
            bmVar.m3501b();
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3084b(bm bmVar, aw awVar) {
            m3081a(bmVar, (ac) awVar);
        }
    }

    /* renamed from: b.a.ac.b */
    private static class C0776b implements bv {
        private C0776b() {
        }

        public C0775a m3086a() {
            return new C0775a();
        }

        public /* synthetic */ bu m3087b() {
            return m3086a();
        }
    }

    /* renamed from: b.a.ac.c */
    private static class C0777c extends bx<ac> {
        private C0777c() {
        }

        public void m3088a(bm bmVar, ac acVar) {
            bt btVar = (bt) bmVar;
            btVar.m3590a(acVar.f2539a);
            btVar.m3590a(acVar.f2541c);
            btVar.m3585a(acVar.f2542d);
            BitSet bitSet = new BitSet();
            if (acVar.m3106a()) {
                bitSet.set(0);
            }
            btVar.m3623a(bitSet, 1);
            if (acVar.m3106a()) {
                btVar.m3590a(acVar.f2540b);
            }
        }

        public void m3090b(bm bmVar, ac acVar) {
            bt btVar = (bt) bmVar;
            acVar.f2539a = btVar.m3613v();
            acVar.m3105a(true);
            acVar.f2541c = btVar.m3613v();
            acVar.m3113c(true);
            acVar.f2542d = btVar.m3611t();
            acVar.m3114d(true);
            if (btVar.m3624b(1).get(0)) {
                acVar.f2540b = btVar.m3613v();
                acVar.m3109b(true);
            }
        }
    }

    /* renamed from: b.a.ac.d */
    private static class C0778d implements bv {
        private C0778d() {
        }

        public C0777c m3092a() {
            return new C0777c();
        }

        public /* synthetic */ bu m3093b() {
            return m3092a();
        }
    }

    /* renamed from: b.a.ac.e */
    public enum C0779e {
        DOMAIN((short) 1, C0714a.DOMAIN),
        OLD_ID((short) 2, "old_id"),
        NEW_ID((short) 3, "new_id"),
        TS((short) 4, MsgConstant.KEY_TS);
        
        private static final Map<String, C0779e> f2528e;
        private final short f2530f;
        private final String f2531g;

        static {
            f2528e = new HashMap();
            Iterator it = EnumSet.allOf(C0779e.class).iterator();
            while (it.hasNext()) {
                C0779e c0779e = (C0779e) it.next();
                f2528e.put(c0779e.m3094a(), c0779e);
            }
        }

        private C0779e(short s, String str) {
            this.f2530f = s;
            this.f2531g = str;
        }

        public String m3094a() {
            return this.f2531g;
        }
    }

    static {
        f2533f = new bs("IdJournal");
        f2534g = new bj(C0714a.DOMAIN, (byte) 11, (short) 1);
        f2535h = new bj("old_id", (byte) 11, (short) 2);
        f2536i = new bj("new_id", (byte) 11, (short) 3);
        f2537j = new bj(MsgConstant.KEY_TS, (byte) 10, (short) 4);
        f2538k = new HashMap();
        f2538k.put(bw.class, new C0776b());
        f2538k.put(bx.class, new C0778d());
        Map enumMap = new EnumMap(C0779e.class);
        enumMap.put(C0779e.DOMAIN, new bc(C0714a.DOMAIN, (byte) 1, new bd((byte) 11)));
        enumMap.put(C0779e.OLD_ID, new bc("old_id", (byte) 2, new bd((byte) 11)));
        enumMap.put(C0779e.NEW_ID, new bc("new_id", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0779e.TS, new bc(MsgConstant.KEY_TS, (byte) 1, new bd((byte) 10)));
        f2532e = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ac.class, f2532e);
    }

    public ac() {
        this.f2543l = (byte) 0;
        this.f2544m = new C0779e[]{C0779e.OLD_ID};
    }

    public ac m3102a(long j) {
        this.f2542d = j;
        m3114d(true);
        return this;
    }

    public ac m3103a(String str) {
        this.f2539a = str;
        return this;
    }

    public void m3104a(bm bmVar) {
        ((bv) f2538k.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3105a(boolean z) {
        if (!z) {
            this.f2539a = null;
        }
    }

    public boolean m3106a() {
        return this.f2540b != null;
    }

    public ac m3107b(String str) {
        this.f2540b = str;
        return this;
    }

    public void m3108b(bm bmVar) {
        ((bv) f2538k.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3109b(boolean z) {
        if (!z) {
            this.f2540b = null;
        }
    }

    public boolean m3110b() {
        return au.m3452a(this.f2543l, 0);
    }

    public ac m3111c(String str) {
        this.f2541c = str;
        return this;
    }

    public void m3112c() {
        if (this.f2539a == null) {
            throw new bn("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f2541c == null) {
            throw new bn("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    public void m3113c(boolean z) {
        if (!z) {
            this.f2541c = null;
        }
    }

    public void m3114d(boolean z) {
        this.f2543l = au.m3450a(this.f2543l, 0, z);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.f2539a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2539a);
        }
        if (m3106a()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.f2540b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2540b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.f2541c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2541c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.f2542d);
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
