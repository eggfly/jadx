import java.util.ArrayList;
import java.util.List;

public class az {
    private en$b DW;
    private en$c[] FH;
    private final cc j6;

    public az(cc ccVar) {
        this.j6 = ccVar;
    }

    public void j6(cj cjVar) {
        if (en.j6() != null) {
            if (this.FH == null) {
                String[] VH = this.j6.VH();
                boolean[] gn = this.j6.gn();
                List arrayList = new ArrayList();
                this.DW = en.j6().DW();
                for (int i = 0; i < VH.length; i++) {
                    try {
                        if (gn[i]) {
                            arrayList.add(en.j6().j6(VH[i]).j6());
                        } else {
                            arrayList.add(en.j6().DW(VH[i]).j6());
                        }
                    } catch (en$a e) {
                    }
                }
                this.FH = new en$c[arrayList.size()];
                arrayList.toArray(this.FH);
            }
            j6(cjVar, cjVar.Ws());
        }
    }

    private void j6(cj cjVar, int i) {
        DW(cjVar, i);
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }

    private void DW(cj cjVar, int i) {
        if (cjVar.tp().Hw().lg(cjVar.rN(i)) && cjVar.tp().Hw().J8(cjVar.rN(i)) && cjVar.nw(i) == cjVar.SI(i)) {
            int Mr = cjVar.Mr(i);
            int U2 = cjVar.U2(i);
            char[] j3 = cjVar.j3(i);
            if (U2 > 0) {
                for (int i2 = 0; i2 < this.FH.length; i2++) {
                    en$c en_c = this.FH[i2];
                    this.DW.j6(j3, Mr, U2);
                    en_c.j6(this.DW);
                    if (en_c.j6()) {
                        int nw = cjVar.nw(i);
                        int KD = cjVar.KD(i);
                        int DW = KD + en_c.DW();
                        int FH = KD + en_c.FH();
                        this.j6.sG.FH(cjVar.we(), cjVar.tp(), nw, DW, nw, FH, new String(j3, en_c.DW() + Mr, en_c.FH() - en_c.DW()), i2);
                    }
                }
            }
        }
    }
}
