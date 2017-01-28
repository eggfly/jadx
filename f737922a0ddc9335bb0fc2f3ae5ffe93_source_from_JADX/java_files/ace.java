import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class ace {
    private int DW;
    private int[] FH;
    private aah[] Hw;
    private BitSet VH;
    private ArrayList<acg> Zo;
    private ArrayList<aci> gn;
    private acj j6;
    private ArrayList<aci> tp;
    private ArrayList<aci> u7;
    private ArrayList<acg> v5;

    private ace(acj acj) {
        this.j6 = acj;
        this.DW = acj.VH();
        this.FH = new int[this.DW];
        this.Hw = new aah[this.DW];
        this.v5 = new ArrayList();
        this.Zo = new ArrayList();
        this.VH = new BitSet(acj.tp().size());
        this.gn = new ArrayList();
        this.u7 = new ArrayList();
        this.tp = new ArrayList();
        for (int i = 0; i < this.DW; i++) {
            this.FH[i] = 0;
            this.Hw[i] = null;
        }
    }

    public static void j6(acj acj) {
        new ace(acj).j6();
    }

    private void j6(acg acg) {
        if (this.VH.get(acg.v5())) {
            this.Zo.add(acg);
            return;
        }
        this.v5.add(acg);
        this.VH.set(acg.v5());
    }

    private void j6(int i, int i2) {
        if (i2 == 2) {
            for (aci add : this.j6.Hw(i)) {
                this.u7.add(add);
            }
            return;
        }
        for (aci add2 : this.j6.Hw(i)) {
            this.gn.add(add2);
        }
    }

    private boolean j6(int i, int i2, aah aah) {
        if (i2 != 1) {
            if (this.FH[i] == i2) {
                return false;
            }
            this.FH[i] = i2;
            return true;
        } else if (this.FH[i] == i2 && this.Hw[i].equals(aah)) {
            return false;
        } else {
            this.FH[i] = i2;
            this.Hw[i] = aah;
            return true;
        }
    }

    private void j6(acb acb) {
        int VH = acb.Ws().VH();
        if (this.FH[VH] != 2) {
            zx DW = acb.DW();
            int m_ = DW.m_();
            int i = 0;
            aah aah = null;
            for (int i2 = 0; i2 < m_; i2++) {
                int j6 = acb.j6(i2);
                int VH2 = DW.DW(i2).VH();
                int i3 = this.FH[VH2];
                if (this.VH.get(j6)) {
                    if (i3 != 1) {
                        i = i3;
                        break;
                    } else if (aah == null) {
                        aah = this.Hw[VH2];
                        i = 1;
                    } else if (!this.Hw[VH2].equals(aah)) {
                        i = 2;
                        break;
                    }
                }
            }
            if (j6(VH, i, aah)) {
                j6(VH, i);
            }
        }
    }

    private void DW(acg acg) {
        Iterator it = acg.FH().iterator();
        while (it.hasNext()) {
            aci aci = (aci) it.next();
            if (aci instanceof acb) {
                j6((acb) aci);
            } else {
                DW(aci);
            }
        }
    }

    private void FH(acg acg) {
        Iterator it = acg.FH().iterator();
        while (it.hasNext()) {
            aci aci = (aci) it.next();
            if (aci instanceof acb) {
                j6((acb) aci);
            } else {
                return;
            }
        }
    }

    private void j6(aci aci) {
        int r_;
        int r_2;
        int i = 0;
        zz v5 = aci.v5();
        zx DW = aci.DW();
        if (v5.Hw() == 4) {
            aah aah;
            aah aah2;
            zw DW2 = DW.DW(0);
            int VH = DW2.VH();
            if (this.j6.j6(DW2) || this.FH[VH] != 1) {
                aah = null;
            } else {
                aah = this.Hw[VH];
            }
            if (DW.m_() == 2) {
                zw DW3 = DW.DW(1);
                int VH2 = DW3.VH();
                if (!this.j6.j6(DW3) && this.FH[VH2] == 1) {
                    aah2 = this.Hw[VH2];
                    if (aah != null || DW.m_() != 1) {
                        if (!(aah == null || aah2 == null)) {
                            switch (((abh) aah).FH()) {
                                case 6:
                                    r_ = ((aat) aah).r_();
                                    r_2 = ((aat) aah2).r_();
                                    switch (v5.j6()) {
                                        case 7:
                                            if (r_ != r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        case 8:
                                            if (r_ == r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        case 9:
                                            if (r_ >= r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        case 10:
                                            if (r_ < r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        case 11:
                                            if (r_ > r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        case 12:
                                            if (r_ <= r_2) {
                                                r_2 = 1;
                                            } else {
                                                r_2 = 0;
                                            }
                                            r_ = 1;
                                            break;
                                        default:
                                            throw new RuntimeException("Unexpected op");
                                    }
                                default:
                                    break;
                            }
                        }
                    }
                    switch (((abh) aah).FH()) {
                        case 6:
                            r_2 = ((aat) aah).r_();
                            switch (v5.j6()) {
                                case 7:
                                    if (r_2 == 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                case 8:
                                    if (r_2 != 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                case 9:
                                    if (r_2 < 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                case 10:
                                    if (r_2 >= 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                case 11:
                                    if (r_2 <= 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                case 12:
                                    if (r_2 > 0) {
                                        r_2 = 1;
                                    } else {
                                        r_2 = 0;
                                    }
                                    r_ = 1;
                                    break;
                                default:
                                    throw new RuntimeException("Unexpected op");
                            }
                    }
                }
            }
            aah2 = null;
            if (aah != null) {
            }
            switch (((abh) aah).FH()) {
                case 6:
                    r_ = ((aat) aah).r_();
                    r_2 = ((aat) aah2).r_();
                    switch (v5.j6()) {
                        case 7:
                            if (r_ != r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        case 8:
                            if (r_ == r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        case 9:
                            if (r_ >= r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        case 10:
                            if (r_ < r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        case 11:
                            if (r_ > r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        case 12:
                            if (r_ <= r_2) {
                                r_2 = 0;
                            } else {
                                r_2 = 1;
                            }
                            r_ = 1;
                            break;
                        default:
                            throw new RuntimeException("Unexpected op");
                    }
                default:
                    break;
            }
        }
        r_2 = 0;
        r_ = 0;
        acg QX = aci.QX();
        if (r_ != 0) {
            if (r_2 != 0) {
                r_2 = QX.tp().DW(1);
            } else {
                r_2 = QX.tp().DW(0);
            }
            j6((acg) this.j6.tp().get(r_2));
            this.tp.add(aci);
            return;
        }
        while (i < QX.tp().DW()) {
            j6((acg) this.j6.tp().get(QX.tp().DW(i)));
            i++;
        }
    }

    private aah j6(aci aci, int i) {
        aah aah;
        aah p_;
        int VH;
        int i2 = 0;
        zo Zo = aci.Zo();
        int j6 = aci.v5().j6();
        zx DW = aci.DW();
        int VH2 = DW.DW(0).VH();
        if (this.FH[VH2] != 1) {
            aah = null;
        } else {
            aah = this.Hw[VH2];
        }
        if (DW.m_() == 1) {
            p_ = ((zk) Zo).p_();
        } else {
            VH = DW.DW(1).VH();
            if (this.FH[VH] != 1) {
                p_ = null;
            } else {
                p_ = this.Hw[VH];
            }
        }
        if (aah == null || p_ == null) {
            return null;
        }
        switch (i) {
            case 6:
                VH2 = ((aat) aah).r_();
                VH = ((aat) p_).r_();
                switch (j6) {
                    case 14:
                        i2 = VH + VH2;
                        VH = 0;
                        break;
                    case 15:
                        if (DW.m_() != 1) {
                            i2 = VH2 - VH;
                            VH = 0;
                            break;
                        }
                        i2 = VH - VH2;
                        VH = 0;
                        break;
                    case 16:
                        i2 = VH * VH2;
                        VH = 0;
                        break;
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        if (VH != 0) {
                            i2 = VH2 / VH;
                            VH = 0;
                            break;
                        }
                        VH = 1;
                        break;
                    case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        if (VH != 0) {
                            i2 = VH2 % VH;
                            VH = 0;
                            break;
                        }
                        VH = 1;
                        break;
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        i2 = VH & VH2;
                        VH = 0;
                        break;
                    case 21:
                        i2 = VH | VH2;
                        VH = 0;
                        break;
                    case 22:
                        i2 = VH ^ VH2;
                        VH = 0;
                        break;
                    case 23:
                        i2 = VH2 << VH;
                        VH = 0;
                        break;
                    case 24:
                        i2 = VH2 >> VH;
                        VH = 0;
                        break;
                    case 25:
                        i2 = VH2 >>> VH;
                        VH = 0;
                        break;
                    default:
                        throw new RuntimeException("Unexpected op");
                }
                if (VH == 0) {
                    return aat.j6(i2);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void DW(aci r9) {
        /*
        r8 = this;
        r7 = 0;
        r3 = 1;
        r1 = r9.Zo();
        r0 = r1.Zo();
        r0 = r0.Hw();
        if (r0 != r3) goto L_0x001a;
    L_0x0010:
        r0 = r1.Zo();
        r0 = r0.v5();
        if (r0 == 0) goto L_0x001d;
    L_0x001a:
        r8.j6(r9);
    L_0x001d:
        r0 = r9.v5();
        r5 = r0.j6();
        r0 = r9.Ws();
        if (r0 != 0) goto L_0x0049;
    L_0x002b:
        r0 = 17;
        if (r5 == r0) goto L_0x0033;
    L_0x002f:
        r0 = 18;
        if (r5 != r0) goto L_0x005d;
    L_0x0033:
        r0 = r9.QX();
        r0 = r0.J0();
        r0 = r0.FH();
        r0 = r0.get(r7);
        r0 = (aci) r0;
        r0 = r0.Ws();
    L_0x0049:
        r6 = r0.VH();
        r4 = 2;
        r2 = 0;
        switch(r5) {
            case 2: goto L_0x0067;
            case 5: goto L_0x005e;
            case 14: goto L_0x0086;
            case 15: goto L_0x0086;
            case 16: goto L_0x0086;
            case 17: goto L_0x0086;
            case 18: goto L_0x0086;
            case 20: goto L_0x0086;
            case 21: goto L_0x0086;
            case 22: goto L_0x0086;
            case 23: goto L_0x0086;
            case 24: goto L_0x0086;
            case 25: goto L_0x0086;
            case 56: goto L_0x0092;
            default: goto L_0x0052;
        };
    L_0x0052:
        r0 = r2;
        r1 = r4;
    L_0x0054:
        r0 = r8.j6(r6, r1, r0);
        if (r0 == 0) goto L_0x005d;
    L_0x005a:
        r8.j6(r6, r1);
    L_0x005d:
        return;
    L_0x005e:
        r0 = r1;
        r0 = (zk) r0;
        r0 = r0.p_();
        r1 = r3;
        goto L_0x0054;
    L_0x0067:
        r0 = r9.DW();
        r0 = r0.m_();
        if (r0 != r3) goto L_0x0052;
    L_0x0071:
        r0 = r9.DW();
        r0 = r0.DW(r7);
        r0 = r0.VH();
        r1 = r8.FH;
        r1 = r1[r0];
        r2 = r8.Hw;
        r0 = r2[r0];
        goto L_0x0054;
    L_0x0086:
        r0 = r0.FH();
        r0 = r8.j6(r9, r0);
        if (r0 == 0) goto L_0x00a1;
    L_0x0090:
        r1 = r3;
        goto L_0x0054;
    L_0x0092:
        r0 = r8.FH;
        r0 = r0[r6];
        if (r0 != r3) goto L_0x0052;
    L_0x0098:
        r0 = r8.FH;
        r1 = r0[r6];
        r0 = r8.Hw;
        r0 = r0[r6];
        goto L_0x0054;
    L_0x00a1:
        r1 = r4;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: ace.DW(aci):void");
    }

    private void j6() {
        j6(this.j6.Hw());
        while (true) {
            if (this.v5.isEmpty() && this.Zo.isEmpty() && this.gn.isEmpty() && this.u7.isEmpty()) {
                DW();
                FH();
                return;
            }
            while (!this.v5.isEmpty()) {
                DW((acg) this.v5.remove(this.v5.size() - 1));
            }
            while (!this.Zo.isEmpty()) {
                FH((acg) this.Zo.remove(this.Zo.size() - 1));
            }
            while (!this.u7.isEmpty()) {
                aci aci = (aci) this.u7.remove(this.u7.size() - 1);
                if (this.VH.get(aci.QX().v5())) {
                    if (aci instanceof acb) {
                        j6((acb) aci);
                    } else {
                        DW(aci);
                    }
                }
            }
            while (!this.gn.isEmpty()) {
                aci = (aci) this.gn.remove(this.gn.size() - 1);
                if (this.VH.get(aci.QX().v5())) {
                    if (aci instanceof acb) {
                        j6((acb) aci);
                    } else {
                        DW(aci);
                    }
                }
            }
        }
    }

    private void DW() {
        int i = 0;
        while (i < this.DW) {
            if (this.FH[i] == 1 && (this.Hw[i] instanceof abh)) {
                aci FH = this.j6.FH(i);
                if (!FH.Ws().gn().Zo()) {
                    FH.DW(FH.Ws().j6((abh) this.Hw[i]));
                    for (aci aci : this.j6.Hw(i)) {
                        if (!aci.we()) {
                            abz abz = (abz) aci;
                            zx DW = aci.DW();
                            int FH2 = DW.FH(i);
                            abz.j6(FH2, DW.DW(FH2).j6((abh) this.Hw[i]));
                        }
                    }
                }
            }
            i++;
        }
    }

    private void FH() {
        Iterator it = this.tp.iterator();
        while (it.hasNext()) {
            aci aci = (aci) it.next();
            acg QX = aci.QX();
            int DW = QX.tp().DW();
            int i = 0;
            int i2 = -1;
            while (i < DW) {
                int DW2 = QX.tp().DW(i);
                if (this.VH.get(DW2)) {
                    DW2 = i2;
                }
                i++;
                i2 = DW2;
            }
            if (DW == 2 && i2 != -1) {
                QX.DW(new zu(aab.j3, aci.Zo().VH(), null, zx.j6));
                QX.DW(i2);
            }
        }
    }
}
