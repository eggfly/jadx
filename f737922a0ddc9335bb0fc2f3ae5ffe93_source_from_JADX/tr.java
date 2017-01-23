import com.aide.uidesigner.ProxyTextView;
import java.util.Arrays;

public final class tr {
    public final tr$a DW;
    public final tr$a EQ;
    public final tr$a FH;
    public final tr$a Hw;
    public final tr$a J0;
    public final tr$a J8;
    public int Mr;
    public final tr$a QX;
    public byte[] U2;
    public final tr$a VH;
    public final tr$a Ws;
    public final tr$a XL;
    public final tr$a Zo;
    public int a8;
    public final tr$a aM;
    public int er;
    public final tr$a gn;
    public final tr$a[] j3;
    public final tr$a j6;
    public int lg;
    public int rN;
    public final tr$a tp;
    public final tr$a u7;
    public final tr$a v5;
    public final tr$a we;
    public int yS;

    public tr() {
        this.j6 = new tr$a(0);
        this.DW = new tr$a(1);
        this.FH = new tr$a(2);
        this.Hw = new tr$a(3);
        this.v5 = new tr$a(4);
        this.Zo = new tr$a(5);
        this.VH = new tr$a(6);
        this.gn = new tr$a(4096);
        this.u7 = new tr$a(ProxyTextView.INPUTTYPE_textCapCharacters);
        this.tp = new tr$a(ProxyTextView.INPUTTYPE_numberSigned);
        this.EQ = new tr$a(4099);
        this.we = new tr$a(8192);
        this.J0 = new tr$a(ProxyTextView.INPUTTYPE_textCapWords);
        this.J8 = new tr$a(ProxyTextView.INPUTTYPE_numberDecimal);
        this.Ws = new tr$a(8195);
        this.QX = new tr$a(8196);
        this.XL = new tr$a(8197);
        this.aM = new tr$a(8198);
        this.j3 = new tr$a[]{this.j6, this.DW, this.FH, this.Hw, this.v5, this.Zo, this.VH, this.gn, this.u7, this.tp, this.EQ, this.we, this.J0, this.J8, this.Ws, this.QX, this.XL, this.aM};
        this.U2 = new byte[20];
    }

    public void j6(yi yiVar) {
        j6(yiVar.j6(0));
        DW(yiVar.j6(this.gn.FH));
        j6();
    }

    private void j6(yi$a yi_a) {
        byte[] j6 = yi_a.j6(8);
        if (tp.j6(j6) < 0) {
            throw new acz("Unexpected magic: " + Arrays.toString(j6));
        }
        this.Mr = yi_a.FH();
        this.U2 = yi_a.j6(20);
        this.a8 = yi_a.FH();
        int FH = yi_a.FH();
        if (FH != 112) {
            throw new acz("Unexpected header: 0x" + Integer.toHexString(FH));
        }
        FH = yi_a.FH();
        if (FH != 305419896) {
            throw new acz("Unexpected endian tag: 0x" + Integer.toHexString(FH));
        }
        this.lg = yi_a.FH();
        this.rN = yi_a.FH();
        this.gn.FH = yi_a.FH();
        if (this.gn.FH == 0) {
            throw new acz("Cannot merge dex files that do not contain a map");
        }
        this.DW.DW = yi_a.FH();
        this.DW.FH = yi_a.FH();
        this.FH.DW = yi_a.FH();
        this.FH.FH = yi_a.FH();
        this.Hw.DW = yi_a.FH();
        this.Hw.FH = yi_a.FH();
        this.v5.DW = yi_a.FH();
        this.v5.FH = yi_a.FH();
        this.Zo.DW = yi_a.FH();
        this.Zo.FH = yi_a.FH();
        this.VH.DW = yi_a.FH();
        this.VH.FH = yi_a.FH();
        this.er = yi_a.FH();
        this.yS = yi_a.FH();
    }

    private void DW(yi$a yi_a) {
        int FH = yi_a.FH();
        tr$a tr_a = null;
        int i = 0;
        while (i < FH) {
            short Hw = yi_a.Hw();
            yi_a.Hw();
            tr$a j6 = j6(Hw);
            int FH2 = yi_a.FH();
            int FH3 = yi_a.FH();
            if ((j6.DW == 0 || j6.DW == FH2) && (j6.FH == -1 || j6.FH == FH3)) {
                j6.DW = FH2;
                j6.FH = FH3;
                if (tr_a == null || tr_a.FH <= j6.FH) {
                    i++;
                    tr_a = j6;
                } else {
                    throw new acz("Map is unsorted at " + tr_a + ", " + j6);
                }
            }
            throw new acz("Unexpected map value for 0x" + Integer.toHexString(Hw));
        }
        Arrays.sort(this.j3);
    }

    public void j6() {
        int i = this.er + this.yS;
        for (int length = this.j3.length - 1; length >= 0; length--) {
            tr$a tr_a = this.j3[length];
            if (tr_a.FH != -1) {
                if (tr_a.FH > i) {
                    throw new acz("Map is unsorted at " + tr_a);
                }
                tr_a.Hw = i - tr_a.FH;
                i = tr_a.FH;
            }
        }
    }

    private tr$a j6(short s) {
        for (tr$a tr_a : this.j3) {
            if (tr_a.j6 == s) {
                return tr_a;
            }
        }
        throw new IllegalArgumentException("No such map item: " + s);
    }
}
