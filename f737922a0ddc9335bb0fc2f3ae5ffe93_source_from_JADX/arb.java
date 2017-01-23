import java.io.File;
import java.util.Collection;
import java.util.Set;

abstract class arb extends anr {
    abstract long DW(asg asg, String str, anb anb);

    abstract anx DW(asg asg, anb anb);

    abstract boolean DW(anb anb);

    abstract Collection<? extends ask> EQ();

    abstract long FH(asg asg, anb anb);

    public /* synthetic */ anw FH() {
        return Ws();
    }

    abstract boolean J0();

    abstract arb VH();

    abstract File gn();

    abstract anx j6(asg asg, String str, anb anb);

    abstract arb$c j6(File file, ans ans, boolean z);

    abstract aro j6(File file, File file2);

    abstract void j6(asy asy, asv asv, asg asg);

    abstract void j6(Set<ans> set, amz amz);

    abstract boolean j6(String str);

    abstract awp tp();

    abstract ani u7();

    abstract arb$a[] we();

    arb() {
    }

    public any Hw() {
        return new asg(this);
    }

    public arm Ws() {
        return new arm(this, u7());
    }

    public boolean j6(anb anb) {
        return Hw(anb) || FH(anb.DW());
    }

    File FH(anb anb) {
        return DW(anb.DW());
    }

    File DW(String str) {
        String substring = str.substring(0, 2);
        return new File(new File(gn(), substring), str.substring(2));
    }

    final boolean Hw(anb anb) {
        if (DW(anb)) {
            return true;
        }
        for (arb$a arb_a : we()) {
            if (arb_a.j6.Hw(anb)) {
                return true;
            }
        }
        if (J0() && DW(anb)) {
            return true;
        }
        return false;
    }

    final boolean FH(String str) {
        if (j6(str)) {
            return true;
        }
        for (arb$a arb_a : we()) {
            if (arb_a.j6.FH(str)) {
                return true;
            }
        }
        return false;
    }

    anx j6(asg asg, anb anb) {
        anx Hw = Hw(asg, anb);
        if (Hw != null) {
            return Hw;
        }
        Hw = FH(asg, anb.DW(), anb);
        return Hw == null ? null : Hw;
    }

    final anx Hw(asg asg, anb anb) {
        anx DW = DW(asg, anb);
        if (DW != null) {
            return DW;
        }
        for (arb$a arb_a : we()) {
            DW = arb_a.j6.Hw(asg, anb);
            if (DW != null) {
                return DW;
            }
        }
        if (J0()) {
            DW = DW(asg, anb);
            if (DW != null) {
                return DW;
            }
        }
        return null;
    }

    final anx FH(asg asg, String str, anb anb) {
        anx j6 = j6(asg, str, anb);
        if (j6 != null) {
            return j6;
        }
        for (arb$a arb_a : we()) {
            j6 = arb_a.j6.FH(asg, str, anb);
            if (j6 != null) {
                return j6;
            }
        }
        return null;
    }

    long v5(asg asg, anb anb) {
        long Zo = Zo(asg, anb);
        return 0 <= Zo ? Zo : Hw(asg, anb.DW(), anb);
    }

    final long Zo(asg asg, anb anb) {
        long FH = FH(asg, anb);
        if (0 <= FH) {
            return FH;
        }
        for (arb$a arb_a : we()) {
            FH = arb_a.j6.Zo(asg, anb);
            if (0 <= FH) {
                return FH;
            }
        }
        if (J0()) {
            FH = FH(asg, anb);
            if (0 <= FH) {
                return FH;
            }
        }
        return -1;
    }

    final long Hw(asg asg, String str, anb anb) {
        long DW = DW(asg, str, anb);
        if (0 <= DW) {
            return DW;
        }
        for (arb$a arb_a : we()) {
            DW = arb_a.j6.Hw(asg, str, anb);
            if (0 <= DW) {
                return DW;
            }
        }
        return -1;
    }
}
