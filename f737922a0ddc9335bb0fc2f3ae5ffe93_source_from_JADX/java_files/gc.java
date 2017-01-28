import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;
import java.util.List;

public class gc {
    private final by DW;
    private final bw FH;
    private final bt Hw;
    private List<String> VH;
    private final gv Zo;
    private final cc j6;
    private final cl v5;

    public gc(cc ccVar, gv gvVar) {
        int i = 0;
        this.j6 = ccVar;
        this.DW = ccVar.ro;
        this.FH = ccVar.cn;
        this.Hw = ccVar.cb;
        this.v5 = ccVar.sh;
        this.Zo = gvVar;
        this.VH = new ArrayList();
        String[] strArr = new String[]{"else", "finally", "catch", "private", "public", "protected"};
        int length = strArr.length;
        while (i < length) {
            this.VH.add(strArr[i]);
            i++;
        }
    }

    private void DW(bv bvVar, int i, int i2, String str, int i3) {
        if (str.length() > i3 - 2 && i3 - 2 >= 0) {
            char charAt = str.charAt(i3 - 2);
            if (charAt == '.' || Character.isJavaIdentifierPart(charAt)) {
                j6(bvVar, i, i2, str, i3);
            }
        }
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3, int i4, boolean z) {
        if (i4 == -1) {
            DW(bvVar, i, i2, str, i3);
        } else if (str.length() >= i3 - 1) {
            int i5 = i4 - 1;
            while (i5 < str.length()) {
                if (Character.isJavaIdentifierPart(str.charAt(i5))) {
                    i5++;
                } else if (i5 + 1 < i3) {
                    this.j6.lg.j6(bvVar);
                    DW(bvVar, i, i2, str, i3);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        if (i3 == -1) {
            DW(cjVar, i, i2);
            return;
        }
        String DW = cjVar.we().DW(i);
        if (DW.length() >= i2 - 1) {
            if (this.VH.contains(j6(DW.substring(0, i2 - 1)))) {
                this.j6.lg.j6(cjVar.we());
                return;
            }
            int i4 = i3 - 1;
            while (i4 < DW.length()) {
                if (Character.isJavaIdentifierPart(DW.charAt(i4))) {
                    i4++;
                } else if (i4 + 1 < i2) {
                    this.j6.lg.j6(cjVar.we());
                    DW(cjVar, i, i2);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void DW(cj cjVar, int i, int i2) {
        String DW = cjVar.we().DW(i);
        if (DW.length() >= i2 - 1) {
            String substring = DW.substring(0, i2 - 1);
            DW = DW.substring(i2 - 1, DW.length());
            if (substring.length() > 0) {
                char charAt = substring.charAt(substring.length() - 1);
                if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                    return;
                }
                if (DW.length() <= 0 || !Character.isJavaIdentifierPart(charAt) || !Character.isJavaIdentifierPart(DW.charAt(0))) {
                    DW = j6(substring);
                    if (!this.VH.contains(DW)) {
                        if (DW.length() <= 0 || Character.isJavaIdentifierStart(DW.charAt(0))) {
                            j6(cjVar, i, i2);
                        }
                    }
                }
            }
        }
    }

    private String j6(String str) {
        int length = str.length() - 1;
        while (length >= 0 && Character.isJavaIdentifierPart(str.charAt(length))) {
            length--;
        }
        if (length == str.length() - 1) {
            return "";
        }
        return str.substring(length + 1, str.length());
    }

    public void j6(bv bvVar, int i, int i2) {
        this.j6.lg.j6();
        dr j6 = this.Hw.j6(bvVar, this.Zo);
        j6.j6.j6();
        while (j6.j6.DW()) {
            bs bsVar = (bp) j6.j6.Hw();
            if (DW(this.DW.j6(j6.j6.FH()))) {
                this.j6.lg.DW(bsVar);
            }
        }
        this.j6.lg.j6(bvVar, this.Zo, i, i2, v5(bvVar, i, i2), false, true);
    }

    private int v5(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        int length = j6.length() + 1;
        while (length - 2 >= 0 && Character.isJavaIdentifierPart(j6.charAt(length - 2))) {
            length--;
        }
        return length;
    }

    private int j6(String str, int i) {
        while (i - 2 >= 0 && Character.isJavaIdentifierPart(str.charAt(i - 2))) {
            i--;
        }
        return i;
    }

    private boolean DW(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (!Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void DW(bv bvVar, int i, int i2) {
        this.j6.lg.j6();
        cj DW = this.v5.DW(bvVar, this.Zo);
        int Zo = DW.Zo(i, i2, i, i2);
        if (Zo != -1) {
            j6(DW, Zo);
        }
        this.j6.lg.j6(bvVar, this.Zo, i, i2, v5(bvVar, i, i2), true, false);
    }

    private void j6(cj cjVar, int i) {
        cjVar.tp().u7().j6(cjVar);
        try {
            bp j6 = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(i)));
            dr lp = j6.lp();
            lp.j6.j6();
            while (lp.j6.DW()) {
                bs bsVar = (bz) lp.j6.Hw();
                if ((cd.VH(bsVar.Ev()) || cd.v5(bsVar.Ev()) || cd.XL(bsVar.Ev())) && bsVar.Xa() != j6) {
                    this.j6.lg.j6(bsVar, j6.j3());
                }
            }
            ea dx = j6.Qq().dx();
            dx.j6.j6();
            while (dx.j6.DW()) {
                if (((bz) dx.j6.FH()).Q6()) {
                }
            }
        } catch (ej e) {
        }
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3) {
        j6(this.v5.j6(bvVar, this.Zo, i, i2, str, i3), i, i2 + i3, j6(str, i3));
    }

    public void j6(cj cjVar, int i, int i2) {
        j6(cjVar, i, i2, v5(cjVar.we(), i, i2));
    }

    private void j6(cj cjVar, int i, int i2, int i3) {
        int i4;
        int i5 = 3;
        bv we = cjVar.we();
        this.j6.lg.j6();
        ((gb) cjVar.tp().u7()).DW(cjVar);
        int gn = cjVar.gn(i, i2);
        if (gn != -1) {
            int aM = cjVar.aM(gn);
            switch (cjVar.rN(aM)) {
                case 155:
                case 159:
                    if (cjVar.J0(cjVar.Hw(aM, 0))) {
                        bp FH = FH(cjVar, aM);
                        co we2 = cjVar.we(cjVar.Hw(aM, 0));
                        this.j6.lg.j6((bs) we2);
                        j6(cjVar, we2, we2, FH, true);
                        j6(cjVar, cjVar.Ws(), i, i2, new ec());
                    } else {
                        j6(cjVar, i, i2, true);
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
                case 156:
                    if (cjVar.Hw(aM, 0) == gn) {
                        j6(cjVar, i, i2, true);
                    } else {
                        i5 = cjVar.lg(aM);
                        i4 = 0;
                        while (i4 < i5 - 3) {
                            if (gn == cjVar.Hw(aM, i4)) {
                                DW(cjVar, cjVar.Hw(aM, i4 - 2), i, i2, true);
                            } else {
                                i4++;
                            }
                        }
                        DW(cjVar, cjVar.Hw(aM, i5 - 5), i, i2, true);
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    if (cjVar.Hw(aM, 0) == gn) {
                        j6(cjVar, i, i2, true);
                    } else {
                        i5 = cjVar.lg(aM);
                        i4 = 0;
                        while (i4 < i5) {
                            if (gn == cjVar.Hw(aM, i4)) {
                                DW(cjVar, cjVar.Hw(aM, i4 - 2), i, i2, true);
                            } else {
                                i4++;
                            }
                        }
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
                case 180:
                    if (cjVar.rN(cjVar.aM(aM)) == 176 && cjVar.lg(cjVar.aM(aM)) == 4 && aM == cjVar.Hw(cjVar.aM(aM), 2) && cjVar.Hw(aM, 0) == gn) {
                        i4 = cjVar.Zo(i, i2, i, i2);
                        try {
                            bp j6 = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(i4)));
                            if (this.j6.lg.j6(cjVar, j6)) {
                                j6(cjVar, j6, i4);
                            }
                        } catch (ej e) {
                        }
                    } else if (cjVar.Hw(aM, 0) == gn) {
                        j6(cjVar, i, i2, true);
                    } else {
                        int lg = cjVar.lg(aM);
                        i4 = 3;
                        while (i4 < lg) {
                            if (gn == cjVar.Hw(aM, i4)) {
                                DW(cjVar, cjVar.Hw(aM, i4 - 3), i, i2, true);
                            } else {
                                i4++;
                            }
                        }
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
                case 213:
                case 214:
                    if (cjVar.Hw(aM, 2) == gn) {
                        j6(cjVar, i, i2, true);
                    } else {
                        i5 = cjVar.lg(aM);
                        i4 = 4;
                        while (i4 < i5) {
                            if (gn == cjVar.Hw(aM, i4)) {
                                DW(cjVar, cjVar.Hw(aM, i4 - 2), i, i2, true);
                            } else {
                                i4++;
                            }
                        }
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
                case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
                case 226:
                    if (cjVar.Hw(aM, 1) == gn) {
                        j6(cjVar, i, i2, true);
                    } else {
                        i4 = cjVar.lg(aM);
                        while (i5 < i4) {
                            if (gn == cjVar.Hw(aM, i5)) {
                                DW(cjVar, cjVar.Hw(aM, i5 - 2), i, i2, true);
                            } else {
                                i5++;
                            }
                        }
                    }
                    this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
                    return;
            }
        }
        i4 = cjVar.EQ(i, i2);
        if (i4 == -1 || cjVar.rN(i4) != 2) {
            j6(cjVar, i, i2, true);
            this.j6.lg.j6(we, this.Zo, i, i2, i3, false, false);
        }
    }

    private void DW(cj cjVar, int i, int i2, int i3, boolean z) {
        bp FH;
        co we;
        switch (cjVar.J8(i)) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                if (cjVar.J0(i)) {
                    FH = FH(cjVar, i);
                    we = cjVar.we(i);
                    this.j6.lg.j6((bs) we);
                    j6(cjVar, we, we, FH, true);
                    if (z) {
                        j6(cjVar, cjVar.Ws(), i2, i3, new ec());
                        return;
                    }
                    return;
                }
                j6(cjVar, i2, i3, z);
            case 6:
                ce ceVar = (ce) cjVar.QX(i);
                this.j6.lg.j6((bs) ceVar);
                j6(cjVar, ceVar, this.Hw.Zo());
            case 8:
            case 9:
            case 10:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                bp FH2 = FH(cjVar, i);
                bs bsVar = (bp) cjVar.QX(i);
                if (FH2 != null && bsVar.cT()) {
                    this.j6.lg.j6(bsVar);
                    DW(cjVar, bsVar, bsVar, FH2);
                }
            case 16:
                if (cjVar.J0(i)) {
                    FH = FH(cjVar, i);
                    we = cjVar.we(i);
                    this.j6.lg.j6((bs) we);
                    bz bzVar = (bz) cjVar.QX(i);
                    j6(cjVar, we, we, FH, true);
                    if (z) {
                        j6(cjVar, cjVar.Ws(), i2, i3, new ec());
                        return;
                    }
                    return;
                }
                j6(cjVar, i2, i3, z);
            default:
                j6(cjVar, i2, i3, z);
        }
    }

    private void j6(cj cjVar, co coVar, co coVar2, bp bpVar, boolean z) {
        try {
            if (coVar.cT()) {
                j6(cjVar, (bp) coVar, coVar2, bpVar);
                if (z) {
                    DW(cjVar, (bp) coVar, coVar2, bpVar);
                }
            } else if (coVar.AL()) {
                j6(cjVar, ((hc) cjVar.tp().VH()).Zo(cjVar.we()), coVar2, bpVar);
                if (z) {
                    DW(cjVar, ((hc) cjVar.tp().VH()).Zo(cjVar.we()), coVar2, bpVar);
                }
                this.j6.lg.FH("length");
            } else if (coVar.a_() != coVar) {
                j6(cjVar, coVar.a_(), coVar2, bpVar, z);
            }
        } catch (ej e) {
        }
    }

    private void j6(cj cjVar, bp bpVar, co coVar, bp bpVar2) {
        boolean z;
        dr sy = bpVar.sy();
        sy.j6.j6();
        while (sy.j6.DW()) {
            bs bsVar = (bz) sy.j6.Hw();
            if (bsVar.j6(bpVar2, bpVar2) && !cd.aM(bsVar.Ev())) {
                cr crVar = this.j6.lg;
                if (bsVar.Xa() != bpVar) {
                    z = true;
                } else {
                    z = false;
                }
                crVar.j6(bsVar, coVar, z);
            }
        }
        sy = bpVar.lp();
        sy.j6.j6();
        while (sy.j6.DW()) {
            bsVar = (bz) sy.j6.Hw();
            if (!(!bsVar.j6(bpVar2, bpVar2) || bsVar.aj() || cd.aM(bsVar.Ev()))) {
                crVar = this.j6.lg;
                if (bsVar.Xa() != bpVar) {
                    z = true;
                } else {
                    z = false;
                }
                crVar.j6(bsVar, coVar, z);
            }
        }
    }

    private void DW(cj cjVar, bp bpVar, co coVar, bp bpVar2) {
        boolean z;
        dr ko = bpVar.ko();
        ko.j6.j6();
        while (ko.j6.DW()) {
            bs bsVar = (bp) ko.j6.Hw();
            if (bsVar.j6((bs) bpVar2) && bsVar.j6(cjVar.we(), cjVar.tp())) {
                this.j6.lg.DW(bsVar);
            }
        }
        dr sy = bpVar.sy();
        sy.j6.j6();
        while (sy.j6.DW()) {
            bsVar = (bz) sy.j6.Hw();
            if (cd.aM(bsVar.Ev()) && bsVar.j6(bpVar2, bpVar2)) {
                cr crVar = this.j6.lg;
                if (bsVar.Xa() != bpVar) {
                    z = true;
                } else {
                    z = false;
                }
                crVar.j6(bsVar, coVar, z);
            }
        }
        sy = bpVar.lp();
        sy.j6.j6();
        while (sy.j6.DW()) {
            bsVar = (bz) sy.j6.Hw();
            if (cd.aM(bsVar.Ev()) && !bsVar.aj() && bsVar.j6(bpVar2, bpVar2)) {
                crVar = this.j6.lg;
                if (bsVar.Xa() != bpVar) {
                    z = true;
                } else {
                    z = false;
                }
                crVar.j6(bsVar, coVar, z);
            }
        }
    }

    private void j6(cj cjVar, int i, int i2, boolean z) {
        int Zo = cjVar.Zo(i, i2, i, i2);
        int FH = cjVar.FH(i, i2, i, i2);
        if (FH == -1) {
            FH = Zo;
        }
        if (FH != -1) {
            ((gb) cjVar.tp().u7()).DW(cjVar, FH);
        } else {
            ((gb) cjVar.tp().u7()).j6(cjVar);
        }
        ec ecVar = new ec();
        int i3 = FH;
        int i4 = FH;
        while (i4 != -1) {
            int i5;
            int i6;
            int Hw;
            int gW;
            cr crVar;
            if (cjVar.rN(i4) == 133) {
                int lg = cjVar.lg(i4);
                for (i5 = 0; i5 < lg; i5++) {
                    int Hw2 = cjVar.Hw(i4, i5);
                    if (Hw2 == i3) {
                        break;
                    }
                    if (cjVar.rN(Hw2) == 151) {
                        int lg2 = cjVar.lg(Hw2);
                        for (i6 = 3; i6 < lg2; i6 += 2) {
                            Hw = cjVar.Hw(cjVar.Hw(Hw2, i6), 0);
                            gW = cjVar.gW(Hw);
                            if (!ecVar.FH(gW) && cjVar.J0(Hw) && (cjVar.nw(Hw) != i || cjVar.KD(Hw) > i2 || cjVar.ro(Hw) < i2)) {
                                crVar = this.j6.lg;
                                r22.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                            }
                        }
                    }
                }
            } else if (cjVar.rN(i4) == 124) {
                i5 = cjVar.Hw(i4, 5);
                i3 = cjVar.lg(i5);
                for (i6 = 1; i6 < i3 - 1; i6 += 2) {
                    r5 = cjVar.Hw(i5, i6);
                    if (cjVar.rN(r5) != 16) {
                        Hw = cjVar.Hw(r5, 3);
                        gW = cjVar.gW(Hw);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw)) {
                            crVar = this.j6.lg;
                            r19.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                        }
                    }
                }
            } else if (cjVar.rN(i4) == 123) {
                i5 = cjVar.Hw(i4, 3);
                i3 = cjVar.lg(i5);
                for (i6 = 1; i6 < i3 - 1; i6 += 2) {
                    r5 = cjVar.Hw(i5, i6);
                    Hw = cjVar.Hw(r5, 3);
                    if (cjVar.rN(r5) != 16) {
                        gW = cjVar.gW(Hw);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw)) {
                            crVar = this.j6.lg;
                            r19.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                        }
                    }
                }
            } else if (cjVar.rN(i4) == 204 && cjVar.lg(i4) == 7) {
                Hw = cjVar.Hw(i4, 4);
                gW = cjVar.gW(Hw);
                if (!ecVar.FH(gW) && cjVar.J0(Hw)) {
                    this.j6.lg.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                }
            } else if (cjVar.rN(i4) == 211) {
                Hw = cjVar.Hw(i4, 5);
                gW = cjVar.gW(Hw);
                if (!ecVar.FH(gW) && cjVar.J0(Hw)) {
                    this.j6.lg.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                }
            } else if (cjVar.rN(i4) == 149) {
                i5 = cjVar.Hw(cjVar.Hw(i4, 2), 0);
                if (cjVar.rN(i5) == 151) {
                    i3 = cjVar.lg(i5);
                    for (i6 = 3; i6 < i3; i6 += 2) {
                        Hw = cjVar.Hw(cjVar.Hw(i5, i6), 0);
                        gW = cjVar.gW(Hw);
                        if (!ecVar.FH(gW) && cjVar.J0(Hw)) {
                            crVar = this.j6.lg;
                            r19.j6(new cp(cjVar.we(), cjVar.tp(), cjVar.nw(Hw), cjVar.KD(Hw), cjVar.ro(Hw), gW, cjVar.we(Hw)));
                        }
                    }
                }
            }
            FH = cjVar.aM(i4);
            if (FH == cjVar.Ws()) {
                i3 = i4;
                i4 = -1;
            } else {
                i3 = i4;
                i4 = FH;
            }
        }
        if (z) {
            j6(cjVar, cjVar.Ws(), i, i2, new ec());
        }
        j6();
        if (Zo != -1) {
            try {
                bp j6 = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(Zo)));
                if (cjVar.v5(i, i2, i, i2) == -1) {
                    j6(cjVar, Zo);
                } else if (this.j6.lg.DW(cjVar, j6)) {
                    DW(cjVar, Zo);
                }
                if (this.j6.lg.j6(cjVar, j6)) {
                    j6(cjVar, j6, Zo);
                    return;
                }
                return;
            } catch (ej e) {
                return;
            }
        }
        j6(cjVar, new ea(this.Hw));
    }

    private void DW(cj cjVar, int i) {
        ec ecVar = new ec();
        ec ecVar2 = new ec();
        while (i != cjVar.Ws()) {
            if (cjVar.rN(i) == 122) {
                try {
                    bs bsVar;
                    bp j6 = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(i)));
                    dr sy = j6.sy();
                    sy.j6.j6();
                    while (sy.j6.DW()) {
                        if (!ecVar2.FH(sy.j6.FH())) {
                            bsVar = (bz) sy.j6.Hw();
                            this.j6.lg.j6(bsVar, j6.j3(), bsVar.Xa() != j6);
                            ecVar2.j6(sy.j6.FH());
                        }
                    }
                    sy = j6.lp();
                    sy.j6.j6();
                    while (sy.j6.DW()) {
                        bsVar = (bz) sy.j6.Hw();
                        if (!(ecVar.FH(sy.j6.FH()) || bsVar.aj())) {
                            boolean z;
                            cr crVar = this.j6.lg;
                            co j3 = j6.j3();
                            if (bsVar.Xa() != j6) {
                                z = true;
                            } else {
                                z = false;
                            }
                            crVar.j6(bsVar, j3, z);
                        }
                    }
                    sy.j6.j6();
                    while (sy.j6.DW()) {
                        ecVar.j6(sy.j6.FH());
                    }
                } catch (ej e) {
                }
            }
            i = cjVar.aM(i);
        }
        j6(cjVar);
    }

    private void j6(cj cjVar, int i, int i2, int i3, ec ecVar) {
        int lg = cjVar.lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            j6(cjVar, cjVar.Hw(i, i4), i2, i3, ecVar);
        }
        if (cjVar.rN(i) == 1 && cjVar.J8(i) == 0 && !ecVar.FH(cjVar.gW(i)) && !cjVar.er(i) && cjVar.nw(i) != i2) {
            this.j6.lg.j6(cjVar.BT(i));
            ecVar.j6(cjVar.gW(i));
        }
    }

    private void j6(cj cjVar, bp bpVar, int i) {
        ea eaVar = new ea(this.Hw);
        int i2 = i;
        while (i2 != -1) {
            try {
                dr ko = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(i2))).ko();
                ko.j6.j6();
                while (ko.j6.DW()) {
                    if (!eaVar.FH(ko.j6.Hw())) {
                        this.j6.lg.DW(ko.j6.Hw());
                        eaVar.j6(ko.j6.Hw());
                    }
                }
            } catch (ej e) {
            }
            do {
                i2 = cjVar.aM(i2);
                if (i2 == cjVar.Ws()) {
                    i2 = -1;
                }
                if (i2 == -1) {
                    break;
                }
            } while (cjVar.rN(i2) != 122);
        }
        j6(cjVar, eaVar);
    }

    private void j6(cj cjVar, ea<bs> eaVar) {
        int i;
        int i2 = 0;
        ce Zo = this.Hw.Zo();
        int Hw = cjVar.Hw(cjVar.Ws(), 0);
        if (cjVar.lg(Hw) > 0) {
            Zo = (ce) cjVar.QX(cjVar.Hw(Hw, cjVar.lg(Hw) - 2));
        }
        j6(cjVar, Zo, Zo, (ea) eaVar);
        Hw = cjVar.lg(cjVar.Ws());
        for (i = 0; i < Hw; i++) {
            int Hw2 = cjVar.Hw(cjVar.Ws(), i);
            if (cjVar.rN(Hw2) == ProxyTextView.INPUTTYPE_textWebPassword) {
                Hw2 = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 2);
                if (cjVar.J8(Hw2) == 8 || cjVar.J8(Hw2) == 17) {
                    bs QX = cjVar.QX(Hw2);
                    if (!eaVar.FH(QX)) {
                        this.j6.lg.DW(QX);
                        eaVar.j6(QX);
                    }
                }
            }
        }
        Hw = cjVar.lg(cjVar.Ws());
        while (i2 < Hw) {
            i = cjVar.Hw(cjVar.Ws(), i2);
            if (cjVar.rN(i) == 226) {
                i = cjVar.Hw(i, cjVar.lg(i) - 4);
                if (cjVar.J8(i) == 6) {
                    Zo = (ce) cjVar.QX(i);
                    j6(cjVar, Zo, Zo, (ea) eaVar);
                } else if (cjVar.J8(i) == 8 || cjVar.J8(i) == 17) {
                    dr ko = ((bp) cjVar.QX(i)).ko();
                    ko.j6.j6();
                    while (ko.j6.DW()) {
                        bs bsVar = (bp) ko.j6.Hw();
                        if (!eaVar.FH(bsVar)) {
                            this.j6.lg.DW(bsVar);
                            eaVar.j6(bsVar);
                        }
                    }
                }
            }
            i2++;
        }
        ea VH = this.Hw.Zo().VH();
        VH.j6.j6();
        while (VH.j6.DW()) {
            this.j6.lg.DW((ce) VH.j6.FH());
        }
        dr j6 = this.Hw.j6(cjVar.we(), this.Zo);
        j6.j6.j6();
        while (j6.j6.DW()) {
            bp bpVar = (bp) j6.j6.Hw();
            if (!eaVar.FH((bs) bpVar)) {
                if (DW(this.DW.j6(j6.j6.FH()))) {
                    this.j6.lg.j6(bpVar);
                }
            }
        }
    }

    private bp FH(cj cjVar, int i) {
        while (i != cjVar.Ws()) {
            if (cjVar.rN(i) == 122) {
                try {
                    return this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(cjVar.aM(i)));
                } catch (ej e) {
                }
            } else {
                i = cjVar.aM(i);
            }
        }
        return null;
    }

    private void j6(cj cjVar, ce ceVar, ce ceVar2) {
        ea eaVar = new ea(this.Hw);
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            if (!eaVar.FH(gn.j6.Hw())) {
                bs bsVar = (bp) gn.j6.Hw();
                eaVar.j6(bsVar);
                if (bsVar.j6(cjVar.we(), cjVar.tp())) {
                    this.j6.lg.DW(bsVar);
                }
            }
        }
        ea VH = ceVar.VH();
        VH.j6.j6();
        while (VH.j6.DW()) {
            this.j6.lg.DW(VH.j6.FH());
        }
    }

    private void j6(cj cjVar, ce ceVar, ce ceVar2, ea<bs> eaVar) {
        dr gn = ceVar.gn();
        gn.j6.j6();
        while (gn.j6.DW()) {
            if (!eaVar.FH(gn.j6.Hw())) {
                bs bsVar = (bp) gn.j6.Hw();
                eaVar.j6(bsVar);
                if (bsVar.j6(cjVar.we(), cjVar.tp())) {
                    this.j6.lg.DW(bsVar);
                }
            }
        }
    }

    private void j6(cj cjVar) {
        int Hw;
        int Ws = cjVar.Ws();
        ea eaVar = new ea(this.Hw);
        int lg = cjVar.lg(Ws);
        for (int i = 0; i < lg; i++) {
            Hw = cjVar.Hw(Ws, i);
            if (cjVar.rN(Hw) == 213) {
                Hw = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                if (cjVar.J8(Hw) == 20 || cjVar.J8(Hw) == 16) {
                    bs QX = cjVar.QX(Hw);
                    if (!eaVar.FH(QX)) {
                        this.j6.lg.j6(QX, true);
                        eaVar.j6(QX);
                    }
                }
            }
        }
        Hw = cjVar.lg(Ws);
        for (lg = 0; lg < Hw; lg++) {
            int Hw2 = cjVar.Hw(Ws, lg);
            if (cjVar.rN(Hw2) == 214) {
                Hw2 = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 4);
                if (cjVar.J8(Hw2) == 8) {
                    bs bsVar;
                    bs QX2 = cjVar.QX(Hw2);
                    dr lp = ((bp) QX2).lp();
                    lp.j6.j6();
                    while (lp.j6.DW()) {
                        bsVar = (bz) lp.j6.Hw();
                        if (!eaVar.FH(bsVar) && bsVar.I()) {
                            this.j6.lg.j6(bsVar, true);
                        }
                    }
                    lp.j6.j6();
                    while (lp.j6.DW()) {
                        eaVar.j6(lp.j6.Hw());
                    }
                    dr sy = ((bp) QX2).sy();
                    sy.j6.j6();
                    while (sy.j6.DW()) {
                        bsVar = (bz) sy.j6.Hw();
                        if (!eaVar.FH(bsVar) && bsVar.I()) {
                            this.j6.lg.j6(bsVar, true);
                            eaVar.j6(bsVar);
                        }
                    }
                }
            }
        }
    }

    private void j6() {
        this.j6.lg.FH("System.out.println(");
        this.j6.lg.FH("assert");
        this.j6.lg.FH("abstract");
        this.j6.lg.FH("boolean");
        this.j6.lg.FH("break");
        this.j6.lg.FH("byte");
        this.j6.lg.FH("case");
        this.j6.lg.FH("catch");
        this.j6.lg.FH("char");
        this.j6.lg.FH("class");
        this.j6.lg.FH("continue");
        this.j6.lg.FH("default");
        this.j6.lg.FH("do");
        this.j6.lg.FH("double");
        this.j6.lg.FH("else");
        this.j6.lg.FH("enum");
        this.j6.lg.FH("extends");
        this.j6.lg.FH("false");
        this.j6.lg.FH("final");
        this.j6.lg.FH("finally");
        this.j6.lg.FH("float");
        this.j6.lg.FH("for");
        this.j6.lg.FH("if");
        this.j6.lg.FH("import");
        this.j6.lg.FH("implements");
        this.j6.lg.FH("instanceof");
        this.j6.lg.FH("int");
        this.j6.lg.FH("interface");
        this.j6.lg.FH("long");
        this.j6.lg.FH("native");
        this.j6.lg.FH("new");
        this.j6.lg.FH("null");
        this.j6.lg.FH("package");
        this.j6.lg.FH("private");
        this.j6.lg.FH("protected");
        this.j6.lg.FH("public");
        this.j6.lg.FH("return");
        this.j6.lg.FH("short");
        this.j6.lg.FH("static");
        this.j6.lg.FH("strictfp");
        this.j6.lg.FH("super");
        this.j6.lg.FH("switch");
        this.j6.lg.FH("synchronized");
        this.j6.lg.FH("this");
        this.j6.lg.FH("throw");
        this.j6.lg.FH("throws");
        this.j6.lg.FH("transient");
        this.j6.lg.FH("true");
        this.j6.lg.FH("try");
        this.j6.lg.FH("void");
        this.j6.lg.FH("volatile");
        this.j6.lg.FH("while");
    }

    public void FH(bv bvVar, int i, int i2) {
        String j6 = bvVar.j6(i, i2);
        if (j6.length() > 0) {
            char charAt = j6.charAt(j6.length() - 1);
            if (charAt == '(' || charAt == ',' || charAt == '=') {
                Hw(bvVar, i, i2);
            }
        }
    }

    public void Hw(bv bvVar, int i, int i2) {
        cj DW = this.v5.DW(bvVar, this.Zo);
        int we = DW.we(i, i2);
        int Ws;
        int Hw;
        if (we == -1) {
            Ws = DW.Ws(i, i2);
            if (Ws != -1 && DW.rN(Ws) == 172 && DW.rN(DW.Hw(Ws, 1)) == 17) {
                ((gb) DW.tp().u7()).DW(DW, Ws);
                Hw = DW.Hw(Ws, 0);
                we = DW.Hw(Ws, 1);
                Ws = DW.Hw(Ws, 2);
                if (DW.J0(Hw)) {
                    j6(DW.we(Hw));
                    this.j6.lg.j6(bvVar, i, i2, new int[]{DW.SI(we), DW.SI(Ws)}, new int[]{DW.ro(we) - 1, DW.ro(Ws)});
                    return;
                }
                this.j6.lg.DW(bvVar, i, i2);
                return;
            }
            Ws = DW.j6(200, i, i2, i, i2);
            if (Ws == -1 || DW.lg(Ws) != 4) {
                this.j6.lg.DW(bvVar, i, i2);
                return;
            }
            ((gb) DW.tp().u7()).DW(DW, Ws);
            Hw = DW.Hw(Ws, 0);
            we = DW.Hw(Ws, 2);
            Ws = DW.Hw(Ws, 3);
            if (DW.J0(Hw)) {
                j6(DW.we(Hw));
                this.j6.lg.j6(bvVar, i, i2, new int[]{DW.nw(we), DW.SI(Ws)}, new int[]{DW.KD(we), DW.ro(Ws)});
                return;
            }
            this.j6.lg.DW(bvVar, i, i2);
            return;
        }
        int Hw2;
        Ws = DW.aM(we);
        ((gb) DW.tp().u7()).DW(DW, we);
        switch (DW.rN(Ws)) {
            case 155:
                Hw = DW.Hw(Ws, 0);
                if (DW.J0(Hw)) {
                    j6(DW, DW.we(Hw), DW.gW(DW.Hw(Ws, 3)), FH(DW, Hw));
                    break;
                }
                break;
            case 156:
                if (DW.lg(Ws) != 2) {
                    Hw = DW.lg(Ws);
                    Hw2 = DW.Hw(Ws, Hw - 5);
                    Ws = DW.gW(DW.Hw(Ws, Hw - 2));
                    switch (DW.J8(Hw2)) {
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        case 16:
                            if (DW.J0(Hw2)) {
                                j6(DW, DW.we(Hw2), Ws, FH(DW, Hw2));
                                break;
                            }
                            break;
                        case 8:
                        case 9:
                        case 10:
                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                            j6(DW, (bp) DW.QX(Hw2), Ws, FH(DW, Hw2));
                            break;
                        default:
                            break;
                    }
                }
                Hw = DW.Zo(i, i2, i, i2);
                Hw2 = DW.gW(DW.Hw(Ws, 0));
                Ws = Hw;
                while (Ws != -1) {
                    try {
                        bp j6 = this.Hw.j6(DW.we(), DW.tp(), DW.XL(DW.aM(Ws)));
                        dr lp = j6.lp();
                        Object obj = null;
                        lp.j6.j6(Hw2);
                        while (lp.j6.DW()) {
                            this.j6.lg.DW((bz) lp.j6.Hw(), j6.j3());
                            obj = 1;
                        }
                        if (obj != null) {
                            break;
                        }
                        Hw = Ws;
                        do {
                            Hw = DW.aM(Hw);
                            if (Hw == DW.Ws()) {
                                Hw = -1;
                            }
                            if (Hw == -1) {
                                Ws = Hw;
                            }
                        } while (DW.rN(Hw) != 122);
                        Ws = Hw;
                    } catch (ej e) {
                        Hw = Ws;
                    }
                }
                break;
                break;
            case 176:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                Ws = DW.Hw(Ws, 2);
                Hw = DW.Hw(Ws, DW.lg(Ws) - 2);
                bp FH;
                bp bpVar;
                switch (DW.J8(Hw)) {
                    case 8:
                    case 9:
                    case 10:
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        FH = FH(DW, Hw);
                        bpVar = (bp) DW.QX(Hw);
                        if (DW.J0(Ws)) {
                            j6(bpVar, DW.we(Ws), FH);
                            break;
                        }
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        FH = FH(DW, Hw);
                        bpVar = ((bz) DW.QX(Hw)).Xa();
                        if (DW.J0(Ws)) {
                            j6(bpVar, DW.we(Ws), FH);
                            break;
                        }
                        break;
                    default:
                        break;
                }
        }
        Hw = (DW.lg(we) - 1) / 2;
        Hw = Hw == 0 ? 2 : Hw + 1;
        int[] iArr = new int[Hw];
        int[] iArr2 = new int[Hw];
        Ws = 0;
        for (Hw = 0; Hw < DW.lg(we) - 1; Hw += 2) {
            Hw2 = DW.Hw(we, Hw);
            iArr[Ws] = DW.nw(Hw2);
            iArr2[Ws] = DW.KD(Hw2);
            Ws++;
        }
        iArr[Ws] = DW.nw(DW.Hw(we, DW.lg(we) - 1));
        iArr2[Ws] = DW.KD(DW.Hw(we, DW.lg(we) - 1));
        if (iArr[Ws] == 0) {
            iArr[Ws] = iArr[Ws - 1];
            iArr2[Ws] = iArr2[Ws - 1] + 1;
        }
        this.j6.lg.j6(bvVar, i, i2, iArr, iArr2);
    }

    private void j6(co coVar) {
        this.j6.lg.j6(coVar);
    }

    private void j6(bp bpVar, co coVar, bp bpVar2) {
        ea dx = bpVar.dx();
        dx.j6.j6();
        while (dx.j6.DW()) {
            bs bsVar = (bz) dx.j6.FH();
            if (bsVar.j6(bpVar2, bpVar2)) {
                this.j6.lg.DW(bsVar, coVar);
            }
        }
    }

    private void j6(cj cjVar, co coVar, int i, bp bpVar) {
        try {
            if (coVar.AL()) {
                coVar = this.Hw.Hw(cjVar.we(), cjVar.tp());
            }
            if (coVar.a_().cT()) {
                dr lp = ((bp) coVar.a_()).lp();
                lp.j6.j6(i);
                while (lp.j6.DW()) {
                    bs bsVar = (bz) lp.j6.Hw();
                    if (bsVar.j6(bpVar, bpVar)) {
                        this.j6.lg.DW(bsVar, coVar);
                    }
                }
            }
        } catch (ej e) {
        }
    }
}
