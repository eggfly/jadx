package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class bt implements gi {
    private final Executor j6;

    class 1 implements Executor {
        final /* synthetic */ bt DW;
        final /* synthetic */ Handler j6;

        1(bt btVar, Handler handler) {
            this.DW = btVar;
            this.j6 = handler;
        }

        public void execute(Runnable runnable) {
            this.j6.post(runnable);
        }
    }

    private class a implements Runnable {
        private final es DW;
        private final gh FH;
        private final Runnable Hw;
        final /* synthetic */ bt j6;

        public a(bt btVar, es esVar, gh ghVar, Runnable runnable) {
            this.j6 = btVar;
            this.DW = esVar;
            this.FH = ghVar;
            this.Hw = runnable;
        }

        public void run() {
            if (this.DW.Zo()) {
                this.DW.FH("canceled-at-delivery");
                return;
            }
            if (this.FH.j6()) {
                this.DW.j6(this.FH.j6);
            } else {
                this.DW.DW(this.FH.FH);
            }
            if (this.FH.Hw) {
                this.DW.DW("intermediate-response");
            } else {
                this.DW.FH("done");
            }
            if (this.Hw != null) {
                this.Hw.run();
            }
        }
    }

    public bt(Handler handler) {
        this.j6 = new 1(this, handler);
    }

    public void j6(es<?> esVar, gh<?> ghVar) {
        j6(esVar, ghVar, null);
    }

    public void j6(es<?> esVar, gh<?> ghVar, Runnable runnable) {
        esVar.Mr();
        esVar.DW("post-response");
        this.j6.execute(new a(this, esVar, ghVar, runnable));
    }

    public void j6(es<?> esVar, hp hpVar) {
        esVar.DW("post-error");
        this.j6.execute(new a(this, esVar, gh.j6(hpVar), null));
    }
}
