package com.google.android.gms.internal;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

@eh
public class ap {
    private boolean DW;
    private SharedPreferences FH;
    private final Object j6;

    class 1 implements Callable<T> {
        final /* synthetic */ ap DW;
        final /* synthetic */ am j6;

        1(ap apVar, am amVar) {
            this.DW = apVar;
            this.j6 = amVar;
        }

        public T call() {
            return this.j6.j6(this.DW.FH);
        }
    }

    public ap() {
        this.j6 = new Object();
        this.DW = false;
        this.FH = null;
    }

    public <T> T j6(am<T> amVar) {
        synchronized (this.j6) {
            if (this.DW) {
                return ey.j6(new 1(this, amVar));
            }
            T DW = amVar.DW();
            return DW;
        }
    }
}
