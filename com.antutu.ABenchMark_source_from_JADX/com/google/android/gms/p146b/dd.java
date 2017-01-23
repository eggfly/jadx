package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.p146b.da.C3110a;
import com.google.android.gms.p146b.ib.C2915c;
import com.google.android.gms.p146b.ib.C2917a;
import com.google.android.gms.p146b.ib.C3280b;
import java.util.Map;

@gb
/* renamed from: com.google.android.gms.b.dd */
public class dd {
    private final Object f10625a;
    private final Context f10626b;
    private final String f10627c;
    private final VersionInfoParcel f10628d;
    private C2944b<da> f10629e;
    private C2944b<da> f10630f;
    private C3140e f10631g;
    private int f10632h;

    /* renamed from: com.google.android.gms.b.dd.b */
    public interface C2944b<T> {
        void m11429a(T t);
    }

    /* renamed from: com.google.android.gms.b.dd.1 */
    class C31271 implements Runnable {
        final /* synthetic */ C3140e f10596a;
        final /* synthetic */ dd f10597b;

        /* renamed from: com.google.android.gms.b.dd.1.1 */
        class C31221 implements C3110a {
            final /* synthetic */ da f10586a;
            final /* synthetic */ C31271 f10587b;

            /* renamed from: com.google.android.gms.b.dd.1.1.1 */
            class C31211 implements Runnable {
                final /* synthetic */ C31221 f10585a;

                /* renamed from: com.google.android.gms.b.dd.1.1.1.1 */
                class C31201 implements Runnable {
                    final /* synthetic */ C31211 f10584a;

                    C31201(C31211 c31211) {
                        this.f10584a = c31211;
                    }

                    public void run() {
                        this.f10584a.f10585a.f10586a.m12207a();
                    }
                }

                C31211(C31221 c31221) {
                    this.f10585a = c31221;
                }

                public void run() {
                    synchronized (this.f10585a.f10587b.f10597b.f10625a) {
                        if (this.f10585a.f10587b.f10596a.m12254f() == -1 || this.f10585a.f10587b.f10596a.m12254f() == 1) {
                            return;
                        }
                        this.f10585a.f10587b.f10596a.m12253e();
                        hj.m13012a(new C31201(this));
                        hf.m12982e("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }

            C31221(C31271 c31271, da daVar) {
                this.f10587b = c31271;
                this.f10586a = daVar;
            }

            public void m12237a() {
                hj.f11297a.postDelayed(new C31211(this), (long) C3130a.f10603b);
            }
        }

        /* renamed from: com.google.android.gms.b.dd.1.2 */
        class C31232 implements cb {
            final /* synthetic */ da f10588a;
            final /* synthetic */ C31271 f10589b;

            C31232(C31271 c31271, da daVar) {
                this.f10589b = c31271;
                this.f10588a = daVar;
            }

            public void m12238a(ii iiVar, Map<String, String> map) {
                synchronized (this.f10589b.f10597b.f10625a) {
                    if (this.f10589b.f10596a.m12254f() == -1 || this.f10589b.f10596a.m12254f() == 1) {
                        return;
                    }
                    this.f10589b.f10597b.f10632h = 0;
                    this.f10589b.f10597b.f10629e.m11429a(this.f10588a);
                    this.f10589b.f10596a.m12252a(this.f10588a);
                    this.f10589b.f10597b.f10631g = this.f10589b.f10596a;
                    hf.m12982e("Successfully loaded JS Engine.");
                }
            }
        }

        /* renamed from: com.google.android.gms.b.dd.1.3 */
        class C31243 implements cb {
            final /* synthetic */ da f10590a;
            final /* synthetic */ ht f10591b;
            final /* synthetic */ C31271 f10592c;

            C31243(C31271 c31271, da daVar, ht htVar) {
                this.f10592c = c31271;
                this.f10590a = daVar;
                this.f10591b = htVar;
            }

            public void m12239a(ii iiVar, Map<String, String> map) {
                synchronized (this.f10592c.f10597b.f10625a) {
                    C2972b.m11581c("JS Engine is requesting an update");
                    if (this.f10592c.f10597b.f10632h == 0) {
                        C2972b.m11581c("Starting reload.");
                        this.f10592c.f10597b.f10632h = 2;
                        this.f10592c.f10597b.m12278a();
                    }
                    this.f10590a.m12205b("/requestReload", (cb) this.f10591b.m13158a());
                }
            }
        }

        /* renamed from: com.google.android.gms.b.dd.1.4 */
        class C31264 implements Runnable {
            final /* synthetic */ da f10594a;
            final /* synthetic */ C31271 f10595b;

            /* renamed from: com.google.android.gms.b.dd.1.4.1 */
            class C31251 implements Runnable {
                final /* synthetic */ C31264 f10593a;

                C31251(C31264 c31264) {
                    this.f10593a = c31264;
                }

                public void run() {
                    this.f10593a.f10594a.m12207a();
                }
            }

            C31264(C31271 c31271, da daVar) {
                this.f10595b = c31271;
                this.f10594a = daVar;
            }

            public void run() {
                synchronized (this.f10595b.f10597b.f10625a) {
                    if (this.f10595b.f10596a.m12254f() == -1 || this.f10595b.f10596a.m12254f() == 1) {
                        return;
                    }
                    this.f10595b.f10596a.m12253e();
                    hj.m13012a(new C31251(this));
                    hf.m12982e("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }

        C31271(dd ddVar, C3140e c3140e) {
            this.f10597b = ddVar;
            this.f10596a = c3140e;
        }

        public void run() {
            da a = this.f10597b.m12277a(this.f10597b.f10626b, this.f10597b.f10628d);
            a.m12209a(new C31221(this, a));
            a.m12202a("/jsLoaded", new C31232(this, a));
            ht htVar = new ht();
            cb c31243 = new C31243(this, a, htVar);
            htVar.m13159a(c31243);
            a.m12202a("/requestReload", c31243);
            if (this.f10597b.f10627c.endsWith(".js")) {
                a.m12210a(this.f10597b.f10627c);
            } else if (this.f10597b.f10627c.startsWith("<html>")) {
                a.m12213c(this.f10597b.f10627c);
            } else {
                a.m12212b(this.f10597b.f10627c);
            }
            hj.f11297a.postDelayed(new C31264(this, a), (long) C3130a.f10602a);
        }
    }

    /* renamed from: com.google.android.gms.b.dd.2 */
    class C31282 implements C2915c<da> {
        final /* synthetic */ C3140e f10598a;
        final /* synthetic */ dd f10599b;

        C31282(dd ddVar, C3140e c3140e) {
            this.f10599b = ddVar;
            this.f10598a = c3140e;
        }

        public void m12240a(da daVar) {
            synchronized (this.f10599b.f10625a) {
                this.f10599b.f10632h = 0;
                if (!(this.f10599b.f10631g == null || this.f10598a == this.f10599b.f10631g)) {
                    hf.m12982e("New JS engine is loaded, marking previous one as destroyable.");
                    this.f10599b.f10631g.m12265c();
                }
                this.f10599b.f10631g = this.f10598a;
            }
        }

        public /* synthetic */ void m12241a(Object obj) {
            m12240a((da) obj);
        }
    }

    /* renamed from: com.google.android.gms.b.dd.3 */
    class C31293 implements C2917a {
        final /* synthetic */ C3140e f10600a;
        final /* synthetic */ dd f10601b;

        C31293(dd ddVar, C3140e c3140e) {
            this.f10601b = ddVar;
            this.f10600a = c3140e;
        }

        public void m12242a() {
            synchronized (this.f10601b.f10625a) {
                this.f10601b.f10632h = 1;
                hf.m12982e("Failed loading new engine. Marking new engine destroyable.");
                this.f10600a.m12265c();
            }
        }
    }

    /* renamed from: com.google.android.gms.b.dd.a */
    static class C3130a {
        static int f10602a;
        static int f10603b;

        static {
            f10602a = 60000;
            f10603b = 10000;
        }
    }

    /* renamed from: com.google.android.gms.b.dd.c */
    public static class C3131c<T> implements C2944b<T> {
        public void m12243a(T t) {
        }
    }

    /* renamed from: com.google.android.gms.b.dd.d */
    public static class C3135d extends ic<de> {
        private final Object f10611d;
        private final C3140e f10612e;
        private boolean f10613f;

        /* renamed from: com.google.android.gms.b.dd.d.1 */
        class C31321 implements C2915c<de> {
            final /* synthetic */ C3135d f10604a;

            C31321(C3135d c3135d) {
                this.f10604a = c3135d;
            }

            public void m12244a(de deVar) {
                hf.m12982e("Ending javascript session.");
                ((df) deVar).m12280a();
            }

            public /* synthetic */ void m12245a(Object obj) {
                m12244a((de) obj);
            }
        }

        /* renamed from: com.google.android.gms.b.dd.d.2 */
        class C31332 implements C2915c<de> {
            final /* synthetic */ C3135d f10605a;

            C31332(C3135d c3135d) {
                this.f10605a = c3135d;
            }

            public void m12246a(de deVar) {
                hf.m12982e("Releasing engine reference.");
                this.f10605a.f10612e.m12264b();
            }

            public /* synthetic */ void m12247a(Object obj) {
                m12246a((de) obj);
            }
        }

        /* renamed from: com.google.android.gms.b.dd.d.3 */
        class C31343 implements C2917a {
            final /* synthetic */ C3135d f10606a;

            C31343(C3135d c3135d) {
                this.f10606a = c3135d;
            }

            public void m12248a() {
                this.f10606a.f10612e.m12264b();
            }
        }

        public C3135d(C3140e c3140e) {
            this.f10611d = new Object();
            this.f10612e = c3140e;
        }

        public void m12256a() {
            synchronized (this.f10611d) {
                if (this.f10613f) {
                    return;
                }
                this.f10613f = true;
                m12251a(new C31321(this), new C3280b());
                m12251a(new C31332(this), new C31343(this));
            }
        }
    }

    /* renamed from: com.google.android.gms.b.dd.e */
    public static class C3140e extends ic<da> {
        private final Object f10621d;
        private C2944b<da> f10622e;
        private boolean f10623f;
        private int f10624g;

        /* renamed from: com.google.android.gms.b.dd.e.1 */
        class C31361 implements C2915c<da> {
            final /* synthetic */ C3135d f10614a;
            final /* synthetic */ C3140e f10615b;

            C31361(C3140e c3140e, C3135d c3135d) {
                this.f10615b = c3140e;
                this.f10614a = c3135d;
            }

            public void m12257a(da daVar) {
                hf.m12982e("Getting a new session for JS Engine.");
                this.f10614a.m12252a(daVar.m12211b());
            }

            public /* synthetic */ void m12258a(Object obj) {
                m12257a((da) obj);
            }
        }

        /* renamed from: com.google.android.gms.b.dd.e.2 */
        class C31372 implements C2917a {
            final /* synthetic */ C3135d f10616a;
            final /* synthetic */ C3140e f10617b;

            C31372(C3140e c3140e, C3135d c3135d) {
                this.f10617b = c3140e;
                this.f10616a = c3135d;
            }

            public void m12259a() {
                hf.m12982e("Rejecting reference for JS Engine.");
                this.f10616a.m12253e();
            }
        }

        /* renamed from: com.google.android.gms.b.dd.e.3 */
        class C31393 implements C2915c<da> {
            final /* synthetic */ C3140e f10620a;

            /* renamed from: com.google.android.gms.b.dd.e.3.1 */
            class C31381 implements Runnable {
                final /* synthetic */ da f10618a;
                final /* synthetic */ C31393 f10619b;

                C31381(C31393 c31393, da daVar) {
                    this.f10619b = c31393;
                    this.f10618a = daVar;
                }

                public void run() {
                    this.f10619b.f10620a.f10622e.m11429a(this.f10618a);
                    this.f10618a.m12207a();
                }
            }

            C31393(C3140e c3140e) {
                this.f10620a = c3140e;
            }

            public void m12260a(da daVar) {
                hj.m13012a(new C31381(this, daVar));
            }

            public /* synthetic */ void m12261a(Object obj) {
                m12260a((da) obj);
            }
        }

        public C3140e(C2944b<da> c2944b) {
            this.f10621d = new Object();
            this.f10622e = c2944b;
            this.f10623f = false;
            this.f10624g = 0;
        }

        public C3135d m12263a() {
            C3135d c3135d = new C3135d(this);
            synchronized (this.f10621d) {
                m12251a(new C31361(this, c3135d), new C31372(this, c3135d));
                C3512u.m14584a(this.f10624g >= 0);
                this.f10624g++;
            }
            return c3135d;
        }

        protected void m12264b() {
            boolean z = true;
            synchronized (this.f10621d) {
                if (this.f10624g < 1) {
                    z = false;
                }
                C3512u.m14584a(z);
                hf.m12982e("Releasing 1 reference for JS Engine");
                this.f10624g--;
                m12266d();
            }
        }

        public void m12265c() {
            boolean z = true;
            synchronized (this.f10621d) {
                if (this.f10624g < 0) {
                    z = false;
                }
                C3512u.m14584a(z);
                hf.m12982e("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.f10623f = true;
                m12266d();
            }
        }

        protected void m12266d() {
            synchronized (this.f10621d) {
                C3512u.m14584a(this.f10624g >= 0);
                if (this.f10623f && this.f10624g == 0) {
                    hf.m12982e("No reference is left (including root). Cleaning up engine.");
                    m12251a(new C31393(this), new C3280b());
                } else {
                    hf.m12982e("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public dd(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.f10625a = new Object();
        this.f10632h = 1;
        this.f10627c = str;
        this.f10626b = context.getApplicationContext();
        this.f10628d = versionInfoParcel;
        this.f10629e = new C3131c();
        this.f10630f = new C3131c();
    }

    public dd(Context context, VersionInfoParcel versionInfoParcel, String str, C2944b<da> c2944b, C2944b<da> c2944b2) {
        this(context, versionInfoParcel, str);
        this.f10629e = c2944b;
        this.f10630f = c2944b2;
    }

    private C3140e m12271c() {
        C3140e c3140e = new C3140e(this.f10630f);
        hj.m13012a(new C31271(this, c3140e));
        return c3140e;
    }

    protected da m12277a(Context context, VersionInfoParcel versionInfoParcel) {
        return new dc(context, versionInfoParcel, null);
    }

    protected C3140e m12278a() {
        C3140e c = m12271c();
        c.m12251a(new C31282(this, c), new C31293(this, c));
        return c;
    }

    public C3135d m12279b() {
        C3135d a;
        synchronized (this.f10625a) {
            if (this.f10631g == null || this.f10631g.m12254f() == -1) {
                this.f10632h = 2;
                this.f10631g = m12278a();
                a = this.f10631g.m12263a();
            } else if (this.f10632h == 0) {
                a = this.f10631g.m12263a();
            } else if (this.f10632h == 1) {
                this.f10632h = 2;
                m12278a();
                a = this.f10631g.m12263a();
            } else if (this.f10632h == 2) {
                a = this.f10631g.m12263a();
            } else {
                a = this.f10631g.m12263a();
            }
        }
        return a;
    }
}
