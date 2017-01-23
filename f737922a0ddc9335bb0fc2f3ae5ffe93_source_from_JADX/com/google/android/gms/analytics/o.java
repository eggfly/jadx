package com.google.android.gms.analytics;

import afq;
import com.google.android.gms.common.internal.b;
import java.util.ArrayList;
import java.util.List;

public abstract class o<T extends o> {
    private final p DW;
    private final List<m> FH;
    protected final l j6;

    protected o(p pVar, afq afq) {
        b.j6((Object) pVar);
        this.DW = pVar;
        this.FH = new ArrayList();
        l lVar = new l(this, afq);
        lVar.EQ();
        this.j6 = lVar;
    }

    protected void DW(l lVar) {
        for (m j6 : this.FH) {
            j6.j6(this, lVar);
        }
    }

    public l J0() {
        return this.j6;
    }

    public List<r> J8() {
        return this.j6.FH();
    }

    protected p Ws() {
        return this.DW;
    }

    protected void j6(l lVar) {
    }

    public l we() {
        l j6 = this.j6.j6();
        DW(j6);
        return j6;
    }
}
