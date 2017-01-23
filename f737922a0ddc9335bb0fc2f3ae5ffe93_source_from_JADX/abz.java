import com.aide.uidesigner.ProxyTextView;

public final class abz extends aci implements Cloneable {
    private zo j6;

    public /* synthetic */ aci J8() {
        return j6();
    }

    public /* synthetic */ Object clone() {
        return j6();
    }

    abz(zo zoVar, acg acg) {
        super(zoVar.gn(), acg);
        this.j6 = zoVar;
    }

    public final void j6(acd acd) {
        zx tp = this.j6.tp();
        zx j6 = acd.j6(tp);
        if (j6 != tp) {
            this.j6 = this.j6.j6(Ws(), j6);
            QX().Ws().j6((aci) this, tp);
        }
    }

    public final void j6(int i, zw zwVar) {
        zx tp = this.j6.tp();
        int m_ = tp.m_();
        zx zxVar = new zx(m_);
        int i2 = 0;
        while (i2 < m_) {
            zxVar.j6(i2, i2 == i ? zwVar : tp.DW(i2));
            i2++;
        }
        zxVar.l_();
        zw DW = tp.DW(i);
        if (DW.VH() != zwVar.VH()) {
            QX().Ws().j6((aci) this, DW, zwVar);
        }
        this.j6 = this.j6.j6(Ws(), zxVar);
    }

    public final void j6(zx zxVar) {
        if (this.j6.tp().m_() != zxVar.m_()) {
            throw new RuntimeException("Sources counts don't match");
        }
        this.j6 = this.j6.j6(Ws(), zxVar);
    }

    public abz j6() {
        return (abz) super.J8();
    }

    public zx DW() {
        return this.j6.tp();
    }

    public String Hw() {
        return FH().Hw();
    }

    public zo FH() {
        return this.j6.j6(Ws(), this.j6.tp());
    }

    public zz v5() {
        return this.j6.Zo();
    }

    public zo Zo() {
        return this.j6;
    }

    public zw VH() {
        zw DW;
        if (this.j6.Zo().j6() == 54) {
            DW = this.j6.tp().DW(0);
        } else {
            DW = Ws();
        }
        if (DW == null || DW.u7() == null) {
            return null;
        }
        return DW;
    }

    public void gn() {
        zx tp = this.j6.tp();
        this.j6 = this.j6.we();
        QX().Ws().j6((aci) this, tp);
    }

    public boolean u7() {
        return this.j6.Zo().j6() == 2;
    }

    public boolean tp() {
        return this.j6.Zo().j6() == 4;
    }

    public boolean EQ() {
        return this.j6.EQ();
    }

    public void j6(aci$a aci_a) {
        if (u7()) {
            aci_a.j6(this);
        } else {
            aci_a.DW(this);
        }
    }

    public boolean we() {
        return u7();
    }

    public boolean J0() {
        zz v5 = v5();
        if (v5.Hw() != 1) {
            return true;
        }
        boolean z = aca.j6() && VH() != null;
        switch (v5.j6()) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case 5:
            case 55:
                return z;
            default:
                return true;
        }
    }
}
