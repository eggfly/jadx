import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class abp {
    private static boolean DW;
    private static boolean j6;
    private final acj FH;

    static {
        j6 = false;
        DW = false;
    }

    public static void j6(acj acj) {
        new abp(acj).j6();
    }

    private abp(acj acj) {
        this.FH = acj;
    }

    private void j6() {
        int VH = this.FH.VH();
        ArrayList DW = DW();
        int min = Math.min(DW.size(), 5);
        acg Hw = this.FH.Hw();
        HashMap hashMap = new HashMap(min);
        for (int i = 0; i < min; i++) {
            abm abm = (abh) DW.get(i);
            zw j6 = zw.j6(this.FH.Ws(), abm);
            zz Zo = aab.Zo(abm);
            if (Zo.Hw() == 1) {
                Hw.j6(new zt(aab.Zo(abm), aac.j6, j6, zx.j6, abm));
            } else {
                acg Hw2 = this.FH.Hw();
                acg J0 = Hw2.J0();
                Hw2 = Hw2.DW(J0);
                Hw2.DW(new aae(Zo, aac.j6, zx.j6, abk.j6, abm));
                Hw2.DW(J0).j6(new zu(aab.v5(j6.gn()), aac.j6, j6, zx.j6));
            }
            hashMap.put(abm, j6);
        }
        j6(hashMap, VH);
    }

    private ArrayList<abh> DW() {
        int VH = this.FH.VH();
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < VH; i++) {
            aci FH = this.FH.FH(i);
            if (!(FH == null || FH.v5() == null)) {
                zw Ws = FH.Ws();
                abm gn = Ws.gn();
                if (gn.Zo()) {
                    abh abh = (abh) gn;
                    if (FH.v5().j6() == 56) {
                        ArrayList FH2 = ((acg) this.FH.tp().get(FH.QX().gn().nextSetBit(0))).FH();
                        FH = (aci) FH2.get(FH2.size() - 1);
                    }
                    if (!FH.EQ() || ((abh instanceof abe) && j6 && FH.QX().u7().cardinality() <= 1)) {
                        if (this.FH.j6(Ws)) {
                            if (DW && !hashSet.contains(abh)) {
                                hashSet.add(abh);
                            }
                        }
                        Integer num = (Integer) hashMap.get(abh);
                        if (num == null) {
                            hashMap.put(abh, Integer.valueOf(1));
                        } else {
                            hashMap.put(abh, Integer.valueOf(num.intValue() + 1));
                        }
                    }
                }
            }
        }
        Object arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > 1) {
                arrayList.add(entry.getKey());
            }
        }
        Collections.sort(arrayList, new abp$1(this, hashMap));
        return arrayList;
    }

    private void j6(zw zwVar, zw zwVar2) {
        for (aci aci : this.FH.Hw(zwVar.VH())) {
            zw VH = aci.VH();
            if (!(VH == null || aci.Ws() == null)) {
                zq u7 = VH.u7();
                aci.j6(null);
                zwVar2 = zwVar2.j6(u7);
                aci j6 = aci.j6(new zu(aab.j3(zwVar2), aac.j6, null, zx.j6(zwVar2)), aci.QX());
                ArrayList FH = aci.QX().FH();
                FH.add(FH.indexOf(aci) + 1, j6);
            }
        }
    }

    private void j6(HashMap<abh, zw> hashMap, int i) {
        HashSet hashSet = new HashSet();
        ArrayList[] J8 = this.FH.J8();
        for (int i2 = 0; i2 < i; i2++) {
            aci FH = this.FH.FH(i2);
            if (FH != null) {
                zw Ws = FH.Ws();
                abm gn = FH.Ws().gn();
                if (gn.Zo()) {
                    abh abh = (abh) gn;
                    zw zwVar = (zw) hashMap.get(abh);
                    if (zwVar != null) {
                        if (this.FH.j6(Ws)) {
                            if (DW && !hashSet.contains(abh)) {
                                hashSet.add(abh);
                                j6(Ws, (zw) hashMap.get(abh));
                            }
                        }
                        acd abp_2 = new abp$2(this, Ws, zwVar);
                        Iterator it = J8[Ws.VH()].iterator();
                        while (it.hasNext()) {
                            FH = (aci) it.next();
                            if (!FH.EQ() || FH.QX().u7().cardinality() <= 1) {
                                FH.j6(abp_2);
                            }
                        }
                    }
                }
            }
        }
    }
}
