package com.google.android.gms.ads.mediation.customevent;

import aer;
import aet;
import aeu;
import aev;
import aew;
import aex;
import aey;
import afc;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.d;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements aet, aev, aex {
    e DW;
    g FH;
    private View Hw;
    b j6;

    static final class a implements c {
        private final aeu DW;
        private final CustomEventAdapter j6;

        public a(CustomEventAdapter customEventAdapter, aeu aeu) {
            this.j6 = customEventAdapter;
            this.DW = aeu;
        }
    }

    class b implements f {
        private final CustomEventAdapter DW;
        private final aew FH;
        final /* synthetic */ CustomEventAdapter j6;

        public b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, aew aew) {
            this.j6 = customEventAdapter;
            this.DW = customEventAdapter2;
            this.FH = aew;
        }
    }

    static class c implements h {
        private final aey DW;
        private final CustomEventAdapter j6;

        public c(CustomEventAdapter customEventAdapter, aey aey) {
            this.j6 = customEventAdapter;
            this.DW = aey;
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

    public void DW() {
        if (this.j6 != null) {
            this.j6.DW();
        }
        if (this.DW != null) {
            this.DW.DW();
        }
        if (this.FH != null) {
            this.FH.DW();
        }
    }

    public void FH() {
        if (this.j6 != null) {
            this.j6.FH();
        }
        if (this.DW != null) {
            this.DW.FH();
        }
        if (this.FH != null) {
            this.FH.FH();
        }
    }

    public View Hw() {
        return this.Hw;
    }

    b j6(aew aew) {
        return new b(this, this, aew);
    }

    public void j6() {
        if (this.j6 != null) {
            this.j6.j6();
        }
        if (this.DW != null) {
            this.DW.j6();
        }
        if (this.FH != null) {
            this.FH.j6();
        }
    }

    public void j6(Context context, aeu aeu, Bundle bundle, d dVar, aer aer, Bundle bundle2) {
        this.j6 = (b) j6(bundle.getString("class_name"));
        if (this.j6 == null) {
            aeu.j6(this, 0);
            return;
        }
        this.j6.j6(context, new a(this, aeu), bundle.getString("parameter"), dVar, aer, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void j6(Context context, aew aew, Bundle bundle, aer aer, Bundle bundle2) {
        this.DW = (e) j6(bundle.getString("class_name"));
        if (this.DW == null) {
            aew.j6(this, 0);
            return;
        }
        this.DW.j6(context, j6(aew), bundle.getString("parameter"), aer, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void j6(Context context, aey aey, Bundle bundle, afc afc, Bundle bundle2) {
        this.FH = (g) j6(bundle.getString("class_name"));
        if (this.FH == null) {
            aey.j6((aex) this, 0);
            return;
        }
        this.FH.j6(context, new c(this, aey), bundle.getString("parameter"), afc, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void v5() {
        this.DW.Hw();
    }
}
