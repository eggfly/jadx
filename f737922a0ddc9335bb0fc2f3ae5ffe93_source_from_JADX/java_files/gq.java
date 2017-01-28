import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class gq implements bf {
    private dt BT;
    private final by DW;
    private ea<bs> EQ;
    private final bw FH;
    private final bt Hw;
    private boolean I;
    private dt J0;
    private dx J8;
    private do KD;
    private co Mr;
    private int Mz;
    private boolean OW;
    private do P8;
    private int QX;
    private boolean Qq;
    private do SI;
    private ea<bz> Sf;
    private int U2;
    private go VH;
    private dl Ws;
    private int XG;
    private bp XL;
    private boolean XX;
    private final cc Zo;
    private char[] a8;
    private boolean aM;
    private boolean aj;
    private boolean br;
    private String ca;
    private ea<bz> cb;
    private dt cn;
    private ea<bp> dx;
    private int ef;
    private do ei;
    private int er;
    private int g3;
    private int gW;
    private do gn;
    private boolean j3;
    private final hc j6;
    private String jJ;
    private boolean kQ;
    private char[] lg;
    private boolean lp;
    private do nw;
    private int rN;
    private do ro;
    private boolean sG;
    private ea<bz> sh;
    private boolean sy;
    private dt tp;
    private ea<bp> u7;
    private final gv v5;
    private boolean vJ;
    private dt vy;
    private dt we;
    private boolean x9;
    private int yO;
    private char[] yS;

    public gq(cc ccVar, gv gvVar) {
        this.gn = new do();
        this.tp = new dt();
        this.we = new dt();
        this.J0 = new dt();
        this.J8 = new dx();
        this.Ws = new dl();
        this.a8 = new char[1000];
        this.lg = new char[1000];
        this.yS = new char[1000];
        this.BT = new dt();
        this.vy = new dt();
        this.P8 = new do();
        this.ei = new do();
        this.nw = new do();
        this.SI = new do();
        this.KD = new do();
        this.ro = new do();
        this.cn = new dt();
        this.DW = ccVar.ro;
        this.FH = ccVar.cn;
        this.Hw = ccVar.cb;
        this.Zo = ccVar;
        this.v5 = gvVar;
        this.VH = new go();
        this.j6 = gvVar.we();
        this.Sf = new ea(this.Hw);
        this.dx = new ea(this.Hw);
        this.u7 = new ea(this.Hw);
        this.EQ = new ea(this.Hw);
        this.sh = new ea(this.Hw);
        this.cb = new ea(this.Hw);
        this.jJ = ep.j6().DW();
    }

    protected void j6() {
        this.VH = new go();
    }

    private boolean DW() {
        return this.Zo.P8 != null && this.Zo.P8.Zo();
    }

    public void j6(List<cj> list, boolean z) {
        for (cj cjVar : list) {
            if (cjVar.tp() == this.v5) {
                j6(cjVar, z);
                return;
            }
        }
    }

    private void j6(cj cjVar, boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        try {
            String DW = this.Zo.cn.DW(cjVar.we());
            if (DW.equals("1.5")) {
                this.sy = false;
                this.aj = true;
                this.lp = false;
                this.OW = false;
                this.br = false;
                this.XX = false;
                this.yO = 0;
                this.XG = 49;
            } else if (DW.equals("1.4")) {
                this.sy = true;
                this.aj = false;
                this.lp = true;
                this.OW = false;
                this.br = false;
                this.XX = false;
                this.yO = 0;
                this.XG = 48;
            } else if (DW.equals("1.3")) {
                this.sy = true;
                this.aj = false;
                this.lp = true;
                this.OW = false;
                this.br = false;
                this.XX = true;
                this.yO = 0;
                this.XG = 46;
            } else {
                this.sy = true;
                this.aj = false;
                this.lp = true;
                this.OW = true;
                this.br = true;
                this.XX = true;
                this.yO = 3;
                this.XG = 45;
            }
            if (this.Zo.cn.Hw(cjVar.we())) {
                z2 = false;
                z3 = z;
            }
            this.kQ = this.Zo.cn.gn(cjVar.we());
            j6(cjVar, z3, z2, false);
        } catch (Exception e) {
            System.out.println(cjVar.we().er());
            e.printStackTrace(System.out);
        }
    }

    private void j6(cj cjVar, boolean z, boolean z2, boolean z3) {
        this.g3 = 1;
        this.I = false;
        this.ca = cjVar.we().er();
        this.x9 = true;
        j6(cjVar);
        for (int i = 0; i < this.gn.Hw(); i++) {
            int FH = this.gn.FH(i);
            this.XL = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(FH));
            this.aM = v5(this.XL);
            this.j3 = Hw(this.XL);
            this.vJ = false;
            this.Qq = false;
            j6(z3, false, cjVar, FH);
            boolean z4 = z3;
            j6(z4, false, "adrt/", new String[]{"ADRTLogCatReader", "ADRTSender"});
            if (this.sy) {
                j6(z3, false, gp.DW);
            }
            if (this.XL.rN().iW().startsWith("com.aide.trainer.")) {
                j6(z3, false, gp.Hw);
            }
        }
        this.x9 = false;
        j6(cjVar);
        for (int i2 = 0; i2 < this.gn.Hw(); i2++) {
            int FH2 = this.gn.FH(i2);
            this.XL = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(FH2));
            this.aM = v5(this.XL);
            if (!this.XL.g3()) {
                this.vJ = true;
                this.Qq = true;
                OutputStream j6 = this.Zo.dx.j6(this.XL, DW(this.XL) + "$0$debug.class", j6(this.XL) + "$0$debug", z3, true);
                if (j6 != null) {
                    u7(this.XL);
                    this.VH.j6(cjVar.we().v5(), 1, this.lg, 0, this.er, j6(this.XL) + "$0$debug", this.XG, this.yO);
                    this.dx.j6();
                    this.vy.DW();
                    this.BT.DW();
                    this.P8.j6();
                    this.ei.j6();
                    this.SI.j6();
                    this.KD.j6();
                    this.ro.j6();
                    this.cn.DW();
                    this.VH.j6("java/lang/Object");
                    FH(cjVar, cjVar.Hw(FH2, cjVar.lg(FH2) - 1));
                    this.VH.j6(j6);
                    j6.close();
                }
            }
            this.vJ = false;
            this.Qq = false;
            j6(z3, true, cjVar, FH2);
            z4 = z3;
            j6(z4, true, "adrt/", new String[]{"ADRT", "ADRTLogCatReader", "ADRTReceiver", "ADRTReflector", "ADRTSender", "ADRTThread", "ADRTThreadLocal", "ADRTLongMap", "ADRTLongSet"});
            if (this.sy) {
                j6(z3, true, gp.DW);
            }
            if (this.XL.rN().iW().startsWith("com.aide.trainer.")) {
                j6(z3, true, gp.Hw);
            }
        }
    }

    public void j6(bh bhVar) {
        if ((this.Zo instanceof ba) && (bhVar instanceof gs)) {
            bv FH;
            ak akVar = ((ba) this.Zo).DW;
            dt dtVar = new dt();
            do doVar = new do();
            eb Hw = this.FH.Hw();
            Hw.j6.j6();
            while (Hw.j6.DW()) {
                FH = Hw.j6.FH();
                if (FH.BT() == bhVar) {
                    doVar.DW(FH.vy());
                    dtVar.j6(FH.gn(), FH.vy());
                }
            }
            doVar.v5();
            dtVar.j6.j6();
            while (dtVar.j6.DW()) {
                try {
                    OutputStream j6 = this.Zo.dx.j6(this.FH.gn(dtVar.j6.Hw()), "adrt/", "ADRTMetadata", false, true);
                    if (j6 != null) {
                        int i;
                        int i2;
                        bv gn;
                        this.VH.j6("ADRTMetadata.java", 1, "adrt/ADRTMetadata".toCharArray(), 0, "adrt/ADRTMetadata".length(), "adrt.ADRTMetadata", 49, 0);
                        this.VH.j6("java/lang/Object");
                        this.VH.j6(9, "FILE_IDS", "[I", true, false);
                        this.VH.j6(9, "FILE_NAMES", "[Ljava/lang/String;", true, false);
                        this.VH.j6(9, "FILE_CALLED_FILES", "[[I", true, false);
                        this.VH.j6(9, "FILE_CALLING_FILES", "[[I", true, false);
                        this.VH.j6(24, "<clinit>", "()V".toCharArray(), 0, 3, false, false, true);
                        this.VH.gn(doVar.Hw());
                        this.VH.j6("[I", 1);
                        for (i = 0; i < doVar.Hw(); i++) {
                            this.VH.er();
                            this.VH.gn(i);
                            this.VH.gn(doVar.FH(i));
                            this.VH.gW();
                        }
                        this.VH.j6("adrt/ADRTMetadata", "FILE_IDS", "[I");
                        this.VH.gn(doVar.Hw());
                        this.VH.j6("[Ljava/lang/String;", 1);
                        for (i = 0; i < doVar.Hw(); i++) {
                            FH = this.FH.gn(doVar.FH(i));
                            this.VH.er();
                            this.VH.gn(i);
                            this.VH.Zo(j6(FH));
                            this.VH.ei();
                        }
                        this.VH.j6("adrt/ADRTMetadata", "FILE_NAMES", "[Ljava/lang/String;");
                        this.VH.gn(doVar.Hw());
                        this.VH.j6("[[I", 1);
                        do doVar2 = new do();
                        for (i2 = 0; i2 < doVar.Hw(); i2++) {
                            gn = this.FH.gn(doVar.FH(i2));
                            doVar2.j6();
                            akVar.j6(gn, doVar2);
                            doVar2.v5();
                            if (doVar2.Hw() > 0) {
                                this.VH.er();
                                this.VH.gn(i2);
                                this.VH.gn(doVar2.Hw());
                                this.VH.j6("[I", 1);
                                for (i = 0; i < doVar2.Hw(); i++) {
                                    this.VH.er();
                                    this.VH.gn(i);
                                    this.VH.gn(doVar2.FH(i));
                                    this.VH.gW();
                                }
                                this.VH.ei();
                            }
                        }
                        this.VH.j6("adrt/ADRTMetadata", "FILE_CALLED_FILES", "[[I");
                        this.VH.gn(doVar.Hw());
                        this.VH.j6("[[I", 1);
                        for (i2 = 0; i2 < doVar.Hw(); i2++) {
                            gn = this.FH.gn(doVar.FH(i2));
                            doVar2.j6();
                            akVar.DW(gn, doVar2);
                            doVar2.v5();
                            if (doVar2.Hw() > 0) {
                                this.VH.er();
                                this.VH.gn(i2);
                                this.VH.gn(doVar2.Hw());
                                this.VH.j6("[I", 1);
                                for (i = 0; i < doVar2.Hw(); i++) {
                                    this.VH.er();
                                    this.VH.gn(i);
                                    this.VH.gn(doVar2.FH(i));
                                    this.VH.gW();
                                }
                                this.VH.ei();
                            }
                        }
                        this.VH.j6("adrt/ADRTMetadata", "FILE_CALLING_FILES", "[[I");
                        this.VH.we();
                        this.VH.j6(j6);
                        j6.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    private void j6(boolean z, boolean z2, cj cjVar, int i) {
        OutputStream j6 = this.Zo.dx.j6(this.XL, DW(this.XL) + ".class", j6(this.XL), z, z2);
        if (j6 != null) {
            int i2;
            int j62 = j6(this.XL, false);
            if ((j62 & 4) != 0) {
                j62 = (j62 & -5) | 1;
            }
            if (this.XL.Mz()) {
                dr lp = this.XL.lp();
                lp.j6.j6();
                int i3 = j62;
                while (lp.j6.DW()) {
                    bz bzVar = (bz) lp.j6.Hw();
                    if (cd.XL(bzVar.Ev()) && bzVar.Xa() == this.XL) {
                        j62 = i3 | 1024;
                    } else {
                        j62 = i3;
                    }
                    i3 = j62;
                }
                i2 = i3;
            } else {
                i2 = j62;
            }
            DW(this.XL, false);
            this.VH.j6(cjVar.we().v5(), i2, this.a8, 0, this.rN, j6(this.XL), this.XG, this.yO);
            if (VH(this.XL)) {
                FH(this.XL);
                this.VH.Zo(this.a8, 0, this.rN);
            }
            this.dx.j6();
            DW(this.XL);
            DW(cjVar, i);
            this.vy.DW();
            this.BT.DW();
            this.P8.j6();
            this.ei.j6();
            this.SI.j6();
            this.KD.j6();
            this.ro.j6();
            this.cn.DW();
            Hw(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            this.VH.pO();
            v5(cjVar, cjVar.Hw(i, 0));
            if (!DW()) {
                this.VH.j6(j6);
                j6.close();
            }
        }
    }

    private void j6(boolean z, boolean z2, String str, String[] strArr) {
        for (String str2 : strArr) {
            OutputStream j6 = this.Zo.dx.j6(this.XL.tp(), str, str2, z, z2);
            if (j6 != null) {
                try {
                    InputStream j62 = ep.j6().j6(str + str2 + ".class");
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = j62.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j6.write(bArr, 0, read);
                    }
                    j6.close();
                    j62.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String j6(bv bvVar) {
        dq FH = this.Zo.cb.FH(bvVar);
        if (FH.FH() <= 0) {
            return "";
        }
        return ((bp) FH.DW()).rN().iW().replace('.', '/') + "/" + bvVar.v5();
    }

    private void j6(boolean z, boolean z2, String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i][0];
            String str2 = strArr[i][1];
            OutputStream j6 = this.Zo.dx.j6(this.XL.tp(), "", str, z, z2);
            if (j6 != null) {
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    j6.write((byte) (str2.charAt(i2) - 512));
                }
                j6.close();
            }
        }
    }

    private int j6(bs bsVar, boolean z) {
        int Ev;
        int i = 0;
        if (bsVar.cT()) {
            Ev = ((bp) bsVar).Ev();
        } else {
            Ev = 0;
        }
        if (bsVar.zh()) {
            Ev = ((bz) bsVar).Ev();
        }
        if (cd.J0(Ev)) {
            i = 1;
        }
        if (z && cd.QX(Ev)) {
            i |= 2;
        }
        if (cd.J8(Ev)) {
            i |= 4;
        }
        if (z && cd.aM(Ev)) {
            i |= 8;
        }
        if (cd.Zo(Ev)) {
            i |= 16;
        }
        if (cd.u7(Ev)) {
            i |= 16;
        }
        if (cd.gn(Ev)) {
            i |= 16;
        }
        if (cd.XL(Ev)) {
            i |= 1024;
        }
        if (cd.Hw(Ev)) {
            i |= 256;
        }
        if ((Ev & 2048) != 0) {
            i |= 32;
        }
        if ((Ev & 4096) != 0) {
            i |= 128;
        }
        if ((Ev & 1024) != 0) {
            i |= 64;
        }
        if ((Ev & 8192) != 0) {
            i |= 2048;
        }
        if (bsVar.fY()) {
            if (((co) bsVar).g3()) {
                i |= 512;
            } else {
                i |= 32;
            }
        }
        if (!this.aj) {
            return i;
        }
        if (bsVar.fY() && ((co) bsVar).Mz()) {
            i |= 16384;
        }
        if (bsVar.fY() && this.j6.FH((co) bsVar)) {
            return i | 8192;
        }
        return i;
    }

    private int j6(bs bsVar, char[] cArr, int i, boolean z) {
        int i2 = 0;
        if (bsVar.fY()) {
            char v5 = v5(bsVar);
            if (v5 != '\u0000') {
                if (i == -1) {
                    return -1;
                }
                if (i >= cArr.length) {
                    return -1;
                }
                cArr[i] = v5;
                return i + 1;
            }
        }
        if (bsVar.n5()) {
            return j6(((cf) bsVar).gn(), cArr, i, z);
        }
        int i3;
        if (bsVar.AL()) {
            if (i >= cArr.length) {
                return -1;
            }
            i3 = i + 1;
            cArr[i] = '[';
            return j6(((bo) bsVar).FH(), cArr, i3, true);
        } else if (bsVar.q7()) {
            return j6(((cg) bsVar).a_(), cArr, i, z);
        } else {
            if (bsVar.Z1()) {
                return j6(((ca) bsVar).a_(), cArr, i, z);
            }
            bs FH;
            int j6;
            if (bsVar.qp()) {
                if (bsVar == this.Hw.Zo()) {
                    return i;
                }
                FH = ((ce) bsVar).FH();
                j6 = j6(FH, cArr, i, z);
                if (j6 == -1) {
                    return -1;
                }
                if (j6 >= cArr.length) {
                    return -1;
                }
                if (FH != this.Hw.Zo()) {
                    i3 = j6 + 1;
                    cArr[j6] = '/';
                } else {
                    i3 = j6;
                }
                i3 = this.DW.j6(((ce) bsVar).aq(), cArr, i3);
                if (i3 == -1) {
                    return -1;
                }
                return i3;
            } else if (bsVar.cT()) {
                String str;
                bsVar = (bp) bsVar;
                if (z) {
                    if (i >= cArr.length) {
                        return -1;
                    }
                    i3 = i + 1;
                    cArr[i] = 'L';
                    i = i3;
                }
                if (this.sy) {
                    try {
                        if (this.sy && bsVar == this.j6.J0(bsVar.tp())) {
                            str = "javalangEnum";
                            if (str.length() + i >= cArr.length) {
                                return -1;
                            }
                            i3 = 0;
                            j6 = i;
                            while (i3 < str.length()) {
                                try {
                                    i = j6 + 1;
                                    cArr[j6] = str.charAt(i3);
                                    i3++;
                                    j6 = i;
                                } catch (ej e) {
                                    i = j6;
                                }
                            }
                            if (z) {
                                if (j6 == -1) {
                                    return -1;
                                }
                                if (j6 >= cArr.length) {
                                    return -1;
                                }
                                i3 = j6 + 1;
                                try {
                                    cArr[j6] = ';';
                                    return i3;
                                } catch (ej e2) {
                                    i = i3;
                                }
                            }
                            return j6;
                        } else if (this.sy && bsVar == this.j6.u7(bsVar.tp())) {
                            str = "javalangIterable";
                            if (str.length() + i >= cArr.length) {
                                return -1;
                            }
                            i3 = 0;
                            j6 = i;
                            while (i3 < str.length()) {
                                i = j6 + 1;
                                cArr[j6] = str.charAt(i3);
                                i3++;
                                j6 = i;
                            }
                            if (z) {
                                if (j6 == -1) {
                                    return -1;
                                }
                                if (j6 >= cArr.length) {
                                    return -1;
                                }
                                i3 = j6 + 1;
                                cArr[j6] = ';';
                                return i3;
                            }
                            return j6;
                        }
                    } catch (ej e3) {
                    }
                }
                if (bsVar.hz()) {
                    FH = bsVar.rN();
                    j6 = bsVar.aq();
                    if (FH == this.j6.Mr()) {
                        i3 = this.DW.j6(j6, cArr, i);
                        if (i3 == -1) {
                            return -1;
                        }
                    }
                    i3 = j6(FH, cArr, i, false);
                    if (i3 == -1) {
                        return -1;
                    }
                    if (i3 >= cArr.length) {
                        return -1;
                    }
                    i2 = i3 + 1;
                    cArr[i3] = '/';
                    i3 = this.DW.j6(j6, cArr, i2);
                    if (i3 == -1) {
                        return -1;
                    }
                    j6 = i3;
                } else {
                    j6 = j6(bsVar.Xa(), cArr, i, false);
                    if (j6 == -1) {
                        return -1;
                    }
                    if (j6 >= cArr.length) {
                        return -1;
                    }
                    i3 = j6 + 1;
                    cArr[j6] = '$';
                    if (bsVar.Eq()) {
                        str = bsVar.EQ() + "$";
                        if (str.length() + i3 >= cArr.length) {
                            return -1;
                        }
                        j6 = i3;
                        i3 = 0;
                        while (i3 < str.length()) {
                            i2 = j6 + 1;
                            cArr[j6] = str.charAt(i3);
                            i3++;
                            j6 = i2;
                        }
                    } else {
                        j6 = i3;
                    }
                    j6 = this.DW.j6(j6(bsVar.aq(), bsVar), cArr, j6);
                    if (j6 == -1) {
                        return -1;
                    }
                }
                if (z) {
                    if (j6 == -1) {
                        return -1;
                    }
                    if (j6 >= cArr.length) {
                        return -1;
                    }
                    i3 = j6 + 1;
                    cArr[j6] = ';';
                    return i3;
                }
                return j6;
            } else if (!bsVar.zh() || !((bz) bsVar).gn()) {
                return (bsVar.zh() && ((bz) bsVar).u7()) ? j6(((bz) bsVar).Mz(), cArr, i, true) : 0;
            } else {
                bz bzVar = (bz) bsVar;
                if (i >= cArr.length) {
                    return -1;
                }
                i3 = i + 1;
                cArr[i] = '(';
                if (bzVar.sy() && bzVar.Xa().J0()) {
                    i3 = j6(bzVar.Xa().Xa(), cArr, i3, true);
                    if (i3 == -1) {
                        return -1;
                    }
                }
                while (i2 < bzVar.lp()) {
                    i3 = j6(bzVar.v5(i2), cArr, i3, true);
                    if (i3 == -1) {
                        return -1;
                    }
                    i2++;
                }
                if (i3 >= cArr.length) {
                    return -1;
                }
                j6 = i3 + 1;
                cArr[i3] = ')';
                if (bzVar.sy()) {
                    return j6(this.j6.u7(), cArr, j6, true);
                }
                return j6(bzVar.Mz(), cArr, j6, true);
            }
        }
    }

    private char v5(bs bsVar) {
        switch (((co) bsVar).Gj()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return 'V';
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return 'N';
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return 'B';
            case 5:
                return 'S';
            case 7:
                return 'I';
            case 9:
                return 'J';
            case 11:
                return 'Z';
            case 12:
                return 'C';
            case 13:
                return 'F';
            case 14:
                return 'D';
            default:
                return '\u0000';
        }
    }

    private int j6(int i, bs bsVar) {
        return !Zo(bsVar) ? i : this.DW.j6("$$" + bsVar.EQ());
    }

    private boolean Zo(bs bsVar) {
        if (bsVar.tp() == null || !this.Zo.cn.VH(bsVar.tp())) {
            return false;
        }
        if (cd.Hw(bsVar.Ev())) {
            return false;
        }
        if (bsVar.Q6()) {
            return true;
        }
        if (bsVar.zh() && ((bz) bsVar).gn()) {
            return false;
        }
        if (bsVar.cT()) {
            bsVar = (bp) bsVar;
        } else {
            bsVar = bsVar.Xa();
        }
        while (!bsVar.hz()) {
            if (bsVar.Q6()) {
                return true;
            }
            bsVar = bsVar.Xa();
        }
        return false;
    }

    public String j6(bs bsVar) {
        if (bsVar.zh() && ((bz) bsVar).sy()) {
            return "<init>";
        }
        if (Zo(bsVar)) {
            return "$$" + bsVar.EQ();
        }
        return bsVar.eU();
    }

    private String DW(bp bpVar) {
        if (bpVar.hz()) {
            return this.DW.j6(bpVar.aq());
        }
        if (bpVar.Eq()) {
            return DW(bpVar.Xa()) + '$' + bpVar.EQ() + "$" + this.DW.j6(j6(bpVar.aq(), (bs) bpVar));
        }
        return DW(bpVar.Xa()) + '$' + this.DW.j6(j6(bpVar.aq(), (bs) bpVar));
    }

    public String DW(bs bsVar) {
        char[] cArr = new char[10];
        int i = 0;
        while (true) {
            try {
                i = j6(bsVar, cArr, 0, false);
                if (i != -1) {
                    break;
                }
                cArr = new char[((cArr.length * 2) + 1)];
            } catch (ej e) {
            }
        }
        return new String(cArr, 0, i);
    }

    public String j6(bp bpVar) {
        char[] cArr = new char[10];
        int i = 0;
        while (true) {
            try {
                i = j6((bs) bpVar, cArr, 0, false);
                if (i != -1) {
                    break;
                }
                cArr = new char[((cArr.length * 2) + 1)];
            } catch (ej e) {
            }
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] == '/') {
                cArr[i2] = '.';
            }
        }
        return new String(cArr, 0, i);
    }

    private ea<bz> j6(bz bzVar) {
        if (bzVar.I() || bzVar.Xa().g3()) {
            return null;
        }
        ea cb = bzVar.cb();
        if (cb.Hw() == 0) {
            return null;
        }
        this.sh.j6();
        cb.j6.j6();
        while (cb.j6.DW()) {
            bz bzVar2 = (bz) cb.j6.FH();
            try {
                if (!j6(bzVar, bzVar2)) {
                    this.sh.j6((bs) bzVar2);
                }
                if (bzVar2.Xa().g3()) {
                    DW(bzVar2);
                }
            } catch (ej e) {
            }
        }
        this.cb.j6();
        this.sh.j6.j6();
        while (this.sh.j6.DW()) {
            bs bsVar = (bz) this.sh.j6.FH();
            if (!j6(bsVar, (bs) bzVar)) {
                this.cb.j6.j6();
                while (this.cb.j6.DW()) {
                    if (j6(bsVar, (bz) this.cb.j6.FH())) {
                        break;
                    }
                }
                this.cb.j6(bsVar);
            }
        }
        return this.cb;
    }

    private void DW(bz bzVar) {
        ea cb = bzVar.cb();
        cb.j6.j6();
        while (cb.j6.DW()) {
            bz bzVar2 = (bz) cb.j6.FH();
            try {
                if (!j6(bzVar2, bzVar)) {
                    this.sh.j6((bs) bzVar2);
                }
                if (bzVar2.Xa().g3()) {
                    DW(bzVar2);
                }
            } catch (ej e) {
            }
        }
    }

    private boolean j6(bz bzVar, bz bzVar2) {
        if (!j6(bzVar.Mz(), bzVar2.Mz())) {
            return false;
        }
        int lp = bzVar.lp();
        for (int i = 0; i < lp; i++) {
            if (!j6(bzVar.v5(i), bzVar2.v5(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean j6(bs bsVar, bs bsVar2) {
        if (bsVar == bsVar2) {
            return true;
        }
        int j6;
        char[] cArr = new char[10];
        char[] cArr2 = new char[10];
        while (true) {
            try {
                j6 = j6(bsVar, cArr2, 0, true);
                if (j6 != -1) {
                    break;
                }
                cArr2 = new char[((cArr2.length * 2) + 1)];
            } catch (ej e) {
                return true;
            }
        }
        char[] cArr3 = cArr;
        while (true) {
            int j62 = j6(bsVar2, cArr3, 0, true);
            if (j62 != -1) {
                break;
            }
            cArr3 = new char[((cArr3.length * 2) + 1)];
        }
        if (j6 != j62) {
            return false;
        }
        for (j62 = 0; j62 < j6; j62++) {
            if (cArr2[j62] != cArr3[j62]) {
                return false;
            }
        }
        return true;
    }

    private boolean VH(bs bsVar) {
        try {
            int WB;
            int i;
            if (bsVar.cT()) {
                if (((bp) bsVar).XX() > 0) {
                    return true;
                }
                WB = ((bp) bsVar).WB();
                for (i = 0; i < WB; i++) {
                    if (!j6(((bp) bsVar).v5(i))) {
                        return true;
                    }
                }
            } else {
                if (bsVar.zh()) {
                    if (((bz) bsVar).gn()) {
                        if (((bz) bsVar).OW() > 0) {
                            return true;
                        }
                        if (!((bz) bsVar).sy()) {
                            if (!j6(((bz) bsVar).Mz())) {
                                return true;
                            }
                        }
                        WB = ((bz) bsVar).lp();
                        for (i = 0; i < WB; i++) {
                            if (!j6(((bz) bsVar).v5(i))) {
                                return true;
                            }
                        }
                        WB = ((bz) bsVar).rN();
                        for (i = 0; i < WB; i++) {
                            if (!j6(((bz) bsVar).DW(i))) {
                                return true;
                            }
                        }
                    }
                }
                if (bsVar.zh()) {
                    if (((bz) bsVar).u7()) {
                        return !j6(((bz) bsVar).Mz());
                    }
                }
            }
        } catch (ej e) {
        }
        return false;
    }

    private boolean j6(co coVar) {
        return this.j6.j6(coVar) || coVar.cT() || (coVar.AL() && j6(((bo) coVar).FH()));
    }

    private int j6(bs bsVar, char[] cArr, int i) {
        int i2 = 0;
        if (bsVar.fY()) {
            char v5 = v5(bsVar);
            if (v5 != '\u0000') {
                if (i == -1) {
                    return -1;
                }
                if (i >= cArr.length) {
                    return -1;
                }
                cArr[i] = v5;
                return i + 1;
            }
        }
        if (bsVar.n5()) {
            return j6((cf) bsVar, ((cf) bsVar).gn(), ((cf) bsVar).DW().length, cArr, i);
        } else if (bsVar.AL()) {
            if (i >= cArr.length) {
                return -1;
            }
            r0 = i + 1;
            cArr[i] = '[';
            if (r0 >= cArr.length) {
                return -1;
            }
            return j6(((bo) bsVar).FH(), cArr, r0);
        } else if (bsVar.q7()) {
            if (i >= cArr.length) {
                return -1;
            }
            r0 = i + 1;
            cArr[i] = 'T';
            r0 = this.DW.j6(((cg) bsVar).aq(), cArr, r0);
            if (r0 == -1) {
                return -1;
            }
            if (r0 >= cArr.length) {
                return -1;
            }
            r1 = r0 + 1;
            cArr[r0] = ';';
            return r1;
        } else if (bsVar.Z1()) {
            if (i >= cArr.length) {
                return -1;
            }
            r0 = i + 1;
            cArr[i] = 'T';
            r0 = this.DW.j6(((ca) bsVar).aq(), cArr, r0);
            if (r0 == -1) {
                return -1;
            }
            if (r0 >= cArr.length) {
                return -1;
            }
            r1 = r0 + 1;
            cArr[r0] = ';';
            return r1;
        } else if (bsVar.zh() && ((bz) bsVar).gn()) {
            int i3;
            if (((bz) bsVar).OW() > 0) {
                if (i >= cArr.length) {
                    return -1;
                }
                r0 = i + 1;
                cArr[i] = '<';
                i3 = r0;
                for (r1 = 0; r1 < ((bz) bsVar).OW(); r1++) {
                    ca gn = ((bz) bsVar).gn(r1);
                    i3 = this.DW.j6(gn.aq(), cArr, i3);
                    if (i3 == -1) {
                        return -1;
                    }
                    int Zo = gn.Zo();
                    if (Zo > 0) {
                        for (r0 = 0; r0 < Zo; r0++) {
                            bs j6 = gn.j6(r0);
                            if (i3 >= cArr.length) {
                                return -1;
                            }
                            int i4 = i3 + 1;
                            cArr[i3] = ':';
                            i3 = j6(j6, cArr, i4);
                            if (i3 == -1) {
                                return -1;
                            }
                        }
                        continue;
                    }
                }
                if (i3 >= cArr.length) {
                    return -1;
                }
                i = i3 + 1;
                cArr[i3] = '>';
            }
            if (i >= cArr.length) {
                return -1;
            }
            r1 = i + 1;
            cArr[i] = '(';
            if (((bz) bsVar).sy() && ((bz) bsVar).Xa().J0()) {
                r0 = j6(((bz) bsVar).Xa().Xa(), cArr, r1);
                if (r0 == -1) {
                    return -1;
                }
            }
            r0 = r1;
            i3 = r0;
            for (r1 = 0; r1 < ((bz) bsVar).lp(); r1++) {
                i3 = j6(((bz) bsVar).v5(r1), cArr, i3);
                if (i3 == -1) {
                    return -1;
                }
            }
            if (i3 >= cArr.length) {
                return -1;
            }
            r1 = i3 + 1;
            cArr[i3] = ')';
            if (((bz) bsVar).sy()) {
                r1 = j6(this.j6.u7(), cArr, r1);
            } else {
                r1 = j6(((bz) bsVar).Mz(), cArr, r1);
            }
            if (r1 == -1) {
                return -1;
            }
            if (((bz) bsVar).rN() <= 0) {
                return r1;
            }
            while (i2 < ((bz) bsVar).rN()) {
                if (r1 >= cArr.length) {
                    return -1;
                }
                i3 = r1 + 1;
                cArr[r1] = '^';
                r0 = j6(((bz) bsVar).DW(i2), cArr, i3);
                if (r0 == -1) {
                    return -1;
                }
                i2++;
                r1 = r0;
            }
            return r1;
        } else if (bsVar.zh() && ((bz) bsVar).u7()) {
            return j6(((bz) bsVar).Mz(), cArr, i);
        } else {
            return bsVar.cT() ? j6(bsVar, cArr, i, true) : 0;
        }
    }

    private int j6(cf cfVar, bp bpVar, int i, char[] cArr, int i2) {
        int j6;
        int[] FH = cfVar.FH();
        co[] DW = cfVar.DW();
        int XX = bpVar.XX();
        int i3 = i - XX;
        if (bpVar.J0()) {
            j6 = j6(cfVar, bpVar.Xa(), i3, cArr, i2);
            if (j6 == -1) {
                return -1;
            }
            if (j6 >= cArr.length) {
                return -1;
            }
            i2 = j6 + 1;
            cArr[j6] = '.';
        }
        j6 = j6((bs) bpVar, cArr, i2);
        if (j6 == -1) {
            return -1;
        }
        int i4;
        j6--;
        if (XX > 0) {
            if (j6 >= cArr.length) {
                return -1;
            }
            i4 = j6 + 1;
            cArr[j6] = '<';
            int i5 = 0;
            int i6 = i4;
            i4 = i3;
            i3 = i6;
            while (i5 < XX) {
                try {
                    int i7;
                    switch (FH[i4]) {
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            if (i3 < cArr.length) {
                                j6 = i3 + 1;
                                try {
                                    cArr[i3] = '*';
                                    continue;
                                } catch (ej e) {
                                    break;
                                }
                            }
                            return -1;
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            if (i3 < cArr.length) {
                                j6 = i3 + 1;
                                cArr[i3] = '+';
                                i7 = i4 + 1;
                                try {
                                    j6 = j6(DW[i4], cArr, j6);
                                    if (j6 == -1) {
                                        return -1;
                                    }
                                } catch (ej e2) {
                                    i4 = i7;
                                    break;
                                }
                            }
                            return -1;
                            break;
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            if (i3 >= cArr.length) {
                                return -1;
                            }
                            j6 = i3 + 1;
                            cArr[i3] = '-';
                            i7 = i4 + 1;
                            j6 = j6(DW[i4], cArr, j6);
                            if (j6 == -1) {
                                return -1;
                            }
                            break;
                        default:
                            i7 = i4 + 1;
                            try {
                                j6 = j6(DW[i4], cArr, i3);
                                if (j6 == -1) {
                                    return -1;
                                }
                            } catch (ej e3) {
                                j6 = i3;
                                i4 = i7;
                                break;
                            }
                            break;
                    }
                    i4 = i7;
                } catch (ej e4) {
                    j6 = i3;
                }
                i5++;
                i3 = j6;
            }
            if (i3 >= cArr.length) {
                return -1;
            }
            j6 = i3 + 1;
            cArr[i3] = '>';
        }
        if (j6 >= cArr.length) {
            return -1;
        }
        i4 = j6 + 1;
        cArr[j6] = ';';
        return i4;
    }

    private int j6(bp bpVar, char[] cArr, int i) {
        int i2 = 0;
        if (bpVar.XX() > 0) {
            if (i >= cArr.length) {
                return -1;
            }
            int i3 = i + 1;
            cArr[i] = '<';
            int XX = bpVar.XX();
            for (int i4 = 0; i4 < XX; i4++) {
                cg j6 = bpVar.j6(i4);
                i3 = this.DW.j6(j6.aq(), cArr, i3);
                if (i3 == -1) {
                    return -1;
                }
                if (i3 >= cArr.length) {
                    return -1;
                }
                int i5 = i3 + 1;
                cArr[i3] = ':';
                int DW = j6.DW();
                i3 = i5;
                for (i5 = 0; i5 < DW; i5++) {
                    i3 = j6(j6.j6(i5), cArr, i3);
                    if (i3 == -1) {
                        return -1;
                    }
                }
            }
            if (i3 >= cArr.length) {
                return -1;
            }
            i = i3 + 1;
            cArr[i3] = '>';
        }
        while (i2 < bpVar.WB()) {
            i = j6(bpVar.v5(i2), cArr, i);
            if (i == -1) {
                return -1;
            }
            i2++;
        }
        return i;
    }

    public String FH(bs bsVar) {
        if (bsVar.cT()) {
            return j6((bp) bsVar);
        }
        return j6(((bz) bsVar).Xa());
    }

    public String Hw(bs bsVar) {
        return "adrt$enabled";
    }

    private String FH(bz bzVar) {
        if (bzVar.I()) {
            return bzVar.eU() + "$";
        }
        return bzVar.eU();
    }

    private void j6(cj cjVar) {
        this.Sf.j6();
        this.gn.j6();
        this.EQ.j6();
        this.we.DW();
        this.J0.DW();
        this.J8.j6();
        this.tp.DW();
        this.XL = null;
        this.Ws.j6();
        this.u7.j6();
        j6(cjVar, cjVar.Ws());
    }

    private void j6(cj cjVar, int i) {
        int i2 = 3;
        int i3 = 0;
        int aM;
        int Hw;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                bz bzVar;
                switch (cjVar.J8(i)) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        this.J8.DW(this.XL.v5(), cjVar.Ws(i));
                    case 16:
                        bzVar = (bz) cjVar.QX(i);
                        if (FH(bzVar, this.XL)) {
                            this.EQ.j6((bs) bzVar);
                        } else if (!this.x9 && Hw(bzVar, this.XL)) {
                            this.EQ.j6((bs) bzVar);
                        } else if (DW(cjVar, bzVar, cjVar.EQ(i), this.XL)) {
                            this.we.DW(((bp) cjVar.EQ(i).a_()).v5(), bzVar.v5());
                        } else if (DW(bzVar, cjVar.EQ(i), this.XL)) {
                            this.we.DW(((bp) cjVar.EQ(i).a_()).v5(), bzVar.v5());
                        }
                        if (!this.x9 && bzVar.Xa() == this.XL && !bzVar.I()) {
                            aM = cjVar.aM(cjVar.aM(i));
                            if (cjVar.rN(aM) == 172) {
                                Hw = cjVar.Hw(aM, 0);
                                int Hw2 = cjVar.Hw(aM, 2);
                                if (cjVar.rN(cjVar.Hw(aM, 1)) != 17) {
                                    return;
                                }
                                if ((cjVar.rN(Hw) != 159 || cjVar.rN(cjVar.Hw(Hw, 0)) != 166) && (cjVar.rN(Hw) != ProxyTextView.INPUTTYPE_textWebEditText || cjVar.lg(Hw) != 1)) {
                                    return;
                                }
                                if ((cjVar.rN(Hw2) == 159 && cjVar.rN(cjVar.Hw(Hw2, 0)) == 166) || (cjVar.rN(Hw2) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(Hw2) == 1)) {
                                    aM = cjVar.Hw(Hw2, cjVar.lg(Hw2) - 1);
                                    if (cjVar.J8(aM) == 2 && cjVar.rN(cjVar.aM(cjVar.Ws(aM))) == 191) {
                                        switch (bzVar.Mz().Gj()) {
                                            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                                            case 5:
                                            case 7:
                                            case 9:
                                            case 11:
                                            case 12:
                                            case 13:
                                            case 14:
                                                break;
                                            default:
                                                if (bzVar.Mz() != this.j6.lg(cjVar.we())) {
                                                    return;
                                                }
                                                break;
                                        }
                                        this.tp.DW(this.XL.v5(), bzVar.v5());
                                    }
                                }
                            }
                        }
                    case ProxyTextView.INPUTTYPE_date /*20*/:
                        bzVar = (bz) cjVar.QX(i);
                        if (cjVar.rN(cjVar.aM(i)) == 157 && cjVar.lg(cjVar.aM(i)) > 5) {
                            this.J0.DW(((bp) cjVar.we(cjVar.Hw(cjVar.aM(i), 0))).v5(), bzVar.v5());
                        } else if (!this.x9 && cjVar.rN(cjVar.aM(i)) == 157) {
                            this.J0.DW(this.XL.v5(), bzVar.v5());
                        } else if (j6(bzVar, this.XL)) {
                            this.EQ.j6((bs) bzVar);
                        } else if (!this.x9 && DW(bzVar, this.XL)) {
                            this.EQ.j6((bs) bzVar);
                        } else if (j6(cjVar, bzVar, cjVar.EQ(i), this.XL)) {
                            this.we.DW(((bp) cjVar.EQ(i).a_()).v5(), bzVar.v5());
                        } else if (!this.x9 && j6(bzVar, cjVar.EQ(i), this.XL)) {
                            this.we.DW(((bp) cjVar.EQ(i).a_()).v5(), bzVar.v5());
                        }
                    default:
                }
            case 120:
            case 121:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
            case 220:
            case 221:
            case 222:
            case 227:
            case 228:
                this.Ws.DW();
                this.gn.DW(i);
                bp bpVar = this.XL;
                this.XL = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i));
                Hw = cjVar.lg(i);
                for (i2 = 0; i2 < Hw; i2++) {
                    j6(cjVar, cjVar.Hw(i, i2));
                }
                do doVar = new do();
                ea jO = this.XL.jO();
                jO.j6.j6();
                while (jO.j6.DW()) {
                    bp bpVar2 = (bp) jO.j6.FH();
                    if (this.J8.DW(bpVar2.v5())) {
                        this.J8.j6.j6(bpVar2.v5());
                        while (this.J8.j6.DW()) {
                            i2 = this.J8.j6.Hw();
                            if (!this.Ws.DW(i2, this.XL.v5())) {
                                doVar.DW(i2);
                            }
                        }
                    }
                    for (i2 = 0; i2 < doVar.Hw(); i2++) {
                        this.J8.DW(this.XL.v5(), doVar.FH(i2));
                    }
                }
                if (bpVar != null && this.J8.DW(this.XL.v5())) {
                    do doVar2 = new do();
                    this.J8.j6.j6(this.XL.v5());
                    while (this.J8.j6.DW()) {
                        Hw = this.J8.j6.Hw();
                        if (!this.Ws.DW(Hw, bpVar.v5())) {
                            doVar2.DW(Hw);
                        }
                    }
                    while (i3 < doVar2.Hw()) {
                        this.J8.DW(bpVar.v5(), doVar2.FH(i3));
                        i3++;
                    }
                }
                this.XL = bpVar;
                this.Ws.Hw();
            case 151:
                aM = cjVar.lg(i);
                while (i2 < aM) {
                    this.Ws.j6(cjVar.Hw(cjVar.Hw(i, i2), 0), 0, this.XL.v5());
                    i2 += 2;
                }
                while (i3 < aM) {
                    j6(cjVar, cjVar.Hw(i, i3));
                    i3++;
                }
            case 191:
                this.Ws.j6(cjVar.Hw(i, 3), 0, this.XL.v5());
            case 204:
                this.Ws.j6(cjVar.Hw(i, 4), 0, this.XL.v5());
                i2 = cjVar.lg(i);
                while (i3 < i2) {
                    j6(cjVar, cjVar.Hw(i, i3));
                    i3++;
                }
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                this.u7.j6(this.XL);
                i2 = cjVar.lg(i);
                while (i3 < i2) {
                    j6(cjVar, cjVar.Hw(i, i3));
                    i3++;
                }
            case 211:
                this.Ws.j6(cjVar.Hw(i, 5), 0, this.XL.v5());
                i2 = cjVar.lg(i);
                while (i3 < i2) {
                    j6(cjVar, cjVar.Hw(i, i3));
                    i3++;
                }
            default:
                i2 = cjVar.lg(i);
                while (i3 < i2) {
                    j6(cjVar, cjVar.Hw(i, i3));
                    i3++;
                }
        }
    }

    private boolean j6(bz bzVar, bp bpVar) {
        return bzVar.Q6() && bzVar.Xa() != bpVar;
    }

    private boolean DW(bz bzVar, bp bpVar) {
        return bzVar.Q6();
    }

    private boolean j6(bz bzVar, co coVar, bp bpVar) {
        if (coVar == null || !cd.J8(bzVar.Ev()) || this.j6.j6(bzVar) || bzVar.Xa().rN() == bpVar.rN()) {
            return false;
        }
        return true;
    }

    private boolean j6(cj cjVar, bz bzVar, co coVar, bp bpVar) {
        if (coVar == null || !cd.J8(bzVar.Ev())) {
            return false;
        }
        boolean z;
        co a_ = coVar.a_();
        if (!a_.cT() || bzVar.Xa().rN() == bpVar.rN() || bpVar == a_ || bpVar.FH(a_) || !bpVar.FH((bp) a_)) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private boolean FH(bz bzVar, bp bpVar) {
        return bzVar.Q6() && bzVar.Xa() != bpVar;
    }

    private boolean Hw(bz bzVar, bp bpVar) {
        return bzVar.Q6();
    }

    private boolean DW(cj cjVar, bz bzVar, co coVar, bp bpVar) {
        if (coVar == null || !cd.J8(bzVar.Ev())) {
            return false;
        }
        boolean z;
        co a_ = coVar.a_();
        if (!a_.cT() || bzVar.Xa().rN() == bpVar.rN() || bpVar == a_ || bpVar.FH(a_) || !bpVar.FH((bp) a_)) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    private boolean DW(bz bzVar, co coVar, bp bpVar) {
        if (coVar == null || !cd.J8(bzVar.Ev()) || bzVar.Xa().rN() == bpVar.rN()) {
            return false;
        }
        return true;
    }

    private String FH() {
        return "$assertionsDisabled";
    }

    private String Hw() {
        return "this$0";
    }

    private String v5() {
        return "access$0";
    }

    private String j6(int i) {
        return "block$" + i;
    }

    private String j6(String str) {
        return "val$" + str;
    }

    private String Hw(bz bzVar) {
        if (bzVar.Q6()) {
            return "access$" + bzVar.EQ();
        }
        return "access$" + DW(bzVar.Xa().iW()) + "$" + bzVar.EQ();
    }

    private String v5(bz bzVar) {
        return "access$S" + DW(bzVar.Xa().iW()) + "$" + bzVar.EQ();
    }

    private String Zo(bz bzVar) {
        if (bzVar.Q6()) {
            return "access$L" + bzVar.EQ();
        }
        return "access$L" + DW(bzVar.Xa().iW()) + "$" + bzVar.EQ();
    }

    private String VH(bz bzVar) {
        if (bzVar.Q6()) {
            return "access$S" + bzVar.EQ();
        }
        return "access$S" + DW(bzVar.Xa().iW()) + "$" + bzVar.EQ();
    }

    private String DW(String str) {
        return str.replace('.', '$');
    }

    private void DW(int i) {
        while (true) {
            int j6 = this.DW.j6(i, this.yS, 0);
            this.gW = j6;
            if (j6 == -1) {
                this.yS = new char[((this.yS.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void DW(bs bsVar, boolean z) {
        while (true) {
            int j6 = j6(bsVar, this.a8, 0, z);
            this.rN = j6;
            if (j6 == -1) {
                this.a8 = new char[((this.a8.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void gn(bs bsVar) {
        while (true) {
            int j6 = j6(bsVar, this.a8, 0);
            this.rN = j6;
            if (j6 == -1) {
                this.a8 = new char[((this.a8.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void FH(bp bpVar) {
        while (true) {
            int j6 = j6(bpVar, this.a8, 0);
            this.rN = j6;
            if (j6 == -1) {
                this.a8 = new char[((this.a8.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void FH(bs bsVar, boolean z) {
        while (true) {
            int j6 = j6(bsVar, this.lg, 0, z);
            this.er = j6;
            if (j6 == -1) {
                this.lg = new char[((this.lg.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void u7(bs bsVar) {
        while (true) {
            int DW = DW(bsVar, this.lg, 0);
            this.er = DW;
            if (DW == -1) {
                this.lg = new char[((this.lg.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private int DW(bs bsVar, char[] cArr, int i) {
        int i2 = 0;
        int j6 = j6(bsVar, cArr, i, false);
        if (j6 == -1) {
            return -1;
        }
        String str = "$0$debug";
        if (str.length() + j6 >= cArr.length) {
            return -1;
        }
        while (i2 < str.length()) {
            int i3 = j6 + 1;
            cArr[j6] = str.charAt(i2);
            i2++;
            j6 = i3;
        }
        return j6;
    }

    private void Hw(bs bsVar, boolean z) {
        int i = this.rN;
        while (true) {
            int j6 = j6(bsVar, this.a8, i, z);
            this.rN = j6;
            if (j6 == -1) {
                this.a8 = new char[((this.a8.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void v5(bs bsVar, boolean z) {
        int i = this.er;
        while (true) {
            int j6 = j6(bsVar, this.lg, i, z);
            this.er = j6;
            if (j6 == -1) {
                this.lg = new char[((this.lg.length * 2) + 1)];
            } else {
                return;
            }
        }
    }

    private void j6(cj cjVar, bp bpVar) {
        DW((bs) bpVar, false);
        this.er = 0;
        char[] cArr = this.lg;
        int i = this.er;
        this.er = i + 1;
        cArr[i] = '(';
        if (bpVar.J0()) {
            v5(bpVar.Xa(), true);
        }
        if (this.J8.DW(bpVar.v5())) {
            this.J8.j6.j6(bpVar.v5());
            while (this.J8.j6.DW()) {
                v5(cjVar.we(this.J8.j6.Hw()), true);
            }
        }
        cArr = this.lg;
        i = this.er;
        this.er = i + 1;
        cArr[i] = ')';
        cArr = this.lg;
        i = this.er;
        this.er = i + 1;
        cArr[i] = 'V';
    }

    private void j6(cj cjVar, bz bzVar, bp bpVar) {
        FH((bs) bzVar, false);
        if (bpVar.J0()) {
            DW(bpVar.Xa(), true);
            System.arraycopy(this.lg, 1, this.lg, this.rN + 1, this.er);
            System.arraycopy(this.a8, 0, this.lg, 1, this.rN);
            this.er += this.rN;
        }
        if (this.J8.DW(bpVar.v5())) {
            this.rN = 0;
            this.J8.j6.j6(bpVar.v5());
            while (this.J8.j6.DW()) {
                Hw(cjVar.we(this.J8.j6.Hw()), true);
            }
            System.arraycopy(this.lg, this.er - 2, this.lg, (this.er + this.rN) - 2, 2);
            System.arraycopy(this.a8, 0, this.lg, this.er - 2, this.rN);
            this.er += this.rN;
        }
    }

    private void DW(cj cjVar, int i) {
        int i2 = 1;
        if (cjVar.rN(i) == ProxyTextView.INPUTTYPE_textFilter) {
            bs we = cjVar.we(cjVar.Hw(i, cjVar.lg(i) - 3));
            DW(we, false);
            if (we.g3()) {
                this.VH.j6("java/lang/Object");
                this.VH.DW(this.a8, 0, this.rN);
            } else {
                this.VH.j6(this.a8, 0, this.rN);
            }
            QX(cjVar, i);
            return;
        }
        int Hw;
        int i3;
        if (this.XL.g3()) {
            this.VH.j6("java/lang/Object");
            Hw = cjVar.Hw(i, 4);
            int lg = cjVar.lg(Hw);
            for (i3 = 1; i3 < lg; i3 += 2) {
                DW(cjVar.we(cjVar.Hw(Hw, i3)), false);
                this.VH.DW(this.a8, 0, this.rN);
            }
        } else {
            try {
                DW(this.XL.Qq(), false);
                this.VH.j6(this.a8, 0, this.rN);
            } catch (ej e) {
            }
        }
        i3 = cjVar.Hw(i, 5);
        Hw = cjVar.lg(i3);
        while (i2 < Hw) {
            DW(cjVar.we(cjVar.Hw(i3, i2)), false);
            this.VH.DW(this.a8, 0, this.rN);
            i2 += 2;
        }
    }

    private void FH(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg && !DW(); i2++) {
            int Hw = cjVar.Hw(i, i2);
            if (cjVar.rN(Hw) == 124 && cjVar.rN(cjVar.Hw(Hw, 8)) == 133) {
                J0(cjVar, Hw);
            }
        }
    }

    private void Hw(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        int i2 = 0;
        while (i2 < lg) {
            if (!DW()) {
                gn(cjVar, cjVar.Hw(i, i2));
                i2++;
            } else {
                return;
            }
        }
        if (this.OW) {
            dr lp = this.XL.lp();
            lp.j6.j6();
            while (lp.j6.DW()) {
                bz bzVar = (bz) lp.j6.Hw();
                if (bzVar.Xa() != this.XL && bzVar.a8()) {
                    try {
                        DW((bs) bzVar, false);
                        lg = j6((bs) bzVar, true);
                        DW(j6(bzVar.aq(), (bs) bzVar));
                        this.VH.j6(lg, this.yS, 0, this.gW, this.a8, 0, this.rN, true, false, false);
                        DW(cjVar, bzVar);
                    } catch (ej e) {
                    }
                }
            }
        }
        u7(cjVar, i);
        VH(this.XL);
        FH(cjVar, this.XL);
        this.we.j6.j6(this.XL.v5());
        while (this.we.j6.DW()) {
            bs FH = this.Hw.FH(this.we.j6.Hw());
            if (FH.zh() && ((bz) FH).u7()) {
                j6(cjVar, this.XL, (bz) FH);
            } else {
                j6(cjVar, this.XL, (bz) FH, false);
            }
        }
        this.J0.j6.j6(this.XL.v5());
        while (this.J0.j6.DW()) {
            j6(cjVar, this.XL, (bz) this.Hw.FH(this.J0.j6.Hw()), true);
        }
        if (this.u7.FH(this.XL)) {
            DW(this.XL, false);
            this.VH.j6(10, FH(), "Z", true, false);
            if (!this.x9) {
                this.VH.j6(8, FH(), "()Z", true, false, true);
                DW(this.XL, false);
                this.VH.j6(this.a8, 0, this.rN, FH(), "Z");
                this.VH.J0();
            }
        }
        if (!this.x9 && !this.XL.g3()) {
            this.VH.j6(10, Hw(this.XL), "Z", true, false);
        }
    }

    private void j6(cj cjVar, int i, co coVar) {
        this.VH.FH();
        DW(cjVar, i, coVar);
    }

    private void v5(cj cjVar, int i) {
        int i2;
        int lg = cjVar.lg(i);
        int i3 = 0;
        for (i2 = 0; i2 < lg; i2++) {
            if (cjVar.rN(cjVar.Hw(i, i2)) == 231) {
                i3++;
            }
        }
        if (i3 > 0) {
            this.VH.DW(i3);
            i2 = cjVar.lg(i);
            for (i3 = 0; i3 < i2; i3++) {
                int Hw = cjVar.Hw(i, i3);
                if (cjVar.rN(Hw) == 231) {
                    Zo(cjVar, Hw);
                }
            }
        }
    }

    private void Zo(cj cjVar, int i) {
        DW(cjVar.we(cjVar.Hw(i, 1)), true);
        int lg = cjVar.lg(i);
        this.VH.j6(this.a8, 0, this.rN, (lg - 3) / 4);
        if (lg >= 5) {
            for (int i2 = 3; i2 < lg; i2 += 4) {
                int Hw = cjVar.Hw(i, i2);
                int gW = cjVar.gW(Hw);
                int Hw2 = cjVar.Hw(i, i2 + 2);
                if (cjVar.J8(Hw) == 20) {
                    co Mz = ((bz) cjVar.QX(Hw)).Mz();
                    DW(gW);
                    this.VH.FH(this.yS, 0, this.gW);
                    DW(cjVar, Hw2, Mz);
                }
            }
        }
    }

    private void DW(cj cjVar, int i, co coVar) {
        if (this.j6.FH(coVar) && cjVar.rN(i) == 231) {
            this.VH.Hw();
            Zo(cjVar, i);
        } else if (coVar.AL() && cjVar.rN(i) == 196) {
            int i2;
            co FH = ((bo) coVar).FH();
            int lg = cjVar.lg(i);
            int i3 = 0;
            for (i2 = 1; i2 < lg; i2 += 2) {
                if (cjVar.rN(cjVar.Hw(i, i2)) != 9) {
                    i3++;
                }
            }
            this.VH.FH(i3);
            for (i3 = 1; i3 < lg; i3 += 2) {
                i2 = cjVar.Hw(i, i3);
                if (cjVar.rN(i2) != 9) {
                    DW(cjVar, i2, FH);
                }
            }
        } else if (cjVar.J0(i) && this.j6.j6(coVar) && this.j6.j6(cjVar.we(i)) && cjVar.u7(i)) {
            char c;
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    c = 'B';
                    break;
                case 5:
                    c = 'S';
                    break;
                case 7:
                    c = 'I';
                    break;
                case 9:
                    c = 'J';
                    break;
                case 11:
                    c = 'Z';
                    break;
                case 12:
                    c = 'C';
                    break;
                case 13:
                    c = 'F';
                    break;
                case 14:
                    c = 'D';
                    break;
                default:
                    c = '\u0000';
                    break;
            }
            long j6 = this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.gn(i), cjVar.we(i), coVar);
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 5:
                case 7:
                case 11:
                case 12:
                    this.VH.j6(c, this.Hw.v5(j6));
                case 9:
                    this.VH.j6(c, this.Hw.VH(j6));
                case 13:
                    this.VH.j6(c, this.Hw.Hw(j6));
                case 14:
                    this.VH.j6(c, this.Hw.FH(j6));
                default:
            }
        } else if (cjVar.J0(i) && cjVar.we(i).Mz() && cjVar.we(i).cT() && cjVar.rN(i) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.J8(cjVar.Hw(i, cjVar.lg(i) - 1)) == 16) {
            bz bzVar = (bz) cjVar.QX(cjVar.Hw(i, cjVar.lg(i) - 1));
            DW(bzVar.Xa(), true);
            this.VH.j6(this.a8, 0, this.rN, bzVar.eU());
        } else if (cjVar.J0(i) && this.j6.lg(cjVar.we()) == cjVar.we(i)) {
            String VH = VH(cjVar, i);
            if (VH == null) {
                VH = "";
            }
            this.VH.FH(VH);
        } else if (cjVar.J0(i) && cjVar.rN(i) == 167 && cjVar.J0(cjVar.Hw(i, 0))) {
            DW(cjVar.we(cjVar.Hw(i, 0)), true);
            this.VH.Hw(this.a8, 0, this.rN);
        } else {
            this.VH.FH("");
        }
    }

    private String VH(cj cjVar, int i) {
        int i2 = 0;
        if (cjVar.u7(i)) {
            long gn = cjVar.gn(i);
            switch (cjVar.we(i).Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 5:
                case 7:
                    return Integer.toString(this.Hw.v5(gn));
                case 9:
                    return String.valueOf(this.Hw.VH(gn));
                case 11:
                    return String.valueOf(this.Hw.DW(gn));
                case 12:
                    return String.valueOf((char) this.Hw.v5(gn));
                case 13:
                    return String.valueOf(this.Hw.Hw(gn));
                case 14:
                    return String.valueOf(this.Hw.FH(gn));
            }
        }
        String a8;
        int Hw;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                a8 = cjVar.a8(i);
                return a8.substring(1, a8.length() - 1);
            case 66:
                return "null";
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
                bz bzVar = (bz) cjVar.QX(Hw);
                return (cjVar.J8(Hw) == 16 && bzVar.FH()) ? bzVar.Zo() : null;
            case 168:
                return VH(cjVar, cjVar.Hw(i, 1));
            case 172:
                if (cjVar.rN(cjVar.Hw(i, 1)) == 21) {
                    a8 = VH(cjVar, cjVar.Hw(i, 0));
                    String VH = VH(cjVar, cjVar.Hw(i, 2));
                    if (!(a8 == null || VH == null)) {
                        return a8 + VH;
                    }
                }
                return null;
            case 178:
                StringBuffer stringBuffer = new StringBuffer();
                Hw = cjVar.lg(i);
                while (i2 < Hw) {
                    stringBuffer.append(VH(cjVar, cjVar.Hw(i, i2)));
                    i2 += 2;
                }
                return stringBuffer.toString();
            default:
                return null;
        }
    }

    private void gn(cj cjVar, int i) {
        switch (cjVar.rN(i)) {
            case 123:
                XL(cjVar, i);
            case 124:
                J8(cjVar, i);
            case 126:
                int lg = cjVar.lg(i);
                for (int i2 = 3; i2 < lg; i2 += 2) {
                    we(cjVar, cjVar.Hw(i, i2));
                }
            case 127:
                if (cjVar.lg(cjVar.Hw(i, 0)) == 0) {
                    this.vJ = false;
                    this.VH.j6(2, j6(i), "()V", true, false, true);
                    this.QX = this.VH.v5();
                    Zo();
                    j3(cjVar, cjVar.Hw(i, 1));
                    this.VH.v5(this.QX);
                    this.VH.we();
                }
            case 221:
            case 227:
            case 228:
                DW(this.Hw.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i)));
            default:
        }
    }

    private void u7(cj cjVar, int i) {
        int i2;
        boolean z = (this.x9 || this.XL.g3()) ? false : true;
        if (this.u7.FH(this.XL)) {
            z = true;
        } else {
            int lg = cjVar.lg(i);
            loop0:
            for (int i3 = 0; i3 < lg; i3++) {
                int Hw = cjVar.Hw(i, i3);
                if (cjVar.rN(Hw) != 126) {
                    if (cjVar.rN(Hw) == 127 && cjVar.lg(cjVar.Hw(Hw, 0)) != 0) {
                        z = true;
                        break;
                    }
                }
                int lg2 = cjVar.lg(Hw);
                for (i2 = 3; i2 < lg2; i2 += 2) {
                    int Hw2 = cjVar.Hw(Hw, i2);
                    if (cjVar.lg(Hw2) > 2) {
                        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw2));
                        if (!(!DW.I() || DW.XL() || DW.FH())) {
                            z = true;
                            break loop0;
                        }
                    }
                }
                continue;
            }
        }
        if (z) {
            this.VH.j6(24, "<clinit>", "()V".toCharArray(), 0, 3, false, false, true);
            if (!(this.x9 || this.XL.g3())) {
                tp(cjVar, i);
            }
            if (this.u7.FH(this.XL)) {
                j6(this.XL, 0);
                this.VH.v5("java/lang/Class", "desiredAssertionStatus", "()Z");
                int v5 = this.VH.v5();
                i2 = this.VH.v5();
                this.VH.j6(v5, true);
                this.VH.gn(1);
                this.VH.Zo(i2);
                this.VH.v5(v5);
                this.VH.gn(0);
                this.VH.v5(i2);
                DW(this.XL, false);
                this.VH.j6(new String(this.a8, 0, this.rN), FH(), "Z");
            }
            this.VH.v5();
            EQ(cjVar, i);
            this.VH.we();
        }
    }

    private void tp(cj cjVar, int i) {
        this.VH.DW((long) cjVar.we().vy());
        this.VH.Zo(j6(this.XL));
        this.VH.Hw("adrt/ADRT", "onClassLoad", "(JLjava/lang/String;)V");
    }

    private void EQ(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            int Hw = cjVar.Hw(i, i2);
            if (cjVar.rN(Hw) == 126) {
                int lg2 = cjVar.lg(Hw);
                for (int i3 = 3; i3 < lg2; i3 += 2) {
                    int Hw2 = cjVar.Hw(Hw, i3);
                    if (cjVar.lg(Hw2) > 2) {
                        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw2));
                        if (!(!DW.I() || DW.XL() || DW.FH())) {
                            Hw2 = cjVar.Hw(Hw2, 3);
                            co Mz = DW.Mz();
                            if (cjVar.rN(Hw2) == 196) {
                                FH(cjVar, Hw2, Mz);
                            } else {
                                Hw(cjVar, Hw2, false);
                                DW(cjVar, cjVar.we(Hw2), Mz);
                            }
                            j6(cjVar, DW, null, true);
                        }
                    }
                }
            } else if (cjVar.rN(Hw) == 127 && cjVar.lg(cjVar.Hw(Hw, 0)) != 0) {
                j3(cjVar, cjVar.Hw(Hw, 1));
            }
        }
    }

    private void we(cj cjVar, int i) {
        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
        DW((bs) DW, false);
        int j6 = j6((bs) DW, true);
        boolean XL = DW.XL() | DW.FH();
        DW(j6(DW.aq(), (bs) DW));
        this.VH.j6(j6, this.yS, 0, this.gW, this.a8, 0, this.rN, false, XL);
        v5(cjVar, cjVar.Hw(cjVar.aM(i), 0));
        if (VH((bs) DW)) {
            gn((bs) DW);
            this.VH.v5(this.a8, 0, this.rN);
        }
        if (XL) {
            switch (DW.Mz().Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case 5:
                case 7:
                case 11:
                case 12:
                    this.VH.j6(this.Hw.v5(DW.aM()));
                    break;
                case 9:
                    this.VH.j6(this.Hw.VH(DW.aM()));
                    break;
                case 13:
                    this.VH.j6(this.Hw.Hw(DW.aM()));
                    break;
                case 14:
                    this.VH.j6(this.Hw.FH(DW.aM()));
                    break;
                default:
                    this.VH.DW(DW.Zo());
                    break;
            }
        }
        if (this.EQ.FH((bs) DW)) {
            j6(cjVar, DW.Xa(), DW);
        }
    }

    private void J0(cj cjVar, int i) {
        int i2;
        boolean z;
        bs DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
        this.Mr = DW.Mz();
        this.U2 = cjVar.v5(i);
        if (DW.I()) {
            DW(DW, false);
        } else {
            this.er = 0;
            char[] cArr = this.lg;
            i2 = this.er;
            this.er = i2 + 1;
            cArr[i2] = '(';
            v5(this.XL, true);
            this.rN = this.er - 1;
            Hw(DW, false);
            System.arraycopy(this.lg, 0, this.a8, 0, this.er);
        }
        i2 = 25;
        if (!DW.sh()) {
            z = false;
        } else if (this.aj) {
            i2 = 153;
            z = false;
        } else {
            z = true;
        }
        this.VH.j6(i2, FH((bz) DW), this.a8, 0, this.rN, false, z, true);
        DW(cjVar, (bz) DW);
        this.Mz = 30000;
        we();
        i2 = this.VH.v5();
        int v5 = this.VH.v5();
        vy(cjVar, i);
        this.VH.v5(i2);
        this.QX = this.VH.v5();
        if (!DW.I()) {
            Zo();
            sh(cjVar, i);
        }
        Ws(cjVar, cjVar.Hw(i, 5));
        int Hw = cjVar.Hw(i, 8);
        int lg = cjVar.lg(Hw);
        for (int i3 = 1; i3 < lg - 1; i3++) {
            j3(cjVar, cjVar.Hw(Hw, i3));
        }
        P8(cjVar, Hw);
        ei(cjVar, i);
        this.VH.v5(this.QX);
        if (this.Mr.Gj() == 1) {
            this.VH.we();
        } else {
            this.VH.VH();
        }
        this.VH.v5(v5);
        this.VH.j6(i2, v5);
        nw(cjVar, i);
        this.VH.EQ();
        if (this.VH.j6() > 32000) {
            this.Sf.j6(DW);
            this.VH.DW();
            if (this.Mr.Gj() == 1) {
                this.VH.we();
            } else {
                this.VH.VH();
            }
        }
    }

    private void J8(cj cjVar, int i) {
        int i2;
        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
        this.Mr = DW.Mz();
        this.U2 = cjVar.v5(i);
        DW((bs) DW, false);
        int j6 = j6((bs) DW, true);
        if ((this.XL.Ev() & 8192) != 0) {
            j6 |= 2048;
        }
        int j62 = j6(DW.aq(), (bs) DW);
        boolean z = false;
        if (!DW.sh()) {
            i2 = j6;
        } else if (this.aj) {
            i2 = j6 | 128;
        } else {
            z = true;
            i2 = j6;
        }
        DW(j62);
        this.VH.j6(i2, this.yS, 0, this.gW, this.a8, 0, this.rN, false, z, cjVar.rN(cjVar.Hw(i, 8)) == 133);
        if (VH((bs) DW)) {
            gn((bs) DW);
            this.VH.v5(this.a8, 0, this.rN);
        }
        DW(cjVar, DW);
        v5(cjVar, cjVar.Hw(i, 0));
        if (cjVar.rN(cjVar.Hw(i, 8)) == 133) {
            if (this.x9) {
                gn(DW);
            }
            if (!(this.x9 || this.Sf.FH((bs) DW))) {
                u7(DW);
                this.Mz = 30000;
                we();
                DW(this.XL, false);
                this.VH.j6(this.a8, 0, this.rN, Hw((bs) DW), "Z");
                int v5 = this.VH.v5();
                this.VH.j6(v5, false);
                if (!DW.I()) {
                    this.VH.u7(0);
                }
                j62 = DW.lp();
                j6 = 0;
                if (!DW.I()) {
                    j6 = 1;
                }
                for (i2 = 0; i2 < j62; i2++) {
                    co v52 = DW.v5(i2);
                    FH(j6, v52);
                    switch (v52.Gj()) {
                        case 9:
                        case 14:
                            j6 += 2;
                            break;
                        default:
                            j6++;
                            break;
                    }
                }
                if (DW.I()) {
                    DW((bs) DW, false);
                } else {
                    this.er = 0;
                    char[] cArr = this.lg;
                    i2 = this.er;
                    this.er = i2 + 1;
                    cArr[i2] = '(';
                    v5(this.XL, true);
                    this.rN = this.er - 1;
                    Hw((bs) DW, false);
                    System.arraycopy(this.lg, 0, this.a8, 0, this.er);
                }
                u7(this.XL);
                this.VH.FH(this.lg, 0, this.er, FH(DW), this.a8, 0, this.rN);
                Hw(this.Mr);
                this.VH.v5(v5);
            }
            this.QX = this.VH.v5();
            if (!DW.I()) {
                Zo();
            }
            j6(cjVar, cjVar.Hw(i, 5), true, DW);
            tp(DW);
            j3(cjVar, cjVar.Hw(i, 8));
            this.VH.v5(this.QX);
            if (this.Mr.Gj() == 1) {
                this.VH.we();
            } else {
                this.VH.VH();
            }
            if (!(this.x9 || this.Sf.FH((bs) DW))) {
                EQ();
            }
        } else {
            j6(cjVar, cjVar.Hw(i, 5), false, DW);
        }
        if (cjVar.rN(cjVar.Hw(i, 8)) == 232) {
            j6(cjVar, cjVar.Hw(cjVar.Hw(i, 8), 1), this.Mr);
        }
        if (this.EQ.FH((bs) DW)) {
            j6(cjVar, DW.Xa(), DW, false);
        }
        j6(cjVar, DW, j6(DW));
        if (cjVar.rN(cjVar.Hw(i, 8)) != 133) {
        }
    }

    private void gn(bz bzVar) {
        if (bzVar.aq() == this.Zo.ro.j6("onCreate") && we(bzVar)) {
            this.VH.u7(0);
            this.VH.Zo(this.jJ);
            this.VH.Hw("adrt/ADRTLogCatReader", "onContext", "(Landroid/content/Context;Ljava/lang/String;)V");
        }
    }

    private void u7(bz bzVar) {
        if (!this.x9 && !this.Qq) {
            if (we(bzVar)) {
                this.VH.u7(0);
                this.VH.Zo(this.jJ);
                this.VH.Hw("adrt/ADRT", "onContext", "(Landroid/content/Context;Ljava/lang/String;)V");
            } else if (EQ(bzVar)) {
                this.VH.u7(1);
                this.VH.Zo(this.jJ);
                this.VH.Hw("adrt/ADRTLogCatReader", "onContext", "(Landroid/content/Context;Ljava/lang/String;)V");
            }
        }
    }

    private void tp(bz bzVar) {
        if (we(bzVar) && bzVar.aq() == this.Zo.ro.j6("onCreate") && bzVar.Xa().rN().iW().startsWith("com.aide.trainer.")) {
            this.VH.u7(0);
            this.VH.Hw("TrainerRuntime", "broadcastRun", "(Landroid/content/Context;)V");
        }
    }

    private boolean EQ(bz bzVar) {
        try {
            if (this.j3 && !cd.aM(bzVar.Ev()) && !cd.QX(bzVar.Ev()) && bzVar.aq() == this.Zo.ro.j6("onReceive") && bzVar.lp() == 2 && bzVar.v5(0).iW().equals("android.content.Context")) {
                return true;
            }
            return false;
        } catch (ej e) {
            return false;
        }
    }

    private boolean we(bz bzVar) {
        return (!this.aM || cd.aM(bzVar.Ev()) || cd.QX(bzVar.Ev())) ? false : true;
    }

    private boolean Hw(bp bpVar) {
        int j6 = this.Zo.ro.j6("BroadcastReceiver");
        ea jO = bpVar.jO();
        jO.j6.j6();
        while (jO.j6.DW()) {
            bp bpVar2 = (bp) jO.j6.FH();
            if (bpVar2.aq() == j6 && bpVar2.rN().iW().equals("android.content")) {
                return true;
            }
        }
        return false;
    }

    private boolean v5(bp bpVar) {
        int j6 = this.Zo.ro.j6("Context");
        ea jO = bpVar.jO();
        jO.j6.j6();
        while (jO.j6.DW()) {
            bp bpVar2 = (bp) jO.j6.FH();
            if (bpVar2.aq() == j6 && bpVar2.rN().iW().equals("android.content")) {
                return true;
            }
        }
        return false;
    }

    private void j6(cj cjVar, int i, boolean z, bz bzVar) {
        int lg = cjVar.lg(i);
        if (lg > 2) {
            for (int i2 = 1; i2 < lg - 1; i2 += 2) {
                int Hw = cjVar.Hw(i, i2);
                if (cjVar.rN(Hw) == 191) {
                    Hw = cjVar.Hw(Hw, 3);
                    int gW = cjVar.gW(Hw);
                    int v5 = cjVar.v5(Hw);
                    co we = cjVar.we(Hw);
                    DW((bs) we, true);
                    DW(gW);
                    if (this.kQ && z) {
                        this.VH.j6(this.QX, v5, this.yS, 0, this.gW, this.a8, 0, this.rN);
                    } else if (!Zo((bs) bzVar)) {
                        this.VH.j6(v5, this.yS, 0, this.gW, this.a8, 0, this.rN);
                    }
                    DW(we);
                }
            }
        }
    }

    private void Ws(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        if (lg > 2) {
            for (int i2 = 1; i2 < lg - 1; i2 += 2) {
                int Hw = cjVar.Hw(i, i2);
                if (cjVar.rN(Hw) == 191) {
                    int Hw2 = cjVar.Hw(Hw, 3);
                    int gW = cjVar.gW(Hw2);
                    int v5 = cjVar.v5(Hw2);
                    co we = cjVar.we(Hw2);
                    DW((bs) we, true);
                    DW(gW);
                    if (this.kQ) {
                        this.VH.j6(this.QX, v5, this.yS, 0, this.gW, this.a8, 0, this.rN);
                    }
                    DW(we);
                    DW(cjVar, Hw2, v5, we);
                    Hw(cjVar, Hw, v5, we);
                }
            }
        }
    }

    private void j6(cj cjVar, int i, boolean z) {
        bp Xa;
        bs we = cjVar.we(i);
        DW(we, false);
        this.VH.gn(this.a8, 0, this.rN);
        if (!z) {
            this.VH.er();
        }
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 3);
        int Hw2 = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
        bs QX = cjVar.QX(Hw2);
        if (QX.zh() && ((bz) QX).gn()) {
            Xa = ((bz) QX).Xa();
        } else {
            Xa = (bp) QX;
        }
        if (((bp) we).J0()) {
            j6(cjVar, we.Xa());
        }
        if (cjVar.lg(i) != 5) {
            Hw(cjVar, cjVar.Hw(i, 0), false);
        } else if (Xa.J0()) {
            j6(cjVar, Xa.Xa());
        }
        if (QX.zh() && ((bz) QX).gn()) {
            j6(cjVar, Hw2, cjVar.Hw(i, cjVar.lg(i) - 2), (bz) QX);
            DW(cjVar, (bp) we);
            j6(cjVar, (bz) QX, (bp) we);
            DW(we, false);
            this.VH.Hw(this.a8, 0, this.rN, "<init>", this.lg, 0, this.er);
        } else {
            DW(cjVar, (bp) we);
            j6(cjVar, (bp) we);
            this.VH.Hw(this.a8, 0, this.rN, "<init>", this.lg, 0, this.er);
        }
        cb(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
    }

    private void DW(cj cjVar, bp bpVar) {
        if (this.J8.DW(bpVar.v5())) {
            int i = this.ef;
            this.J8.j6.j6(bpVar.v5());
            while (this.J8.j6.DW()) {
                int Hw = this.J8.j6.Hw();
                co we = cjVar.we(Hw);
                int v5 = cjVar.v5(Hw);
                if (!this.J8.FH(this.XL.v5(), Hw)) {
                    FH(v5, we);
                } else if (this.sG) {
                    FH(i, we);
                    switch (we.Gj()) {
                        case 9:
                        case 14:
                            i += 2;
                            break;
                        default:
                            i++;
                            break;
                    }
                } else {
                    this.VH.u7(0);
                    BT(cjVar, Hw);
                }
            }
        }
    }

    private void QX(cj cjVar, int i) {
        int i2 = 2;
        co we = cjVar.we(i);
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 3);
        bs QX = cjVar.QX(cjVar.Hw(Hw, cjVar.lg(Hw) - 2));
        if (QX.zh() && ((bz) QX).gn()) {
            int i3;
            int lp;
            int i4;
            co v5;
            bp Xa = ((bz) QX).Xa();
            j6(cjVar, (bz) QX, (bp) we);
            this.VH.j6(0, "<init>", this.lg, 0, this.er, false, false, true);
            if (!this.XX) {
                this.sG = true;
                this.VH.u7(0);
                if (((bp) we).J0()) {
                    Hw = 2;
                } else {
                    Hw = 1;
                }
                if (Xa.J0()) {
                    i3 = Hw + 1;
                    this.VH.u7(Hw);
                } else {
                    i3 = Hw;
                }
                lp = ((bz) QX).lp();
                i4 = i3;
                i3 = 0;
                while (i3 < lp) {
                    v5 = ((bz) QX).v5(i3);
                    FH(i4, v5);
                    switch (v5.Gj()) {
                        case 9:
                        case 14:
                            Hw = i4 + 2;
                            break;
                        default:
                            Hw = i4 + 1;
                            break;
                    }
                    i3++;
                    i4 = Hw;
                }
                if (this.J8.DW(Xa.v5())) {
                    DW(cjVar, Xa);
                }
                j6(cjVar, (bz) QX);
                this.sG = false;
            }
            if (((bp) we).J0()) {
                j6((bp) we, 1);
            }
            lp = ((bz) QX).lp();
            if (((bp) we).J0()) {
                Hw = 2;
            } else {
                Hw = 1;
            }
            if (Xa.J0()) {
                i3 = Hw + 1;
                this.VH.u7(Hw);
                Hw = i3;
            }
            i3 = 0;
            i4 = Hw;
            while (i3 < lp) {
                switch (((bz) QX).v5(i3).Gj()) {
                    case 9:
                    case 14:
                        Hw = i4 + 2;
                        break;
                    default:
                        Hw = i4 + 1;
                        break;
                }
                i3++;
                i4 = Hw;
            }
            j6(cjVar, (bp) we, i4);
            if (this.XX) {
                this.sG = true;
                this.VH.u7(0);
                if (!((bp) we).J0()) {
                    i2 = 1;
                }
                if (Xa.J0()) {
                    Hw = i2 + 1;
                    this.VH.u7(i2);
                    i2 = Hw;
                }
                i4 = ((bz) QX).lp();
                i3 = 0;
                while (i3 < i4) {
                    v5 = ((bz) QX).v5(i3);
                    FH(i2, v5);
                    switch (v5.Gj()) {
                        case 9:
                        case 14:
                            Hw = i2 + 2;
                            break;
                        default:
                            Hw = i2 + 1;
                            break;
                    }
                    i3++;
                    i2 = Hw;
                }
                if (this.J8.DW(Xa.v5())) {
                    DW(cjVar, Xa);
                }
                j6(cjVar, (bz) QX);
                this.sG = false;
            }
            aM(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
            this.VH.we();
            return;
        }
        j6(cjVar, (bp) we);
        this.VH.j6(0, "<init>", this.lg, 0, this.er, false, false, true);
        this.VH.u7(0);
        this.VH.Zo("java/lang/Object", "<init>", "()V");
        if (((bp) we).J0()) {
            j6((bp) we, 1);
        }
        if (!((bp) we).J0()) {
            i2 = 1;
        }
        j6(cjVar, (bp) we, i2);
        aM(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
        this.VH.we();
    }

    private void j6(cj cjVar, bp bpVar, int i) {
        DW((bs) bpVar, false);
        this.J8.j6.j6(bpVar.v5());
        while (this.J8.j6.DW()) {
            int Hw = this.J8.j6.Hw();
            bs we = cjVar.we(Hw);
            this.VH.u7(0);
            FH(i, (co) we);
            switch (we.Gj()) {
                case 9:
                case 14:
                    i += 2;
                    break;
                default:
                    i++;
                    break;
            }
            String j6 = j6(cjVar.BT(Hw));
            FH(we, true);
            this.VH.j6(this.a8, 0, this.rN, j6, this.lg, 0, this.er);
        }
    }

    private void FH(cj cjVar, bp bpVar) {
        this.J8.j6.j6(bpVar.v5());
        while (this.J8.j6.DW()) {
            int Hw = this.J8.j6.Hw();
            DW(cjVar.we(Hw), true);
            String j6 = j6(cjVar.BT(Hw));
            if (this.x9) {
                this.VH.j6(18, j6, this.a8, 0, this.rN, true, false);
            } else {
                this.VH.j6(16, j6, this.a8, 0, this.rN, true, false);
            }
        }
    }

    private void XL(cj cjVar, int i) {
        boolean z;
        int i2;
        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i));
        this.U2 = cjVar.v5(i);
        bp Xa = DW.Xa();
        DW((bs) DW, false);
        this.rN -= 2;
        this.J8.j6.j6(Xa.v5());
        while (this.J8.j6.DW()) {
            Hw(cjVar.we(this.J8.j6.Hw()), true);
        }
        char[] cArr = this.a8;
        int i3 = this.rN;
        this.rN = i3 + 1;
        cArr[i3] = ')';
        cArr = this.a8;
        i3 = this.rN;
        this.rN = i3 + 1;
        cArr[i3] = 'V';
        i3 = j6((bs) DW, true) & -3;
        if (!DW.sh()) {
            z = false;
        } else if (this.aj) {
            i3 |= 128;
            z = false;
        } else {
            z = true;
        }
        this.VH.j6(i3, "<init>", this.a8, 0, this.rN, false, z, true);
        i3 = cjVar.Hw(i, 4);
        int lg = cjVar.lg(i3);
        for (i2 = 1; i2 < lg; i2 += 2) {
            bs we = cjVar.we(cjVar.Hw(i3, i2));
            if (this.j6.Hw(cjVar.we(), we)) {
                DW(we, false);
                this.VH.VH(this.a8, 0, this.rN);
            }
        }
        if (VH((bs) DW)) {
            gn((bs) DW);
            this.VH.v5(this.a8, 0, this.rN);
        }
        i2 = this.VH.v5();
        if (!this.x9) {
            this.Mz = 30000;
            we();
            DW(this.XL, false);
            this.VH.j6(this.a8, 0, this.rN, Hw((bs) DW), "Z");
            this.VH.j6(i2, true);
        }
        this.QX = this.VH.v5();
        Zo();
        j6(cjVar, cjVar.Hw(i, 3), true, DW);
        j6(cjVar, cjVar.Hw(i, 5), DW);
        this.VH.v5(this.QX);
        this.VH.we();
        if (!this.x9) {
            we();
            this.vJ = true;
            this.VH.v5(i2);
            i2 = this.VH.v5();
            i3 = this.VH.v5();
            vy(cjVar, i);
            this.VH.v5(i2);
            this.QX = this.VH.v5();
            Zo();
            Ws(cjVar, cjVar.Hw(i, 3));
            j6(cjVar, cjVar.Hw(i, 5), DW);
            this.VH.v5(this.QX);
            P8(cjVar, cjVar.Hw(i, 5));
            ei(cjVar, i);
            this.VH.we();
            this.VH.v5(i3);
            this.VH.j6(i2, i3);
            nw(cjVar, i);
            this.VH.EQ();
            this.vJ = false;
            EQ();
            if (this.VH.j6() > 32000) {
                this.VH.DW();
                this.QX = this.VH.v5();
                Zo();
                j6(cjVar, cjVar.Hw(i, 3), true, DW);
                j6(cjVar, cjVar.Hw(i, 5), DW);
                this.VH.v5(this.QX);
                this.VH.we();
            }
        }
    }

    private void j6(cj cjVar, int i, bz bzVar) {
        int i2;
        if (!this.XX) {
            j3(cjVar, cjVar.Hw(i, 1));
        }
        if (cjVar.rN(cjVar.Hw(cjVar.Hw(i, 1), 0)) != 163) {
            bp Xa = bzVar.Xa();
            this.ef = 1;
            int lp = bzVar.lp();
            if (Xa.J0()) {
                this.ef++;
            }
            for (i2 = 0; i2 < lp; i2++) {
                switch (bzVar.v5(i2).Gj()) {
                    case 9:
                    case 14:
                        this.ef += 2;
                        break;
                    default:
                        this.ef++;
                        break;
                }
            }
            if (Xa.J0()) {
                j6(Xa, 1);
            }
            if (this.J8.DW(Xa.v5())) {
                j6(cjVar, Xa, this.ef);
            }
        }
        if (this.XX) {
            j3(cjVar, cjVar.Hw(i, 1));
        }
        sh(cjVar, i);
        if (cjVar.rN(cjVar.Hw(cjVar.Hw(i, 1), 0)) != 163) {
            aM(cjVar, cjVar.aM(cjVar.aM(i)));
        }
        int lg = cjVar.lg(i);
        for (i2 = 2; i2 < lg - 1; i2++) {
            j3(cjVar, cjVar.Hw(i, i2));
        }
    }

    private void Zo() {
        DW(this.XL, true);
        if (this.kQ) {
            this.VH.j6(this.QX, 0, "this".toCharArray(), 0, 4, this.a8, 0, this.rN);
        }
    }

    private void aM(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            int Hw = cjVar.Hw(i, i2);
            if (cjVar.rN(Hw) == 126) {
                int lg2 = cjVar.lg(Hw);
                for (int i3 = 3; i3 < lg2; i3 += 2) {
                    int Hw2 = cjVar.Hw(Hw, i3);
                    if (cjVar.lg(Hw2) > 2) {
                        bz DW = this.Hw.DW(cjVar.we(), cjVar.tp(), cjVar.XL(Hw2));
                        if (!DW.I()) {
                            this.VH.u7(0);
                            Hw2 = cjVar.Hw(Hw2, 3);
                            co Mz = DW.Mz();
                            if (cjVar.rN(Hw2) == 196) {
                                FH(cjVar, Hw2, Mz);
                            } else {
                                Hw(cjVar, Hw2, false);
                                DW(cjVar, cjVar.we(Hw2), Mz);
                            }
                            j6(cjVar, DW, null, true);
                        }
                    }
                }
            } else if (cjVar.rN(Hw) == 127 && cjVar.lg(cjVar.Hw(Hw, 0)) == 0) {
                this.VH.u7(0);
                DW(this.XL, false);
                this.VH.Zo(new String(this.a8, 0, this.rN), j6(Hw), "()V");
            }
        }
    }

    private void j3(cj cjVar, int i) {
        int i2;
        int lg;
        int i3;
        int v5;
        int v52;
        int v53;
        int Hw;
        int lg2;
        int v54;
        int v55;
        int v56;
        int Hw2;
        int i4;
        int i5;
        int lg3;
        int i6;
        switch (cjVar.rN(i)) {
            case 133:
                i2 = this.QX;
                this.QX = this.VH.v5();
                lg = cjVar.lg(i);
                for (i3 = 1; i3 < lg - 1; i3++) {
                    j3(cjVar, cjVar.Hw(i, i3));
                }
                this.VH.v5(this.QX);
                this.QX = i2;
            case 135:
                i3 = cjVar.Hw(i, 2);
                if (!cjVar.u7(i3) || this.Hw.DW(cjVar.gn(i3))) {
                    i2 = this.VH.v5();
                    FH(cjVar.nw(i));
                    ro(cjVar, cjVar.Hw(i, 0));
                    j6(cjVar, i3, i2, false);
                    j3(cjVar, cjVar.Hw(i, 4));
                    this.VH.v5(i2);
                } else if (this.vJ) {
                    i2 = this.VH.v5();
                    FH(cjVar.nw(i));
                    ro(cjVar, cjVar.Hw(i, 0));
                    j6(cjVar, i3, i2, false);
                    this.VH.v5(i2);
                }
            case 136:
                i3 = this.VH.v5();
                i2 = this.VH.v5();
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                j6(cjVar, cjVar.Hw(i, 2), i2, false);
                j3(cjVar, cjVar.Hw(i, 4));
                this.VH.Zo(i3);
                this.VH.v5(i2);
                j3(cjVar, cjVar.Hw(i, 6));
                this.VH.v5(i3);
            case 137:
                i3 = this.VH.v5();
                i2 = this.VH.v5();
                lg = this.VH.v5();
                ro(cjVar, cjVar.Hw(i, 0));
                this.VH.Zo(i3);
                this.VH.v5(i2);
                this.vy.j6(i, i3);
                this.BT.j6(i, lg);
                j3(cjVar, cjVar.Hw(i, 4));
                this.vy.DW(i);
                this.BT.DW(i);
                this.VH.v5(i3);
                FH(cjVar.nw(i));
                j6(cjVar, cjVar.Hw(i, 2), i2, true);
                this.VH.v5(lg);
            case 138:
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                er(cjVar, i);
                this.VH.Zo(this.BT.Hw(cjVar.Zo(i)));
            case 139:
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                er(cjVar, i);
                this.VH.Zo(this.vy.Hw(cjVar.Zo(i)));
            case 140:
                i3 = cjVar.v5(i);
                i2 = i3 + 1;
                this.P8.j6(i3);
                this.ei.j6(i);
                lg = this.VH.v5();
                v5 = this.VH.v5();
                v52 = this.VH.v5();
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                Hw(cjVar, cjVar.Hw(i, 2), false);
                this.VH.J8(i3);
                this.VH.u7(i3);
                this.VH.u7();
                this.VH.v5(lg);
                j3(cjVar, cjVar.Hw(i, 4));
                this.VH.v5(v5);
                this.VH.u7(i3);
                this.VH.tp();
                this.VH.Zo(v52);
                this.VH.j6(lg, v5);
                this.VH.J8(i2);
                this.VH.u7(i3);
                this.VH.tp();
                this.VH.u7(i2);
                this.VH.EQ();
                this.VH.v5(v52);
                this.P8.DW();
                this.ei.DW();
            case 141:
                FH(cjVar.nw(i));
                KD(cjVar, i);
                if (cjVar.lg(i) == 2) {
                    er(cjVar, i);
                    ei(cjVar, i);
                    this.VH.we();
                    return;
                }
                v5(cjVar, cjVar.Hw(i, 1), false);
                DW(cjVar, cjVar.we(cjVar.Hw(i, 1)), this.Mr);
                if (this.KD.Hw() > 0) {
                    j6(this.ro.FH(), this.Mr, true);
                    er(cjVar, i);
                    FH(this.ro.FH(), this.Mr);
                } else {
                    er(cjVar, i);
                }
                SI(cjVar, cjVar.Hw(i, 1));
                Hw(this.Mr);
            case 142:
                FH(cjVar.nw(i));
                KD(cjVar, i);
                Hw(cjVar, cjVar.Hw(i, 1), false);
                cn(cjVar, cjVar.Hw(i, 0));
                this.VH.EQ();
            case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                i3 = this.VH.v5();
                i2 = this.VH.v5();
                lg = this.VH.v5();
                ro(cjVar, cjVar.Hw(i, 0));
                this.VH.v5(i2);
                this.vy.j6(i, i3);
                this.BT.j6(i, lg);
                j3(cjVar, cjVar.Hw(i, 1));
                this.vy.DW(i);
                this.BT.DW(i);
                this.VH.v5(i3);
                FH(cjVar.nw(i));
                j6(cjVar, cjVar.Hw(i, 4), i2, true);
                this.VH.v5(lg);
            case 146:
                switch (cjVar.rN(cjVar.Hw(i, 0))) {
                    case 163:
                    case 164:
                        FH(cjVar.nw(i));
                        KD(cjVar, i);
                        Hw(cjVar, cjVar.Hw(i, 0), true);
                    default:
                        FH(cjVar.nw(i));
                        i3 = this.VH.v5();
                        DW(cjVar, i, i3);
                        Hw(cjVar, cjVar.Hw(i, 0), true);
                        this.VH.v5(i3);
                }
            case 147:
                a8(cjVar, i);
            case 148:
                i3 = this.VH.v5();
                this.BT.j6(i, i3);
                j3(cjVar, cjVar.Hw(i, 2));
                this.VH.v5(i3);
            case 149:
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                i2 = this.QX;
                lg = this.VH.v5();
                this.QX = lg;
                v5 = this.VH.v5();
                v52 = this.VH.v5();
                v53 = this.VH.v5();
                Hw = cjVar.Hw(i, 2);
                if (cjVar.rN(cjVar.Hw(Hw, 0)) != 14) {
                    lg2 = cjVar.lg(Hw);
                    for (i3 = 0; i3 < lg2; i3 += 2) {
                        if (cjVar.rN(cjVar.Hw(Hw, i3)) == 151) {
                            j3(cjVar, cjVar.Hw(Hw, i3));
                        } else if (this.vJ) {
                            v54 = this.VH.v5();
                            DW(cjVar, cjVar.Hw(Hw, i3), v54);
                            Hw(cjVar, cjVar.Hw(Hw, i3), true);
                            this.VH.v5(v54);
                        } else {
                            KD(cjVar, cjVar.Hw(Hw, i3));
                            Hw(cjVar, cjVar.Hw(Hw, i3), true);
                        }
                    }
                }
                this.VH.Zo(v5);
                this.VH.v5(v53);
                this.vy.j6(i, v52);
                this.BT.j6(i, lg);
                j3(cjVar, cjVar.Hw(i, 6));
                this.vy.DW(i);
                this.BT.DW(i);
                this.VH.v5(v52);
                v52 = cjVar.Hw(i, 4);
                if (cjVar.lg(v52) > 0) {
                    Hw = cjVar.lg(v52);
                    for (i3 = 0; i3 < Hw; i3 += 2) {
                        FH(cjVar.nw(v52));
                        if (this.vJ) {
                            lg2 = this.VH.v5();
                            DW(cjVar, v52, lg2);
                            Hw(cjVar, cjVar.Hw(v52, i3), true);
                            this.VH.v5(lg2);
                        } else {
                            Hw(cjVar, cjVar.Hw(v52, i3), true);
                        }
                    }
                }
                this.VH.v5(v5);
                i3 = cjVar.Hw(i, 3);
                if (cjVar.rN(cjVar.Hw(i3, 0)) != 14) {
                    j6(cjVar, cjVar.Hw(i3, 0), v53, true);
                } else {
                    this.VH.Zo(v53);
                }
                this.VH.v5(lg);
                this.QX = i2;
            case 150:
                Object obj;
                ro(cjVar, cjVar.Hw(i, 0));
                i2 = this.VH.v5();
                lg = this.VH.v5();
                v55 = this.VH.v5();
                v56 = this.VH.v5();
                Hw2 = cjVar.Hw(i, cjVar.lg(i) - 1);
                if (cjVar.rN(Hw2) == 205) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.SI.DW(i);
                    this.KD.j6(Hw2);
                    this.ro.j6(cjVar.v5(Hw2) + 2);
                }
                this.VH.v5(i2);
                j3(cjVar, cjVar.Hw(i, 1));
                this.VH.v5(lg);
                this.VH.Zo(v55);
                if (obj != null) {
                    this.SI.DW();
                    this.KD.DW();
                    this.ro.DW();
                }
                int lg4 = cjVar.lg(i);
                for (i4 = 2; i4 < lg4; i4++) {
                    int Hw3 = cjVar.Hw(i, i4);
                    if (cjVar.rN(Hw3) == 204) {
                        lg2 = cjVar.Hw(Hw3, 3);
                        v54 = cjVar.lg(lg2);
                        for (Hw = 0; Hw < v54; Hw += 2) {
                            co we = cjVar.we(cjVar.Hw(lg2, Hw));
                            DW((bs) we, false);
                            this.VH.j6(i2, lg, this.a8, 0, this.rN);
                            DW(we);
                        }
                        i3 = this.QX;
                        this.QX = this.VH.v5();
                        int Hw4 = cjVar.Hw(Hw3, 4);
                        v5 = cjVar.gW(Hw4);
                        bs we2 = cjVar.we(Hw4);
                        v53 = cjVar.v5(cjVar.Hw(Hw3, 4));
                        this.VH.J8(v53);
                        DW(we2, true);
                        DW(v5);
                        if (this.kQ) {
                            this.VH.j6(this.QX, v53, this.yS, 0, this.gW, this.a8, 0, this.rN);
                        }
                        j6(cjVar, Hw4, v53, (co) we2);
                        Hw(cjVar, Hw4, v53, we2);
                        FH(cjVar, Hw4, v53, we2);
                        DW((co) we2);
                        ro(cjVar, cjVar.Hw(Hw3, 0));
                        if (obj != null) {
                            this.SI.j6(i);
                            this.KD.j6(Hw2);
                            this.ro.j6(cjVar.v5(Hw2) + 2);
                        }
                        j3(cjVar, cjVar.Hw(Hw3, cjVar.lg(Hw3) - 1));
                        if (obj != null) {
                            this.SI.DW();
                            this.KD.DW();
                            this.ro.DW();
                        }
                        this.VH.Zo(v55);
                        this.VH.v5(this.QX);
                        this.QX = i3;
                    }
                }
                this.VH.v5(v56);
                if (obj != null) {
                    this.VH.j6(i2, v56);
                    i3 = cjVar.v5(Hw2);
                    this.VH.J8(i3);
                    j3(cjVar, cjVar.Hw(Hw2, cjVar.lg(Hw2) - 1));
                    this.VH.u7(i3);
                    this.VH.EQ();
                }
                this.VH.v5(v55);
                if (obj != null) {
                    j3(cjVar, cjVar.Hw(Hw2, cjVar.lg(Hw2) - 1));
                }
            case 151:
                FH(cjVar.nw(i));
                i3 = -1;
                if (this.vJ) {
                    lg(cjVar, i);
                    i3 = this.VH.v5();
                    DW(cjVar, i, i3);
                    rN(cjVar, i);
                }
                i5 = i3;
                lg3 = cjVar.lg(i);
                for (i6 = 3; i6 < lg3; i6 += 2) {
                    i4 = cjVar.Hw(i, i6);
                    i3 = cjVar.Hw(i4, 0);
                    i2 = cjVar.gW(i3);
                    lg = cjVar.v5(i3);
                    bs we3 = cjVar.we(i3);
                    if (cjVar.lg(i4) > 2) {
                        v55 = cjVar.Hw(i4, 3);
                        if (cjVar.rN(v55) == 196) {
                            FH(cjVar, v55, (co) we3);
                        } else {
                            Hw(cjVar, v55, false);
                            DW(cjVar, cjVar.we(v55), (co) we3);
                        }
                        j6(lg, (co) we3, true);
                        DW(we3, true);
                        DW(i2);
                        if (this.kQ) {
                            this.VH.j6(this.QX, lg, this.yS, 0, this.gW, this.a8, 0, this.rN);
                        }
                        Hw(cjVar, v55, lg, we3);
                        FH(cjVar, i4, lg, we3);
                    } else {
                        this.cn.j6(i3, this.QX);
                    }
                    DW((co) we3);
                }
                if (this.vJ) {
                    this.VH.v5(i5);
                }
            case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                ro(cjVar, cjVar.Hw(i, 0));
                Hw = this.VH.v5();
                if (this.Qq) {
                    DW(this.XL, false);
                    this.VH.DW(this.a8, 0, this.rN, FH(), "()Z");
                } else {
                    DW(this.XL, false);
                    this.VH.j6(this.a8, 0, this.rN, FH(), "Z");
                }
                this.VH.j6(Hw, true);
                FH(cjVar.nw(i));
                j6(cjVar, cjVar.Hw(i, 1), Hw, true);
                this.VH.Hw("java/lang/AssertionError");
                this.VH.er();
                if (cjVar.lg(i) != 3) {
                    Hw(cjVar, cjVar.Hw(i, 3), false);
                    switch (cjVar.we(cjVar.Hw(i, 3)).Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case 5:
                        case 7:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(I)V");
                            break;
                        case 9:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(J)V");
                            break;
                        case 11:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(Z)V");
                            break;
                        case 12:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(C)V");
                            break;
                        case 13:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(F)V");
                            break;
                        case 14:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(D)V");
                            break;
                        default:
                            this.VH.Zo("java/lang/AssertionError", "<init>", "(Ljava/lang/Object;)V");
                            break;
                    }
                }
                this.VH.Zo("java/lang/AssertionError", "<init>", "()V");
                this.VH.EQ();
                this.VH.v5(Hw);
            case 211:
                FH(cjVar.nw(i));
                ro(cjVar, cjVar.Hw(i, 0));
                i5 = this.QX;
                i6 = this.VH.v5();
                lg3 = this.VH.v5();
                i4 = this.VH.v5();
                int v57 = this.VH.v5();
                this.QX = i6;
                co we4 = cjVar.we(cjVar.Hw(i, 8));
                bs we5 = cjVar.we(cjVar.Hw(i, 5));
                lg = cjVar.v5(cjVar.Hw(i, 5));
                v56 = cjVar.Hw(i, 5);
                i2 = cjVar.gW(v56);
                Hw2 = cjVar.v5(i);
                if (we4.AL()) {
                    co FH = ((bo) we4).FH();
                    Hw(cjVar, cjVar.Hw(i, 8), false);
                    this.VH.J8(Hw2);
                    this.VH.gn(0);
                    this.VH.Ws(Hw2 + 1);
                    this.VH.Zo(lg3);
                    this.VH.v5(v57);
                    DW(we5, true);
                    DW(i2);
                    if (this.kQ) {
                        this.VH.j6(this.QX, lg, this.yS, 0, this.gW, this.a8, 0, this.rN);
                    }
                    this.vy.j6(i, i4);
                    this.BT.j6(i, i6);
                    this.VH.u7(Hw2);
                    this.VH.tp(Hw2 + 1);
                    v5(FH);
                    DW(cjVar, FH, (co) we5);
                    j6(lg, (co) we5, true);
                    j6(cjVar, v56, lg, (co) we5);
                    Hw(cjVar, i, lg, we5);
                    FH(cjVar, cjVar.Hw(i, 5), lg, we5);
                    j3(cjVar, cjVar.Hw(i, 10));
                    this.vy.DW(i);
                    this.BT.DW(i);
                    this.VH.v5(i4);
                    this.VH.Hw(Hw2 + 1, 1);
                    this.VH.v5(lg3);
                    this.VH.tp(Hw2 + 1);
                    this.VH.u7(Hw2);
                    this.VH.gn();
                    this.VH.lg(v57, true);
                } else if (we4.FH(cjVar.we(), cjVar.tp(), this.j6.VH(cjVar.we()))) {
                    Hw(cjVar, cjVar.Hw(i, 8), false);
                    this.VH.v5("java/util/Collection");
                    this.VH.FH("java/util/Collection", "iterator", "()Ljava/util/Iterator;");
                    this.VH.J8(Hw2);
                    this.VH.Zo(lg3);
                    this.VH.v5(v57);
                    DW(we5, true);
                    DW(i2);
                    if (this.kQ) {
                        this.VH.j6(this.QX, lg, this.yS, 0, this.gW, this.a8, 0, this.rN);
                    }
                    this.vy.j6(i, lg3);
                    this.BT.j6(i, i6);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "next", "()Ljava/lang/Object;");
                    if (this.j6.j6((co) we5)) {
                        DW(cjVar, this.j6.j6(cjVar.we(), (co) we5), (co) we5);
                    } else {
                        DW(we5, false);
                        this.VH.u7(this.a8, 0, this.rN);
                    }
                    j6(lg, (co) we5, true);
                    j6(cjVar, v56, lg, (co) we5);
                    Hw(cjVar, i, lg, we5);
                    FH(cjVar, cjVar.Hw(i, 5), lg, we5);
                    j3(cjVar, cjVar.Hw(i, 10));
                    this.vy.DW(i);
                    this.BT.DW(i);
                    this.VH.v5(lg3);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "hasNext", "()Z");
                    this.VH.j6(v57, true);
                } else if (this.sy) {
                    Hw(cjVar, cjVar.Hw(i, 8), false);
                    this.VH.v5("javalangIterable");
                    this.VH.FH("javalangIterable", "iterator", "()Ljava/util/Iterator;");
                    this.VH.J8(Hw2);
                    this.VH.Zo(lg3);
                    this.VH.v5(v57);
                    this.vy.j6(i, lg3);
                    this.BT.j6(i, i6);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "next", "()Ljava/lang/Object;");
                    if (this.j6.j6((co) we5)) {
                        DW(cjVar, this.j6.j6(cjVar.we(), (co) we5), (co) we5);
                    } else {
                        DW(we5, false);
                        this.VH.u7(this.a8, 0, this.rN);
                    }
                    j6(lg, (co) we5, true);
                    Hw(cjVar, i, lg, we5);
                    FH(cjVar, cjVar.Hw(i, 5), lg, we5);
                    j3(cjVar, cjVar.Hw(i, 10));
                    this.vy.DW(i);
                    this.BT.DW(i);
                    this.VH.v5(lg3);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "hasNext", "()Z");
                    this.VH.j6(v57, true);
                } else {
                    Hw(cjVar, cjVar.Hw(i, 8), false);
                    this.VH.v5("java/lang/Iterable");
                    this.VH.FH("java/lang/Iterable", "iterator", "()Ljava/util/Iterator;");
                    this.VH.J8(Hw2);
                    this.VH.Zo(lg3);
                    this.VH.v5(v57);
                    this.vy.j6(i, lg3);
                    this.BT.j6(i, i6);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "next", "()Ljava/lang/Object;");
                    if (this.j6.j6((co) we5)) {
                        DW(cjVar, this.j6.j6(cjVar.we(), (co) we5), (co) we5);
                    } else {
                        DW(we5, false);
                        this.VH.u7(this.a8, 0, this.rN);
                    }
                    j6(lg, (co) we5, true);
                    j6(cjVar, v56, lg, (co) we5);
                    Hw(cjVar, i, lg, we5);
                    FH(cjVar, cjVar.Hw(i, 5), lg, we5);
                    j3(cjVar, cjVar.Hw(i, 10));
                    this.vy.DW(i);
                    this.BT.DW(i);
                    this.VH.v5(lg3);
                    this.VH.u7(Hw2);
                    this.VH.FH("java/util/Iterator", "hasNext", "()Z");
                    this.VH.j6(v57, true);
                }
                this.VH.v5(i6);
                this.QX = i5;
            case 212:
                i2 = this.VH.v5();
                lg = this.VH.v5();
                v5 = this.VH.v5();
                v52 = this.VH.v5();
                v53 = this.VH.v5();
                this.VH.v5(v52);
                Hw = cjVar.v5(i);
                this.VH.vJ();
                this.VH.J8(Hw);
                Mr(cjVar, i);
                lg2 = cjVar.lg(i);
                for (i3 = 2; i3 < lg2 - 2; i3++) {
                    j3(cjVar, cjVar.Hw(i, i3));
                }
                this.nw.DW(i);
                this.VH.v5(i2);
                j3(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
                this.nw.DW();
                U2(cjVar, i);
                this.VH.Zo(v5);
                this.VH.v5(lg);
                this.VH.j6(i2, lg);
                this.VH.J8(Hw);
                U2(cjVar, i);
                this.VH.u7(Hw);
                this.VH.EQ();
                i3 = Hw + 1;
                i2 = this.VH.v5();
                lg = this.VH.v5();
                this.VH.v5(v53);
                this.VH.j6(v52, v53);
                this.VH.J8(i3);
                this.VH.u7(Hw);
                this.VH.DW(i2, false);
                this.VH.u7(i3);
                this.VH.J8(Hw);
                this.VH.Zo(lg);
                this.VH.v5(i2);
                this.VH.u7(Hw);
                this.VH.u7(i3);
                this.VH.FH(lg, true);
                this.VH.u7(Hw);
                this.VH.u7(i3);
                this.VH.v5("java/lang/Throwable", "addSuppressed", "(Ljava/lang/Throwable;)V");
                this.VH.v5(lg);
                this.VH.u7(Hw);
                this.VH.EQ();
                this.VH.v5(v5);
            default:
        }
    }

    private void Mr(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 2; i2 < lg - 2; i2++) {
            int Hw = cjVar.Hw(i, i2);
            int lg2 = cjVar.lg(Hw);
            for (int i3 = 3; i3 < lg2; i3 += 2) {
                int v5 = cjVar.v5(cjVar.Hw(cjVar.Hw(Hw, i3), 0));
                this.VH.vJ();
                this.VH.J8(v5);
            }
        }
    }

    private void U2(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 2; i2 < lg - 2; i2++) {
            int Hw = cjVar.Hw(i, i2);
            int lg2 = cjVar.lg(Hw);
            for (int i3 = 3; i3 < lg2; i3 += 2) {
                int v5 = cjVar.v5(cjVar.Hw(cjVar.Hw(Hw, i3), 0));
                int v52 = this.VH.v5();
                this.VH.u7(v5);
                this.VH.DW(v52, true);
                this.VH.u7(v5);
                this.VH.FH("java/lang/AutoCloseable", "close", "()V");
                this.VH.v5(v52);
            }
        }
    }

    private void a8(cj cjVar, int i) {
        int Hw;
        int lg;
        int i2;
        int Hw2;
        FH(cjVar.nw(i));
        ro(cjVar, cjVar.Hw(i, 0));
        Hw(cjVar, cjVar.Hw(i, 2), false);
        co we = cjVar.we(cjVar.Hw(i, 2));
        if (this.j6.DW(cjVar.we(), we)) {
            FH(cjVar, we);
            we = this.j6.v5(cjVar.we(), we);
        }
        if (this.vJ) {
            Hw = cjVar.Hw(i, 4);
            lg = cjVar.lg(Hw);
            for (i2 = 1; i2 < lg - 1; i2++) {
                Hw2 = cjVar.Hw(Hw, i2);
                if (cjVar.rN(Hw2) == 151) {
                    lg(cjVar, Hw2);
                }
            }
        }
        int Hw3;
        int lg2;
        int v5;
        int Hw4;
        if (this.j6.j6(we)) {
            int i3;
            do doVar = new do();
            dt dtVar = new dt();
            lg = 0;
            Hw = 0;
            doVar.j6();
            Hw3 = cjVar.Hw(i, 4);
            lg2 = cjVar.lg(Hw3);
            for (i3 = 1; i3 < lg2 - 1; i3++) {
                i2 = cjVar.Hw(Hw3, i3);
                if (cjVar.rN(i2) == 143) {
                    doVar.DW(this.Hw.v5(cjVar.gn(cjVar.Hw(i2, 1))));
                }
            }
            doVar.v5();
            v5 = this.VH.v5();
            int v52 = this.VH.v5();
            if (((long) (doVar.Hw() * 2)) >= (((long) doVar.FH()) - ((long) doVar.FH(0))) + 1) {
                dtVar.DW();
                this.VH.j6(v52, doVar.FH(0), doVar.FH());
                i2 = 0;
                for (i3 = doVar.FH(0); i3 <= doVar.FH(); i3++) {
                    if (doVar.FH(i2) == i3) {
                        Hw2 = this.VH.v5();
                        if (doVar.FH(i2) == Integer.MIN_VALUE) {
                            lg = Hw2;
                        } else if (doVar.FH(i2) == Integer.MAX_VALUE) {
                            Hw = Hw2;
                        } else {
                            dtVar.j6(doVar.FH(i2), Hw2);
                        }
                        this.VH.VH(Hw2);
                        i2++;
                    } else {
                        this.VH.VH(v52);
                    }
                    if (i3 == Integer.MAX_VALUE) {
                        break;
                    }
                }
            } else {
                dtVar.DW();
                this.VH.DW(v52, doVar.Hw());
                for (i3 = 0; i3 < doVar.Hw(); i3++) {
                    i2 = this.VH.v5();
                    if (doVar.FH(i3) == Integer.MIN_VALUE) {
                        lg = i2;
                    } else if (doVar.FH(i3) == Integer.MAX_VALUE) {
                        Hw = i2;
                    } else {
                        dtVar.j6(doVar.FH(i3), i2);
                    }
                    this.VH.FH(doVar.FH(i3), i2);
                }
            }
            this.BT.j6(i, v5);
            i3 = -1;
            Object obj = null;
            for (Hw2 = 1; Hw2 < lg2 - 1; Hw2++) {
                Hw4 = cjVar.Hw(Hw3, Hw2);
                switch (cjVar.rN(Hw4)) {
                    case 143:
                        if (this.vJ) {
                            if (i3 == -1) {
                                i3 = this.VH.v5();
                            }
                            this.VH.Zo(i3);
                        }
                        int v53 = this.Hw.v5(cjVar.gn(cjVar.Hw(Hw4, 1)));
                        if (v53 == Integer.MIN_VALUE) {
                            this.VH.v5(lg);
                        } else if (v53 == Integer.MAX_VALUE) {
                            this.VH.v5(Hw);
                        } else {
                            this.VH.v5(dtVar.Hw(v53));
                        }
                        ro(cjVar, cjVar.Hw(Hw4, 0));
                        break;
                    case 144:
                        if (this.vJ) {
                            if (i3 == -1) {
                                i3 = this.VH.v5();
                            }
                            this.VH.Zo(i3);
                        }
                        this.VH.v5(v52);
                        obj = 1;
                        ro(cjVar, cjVar.Hw(Hw4, 0));
                        break;
                    default:
                        if (this.vJ && i3 != -1) {
                            this.VH.v5(i3);
                            i3 = -1;
                        }
                        j3(cjVar, Hw4);
                        break;
                }
            }
            if (this.vJ && i3 != -1) {
                this.VH.v5(i3);
            }
            if (obj == null) {
                this.VH.v5(v52);
            }
            this.BT.DW(i);
            this.VH.v5(v5);
        } else if (we == this.j6.rN(cjVar.we())) {
            lg = cjVar.v5(i);
            this.VH.J8(lg);
            Hw2 = this.VH.v5();
            Hw4 = this.VH.v5();
            Hw = this.VH.v5();
            this.VH.Zo(Hw);
            this.BT.j6(i, Hw2);
            r8 = cjVar.Hw(i, 4);
            Hw3 = cjVar.lg(r8);
            r2 = null;
            i2 = Hw;
            for (Hw = 1; Hw < Hw3; Hw++) {
                lg2 = cjVar.Hw(r8, Hw);
                switch (cjVar.rN(lg2)) {
                    case 9:
                        this.VH.Zo(Hw2);
                        break;
                    case 143:
                        v5 = this.VH.v5();
                        this.VH.Zo(v5);
                        this.VH.v5(i2);
                        this.VH.u7(lg);
                        v5(cjVar, cjVar.Hw(lg2, 1), false);
                        i2 = this.VH.v5();
                        this.VH.v5("java/lang/String", "equals", "(Ljava/lang/Object;)Z");
                        this.VH.gn(1);
                        this.VH.gW(i2, true);
                        ro(cjVar, cjVar.Hw(lg2, 0));
                        this.VH.v5(v5);
                        break;
                    case 144:
                        v5 = this.VH.v5();
                        this.VH.Zo(v5);
                        r2 = 1;
                        this.VH.v5(Hw4);
                        ro(cjVar, cjVar.Hw(lg2, 0));
                        this.VH.v5(v5);
                        break;
                    default:
                        j3(cjVar, lg2);
                        break;
                }
            }
            this.VH.v5(i2);
            if (r2 != null) {
                this.VH.Zo(Hw4);
            }
            this.BT.DW(i);
            this.VH.v5(Hw2);
        } else {
            lg = cjVar.v5(i);
            this.VH.J8(lg);
            Hw2 = this.VH.v5();
            Hw4 = this.VH.v5();
            Hw = this.VH.v5();
            this.VH.Zo(Hw);
            this.BT.j6(i, Hw2);
            r8 = cjVar.Hw(i, 4);
            Hw3 = cjVar.lg(r8);
            r2 = null;
            i2 = Hw;
            for (Hw = 1; Hw < Hw3; Hw++) {
                lg2 = cjVar.Hw(r8, Hw);
                switch (cjVar.rN(lg2)) {
                    case 9:
                        this.VH.Zo(Hw2);
                        break;
                    case 143:
                        v5 = this.VH.v5();
                        this.VH.Zo(v5);
                        this.VH.v5(i2);
                        this.VH.u7(lg);
                        v5(cjVar, cjVar.Hw(lg2, 1), false);
                        i2 = this.VH.v5();
                        this.VH.Hw(i2, true);
                        ro(cjVar, cjVar.Hw(lg2, 0));
                        this.VH.v5(v5);
                        break;
                    case 144:
                        v5 = this.VH.v5();
                        this.VH.Zo(v5);
                        r2 = 1;
                        this.VH.v5(Hw4);
                        ro(cjVar, cjVar.Hw(lg2, 0));
                        this.VH.v5(v5);
                        break;
                    default:
                        j3(cjVar, lg2);
                        break;
                }
            }
            this.VH.v5(i2);
            if (r2 != null) {
                this.VH.Zo(Hw4);
            }
            this.BT.DW(i);
            this.VH.v5(Hw2);
        }
    }

    private void lg(cj cjVar, int i) {
    }

    private void rN(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 3; i2 < lg; i2 += 2) {
            int Hw = cjVar.Hw(cjVar.Hw(i, i2), 0);
            j6(cjVar, Hw, cjVar.v5(Hw), cjVar.we(Hw));
        }
    }

    private void j6(cj cjVar, int i, int i2, co coVar) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.Zo(this.DW.j6(cjVar.gW(i)));
            this.VH.gn(i2);
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.VH.v5("adrt/ADRTThread", "onByteVariableDeclare", "(Ljava/lang/String;I)V");
                case 5:
                    this.VH.v5("adrt/ADRTThread", "onShortVariableDeclare", "(Ljava/lang/String;I)V");
                case 7:
                    this.VH.v5("adrt/ADRTThread", "onIntVariableDeclare", "(Ljava/lang/String;I)V");
                case 9:
                    this.VH.v5("adrt/ADRTThread", "onLongVariableDeclare", "(Ljava/lang/String;I)V");
                case 11:
                    this.VH.v5("adrt/ADRTThread", "onBoolVariableDeclare", "(Ljava/lang/String;I)V");
                case 12:
                    this.VH.v5("adrt/ADRTThread", "onCharVariableDeclare", "(Ljava/lang/String;I)V");
                case 13:
                    this.VH.v5("adrt/ADRTThread", "onFloatVariableDeclare", "(Ljava/lang/String;I)V");
                case 14:
                    this.VH.v5("adrt/ADRTThread", "onDoubleVariableDeclare", "(Ljava/lang/String;I)V");
                default:
                    this.VH.v5("adrt/ADRTThread", "onObjectVariableDeclare", "(Ljava/lang/String;I)V");
            }
        }
    }

    private void er(cj cjVar, int i) {
        if (this.ei.Hw() != 0 || this.SI.Hw() != 0 || this.nw.Hw() != 0) {
            int i2 = 0;
            switch (cjVar.rN(i)) {
                case 138:
                case 139:
                    i2 = cjVar.Zo(i);
                    break;
            }
            int Hw = this.SI.Hw() - 1;
            int Hw2 = this.ei.Hw() - 1;
            int Hw3 = this.nw.Hw() - 1;
            int i3 = i;
            while (true) {
                if (Hw2 >= 0 && i3 == this.ei.FH(Hw2)) {
                    this.VH.u7(this.P8.FH(Hw2));
                    this.VH.tp();
                    Hw2--;
                } else if (Hw >= 0 && i3 == this.SI.FH(Hw)) {
                    if (!cjVar.Zo(this.KD.FH(Hw), i)) {
                        j3(cjVar, cjVar.Hw(this.KD.FH(Hw), cjVar.lg(this.KD.FH(Hw)) - 1));
                    }
                    Hw--;
                } else if (Hw3 >= 0 && i3 == this.nw.FH(Hw3)) {
                    U2(cjVar, i3);
                    Hw3--;
                }
                if (i3 != i2) {
                    switch (cjVar.rN(i3)) {
                        case 123:
                        case 124:
                        case 127:
                        case 194:
                            return;
                        default:
                            i3 = cjVar.aM(i3);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void DW(cj cjVar, int i, boolean z) {
        int v5 = this.VH.v5();
        int v52 = this.VH.v5();
        DW(cjVar, i, v5, z);
        this.VH.gn(0);
        this.VH.Zo(v52);
        this.VH.v5(v5);
        this.VH.gn(1);
        this.VH.v5(v52);
    }

    private void FH(cj cjVar, int i, boolean z) {
        int v5 = this.VH.v5();
        int v52 = this.VH.v5();
        j6(cjVar, i, v5, z);
        this.VH.gn(0);
        this.VH.Zo(v52);
        this.VH.v5(v5);
        this.VH.gn(1);
        this.VH.v5(v52);
    }

    private void j6(cj cjVar, int i, int i2, boolean z) {
        boolean z2 = true;
        if (this.vJ) {
            int v5;
            boolean z3;
            switch (cjVar.rN(i)) {
                case 68:
                case 74:
                    DW(cjVar, i, i2, z);
                    u7(cjVar, i, this.Hw.DW(cjVar.gn(i)));
                    return;
                case 168:
                    DW(cjVar, i, i2, z);
                    return;
                case 172:
                    switch (cjVar.rN(cjVar.Hw(i, 1))) {
                        case 39:
                        case 42:
                        case 210:
                            DW(cjVar, i, i2, z);
                            return;
                        default:
                            v5 = this.VH.v5();
                            if (z) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            DW(cjVar, i, v5, z3);
                            gn(cjVar, i, z);
                            this.VH.Zo(i2);
                            this.VH.v5(v5);
                            if (z) {
                                z2 = false;
                            }
                            gn(cjVar, i, z2);
                            return;
                    }
                default:
                    v5 = this.VH.v5();
                    if (z) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    DW(cjVar, i, v5, z3);
                    gn(cjVar, i, z);
                    this.VH.Zo(i2);
                    this.VH.v5(v5);
                    if (z) {
                        z2 = false;
                    }
                    gn(cjVar, i, z2);
                    return;
            }
        }
        DW(cjVar, i, i2, z);
    }

    private void DW(cj cjVar, int i, int i2, boolean z) {
        boolean z2 = true;
        if (!cjVar.u7(i)) {
            int Hw;
            switch (cjVar.rN(i)) {
                case 168:
                    j6(cjVar, cjVar.Hw(i, 1), i2, z);
                case 170:
                    if (cjVar.rN(cjVar.Hw(i, 0)) == 34) {
                        Hw = cjVar.Hw(i, 1);
                        if (z) {
                            z2 = false;
                        }
                        j6(cjVar, Hw, i2, z2);
                    }
                case 172:
                    Hw = cjVar.Hw(i, 0);
                    co we = cjVar.we(Hw);
                    int Hw2 = cjVar.Hw(i, 2);
                    co we2 = cjVar.we(Hw2);
                    int v5;
                    int v52;
                    co j6;
                    switch (cjVar.rN(cjVar.Hw(i, 1))) {
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                            if ((we.Gj() == 11 || we == this.j6.EQ(cjVar.we())) && (we2.Gj() == 11 || we2 == this.j6.EQ(cjVar.we()))) {
                                v5 = this.VH.v5();
                                v52 = this.VH.v5();
                                j6(cjVar, Hw, v5, true);
                                if (z) {
                                    z2 = false;
                                }
                                j6(cjVar, Hw2, i2, z2);
                                this.VH.Zo(v52);
                                this.VH.v5(v5);
                                j6(cjVar, Hw2, i2, z);
                                this.VH.v5(v52);
                            } else if (this.j6.gn(cjVar.we(), we, we2)) {
                                j6 = this.j6.j6(cjVar.we(), 9, we, we2);
                                Hw(cjVar, Hw, false);
                                DW(cjVar, we, j6);
                                Hw(cjVar, Hw2, false);
                                DW(cjVar, we2, j6);
                                j6(cjVar.rN(cjVar.Hw(i, 1)), j6, i2, z);
                            } else if (!this.j6.DW(we) && we.Gj() != 2) {
                            } else {
                                if (cjVar.rN(Hw) == 66) {
                                    Hw(cjVar, Hw2, false);
                                    this.VH.DW(i2, z);
                                } else if (cjVar.rN(Hw2) == 66) {
                                    Hw(cjVar, Hw, false);
                                    this.VH.DW(i2, z);
                                } else {
                                    Hw(cjVar, Hw, false);
                                    if (this.j6.j6(we)) {
                                        VH(we);
                                    }
                                    Hw(cjVar, Hw2, false);
                                    if (this.j6.j6(we2)) {
                                        VH(we2);
                                    }
                                    this.VH.FH(i2, z);
                                }
                            }
                        case 35:
                            if ((we.Gj() == 11 || we == this.j6.EQ(cjVar.we())) && (we2.Gj() == 11 || we2 == this.j6.EQ(cjVar.we()))) {
                                v5 = this.VH.v5();
                                v52 = this.VH.v5();
                                j6(cjVar, Hw, v5, true);
                                j6(cjVar, Hw2, i2, z);
                                this.VH.Zo(v52);
                                this.VH.v5(v5);
                                if (z) {
                                    z2 = false;
                                }
                                j6(cjVar, Hw2, i2, z2);
                                this.VH.v5(v52);
                            } else if (this.j6.gn(cjVar.we(), we, we2)) {
                                j6 = this.j6.j6(cjVar.we(), 10, we, we2);
                                Hw(cjVar, Hw, false);
                                DW(cjVar, we, j6);
                                Hw(cjVar, Hw2, false);
                                DW(cjVar, we2, j6);
                                j6(cjVar.rN(cjVar.Hw(i, 1)), j6, i2, z);
                            } else if (!this.j6.DW(we) && we.Gj() != 2) {
                            } else {
                                go goVar;
                                if (cjVar.rN(Hw) == 66) {
                                    Hw(cjVar, Hw2, false);
                                    goVar = this.VH;
                                    if (z) {
                                        z2 = false;
                                    }
                                    goVar.DW(i2, z2);
                                } else if (cjVar.rN(Hw2) == 66) {
                                    Hw(cjVar, Hw, false);
                                    goVar = this.VH;
                                    if (z) {
                                        z2 = false;
                                    }
                                    goVar.DW(i2, z2);
                                } else {
                                    Hw(cjVar, Hw, false);
                                    if (this.j6.j6(we)) {
                                        VH(we);
                                    }
                                    Hw(cjVar, Hw2, false);
                                    if (this.j6.j6(we2)) {
                                        VH(we2);
                                    }
                                    this.VH.Hw(i2, z);
                                }
                            }
                        case 39:
                            if (z) {
                                j6(cjVar, Hw, i2, true);
                                j6(cjVar, Hw2, i2, true);
                                return;
                            }
                            v5 = this.VH.v5();
                            j6(cjVar, Hw, v5, true);
                            j6(cjVar, Hw2, i2, false);
                            this.VH.v5(v5);
                        case 42:
                            if (z) {
                                v5 = this.VH.v5();
                                j6(cjVar, Hw, v5, false);
                                j6(cjVar, Hw2, i2, true);
                                this.VH.v5(v5);
                                return;
                            }
                            j6(cjVar, Hw, i2, false);
                            j6(cjVar, Hw2, i2, false);
                        case 44:
                        case 45:
                        case 48:
                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                            j6 = this.j6.j6(cjVar.we(), 13, we, we2);
                            Hw(cjVar, Hw, false);
                            DW(cjVar, we, j6);
                            Hw(cjVar, Hw2, false);
                            DW(cjVar, we2, j6);
                            j6(cjVar.rN(cjVar.Hw(i, 1)), j6, i2, z);
                        case 210:
                            v5 = this.VH.v5();
                            v52 = this.VH.v5();
                            j6(cjVar, Hw, v5, false);
                            j6(cjVar, cjVar.Hw(cjVar.Hw(i, 1), 1), i2, z);
                            this.VH.Zo(v52);
                            this.VH.v5(v5);
                            j6(cjVar, Hw2, i2, z);
                            this.VH.v5(v52);
                        default:
                            v5(cjVar, i, false);
                            if (this.j6.DW(cjVar.we(i))) {
                                FH(cjVar, cjVar.we(i));
                            }
                            this.VH.j6(i2, z);
                    }
                default:
                    v5(cjVar, i, false);
                    if (this.j6.DW(cjVar.we(i))) {
                        FH(cjVar, cjVar.we(i));
                    }
                    this.VH.j6(i2, z);
            }
        } else if (this.Hw.DW(cjVar.gn(i)) == z) {
            this.VH.Zo(i2);
        }
    }

    private void Hw(cj cjVar, int i, boolean z) {
        if (this.vJ) {
            v5(cjVar, i, z);
        } else {
            v5(cjVar, i, z);
        }
    }

    private void v5(cj cjVar, int i, boolean z) {
        if (!cjVar.u7(i) || yS(cjVar, i)) {
            if (cjVar.J0(i)) {
                DW(cjVar.we(i));
            }
            int Hw;
            bz bzVar;
            co we;
            co EQ;
            int Hw2;
            bz bzVar2;
            bp Xa;
            co we2;
            int lg;
            co DW;
            co we3;
            int v5;
            int v52;
            switch (cjVar.rN(i)) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.VH.EQ(cjVar.j3(i), cjVar.Mr(i) + 1, cjVar.U2(i) - 2);
                    return;
                case 66:
                    this.VH.vJ();
                    return;
                case 155:
                    Hw = cjVar.Hw(i, cjVar.lg(i) - 2);
                    bzVar = (bz) cjVar.QX(Hw);
                    if (bzVar.I()) {
                        Hw(cjVar, cjVar.Hw(i, 0), false);
                        this.VH.j3();
                    } else {
                        Hw(cjVar, cjVar.Hw(i, 0), false);
                        VH();
                    }
                    j6(cjVar, Hw, cjVar.Hw(i, cjVar.lg(i) - 1), bzVar);
                    we = cjVar.we(i);
                    EQ = cjVar.EQ(Hw);
                    DW(cjVar, Hw, bzVar);
                    j6(cjVar, bzVar, EQ, we, false, false, z);
                    return;
                case 156:
                    Hw = cjVar.Hw(i, cjVar.lg(i) - 2);
                    bzVar = (bz) cjVar.QX(Hw);
                    if (!bzVar.I()) {
                        if (cjVar.lg(i) == 2) {
                            j6(cjVar, cjVar.EQ(Hw).a_());
                        } else {
                            j6(cjVar, i, cjVar.lg(i) - 5);
                        }
                        VH();
                    }
                    j6(cjVar, Hw, cjVar.Hw(i, cjVar.lg(i) - 1), bzVar);
                    we = cjVar.we(i);
                    EQ = cjVar.EQ(Hw);
                    DW(cjVar, Hw, bzVar);
                    j6(cjVar, bzVar, EQ, we, false, false, z);
                    return;
                case 157:
                    Hw = cjVar.Hw(i, cjVar.lg(i) - 2);
                    bzVar = (bz) cjVar.QX(Hw);
                    if (cjVar.lg(i) != 5) {
                        FH(cjVar.we(cjVar.Hw(i, 0)).a_());
                        j6(cjVar, Hw, cjVar.Hw(i, cjVar.lg(i) - 1), bzVar);
                        we = cjVar.we(i);
                        EQ = cjVar.we(cjVar.Hw(i, 0));
                        DW(cjVar, Hw, bzVar);
                        j6(cjVar, bzVar, EQ, we, false, true, z);
                        return;
                    } else if (bzVar.I()) {
                        j6(cjVar, Hw, cjVar.Hw(i, cjVar.lg(i) - 1), bzVar);
                        we = cjVar.we(i);
                        EQ = cjVar.EQ(Hw);
                        DW(cjVar, Hw, bzVar);
                        j6(cjVar, bzVar, EQ, we, false, false, z);
                        return;
                    } else {
                        this.VH.u7(0);
                        j6(cjVar, Hw, cjVar.Hw(i, cjVar.lg(i) - 1), bzVar);
                        we = cjVar.we(i);
                        EQ = cjVar.EQ(Hw);
                        DW(cjVar, Hw, bzVar);
                        j6(cjVar, bzVar, EQ, we, true, false, z);
                        return;
                    }
                case 159:
                case 162:
                    Zo(cjVar, i, false);
                    gW(cjVar, i);
                    return;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    Hw2 = cjVar.Hw(i, cjVar.lg(i) - 1);
                    if (cjVar.J8(Hw2) == 16 && ((bz) cjVar.QX(Hw2)).FH()) {
                        this.VH.Zo(((bz) cjVar.QX(Hw2)).Zo());
                        return;
                    }
                    Zo(cjVar, i, false);
                    gW(cjVar, i);
                    return;
                case 163:
                case 164:
                    this.sG = true;
                    if (cjVar.lg(i) == 4) {
                        Hw2 = cjVar.Hw(i, 3);
                        if (cjVar.J8(Hw2) != 0) {
                            this.VH.u7(0);
                            bzVar2 = (bz) cjVar.QX(Hw2);
                            Xa = bzVar2.Xa();
                            if (Xa.J0()) {
                                j6(cjVar, Xa.Xa());
                            }
                            j6(cjVar, Hw2, cjVar.Hw(i, 2), bzVar2);
                            if (this.J8.DW(Xa.v5())) {
                                DW(cjVar, Xa);
                            }
                            DW(cjVar, i, bzVar2);
                            j6(cjVar, bzVar2);
                        }
                    } else {
                        Hw2 = cjVar.Hw(i, 5);
                        if (cjVar.J8(Hw2) != 0) {
                            this.VH.u7(0);
                            bzVar2 = (bz) cjVar.QX(Hw2);
                            Xa = bzVar2.Xa();
                            Hw(cjVar, cjVar.Hw(i, 0), false);
                            j6(cjVar, Hw2, cjVar.Hw(i, 4), bzVar2);
                            if (this.J8.DW(Xa.v5())) {
                                DW(cjVar, Xa);
                            }
                            DW(cjVar, i, bzVar2);
                            j6(cjVar, bzVar2);
                        }
                    }
                    this.sG = false;
                    return;
                case 165:
                    Hw(cjVar, cjVar.Hw(i, 0), false);
                    Hw(cjVar, cjVar.Hw(i, 2), false);
                    if (this.j6.DW(cjVar.we(cjVar.Hw(i, 2)))) {
                        FH(cjVar, cjVar.we(cjVar.Hw(i, 2)));
                    }
                    v5(cjVar.we(i));
                    return;
                case 166:
                    if (cjVar.lg(i) == 1) {
                        this.VH.u7(0);
                        return;
                    } else {
                        FH(cjVar.we(cjVar.Hw(i, 0)));
                        return;
                    }
                case 167:
                    we2 = cjVar.we(cjVar.Hw(i, 0));
                    lg = cjVar.lg(cjVar.Hw(i, 1)) / 3;
                    for (Hw = 0; Hw < lg; Hw++) {
                        we2 = this.Hw.j6(we2, 1);
                    }
                    j6(we2, cjVar.v5(i));
                    return;
                case 168:
                    Hw(cjVar, cjVar.Hw(i, 1), false);
                    return;
                case 169:
                    bs we4 = cjVar.we(i);
                    we2 = cjVar.we(cjVar.Hw(i, 4));
                    if (this.j6.j6((co) we4)) {
                        Hw(cjVar, cjVar.Hw(i, 4), false);
                        DW(cjVar, we2, (co) we4);
                        return;
                    }
                    Hw(cjVar, cjVar.Hw(i, 4), false);
                    if (this.j6.j6(we2)) {
                        DW(cjVar, we2, (co) we4);
                        return;
                    }
                    DW(we4, false);
                    this.VH.u7(this.a8, 0, this.rN);
                    return;
                case 170:
                    switch (cjVar.rN(cjVar.Hw(i, 0))) {
                        case 21:
                            Hw(cjVar, cjVar.Hw(i, 1), false);
                            return;
                        case 22:
                        case 28:
                            Hw = cjVar.Hw(i, 1);
                            while (cjVar.rN(Hw) == 168) {
                                Hw = cjVar.Hw(Hw, 1);
                            }
                            we2 = cjVar.we(Hw);
                            if (cjVar.rN(Hw) == 165) {
                                Hw(cjVar, cjVar.Hw(Hw, 0), false);
                                Hw(cjVar, cjVar.Hw(Hw, 2), false);
                                this.VH.yS();
                                v5(cjVar.we(i));
                                DW = DW(cjVar, we2);
                                DW(cjVar, we2, DW);
                                DW(cjVar.rN(cjVar.Hw(i, 0)), DW);
                                j6(21, DW);
                                j6(cjVar, we2, DW, z);
                                DW(cjVar, we2, cjVar.we(i));
                                if (!z) {
                                    DW(cjVar, we2, cjVar.we(i));
                                }
                            } else {
                                Zo(cjVar, Hw, true);
                                gW(cjVar, Hw);
                                DW = DW(cjVar, we2);
                                DW(cjVar, we2, DW);
                                DW(cjVar.rN(cjVar.Hw(i, 0)), DW);
                                j6(21, DW);
                                DW(cjVar, DW, we2);
                                VH(cjVar, Hw, z);
                                if (!z) {
                                    DW(cjVar, we2, cjVar.we(i));
                                }
                            }
                            if (cjVar.rN(Hw) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(Hw) == 1 && cjVar.J8(cjVar.Hw(Hw, 0)) == 2) {
                                Hw(cjVar, i, cjVar.v5(cjVar.Hw(Hw, 0)), we2);
                                return;
                            }
                            return;
                        case 24:
                            we3 = cjVar.we(cjVar.Hw(i, 1));
                            we2 = cjVar.we(i);
                            Hw(cjVar, cjVar.Hw(i, 1), false);
                            DW(cjVar, we3, we2);
                            if (we2.Gj() == 9) {
                                this.VH.DW(-1);
                                this.VH.FN();
                                return;
                            }
                            this.VH.gn(-1);
                            this.VH.XX();
                            return;
                        case 27:
                            we3 = cjVar.we(cjVar.Hw(i, 1));
                            we2 = cjVar.we(i);
                            Hw(cjVar, cjVar.Hw(i, 1), false);
                            DW(cjVar, we3, we2);
                            switch (we2.Gj()) {
                                case 9:
                                    this.VH.wc();
                                    return;
                                case 13:
                                    this.VH.Ev();
                                    return;
                                case 14:
                                    this.VH.qp();
                                    return;
                                default:
                                    this.VH.x9();
                                    return;
                            }
                        case 34:
                            FH(cjVar, cjVar.Hw(i, 1), false);
                            return;
                        default:
                            return;
                    }
                case 171:
                    Hw = cjVar.Hw(i, 0);
                    while (cjVar.rN(Hw) == 168) {
                        Hw = cjVar.Hw(Hw, 1);
                    }
                    DW = cjVar.we(Hw);
                    if (cjVar.rN(Hw) == 165) {
                        Hw(cjVar, cjVar.Hw(Hw, 0), false);
                        Hw(cjVar, cjVar.Hw(Hw, 2), false);
                        this.VH.yS();
                        v5(DW);
                        we2 = DW(cjVar, DW);
                        DW(cjVar, DW, we2);
                        if (!z) {
                            switch (we2.Gj()) {
                                case 9:
                                case 14:
                                    this.VH.rN();
                                    break;
                                default:
                                    this.VH.lg();
                                    break;
                            }
                        }
                        DW(cjVar.rN(cjVar.Hw(i, 1)), we2);
                        j6(21, we2);
                        j6(cjVar, DW, we2, true);
                    } else if (cjVar.rN(Hw) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(Hw) == 1 && cjVar.J8(cjVar.Hw(Hw, 0)) == 2 && DW.Gj() == 7) {
                        v5 = cjVar.v5(cjVar.Hw(Hw, 0));
                        if (!z) {
                            FH(v5, DW);
                        }
                        if (cjVar.rN(cjVar.Hw(i, 1)) == 28) {
                            Hw2 = -1;
                        } else {
                            Hw2 = 1;
                        }
                        this.VH.Hw(v5, Hw2);
                    } else {
                        boolean Zo = Zo(cjVar, Hw, true);
                        gW(cjVar, Hw);
                        EQ = DW(cjVar, DW);
                        DW(cjVar, DW, EQ);
                        if (!z) {
                            if (!Zo) {
                                switch (EQ.Gj()) {
                                    case 9:
                                    case 14:
                                        this.VH.yS();
                                        break;
                                    default:
                                        this.VH.er();
                                        break;
                                }
                            }
                            switch (EQ.Gj()) {
                                case 9:
                                case 14:
                                    this.VH.a8();
                                    break;
                                default:
                                    this.VH.U2();
                                    break;
                            }
                        }
                        DW(cjVar.rN(cjVar.Hw(i, 1)), EQ);
                        j6(21, EQ);
                        DW(cjVar, EQ, DW);
                        VH(cjVar, Hw, true);
                    }
                    if (cjVar.rN(Hw) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(Hw) == 1 && cjVar.J8(cjVar.Hw(Hw, 0)) == 2) {
                        Hw(cjVar, i, cjVar.v5(cjVar.Hw(Hw, 0)), DW);
                        return;
                    }
                    return;
                case 172:
                    we2 = cjVar.we(i);
                    lg = cjVar.Hw(i, 0);
                    co we5 = cjVar.we(lg);
                    v5 = cjVar.Hw(i, 2);
                    we = cjVar.we(v5);
                    switch (cjVar.rN(cjVar.Hw(i, 1))) {
                        case ProxyTextView.INPUTTYPE_textUri /*17*/:
                            int i2 = lg;
                            while (cjVar.rN(i2) == 168) {
                                i2 = cjVar.Hw(i2, 1);
                            }
                            if (cjVar.rN(i2) == 165) {
                                Hw(cjVar, cjVar.Hw(i2, 0), false);
                                Hw(cjVar, cjVar.Hw(i2, 2), false);
                                Hw(cjVar, v5, false);
                                j6(cjVar, we5, we, z);
                            } else {
                                Zo(cjVar, i2, false);
                                Hw(cjVar, v5, false);
                                DW(cjVar, we, we5);
                                VH(cjVar, i2, z);
                                if (cjVar.lg(i2) == 1) {
                                    Hw = cjVar.Hw(i2, cjVar.lg(i2) - 1);
                                    if (cjVar.J8(Hw) == 2) {
                                        v5 = cjVar.Ws(Hw);
                                        if (this.cn.FH(v5)) {
                                            Hw2 = this.cn.Hw(v5);
                                            this.cn.DW(v5);
                                            lg = cjVar.v5(v5);
                                            DW(cjVar.we(v5), true);
                                            DW(cjVar.gW(Hw));
                                            if (this.kQ) {
                                                this.VH.j6(Hw2, lg, this.yS, 0, this.gW, this.a8, 0, this.rN);
                                            }
                                        }
                                    }
                                }
                            }
                            if (cjVar.rN(i2) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(i2) == 1 && cjVar.J8(cjVar.Hw(i2, 0)) == 2) {
                                Hw(cjVar, i, cjVar.v5(cjVar.Hw(i2, 0)), we5);
                                return;
                            }
                            return;
                        case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                        case 35:
                        case 39:
                        case 42:
                        case 44:
                        case 45:
                        case 48:
                        case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                            DW(cjVar, i, true);
                            return;
                        case 19:
                        case 21:
                        case 27:
                        case 30:
                        case 32:
                        case ProxyTextView.INPUTTYPE_time /*36*/:
                        case 38:
                        case 41:
                        case 46:
                        case 50:
                        case 51:
                            if (this.j6.j6(we2)) {
                                switch (cjVar.rN(cjVar.Hw(i, 1))) {
                                    case 46:
                                    case 47:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                        we3 = this.j6.J0();
                                        break;
                                    default:
                                        we3 = we2;
                                        break;
                                }
                                Hw(cjVar, lg, false);
                                DW(cjVar, we5, we2);
                                Hw(cjVar, v5, false);
                                DW(cjVar, we, we3);
                                j6(cjVar.rN(cjVar.Hw(i, 1)), we2);
                                return;
                            }
                            gn();
                            Hw(cjVar, lg, false);
                            Hw(cjVar, we5);
                            Hw(cjVar, v5, false);
                            Hw(cjVar, we);
                            u7();
                            return;
                        case ProxyTextView.INPUTTYPE_date /*20*/:
                        case 23:
                        case 29:
                        case 31:
                        case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                        case 37:
                        case 40:
                        case 43:
                        case 47:
                        case 52:
                        case 53:
                            break;
                        case 210:
                            Hw = this.VH.v5();
                            v52 = this.VH.v5();
                            j6(cjVar, lg, Hw, false);
                            lg = cjVar.Hw(cjVar.Hw(i, 1), 1);
                            Hw(cjVar, lg, false);
                            DW(cjVar, cjVar.we(lg), we2);
                            this.VH.Zo(v52);
                            this.VH.v5(Hw);
                            Hw(cjVar, v5, false);
                            DW(cjVar, cjVar.we(v5), we2);
                            this.VH.v5(v52);
                            return;
                        default:
                            return;
                    }
                    while (cjVar.rN(lg) == 168) {
                        lg = cjVar.Hw(lg, 1);
                    }
                    boolean j6 = this.j6.j6(we2);
                    try {
                        if (this.j6.v5(cjVar.we(), we2).hK()) {
                            j6 = true;
                        }
                    } catch (ej e) {
                    }
                    if (j6) {
                        we2 = j6(cjVar, cjVar.rN(cjVar.Hw(i, 1)), we5, we);
                        switch (cjVar.rN(cjVar.Hw(i, 1))) {
                            case 46:
                            case 47:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                                we3 = this.j6.J0();
                                break;
                            default:
                                we3 = we2;
                                break;
                        }
                        if (cjVar.rN(lg) == 165) {
                            Hw(cjVar, cjVar.Hw(lg, 0), false);
                            Hw(cjVar, cjVar.Hw(lg, 2), false);
                            this.VH.yS();
                            v5(cjVar.we(i));
                            DW(cjVar, we5, we2);
                            Hw(cjVar, v5, false);
                            DW(cjVar, we, we3);
                            j6(cjVar.rN(cjVar.Hw(i, 1)), we2);
                            j6(cjVar, we5, we2, z);
                        } else {
                            Zo(cjVar, lg, true);
                            gW(cjVar, lg);
                            DW(cjVar, we5, we2);
                            Hw(cjVar, v5, false);
                            DW(cjVar, we, we3);
                            j6(cjVar.rN(cjVar.Hw(i, 1)), we2);
                            DW(cjVar, we2, we5);
                            VH(cjVar, lg, z);
                        }
                    } else if (cjVar.rN(lg) == 165) {
                        gn();
                        Hw(cjVar, cjVar.Hw(lg, 0), false);
                        Hw(cjVar, cjVar.Hw(lg, 2), false);
                        this.VH.a8();
                        v5(cjVar.we(i));
                        Hw(cjVar, we5);
                        Hw(cjVar, v5, false);
                        Hw(cjVar, we);
                        u7();
                        j6(cjVar, we5, we2, z);
                    } else {
                        gn();
                        if (Zo(cjVar, lg, false)) {
                            this.VH.U2();
                        }
                        gW(cjVar, lg);
                        Hw(cjVar, we5);
                        Hw(cjVar, v5, false);
                        Hw(cjVar, we);
                        u7();
                        VH(cjVar, lg, z);
                    }
                    if (cjVar.rN(lg) == ProxyTextView.INPUTTYPE_textWebEditText && cjVar.lg(lg) == 1 && cjVar.J8(cjVar.Hw(lg, 0)) == 2) {
                        Hw(cjVar, i, cjVar.v5(cjVar.Hw(lg, 0)), we5);
                        return;
                    }
                    return;
                case 173:
                    we2 = cjVar.we(cjVar.Hw(i, 2));
                    lg = cjVar.lg(cjVar.Hw(i, 3)) / 3;
                    for (Hw = 0; Hw < lg; Hw++) {
                        we2 = this.Hw.j6(we2, 1);
                    }
                    Hw(cjVar, cjVar.Hw(i, 0), false);
                    DW((bs) we2, false);
                    this.VH.tp(this.a8, 0, this.rN);
                    DW(we2);
                    return;
                case 175:
                    if (cjVar.rN(cjVar.Hw(i, cjVar.lg(i) - 1)) == 196) {
                        FH(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1), cjVar.we(i));
                        return;
                    }
                    bs we6 = cjVar.we(i);
                    Hw2 = 0;
                    Hw = 3;
                    v5 = cjVar.lg(i);
                    while (Hw < v5) {
                        v52 = cjVar.Hw(i, Hw);
                        if (!(cjVar.rN(v52) == 11 || cjVar.rN(v52) == 230)) {
                            Hw(cjVar, v52, false);
                            Hw2++;
                            Hw += 3;
                        }
                        DW(we6, false);
                        this.VH.DW(this.a8, 0, this.rN, Hw2);
                        return;
                    }
                    DW(we6, false);
                    this.VH.DW(this.a8, 0, this.rN, Hw2);
                    return;
                case 176:
                    if (cjVar.lg(i) == 4) {
                        DW(cjVar.we(i), false);
                        this.VH.gn(this.a8, 0, this.rN);
                        if (!z) {
                            this.VH.er();
                        }
                        Hw = cjVar.Hw(i, 2);
                        Hw2 = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                        bzVar2 = (bz) cjVar.QX(Hw2);
                        Xa = bzVar2.Xa();
                        if (Xa.J0()) {
                            j6(cjVar, Xa.Xa());
                        }
                        j6(cjVar, Hw2, cjVar.Hw(i, 3), bzVar2);
                        if (this.J8.DW(Xa.v5())) {
                            DW(cjVar, Xa);
                        }
                        DW(cjVar, i, bzVar2);
                        j6(cjVar, bzVar2);
                        return;
                    }
                    DW(cjVar.we(i), false);
                    this.VH.gn(this.a8, 0, this.rN);
                    if (!z) {
                        this.VH.er();
                    }
                    Hw = cjVar.Hw(i, 4);
                    Hw2 = cjVar.Hw(Hw, cjVar.lg(Hw) - 2);
                    bzVar2 = (bz) cjVar.QX(Hw2);
                    Xa = bzVar2.Xa();
                    Hw(cjVar, cjVar.Hw(i, 0), false);
                    j6(cjVar, Hw2, cjVar.Hw(i, 5), bzVar2);
                    if (this.J8.DW(Xa.v5())) {
                        DW(cjVar, Xa);
                    }
                    DW(cjVar, i, bzVar2);
                    j6(cjVar, bzVar2);
                    return;
                case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                    j6(cjVar, i, z);
                    return;
                case 178:
                    this.VH.Zo(VH(cjVar, i));
                    return;
                default:
                    return;
            }
        }
        switch (cjVar.we(i).Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 7:
            case 12:
                this.VH.gn(this.Hw.v5(cjVar.gn(i)));
            case 9:
                this.VH.DW(this.Hw.VH(cjVar.gn(i)));
            case 11:
                if (this.Hw.DW(cjVar.gn(i))) {
                    this.VH.gn(1);
                } else {
                    this.VH.gn(0);
                }
            case 13:
                this.VH.DW(this.Hw.Hw(cjVar.gn(i)));
            case 14:
                this.VH.DW(this.Hw.FH(cjVar.gn(i)));
            default:
        }
    }

    private boolean yS(cj cjVar, int i) {
        if (cjVar.rN(i) == ProxyTextView.INPUTTYPE_textWebEditText) {
            int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
            if (cjVar.J8(Hw) == 16) {
                return this.FH.Zo(((bz) cjVar.QX(Hw)).tp());
            }
        }
        return false;
    }

    private void VH() {
        if (!this.vJ) {
        }
    }

    private void FH(cj cjVar, int i, co coVar) {
        int i2;
        int Hw;
        int lg = cjVar.lg(i);
        int i3 = 0;
        for (i2 = 1; i2 < lg; i2 += 2) {
            Hw = cjVar.Hw(i, i2);
            if (cjVar.rN(Hw) == 196) {
                i3++;
            } else if (cjVar.rN(Hw) != 9) {
                i3++;
            }
        }
        this.VH.gn(i3);
        DW((bs) coVar, false);
        this.VH.DW(this.a8, 0, this.rN, 1);
        Hw = 1;
        i2 = 0;
        while (Hw < lg) {
            int Hw2 = cjVar.Hw(i, Hw);
            co FH = ((bo) coVar).FH();
            if (cjVar.rN(Hw2) == 196) {
                this.VH.er();
                this.VH.gn(i2);
                FH(cjVar, Hw2, FH);
                this.VH.ei();
                i3 = i2 + 1;
            } else if (cjVar.rN(Hw2) != 9) {
                this.VH.er();
                this.VH.gn(i2);
                Hw(cjVar, Hw2, false);
                j6(cjVar, FH, cjVar.we(Hw2), true);
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            Hw += 2;
            i2 = i3;
        }
    }

    private void j6(cj cjVar, int i, int i2, bz bzVar) {
        int lg = (cjVar.lg(i2) - 1) / 2;
        int lp = bzVar.lp();
        int lg2 = cjVar.lg(i2);
        co EQ = cjVar.EQ(i);
        int i3;
        int i4;
        if (!bzVar.sh() || (lp == lg && j6(cjVar.we(), cjVar.we(cjVar.Hw(i2, lg2 - 2)), bzVar.FH(EQ, lp - 1)))) {
            i3 = 0;
            for (i4 = 1; i4 < lg2 - 1; i4 += 2) {
                co v5;
                int Hw = cjVar.Hw(i2, i4);
                if (EQ == null || !(EQ.cT() || EQ.n5())) {
                    v5 = bzVar.v5(i3);
                } else {
                    v5 = bzVar.FH(EQ, i3);
                }
                co we = cjVar.we(Hw);
                Hw(cjVar, Hw, false);
                DW(cjVar, we, v5);
                i3++;
            }
            return;
        }
        int i5;
        Hw = 1;
        for (i5 = 0; i5 < lp - 1; i5++) {
            i4 = cjVar.Hw(i2, Hw);
            co v52 = bzVar.v5(i5);
            co we2 = cjVar.we(i4);
            Hw(cjVar, i4, false);
            DW(cjVar, we2, v52);
            Hw += 2;
        }
        bs FH = bzVar.FH(EQ, lp - 1);
        EQ = ((bo) FH).FH();
        this.VH.gn((lg - lp) + 1);
        DW(FH, false);
        this.VH.DW(this.a8, 0, this.rN, 1);
        i5 = 0;
        i4 = Hw;
        while (i4 < lg2 - 1) {
            i3 = cjVar.Hw(i2, i4);
            co we3 = cjVar.we(i3);
            this.VH.er();
            this.VH.gn(i5);
            Hw(cjVar, i3, false);
            DW(cjVar, we3, EQ);
            Zo(EQ);
            i4 += 2;
            i5++;
        }
    }

    private boolean j6(bv bvVar, co coVar, co coVar2) {
        if (coVar.AL() && coVar2.AL() && (this.j6.j6(bvVar, coVar, coVar2, false) || ((bo) coVar2).FH().Z1())) {
            return true;
        }
        return false;
    }

    private void j6(cj cjVar, int i, int i2) {
        int Hw = cjVar.Hw(i, i2);
        if (i2 == 0 && cjVar.J8(Hw) == 2) {
            FH(cjVar.v5(Hw), cjVar.we(Hw));
        } else if (i2 == 0 && cjVar.J8(Hw) == 3) {
            this.VH.u7(0);
            BT(cjVar, cjVar.Ws(Hw));
        } else if (i2 != 0) {
            r0 = (bz) cjVar.QX(Hw);
            if (!r0.I()) {
                j6(cjVar, i, i2 - 2);
            }
            j6(cjVar, r0, cjVar.EQ(Hw), cjVar.we(Hw));
        } else {
            r0 = (bz) cjVar.QX(Hw);
            if (!r0.I()) {
                j6(cjVar, cjVar.EQ(Hw).a_());
            }
            j6(cjVar, r0, cjVar.EQ(Hw), cjVar.we(Hw));
        }
        FH(cjVar, i, Hw);
    }

    private void gW(cj cjVar, int i) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        if (cjVar.J8(Hw) == 27) {
            this.VH.gn();
            return;
        }
        switch (cjVar.rN(i)) {
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                if (cjVar.lg(i) == 1 && cjVar.J8(Hw) == 2) {
                    FH(cjVar.v5(Hw), cjVar.we(Hw));
                } else if (cjVar.lg(i) == 1 && cjVar.J8(Hw) == 3) {
                    BT(cjVar, cjVar.Ws(Hw));
                } else {
                    j6(cjVar, (bz) cjVar.QX(Hw), cjVar.EQ(Hw), cjVar.we(Hw));
                }
            default:
                j6(cjVar, (bz) cjVar.QX(Hw), cjVar.EQ(Hw), cjVar.we(i));
        }
    }

    private boolean Zo(cj cjVar, int i, boolean z) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        if (cjVar.J8(Hw) == 27) {
            switch (cjVar.rN(i)) {
                case 159:
                    Hw(cjVar, cjVar.Hw(i, 0), false);
                    return true;
                case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                    j6(cjVar, i, cjVar.lg(i) - 3);
                    return true;
                default:
                    return true;
            }
        }
        bz bzVar;
        switch (cjVar.rN(i)) {
            case 159:
                bzVar = (bz) cjVar.QX(Hw);
                Hw(cjVar, cjVar.Hw(i, 0), false);
                if (bzVar.I()) {
                    this.VH.j3();
                } else if (z) {
                    this.VH.er();
                }
                if (bzVar.I()) {
                    return false;
                }
                return true;
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                if (cjVar.lg(i) == 1 && cjVar.J8(Hw) == 2) {
                    return false;
                }
                if (cjVar.lg(i) == 1 && cjVar.J8(Hw) == 3) {
                    this.VH.u7(0);
                    return true;
                } else if (cjVar.lg(i) > 1) {
                    bzVar = (bz) cjVar.QX(Hw);
                    if (!bzVar.I()) {
                        j6(cjVar, i, cjVar.lg(i) - 3);
                        if (z) {
                            this.VH.er();
                        }
                    }
                    return !bzVar.I();
                } else {
                    bzVar = (bz) cjVar.QX(Hw);
                    if (!bzVar.I()) {
                        j6(cjVar, cjVar.EQ(Hw).a_());
                        if (z) {
                            this.VH.er();
                        }
                    }
                    if (bzVar.I()) {
                        return false;
                    }
                    return true;
                }
            case 162:
                bzVar = (bz) cjVar.QX(Hw);
                if (!bzVar.I()) {
                    if (cjVar.lg(i) == 3) {
                        this.VH.u7(0);
                    } else {
                        FH(cjVar.we(cjVar.Hw(i, 0)).a_());
                    }
                    if (z) {
                        this.VH.er();
                    }
                }
                if (bzVar.I()) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    private void VH(cj cjVar, int i, boolean z) {
        int Hw = cjVar.Hw(i, cjVar.lg(i) - 1);
        switch (cjVar.rN(i)) {
            case 159:
            case 162:
                j6(cjVar, (bz) cjVar.QX(Hw), cjVar.EQ(Hw), z);
            case ProxyTextView.INPUTTYPE_textWebEditText /*161*/:
                if (cjVar.lg(i) == 1 && cjVar.J8(Hw) == 2) {
                    j6(cjVar.v5(cjVar.Hw(i, 0)), cjVar.we(i), z);
                } else {
                    j6(cjVar, (bz) cjVar.QX(Hw), cjVar.EQ(Hw), z);
                }
            default:
        }
    }

    private void BT(cj cjVar, int i) {
        bs we = cjVar.we(i);
        String j6 = j6(cjVar.BT(i));
        FH(we, true);
        DW(this.XL, false);
        this.VH.DW(this.a8, 0, this.rN, j6, this.lg, 0, this.er);
    }

    private void j6(cj cjVar, bz bzVar) {
        bs Xa = bzVar.Xa();
        if (this.J8.DW(Xa.v5())) {
            DW(Xa, false);
            FH((bs) bzVar, false);
            this.er -= 2;
            this.J8.j6.j6(Xa.v5());
            while (this.J8.j6.DW()) {
                v5(cjVar.we(this.J8.j6.Hw()), true);
            }
            char[] cArr = this.lg;
            int i = this.er;
            this.er = i + 1;
            cArr[i] = ')';
            cArr = this.lg;
            i = this.er;
            this.er = i + 1;
            cArr[i] = 'V';
        } else {
            DW(Xa, false);
            FH((bs) bzVar, false);
        }
        this.VH.Hw(this.a8, 0, this.rN, "<init>", this.lg, 0, this.er);
    }

    private void DW(co coVar) {
        bs j6;
        if (coVar.AL()) {
            j6 = ((bo) coVar).j6();
        } else {
            j6 = coVar;
        }
        if (j6.cT() && !((bp) j6).hz() && !this.dx.FH(j6)) {
            this.dx.j6((bp) j6);
            DW(j6, false);
            FH(j6.Xa(), false);
            int j62 = j6(j6.aq(), j6);
            int j63 = j6(j6, true);
            DW(j62);
            this.VH.j6(this.a8, 0, this.rN, this.lg, 0, this.er, this.yS, 0, this.gW, j63);
        }
    }

    private void j6(cj cjVar, co coVar) {
        if (coVar == this.XL || this.XL.FH(coVar)) {
            this.VH.u7(0);
            return;
        }
        if (this.sG) {
            this.VH.u7(1);
        } else if (this.Qq) {
            this.VH.u7(0);
            Zo(this.XL);
        } else {
            tp();
        }
        bp Xa = this.XL.Xa();
        while (Xa != coVar && !Xa.FH(coVar) && !Xa.hz()) {
            Zo(Xa);
            Xa = Xa.Xa();
        }
    }

    private void FH(co coVar) {
        if (coVar == this.XL) {
            this.VH.u7(0);
            return;
        }
        if (this.sG) {
            this.VH.u7(1);
        } else if (this.Qq) {
            this.VH.u7(0);
            Zo(this.XL);
        } else {
            tp();
        }
        bp Xa = this.XL.Xa();
        while (Xa != coVar && !Xa.hz()) {
            Zo(Xa);
            Xa = Xa.Xa();
        }
    }

    private void Hw(co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                this.VH.we();
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 7:
            case 11:
            case 12:
                this.VH.J0();
            case 9:
                this.VH.J8();
            case 13:
                this.VH.Ws();
            case 14:
                this.VH.QX();
            default:
                this.VH.XL();
        }
    }

    private void j6(cj cjVar, bz bzVar, co coVar, co coVar2) {
        bs Xa = bzVar.Xa();
        DW((co) Xa);
        DW(Xa, false);
        FH((bs) bzVar, false);
        int j6 = j6(bzVar.aq(), (bs) bzVar);
        String Zo;
        char[] cArr;
        int i;
        char[] cArr2;
        if ((this.Qq && DW(bzVar, coVar, this.XL)) || DW(cjVar, bzVar, coVar, this.XL)) {
            Xa = (bp) coVar.a_();
            DW(Xa, false);
            Zo = Zo(bzVar);
            this.er = 0;
            cArr = this.lg;
            i = this.er;
            this.er = i + 1;
            cArr[i] = '(';
            if (!bzVar.I()) {
                v5(Xa, true);
            }
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = ')';
            v5((bs) bzVar, false);
            this.VH.FH(this.a8, 0, this.rN, Zo, this.lg, 0, this.er);
        } else if ((this.Qq && Hw(bzVar, this.XL)) || FH(bzVar, this.XL)) {
            Zo = Zo(bzVar);
            this.er = 0;
            cArr = this.lg;
            i = this.er;
            this.er = i + 1;
            cArr[i] = '(';
            if (!bzVar.I()) {
                v5(Xa, true);
            }
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = ')';
            v5((bs) bzVar, false);
            this.VH.FH(this.a8, 0, this.rN, Zo, this.lg, 0, this.er);
        } else if (bzVar.I()) {
            DW(j6);
            this.VH.FH(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else {
            DW(j6);
            this.VH.Hw(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        }
        j6(cjVar, bzVar.Mz(), coVar2);
    }

    private void j6(cj cjVar, co coVar, co coVar2) {
        if (!(coVar.q7() || coVar.Z1())) {
            if (!coVar.AL()) {
                return;
            }
            if (!(((bo) coVar).j6().q7() || ((bo) coVar).j6().Z1())) {
                return;
            }
        }
        if (coVar2 != this.j6.Zo(cjVar.we()) && coVar2.Gj() != 2 && !coVar2.k2()) {
            DW((bs) coVar2, false);
            this.VH.u7(this.a8, 0, this.rN);
        }
    }

    private void j6(cj cjVar, bz bzVar, co coVar, boolean z) {
        bs Xa = bzVar.Xa();
        DW((co) Xa);
        DW(Xa, false);
        FH((bs) bzVar, false);
        int j6 = j6(bzVar.aq(), (bs) bzVar);
        if (!z) {
            switch (bzVar.Mz().Gj()) {
                case 9:
                case 14:
                    if (!bzVar.I()) {
                        this.VH.a8();
                        break;
                    } else {
                        this.VH.yS();
                        break;
                    }
                default:
                    if (!bzVar.I()) {
                        this.VH.U2();
                        break;
                    } else {
                        this.VH.er();
                        break;
                    }
            }
        }
        String VH;
        char[] cArr;
        int i;
        char[] cArr2;
        if ((this.Qq && DW(bzVar, coVar, this.XL)) || DW(cjVar, bzVar, coVar, this.XL)) {
            Xa = (bp) coVar.a_();
            DW(Xa, false);
            VH = VH(bzVar);
            this.er = 0;
            cArr = this.lg;
            i = this.er;
            this.er = i + 1;
            cArr[i] = '(';
            if (!bzVar.I()) {
                v5(Xa, true);
            }
            v5((bs) bzVar, false);
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = ')';
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = 'V';
            this.VH.FH(this.a8, 0, this.rN, VH, this.lg, 0, this.er);
        } else if ((this.Qq && Hw(bzVar, this.XL)) || FH(bzVar, this.XL)) {
            VH = VH(bzVar);
            this.er = 0;
            cArr = this.lg;
            i = this.er;
            this.er = i + 1;
            cArr[i] = '(';
            if (!bzVar.I()) {
                v5(Xa, true);
            }
            v5((bs) bzVar, false);
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = ')';
            cArr2 = this.lg;
            j6 = this.er;
            this.er = j6 + 1;
            cArr2[j6] = 'V';
            this.VH.FH(this.a8, 0, this.rN, VH, this.lg, 0, this.er);
        } else if (bzVar.I()) {
            DW(j6);
            this.VH.j6(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else {
            DW(j6);
            this.VH.DW(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        }
    }

    private void j6(cj cjVar, bz bzVar, co coVar, co coVar2, boolean z, boolean z2, boolean z3) {
        DW(bzVar.Xa());
        FH((bs) bzVar, false);
        int j6 = j6(bzVar.aq(), (bs) bzVar);
        bs bsVar;
        String v5;
        char[] cArr;
        int i;
        if (z2) {
            bsVar = (bp) coVar.a_();
            v5 = v5(bzVar);
            if (bzVar.I()) {
                FH((bs) bzVar, false);
            } else {
                this.rN = 0;
                cArr = this.a8;
                i = this.rN;
                this.rN = i + 1;
                cArr[i] = '(';
                Hw(bsVar, true);
                this.er = this.rN - 1;
                v5((bs) bzVar, false);
                System.arraycopy(this.a8, 0, this.lg, 0, this.rN);
            }
            DW(bsVar, false);
            this.VH.FH(this.a8, 0, this.rN, v5, this.lg, 0, this.er);
        } else if (z && this.Qq) {
            bsVar = this.XL;
            v5 = v5(bzVar);
            if (bzVar.I()) {
                FH((bs) bzVar, false);
            } else {
                this.rN = 0;
                cArr = this.a8;
                i = this.rN;
                this.rN = i + 1;
                cArr[i] = '(';
                Hw(bsVar, true);
                this.er = this.rN - 1;
                v5((bs) bzVar, false);
                System.arraycopy(this.a8, 0, this.lg, 0, this.rN);
            }
            DW(bsVar, false);
            this.VH.FH(this.a8, 0, this.rN, v5, this.lg, 0, this.er);
        } else if (z) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.gn(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if ((this.Qq && j6(bzVar, coVar, this.XL)) || j6(cjVar, bzVar, coVar, this.XL)) {
            bsVar = (bp) coVar.a_();
            v5 = Hw(bzVar);
            if (bzVar.I()) {
                FH((bs) bzVar, false);
            } else {
                this.rN = 0;
                cArr = this.a8;
                i = this.rN;
                this.rN = i + 1;
                cArr[i] = '(';
                Hw(bsVar, true);
                this.er = this.rN - 1;
                v5((bs) bzVar, false);
                System.arraycopy(this.a8, 0, this.lg, 0, this.rN);
            }
            DW(bsVar, false);
            this.VH.FH(this.a8, 0, this.rN, v5, this.lg, 0, this.er);
        } else if ((this.Qq && DW(bzVar, this.XL)) || j6(bzVar, this.XL)) {
            bsVar = (bp) coVar.a_();
            v5 = Hw(bzVar);
            if (bzVar.I()) {
                FH((bs) bzVar, false);
            } else {
                this.rN = 0;
                cArr = this.a8;
                i = this.rN;
                this.rN = i + 1;
                cArr[i] = '(';
                Hw(bsVar, true);
                this.er = this.rN - 1;
                v5((bs) bzVar, false);
                System.arraycopy(this.a8, 0, this.lg, 0, this.rN);
            }
            DW(bsVar, false);
            this.VH.FH(this.a8, 0, this.rN, v5, this.lg, 0, this.er);
        } else if (bzVar.I()) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.Zo(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if (bzVar.Q6()) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.gn(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if (coVar == null) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.VH(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if (coVar.a_().g3() && !bzVar.Xa().g3()) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.VH(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if (coVar.a_().g3()) {
            DW(coVar.a_(), false);
            DW(j6);
            this.VH.v5(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else if (this.br) {
            DW(bzVar.Xa(), false);
            DW(j6);
            this.VH.VH(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        } else {
            DW(coVar.a_(), false);
            DW(j6);
            this.VH.VH(this.a8, 0, this.rN, this.yS, 0, this.gW, this.lg, 0, this.er);
        }
        if (!z3) {
            j6(cjVar, bzVar.Mz(), coVar2);
            if (this.j6.j6(bzVar) && coVar2.AL()) {
                DW((bs) coVar2, false);
                this.VH.u7(this.a8, 0, this.rN);
            }
        }
        if (z3) {
            switch (bzVar.Mz().Gj()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                case 9:
                case 14:
                    this.VH.Mr();
                default:
                    this.VH.j3();
            }
        }
    }

    private void j6(int i, co coVar, int i2, boolean z) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.BT(i2, z);
                    case 9:
                        this.VH.tp(i2, z);
                    case 13:
                        this.VH.QX(i2, z);
                    case 14:
                        this.VH.a8(i2, z);
                    default:
                }
            case 35:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.gW(i2, z);
                    case 9:
                        this.VH.u7(i2, z);
                    case 13:
                        this.VH.Ws(i2, z);
                    case 14:
                        this.VH.U2(i2, z);
                    default:
                }
            case 44:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.lg(i2, z);
                    case 9:
                        this.VH.v5(i2, z);
                    case 13:
                        this.VH.EQ(i2, z);
                    case 14:
                        this.VH.XL(i2, z);
                    default:
                }
            case 45:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.er(i2, z);
                    case 9:
                        this.VH.gn(i2, z);
                    case 13:
                        this.VH.J8(i2, z);
                    case 14:
                        this.VH.j3(i2, z);
                    default:
                }
            case 48:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.yS(i2, z);
                    case 9:
                        this.VH.VH(i2, z);
                    case 13:
                        this.VH.J0(i2, z);
                    case 14:
                        this.VH.Mr(i2, z);
                    default:
                }
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
                switch (coVar.Gj()) {
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    case 5:
                    case 7:
                    case 12:
                        this.VH.rN(i2, z);
                    case 9:
                        this.VH.Zo(i2, z);
                    case 13:
                        this.VH.we(i2, z);
                    case 14:
                        this.VH.aM(i2, z);
                    default:
                }
            default:
        }
    }

    private void j6(int i, co coVar) {
        switch (i) {
            case 19:
            case ProxyTextView.INPUTTYPE_date /*20*/:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.XG();
                    case 13:
                        this.VH.oY();
                    case 14:
                        this.VH.jw();
                    default:
                        this.VH.I();
                }
            case 21:
            case 23:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.kQ();
                    case 13:
                        this.VH.jO();
                    case 14:
                        this.VH.mb();
                    default:
                        this.VH.g3();
                }
            case 27:
            case 29:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.hz();
                    case 13:
                        this.VH.WB();
                    case 14:
                        this.VH.zh();
                    default:
                        this.VH.OW();
                }
            case 30:
            case 31:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.jJ();
                    case 13:
                        this.VH.ko();
                    case 14:
                        this.VH.fY();
                    default:
                        this.VH.ca();
                }
            case 32:
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.CU();
                    case 13:
                        this.VH.ye();
                    case 14:
                        this.VH.k2();
                    default:
                        this.VH.sy();
                }
            case ProxyTextView.INPUTTYPE_time /*36*/:
            case 37:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.FN();
                    default:
                        this.VH.XX();
                }
            case 38:
            case 40:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.et();
                    default:
                        this.VH.Qq();
                }
            case 41:
            case 43:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.yO();
                    default:
                        this.VH.Mz();
                }
            case 46:
            case 47:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.Xa();
                    default:
                        this.VH.aj();
                }
            case 50:
            case 52:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.Eq();
                    default:
                        this.VH.lp();
                }
            case 51:
            case 53:
                switch (coVar.Gj()) {
                    case 9:
                        this.VH.aq();
                    default:
                        this.VH.br();
                }
            default:
        }
    }

    private co j6(cj cjVar, int i, co coVar, co coVar2) {
        int i2 = 21;
        switch (i) {
            case ProxyTextView.INPUTTYPE_date /*20*/:
                i2 = 3;
                break;
            case 23:
                i2 = 1;
                break;
            case 29:
                i2 = 2;
                break;
            case 31:
                i2 = 5;
                break;
            case ProxyTextView.INPUTTYPE_textEmailAddress /*33*/:
                i2 = 4;
                break;
            case 37:
                i2 = 8;
                break;
            case 40:
                i2 = 6;
                break;
            case 43:
                i2 = 7;
                break;
            case 47:
                i2 = 17;
                break;
            case 52:
                i2 = 18;
                break;
            case 53:
                i2 = 19;
                break;
        }
        return this.j6.DW(cjVar.we(), i2, coVar, coVar2);
    }

    private co DW(cj cjVar, co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 12:
                return this.j6.J0();
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
                return coVar;
            default:
                try {
                    co v5 = this.j6.v5(cjVar.we(), coVar);
                    switch (v5.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        case 5:
                        case 12:
                            return this.j6.J0();
                        case 7:
                            return v5;
                        case 9:
                            return v5;
                        case 11:
                            return v5;
                        case 13:
                            return v5;
                        case 14:
                            return v5;
                        default:
                            return coVar;
                    }
                } catch (ej e) {
                    return coVar;
                }
                return coVar;
        }
    }

    private void DW(int i, co coVar) {
        int i2 = 1;
        if (i == 28) {
            i2 = -1;
        }
        switch (coVar.Gj()) {
            case 9:
                this.VH.DW((long) i2);
            case 13:
                this.VH.DW((float) i2);
            case 14:
                this.VH.DW((double) i2);
            default:
                this.VH.gn(i2);
        }
    }

    private void v5(co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.VH.sG();
            case 5:
                this.VH.Sf();
            case 7:
                this.VH.ro();
            case 9:
                this.VH.cn();
            case 11:
                this.VH.sG();
            case 12:
                this.VH.ef();
            case 13:
                this.VH.sh();
            case 14:
                this.VH.cb();
            default:
                this.VH.dx();
        }
    }

    private void FH(int i, co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 7:
            case 11:
            case 12:
                this.VH.tp(i);
            case 9:
                this.VH.J0(i);
            case 13:
                this.VH.EQ(i);
            case 14:
                this.VH.we(i);
            default:
                this.VH.u7(i);
        }
    }

    private void j6(cj cjVar, co coVar, co coVar2, boolean z) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 5:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 7:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 9:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.rN();
                    break;
                }
                break;
            case 11:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 12:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 13:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
            case 14:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.rN();
                    break;
                }
                break;
            default:
                DW(cjVar, coVar2, coVar);
                if (!z) {
                    this.VH.lg();
                    break;
                }
                break;
        }
        Zo(coVar);
    }

    private void Zo(co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.VH.nw();
            case 5:
                this.VH.KD();
            case 7:
                this.VH.gW();
            case 9:
                this.VH.BT();
            case 11:
                this.VH.nw();
            case 12:
                this.VH.SI();
            case 13:
                this.VH.vy();
            case 14:
                this.VH.P8();
            default:
                this.VH.ei();
        }
    }

    private void j6(int i, co coVar, boolean z) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 7:
            case 12:
                if (!z) {
                    this.VH.er();
                }
                this.VH.Ws(i);
            case 9:
                if (!z) {
                    this.VH.yS();
                }
                this.VH.XL(i);
            case 11:
                if (!z) {
                    this.VH.er();
                }
                this.VH.Ws(i);
            case 13:
                if (!z) {
                    this.VH.er();
                }
                this.VH.QX(i);
            case 14:
                if (!z) {
                    this.VH.yS();
                }
                this.VH.aM(i);
            default:
                if (!z) {
                    this.VH.er();
                }
                this.VH.J8(i);
        }
    }

    private void FH(cj cjVar, co coVar) {
        try {
            if (coVar == this.j6.aM(cjVar.we())) {
                this.VH.v5("java/lang/Integer");
                this.VH.v5("java/lang/Integer", "intValue", "()I");
            } else if (coVar == this.j6.J8(cjVar.we())) {
                this.VH.v5("java/lang/Byte");
                this.VH.v5("java/lang/Byte", "byteValue", "()B");
            } else if (coVar == this.j6.XL(cjVar.we())) {
                this.VH.v5("java/lang/Short");
                this.VH.v5("java/lang/Short", "shortValue", "()S");
            } else if (coVar == this.j6.j3(cjVar.we())) {
                this.VH.v5("java/lang/Long");
                this.VH.v5("java/lang/Long", "longValue", "()J");
            } else if (coVar == this.j6.Mr(cjVar.we())) {
                this.VH.v5("java/lang/Float");
                this.VH.v5("java/lang/Float", "floatValue", "()F");
            } else if (coVar == this.j6.U2(cjVar.we())) {
                this.VH.v5("java/lang/Double");
                this.VH.v5("java/lang/Double", "doubleValue", "()D");
            } else if (coVar == this.j6.Ws(cjVar.we())) {
                this.VH.v5("java/lang/Character");
                this.VH.v5("java/lang/Character", "charValue", "()C");
                this.VH.Jl();
            } else if (coVar == this.j6.EQ(cjVar.we())) {
                this.VH.v5("java/lang/Boolean");
                this.VH.v5("java/lang/Boolean", "booleanValue", "()Z");
            }
        } catch (ej e) {
        }
    }

    private void VH(co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                this.VH.Hw("java/lang/Byte");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Byte", "<init>", "(B)V");
            case 5:
                this.VH.Hw("java/lang/Short");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Short", "<init>", "(S)V");
            case 7:
                this.VH.Hw("java/lang/Integer");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Integer", "<init>", "(I)V");
            case 9:
                this.VH.Hw("java/lang/Long");
                this.VH.lg();
                this.VH.lg();
                this.VH.j3();
                this.VH.Zo("java/lang/Long", "<init>", "(J)V");
            case 11:
                this.VH.Hw("java/lang/Boolean");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Boolean", "<init>", "(Z)V");
            case 12:
                this.VH.Hw("java/lang/Character");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Character", "<init>", "(C)V");
            case 13:
                this.VH.Hw("java/lang/Float");
                this.VH.U2();
                this.VH.aM();
                this.VH.Zo("java/lang/Float", "<init>", "(F)V");
            case 14:
                this.VH.Hw("java/lang/Double");
                this.VH.lg();
                this.VH.lg();
                this.VH.j3();
                this.VH.Zo("java/lang/Double", "<init>", "(D)V");
            default:
        }
    }

    private void DW(cj cjVar, co coVar, co coVar2) {
        if (coVar != coVar2) {
            if (coVar.AL() && coVar2.AL() && ((bo) coVar).j6().k2()) {
                DW((bs) coVar2, false);
                this.VH.u7(this.a8, 0, this.rN);
            } else if (coVar.k2()) {
                if (coVar2 != this.j6.Zo(cjVar.we())) {
                    DW((bs) coVar2, false);
                    this.VH.u7(this.a8, 0, this.rN);
                }
            } else if (this.j6.j6(coVar) && this.j6.DW(coVar2)) {
                if (coVar2 == this.j6.Zo(cjVar.we())) {
                    VH(coVar);
                    return;
                }
                try {
                    co v5 = this.j6.v5(cjVar.we(), coVar2);
                    j6(coVar, v5);
                    VH(v5);
                } catch (ej e) {
                    VH(coVar);
                }
            } else if (this.j6.j6(coVar2) && this.j6.DW(coVar)) {
                if (coVar == this.j6.v5(cjVar.we())) {
                    FH(cjVar, this.j6.j6(cjVar.we(), coVar2));
                    return;
                }
                FH(cjVar, coVar);
                j6(this.j6.v5(cjVar.we(), coVar), coVar2);
            } else if (coVar.Gj() == 2) {
                DW((bs) coVar2, false);
                this.VH.u7(this.a8, 0, this.rN);
            } else {
                j6(coVar, coVar2);
            }
        }
    }

    private void j6(co coVar, co coVar2) {
        if (coVar != coVar2) {
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    switch (coVar2.Gj()) {
                        case 5:
                            this.VH.eU();
                        case 9:
                            this.VH.Q6();
                        case 12:
                            this.VH.Jl();
                        case 13:
                            this.VH.iW();
                        case 14:
                            this.VH.n5();
                        default:
                    }
                case 5:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.kf();
                        case 9:
                            this.VH.Q6();
                        case 12:
                            this.VH.Jl();
                        case 13:
                            this.VH.iW();
                        case 14:
                            this.VH.n5();
                        default:
                    }
                case 7:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.kf();
                        case 5:
                            this.VH.eU();
                        case 9:
                            this.VH.Q6();
                        case 12:
                            this.VH.Jl();
                        case 13:
                            this.VH.iW();
                        case 14:
                            this.VH.n5();
                        default:
                    }
                case 9:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.sg();
                            this.VH.kf();
                        case 5:
                            this.VH.sg();
                            this.VH.eU();
                        case 7:
                            this.VH.sg();
                        case 12:
                            this.VH.sg();
                            this.VH.Jl();
                        case 13:
                            this.VH.sE();
                        case 14:
                            this.VH.e3();
                        default:
                    }
                case 12:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.kf();
                        case 5:
                            this.VH.eU();
                        case 9:
                            this.VH.Q6();
                        case 13:
                            this.VH.iW();
                        case 14:
                            this.VH.n5();
                        default:
                    }
                case 13:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.Z1();
                            this.VH.kf();
                        case 5:
                            this.VH.Z1();
                            this.VH.eU();
                        case 7:
                            this.VH.Z1();
                        case 9:
                            this.VH.q7();
                        case 12:
                            this.VH.Z1();
                            this.VH.Jl();
                        case 14:
                            this.VH.cT();
                        default:
                    }
                case 14:
                    switch (coVar2.Gj()) {
                        case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                            this.VH.w9();
                            this.VH.kf();
                        case 5:
                            this.VH.w9();
                            this.VH.eU();
                        case 7:
                            this.VH.w9();
                        case 9:
                            this.VH.hK();
                        case 12:
                            this.VH.w9();
                            this.VH.Jl();
                        case 13:
                            this.VH.AL();
                        default:
                    }
                default:
            }
        }
    }

    private void gn() {
        this.VH.Hw("java/lang/StringBuffer");
        this.VH.er();
        this.VH.Zo("java/lang/StringBuffer", "<init>", "()V");
    }

    private void u7() {
        this.VH.v5("java/lang/StringBuffer", "toString", "()Ljava/lang/String;");
    }

    private void Hw(cj cjVar, co coVar) {
        switch (coVar.Gj()) {
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case 5:
            case 7:
                this.VH.v5("java/lang/StringBuffer", "append", "(I)Ljava/lang/StringBuffer;");
            case 9:
                this.VH.v5("java/lang/StringBuffer", "append", "(J)Ljava/lang/StringBuffer;");
            case 11:
                this.VH.v5("java/lang/StringBuffer", "append", "(Z)Ljava/lang/StringBuffer;");
            case 12:
                this.VH.v5("java/lang/StringBuffer", "append", "(C)Ljava/lang/StringBuffer;");
            case 13:
                this.VH.v5("java/lang/StringBuffer", "append", "(F)Ljava/lang/StringBuffer;");
            case 14:
                this.VH.v5("java/lang/StringBuffer", "append", "(D)Ljava/lang/StringBuffer;");
            default:
                if (coVar == this.j6.lg(cjVar.we())) {
                    this.VH.v5("java/lang/StringBuffer", "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;");
                } else {
                    this.VH.v5("java/lang/StringBuffer", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuffer;");
                }
        }
    }

    private void j6(co coVar, int i) {
        if (this.j6.j6(coVar) || coVar.Gj() == 1) {
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    this.VH.DW("java/lang/Void", "TYPE", "Ljava/lang/Class;");
                    return;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.VH.DW("java/lang/Byte", "TYPE", "Ljava/lang/Class;");
                    return;
                case 5:
                    this.VH.DW("java/lang/Short", "TYPE", "Ljava/lang/Class;");
                    return;
                case 7:
                    this.VH.DW("java/lang/Integer", "TYPE", "Ljava/lang/Class;");
                    return;
                case 9:
                    this.VH.DW("java/lang/Long", "TYPE", "Ljava/lang/Class;");
                    return;
                case 11:
                    this.VH.DW("java/lang/Boolean", "TYPE", "Ljava/lang/Class;");
                    return;
                case 12:
                    this.VH.DW("java/lang/Character", "TYPE", "Ljava/lang/Class;");
                    return;
                case 13:
                    this.VH.DW("java/lang/Float", "TYPE", "Ljava/lang/Class;");
                    return;
                case 14:
                    this.VH.DW("java/lang/Double", "TYPE", "Ljava/lang/Class;");
                    return;
                default:
                    return;
            }
        }
        int v5 = this.VH.v5();
        int v52 = this.VH.v5();
        int v53 = this.VH.v5();
        this.VH.v5(v5);
        DW((bs) coVar, false);
        for (int i2 = 0; i2 < this.rN; i2++) {
            if (this.a8[i2] == '/') {
                this.a8[i2] = '.';
            }
        }
        this.VH.EQ(this.a8, 0, this.rN);
        this.VH.Hw("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        this.VH.v5(v52);
        this.VH.Zo(v53);
        this.VH.j6(v5, v52, "java/lang/ClassNotFoundException".toCharArray(), 0, 32);
        this.VH.J8(i);
        this.VH.Hw("java/lang/NoClassDefFoundError");
        this.VH.er();
        this.VH.u7(i);
        this.VH.v5("java/lang/Throwable", "getMessage", "()Ljava/lang/String;");
        this.VH.Zo("java/lang/NoClassDefFoundError", "<init>", "(Ljava/lang/String;)V");
        this.VH.EQ();
        this.VH.v5(v53);
    }

    private void j6(cj cjVar, bp bpVar, bz bzVar) {
        int i = 0;
        boolean z = this.lp;
        int i2 = 8;
        if (this.aj) {
            i2 = 4104;
        }
        String Zo = Zo(bzVar);
        this.er = 0;
        char[] cArr = this.lg;
        int i3 = this.er;
        this.er = i3 + 1;
        cArr[i3] = '(';
        if (!bzVar.I()) {
            v5((bs) bpVar, true);
        }
        cArr = this.lg;
        i3 = this.er;
        this.er = i3 + 1;
        cArr[i3] = ')';
        v5((bs) bzVar, false);
        this.VH.j6(i2, Zo, this.lg, 0, this.er, z, false, true);
        if (!bzVar.I()) {
            this.VH.u7(0);
        }
        j6(cjVar, bzVar, null, this.j6.Zo(cjVar.we()));
        Hw(bzVar.Mz());
        if (!bzVar.U2()) {
            Zo = VH(bzVar);
            this.er = 0;
            cArr = this.lg;
            i3 = this.er;
            this.er = i3 + 1;
            cArr[i3] = '(';
            if (!bzVar.I()) {
                v5((bs) bpVar, true);
            }
            v5((bs) bzVar, false);
            cArr = this.lg;
            i3 = this.er;
            this.er = i3 + 1;
            cArr[i3] = ')';
            cArr = this.lg;
            i3 = this.er;
            this.er = i3 + 1;
            cArr[i3] = 'V';
            this.VH.j6(i2, Zo, this.lg, 0, this.er, z, false, true);
            if (!bzVar.I()) {
                this.VH.u7(0);
            }
            if (!bzVar.I()) {
                i = 1;
            }
            FH(i, bzVar.Mz());
            j6(cjVar, bzVar, null, true);
            this.VH.we();
        }
    }

    private void DW(cj cjVar, bz bzVar) {
        int rN = bzVar.rN();
        for (int i = 0; i < rN; i++) {
            co DW = bzVar.DW(i);
            if (this.j6.Hw(cjVar.we(), DW)) {
                DW((bs) DW, false);
                this.VH.VH(this.a8, 0, this.rN);
                DW(DW);
            }
        }
    }

    private void j6(cj cjVar, bz bzVar, ea<bz> eaVar) {
        if (eaVar != null) {
            eaVar.j6.j6();
            while (eaVar.j6.DW()) {
                bs bsVar = (bz) eaVar.j6.FH();
                DW((bs) bzVar, false);
                FH(bsVar, false);
                int j6 = j6((bs) bzVar, true) & -1025;
                if (this.aj) {
                    j6 |= 64;
                }
                int j62 = j6(bzVar.aq(), (bs) bzVar);
                boolean z = this.lp;
                DW(j62);
                this.VH.j6(j6, this.yS, 0, this.gW, this.lg, 0, this.er, z, false, true);
                DW(cjVar, bzVar);
                co j3 = this.XL.j3();
                this.VH.u7(0);
                int lp = bsVar.lp();
                j62 = 1;
                for (j6 = 0; j6 < lp; j6++) {
                    co v5 = bsVar.v5(j6);
                    co FH = bzVar.FH(j3, j6);
                    FH(j62, v5);
                    j6(cjVar, v5, FH);
                    switch (v5.Gj()) {
                        case 9:
                        case 14:
                            j62 += 2;
                            break;
                        default:
                            j62++;
                            break;
                    }
                }
                j6(cjVar, bzVar, null, this.j6.Zo(cjVar.we()), false, false, false);
                DW(cjVar, bsVar.DW(j3), bsVar.Mz());
                Hw(bsVar.Mz());
            }
        }
    }

    private void j6(cj cjVar, bp bpVar, bz bzVar, boolean z) {
        String v5;
        boolean z2 = this.lp;
        int i = 8;
        if (this.aj) {
            i = 4104;
        }
        if (z) {
            v5 = v5(bzVar);
        } else {
            v5 = Hw(bzVar);
        }
        if (bzVar.I()) {
            FH((bs) bzVar, false);
        } else {
            this.rN = 0;
            char[] cArr = this.a8;
            int i2 = this.rN;
            this.rN = i2 + 1;
            cArr[i2] = '(';
            Hw((bs) bpVar, true);
            this.er = this.rN - 1;
            v5((bs) bzVar, false);
            System.arraycopy(this.a8, 0, this.lg, 0, this.rN);
        }
        this.VH.j6(i, v5, this.lg, 0, this.er, z2, false, true);
        DW(cjVar, bzVar);
        if (!bzVar.I()) {
            this.VH.u7(0);
        }
        int lp = bzVar.lp();
        int i3 = 0;
        if (!bzVar.I()) {
            i3 = 1;
        }
        for (i = 0; i < lp; i++) {
            co v52 = bzVar.v5(i);
            FH(i3, v52);
            switch (v52.Gj()) {
                case 9:
                case 14:
                    i3 += 2;
                    break;
                default:
                    i3++;
                    break;
            }
        }
        j6(cjVar, bzVar, null, this.j6.Zo(cjVar.we()), z, false, false);
        Hw(bzVar.Mz());
    }

    private void j6(bp bpVar, int i) {
        this.VH.u7(0);
        this.VH.u7(i);
        bs Xa = bpVar.Xa();
        DW(this.XL, false);
        FH(Xa, true);
        this.VH.j6(this.a8, 0, this.rN, Hw(), this.lg, 0, this.er);
    }

    private void Zo(bp bpVar) {
        String v5 = v5();
        DW((bs) bpVar, false);
        this.er = 0;
        char[] cArr = this.lg;
        int i = this.er;
        this.er = i + 1;
        cArr[i] = '(';
        v5((bs) bpVar, true);
        cArr = this.lg;
        i = this.er;
        this.er = i + 1;
        cArr[i] = ')';
        v5(bpVar.Xa(), true);
        this.VH.FH(this.a8, 0, this.rN, v5, this.lg, 0, this.er);
    }

    private void tp() {
        this.VH.u7(0);
        bs Xa = this.XL.Xa();
        DW(this.XL, false);
        FH(Xa, true);
        this.VH.DW(this.a8, 0, this.rN, Hw(), this.lg, 0, this.er);
    }

    private void VH(bp bpVar) {
        if (bpVar.J0()) {
            boolean z = this.lp;
            bs Xa;
            String v5;
            char[] cArr;
            int i;
            if (this.aj) {
                Xa = bpVar.Xa();
                DW(Xa, true);
                this.VH.j6(18, Hw(), this.a8, 0, this.rN, z, false);
                v5 = v5();
                this.er = 0;
                cArr = this.lg;
                i = this.er;
                this.er = i + 1;
                cArr[i] = '(';
                v5((bs) bpVar, true);
                cArr = this.lg;
                i = this.er;
                this.er = i + 1;
                cArr[i] = ')';
                v5(Xa, true);
                this.VH.j6(8, v5, this.lg, 0, this.er, z, false, true);
                tp();
                this.VH.XL();
            } else {
                Xa = bpVar.Xa();
                DW(Xa, true);
                this.VH.j6(18, Hw(), this.a8, 0, this.rN, z, false);
                v5 = v5();
                this.er = 0;
                cArr = this.lg;
                i = this.er;
                this.er = i + 1;
                cArr[i] = '(';
                v5((bs) bpVar, true);
                cArr = this.lg;
                i = this.er;
                this.er = i + 1;
                cArr[i] = ')';
                v5(Xa, true);
                this.VH.j6(8, v5, this.lg, 0, this.er, z, false, true);
                tp();
                this.VH.XL();
            }
        }
    }

    private void EQ() {
        this.VH.Zo();
        this.VH.Zo();
        this.VH.Zo();
    }

    private void we() {
    }

    private void FH(int i) {
        if (this.vJ) {
            this.VH.Hw(i);
        } else {
            this.VH.Hw(i);
        }
    }

    private void vy(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.DW((long) cjVar.we().vy());
            this.VH.Hw("adrt/ADRT", "onMethodEnter", "(J)Ladrt/ADRTThread;");
            this.VH.J8(cjVar.v5(i));
        }
    }

    private void P8(cj cjVar, int i) {
        if (this.vJ) {
            ro(cjVar, cjVar.Hw(i, cjVar.lg(i) - 1));
        }
    }

    private void ei(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.v5("adrt/ADRTThread", "onMethodExit", "()V");
        }
    }

    private void nw(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.v5("adrt/ADRTThread", "onMethodExit", "()V");
        }
    }

    private void SI(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.v5("adrt/ADRTThread", "onMethodExit", "()V");
        }
    }

    private void KD(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.gn(cjVar.nw(i));
            this.VH.v5("adrt/ADRTThread", "onStatementStart", "(I)V");
        }
    }

    private void DW(cj cjVar, int i, int i2) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.gn(cjVar.nw(i));
            this.VH.v5("adrt/ADRTThread", "onStatementStart", "(I)V");
        }
    }

    private void ro(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.gn(cjVar.nw(i));
            this.VH.v5("adrt/ADRTThread", "onStatementStart", "(I)V");
        }
    }

    private void gn(cj cjVar, int i, boolean z) {
        if (!this.vJ) {
        }
    }

    private void u7(cj cjVar, int i, boolean z) {
        if (!this.vJ) {
        }
    }

    private void DW(cj cjVar, int i, bz bzVar) {
        if (!this.vJ) {
        }
    }

    private void cn(cj cjVar, int i) {
        if (!this.vJ) {
        }
    }

    private void FH(cj cjVar, int i, int i2) {
        if (!this.vJ) {
        }
    }

    private void DW(cj cjVar, int i, int i2, co coVar) {
        if (this.vJ) {
            j6(cjVar, i, i2, coVar);
        }
    }

    private void FH(cj cjVar, int i, int i2, co coVar) {
        if (!this.vJ) {
        }
    }

    private void sh(cj cjVar, int i) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.u7(0);
            this.VH.v5("adrt/ADRTThread", "onThisAvailable", "(Ljava/lang/Object;)V");
        }
    }

    private void cb(cj cjVar, int i) {
        if (!this.vJ) {
        }
    }

    private void Hw(cj cjVar, int i, int i2, co coVar) {
        if (this.vJ) {
            this.VH.u7(this.U2);
            this.VH.gn(i2);
            FH(i2, coVar);
            switch (coVar.Gj()) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IB)V");
                case 5:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IS)V");
                case 7:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(II)V");
                case 9:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IJ)V");
                case 11:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IZ)V");
                case 12:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IC)V");
                case 13:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(IF)V");
                case 14:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(ID)V");
                default:
                    this.VH.v5("adrt/ADRTThread", "onVariableWrite", "(ILjava/lang/Object;)V");
            }
        }
    }
}
