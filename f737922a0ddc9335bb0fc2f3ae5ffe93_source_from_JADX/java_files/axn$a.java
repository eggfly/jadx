import org.eclipse.jgit.JGitText;

final class axn$a implements Runnable {
    private long DW;
    private boolean FH;
    private Thread j6;

    axn$a() {
        this.j6 = Thread.currentThread();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void run() {
        /*
        r6 = this;
        r4 = 0;
        monitor-enter(r6);
    L_0x0003:
        r0 = r6.FH;	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x000f;
    L_0x0007:
        r0 = r6.j6;	 Catch:{ all -> 0x0032 }
        r0 = r0.isAlive();	 Catch:{ all -> 0x0032 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r6);
        return;
    L_0x0011:
        r0 = r6.DW;	 Catch:{ InterruptedException -> 0x002c }
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0035;
    L_0x0017:
        r0 = r6.DW;	 Catch:{ InterruptedException -> 0x002c }
        r2 = FH();	 Catch:{ InterruptedException -> 0x002c }
        r0 = r0 - r2;
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x002e;
    L_0x0022:
        r0 = 0;
        r6.DW = r0;	 Catch:{ InterruptedException -> 0x002c }
        r0 = r6.j6;	 Catch:{ InterruptedException -> 0x002c }
        r0.interrupt();	 Catch:{ InterruptedException -> 0x002c }
        goto L_0x0003;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0003;
    L_0x002e:
        r6.wait(r0);	 Catch:{ InterruptedException -> 0x002c }
        goto L_0x0003;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0035:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6.wait(r0);	 Catch:{ InterruptedException -> 0x002c }
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: axn$a.run():void");
    }

    synchronized void j6(int i) {
        if (this.FH) {
            throw new IllegalStateException(JGitText.j6().timerAlreadyTerminated);
        }
        this.j6 = Thread.currentThread();
        this.DW = FH() + ((long) i);
        notifyAll();
    }

    synchronized void j6() {
        if (0 == this.DW) {
            Thread.interrupted();
        } else {
            this.DW = 0;
        }
        notifyAll();
    }

    synchronized void DW() {
        if (!this.FH) {
            this.DW = 0;
            this.FH = true;
            notifyAll();
        }
    }

    private static long FH() {
        return System.currentTimeMillis();
    }
}
