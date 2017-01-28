import com.aide.uidesigner.ProxyTextView;
import java.util.List;

public class at {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private final ap Zo;
    private final ba j6;
    private final cl v5;

    public at(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.cb;
        this.v5 = baVar.sh;
        this.Zo = baVar.j6;
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, String str, String str2) {
        String toLowerCase = str.toLowerCase();
        this.j6.rN.DW();
        List lg = bvVar.lg();
        for (int min = Math.min(i3, lg.size() - 1); min >= i; min--) {
            String toLowerCase2 = ((String) lg.get(min)).toLowerCase();
            int length = toLowerCase2.length();
            while (length > 0) {
                int lastIndexOf = toLowerCase2.lastIndexOf(toLowerCase, length);
                if (lastIndexOf >= 0) {
                    this.j6.rN.j6(bvVar, min, lastIndexOf + 1, min, (toLowerCase.length() + lastIndexOf) + 1, str2);
                }
                length = lastIndexOf - 1;
            }
        }
        this.j6.rN.Hw();
    }

    public void j6(bv bvVar, String str) {
        this.j6.rN.DW();
        if (bvVar.Mr()) {
            try {
                j6(bvVar.Zo(), j6(bvVar), this.DW.j6(str));
            } catch (ej e) {
                this.j6.rN.j6(bvVar, str);
            }
        } else if (bvVar.FH()) {
            bp bpVar;
            dq FH = this.j6.cb.FH(bvVar);
            FH.j6.j6();
            while (FH.j6.DW()) {
                bpVar = (bp) FH.j6.FH();
                if (bpVar.aq() == bvVar.Zo()) {
                    break;
                }
            }
            bpVar = null;
            if (bpVar != null) {
                if (str.lastIndexOf(46) > 0) {
                    str = str.substring(0, str.lastIndexOf(46));
                }
                j6(bvVar.Zo(), bpVar, this.DW.j6(str), false);
            } else {
                this.j6.rN.j6(bvVar, str);
            }
        } else {
            this.j6.rN.j6(bvVar, str);
        }
        this.j6.rN.Hw();
    }

    public void j6(bv bvVar, int i, int i2) {
        eb ebVar = new eb(this.FH);
        ebVar.j6(this.FH.Hw());
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            int gW = DW.gW(gn);
            DW.tp().u7().DW(DW, gn);
            bs QX;
            bs QX2;
            switch (DW.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 32:
                    this.j6.rN.j6("variable " + this.DW.j6(gW), this.DW.j6(gW), true, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                    this.j6.rN.j6("label " + this.DW.j6(gW), this.DW.j6(gW), true, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                    return;
                case 6:
                    boolean z = false;
                    this.j6.rN.j6("package " + DW.QX(gn).iW(), this.DW.j6(gW), z, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                    return;
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    QX = DW.QX(gn);
                    if (ebVar.FH(QX.tp()) || QX.tp() == bvVar) {
                        this.j6.rN.j6("class " + QX.iW(), this.DW.j6(gW), false, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                        return;
                    }
                    this.j6.rN.DW("This class is defined outside of the project.");
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                    this.j6.rN.j6("parametertype " + DW.QX(gn).iW(), this.DW.j6(gW), true, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                    return;
                case 15:
                case 16:
                    QX2 = DW.QX(gn);
                    if (ebVar.FH(QX2.tp()) || QX2.tp() == bvVar) {
                        this.j6.rN.j6("field " + QX2.iW(), this.DW.j6(gW), ((bz) QX2).kf(), bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                        return;
                    } else {
                        this.j6.rN.DW("This field is defined outside of the project.");
                        return;
                    }
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    QX2 = DW.QX(gn);
                    if (ebVar.FH(QX2.tp()) || bvVar == QX2.tp()) {
                        this.j6.rN.j6("method " + QX2.iW(), this.DW.j6(gW), ((bz) QX2).kf(), bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                        return;
                    } else {
                        this.j6.rN.DW("This method is defined outside of the project.");
                        return;
                    }
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    QX = DW.QX(gn);
                    if (ebVar.FH(QX.tp()) || QX.tp() == bvVar) {
                        this.j6.rN.j6("class " + ((bz) QX).Xa().iW(), this.DW.j6(gW), false, bvVar.er(), DW.nw(gn), DW.KD(gn), DW.ro(gn));
                        return;
                    }
                    this.j6.rN.DW("This class is defined outside of the project.");
                    return;
                default:
                    this.j6.rN.DW("Select a symbol in the code to be renamed.");
                    return;
            }
        }
        this.j6.rN.DW("Select a symbol in the code to be renamed.");
        this.v5.j6(DW);
    }

    public void j6(bv bvVar, int i, int i2, String str) {
        cj DW = this.j6.sh.DW(bvVar, i, i2);
        int gn = DW.gn(i, i2);
        if (gn != -1) {
            this.j6.rN.DW();
            int gW = DW.gW(gn);
            DW.tp().u7().DW(DW, gn);
            switch (DW.J8(gn)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 32:
                    j6(DW, gW, DW.Ws(gn), this.DW.j6(str));
                    this.j6.rN.Hw();
                    return;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                    int Ws = DW.Ws(gn);
                    DW.tp().u7().j6(DW, gW);
                    j6(DW, DW.Ws(), bvVar, gW, Ws, str);
                    this.j6.rN.Hw();
                    return;
                case 6:
                    j6(gW, (ce) DW.QX(gn), this.DW.j6(str));
                    this.j6.rN.Hw();
                    return;
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    j6(gW, (bp) DW.QX(gn), this.DW.j6(str), true);
                    this.j6.rN.Hw();
                    return;
                case 11:
                case 12:
                case 13:
                case 14:
                    bs QX = DW.QX(gn);
                    DW.tp().u7().j6(DW, gW);
                    j6(DW, DW.Ws(), bvVar, gW, QX, str);
                    this.j6.rN.Hw();
                    return;
                case 15:
                case 16:
                    DW(gW, (bz) DW.QX(gn), this.DW.j6(str), false);
                    this.j6.rN.Hw();
                    return;
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    j6(gW, (bz) DW.QX(gn), this.DW.j6(str), false);
                    this.j6.rN.Hw();
                    return;
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    j6(gW, ((bz) DW.QX(gn)).Xa(), this.DW.j6(str), true);
                    this.j6.rN.Hw();
                    return;
                default:
                    return;
            }
        }
        this.v5.j6(DW);
    }

    private void j6(cj cjVar, ck ckVar, int i, bv bvVar, int i2, bs bsVar, int i3) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, ckVar, cjVar.Hw(i, lg), bvVar, i2, bsVar, i3);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    if (bsVar != cjVar.QX(i)) {
                        return;
                    }
                    if (cjVar.nw(i) == 0) {
                        j6("Code in included files will not be changed.", cjVar.we(), 1, 1);
                        return;
                    }
                    this.j6.rN.j6(bvVar, ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                    ckVar.j6(ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                default:
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, int i2, int i3, String str) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg), bvVar, i2, i3, str);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 5:
                    if (i3 == cjVar.Ws(i) && cjVar.nw(i) > 0) {
                        this.j6.rN.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), str);
                    }
                default:
            }
        }
    }

    private void j6(cj cjVar, int i, bv bvVar, int i2, bs bsVar, String str) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, cjVar.Hw(i, lg), bvVar, i2, bsVar, str);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case 11:
                case 12:
                case 13:
                case 14:
                    if (bsVar == cjVar.QX(i) && cjVar.nw(i) > 0) {
                        this.j6.rN.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), str);
                    }
                default:
            }
        }
    }

    private void j6(int i, bp bpVar, int i2, boolean z) {
        ck ckVar = new ck();
        ea eaVar = new ea(this.Hw);
        eaVar.j6((bs) bpVar);
        if (bpVar.ef()) {
            eaVar.j6(bpVar.aM());
        }
        List<cj> j6 = this.v5.j6(bpVar.tp());
        ckVar.j6();
        ckVar.j6((List) j6);
        for (cj cjVar : j6) {
            cjVar.tp().u7().j6(cjVar, i);
            j6(cjVar, ckVar, cjVar.Ws(), bpVar.tp(), i, eaVar, i2);
            this.v5.j6(cjVar);
        }
        if (!bpVar.kf()) {
            this.Zo.DW(i);
            while (true) {
                bv FH = this.Zo.FH();
                if (FH == null) {
                    break;
                } else if (FH != bpVar.tp()) {
                    if (this.j6.P8.FH()) {
                        break;
                    }
                    j6 = this.v5.j6(FH);
                    ckVar.j6();
                    ckVar.j6((List) j6);
                    for (cj cjVar2 : j6) {
                        cjVar2.tp().u7().j6(cjVar2, i);
                        j6(cjVar2, ckVar, cjVar2.Ws(), FH, i, eaVar, i2);
                        this.v5.j6(cjVar2);
                    }
                }
            }
        }
        if (bpVar.hz()) {
            if (i == bpVar.tp().Zo()) {
                this.j6.rN.j6(bpVar.tp(), this.DW.j6(i2) + bpVar.tp().Hw());
            }
        } else if (bpVar.Xa().ko().j6(i2)) {
            bp bpVar2 = (bp) bpVar.Xa().ko().FH(i2);
            j6("There already is a class with that name.", bpVar2.tp(), bpVar2.er(), bpVar2.gW());
        }
    }

    private void j6(cj cjVar, ck ckVar, int i, bv bvVar, int i2, ea<bp> eaVar, int i3) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, ckVar, cjVar.Hw(i, lg), bvVar, i2, (ea) eaVar, i3);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case 7:
                case 8:
                case 9:
                case 10:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                    if (!eaVar.FH(cjVar.QX(i))) {
                        return;
                    }
                    if (cjVar.nw(i) == 0) {
                        j6("Code in included files will not be changed.", cjVar.we(), 1, 1);
                        return;
                    }
                    this.j6.rN.j6(bvVar, ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                    ckVar.j6(ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                    if (!eaVar.FH(((bz) cjVar.QX(i)).Xa())) {
                        return;
                    }
                    if (cjVar.nw(i) == 0) {
                        j6("Code in included files will not be changed.", cjVar.we(), 1, 1);
                        return;
                    }
                    this.j6.rN.j6(bvVar, ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                    ckVar.j6(ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i3));
                default:
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(int r10, ce r11, int r12) {
        /*
        r9 = this;
        r2 = new ck;
        r2.<init>();
        r0 = r9.Zo;
        r0.DW(r10);
    L_0x000a:
        r0 = r9.Zo;
        r4 = r0.FH();
        if (r4 == 0) goto L_0x001c;
    L_0x0012:
        r0 = r9.j6;
        r0 = r0.P8;
        r0 = r0.FH();
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = new eb;
        r1 = r9.FH;
        r0.<init>(r1);
        r9.j6(r11, r11, r12, r0);
        return;
    L_0x0027:
        r0 = r9.v5;
        r0 = r0.j6(r4);
        r2.j6();
        r2.j6(r0);
        r8 = r0.iterator();
    L_0x0037:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x000a;
    L_0x003d:
        r1 = r8.next();
        r1 = (cj) r1;
        r0 = r1.tp();
        r0 = r0.u7();
        r0.j6(r1, r10);
        r3 = r1.Ws();
        r0 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        r0.j6(r1, r2, r3, r4, r5, r6, r7);
        r0 = r9.v5;
        r0.j6(r1);
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: at.j6(int, ce, int):void");
    }

    private ce j6(bv bvVar) {
        eb ebVar = new eb(this.FH);
        ebVar.j6(this.j6.cn.Hw());
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            bv FH = ebVar.j6.FH();
            if (bvVar == FH.u7()) {
                dq FH2 = this.Hw.FH(FH);
                FH2.j6.j6();
                while (FH2.j6.DW()) {
                    if (FH.u7().v5().equals(((bp) FH2.j6.FH()).rN().iW())) {
                    }
                }
            }
        }
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            bv FH3 = ebVar.j6.FH();
            if (bvVar.FH(FH3)) {
                dq FH4 = this.Hw.FH(FH3);
                FH4.j6.j6();
                while (FH4.j6.DW()) {
                    ce rN = ((bp) FH4.j6.FH()).rN();
                    bv u7 = FH3.u7();
                    while (rN != this.Hw.Zo() && u7.Zo() == rN.aq()) {
                        if (u7 == bvVar) {
                            return rN;
                        }
                        u7 = u7.u7();
                        rN = rN.FH();
                    }
                }
                continue;
            }
        }
        throw new ej();
    }

    private void j6(ce ceVar, ce ceVar2, int i, eb ebVar) {
        eb u7 = ceVar.u7();
        u7.j6.j6();
        while (u7.j6.DW()) {
            bv FH = u7.j6.FH();
            if (FH.DW()) {
                dq FH2 = this.Hw.FH(FH);
                FH2.j6.j6();
                while (FH2.j6.DW()) {
                    ce ceVar3;
                    bv bvVar;
                    ce rN = ((bp) FH2.j6.FH()).rN();
                    bv u72 = FH.u7();
                    if (ebVar.FH(u72) || !u72.v5().equals(rN.iW())) {
                        bv bvVar2 = u72;
                        ceVar3 = rN;
                        bvVar = bvVar2;
                    } else {
                        String str;
                        String str2 = "";
                        ce ceVar4 = rN;
                        while (ceVar4 != ceVar2 && ceVar4 != this.Hw.Zo()) {
                            str = '.' + this.DW.j6(ceVar4.aq()) + str2;
                            ceVar4 = ceVar4.FH();
                            str2 = str;
                        }
                        str = ceVar2.FH().iW();
                        if (str.length() != 0) {
                            str = str + '.';
                        }
                        str = str + this.DW.j6(i) + str2;
                        if (!str.equals(u72.v5())) {
                            j6(u72, str, ebVar);
                        }
                        ebVar.j6(u72);
                        bvVar = u72;
                        ceVar3 = ceVar4;
                    }
                    while (ceVar3 != this.Hw.Zo() && bvVar.Zo() == ceVar3.aq()) {
                        if (ceVar3 != ceVar2) {
                            bvVar = bvVar.u7();
                            ceVar3 = ceVar3.FH();
                        } else if (!ebVar.FH(bvVar)) {
                            j6(bvVar, this.DW.j6(i), ebVar);
                            ebVar.j6(bvVar);
                        }
                    }
                }
            }
        }
        ea VH = ceVar.VH();
        VH.j6.j6();
        while (VH.j6.DW()) {
            j6((ce) VH.j6.FH(), ceVar2, i, ebVar);
        }
    }

    private void j6(bv bvVar, String str, eb ebVar) {
        ebVar.j6.j6();
        while (ebVar.j6.DW()) {
            if (ebVar.j6.FH().FH(bvVar)) {
                return;
            }
        }
        this.j6.rN.j6(bvVar, str);
    }

    private void j6(cj cjVar, int i, int i2, int i3) {
        ec ecVar = new ec();
        ecVar.j6(i);
        ecVar.j6(i3);
        cjVar.tp().u7().j6(cjVar, ecVar);
        DW(cjVar, cjVar.Ws(), cjVar.we(), i, i2, this.DW.j6(i3));
    }

    private void DW(cj cjVar, int i, bv bvVar, int i2, int i3, String str) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            DW(cjVar, cjVar.Hw(i, lg), bvVar, i2, i3, str);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 32:
                    if (i3 == cjVar.Ws(i) && cjVar.nw(i) > 0) {
                        this.j6.rN.j6(bvVar, cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), str);
                    }
                default:
            }
        }
    }

    private void j6(int i, bz bzVar, int i2, boolean z) {
        ck ckVar = new ck();
        eb ebVar = new eb(this.FH);
        ebVar.j6(this.FH.Hw());
        ea j6 = j6(bzVar);
        j6(j6, ebVar, i2);
        bv tp = bzVar.tp();
        List<cj> j62 = this.v5.j6(tp);
        ckVar.j6();
        ckVar.j6((List) j62);
        for (cj cjVar : j62) {
            cjVar.tp().u7().j6(cjVar, i);
            j6(cjVar, ckVar, cjVar.Ws(), tp, i2, j6, z);
            this.v5.j6(cjVar);
        }
        if (!bzVar.kf()) {
            this.Zo.DW(i);
            while (true) {
                tp = this.Zo.FH();
                if (tp == null) {
                    return;
                }
                if (tp != bzVar.tp()) {
                    if (!this.j6.P8.FH()) {
                        j62 = this.v5.j6(tp);
                        ckVar.j6();
                        ckVar.j6((List) j62);
                        for (cj cjVar2 : j62) {
                            cjVar2.tp().u7().j6(cjVar2, i);
                            j6(cjVar2, ckVar, cjVar2.Ws(), tp, i2, j6, z);
                            this.v5.j6(cjVar2);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void j6(ea<bz> eaVar, eb ebVar, int i) {
        eaVar.j6.j6();
        while (eaVar.j6.DW()) {
            bz bzVar = (bz) eaVar.j6.FH();
            if (!ebVar.FH(bzVar.tp())) {
                j6("There is an overridden method, which is defined outside the project.", bzVar.tp(), bzVar.er(), bzVar.gW());
            }
            dr lp = bzVar.Xa().lp();
            lp.j6.j6(i);
            while (lp.j6.DW()) {
                bz bzVar2 = (bz) lp.j6.Hw();
                if (bzVar2.lp() == bzVar.lp()) {
                    j6("There already is a method with that name.", bzVar2.tp(), bzVar2.er(), bzVar2.gW());
                }
            }
        }
    }

    private ea<bz> j6(bz bzVar) {
        ea j6 = j6(bzVar.aq(), bzVar.lp());
        ea eaVar = new ea(this.Hw);
        eaVar.j6((bs) bzVar);
        ea eaVar2 = new ea(this.Hw);
        while (true) {
            eaVar.j6.j6();
            while (eaVar.j6.DW()) {
                bs bsVar = (bz) eaVar.j6.FH();
                eaVar2.j6(bsVar);
                eaVar2.j6(bsVar.cb());
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs bsVar2 = (bz) j6.j6.FH();
                    if (bsVar2.ef().FH(bsVar)) {
                        eaVar2.j6(bsVar2);
                    }
                }
            }
            if (eaVar.Hw() == eaVar2.Hw()) {
                return eaVar2;
            }
            eaVar.j6();
            eaVar.j6(eaVar2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ea<bz> j6(int r8, int r9) {
        /*
        r7 = this;
        r5 = new ea;
        r0 = r7.Hw;
        r5.<init>(r0);
        r0 = r7.Zo;
        r0.j6(r8);
    L_0x000c:
        r0 = r7.Zo;
        r0 = r0.DW();
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        r1 = r7.j6;
        r1 = r1.P8;
        r1 = r1.FH();
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        return r5;
    L_0x001f:
        r1 = r7.v5;
        r0 = r1.j6(r0);
        r6 = r0.iterator();
    L_0x0029:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x000c;
    L_0x002f:
        r1 = r6.next();
        r1 = (cj) r1;
        r2 = r1.Ws();
        r0 = r7;
        r3 = r8;
        r4 = r9;
        r0.j6(r1, r2, r3, r4, r5);
        r0 = r7.v5;
        r0.j6(r1);
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: at.j6(int, int):ea<bz>");
    }

    private void j6(cj cjVar, int i, int i2, int i3, ea<bz> eaVar) {
        int lg = cjVar.lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            j6(cjVar, cjVar.Hw(i, i4), i2, i3, eaVar);
        }
        if (cjVar.ca(i)) {
            try {
                bs DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (!DW.sy() && this.j6.ro.FH(DW.aq()) == this.j6.ro.FH(i2) && DW.lp() == i3) {
                    eaVar.j6(DW);
                }
            } catch (ej e) {
            }
        }
    }

    private void DW(int i, bz bzVar, int i2, boolean z) {
        ck ckVar = new ck();
        eb ebVar = new eb(this.FH);
        ebVar.j6(this.FH.Hw());
        ea DW = DW(bzVar);
        DW(DW, ebVar, i2);
        bv tp = bzVar.tp();
        List<cj> j6 = this.v5.j6(tp);
        ckVar.j6();
        ckVar.j6((List) j6);
        for (cj cjVar : j6) {
            cjVar.tp().u7().j6(cjVar, i);
            j6(cjVar, ckVar, cjVar.Ws(), tp, i2, DW, z);
            this.v5.j6(cjVar);
        }
        if (!bzVar.kf()) {
            this.Zo.DW(i);
            while (true) {
                tp = this.Zo.FH();
                if (tp == null) {
                    return;
                }
                if (tp != bzVar.tp()) {
                    if (!this.j6.P8.FH()) {
                        j6 = this.v5.j6(tp);
                        ckVar.j6();
                        ckVar.j6((List) j6);
                        for (cj cjVar2 : j6) {
                            cjVar2.tp().u7().j6(cjVar2, i);
                            j6(cjVar2, ckVar, cjVar2.Ws(), tp, i2, DW, z);
                            this.v5.j6(cjVar2);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private ea<bz> DW(bz bzVar) {
        ea j6 = j6(bzVar.aq());
        ea eaVar = new ea(this.Hw);
        eaVar.j6((bs) bzVar);
        ea eaVar2 = new ea(this.Hw);
        while (true) {
            eaVar.j6.j6();
            while (eaVar.j6.DW()) {
                bs bsVar = (bz) eaVar.j6.FH();
                eaVar2.j6(bsVar);
                eaVar2.j6(bsVar.cb());
                j6.j6.j6();
                while (j6.j6.DW()) {
                    bs bsVar2 = (bz) j6.j6.FH();
                    if (bsVar2.ef().FH(bsVar)) {
                        eaVar2.j6(bsVar2);
                    }
                    if (bsVar2.Xa() == bsVar.Xa()) {
                        eaVar2.j6(bsVar2);
                    }
                }
            }
            if (eaVar.Hw() == eaVar2.Hw()) {
                return eaVar2;
            }
            eaVar.j6();
            eaVar.j6(eaVar2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ea<bz> j6(int r5) {
        /*
        r4 = this;
        r1 = new ea;
        r0 = r4.Hw;
        r1.<init>(r0);
        r0 = r4.Zo;
        r0.j6(r5);
    L_0x000c:
        r0 = r4.Zo;
        r0 = r0.DW();
        if (r0 == 0) goto L_0x001e;
    L_0x0014:
        r2 = r4.j6;
        r2 = r2.P8;
        r2 = r2.FH();
        if (r2 == 0) goto L_0x001f;
    L_0x001e:
        return r1;
    L_0x001f:
        r2 = r4.v5;
        r0 = r2.j6(r0);
        r2 = r0.iterator();
    L_0x0029:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x000c;
    L_0x002f:
        r0 = r2.next();
        r0 = (cj) r0;
        r3 = r0.Ws();
        r4.j6(r0, r3, r5, r1);
        r3 = r4.v5;
        r3.j6(r0);
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: at.j6(int):ea<bz>");
    }

    private void j6(cj cjVar, int i, int i2, ea<bz> eaVar) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3), i2, (ea) eaVar);
        }
        if (cjVar.x9(i)) {
            try {
                bs DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                if (this.j6.ro.FH(DW.aq()) == this.j6.ro.FH(i2)) {
                    eaVar.j6(DW);
                }
            } catch (ej e) {
            }
        }
    }

    private void DW(ea<bz> eaVar, eb ebVar, int i) {
        if (eaVar.Hw() == 1) {
            j6((bz) eaVar.DW(), i);
        }
    }

    private void j6(bz bzVar, int i) {
        dr sy = bzVar.Xa().sy();
        if (sy.j6(i)) {
            bz bzVar2 = (bz) sy.FH(i);
            j6("There already is a field with that name.", bzVar2.tp(), bzVar2.er(), bzVar2.gW());
        }
    }

    private void j6(cj cjVar, ck ckVar, int i, bv bvVar, int i2, ea<? extends bs> eaVar, boolean z) {
        for (int lg = cjVar.lg(i) - 1; lg >= 0; lg--) {
            j6(cjVar, ckVar, cjVar.Hw(i, lg), bvVar, i2, (ea) eaVar, z);
        }
        if (cjVar.sy(i) && !cjVar.er(i)) {
            switch (cjVar.J8(i)) {
                case 15:
                case 16:
                case 19:
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    if (!eaVar.FH(cjVar.QX(i))) {
                        return;
                    }
                    if (z) {
                        if (cjVar.nw(i) > 0) {
                            this.j6.rN.DW(bvVar, ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i));
                        }
                    } else if (cjVar.nw(i) == 0) {
                        j6("Code in included files will not be changed.", cjVar.we(), 1, 1);
                    } else {
                        this.j6.rN.j6(bvVar, ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i2));
                        ckVar.j6(ckVar.DW(cjVar, i), ckVar.FH(cjVar, i), ckVar.Hw(cjVar, i), ckVar.v5(cjVar, i), this.DW.j6(i2));
                    }
                default:
            }
        }
    }

    private void j6(String str, bv bvVar, int i, int i2) {
        this.j6.rN.j6(bvVar.er() + ":" + i + ":" + i2 + "\n    " + str);
    }
}
