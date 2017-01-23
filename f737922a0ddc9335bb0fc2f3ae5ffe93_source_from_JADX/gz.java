import com.aide.uidesigner.ProxyTextView;
import java.util.Stack;
import java.util.zip.CRC32;

public class gz implements bk {
    private static byte[] EQ;
    private static CRC32 tp;
    private static int we;
    private final gb DW;
    private final bw FH;
    private final by Hw;
    private final bt VH;
    private final hc Zo;
    private final gv gn;
    private final cc j6;
    private Stack<gz$a> u7;
    private final cl v5;

    static {
        tp = new CRC32();
        EQ = new byte[1024];
    }

    public gz(cc ccVar, gv gvVar) {
        this.u7 = new Stack();
        this.j6 = ccVar;
        this.VH = ccVar.cb;
        this.FH = ccVar.cn;
        this.Hw = ccVar.ro;
        this.v5 = ccVar.sh;
        this.Zo = gvVar.we();
        this.DW = gvVar.J0();
        this.gn = gvVar;
    }

    protected void j6() {
        this.u7 = new Stack();
    }

    public long DW(cj cjVar) {
        DW();
        j6(cjVar, cjVar.Ws());
        return Hw();
    }

    public long FH(cj cjVar) {
        DW();
        DW(cjVar, cjVar.Ws());
        return Hw();
    }

    public long j6(cj cjVar) {
        return 0;
    }

    public long Hw(cj cjVar) {
        DW();
        Hw(cjVar, cjVar.Ws());
        return Hw();
    }

    private void j6(cj cjVar, int i) {
        int i2 = 0;
        int lg = cjVar.lg(i);
        for (int i3 = 0; i3 < lg; i3++) {
            j6(cjVar, cjVar.Hw(i, i3));
        }
        switch (cjVar.rN(i)) {
            case 120:
            case 121:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 220:
            case 221:
            case 222:
            case 227:
            case 228:
                v5(cjVar, cjVar.Hw(i, 0));
                v5(cjVar, cjVar.Hw(i, 1));
                v5(cjVar, cjVar.Hw(i, 2));
                v5(cjVar, cjVar.Hw(i, 3));
                v5(cjVar, cjVar.Hw(i, 4));
                v5(cjVar, cjVar.Hw(i, 5));
                j6(cjVar.XL(i));
                return;
            case 123:
                v5(cjVar, cjVar.Hw(i, 0));
                v5(cjVar, cjVar.Hw(i, 1));
                v5(cjVar, cjVar.Hw(i, 2));
                v5(cjVar, cjVar.Hw(i, 3));
                v5(cjVar, cjVar.Hw(i, 4));
                j6(cjVar.XL(i));
                return;
            case 124:
                v5(cjVar, cjVar.Hw(i, 0));
                v5(cjVar, cjVar.Hw(i, 1));
                v5(cjVar, cjVar.Hw(i, 2));
                v5(cjVar, cjVar.Hw(i, 3));
                v5(cjVar, cjVar.Hw(i, 4));
                v5(cjVar, cjVar.Hw(i, 5));
                v5(cjVar, cjVar.Hw(i, 6));
                v5(cjVar, cjVar.Hw(i, 7));
                j6(cjVar.XL(i));
                return;
            case 126:
                v5(cjVar, i);
                return;
            case 127:
                j6(1);
                return;
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                break;
            case 194:
                j6(cjVar.XL(i));
                return;
            case 208:
                v5(cjVar, i);
                j6(cjVar.XL(i));
                return;
            case 213:
            case 214:
            case 224:
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
            case 226:
                v5(cjVar, i);
                return;
            case 245:
            case 246:
                v5(cjVar, i);
                return;
            default:
                return;
        }
        while (i2 < cjVar.lg(i) - 2) {
            v5(cjVar, cjVar.Hw(i, i2));
            i2++;
        }
    }

    private void DW(cj cjVar, int i) {
        int i2 = 0;
        switch (cjVar.rN(i)) {
            case 120:
            case 121:
            case 220:
                v5(cjVar, cjVar.Hw(i, 0));
                v5(cjVar, cjVar.Hw(i, 1));
                v5(cjVar, cjVar.Hw(i, 2));
                v5(cjVar, cjVar.Hw(i, 3));
                v5(cjVar, cjVar.Hw(i, 4));
                v5(cjVar, cjVar.Hw(i, 5));
                j6(cjVar.XL(i));
                break;
            case 123:
                if (!FH(cjVar, cjVar.Hw(i, 0))) {
                    v5(cjVar, cjVar.Hw(i, 0));
                    v5(cjVar, cjVar.Hw(i, 2));
                    v5(cjVar, cjVar.Hw(i, 3));
                    v5(cjVar, cjVar.Hw(i, 4));
                    j6(cjVar.XL(i));
                    break;
                }
                break;
            case 124:
                if (!FH(cjVar, cjVar.Hw(i, 0))) {
                    v5(cjVar, cjVar.Hw(i, 0));
                    v5(cjVar, cjVar.Hw(i, 1));
                    v5(cjVar, cjVar.Hw(i, 2));
                    v5(cjVar, cjVar.Hw(i, 3));
                    v5(cjVar, cjVar.Hw(i, 4));
                    v5(cjVar, cjVar.Hw(i, 5));
                    v5(cjVar, cjVar.Hw(i, 6));
                    v5(cjVar, cjVar.Hw(i, 7));
                    j6(cjVar.XL(i));
                    break;
                }
                break;
            case 126:
                if (!FH(cjVar, cjVar.Hw(i, 0))) {
                    v5(cjVar, i);
                    j6(cjVar.XL(i));
                    break;
                }
                break;
            case 133:
                return;
            case 213:
            case 214:
            case 224:
            case ProxyTextView.INPUTTYPE_textWebPassword /*225*/:
            case 226:
                v5(cjVar, i);
                break;
            case 221:
            case 227:
            case 228:
                if (!FH(cjVar, cjVar.Hw(i, 0))) {
                    v5(cjVar, cjVar.Hw(i, 0));
                    v5(cjVar, cjVar.Hw(i, 1));
                    v5(cjVar, cjVar.Hw(i, 2));
                    v5(cjVar, cjVar.Hw(i, 3));
                    v5(cjVar, cjVar.Hw(i, 4));
                    v5(cjVar, cjVar.Hw(i, 5));
                    j6(cjVar.XL(i));
                    break;
                }
                return;
            case 245:
            case 246:
                v5(cjVar, i);
                break;
        }
        int lg = cjVar.lg(i);
        while (i2 < lg) {
            DW(cjVar, cjVar.Hw(i, i2));
            i2++;
        }
    }

    private boolean FH(cj cjVar, int i) {
        switch (cjVar.rN(cjVar.aM(cjVar.aM(cjVar.aM(i))))) {
            case 121:
            case 228:
                return false;
            default:
                int lg = cjVar.lg(i);
                for (int i2 = 0; i2 < lg; i2++) {
                    if (cjVar.rN(cjVar.Hw(i, i2)) == 94) {
                        return true;
                    }
                }
                return false;
        }
    }

    private void Hw(cj cjVar, int i) {
        int i2 = 0;
        switch (cjVar.rN(i)) {
            case 120:
            case 121:
            case 220:
            case 221:
            case 227:
            case 228:
                v5(cjVar, cjVar.Hw(i, 0));
                v5(cjVar, cjVar.Hw(i, 1));
                v5(cjVar, cjVar.Hw(i, 2));
                v5(cjVar, cjVar.Hw(i, 3));
                v5(cjVar, cjVar.Hw(i, 4));
                v5(cjVar, cjVar.Hw(i, 5));
                j6(cjVar.XL(i));
                break;
            case 133:
                return;
            case 224:
                v5(cjVar, i);
                break;
            case 245:
            case 246:
                v5(cjVar, i);
                break;
        }
        int lg = cjVar.lg(i);
        while (i2 < lg) {
            Hw(cjVar, cjVar.Hw(i, i2));
            i2++;
        }
    }

    private void v5(cj cjVar, int i) {
        int Mr;
        int i2 = 0;
        j6(cjVar.lg(i));
        j6(cjVar.rN(i));
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6(cjVar.gW(i));
                break;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 5:
            case 6:
            case 7:
                Mr = cjVar.Mr(i);
                int U2 = cjVar.U2(i);
                char[] j3 = cjVar.j3(i);
                int i3 = 0;
                int i4 = Mr;
                Mr = 0;
                while (Mr < U2) {
                    i3 = (i3 * 31) + j3[i4];
                    Mr++;
                    i4++;
                }
                j6(i3);
                break;
        }
        Mr = cjVar.lg(i);
        while (i2 < Mr) {
            v5(cjVar, cjVar.Hw(i, i2));
            i2++;
        }
    }

    private static void DW() {
        tp.reset();
    }

    private static void j6(int i) {
        if (we + 4 > EQ.length) {
            FH();
        }
        byte[] bArr = EQ;
        int i2 = we;
        we = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = EQ;
        i2 = we;
        we = i2 + 1;
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr = EQ;
        i2 = we;
        we = i2 + 1;
        bArr[i2] = (byte) ((i >> 16) & 255);
        bArr = EQ;
        i2 = we;
        we = i2 + 1;
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    private static void FH() {
        tp.update(EQ, 0, we);
        we = 0;
    }

    private long Hw() {
        FH();
        return tp.getValue();
    }

    public void v5(cj cjVar) {
    }

    public void j6(bz bzVar) {
        this.DW.j6(bzVar);
    }

    public void DW(bp bpVar) {
        this.VH.j6(bpVar);
        try {
            if (bpVar != this.Zo.Zo(bpVar.tp())) {
                this.VH.j6(bpVar, this.Zo.Zo(bpVar.tp()));
            }
        } catch (ej e) {
        }
        this.VH.DW(bpVar);
    }

    public void j6(bp bpVar) {
        cj DW = this.v5.DW(bpVar.tp(), this.gn);
        gz$a v5 = v5();
        v5.FH(this.VH, this.Zo, bpVar, DW);
        j6(v5);
        this.v5.j6(DW);
    }

    public void FH(bp bpVar) {
        cj DW = this.v5.DW(bpVar.tp(), this.gn);
        gz$a v5 = v5();
        v5.DW(this.VH, this.Zo, bpVar, DW);
        j6(v5);
        this.v5.j6(DW);
    }

    public void Hw(bp bpVar) {
        cj DW = this.v5.DW(bpVar.tp(), this.gn);
        gz$a v5 = v5();
        v5.j6(this.VH, this.Zo, bpVar, DW);
        j6(v5);
        this.v5.j6(DW);
    }

    public void DW(bv bvVar) {
        cj DW = this.v5.DW(bvVar, this.gn);
        gz$a v5 = v5();
        v5.j6(this.VH, DW);
        j6(v5);
        this.v5.j6(DW);
    }

    public void FH(bv bvVar) {
        cj DW = this.v5.DW(bvVar, this.gn);
        gz$a v5 = v5();
        v5.j6(this.VH, this.Zo, DW);
        j6(v5);
        this.v5.j6(DW);
    }

    public void Hw(bv bvVar) {
        cj j6 = this.v5.j6(bvVar, this.gn);
        gz$a v5 = v5();
        v5.DW(this.VH, this.Zo, j6);
        j6(v5);
        this.v5.j6(j6);
    }

    public void j6(bv bvVar) {
        if (this.VH.DW(bvVar, this.gn)) {
            Hw(bvVar);
        }
    }

    private gz$a v5() {
        if (this.u7.empty()) {
            return new gz$a(this, this.VH);
        }
        return (gz$a) this.u7.pop();
    }

    private void j6(gz$a gz_a) {
        this.u7.push(gz_a);
    }
}
