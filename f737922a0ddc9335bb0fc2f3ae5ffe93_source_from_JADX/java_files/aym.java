import com.aide.uidesigner.ProxyTextView;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class aym extends FilterInputStream {
    private final boolean DW;
    private final byte[][] FH;
    private final int j6;

    public aym(InputStream inputStream) {
        this(inputStream, bbg.j6(inputStream));
    }

    public aym(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public aym(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public aym(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    public aym(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.j6 = i;
        this.DW = z;
        this.FH = new byte[11][];
    }

    int j6() {
        return this.j6;
    }

    protected int DW() {
        return DW(this, this.j6);
    }

    protected ayv j6(int i, int i2, int i3) {
        int i4 = 0;
        boolean z = (i & 32) != 0;
        baz baz = new baz(this, i3);
        if ((i & 64) != 0) {
            return new azs(z, i2, baz.DW());
        }
        if ((i & 128) != 0) {
            return new aza(baz).j6(z, i2);
        }
        if (!z) {
            return j6(i2, baz, this.FH);
        }
        switch (i2) {
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                ayi j6 = j6(baz);
                ayr[] ayrArr = new ayr[j6.j6()];
                while (i4 != ayrArr.length) {
                    ayrArr[i4] = (ayr) j6.j6(i4);
                    i4++;
                }
                return new azj(ayrArr);
            case 8:
                return new azx(j6(baz));
            case 16:
                if (this.DW) {
                    return new bbd(baz.DW());
                }
                return azz.j6(j6(baz));
            case ProxyTextView.INPUTTYPE_textUri /*17*/:
                return azz.DW(j6(baz));
            default:
                throw new IOException("unknown tag " + i2 + " encountered");
        }
    }

    ayi FH() {
        ayi ayi = new ayi();
        while (true) {
            ayh Hw = Hw();
            if (Hw == null) {
                return ayi;
            }
            ayi.j6(Hw);
        }
    }

    ayi j6(baz baz) {
        return new aym((InputStream) baz).FH();
    }

    public ayv Hw() {
        int read = read();
        if (read > 0) {
            int j6 = j6((InputStream) this, read);
            boolean z = (read & 32) != 0;
            int DW = DW();
            if (DW >= 0) {
                try {
                    return j6(read, j6, DW);
                } catch (Throwable e) {
                    throw new ayk("corrupted stream detected", e);
                }
            } else if (z) {
                aza aza = new aza(new bbb(this, this.j6), this.j6);
                if ((read & 64) != 0) {
                    return new azg(j6, aza).v5();
                }
                if ((read & 128) != 0) {
                    return new azq(true, j6, aza).v5();
                }
                switch (j6) {
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        return new azk(aza).v5();
                    case 8:
                        return new azy(aza).v5();
                    case 16:
                        return new azm(aza).v5();
                    case ProxyTextView.INPUTTYPE_textUri /*17*/:
                        return new azo(aza).v5();
                    default:
                        throw new IOException("unknown BER object encountered");
                }
            } else {
                throw new IOException("indefinite length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    static int j6(InputStream inputStream, int i) {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        i2 = inputStream.read();
        if ((i2 & 127) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while (i2 >= 0 && (i2 & 128) != 0) {
            i3 = ((i2 & 127) | i3) << 7;
            i2 = inputStream.read();
        }
        if (i2 >= 0) {
            return (i2 & 127) | i3;
        }
        throw new EOFException("EOF found inside tag value.");
    }

    static int DW(InputStream inputStream, int i) {
        int i2 = 0;
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i3 = read & 127;
            if (i3 > 4) {
                throw new IOException("DER length more than 4 bytes: " + i3);
            }
            read = 0;
            while (i2 < i3) {
                int read2 = inputStream.read();
                if (read2 < 0) {
                    throw new EOFException("EOF found reading length");
                }
                i2++;
                read = read2 + (read << 8);
            }
            if (read < 0) {
                throw new IOException("corrupted stream - negative length found");
            } else if (read < i) {
                return read;
            } else {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }
    }

    private static byte[] j6(baz baz, byte[][] bArr) {
        int j6 = baz.j6();
        if (baz.j6() >= bArr.length) {
            return baz.DW();
        }
        byte[] bArr2 = bArr[j6];
        if (bArr2 == null) {
            bArr2 = new byte[j6];
            bArr[j6] = bArr2;
        }
        bhp.j6((InputStream) baz, bArr2);
        return bArr2;
    }

    private static char[] DW(baz baz) {
        int j6 = baz.j6() / 2;
        char[] cArr = new char[j6];
        int i = 0;
        while (i < j6) {
            int read = baz.read();
            if (read < 0) {
                break;
            }
            int read2 = baz.read();
            if (read2 < 0) {
                break;
            }
            int i2 = i + 1;
            cArr[i] = (char) ((read << 8) | (read2 & 255));
            i = i2;
        }
        return cArr;
    }

    static ayv j6(int i, baz baz, byte[][] bArr) {
        switch (i) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return azv.DW(j6(baz, bArr));
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return new ayn(baz.DW());
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return azu.j6(baz.j6(), (InputStream) baz);
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return new bah(baz.DW());
            case 5:
                return bae.j6;
            case 6:
                return bag.DW(j6(baz, bArr));
            case 10:
                return azw.DW(j6(baz, bArr));
            case 12:
                return new bas(baz.DW());
            case ProxyTextView.INPUTTYPE_numberPassword /*18*/:
                return new baf(baz.DW());
            case 19:
                return new bak(baz.DW());
            case ProxyTextView.INPUTTYPE_date /*20*/:
                return new bap(baz.DW());
            case 22:
                return new bac(baz.DW());
            case 23:
                return new aze(baz.DW());
            case 24:
                return new ayl(baz.DW());
            case 26:
                return new bau(baz.DW());
            case 27:
                return new baa(baz.DW());
            case 28:
                return new bat(baz.DW());
            case 30:
                return new azt(DW(baz));
            default:
                throw new IOException("unknown tag " + i + " encountered");
        }
    }
}
