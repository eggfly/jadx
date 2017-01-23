package p023b.p024a;

import com.igexin.download.Downloads;
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

/* renamed from: b.a.ai */
public class ai implements aw<ai, C0815e>, Serializable, Cloneable {
    public static final Map<C0815e, bc> f2646k;
    private static final bs f2647l;
    private static final bj f2648m;
    private static final bj f2649n;
    private static final bj f2650o;
    private static final bj f2651p;
    private static final bj f2652q;
    private static final bj f2653r;
    private static final bj f2654s;
    private static final bj f2655t;
    private static final bj f2656u;
    private static final bj f2657v;
    private static final Map<Class<? extends bu>, bv> f2658w;
    public String f2659a;
    public String f2660b;
    public String f2661c;
    public int f2662d;
    public int f2663e;
    public int f2664f;
    public ByteBuffer f2665g;
    public String f2666h;
    public String f2667i;
    public int f2668j;
    private byte f2669x;
    private C0815e[] f2670y;

    /* renamed from: b.a.ai.a */
    private static class C0811a extends bw<ai> {
        private C0811a() {
        }

        public void m3261a(bm bmVar, ai aiVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (!aiVar.m3291a()) {
                        throw new bn("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    } else if (!aiVar.m3296b()) {
                        throw new bn("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    } else if (aiVar.m3300c()) {
                        aiVar.m3306e();
                        return;
                    } else {
                        throw new bn("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                }
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2659a = bmVar.m3521v();
                        aiVar.m3290a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2660b = bmVar.m3521v();
                        aiVar.m3295b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2661c = bmVar.m3521v();
                        aiVar.m3299c(true);
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        if (h.f2782b != (byte) 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2662d = bmVar.m3518s();
                        aiVar.m3303d(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        if (h.f2782b != (byte) 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2663e = bmVar.m3518s();
                        aiVar.m3307e(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                        if (h.f2782b != (byte) 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2664f = bmVar.m3518s();
                        aiVar.m3308f(true);
                        break;
                    case SpdyProtocol.PUBKEY_PSEQ_ARUP /*7*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2665g = bmVar.m3522w();
                        aiVar.m3309g(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2666h = bmVar.m3521v();
                        aiVar.m3310h(true);
                        break;
                    case SpdyProtocol.PUBKEY_PSEQ_ADASH /*9*/:
                        if (h.f2782b != (byte) 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2667i = bmVar.m3521v();
                        aiVar.m3311i(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                        if (h.f2782b != (byte) 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        aiVar.f2668j = bmVar.m3518s();
                        aiVar.m3312j(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3262a(bm bmVar, aw awVar) {
            m3263b(bmVar, (ai) awVar);
        }

        public void m3263b(bm bmVar, ai aiVar) {
            aiVar.m3306e();
            bmVar.m3498a(ai.f2647l);
            if (aiVar.f2659a != null) {
                bmVar.m3495a(ai.f2648m);
                bmVar.m3499a(aiVar.f2659a);
                bmVar.m3501b();
            }
            if (aiVar.f2660b != null) {
                bmVar.m3495a(ai.f2649n);
                bmVar.m3499a(aiVar.f2660b);
                bmVar.m3501b();
            }
            if (aiVar.f2661c != null) {
                bmVar.m3495a(ai.f2650o);
                bmVar.m3499a(aiVar.f2661c);
                bmVar.m3501b();
            }
            bmVar.m3495a(ai.f2651p);
            bmVar.m3493a(aiVar.f2662d);
            bmVar.m3501b();
            bmVar.m3495a(ai.f2652q);
            bmVar.m3493a(aiVar.f2663e);
            bmVar.m3501b();
            bmVar.m3495a(ai.f2653r);
            bmVar.m3493a(aiVar.f2664f);
            bmVar.m3501b();
            if (aiVar.f2665g != null) {
                bmVar.m3495a(ai.f2654s);
                bmVar.m3500a(aiVar.f2665g);
                bmVar.m3501b();
            }
            if (aiVar.f2666h != null) {
                bmVar.m3495a(ai.f2655t);
                bmVar.m3499a(aiVar.f2666h);
                bmVar.m3501b();
            }
            if (aiVar.f2667i != null) {
                bmVar.m3495a(ai.f2656u);
                bmVar.m3499a(aiVar.f2667i);
                bmVar.m3501b();
            }
            if (aiVar.m3304d()) {
                bmVar.m3495a(ai.f2657v);
                bmVar.m3493a(aiVar.f2668j);
                bmVar.m3501b();
            }
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3264b(bm bmVar, aw awVar) {
            m3261a(bmVar, (ai) awVar);
        }
    }

    /* renamed from: b.a.ai.b */
    private static class C0812b implements bv {
        private C0812b() {
        }

        public C0811a m3265a() {
            return new C0811a();
        }

        public /* synthetic */ bu m3266b() {
            return m3265a();
        }
    }

    /* renamed from: b.a.ai.c */
    private static class C0813c extends bx<ai> {
        private C0813c() {
        }

        public void m3267a(bm bmVar, ai aiVar) {
            bt btVar = (bt) bmVar;
            btVar.m3590a(aiVar.f2659a);
            btVar.m3590a(aiVar.f2660b);
            btVar.m3590a(aiVar.f2661c);
            btVar.m3584a(aiVar.f2662d);
            btVar.m3584a(aiVar.f2663e);
            btVar.m3584a(aiVar.f2664f);
            btVar.m3591a(aiVar.f2665g);
            btVar.m3590a(aiVar.f2666h);
            btVar.m3590a(aiVar.f2667i);
            BitSet bitSet = new BitSet();
            if (aiVar.m3304d()) {
                bitSet.set(0);
            }
            btVar.m3623a(bitSet, 1);
            if (aiVar.m3304d()) {
                btVar.m3584a(aiVar.f2668j);
            }
        }

        public void m3269b(bm bmVar, ai aiVar) {
            bt btVar = (bt) bmVar;
            aiVar.f2659a = btVar.m3613v();
            aiVar.m3290a(true);
            aiVar.f2660b = btVar.m3613v();
            aiVar.m3295b(true);
            aiVar.f2661c = btVar.m3613v();
            aiVar.m3299c(true);
            aiVar.f2662d = btVar.m3610s();
            aiVar.m3303d(true);
            aiVar.f2663e = btVar.m3610s();
            aiVar.m3307e(true);
            aiVar.f2664f = btVar.m3610s();
            aiVar.m3308f(true);
            aiVar.f2665g = btVar.m3614w();
            aiVar.m3309g(true);
            aiVar.f2666h = btVar.m3613v();
            aiVar.m3310h(true);
            aiVar.f2667i = btVar.m3613v();
            aiVar.m3311i(true);
            if (btVar.m3624b(1).get(0)) {
                aiVar.f2668j = btVar.m3610s();
                aiVar.m3312j(true);
            }
        }
    }

    /* renamed from: b.a.ai.d */
    private static class C0814d implements bv {
        private C0814d() {
        }

        public C0813c m3271a() {
            return new C0813c();
        }

        public /* synthetic */ bu m3272b() {
            return m3271a();
        }
    }

    /* renamed from: b.a.ai.e */
    public enum C0815e {
        VERSION((short) 1, Constants.SP_KEY_VERSION),
        ADDRESS((short) 2, "address"),
        SIGNATURE((short) 3, "signature"),
        SERIAL_NUM((short) 4, "serial_num"),
        TS_SECS((short) 5, "ts_secs"),
        LENGTH((short) 6, "length"),
        ENTITY((short) 7, Downloads.COLUMN_APP_DATA),
        GUID((short) 8, "guid"),
        CHECKSUM((short) 9, "checksum"),
        CODEX((short) 10, "codex");
        
        private static final Map<String, C0815e> f2642k;
        private final short f2644l;
        private final String f2645m;

        static {
            f2642k = new HashMap();
            Iterator it = EnumSet.allOf(C0815e.class).iterator();
            while (it.hasNext()) {
                C0815e c0815e = (C0815e) it.next();
                f2642k.put(c0815e.m3273a(), c0815e);
            }
        }

        private C0815e(short s, String str) {
            this.f2644l = s;
            this.f2645m = str;
        }

        public String m3273a() {
            return this.f2645m;
        }
    }

    static {
        f2647l = new bs("UMEnvelope");
        f2648m = new bj(Constants.SP_KEY_VERSION, (byte) 11, (short) 1);
        f2649n = new bj("address", (byte) 11, (short) 2);
        f2650o = new bj("signature", (byte) 11, (short) 3);
        f2651p = new bj("serial_num", (byte) 8, (short) 4);
        f2652q = new bj("ts_secs", (byte) 8, (short) 5);
        f2653r = new bj("length", (byte) 8, (short) 6);
        f2654s = new bj(Downloads.COLUMN_APP_DATA, (byte) 11, (short) 7);
        f2655t = new bj("guid", (byte) 11, (short) 8);
        f2656u = new bj("checksum", (byte) 11, (short) 9);
        f2657v = new bj("codex", (byte) 8, (short) 10);
        f2658w = new HashMap();
        f2658w.put(bw.class, new C0812b());
        f2658w.put(bx.class, new C0814d());
        Map enumMap = new EnumMap(C0815e.class);
        enumMap.put(C0815e.VERSION, new bc(Constants.SP_KEY_VERSION, (byte) 1, new bd((byte) 11)));
        enumMap.put(C0815e.ADDRESS, new bc("address", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0815e.SIGNATURE, new bc("signature", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0815e.SERIAL_NUM, new bc("serial_num", (byte) 1, new bd((byte) 8)));
        enumMap.put(C0815e.TS_SECS, new bc("ts_secs", (byte) 1, new bd((byte) 8)));
        enumMap.put(C0815e.LENGTH, new bc("length", (byte) 1, new bd((byte) 8)));
        enumMap.put(C0815e.ENTITY, new bc(Downloads.COLUMN_APP_DATA, (byte) 1, new bd((byte) 11, true)));
        enumMap.put(C0815e.GUID, new bc("guid", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0815e.CHECKSUM, new bc("checksum", (byte) 1, new bd((byte) 11)));
        enumMap.put(C0815e.CODEX, new bc("codex", (byte) 2, new bd((byte) 8)));
        f2646k = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ai.class, f2646k);
    }

    public ai() {
        this.f2669x = (byte) 0;
        this.f2670y = new C0815e[]{C0815e.CODEX};
    }

    public ai m3285a(int i) {
        this.f2662d = i;
        m3303d(true);
        return this;
    }

    public ai m3286a(String str) {
        this.f2659a = str;
        return this;
    }

    public ai m3287a(ByteBuffer byteBuffer) {
        this.f2665g = byteBuffer;
        return this;
    }

    public ai m3288a(byte[] bArr) {
        m3287a(bArr == null ? (ByteBuffer) null : ByteBuffer.wrap(bArr));
        return this;
    }

    public void m3289a(bm bmVar) {
        ((bv) f2658w.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3290a(boolean z) {
        if (!z) {
            this.f2659a = null;
        }
    }

    public boolean m3291a() {
        return au.m3452a(this.f2669x, 0);
    }

    public ai m3292b(int i) {
        this.f2663e = i;
        m3307e(true);
        return this;
    }

    public ai m3293b(String str) {
        this.f2660b = str;
        return this;
    }

    public void m3294b(bm bmVar) {
        ((bv) f2658w.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3295b(boolean z) {
        if (!z) {
            this.f2660b = null;
        }
    }

    public boolean m3296b() {
        return au.m3452a(this.f2669x, 1);
    }

    public ai m3297c(int i) {
        this.f2664f = i;
        m3308f(true);
        return this;
    }

    public ai m3298c(String str) {
        this.f2661c = str;
        return this;
    }

    public void m3299c(boolean z) {
        if (!z) {
            this.f2661c = null;
        }
    }

    public boolean m3300c() {
        return au.m3452a(this.f2669x, 2);
    }

    public ai m3301d(int i) {
        this.f2668j = i;
        m3312j(true);
        return this;
    }

    public ai m3302d(String str) {
        this.f2666h = str;
        return this;
    }

    public void m3303d(boolean z) {
        this.f2669x = au.m3450a(this.f2669x, 0, z);
    }

    public boolean m3304d() {
        return au.m3452a(this.f2669x, 3);
    }

    public ai m3305e(String str) {
        this.f2667i = str;
        return this;
    }

    public void m3306e() {
        if (this.f2659a == null) {
            throw new bn("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f2660b == null) {
            throw new bn("Required field 'address' was not present! Struct: " + toString());
        } else if (this.f2661c == null) {
            throw new bn("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.f2665g == null) {
            throw new bn("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.f2666h == null) {
            throw new bn("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.f2667i == null) {
            throw new bn("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public void m3307e(boolean z) {
        this.f2669x = au.m3450a(this.f2669x, 1, z);
    }

    public void m3308f(boolean z) {
        this.f2669x = au.m3450a(this.f2669x, 2, z);
    }

    public void m3309g(boolean z) {
        if (!z) {
            this.f2665g = null;
        }
    }

    public void m3310h(boolean z) {
        if (!z) {
            this.f2666h = null;
        }
    }

    public void m3311i(boolean z) {
        if (!z) {
            this.f2667i = null;
        }
    }

    public void m3312j(boolean z) {
        this.f2669x = au.m3450a(this.f2669x, 3, z);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMEnvelope(");
        stringBuilder.append("version:");
        if (this.f2659a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2659a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("address:");
        if (this.f2660b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2660b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("signature:");
        if (this.f2661c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2661c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("serial_num:");
        stringBuilder.append(this.f2662d);
        stringBuilder.append(", ");
        stringBuilder.append("ts_secs:");
        stringBuilder.append(this.f2663e);
        stringBuilder.append(", ");
        stringBuilder.append("length:");
        stringBuilder.append(this.f2664f);
        stringBuilder.append(", ");
        stringBuilder.append("entity:");
        if (this.f2665g == null) {
            stringBuilder.append("null");
        } else {
            ax.m3467a(this.f2665g, stringBuilder);
        }
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.f2666h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2666h);
        }
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.f2667i == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2667i);
        }
        if (m3304d()) {
            stringBuilder.append(", ");
            stringBuilder.append("codex:");
            stringBuilder.append(this.f2668j);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
