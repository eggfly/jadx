class pd$3 implements Runnable {
    final /* synthetic */ Runnable DW;
    final /* synthetic */ pd FH;
    final /* synthetic */ Runnable j6;

    pd$3(pd pdVar, Runnable runnable, Runnable runnable2) {
        this.FH = pdVar;
        this.j6 = runnable;
        this.DW = runnable2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
        r0 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x003b }
        r1 = "su";
        r0 = r0.exec(r1);	 Catch:{ Throwable -> 0x003b }
        r1 = new java.io.DataOutputStream;	 Catch:{ Throwable -> 0x003b }
        r2 = r0.getOutputStream();	 Catch:{ Throwable -> 0x003b }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x003b }
        r2 = "echo hello\n";
        r1.writeBytes(r2);	 Catch:{ Throwable -> 0x003b }
        r2 = "exit\n";
        r1.writeBytes(r2);	 Catch:{ Throwable -> 0x003b }
        r1.flush();	 Catch:{ Throwable -> 0x003b }
        r0.waitFor();	 Catch:{ Throwable -> 0x003b }
        r0 = r0.exitValue();	 Catch:{ Throwable -> 0x003b }
        if (r0 != 0) goto L_0x0032;
    L_0x002c:
        r0 = r3.FH;	 Catch:{ Throwable -> 0x003b }
        r1 = 1;
        r0.j6 = r1;	 Catch:{ Throwable -> 0x003b }
    L_0x0032:
        r0 = new pd$3$1;
        r0.<init>(r3);
        com.aide.ui.e.j6(r0);
    L_0x003a:
        return;
    L_0x003b:
        r0 = move-exception;
        com.aide.common.e.j6(r0);	 Catch:{ all -> 0x0048 }
        r0 = new pd$3$1;
        r0.<init>(r3);
        com.aide.ui.e.j6(r0);
        goto L_0x003a;
    L_0x0048:
        r0 = move-exception;
        r1 = new pd$3$1;
        r1.<init>(r3);
        com.aide.ui.e.j6(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: pd$3.run():void");
    }
}
