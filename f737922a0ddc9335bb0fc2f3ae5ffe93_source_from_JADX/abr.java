import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class abr {
    private static boolean j6;
    private final acj DW;
    private final ArrayList<acg> FH;
    private final abr$a[] Hw;

    static {
        j6 = false;
    }

    public abr(acj acj) {
        this.DW = acj;
        this.FH = acj.tp();
        int size = this.FH.size();
        this.Hw = new abr$a[size];
        for (int i = 0; i < size; i++) {
            this.Hw[i] = new abr$a();
        }
    }

    public abr$a[] j6() {
        int i;
        int size = this.FH.size();
        if (j6) {
            for (int i2 = 0; i2 < size; i2++) {
                System.out.println("pred[" + i2 + "]: " + ((acg) this.FH.get(i2)).gn());
            }
        }
        abs.j6(this.DW, this.Hw, false);
        if (j6) {
            for (i = 0; i < size; i++) {
                System.out.println("idom[" + i + "]: " + this.Hw[i].DW);
            }
        }
        FH();
        if (j6) {
            DW();
        }
        for (i = 0; i < size; i++) {
            this.Hw[i].j6 = acf.j6(size);
        }
        Hw();
        if (j6) {
            for (i = 0; i < size; i++) {
                System.out.println("df[" + i + "]: " + this.Hw[i].j6);
            }
        }
        return this.Hw;
    }

    private void DW() {
        int size = this.FH.size();
        for (int i = 0; i < size; i++) {
            acg acg = (acg) this.FH.get(i);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('{');
            Iterator it = acg.j6().iterator();
            Object obj = null;
            while (it.hasNext()) {
                acg acg2 = (acg) it.next();
                if (obj != null) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(acg2);
                int i2 = 1;
            }
            stringBuffer.append('}');
            System.out.println("domChildren[" + acg + "]: " + stringBuffer);
        }
    }

    private void FH() {
        int size = this.FH.size();
        for (int i = 0; i < size; i++) {
            abr$a abr_a = this.Hw[i];
            if (abr_a.DW != -1) {
                ((acg) this.FH.get(abr_a.DW)).j6((acg) this.FH.get(i));
            }
        }
    }

    private void Hw() {
        int size = this.FH.size();
        for (int i = 0; i < size; i++) {
            acg acg = (acg) this.FH.get(i);
            abr$a abr_a = this.Hw[i];
            BitSet gn = acg.gn();
            if (gn.cardinality() > 1) {
                for (int nextSetBit = gn.nextSetBit(0); nextSetBit >= 0; nextSetBit = gn.nextSetBit(nextSetBit + 1)) {
                    int i2 = nextSetBit;
                    while (i2 != abr_a.DW && i2 != -1) {
                        abr$a abr_a2 = this.Hw[i2];
                        if (abr_a2.j6.DW(i)) {
                            break;
                        }
                        abr_a2.j6.j6(i);
                        i2 = abr_a2.DW;
                    }
                }
            }
        }
    }
}
