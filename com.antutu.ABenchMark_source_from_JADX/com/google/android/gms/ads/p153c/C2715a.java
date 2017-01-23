package com.google.android.gms.ads.p153c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C3385a;
import com.google.android.gms.common.C3455d;
import com.google.android.gms.common.C3457f;
import com.google.android.gms.common.internal.C3512u;
import com.google.android.gms.common.stats.C3527b;
import com.google.android.gms.p146b.C3352p;
import com.google.android.gms.p146b.C3352p.C3354a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.google.android.gms.ads.c.a */
public class C2715a {
    C3455d f9248a;
    C3352p f9249b;
    boolean f9250c;
    Object f9251d;
    C2714b f9252e;
    final long f9253f;
    private final Context f9254g;

    /* renamed from: com.google.android.gms.ads.c.a.a */
    public static final class C2713a {
        private final String f9242a;
        private final boolean f9243b;

        public C2713a(String str, boolean z) {
            this.f9242a = str;
            this.f9243b = z;
        }

        public String m10319a() {
            return this.f9242a;
        }

        public boolean m10320b() {
            return this.f9243b;
        }

        public String toString() {
            return "{" + this.f9242a + "}" + this.f9243b;
        }
    }

    /* renamed from: com.google.android.gms.ads.c.a.b */
    static class C2714b extends Thread {
        CountDownLatch f9244a;
        boolean f9245b;
        private WeakReference<C2715a> f9246c;
        private long f9247d;

        public C2714b(C2715a c2715a, long j) {
            this.f9246c = new WeakReference(c2715a);
            this.f9247d = j;
            this.f9244a = new CountDownLatch(1);
            this.f9245b = false;
            start();
        }

        private void m10321c() {
            C2715a c2715a = (C2715a) this.f9246c.get();
            if (c2715a != null) {
                c2715a.m10332c();
                this.f9245b = true;
            }
        }

        public void m10322a() {
            this.f9244a.countDown();
        }

        public boolean m10323b() {
            return this.f9245b;
        }

        public void run() {
            try {
                if (!this.f9244a.await(this.f9247d, TimeUnit.MILLISECONDS)) {
                    m10321c();
                }
            } catch (InterruptedException e) {
                m10321c();
            }
        }
    }

    public C2715a(Context context) {
        this(context, 30000);
    }

    public C2715a(Context context, long j) {
        this.f9251d = new Object();
        C3512u.m14580a((Object) context);
        this.f9254g = context;
        this.f9250c = false;
        this.f9253f = j;
    }

    static C3352p m10324a(Context context, C3455d c3455d) {
        try {
            return C3354a.m13819a(c3455d.m14265a());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    static C3455d m10325a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            switch (C3457f.m14269a().m14271a(context)) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    ServiceConnection c3455d = new C3455d();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (C3527b.m14718a().m14729a(context, intent, c3455d, 1)) {
                            return c3455d;
                        }
                        throw new IOException("Connection failure");
                    } catch (Throwable th) {
                        IOException iOException = new IOException(th);
                    }
                default:
                    throw new IOException("Google Play services not available");
            }
        } catch (NameNotFoundException e) {
            throw new C3385a(9);
        }
    }

    public static C2713a m10326b(Context context) {
        C2715a c2715a = new C2715a(context, -1);
        try {
            c2715a.m10330a(false);
            C2713a b = c2715a.m10331b();
            return b;
        } finally {
            c2715a.m10332c();
        }
    }

    public static void m10327b(boolean z) {
    }

    private void m10328d() {
        synchronized (this.f9251d) {
            if (this.f9252e != null) {
                this.f9252e.m10322a();
                try {
                    this.f9252e.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.f9253f > 0) {
                this.f9252e = new C2714b(this, this.f9253f);
            }
        }
    }

    public void m10329a() {
        m10330a(true);
    }

    protected void m10330a(boolean z) {
        C3512u.m14590c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f9250c) {
                m10332c();
            }
            this.f9248a = C2715a.m10325a(this.f9254g);
            this.f9249b = C2715a.m10324a(this.f9254g, this.f9248a);
            this.f9250c = true;
            if (z) {
                m10328d();
            }
        }
    }

    public C2713a m10331b() {
        C2713a c2713a;
        C3512u.m14590c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f9250c) {
                synchronized (this.f9251d) {
                    if (this.f9252e == null || !this.f9252e.m10323b()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m10330a(false);
                    if (!this.f9250c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            C3512u.m14580a(this.f9248a);
            C3512u.m14580a(this.f9249b);
            c2713a = new C2713a(this.f9249b.m13811a(), this.f9249b.m13814a(true));
        }
        m10328d();
        return c2713a;
    }

    public void m10332c() {
        C3512u.m14590c("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f9254g == null || this.f9248a == null) {
                return;
            }
            try {
                if (this.f9250c) {
                    C3527b.m14718a().m14727a(this.f9254g, this.f9248a);
                }
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.f9250c = false;
            this.f9249b = null;
            this.f9248a = null;
        }
    }

    protected void finalize() {
        m10332c();
        super.finalize();
    }
}
