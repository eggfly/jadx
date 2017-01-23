package com.igexin.p158b.p159a.p165d;

/* renamed from: com.igexin.b.a.d.i */
final class C3699i extends Thread {
    volatile boolean f12472a;
    C3696f f12473b;
    final /* synthetic */ C3684e f12474c;

    public C3699i(C3684e c3684e) {
        this.f12474c = c3684e;
        this.f12472a = true;
        setName("taskService-processor");
    }

    public final void run() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00d4 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r7 = this;
        r6 = 0;
        r3 = 0;
        r1 = 1;
        r0 = -2;
        android.os.Process.setThreadPriority(r0);
        r0 = r7.f12474c;
        r4 = r0.f12419k;
        r0 = r1;
        r2 = r3;
    L_0x000d:
        r5 = r7.f12472a;
        if (r5 == 0) goto L_0x010c;
    L_0x0011:
        switch(r0) {
            case -1: goto L_0x0015;
            case 0: goto L_0x0080;
            case 1: goto L_0x00a4;
            case 2: goto L_0x0102;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x000d;
    L_0x0015:
        r2.m14961d();	 Catch:{ Exception -> 0x007d }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007d }
        r0.<init>();	 Catch:{ Exception -> 0x007d }
        r5 = "Processor InitTask: ";	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r5 = r2.getClass();	 Catch:{ Exception -> 0x007d }
        r5 = r5.getName();	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r5 = "@";	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r5 = r2.hashCode();	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x007d }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x007d }
        r0 = r2.m14967q();	 Catch:{ Exception -> 0x007d }
        if (r0 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x007d }
    L_0x004a:
        r0 = r7.f12473b;	 Catch:{ Exception -> 0x007d }
        if (r0 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x007d }
    L_0x004e:
        r0 = new com.igexin.b.a.d.f;	 Catch:{ Exception -> 0x007d }
        r5 = r7.f12474c;	 Catch:{ Exception -> 0x007d }
        r0.<init>(r5);	 Catch:{ Exception -> 0x007d }
        r7.f12473b = r0;	 Catch:{ Exception -> 0x007d }
    L_0x0057:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007d }
        r0.<init>();	 Catch:{ Exception -> 0x007d }
        r5 = r2.getClass();	 Catch:{ Exception -> 0x007d }
        r5 = r5.getName();	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r5 = " is a block task!";	 Catch:{ Exception -> 0x007d }
        r0 = r0.append(r5);	 Catch:{ Exception -> 0x007d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x007d }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x007d }
        r0 = r7.f12473b;	 Catch:{ Exception -> 0x007d }
        r0.m15120a(r2);	 Catch:{ Exception -> 0x007d }
        r0 = r1;
        r2 = r3;
        goto L_0x000d;
    L_0x007d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x000d;
    L_0x0080:
        r2.a_();	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r2.m14969s();	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r2.m14971u();	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r0 = r7.f12474c;
        r0.m15059g();
        r0 = r2.f12347t;
        if (r0 != 0) goto L_0x0095;
    L_0x0092:
        r2.m14960c();
    L_0x0095:
        r0 = r2.f12339k;
        if (r0 != 0) goto L_0x00a2;
    L_0x0099:
        r0 = r2.f12343p;
        if (r0 != 0) goto L_0x00a2;
    L_0x009d:
        r2.f12328A = r6;
        r4.m15114a(r2);
    L_0x00a2:
        r0 = r1;
        r2 = r3;
    L_0x00a4:
        r2 = r4.m15117c();	 Catch:{ InterruptedException -> 0x0110 }
    L_0x00a8:
        if (r2 == 0) goto L_0x0102;
    L_0x00aa:
        r5 = r2.f12339k;
        if (r5 != 0) goto L_0x00b2;
    L_0x00ae:
        r5 = r2.f12340m;
        if (r5 == 0) goto L_0x00ff;
    L_0x00b2:
        r2 = r3;
        goto L_0x000d;
    L_0x00b5:
        r0 = move-exception;
        r5 = 1;
        r2.f12347t = r5;	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r2.f12329B = r0;	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r2.m14972v();	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r2.m14966p();	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r0 = r7.f12474c;	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r0 = r0.f12418j;	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r0.offer(r2);	 Catch:{ Exception -> 0x00b5, all -> 0x00e4 }
        r0 = r7.f12474c;
        r0.m15059g();
        r0 = r2.f12347t;
        if (r0 != 0) goto L_0x00d4;
    L_0x00d1:
        r2.m14960c();
    L_0x00d4:
        r0 = r2.f12339k;
        if (r0 != 0) goto L_0x00e1;
    L_0x00d8:
        r0 = r2.f12343p;
        if (r0 != 0) goto L_0x00e1;
    L_0x00dc:
        r2.f12328A = r6;
        r4.m15114a(r2);
    L_0x00e1:
        r0 = r1;
        r2 = r3;
        goto L_0x00a4;
    L_0x00e4:
        r0 = move-exception;
        r1 = r7.f12474c;
        r1.m15059g();
        r1 = r2.f12347t;
        if (r1 != 0) goto L_0x00f1;
    L_0x00ee:
        r2.m14960c();
    L_0x00f1:
        r1 = r2.f12339k;
        if (r1 != 0) goto L_0x00fe;
    L_0x00f5:
        r1 = r2.f12343p;
        if (r1 != 0) goto L_0x00fe;
    L_0x00f9:
        r2.f12328A = r6;
        r4.m15114a(r2);
    L_0x00fe:
        throw r0;
    L_0x00ff:
        r0 = -1;
        goto L_0x000d;
    L_0x0102:
        r0 = r2;
        r2 = r7.f12474c;
        r2.m15059g();
        r2 = r0;
        r0 = r1;
        goto L_0x000d;
    L_0x010c:
        r4.m15118d();
        return;
    L_0x0110:
        r5 = move-exception;
        goto L_0x00a8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.i.run():void");
    }
}
