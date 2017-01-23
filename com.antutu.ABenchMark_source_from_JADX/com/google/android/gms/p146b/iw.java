package com.google.android.gms.p146b;

import android.util.Log;
import com.google.android.gms.clearcut.C3313c;
import com.google.android.gms.clearcut.C3383b;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.C3304d;
import com.google.android.gms.common.api.C3304d.C3300a;
import com.google.android.gms.common.api.C3386f;
import com.google.android.gms.common.api.C3427c;
import com.google.android.gms.common.api.C3444a.C2924c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p155a.C3392a.C3307a;
import com.google.android.gms.p146b.iy.C3309a;
import com.umeng.message.proguard.C4233j;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.b.iw */
public class iw implements C3313c {
    private static final Object f11530a;
    private static final C3312e f11531b;
    private static final long f11532c;
    private final jg f11533d;
    private final C3302a f11534e;
    private final Object f11535f;
    private long f11536g;
    private final long f11537h;
    private ScheduledFuture<?> f11538i;
    private C3427c f11539j;
    private final Runnable f11540k;

    /* renamed from: com.google.android.gms.b.iw.1 */
    class C32991 implements Runnable {
        final /* synthetic */ iw f11508a;

        C32991(iw iwVar) {
            this.f11508a = iwVar;
        }

        public void run() {
            synchronized (this.f11508a.f11535f) {
                if (this.f11508a.f11536g <= this.f11508a.f11533d.m13544b() && this.f11508a.f11539j != null) {
                    Log.i("ClearcutLoggerApiImpl", "disconnect managed GoogleApiClient");
                    this.f11508a.f11539j.m14140c();
                    this.f11508a.f11539j = null;
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.b.iw.2 */
    class C33012 implements C3300a {
        final /* synthetic */ iw f11509a;

        C33012(iw iwVar) {
            this.f11509a = iwVar;
        }

        public void m13434a(Status status) {
            iw.f11531b.m13479b();
        }
    }

    /* renamed from: com.google.android.gms.b.iw.a */
    public interface C3302a {
    }

    /* renamed from: com.google.android.gms.b.iw.b */
    public static class C3303b implements C3302a {
    }

    /* renamed from: com.google.android.gms.b.iw.c */
    static abstract class C3308c<R extends C3386f> extends C3307a<R, ix> {
        public C3308c(C3427c c3427c) {
            super(C3383b.f11796a, c3427c);
        }
    }

    /* renamed from: com.google.android.gms.b.iw.d */
    final class C3311d extends C3308c<Status> {
        final /* synthetic */ iw f11527b;
        private final LogEventParcelable f11528c;

        /* renamed from: com.google.android.gms.b.iw.d.1 */
        class C33101 extends C3309a {
            final /* synthetic */ C3311d f11526a;

            C33101(C3311d c3311d) {
                this.f11526a = c3311d;
            }

            public void m13472a(Status status) {
                this.f11526a.m13443a((C3386f) status);
            }
        }

        C3311d(iw iwVar, LogEventParcelable logEventParcelable, C3427c c3427c) {
            this.f11527b = iwVar;
            super(c3427c);
            this.f11528c = logEventParcelable;
        }

        protected void m13473a(ix ixVar) {
            iy c33101 = new C33101(this);
            try {
                iw.m13488b(this.f11528c);
                ixVar.m13495a(c33101, this.f11528c);
            } catch (Throwable th) {
                Log.e("ClearcutLoggerApiImpl", "MessageNanoProducer " + this.f11528c.f11781f.toString() + " threw: " + th.toString());
            }
        }

        protected /* synthetic */ void m13474b(C2924c c2924c) {
            m13473a((ix) c2924c);
        }

        protected /* synthetic */ C3386f m13475c(Status status) {
            return m13476d(status);
        }

        protected Status m13476d(Status status) {
            return status;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3311d)) {
                return false;
            }
            return this.f11528c.equals(((C3311d) obj).f11528c);
        }

        public String toString() {
            return "MethodImpl(" + this.f11528c + C4233j.f14397t;
        }
    }

    /* renamed from: com.google.android.gms.b.iw.e */
    private static final class C3312e {
        private int f11529a;

        private C3312e() {
            this.f11529a = 0;
        }

        public synchronized void m13477a() {
            this.f11529a++;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m13478a(long r8, java.util.concurrent.TimeUnit r10) {
            /*
            r7 = this;
            r2 = java.lang.System.currentTimeMillis();
            r0 = java.util.concurrent.TimeUnit.MILLISECONDS;
            r0 = r0.convert(r8, r10);
            monitor-enter(r7);
        L_0x000b:
            r4 = r7.f11529a;	 Catch:{ all -> 0x001b }
            if (r4 != 0) goto L_0x0012;
        L_0x000f:
            r0 = 1;
            monitor-exit(r7);	 Catch:{ all -> 0x001b }
        L_0x0011:
            return r0;
        L_0x0012:
            r4 = 0;
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 > 0) goto L_0x001e;
        L_0x0018:
            r0 = 0;
            monitor-exit(r7);	 Catch:{ all -> 0x001b }
            goto L_0x0011;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r7.wait(r0);	 Catch:{ all -> 0x001b }
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x001b }
            r4 = r4 - r2;
            r0 = r0 - r4;
            goto L_0x000b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.iw.e.a(long, java.util.concurrent.TimeUnit):boolean");
        }

        public synchronized void m13479b() {
            if (this.f11529a == 0) {
                throw new RuntimeException("too many decrements");
            }
            this.f11529a--;
            if (this.f11529a == 0) {
                notifyAll();
            }
        }
    }

    static {
        f11530a = new Object();
        f11531b = new C3312e();
        f11532c = TimeUnit.MILLISECONDS.convert(2, TimeUnit.MINUTES);
    }

    public iw() {
        this(new ji(), f11532c, new C3303b());
    }

    public iw(jg jgVar, long j, C3302a c3302a) {
        this.f11535f = new Object();
        this.f11536g = 0;
        this.f11538i = null;
        this.f11539j = null;
        this.f11540k = new C32991(this);
        this.f11533d = jgVar;
        this.f11537h = j;
        this.f11534e = c3302a;
    }

    private C3311d m13487b(C3427c c3427c, LogEventParcelable logEventParcelable) {
        f11531b.m13477a();
        C3311d c3311d = new C3311d(this, logEventParcelable, c3427c);
        c3311d.m13442a(new C33012(this));
        return c3311d;
    }

    private static void m13488b(LogEventParcelable logEventParcelable) {
        if (logEventParcelable.f11781f != null && logEventParcelable.f11780e.f11657k.length == 0) {
            logEventParcelable.f11780e.f11657k = logEventParcelable.f11781f.m13926a();
        }
        if (logEventParcelable.f11782g != null && logEventParcelable.f11780e.f11664r.length == 0) {
            logEventParcelable.f11780e.f11664r = logEventParcelable.f11782g.m13926a();
        }
        logEventParcelable.f11778c = km.m10116a(logEventParcelable.f11780e);
    }

    public C3304d<Status> m13491a(C3427c c3427c, LogEventParcelable logEventParcelable) {
        iw.m13488b(logEventParcelable);
        return c3427c.m14131a(m13487b(c3427c, logEventParcelable));
    }

    public boolean m13492a(C3427c c3427c, long j, TimeUnit timeUnit) {
        try {
            return f11531b.m13478a(j, timeUnit);
        } catch (InterruptedException e) {
            Log.e("ClearcutLoggerApiImpl", "flush interrupted");
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
