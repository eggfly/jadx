import java.util.ArrayList;
import java.util.Iterator;

public class acq {
    private final boolean DW;
    private final acn FH;
    private final acj j6;

    public static aaa j6(acj acj, boolean z) {
        return new acq(acj, z).j6();
    }

    private acq(acj acj, boolean z) {
        this.DW = z;
        this.j6 = acj;
        this.FH = aco.j6(acj);
    }

    private aaa j6() {
        acp acl = new acl(this.j6, this.FH, this.DW);
        acd DW = acl.DW();
        this.j6.QX();
        this.j6.j6(DW);
        FH();
        if (acl.j6()) {
            Hw();
        }
        DW();
        return new acm(new aaa(v5(), this.j6.j6(this.j6.FH()))).j6();
    }

    private void DW() {
        this.j6.j6(false, new acq$1(this, this.j6.tp()));
    }

    private void FH() {
        ArrayList tp = this.j6.tp();
        Iterator it = tp.iterator();
        while (it.hasNext()) {
            acg acg = (acg) it.next();
            acg.j6(new acq$a(tp));
            acg.DW();
        }
        Iterator it2 = tp.iterator();
        while (it2.hasNext()) {
            ((acg) it2.next()).Mr();
        }
    }

    private void Hw() {
        int gn = this.j6.gn();
        acd abo = new abo(this.j6.VH());
        int VH = this.j6.VH();
        for (int i = 0; i < VH; i++) {
            if (i < gn) {
                abo.j6(i, (VH - gn) + i, 1);
            } else {
                abo.j6(i, i - gn, 1);
            }
        }
        this.j6.j6(abo);
    }

    private zj v5() {
        int i = 0;
        ArrayList tp = this.j6.tp();
        acg Zo = this.j6.Zo();
        this.j6.we();
        int EQ = this.j6.EQ();
        int i2 = (Zo == null || !Zo.j3()) ? 0 : 1;
        zj zjVar = new zj(EQ - i2);
        Iterator it = tp.iterator();
        while (it.hasNext()) {
            acg acg = (acg) it.next();
            if (acg.j3() && acg != Zo) {
                int i3 = i + 1;
                zjVar.j6(i, DW(acg));
                i = i3;
            }
        }
        if (Zo == null || Zo.FH().size() == 0) {
            return zjVar;
        }
        throw new RuntimeException("Exit block must have no insns when leaving SSA form");
    }

    private void j6(acg acg) {
        ArrayList FH = acg.FH();
        zz v5 = ((aci) FH.get(FH.size() - 1)).v5();
        if (v5.Hw() != 2 && v5 != aab.GK) {
            throw new RuntimeException("Exit predecessor must end in valid exit statement.");
        }
    }

    private zi DW(acg acg) {
        adg adg;
        int i = -1;
        adg J8 = acg.J8();
        int we = acg.we();
        acg Zo = this.j6.Zo();
        if (!J8.gn(Zo == null ? -1 : Zo.Zo())) {
            i = we;
            adg = J8;
        } else if (J8.DW() > 1) {
            throw new RuntimeException("Exit predecessor must have no other successors" + add.FH(acg.Zo()));
        } else {
            adg = adg.j6;
            j6(acg);
        }
        adg.l_();
        return new zi(acg.Zo(), j6(acg.FH()), adg, i);
    }

    private zp j6(ArrayList<aci> arrayList) {
        int size = arrayList.size();
        zp zpVar = new zp(size);
        for (int i = 0; i < size; i++) {
            zpVar.j6(i, ((aci) arrayList.get(i)).FH());
        }
        zpVar.l_();
        return zpVar;
    }
}
