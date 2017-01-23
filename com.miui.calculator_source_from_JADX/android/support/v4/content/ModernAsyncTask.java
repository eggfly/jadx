package android.support.v4.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
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

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final ThreadFactory f382a;
    private static final BlockingQueue<Runnable> f383b;
    public static final Executor f384c;
    private static InternalHandler f385d;
    private static volatile Executor f386e;
    private final WorkerRunnable<Params, Result> f387f;
    private final FutureTask<Result> f388g;
    private volatile Status f389h;
    private final AtomicBoolean f390i;

    /* renamed from: android.support.v4.content.ModernAsyncTask.1 */
    final class C00361 implements ThreadFactory {
        private final AtomicInteger f435a;

        C00361() {
            this.f435a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f435a.getAndIncrement());
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] f436b;

        private WorkerRunnable() {
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.2 */
    class C00372 extends WorkerRunnable<Params, Result> {
        final /* synthetic */ ModernAsyncTask f437a;

        C00372(ModernAsyncTask modernAsyncTask) {
            this.f437a = modernAsyncTask;
            super();
        }

        public Result call() {
            this.f437a.f390i.set(true);
            Process.setThreadPriority(10);
            return this.f437a.m497d(this.f437a.m500a(this.b));
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.3 */
    class C00383 extends FutureTask<Result> {
        final /* synthetic */ ModernAsyncTask f438a;

        C00383(ModernAsyncTask modernAsyncTask, Callable callable) {
            this.f438a = modernAsyncTask;
            super(callable);
        }

        protected void done() {
            try {
                this.f438a.m495c(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f438a.m495c(null);
            } catch (Throwable e4) {
                RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask.4 */
    static /* synthetic */ class C00394 {
        static final /* synthetic */ int[] f439a;

        static {
            f439a = new int[Status.values().length];
            try {
                f439a[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f439a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static class AsyncTaskResult<Data> {
        final ModernAsyncTask f440a;
        final Data[] f441b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f440a = modernAsyncTask;
            this.f441b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    asyncTaskResult.f440a.m498e(asyncTaskResult.f441b[0]);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    asyncTaskResult.f440a.m506b(asyncTaskResult.f441b);
                default:
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result m500a(Params... paramsArr);

    static {
        f382a = new C00361();
        f383b = new LinkedBlockingQueue(10);
        f384c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f383b, f382a);
        f386e = f384c;
    }

    private static Handler m496d() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            if (f385d == null) {
                f385d = new InternalHandler();
            }
            handler = f385d;
        }
        return handler;
    }

    public ModernAsyncTask() {
        this.f389h = Status.PENDING;
        this.f390i = new AtomicBoolean();
        this.f387f = new C00372(this);
        this.f388g = new C00383(this, this.f387f);
    }

    private void m495c(Result result) {
        if (!this.f390i.get()) {
            m497d(result);
        }
    }

    private Result m497d(Result result) {
        m496d().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    protected void m501a() {
    }

    protected void m502a(Result result) {
    }

    protected void m506b(Progress... progressArr) {
    }

    protected void m505b(Result result) {
        m504b();
    }

    protected void m504b() {
    }

    public final boolean m507c() {
        return this.f388g.isCancelled();
    }

    public final boolean m503a(boolean z) {
        return this.f388g.cancel(z);
    }

    public final ModernAsyncTask<Params, Progress, Result> m499a(Executor executor, Params... paramsArr) {
        if (this.f389h != Status.PENDING) {
            switch (C00394.f439a[this.f389h.ordinal()]) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f389h = Status.RUNNING;
        m501a();
        this.f387f.f436b = paramsArr;
        executor.execute(this.f388g);
        return this;
    }

    private void m498e(Result result) {
        if (m507c()) {
            m505b((Object) result);
        } else {
            m502a((Object) result);
        }
        this.f389h = Status.FINISHED;
    }
}
