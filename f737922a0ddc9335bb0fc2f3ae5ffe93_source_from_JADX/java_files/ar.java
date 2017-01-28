import com.aide.uidesigner.ProxyTextView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class ar {
    private ck DW;
    private final ba j6;

    public ar(ba baVar) {
        this.DW = new ck();
        this.j6 = baVar;
    }

    public void j6(bv bvVar, int i, int i2, String str) {
        this.j6.rN.DW();
        try {
            ce j6 = j6(str);
            cj DW = this.j6.sh.DW(bvVar, i, i2);
            int gn = DW.gn(i, i2);
            if (gn != -1) {
                DW.tp().u7().DW(DW, gn);
                dq dqVar;
                bs bsVar;
                switch (DW.J8(gn)) {
                    case 6:
                        ce ceVar = (ce) DW.QX(gn);
                        dqVar = new dq(this.j6.cb);
                        j6(ceVar, j6, dqVar);
                        DW(dqVar);
                        Map j62 = j6(dqVar);
                        DW(j62);
                        DW(j6(j62));
                        break;
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        bsVar = (bp) DW.QX(gn);
                        dqVar = new dq(this.j6.cb);
                        dqVar.j6(bsVar, (bs) j6);
                        DW(dqVar);
                        DW(j6(dqVar));
                        break;
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        bsVar = ((bz) DW.QX(gn)).Xa();
                        dqVar = new dq(this.j6.cb);
                        dqVar.j6(bsVar, (bs) j6);
                        DW(dqVar);
                        DW(j6(dqVar));
                        break;
                }
                this.j6.rN.v5();
                return;
            }
            this.j6.sh.j6(DW);
            this.j6.rN.v5();
        } catch (ej e) {
        }
    }

    public void j6(bv bvVar, int i, int i2) {
        eb ebVar = new eb(this.j6.cn);
        ebVar.j6(this.j6.cn.Hw());
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            DW.tp().u7().DW(DW, gn);
            bp bpVar;
            switch (DW.J8(gn)) {
                case 6:
                    ce ceVar = (ce) DW.QX(gn);
                    this.j6.rN.j6("All classes of namespace " + ceVar.iW() + " will be moved to the new namespace and all references will be updated.", ceVar.iW());
                    return;
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    bpVar = (bp) DW.QX(gn);
                    if (ebVar.FH(bpVar.tp()) && bpVar.hz()) {
                        this.j6.rN.j6("Class " + bpVar.iW() + " will be moved to the new namespace and all references will be updated.", bpVar.rN().iW());
                        return;
                    }
                    this.j6.rN.FH("This class is defined outside of the project.");
                    return;
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    bpVar = ((bz) DW.QX(gn)).Xa();
                    if (ebVar.FH(bpVar.tp()) && bpVar.hz()) {
                        this.j6.rN.j6("Class " + bpVar.iW() + " will be moved to the new namespace and all references will be updated.", bpVar.rN().iW());
                        return;
                    }
                    this.j6.rN.FH("This class is defined outside of the project.");
                    return;
                default:
                    this.j6.rN.FH("Select a class or namespace identifier in the code to be moved.");
                    return;
            }
        }
        this.j6.sh.j6(DW);
        this.j6.rN.FH("Select a class or namespace identifier in the code to be moved.");
    }

    public void j6(List<bv> list, bv bvVar) {
        this.j6.rN.DW();
        dq DW = DW(list, bvVar);
        if (DW.FH() > 0) {
            DW(DW);
        }
        for (bv j6 : list) {
            this.j6.rN.j6(j6, bvVar);
        }
        this.j6.rN.v5();
    }

    private dq<bp, ce> DW(List<bv> list, bv bvVar) {
        dq<bp, ce> dqVar = new dq(this.j6.cb);
        try {
            bs j6 = j6(bvVar);
            for (int i = 0; i < list.size(); i++) {
                eb ebVar = new eb(this.j6.cn);
                bv bvVar2 = (bv) list.get(i);
                j6(bvVar2, ebVar);
                ebVar.j6.j6();
                while (ebVar.j6.DW()) {
                    bs bsVar;
                    bv FH = ebVar.j6.FH();
                    if (bvVar2.Mr()) {
                        do doVar = new do();
                        bv u7 = FH.u7();
                        while (u7 != bvVar2) {
                            doVar.DW(u7.VH());
                            u7 = u7.u7();
                        }
                        doVar.DW(u7.VH());
                        int Hw = doVar.Hw() - 1;
                        bsVar = j6;
                        while (Hw >= 0) {
                            bs j62 = bsVar.j6(doVar.FH(Hw));
                            Hw--;
                            bsVar = j62;
                        }
                    } else {
                        bsVar = j6;
                    }
                    dq FH2 = this.j6.cb.FH(FH);
                    FH2.j6.j6();
                    while (FH2.j6.DW()) {
                        dqVar.j6(FH2.j6.FH(), bsVar);
                    }
                }
            }
        } catch (ej e) {
        }
        return dqVar;
    }

    private Map<bv, bv> j6(dq<bp, ce> dqVar) {
        Map<bv, bv> hashMap = new HashMap();
        dqVar.j6.j6();
        while (dqVar.j6.DW()) {
            bp bpVar = (bp) dqVar.j6.FH();
            ce ceVar = (ce) dqVar.j6.Hw();
            bv tp = bpVar.tp();
            if (tp.DW() && tp.Zo() == bpVar.aq()) {
                boolean z = false;
                bv bvVar = null;
                try {
                    bvVar = DW(tp);
                    z = FH(tp);
                } catch (ej e) {
                    if (bpVar.rN().Zo()) {
                        bvVar = tp.u7();
                    }
                }
                if (bvVar != null) {
                    String iW = ceVar.iW();
                    if (!z) {
                        iW = iW.replace('.', File.separatorChar);
                    }
                    hashMap.put(tp, this.j6.cn.DW(bvVar.er() + File.separator + iW));
                }
            }
        }
        return hashMap;
    }

    private Map<bv, bv> j6(Map<bv, bv> map) {
        return new HashMap();
    }

    private void DW(Map<bv, bv> map) {
        for (Entry entry : map.entrySet()) {
            this.j6.rN.j6((bv) entry.getKey(), (bv) entry.getValue());
        }
    }

    private void DW(dq<bp, ce> dqVar) {
        ec ecVar = new ec();
        eb ebVar = new eb(this.j6.cn);
        dqVar.j6.j6();
        while (dqVar.j6.DW()) {
            bp bpVar = (bp) dqVar.j6.FH();
            ebVar.j6(bpVar.tp());
            ecVar.j6(bpVar.aq());
        }
        this.j6.j6.FH(ecVar);
        while (true) {
            bv FH = this.j6.j6.FH();
            if (FH == null) {
                break;
            } else if (!ebVar.FH(FH)) {
                j6(FH, false, (dq) dqVar);
            }
        }
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            j6(ebVar.j6.FH(), true, (dq) dqVar);
        }
    }

    private void j6(bv bvVar, boolean z, dq<bp, ce> dqVar) {
        Iterator it = this.j6.sh.j6(bvVar).iterator();
        if (it.hasNext()) {
            bs bsVar;
            int i;
            int U2;
            int Mr;
            String j6;
            String str;
            int FH;
            int FH2;
            int Hw;
            int v5;
            cj cjVar = (cj) it.next();
            cjVar.tp().u7().DW(cjVar);
            this.DW.j6();
            dq dqVar2 = new dq(this.j6.cb);
            ea eaVar = new ea(this.j6.cb);
            boolean j62 = j6(cjVar, cjVar.Ws(), z, dqVar, dqVar2, eaVar);
            dr drVar = new dr(this.j6.cb);
            dq FH3 = this.j6.cb.FH(bvVar);
            FH3.j6.j6();
            while (FH3.j6.DW()) {
                bsVar = (bp) FH3.j6.FH();
                if (bsVar.Hw() == cjVar.tp() && cjVar.ef(bsVar.EQ()) != -1 && cjVar.nw(cjVar.ef(bsVar.EQ())) > 0) {
                    drVar.j6(cjVar.ef(bsVar.EQ()), bsVar);
                }
            }
            drVar.j6.j6();
            while (drVar.j6.DW()) {
                this.DW.j6(cjVar, drVar.j6.FH());
            }
            do QX = cjVar.QX();
            for (i = 0; i < QX.Hw(); i++) {
                this.DW.j6(cjVar, QX.FH(i));
            }
            do XL = cjVar.XL();
            for (i = 0; i < XL.Hw(); i++) {
                this.DW.j6(cjVar, XL.FH(i));
            }
            j6(cjVar, cjVar.Ws(), (dq) dqVar);
            if (z || j62) {
                U2 = cjVar.U2();
                Mr = cjVar.Mr();
                j6 = cjVar.tp().v5().j6(cjVar, dqVar2, eaVar);
                String j63 = cjVar.tp().v5().j6(cjVar, dqVar2);
                if (j63.length() > 0) {
                    if (j6.length() > 0) {
                        j6 = j6 + "\n\n";
                    }
                    j6 = j6 + j63;
                }
                if (j6.length() > 0) {
                    if (XL.Hw() == 0) {
                        str = j6 + "\n\n";
                    } else {
                        str = j6;
                    }
                    this.DW.j6(U2, Mr, U2, Mr, str);
                    this.j6.rN.j6(bvVar, U2, Mr, U2, Mr, str);
                }
                for (i = XL.Hw() - 1; i >= 0; i -= 2) {
                    FH = XL.FH(i - 1);
                    U2 = XL.FH(i);
                    Mr = this.DW.DW(cjVar, FH);
                    FH2 = this.DW.FH(cjVar, FH);
                    Hw = this.DW.Hw(cjVar, U2);
                    v5 = this.DW.v5(cjVar, U2);
                    this.DW.j6(Mr, FH2, Hw, v5);
                    this.j6.rN.j6(bvVar, Mr, FH2, Hw, v5, "");
                }
            }
            if (z) {
                for (i = QX.Hw() - 1; i >= 0; i -= 2) {
                    FH = QX.FH(i - 1);
                    U2 = QX.FH(i);
                    Mr = this.DW.DW(cjVar, FH);
                    FH2 = this.DW.FH(cjVar, FH);
                    Hw = this.DW.Hw(cjVar, U2);
                    v5 = this.DW.v5(cjVar, U2);
                    this.DW.j6(Mr, FH2, Hw, v5);
                    this.j6.rN.j6(bvVar, Mr, FH2, Hw, v5, "");
                }
                drVar.j6.j6();
                while (drVar.j6.DW()) {
                    int FH4 = drVar.j6.FH();
                    bsVar = (bp) drVar.j6.Hw();
                    bs lg = bsVar.lg();
                    if (dqVar.DW(bsVar)) {
                        lg = dqVar.Hw(bsVar);
                    }
                    if (lg.qp()) {
                        str = cjVar.tp().v5().DW((ce) lg);
                        j6 = cjVar.tp().v5().FH((ce) lg);
                        if (str.length() > 0 || j6.length() > 0) {
                            U2 = this.DW.DW(cjVar, FH4);
                            Mr = this.DW.FH(cjVar, FH4);
                            this.DW.j6(U2, Mr, U2, Mr, str);
                            this.j6.rN.j6(bvVar, U2, Mr, U2, Mr, str);
                            U2 = this.DW.Hw(cjVar, FH4);
                            Mr = this.DW.v5(cjVar, FH4);
                            this.DW.j6(U2, Mr, U2, Mr, j6);
                            this.j6.rN.j6(bvVar, U2, Mr, U2, Mr, j6);
                        } else {
                            String j64 = cjVar.tp().v5().j6((ce) lg);
                            if (j64.length() > 0) {
                                this.j6.rN.j6(bvVar, 1, 1, 1, 1, j64);
                                break;
                            }
                        }
                    }
                }
                this.j6.rN.DW(bvVar, 1, 100000);
            }
            this.j6.sh.j6(cjVar);
        }
    }

    private void j6(cj cjVar, int i, dq<bp, ce> dqVar) {
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 8:
                    if (dqVar.DW((bp) cjVar.QX(i)) && cjVar.yO(i)) {
                        int XG = cjVar.XG(i);
                        int DW = this.DW.DW(cjVar, XG);
                        int FH = this.DW.FH(cjVar, XG);
                        int DW2 = this.DW.DW(cjVar, i);
                        int FH2 = this.DW.FH(cjVar, i);
                        this.DW.j6(DW, FH, DW2, FH2);
                        this.j6.rN.j6(cjVar.we(), DW, FH, DW2, FH2, "");
                        break;
                    }
            }
        }
        int lg = cjVar.lg(i);
        for (XG = 0; XG < lg; XG++) {
            j6(cjVar, cjVar.Hw(i, XG), (dq) dqVar);
        }
    }

    private boolean j6(cj cjVar, int i, boolean z, dq<bp, ce> dqVar, dq<bp, bs> dqVar2, ea<ce> eaVar) {
        boolean z2 = false;
        if (cjVar.sy(i)) {
            bs bsVar;
            switch (cjVar.J8(i)) {
                case 8:
                    bsVar = (bp) cjVar.QX(i);
                    if (dqVar.DW(bsVar)) {
                        dqVar2.j6(bsVar, dqVar.Hw(bsVar));
                        z2 = true;
                        break;
                    }
                    break;
                case 9:
                    bsVar = (bp) cjVar.QX(i);
                    if (!dqVar.DW(bsVar)) {
                        if (z) {
                            dqVar2.j6(bsVar, bsVar.rN());
                            break;
                        }
                    }
                    dqVar2.j6(bsVar, dqVar.Hw(bsVar));
                    z2 = true;
                    break;
                    break;
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    bsVar = (bp) cjVar.QX(i);
                    if (!dqVar.DW(bsVar)) {
                        dqVar2.j6(bsVar, bsVar.lg());
                        break;
                    }
                    dqVar2.j6(bsVar, dqVar.Hw(bsVar));
                    z2 = true;
                    break;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    bz bzVar = (bz) cjVar.QX(i);
                    if (bzVar.cn()) {
                        if (!dqVar.DW(bzVar.Xa())) {
                            eaVar.j6(bzVar.Xa().rN());
                            break;
                        }
                        eaVar.j6(dqVar.Hw(bzVar.Xa()));
                        break;
                    }
                    break;
                case 23:
                    boolean z3;
                    bsVar = ((bz) cjVar.QX(i)).Xa();
                    if (dqVar.DW(bsVar)) {
                        dqVar2.j6(bsVar, dqVar.Hw(bsVar));
                        z3 = true;
                    } else {
                        if (z) {
                            dqVar2.j6(bsVar, bsVar.rN());
                        }
                        z3 = false;
                    }
                    z2 = z3;
                    break;
                case 24:
                case 25:
                    bsVar = ((bz) cjVar.QX(i)).Xa();
                    if (!dqVar.DW(bsVar)) {
                        dqVar2.j6(bsVar, bsVar.lg());
                        break;
                    }
                    dqVar2.j6(bsVar, dqVar.Hw(bsVar));
                    z2 = true;
                    break;
            }
        }
        int i2 = 0;
        boolean z4 = z2;
        while (i2 < cjVar.lg(i)) {
            z2 = z4 | j6(cjVar, cjVar.Hw(i, i2), z, dqVar, dqVar2, eaVar);
            i2++;
            z4 = z2;
        }
        return z4;
    }

    private void j6(bv bvVar, eb ebVar) {
        if (bvVar.DW()) {
            ebVar.j6(bvVar);
        } else if (bvVar.Mr()) {
            int yS = bvVar.yS();
            for (int i = 0; i < yS; i++) {
                j6(bvVar.FH(i), ebVar);
            }
        }
    }

    private void j6(ce ceVar, ce ceVar2, dq<bp, ce> dqVar) {
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            dqVar.j6((bp) gn.j6.Hw(), (bs) ceVar2);
        }
        ea VH = ceVar.VH();
        VH.j6.j6();
        while (VH.j6.DW()) {
            ce ceVar3 = (ce) VH.j6.FH();
            j6(ceVar3, ceVar2.j6(ceVar3.aq()), (dq) dqVar);
        }
    }

    private ce j6(String str) {
        ce Zo = this.j6.cb.Zo();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        while (stringTokenizer.hasMoreElements()) {
            Zo = Zo.j6(this.j6.ro.j6(stringTokenizer.nextToken()));
        }
        return Zo;
    }

    private ce j6(bv bvVar) {
        eb Hw = this.j6.cn.Hw();
        Hw.j6.j6();
        while (Hw.j6.DW()) {
            try {
                bv DW = DW(Hw.j6.FH());
                if (DW.FH(bvVar)) {
                    String str = "";
                    while (bvVar != DW) {
                        if (str.length() > 0) {
                            str = "." + str;
                        }
                        str = bvVar.v5() + str;
                        bvVar = bvVar.u7();
                    }
                    return j6(str);
                }
            } catch (ej e) {
            }
        }
        throw new ej();
    }

    private bv DW(bv bvVar) {
        dq FH = this.j6.cb.FH(bvVar);
        FH.j6.j6();
        while (FH.j6.DW()) {
            ce rN = ((bp) FH.j6.FH()).rN();
            bv u7 = bvVar.u7();
            if (u7.v5().equals(rN.iW())) {
                return u7.u7();
            }
            while (u7.Zo() == rN.aq()) {
                u7 = u7.u7();
                rN = rN.FH();
                if (u7 == this.j6.cn.gn()) {
                    break;
                    continue;
                } else if (rN == this.j6.cb.Zo()) {
                    return u7;
                }
            }
        }
        throw new ej();
    }

    private boolean FH(bv bvVar) {
        dq FH = this.j6.cb.FH(bvVar);
        FH.j6.j6();
        while (FH.j6.DW()) {
            ce rN = ((bp) FH.j6.FH()).rN();
            bv u7 = bvVar.u7();
            if (u7.v5().indexOf(46) != -1 && u7.v5().equals(rN.iW())) {
                return true;
            }
            while (u7.Zo() == rN.aq()) {
                u7 = u7.u7();
                rN = rN.FH();
                if (u7 == this.j6.cn.gn()) {
                    break;
                    continue;
                } else if (rN == this.j6.cb.Zo()) {
                    return false;
                }
            }
        }
        return false;
    }
}
