package p023b.p024a;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
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

/* renamed from: b.a.ah */
public class ah implements aw<ah, C0809e>, Serializable, Cloneable {
    public static final Map<C0809e, bc> f2621d;
    private static final bs f2622e;
    private static final bj f2623f;
    private static final bj f2624g;
    private static final bj f2625h;
    private static final Map<Class<? extends bu>, bv> f2626i;
    public int f2627a;
    public String f2628b;
    public af f2629c;
    private byte f2630j;
    private C0809e[] f2631k;

    /* renamed from: b.a.ah.a */
    private static class C0805a extends bw<ah> {
        private C0805a() {
        }

        public void m3233a(bm bmVar, ah ahVar) {
            bmVar.m3505f();
            while (true) {
                bj h = bmVar.m3507h();
                if (h.f2782b == null) {
                    bmVar.m3506g();
                    if (ahVar.m3252a()) {
                        ahVar.m3260f();
                        return;
                    }
                    throw new bn("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
                }
                switch (h.f2783c) {
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        if (h.f2782b != 8) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        ahVar.f2627a = bmVar.m3518s();
                        ahVar.m3251a(true);
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        if (h.f2782b != 11) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        ahVar.f2628b = bmVar.m3521v();
                        ahVar.m3255b(true);
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        if (h.f2782b != 12) {
                            bp.m3616a(bmVar, h.f2782b);
                            break;
                        }
                        ahVar.f2629c = new af();
                        ahVar.f2629c.m3195a(bmVar);
                        ahVar.m3256c(true);
                        break;
                    default:
                        bp.m3616a(bmVar, h.f2782b);
                        break;
                }
                bmVar.m3508i();
            }
        }

        public /* synthetic */ void m3234a(bm bmVar, aw awVar) {
            m3235b(bmVar, (ah) awVar);
        }

        public void m3235b(bm bmVar, ah ahVar) {
            ahVar.m3260f();
            bmVar.m3498a(ah.f2622e);
            bmVar.m3495a(ah.f2623f);
            bmVar.m3493a(ahVar.f2627a);
            bmVar.m3501b();
            if (ahVar.f2628b != null && ahVar.m3257c()) {
                bmVar.m3495a(ah.f2624g);
                bmVar.m3499a(ahVar.f2628b);
                bmVar.m3501b();
            }
            if (ahVar.f2629c != null && ahVar.m3259e()) {
                bmVar.m3495a(ah.f2625h);
                ahVar.f2629c.m3197b(bmVar);
                bmVar.m3501b();
            }
            bmVar.m3502c();
            bmVar.m3492a();
        }

        public /* synthetic */ void m3236b(bm bmVar, aw awVar) {
            m3233a(bmVar, (ah) awVar);
        }
    }

    /* renamed from: b.a.ah.b */
    private static class C0806b implements bv {
        private C0806b() {
        }

        public C0805a m3237a() {
            return new C0805a();
        }

        public /* synthetic */ bu m3238b() {
            return m3237a();
        }
    }

    /* renamed from: b.a.ah.c */
    private static class C0807c extends bx<ah> {
        private C0807c() {
        }

        public void m3239a(bm bmVar, ah ahVar) {
            bmVar = (bt) bmVar;
            bmVar.m3584a(ahVar.f2627a);
            BitSet bitSet = new BitSet();
            if (ahVar.m3257c()) {
                bitSet.set(0);
            }
            if (ahVar.m3259e()) {
                bitSet.set(1);
            }
            bmVar.m3623a(bitSet, 2);
            if (ahVar.m3257c()) {
                bmVar.m3590a(ahVar.f2628b);
            }
            if (ahVar.m3259e()) {
                ahVar.f2629c.m3197b(bmVar);
            }
        }

        public void m3241b(bm bmVar, ah ahVar) {
            bmVar = (bt) bmVar;
            ahVar.f2627a = bmVar.m3610s();
            ahVar.m3251a(true);
            BitSet b = bmVar.m3624b(2);
            if (b.get(0)) {
                ahVar.f2628b = bmVar.m3613v();
                ahVar.m3255b(true);
            }
            if (b.get(1)) {
                ahVar.f2629c = new af();
                ahVar.f2629c.m3195a(bmVar);
                ahVar.m3256c(true);
            }
        }
    }

    /* renamed from: b.a.ah.d */
    private static class C0808d implements bv {
        private C0808d() {
        }

        public C0807c m3243a() {
            return new C0807c();
        }

        public /* synthetic */ bu m3244b() {
            return m3243a();
        }
    }

    /* renamed from: b.a.ah.e */
    public enum C0809e {
        RESP_CODE((short) 1, "resp_code"),
        MSG((short) 2, XAdErrorCode.ERROR_CODE_MESSAGE),
        IMPRINT((short) 3, "imprint");
        
        private static final Map<String, C0809e> f2617d;
        private final short f2619e;
        private final String f2620f;

        static {
            f2617d = new HashMap();
            Iterator it = EnumSet.allOf(C0809e.class).iterator();
            while (it.hasNext()) {
                C0809e c0809e = (C0809e) it.next();
                f2617d.put(c0809e.m3245a(), c0809e);
            }
        }

        private C0809e(short s, String str) {
            this.f2619e = s;
            this.f2620f = str;
        }

        public String m3245a() {
            return this.f2620f;
        }
    }

    static {
        f2622e = new bs("Response");
        f2623f = new bj("resp_code", (byte) 8, (short) 1);
        f2624g = new bj(XAdErrorCode.ERROR_CODE_MESSAGE, (byte) 11, (short) 2);
        f2625h = new bj("imprint", (byte) 12, (short) 3);
        f2626i = new HashMap();
        f2626i.put(bw.class, new C0806b());
        f2626i.put(bx.class, new C0808d());
        Map enumMap = new EnumMap(C0809e.class);
        enumMap.put(C0809e.RESP_CODE, new bc("resp_code", (byte) 1, new bd((byte) 8)));
        enumMap.put(C0809e.MSG, new bc(XAdErrorCode.ERROR_CODE_MESSAGE, (byte) 2, new bd((byte) 11)));
        enumMap.put(C0809e.IMPRINT, new bc("imprint", (byte) 2, new bg((byte) 12, af.class)));
        f2621d = Collections.unmodifiableMap(enumMap);
        bc.m3489a(ah.class, f2621d);
    }

    public ah() {
        this.f2630j = (byte) 0;
        this.f2631k = new C0809e[]{C0809e.MSG, C0809e.IMPRINT};
    }

    public void m3250a(bm bmVar) {
        ((bv) f2626i.get(bmVar.m3524y())).m3085b().m3080b(bmVar, this);
    }

    public void m3251a(boolean z) {
        this.f2630j = au.m3450a(this.f2630j, 0, z);
    }

    public boolean m3252a() {
        return au.m3452a(this.f2630j, 0);
    }

    public String m3253b() {
        return this.f2628b;
    }

    public void m3254b(bm bmVar) {
        ((bv) f2626i.get(bmVar.m3524y())).m3085b().m3079a(bmVar, this);
    }

    public void m3255b(boolean z) {
        if (!z) {
            this.f2628b = null;
        }
    }

    public void m3256c(boolean z) {
        if (!z) {
            this.f2629c = null;
        }
    }

    public boolean m3257c() {
        return this.f2628b != null;
    }

    public af m3258d() {
        return this.f2629c;
    }

    public boolean m3259e() {
        return this.f2629c != null;
    }

    public void m3260f() {
        if (this.f2629c != null) {
            this.f2629c.m3204f();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.f2627a);
        if (m3257c()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.f2628b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2628b);
            }
        }
        if (m3259e()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.f2629c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.f2629c);
            }
        }
        stringBuilder.append(C4233j.f14397t);
        return stringBuilder.toString();
    }
}
