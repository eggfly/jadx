import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

class uv$b implements zo$b {
    final /* synthetic */ uv DW;
    private zi FH;
    private uc Hw;
    private final ur j6;

    public uv$b(uv uvVar, ur urVar) {
        this.DW = uvVar;
        this.j6 = urVar;
    }

    public void j6(zi ziVar, uc ucVar) {
        this.FH = ziVar;
        this.Hw = ucVar;
    }

    public void j6(zu zuVar) {
        zz Zo = zuVar.Zo();
        if (Zo.j6() != 54 && Zo.j6() != 56) {
            uf uwVar;
            aac VH = zuVar.VH();
            uh j6 = uu.j6(zuVar);
            switch (Zo.Hw()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case 6:
                    uwVar = new uw(j6, VH, uv.DW((zo) zuVar));
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    uwVar = new uz(j6, VH, uv.DW((zo) zuVar), this.DW.v5.j6(this.FH.FH().DW(1)));
                    break;
                default:
                    throw new RuntimeException("shouldn't happen");
            }
            j6(uwVar);
        }
    }

    public void j6(zt ztVar) {
        aac VH = ztVar.VH();
        uh j6 = uu.j6(ztVar);
        zz Zo = ztVar.Zo();
        int j62 = Zo.j6();
        if (Zo.Hw() != 1) {
            throw new RuntimeException("shouldn't happen");
        } else if (j62 != 3) {
            j6(new ud(j6, VH, uv.DW((zo) ztVar), ztVar.p_()));
        } else if (!this.DW.EQ) {
            zw gn = ztVar.gn();
            j6(new uw(j6, VH, zx.j6(gn, zw.j6(((aat) ztVar.p_()).r_() + (this.DW.gn - this.DW.tp), gn.j6()))));
        }
    }

    public void j6(aad aad) {
        aac VH = aad.VH();
        adg FH = aad.FH();
        adg FH2 = this.FH.FH();
        int DW = FH.DW();
        int DW2 = FH2.DW();
        int Hw = this.FH.Hw();
        if (DW == DW2 - 1 && Hw == FH2.DW(DW)) {
            uc[] ucVarArr = new uc[DW];
            for (DW2 = 0; DW2 < DW; DW2++) {
                ucVarArr[DW2] = this.DW.v5.j6(FH2.DW(DW2));
            }
            uf ucVar = new uc(VH);
            uf uyVar = new uy(VH, this.Hw, FH, ucVarArr);
            uf uzVar = new uz(uyVar.FH() ? ui.Mz : ui.I, VH, uv.DW((zo) aad), ucVar);
            j6(this.Hw);
            j6(uzVar);
            DW(new uq(VH));
            DW(ucVar);
            DW(uyVar);
            return;
        }
        throw new RuntimeException("shouldn't happen");
    }

    private zw j6() {
        int Hw = this.FH.Hw();
        if (Hw < 0) {
            return null;
        }
        zo j6 = this.DW.DW.j6().DW(Hw).DW().j6(0);
        if (j6.Zo().j6() == 56) {
            return j6.gn();
        }
        return null;
    }

    public void j6(aae aae) {
        Object obj = 1;
        aac VH = aae.VH();
        uh j6 = uu.j6(aae);
        zz Zo = aae.Zo();
        aah p_ = aae.p_();
        if (Zo.Hw() != 6) {
            throw new RuntimeException("shouldn't happen");
        }
        j6(this.Hw);
        if (Zo.v5()) {
            j6(new ud(j6, VH, aae.tp(), p_));
            return;
        }
        Object obj2;
        zw j62 = j6();
        zx j63 = uv.DW(aae, j62);
        if (j6.Hw() || Zo.j6() == 43) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (j62 == null) {
            obj = null;
        }
        if (obj2 != obj) {
            throw new RuntimeException("Insn with result/move-result-pseudo mismatch " + aae);
        }
        uf udVar;
        if (Zo.j6() != 41 || j6.j6() == 35) {
            udVar = new ud(j6, VH, j63, p_);
        } else {
            udVar = new uw(j6, VH, j63);
        }
        j6(udVar);
    }

    public void j6(aaf aaf) {
        aac VH = aaf.VH();
        uh j6 = uu.j6(aaf);
        if (aaf.Zo().Hw() != 6) {
            throw new RuntimeException("shouldn't happen");
        }
        zw j62 = j6();
        if (j6.Hw() != (j62 != null)) {
            throw new RuntimeException("Insn with result/move-result-pseudo mismatch" + aaf);
        }
        j6(this.Hw);
        j6(new uw(j6, VH, uv.DW(aaf, j62)));
    }

    public void j6(zn znVar) {
        aac VH = znVar.VH();
        aah v5 = znVar.v5();
        ArrayList FH = znVar.FH();
        if (znVar.Zo().Hw() != 1) {
            throw new RuntimeException("shouldn't happen");
        }
        uf ucVar = new uc(VH);
        uf txVar = new tx(VH, this.Hw, FH, v5);
        uf uzVar = new uz(ui.sG, VH, uv.DW((zo) znVar), ucVar);
        j6(this.Hw);
        j6(uzVar);
        DW(new uq(VH));
        DW(ucVar);
        DW(txVar);
    }

    protected void j6(uf ufVar) {
        this.j6.j6(ufVar);
    }

    protected void DW(uf ufVar) {
        this.j6.DW(ufVar);
    }
}
