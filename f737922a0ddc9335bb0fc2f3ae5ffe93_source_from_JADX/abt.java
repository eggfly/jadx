import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class abt {
    private int DW;
    private ArrayList<abt$a> FH;
    private acj j6;

    private abt(acj acj) {
        this.j6 = acj;
        this.DW = acj.VH();
        this.FH = new ArrayList();
    }

    private int j6(zw zwVar) {
        int i = 0;
        while (i < this.FH.size() && !((abt$a) this.FH.get(i)).j6.get(zwVar.VH())) {
            i++;
        }
        return i;
    }

    private aci j6(aci aci) {
        ArrayList FH = ((acg) this.j6.tp().get(aci.QX().gn().nextSetBit(0))).FH();
        return (aci) FH.get(FH.size() - 1);
    }

    private aci DW(aci aci) {
        return (aci) ((acg) this.j6.tp().get(aci.QX().u7().nextSetBit(0))).FH().get(0);
    }

    private void j6(abt$a abt_a, abt$a abt_a2) {
        if (!abt_a2.Hw.contains(abt_a)) {
            abt_a2.Hw.add(abt_a);
        }
        if (!abt_a.FH.contains(abt_a2)) {
            abt_a.FH.add(abt_a2);
        }
    }

    private void DW(abt$a abt_a, abt$a abt_a2) {
        Iterator it = abt_a2.Hw.iterator();
        while (it.hasNext()) {
            abt$a abt_a3 = (abt$a) it.next();
            abt_a3.FH.remove(abt_a2);
            abt_a3.FH.add(abt_a);
            abt_a.Hw.add(abt_a3);
        }
        it = abt_a2.FH.iterator();
        while (it.hasNext()) {
            abt_a3 = (abt$a) it.next();
            abt_a3.Hw.remove(abt_a2);
            abt_a3.Hw.add(abt_a);
            abt_a.FH.add(abt_a3);
        }
    }

    public static void j6(acj acj) {
        new abt(acj).FH();
    }

    private void FH(aci aci) {
        int j6 = aci.v5().j6();
        zw Ws = aci.Ws();
        if (j6 == 56 && Ws.gn().FH() == 9) {
            j6(Ws, Hw(aci));
        } else if (j6 == 3 && Ws.gn().FH() == 9) {
            r0 = new abt$a(Ws.VH(), this.DW, abt$b.NONE);
            this.FH.add(r0);
            j6(Ws, r0);
        } else if (j6 == 55 && Ws.gn().FH() == 9) {
            r0 = new abt$a(Ws.VH(), this.DW, abt$b.NONE);
            this.FH.add(r0);
            j6(Ws, r0);
        }
    }

    private abt$a Hw(aci aci) {
        abt$a abt_a;
        zw Ws = aci.Ws();
        aci j6 = j6(aci);
        switch (j6.v5().j6()) {
            case 5:
            case 40:
                abt_a = new abt$a(Ws.VH(), this.DW, abt$b.NONE);
                break;
            case 38:
            case 43:
            case 45:
                zw DW = j6.DW().DW(0);
                int j62 = j6(DW);
                if (j62 == this.FH.size()) {
                    if (DW.j6() != abl.tp) {
                        abt_a = new abt$a(Ws.VH(), this.DW, abt$b.GLOBAL);
                        break;
                    }
                    abt_a = new abt$a(Ws.VH(), this.DW, abt$b.NONE);
                    break;
                }
                abt_a = (abt$a) this.FH.get(j62);
                abt_a.j6.set(Ws.VH());
                return abt_a;
            case 41:
            case 42:
                if (!j6.DW().DW(0).gn().Zo()) {
                    abt_a = new abt$a(Ws.VH(), this.DW, abt$b.GLOBAL);
                    break;
                }
                abt_a = new abt$a(Ws.VH(), this.DW, abt$b.NONE);
                abt_a.v5 = true;
                break;
            case 46:
                abt_a = new abt$a(Ws.VH(), this.DW, abt$b.GLOBAL);
                break;
            default:
                return null;
        }
        this.FH.add(abt_a);
        return abt_a;
    }

    private void j6(zw zwVar, abt$a abt_a) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(zwVar);
        while (!arrayList.isEmpty()) {
            zw zwVar2 = (zw) arrayList.remove(arrayList.size() - 1);
            for (aci aci : this.j6.Hw(zwVar2.VH())) {
                if (aci.v5() == null) {
                    j6(aci, abt_a, arrayList);
                } else {
                    j6(zwVar2, aci, abt_a, arrayList);
                }
            }
        }
    }

    private void j6(aci aci, abt$a abt_a, ArrayList<zw> arrayList) {
        int j6 = j6(aci.Ws());
        if (j6 != this.FH.size()) {
            abt$a abt_a2 = (abt$a) this.FH.get(j6);
            if (abt_a2 != abt_a) {
                abt_a.v5 = false;
                abt_a.j6.or(abt_a2.j6);
                if (abt_a.DW.compareTo(abt_a2.DW) < 0) {
                    abt_a.DW = abt_a2.DW;
                }
                DW(abt_a, abt_a2);
                this.FH.remove(j6);
                return;
            }
            return;
        }
        abt_a.j6.set(aci.Ws().VH());
        arrayList.add(aci.Ws());
    }

    private void j6(zw zwVar, aci aci, abt$a abt_a, ArrayList<zw> arrayList) {
        switch (aci.v5().j6()) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                abt_a.j6.set(aci.Ws().VH());
                arrayList.add(aci.Ws());
                return;
            case 7:
            case 8:
            case 43:
                if (abt_a.DW.compareTo(abt$b.METHOD) < 0) {
                    abt_a.DW = abt$b.METHOD;
                    return;
                }
                return;
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
            case 35:
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case 50:
            case 51:
            case 52:
            case 53:
                abt_a.DW = abt$b.INTER;
                return;
            case 38:
                if (!aci.DW().DW(1).gn().Zo()) {
                    abt_a.v5 = false;
                    return;
                }
                return;
            case 39:
                if (!aci.DW().DW(2).gn().Zo()) {
                    abt_a.v5 = false;
                    break;
                }
                break;
            case 47:
                break;
            case 48:
                abt_a.DW = abt$b.GLOBAL;
                return;
            default:
                return;
        }
        if (aci.DW().DW(0).gn().FH() == 9) {
            abt_a.v5 = false;
            zx DW = aci.DW();
            int j6;
            abt$a abt_a2;
            if (DW.DW(0).VH() == zwVar.VH()) {
                j6 = j6(DW.DW(1));
                if (j6 != this.FH.size()) {
                    abt_a2 = (abt$a) this.FH.get(j6);
                    j6(abt_a2, abt_a);
                    if (abt_a.DW.compareTo(abt_a2.DW) < 0) {
                        abt_a.DW = abt_a2.DW;
                        return;
                    }
                    return;
                }
                return;
            }
            j6 = j6(DW.DW(0));
            if (j6 != this.FH.size()) {
                abt_a2 = (abt$a) this.FH.get(j6);
                j6(abt_a, abt_a2);
                if (abt_a2.DW.compareTo(abt_a.DW) < 0) {
                    abt_a2.DW = abt_a.DW;
                }
            }
        }
    }

    private void j6() {
        Iterator it = this.FH.iterator();
        while (it.hasNext()) {
            abt$a abt_a = (abt$a) it.next();
            if (abt_a.v5 && abt_a.DW == abt$b.NONE) {
                int nextSetBit = abt_a.j6.nextSetBit(0);
                aci FH = this.j6.FH(nextSetBit);
                aci j6 = j6(FH);
                int tp = ((aay) j6.DW().DW(0).gn()).tp();
                ArrayList arrayList = new ArrayList(tp);
                Set hashSet = new HashSet();
                j6(FH, j6, tp, arrayList);
                hashSet.add(j6);
                hashSet.add(FH);
                for (aci aci : this.j6.Hw(nextSetBit)) {
                    j6(aci, j6, arrayList, (HashSet) hashSet);
                    hashSet.add(aci);
                }
                this.j6.j6(hashSet);
                this.j6.J0();
                ach.j6(this.j6, this.DW);
                DW();
            }
        }
    }

    private void j6(aci aci, aci aci2, int i, ArrayList<zw> arrayList) {
        abl j6 = aci.Ws().j6();
        for (int i2 = 0; i2 < i; i2++) {
            aah j62 = abi.j6(j6.U2());
            zw j63 = zw.j6(this.j6.Ws(), (abh) j62);
            arrayList.add(j63);
            j6(aci, zx.j6, j63, 5, j62);
        }
    }

    private void j6(aci aci, aci aci2, ArrayList<zw> arrayList, HashSet<aci> hashSet) {
        int size = arrayList.size();
        aci DW;
        zx DW2;
        zw DW3;
        int tp;
        switch (aci.v5().j6()) {
            case 34:
                abm gn = aci2.DW().DW(0).gn();
                DW = DW(aci);
                j6(DW, zx.j6, DW.Ws(), 5, (aah) gn);
                hashSet.add(DW);
            case 38:
                DW = DW(aci);
                DW2 = aci.DW();
                int tp2 = ((aay) DW2.DW(1).gn()).tp();
                if (tp2 < size) {
                    zw zwVar = (zw) arrayList.get(tp2);
                    DW3 = zwVar.DW(DW.Ws().VH());
                    j6(DW, zx.j6(zwVar), DW3, 2, null);
                } else {
                    j6(DW, DW2.DW(1), (HashSet) hashSet);
                    hashSet.add(DW.QX().FH().get(2));
                }
                hashSet.add(DW);
            case 39:
                DW2 = aci.DW();
                tp = ((aay) DW2.DW(2).gn()).tp();
                if (tp < size) {
                    zw DW4 = DW2.DW(0);
                    DW3 = DW4.DW(((zw) arrayList.get(tp)).VH());
                    j6(aci, zx.j6(DW4), DW3, 2, null);
                    arrayList.set(tp, DW3.J8());
                    return;
                }
                j6(aci, DW2.DW(2), (HashSet) hashSet);
            case 57:
                ArrayList FH = ((zn) aci.Zo()).FH();
                for (tp = 0; tp < size; tp++) {
                    DW3 = zw.j6(((zw) arrayList.get(tp)).VH(), (abm) FH.get(tp));
                    j6(aci, zx.j6, DW3, 5, (aah) FH.get(tp));
                    arrayList.set(tp, DW3);
                }
            default:
        }
    }

    private void DW() {
        for (int i = 0; i < this.j6.VH(); i++) {
            aci FH = this.j6.FH(i);
            if (!(FH == null || FH.v5() == null || FH.v5().j6() != 2)) {
                ArrayList[] J8 = this.j6.J8();
                zw DW = FH.DW().DW(0);
                zw Ws = FH.Ws();
                if (DW.VH() >= this.DW || Ws.VH() >= this.DW) {
                    acd abt_1 = new abt$1(this, Ws, DW);
                    Iterator it = J8[Ws.VH()].iterator();
                    while (it.hasNext()) {
                        ((aci) it.next()).j6(abt_1);
                    }
                }
            }
        }
    }

    private void FH() {
        this.j6.j6(new abt$2(this));
        Iterator it = this.FH.iterator();
        while (it.hasNext()) {
            abt$a abt_a = (abt$a) it.next();
            if (abt_a.DW != abt$b.NONE) {
                Iterator it2 = abt_a.FH.iterator();
                while (it2.hasNext()) {
                    abt$a abt_a2 = (abt$a) it2.next();
                    if (abt_a.DW.compareTo(abt_a2.DW) > 0) {
                        abt_a2.DW = abt_a.DW;
                    }
                }
            }
        }
        j6();
    }

    private void j6(aci aci, zw zwVar, HashSet<aci> hashSet) {
        abm abf = new abf(zm.DW);
        DW(aci, zx.j6, null, 40, abf);
        acg QX = aci.QX();
        QX = QX.DW(QX.J0());
        aci aci2 = (aci) QX.FH().get(0);
        zw j6 = zw.j6(this.j6.Ws(), abf);
        j6(aci2, zx.j6, j6, 56, null);
        acg DW = QX.DW(QX.J0());
        aci aci3 = (aci) DW.FH().get(0);
        DW(aci3, zx.j6(j6, zwVar), null, 52, new abb(abf, new abc(new abe("<init>"), new abe("(I)V"))));
        hashSet.add(aci3);
        DW = DW.DW(DW.J0());
        aci3 = (aci) DW.FH().get(0);
        DW(aci3, zx.j6(j6), null, 35, null);
        DW.j6(DW.EQ(), this.j6.Zo().v5());
        hashSet.add(aci3);
    }

    private void j6(aci aci, zx zxVar, zw zwVar, int i, aah aah) {
        zz v5;
        zo zuVar;
        zo Zo = aci.Zo();
        if (i == 56) {
            v5 = aab.v5(zwVar.j6());
        } else {
            v5 = aab.j6(i, zwVar, zxVar, aah);
        }
        if (aah == null) {
            zuVar = new zu(v5, Zo.VH(), zwVar, zxVar);
        } else {
            zuVar = new zt(v5, Zo.VH(), zwVar, zxVar, aah);
        }
        aci abz = new abz(zuVar, aci.QX());
        List FH = aci.QX().FH();
        FH.add(FH.lastIndexOf(aci), abz);
        this.j6.j6(abz);
    }

    private void DW(aci aci, zx zxVar, zw zwVar, int i, aah aah) {
        zo aaf;
        zo Zo = aci.Zo();
        zz j6 = aab.j6(i, zwVar, zxVar, aah);
        if (aah == null) {
            aaf = new aaf(j6, Zo.VH(), zxVar, abk.j6);
        } else {
            aaf = new aae(j6, Zo.VH(), zxVar, abk.j6, aah);
        }
        aci abz = new abz(aaf, aci.QX());
        List FH = aci.QX().FH();
        FH.add(FH.lastIndexOf(aci), abz);
        this.j6.j6(abz);
    }
}
