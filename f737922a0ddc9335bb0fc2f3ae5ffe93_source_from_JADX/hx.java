import com.aide.uidesigner.ProxyTextView;
import java.io.File;

public class hx {
    private eb DW;
    private du FH;
    private er Hw;
    private int VH;
    private int Zo;
    private int gn;
    private final cc j6;
    private int tp;
    private int u7;
    private er v5;

    public hx(cc ccVar) {
        this.j6 = ccVar;
        this.DW = new eb(ccVar.cn);
        this.FH = new du();
        this.v5 = new er(ccVar);
        this.Hw = new er(ccVar);
        this.Zo = ccVar.ro.j6("public");
        this.VH = ccVar.ro.j6("system");
        this.gn = ccVar.ro.j6("uri");
        this.u7 = ccVar.ro.j6("publicId");
        this.tp = ccVar.ro.j6("systemId");
    }

    public bv j6(String str) {
        j6();
        this.DW.j6.j6();
        while (this.DW.j6.DW()) {
            bv FH = this.DW.j6.FH();
            for (bj bjVar : FH.BT().Zo()) {
                if (bjVar instanceof ih) {
                    cj DW = this.j6.sh.DW(FH, bjVar);
                    String DW2 = DW(DW, DW.Ws(), str);
                    if (DW2 != null && DW2.startsWith("file:")) {
                        DW2 = DW2.substring(5, DW2.length());
                        if (!DW2.startsWith("/")) {
                            File file = new File(FH.u7().er(), DW2);
                            if (file.isFile() && file.canRead()) {
                                return this.j6.cn.DW(file.getPath());
                            }
                        }
                    }
                    this.j6.sh.j6(DW);
                }
            }
        }
        return null;
    }

    public bv DW(String str) {
        j6();
        this.DW.j6.j6();
        while (this.DW.j6.DW()) {
            bv FH = this.DW.j6.FH();
            for (bj bjVar : FH.BT().Zo()) {
                if (bjVar instanceof ih) {
                    cj DW = this.j6.sh.DW(FH, bjVar);
                    String j6 = j6(DW, DW.Ws(), str);
                    if (j6 != null && j6.startsWith("file:")) {
                        j6 = j6.substring(5, j6.length());
                        if (!j6.startsWith("/")) {
                            File file = new File(FH.u7().er(), j6);
                            if (file.isFile() && file.canRead()) {
                                return this.j6.cn.DW(file.getPath());
                            }
                        }
                    }
                    this.j6.sh.j6(DW);
                }
            }
        }
        return null;
    }

    private String j6(cj cjVar, int i, String str) {
        int i2;
        switch (cjVar.rN(i)) {
            case 200:
            case 201:
                if (cjVar.gW(cjVar.Hw(i, 1)) == this.Zo) {
                    for (i2 = 2; i2 < cjVar.lg(i) - 1; i2++) {
                        int Hw = cjVar.Hw(i, i2);
                        if (cjVar.rN(Hw) == 203) {
                            int U2 = ik.U2(cjVar, Hw);
                            if (U2 == this.u7) {
                                j6(cjVar, cjVar.Hw(Hw, cjVar.lg(Hw) - 1));
                                if (!this.Hw.j6(str)) {
                                    break;
                                }
                            }
                            if (U2 == this.gn) {
                                j6(cjVar, cjVar.Hw(Hw, cjVar.lg(Hw) - 1));
                                return this.Hw.toString();
                            }
                        }
                    }
                    break;
                }
                break;
        }
        for (i2 = 0; i2 < cjVar.lg(i); i2++) {
            String j6 = j6(cjVar, cjVar.Hw(i, i2), str);
            if (j6 != null) {
                return j6;
            }
        }
        return null;
    }

    private String DW(cj cjVar, int i, String str) {
        int i2;
        switch (cjVar.rN(i)) {
            case 200:
            case 201:
                if (cjVar.gW(cjVar.Hw(i, 1)) == this.VH) {
                    for (i2 = 2; i2 < cjVar.lg(i) - 1; i2++) {
                        int Hw = cjVar.Hw(i, i2);
                        if (cjVar.rN(Hw) == 203) {
                            int U2 = ik.U2(cjVar, Hw);
                            if (U2 == this.tp) {
                                j6(cjVar, cjVar.Hw(Hw, cjVar.lg(Hw) - 1));
                                if (!this.Hw.j6(str)) {
                                    break;
                                }
                            }
                            if (U2 == this.gn) {
                                j6(cjVar, cjVar.Hw(Hw, cjVar.lg(Hw) - 1));
                                return this.Hw.toString();
                            }
                        }
                    }
                    break;
                }
                break;
        }
        for (i2 = 0; i2 < cjVar.lg(i); i2++) {
            String DW = DW(cjVar, cjVar.Hw(i, i2), str);
            if (DW != null) {
                return DW;
            }
        }
        return null;
    }

    private void j6(cj cjVar, int i) {
        this.Hw.j6();
        int Hw = cjVar.Hw(i, 0);
        switch (cjVar.rN(Hw)) {
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                for (Hw = 1; Hw < cjVar.lg(i) - 1; Hw++) {
                    int Hw2 = cjVar.Hw(i, Hw);
                    if (cjVar.rN(Hw2) == 18) {
                        this.Hw.j6(cjVar.j3(Hw2), cjVar.Mr(Hw2), cjVar.U2(Hw2));
                    }
                }
            case 26:
            case 50:
                this.Hw.j6(cjVar.gW(Hw));
            default:
        }
    }

    private void j6() {
        eb Hw = this.j6.cn.Hw();
        while (Hw.j6.DW()) {
            bv FH = Hw.j6.FH();
            if ((FH.BT() instanceof ig) && !(this.FH.j6(FH.vy()) && FH.aM() == this.FH.FH(FH.vy()))) {
                for (bj bjVar : FH.BT().Zo()) {
                    if (bjVar instanceof ih) {
                        cj DW = this.j6.sh.DW(FH, bjVar);
                        if (j6(DW)) {
                            this.DW.j6(FH);
                        } else {
                            this.DW.DW(FH);
                        }
                        this.FH.j6(FH.vy(), FH.aM());
                        this.j6.sh.j6(DW);
                    }
                }
            }
        }
    }

    private boolean j6(cj cjVar) {
        int DW = DW(cjVar, cjVar.Ws());
        if (DW <= 0 || cjVar.rN(cjVar.Hw(DW, 2)) != 215) {
            return false;
        }
        DW = cjVar.Hw(cjVar.Hw(DW, 2), 1);
        this.v5.j6();
        this.v5.j6(cjVar.j3(DW), cjVar.Mr(DW), cjVar.U2(DW));
        return this.v5.j6("\"-//OASIS//DTD Entity Resolution XML Catalog V1.0//EN\"");
    }

    private int DW(cj cjVar, int i) {
        if (cjVar.rN(i) == 213) {
            return i;
        }
        for (int i2 = 0; i2 < cjVar.lg(i); i2++) {
            int DW = DW(cjVar, cjVar.Hw(i, i2));
            if (DW > 0) {
                return DW;
            }
        }
        return -1;
    }
}
