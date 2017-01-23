package com.google.android.gms.p146b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@gb
/* renamed from: com.google.android.gms.b.hy */
public class hy {

    /* renamed from: com.google.android.gms.b.hy.a */
    public interface C3212a<D, R> {
        R m12761a(D d);
    }

    /* renamed from: com.google.android.gms.b.hy.1 */
    static class C32761 implements Runnable {
        final /* synthetic */ hw f11361a;
        final /* synthetic */ C3212a f11362b;
        final /* synthetic */ hz f11363c;

        C32761(hw hwVar, C3212a c3212a, hz hzVar) {
            this.f11361a = hwVar;
            this.f11362b = c3212a;
            this.f11363c = hzVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.f11361a;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r3.f11362b;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r3.f11363c;	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r2 = r2.get();	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r1 = r1.m12761a(r2);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
            r0.m12217b(r1);	 Catch:{ CancellationException -> 0x001c, InterruptedException -> 0x001a, ExecutionException -> 0x0012 }
        L_0x0011:
            return;
        L_0x0012:
            r0 = move-exception;
        L_0x0013:
            r0 = r3.f11361a;
            r1 = 1;
            r0.cancel(r1);
            goto L_0x0011;
        L_0x001a:
            r0 = move-exception;
            goto L_0x0013;
        L_0x001c:
            r0 = move-exception;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.hy.1.run():void");
        }
    }

    /* renamed from: com.google.android.gms.b.hy.2 */
    static class C32772 implements Runnable {
        final /* synthetic */ AtomicInteger f11364a;
        final /* synthetic */ int f11365b;
        final /* synthetic */ hw f11366c;
        final /* synthetic */ List f11367d;

        C32772(AtomicInteger atomicInteger, int i, hw hwVar, List list) {
            this.f11364a = atomicInteger;
            this.f11365b = i;
            this.f11366c = hwVar;
            this.f11367d = list;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r2 = this;
            r0 = r2.f11364a;
            r0 = r0.incrementAndGet();
            r1 = r2.f11365b;
            if (r0 < r1) goto L_0x0015;
        L_0x000a:
            r0 = r2.f11366c;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = r2.f11367d;	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r1 = com.google.android.gms.p146b.hy.m13172c(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
            r0.m12217b(r1);	 Catch:{ ExecutionException -> 0x001d, InterruptedException -> 0x0016 }
        L_0x0015:
            return;
        L_0x0016:
            r0 = move-exception;
        L_0x0017:
            r1 = "Unable to convert list of futures to a future of list";
            com.google.android.gms.ads.internal.util.client.C2972b.m11584d(r1, r0);
            goto L_0x0015;
        L_0x001d:
            r0 = move-exception;
            goto L_0x0017;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.hy.2.run():void");
        }
    }

    public static <A, B> hz<B> m13169a(hz<A> hzVar, C3212a<A, B> c3212a) {
        hz hwVar = new hw();
        hzVar.m12215a(new C32761(hwVar, c3212a, hzVar));
        return hwVar;
    }

    public static <V> hz<List<V>> m13170a(List<hz<V>> list) {
        hz hwVar = new hw();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (hz a : list) {
            a.m12215a(new C32772(atomicInteger, size, hwVar, list));
        }
        return hwVar;
    }

    private static <V> List<V> m13172c(List<hz<V>> list) {
        List<V> arrayList = new ArrayList();
        for (hz hzVar : list) {
            Object obj = hzVar.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
