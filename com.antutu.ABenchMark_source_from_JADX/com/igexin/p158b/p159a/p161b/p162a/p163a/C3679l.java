package com.igexin.p158b.p159a.p161b.p162a.p163a;

import android.text.TextUtils;
import com.igexin.p158b.p159a.p161b.C3683b;
import com.igexin.p158b.p159a.p161b.C3686d;
import com.igexin.p158b.p159a.p161b.p162a.p163a.p164a.C3661c;
import com.igexin.p158b.p159a.p167c.C3688a;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.igexin.b.a.b.a.a.l */
public final class C3679l extends C3668a {
    private static final String f12397L;
    private C3661c f12398M;
    private C3686d f12399N;
    public C3683b f12400i;
    C3681n f12401j;

    static {
        f12397L = C3679l.class.getName();
    }

    public C3679l(C3681n c3681n, C3683b c3683b, C3686d c3686d) {
        super(TnetStatusCode.EASY_REASON_SPDYINIT_ERROR, null, c3683b);
        this.f12400i = c3683b;
        this.f12399N = c3686d;
        this.f12401j = c3681n;
    }

    public void m15033a(C3661c c3661c) {
        this.f12398M = c3661c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a_() {
        /*
        r8 = this;
        super.a_();
        r2 = java.lang.Thread.currentThread();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = f12397L;
        r0 = r0.append(r1);
        r1 = "|";
        r0 = r0.append(r1);
        r0 = r0.append(r2);
        r1 = " running";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
        r3 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3671d.m14981a();
    L_0x002d:
        r0 = r8.h;
        if (r0 == 0) goto L_0x00f5;
    L_0x0031:
        r0 = r2.isInterrupted();
        if (r0 != 0) goto L_0x00f5;
    L_0x0037:
        r0 = r8.e;
        if (r0 != 0) goto L_0x00f5;
    L_0x003b:
        r0 = r3.f12372a;	 Catch:{ Throwable -> 0x00d0 }
        r0.lock();	 Catch:{ Throwable -> 0x00d0 }
        r0 = r3.f12374c;	 Catch:{ Throwable -> 0x00d0 }
        r0 = r0.isEmpty();	 Catch:{ Throwable -> 0x00d0 }
        if (r0 == 0) goto L_0x004d;
    L_0x0048:
        r0 = r3.f12373b;	 Catch:{ Throwable -> 0x00d0 }
        r0.await();	 Catch:{ Throwable -> 0x00d0 }
    L_0x004d:
        r0 = r3.f12374c;	 Catch:{ Throwable -> 0x00d0 }
        r0 = r0.poll();	 Catch:{ Throwable -> 0x00d0 }
        r0 = (com.igexin.p158b.p159a.p161b.p162a.p163a.C3678k) r0;	 Catch:{ Throwable -> 0x00d0 }
        if (r0 == 0) goto L_0x00c6;
    L_0x0057:
        r1 = r8.f12399N;	 Catch:{ Throwable -> 0x00d0 }
        r0.d = r1;	 Catch:{ Throwable -> 0x00d0 }
        r1 = r8.f12399N;	 Catch:{ Throwable -> 0x00d0 }
        if (r1 == 0) goto L_0x00c6;
    L_0x005f:
        r1 = r8.f12401j;	 Catch:{ Throwable -> 0x00d0 }
        if (r1 == 0) goto L_0x00c6;
    L_0x0063:
        r1 = r8.e;	 Catch:{ Throwable -> 0x00d0 }
        if (r1 != 0) goto L_0x00c6;
    L_0x0067:
        r1 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3669b.NORMAL;	 Catch:{ Throwable -> 0x00d0 }
        r8.f = r1;	 Catch:{ Throwable -> 0x00d0 }
        r4 = r8.f12401j;	 Catch:{ Throwable -> 0x00d0 }
        r1 = r8.f12400i;	 Catch:{ Throwable -> 0x00d0 }
        r5 = 0;
        r6 = r8.f12399N;	 Catch:{ Throwable -> 0x00d0 }
        r7 = r0.c;	 Catch:{ Throwable -> 0x00d0 }
        r1 = r1.m15046d(r5, r6, r7);	 Catch:{ Throwable -> 0x00d0 }
        r1 = (byte[]) r1;	 Catch:{ Throwable -> 0x00d0 }
        r1 = (byte[]) r1;	 Catch:{ Throwable -> 0x00d0 }
        r4.m15040a(r1);	 Catch:{ Throwable -> 0x00d0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d0 }
        r1.<init>();	 Catch:{ Throwable -> 0x00d0 }
        r4 = f12397L;	 Catch:{ Throwable -> 0x00d0 }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r4 = "|";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r4 = r0.toString();	 Catch:{ Throwable -> 0x00d0 }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r4 = " --> ";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r4 = r0.c;	 Catch:{ Throwable -> 0x00d0 }
        r4 = r4.getClass();	 Catch:{ Throwable -> 0x00d0 }
        r4 = r4.getName();	 Catch:{ Throwable -> 0x00d0 }
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r4 = "-- send success";
        r1 = r1.append(r4);	 Catch:{ Throwable -> 0x00d0 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00d0 }
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r1);	 Catch:{ Throwable -> 0x00d0 }
        r1 = r8.f12398M;	 Catch:{ Throwable -> 0x00d0 }
        if (r1 == 0) goto L_0x00c6;
    L_0x00bd:
        r1 = r8.e;	 Catch:{ Throwable -> 0x00d0 }
        if (r1 != 0) goto L_0x00c6;
    L_0x00c1:
        r1 = r8.f12398M;	 Catch:{ Throwable -> 0x00d0 }
        r1.m14942a(r0);	 Catch:{ Throwable -> 0x00d0 }
    L_0x00c6:
        r0 = r3.f12372a;	 Catch:{ Exception -> 0x00cd }
        r0.unlock();	 Catch:{ Exception -> 0x00cd }
        goto L_0x002d;
    L_0x00cd:
        r0 = move-exception;
        goto L_0x002d;
    L_0x00d0:
        r0 = move-exception;
        r1 = 0;
        r8.h = r1;	 Catch:{ all -> 0x00ee }
        r1 = r8.f;	 Catch:{ all -> 0x00ee }
        r4 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3669b.INTERRUPT;	 Catch:{ all -> 0x00ee }
        if (r1 == r4) goto L_0x00e4;
    L_0x00da:
        r1 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3669b.EXCEPTION;	 Catch:{ all -> 0x00ee }
        r8.f = r1;	 Catch:{ all -> 0x00ee }
        r0 = r0.toString();	 Catch:{ all -> 0x00ee }
        r8.g = r0;	 Catch:{ all -> 0x00ee }
    L_0x00e4:
        r0 = r3.f12372a;	 Catch:{ Exception -> 0x00eb }
        r0.unlock();	 Catch:{ Exception -> 0x00eb }
        goto L_0x002d;
    L_0x00eb:
        r0 = move-exception;
        goto L_0x002d;
    L_0x00ee:
        r0 = move-exception;
        r1 = r3.f12372a;	 Catch:{ Exception -> 0x0111 }
        r1.unlock();	 Catch:{ Exception -> 0x0111 }
    L_0x00f4:
        throw r0;
    L_0x00f5:
        r0 = 1;
        r8.e = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = f12397L;
        r0 = r0.append(r1);
        r1 = "|finish ~~~~~~";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.igexin.p158b.p159a.p167c.C3688a.m15097b(r0);
        return;
    L_0x0111:
        r1 = move-exception;
        goto L_0x00f4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.l.a_():void");
    }

    public final int m15034b() {
        return TnetStatusCode.EASY_REASON_SPDYINIT_ERROR;
    }

    public void m15035f() {
        super.m14974f();
        C3688a.m15097b(f12397L + "|dispose");
        if (this.f12398M != null) {
            if (this.f == C3669b.EXCEPTION) {
                if (!TextUtils.isEmpty(this.g)) {
                    this.f12398M.m14943a(new Exception(this.g));
                }
            } else if (this.f == C3669b.INTERRUPT) {
                this.f12398M.m14939a(this);
            }
        }
        this.f12398M = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m15036h() {
        /*
        r2 = this;
        r0 = 0;
        r2.h = r0;
        r0 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3669b.INTERRUPT;
        r2.f = r0;
        r1 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3671d.m14981a();
        r0 = r2.e;	 Catch:{ Exception -> 0x0023, all -> 0x002c }
        if (r0 != 0) goto L_0x001d;
    L_0x000f:
        r0 = r1.f12372a;	 Catch:{ Exception -> 0x0023, all -> 0x002c }
        r0.lock();	 Catch:{ Exception -> 0x0023, all -> 0x002c }
        r0 = com.igexin.p158b.p159a.p161b.p162a.p163a.C3671d.m14981a();	 Catch:{ Exception -> 0x0023, all -> 0x002c }
        r0 = r0.f12373b;	 Catch:{ Exception -> 0x0023, all -> 0x002c }
        r0.signalAll();	 Catch:{ Exception -> 0x0023, all -> 0x002c }
    L_0x001d:
        r0 = r1.f12372a;	 Catch:{ Exception -> 0x0035 }
        r0.unlock();	 Catch:{ Exception -> 0x0035 }
    L_0x0022:
        return;
    L_0x0023:
        r0 = move-exception;
        r0 = r1.f12372a;	 Catch:{ Exception -> 0x002a }
        r0.unlock();	 Catch:{ Exception -> 0x002a }
        goto L_0x0022;
    L_0x002a:
        r0 = move-exception;
        goto L_0x0022;
    L_0x002c:
        r0 = move-exception;
        r1 = r1.f12372a;	 Catch:{ Exception -> 0x0033 }
        r1.unlock();	 Catch:{ Exception -> 0x0033 }
    L_0x0032:
        throw r0;
    L_0x0033:
        r1 = move-exception;
        goto L_0x0032;
    L_0x0035:
        r0 = move-exception;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.l.h():void");
    }
}
