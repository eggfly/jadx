import java.util.HashSet;
import java.util.List;

class aby$1 implements aci$a {
    final /* synthetic */ HashSet DW;
    final /* synthetic */ aby FH;
    final /* synthetic */ zw[] j6;

    aby$1(aby aby, zw[] zwVarArr, HashSet hashSet) {
        this.FH = aby;
        this.j6 = zwVarArr;
        this.DW = hashSet;
    }

    public void j6(abz abz) {
    }

    public void j6(acb acb) {
    }

    public void DW(abz abz) {
        if (abz.v5().j6() == 3) {
            int j6 = this.FH.j6(abz);
            if (this.j6[j6] == null) {
                this.j6[j6] = abz.Ws();
                return;
            }
            zw zwVar = this.j6[j6];
            zw Ws = abz.Ws();
            zq u7 = zwVar.u7();
            zq u72 = Ws.u7();
            if (u7 != null) {
                if (u72 == null) {
                    u72 = u7;
                } else if (u7.equals(u72)) {
                    u72 = u7;
                } else {
                    return;
                }
            }
            this.FH.j6.FH(zwVar.VH()).j6(u72);
            acd aby_1_1 = new aby$1$1(this, Ws, zwVar);
            List Hw = this.FH.j6.Hw(Ws.VH());
            for (int size = Hw.size() - 1; size >= 0; size--) {
                ((aci) Hw.get(size)).j6(aby_1_1);
            }
            this.DW.add(abz);
        }
    }
}
