package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.aa.a;
import java.util.concurrent.BlockingQueue;

public class ac extends Thread {
    private static final boolean j6;
    private final BlockingQueue<es<?>> DW;
    private final BlockingQueue<es<?>> FH;
    private final aa Hw;
    private volatile boolean Zo;
    private final gi v5;

    class 1 implements Runnable {
        final /* synthetic */ ac DW;
        final /* synthetic */ es j6;

        1(ac acVar, es esVar) {
            this.DW = acVar;
            this.j6 = esVar;
        }

        public void run() {
            try {
                this.DW.FH.put(this.j6);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        j6 = hq.DW;
    }

    public ac(BlockingQueue<es<?>> blockingQueue, BlockingQueue<es<?>> blockingQueue2, aa aaVar, gi giVar) {
        super("VolleyCacheDispatcher");
        this.Zo = false;
        this.DW = blockingQueue;
        this.FH = blockingQueue2;
        this.Hw = aaVar;
        this.v5 = giVar;
    }

    public void j6() {
        this.Zo = true;
        interrupt();
    }

    public void run() {
        if (j6) {
            hq.j6("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.Hw.j6();
        while (true) {
            try {
                es esVar = (es) this.DW.take();
                esVar.DW("cache-queue-take");
                if (esVar.Zo()) {
                    esVar.FH("cache-discard-canceled");
                } else {
                    a j6 = this.Hw.j6(esVar.Hw());
                    if (j6 == null) {
                        esVar.DW("cache-miss");
                        this.FH.put(esVar);
                    } else if (j6.j6()) {
                        esVar.DW("cache-hit-expired");
                        esVar.j6(j6);
                        this.FH.put(esVar);
                    } else {
                        esVar.DW("cache-hit");
                        gh j62 = esVar.j6(new ef(j6.j6, j6.VH));
                        esVar.DW("cache-hit-parsed");
                        if (j6.DW()) {
                            esVar.DW("cache-hit-refresh-needed");
                            esVar.j6(j6);
                            j62.Hw = true;
                            this.v5.j6(esVar, j62, new 1(this, esVar));
                        } else {
                            this.v5.j6(esVar, j62);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.Zo) {
                    return;
                }
            }
        }
    }
}
