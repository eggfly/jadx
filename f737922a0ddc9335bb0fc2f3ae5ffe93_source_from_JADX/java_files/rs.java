import com.aide.uidesigner.ProxyTextView;
import java.util.ArrayList;

public final class rs implements rx$c {
    private final int[] DW;
    private final int[] FH;
    private final int[] Hw;
    private int VH;
    private final rv[] Zo;
    private final ry j6;
    private final adg[] v5;

    public static ru j6(ry ryVar) {
        rs rsVar = new rs(ryVar);
        rsVar.FH();
        return rsVar.DW();
    }

    private rs(ry ryVar) {
        if (ryVar == null) {
            throw new NullPointerException("method == null");
        }
        this.j6 = ryVar;
        int DW = ryVar.EQ().DW() + 1;
        this.DW = act.j6(DW);
        this.FH = act.j6(DW);
        this.Hw = act.j6(DW);
        this.v5 = new adg[DW];
        this.Zo = new rv[DW];
        this.VH = -1;
    }

    public void j6(int i, int i2, int i3) {
        j6(i2, i3, true);
    }

    public void j6(int i, int i2, int i3, abl abl) {
        switch (i) {
            case 46:
            case 47:
            case 48:
            case ProxyTextView.INPUTTYPE_textEmailSubject /*49*/:
            case 50:
            case 51:
            case 52:
            case 53:
            case 79:
            case 80:
            case ProxyTextView.INPUTTYPE_textLongMessage /*81*/:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 190:
            case 194:
            case 195:
                j6(i2, i3, true);
                DW(i2, i3, true);
            case 108:
            case 112:
                j6(i2, i3, true);
                if (abl == abl.Zo || abl == abl.VH) {
                    DW(i2, i3, true);
                }
            case 172:
            case ProxyTextView.INPUTTYPE_textFilter /*177*/:
                j6(i2, i3, false);
                this.v5[i2] = adg.j6;
            case 191:
                j6(i2, i3, false);
                DW(i2, i3, false);
            default:
                j6(i2, i3, true);
        }
    }

    public void j6(int i, int i2, int i3, int i4, abl abl, int i5) {
        if (i == 169) {
            j6(i2, i3, false);
            this.v5[i2] = adg.j6;
            return;
        }
        j6(i2, i3, true);
    }

    public void j6(int i, int i2, int i3, aah aah, int i4) {
        j6(i2, i3, true);
        if ((aah instanceof aba) || (aah instanceof abf) || (aah instanceof abe)) {
            DW(i2, i3, true);
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        switch (i) {
            case 167:
                j6(i2, i3, false);
                this.v5[i2] = adg.j6(i4);
                break;
            case 168:
                j6(i2, true);
                break;
        }
        int i5 = i2 + i3;
        j6(i2, i3, true);
        j6(i5, true);
        this.v5[i2] = adg.j6(i5, i4);
        j6(i4, true);
    }

    public void j6(int i, int i2, int i3, sn snVar, int i4) {
        int i5 = 0;
        j6(i2, i3, false);
        j6(snVar.DW(), true);
        int j6 = snVar.j6();
        while (i5 < j6) {
            j6(snVar.DW(i5), true);
            i5++;
        }
        this.v5[i2] = snVar.Hw();
    }

    public void j6(int i, int i2, abf abf, ArrayList<aah> arrayList) {
        j6(i, i2, true);
        DW(i, i2, true);
    }

    private ru DW() {
        int i = 0;
        rt[] rtVarArr = new rt[this.j6.EQ().DW()];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int Hw = act.Hw(this.Hw, i2 + 1);
            if (Hw < 0) {
                break;
            }
            int i4;
            if (act.j6(this.FH, i2)) {
                rv rvVar;
                adg adg = null;
                i4 = Hw - 1;
                while (i4 >= i2) {
                    adg = this.v5[i4];
                    if (adg != null) {
                        break;
                    }
                    i4--;
                }
                i4 = -1;
                if (adg == null) {
                    adg = adg.j6(Hw);
                    rvVar = rv.j6;
                } else {
                    rvVar = this.Zo[i4];
                    if (rvVar == null) {
                        rvVar = rv.j6;
                    }
                }
                rtVarArr[i3] = new rt(i2, i2, Hw, adg, rvVar);
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2 = Hw;
            i3 = i4;
        }
        ru ruVar = new ru(i3);
        while (i < i3) {
            ruVar.j6(i, rtVarArr[i]);
            i++;
        }
        return ruVar;
    }

    private void FH() {
        rx EQ = this.j6.EQ();
        rv we = this.j6.we();
        int m_ = we.m_();
        act.DW(this.DW, 0);
        act.DW(this.Hw, 0);
        while (!act.DW(this.DW)) {
            try {
                EQ.j6(this.DW, (rx$c) this);
                for (int i = 0; i < m_; i++) {
                    rv$a j6 = we.j6(i);
                    int j62 = j6.j6();
                    int DW = j6.DW();
                    if (act.j6(this.FH, j62, DW)) {
                        act.DW(this.Hw, j62);
                        act.DW(this.Hw, DW);
                        j6(j6.FH(), true);
                    }
                }
            } catch (Throwable e) {
                throw new sl("flow of control falls off end of method", e);
            }
        }
    }

    private void j6(int i, boolean z) {
        if (!act.j6(this.FH, i)) {
            act.DW(this.DW, i);
        }
        if (z) {
            act.DW(this.Hw, i);
        }
    }

    private void j6(int i, int i2, boolean z) {
        act.DW(this.FH, i);
        if (z) {
            j6(i + i2, false);
        } else {
            act.DW(this.Hw, i + i2);
        }
    }

    private void DW(int i, int i2, boolean z) {
        int i3 = i + i2;
        if (z) {
            j6(i3, true);
        }
        rv DW = this.j6.we().DW(i);
        this.Zo[i] = DW;
        adg[] adgArr = this.v5;
        if (!z) {
            i3 = -1;
        }
        adgArr[i] = DW.FH(i3);
    }

    public void j6(int i) {
        this.VH = i;
    }

    public int j6() {
        return this.VH;
    }
}
