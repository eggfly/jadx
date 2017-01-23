package com.google.android.gms.p146b;

import android.os.Process;
import com.google.android.gms.p146b.C3345w.C3369a;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.b.ax */
public class ax extends Thread {
    private static final boolean f10336a;
    private final BlockingQueue<it<?>> f10337b;
    private final BlockingQueue<it<?>> f10338c;
    private final C3345w f10339d;
    private final jl f10340e;
    private volatile boolean f10341f;

    /* renamed from: com.google.android.gms.b.ax.1 */
    class C30361 implements Runnable {
        final /* synthetic */ it f10334a;
        final /* synthetic */ ax f10335b;

        C30361(ax axVar, it itVar) {
            this.f10335b = axVar;
            this.f10334a = itVar;
        }

        public void run() {
            try {
                this.f10335b.f10338c.put(this.f10334a);
            } catch (InterruptedException e) {
            }
        }
    }

    static {
        f10336a = ke.f11609b;
    }

    public ax(BlockingQueue<it<?>> blockingQueue, BlockingQueue<it<?>> blockingQueue2, C3345w c3345w, jl jlVar) {
        this.f10341f = false;
        this.f10337b = blockingQueue;
        this.f10338c = blockingQueue2;
        this.f10339d = c3345w;
        this.f10340e = jlVar;
    }

    public void m11845a() {
        this.f10341f = true;
        interrupt();
    }

    public void run() {
        if (f10336a) {
            ke.m13613a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f10339d.m13742a();
        while (true) {
            try {
                it itVar = (it) this.f10337b.take();
                itVar.m11989b("cache-queue-take");
                if (itVar.m11995g()) {
                    itVar.m11991c("cache-discard-canceled");
                } else {
                    C3369a a = this.f10339d.m13741a(itVar.m11993e());
                    if (a == null) {
                        itVar.m11989b("cache-miss");
                        this.f10338c.put(itVar);
                    } else if (a.m13888a()) {
                        itVar.m11989b("cache-hit-expired");
                        itVar.m11982a(a);
                        this.f10338c.put(itVar);
                    } else {
                        itVar.m11989b("cache-hit");
                        jb a2 = itVar.m11983a(new gs(a.f11746a, a.f11752g));
                        itVar.m11989b("cache-hit-parsed");
                        if (a.m13889b()) {
                            itVar.m11989b("cache-hit-refresh-needed");
                            itVar.m11982a(a);
                            a2.f11560d = true;
                            this.f10340e.m12156a(itVar, a2, new C30361(this, itVar));
                        } else {
                            this.f10340e.m12155a(itVar, a2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f10341f) {
                    return;
                }
            }
        }
    }
}
