package com.aide.ui;

import com.aide.common.KeyStrokeDetector.a;
import com.aide.common.k;
import java.util.List;
import qi;

public class b implements a {
    private List<qi> j6;

    public b(List<qi> list) {
        this.j6 = list;
    }

    public boolean j6(k kVar) {
        qi DW = DW(kVar);
        if (DW == null) {
            return false;
        }
        if (DW.g_()) {
            com.aide.analytics.a.DW("Global key command: " + DW.v5());
            DW.DW();
        }
        return true;
    }

    private qi DW(k kVar) {
        for (qi qiVar : this.j6) {
            List<k> j6 = e.BT().j6(qiVar);
            if (j6 != null) {
                for (k j62 : j6) {
                    if (j62.j6(kVar)) {
                        return qiVar;
                    }
                }
                continue;
            }
        }
        return null;
    }
}
