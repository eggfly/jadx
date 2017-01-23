package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.v;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.gd;
import java.util.ListIterator;

public class h extends o<h> {
    private final v DW;
    private boolean FH;

    public h(v vVar) {
        super(vVar.gn(), vVar.Hw());
        this.DW = vVar;
    }

    public void DW(String str) {
        Uri j6 = i.j6(str);
        ListIterator listIterator = J8().listIterator();
        while (listIterator.hasNext()) {
            if (j6.equals(((r) listIterator.next()).j6())) {
                listIterator.remove();
            }
        }
    }

    v EQ() {
        return this.DW;
    }

    public void FH(boolean z) {
        this.FH = z;
    }

    protected void j6(l lVar) {
        gd gdVar = (gd) lVar.DW(gd.class);
        if (TextUtils.isEmpty(gdVar.DW())) {
            gdVar.DW(this.DW.QX().DW());
        }
        if (this.FH && TextUtils.isEmpty(gdVar.Hw())) {
            a Ws = this.DW.Ws();
            gdVar.Hw(Ws.FH());
            gdVar.j6(Ws.DW());
        }
    }

    public void j6(String str) {
        b.j6(str);
        DW(str);
        J8().add(new i(this.DW, str));
    }

    public l we() {
        l j6 = J0().j6();
        j6.j6(this.DW.XL().FH());
        j6.j6(this.DW.aM().DW());
        DW(j6);
        return j6;
    }
}
