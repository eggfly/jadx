import com.aide.uidesigner.ProxyTextView;
import java.util.Stack;

public class gb implements bc {
    private final boolean DW;
    private final cc EQ;
    private final boolean FH;
    private ec Hw;
    private final hd J0;
    private final bu VH;
    private final bw Zo;
    private final bt gn;
    private Stack<gb$a> j6;
    private final cl tp;
    private final hc u7;
    private final by v5;
    private final gt we;

    public gb(cc ccVar, gv gvVar) {
        this.DW = true;
        this.FH = true;
        this.EQ = ccVar;
        this.Zo = ccVar.cn;
        this.v5 = ccVar.ro;
        this.VH = ccVar.sG;
        this.gn = ccVar.cb;
        this.u7 = gvVar.we();
        this.tp = ccVar.sh;
        this.j6 = new Stack();
        this.Hw = new ec();
        this.we = new gt(ccVar, this.u7, true);
        this.J0 = new hd(ccVar);
    }

    protected void j6() {
        this.j6 = new Stack();
    }

    public void FH(cj cjVar) {
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, null, true, true, true);
        j6(DW);
        this.we.FH(cjVar);
        this.we.DW(cjVar);
        this.we.j6(cjVar);
        this.J0.j6(cjVar);
    }

    public void j6(cj cjVar, ec ecVar) {
        ec ecVar2 = new ec();
        j6(cjVar, cjVar.Ws(), ecVar, ecVar2);
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar2, false, false, false);
        j6(DW);
    }

    public void j6(cj cjVar, int i) {
        ec ecVar = new ec();
        j6(cjVar, cjVar.Ws(), i, ecVar);
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar, false, false, false);
        j6(DW);
    }

    public void DW(cj cjVar, int i) {
        ec ecVar = new ec();
        DW(cjVar, i, ecVar);
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar, false, false, false);
        j6(DW);
    }

    public void FH(cj cjVar, int i) {
        ec ecVar = new ec();
        DW(cjVar, i, ecVar);
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar, false, false, true);
        j6(DW);
    }

    public void DW(cj cjVar) {
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, null, false, false, false);
        j6(DW);
    }

    public void Hw(cj cjVar, int i) {
        ec ecVar = new ec();
        j6(cjVar, i, ecVar);
        DW(cjVar, i, ecVar);
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar, false, false, false);
        j6(DW);
    }

    public void j6(cj cjVar) {
        ec ecVar = new ec();
        gb$a DW = DW();
        DW.j6(this, this.VH, this.gn, this.u7, cjVar, ecVar, false, false, false);
        j6(DW);
    }

    public co j6(cj cjVar, int i, int i2, String str) {
        if (str.equals("boolean")) {
            return this.u7.XL();
        }
        if (str.equals("byte")) {
            return this.u7.EQ();
        }
        if (str.equals("short")) {
            return this.u7.Ws();
        }
        if (str.equals("int")) {
            return this.u7.J0();
        }
        if (str.equals("char")) {
            return this.u7.QX();
        }
        if (str.equals("long")) {
            return this.u7.aM();
        }
        if (str.equals("float")) {
            return this.u7.J8();
        }
        if (str.equals("double")) {
            return this.u7.j3();
        }
        dq DW = this.gn.DW(this.v5.j6(str), 0, cjVar.we(), cjVar.tp());
        if (DW.FH() == 1) {
            return (co) DW.DW();
        }
        throw new ej();
    }

    private gb$a DW() {
        if (this.j6.size() > 0) {
            return (gb$a) this.j6.pop();
        }
        return new gb$a(this.gn);
    }

    private void j6(gb$a gb_a) {
        if (this.j6.size() < 10) {
            this.j6.push(gb_a);
        }
    }

    private void j6(cj cjVar, int i, ec ecVar) {
        ecVar.j6(i);
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), ecVar);
        }
    }

    private void j6(cj cjVar, int i, int i2, ec ecVar) {
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3), i2, ecVar);
        }
        if (cjVar.rN(i) == 1 && cjVar.gW(i) == i2) {
            DW(cjVar, i, ecVar);
        }
    }

    private void j6(cj cjVar, int i, ec ecVar, ec ecVar2) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2), ecVar, ecVar2);
        }
        if (cjVar.rN(i) == 1 && ecVar.FH(cjVar.gW(i))) {
            DW(cjVar, i, ecVar2);
        }
    }

    private void DW(cj cjVar, int i, ec ecVar) {
        while (i != cjVar.Ws()) {
            switch (cjVar.rN(i)) {
                case 120:
                case 121:
                case 123:
                case 124:
                case 126:
                case 127:
                case 128:
                case ProxyTextView.INPUTTYPE_textPassword /*129*/:
                case 133:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case ProxyTextView.INPUTTYPE_textVisiblePassword /*145*/:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 194:
                case ProxyTextView.INPUTTYPE_textWebEmailAddress /*209*/:
                case 211:
                case 212:
                case 220:
                case 221:
                case 222:
                case 227:
                case 228:
                case 245:
                case 246:
                    ecVar.j6(i);
                    break;
                default:
                    break;
            }
            i = cjVar.aM(i);
        }
    }

    public void j6(bz bzVar) {
        bzVar.tp();
        cj DW = this.tp.DW(bzVar.tp(), bzVar.Hw());
        int sG = DW.sG(bzVar.EQ());
        this.Hw.j6();
        DW(DW, sG, this.Hw);
        gb$a DW2 = DW();
        DW2.j6(this, this.VH, this.gn, this.u7, DW, this.Hw, false, false, true);
        j6(DW2);
        this.tp.j6(DW);
    }
}
