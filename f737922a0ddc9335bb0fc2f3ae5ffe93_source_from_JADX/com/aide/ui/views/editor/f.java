package com.aide.ui.views.editor;

import android.os.Handler;

public abstract class f implements Runnable {
    private Handler DW;
    private long FH;
    private boolean j6;

    public abstract void j6();

    public f() {
        this(0);
    }

    public f(long j) {
        this.DW = new Handler();
        this.FH = j;
    }

    public synchronized void DW() {
        if (!this.j6) {
            this.j6 = true;
            if (this.FH == 0) {
                this.DW.post(this);
            } else {
                this.DW.postDelayed(this, this.FH);
            }
        }
    }

    public synchronized boolean FH() {
        return this.j6;
    }

    public void run() {
        synchronized (this) {
            this.j6 = false;
        }
        j6();
    }
}
