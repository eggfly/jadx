package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.a;
import java.util.ArrayList;
import java.util.List;

@eh
class fc {
    private final List<Runnable> DW;
    private final List<Runnable> FH;
    private boolean Hw;
    private final Object j6;

    public fc() {
        this.j6 = new Object();
        this.DW = new ArrayList();
        this.FH = new ArrayList();
        this.Hw = false;
    }

    private void DW(Runnable runnable) {
        er.j6(runnable);
    }

    private void FH(Runnable runnable) {
        a.j6.post(runnable);
    }

    public void j6() {
        synchronized (this.j6) {
            if (this.Hw) {
                return;
            }
            for (Runnable DW : this.DW) {
                DW(DW);
            }
            for (Runnable DW2 : this.FH) {
                FH(DW2);
            }
            this.DW.clear();
            this.FH.clear();
            this.Hw = true;
        }
    }

    public void j6(Runnable runnable) {
        synchronized (this.j6) {
            if (this.Hw) {
                FH(runnable);
            } else {
                this.FH.add(runnable);
            }
        }
    }
}
