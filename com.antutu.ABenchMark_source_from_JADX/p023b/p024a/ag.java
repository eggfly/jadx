package p023b.p024a;

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

/* renamed from: b.a.ag */
public class ag implements aw<ag, C0803e>, Serializable, Cloneable {
    public static final Map<C0803e, bc> f2603d;
    private static final bs f2604e;
    private static final bj f2605f;
    private static final bj f2606g;
    private static final bj f2607h;
    private static final Map<Class<? extends bu>, bv> f2608i;
    public String f2609a;
    public long f2610b;
    public String f2611c;
    private byte f2612j;
    private C0803e[] f2613k;

    /* renamed from: b.a.ag.a */
    private static class C0799a extends bw<ag> {
        private C0799a() {
        }

        public void m3205a(bm bmVar, ag agVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (agVar.m3230d()) {
                        agVar.m3232f();
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
                        agVar.f2609a = bmVar.m3521v();
                        agVar.m3224a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != 10) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        agVar.f2610b = bmVar.m3519t();
                        agVar.m3226b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        agVar.f2611c = bmVar.m3521v();
                        agVar.m3229c(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3206a(bm bmVar, aw awVar) {
            m3207b(bmVar, (ag) awVar);
        }

        public void m3207b(bm bmVar, ag agVar) {
            agVar.m3232f();
            bmVar.m3498a(ag.f2604e);
            if (agVar.f2609a != null && agVar.m3227b()) {
                bmVar.m3495a(ag.f2605f);
                bmVar.m3499a(agVar.f2609a);
                bmVar.m3501b();
            }
            bmVar.m3495a(ag.f2606g);
            bmVar.m3494a(agVar.f2610b);
            bmVar.m3501b();
            if (agVar.f2611c != null) {
                bmVar.m3495a(ag.f2607h);
                bmVar.m3499a(agVar.f2611c);
                bmVar.m3501b();
            }
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3208b(bm bmVar, aw awVar) {
            m3205a(bmVar, (ag) awVar);
        }
    }

    /* renamed from: b.a.ag.b */
    private static class C0800b implements bv {
        private C0800b() {
        }

        public C0799a m3209a() {
            return new C0799a();
        }

        public /* synthetic */ bu m3210b() {
            return m3209a();
        }
    }

    /* renamed from: b.a.ag.c */
    private static class C0801c extends bx<ag> {
        private C0801c() {
        }

        public void m3211a(bm bmVar, ag agVar) {
            bt btVar = (bt) bmVar;
            btVar.m3585a(agVar.f2610b);
            btVar.m3590a(agVar.f2611c);
            BitSet bitSet = new BitSet();
            if (agVar.m3227b()) {
                bitSet.set(0);
            }
            btVar.m3623a(bitSet, 1);
            if (agVar.m3227b()) {
                btVar.m3590a(agVar.f2609a);
            }
        }

        public void m3213b(bm bmVar, ag agVar) {
            bt btVar = (bt) bmVar;
            agVar.f2610b = btVar.m3611t();
            agVar.m3226b(true);
            agVar.f2611c = btVar.m3613v();
            agVar.m3229c(true);
            if (btVar.m3624b(1).get(0)) {
                agVar.f2609a = btVar.m3613v();
                agVar.m3224a(true);
            }
        }
    }

    /* renamed from: b.a.ag.d */
    private static class C0802d implements bv {
        private C0802d() {
        }

        public C0801c m3215a() {
            return new C0801c();
        }

        public /* synthetic */ bu m3216b() {
            return m3215a();
        }
    }

    /* renamed from: b.a.ag.e */
    public enum C0803e {
        VALUE((short) 1, "value"),
        TS((short) 2, MsgConstant.KEY_TS),
        GUID((short) 3, "guid");
        
        private static final Map<String, C0803e> f2599d;
        private final short f2601e;
        private final String f2602f;

        static {
            f2599d = new HashMap();
            Iterator it = EnumSet.allOf(C0803e.class).iterator();
            while (it.hasNext()) {
                C0803e c0803e = (C0803e) it.next();
                f2599d.put(c0803e.m3217a(), c0803e);
            }
        }

        private C0803e(short s, String str) {
            this.f2601e = s;
            this.f2602f = str;
        }

        public String m3217a() {
            return this.f2602f;
        }
    }

    static {
        f2604e = new bs("ImprintValue");
        f2605f = new bj("value", (byte) 11, (short) 1);
        f2606g = new bj(MsgConstant.KEY_TS, (byte) 10, (short) 2);
        f2607h = new bj("guid", (byte) 11, (short) 3);
        f2608i = new HashMap();
        f2608i.put(bw.class, new C0800b());
        f2608i.put(bx.class, new C0802d());
        Map enumMap = new EnumMap(C0803e.class);
        enumMap.put(C0803e.VALUE, new bc("value", (byte) 2, new bd((byte) 11)));
        enumMap.put(C0803e.TS, new bc(MsgConstant.KEY_TS, (byte) 1, new bd((byte) 10)));
        enumMap.put(C0803e.GUID, new bc("guid", (byte) 1, new bd((byte) 11)));
        f2603d = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ag.class, f2603d);
    }

    public ag() {
        this.f2612j = (byte) 0;
        this.f2613k = new C0803e[]{C0803e.VALUE};
    }

    public String m3222a() {
        return this.f2609a;
    }

    public void m3223a(bm bmVar) {
        ((bv) f2608i.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3224a(boolean z) {
        if (!z) {
            this.f2609a = null;
        }
    }

    public void m3225b(bm bmVar) {
        ((bv) f2608i.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3226b(boolean z) {
        this.f2612j = au.m3450a(this.f2612j, 0, z);
    }

    public boolean m3227b() {
        return this.f2609a != null;
    }

    public long m3228c() {
        return this.f2610b;
    }

    public void m3229c(boolean z) {
        if (!z) {
            this.f2611c = null;
        }
    }

    public boolean m3230d() {
        return au.m3452a(this.f2612j, 0);
    }

    public String m3231e() {
        return this.f2611c;
    }

    public void m3232f() {
        if (this.f2611c == null) {
            throw new bn("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        Object obj = 1;
        if (m3227b()) {
            stringBuilder.append("value:");
            if (this.f2609a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2609a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.f2610b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.f2611c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2611c);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
