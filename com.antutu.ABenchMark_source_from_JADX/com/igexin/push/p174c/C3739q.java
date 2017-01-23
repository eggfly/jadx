package com.igexin.push.p174c;

/* renamed from: com.igexin.push.c.q */
class C3739q implements Runnable {
    final /* synthetic */ C3738p f12624a;

    C3739q(C3738p c3738p) {
        this.f12624a = c3738p;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r8 = this;
    L_0x0000:
        r0 = r8.f12624a;
        r0 = r0.f12615L;
        if (r0 == 0) goto L_0x0058;
    L_0x0008:
        r0 = r8.f12624a;
        r0 = r0.f12618e;
        r0 = r0.isInterrupted();
        if (r0 != 0) goto L_0x0058;
    L_0x0014:
        r1 = 0;
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12621h;	 Catch:{ Exception -> 0x0154 }
        r0.lock();	 Catch:{ Exception -> 0x0154 }
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12623j;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.isEmpty();	 Catch:{ Exception -> 0x0154 }
        if (r0 == 0) goto L_0x0033;
    L_0x002a:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12622i;	 Catch:{ Exception -> 0x0154 }
        r0.await();	 Catch:{ Exception -> 0x0154 }
    L_0x0033:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12623j;	 Catch:{ Exception -> 0x0154 }
        r0.clear();	 Catch:{ Exception -> 0x0154 }
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12616M;	 Catch:{ Exception -> 0x0154 }
        if (r0 == 0) goto L_0x0059;
    L_0x0044:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01f3 }
        r0 = r0.f12621h;	 Catch:{ Exception -> 0x01f3 }
        r0.unlock();	 Catch:{ Exception -> 0x01f3 }
    L_0x004d:
        if (r1 == 0) goto L_0x0058;
    L_0x004f:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x0058;
    L_0x0055:
        r1.close();	 Catch:{ Exception -> 0x01e0 }
    L_0x0058:
        return;
    L_0x0059:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12619f;	 Catch:{ Exception -> 0x0154 }
        if (r0 == 0) goto L_0x0070;
    L_0x0061:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12619f;	 Catch:{ Exception -> 0x0154 }
        r2 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r2 = r2.f12617c;	 Catch:{ Exception -> 0x0154 }
        r0.m15340a(r2);	 Catch:{ Exception -> 0x0154 }
    L_0x0070:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0154 }
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.f12617c;	 Catch:{ Exception -> 0x0154 }
        r0 = r0.m15284a();	 Catch:{ Exception -> 0x0154 }
        r0 = com.igexin.p158b.p159a.p161b.C3687f.m15083a(r0);	 Catch:{ Exception -> 0x0154 }
        r6 = new java.net.Socket;	 Catch:{ Exception -> 0x0154 }
        r6.<init>();	 Catch:{ Exception -> 0x0154 }
        r1 = new java.net.InetSocketAddress;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r4 = 1;
        r0 = r0[r4];	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r4 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r4 = r4.f12617c;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r4 = r4.m15296d();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1.<init>(r0, r4);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r6.connect(r1, r0);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.f12617c;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1.<init>();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = "socket://";
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = r6.getInetAddress();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = r7.getHostAddress();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = ":";
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = r7.f12617c;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r7 = r7.m15296d();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r1.append(r7);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r2 = r4 - r2;
        r0.m15288a(r1, r2, r4);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0.<init>();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = com.igexin.push.p174c.C3738p.f12614b;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = "|detect ";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r1.m15361y();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = "ok, time: ";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = r1.f12617c;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r2 = r1.m15297e();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = " ######";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.f12619f;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        if (r0 == 0) goto L_0x013b;
    L_0x0122:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.f12616M;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        if (r0 != 0) goto L_0x013b;
    L_0x012a:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0 = r0.f12619f;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r1 = com.igexin.push.p174c.C3728g.SUCCESS;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r2 = r8.f12624a;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r2 = r2.f12617c;	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
        r0.m15339a(r1, r2);	 Catch:{ Exception -> 0x01ec, all -> 0x01e7 }
    L_0x013b:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01f0 }
        r0 = r0.f12621h;	 Catch:{ Exception -> 0x01f0 }
        r0.unlock();	 Catch:{ Exception -> 0x01f0 }
    L_0x0144:
        if (r6 == 0) goto L_0x0000;
    L_0x0146:
        r0 = r6.isClosed();
        if (r0 != 0) goto L_0x0000;
    L_0x014c:
        r6.close();	 Catch:{ Exception -> 0x0151 }
        goto L_0x0000;
    L_0x0151:
        r0 = move-exception;
        goto L_0x0000;
    L_0x0154:
        r0 = move-exception;
    L_0x0155:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ca }
        r2.<init>();	 Catch:{ all -> 0x01ca }
        r3 = com.igexin.push.p174c.C3738p.f12614b;	 Catch:{ all -> 0x01ca }
        r2 = r2.append(r3);	 Catch:{ all -> 0x01ca }
        r3 = "|detect ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01ca }
        r3 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r3 = r3.m15361y();	 Catch:{ all -> 0x01ca }
        r2 = r2.append(r3);	 Catch:{ all -> 0x01ca }
        r3 = "thread -->";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01ca }
        r0 = r0.toString();	 Catch:{ all -> 0x01ca }
        r0 = r2.append(r0);	 Catch:{ all -> 0x01ca }
        r0 = r0.toString();	 Catch:{ all -> 0x01ca }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);	 Catch:{ all -> 0x01ca }
        r0 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f12616M;	 Catch:{ all -> 0x01ca }
        if (r0 != 0) goto L_0x01b1;
    L_0x018f:
        r0 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f12617c;	 Catch:{ all -> 0x01ca }
        r0.m15291b();	 Catch:{ all -> 0x01ca }
        r0 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f12619f;	 Catch:{ all -> 0x01ca }
        if (r0 == 0) goto L_0x01b1;
    L_0x01a0:
        r0 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r0 = r0.f12619f;	 Catch:{ all -> 0x01ca }
        r2 = com.igexin.push.p174c.C3728g.EXCEPTION;	 Catch:{ all -> 0x01ca }
        r3 = r8.f12624a;	 Catch:{ all -> 0x01ca }
        r3 = r3.f12617c;	 Catch:{ all -> 0x01ca }
        r0.m15339a(r2, r3);	 Catch:{ all -> 0x01ca }
    L_0x01b1:
        r0 = r8.f12624a;	 Catch:{ Exception -> 0x01ea }
        r0 = r0.f12621h;	 Catch:{ Exception -> 0x01ea }
        r0.unlock();	 Catch:{ Exception -> 0x01ea }
    L_0x01ba:
        if (r1 == 0) goto L_0x0000;
    L_0x01bc:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x0000;
    L_0x01c2:
        r1.close();	 Catch:{ Exception -> 0x01c7 }
        goto L_0x0000;
    L_0x01c7:
        r0 = move-exception;
        goto L_0x0000;
    L_0x01ca:
        r0 = move-exception;
    L_0x01cb:
        r2 = r8.f12624a;	 Catch:{ Exception -> 0x01e5 }
        r2 = r2.f12621h;	 Catch:{ Exception -> 0x01e5 }
        r2.unlock();	 Catch:{ Exception -> 0x01e5 }
    L_0x01d4:
        if (r1 == 0) goto L_0x01df;
    L_0x01d6:
        r2 = r1.isClosed();
        if (r2 != 0) goto L_0x01df;
    L_0x01dc:
        r1.close();	 Catch:{ Exception -> 0x01e3 }
    L_0x01df:
        throw r0;
    L_0x01e0:
        r0 = move-exception;
        goto L_0x0058;
    L_0x01e3:
        r1 = move-exception;
        goto L_0x01df;
    L_0x01e5:
        r2 = move-exception;
        goto L_0x01d4;
    L_0x01e7:
        r0 = move-exception;
        r1 = r6;
        goto L_0x01cb;
    L_0x01ea:
        r0 = move-exception;
        goto L_0x01ba;
    L_0x01ec:
        r0 = move-exception;
        r1 = r6;
        goto L_0x0155;
    L_0x01f0:
        r0 = move-exception;
        goto L_0x0144;
    L_0x01f3:
        r0 = move-exception;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.q.run():void");
    }
}
