package com.google.android.gms.p146b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

@gb
/* renamed from: com.google.android.gms.b.ds */
public class ds implements dj {
    private final AdRequestInfoParcel f10710a;
    private final du f10711b;
    private final Context f10712c;
    private final Object f10713d;
    private final dl f10714e;
    private final boolean f10715f;
    private final long f10716g;
    private final long f10717h;
    private final az f10718i;
    private final boolean f10719j;
    private boolean f10720k;
    private C3146do f10721l;

    /* renamed from: com.google.android.gms.b.ds.1 */
    class C31491 implements Runnable {
        final /* synthetic */ dp f10708a;
        final /* synthetic */ ds f10709b;

        C31491(ds dsVar, dp dpVar) {
            this.f10709b = dsVar;
            this.f10708a = dpVar;
        }

        public void run() {
            try {
                this.f10708a.f10688c.m12377c();
            } catch (Throwable e) {
                C2972b.m11584d("Could not destroy mediation adapter.", e);
            }
        }
    }

    public ds(Context context, AdRequestInfoParcel adRequestInfoParcel, du duVar, dl dlVar, boolean z, boolean z2, long j, long j2, az azVar) {
        this.f10713d = new Object();
        this.f10720k = false;
        this.f10712c = context;
        this.f10710a = adRequestInfoParcel;
        this.f10711b = duVar;
        this.f10714e = dlVar;
        this.f10715f = z;
        this.f10719j = z2;
        this.f10716g = j;
        this.f10717h = j2;
        this.f10718i = azVar;
    }

    public dp m12355a(List<dk> list) {
        C2972b.m11576a("Starting mediation.");
        Iterable arrayList = new ArrayList();
        aw a = this.f10718i.m11849a();
        for (dk dkVar : list) {
            C2972b.m11581c("Trying mediation network: " + dkVar.f10636b);
            for (String str : dkVar.f10637c) {
                aw a2 = this.f10718i.m11849a();
                synchronized (this.f10713d) {
                    if (this.f10720k) {
                        dp dpVar = new dp(-1);
                        return dpVar;
                    }
                    this.f10721l = new C3146do(this.f10712c, str, this.f10711b, this.f10714e, dkVar, this.f10710a.f9853c, this.f10710a.f9854d, this.f10710a.f9861k, this.f10715f, this.f10719j, this.f10710a.f9876z, this.f10710a.f9864n);
                    dpVar = this.f10721l.m12338a(this.f10716g, this.f10717h);
                    if (dpVar.f10686a == 0) {
                        C2972b.m11576a("Adapter succeeded.");
                        this.f10718i.m11853a("mediation_network_succeed", str);
                        if (!arrayList.isEmpty()) {
                            this.f10718i.m11853a("mediation_networks_fail", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
                        }
                        this.f10718i.m11855a(a2, "mls");
                        this.f10718i.m11855a(a, "ttm");
                        return dpVar;
                    }
                    arrayList.add(str);
                    this.f10718i.m11855a(a2, "mlf");
                    if (dpVar.f10688c != null) {
                        hj.f11297a.post(new C31491(this, dpVar));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f10718i.m11853a("mediation_networks_fail", TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, arrayList));
        }
        return new dp(1);
    }

    public void m12356a() {
        synchronized (this.f10713d) {
            this.f10720k = true;
            if (this.f10721l != null) {
                this.f10721l.m12339a();
            }
        }
    }
}
