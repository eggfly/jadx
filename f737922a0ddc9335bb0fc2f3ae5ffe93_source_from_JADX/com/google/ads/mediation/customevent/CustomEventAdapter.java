package com.google.ads.mediation.customevent;

import aeo$a;
import aep;
import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.d;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.ads.mediation.g;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements d<com.google.android.gms.ads.mediation.customevent.d, f>, f<com.google.android.gms.ads.mediation.customevent.d, f> {
    d DW;
    private View FH;
    b j6;

    static final class a implements c {
        private final e DW;
        private final CustomEventAdapter j6;

        public a(CustomEventAdapter customEventAdapter, e eVar) {
            this.j6 = customEventAdapter;
            this.DW = eVar;
        }
    }

    class b implements e {
        private final CustomEventAdapter DW;
        private final g FH;
        final /* synthetic */ CustomEventAdapter j6;

        public b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, g gVar) {
            this.j6 = customEventAdapter;
            this.DW = customEventAdapter2;
            this.FH = gVar;
        }
    }

    private static <T> T j6(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            com.google.android.gms.ads.internal.util.client.b.Hw(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    public Class<com.google.android.gms.ads.mediation.customevent.d> DW() {
        return com.google.android.gms.ads.mediation.customevent.d.class;
    }

    public Class<f> FH() {
        return f.class;
    }

    public View Hw() {
        return this.FH;
    }

    b j6(g gVar) {
        return new b(this, this, gVar);
    }

    public void j6() {
        if (this.j6 != null) {
            this.j6.j6();
        }
        if (this.DW != null) {
            this.DW.j6();
        }
    }

    public void j6(e eVar, Activity activity, f fVar, aep aep, com.google.ads.mediation.b bVar, com.google.android.gms.ads.mediation.customevent.d dVar) {
        this.j6 = (b) j6(fVar.DW);
        if (this.j6 == null) {
            eVar.j6(this, aeo$a.INTERNAL_ERROR);
        } else {
            this.j6.j6(new a(this, eVar), activity, fVar.j6, fVar.FH, aep, bVar, dVar == null ? null : dVar.j6(fVar.j6));
        }
    }

    public void j6(g gVar, Activity activity, f fVar, com.google.ads.mediation.b bVar, com.google.android.gms.ads.mediation.customevent.d dVar) {
        this.DW = (d) j6(fVar.DW);
        if (this.DW == null) {
            gVar.j6(this, aeo$a.INTERNAL_ERROR);
        } else {
            this.DW.j6(j6(gVar), activity, fVar.j6, fVar.FH, bVar, dVar == null ? null : dVar.j6(fVar.j6));
        }
    }

    public void v5() {
        this.DW.DW();
    }
}
