package com.google.android.gms.p146b;

import android.os.Handler;
import com.google.android.gms.ads.internal.C2836l;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2769y.C2770a;
import com.google.android.gms.ads.internal.client.C2772z.C2773a;
import com.google.android.gms.ads.internal.client.af.C2748a;
import com.google.android.gms.ads.internal.reward.client.C2950a;
import com.google.android.gms.ads.internal.reward.client.C2956c.C2958a;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.bd.C3041a;
import com.google.android.gms.p146b.fc.C3090a;
import java.util.LinkedList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.cs */
class cs {
    private final List<C3080a> f10514a;

    /* renamed from: com.google.android.gms.b.cs.a */
    interface C3080a {
        void m12098a(ct ctVar);
    }

    /* renamed from: com.google.android.gms.b.cs.1 */
    class C30861 extends C2773a {
        final /* synthetic */ cs f10488a;

        /* renamed from: com.google.android.gms.b.cs.1.1 */
        class C30811 implements C3080a {
            final /* synthetic */ C30861 f10482a;

            C30811(C30861 c30861) {
                this.f10482a = c30861;
            }

            public void m12099a(ct ctVar) {
                if (ctVar.f10517a != null) {
                    ctVar.f10517a.m10701a();
                }
                C2968s.m11536p().m12146a();
            }
        }

        /* renamed from: com.google.android.gms.b.cs.1.2 */
        class C30822 implements C3080a {
            final /* synthetic */ int f10483a;
            final /* synthetic */ C30861 f10484b;

            C30822(C30861 c30861, int i) {
                this.f10484b = c30861;
                this.f10483a = i;
            }

            public void m12100a(ct ctVar) {
                if (ctVar.f10517a != null) {
                    ctVar.f10517a.m10702a(this.f10483a);
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.1.3 */
        class C30833 implements C3080a {
            final /* synthetic */ C30861 f10485a;

            C30833(C30861 c30861) {
                this.f10485a = c30861;
            }

            public void m12101a(ct ctVar) {
                if (ctVar.f10517a != null) {
                    ctVar.f10517a.m10703b();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.1.4 */
        class C30844 implements C3080a {
            final /* synthetic */ C30861 f10486a;

            C30844(C30861 c30861) {
                this.f10486a = c30861;
            }

            public void m12102a(ct ctVar) {
                if (ctVar.f10517a != null) {
                    ctVar.f10517a.m10704c();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.1.5 */
        class C30855 implements C3080a {
            final /* synthetic */ C30861 f10487a;

            C30855(C30861 c30861) {
                this.f10487a = c30861;
            }

            public void m12103a(ct ctVar) {
                if (ctVar.f10517a != null) {
                    ctVar.f10517a.m10705d();
                }
            }
        }

        C30861(cs csVar) {
            this.f10488a = csVar;
        }

        public void m12104a() {
            this.f10488a.f10514a.add(new C30811(this));
        }

        public void m12105a(int i) {
            this.f10488a.f10514a.add(new C30822(this, i));
            hf.m12982e("Pooled interstitial failed to load.");
        }

        public void m12106b() {
            this.f10488a.f10514a.add(new C30833(this));
        }

        public void m12107c() {
            this.f10488a.f10514a.add(new C30844(this));
            hf.m12982e("Pooled interstitial loaded.");
        }

        public void m12108d() {
            this.f10488a.f10514a.add(new C30855(this));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.2 */
    class C30882 extends C2748a {
        final /* synthetic */ cs f10492a;

        /* renamed from: com.google.android.gms.b.cs.2.1 */
        class C30871 implements C3080a {
            final /* synthetic */ String f10489a;
            final /* synthetic */ String f10490b;
            final /* synthetic */ C30882 f10491c;

            C30871(C30882 c30882, String str, String str2) {
                this.f10491c = c30882;
                this.f10489a = str;
                this.f10490b = str2;
            }

            public void m12109a(ct ctVar) {
                if (ctVar.f10518b != null) {
                    ctVar.f10518b.m10556a(this.f10489a, this.f10490b);
                }
            }
        }

        C30882(cs csVar) {
            this.f10492a = csVar;
        }

        public void m12110a(String str, String str2) {
            this.f10492a.f10514a.add(new C30871(this, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.3 */
    class C30913 extends C3090a {
        final /* synthetic */ cs f10495a;

        /* renamed from: com.google.android.gms.b.cs.3.1 */
        class C30891 implements C3080a {
            final /* synthetic */ fb f10493a;
            final /* synthetic */ C30913 f10494b;

            C30891(C30913 c30913, fb fbVar) {
                this.f10494b = c30913;
                this.f10493a = fbVar;
            }

            public void m12111a(ct ctVar) {
                if (ctVar.f10519c != null) {
                    ctVar.f10519c.m12112a(this.f10493a);
                }
            }
        }

        C30913(cs csVar) {
            this.f10495a = csVar;
        }

        public void m12114a(fb fbVar) {
            this.f10495a.f10514a.add(new C30891(this, fbVar));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.4 */
    class C30934 extends C3041a {
        final /* synthetic */ cs f10498a;

        /* renamed from: com.google.android.gms.b.cs.4.1 */
        class C30921 implements C3080a {
            final /* synthetic */ bc f10496a;
            final /* synthetic */ C30934 f10497b;

            C30921(C30934 c30934, bc bcVar) {
                this.f10497b = c30934;
                this.f10496a = bcVar;
            }

            public void m12115a(ct ctVar) {
                if (ctVar.f10520d != null) {
                    ctVar.f10520d.m11877a(this.f10496a);
                }
            }
        }

        C30934(cs csVar) {
            this.f10498a = csVar;
        }

        public void m12116a(bc bcVar) {
            this.f10498a.f10514a.add(new C30921(this, bcVar));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.5 */
    class C30955 extends C2770a {
        final /* synthetic */ cs f10500a;

        /* renamed from: com.google.android.gms.b.cs.5.1 */
        class C30941 implements C3080a {
            final /* synthetic */ C30955 f10499a;

            C30941(C30955 c30955) {
                this.f10499a = c30955;
            }

            public void m12117a(ct ctVar) {
                if (ctVar.f10521e != null) {
                    ctVar.f10521e.m10698a();
                }
            }
        }

        C30955(cs csVar) {
            this.f10500a = csVar;
        }

        public void m12118a() {
            this.f10500a.f10514a.add(new C30941(this));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.6 */
    class C31036 extends C2958a {
        final /* synthetic */ cs f10510a;

        /* renamed from: com.google.android.gms.b.cs.6.1 */
        class C30961 implements C3080a {
            final /* synthetic */ C31036 f10501a;

            C30961(C31036 c31036) {
                this.f10501a = c31036;
            }

            public void m12119a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11457a();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.2 */
        class C30972 implements C3080a {
            final /* synthetic */ C31036 f10502a;

            C30972(C31036 c31036) {
                this.f10502a = c31036;
            }

            public void m12120a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11460b();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.3 */
        class C30983 implements C3080a {
            final /* synthetic */ C31036 f10503a;

            C30983(C31036 c31036) {
                this.f10503a = c31036;
            }

            public void m12121a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11461c();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.4 */
        class C30994 implements C3080a {
            final /* synthetic */ C31036 f10504a;

            C30994(C31036 c31036) {
                this.f10504a = c31036;
            }

            public void m12122a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11462d();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.5 */
        class C31005 implements C3080a {
            final /* synthetic */ C2950a f10505a;
            final /* synthetic */ C31036 f10506b;

            C31005(C31036 c31036, C2950a c2950a) {
                this.f10506b = c31036;
                this.f10505a = c2950a;
            }

            public void m12123a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11459a(this.f10505a);
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.6 */
        class C31016 implements C3080a {
            final /* synthetic */ C31036 f10507a;

            C31016(C31036 c31036) {
                this.f10507a = c31036;
            }

            public void m12124a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11463e();
                }
            }
        }

        /* renamed from: com.google.android.gms.b.cs.6.7 */
        class C31027 implements C3080a {
            final /* synthetic */ int f10508a;
            final /* synthetic */ C31036 f10509b;

            C31027(C31036 c31036, int i) {
                this.f10509b = c31036;
                this.f10508a = i;
            }

            public void m12125a(ct ctVar) {
                if (ctVar.f10522f != null) {
                    ctVar.f10522f.m11458a(this.f10508a);
                }
            }
        }

        C31036(cs csVar) {
            this.f10510a = csVar;
        }

        public void m12126a() {
            this.f10510a.f10514a.add(new C30961(this));
        }

        public void m12127a(int i) {
            this.f10510a.f10514a.add(new C31027(this, i));
        }

        public void m12128a(C2950a c2950a) {
            this.f10510a.f10514a.add(new C31005(this, c2950a));
        }

        public void m12129b() {
            this.f10510a.f10514a.add(new C30972(this));
        }

        public void m12130c() {
            this.f10510a.f10514a.add(new C30983(this));
        }

        public void m12131d() {
            this.f10510a.f10514a.add(new C30994(this));
        }

        public void m12132e() {
            this.f10510a.f10514a.add(new C31016(this));
        }
    }

    /* renamed from: com.google.android.gms.b.cs.7 */
    class C31047 implements Runnable {
        final /* synthetic */ C3080a f10511a;
        final /* synthetic */ ct f10512b;
        final /* synthetic */ cs f10513c;

        C31047(cs csVar, C3080a c3080a, ct ctVar) {
            this.f10513c = csVar;
            this.f10511a = c3080a;
            this.f10512b = ctVar;
        }

        public void run() {
            try {
                this.f10511a.m12098a(this.f10512b);
            } catch (Throwable e) {
                C2972b.m11584d("Could not propagate interstitial ad event.", e);
            }
        }
    }

    cs() {
        this.f10514a = new LinkedList();
    }

    void m12134a(C2836l c2836l) {
        c2836l.m10430a(new C30861(this));
        c2836l.m10427a(new C30882(this));
        c2836l.m10475a(new C30913(this));
        c2836l.m10765a(new C30934(this));
        c2836l.m10429a(new C30955(this));
        c2836l.m10431a(new C31036(this));
    }

    void m12135a(ct ctVar) {
        Handler handler = hj.f11297a;
        for (C3080a c31047 : this.f10514a) {
            handler.post(new C31047(this, c31047, ctVar));
        }
    }
}
