import com.aide.uidesigner.ProxyTextView;
import java.util.List;
import java.util.Set;

public class il implements bm {
    private final ie DW;
    private final id FH;
    private final ib Hw;
    private final cc j6;

    public il(cc ccVar, ih ihVar, boolean z) {
        this.j6 = ccVar;
        this.DW = new ie(ccVar, ihVar);
        this.FH = new id(ccVar, ihVar, z);
        this.Hw = new ib(ccVar, ihVar);
    }

    public boolean j6(String str) {
        return false;
    }

    public void j6(bv bvVar, String str) {
    }

    public void j6(bv bvVar, int i, int i2) {
        String DW = bvVar.DW(i2);
        if (DW.trim().endsWith("-->")) {
            int FH = FH(DW);
            this.j6.rN.j6(bvVar, i2, FH - 2, i2, FH + 1, "");
        }
        DW = bvVar.DW(i);
        if (DW.trim().startsWith("<!--")) {
            int DW2 = DW(DW);
            this.j6.rN.j6(bvVar, i, DW2, i, DW2 + 4, "");
        }
    }

    public void DW(bv bvVar, int i, int i2) {
        int DW = DW(bvVar.DW(i));
        this.j6.rN.j6(bvVar, i, DW, i, DW, "<!--");
        DW = FH(bvVar.DW(i2)) + 1;
        if (i == i2) {
            DW += 4;
        }
        this.j6.rN.j6(bvVar, i2, DW, i2, DW, "-->");
    }

    private int DW(String str) {
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i + 1;
    }

    private int FH(String str) {
        int length = str.length() - 1;
        while (length > 0 && Character.isWhitespace(str.charAt(length))) {
            length--;
        }
        return length + 1;
    }

    public void j6(de deVar, bv bvVar, int i, int i2, String str, List<String> list) {
    }

    public void j6(cj cjVar, int i, int i2) {
        int EQ = cjVar.EQ(i, i2 - 1);
        if (EQ != -1) {
            switch (cjVar.rN(EQ)) {
                case 7:
                case 11:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 100:
                    int aM = cjVar.aM(EQ);
                    DW(cjVar, EQ, cjVar.Hw(aM, cjVar.lg(aM) - 1));
                    return;
                case 8:
                case 12:
                case 76:
                    DW(cjVar, EQ, cjVar.Hw(cjVar.aM(EQ), 0));
                    return;
                case 25:
                case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                    EQ = cjVar.aM(cjVar.aM(EQ));
                    switch (cjVar.rN(EQ)) {
                        case 200:
                            DW(cjVar, cjVar.aM(EQ));
                            return;
                        case 201:
                            break;
                        case 207:
                            DW(cjVar, cjVar.aM(EQ));
                            return;
                        default:
                            break;
                    }
            }
        }
        this.j6.vy.j6(cjVar.we());
    }

    private void DW(cj cjVar, int i) {
        DW(cjVar, cjVar.Hw(cjVar.Hw(i, 0), 1), cjVar.Hw(cjVar.Hw(i, 2), 1));
    }

    private void DW(cj cjVar, int i, int i2) {
        if (!cjVar.er(i) && !cjVar.er(i2)) {
            this.j6.vy.j6(cjVar.we(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i), cjVar.nw(i2), cjVar.KD(i2), cjVar.SI(i2), cjVar.ro(i2));
        }
    }

    public String j6() {
        return "";
    }

    public void j6(bv bvVar, int i, int i2, boolean z) {
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3, int i4, boolean z) {
    }

    public void j6(cj cjVar, int i, int i2, int i3, boolean z) {
        this.FH.j6(cjVar, i, i2, i3, z);
    }

    public boolean FH(bv bvVar, int i, int i2) {
        return false;
    }

    public void j6(cj cjVar, bv bvVar, bj bjVar, int i, int i2) {
        this.FH.j6(cjVar, i, i2);
    }

    public void j6(bv bvVar, int i, int i2, String str, int i3) {
    }

    public void Hw(bv bvVar, int i, int i2) {
    }

    public void v5(bv bvVar, int i, int i2) {
    }

    public dj<bm$a> j6(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.FH(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.DW(cjVar, ckVar, i, i2, i3);
    }

    public dj<bm$a> FH(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return this.DW.j6(cjVar, ckVar, i, i2, i3);
    }

    public void DW(cj cjVar, ck ckVar, int i, int i2) {
    }

    public int[] FH(cj cjVar, ck ckVar, int i, int i2) {
        return this.DW.j6(cjVar, ckVar, i, i2);
    }

    public void j6(cj cjVar, ck ckVar, int i, int i2) {
        this.DW.DW(cjVar, ckVar, i, i2);
    }

    public Set<? extends bd> j6(cj cjVar, int i) {
        return this.DW.j6(cjVar, i);
    }

    public boolean j6(bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
        return false;
    }

    public void j6(bv bvVar, bz bzVar, do doVar, do doVar2, do doVar3, do doVar4, do doVar5) {
    }

    public void Zo(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void VH(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar) {
    }

    public void j6(bv bvVar, int i, int i2, int i3, int i4, co coVar, int[] iArr, co[] coVarArr, int[] iArr2) {
    }

    public void gn(bv bvVar, int i, int i2) {
    }

    public void DW(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void FH(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void Hw(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public void u7(bv bvVar, int i, int i2) {
    }

    public void j6(bv bvVar, int i, int i2, bz bzVar) {
    }

    public void v5(bv bvVar, int i, int i2, int i3, int i4) {
    }

    public String j6(String str, String str2) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, co coVar) {
        return null;
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar) {
        return null;
    }

    public String j6(ce ceVar) {
        return null;
    }

    public String DW(ce ceVar) {
        return null;
    }

    public String FH(ce ceVar) {
        return null;
    }

    public String j6(cj cjVar, dq<bp, bs> dqVar, ea<ce> eaVar) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar) {
        return null;
    }

    public String j6(cj cjVar, int i, int i2, ea<? extends co> eaVar, ea<bs> eaVar2) {
        return null;
    }

    public void j6(bv bvVar, bv bvVar2, int i, int i2, int i3, int i4) {
        this.Hw.j6(bvVar, bvVar2, i, i2, i3, i4);
    }
}
