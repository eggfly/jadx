import com.aide.uidesigner.ProxyTextView;
import java.util.Collection;

public final class xz {
    private final acr DW;
    private final wq j6;

    public xz(wq wqVar, acr acr) {
        if (wqVar == null) {
            throw new NullPointerException("file == null");
        } else if (acr == null) {
            throw new NullPointerException("out == null");
        } else {
            this.j6 = wqVar;
            this.DW = acr;
        }
    }

    public void j6(aah aah) {
        int FH = FH(aah);
        switch (FH) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
            case 6:
                j6(FH, ((aay) aah).EQ());
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                DW(FH, ((aay) aah).EQ());
            case 16:
                FH(FH, ((aas) aah).EQ() << 32);
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                FH(FH, ((aap) aah).EQ());
            case 23:
                DW(FH, (long) this.j6.VH().DW((abe) aah));
            case 24:
                DW(FH, (long) this.j6.tp().DW((abf) aah));
            case 25:
                DW(FH, (long) this.j6.we().DW((aar) aah));
            case 26:
                DW(FH, (long) this.j6.J0().DW((abb) aah));
            case 27:
                DW(FH, (long) this.j6.we().DW(((aaq) aah).u7()));
            case 28:
                this.DW.FH(FH);
                j6((aak) aah, false);
            case 29:
                this.DW.FH(FH);
                j6(((aaj) aah).j6(), false);
            case 30:
                this.DW.FH(FH);
            case 31:
                this.DW.FH(FH | (((aam) aah).tp() << 5));
            default:
                throw new RuntimeException("Shouldn't happen");
        }
    }

    private static int FH(aah aah) {
        if (aah instanceof aan) {
            return 0;
        }
        if (aah instanceof abd) {
            return 2;
        }
        if (aah instanceof aao) {
            return 3;
        }
        if (aah instanceof aat) {
            return 4;
        }
        if (aah instanceof aaz) {
            return 6;
        }
        if (aah instanceof aas) {
            return 16;
        }
        if (aah instanceof aap) {
            return 17;
        }
        if (aah instanceof abe) {
            return 23;
        }
        if (aah instanceof abf) {
            return 24;
        }
        if (aah instanceof aar) {
            return 25;
        }
        if (aah instanceof abb) {
            return 26;
        }
        if (aah instanceof aaq) {
            return 27;
        }
        if (aah instanceof aak) {
            return 28;
        }
        if (aah instanceof aaj) {
            return 29;
        }
        if (aah instanceof aav) {
            return 30;
        }
        if (aah instanceof aam) {
            return 31;
        }
        throw new RuntimeException("Shouldn't happen");
    }

    public void j6(aak aak, boolean z) {
        int i = 0;
        int i2 = (z && this.DW.j6()) ? 1 : 0;
        aak$a j6 = aak.j6();
        int m_ = j6.m_();
        if (i2 != 0) {
            this.DW.j6("  size: " + add.j6(m_));
        }
        this.DW.v5(m_);
        while (i < m_) {
            aah j62 = j6.j6(i);
            if (i2 != 0) {
                this.DW.j6("  [" + Integer.toHexString(i) + "] " + DW(j62));
            }
            j6(j62);
            i++;
        }
        if (i2 != 0) {
            this.DW.FH();
        }
    }

    public void j6(zc zcVar, boolean z) {
        int i = (z && this.DW.j6()) ? 1 : 0;
        xt VH = this.j6.VH();
        xv tp = this.j6.tp();
        abf DW = zcVar.DW();
        int DW2 = tp.DW(DW);
        if (i != 0) {
            this.DW.j6("  type_idx: " + add.j6(DW2) + " // " + DW.Hw());
        }
        this.DW.v5(tp.DW(zcVar.DW()));
        Collection<zg> Zo = zcVar.Zo();
        int size = Zo.size();
        if (i != 0) {
            this.DW.j6("  size: " + add.j6(size));
        }
        this.DW.v5(size);
        size = 0;
        for (zg zgVar : Zo) {
            int i2;
            abe j6 = zgVar.j6();
            int DW3 = VH.DW(j6);
            aah DW4 = zgVar.DW();
            if (i != 0) {
                this.DW.j6(0, "  elements[" + size + "]:");
                i2 = size + 1;
                this.DW.j6("    name_idx: " + add.j6(DW3) + " // " + j6.Hw());
            } else {
                i2 = size;
            }
            this.DW.v5(DW3);
            if (i != 0) {
                this.DW.j6("    value: " + DW(DW4));
            }
            j6(DW4);
            size = i2;
        }
        if (i != 0) {
            this.DW.FH();
        }
    }

    public static String DW(aah aah) {
        if (FH(aah) == 30) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aah.gn());
        stringBuilder.append(' ');
        stringBuilder.append(aah.Hw());
        return stringBuilder.toString();
    }

    private void j6(int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros((j >> 63) ^ j)) + 7) >> 3;
        this.DW.FH(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            this.DW.FH((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    private void DW(int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        numberOfLeadingZeros = (numberOfLeadingZeros + 7) >> 3;
        this.DW.FH(((numberOfLeadingZeros - 1) << 5) | i);
        while (numberOfLeadingZeros > 0) {
            this.DW.FH((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    private void FH(int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        numberOfTrailingZeros = (numberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (numberOfTrailingZeros * 8));
        this.DW.FH(((numberOfTrailingZeros - 1) << 5) | i);
        while (numberOfTrailingZeros > 0) {
            this.DW.FH((byte) ((int) j2));
            j2 >>= 8;
            numberOfTrailingZeros--;
        }
    }

    public static void j6(wq wqVar, zc zcVar) {
        xv tp = wqVar.tp();
        xt VH = wqVar.VH();
        tp.j6(zcVar.DW());
        for (zg zgVar : zcVar.Zo()) {
            VH.j6(zgVar.j6());
            j6(wqVar, zgVar.DW());
        }
    }

    public static void j6(wq wqVar, aah aah) {
        if (aah instanceof aaj) {
            j6(wqVar, ((aaj) aah).j6());
        } else if (aah instanceof aak) {
            aak$a j6 = ((aak) aah).j6();
            int m_ = j6.m_();
            for (int i = 0; i < m_; i++) {
                j6(wqVar, j6.j6(i));
            }
        } else {
            wqVar.j6(aah);
        }
    }
}
