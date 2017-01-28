class pf$h$1 implements Runnable {
    final /* synthetic */ pf$h j6;

    pf$h$1(pf$h pf_h) {
        this.j6 = pf_h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.j6;
        r1 = r0.j6;
        monitor-enter(r1);
        r0 = r4.j6;	 Catch:{ InterruptedException -> 0x0052 }
        r0 = r0.j6;	 Catch:{ InterruptedException -> 0x0052 }
        r2 = 600000; // 0x927c0 float:8.40779E-40 double:2.964394E-318;
        r0.wait(r2);	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0013:
        r0 = r4.j6;	 Catch:{ all -> 0x0027 }
        r0 = r0.DW;	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
    L_0x001c:
        return;
    L_0x001d:
        r0 = r4.j6;	 Catch:{ all -> 0x0027 }
        r0 = r0.Hw;	 Catch:{ all -> 0x0027 }
        if (r0 != 0) goto L_0x002a;
    L_0x0025:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        goto L_0x0000;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0047 }
        r2 = r4.j6;	 Catch:{ JSONException -> 0x0047 }
        r2 = r2.Hw;	 Catch:{ JSONException -> 0x0047 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0047 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0047 }
        r2 = r4.j6;	 Catch:{ all -> 0x0027 }
        r2 = r2.v5;	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        r0 = pf$h.FH(r0, r2);	 Catch:{ Exception -> 0x004d }
        if (r0 == 0) goto L_0x0000;
    L_0x0046:
        goto L_0x001c;
    L_0x0047:
        r0 = move-exception;
        com.aide.common.e.j6(r0);	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        goto L_0x0000;
    L_0x004d:
        r0 = move-exception;
        com.aide.common.e.j6(r0);
        goto L_0x0000;
    L_0x0052:
        r0 = move-exception;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: pf$h$1.run():void");
    }
}
