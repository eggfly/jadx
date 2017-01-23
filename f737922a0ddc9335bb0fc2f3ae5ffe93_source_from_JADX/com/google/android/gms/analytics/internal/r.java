package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.p;
import com.google.android.gms.common.internal.b;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class r extends t {
    private final aa j6;

    class 1 implements Runnable {
        final /* synthetic */ r DW;
        final /* synthetic */ boolean j6;

        1(r rVar, boolean z) {
            this.DW = rVar;
            this.j6 = z;
        }

        public void run() {
            this.DW.j6.j6(this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ Runnable DW;
        final /* synthetic */ r FH;
        final /* synthetic */ String j6;

        2(r rVar, String str, Runnable runnable) {
            this.FH = rVar;
            this.j6 = str;
            this.DW = runnable;
        }

        public void run() {
            this.FH.j6.j6(this.j6);
            if (this.DW != null) {
                this.DW.run();
            }
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ r DW;
        final /* synthetic */ c j6;

        3(r rVar, c cVar) {
            this.DW = rVar;
            this.j6 = cVar;
        }

        public void run() {
            this.DW.j6.j6(this.j6);
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ r j6;

        4(r rVar) {
            this.j6 = rVar;
        }

        public void run() {
            this.j6.j6.gn();
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ r DW;
        final /* synthetic */ al j6;

        5(r rVar, al alVar) {
            this.DW = rVar;
            this.j6 = alVar;
        }

        public void run() {
            this.DW.j6.j6(this.j6);
        }
    }

    class 6 implements Callable<Void> {
        final /* synthetic */ r j6;

        6(r rVar) {
            this.j6 = rVar;
        }

        public /* synthetic */ Object call() {
            return j6();
        }

        public Void j6() {
            this.j6.j6.nw();
            return null;
        }
    }

    public r(v vVar, zzg com_google_android_gms_analytics_internal_zzg) {
        super(vVar);
        b.j6((Object) com_google_android_gms_analytics_internal_zzg);
        this.j6 = com_google_android_gms_analytics_internal_zzg.tp(vVar);
    }

    public void DW() {
        this.j6.DW();
    }

    public void FH() {
        P8();
        we();
        aM().j6(new 4(this));
    }

    public void Hw() {
        P8();
        Context Ws = Ws();
        if (k.j6(Ws) && l.j6(Ws)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(Ws, "com.google.android.gms.analytics.AnalyticsService"));
            Ws.startService(intent);
            return;
        }
        j6(null);
    }

    public void VH() {
        DW("Radio powered up");
        Hw();
    }

    public void Zo() {
        P8();
        p.Hw();
        this.j6.Zo();
    }

    void gn() {
        J0();
        this.j6.v5();
    }

    public long j6(w wVar) {
        P8();
        b.j6((Object) wVar);
        J0();
        long j6 = this.j6.j6(wVar, true);
        if (j6 == 0) {
            this.j6.j6(wVar);
        }
        return j6;
    }

    protected void j6() {
        this.j6.ei();
    }

    public void j6(al alVar) {
        P8();
        aM().j6(new 5(this, alVar));
    }

    public void j6(c cVar) {
        b.j6((Object) cVar);
        P8();
        DW("Hit delivery requested", cVar);
        aM().j6(new 3(this, cVar));
    }

    public void j6(String str, Runnable runnable) {
        b.j6(str, (Object) "campaign param can't be empty");
        aM().j6(new 2(this, str, runnable));
    }

    public void j6(boolean z) {
        j6("Network connectivity status changed", Boolean.valueOf(z));
        aM().j6(new 1(this, z));
    }

    void u7() {
        J0();
        this.j6.Hw();
    }

    public boolean v5() {
        P8();
        try {
            aM().j6(new 6(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            Hw("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            v5("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            Hw("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }
}
