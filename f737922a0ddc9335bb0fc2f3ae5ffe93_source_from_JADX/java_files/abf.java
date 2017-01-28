import com.aide.uidesigner.ProxyTextView;
import java.util.HashMap;

public final class abf extends abh {
    public static final abf DW;
    public static final abf EQ;
    public static final abf FH;
    public static final abf Hw;
    public static final abf J0;
    public static final abf J8;
    public static final abf QX;
    public static final abf VH;
    public static final abf Ws;
    public static final abf XL;
    public static final abf Zo;
    public static final abf aM;
    public static final abf gn;
    private static final HashMap<abl, abf> j3;
    public static final abf j6;
    public static final abf tp;
    public static final abf u7;
    public static final abf v5;
    public static final abf we;
    private final abl Mr;
    private abe U2;

    static {
        j3 = new HashMap(100);
        j6 = DW(abl.Ws);
        DW = DW(abl.j3);
        FH = DW(abl.Mr);
        Hw = DW(abl.U2);
        v5 = DW(abl.a8);
        Zo = DW(abl.lg);
        VH = DW(abl.er);
        gn = DW(abl.rN);
        u7 = DW(abl.yS);
        tp = DW(abl.gW);
        EQ = DW(abl.BT);
        we = DW(abl.vy);
        J0 = DW(abl.P8);
        J8 = DW(abl.ei);
        Ws = DW(abl.nw);
        QX = DW(abl.KD);
        XL = DW(abl.SI);
        aM = DW(abl.cn);
    }

    public static abf j6(abl abl) {
        switch (abl.FH()) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                return tp;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                return DW;
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                return FH;
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                return Hw;
            case ProxyTextView.INPUTTYPE_datetime /*4*/:
                return v5;
            case 5:
                return Zo;
            case 6:
                return gn;
            case 7:
                return VH;
            case 8:
                return u7;
            default:
                throw new IllegalArgumentException("not primitive: " + abl);
        }
    }

    public static abf DW(abl abl) {
        abf abf;
        synchronized (j3) {
            abf = (abf) j3.get(abl);
            if (abf == null) {
                abf = new abf(abl);
                j3.put(abl, abf);
            }
        }
        return abf;
    }

    public abf(abl abl) {
        if (abl == null) {
            throw new NullPointerException("type == null");
        } else if (abl == abl.tp) {
            throw new UnsupportedOperationException("KNOWN_NULL is not representable");
        } else {
            this.Mr = abl;
            this.U2 = null;
        }
    }

    public boolean equals(Object obj) {
        if ((obj instanceof abf) && this.Mr == ((abf) obj).Mr) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.Mr.hashCode();
    }

    protected int DW(aah aah) {
        return this.Mr.gn().compareTo(((abf) aah).Mr.gn());
    }

    public String toString() {
        return "type{" + Hw() + '}';
    }

    public abl j6() {
        return abl.J0;
    }

    public String gn() {
        return "type";
    }

    public boolean VH() {
        return false;
    }

    public String Hw() {
        return this.Mr.Hw();
    }

    public abl u7() {
        return this.Mr;
    }

    public abe tp() {
        if (this.U2 == null) {
            this.U2 = new abe(this.Mr.gn());
        }
        return this.U2;
    }
}
