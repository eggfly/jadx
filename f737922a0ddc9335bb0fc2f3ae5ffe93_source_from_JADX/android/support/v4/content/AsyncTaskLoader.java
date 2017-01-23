package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import t;

public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile a DW;
    long FH;
    long Hw;
    private final Executor Zo;
    volatile a j6;
    Handler v5;

    final class a extends e<Void, Void, D> implements Runnable {
        final /* synthetic */ AsyncTaskLoader DW;
        private final CountDownLatch Hw;
        boolean j6;

        a(AsyncTaskLoader asyncTaskLoader) {
            this.DW = asyncTaskLoader;
            this.Hw = new CountDownLatch(1);
        }

        protected D j6(Void... voidArr) {
            try {
                return this.DW.v5();
            } catch (g e) {
                if (FH()) {
                    return null;
                }
                throw e;
            }
        }

        protected void j6(D d) {
            try {
                this.DW.DW(this, d);
            } finally {
                this.Hw.countDown();
            }
        }

        protected void DW(D d) {
            try {
                this.DW.j6(this, d);
            } finally {
                this.Hw.countDown();
            }
        }

        public void run() {
            this.j6 = false;
            this.DW.FH();
        }
    }

    public abstract D Hw();

    public AsyncTaskLoader(Context context) {
        this(context, e.FH);
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.Hw = -10000;
        this.Zo = executor;
    }

    protected void j6() {
        super.j6();
        aM();
        this.j6 = new a(this);
        FH();
    }

    protected boolean DW() {
        boolean z = false;
        if (this.j6 != null) {
            if (this.DW != null) {
                if (this.j6.j6) {
                    this.j6.j6 = false;
                    this.v5.removeCallbacks(this.j6);
                }
                this.j6 = null;
            } else if (this.j6.j6) {
                this.j6.j6 = false;
                this.v5.removeCallbacks(this.j6);
                this.j6 = null;
            } else {
                z = this.j6.j6(false);
                if (z) {
                    this.DW = this.j6;
                    Zo();
                }
                this.j6 = null;
            }
        }
        return z;
    }

    public void j6(D d) {
    }

    void FH() {
        if (this.DW == null && this.j6 != null) {
            if (this.j6.j6) {
                this.j6.j6 = false;
                this.v5.removeCallbacks(this.j6);
            }
            if (this.FH <= 0 || SystemClock.uptimeMillis() >= this.Hw + this.FH) {
                this.j6.j6(this.Zo, (Object[]) (Void[]) null);
                return;
            }
            this.j6.j6 = true;
            this.v5.postAtTime(this.j6, this.Hw + this.FH);
        }
    }

    void j6(a aVar, D d) {
        j6(d);
        if (this.DW == aVar) {
            rN();
            this.Hw = SystemClock.uptimeMillis();
            this.DW = null;
            we();
            FH();
        }
    }

    void DW(a aVar, D d) {
        if (this.j6 != aVar) {
            j6(aVar, d);
        } else if (Ws()) {
            j6(d);
        } else {
            lg();
            this.Hw = SystemClock.uptimeMillis();
            this.j6 = null;
            DW((Object) d);
        }
    }

    protected D v5() {
        return Hw();
    }

    public void Zo() {
    }

    public boolean VH() {
        return this.DW != null;
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.j6(str, fileDescriptor, printWriter, strArr);
        if (this.j6 != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.j6);
            printWriter.print(" waiting=");
            printWriter.println(this.j6.j6);
        }
        if (this.DW != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.DW);
            printWriter.print(" waiting=");
            printWriter.println(this.DW.j6);
        }
        if (this.FH != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            t.j6(this.FH, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            t.j6(this.Hw, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
