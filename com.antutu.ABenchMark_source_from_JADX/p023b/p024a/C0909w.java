package p023b.p024a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.message.common.C4210b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: b.a.w */
public class C0909w implements Serializable {
    public static long f3093c;
    public C0906m f3094a;
    public C0905l f3095b;

    /* renamed from: b.a.w.a */
    public static class C0894a implements Serializable {
        public long f2990a;

        public C0894a() {
            this.f2990a = 0;
        }
    }

    /* renamed from: b.a.w.b */
    public static class C0895b implements Serializable {
        public String f2991a;
        public String f2992b;

        public C0895b() {
            this.f2991a = null;
            this.f2992b = null;
        }
    }

    /* renamed from: b.a.w.c */
    public static class C0896c implements Serializable {
        public Map<String, List<C0897d>> f2993a;
        public Map<String, List<C0898e>> f2994b;

        public C0896c() {
            this.f2993a = new HashMap();
            this.f2994b = new HashMap();
        }
    }

    /* renamed from: b.a.w.d */
    public static class C0897d implements Serializable {
        public long f2995a;
        public long f2996b;
        public int f2997c;
        public int f2998d;
        public List<String> f2999e;

        public C0897d() {
            this.f2995a = 0;
            this.f2996b = 0;
            this.f2997c = 0;
            this.f2998d = 0;
            this.f2999e = new ArrayList();
        }
    }

    /* renamed from: b.a.w.e */
    public static final class C0898e implements Serializable {
        public int f3000a;
        public long f3001b;
        public String f3002c;

        public C0898e() {
            this.f3000a = 0;
            this.f3001b = 0;
            this.f3002c = null;
        }
    }

    /* renamed from: b.a.w.f */
    public static class C0899f implements Serializable {
        public Integer f3003a;
        public long f3004b;
        public boolean f3005c;

        public C0899f() {
            this.f3003a = Integer.valueOf(0);
            this.f3004b = 0;
            this.f3005c = false;
        }
    }

    /* renamed from: b.a.w.g */
    public static class C0900g implements Serializable {
        public String f3006a;
        public List<C0902i> f3007b;

        public C0900g() {
            this.f3006a = null;
            this.f3007b = new ArrayList();
        }
    }

    /* renamed from: b.a.w.h */
    public static class C0901h implements C0882k, Serializable {
        public long f3008a;
        public long f3009b;
        public String f3010c;

        public C0901h() {
            this.f3008a = 0;
            this.f3009b = 0;
            this.f3010c = null;
        }

        public void m3979a(C0909w c0909w) {
            if (c0909w.f3095b.f3033i != null) {
                c0909w.f3095b.f3033i.add(this);
            }
        }
    }

    /* renamed from: b.a.w.i */
    public static class C0902i implements C0882k, Serializable {
        public int f3011a;
        public String f3012b;
        public String f3013c;
        public long f3014d;
        public long f3015e;
        public int f3016f;
        public Map<String, Object> f3017g;

        public C0902i() {
            this.f3011a = 0;
            this.f3012b = null;
            this.f3013c = null;
            this.f3014d = 0;
            this.f3015e = 0;
            this.f3016f = 0;
            this.f3017g = new HashMap();
        }

        public void m3980a(C0909w c0909w) {
            int i;
            C0900g c0900g;
            int i2 = 0;
            if (this.f3012b == null) {
                this.f3012b = C0891t.m3949a();
            }
            if (c0909w.f3095b.f3025a != null) {
                try {
                    if (this.f3011a == 1) {
                        int size = c0909w.f3095b.f3025a.size();
                        if (size > 0) {
                            i = 0;
                            while (i < size) {
                                c0900g = (C0900g) c0909w.f3095b.f3025a.get(i);
                                if (TextUtils.isEmpty(c0900g.f3006a) || !c0900g.f3006a.equals(this.f3012b)) {
                                    i++;
                                } else {
                                    c0909w.f3095b.f3025a.remove(c0900g);
                                    c0900g.f3007b.add(this);
                                    c0909w.f3095b.f3025a.add(c0900g);
                                    return;
                                }
                            }
                            c0900g = new C0900g();
                            c0900g.f3006a = this.f3012b;
                            c0900g.f3007b.add(this);
                            if (!c0909w.f3095b.f3025a.contains(c0900g)) {
                                c0909w.f3095b.f3025a.add(c0900g);
                            }
                        } else {
                            c0900g = new C0900g();
                            c0900g.f3006a = this.f3012b;
                            c0900g.f3007b.add(this);
                            c0909w.f3095b.f3025a.add(c0900g);
                        }
                    }
                } catch (Throwable th) {
                    ap.m3385a(th);
                }
            }
            if (c0909w.f3095b.f3026b == null) {
                return;
            }
            if (this.f3011a == 2) {
                i = c0909w.f3095b.f3026b.size();
                if (i > 0) {
                    while (i2 < i) {
                        c0900g = (C0900g) c0909w.f3095b.f3026b.get(i2);
                        if (TextUtils.isEmpty(c0900g.f3006a) || !c0900g.f3006a.equals(this.f3012b)) {
                            i2++;
                        } else {
                            c0909w.f3095b.f3026b.remove(c0900g);
                            c0900g.f3007b.add(this);
                            c0909w.f3095b.f3026b.add(c0900g);
                            return;
                        }
                    }
                    c0900g = new C0900g();
                    c0900g.f3006a = this.f3012b;
                    c0900g.f3007b.add(this);
                    c0909w.f3095b.f3026b.add(c0900g);
                    return;
                }
                c0900g = new C0900g();
                c0900g.f3006a = this.f3012b;
                c0900g.f3007b.add(this);
                c0909w.f3095b.f3026b.add(c0900g);
            }
        }
    }

    /* renamed from: b.a.w.j */
    public static final class C0903j implements Serializable {
        public double f3018a;
        public double f3019b;
        public long f3020c;

        public C0903j() {
            this.f3018a = 0.0d;
            this.f3019b = 0.0d;
            this.f3020c = 0;
        }
    }

    /* renamed from: b.a.w.k */
    public static final class C0904k implements Serializable {
        public String f3021a;
        public long f3022b;
        public long f3023c;
        public long f3024d;

        public C0904k() {
            this.f3021a = null;
            this.f3022b = 0;
            this.f3023c = 0;
            this.f3024d = 0;
        }
    }

    /* renamed from: b.a.w.l */
    public static class C0905l implements Serializable {
        public List<C0900g> f3025a;
        public List<C0900g> f3026b;
        public List<C0907n> f3027c;
        public C0894a f3028d;
        public C0899f f3029e;
        public Map<String, Integer> f3030f;
        public C0895b f3031g;
        public C0896c f3032h;
        public List<C0901h> f3033i;
        public String f3034j;

        public C0905l() {
            this.f3025a = new ArrayList();
            this.f3026b = new ArrayList();
            this.f3027c = new ArrayList();
            this.f3028d = new C0894a();
            this.f3029e = new C0899f();
            this.f3030f = new HashMap();
            this.f3031g = new C0895b();
            this.f3032h = new C0896c();
            this.f3033i = new ArrayList();
            this.f3034j = null;
        }
    }

    /* renamed from: b.a.w.m */
    public static class C0906m implements Serializable {
        public String f3035A;
        public String f3036B;
        public long f3037C;
        public String f3038D;
        public String f3039E;
        public String f3040F;
        public String f3041G;
        public String f3042H;
        public long f3043I;
        public String f3044J;
        public String f3045K;
        public String f3046L;
        public String f3047M;
        public String f3048N;
        public String f3049O;
        public long f3050P;
        public long f3051Q;
        public long f3052R;
        public String f3053S;
        public String f3054T;
        public String f3055a;
        public String f3056b;
        public String f3057c;
        public String f3058d;
        public String f3059e;
        public String f3060f;
        public String f3061g;
        public int f3062h;
        public String f3063i;
        public String f3064j;
        public String f3065k;
        public String f3066l;
        public int f3067m;
        public int f3068n;
        public String f3069o;
        public String f3070p;
        public String f3071q;
        public String f3072r;
        public String f3073s;
        public String f3074t;
        public String f3075u;
        public String f3076v;
        public String f3077w;
        public String f3078x;
        public String f3079y;
        public String f3080z;

        public C0906m() {
            this.f3055a = null;
            this.f3056b = null;
            this.f3057c = null;
            this.f3058d = null;
            this.f3059e = null;
            this.f3060f = null;
            this.f3061g = null;
            this.f3062h = 0;
            this.f3063i = AnalyticsConfig.mWrapperType;
            this.f3064j = AnalyticsConfig.mWrapperVersion;
            this.f3065k = C4210b.f14219D;
            this.f3066l = null;
            this.f3067m = 0;
            this.f3068n = 0;
            this.f3069o = null;
            this.f3070p = null;
            this.f3071q = null;
            this.f3072r = null;
            this.f3073s = null;
            this.f3074t = am.m3331a();
            this.f3075u = C4210b.f14219D;
            this.f3076v = VERSION.RELEASE;
            this.f3077w = null;
            this.f3078x = null;
            this.f3079y = null;
            this.f3080z = Build.MODEL;
            this.f3035A = Build.BOARD;
            this.f3036B = Build.BRAND;
            this.f3037C = Build.TIME;
            this.f3038D = Build.MANUFACTURER;
            this.f3039E = Build.ID;
            this.f3040F = Build.DEVICE;
            this.f3041G = null;
            this.f3042H = null;
            this.f3043I = 8;
            this.f3044J = null;
            this.f3045K = null;
            this.f3046L = null;
            this.f3047M = null;
            this.f3048N = null;
            this.f3049O = null;
            this.f3050P = 0;
            this.f3051Q = 0;
            this.f3052R = 0;
            this.f3053S = null;
            this.f3054T = null;
        }
    }

    /* renamed from: b.a.w.n */
    public static class C0907n implements C0882k, Serializable {
        public int f3081a;
        public String f3082b;
        public long f3083c;
        public long f3084d;
        public long f3085e;
        public boolean f3086f;
        public List<C0904k> f3087g;
        public List<C0904k> f3088h;
        public C0908o f3089i;
        public C0903j f3090j;

        public C0907n() {
            this.f3081a = 0;
            this.f3082b = null;
            this.f3083c = 0;
            this.f3084d = 0;
            this.f3085e = 0;
            this.f3086f = false;
            this.f3087g = new ArrayList();
            this.f3088h = new ArrayList();
            this.f3089i = new C0908o();
            this.f3090j = new C0903j();
        }

        public void m3981a(C0909w c0909w) {
            if (c0909w.f3095b.f3027c != null) {
                c0909w.f3095b.f3027c.add(this);
            }
        }
    }

    /* renamed from: b.a.w.o */
    public static final class C0908o implements Serializable {
        public long f3091a;
        public long f3092b;

        public C0908o() {
            this.f3091a = 0;
            this.f3092b = 0;
        }
    }

    static {
        f3093c = 0;
    }

    public C0909w() {
        this.f3094a = new C0906m();
        this.f3095b = new C0905l();
    }

    public boolean m3982a() {
        return (this.f3094a.f3079y == null || this.f3094a.f3078x == null || this.f3094a.f3077w == null || this.f3094a.f3055a == null || this.f3094a.f3056b == null || this.f3094a.f3060f == null || this.f3094a.f3059e == null || this.f3094a.f3058d == null) ? false : true;
    }
}
