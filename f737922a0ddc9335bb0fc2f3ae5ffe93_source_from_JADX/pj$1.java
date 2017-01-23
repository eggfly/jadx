class pj$1 implements Runnable {
    final /* synthetic */ pj j6;

    pj$1(pj pjVar) {
        this.j6 = pjVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r6 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r0 = pj.tp;
        r0 = r0.j6();
        if (r1 >= r0) goto L_0x001d;
    L_0x000c:
        r0 = pj.tp;
        r0 = r0.j6(r1);
        r0 = (java.lang.String) r0;
        pj.j6(r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0002;
    L_0x001d:
        r0 = pj.tp;
        r0.DW();
        r0 = r6.j6;	 Catch:{ IOException -> 0x0072 }
        r1 = r6.j6;	 Catch:{ IOException -> 0x0072 }
        r2 = "logcat -v threadtime";
        r1 = r1.DW(r2);	 Catch:{ IOException -> 0x0072 }
        r0.j6 = r1;	 Catch:{ IOException -> 0x0072 }
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0072 }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0072 }
        r2 = r6.j6;	 Catch:{ IOException -> 0x0072 }
        r2 = r2.j6;	 Catch:{ IOException -> 0x0072 }
        r2 = r2.getInputStream();	 Catch:{ IOException -> 0x0072 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0072 }
        r2 = 20;
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0072 }
        r1 = "";
    L_0x0048:
        r1 = r0.readLine();	 Catch:{ IOException -> 0x0072 }
        if (r1 == 0) goto L_0x0076;
    L_0x004e:
        r2 = r6.j6;	 Catch:{ IOException -> 0x0072 }
        r2 = r2.v5;	 Catch:{ IOException -> 0x0072 }
        monitor-enter(r2);	 Catch:{ IOException -> 0x0072 }
    L_0x0055:
        r3 = r6.j6;	 Catch:{ all -> 0x0077 }
        r3 = r3.Zo;	 Catch:{ all -> 0x0077 }
        if (r3 == 0) goto L_0x006b;
    L_0x005d:
        r3 = r6.j6;	 Catch:{ InterruptedException -> 0x0069 }
        r3 = r3.v5;	 Catch:{ InterruptedException -> 0x0069 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3.wait(r4);	 Catch:{ InterruptedException -> 0x0069 }
        goto L_0x0055;
    L_0x0069:
        r3 = move-exception;
        goto L_0x0055;
    L_0x006b:
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        r2 = r6.j6;	 Catch:{ IOException -> 0x0072 }
        r2.Hw(r1);	 Catch:{ IOException -> 0x0072 }
        goto L_0x0048;
    L_0x0072:
        r0 = move-exception;
        com.aide.common.e.j6(r0);
    L_0x0076:
        return;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0077 }
        throw r0;	 Catch:{ IOException -> 0x0072 }
        */
        throw new UnsupportedOperationException("Method not decompiled: pj$1.run():void");
    }
}
