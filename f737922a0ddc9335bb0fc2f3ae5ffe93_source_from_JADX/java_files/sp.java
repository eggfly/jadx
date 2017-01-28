import com.aide.uidesigner.ProxyTextView;
import java.util.BitSet;

public final class sp {
    private final abg DW;
    private final int[] FH;
    private int Hw;
    private final acu j6;
    private ti v5;

    public sp(acu acu) {
        int Zo = acu.Zo(8);
        this.j6 = acu;
        this.DW = new abg(Zo);
        this.FH = new int[Zo];
        this.Hw = -1;
    }

    public void j6(ti tiVar) {
        this.v5 = tiVar;
    }

    public int j6() {
        FH();
        return this.Hw;
    }

    public abg DW() {
        FH();
        return this.DW;
    }

    private void FH() {
        if (this.Hw < 0) {
            Hw();
        }
    }

    private void Hw() {
        int i = 1;
        v5();
        if (this.v5 != null) {
            this.v5.j6(this.j6, 8, 2, "constant_pool_count: " + add.FH(this.FH.length));
            this.v5.j6(this.j6, 10, 0, "\nconstant_pool:");
            this.v5.j6(1);
        }
        BitSet bitSet = new BitSet(this.FH.length);
        int i2 = 1;
        while (i2 < this.FH.length) {
            if (this.FH[i2] != 0 && this.DW.FH(i2) == null) {
                j6(i2, bitSet);
            }
            i2++;
        }
        if (this.v5 != null) {
            while (i < this.FH.length) {
                aah FH = this.DW.FH(i);
                if (FH != null) {
                    int i3 = this.FH[i];
                    int i4 = this.Hw;
                    for (i2 = i + 1; i2 < this.FH.length; i2++) {
                        int i5 = this.FH[i2];
                        if (i5 != 0) {
                            i2 = i5;
                            break;
                        }
                    }
                    i2 = i4;
                    this.v5.j6(this.j6, i3, i2 - i3, bitSet.get(i) ? add.FH(i) + ": utf8{\"" + FH.Hw() + "\"}" : add.FH(i) + ": " + FH.toString());
                }
                i++;
            }
            this.v5.j6(-1);
            this.v5.j6(this.j6, this.Hw, 0, "end constant_pool");
        }
    }

    private void v5() {
        int i = 10;
        int i2 = 1;
        while (i2 < this.FH.length) {
            this.FH[i2] = i;
            int v5 = this.j6.v5(i);
            switch (v5) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    i += this.j6.Zo(i + 1) + 3;
                    v5 = 1;
                    break;
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                case 9:
                case 10:
                case 11:
                case 12:
                    i += 5;
                    v5 = 1;
                    break;
                case 5:
                case 6:
                    v5 = 2;
                    i += 9;
                    break;
                case 7:
                case 8:
                    i += 3;
                    v5 = 1;
                    break;
                default:
                    th thVar = new th("unknown tag byte: " + add.v5(v5));
                    thVar.j6("...while preparsing cst " + add.FH(i2) + " at offset " + add.j6(i));
                    throw thVar;
            }
            i2 += v5;
        }
        this.Hw = i;
    }

    private aah j6(int i, BitSet bitSet) {
        aah FH = this.DW.FH(i);
        if (FH == null) {
            int i2 = this.FH[i];
            try {
                switch (this.j6.v5(i2)) {
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        FH = j6(i2);
                        bitSet.set(i);
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        FH = aat.j6(this.j6.FH(i2 + 1));
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        FH = aas.j6(this.j6.FH(i2 + 1));
                        break;
                    case 5:
                        FH = aaz.j6(this.j6.Hw(i2 + 1));
                        break;
                    case 6:
                        FH = aap.j6(this.j6.Hw(i2 + 1));
                        break;
                    case 7:
                        FH = new abf(abl.FH(((abe) j6(this.j6.Zo(i2 + 1), bitSet)).tp()));
                        break;
                    case 8:
                        FH = j6(this.j6.Zo(i2 + 1), bitSet);
                        break;
                    case 9:
                        FH = new aar((abf) j6(this.j6.Zo(i2 + 1), bitSet), (abc) j6(this.j6.Zo(i2 + 3), bitSet));
                        break;
                    case 10:
                        FH = new abb((abf) j6(this.j6.Zo(i2 + 1), bitSet), (abc) j6(this.j6.Zo(i2 + 3), bitSet));
                        break;
                    case 11:
                        FH = new aau((abf) j6(this.j6.Zo(i2 + 1), bitSet), (abc) j6(this.j6.Zo(i2 + 3), bitSet));
                        break;
                    case 12:
                        FH = new abc((abe) j6(this.j6.Zo(i2 + 1), bitSet), (abe) j6(this.j6.Zo(i2 + 3), bitSet));
                        break;
                }
                this.DW.j6(i, FH);
            } catch (th e) {
                e.j6("...while parsing cst " + add.FH(i) + " at offset " + add.j6(i2));
                throw e;
            } catch (Throwable e2) {
                th thVar = new th(e2);
                thVar.j6("...while parsing cst " + add.FH(i) + " at offset " + add.j6(i2));
                throw thVar;
            }
        }
        return FH;
    }

    private abe j6(int i) {
        int i2 = i + 3;
        try {
            return new abe(this.j6.j6(i2, this.j6.Zo(i + 1) + i2));
        } catch (Throwable e) {
            throw new th(e);
        }
    }
}
