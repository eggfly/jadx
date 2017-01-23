package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

abstract class q {
    private static volatile Handler DW;
    private final Runnable FH;
    private volatile long Hw;
    private final ai j6;
    private boolean v5;

    class 1 implements Runnable {
        final /* synthetic */ q j6;

        1(q qVar) {
            this.j6 = qVar;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.j6.j6.gn().j6((Runnable) this);
                return;
            }
            boolean DW = this.j6.DW();
            this.j6.Hw = 0;
            if (DW && this.j6.v5) {
                this.j6.j6();
            }
        }
    }

    q(ai aiVar) {
        b.j6((Object) aiVar);
        this.j6 = aiVar;
        this.v5 = true;
        this.FH = new 1(this);
    }

    private Handler Hw() {
        if (DW != null) {
            return DW;
        }
        Handler handler;
        synchronized (q.class) {
            if (DW == null) {
                DW = new Handler(this.j6.XL().getMainLooper());
            }
            handler = DW;
        }
        return handler;
    }

    public boolean DW() {
        return this.Hw != 0;
    }

    public void FH() {
        this.Hw = 0;
        Hw().removeCallbacks(this.FH);
    }

    public abstract void j6();

    public void j6(long j) {
        FH();
        if (j >= 0) {
            this.Hw = this.j6.aM().j6();
            if (!Hw().postDelayed(this.FH, j)) {
                this.j6.Zo().Zo().j6("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
