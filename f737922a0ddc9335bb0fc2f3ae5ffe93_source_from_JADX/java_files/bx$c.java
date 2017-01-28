import java.util.ArrayList;
import java.util.List;

class bx$c {
    private final bx DW;
    private di EQ;
    private dj<dj<do>> FH;
    private dg Hw;
    private dg J0;
    private dg J8;
    private int QX;
    private dy VH;
    private int Ws;
    private int XL;
    private dy Zo;
    private int aM;
    private ec gn;
    private final cc j6;
    private di tp;
    private ec u7;
    private ec v5;
    private dg we;

    public bx$c(cc ccVar, bx bxVar) {
        this.FH = new dj();
        this.Hw = new dg();
        this.v5 = new ec();
        this.Zo = new dy();
        this.VH = new dy();
        this.gn = new ec();
        this.u7 = new ec();
        this.tp = new di();
        this.EQ = new di();
        this.we = new dg();
        this.J0 = new dg();
        this.J8 = new dg();
        this.j6 = ccVar;
        this.DW = bxVar;
        this.Ws = ccVar.ro.j6("prototype");
        this.QX = ccVar.ro.j6("()");
        this.aM = ccVar.ro.j6("function");
        this.XL = ccVar.ro.j6("[]");
    }

    public dm<bz> j6(cj cjVar, int i) {
        dm<bz> dmVar = new dm(this.j6.cb);
        dj djVar = (dj) this.FH.FH(j6(cjVar.we(), cjVar.tp(), i));
        if (djVar != null) {
            djVar.j6.j6();
            while (djVar.j6.DW()) {
                do doVar = (do) djVar.j6.Hw();
                for (int i2 = 0; i2 < doVar.Hw(); i2++) {
                    int FH = doVar.FH(i2);
                    int j6 = j6(FH);
                    bs gn = this.DW.j6(FH(FH), DW(FH)).gn(j6);
                    if (!(gn == null || this.DW.j6(FH(FH), DW(FH)).EQ(j6) == this.aM)) {
                        dmVar.FH(gn);
                    }
                }
            }
        }
        return dmVar;
    }

    public List<cp> DW(cj cjVar, int i) {
        int i2 = 0;
        List<cp> arrayList = new ArrayList();
        bv we = cjVar.we();
        bj tp = cjVar.tp();
        dg dgVar = new dg();
        int j6 = j6(we, tp, i);
        do doVar = new do();
        dj djVar = (dj) this.FH.FH(j6);
        if (djVar != null) {
            djVar.j6.j6();
            while (djVar.j6.DW()) {
                do doVar2 = (do) djVar.j6.Hw();
                for (int i3 = 0; i3 < doVar2.Hw(); i3++) {
                    int FH = doVar2.FH(i3);
                    if (FH(FH) == we) {
                        doVar.DW(j6(FH));
                    }
                }
            }
        }
        for (j6 = 0; j6 < doVar.Hw(); j6++) {
            int FH2 = doVar.FH(j6);
            if (!(FH2 == i || this.DW.j6(we, tp).EQ(FH2) == -1 || !this.DW.j6(we, tp).u7(FH2))) {
                dgVar.j6(this.DW.j6(we, tp).EQ(FH2), this.DW.j6(we, tp).tp(FH2));
            }
        }
        while (i2 < doVar.Hw()) {
            j6 = doVar.FH(i2);
            if (!(j6 == i || this.DW.j6(we, tp).EQ(j6) == -1 || dgVar.DW(this.DW.j6(we, tp).EQ(j6)))) {
                dgVar.j6(this.DW.j6(we, tp).EQ(j6), this.DW.j6(we, tp).tp(j6));
            }
            i2++;
        }
        dgVar.j6.j6();
        while (dgVar.j6.DW()) {
            int Hw = dgVar.j6.Hw();
            if (Hw != -1) {
                arrayList.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), cjVar.gW(Hw), null));
            }
        }
        return arrayList;
    }

    public List<bz> FH(cj cjVar, int i) {
        cjVar.we();
        List<bz> arrayList = new ArrayList();
        do doVar = (do) ((dj) this.FH.FH(j6(cjVar.we(), cjVar.tp(), i))).FH(this.aM);
        if (doVar != null) {
            for (int i2 = 0; i2 < doVar.Hw(); i2++) {
                int FH = doVar.FH(i2);
                int j6 = j6(FH);
                bz gn = this.DW.j6(FH(FH), DW(FH)).gn(j6);
                if (gn != null && gn.gn() && this.DW.j6(FH(FH), DW(FH)).EQ(j6) == this.aM) {
                    arrayList.add(gn);
                }
            }
        }
        return arrayList;
    }

    public List<List<cp>> Hw(cj cjVar, int i) {
        bv we = cjVar.we();
        bj tp = cjVar.tp();
        List<List<cp>> arrayList = new ArrayList();
        int j6 = j6(cjVar.we(), cjVar.tp(), i);
        do doVar = new do();
        do doVar2 = (do) ((dj) this.FH.FH(j6)).FH(this.aM);
        if (doVar2 != null) {
            for (int i2 = 0; i2 < doVar2.Hw(); i2++) {
                int FH = doVar2.FH(i2);
                if (this.DW.j6(FH(FH), DW(FH)).gn(j6(FH)) == null && FH(FH) == we) {
                    doVar.DW(j6(FH));
                }
            }
            if (doVar != null) {
                for (int i3 = 0; i3 < doVar.Hw(); i3++) {
                    int FH2 = doVar.FH(i3);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList.add(arrayList2);
                    int Hw = this.DW.j6(we, tp).Hw(FH2);
                    for (int i4 = 0; i4 < Hw; i4++) {
                        int Hw2 = this.DW.j6(we, tp).Hw(FH2, i4);
                        arrayList2.add(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw2), cjVar.KD(Hw2), cjVar.ro(Hw2), cjVar.gW(Hw2), null));
                    }
                }
            }
        }
        return arrayList;
    }

    public bz j6(int i, int i2) {
        dj djVar = (dj) this.FH.FH(i);
        if (djVar != null) {
            do doVar = (do) djVar.FH(i2);
            if (doVar != null) {
                for (int i3 = 0; i3 < doVar.Hw(); i3++) {
                    int FH = doVar.FH(i3);
                    bz gn = this.DW.j6(FH(FH), DW(FH)).gn(j6(FH));
                    if (gn != null) {
                        return gn;
                    }
                }
            }
        }
        return null;
    }

    public boolean DW(int i, int i2) {
        dj djVar = (dj) this.FH.FH(i);
        if (djVar == null) {
            return false;
        }
        do doVar = (do) djVar.FH(this.j6.ro.j6("new"));
        if (doVar == null || doVar.Hw() == 0) {
            return false;
        }
        do doVar2 = (do) djVar.FH(i2);
        if (doVar2 != null) {
            for (int i3 = 0; i3 < doVar2.Hw(); i3++) {
                int FH = doVar2.FH(i3);
                if (this.DW.j6(FH(FH), DW(FH)).u7(j6(FH))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int j6(bv bvVar, bj bjVar, int i) {
        return this.Hw.FH(FH(bvVar, bjVar, i));
    }

    private int j6(bv bvVar, int i) {
        long vy = (((long) bvVar.vy()) << 32) | ((long) i);
        if (!this.tp.j6(vy)) {
            this.tp.j6(vy, this.tp.DW());
        }
        return this.tp.DW(vy);
    }

    private int FH(bv bvVar, bj bjVar, int i) {
        int j6 = this.j6.cn.j6(bjVar);
        long vy = ((((long) bvVar.vy()) << 40) | (((long) j6) << 32)) | ((long) i);
        if (!this.EQ.j6(vy)) {
            int DW = this.EQ.DW();
            this.we.j6(DW, i);
            this.J0.j6(DW, bvVar.vy());
            this.J8.j6(DW, j6);
            this.EQ.j6(vy, DW);
        }
        return this.EQ.DW(vy);
    }

    private int j6(int i) {
        return this.we.FH(i);
    }

    private bj DW(int i) {
        return this.j6.cn.DW(this.J8.FH(i));
    }

    private bv FH(int i) {
        return this.j6.cn.gn(this.J0.FH(i));
    }

    public void DW(bv bvVar, bj bjVar, int i) {
        int Hw;
        System.currentTimeMillis();
        this.tp.j6();
        this.EQ.j6();
        this.J0.j6();
        this.J8.j6();
        this.we.j6();
        this.gn.j6();
        this.Zo.j6();
        this.FH.j6();
        this.Hw.j6();
        this.v5.j6();
        if (bvVar == null) {
            eb Hw2 = this.j6.cn.Hw();
            Hw2.j6.j6();
            while (Hw2.j6.DW()) {
                bv FH = Hw2.j6.FH();
                bh BT = FH.BT();
                if (BT != null) {
                    for (bj bjVar2 : BT.Zo()) {
                        if (bjVar2.Zo() != null) {
                            j6(FH, bjVar2);
                        }
                    }
                }
            }
        } else {
            j6(bvVar, bjVar);
            this.Hw.j6.j6();
            while (this.Hw.j6.DW()) {
                int FH2 = this.Hw.j6.FH();
                int j6 = j6(FH2);
                bv FH3 = FH(FH2);
                Hw = this.Hw.j6.Hw();
                if (FH3 == bvVar && (i == -1 || i == j6)) {
                    this.gn.j6(Hw);
                }
            }
        }
        Object obj;
        do {
            this.VH.j6();
            this.VH.j6(this.Zo);
            this.Zo.j6();
            if (bvVar != null) {
                j6();
            }
            this.VH.j6.j6();
            obj = null;
            while (this.VH.j6.DW()) {
                j6 = this.VH.j6.FH();
                Hw = this.VH.j6.Hw();
                int FH4 = this.Hw.FH(j6);
                int FH5 = this.Hw.FH(Hw);
                if (!(FH4 == FH5 || FH4 == -1 || FH5 == -1)) {
                    if (bvVar == null || this.gn.FH(FH4) || this.gn.FH(FH5)) {
                        int FH6;
                        do doVar;
                        if (bvVar != null) {
                            j6(FH(j6), DW(j6));
                        }
                        if (bvVar != null) {
                            j6(FH(Hw), DW(Hw));
                        }
                        dj djVar = (dj) this.FH.FH(FH4);
                        dj djVar2 = (dj) this.FH.FH(FH5);
                        djVar.j6.j6();
                        while (djVar.j6.DW()) {
                            FH6 = djVar.j6.FH();
                            doVar = (do) djVar.j6.Hw();
                            for (int i2 = 0; i2 < doVar.Hw(); i2++) {
                                j6(djVar2, doVar.FH(i2), FH6);
                            }
                        }
                        djVar.j6.j6();
                        while (djVar.j6.DW()) {
                            Hw = djVar.j6.FH();
                            if (!djVar2.j6(Hw)) {
                                djVar2.j6(Hw, new do());
                            }
                            doVar = (do) djVar2.FH(Hw);
                            do doVar2 = (do) djVar.j6.Hw();
                            for (FH6 = 0; FH6 < doVar2.Hw(); FH6++) {
                                int FH7 = doVar2.FH(FH6);
                                doVar.DW(FH7);
                                this.Hw.j6(FH7, FH5);
                            }
                        }
                        this.gn.DW(FH4);
                        this.gn.j6(FH5);
                        this.FH.DW(FH4);
                        obj = 1;
                    } else {
                        this.Zo.DW(j6, Hw);
                    }
                }
            }
        } while (obj != null);
    }

    private void j6(bv bvVar, bj bjVar) {
        if (!this.v5.FH(bvVar.vy())) {
            ea eaVar = new ea(this.j6.cb);
            this.v5.j6(bvVar.vy());
            this.DW.DW(bvVar, bjVar);
            bx$a j6 = this.DW.j6(bvVar, bjVar);
            dy Hw = j6.Hw();
            Hw.j6.j6();
            while (Hw.j6.DW()) {
                this.Zo.DW(FH(bvVar, bjVar, Hw.j6.FH()), FH(bvVar, bjVar, Hw.j6.Hw()));
            }
            dr v5 = j6.v5();
            v5.j6.j6();
            while (v5.j6.DW()) {
                bs bsVar = (bz) v5.j6.Hw();
                this.Zo.DW(FH(bvVar, bjVar, v5.j6.FH()), FH(bsVar.tp(), bsVar.Hw(), bsVar.v5() | Integer.MIN_VALUE));
                eaVar.j6(bsVar);
            }
            dg FH = j6.FH();
            FH.j6.j6();
            while (FH.j6.DW()) {
                int FH2 = FH.j6.FH();
                int FH3 = FH(bvVar, bjVar, FH2);
                int j62 = j6(bvVar, FH.j6.Hw());
                this.Hw.j6(FH3, j62);
                if (!this.FH.j6(j62)) {
                    this.FH.j6(j62, new dj());
                }
                dj djVar = (dj) this.FH.FH(j62);
                FH2 = j6.EQ(FH2);
                j6(djVar, FH3, FH2);
                if (!djVar.j6(FH2)) {
                    djVar.j6(FH2, new do());
                }
                ((do) djVar.FH(FH2)).DW(FH3);
            }
            eaVar.j6.j6();
            while (eaVar.j6.DW()) {
                bz bzVar = (bz) eaVar.j6.FH();
                this.DW.DW(bzVar.tp(), bzVar.Hw());
                j6(bzVar.tp(), bzVar.Hw());
            }
        }
    }

    private void j6() {
        while (true) {
            this.u7.j6();
            this.gn.j6.j6();
            while (this.gn.j6.DW()) {
                dj djVar = (dj) this.FH.FH(this.gn.j6.FH());
                djVar.j6.j6();
                while (djVar.j6.DW()) {
                    do doVar = (do) djVar.j6.Hw();
                    for (int i = 0; i < doVar.Hw(); i++) {
                        int FH = doVar.FH(i);
                        int j6 = j6(FH);
                        bv FH2 = FH(FH);
                        bj DW = DW(FH);
                        dt DW2 = this.DW.j6(FH2, DW).DW();
                        DW2.j6.j6(j6);
                        while (DW2.j6.DW()) {
                            j6 = this.Hw.FH(FH(FH2, DW, DW2.j6.Hw()));
                            if (!(j6 == -1 || this.gn.FH(j6))) {
                                this.u7.j6(j6);
                            }
                        }
                    }
                }
            }
            if (!this.u7.FH()) {
                this.gn.j6(this.u7);
            } else {
                return;
            }
        }
    }

    private void j6(dj<do> djVar, int i, int i2) {
        do doVar;
        int i3;
        int i4 = 0;
        if (!(i2 == -1 || i2 == this.aM)) {
            doVar = (do) djVar.FH(i2);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    bv FH = FH(i);
                    bv FH2 = FH(doVar.FH(i3));
                    bj DW = DW(i);
                    bj DW2 = DW(doVar.FH(i3));
                    this.Zo.DW(FH(FH, DW, this.DW.j6(FH, DW).VH(j6(i))), FH(FH2, DW2, this.DW.j6(FH2, DW2).VH(j6(doVar.FH(i3)))));
                }
            }
        }
        if (i2 == this.QX) {
            doVar = (do) djVar.FH(this.aM);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    Hw(doVar.FH(i3), i);
                }
            }
        }
        if (i2 == this.aM) {
            doVar = (do) djVar.FH(this.QX);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    Hw(i, doVar.FH(i3));
                }
            }
        }
        if (i2 == this.Ws) {
            doVar = (do) djVar.FH(this.aM);
            if (doVar != null) {
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    FH(doVar.FH(i3), i);
                }
            }
        }
        if (i2 == this.aM) {
            doVar = (do) djVar.FH(this.Ws);
            if (doVar != null) {
                while (i4 < doVar.Hw()) {
                    FH(i, doVar.FH(i4));
                    i4++;
                }
            }
        }
    }

    private void FH(int i, int i2) {
        bv FH = FH(i);
        bv FH2 = FH(i2);
        bj DW = DW(i);
        bj DW2 = DW(i2);
        this.Zo.DW(FH(FH, DW, this.DW.j6(FH, DW).Zo(j6(i))), FH(FH2, DW2, this.DW.j6(FH2, DW2).VH(j6(i2))));
    }

    private void Hw(int i, int i2) {
        int i3;
        bv FH = FH(i);
        bv FH2 = FH(i2);
        bj DW = DW(i);
        bj DW2 = DW(i2);
        int j6 = j6(i2);
        int j62 = j6(i);
        bx$a j63 = this.DW.j6(FH, DW);
        bx$a j64 = this.DW.j6(FH2, DW2);
        int v5 = j63.v5(j62);
        for (i3 = 0; i3 < v5; i3++) {
            this.Zo.j6(FH(FH2, DW2, j64.FH(j6)), FH(FH, DW, j63.v5(j62, i3)));
        }
        v5 = Math.min(j63.Hw(j62), j64.DW(j6));
        for (i3 = 0; i3 < v5; i3++) {
            this.Zo.j6(FH(FH, DW, j63.Hw(j62, i3)), FH(FH2, DW2, j64.FH(j6, i3)));
        }
        if (j64.j6(j6) != -1) {
            this.Zo.j6(FH(FH2, DW2, j64.j6(j6)), FH(FH, DW, j63.Zo(j62)));
        }
    }
}
