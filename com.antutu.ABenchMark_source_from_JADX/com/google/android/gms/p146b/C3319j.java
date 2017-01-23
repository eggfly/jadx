package com.google.android.gms.p146b;

import android.content.Context;
import com.google.ads.p147a.p148a.C2630b.C2627a;
import com.google.android.gms.ads.p153c.C2715a;
import com.google.android.gms.ads.p153c.C2715a.C2713a;
import com.google.android.gms.common.C3385a;
import com.google.android.gms.common.C3454b;
import com.google.android.gms.p146b.C3279i.C3278a;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.b.j */
public class C3319j extends C3279i {
    private static C2715a f11547r;
    private static CountDownLatch f11548s;
    private boolean f11549t;

    /* renamed from: com.google.android.gms.b.j.a */
    class C3317a {
        final /* synthetic */ C3319j f11543a;
        private String f11544b;
        private boolean f11545c;

        public C3317a(C3319j c3319j, String str, boolean z) {
            this.f11543a = c3319j;
            this.f11544b = str;
            this.f11545c = z;
        }

        public String m13502a() {
            return this.f11544b;
        }

        public boolean m13503b() {
            return this.f11545c;
        }
    }

    /* renamed from: com.google.android.gms.b.j.b */
    private static final class C3318b implements Runnable {
        private Context f11546a;

        public C3318b(Context context) {
            this.f11546a = context.getApplicationContext();
            if (this.f11546a == null) {
                this.f11546a = context;
            }
        }

        public void run() {
            synchronized (C3319j.class) {
                try {
                    if (C3319j.f11547r == null) {
                        C2715a.m10327b(true);
                        C2715a c2715a = new C2715a(this.f11546a);
                        c2715a.m10329a();
                        C3319j.f11547r = c2715a;
                    }
                    C3319j.f11548s.countDown();
                } catch (C3385a e) {
                    try {
                        C3319j.f11547r = null;
                    } finally {
                        C3319j.f11548s.countDown();
                    }
                } catch (IOException e2) {
                    C3319j.f11547r = null;
                } catch (C3454b e3) {
                    C3319j.f11547r = null;
                }
            }
        }
    }

    static {
        f11547r = null;
        f11548s = new CountDownLatch(1);
    }

    protected C3319j(Context context, C3158m c3158m, boolean z) {
        super(context, c3158m);
        this.f11549t = z;
    }

    public static C3319j m13505a(String str, Context context, boolean z) {
        C3158m c3159e = new C3159e();
        C3279i.m13176a(str, context, c3159e);
        if (z) {
            synchronized (C3319j.class) {
                if (f11547r == null) {
                    new Thread(new C3318b(context)).start();
                }
            }
        }
        return new C3319j(context, c3159e, z);
    }

    private void m13506a(Context context, C2627a c2627a) {
        if (this.f11549t) {
            try {
                if (m13193a()) {
                    C3317a f = m13510f();
                    String a = f.m13502a();
                    if (a != null) {
                        c2627a.f9127O = Boolean.valueOf(f.m13503b());
                        c2627a.f9126N = Integer.valueOf(5);
                        c2627a.f9125M = a;
                        C3279i.m13175a(28, m);
                        return;
                    }
                    return;
                }
                c2627a.f9125M = C3279i.m13182d(context);
                C3279i.m13175a(24, m);
            } catch (IOException e) {
            } catch (C3278a e2) {
            }
        }
    }

    protected C2627a m13509b(Context context) {
        C2627a b = super.m13194b(context);
        m13506a(context, b);
        return b;
    }

    C3317a m13510f() {
        try {
            if (!f11548s.await(2, TimeUnit.SECONDS)) {
                return new C3317a(this, null, false);
            }
            synchronized (C3319j.class) {
                if (f11547r == null) {
                    C3317a c3317a = new C3317a(this, null, false);
                    return c3317a;
                }
                C2713a b = f11547r.m10331b();
                return new C3317a(this, m12962a(b.m10319a()), b.m10320b());
            }
        } catch (InterruptedException e) {
            return new C3317a(this, null, false);
        }
    }
}
