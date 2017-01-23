import com.aide.uidesigner.ProxyTextView;
import java.util.BitSet;

public abstract class ul {
    public static boolean j6;

    public abstract String DW(uf ufVar, boolean z);

    public abstract boolean DW(uf ufVar);

    public abstract int j6();

    public abstract String j6(uf ufVar);

    public abstract void j6(acr acr, uf ufVar);

    static {
        j6 = true;
    }

    public final String j6(uf ufVar, boolean z) {
        String v5 = ufVar.gn().v5();
        String j6 = j6(ufVar);
        String DW = DW(ufVar, z);
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(v5);
        if (j6.length() != 0) {
            stringBuilder.append(' ');
            stringBuilder.append(j6);
        }
        if (DW.length() != 0) {
            stringBuilder.append(" // ");
            stringBuilder.append(DW);
        }
        return stringBuilder.toString();
    }

    public BitSet FH(uf ufVar) {
        return new BitSet();
    }

    public boolean j6(uz uzVar) {
        return false;
    }

    protected static String j6(zx zxVar) {
        int m_ = zxVar.m_();
        StringBuffer stringBuffer = new StringBuffer((m_ * 5) + 2);
        stringBuffer.append('{');
        for (int i = 0; i < m_; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(zxVar.DW(i).J0());
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    protected static String DW(zx zxVar) {
        int m_ = zxVar.m_();
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("{");
        switch (m_) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                stringBuilder.append(zxVar.DW(0).J0());
                break;
            default:
                zw DW = zxVar.DW(m_ - 1);
                if (DW.EQ() == 2) {
                    DW = DW.FH(1);
                }
                stringBuilder.append(zxVar.DW(0).J0());
                stringBuilder.append("..");
                stringBuilder.append(DW.J0());
                break;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    protected static String j6(aay aay) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('#');
        if (aay instanceof aav) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(aay.gn());
            stringBuffer.append(' ');
            stringBuffer.append(aay.Hw());
        }
        return stringBuffer.toString();
    }

    protected static String j6(aay aay, int i) {
        long EQ;
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("#");
        if (aay instanceof aax) {
            EQ = ((aax) aay).EQ();
        } else {
            EQ = (long) aay.tp();
        }
        switch (i) {
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                stringBuffer.append(add.Zo((int) EQ));
                break;
            case 8:
                stringBuffer.append(add.v5((int) EQ));
                break;
            case 16:
                stringBuffer.append(add.FH((int) EQ));
                break;
            case 32:
                stringBuffer.append(add.j6((int) EQ));
                break;
            case 64:
                stringBuffer.append(add.j6(EQ));
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        return stringBuffer.toString();
    }

    protected static String Hw(uf ufVar) {
        int Hw = ((uz) ufVar).Hw();
        return Hw == ((char) Hw) ? add.FH(Hw) : add.j6(Hw);
    }

    protected static String v5(uf ufVar) {
        short v5 = ((uz) ufVar).v5();
        return v5 == ((short) v5) ? add.gn(v5) : add.VH(v5);
    }

    protected static String Zo(uf ufVar) {
        aah FH = ((ud) ufVar).FH();
        return FH instanceof abe ? ((abe) FH).u7() : FH.Hw();
    }

    protected static String VH(uf ufVar) {
        ud udVar = (ud) ufVar;
        if (!udVar.v5()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        int Hw = udVar.Hw();
        stringBuilder.append(udVar.FH().gn());
        stringBuilder.append('@');
        if (Hw < 65536) {
            stringBuilder.append(add.FH(Hw));
        } else {
            stringBuilder.append(add.j6(Hw));
        }
        return stringBuilder.toString();
    }

    protected static boolean j6(int i) {
        return i >= -8 && i <= 7;
    }

    protected static boolean DW(int i) {
        return i == (i & 15);
    }

    protected static boolean FH(int i) {
        return ((byte) i) == i;
    }

    protected static boolean Hw(int i) {
        return i == (i & 255);
    }

    protected static boolean v5(int i) {
        return ((short) i) == i;
    }

    protected static boolean Zo(int i) {
        return i == (65535 & i);
    }

    protected static boolean FH(zx zxVar) {
        int m_ = zxVar.m_();
        if (m_ < 2) {
            return true;
        }
        int VH = zxVar.DW(0).VH();
        for (int i = 0; i < m_; i++) {
            zw DW = zxVar.DW(i);
            if (DW.VH() != VH) {
                return false;
            }
            VH += DW.EQ();
        }
        return true;
    }

    protected static short j6(uf ufVar, int i) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("arg out of range 0..255");
        }
        int j6 = ufVar.gn().j6();
        if ((j6 & 255) == j6) {
            return (short) (j6 | (i << 8));
        }
        throw new IllegalArgumentException("opcode out of range 0..255");
    }

    protected static short gn(uf ufVar) {
        int j6 = ufVar.gn().j6();
        if (j6 >= 255 && j6 <= 65535) {
            return (short) j6;
        }
        throw new IllegalArgumentException("extended opcode out of range 255..65535");
    }

    protected static short j6(int i, int i2) {
        if ((i & 255) != i) {
            throw new IllegalArgumentException("low out of range 0..255");
        } else if ((i2 & 255) == i2) {
            return (short) ((i2 << 8) | i);
        } else {
            throw new IllegalArgumentException("high out of range 0..255");
        }
    }

    protected static short j6(int i, int i2, int i3, int i4) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("n0 out of range 0..15");
        } else if ((i2 & 15) != i2) {
            throw new IllegalArgumentException("n1 out of range 0..15");
        } else if ((i3 & 15) != i3) {
            throw new IllegalArgumentException("n2 out of range 0..15");
        } else if ((i4 & 15) == i4) {
            return (short) ((((i2 << 4) | i) | (i3 << 8)) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("n3 out of range 0..15");
        }
    }

    protected static int DW(int i, int i2) {
        if ((i & 15) != i) {
            throw new IllegalArgumentException("low out of range 0..15");
        } else if ((i2 & 15) == i2) {
            return (i2 << 4) | i;
        } else {
            throw new IllegalArgumentException("high out of range 0..15");
        }
    }

    protected static void j6(acr acr, short s) {
        acr.DW(s);
    }

    protected static void j6(acr acr, short s, short s2) {
        acr.DW(s);
        acr.DW(s2);
    }

    protected static void j6(acr acr, short s, short s2, short s3) {
        acr.DW(s);
        acr.DW(s2);
        acr.DW(s3);
    }

    protected static void j6(acr acr, short s, short s2, short s3, short s4) {
        acr.DW(s);
        acr.DW(s2);
        acr.DW(s3);
        acr.DW(s4);
    }

    protected static void j6(acr acr, short s, short s2, short s3, short s4, short s5) {
        acr.DW(s);
        acr.DW(s2);
        acr.DW(s3);
        acr.DW(s4);
        acr.DW(s5);
    }

    protected static void j6(acr acr, short s, int i) {
        j6(acr, s, (short) i, (short) (i >> 16));
    }

    protected static void j6(acr acr, short s, int i, short s2) {
        j6(acr, s, (short) i, (short) (i >> 16), s2);
    }

    protected static void j6(acr acr, short s, int i, short s2, short s3) {
        acr acr2 = acr;
        short s4 = s;
        j6(acr2, s4, (short) i, (short) (i >> 16), s2, s3);
    }

    protected static void j6(acr acr, short s, long j) {
        j6(acr, s, (short) ((int) j), (short) ((int) (j >> 16)), (short) ((int) (j >> 32)), (short) ((int) (j >> 48)));
    }
}
