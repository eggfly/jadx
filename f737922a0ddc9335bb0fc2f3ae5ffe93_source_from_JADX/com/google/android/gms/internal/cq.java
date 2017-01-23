package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class cq extends Thread {
    private final cl DW;
    private final aa FH;
    private final gi Hw;
    private final BlockingQueue<es<?>> j6;
    private volatile boolean v5;

    public cq(BlockingQueue<es<?>> blockingQueue, cl clVar, aa aaVar, gi giVar) {
        super("VolleyNetworkDispatcher");
        this.v5 = false;
        this.j6 = blockingQueue;
        this.DW = clVar;
        this.FH = aaVar;
        this.Hw = giVar;
    }

    @TargetApi(14)
    private void j6(es<?> esVar) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(esVar.DW());
        }
    }

    private void j6(es<?> esVar, hp hpVar) {
        this.Hw.j6((es) esVar, esVar.j6(hpVar));
    }

    public void j6() {
        this.v5 = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                es esVar = (es) this.j6.take();
                try {
                    esVar.DW("network-queue-take");
                    if (esVar.Zo()) {
                        esVar.FH("network-discard-cancelled");
                    } else {
                        j6(esVar);
                        ef j6 = this.DW.j6(esVar);
                        esVar.DW("network-http-complete");
                        if (j6.Hw && esVar.U2()) {
                            esVar.FH("not-modified");
                        } else {
                            gh j62 = esVar.j6(j6);
                            esVar.DW("network-parse-complete");
                            if (esVar.QX() && j62.DW != null) {
                                this.FH.j6(esVar.Hw(), j62.DW);
                                esVar.DW("network-cache-written");
                            }
                            esVar.Mr();
                            this.Hw.j6(esVar, j62);
                        }
                    }
                } catch (hp e) {
                    e.j6(SystemClock.elapsedRealtime() - elapsedRealtime);
                    j6(esVar, e);
                } catch (Throwable e2) {
                    hq.j6(e2, "Unhandled exception %s", e2.toString());
                    hp hpVar = new hp(e2);
                    hpVar.j6(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.Hw.j6(esVar, hpVar);
                }
            } catch (InterruptedException e3) {
                if (this.v5) {
                    return;
                }
            }
        }
    }
}
