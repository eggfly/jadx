class nz$1 implements Runnable {
    final /* synthetic */ nz j6;

    public void run() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:132:0x0085
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r10 = this;
        r9 = 0;
        r8 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r7 = 0;
    L_0x0004:
        r0 = r10.j6;
        r1 = r0.VH;
        monitor-enter(r1);
    L_0x000b:
        r0 = r10.j6();
        if (r0 == 0) goto L_0x0019;
    L_0x0011:
        r0 = r10.j6;
        r0 = r0.Hw;
        if (r0 == 0) goto L_0x0025;
    L_0x0019:
        r0 = r10.j6;	 Catch:{ InterruptedException -> 0x0023 }
        r0 = r0.VH;	 Catch:{ InterruptedException -> 0x0023 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0023 }
        goto L_0x000b;
    L_0x0023:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0025:
        r0 = r10.j6;
        r0 = r0.J8;
        r0.clear();
    L_0x002e:
        r0 = r10.j6;
        r0 = r0.u7;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0060;
    L_0x003a:
        r0 = r10.j6;
        r0 = r0.J8;
        r2 = r10.j6;
        r2 = r2.u7;
        r0.addAll(r2);
        r0 = r10.j6;
        r0 = r0.u7;
        r0.clear();
        r0 = r10.j6;	 Catch:{ InterruptedException -> 0x005e }
        r0 = r0.VH;	 Catch:{ InterruptedException -> 0x005e }
        r2 = 100;	 Catch:{ InterruptedException -> 0x005e }
        r0.wait(r2);	 Catch:{ InterruptedException -> 0x005e }
        goto L_0x002e;
    L_0x005e:
        r0 = move-exception;
        goto L_0x002e;
    L_0x0060:
        monitor-exit(r1);
        r0 = r10.j6;
        r0 = r0.tp;
        if (r0 == 0) goto L_0x0088;
    L_0x0069:
        r0 = r10.j6;
        r0 = r0.J0();
        if (r0 == 0) goto L_0x0004;
    L_0x0071:
        r0 = r10.j6;
        r0 = r0.tp;
        r1 = r10.j6;
        r1.tp = r9;
        r1 = new nz$1$1;
        r1.<init>(r10, r0);
        com.aide.ui.e.j6(r1);
        goto L_0x0004;
    L_0x0085:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0088:
        r0 = r10.j6;
        r0 = r0.EQ;
        if (r0 == 0) goto L_0x00ef;
    L_0x0090:
        r0 = r10.j6;
        r0 = r0.J0();
        if (r0 == 0) goto L_0x0004;
    L_0x0098:
        r0 = r10.j6;	 Catch:{ aea -> 0x00d7 }
        r1 = r0.EQ;	 Catch:{ aea -> 0x00d7 }
        r0 = r10.j6;	 Catch:{ aea -> 0x00d7 }
        r2 = 0;	 Catch:{ aea -> 0x00d7 }
        r0.EQ = r2;	 Catch:{ aea -> 0x00d7 }
        r6 = new java.util.ArrayList;	 Catch:{ aea -> 0x00d7 }
        r6.<init>();	 Catch:{ aea -> 0x00d7 }
        r0 = r10.j6;	 Catch:{ aea -> 0x00d7 }
        r0 = r0.DW;	 Catch:{ aea -> 0x00d7 }
        r2 = 0;	 Catch:{ aea -> 0x00d7 }
        r3 = 0;	 Catch:{ aea -> 0x00d7 }
        r4 = 1;	 Catch:{ aea -> 0x00d7 }
        r5 = 0;	 Catch:{ aea -> 0x00d7 }
        r0 = r0.j6(r1, r2, r3, r4, r5);	 Catch:{ aea -> 0x00d7 }
        r1 = r0.J8;	 Catch:{ aea -> 0x00d7 }
        if (r1 == 0) goto L_0x00e5;	 Catch:{ aea -> 0x00d7 }
    L_0x00bb:
        r0 = r0.J8;	 Catch:{ aea -> 0x00d7 }
        r1 = r0.iterator();	 Catch:{ aea -> 0x00d7 }
    L_0x00c1:
        r0 = r1.hasNext();	 Catch:{ aea -> 0x00d7 }
        if (r0 == 0) goto L_0x00e5;	 Catch:{ aea -> 0x00d7 }
    L_0x00c7:
        r0 = r1.next();	 Catch:{ aea -> 0x00d7 }
        r0 = (adv$e) r0;	 Catch:{ aea -> 0x00d7 }
        r2 = r0.Hw;	 Catch:{ aea -> 0x00d7 }
        if (r2 == 0) goto L_0x00c1;	 Catch:{ aea -> 0x00d7 }
    L_0x00d1:
        r0 = r0.VH;	 Catch:{ aea -> 0x00d7 }
        r6.add(r0);	 Catch:{ aea -> 0x00d7 }
        goto L_0x00c1;
    L_0x00d7:
        r0 = move-exception;
        com.aide.common.e.j6(r0);
        r1 = new nz$1$3;
        r1.<init>(r10, r0);
        com.aide.ui.e.j6(r1);
        goto L_0x0004;
    L_0x00e5:
        r0 = new nz$1$2;	 Catch:{ aea -> 0x00d7 }
        r0.<init>(r10, r6);	 Catch:{ aea -> 0x00d7 }
        com.aide.ui.e.j6(r0);	 Catch:{ aea -> 0x00d7 }
        goto L_0x0004;
    L_0x00ef:
        r0 = r10.j6;	 Catch:{ all -> 0x012c }
        r0 = r0.J0();	 Catch:{ all -> 0x012c }
        if (r0 != 0) goto L_0x014a;	 Catch:{ all -> 0x012c }
    L_0x00f7:
        r0 = r10.j6;
        r1 = r0.VH;
        monitor-enter(r1);
        r0 = r10.j6;	 Catch:{ all -> 0x012c }
        r0 = r0.u7;	 Catch:{ all -> 0x012c }
        r2 = r10.j6;	 Catch:{ all -> 0x012c }
        r2 = r2.J8;	 Catch:{ all -> 0x012c }
        r0.addAll(r2);	 Catch:{ all -> 0x012c }
        monitor-exit(r1);	 Catch:{ all -> 0x012c }
        r0 = r10.j6;
        r1 = r0.VH;
        monitor-enter(r1);
        r0 = r10.j6;
        r0 = r0.J8;
        r0.clear();
        monitor-exit(r1);
        r0 = r10.j6;
        r1 = "Done";
        r0.j6(r7, r1, r8);
        goto L_0x0004;
    L_0x0129:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x012c }
        throw r0;	 Catch:{ all -> 0x012c }
    L_0x012c:
        r0 = move-exception;
        r1 = r10.j6;
        r1 = r1.VH;
        monitor-enter(r1);
        r2 = r10.j6;
        r2 = r2.J8;
        r2.clear();
        monitor-exit(r1);
        r1 = r10.j6;
        r2 = "Done";
        r1.j6(r7, r2, r8);
        throw r0;
    L_0x0147:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x014a:
        r0 = r10.j6;	 Catch:{ all -> 0x012c }
        r0 = r0.gn;	 Catch:{ all -> 0x012c }
        if (r0 == 0) goto L_0x015a;	 Catch:{ all -> 0x012c }
    L_0x0152:
        r0 = new nz$1$4;	 Catch:{ all -> 0x012c }
        r0.<init>(r10);	 Catch:{ all -> 0x012c }
        com.aide.ui.e.j6(r0);	 Catch:{ all -> 0x012c }
    L_0x015a:
        r0 = r10.j6;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r0 = r0.J8;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r1 = r0.iterator();	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
    L_0x0164:
        r0 = r1.hasNext();	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        if (r0 == 0) goto L_0x01a2;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
    L_0x016a:
        r0 = r1.next();	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r0 = (nz$e) r0;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r2 = r10.j6;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r3 = 1;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r4 = "Connecting...";	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r5 = 0;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r2.j6(r3, r4, r5);	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r2 = r10.j6;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r2.j6(r0);	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r0 = new nz$1$5;	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        r0.<init>(r10);	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        com.aide.ui.e.j6(r0);	 Catch:{ nz$a -> 0x0188, Exception -> 0x01bd }
        goto L_0x0164;
    L_0x0188:
        r0 = move-exception;
        r0 = "Canceled";	 Catch:{ all -> 0x012c }
        com.aide.common.e.j6(r0);	 Catch:{ all -> 0x012c }
        r0 = r10.j6;	 Catch:{ all -> 0x012c }
        r1 = 0;	 Catch:{ all -> 0x012c }
        r2 = "Done";	 Catch:{ all -> 0x012c }
        r3 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;	 Catch:{ all -> 0x012c }
        r0.j6(r1, r2, r3);	 Catch:{ all -> 0x012c }
        r0 = new nz$1$6;	 Catch:{ all -> 0x012c }
        r0.<init>(r10);	 Catch:{ all -> 0x012c }
        com.aide.ui.e.j6(r0);	 Catch:{ all -> 0x012c }
    L_0x01a2:
        r0 = r10.j6;
        r1 = r0.VH;
        monitor-enter(r1);
        r0 = r10.j6;
        r0 = r0.J8;
        r0.clear();
        monitor-exit(r1);
        r0 = r10.j6;
        r1 = "Done";
        r0.j6(r7, r1, r8);
        goto L_0x0004;
    L_0x01bd:
        r0 = move-exception;
        com.aide.common.e.j6(r0);	 Catch:{ all -> 0x012c }
        r1 = r10.j6;	 Catch:{ all -> 0x012c }
        r2 = 0;	 Catch:{ all -> 0x012c }
        r3 = "Done";	 Catch:{ all -> 0x012c }
        r4 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;	 Catch:{ all -> 0x012c }
        r1.j6(r2, r3, r4);	 Catch:{ all -> 0x012c }
        r1 = new nz$1$7;	 Catch:{ all -> 0x012c }
        r1.<init>(r10, r0);	 Catch:{ all -> 0x012c }
        com.aide.ui.e.j6(r1);	 Catch:{ all -> 0x012c }
        goto L_0x01a2;
    L_0x01d5:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x01d8:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: nz$1.run():void");
    }

    nz$1(nz nzVar) {
        this.j6 = nzVar;
    }

    private boolean j6() {
        return (this.j6.u7.size() <= 0 && this.j6.tp == null && this.j6.EQ == null) ? false : true;
    }
}
