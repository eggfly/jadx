package com.google.android.gms.p146b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C2810h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p146b.C3364q.C3360a;
import com.google.android.gms.p146b.C3364q.C3363d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@gb
/* renamed from: com.google.android.gms.b.t */
public class C3367t implements C3366u {
    private final Object f11739a;
    private final WeakHashMap<gx, C3364q> f11740b;
    private final ArrayList<C3364q> f11741c;
    private final Context f11742d;
    private final VersionInfoParcel f11743e;
    private final dd f11744f;

    public C3367t(Context context, VersionInfoParcel versionInfoParcel, dd ddVar) {
        this.f11739a = new Object();
        this.f11740b = new WeakHashMap();
        this.f11741c = new ArrayList();
        this.f11742d = context.getApplicationContext();
        this.f11743e = versionInfoParcel;
        this.f11744f = ddVar;
    }

    public C3364q m13873a(AdSizeParcel adSizeParcel, gx gxVar) {
        return m13874a(adSizeParcel, gxVar, gxVar.f11179b.m13233b());
    }

    public C3364q m13874a(AdSizeParcel adSizeParcel, gx gxVar, View view) {
        return m13877a(adSizeParcel, gxVar, new C3363d(view, gxVar), null);
    }

    public C3364q m13875a(AdSizeParcel adSizeParcel, gx gxVar, View view, de deVar) {
        return m13877a(adSizeParcel, gxVar, new C3363d(view, gxVar), deVar);
    }

    public C3364q m13876a(AdSizeParcel adSizeParcel, gx gxVar, C2810h c2810h) {
        return m13877a(adSizeParcel, gxVar, new C3360a(c2810h), null);
    }

    public C3364q m13877a(AdSizeParcel adSizeParcel, gx gxVar, C3359y c3359y, de deVar) {
        C3364q c3364q;
        synchronized (this.f11739a) {
            if (m13879a(gxVar)) {
                c3364q = (C3364q) this.f11740b.get(gxVar);
            } else {
                if (deVar != null) {
                    c3364q = new C3368v(this.f11742d, adSizeParcel, gxVar, this.f11743e, c3359y, deVar);
                } else {
                    c3364q = new C3376x(this.f11742d, adSizeParcel, gxVar, this.f11743e, c3359y, this.f11744f);
                }
                c3364q.m13844a((C3366u) this);
                this.f11740b.put(gxVar, c3364q);
                this.f11741c.add(c3364q);
            }
        }
        return c3364q;
    }

    public void m13878a(C3364q c3364q) {
        synchronized (this.f11739a) {
            if (!c3364q.m13855f()) {
                this.f11741c.remove(c3364q);
                Iterator it = this.f11740b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == c3364q) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean m13879a(gx gxVar) {
        boolean z;
        synchronized (this.f11739a) {
            C3364q c3364q = (C3364q) this.f11740b.get(gxVar);
            z = c3364q != null && c3364q.m13855f();
        }
        return z;
    }

    public void m13880b(gx gxVar) {
        synchronized (this.f11739a) {
            C3364q c3364q = (C3364q) this.f11740b.get(gxVar);
            if (c3364q != null) {
                c3364q.m13853d();
            }
        }
    }

    public void m13881c(gx gxVar) {
        synchronized (this.f11739a) {
            C3364q c3364q = (C3364q) this.f11740b.get(gxVar);
            if (c3364q != null) {
                c3364q.m13863n();
            }
        }
    }

    public void m13882d(gx gxVar) {
        synchronized (this.f11739a) {
            C3364q c3364q = (C3364q) this.f11740b.get(gxVar);
            if (c3364q != null) {
                c3364q.m13864o();
            }
        }
    }

    public void m13883e(gx gxVar) {
        synchronized (this.f11739a) {
            C3364q c3364q = (C3364q) this.f11740b.get(gxVar);
            if (c3364q != null) {
                c3364q.m13865p();
            }
        }
    }
}
