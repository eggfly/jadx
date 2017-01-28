import com.aide.uidesigner.ProxyTextView;

public class ak {
    private eb BT;
    private final by DW;
    private ec EQ;
    private final bt FH;
    private final bw Hw;
    private du J0;
    private du J8;
    private int KD;
    private boolean[] Mr;
    private int P8;
    private ea<bp> QX;
    private int[] SI;
    private boolean[] U2;
    private ec VH;
    private du Ws;
    private dt XL;
    private final bu Zo;
    private boolean[] a8;
    private dt aM;
    private do cb;
    private int[] cn;
    private int ei;
    private dh er;
    private boolean gW;
    private dy gn;
    private boolean[] j3;
    private final ba j6;
    private boolean[] lg;
    private int[] nw;
    private boolean[] rN;
    private int ro;
    private int sh;
    private ec tp;
    private ec u7;
    private final cl v5;
    private eb vy;
    private ec we;
    private dh yS;

    public ak(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cb;
        this.v5 = baVar.sh;
        this.Hw = baVar.cn;
        this.Zo = baVar.sG;
        this.QX = new ea(baVar.cb);
        this.VH = new ec();
        this.u7 = new ec();
        this.J0 = new du();
        this.J8 = new du();
        this.Ws = new du();
        this.gn = new dy();
        this.we = new ec();
        this.tp = new ec();
        this.EQ = new ec();
        this.gW = true;
        this.BT = new eb(this.Hw);
        this.vy = new eb(this.Hw);
        this.er = new dh();
        this.j3 = new boolean[10000];
        this.Mr = new boolean[10000];
        this.U2 = new boolean[10000];
        this.a8 = new boolean[10000];
        this.lg = new boolean[10000];
        this.rN = new boolean[10000];
        this.P8 = 0;
        this.ei = 0;
        this.nw = new int[9000];
        this.SI = new int[3000];
        this.KD = 0;
        this.ro = 0;
        this.cn = new int[4000];
        this.sh = 0;
        this.cb = new do();
        this.yS = new dh();
        this.XL = new dt();
        this.aM = new dt();
    }

    protected void j6(ee eeVar) {
        int i;
        this.u7 = new ec(eeVar);
        this.J0 = new du(eeVar);
        this.J8 = new du(eeVar);
        this.Ws = new du(eeVar);
        this.gn = new dy(eeVar);
        this.we = new ec(eeVar);
        this.tp = new ec(eeVar);
        this.EQ = new ec(eeVar);
        this.P8 = 0;
        this.ei = eeVar.readInt();
        this.nw = new int[((((this.ei * 5) / 4) / 3) * 3)];
        for (i = 0; i < this.ei; i++) {
            this.nw[i] = eeVar.readInt();
        }
        this.SI = new int[(((this.ei * 5) / 4) / 3)];
        for (i = 0; i < this.ei / 3; i++) {
            this.SI[i] = eeVar.readInt();
        }
        this.KD = 0;
        this.ro = eeVar.readInt();
        this.cn = new int[this.ro];
        for (i = 0; i < this.cn.length; i++) {
            this.cn[i] = eeVar.readInt();
        }
        this.sh = 0;
        this.cb = new do(eeVar);
        this.yS = new dh(eeVar);
        this.XL = new dt(eeVar);
        this.aM = new dt(eeVar);
    }

    protected void j6(ef efVar) {
        int i;
        int i2 = 0;
        this.u7.j6(efVar);
        this.J0.j6(efVar);
        this.J8.j6(efVar);
        this.Ws.j6(efVar);
        this.gn.j6(efVar);
        this.we.j6(efVar);
        this.tp.j6(efVar);
        this.EQ.j6(efVar);
        efVar.writeInt(this.ei);
        for (i = 0; i < this.ei; i++) {
            efVar.writeInt(this.nw[i]);
        }
        for (i = 0; i < this.ei / 3; i++) {
            efVar.writeInt(this.SI[i]);
        }
        efVar.writeInt(this.ro);
        while (i2 < this.ro) {
            efVar.writeInt(this.cn[i2]);
            i2++;
        }
        this.cb.j6(efVar);
        this.yS.j6(efVar);
        this.XL.j6(efVar);
        this.aM.j6(efVar);
    }

    protected void j6() {
        if ((this.ei * 5) / 4 < this.nw.length) {
            Object obj = new int[((((this.ei * 5) / 4) / 3) * 3)];
            System.arraycopy(this.nw, 0, obj, 0, this.ei);
            this.nw = obj;
            obj = new int[(((this.ei * 5) / 4) / 3)];
            System.arraycopy(this.SI, 0, obj, 0, this.ei / 3);
            this.SI = obj;
        }
    }

    protected void DW() {
        Object obj = null;
        ec ecVar = new ec();
        this.J0.j6.j6();
        Object obj2 = null;
        while (this.J0.j6.DW()) {
            bv Hw;
            if (this.j6.P8 == null || !this.j6.P8.DW() || ecVar.Hw() != 0) {
                int FH = this.J0.j6.FH();
                bj FH2 = this.Hw.FH(FH);
                Hw = this.Hw.Hw(FH);
                if (Hw.QX() != this.J0.j6.Hw()) {
                    if (this.J8.j6(FH)) {
                        cj j6 = this.v5.j6(Hw, FH2);
                        if (this.J8.FH(FH) != j6.VH()) {
                            ecVar.j6(j6(FH));
                            ecVar.j6(FH);
                            this.J8.j6(FH, j6.VH());
                            obj2 = 1;
                        }
                        this.v5.j6(j6);
                    } else {
                        ecVar.j6(j6(FH));
                        ecVar.j6(FH);
                        int i = 1;
                    }
                    if (this.Ws.j6(FH)) {
                        cj DW = this.v5.DW(Hw, FH2);
                        if (this.Ws.FH(FH) != DW.Zo()) {
                            this.Ws.j6(FH, DW.Zo());
                            obj = 1;
                        }
                        this.v5.j6(DW);
                    }
                }
            } else {
                return;
            }
        }
        ec ecVar2 = new ec();
        this.we.j6.j6();
        while (this.we.j6.DW()) {
            int FH3 = this.we.j6.FH();
            Hw = this.Hw.Hw(FH3);
            this.Hw.FH(FH3);
            if (!(this.J0.j6(FH3) && Hw.QX() == this.J0.FH(FH3))) {
                ecVar2.j6(FH3);
                ecVar.j6(FH3);
            }
            if (!Hw.FH()) {
                ecVar2.j6(FH3);
                ecVar.j6(j6(FH3));
                ecVar.j6(FH3);
                obj2 = 1;
            }
        }
        if (obj != null) {
            ecVar.j6(this.we);
        }
        if (obj2 != null) {
            this.EQ.j6();
            ecVar.j6(this.tp);
        }
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            int FH4 = ecVar.j6.FH();
            this.Hw.FH(FH4);
            bv Hw2 = this.Hw.Hw(FH4);
            this.we.DW(FH4);
            this.J0.j6(FH4, Hw2.QX());
        }
        this.gn.j6(ecVar);
        j6(ecVar, ecVar2);
    }

    protected void FH() {
        this.EQ.j6();
    }

    public ea<bs> j6(ea<bs> eaVar, int i) {
        ea eaVar2 = new ea(this.FH);
        ea eaVar3 = new ea(this.FH);
        eaVar2.j6((ea) eaVar);
        do {
            int Hw = eaVar2.Hw();
            eaVar3.j6();
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.ei) {
                if (this.nw[i3] != -1 && eaVar2.FH(this.FH.FH(this.nw[i3 + 1]))) {
                    switch (this.SI[i2]) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                            if (!this.FH.FH(this.nw[i3 + 2]).zh()) {
                                break;
                            }
                            eaVar3.j6(this.FH.FH(this.nw[i3 + 2]));
                            break;
                        default:
                            break;
                    }
                }
                i3 += 3;
                i2++;
            }
            do {
                i3 = eaVar3.Hw();
                i2 = 0;
                while (i2 < this.ro) {
                    if (this.cn[i2] != -1 && eaVar2.FH(this.FH.FH(this.cn[i2 + 1]))) {
                        eaVar3.j6(this.FH.FH(this.cn[i2 + 3]));
                    }
                    i2 += 4;
                }
            } while (i3 != eaVar3.Hw());
            eaVar2.j6(eaVar3);
            i--;
            if (Hw != eaVar2.Hw()) {
            }
            eaVar3.j6();
            eaVar2.j6.j6();
            while (eaVar2.j6.DW()) {
                eaVar3.j6(eaVar2.j6.FH());
            }
            return eaVar3;
        } while (i > 0);
        eaVar3.j6();
        eaVar2.j6.j6();
        while (eaVar2.j6.DW()) {
            eaVar3.j6(eaVar2.j6.FH());
        }
        return eaVar3;
    }

    public ea<bs> DW(ea<bs> eaVar, int i) {
        ea eaVar2 = new ea(this.FH);
        ea eaVar3 = new ea(this.FH);
        eaVar2.j6((ea) eaVar);
        do {
            int Hw = eaVar2.Hw();
            eaVar3.j6();
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.ei) {
                if (this.nw[i3] != -1 && eaVar2.FH(this.FH.FH(this.nw[i3 + 2]))) {
                    switch (this.SI[i2]) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        case 5:
                            if (!this.FH.FH(this.nw[i3 + 1]).zh()) {
                                break;
                            }
                            eaVar3.j6(this.FH.FH(this.nw[i3 + 1]));
                            break;
                        default:
                            break;
                    }
                }
                i3 += 3;
                i2++;
            }
            do {
                i3 = eaVar3.Hw();
                i2 = 0;
                while (i2 < this.ro) {
                    if (this.cn[i2] != -1 && eaVar2.FH(this.FH.FH(this.cn[i2 + 3]))) {
                        eaVar3.j6(this.FH.FH(this.cn[i2 + 1]));
                    }
                    i2 += 4;
                }
            } while (i3 != eaVar3.Hw());
            eaVar2.j6(eaVar3);
            i--;
            if (Hw != eaVar2.Hw()) {
            }
            eaVar3.j6();
            eaVar2.j6.j6();
            while (eaVar2.j6.DW()) {
                eaVar3.j6(eaVar2.j6.FH());
            }
            return eaVar3;
        } while (i > 0);
        eaVar3.j6();
        eaVar2.j6.j6();
        while (eaVar2.j6.DW()) {
            eaVar3.j6(eaVar2.j6.FH());
        }
        return eaVar3;
    }

    public ea<bs> Hw() {
        return new ea(this.FH);
    }

    public eb v5() {
        if (!this.gW) {
            return null;
        }
        int i;
        int i2 = 0;
        for (i = 0; i < this.ei; i += 3) {
            if (this.nw[i + 1] > i2) {
                i2 = this.nw[i + 1];
            }
            if (this.nw[i + 2] > i2) {
                i2 = this.nw[i + 2];
            }
        }
        for (i = 0; i < this.ro; i += 4) {
            if (this.cn[i + 1] > i2) {
                i2 = this.cn[i + 1];
            }
            if (this.cn[i + 2] > i2) {
                i2 = this.cn[i + 2];
            }
            if (this.cn[i + 3] > i2) {
                i2 = this.cn[i + 3];
            }
        }
        i = 0;
        while (i < this.cb.Hw()) {
            if (this.cb.FH(i) != -1 && this.cb.FH(i + 1) > i2) {
                i2 = this.cb.FH(i + 1);
            }
            i += 2;
        }
        if (i2 >= this.j3.length) {
            this.j3 = new boolean[((i2 * 3) / 2)];
        }
        if (i2 >= this.Mr.length) {
            this.Mr = new boolean[((i2 * 3) / 2)];
        }
        if (i2 >= this.U2.length) {
            this.U2 = new boolean[((i2 * 3) / 2)];
        }
        if (i2 >= this.a8.length) {
            this.a8 = new boolean[((i2 * 3) / 2)];
        }
        if (i2 >= this.lg.length) {
            this.lg = new boolean[((i2 * 3) / 2)];
        }
        if (i2 >= this.rN.length) {
            this.rN = new boolean[((i2 * 3) / 2)];
        }
        for (i = 0; i < this.j3.length; i++) {
            this.j3[i] = false;
        }
        for (i = 0; i < this.Mr.length; i++) {
            this.Mr[i] = false;
        }
        for (i = 0; i < this.U2.length; i++) {
            this.U2[i] = false;
        }
        for (i = 0; i < this.a8.length; i++) {
            this.a8[i] = false;
        }
        for (i = 0; i < this.lg.length; i++) {
            this.lg[i] = false;
        }
        for (i = 0; i < this.rN.length; i++) {
            this.rN[i] = false;
        }
        if (ek.j6) {
            i2 = 0;
            i = 0;
            while (i < this.ei) {
                if (!(this.nw[i] == -1 || this.Mr[this.nw[i + 2]] || this.SI[i2] == 2)) {
                    this.Mr[this.nw[i + 2]] = true;
                }
                i += 3;
                i2++;
            }
            i = 0;
            while (i < this.ro) {
                if (!(this.cn[i] == -1 || this.Mr[this.cn[i + 3]])) {
                    this.Mr[this.cn[i + 3]] = true;
                }
                i += 4;
            }
            i = 0;
            while (i < this.cb.Hw()) {
                if (!(this.cb.FH(i) == -1 || this.Mr[this.cb.FH(i + 1)])) {
                    this.j3[this.FH.FH(this.cb.FH(i + 1)).v5()] = true;
                }
                i += 2;
            }
            if (this.j6.P8.VH()) {
                return null;
            }
            for (i = 0; i < this.j3.length; i++) {
                if (this.j3[i]) {
                    this.lg[i] = true;
                }
            }
        }
        for (i = 0; i < this.ro; i += 4) {
            if (this.cn[i] != -1) {
                this.rN[this.cn[i + 1]] = true;
            }
        }
        if (this.j6.P8.VH()) {
            return null;
        }
        bv tp;
        this.er.j6();
        for (i = 0; i < this.rN.length; i++) {
            if (this.rN[i]) {
                tp = this.FH.FH(i).tp();
                if (!this.er.DW(tp.vy())) {
                    this.er.j6(tp.vy(), 0);
                }
                this.er.j6(tp.vy(), (this.er.FH(tp.vy()) * 37) ^ ((long) (i + 1)));
            }
        }
        if (ek.j6) {
            bv gn;
            long Hw;
            for (i = 0; i < this.U2.length; i++) {
                if (this.U2[i]) {
                    tp = this.FH.FH(i).tp();
                    if (!this.er.DW(tp.vy())) {
                        this.er.j6(tp.vy(), 0);
                    }
                    this.er.j6(tp.vy(), (this.er.FH(tp.vy()) * 37) ^ ((long) (i + 3)));
                }
            }
            for (i = 0; i < this.a8.length; i++) {
                if (this.a8[i]) {
                    tp = this.FH.FH(i).tp();
                    if (!this.er.DW(tp.vy())) {
                        this.er.j6(tp.vy(), 0);
                    }
                    this.er.j6(tp.vy(), (this.er.FH(tp.vy()) * 37) ^ ((long) (i + 5)));
                }
            }
            for (i = 0; i < this.lg.length; i++) {
                if (this.lg[i]) {
                    tp = this.FH.FH(i).tp();
                    if (!this.er.DW(tp.vy())) {
                        this.er.j6(tp.vy(), 0);
                    }
                    this.er.j6(tp.vy(), (this.er.FH(tp.vy()) * 37) ^ ((long) (i + 7)));
                }
            }
            this.er.j6.j6();
            while (this.er.j6.DW()) {
                gn = this.Hw.gn(this.er.j6.FH());
                Hw = this.er.j6.Hw();
                if (!this.yS.DW(gn.vy()) || this.yS.FH(gn.vy()) != Hw) {
                    this.BT.j6(gn);
                }
            }
            this.yS.j6.j6();
            while (this.yS.j6.DW()) {
                gn = this.Hw.gn(this.yS.j6.FH());
                Hw = this.yS.j6.Hw();
                if (!this.er.DW(gn.vy()) || this.er.FH(gn.vy()) != Hw) {
                    this.BT.j6(gn);
                }
            }
        }
        dt dtVar = new dt();
        dt dtVar2 = new dt();
        dt dtVar3 = new dt();
        dt dtVar4 = new dt();
        for (i = 0; i < this.rN.length; i++) {
            if (this.rN[i]) {
                tp = this.FH.FH(i).tp();
                if (this.BT.FH(tp)) {
                    dtVar4.DW(tp.vy(), i);
                }
            }
        }
        if (ek.j6) {
            for (i = 0; i < this.U2.length; i++) {
                if (this.U2[i]) {
                    tp = this.FH.FH(i).tp();
                    if (this.BT.FH(tp)) {
                        dtVar3.DW(tp.vy(), i);
                    }
                }
            }
            for (i = 0; i < this.a8.length; i++) {
                if (this.a8[i]) {
                    tp = this.FH.FH(i).tp();
                    if (this.BT.FH(tp)) {
                        dtVar2.DW(tp.vy(), i);
                    }
                }
            }
            for (i = 0; i < this.lg.length; i++) {
                if (this.lg[i]) {
                    tp = this.FH.FH(i).tp();
                    if (this.BT.FH(tp)) {
                        dtVar.DW(tp.vy(), i);
                    }
                }
            }
        }
        if (this.j6.P8.VH()) {
            return null;
        }
        int j6 = this.DW.j6("main");
        int j62 = this.DW.j6("Main");
        this.BT.j6.j6();
        while (this.BT.j6.DW()) {
            tp = this.BT.j6.FH();
            this.Zo.j6(tp);
            dtVar4.j6.j6(tp.vy());
            while (dtVar4.j6.DW()) {
                bs FH = this.FH.FH(dtVar4.j6.Hw());
                int er = FH.er();
                int gW = FH.gW();
                int yS = FH.yS();
                if (gW != yS) {
                    this.Zo.j6(tp, er, gW, er, yS, "", 90);
                }
            }
            if (ek.j6) {
                String eU;
                dtVar.j6.j6(tp.vy());
                while (dtVar.j6.DW()) {
                    bs FH2 = this.FH.FH(dtVar.j6.Hw());
                    er = FH2.er();
                    gW = FH2.gW();
                    yS = FH2.yS();
                    eU = FH2.eU();
                    if (gW != yS) {
                        if (FH2.zh() && ((bz) FH2).u7()) {
                            this.Zo.j6(tp, er, gW, er, yS, "There is no read access to field </C>" + eU + "<//C> which can be reached from the project's entry points", 81);
                        } else if (FH2.cT()) {
                            this.Zo.j6(tp, er, gW, er, yS, "There is no usage of class </C>" + eU + "<//C> which can be reached from the project's entry points", 80);
                        } else if (FH2.zh() && ((bz) FH2).sy()) {
                            if (!FH2.Q6() || ((bz) FH2).lp() != 0) {
                                this.Zo.j6(tp, er, gW, er, yS, "This constructor can not be reached from the project's entry points", 81);
                            }
                        } else if (!(!FH2.zh() || !((bz) FH2).gn() || ((bz) FH2).sy() || ((bz) FH2).aq() == j6 || ((bz) FH2).aq() == j62)) {
                            this.Zo.j6(tp, er, gW, er, yS, "Method </C>" + eU + "<//C> can not be reached from the project's entry points", 81);
                        }
                    }
                }
                dtVar2.j6.j6(tp.vy());
                while (dtVar2.j6.DW()) {
                    bs FH3 = this.FH.FH(dtVar2.j6.Hw());
                    er = FH3.BT();
                    int vy = FH3.vy();
                    gW = FH3.ei();
                    yS = FH3.P8();
                    String eU2 = FH3.eU();
                    if (FH3.gW() != FH3.yS()) {
                        if (FH3.zh() && ((bz) FH3).u7()) {
                            eU = "Field </C>" + eU2 + "<//C> can be private. There is no access outside of this class";
                            if (er == vy && gW == yS) {
                                this.Zo.j6(tp, er, gW, vy, yS + 2, eU, 83);
                            } else {
                                this.Zo.j6(tp, er, gW, vy, yS, eU, 83);
                            }
                        } else if (FH3.cT()) {
                            eU = "Class </C>" + eU2 + "<//C> can be private. There is no usage outside of this class";
                            if (er == vy && gW == yS) {
                                this.Zo.j6(tp, er, gW, vy, yS + 2, eU, 82);
                            } else {
                                this.Zo.j6(tp, er, gW, vy, yS, eU, 82);
                            }
                        } else if (FH3.zh() && ((bz) FH3).gn() && !((bz) FH3).sy()) {
                            eU = "Method </C>" + eU2 + "<//C> can be private. There is no call outside of this class";
                            if (er == vy && gW == yS) {
                                this.Zo.j6(tp, er, gW, vy, yS + 2, eU, 83);
                            } else {
                                this.Zo.j6(tp, er, gW, vy, yS, eU, 83);
                            }
                        } else if (FH3.zh() && ((bz) FH3).sy() && FH3.gW() != FH3.yS()) {
                            eU = "This constructor can be private. There is no call outside of this class";
                            if (er == vy && gW == yS) {
                                this.Zo.j6(tp, er, gW, vy, yS + 2, eU, 83);
                            } else {
                                this.Zo.j6(tp, er, gW, vy, yS, eU, 83);
                            }
                        }
                    }
                }
                dtVar3.j6.j6(tp.vy());
                while (dtVar3.j6.DW()) {
                    FH = this.FH.FH(dtVar3.j6.Hw());
                    er = FH.er();
                    if (FH.gW() != FH.yS()) {
                        this.Zo.j6(tp, er, FH.gW() - 1, er, FH.gW() + 1, "Method </C>" + FH.eU() + "<//C> can be void. The returned value is never used in the project", 84);
                    }
                }
            }
        }
        eb ebVar = new eb(this.Hw);
        ebVar.j6(this.BT);
        this.BT.j6();
        this.gW = false;
        this.yS.j6();
        this.yS.j6(this.er);
        return ebVar;
    }

    public boolean j6(bv bvVar) {
        if (bvVar.BT() != null) {
            for (bj j6 : bvVar.BT().Zo()) {
                int j62 = this.Hw.j6(bvVar, j6);
                if (!this.we.FH(j62) || (this.tp.FH(j62) && !this.EQ.FH(j62))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void j6(cj cjVar) {
        if (!j6(cjVar.we())) {
            bv we = cjVar.we();
            int j6 = this.Hw.j6(we, cjVar.tp());
            this.J8.j6(j6, cjVar.VH());
            this.Ws.j6(j6, cjVar.Zo());
            if (!this.J0.j6(j6)) {
                this.J0.j6(j6, we.QX());
            }
            this.we.j6(j6);
            this.tp.DW(j6);
            DW(cjVar);
            this.XL.DW(j6);
            this.aM.DW(j6);
            j6(j6, cjVar, cjVar.Ws());
            FH(cjVar);
            if (this.j6.sG.FH(we, cjVar.tp())) {
                this.tp.j6(j6);
                this.EQ.j6(j6);
            }
        }
    }

    private void j6(int i, cj cjVar, int i2) {
        int i3;
        bv tp;
        if (cjVar.I(i2)) {
            try {
                bp j6 = this.FH.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i2));
                for (i3 = 0; i3 < j6.WB(); i3++) {
                    co a_ = j6.v5(i3).a_();
                    if (a_.cT()) {
                        tp = ((bp) a_).tp();
                        if (tp.DW() && tp != cjVar.we()) {
                            this.aM.DW(i, tp.vy());
                        }
                    }
                }
            } catch (ej e) {
            }
        }
        if (cjVar.sy(i2)) {
            switch (cjVar.J8(i2)) {
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    tp = ((bz) cjVar.QX(i2)).tp();
                    if (tp.DW() && tp != cjVar.we()) {
                        this.XL.DW(i, tp.vy());
                        break;
                    }
                case 22:
                case 23:
                case 24:
                case 25:
                    tp = ((bz) cjVar.QX(i2)).tp();
                    if (tp.DW() && tp != cjVar.we()) {
                        this.XL.DW(i, tp.vy());
                        break;
                    }
            }
        }
        i3 = cjVar.lg(i2);
        for (int i4 = 0; i4 < i3; i4++) {
            j6(i, cjVar, cjVar.Hw(i2, i4));
        }
    }

    private void j6(bv bvVar, bj bjVar, bv bvVar2, bj bjVar2) {
        if (bvVar2.J8()) {
            bvVar2 = bvVar2.EQ();
        }
        int j6 = this.Hw.j6(bvVar, bjVar);
        int j62 = this.Hw.j6(bvVar2, bjVar2);
        this.gn.DW(j6, j62);
        this.u7.j6(j62);
        if (!this.J0.j6(j62)) {
            this.J0.j6(j62, bvVar2.QX());
        }
    }

    private ec j6(int i) {
        this.VH.j6();
        this.we.j6.j6();
        while (this.we.j6.DW()) {
            if (this.gn.FH(this.we.j6.FH(), i)) {
                this.VH.j6(this.we.j6.FH());
            }
        }
        return this.VH;
    }

    private void j6(ec ecVar, ec ecVar2) {
        int i = 0;
        this.vy.j6();
        this.vy.j6(this.Hw.Hw());
        if (ecVar2.Hw() > 0) {
            this.gW = true;
            ecVar2.j6.j6();
            while (ecVar2.j6.DW()) {
                this.BT.j6(this.Hw.Hw(ecVar2.j6.FH()));
            }
        }
        if (ecVar.Hw() > 0) {
            int i2;
            this.gW = true;
            for (i2 = 0; i2 < this.ei; i2 += 3) {
                if (ecVar.FH(this.nw[i2])) {
                    if (this.P8 > i2) {
                        this.P8 = i2;
                    }
                    this.nw[i2] = -1;
                }
            }
            for (i2 = 0; i2 < this.ro; i2 += 4) {
                if (ecVar.FH(this.cn[i2])) {
                    if (this.KD > i2) {
                        this.KD = i2;
                    }
                    this.cn[i2] = -1;
                }
            }
            while (i < this.cb.Hw()) {
                i2 = this.cb.FH(i);
                if (ecVar.FH(i2) || !this.vy.FH(this.Hw.Hw(i2))) {
                    if (this.sh > i) {
                        this.sh = i;
                    }
                    this.cb.j6(i, -1);
                }
                i += 2;
            }
        }
    }

    private void j6(cj cjVar, bs bsVar, bs bsVar2, bs bsVar3) {
        if (bsVar != null && bsVar != bsVar2 && this.vy.FH(bsVar2.tp()) && this.vy.FH(bsVar.tp())) {
            while (this.KD < this.ro && this.cn[this.KD] != -1) {
                this.KD += 4;
            }
            if (this.KD >= this.ro) {
                if (this.ro + 4 >= this.cn.length) {
                    Object obj = new int[((((this.cn.length * 2) / 4) * 4) + 4)];
                    System.arraycopy(this.cn, 0, obj, 0, this.cn.length);
                    this.cn = obj;
                }
                this.cn[this.ro] = this.Hw.j6(cjVar.we(), cjVar.tp());
                this.cn[this.ro + 1] = bsVar.v5();
                this.cn[this.ro + 2] = bsVar2.v5();
                this.cn[this.ro + 3] = bsVar3.v5();
                this.ro += 4;
                return;
            }
            this.cn[this.KD] = this.Hw.j6(cjVar.we(), cjVar.tp());
            this.cn[this.KD + 1] = bsVar.v5();
            this.cn[this.KD + 2] = bsVar2.v5();
            this.cn[this.KD + 3] = bsVar3.v5();
            this.KD += 4;
        }
    }

    private void j6(cj cjVar, bs bsVar) {
        while (this.sh < this.cb.Hw() && this.cb.FH(this.sh) != -1) {
            this.sh += 2;
        }
        if (this.sh >= this.cb.Hw()) {
            this.cb.DW(this.Hw.j6(cjVar.we(), cjVar.tp()));
            this.cb.DW(bsVar.v5());
            return;
        }
        this.cb.j6(this.sh, this.Hw.j6(cjVar.we(), cjVar.tp()));
        this.cb.j6(this.sh + 1, bsVar.v5());
        this.sh += 2;
    }

    private void DW(cj cjVar) {
        bv we = cjVar.we();
        bj tp = cjVar.tp();
        this.QX.j6();
        j6(cjVar, cjVar.Ws());
        this.QX.j6.j6();
        while (this.QX.j6.DW()) {
            bp bpVar = (bp) this.QX.j6.FH();
            ea jO = bpVar.jO();
            jO.j6.j6();
            while (jO.j6.DW()) {
                bp bpVar2 = (bp) jO.j6.FH();
                bv tp2 = bpVar2.tp();
                if (tp2.J8()) {
                    tp2 = tp2.EQ();
                }
                j6(we, tp, tp2, bpVar2.Hw());
            }
            if (bpVar.ef()) {
                ea aM = bpVar.aM();
                if (aM != null) {
                    while (aM.j6.DW()) {
                        bpVar = (bp) aM.j6.FH();
                        bv tp3 = bpVar.tp();
                        if (tp3.J8()) {
                            tp3 = tp3.EQ();
                        }
                        j6(we, tp, tp3, bpVar.Hw());
                    }
                }
            }
        }
    }

    private void j6(cj cjVar, int i) {
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 6:
                    j6((ce) cjVar.QX(i));
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    DW((bp) cjVar.QX(i));
                    break;
                case 16:
                    DW(((bz) cjVar.QX(i)).Xa());
                    break;
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    DW(((bz) cjVar.QX(i)).Xa());
                    break;
                case 22:
                case 23:
                case 24:
                case 25:
                    j6(((bz) cjVar.QX(i)).Xa());
                    break;
            }
        }
        if (cjVar.J0(i)) {
            co we = cjVar.we(i);
            if (we.cT()) {
                DW((bp) we);
            } else if (we.n5()) {
                DW(((cf) we).gn());
            }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }

    private void j6(ce ceVar) {
    }

    private void j6(bp bpVar) {
        this.QX.j6((bs) bpVar);
    }

    private void DW(bp bpVar) {
        this.QX.j6((bs) bpVar);
    }

    private void FH(cj cjVar) {
        j6(cjVar, cjVar.Ws(), null);
    }

    private void j6(cj cjVar, int i, bs bsVar) {
        bs DW;
        bs bsVar2;
        bs Xa;
        ea dx;
        int i2;
        int i3 = 0;
        if (ek.j6 && cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    j6(cjVar, bsVar, cjVar.QX(i), 0);
                    break;
                case 16:
                    if (!cjVar.Sf(cjVar.aM(i))) {
                        j6(cjVar, bsVar, cjVar.QX(i), 1);
                        break;
                    } else {
                        j6(cjVar, bsVar, cjVar.QX(i), 2);
                        break;
                    }
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    j6(cjVar, bsVar, cjVar.QX(i), 3);
                    break;
                case 22:
                case 23:
                case 24:
                case 25:
                    j6(cjVar, bsVar, cjVar.QX(i), 5);
                    break;
            }
        }
        if (cjVar.ca(i)) {
            try {
                DW = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                try {
                    if (!((bz) DW).sy()) {
                        ea cb;
                        if (ek.j6) {
                            j6(cjVar, DW, ((bz) DW).Xa(), 6);
                        }
                        j6(cjVar, DW);
                        cb = ((bz) DW).cb();
                        cb.j6.j6();
                        while (cb.j6.DW()) {
                            bsVar2 = (bz) cb.j6.FH();
                            Xa = ((bz) DW).Xa();
                            if (bsVar2.tp().DW()) {
                                dx = Xa.dx();
                                dx.j6.j6();
                                while (dx.j6.DW()) {
                                    j6(cjVar, bsVar2, dx.j6.FH(), DW);
                                }
                                if (dx.Hw() == 0) {
                                    j6(cjVar, bsVar2, Xa, DW);
                                }
                            } else {
                                ea dx2;
                                dx2 = Xa.dx();
                                dx2.j6.j6();
                                while (dx2.j6.DW()) {
                                    j6(cjVar, dx2.j6.FH(), DW, 7);
                                }
                                if (dx2.Hw() == 0) {
                                    j6(cjVar, Xa, DW, 7);
                                }
                            }
                        }
                    } else if (ek.j6) {
                        try {
                            DW = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                            j6(cjVar, DW, ((bz) DW).Xa(), 6);
                            j6(cjVar, DW);
                        } catch (ej e) {
                        }
                    }
                } catch (ej e2) {
                }
            } catch (ej e3) {
                DW = bsVar;
            }
        } else {
            DW = bsVar;
        }
        if (ek.j6 && cjVar.I(i)) {
            try {
                DW = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                int wc;
                bs FH;
                bs Hw;
                ea dx3;
                if (((bp) DW).hz()) {
                    j6(cjVar, DW);
                    bsVar2 = (bp) DW;
                    wc = bsVar2.wc();
                    for (i2 = 0; i2 < wc; i2++) {
                        FH = bsVar2.FH(i2);
                        Hw = bsVar2.Hw(i2);
                        dx3 = bsVar2.dx();
                        dx3.j6.j6();
                        while (dx3.j6.DW()) {
                            j6(cjVar, Hw, dx3.j6.FH(), FH);
                        }
                        if (dx3.Hw() == 0) {
                            j6(cjVar, Hw, bsVar2, FH);
                        }
                    }
                } else {
                    j6(cjVar, DW);
                    j6(cjVar, DW, DW.Xa(), 6);
                    bsVar2 = (bp) DW;
                    wc = bsVar2.wc();
                    for (i2 = 0; i2 < wc; i2++) {
                        FH = bsVar2.FH(i2);
                        Hw = bsVar2.Hw(i2);
                        dx3 = bsVar2.dx();
                        dx3.j6.j6();
                        while (dx3.j6.DW()) {
                            j6(cjVar, Hw, dx3.j6.FH(), FH);
                        }
                        if (dx3.Hw() == 0) {
                            j6(cjVar, Hw, bsVar2, FH);
                        }
                    }
                }
            } catch (ej e4) {
            }
        }
        int lg;
        if (cjVar.x9(i)) {
            try {
                Xa = this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (ek.j6) {
                    j6(cjVar, Xa, Xa.Xa(), 6);
                }
                j6(cjVar, Xa);
                if (ek.j6) {
                    int lg2;
                    if (Xa.I()) {
                        bsVar2 = Xa.Xa();
                        lg2 = cjVar.lg(i);
                        while (i3 < lg2) {
                            j6(cjVar, cjVar.Hw(i, i3), bsVar2);
                            i3++;
                        }
                    } else {
                        bs Xa2 = Xa.Xa();
                        dx = Xa2.dx();
                        dx.j6.j6();
                        while (dx.j6.DW()) {
                            bsVar2 = (bz) dx.j6.FH();
                            int lg3 = cjVar.lg(i);
                            for (lg2 = 0; lg2 < lg3; lg2++) {
                                j6(cjVar, cjVar.Hw(i, lg2), bsVar2);
                            }
                        }
                        if (dx.Hw() == 0) {
                            lg = cjVar.lg(i);
                            while (i3 < lg) {
                                j6(cjVar, cjVar.Hw(i, i3), Xa2);
                                i3++;
                            }
                        }
                    }
                }
                ea cb2 = Xa.cb();
                cb2.j6.j6();
                while (cb2.j6.DW()) {
                    bsVar2 = (bz) cb2.j6.FH();
                    bs Xa3 = Xa.Xa();
                    if (bsVar2.tp().DW()) {
                        cb = Xa3.dx();
                        cb.j6.j6();
                        while (cb.j6.DW()) {
                            j6(cjVar, bsVar2, cb.j6.FH(), Xa);
                        }
                        if (cb.Hw() == 0) {
                            j6(cjVar, bsVar2, Xa3, Xa);
                        }
                    } else {
                        dx2 = Xa3.dx();
                        dx2.j6.j6();
                        while (dx2.j6.DW()) {
                            j6(cjVar, dx2.j6.FH(), Xa, 7);
                        }
                        if (dx2.Hw() == 0) {
                            j6(cjVar, Xa3, Xa, 7);
                        }
                    }
                }
                return;
            } catch (ej e5) {
                return;
            }
        }
        i2 = cjVar.lg(i);
        for (lg = 0; lg < i2; lg++) {
            j6(cjVar, cjVar.Hw(i, lg), DW);
        }
    }

    private void j6(cj cjVar, bs bsVar, bs bsVar2, int i) {
        if (bsVar != null && this.vy.FH(bsVar2.tp()) && this.vy.FH(bsVar.tp())) {
            while (this.P8 < this.ei && this.nw[this.P8] != -1) {
                this.P8 += 3;
            }
            if (this.P8 >= this.ei) {
                if (this.ei + 3 >= this.nw.length) {
                    Object obj = new int[((((this.nw.length * 2) / 3) * 3) + 3)];
                    System.arraycopy(this.nw, 0, obj, 0, this.nw.length);
                    this.nw = obj;
                    obj = new int[((this.nw.length / 3) + 1)];
                    System.arraycopy(this.SI, 0, obj, 0, this.SI.length);
                    this.SI = obj;
                }
                this.nw[this.ei] = this.Hw.j6(cjVar.we(), cjVar.tp());
                this.nw[this.ei + 1] = bsVar.v5();
                this.nw[this.ei + 2] = bsVar2.v5();
                this.SI[this.ei / 3] = i;
                this.ei += 3;
                return;
            }
            this.nw[this.P8] = this.Hw.j6(cjVar.we(), cjVar.tp());
            this.nw[this.P8 + 1] = bsVar.v5();
            this.nw[this.P8 + 2] = bsVar2.v5();
            this.SI[this.P8 / 3] = i;
            this.P8 += 3;
        }
    }

    public void j6(bv bvVar, do doVar) {
        for (bj j6 : bvVar.BT().Zo()) {
            this.XL.j6.j6(this.Hw.j6(bvVar, j6));
            while (this.XL.j6.DW()) {
                doVar.DW(this.XL.j6.Hw());
            }
        }
    }

    public void DW(bv bvVar, do doVar) {
        for (bj j6 : bvVar.BT().Zo()) {
            this.aM.j6.j6(this.Hw.j6(bvVar, j6));
            while (this.aM.j6.DW()) {
                doVar.DW(this.aM.j6.Hw());
            }
        }
    }
}
