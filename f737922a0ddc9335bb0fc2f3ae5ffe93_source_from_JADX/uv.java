public final class uv {
    private final aaa DW;
    private boolean EQ;
    private final int FH;
    private final zs Hw;
    private final uv$b VH;
    private final ur Zo;
    private final int gn;
    private final tq j6;
    private final int tp;
    private int[] u7;
    private final ty v5;

    public static ue j6(aaa aaa, int i, zs zsVar, int i2, tq tqVar) {
        return new uv(aaa, i, zsVar, i2, tqVar).j6();
    }

    private uv(aaa aaa, int i, zs zsVar, int i2, tq tqVar) {
        this.j6 = tqVar;
        this.DW = aaa;
        this.FH = i;
        this.Hw = zsVar;
        this.v5 = new ty(aaa);
        this.tp = i2;
        this.u7 = null;
        this.EQ = j6(aaa, i2);
        zj j6 = aaa.j6();
        int m_ = j6.m_();
        int Zo = (m_ * 3) + j6.Zo();
        if (zsVar != null) {
            Zo += zsVar.DW() + m_;
        }
        this.gn = (this.EQ ? 0 : this.tp) + j6.v5();
        this.Zo = new ur(tqVar, Zo, m_ * 3, this.gn);
        if (zsVar != null) {
            this.VH = new uv$a(this, this.Zo, zsVar);
        } else {
            this.VH = new uv$b(this, this.Zo);
        }
    }

    private static boolean j6(aaa aaa, int i) {
        boolean[] zArr = new boolean[]{true};
        aaa.j6().j6(new uv$1(zArr, aaa.j6().v5(), i));
        return zArr[0];
    }

    private ue j6() {
        FH();
        DW();
        return new ue(this.FH, this.Zo.j6(), new ux(this.DW, this.u7, this.v5));
    }

    private void DW() {
        zj j6 = this.DW.j6();
        int[] iArr = this.u7;
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i + 1;
            j6(j6.DW(iArr[i]), i2 == iArr.length ? -1 : iArr[i2]);
        }
    }

    private void j6(zi ziVar, int i) {
        uf j6 = this.v5.j6(ziVar);
        this.Zo.j6(j6);
        if (this.Hw != null) {
            this.Zo.j6(new uo(j6.u7(), this.Hw.j6(ziVar)));
        }
        this.VH.j6(ziVar, this.v5.DW(ziVar));
        ziVar.DW().j6(this.VH);
        this.Zo.j6(this.v5.FH(ziVar));
        int Hw = ziVar.Hw();
        zo VH = ziVar.VH();
        if (Hw >= 0 && Hw != i) {
            if (VH.Zo().Hw() == 4 && ziVar.v5() == i) {
                this.Zo.j6(1, this.v5.j6(Hw));
                return;
            }
            this.Zo.j6(new uz(ui.Sf, VH.VH(), zx.j6, this.v5.j6(Hw)));
        }
    }

    private void FH() {
        zj j6 = this.DW.j6();
        int m_ = j6.m_();
        int tp = j6.tp();
        int[] j62 = act.j6(tp);
        int[] j63 = act.j6(tp);
        for (tp = 0; tp < m_; tp++) {
            act.DW(j62, j6.j6(tp).j6());
        }
        int[] iArr = new int[m_];
        tp = this.DW.DW();
        int i = 0;
        while (tp != -1) {
            int DW;
            while (true) {
                adg j64 = this.DW.j6(tp);
                int DW2 = j64.DW();
                int i2 = 0;
                while (i2 < DW2) {
                    DW = j64.DW(i2);
                    if (act.j6(j63, DW)) {
                        break;
                    } else if (act.j6(j62, DW) && j6.DW(DW).Hw() == tp) {
                        act.DW(j63, DW);
                        tp = DW;
                    } else {
                        i2++;
                    }
                }
                break;
            }
            DW = tp;
            tp = i;
            while (DW != -1) {
                act.FH(j62, DW);
                act.FH(j63, DW);
                iArr[tp] = DW;
                i = tp + 1;
                zi DW3 = j6.DW(DW);
                zi j65 = j6.j6(DW3);
                if (j65 == null) {
                    tp = i;
                    break;
                }
                tp = j65.j6();
                DW = DW3.Hw();
                if (!act.j6(j62, tp)) {
                    if (DW == tp || DW < 0 || !act.j6(j62, DW)) {
                        adg FH = DW3.FH();
                        int DW4 = FH.DW();
                        for (DW = 0; DW < DW4; DW++) {
                            tp = FH.DW(DW);
                            if (act.j6(j62, tp)) {
                                break;
                            }
                        }
                        tp = -1;
                    } else {
                        tp = DW;
                    }
                }
                DW = tp;
                tp = i;
            }
            i = tp;
            tp = act.Hw(j62, 0);
        }
        if (i != m_) {
            throw new RuntimeException("shouldn't happen");
        }
        this.u7 = iArr;
    }

    private static zx DW(zo zoVar) {
        return DW(zoVar, zoVar.gn());
    }

    private static zx DW(zo zoVar, zw zwVar) {
        zx tp = zoVar.tp();
        if (zoVar.Zo().Zo() && tp.m_() == 2 && zwVar.VH() == tp.DW(1).VH()) {
            tp = zx.j6(tp.DW(1), tp.DW(0));
        }
        return zwVar == null ? tp : tp.DW(zwVar);
    }
}
