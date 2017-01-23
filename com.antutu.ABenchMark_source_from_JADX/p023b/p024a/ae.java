package p023b.p024a;

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
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.ae */
public class ae implements aw<ae, C0791e>, Serializable, Cloneable {
    public static final Map<C0791e, bc> f2569d;
    private static final bs f2570e;
    private static final bj f2571f;
    private static final bj f2572g;
    private static final bj f2573h;
    private static final Map<Class<? extends bu>, bv> f2574i;
    public Map<String, ad> f2575a;
    public List<ac> f2576b;
    public String f2577c;
    private C0791e[] f2578j;

    /* renamed from: b.a.ae.a */
    private static class C0787a extends bw<ae> {
        private C0787a() {
        }

        public void m3146a(bm bmVar, ae aeVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    aeVar.m3174e();
                    return;
                }
                int i;
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != 13) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        bl j = bmVar.m3509j();
                        aeVar.f2575a = new HashMap(j.f2788c * 2);
                        for (i = 0; i < j.f2788c; i++) {
                            String v = bmVar.m3521v();
                            ad adVar = new ad();
                            adVar.m3136a(bmVar);
                            aeVar.f2575a.put(v, adVar);
                        }
                        bmVar.m3510k();
                        aeVar.m3167a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != 15) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        bk l = bmVar.m3511l();
                        aeVar.f2576b = new ArrayList(l.f2785b);
                        for (i = 0; i < l.f2785b; i++) {
                            ac acVar = new ac();
                            acVar.m3104a(bmVar);
                            aeVar.f2576b.add(acVar);
                        }
                        bmVar.m3512m();
                        aeVar.m3170b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aeVar.f2577c = bmVar.m3521v();
                        aeVar.m3171c(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3147a(bm bmVar, aw awVar) {
            m3148b(bmVar, (ae) awVar);
        }

        public void m3148b(bm bmVar, ae aeVar) {
            aeVar.m3174e();
            bmVar.m3498a(ae.f2570e);
            if (aeVar.f2575a != null) {
                bmVar.m3495a(ae.f2571f);
                bmVar.m3497a(new bl((byte) 11, (byte) 12, aeVar.f2575a.size()));
                for (Entry entry : aeVar.f2575a.entrySet()) {
                    bmVar.m3499a((String) entry.getKey());
                    ((ad) entry.getValue()).m3139b(bmVar);
                }
                bmVar.m3503d();
                bmVar.m3501b();
            }
            if (aeVar.f2576b != null && aeVar.m3172c()) {
                bmVar.m3495a(ae.f2572g);
                bmVar.m3496a(new bk((byte) 12, aeVar.f2576b.size()));
                for (ac b : aeVar.f2576b) {
                    b.m3108b(bmVar);
                }
                bmVar.m3504e();
                bmVar.m3501b();
            }
            if (aeVar.f2577c != null && aeVar.m3173d()) {
                bmVar.m3495a(ae.f2573h);
                bmVar.m3499a(aeVar.f2577c);
                bmVar.m3501b();
            }
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3149b(bm bmVar, aw awVar) {
            m3146a(bmVar, (ae) awVar);
        }
    }

    /* renamed from: b.a.ae.b */
    private static class C0788b implements bv {
        private C0788b() {
        }

        public C0787a m3150a() {
            return new C0787a();
        }

        public /* synthetic */ bu m3151b() {
            return m3150a();
        }
    }

    /* renamed from: b.a.ae.c */
    private static class C0789c extends bx<ae> {
        private C0789c() {
        }

        public void m3152a(bm bmVar, ae aeVar) {
            bmVar = (bt) bmVar;
            bmVar.m3584a(aeVar.f2575a.size());
            for (Entry entry : aeVar.f2575a.entrySet()) {
                bmVar.m3590a((String) entry.getKey());
                ((ad) entry.getValue()).m3139b(bmVar);
            }
            BitSet bitSet = new BitSet();
            if (aeVar.m3172c()) {
                bitSet.set(0);
            }
            if (aeVar.m3173d()) {
                bitSet.set(1);
            }
            bmVar.m3623a(bitSet, 2);
            if (aeVar.m3172c()) {
                bmVar.m3584a(aeVar.f2576b.size());
                for (ac b : aeVar.f2576b) {
                    b.m3108b(bmVar);
                }
            }
            if (aeVar.m3173d()) {
                bmVar.m3590a(aeVar.f2577c);
            }
        }

        public void m3154b(bm bmVar, ae aeVar) {
            int i = 0;
            bmVar = (bt) bmVar;
            bl blVar = new bl((byte) 11, (byte) 12, bmVar.m3610s());
            aeVar.f2575a = new HashMap(blVar.f2788c * 2);
            for (int i2 = 0; i2 < blVar.f2788c; i2++) {
                String v = bmVar.m3613v();
                ad adVar = new ad();
                adVar.m3136a(bmVar);
                aeVar.f2575a.put(v, adVar);
            }
            aeVar.m3167a(true);
            BitSet b = bmVar.m3624b(2);
            if (b.get(0)) {
                bk bkVar = new bk((byte) 12, bmVar.m3610s());
                aeVar.f2576b = new ArrayList(bkVar.f2785b);
                while (i < bkVar.f2785b) {
                    ac acVar = new ac();
                    acVar.m3104a(bmVar);
                    aeVar.f2576b.add(acVar);
                    i++;
                }
                aeVar.m3170b(true);
            }
            if (b.get(1)) {
                aeVar.f2577c = bmVar.m3613v();
                aeVar.m3171c(true);
            }
        }
    }

    /* renamed from: b.a.ae.d */
    private static class C0790d implements bv {
        private C0790d() {
        }

        public C0789c m3156a() {
            return new C0789c();
        }

        public /* synthetic */ bu m3157b() {
            return m3156a();
        }
    }

    /* renamed from: b.a.ae.e */
    public enum C0791e {
        SNAPSHOTS((short) 1, "snapshots"),
        JOURNALS((short) 2, "journals"),
        CHECKSUM((short) 3, "checksum");
        
        private static final Map<String, C0791e> f2565d;
        private final short f2567e;
        private final String f2568f;

        static {
            f2565d = new HashMap();
            Iterator it = EnumSet.allOf(C0791e.class).iterator();
            while (it.hasNext()) {
                C0791e c0791e = (C0791e) it.next();
                f2565d.put(c0791e.m3158a(), c0791e);
            }
        }

        private C0791e(short s, String str) {
            this.f2567e = s;
            this.f2568f = str;
        }

        public String m3158a() {
            return this.f2568f;
        }
    }

    static {
        f2570e = new bs("IdTracking");
        f2571f = new bj("snapshots", (byte) 13, (short) 1);
        f2572g = new bj("journals", (byte) 15, (short) 2);
        f2573h = new bj("checksum", (byte) 11, (short) 3);
        f2574i = new HashMap();
        f2574i.put(bw.class, new C0788b());
        f2574i.put(bx.class, new C0790d());
        Map enumMap = new EnumMap(C0791e.class);
        enumMap.put(C0791e.SNAPSHOTS, new bc("snapshots", (byte) 1, new bf((byte) 13, new bd((byte) 11), new bg((byte) 12, ad.class))));
        enumMap.put(C0791e.JOURNALS, new bc("journals", (byte) 2, new be((byte) 15, new bg((byte) 12, ac.class))));
        enumMap.put(C0791e.CHECKSUM, new bc("checksum", (byte) 2, new bd((byte) 11)));
        f2569d = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ae.class, f2569d);
    }

    public ae() {
        this.f2578j = new C0791e[]{C0791e.JOURNALS, C0791e.CHECKSUM};
    }

    public ae m3163a(List<ac> list) {
        this.f2576b = list;
        return this;
    }

    public ae m3164a(Map<String, ad> map) {
        this.f2575a = map;
        return this;
    }

    public Map<String, ad> m3165a() {
        return this.f2575a;
    }

    public void m3166a(bm bmVar) {
        ((bv) f2574i.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3167a(boolean z) {
        if (!z) {
            this.f2575a = null;
        }
    }

    public List<ac> m3168b() {
        return this.f2576b;
    }

    public void m3169b(bm bmVar) {
        ((bv) f2574i.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3170b(boolean z) {
        if (!z) {
            this.f2576b = null;
        }
    }

    public void m3171c(boolean z) {
        if (!z) {
            this.f2577c = null;
        }
    }

    public boolean m3172c() {
        return this.f2576b != null;
    }

    public boolean m3173d() {
        return this.f2577c != null;
    }

    public void m3174e() {
        if (this.f2575a == null) {
            throw new bn("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.f2575a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2575a);
        }
        if (m3172c()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.f2576b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2576b);
            }
        }
        if (m3173d()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
            if (this.f2577c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2577c);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
