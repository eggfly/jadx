package com.google.android.gms.p146b;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.C2836l;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.C3512u;
import java.util.Iterator;
import java.util.LinkedList;

@gb
/* renamed from: com.google.android.gms.b.cx */
class cx {
    private final LinkedList<C3108a> f10542a;
    private AdRequestParcel f10543b;
    private final String f10544c;
    private final int f10545d;

    /* renamed from: com.google.android.gms.b.cx.a */
    class C3108a {
        C2836l f10535a;
        MutableContextWrapper f10536b;
        cs f10537c;
        long f10538d;
        boolean f10539e;
        boolean f10540f;
        final /* synthetic */ cx f10541g;

        C3108a(cx cxVar, cr crVar) {
            this.f10541g = cxVar;
            cr a = crVar.m12096a();
            this.f10536b = crVar.m12097b();
            this.f10535a = a.m12095a(cxVar.f10544c);
            this.f10537c = new cs();
            this.f10537c.m12134a(this.f10535a);
        }

        private void m12161a() {
            if (!this.f10539e && this.f10541g.f10543b != null) {
                this.f10540f = this.f10535a.m10442a(this.f10541g.f10543b);
                this.f10539e = true;
                this.f10538d = C2968s.m11529i().m13543a();
            }
        }

        void m12162a(AdRequestParcel adRequestParcel) {
            if (adRequestParcel != null) {
                this.f10541g.f10543b = adRequestParcel;
            }
            m12161a();
            Iterator it = this.f10541g.f10542a.iterator();
            while (it.hasNext()) {
                ((C3108a) it.next()).m12161a();
            }
        }

        void m12163a(cr crVar) {
            this.f10536b.setBaseContext(crVar.m12097b().getBaseContext());
        }
    }

    cx(AdRequestParcel adRequestParcel, String str, int i) {
        C3512u.m14580a((Object) adRequestParcel);
        C3512u.m14580a((Object) str);
        this.f10542a = new LinkedList();
        this.f10543b = adRequestParcel;
        this.f10544c = str;
        this.f10545d = i;
    }

    AdRequestParcel m12168a() {
        return this.f10543b;
    }

    void m12169a(cr crVar) {
        C3108a c3108a = new C3108a(this, crVar);
        this.f10542a.add(c3108a);
        c3108a.m12162a(this.f10543b);
    }

    int m12170b() {
        return this.f10545d;
    }

    String m12171c() {
        return this.f10544c;
    }

    C3108a m12172d() {
        return (C3108a) this.f10542a.remove();
    }

    int m12173e() {
        return this.f10542a.size();
    }
}
