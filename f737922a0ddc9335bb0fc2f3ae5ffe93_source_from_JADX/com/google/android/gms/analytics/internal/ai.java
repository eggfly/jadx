package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

abstract class ai {
    private static volatile Handler DW;
    private final Runnable FH;
    private volatile long Hw;
    private final v j6;

    class 1 implements Runnable {
        final /* synthetic */ ai j6;

        1(ai aiVar) {
            this.j6 = aiVar;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.j6.j6.gn().j6((Runnable) this);
                return;
            }
            boolean FH = this.j6.FH();
            this.j6.Hw = 0;
            if (FH && !false) {
                this.j6.j6();
            }
        }
    }

    ai(v vVar) {
        b.j6((Object) vVar);
        this.j6 = vVar;
        this.FH = new 1(this);
    }

    private Handler v5() {
        if (DW != null) {
            return DW;
        }
        Handler handler;
        synchronized (ai.class) {
            if (DW == null) {
                DW = new Handler(this.j6.DW().getMainLooper());
            }
            handler = DW;
        }
        return handler;
    }

    public long DW() {
        return this.Hw == 0 ? 0 : Math.abs(this.j6.Hw().j6() - this.Hw);
    }

    public void DW(long j) {
        long j2 = 0;
        if (!FH()) {
            return;
        }
        if (j < 0) {
            Hw();
            return;
        }
        long abs = j - Math.abs(this.j6.Hw().j6() - this.Hw);
        if (abs >= 0) {
            j2 = abs;
        }
        v5().removeCallbacks(this.FH);
        if (!v5().postDelayed(this.FH, j2)) {
            this.j6.Zo().v5("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }

    public boolean FH() {
        return this.Hw != 0;
    }

    public void Hw() {
        this.Hw = 0;
        v5().removeCallbacks(this.FH);
    }

    public abstract void j6();

    public void j6(long j) {
        Hw();
        if (j >= 0) {
            this.Hw = this.j6.Hw().j6();
            if (!v5().postDelayed(this.FH, j)) {
                this.j6.Zo().v5("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
