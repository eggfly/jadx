import com.aide.uidesigner.ProxyTextView;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class aco {
    private final BitSet DW;
    private final int FH;
    private final acj Hw;
    private int VH;
    private acg Zo;
    private aco$a gn;
    private final BitSet j6;
    private final acn v5;

    public static acn j6(acj acj) {
        int VH = acj.VH();
        acn acn = new acn(VH);
        for (int i = 0; i < VH; i++) {
            new aco(acj, i, acn).j6();
        }
        j6(acj, acn);
        return acn;
    }

    private aco(acj acj, int i, acn acn) {
        int size = acj.tp().size();
        this.Hw = acj;
        this.FH = i;
        this.j6 = new BitSet(size);
        this.DW = new BitSet(size);
        this.v5 = acn;
    }

    private void DW() {
        while (this.gn != aco$a.DONE) {
            switch (aco$1.j6[this.gn.ordinal()]) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.gn = aco$a.DONE;
                    Hw();
                    break;
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.gn = aco$a.DONE;
                    v5();
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.gn = aco$a.DONE;
                    FH();
                    break;
                default:
                    break;
            }
        }
    }

    public void j6() {
        for (aci aci : this.Hw.Hw(this.FH)) {
            this.gn = aco$a.DONE;
            if (aci instanceof acb) {
                for (acg acg : ((acb) aci).j6(this.FH, this.Hw)) {
                    this.Zo = acg;
                    this.gn = aco$a.LIVE_OUT_AT_BLOCK;
                    DW();
                }
            } else {
                this.Zo = aci.QX();
                this.VH = this.Zo.FH().indexOf(aci);
                if (this.VH < 0) {
                    throw new RuntimeException("insn not found in it's own block");
                }
                this.gn = aco$a.LIVE_IN_AT_STATEMENT;
                DW();
            }
        }
        while (true) {
            int nextSetBit = this.DW.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.Zo = (acg) this.Hw.tp().get(nextSetBit);
                this.DW.clear(nextSetBit);
                this.gn = aco$a.LIVE_OUT_AT_BLOCK;
                DW();
            } else {
                return;
            }
        }
    }

    private void FH() {
        if (!this.j6.get(this.Zo.v5())) {
            this.j6.set(this.Zo.v5());
            this.Zo.FH(this.FH);
            this.VH = this.Zo.FH().size() - 1;
            this.gn = aco$a.LIVE_OUT_AT_STATEMENT;
        }
    }

    private void Hw() {
        if (this.VH == 0) {
            this.Zo.Hw(this.FH);
            this.DW.or(this.Zo.gn());
            return;
        }
        this.VH--;
        this.gn = aco$a.LIVE_OUT_AT_STATEMENT;
    }

    private void v5() {
        aci aci = (aci) this.Zo.FH().get(this.VH);
        zw Ws = aci.Ws();
        if (!aci.DW(this.FH)) {
            if (Ws != null) {
                this.v5.j6(this.FH, Ws.VH());
            }
            this.gn = aco$a.LIVE_IN_AT_STATEMENT;
        }
    }

    private static void j6(acj acj, acn acn) {
        Iterator it = acj.tp().iterator();
        while (it.hasNext()) {
            List Hw = ((acg) it.next()).Hw();
            int size = Hw.size();
            for (int i = 0; i < size; i++) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (i != i2) {
                        acn.j6(((aci) Hw.get(i)).Ws().VH(), ((aci) Hw.get(i2)).Ws().VH());
                    }
                }
            }
        }
    }
}
