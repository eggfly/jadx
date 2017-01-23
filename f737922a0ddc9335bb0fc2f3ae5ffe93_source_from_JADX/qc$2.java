class qc$2 extends Thread {
    final /* synthetic */ qc j6;

    qc$2(qc qcVar, String str) {
        this.j6 = qcVar;
        super(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r3 = this;
        r0 = r3.j6;	 Catch:{ Throwable -> 0x009e }
        r0 = r0.EQ;	 Catch:{ Throwable -> 0x009e }
        if (r0 == 0) goto L_0x0036;
    L_0x0008:
        r0 = r3.j6;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r0 = r0.EQ;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r0 = r0.read();	 Catch:{ IOException -> 0x0076, all -> 0x008b }
    L_0x0012:
        r1 = -1;
        if (r0 == r1) goto L_0x0025;
    L_0x0015:
        r1 = r3.j6;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r1 = r1.v5;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        monitor-enter(r1);	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r2 = r3.j6;	 Catch:{ all -> 0x0073 }
        r2 = r2.Zo;	 Catch:{ all -> 0x0073 }
        if (r2 == 0) goto L_0x0056;
    L_0x0024:
        monitor-exit(r1);	 Catch:{ all -> 0x0073 }
    L_0x0025:
        r0 = r3.j6;	 Catch:{ IOException -> 0x00a7 }
        r0 = r0.FH;	 Catch:{ IOException -> 0x00a7 }
        if (r0 == 0) goto L_0x0036;
    L_0x002d:
        r0 = r3.j6;	 Catch:{ IOException -> 0x00a7 }
        r0 = r0.FH;	 Catch:{ IOException -> 0x00a7 }
        r0.close();	 Catch:{ IOException -> 0x00a7 }
    L_0x0036:
        r1 = r3.j6;	 Catch:{ Throwable -> 0x009e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x009e }
        r0 = r3.j6;	 Catch:{ all -> 0x00a0 }
        r0.j6.VH = r0.VH - 1;	 Catch:{ all -> 0x00a0 }
        r0 = r3.j6;	 Catch:{ all -> 0x00a0 }
        r0 = r0.VH;	 Catch:{ all -> 0x00a0 }
        if (r0 > 0) goto L_0x0054;
    L_0x0046:
        r0 = r3.j6;	 Catch:{ all -> 0x00a0 }
        r0.notifyAll();	 Catch:{ all -> 0x00a0 }
        r0 = r3.j6;	 Catch:{ IOException -> 0x00a3 }
        r0 = r0.J0;	 Catch:{ IOException -> 0x00a3 }
        r0.j6();	 Catch:{ IOException -> 0x00a3 }
    L_0x0054:
        monitor-exit(r1);	 Catch:{ all -> 0x00a0 }
    L_0x0055:
        return;
    L_0x0056:
        monitor-exit(r1);	 Catch:{ all -> 0x0073 }
        r1 = r3.j6;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r1 = r1.FH;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        if (r1 == 0) goto L_0x0068;
    L_0x005f:
        r1 = r3.j6;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r1 = r1.FH;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r1.write(r0);	 Catch:{ IOException -> 0x0076, all -> 0x008b }
    L_0x0068:
        r0 = r3.j6;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r0 = r0.EQ;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        r0 = r0.read();	 Catch:{ IOException -> 0x0076, all -> 0x008b }
        goto L_0x0012;
    L_0x0073:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0073 }
        throw r0;	 Catch:{ IOException -> 0x0076, all -> 0x008b }
    L_0x0076:
        r0 = move-exception;
        r0 = r3.j6;	 Catch:{ IOException -> 0x0089 }
        r0 = r0.FH;	 Catch:{ IOException -> 0x0089 }
        if (r0 == 0) goto L_0x0036;
    L_0x007f:
        r0 = r3.j6;	 Catch:{ IOException -> 0x0089 }
        r0 = r0.FH;	 Catch:{ IOException -> 0x0089 }
        r0.close();	 Catch:{ IOException -> 0x0089 }
        goto L_0x0036;
    L_0x0089:
        r0 = move-exception;
        goto L_0x0036;
    L_0x008b:
        r0 = move-exception;
        r1 = r3.j6;	 Catch:{ IOException -> 0x00a5 }
        r1 = r1.FH;	 Catch:{ IOException -> 0x00a5 }
        if (r1 == 0) goto L_0x009d;
    L_0x0094:
        r1 = r3.j6;	 Catch:{ IOException -> 0x00a5 }
        r1 = r1.FH;	 Catch:{ IOException -> 0x00a5 }
        r1.close();	 Catch:{ IOException -> 0x00a5 }
    L_0x009d:
        throw r0;	 Catch:{ Throwable -> 0x009e }
    L_0x009e:
        r0 = move-exception;
        goto L_0x0055;
    L_0x00a0:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00a0 }
        throw r0;	 Catch:{ Throwable -> 0x009e }
    L_0x00a3:
        r0 = move-exception;
        goto L_0x0054;
    L_0x00a5:
        r1 = move-exception;
        goto L_0x009d;
    L_0x00a7:
        r0 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: qc$2.run():void");
    }
}
