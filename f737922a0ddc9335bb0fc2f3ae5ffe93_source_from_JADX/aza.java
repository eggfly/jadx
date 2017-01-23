import com.aide.uidesigner.ProxyTextView;
import java.io.IOException;
import java.io.InputStream;

public class aza {
    private final int DW;
    private final byte[][] FH;
    private final InputStream j6;

    public aza(InputStream inputStream) {
        this(inputStream, bbg.j6(inputStream));
    }

    public aza(InputStream inputStream, int i) {
        this.j6 = inputStream;
        this.DW = i;
        this.FH = new byte[11][];
    }

    ayh j6(int i) {
        switch (i) {
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return new azk(this);
            case 8:
                return new azy(this);
            case 16:
                return new azm(this);
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return new azo(this);
            default:
                throw new ayk("unknown BER object encountered: 0x" + Integer.toHexString(i));
        }
    }

    ayv j6(boolean z, int i) {
        if (!z) {
            return new baq(false, i, new bah(((baz) this.j6).DW()));
        }
        ayi DW = DW();
        if (this.j6 instanceof bbb) {
            if (DW.j6() == 1) {
                return new azp(true, i, DW.j6(0));
            }
            return new azp(false, i, azi.j6(DW));
        } else if (DW.j6() == 1) {
            return new baq(true, i, DW.j6(0));
        } else {
            return new baq(false, i, azz.j6(DW));
        }
    }

    public ayh j6() {
        boolean z = false;
        int read = this.j6.read();
        if (read == -1) {
            return null;
        }
        j6(false);
        int j6 = aym.j6(this.j6, read);
        if ((read & 32) != 0) {
            z = true;
        }
        int DW = aym.DW(this.j6, this.DW);
        if (DW >= 0) {
            baz baz = new baz(this.j6, DW);
            if ((read & 64) != 0) {
                return new azs(z, j6, baz.DW());
            }
            if ((read & 128) != 0) {
                return new azq(z, j6, new aza(baz));
            }
            if (z) {
                switch (j6) {
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        return new azk(new aza(baz));
                    case 8:
                        return new azy(new aza(baz));
                    case 16:
                        return new bam(new aza(baz));
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        return new bao(new aza(baz));
                    default:
                        throw new IOException("unknown tag " + j6 + " encountered");
                }
            }
            switch (j6) {
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    return new bai(baz);
                default:
                    try {
                        return aym.j6(j6, baz, this.FH);
                    } catch (Throwable e) {
                        throw new ayk("corrupted stream detected", e);
                    }
            }
        } else if (z) {
            aza aza = new aza(new bbb(this.j6, this.DW), this.DW);
            if ((read & 64) != 0) {
                return new azg(j6, aza);
            }
            if ((read & 128) != 0) {
                return new azq(true, j6, aza);
            }
            return aza.j6(j6);
        } else {
            throw new IOException("indefinite length primitive encoding encountered");
        }
    }

    private void j6(boolean z) {
        if (this.j6 instanceof bbb) {
            ((bbb) this.j6).j6(z);
        }
    }

    ayi DW() {
        ayi ayi = new ayi();
        while (true) {
            ayh j6 = j6();
            if (j6 == null) {
                return ayi;
            }
            if (j6 instanceof bba) {
                ayi.j6(((bba) j6).v5());
            } else {
                ayi.j6(j6.w_());
            }
        }
    }
}
