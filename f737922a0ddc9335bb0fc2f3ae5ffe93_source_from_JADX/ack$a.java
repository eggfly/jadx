import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class ack$a implements aci$a {
    private final acg DW;
    private final zw[] FH;
    private final HashSet<aci> Hw;
    private final ack$a$a Zo;
    final /* synthetic */ ack j6;
    private final HashMap<aci, aci> v5;

    ack$a(ack ack, acg acg) {
        this.j6 = ack;
        this.DW = acg;
        this.FH = ack.v5[acg.v5()];
        this.Hw = new HashSet();
        this.v5 = new HashMap();
        this.Zo = new ack$a$a(this);
        ack.v5[acg.v5()] = null;
    }

    public void j6() {
        this.DW.j6((aci$a) this);
        DW();
        ArrayList FH = this.DW.FH();
        for (int size = FH.size() - 1; size >= 0; size--) {
            aci aci = (aci) FH.get(size);
            aci aci2 = (aci) this.v5.get(aci);
            if (aci2 != null) {
                FH.set(size, aci2);
            } else if (aci.u7() && !this.Hw.contains(aci)) {
                FH.remove(size);
            }
        }
        Iterator it = this.DW.j6().iterator();
        Object obj = 1;
        while (it.hasNext()) {
            Object obj2;
            acg acg = (acg) it.next();
            if (acg != this.DW) {
                this.j6.v5[acg.v5()] = obj != null ? this.FH : ack.DW(this.FH);
                obj2 = null;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
    }

    private void j6(int i, zw zwVar) {
        int length;
        int VH = zwVar.VH();
        zq u7 = zwVar.u7();
        this.FH[i] = zwVar;
        for (length = this.FH.length - 1; length >= 0; length--) {
            if (VH == this.FH[length].VH()) {
                this.FH[length] = zwVar;
            }
        }
        if (u7 != null) {
            this.j6.j6(zwVar);
            for (length = this.FH.length - 1; length >= 0; length--) {
                zw zwVar2 = this.FH[length];
                if (VH != zwVar2.VH() && u7.equals(zwVar2.u7())) {
                    this.FH[length] = zwVar2.j6(null);
                }
            }
        }
    }

    public void j6(acb acb) {
        j6((aci) acb);
    }

    public void j6(abz abz) {
        int i = 0;
        zw Ws = abz.Ws();
        int VH = Ws.VH();
        int VH2 = abz.DW().DW(0).VH();
        abz.j6(this.Zo);
        int VH3 = abz.DW().DW(0).VH();
        Object u7 = this.FH[VH2].u7();
        Object u72 = Ws.u7();
        if (u72 == null) {
            u72 = u7;
        }
        zq j6 = this.j6.j6(VH3);
        if (j6 == null || u72 == null || u72.equals(j6)) {
            i = 1;
        }
        Ws = zw.DW(VH3, Ws.j6(), u72);
        if (!aca.j6() || (i != 0 && ack.DW(u72, u7) && this.j6.Hw == 0)) {
            j6(VH, Ws);
        } else if (i != 0 && u7 == null && this.j6.Hw == 0) {
            this.v5.put(abz, aci.j6(new zu(aab.j3(Ws), aac.j6, null, zx.j6(zw.j6(Ws.VH(), Ws.j6(), u72))), this.DW));
            j6(VH, Ws);
        } else {
            j6((aci) abz);
            this.Hw.add(abz);
        }
    }

    public void DW(abz abz) {
        abz.j6(this.Zo);
        j6((aci) abz);
    }

    void j6(aci aci) {
        zw Ws = aci.Ws();
        if (Ws != null) {
            int VH = Ws.VH();
            if (!this.j6.DW(VH)) {
                aci.FH(this.j6.DW);
                j6(VH, aci.Ws());
                this.j6.DW = this.j6.DW + 1;
            }
        }
    }

    private void DW() {
        acb$b ack_a_1 = new ack$a$1(this);
        BitSet u7 = this.DW.u7();
        for (int nextSetBit = u7.nextSetBit(0); nextSetBit >= 0; nextSetBit = u7.nextSetBit(nextSetBit + 1)) {
            ((acg) this.j6.j6.tp().get(nextSetBit)).j6(ack_a_1);
        }
    }
}
