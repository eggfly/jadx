package com.google.android.gms.p146b;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.b.dr */
public class dr implements dj {
    private final AdRequestInfoParcel f10696a;
    private final du f10697b;
    private final Context f10698c;
    private final dl f10699d;
    private final boolean f10700e;
    private final long f10701f;
    private final long f10702g;
    private final int f10703h;
    private final Object f10704i;
    private boolean f10705j;
    private final Map<hz<dp>, C3146do> f10706k;
    private final boolean f10707l;

    /* renamed from: com.google.android.gms.b.dr.1 */
    class C31471 implements Callable<dp> {
        final /* synthetic */ C3146do f10692a;
        final /* synthetic */ dr f10693b;

        C31471(dr drVar, C3146do c3146do) {
            this.f10693b = drVar;
            this.f10692a = c3146do;
        }

        public dp m12344a() {
            synchronized (this.f10693b.f10704i) {
                if (this.f10693b.f10705j) {
                    return null;
                }
                return this.f10692a.m12338a(this.f10693b.f10701f, this.f10693b.f10702g);
            }
        }

        public /* synthetic */ Object call() {
            return m12344a();
        }
    }

    /* renamed from: com.google.android.gms.b.dr.2 */
    class C31482 implements Runnable {
        final /* synthetic */ hz f10694a;
        final /* synthetic */ dr f10695b;

        C31482(dr drVar, hz hzVar) {
            this.f10695b = drVar;
            this.f10694a = hzVar;
        }

        public void run() {
            for (hz hzVar : this.f10695b.f10706k.keySet()) {
                if (hzVar != this.f10694a) {
                    ((C3146do) this.f10695b.f10706k.get(hzVar)).m12339a();
                }
            }
        }
    }

    public dr(Context context, AdRequestInfoParcel adRequestInfoParcel, du duVar, dl dlVar, boolean z, boolean z2, long j, long j2, int i) {
        this.f10704i = new Object();
        this.f10705j = false;
        this.f10706k = new HashMap();
        this.f10698c = context;
        this.f10696a = adRequestInfoParcel;
        this.f10697b = duVar;
        this.f10699d = dlVar;
        this.f10700e = z;
        this.f10707l = z2;
        this.f10701f = j;
        this.f10702g = j2;
        this.f10703h = i;
    }

    private void m12346a(hz<dp> hzVar) {
        hj.f11297a.post(new C31482(this, hzVar));
    }

    private dp m12347b(List<hz<dp>> list) {
        Throwable e;
        synchronized (this.f10704i) {
            if (this.f10705j) {
                dp dpVar = new dp(-1);
                return dpVar;
            }
            for (hz hzVar : list) {
                try {
                    dpVar = (dp) hzVar.get();
                    if (dpVar != null && dpVar.f10686a == 0) {
                        m12346a(hzVar);
                        return dpVar;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", e);
                } catch (ExecutionException e3) {
                    e = e3;
                    C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", e);
                }
            }
            m12346a(null);
            return new dp(1);
        }
    }

    private dp m12350c(List<hz<dp>> list) {
        RemoteException max;
        synchronized (this.f10704i) {
            if (this.f10705j) {
                dp dpVar = new dp(-1);
                return dpVar;
            }
            long j = -1;
            hz hzVar = null;
            dpVar = null;
            long j2 = this.f10699d.f10660k != -1 ? this.f10699d.f10660k : 10000;
            long j3 = j2;
            for (hz hzVar2 : list) {
                dp dpVar2;
                dy dyVar;
                int a;
                dp dpVar3;
                hz hzVar3;
                dp dpVar4;
                long a2 = C2968s.m11529i().m13543a();
                if (j3 == 0) {
                    try {
                        if (hzVar2.isDone()) {
                            dpVar2 = (dp) hzVar2.get();
                            if (dpVar2 != null && dpVar2.f10686a == 0) {
                                dyVar = dpVar2.f10691f;
                                if (dyVar != null && dyVar.m12311a() > j) {
                                    a = dyVar.m12311a();
                                    dpVar3 = dpVar2;
                                    hzVar3 = hzVar2;
                                    dpVar4 = dpVar3;
                                    hzVar = hzVar3;
                                    dpVar3 = dpVar4;
                                    max = Math.max(j3 - (C2968s.m11529i().m13543a() - a2), 0);
                                    j = a;
                                    dpVar = dpVar3;
                                    j3 = max;
                                }
                            }
                            dpVar4 = dpVar;
                            hzVar3 = hzVar;
                            a = j;
                            hzVar = hzVar3;
                            dpVar3 = dpVar4;
                            max = Math.max(j3 - (C2968s.m11529i().m13543a() - a2), 0);
                            j = a;
                            dpVar = dpVar3;
                            j3 = max;
                        }
                    } catch (InterruptedException e) {
                        max = e;
                        try {
                            C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", max);
                            j3 = max;
                        } finally {
                            dpVar = j3 - (C2968s.m11529i().m13543a() - a2);
                            j = 0;
                            Math.max(dpVar, j);
                            j = j3;
                        }
                    } catch (ExecutionException e2) {
                        max = e2;
                        C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (RemoteException e3) {
                        max = e3;
                        C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    } catch (TimeoutException e4) {
                        max = e4;
                        C2972b.m11584d("Exception while processing an adapter; continuing with other adapters", max);
                        j3 = max;
                    }
                }
                dpVar2 = (dp) hzVar2.get(j3, TimeUnit.MILLISECONDS);
                dyVar = dpVar2.f10691f;
                a = dyVar.m12311a();
                dpVar3 = dpVar2;
                hzVar3 = hzVar2;
                dpVar4 = dpVar3;
                hzVar = hzVar3;
                dpVar3 = dpVar4;
                max = Math.max(j3 - (C2968s.m11529i().m13543a() - a2), 0);
                j = a;
                dpVar = dpVar3;
                j3 = max;
            }
            m12346a(hzVar);
            return dpVar == null ? new dp(1) : dpVar;
        }
    }

    public dp m12353a(List<dk> list) {
        C2972b.m11576a("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (dk dkVar : list) {
            C2972b.m11581c("Trying mediation network: " + dkVar.f10636b);
            for (String c3146do : dkVar.f10637c) {
                C3146do c3146do2 = new C3146do(this.f10698c, c3146do, this.f10697b, this.f10699d, dkVar, this.f10696a.f9853c, this.f10696a.f9854d, this.f10696a.f9861k, this.f10700e, this.f10707l, this.f10696a.f9876z, this.f10696a.f9864n);
                hz a = hi.m13006a(newCachedThreadPool, new C31471(this, c3146do2));
                this.f10706k.put(a, c3146do2);
                arrayList.add(a);
            }
        }
        switch (this.f10703h) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                return m12350c(arrayList);
            default:
                return m12347b(arrayList);
        }
    }

    public void m12354a() {
        synchronized (this.f10704i) {
            this.f10705j = true;
            for (C3146do a : this.f10706k.values()) {
                a.m12339a();
            }
        }
    }
}
