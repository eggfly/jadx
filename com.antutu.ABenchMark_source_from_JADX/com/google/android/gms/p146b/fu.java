package com.google.android.gms.p146b;

import android.content.Context;
import com.google.android.gms.ads.internal.C2900q;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@gb
/* renamed from: com.google.android.gms.b.fu */
public class fu extends he {
    private final C2732a f10960a;
    private final AdResponseParcel f10961b;
    private final C3232a f10962c;
    private final fv f10963d;
    private final Object f10964e;
    private Future<gx> f10965f;

    /* renamed from: com.google.android.gms.b.fu.1 */
    class C32081 implements Runnable {
        final /* synthetic */ gx f10958a;
        final /* synthetic */ fu f10959b;

        C32081(fu fuVar, gx gxVar) {
            this.f10959b = fuVar;
            this.f10958a = gxVar;
        }

        public void run() {
            this.f10959b.f10960a.m10419b(this.f10958a);
        }
    }

    public fu(Context context, C2900q c2900q, db dbVar, C3232a c3232a, C3326k c3326k, C2732a c2732a) {
        this(c3232a, c2732a, new fv(context, c2900q, dbVar, new ho(context), c3326k, c3232a));
    }

    fu(C3232a c3232a, C2732a c2732a, fv fvVar) {
        this.f10964e = new Object();
        this.f10962c = c3232a;
        this.f10961b = c3232a.f11167b;
        this.f10960a = c2732a;
        this.f10963d = fvVar;
    }

    private gx m12756a(int i) {
        return new gx(this.f10962c.f11166a.f9853c, null, null, i, null, null, this.f10961b.f9896l, this.f10961b.f9895k, this.f10962c.f11166a.f9859i, false, null, null, null, null, null, this.f10961b.f9893i, this.f10962c.f11169d, this.f10961b.f9891g, this.f10962c.f11171f, this.f10961b.f9898n, this.f10961b.f9899o, this.f10962c.f11173h, null, null, null, null, this.f10962c.f11167b.f9883G);
    }

    public void m12757a() {
        gx gxVar;
        int i;
        try {
            synchronized (this.f10964e) {
                this.f10965f = hi.m13005a(this.f10963d);
            }
            gxVar = (gx) this.f10965f.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            C2972b.m11583d("Timed out waiting for native ad.");
            this.f10965f.cancel(true);
            i = 2;
            gxVar = null;
        } catch (ExecutionException e2) {
            i = 0;
            gxVar = null;
        } catch (InterruptedException e3) {
            gxVar = null;
            i = -1;
        } catch (CancellationException e4) {
            gxVar = null;
            i = -1;
        }
        if (gxVar == null) {
            gxVar = m12756a(i);
        }
        hj.f11297a.post(new C32081(this, gxVar));
    }

    public void m12758b() {
        synchronized (this.f10964e) {
            if (this.f10965f != null) {
                this.f10965f.cancel(true);
            }
        }
    }
}
