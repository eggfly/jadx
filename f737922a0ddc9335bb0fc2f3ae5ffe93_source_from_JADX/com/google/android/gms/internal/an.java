package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@eh
public class an {
    private final Collection<am<String>> DW;
    private final Collection<am<String>> FH;
    private final Collection<am> j6;

    public an() {
        this.j6 = new ArrayList();
        this.DW = new ArrayList();
        this.FH = new ArrayList();
    }

    public void DW(am<String> amVar) {
        this.DW.add(amVar);
    }

    public void FH(am<String> amVar) {
        this.FH.add(amVar);
    }

    public List<String> j6() {
        List<String> arrayList = new ArrayList();
        for (am FH : this.DW) {
            String str = (String) FH.FH();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void j6(am amVar) {
        this.j6.add(amVar);
    }
}
