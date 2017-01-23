import com.aide.uidesigner.ProxyTextView;

public class yk {
    protected final acx j6;

    public yk(acx acx) {
        this.j6 = acx;
    }

    public yk(yj yjVar) {
        this(yjVar.j6());
    }

    public final void j6() {
        int DW = adk.DW(this.j6);
        j6(DW);
        for (int i = 0; i < DW; i++) {
            FH();
        }
    }

    public final void DW() {
        int DW = adk.DW(this.j6);
        int DW2 = adk.DW(this.j6);
        j6(DW, DW2);
        for (DW = 0; DW < DW2; DW++) {
            DW(adk.DW(this.j6));
            FH();
        }
    }

    public final void FH() {
        int Zo = this.j6.Zo() & 255;
        int i = Zo & 31;
        int i2 = (Zo & 224) >> 5;
        int i3 = i2 + 1;
        switch (i) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 6:
            case 16:
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                j6(Zo, i, i2, i3);
            case 23:
                DW(i, j6(this.j6, i3));
            case 24:
                FH(i, j6(this.j6, i3));
            case 25:
            case 27:
                Hw(i, j6(this.j6, i3));
            case 26:
                v5(i, j6(this.j6, i3));
            case 28:
                FH(Zo);
                j6();
            case 29:
                Hw(Zo);
                DW();
            case 30:
                Zo(Zo);
            case 31:
                v5(Zo);
            default:
        }
    }

    protected void j6(int i) {
    }

    protected void j6(int i, int i2) {
    }

    protected void DW(int i) {
    }

    protected void j6(int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            this.j6.Zo();
        }
    }

    protected void DW(int i, int i2) {
    }

    protected void FH(int i, int i2) {
    }

    protected void Hw(int i, int i2) {
    }

    protected void v5(int i, int i2) {
    }

    protected void FH(int i) {
    }

    protected void Hw(int i) {
    }

    protected void v5(int i) {
    }

    protected void Zo(int i) {
    }

    private int j6(acx acx, int i) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i) {
            i4 += (acx.Zo() & 255) << i3;
            i3 += 8;
            i2++;
        }
        return i4;
    }
}
