package com.google.android.gms.internal;

import afb;
import agg;
import agh;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.cw.a;
import java.util.ArrayList;
import java.util.List;

@eh
public class db extends a {
    private final afb j6;

    public db(afb afb) {
        this.j6 = afb;
    }

    public List DW() {
        List<com.google.android.gms.ads.formats.a.a> Zo = this.j6.Zo();
        if (Zo == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (com.google.android.gms.ads.formats.a.a aVar : Zo) {
            arrayList.add(new com.google.android.gms.ads.internal.formats.a(aVar.j6(), aVar.DW(), aVar.FH()));
        }
        return arrayList;
    }

    public void DW(agg agg) {
        this.j6.j6((View) agh.j6(agg));
    }

    public String FH() {
        return this.j6.VH();
    }

    public bd Hw() {
        com.google.android.gms.ads.formats.a.a gn = this.j6.gn();
        return gn != null ? new com.google.android.gms.ads.internal.formats.a(gn.j6(), gn.DW(), gn.FH()) : null;
    }

    public void VH() {
        this.j6.Hw();
    }

    public String Zo() {
        return this.j6.tp();
    }

    public boolean gn() {
        return this.j6.j6();
    }

    public String j6() {
        return this.j6.v5();
    }

    public void j6(agg agg) {
        this.j6.DW((View) agh.j6(agg));
    }

    public Bundle tp() {
        return this.j6.FH();
    }

    public boolean u7() {
        return this.j6.DW();
    }

    public String v5() {
        return this.j6.u7();
    }
}
