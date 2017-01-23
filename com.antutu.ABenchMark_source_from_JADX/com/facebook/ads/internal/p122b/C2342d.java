package com.facebook.ads.internal.p122b;

import android.content.Context;
import com.facebook.ads.internal.p127e.p129b.C2397f;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.facebook.ads.internal.b.d */
public class C2342d {
    private static final String f8155a;
    private static C2342d f8156b;
    private final Future<C2397f> f8157c;

    /* renamed from: com.facebook.ads.internal.b.d.1 */
    class C23411 implements Callable<C2397f> {
        final /* synthetic */ Context f8153a;
        final /* synthetic */ C2342d f8154b;

        C23411(C2342d c2342d, Context context) {
            this.f8154b = c2342d;
            this.f8153a = context;
        }

        public C2397f m9030a() {
            return new C2397f(this.f8153a);
        }

        public /* synthetic */ Object call() {
            return m9030a();
        }
    }

    static {
        f8155a = C2342d.class.getSimpleName();
    }

    private C2342d(Context context) {
        this.f8157c = Executors.newSingleThreadExecutor().submit(new C23411(this, context));
    }

    public static C2342d m9031a(Context context) {
        if (f8156b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (applicationContext) {
                if (f8156b == null) {
                    f8156b = new C2342d(applicationContext);
                }
            }
        }
        return f8156b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.ads.internal.p127e.p129b.C2397f m9032a() {
        /*
        r4 = this;
        r0 = r4.f8157c;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r0 = r0.get(r2, r1);	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
        r0 = (com.facebook.ads.internal.p127e.p129b.C2397f) r0;	 Catch:{ InterruptedException -> 0x000d, ExecutionException -> 0x0017, TimeoutException -> 0x0019 }
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = move-exception;
    L_0x000e:
        r1 = f8155a;
        r2 = "Timed out waiting for cache server.";
        android.util.Log.e(r1, r2, r0);
        r0 = 0;
        goto L_0x000c;
    L_0x0017:
        r0 = move-exception;
        goto L_0x000e;
    L_0x0019:
        r0 = move-exception;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.b.d.a():com.facebook.ads.internal.e.b.f");
    }

    public void m9033a(String str) {
        C2397f a = m9032a();
        if (a != null) {
            a.m9228a(str);
        }
    }

    public String m9034b(String str) {
        C2397f a = m9032a();
        return a == null ? null : a.m9229b(str);
    }
}
