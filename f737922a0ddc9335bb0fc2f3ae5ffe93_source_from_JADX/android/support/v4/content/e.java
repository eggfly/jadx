package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class e<Params, Progress, Result> {
    private static final BlockingQueue<Runnable> DW;
    public static final Executor FH;
    private static b Hw;
    private static final ThreadFactory j6;
    private static volatile Executor v5;
    private final FutureTask<Result> VH;
    private final d<Params, Result> Zo;
    private volatile c gn;
    private final AtomicBoolean u7;

    static class 1 implements ThreadFactory {
        private final AtomicInteger j6;

        1() {
            this.j6 = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.j6.getAndIncrement());
        }
    }

    private static abstract class d<Params, Result> implements Callable<Result> {
        Params[] DW;

        private d() {
        }
    }

    class 2 extends d<Params, Result> {
        final /* synthetic */ e j6;

        2(e eVar) {
            this.j6 = eVar;
            super();
        }

        public Result call() {
            this.j6.u7.set(true);
            Process.setThreadPriority(10);
            return this.j6.Hw(this.j6.j6(this.DW));
        }
    }

    class 3 extends FutureTask<Result> {
        final /* synthetic */ e j6;

        3(e eVar, Callable callable) {
            this.j6 = eVar;
            super(callable);
        }

        protected void done() {
            try {
                this.j6.FH(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.j6.FH(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
            }
        }
    }

    static /* synthetic */ class 4 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[c.values().length];
            try {
                j6[c.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[c.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static class a<Data> {
        final Data[] DW;
        final e j6;

        a(e eVar, Data... dataArr) {
            this.j6 = eVar;
            this.DW = dataArr;
        }
    }

    private static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    aVar.j6.v5(aVar.DW[0]);
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    aVar.j6.DW(aVar.DW);
                default:
            }
        }
    }

    public enum c {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result j6(Params... paramsArr);

    static {
        j6 = new 1();
        DW = new LinkedBlockingQueue(10);
        FH = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, DW, j6);
        v5 = FH;
    }

    private static Handler Hw() {
        Handler handler;
        synchronized (e.class) {
            if (Hw == null) {
                Hw = new b();
            }
            handler = Hw;
        }
        return handler;
    }

    public e() {
        this.gn = c.PENDING;
        this.u7 = new AtomicBoolean();
        this.Zo = new 2(this);
        this.VH = new 3(this, this.Zo);
    }

    private void FH(Result result) {
        if (!this.u7.get()) {
            Hw(result);
        }
    }

    private Result Hw(Result result) {
        Hw().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    protected void j6() {
    }

    protected void j6(Result result) {
    }

    protected void DW(Progress... progressArr) {
    }

    protected void DW(Result result) {
        DW();
    }

    protected void DW() {
    }

    public final boolean FH() {
        return this.VH.isCancelled();
    }

    public final boolean j6(boolean z) {
        return this.VH.cancel(z);
    }

    public final e<Params, Progress, Result> j6(Executor executor, Params... paramsArr) {
        if (this.gn != c.PENDING) {
            switch (4.j6[this.gn.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.gn = c.RUNNING;
        j6();
        this.Zo.DW = paramsArr;
        executor.execute(this.VH);
        return this;
    }

    private void v5(Result result) {
        if (FH()) {
            DW((Object) result);
        } else {
            j6((Object) result);
        }
        this.gn = c.FINISHED;
    }
}
