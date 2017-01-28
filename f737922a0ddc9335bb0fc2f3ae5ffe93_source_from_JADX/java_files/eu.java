import com.aide.uidesigner.ProxyTextView;
import java.io.Reader;

public class eu {
    private final by DW;
    private final bu FH;
    private final et Hw;
    private bv VH;
    private boolean Zo;
    private final bj j6;
    private final ev v5;

    public eu(by byVar, bu buVar, bj bjVar, et etVar) {
        this.DW = byVar;
        this.FH = buVar;
        this.Hw = etVar;
        this.j6 = bjVar;
        this.v5 = new ev();
    }

    public void j6(bv bvVar, Reader reader, boolean z, boolean z2, cm cmVar) {
        j6(bvVar, reader, z, z2, cmVar, false, Integer.MAX_VALUE);
    }

    public void j6(bv bvVar, Reader reader, boolean z, boolean z2, cm cmVar, boolean z3, int i) {
        this.Zo = z;
        this.VH = bvVar;
        this.v5.j6(reader);
        this.Hw.j6(this.v5);
        ev evVar = this.v5;
        if (z3) {
            evVar.j6();
        }
        cmVar.j6();
        bl Hw = this.j6.Hw();
        while (true) {
            int v5 = this.Hw.v5();
            int j6 = this.Hw.j6();
            int j62 = evVar.j6(j6, true);
            int DW = evVar.DW(j6, true);
            switch (v5) {
                case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                    cmVar.j6(0, 0, j62, DW, j62, DW);
                    evVar.j6(null);
                    this.VH = null;
                    return;
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    j6(j62, DW, this.Hw.j6(0));
                    break;
                default:
                    if (v5 < i) {
                        int j63;
                        if (Hw.gn(v5)) {
                            j63 = this.DW.j6(this.Hw.DW(), this.Hw.FH(), this.Hw.Hw());
                        } else if (!Hw.J8(v5)) {
                            j63 = 0;
                        } else if (z2) {
                            j63 = cmVar.j6(this.Hw.DW(), this.Hw.FH(), this.Hw.Hw());
                        } else {
                            j63 = 0;
                        }
                        cmVar.j6(v5, j63, j62, DW, evVar.j6(this.Hw.Hw() + j6, false), evVar.DW(j6 + this.Hw.Hw(), false));
                        break;
                    }
                    break;
            }
        }
    }

    private void j6(int i, int i2, int i3) {
        if (this.Zo && this.VH != null) {
            if (i3 == -1) {
                this.FH.Zo(this.VH, this.j6, i, i2, i, i2 + 1, "Unexpected end of file", 0);
                return;
            }
            this.FH.Zo(this.VH, this.j6, i, i2, i, i2 + 1, "Unexpected " + ((char) i3), 0);
            this.FH.j6(this.VH, this.j6, i, i2, i, i2 + 1, "", "Delete");
        }
    }
}
