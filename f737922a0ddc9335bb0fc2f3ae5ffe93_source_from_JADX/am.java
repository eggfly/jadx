import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class am {
    private final by DW;
    private final bw FH;
    private final cl Hw;
    private dh Zo;
    private final ba j6;
    private dh v5;

    public am(ba baVar) {
        this.j6 = baVar;
        this.DW = baVar.ro;
        this.FH = baVar.cn;
        this.Hw = baVar.sh;
        this.v5 = new dh();
        this.Zo = new dh();
    }

    public void j6() {
        ec ecVar = new ec();
        this.v5.j6.j6();
        while (this.v5.j6.DW()) {
            int FH = this.v5.j6.FH();
            if (!this.j6.cn.gn(FH).j3()) {
                ecVar.j6(FH);
            }
        }
        this.Zo.j6.j6();
        while (this.Zo.j6.DW()) {
            FH = this.Zo.j6.FH();
            if (!this.j6.cn.gn(FH).j3()) {
                ecVar.j6(FH);
            }
        }
        ecVar.j6.j6();
        while (ecVar.j6.DW()) {
            this.v5.j6(ecVar.j6.FH());
            this.Zo.j6(ecVar.j6.FH());
        }
    }

    public void j6(bv bvVar, int i, Reader reader) {
        System.currentTimeMillis();
        this.j6.U2.j6();
        Map hashMap = new HashMap();
        List<bj> Zo = bvVar.BT().Zo();
        for (bj put : Zo) {
            hashMap.put(put, this.j6.ef.DW());
        }
        if (reader == null) {
            try {
                reader = bvVar.rN();
            } catch (IOException e) {
            } catch (Throwable th) {
                reader.close();
            }
        }
        bvVar.BT().j6(bvVar, reader, hashMap);
        reader.close();
        for (bj put2 : Zo) {
            cm cmVar = (cm) hashMap.get(put2);
            this.j6.U2.j6(put2, cmVar);
            this.j6.ef.j6(cmVar);
        }
        this.j6.U2.j6(bvVar, i);
    }

    public void j6(bv bvVar) {
        if (bvVar.BT() != null && this.Zo.FH(bvVar.vy()) != bvVar.aM()) {
            this.Zo.j6(bvVar.vy(), bvVar.aM());
            j6(bvVar, 0, null);
        }
    }

    public void j6(bv bvVar, List<cj> list) {
        if (bvVar.BT() != null && this.v5.FH(bvVar.vy()) != bvVar.aM()) {
            this.v5.j6(bvVar.vy(), bvVar.aM());
            this.j6.U2.DW();
            for (cj cjVar : list) {
                j6(cjVar, cjVar.Ws());
                this.Hw.j6(cjVar);
            }
            this.j6.U2.j6(bvVar);
        }
    }

    public void DW(bv bvVar) {
        if (bvVar.BT() != null && this.v5.FH(bvVar.vy()) != bvVar.aM()) {
            this.v5.j6(bvVar.vy(), bvVar.aM());
            this.j6.U2.DW();
            for (cj cjVar : this.Hw.j6(bvVar)) {
                cjVar.tp().u7().FH(cjVar);
                j6(cjVar, cjVar.Ws());
                this.Hw.j6(cjVar);
            }
            this.j6.U2.j6(bvVar);
        }
    }

    private void j6(cj cjVar, int i) {
        if (cjVar.sy(i)) {
            switch (cjVar.J8(i)) {
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    if (cjVar.J0(i) && cjVar.we(i).I()) {
                        this.j6.U2.j6(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        break;
                    }
                case 6:
                    this.j6.U2.Hw(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case ProxyTextView.INPUTTYPE_textUri /*17*/:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 30:
                    this.j6.U2.v5(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    break;
                case 15:
                    this.j6.U2.FH(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    break;
                case 16:
                    if (!cjVar.J0(i) || !cjVar.we(i).I()) {
                        this.j6.U2.FH(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        break;
                    } else {
                        this.j6.U2.j6(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        break;
                    }
                case ProxyTextView.INPUTTYPE_date /*20*/:
                    if (cjVar.wc(i)) {
                        this.j6.U2.j6(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                        break;
                    }
                    break;
                case 26:
                    this.j6.U2.DW(cjVar.tp(), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
                    break;
            }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
    }
}
