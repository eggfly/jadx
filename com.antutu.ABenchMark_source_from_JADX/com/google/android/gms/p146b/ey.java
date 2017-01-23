package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* renamed from: com.google.android.gms.b.ey */
public class ey extends Thread {
    private final BlockingQueue<it<?>> f10826a;
    private final dx f10827b;
    private final C3345w f10828c;
    private final jl f10829d;
    private volatile boolean f10830e;

    public ey(BlockingQueue<it<?>> blockingQueue, dx dxVar, C3345w c3345w, jl jlVar) {
        this.f10830e = false;
        this.f10826a = blockingQueue;
        this.f10827b = dxVar;
        this.f10828c = c3345w;
        this.f10829d = jlVar;
    }

    @TargetApi(14)
    private void m12661a(it<?> itVar) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(itVar.m11990c());
        }
    }

    private void m12662a(it<?> itVar, jz jzVar) {
        this.f10829d.m12157a((it) itVar, itVar.m11984a(jzVar));
    }

    public void m12663a() {
        this.f10830e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                it itVar = (it) this.f10826a.take();
                try {
                    itVar.m11989b("network-queue-take");
                    if (itVar.m11995g()) {
                        itVar.m11991c("network-discard-cancelled");
                    } else {
                        m12661a(itVar);
                        gs a = this.f10827b.m12415a(itVar);
                        itVar.m11989b("network-http-complete");
                        if (a.f11164d && itVar.m12009u()) {
                            itVar.m11991c("not-modified");
                        } else {
                            jb a2 = itVar.m11983a(a);
                            itVar.m11989b("network-parse-complete");
                            if (itVar.m12004p() && a2.f11558b != null) {
                                this.f10828c.m13743a(itVar.m11993e(), a2.f11558b);
                                itVar.m11989b("network-cache-written");
                            }
                            itVar.m12008t();
                            this.f10829d.m12155a(itVar, a2);
                        }
                    }
                } catch (jz e) {
                    e.m11729a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m12662a(itVar, e);
                } catch (Throwable e2) {
                    ke.m13614a(e2, "Unhandled exception %s", e2.toString());
                    jz jzVar = new jz(e2);
                    jzVar.m11729a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f10829d.m12157a(itVar, jzVar);
                }
            } catch (InterruptedException e3) {
                if (this.f10830e) {
                    return;
                }
            }
        }
    }
}
