package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.f;

@eh
public class cg extends en {
    final ci DW;
    private final String FH;
    final fj j6;

    class 1 implements Runnable {
        final /* synthetic */ cg j6;

        1(cg cgVar) {
            this.j6 = cgVar;
        }

        public void run() {
            f.EQ().DW(this.j6);
        }
    }

    cg(fj fjVar, ci ciVar, String str) {
        this.j6 = fjVar;
        this.DW = ciVar;
        this.FH = str;
        f.EQ().j6(this);
    }

    public void j6() {
        try {
            this.DW.j6(this.FH);
        } finally {
            et.j6.post(new 1(this));
        }
    }
}
