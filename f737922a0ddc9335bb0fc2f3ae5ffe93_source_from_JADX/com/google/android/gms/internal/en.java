package com.google.android.gms.internal;

import java.util.concurrent.Future;

@eh
public abstract class en {
    private volatile Thread DW;
    private boolean FH;
    private final Runnable j6;

    class 1 implements Runnable {
        final /* synthetic */ en j6;

        1(en enVar) {
            this.j6 = enVar;
        }

        public final void run() {
            this.j6.DW = Thread.currentThread();
            this.j6.j6();
        }
    }

    public en() {
        this.j6 = new 1(this);
        this.FH = false;
    }

    public final Future DW() {
        return this.FH ? er.j6(1, this.j6) : er.j6(this.j6);
    }

    public /* synthetic */ Object FH() {
        return DW();
    }

    public abstract void j6();
}
