package com.google.android.gms.internal;

public abstract class n<M extends n<M>> extends t {
    protected p J0;

    protected int FH() {
        int i = 0;
        if (this.J0 == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.J0.j6()) {
            i2 += this.J0.DW(i).j6();
            i++;
        }
        return i2;
    }

    public M Hw() {
        n nVar = (n) super.v5();
        r.j6(this, nVar);
        return nVar;
    }

    public /* synthetic */ Object clone() {
        return Hw();
    }

    public void j6(m mVar) {
        if (this.J0 != null) {
            for (int i = 0; i < this.J0.j6(); i++) {
                this.J0.DW(i).j6(mVar);
            }
        }
    }

    protected final boolean j6(l lVar, int i) {
        int aM = lVar.aM();
        if (!lVar.DW(i)) {
            return false;
        }
        int DW = w.DW(i);
        v vVar = new v(i, lVar.j6(aM, lVar.aM() - aM));
        q qVar = null;
        if (this.J0 == null) {
            this.J0 = new p();
        } else {
            qVar = this.J0.j6(DW);
        }
        if (qVar == null) {
            qVar = new q();
            this.J0.j6(DW, qVar);
        }
        qVar.j6(vVar);
        return true;
    }

    public /* synthetic */ t v5() {
        return (n) clone();
    }
}
