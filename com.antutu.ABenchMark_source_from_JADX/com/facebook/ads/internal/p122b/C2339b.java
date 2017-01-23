package com.facebook.ads.internal.p122b;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.facebook.ads.internal.b.b */
public class C2339b {
    private static final String f8144a;
    private final Handler f8145b;
    private final ExecutorService f8146c;
    private final C2340c f8147d;
    private final C2342d f8148e;
    private final List<Callable<Boolean>> f8149f;

    /* renamed from: com.facebook.ads.internal.b.b.1 */
    class C23361 implements Runnable {
        final /* synthetic */ ArrayList f8137a;
        final /* synthetic */ C2261a f8138b;
        final /* synthetic */ C2339b f8139c;

        /* renamed from: com.facebook.ads.internal.b.b.1.1 */
        class C23351 implements Runnable {
            final /* synthetic */ C23361 f8136a;

            C23351(C23361 c23361) {
                this.f8136a = c23361;
            }

            public void run() {
                this.f8136a.f8138b.m8563a();
            }
        }

        C23361(C2339b c2339b, ArrayList arrayList, C2261a c2261a) {
            this.f8139c = c2339b;
            this.f8137a = arrayList;
            this.f8138b = c2261a;
        }

        public void run() {
            Throwable e;
            List<Future> arrayList = new ArrayList(this.f8137a.size());
            Iterator it = this.f8137a.iterator();
            while (it.hasNext()) {
                arrayList.add(this.f8139c.f8146c.submit((Callable) it.next()));
            }
            try {
                for (Future future : arrayList) {
                    future.get();
                }
            } catch (InterruptedException e2) {
                e = e2;
                Log.e(C2339b.f8144a, "Exception while executing cache downloads.", e);
                this.f8139c.f8145b.post(new C23351(this));
            } catch (ExecutionException e3) {
                e = e3;
                Log.e(C2339b.f8144a, "Exception while executing cache downloads.", e);
                this.f8139c.f8145b.post(new C23351(this));
            }
            this.f8139c.f8145b.post(new C23351(this));
        }
    }

    /* renamed from: com.facebook.ads.internal.b.b.a */
    private class C2337a implements Callable<Boolean> {
        final /* synthetic */ C2339b f8140a;
        private final String f8141b;

        public C2337a(C2339b c2339b, String str) {
            this.f8140a = c2339b;
            this.f8141b = str;
        }

        public Boolean m9014a() {
            this.f8140a.f8147d.m9028a(this.f8141b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m9014a();
        }
    }

    /* renamed from: com.facebook.ads.internal.b.b.b */
    private class C2338b implements Callable<Boolean> {
        final /* synthetic */ C2339b f8142a;
        private final String f8143b;

        public C2338b(C2339b c2339b, String str) {
            this.f8142a = c2339b;
            this.f8143b = str;
        }

        public Boolean m9015a() {
            this.f8142a.f8148e.m9033a(this.f8143b);
            return Boolean.valueOf(true);
        }

        public /* synthetic */ Object call() {
            return m9015a();
        }
    }

    static {
        f8144a = C2339b.class.getSimpleName();
    }

    public C2339b(Context context) {
        this.f8145b = new Handler();
        this.f8146c = Executors.newFixedThreadPool(10);
        this.f8147d = C2340c.m9025a(context);
        this.f8148e = C2342d.m9031a(context);
        this.f8149f = new ArrayList();
    }

    public void m9021a(C2261a c2261a) {
        this.f8146c.submit(new C23361(this, new ArrayList(this.f8149f), c2261a));
        this.f8149f.clear();
    }

    public void m9022a(String str) {
        this.f8149f.add(new C2337a(this, str));
    }

    public void m9023b(String str) {
        this.f8149f.add(new C2338b(this, str));
    }

    public String m9024c(String str) {
        return this.f8148e.m9034b(str);
    }
}
