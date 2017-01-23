package com.xiaomi.mistatistic.sdk.controller;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.mistatistic.sdk.controller.d */
public class C0555d {
    private static C0555d f4719a;
    private static C0555d f4720b;
    private volatile Handler f4721c;
    private ArrayList<C0523a> f4722d;

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.d.a */
    public interface C0523a {
        void m6250a();
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.d.1 */
    class C05521 implements Runnable {
        final /* synthetic */ C0523a f4713a;
        final /* synthetic */ C0555d f4714b;

        C05521(C0555d c0555d, C0523a c0523a) {
            this.f4714b = c0555d;
            this.f4713a = c0523a;
        }

        public void run() {
            try {
                this.f4713a.m6250a();
            } catch (Throwable e) {
                C0566h.m6418a("error while executing job.", e);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.d.2 */
    class C05532 implements Runnable {
        final /* synthetic */ long f4715a;
        final /* synthetic */ C0523a f4716b;
        final /* synthetic */ C0555d f4717c;

        C05532(C0555d c0555d, long j, C0523a c0523a) {
            this.f4717c = c0555d;
            this.f4715a = j;
            this.f4716b = c0523a;
        }

        public void run() {
            try {
                C0566h.m6414a("AsyncJobDispatcher run a job with delay " + String.valueOf(this.f4715a));
                this.f4716b.m6250a();
            } catch (Throwable e) {
                C0566h.m6418a("error while executing job.", e);
            }
        }
    }

    /* renamed from: com.xiaomi.mistatistic.sdk.controller.d.b */
    private class C0554b extends HandlerThread {
        final /* synthetic */ C0555d f4718a;

        public C0554b(C0555d c0555d, String str) {
            this.f4718a = c0555d;
            super(str);
        }

        protected void onLooperPrepared() {
            this.f4718a.f4721c = new Handler();
            ArrayList arrayList = null;
            synchronized (this.f4718a.f4722d) {
                if (!this.f4718a.f4722d.isEmpty()) {
                    arrayList = (ArrayList) this.f4718a.f4722d.clone();
                    String valueOf = String.valueOf(this.f4718a.f4722d.size());
                    this.f4718a.f4722d.clear();
                    C0566h.m6414a("mPendingJob(cnt=" + valueOf + ") not empty, clone a job list and clear original list");
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C0523a c0523a = (C0523a) it.next();
                    try {
                        C0566h.m6414a("execute a pending job");
                        c0523a.m6250a();
                    } catch (Throwable e) {
                        C0566h.m6418a("error while executing job.", e);
                    }
                }
            }
            super.onLooperPrepared();
        }
    }

    static {
        f4719a = null;
        f4720b = null;
    }

    public static synchronized C0555d m6362a() {
        C0555d c0555d;
        synchronized (C0555d.class) {
            if (f4719a == null) {
                f4719a = new C0555d("local_job_dispatcher");
            }
            c0555d = f4719a;
        }
        return c0555d;
    }

    public static synchronized C0555d m6364b() {
        C0555d c0555d;
        synchronized (C0555d.class) {
            if (f4720b == null) {
                f4720b = new C0555d("remote_job_dispatcher");
            }
            c0555d = f4720b;
        }
        return c0555d;
    }

    private C0555d(String str) {
        this.f4722d = new ArrayList();
        new C0554b(this, str).start();
    }

    public void m6365a(C0523a c0523a) {
        synchronized (this.f4722d) {
            if (this.f4721c == null) {
                C0566h.m6414a("AsyncJobDispatcher.mHander is null, add job to pending queue");
                this.f4722d.add(c0523a);
            } else {
                this.f4721c.post(new C05521(this, c0523a));
            }
        }
    }

    public void m6366a(C0523a c0523a, long j) {
        if (this.f4721c != null) {
            this.f4721c.postDelayed(new C05532(this, j, c0523a), j);
        } else {
            C0566h.m6418a("drop the job as handler is not ready.", null);
        }
    }
}
