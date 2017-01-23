import com.aide.uidesigner.ProxyTextView;
import java.util.zip.CRC32;

public class ht implements bk {
    private static CRC32 FH;
    private static byte[] Hw;
    private static int v5;
    private final hq DW;
    private final cc j6;

    static {
        FH = new CRC32();
        Hw = new byte[1024];
    }

    public ht(cc ccVar, hq hqVar) {
        this.j6 = ccVar;
        this.DW = hqVar;
    }

    public long j6(cj cjVar) {
        return 10;
    }

    public long Hw(cj cjVar) {
        return 10;
    }

    public long FH(cj cjVar) {
        return DW(cjVar);
    }

    public long DW(cj cjVar) {
        j6();
        j6(cjVar, cjVar.Ws());
        return FH();
    }

    private void j6(cj cjVar, int i) {
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            j6(cjVar, cjVar.Hw(i, i2));
        }
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (((hu) this.DW.Hw()).lg(cjVar, i)) {
                    j6(cjVar.gW(i));
                } else if (((hu) this.DW.Hw()).Mr(cjVar, i)) {
                    DW(cjVar, ((hu) this.DW.Hw()).a8(cjVar, i));
                    j6(cjVar.gW(i));
                }
            case 125:
                j6(cjVar.gW(cjVar.Hw(i, 1)));
                DW(cjVar, cjVar.Hw(i, cjVar.lg(i) - 2));
                j6(cjVar.XL(i));
            case 207:
                j6(cjVar.gW(cjVar.Hw(i, 0)));
                j6(cjVar.XL(i));
            default:
        }
    }

    private void DW(cj cjVar, int i) {
        j6(cjVar.lg(i));
        j6(cjVar.rN(i));
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                j6(cjVar.gW(i));
                break;
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            DW(cjVar, cjVar.Hw(i, i2));
        }
    }

    private static void j6() {
        FH.reset();
    }

    private static void j6(int i) {
        if (v5 + 4 > Hw.length) {
            DW();
        }
        byte[] bArr = Hw;
        int i2 = v5;
        v5 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = Hw;
        i2 = v5;
        v5 = i2 + 1;
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr = Hw;
        i2 = v5;
        v5 = i2 + 1;
        bArr[i2] = (byte) ((i >> 16) & 255);
        bArr = Hw;
        i2 = v5;
        v5 = i2 + 1;
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    private static void DW() {
        FH.update(Hw, 0, v5);
        v5 = 0;
    }

    private long FH() {
        DW();
        return FH.getValue();
    }

    public void v5(cj cjVar) {
        ((he) cjVar.tp().u7()).Hw(cjVar);
    }

    public void j6(bv bvVar) {
        bv bvVar2 = bvVar;
        this.j6.cb.j6(bvVar2, this.DW, ((hw) this.DW.VH()).v5(), bvVar.Zo(), false, 0);
    }

    public void DW(bv bvVar) {
        cj j6 = this.j6.sh.j6(bvVar, this.DW);
        FH(j6, j6.Ws());
        this.j6.sh.j6(j6);
    }

    private void FH(cj cjVar, int i) {
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (!((hu) this.DW.Hw()).Mr(cjVar, i)) {
                    if (((hu) this.DW.Hw()).lg(cjVar, i)) {
                        try {
                            DW(cjVar, i, this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)));
                            break;
                        } catch (ej e) {
                            break;
                        }
                    }
                }
                try {
                    DW(cjVar, i, this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)));
                    break;
                } catch (ej e2) {
                    break;
                }
                break;
            case 125:
                try {
                    Hw(cjVar, i, this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)));
                    break;
                } catch (ej e3) {
                    break;
                }
            case 207:
                try {
                    FH(cjVar, i, this.j6.cb.DW(cjVar.we(), cjVar.tp(), cjVar.XL(i)));
                    break;
                } catch (ej e4) {
                    break;
                }
        }
        int lg = cjVar.lg(i);
        for (int i2 = 0; i2 < lg; i2++) {
            FH(cjVar, cjVar.Hw(i, i2));
        }
    }

    public void Hw(bv bvVar) {
        cj j6 = this.j6.sh.j6(bvVar, this.DW);
        j6(j6, j6.Ws(), null, null);
        this.j6.sh.j6(j6);
    }

    private void j6(cj cjVar, int i, bp bpVar, bp bpVar2) {
        cj cjVar2;
        int i2;
        int a8;
        int i3;
        bz j6;
        switch (cjVar.rN(i)) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                if (!((hu) this.DW.Hw()).Mr(cjVar, i)) {
                    if (((hu) this.DW.Hw()).lg(cjVar, i)) {
                        cjVar2 = cjVar;
                        i2 = i;
                        DW(cjVar2, i2, this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i), bpVar2, 1, cjVar.gW(i), false, false, false, false));
                        break;
                    }
                }
                a8 = ((hu) this.DW.Hw()).a8(cjVar, i);
                if (cjVar.lg(a8) == 2) {
                    i3 = 0;
                } else {
                    i3 = (cjVar.lg(a8) - 1) / 2;
                }
                j6 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i), bpVar2, 1, cjVar.gW(i), 0, i3, false, false, 0);
                j6(cjVar, a8, j6);
                DW(cjVar, i, j6);
                break;
                break;
            case 125:
                int gW;
                if (cjVar.lg(i) == 4) {
                    gW = cjVar.gW(cjVar.Hw(i, 1));
                } else {
                    gW = this.j6.ro.j6("");
                }
                a8 = cjVar.Hw(i, cjVar.lg(i) - 2);
                if (cjVar.lg(a8) == 2) {
                    i3 = 0;
                } else {
                    i3 = (cjVar.lg(a8) - 1) / 2;
                }
                j6 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i), bpVar, 1, gW, 0, i3, false, false, 0);
                j6(cjVar, a8, j6);
                Hw(cjVar, i, j6);
                break;
            case 207:
                cjVar2 = cjVar;
                i2 = i;
                FH(cjVar2, i2, this.j6.cb.j6(cjVar.we(), cjVar.tp(), cjVar.XL(i), bpVar, 1, cjVar.gW(cjVar.Hw(i, 0)), false, false, false, false));
                break;
            case 223:
                ce v5 = ((hw) this.DW.VH()).v5();
                this.j6.cb.j6(v5, cjVar.we(), cjVar.tp());
                bp j62 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), 0, v5, 0, 1, cjVar.we().Zo(), false, false, false);
                bpVar2 = this.j6.cb.j6(cjVar.we(), cjVar.tp(), 1, v5, 0, j62, 1, this.j6.ro.j6("Members"), false);
                bpVar = j62;
                break;
        }
        int lg = cjVar.lg(i);
        for (int i4 = 0; i4 < lg; i4++) {
            j6(cjVar, cjVar.Hw(i, i4), bpVar, bpVar2);
        }
    }

    private void j6(cj cjVar, int i, bz bzVar) {
        int lg = cjVar.lg(i);
        if (lg > 2) {
            int i2 = 0;
            for (int i3 = 1; i3 < lg; i3 += 2) {
                this.j6.cb.j6(bzVar, 0, cjVar.gW(cjVar.Hw(cjVar.Hw(i, i3), 0)), i2);
                i2++;
            }
        }
    }

    private void DW(cj cjVar, int i, bz bzVar) {
        this.j6.cb.j6(bzVar, cjVar.nw(i), cjVar.KD(i), cjVar.ro(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
    }

    private void FH(cj cjVar, int i, bz bzVar) {
        this.j6.cb.j6(bzVar, cjVar.nw(cjVar.Hw(i, 0)), cjVar.KD(cjVar.Hw(i, 0)), cjVar.ro(cjVar.Hw(i, 0)), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
    }

    private void Hw(cj cjVar, int i, bz bzVar) {
        if (cjVar.lg(i) == 4) {
            this.j6.cb.j6(bzVar, cjVar.nw(cjVar.Hw(i, 1)), cjVar.KD(cjVar.Hw(i, 1)), cjVar.ro(cjVar.Hw(i, 1)), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
            return;
        }
        this.j6.cb.j6(bzVar, cjVar.nw(i), cjVar.KD(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.nw(i), cjVar.KD(i), cjVar.SI(i), cjVar.ro(i));
    }

    public void FH(bv bvVar) {
    }

    public void j6(bp bpVar) {
    }

    public void DW(bp bpVar) {
        this.j6.cb.j6(bpVar);
        this.j6.cb.DW(bpVar);
    }

    public void FH(bp bpVar) {
    }

    public void Hw(bp bpVar) {
    }

    public void j6(bz bzVar) {
    }
}
