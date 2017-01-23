package anet.channel.p019c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: anet.channel.c.b */
class C0658b extends ThreadPoolExecutor {

    /* renamed from: anet.channel.c.b.a */
    class C0657a<V> extends FutureTask<V> implements Comparable<C0657a<V>> {
        final /* synthetic */ C0658b f2196a;
        private Object f2197b;

        public C0657a(C0658b c0658b, Runnable runnable, V v) {
            this.f2196a = c0658b;
            super(runnable, v);
            this.f2197b = runnable;
        }

        public C0657a(C0658b c0658b, Callable<V> callable) {
            this.f2196a = c0658b;
            super(callable);
            this.f2197b = callable;
        }

        public int m2782a(C0657a<V> c0657a) {
            return this == c0657a ? 0 : c0657a == null ? -1 : (this.f2197b == null || c0657a.f2197b == null || !this.f2197b.getClass().equals(c0657a.f2197b.getClass()) || !(this.f2197b instanceof Comparable)) ? 0 : ((Comparable) this.f2197b).compareTo(c0657a.f2197b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m2782a((C0657a) obj);
        }
    }

    public C0658b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0657a(this, runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0657a(this, callable);
    }
}
