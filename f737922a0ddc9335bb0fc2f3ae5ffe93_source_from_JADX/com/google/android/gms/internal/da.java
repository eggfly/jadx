package com.google.android.gms.internal;

import afa;
import agg;
import agh;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.cv.a;
import java.util.ArrayList;
import java.util.List;

@eh
public class da extends a {
    private final afa j6;

    public da(afa afa) {
        this.j6 = afa;
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

    public boolean EQ() {
        return this.j6.DW();
    }

    public String FH() {
        return this.j6.VH();
    }

    public bd Hw() {
        com.google.android.gms.ads.formats.a.a gn = this.j6.gn();
        return gn != null ? new com.google.android.gms.ads.internal.formats.a(gn.j6(), gn.DW(), gn.FH()) : null;
    }

    public String VH() {
        return this.j6.EQ();
    }

    public double Zo() {
        return this.j6.tp();
    }

    public String gn() {
        return this.j6.we();
    }

    public String j6() {
        return this.j6.v5();
    }

    public void j6(agg agg) {
        this.j6.DW((View) agh.j6(agg));
    }

    public boolean tp() {
        return this.j6.j6();
    }

    public void u7() {
        this.j6.Hw();
    }

    public String v5() {
        return this.j6.u7();
    }

    public Bundle we() {
        return this.j6.FH();
    }
}
