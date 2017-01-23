package p023b.p024a;

import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

/* renamed from: b.a.af */
public class af implements aw<af, C0797e>, Serializable, Cloneable {
    public static final Map<C0797e, bc> f2586d;
    private static final bs f2587e;
    private static final bj f2588f;
    private static final bj f2589g;
    private static final bj f2590h;
    private static final Map<Class<? extends bu>, bv> f2591i;
    public Map<String, ag> f2592a;
    public int f2593b;
    public String f2594c;
    private byte f2595j;

    /* renamed from: b.a.af.a */
    private static class C0793a extends bw<af> {
        private C0793a() {
        }

        public void m3175a(bm bmVar, af afVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (afVar.m3202d()) {
                        afVar.m3204f();
                        return;
                    }
                    throw new bn("Required field 'version' was not found in serialized data! Struct: " + toString());
                }
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != 13) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        bl j = bmVar.m3509j();
                        afVar.f2592a = new HashMap(j.f2788c * 2);
                        for (int i = 0; i < j.f2788c; i++) {
                            String v = bmVar.m3521v();
                            ag agVar = new ag();
                            agVar.m3223a(bmVar);
                            afVar.f2592a.put(v, agVar);
                        }
                        bmVar.m3510k();
                        afVar.m3196a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        afVar.f2593b = bmVar.m3518s();
                        afVar.m3198b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        afVar.f2594c = bmVar.m3521v();
                        afVar.m3201c(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3176a(bm bmVar, aw awVar) {
            m3177b(bmVar, (af) awVar);
        }

        public void m3177b(bm bmVar, af afVar) {
            afVar.m3204f();
            bmVar.m3498a(af.f2587e);
            if (afVar.f2592a != null) {
                bmVar.m3495a(af.f2588f);
                bmVar.m3497a(new bl((byte) 11, (byte) 12, afVar.f2592a.size()));
                for (Entry entry : afVar.f2592a.entrySet()) {
                    bmVar.m3499a((String) entry.getKey());
                    ((ag) entry.getValue()).m3225b(bmVar);
                }
                bmVar.m3503d();
                bmVar.m3501b();
            }
            bmVar.m3495a(af.f2589g);
            bmVar.m3493a(afVar.f2593b);
            bmVar.m3501b();
            if (afVar.f2594c != null) {
                bmVar.m3495a(af.f2590h);
                bmVar.m3499a(afVar.f2594c);
                bmVar.m3501b();
            }
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3178b(bm bmVar, aw awVar) {
            m3175a(bmVar, (af) awVar);
        }
    }

    /* renamed from: b.a.af.b */
    private static class C0794b implements bv {
        private C0794b() {
        }

        public C0793a m3179a() {
            return new C0793a();
        }

        public /* synthetic */ bu m3180b() {
            return m3179a();
        }
    }

    /* renamed from: b.a.af.c */
    private static class C0795c extends bx<af> {
        private C0795c() {
        }

        public void m3181a(bm bmVar, af afVar) {
            bmVar = (bt) bmVar;
            bmVar.m3584a(afVar.f2592a.size());
            for (Entry entry : afVar.f2592a.entrySet()) {
                bmVar.m3590a((String) entry.getKey());
                ((ag) entry.getValue()).m3225b(bmVar);
            }
            bmVar.m3584a(afVar.f2593b);
            bmVar.m3590a(afVar.f2594c);
        }

        public void m3183b(bm bmVar, af afVar) {
            bmVar = (bt) bmVar;
            bl blVar = new bl((byte) 11, (byte) 12, bmVar.m3610s());
            afVar.f2592a = new HashMap(blVar.f2788c * 2);
            for (int i = 0; i < blVar.f2788c; i++) {
                String v = bmVar.m3613v();
                ag agVar = new ag();
                agVar.m3223a(bmVar);
                afVar.f2592a.put(v, agVar);
            }
            afVar.m3196a(true);
            afVar.f2593b = bmVar.m3610s();
            afVar.m3198b(true);
            afVar.f2594c = bmVar.m3613v();
            afVar.m3201c(true);
        }
    }

    /* renamed from: b.a.af.d */
    private static class C0796d implements bv {
        private C0796d() {
        }

        public C0795c m3185a() {
            return new C0795c();
        }

        public /* synthetic */ bu m3186b() {
            return m3185a();
        }
    }

    /* renamed from: b.a.af.e */
    public enum C0797e {
        PROPERTY((short) 1, "property"),
        VERSION((short) 2, Constants.SP_KEY_VERSION),
        CHECKSUM((short) 3, "checksum");
        
        private static final Map<String, C0797e> f2582d;
        private final short f2584e;
        private final String f2585f;

        static {
            f2582d = new HashMap();
            Iterator it = EnumSet.allOf(C0797e.class).iterator();
            while (it.hasNext()) {
                C0797e c0797e = (C0797e) it.next();
                f2582d.put(c0797e.m3187a(), c0797e);
            }
        }

        private C0797e(short s, String str) {
            this.f2584e = s;
            this.f2585f = str;
        }

        public String m3187a() {
            return this.f2585f;
        }
    }

    static {
        f2587e = new bs("Imprint");
        f2588f = new bj("property", (byte) 13, (short) 1);
        f2589g = new bj(Constants.SP_KEY_VERSION, (byte) 8, (short) 2);
        f2590h = new bj("checksum", (byte) 11, (short) 3);
        f2591i = new HashMap();
        f2591i.put(bw.class, new C0794b());
        f2591i.put(bx.class, new C0796d());
        Map enumMap = new EnumMap(C0797e.class);
        enumMap.put(C0797e.PROPERTY, new bc("property", (byte) 1, new bf((byte) 13, new bd((byte) 11), new bg((byte) 12, ag.class))));
        enumMap.put(C0797e.VERSION, new bc(Constants.SP_KEY_VERSION, (byte) 1, new bd((byte) 8)));
        enumMap.put(C0797e.CHECKSUM, new bc("checksum", (byte) 1, new bd((byte) 11)));
        f2586d = Collections.unmodifiableMap(enumMap);
        bc.m3489a(af.class, f2586d);
    }

    public af() {
        this.f2595j = (byte) 0;
    }

    public af m3192a(int i) {
        this.f2593b = i;
        m3198b(true);
        return this;
    }

    public af m3193a(String str) {
        this.f2594c = str;
        return this;
    }

    public Map<String, ag> m3194a() {
        return this.f2592a;
    }

    public void m3195a(bm bmVar) {
        ((bv) f2591i.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3196a(boolean z) {
        if (!z) {
            this.f2592a = null;
        }
    }

    public void m3197b(bm bmVar) {
        ((bv) f2591i.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3198b(boolean z) {
        this.f2595j = au.m3450a(this.f2595j, 0, z);
    }

    public boolean m3199b() {
        return this.f2592a != null;
    }

    public int m3200c() {
        return this.f2593b;
    }

    public void m3201c(boolean z) {
        if (!z) {
            this.f2594c = null;
        }
    }

    public boolean m3202d() {
        return au.m3452a(this.f2595j, 0);
    }

    public String m3203e() {
        return this.f2594c;
    }

    public void m3204f() {
        if (this.f2592a == null) {
            throw new bn("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f2594c == null) {
            throw new bn("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.f2592a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2592a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.f2593b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.f2594c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.f2594c);
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
