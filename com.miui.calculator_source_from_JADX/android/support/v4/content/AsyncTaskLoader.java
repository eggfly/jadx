package android.support.v4.content;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile LoadTask f403a;
    volatile LoadTask f404b;
    long f405c;
    long f406d;
    Handler f407e;
    private final Executor f408f;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        boolean f391a;
        final /* synthetic */ AsyncTaskLoader f392b;
        private final CountDownLatch f393d;

        LoadTask(AsyncTaskLoader asyncTaskLoader) {
            this.f392b = asyncTaskLoader;
            this.f393d = new CountDownLatch(1);
        }

        protected D m509a(Void... voidArr) {
            try {
                return this.f392b.m546e();
            } catch (OperationCanceledException e) {
                if (m507c()) {
                    return null;
                }
                throw e;
            }
        }

        protected void m510a(D d) {
            try {
                this.f392b.m542b(this, d);
            } finally {
                this.f393d.countDown();
            }
        }

        protected void m511b(D d) {
            try {
                this.f392b.m539a(this, d);
            } finally {
                this.f393d.countDown();
            }
        }

        public void run() {
            this.f391a = false;
            this.f392b.m544c();
        }
    }

    public abstract D m545d();

    protected void m538a() {
        super.m512a();
        m530r();
        this.f403a = new LoadTask(this);
        m544c();
    }

    protected boolean m543b() {
        boolean z = false;
        if (this.f403a != null) {
            if (this.f404b != null) {
                if (this.f403a.f391a) {
                    this.f403a.f391a = false;
                    this.f407e.removeCallbacks(this.f403a);
                }
                this.f403a = null;
            } else if (this.f403a.f391a) {
                this.f403a.f391a = false;
                this.f407e.removeCallbacks(this.f403a);
                this.f403a = null;
            } else {
                z = this.f403a.m503a(false);
                if (z) {
                    this.f404b = this.f403a;
                    m547f();
                }
                this.f403a = null;
            }
        }
        return z;
    }

    public void m540a(D d) {
    }

    void m544c() {
        if (this.f404b == null && this.f403a != null) {
            if (this.f403a.f391a) {
                this.f403a.f391a = false;
                this.f407e.removeCallbacks(this.f403a);
            }
            if (this.f405c <= 0 || SystemClock.uptimeMillis() >= this.f406d + this.f405c) {
                this.f403a.m499a(this.f408f, (Object[]) (Void[]) null);
                return;
            }
            this.f403a.f391a = true;
            this.f407e.postAtTime(this.f403a, this.f406d + this.f405c);
        }
    }

    void m539a(LoadTask loadTask, D d) {
        m540a(d);
        if (this.f404b == loadTask) {
            m536x();
            this.f406d = SystemClock.uptimeMillis();
            this.f404b = null;
            m524l();
            m544c();
        }
    }

    void m542b(LoadTask loadTask, D d) {
        if (this.f403a != loadTask) {
            m539a(loadTask, d);
        } else if (m527o()) {
            m540a(d);
        } else {
            m535w();
            this.f406d = SystemClock.uptimeMillis();
            this.f403a = null;
            m518b((Object) d);
        }
    }

    protected D m546e() {
        return m545d();
    }

    public void m547f() {
    }

    public boolean m548g() {
        return this.f404b != null;
    }

    public void m541a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m516a(str, fileDescriptor, printWriter, strArr);
        if (this.f403a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f403a);
            printWriter.print(" waiting=");
            printWriter.println(this.f403a.f391a);
        }
        if (this.f404b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f404b);
            printWriter.print(" waiting=");
            printWriter.println(this.f404b.f391a);
        }
        if (this.f405c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.m1121a(this.f405c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.m1120a(this.f406d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
