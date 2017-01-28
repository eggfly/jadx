import com.aide.uidesigner.ProxyTextView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class hg {
    private final hq DW;
    private int EQ;
    private cj FH;
    private ck Hw;
    private int J0;
    private dg J8;
    private int Mr;
    private Map<hh, Integer> QX;
    private int VH;
    private dg Ws;
    private Map<hh, Integer> XL;
    private int Zo;
    private dj<bm$a> aM;
    private int gn;
    private dj<bm$a> j3;
    private final cc j6;
    private int tp;
    private int u7;
    private Set<? extends bd> v5;
    private int we;

    public hg(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.DW = hqVar;
        this.aM = new dj();
        this.j3 = new dj();
        this.J8 = new dg();
        this.Ws = new dg();
    }

    public int[] j6(cj cjVar, ck ckVar, int i, int i2) {
        return null;
    }

    public void j6(cj cjVar, ck ckVar, int i) {
        if (cjVar.we().DW(i).endsWith("{") && cjVar.we().DW(i + 1, 1).startsWith("}")) {
            this.j6.rN.DW(cjVar.we(), i + 1, 1, i + 1, 1, "\n");
            ckVar.j6(i + 1, 1);
        }
    }

    public dj<bm$a> j6(cj cjVar, ck ckVar, int i, int i2, int i3) {
        return null;
    }

    public dj<bm$a> DW(cj cjVar, ck ckVar, int i, int i2, int i3) {
        this.v5 = this.j6.u7().DW(cjVar.tp());
        this.Zo = this.j6.u7().j6(cjVar.tp());
        this.VH = this.j6.u7().VH;
        this.Mr = i3;
        this.gn = i;
        this.u7 = i2;
        this.FH = cjVar;
        this.Hw = ckVar;
        this.Ws = cjVar.we().j6(i3);
        this.J8.j6();
        FH(cjVar.Ws());
        this.j3.j6();
        this.aM.j6();
        this.tp = 0;
        this.EQ = 0;
        this.we = -1;
        this.J0 = 0;
        j6(cjVar.Ws(), false);
        j6(cjVar.Ws());
        j6(cjVar.we());
        return this.j3;
    }

    public void DW(cj cjVar, ck ckVar, int i, int i2) {
        this.v5 = this.j6.u7().DW(cjVar.tp());
        this.Zo = this.j6.u7().j6(cjVar.tp());
        this.VH = this.j6.u7().VH;
        this.FH = cjVar;
        this.Hw = ckVar;
        this.gn = i;
        this.u7 = i2;
        DW(cjVar.Ws(), false);
    }

    public Set<? extends bd> j6(cj cjVar, int i) {
        this.v5 = this.j6.u7().DW(cjVar.tp());
        this.Zo = this.j6.u7().j6(cjVar.tp());
        this.VH = this.j6.u7().VH;
        this.Mr = i;
        this.gn = 1;
        this.u7 = 10000000;
        this.FH = cjVar;
        this.Hw = new ck();
        this.QX = new HashMap();
        this.XL = new HashMap();
        for (Object obj : hh.values()) {
            this.QX.put(obj, Integer.valueOf(0));
            this.XL.put(obj, Integer.valueOf(0));
        }
        this.Ws = cjVar.we().j6(i);
        this.J8.j6();
        FH(cjVar.Ws());
        this.aM.j6();
        this.tp = 0;
        this.EQ = 0;
        this.we = -1;
        this.J0 = 0;
        j6(cjVar.Ws(), true);
        DW(cjVar.Ws(), true);
        Set<? extends bd> hashSet = new HashSet(this.v5);
        for (Object obj2 : hh.values()) {
            if (((Integer) this.XL.get(obj2)).intValue() + ((Integer) this.QX.get(obj2)).intValue() > 0) {
                if (((Integer) this.QX.get(obj2)).intValue() > ((Integer) this.XL.get(obj2)).intValue()) {
                    hashSet.add(obj2);
                } else {
                    hashSet.remove(obj2);
                }
            }
        }
        return hashSet;
    }

    private void j6(int i) {
        int i2 = 0;
        if (!this.FH.er(i)) {
            if (this.FH.rN(i) == 2) {
                for (int DW = this.Hw.DW(this.FH, i) + 1; DW <= this.Hw.Hw(this.FH, i); DW++) {
                    this.aM.j6(DW, new bm$a(this.DW, 0, false, true, 0));
                }
            }
            int lg = this.FH.lg(i);
            while (i2 < lg) {
                j6(this.FH.Hw(i, i2));
                i2++;
            }
        }
    }

    private void j6(bv bvVar) {
        if (this.gn != 1) {
            int j6 = j6(bvVar.j6(this.Mr), this.FH.Ws());
            this.aM.j6.j6();
            while (this.aM.j6.DW()) {
                this.j3.j6(this.aM.j6.FH(), ((bm$a) this.aM.j6.Hw()).j6(j6));
            }
            return;
        }
        this.j3.j6(this.aM);
    }

    private int j6(dg dgVar, int i) {
        if (DW(i)) {
            int j6;
            int lg = this.FH.lg(i);
            for (int i2 = 0; i2 < lg; i2++) {
                j6 = j6(dgVar, this.FH.Hw(i, i2));
                if (j6 != 0) {
                    return j6;
                }
            }
            switch (this.FH.rN(i)) {
                case ProxyTextView.INPUTTYPE_textPersonName /*97*/:
                case 133:
                    j6 = this.Hw.DW(this.FH, i);
                    if (j6 != 0 && j6 < this.gn && this.aM.j6(j6)) {
                        return dgVar.FH(j6) - ((bm$a) this.aM.FH(j6)).j6;
                    }
            }
        }
        return 0;
    }

    private boolean DW(int i) {
        return this.u7 >= this.Hw.DW(this.FH, i) && (this.gn <= this.Hw.Hw(this.FH, i) || this.Hw.Hw(this.FH, i) == 0);
    }

    private void FH(int i) {
        int i2 = 0;
        if (!this.FH.er(i)) {
            int DW;
            if (this.FH.tp().Hw().Ws(this.FH.rN(i))) {
                DW = this.Hw.DW(this.FH, i);
                int FH = this.Hw.FH(this.FH, i);
                if (this.J8.FH(DW) <= 0 || this.J8.FH(DW) > FH) {
                    this.J8.j6(DW, FH);
                }
            }
            switch (this.FH.rN(i)) {
                case 133:
                case 140:
                case 196:
                    if (DW(i)) {
                        DW = this.FH.lg(i);
                        while (i2 < DW) {
                            FH(this.FH.Hw(i, i2));
                            i2++;
                        }
                    }
                default:
                    DW = this.FH.lg(i);
                    while (i2 < DW) {
                        FH(this.FH.Hw(i, i2));
                        i2++;
                    }
            }
        }
    }

    private void j6(int i, boolean z) {
        if (!this.FH.er(i)) {
            if (this.FH.tp().Hw().Ws(this.FH.rN(i))) {
                Hw(i);
            }
            int i2;
            int FH;
            int lg;
            int i3;
            int i4;
            int i5;
            switch (this.FH.rN(i)) {
                case 133:
                    if (DW(i)) {
                        i2 = this.we;
                        this.we = -1;
                        FH = this.Ws.FH(this.Hw.DW(this.FH, i));
                        lg = this.FH.lg(i);
                        if (this.v5.contains(hh.BRACE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        j6(this.FH.Hw(i, 0), z);
                        if (this.FH.rN(this.FH.aM(i)) == 147 && this.v5.contains(hh.CASELABEL_INDENT)) {
                            this.tp += this.Zo;
                        }
                        if (this.v5.contains(hh.BLOCK_INDENT)) {
                            this.tp += this.Zo;
                        }
                        int i6 = this.J0;
                        this.J0 = this.tp;
                        i3 = -1;
                        for (i4 = 1; i4 < lg - 1; i4++) {
                            int Hw = this.FH.Hw(i, i4);
                            switch (this.FH.rN(Hw)) {
                                case 143:
                                case 144:
                                    if (z) {
                                        i3 = this.Ws.FH(this.Hw.DW(this.FH, Hw));
                                        j6(hh.CASELABEL_INDENT, i3, FH);
                                    }
                                    if (this.v5.contains(hh.CASE_INDENT)) {
                                        this.tp -= this.Zo;
                                    }
                                    j6(Hw, z);
                                    if (!this.v5.contains(hh.CASE_INDENT)) {
                                        break;
                                    }
                                    this.tp += this.Zo;
                                    break;
                                case 148:
                                    if (this.v5.contains(hh.LABELLEFT_INDENT)) {
                                        i5 = this.tp;
                                        this.tp = 0;
                                        Hw(this.FH.Hw(Hw, 0));
                                        this.tp = i5;
                                    }
                                    if (z) {
                                        j6(hh.LABELLEFT_INDENT, this.Ws.FH(this.Hw.DW(this.FH, Hw)) == 0);
                                    }
                                    j6(Hw, z);
                                    break;
                                default:
                                    if (z) {
                                        if (i3 != -1) {
                                            j6(hh.CASE_INDENT, this.Ws.FH(this.Hw.DW(this.FH, Hw)), i3);
                                            i3 = -1;
                                        } else if (i4 == 1) {
                                            j6(hh.BLOCK_INDENT, this.Ws.FH(this.Hw.DW(this.FH, Hw)), FH);
                                        }
                                    }
                                    j6(Hw, z);
                                    break;
                            }
                        }
                        if (this.v5.contains(hh.BLOCK_INDENT)) {
                            this.tp -= this.Zo;
                        }
                        if (this.FH.rN(this.FH.aM(i)) == 147 && this.v5.contains(hh.CASELABEL_INDENT)) {
                            this.tp -= this.Zo;
                        }
                        j6(this.FH.Hw(i, lg - 1), z);
                        this.J0 = i6;
                        if (this.v5.contains(hh.BRACE_INDENT)) {
                            this.tp -= this.Zo;
                        }
                        this.we = i2;
                    }
                case 135:
                case 137:
                case 149:
                    j6(this.FH.Hw(i, 0), z);
                    j6(this.FH.Hw(i, 1), z);
                    if (this.v5.contains(hh.ARGUMENT_INDENT) && this.Hw.Hw(this.FH, this.FH.Hw(i, 1)) == this.Hw.DW(this.FH, this.FH.Hw(i, 2))) {
                        i5 = this.tp;
                        i3 = this.Hw.DW(this.FH, this.FH.Hw(i, 1));
                        this.tp = (this.Hw.FH(this.FH, this.FH.Hw(i, 1)) - this.J8.FH(i3)) + 1;
                        if (this.aM.j6(i3)) {
                            this.tp = ((bm$a) this.aM.FH(i3)).j6 + this.tp;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i5;
                    } else {
                        i3 = this.tp;
                        if (this.v5.contains(hh.NEXTLINE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i3;
                    }
                    i5 = this.FH.lg(i);
                    for (i3 = 4; i3 < i5 - 1; i3++) {
                        j6(this.FH.Hw(i, i3), z);
                    }
                    if (this.FH.rN(this.FH.Hw(i, i5 - 1)) != 133) {
                        this.tp += this.Zo;
                    }
                    j6(this.FH.Hw(i, i5 - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, i5 - 1)) != 133) {
                        this.tp -= this.Zo;
                    }
                case 136:
                    j6(this.FH.Hw(i, 0), z);
                    j6(this.FH.Hw(i, 1), z);
                    if (this.v5.contains(hh.ARGUMENT_INDENT) && this.Hw.Hw(this.FH, this.FH.Hw(i, 1)) == this.Hw.DW(this.FH, this.FH.Hw(i, 2))) {
                        i5 = this.tp;
                        i3 = this.Hw.DW(this.FH, this.FH.Hw(i, 1));
                        this.tp = (this.Hw.FH(this.FH, this.FH.Hw(i, 1)) - this.J8.FH(i3)) + 1;
                        if (this.aM.j6(i3)) {
                            this.tp = ((bm$a) this.aM.FH(i3)).j6 + this.tp;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i5;
                    } else {
                        i3 = this.tp;
                        if (this.v5.contains(hh.NEXTLINE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i3;
                    }
                    if (this.FH.rN(this.FH.Hw(i, 4)) != 133) {
                        this.tp += this.Zo;
                    }
                    j6(this.FH.Hw(i, 4), z);
                    if (this.FH.rN(this.FH.Hw(i, 4)) != 133) {
                        this.tp -= this.Zo;
                    }
                    j6(this.FH.Hw(i, 5), z);
                    if (!(this.FH.rN(this.FH.Hw(i, 6)) == 133 || this.FH.rN(this.FH.Hw(i, 6)) == 135 || this.FH.rN(this.FH.Hw(i, 6)) == 136)) {
                        this.tp += this.Zo;
                    }
                    j6(this.FH.Hw(i, 6), z);
                    if (this.FH.rN(this.FH.Hw(i, 6)) != 133 && this.FH.rN(this.FH.Hw(i, 6)) != 135 && this.FH.rN(this.FH.Hw(i, 6)) != 136) {
                        this.tp -= this.Zo;
                    }
                case 140:
                case 196:
                    if (DW(i)) {
                        i5 = this.we;
                        this.we = -1;
                        i4 = this.Ws.FH(this.Hw.DW(this.FH, i));
                        i2 = this.FH.lg(i);
                        if (this.v5.contains(hh.BRACE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        j6(this.FH.Hw(i, 0), z);
                        if (this.v5.contains(hh.ARRAY_INDENT)) {
                            this.tp += this.Zo;
                        }
                        FH = this.J0;
                        this.J0 = this.tp;
                        for (i3 = 0; i3 < i2 - 1; i3++) {
                            lg = this.FH.Hw(i, i3);
                            if (z) {
                                j6(hh.BLOCK_INDENT, this.Ws.FH(this.Hw.DW(this.FH, lg)), i4);
                            }
                            j6(this.FH.Hw(i, i3), z);
                        }
                        if (this.v5.contains(hh.ARRAY_INDENT)) {
                            this.tp -= this.Zo;
                        }
                        j6(this.FH.Hw(i, i2 - 1), z);
                        this.J0 = FH;
                        if (this.v5.contains(hh.BRACE_INDENT)) {
                            this.tp -= this.Zo;
                        }
                        this.we = i5;
                    }
                case 141:
                case 146:
                case 151:
                case 152:
                    i5 = this.we;
                    this.we = this.Hw.DW(this.FH, i);
                    i4 = this.FH.lg(i);
                    for (i3 = 0; i3 < i4; i3++) {
                        j6(this.FH.Hw(i, i3), z);
                    }
                    this.we = i5;
                case 190:
                    i5 = this.we;
                    this.we = -1;
                    Hw(this.FH.Hw(i, 0));
                    if (this.v5.contains(hh.PARAMETER_INDENT) && this.Hw.Hw(this.FH, this.FH.Hw(i, 0)) == this.Hw.DW(this.FH, this.FH.Hw(i, 1))) {
                        i4 = this.tp;
                        i3 = this.Hw.DW(this.FH, this.FH.Hw(i, 0));
                        this.tp = (this.Hw.FH(this.FH, this.FH.Hw(i, 0)) - this.J8.FH(i3)) + 1;
                        if (this.aM.j6(i3)) {
                            this.tp = ((bm$a) this.aM.FH(i3)).j6 + this.tp;
                        }
                        i2 = this.J0;
                        this.J0 = this.tp;
                        FH = this.FH.lg(i);
                        for (i3 = 0; i3 < FH - 1; i3++) {
                            j6(this.FH.Hw(i, i3), z);
                        }
                        j6(this.FH.Hw(i, FH - 1), z);
                        this.J0 = i2;
                        this.tp = i4;
                    } else {
                        i4 = this.tp;
                        if (this.v5.contains(hh.NEXTLINE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        i2 = this.J0;
                        this.J0 = this.tp;
                        FH = this.FH.lg(i);
                        for (i3 = 0; i3 < FH - 1; i3++) {
                            j6(this.FH.Hw(i, i3), z);
                        }
                        this.J0 = i2;
                        this.tp = i4;
                        j6(this.FH.Hw(i, FH - 1), z);
                    }
                    this.we = i5;
                case 197:
                    i5 = this.we;
                    this.we = -1;
                    Hw(this.FH.Hw(i, 0));
                    i4 = this.FH.lg(i);
                    if (this.v5.contains(hh.ARGUMENT_INDENT) && this.Hw.Hw(this.FH, this.FH.Hw(i, 0)) == this.Hw.DW(this.FH, this.FH.Hw(i, 1))) {
                        i2 = this.tp;
                        i3 = this.Hw.DW(this.FH, this.FH.Hw(i, 0));
                        this.tp = (this.Hw.FH(this.FH, this.FH.Hw(i, 0)) - this.J8.FH(i3)) + 1;
                        if (this.aM.j6(i3)) {
                            this.tp = ((bm$a) this.aM.FH(i3)).j6 + this.tp;
                        }
                        FH = this.J0;
                        this.J0 = this.tp;
                        for (i3 = 0; i3 < i4 - 1; i3++) {
                            j6(this.FH.Hw(i, i3), z);
                        }
                        j6(this.FH.Hw(i, i4 - 1), z);
                        this.J0 = FH;
                        this.tp = i2;
                    } else {
                        i2 = this.tp;
                        if (this.v5.contains(hh.NEXTLINE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        FH = this.J0;
                        this.J0 = this.tp;
                        for (i3 = 0; i3 < i4 - 1; i3++) {
                            j6(this.FH.Hw(i, i3), z);
                        }
                        this.J0 = FH;
                        this.tp = i2;
                        j6(this.FH.Hw(i, i4 - 1), z);
                    }
                    this.we = i5;
                case 211:
                    j6(this.FH.Hw(i, 0), z);
                    j6(this.FH.Hw(i, 1), z);
                    if (this.v5.contains(hh.ARGUMENT_INDENT) && this.Hw.Hw(this.FH, this.FH.Hw(i, 1)) == this.Hw.DW(this.FH, this.FH.Hw(i, 2))) {
                        i5 = this.tp;
                        i3 = this.Hw.DW(this.FH, this.FH.Hw(i, 1));
                        this.tp = (this.Hw.FH(this.FH, this.FH.Hw(i, 1)) - this.J8.FH(i3)) + 1;
                        if (this.aM.j6(i3)) {
                            this.tp = ((bm$a) this.aM.FH(i3)).j6 + this.tp;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i5;
                    } else {
                        i3 = this.tp;
                        if (this.v5.contains(hh.NEXTLINE_INDENT)) {
                            this.tp += this.Zo;
                        }
                        j6(this.FH.Hw(i, 2), z);
                        j6(this.FH.Hw(i, 3), z);
                        this.tp = i3;
                    }
                    i5 = this.FH.lg(i);
                    for (i3 = 5; i3 < i5 - 1; i3++) {
                        j6(this.FH.Hw(i, i3), z);
                    }
                    if (this.FH.rN(this.FH.Hw(i, i5 - 1)) != 133) {
                        this.tp += this.Zo;
                    }
                    j6(this.FH.Hw(i, i5 - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, i5 - 1)) != 133) {
                        this.tp -= this.Zo;
                    }
                default:
                    i5 = this.FH.lg(i);
                    for (i3 = 0; i3 < i5; i3++) {
                        j6(this.FH.Hw(i, i3), z);
                    }
            }
        }
    }

    private void j6(hh hhVar, int i, int i2) {
        j6(hhVar, i != i2);
    }

    private void Hw(int i) {
        int DW = this.Hw.DW(this.FH, i);
        if (DW != 0 && DW != this.EQ) {
            int i2;
            if (this.EQ > DW) {
                this.EQ = DW;
            }
            if (DW == this.we || this.we == -1 || !this.v5.contains(hh.NEXTLINE_INDENT)) {
                i2 = 0;
            } else {
                i2 = this.Zo;
            }
            while (this.EQ < DW - 1) {
                this.EQ++;
                if (!this.aM.j6(this.EQ) || ((bm$a) this.aM.FH(this.EQ)).Hw > 101) {
                    this.aM.j6(this.EQ, new bm$a(this.DW, this.J0 + i2, false, false, 1001));
                }
            }
            if (!this.aM.j6(DW) || ((bm$a) this.aM.FH(DW)).Hw > 101) {
                this.aM.j6(DW, new bm$a(this.DW, this.tp + i2, false, false, 101));
            }
            this.EQ = DW;
        }
    }

    private void DW(int i, boolean z) {
        if (!this.FH.er(i)) {
            int lg;
            int Hw;
            int Hw2;
            switch (this.FH.rN(i)) {
                case 124:
                case 125:
                    DW(this.FH.Hw(i, this.FH.lg(i) - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, this.FH.lg(i) - 1)) == 133) {
                        DW(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.FUNCTION_NEWLINE, z);
                    }
                    DW(this.FH.Hw(i, this.FH.lg(i) - 2), z);
                case 133:
                    for (lg = this.FH.lg(i) - 1; lg >= 1; lg--) {
                        Hw = this.FH.Hw(i, lg);
                        if (!this.FH.er(Hw)) {
                            Hw2 = this.FH.Hw(i, lg - 1);
                            if (this.FH.er(Hw2)) {
                                Hw2 = this.FH.Hw(i, lg - 2);
                            }
                            DW(Hw, z);
                            if (this.v5.contains(hh.STATEMENT_WRAP) && this.Hw.v5(this.FH, Hw) > this.VH) {
                                j6(Hw2, Hw, z);
                            }
                        }
                    }
                case 135:
                case 137:
                case 147:
                    DW(this.FH.Hw(i, this.FH.lg(i) - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, this.FH.lg(i) - 1)) == 133) {
                        DW(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.BLOCK_NEWLINE, z);
                    }
                    j6(this.FH.Hw(i, 2), this.FH.Hw(i, 3), hh.CONDITION_SPACE, z);
                    DW(this.FH.Hw(i, 2), z);
                    j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.CONDITION_SPACE, z);
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.KEYWORD_SPACE, z);
                case 136:
                    DW(this.FH.Hw(i, 6), z);
                    if (this.FH.rN(this.FH.Hw(i, 6)) == 133) {
                        DW(this.FH.Hw(i, 5), this.FH.Hw(i, 6), hh.BLOCK_NEWLINE, z);
                    }
                    if (this.FH.rN(this.FH.Hw(i, 4)) == 133) {
                        DW(this.FH.Hw(i, 4), this.FH.Hw(i, 5), hh.ELSE_NEWLINE, z);
                    }
                    DW(this.FH.Hw(i, 4), z);
                    if (this.FH.rN(this.FH.Hw(i, 4)) == 133) {
                        DW(this.FH.Hw(i, 3), this.FH.Hw(i, 4), hh.BLOCK_NEWLINE, z);
                    }
                    j6(this.FH.Hw(i, 2), this.FH.Hw(i, 3), hh.CONDITION_SPACE, z);
                    DW(this.FH.Hw(i, 2), z);
                    j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.CONDITION_SPACE, z);
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.KEYWORD_SPACE, z);
                case 148:
                    DW(this.FH.Hw(i, this.FH.lg(i) - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, this.FH.lg(i) - 1)) == 133) {
                        DW(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.BLOCK_NEWLINE, z);
                    }
                case 149:
                    DW(this.FH.Hw(i, this.FH.lg(i) - 1), z);
                    if (this.FH.rN(this.FH.Hw(i, this.FH.lg(i) - 1)) == 133) {
                        DW(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.BLOCK_NEWLINE, z);
                    }
                    j6(this.FH.Hw(i, 4), this.FH.Hw(i, 5), hh.CONDITION_SPACE, z);
                    DW(this.FH.Hw(i, 4), z);
                    DW(this.FH.Hw(i, 3), z);
                    DW(this.FH.Hw(i, 2), z);
                    j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.CONDITION_SPACE, z);
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.KEYWORD_SPACE, z);
                case 150:
                    for (Hw2 = this.FH.lg(i) - 1; Hw2 >= 1; Hw2--) {
                        DW(this.FH.Hw(i, Hw2), z);
                    }
                    DW(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.BLOCK_NEWLINE, z);
                case 165:
                    Hw2 = this.FH.lg(i);
                    j6(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.ARRAYARGUMENT_SPACE, z);
                    for (Hw2 -= 2; Hw2 >= 2; Hw2 -= 2) {
                        DW(this.FH.Hw(i, Hw2), z);
                    }
                    j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.ARRAYARGUMENT_SPACE, z);
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.ARRAYMETHODCALL_SPACE, z);
                    DW(this.FH.Hw(i, 0), z);
                case 168:
                    j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.PAREN_SPACE, z);
                    DW(this.FH.Hw(i, 1), z);
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.PAREN_SPACE, z);
                case 172:
                    DW(this.FH.Hw(i, 2), z);
                    if (this.FH.rN(this.FH.aM(i)) != 146) {
                        j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.BINARYOPERATOR_SPACE, z);
                    } else {
                        j6(this.FH.Hw(i, 1), this.FH.Hw(i, 2), hh.ASSIGNMENTOPERATOR_SPACE, z);
                    }
                    DW(this.FH.Hw(i, 1), z);
                    if (this.FH.rN(this.FH.aM(i)) != 146) {
                        j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.BINARYOPERATOR_SPACE, z);
                    } else {
                        j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.ASSIGNMENTOPERATOR_SPACE, z);
                    }
                    DW(this.FH.Hw(i, 0), z);
                case 190:
                    if (this.FH.lg(i) == 2) {
                        j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.PARAMETER_SPACE, z);
                        return;
                    }
                    j6(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.PARAMETER_SPACE, z);
                    for (Hw2 = this.FH.lg(i) - 2; Hw2 >= 2; Hw2 -= 2) {
                        j6(this.FH.Hw(i, Hw2 - 1), this.FH.Hw(i, Hw2), hh.PARAMETERCOMMA_SPACE, z);
                    }
                    j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.PARAMETER_SPACE, z);
                case 197:
                    if (this.FH.lg(i) == 2) {
                        j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.ARGUMENT_SPACE, z);
                    } else {
                        j6(this.FH.Hw(i, this.FH.lg(i) - 2), this.FH.Hw(i, this.FH.lg(i) - 1), hh.ARGUMENT_SPACE, z);
                        lg = this.FH.lg(i);
                        for (Hw2 = lg - 2; Hw2 >= 2; Hw2 -= 2) {
                            Hw = this.FH.Hw(i, Hw2 - 1);
                            int Hw3 = this.FH.Hw(i, Hw2);
                            DW(Hw3, z);
                            j6(Hw, Hw3, hh.ARGUMENTCOMMA_SPACE, z);
                        }
                        if (lg >= 3) {
                            DW(this.FH.Hw(i, 1), z);
                        }
                        j6(this.FH.Hw(i, 0), this.FH.Hw(i, 1), hh.ARGUMENT_SPACE, z);
                    }
                    j6(this.FH.sh(i), i, hh.METHODCALL_SPACE, z);
                default:
                    for (Hw2 = this.FH.lg(i) - 1; Hw2 >= 0; Hw2--) {
                        DW(this.FH.Hw(i, Hw2), z);
                    }
            }
        }
    }

    private void j6(int i, int i2, hh hhVar, boolean z) {
        if (this.FH.nw(i) == 0) {
            return;
        }
        if (z) {
            if (this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2)) {
                boolean z2;
                if (this.Hw.v5(this.FH, i) != this.Hw.FH(this.FH, i2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                j6(hhVar, z2);
            }
        } else if (!this.v5.contains(hh.ADJUST_SPACES)) {
        } else {
            if (this.v5.contains(hhVar)) {
                if (this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2) && this.Hw.v5(this.FH, i) == this.Hw.FH(this.FH, i2) && this.Hw.Hw(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i) <= this.u7) {
                    this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), " ");
                    this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), " ");
                }
            } else if (this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2) && this.Hw.v5(this.FH, i) != this.Hw.FH(this.FH, i2) && this.Hw.DW(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i2) <= this.u7) {
                this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.DW(this.FH, i2), this.Hw.FH(this.FH, i2), "");
                this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.DW(this.FH, i2), this.Hw.FH(this.FH, i2));
            }
        }
    }

    private void DW(int i, int i2, hh hhVar, boolean z) {
        boolean z2 = true;
        if (this.FH.nw(i) == 0) {
            return;
        }
        if (z) {
            j6(hhVar, this.Hw.Hw(this.FH, i) != this.Hw.DW(this.FH, i2));
            if (this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2)) {
                hh hhVar2 = hh.BRACE_SPACE;
                if (this.Hw.v5(this.FH, i) == this.Hw.FH(this.FH, i2)) {
                    z2 = false;
                }
                j6(hhVar2, z2);
            }
        } else if (!this.v5.contains(hh.ADJUST_NEWLINES)) {
        } else {
            if (this.v5.contains(hhVar)) {
                if (this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2) && this.Hw.Hw(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i) <= this.u7) {
                    this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), "\n");
                    this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i));
                }
            } else if (this.Hw.Hw(this.FH, i) != this.Hw.DW(this.FH, i2)) {
                if (this.Hw.DW(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i2) <= this.u7) {
                    this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.DW(this.FH, i2), this.Hw.FH(this.FH, i2), "");
                    this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.DW(this.FH, i2), this.Hw.FH(this.FH, i2));
                }
                if (this.v5.contains(hh.BRACE_SPACE) && this.Hw.Hw(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i) <= this.u7) {
                    this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), " ");
                    this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), " ");
                }
            } else {
                j6(i, i2, hh.BRACE_SPACE, z);
            }
        }
    }

    private void j6(int i, int i2, boolean z) {
        if (this.FH.nw(i) != 0 && !z && this.v5.contains(hh.ADJUST_NEWLINES) && this.Hw.Hw(this.FH, i) == this.Hw.DW(this.FH, i2) && this.Hw.Hw(this.FH, i) >= this.gn && this.Hw.Hw(this.FH, i) <= this.u7) {
            this.j6.rN.j6(this.FH.we(), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i), "\n");
            this.Hw.j6(this.Hw.Hw(this.FH, i), this.Hw.v5(this.FH, i));
        }
    }

    private void j6(hh hhVar, boolean z) {
        if (z) {
            this.QX.put(hhVar, Integer.valueOf(((Integer) this.QX.get(hhVar)).intValue() + 1));
        } else {
            this.XL.put(hhVar, Integer.valueOf(((Integer) this.XL.get(hhVar)).intValue() + 1));
        }
    }
}
