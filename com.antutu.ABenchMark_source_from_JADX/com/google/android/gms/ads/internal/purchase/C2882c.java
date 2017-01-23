package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.stats.C3527b;
import com.google.android.gms.p146b.fg;
import com.google.android.gms.p146b.gb;
import com.google.android.gms.p146b.he;
import com.google.android.gms.p146b.hf;
import com.google.android.gms.p146b.hj;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.ads.internal.purchase.c */
public class C2882c extends he implements ServiceConnection {
    private final Object f9757a;
    private boolean f9758b;
    private Context f9759c;
    private fg f9760d;
    private C2880b f9761e;
    private C2891h f9762f;
    private List<C2887f> f9763g;
    private C2894k f9764h;

    /* renamed from: com.google.android.gms.ads.internal.purchase.c.1 */
    class C28811 implements Runnable {
        final /* synthetic */ C2887f f9754a;
        final /* synthetic */ Intent f9755b;
        final /* synthetic */ C2882c f9756c;

        C28811(C2882c c2882c, C2887f c2887f, Intent intent) {
            this.f9756c = c2882c;
            this.f9754a = c2887f;
            this.f9755b = intent;
        }

        public void run() {
            try {
                if (this.f9756c.f9764h.m11262a(this.f9754a.f9779b, -1, this.f9755b)) {
                    this.f9756c.f9760d.m12696a(new C2889g(this.f9756c.f9759c, this.f9754a.f9780c, true, -1, this.f9755b, this.f9754a));
                } else {
                    this.f9756c.f9760d.m12696a(new C2889g(this.f9756c.f9759c, this.f9754a.f9780c, false, -1, this.f9755b, this.f9754a));
                }
            } catch (RemoteException e) {
                C2972b.m11583d("Fail to verify and dispatch pending transaction");
            }
        }
    }

    public C2882c(Context context, fg fgVar, C2894k c2894k) {
        this(context, fgVar, c2894k, new C2880b(context), C2891h.m11244a(context.getApplicationContext()));
    }

    C2882c(Context context, fg fgVar, C2894k c2894k, C2880b c2880b, C2891h c2891h) {
        this.f9757a = new Object();
        this.f9758b = false;
        this.f9763g = null;
        this.f9759c = context;
        this.f9760d = fgVar;
        this.f9764h = c2894k;
        this.f9761e = c2880b;
        this.f9762f = c2891h;
        this.f9763g = this.f9762f.m11248a(10);
    }

    private void m11207a(long j) {
        do {
            if (!m11209b(j)) {
                hf.m12982e("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.f9758b);
    }

    private boolean m11209b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f9757a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            C2972b.m11583d("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void m11211a() {
        synchronized (this.f9757a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            C3527b.m14718a().m14729a(this.f9759c, intent, (ServiceConnection) this, 1);
            m11207a(SystemClock.elapsedRealtime());
            C3527b.m14718a().m14727a(this.f9759c, (ServiceConnection) this);
            this.f9761e.m11203a();
        }
    }

    protected void m11212a(C2887f c2887f, String str, String str2) {
        Intent intent = new Intent();
        C2968s.m11535o();
        intent.putExtra("RESPONSE_CODE", 0);
        C2968s.m11535o();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        C2968s.m11535o();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        hj.f11297a.post(new C28811(this, c2887f, intent));
    }

    public void m11213b() {
        synchronized (this.f9757a) {
            C3527b.m14718a().m14727a(this.f9759c, (ServiceConnection) this);
            this.f9761e.m11203a();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m11214c() {
        /*
        r12 = this;
        r0 = r12.f9763g;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r6 = new java.util.HashMap;
        r6.<init>();
        r0 = r12.f9763g;
        r1 = r0.iterator();
    L_0x0014:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r1.next();
        r0 = (com.google.android.gms.ads.internal.purchase.C2887f) r0;
        r2 = r0.f9780c;
        r6.put(r2, r0);
        goto L_0x0014;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        r1 = r12.f9761e;
        r2 = r12.f9759c;
        r2 = r2.getPackageName();
        r0 = r1.m11205b(r2, r0);
        if (r0 != 0) goto L_0x0055;
    L_0x0035:
        r0 = r6.keySet();
        r1 = r0.iterator();
    L_0x003d:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0008;
    L_0x0043:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r12.f9762f;
        r0 = r6.get(r0);
        r0 = (com.google.android.gms.ads.internal.purchase.C2887f) r0;
        r2.m11249a(r0);
        goto L_0x003d;
    L_0x0055:
        r1 = com.google.android.gms.ads.internal.C2968s.m11535o();
        r1 = r1.m11254a(r0);
        if (r1 != 0) goto L_0x0035;
    L_0x005f:
        r1 = "INAPP_PURCHASE_ITEM_LIST";
        r7 = r0.getStringArrayList(r1);
        r1 = "INAPP_PURCHASE_DATA_LIST";
        r8 = r0.getStringArrayList(r1);
        r1 = "INAPP_DATA_SIGNATURE_LIST";
        r9 = r0.getStringArrayList(r1);
        r1 = "INAPP_CONTINUATION_TOKEN";
        r5 = r0.getString(r1);
        r0 = 0;
        r4 = r0;
    L_0x0079:
        r0 = r7.size();
        if (r4 >= r0) goto L_0x00bb;
    L_0x007f:
        r0 = r7.get(r4);
        r0 = r6.containsKey(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x0089:
        r0 = r7.get(r4);
        r0 = (java.lang.String) r0;
        r1 = r8.get(r4);
        r1 = (java.lang.String) r1;
        r2 = r9.get(r4);
        r2 = (java.lang.String) r2;
        r3 = r6.get(r0);
        r3 = (com.google.android.gms.ads.internal.purchase.C2887f) r3;
        r10 = com.google.android.gms.ads.internal.C2968s.m11535o();
        r10 = r10.m11255a(r1);
        r11 = r3.f9779b;
        r10 = r11.equals(r10);
        if (r10 == 0) goto L_0x00b7;
    L_0x00b1:
        r12.m11212a(r3, r1, r2);
        r6.remove(r0);
    L_0x00b7:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x0079;
    L_0x00bb:
        if (r5 == 0) goto L_0x0035;
    L_0x00bd:
        r0 = r6.isEmpty();
        if (r0 != 0) goto L_0x0035;
    L_0x00c3:
        r0 = r5;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.purchase.c.c():void");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f9757a) {
            this.f9761e.m11204a(iBinder);
            m11214c();
            this.f9758b = true;
            this.f9757a.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C2972b.m11581c("In-app billing service disconnected.");
        this.f9761e.m11203a();
    }
}
