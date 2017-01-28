import java.io.IOException;

public class bdb {
    public static final ayq BT;
    public static final ayq DW;
    public static final ayq EQ;
    public static final ayq FH;
    public static final ayq Hw;
    public static final ayq J0;
    public static final ayq J8;
    public static final ayq Mr;
    public static final ayq P8;
    public static final ayq QX;
    public static final ayq U2;
    public static final ayq VH;
    public static final ayq Ws;
    public static final ayq XL;
    public static final ayq Zo;
    public static final ayq a8;
    public static final ayq aM;
    public static final ayq ei;
    public static final ayq er;
    public static final ayq gW;
    public static final ayq gn;
    public static final ayq j3;
    public static final ayq j6;
    public static final ayq lg;
    public static final ayq rN;
    public static final ayq tp;
    public static final ayq u7;
    public static final ayq v5;
    public static final ayq vy;
    public static final ayq we;
    public static final ayq yS;
    ayr SI;
    boolean nw;

    static {
        j6 = new ayq("2.5.29.9");
        DW = new ayq("2.5.29.14");
        FH = new ayq("2.5.29.15");
        Hw = new ayq("2.5.29.16");
        v5 = new ayq("2.5.29.17");
        Zo = new ayq("2.5.29.18");
        VH = new ayq("2.5.29.19");
        gn = new ayq("2.5.29.20");
        u7 = new ayq("2.5.29.21");
        tp = new ayq("2.5.29.23");
        EQ = new ayq("2.5.29.24");
        we = new ayq("2.5.29.27");
        J0 = new ayq("2.5.29.28");
        J8 = new ayq("2.5.29.29");
        Ws = new ayq("2.5.29.30");
        QX = new ayq("2.5.29.31");
        XL = new ayq("2.5.29.32");
        aM = new ayq("2.5.29.33");
        j3 = new ayq("2.5.29.35");
        Mr = new ayq("2.5.29.36");
        U2 = new ayq("2.5.29.37");
        a8 = new ayq("2.5.29.46");
        lg = new ayq("2.5.29.54");
        rN = new ayq("1.3.6.1.5.5.7.1.1");
        er = new ayq("1.3.6.1.5.5.7.1.11");
        yS = new ayq("1.3.6.1.5.5.7.1.12");
        gW = new ayq("1.3.6.1.5.5.7.1.2");
        BT = new ayq("1.3.6.1.5.5.7.1.3");
        vy = new ayq("1.3.6.1.5.5.7.1.4");
        P8 = new ayq("2.5.29.56");
        ei = new ayq("2.5.29.55");
    }

    public bdb(azv azv, ayr ayr) {
        this.nw = azv.FH();
        this.SI = ayr;
    }

    public bdb(boolean z, ayr ayr) {
        this.nw = z;
        this.SI = ayr;
    }

    public boolean j6() {
        return this.nw;
    }

    public ayr DW() {
        return this.SI;
    }

    public int hashCode() {
        if (j6()) {
            return DW().hashCode();
        }
        return DW().hashCode() ^ -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof bdb)) {
            return false;
        }
        bdb bdb = (bdb) obj;
        if (bdb.DW().equals(DW()) && bdb.j6() == j6()) {
            return true;
        }
        return false;
    }

    public static ayv j6(bdb bdb) {
        try {
            return ayv.j6(bdb.DW().Hw());
        } catch (IOException e) {
            throw new IllegalArgumentException("can't convert extension: " + e);
        }
    }
}
