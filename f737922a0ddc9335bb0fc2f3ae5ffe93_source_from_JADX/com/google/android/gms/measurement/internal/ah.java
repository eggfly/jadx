package com.google.android.gms.measurement.internal;

import afq;
import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class ah extends b {
    private static final AtomicLong tp;
    private d DW;
    private final PriorityBlockingQueue<FutureTask<?>> FH;
    private final BlockingQueue<FutureTask<?>> Hw;
    private final Object VH;
    private final UncaughtExceptionHandler Zo;
    private final Semaphore gn;
    private d j6;
    private volatile boolean u7;
    private final UncaughtExceptionHandler v5;

    static class a extends RuntimeException {
    }

    private final class b implements UncaughtExceptionHandler {
        private final String DW;
        final /* synthetic */ ah j6;

        public b(ah ahVar, String str) {
            this.j6 = ahVar;
            com.google.android.gms.common.internal.b.j6((Object) str);
            this.DW = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.j6.lg().Zo().j6(this.DW, th);
        }
    }

    private final class c<V> extends FutureTask<V> implements Comparable<c> {
        private final long DW;
        private final boolean FH;
        private final String Hw;
        final /* synthetic */ ah j6;

        c(ah ahVar, Runnable runnable, boolean z, String str) {
            this.j6 = ahVar;
            super(runnable, null);
            com.google.android.gms.common.internal.b.j6((Object) str);
            this.DW = ah.tp.getAndIncrement();
            this.Hw = str;
            this.FH = z;
            if (this.DW == Long.MAX_VALUE) {
                ahVar.lg().Zo().j6("Tasks index overflow");
            }
        }

        c(ah ahVar, Callable<V> callable, boolean z, String str) {
            this.j6 = ahVar;
            super(callable);
            com.google.android.gms.common.internal.b.j6((Object) str);
            this.DW = ah.tp.getAndIncrement();
            this.Hw = str;
            this.FH = z;
            if (this.DW == Long.MAX_VALUE) {
                ahVar.lg().Zo().j6("Tasks index overflow");
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return j6((c) obj);
        }

        public int j6(c cVar) {
            if (this.FH != cVar.FH) {
                return this.FH ? -1 : 1;
            } else {
                if (this.DW < cVar.DW) {
                    return -1;
                }
                if (this.DW > cVar.DW) {
                    return 1;
                }
                this.j6.lg().VH().j6("Two tasks share the same index. index", Long.valueOf(this.DW));
                return 0;
            }
        }

        protected void setException(Throwable th) {
            this.j6.lg().Zo().j6(this.Hw, th);
            if (th instanceof a) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }
    }

    private final class d extends Thread {
        private final Object DW;
        private final BlockingQueue<FutureTask<?>> FH;
        final /* synthetic */ ah j6;

        public d(ah ahVar, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.j6 = ahVar;
            com.google.android.gms.common.internal.b.j6((Object) str);
            com.google.android.gms.common.internal.b.j6((Object) blockingQueue);
            this.DW = new Object();
            this.FH = blockingQueue;
            setName(str);
        }

        private void j6(InterruptedException interruptedException) {
            this.j6.lg().yS().j6(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        public void j6() {
            synchronized (this.DW) {
                this.DW.notifyAll();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            if (r1 != 0) goto L_0x0015;
        L_0x0004:
            r0 = r4.j6;	 Catch:{ InterruptedException -> 0x0010 }
            r0 = r0.gn;	 Catch:{ InterruptedException -> 0x0010 }
            r0.acquire();	 Catch:{ InterruptedException -> 0x0010 }
            r0 = 1;
            r1 = r0;
            goto L_0x0002;
        L_0x0010:
            r0 = move-exception;
            r4.j6(r0);
            goto L_0x0002;
        L_0x0015:
            r0 = r4.FH;	 Catch:{ all -> 0x0023 }
            r0 = r0.poll();	 Catch:{ all -> 0x0023 }
            r0 = (java.util.concurrent.FutureTask) r0;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x004d;
        L_0x001f:
            r0.run();	 Catch:{ all -> 0x0023 }
            goto L_0x0015;
        L_0x0023:
            r0 = move-exception;
            r1 = r4.j6;
            r1 = r1.VH;
            monitor-enter(r1);
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r2 = r2.gn;	 Catch:{ all -> 0x00e2 }
            r2.release();	 Catch:{ all -> 0x00e2 }
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r2 = r2.VH;	 Catch:{ all -> 0x00e2 }
            r2.notifyAll();	 Catch:{ all -> 0x00e2 }
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r2 = r2.j6;	 Catch:{ all -> 0x00e2 }
            if (r4 != r2) goto L_0x00d2;
        L_0x0045:
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r3 = 0;
            r2.j6 = r3;	 Catch:{ all -> 0x00e2 }
        L_0x004b:
            monitor-exit(r1);	 Catch:{ all -> 0x00e2 }
            throw r0;
        L_0x004d:
            r1 = r4.DW;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.FH;	 Catch:{ all -> 0x00a6 }
            r0 = r0.peek();	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0058:
            r0 = r4.j6;	 Catch:{ all -> 0x00a6 }
            r0 = r0.u7;	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0060:
            r0 = r4.DW;	 Catch:{ InterruptedException -> 0x00a1 }
            r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r0.wait(r2);	 Catch:{ InterruptedException -> 0x00a1 }
        L_0x0067:
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            r0 = r4.j6;	 Catch:{ all -> 0x0023 }
            r1 = r0.VH;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.FH;	 Catch:{ all -> 0x00cf }
            r0 = r0.peek();	 Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x00cc;
        L_0x0077:
            monitor-exit(r1);	 Catch:{ all -> 0x00cf }
            r0 = r4.j6;
            r1 = r0.VH;
            monitor-enter(r1);
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r0 = r0.gn;	 Catch:{ all -> 0x00b8 }
            r0.release();	 Catch:{ all -> 0x00b8 }
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r0 = r0.VH;	 Catch:{ all -> 0x00b8 }
            r0.notifyAll();	 Catch:{ all -> 0x00b8 }
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r0 = r0.j6;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00a9;
        L_0x0099:
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.j6 = r2;	 Catch:{ all -> 0x00b8 }
        L_0x009f:
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            return;
        L_0x00a1:
            r0 = move-exception;
            r4.j6(r0);	 Catch:{ all -> 0x00a6 }
            goto L_0x0067;
        L_0x00a6:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00a9:
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r0 = r0.DW;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00bb;
        L_0x00b1:
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.DW = r2;	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00b8:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            throw r0;
        L_0x00bb:
            r0 = r4.j6;	 Catch:{ all -> 0x00b8 }
            r0 = r0.lg();	 Catch:{ all -> 0x00b8 }
            r0 = r0.Zo();	 Catch:{ all -> 0x00b8 }
            r2 = "Current scheduler thread is neither worker nor network";
            r0.j6(r2);	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00cc:
            monitor-exit(r1);	 Catch:{ all -> 0x00cf }
            goto L_0x0015;
        L_0x00cf:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00cf }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00d2:
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r2 = r2.DW;	 Catch:{ all -> 0x00e2 }
            if (r4 != r2) goto L_0x00e5;
        L_0x00da:
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r3 = 0;
            r2.DW = r3;	 Catch:{ all -> 0x00e2 }
            goto L_0x004b;
        L_0x00e2:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00e2 }
            throw r0;
        L_0x00e5:
            r2 = r4.j6;	 Catch:{ all -> 0x00e2 }
            r2 = r2.lg();	 Catch:{ all -> 0x00e2 }
            r2 = r2.Zo();	 Catch:{ all -> 0x00e2 }
            r3 = "Current scheduler thread is neither worker nor network";
            r2.j6(r3);	 Catch:{ all -> 0x00e2 }
            goto L_0x004b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ah.d.run():void");
        }
    }

    static {
        tp = new AtomicLong(Long.MIN_VALUE);
    }

    ah(ai aiVar) {
        super(aiVar);
        this.VH = new Object();
        this.gn = new Semaphore(2);
        this.FH = new PriorityBlockingQueue();
        this.Hw = new LinkedBlockingQueue();
        this.v5 = new b(this, "Thread death: Uncaught exception on worker thread");
        this.Zo = new b(this, "Thread death: Uncaught exception on network thread");
    }

    private void j6(c<?> cVar) {
        synchronized (this.VH) {
            this.FH.add(cVar);
            if (this.j6 == null) {
                this.j6 = new d(this, "Measurement Worker", this.FH);
                this.j6.setUncaughtExceptionHandler(this.v5);
                this.j6.start();
            } else {
                this.j6.j6();
            }
        }
    }

    private void j6(FutureTask<?> futureTask) {
        synchronized (this.VH) {
            this.Hw.add(futureTask);
            if (this.DW == null) {
                this.DW = new d(this, "Measurement Network", this.Hw);
                this.DW.setUncaughtExceptionHandler(this.Zo);
                this.DW.start();
            } else {
                this.DW.j6();
            }
        }
    }

    public <V> Future<V> DW(Callable<V> callable) {
        FH();
        com.google.android.gms.common.internal.b.j6((Object) callable);
        c cVar = new c(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.j6) {
            cVar.run();
        } else {
            j6(cVar);
        }
        return cVar;
    }

    public void DW(Runnable runnable) {
        FH();
        com.google.android.gms.common.internal.b.j6((Object) runnable);
        j6(new c(this, runnable, false, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ n EQ() {
        return super.EQ();
    }

    public /* bridge */ /* synthetic */ y J0() {
        return super.J0();
    }

    public /* bridge */ /* synthetic */ r J8() {
        return super.J8();
    }

    public /* bridge */ /* synthetic */ ag Mr() {
        return super.Mr();
    }

    public /* bridge */ /* synthetic */ afq QX() {
        return super.QX();
    }

    public /* bridge */ /* synthetic */ f U2() {
        return super.U2();
    }

    public /* bridge */ /* synthetic */ d Ws() {
        return super.Ws();
    }

    public /* bridge */ /* synthetic */ Context XL() {
        return super.XL();
    }

    public /* bridge */ /* synthetic */ ah a8() {
        return super.a8();
    }

    public /* bridge */ /* synthetic */ p aM() {
        return super.aM();
    }

    public /* bridge */ /* synthetic */ o er() {
        return super.er();
    }

    public /* bridge */ /* synthetic */ void gn() {
        super.gn();
    }

    public /* bridge */ /* synthetic */ l j3() {
        return super.j3();
    }

    public <V> Future<V> j6(Callable<V> callable) {
        FH();
        com.google.android.gms.common.internal.b.j6((Object) callable);
        c cVar = new c(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.j6) {
            cVar.run();
        } else {
            j6(cVar);
        }
        return cVar;
    }

    public void j6(Runnable runnable) {
        FH();
        com.google.android.gms.common.internal.b.j6((Object) runnable);
        j6(new c(this, runnable, false, "Task exception on worker thread"));
    }

    public /* bridge */ /* synthetic */ aa lg() {
        return super.lg();
    }

    public /* bridge */ /* synthetic */ ae rN() {
        return super.rN();
    }

    public void tp() {
        if (Thread.currentThread() != this.j6) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public void u7() {
        if (Thread.currentThread() != this.DW) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    protected void v5() {
    }

    public /* bridge */ /* synthetic */ c we() {
        return super.we();
    }
}
