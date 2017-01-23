package com.google.android.gms.p146b;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.C2843n;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.p146b.fp.C3206a;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

@gb
/* renamed from: com.google.android.gms.b.ft */
public class ft extends fp {
    protected dp f10951g;
    private du f10952h;
    private dj f10953i;
    private dl f10954j;
    private final az f10955k;
    private final ii f10956l;
    private boolean f10957m;

    /* renamed from: com.google.android.gms.b.ft.1 */
    class C32071 implements Runnable {
        final /* synthetic */ CountDownLatch f10949a;
        final /* synthetic */ ft f10950b;

        C32071(ft ftVar, CountDownLatch countDownLatch) {
            this.f10950b = ftVar;
            this.f10949a = countDownLatch;
        }

        public void run() {
            synchronized (this.f10950b.d) {
                this.f10950b.f10957m = C2843n.m11022a(this.f10950b.f10956l, this.f10950b.f10951g, this.f10949a);
            }
        }
    }

    ft(Context context, C3232a c3232a, du duVar, C2732a c2732a, az azVar, ii iiVar) {
        super(context, c3232a, c2732a);
        this.f10952h = duVar;
        this.f10954j = c3232a.f11168c;
        this.f10955k = azVar;
        this.f10956l = iiVar;
    }

    private void m12750c() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        hj.f11297a.post(new C32071(this, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.d) {
                if (!this.f10957m) {
                    throw new C3206a("View could not be prepared", 0);
                } else if (this.f10956l.m13255r()) {
                    throw new C3206a("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            throw new C3206a("Interrupted while waiting for latch : " + e, 0);
        }
    }

    protected gx m12751a(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.e.f11166a;
        return new gx(adRequestInfoParcel.f9853c, this.f10956l, this.f.f9888d, i, this.f.f9890f, this.f.f9894j, this.f.f9896l, this.f.f9895k, adRequestInfoParcel.f9859i, this.f.f9892h, this.f10951g != null ? this.f10951g.f10687b : null, this.f10951g != null ? this.f10951g.f10688c : null, this.f10951g != null ? this.f10951g.f10689d : AdMobAdapter.class.getName(), this.f10954j, this.f10951g != null ? this.f10951g.f10690e : null, this.f.f9893i, this.e.f11169d, this.f.f9891g, this.e.f11171f, this.f.f9898n, this.f.f9899o, this.e.f11173h, null, this.f.f9880D, this.f.f9881E, this.f.f9882F, this.f.f9883G);
    }

    protected void m12752a(long j) {
        synchronized (this.d) {
            this.f10953i = m12753b(j);
        }
        this.f10951g = this.f10953i.m12291a(this.f10954j.f10650a);
        switch (this.f10951g.f10686a) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                if (this.f10951g.f10687b != null && this.f10951g.f10687b.f10645k != null) {
                    m12750c();
                }
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                throw new C3206a("No fill from any mediation ad networks.", 3);
            default:
                throw new C3206a("Unexpected mediation result: " + this.f10951g.f10686a, 0);
        }
    }

    dj m12753b(long j) {
        if (this.f10954j.f10659j != -1) {
            return new dr(this.b, this.e.f11166a, this.f10952h, this.f10954j, this.f.f9904t, this.f.f9879C, j, ((Long) aq.ay.m11794c()).longValue(), 2);
        }
        return new ds(this.b, this.e.f11166a, this.f10952h, this.f10954j, this.f.f9904t, this.f.f9879C, j, ((Long) aq.ay.m11794c()).longValue(), this.f10955k);
    }

    public void m12754b() {
        synchronized (this.d) {
            super.m12740b();
            if (this.f10953i != null) {
                this.f10953i.m12292a();
            }
        }
    }
}
