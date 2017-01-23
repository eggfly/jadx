import java.util.ArrayList;
import java.util.List;

public class abv {
    private final acj j6;

    public static void j6(acj acj) {
        new abv(acj).j6();
    }

    private abv(acj acj) {
        this.j6 = acj;
    }

    private static boolean DW(zw zwVar) {
        abm gn = zwVar.gn();
        if (!(gn instanceof aay)) {
            return false;
        }
        if (((aay) gn).EQ() == 0) {
            return true;
        }
        return false;
    }

    private void j6() {
        this.j6.j6(new abv$1(this, aca.DW()));
    }

    private boolean j6(abz abz) {
        zz Zo = abz.Zo().Zo();
        zw Ws = abz.Ws();
        if (!(Ws == null || this.j6.j6(Ws) || Zo.j6() == 5)) {
            abm gn = abz.Ws().gn();
            if (gn.Zo() && gn.FH() == 6) {
                j6(abz, zx.j6, 5, (aah) gn);
                if (Zo.j6() == 56) {
                    ArrayList FH = ((acg) this.j6.tp().get(abz.QX().gn().nextSetBit(0))).FH();
                    j6((abz) FH.get(FH.size() - 1), zx.j6, 6, null);
                }
                return true;
            }
        }
        return false;
    }

    private void j6(abz abz, zx zxVar, int i, aah aah) {
        zo zuVar;
        zo Zo = abz.Zo();
        zz j6 = aab.j6(i, abz.Ws(), zxVar, aah);
        if (aah == null) {
            zuVar = new zu(j6, Zo.VH(), abz.Ws(), zxVar);
        } else {
            zuVar = new zt(j6, Zo.VH(), abz.Ws(), zxVar, aah);
        }
        aci abz2 = new abz(zuVar, abz.QX());
        List FH = abz.QX().FH();
        this.j6.DW((aci) abz);
        FH.set(FH.lastIndexOf(abz), abz2);
        this.j6.j6(abz2);
    }
}
