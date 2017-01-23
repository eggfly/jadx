import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class bdc extends ayp {
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
    private Vector SI;
    private Hashtable nw;

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

    public static bdc j6(Object obj) {
        if (obj == null || (obj instanceof bdc)) {
            return (bdc) obj;
        }
        if (obj instanceof ayw) {
            return new bdc((ayw) obj);
        }
        if (obj instanceof bct) {
            return new bdc((ayw) ((bct) obj).w_());
        }
        if (obj instanceof azc) {
            return j6(((azc) obj).EQ());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public bdc(ayw ayw) {
        this.nw = new Hashtable();
        this.SI = new Vector();
        Enumeration Hw = ayw.Hw();
        while (Hw.hasMoreElements()) {
            ayw j6 = ayw.j6(Hw.nextElement());
            if (j6.v5() == 3) {
                this.nw.put(j6.j6(0), new bdb(azv.j6(j6.j6(1)), ayr.j6(j6.j6(2))));
            } else if (j6.v5() == 2) {
                this.nw.put(j6.j6(0), new bdb(false, ayr.j6(j6.j6(1))));
            } else {
                throw new IllegalArgumentException("Bad sequence size: " + j6.v5());
            }
            this.SI.addElement(j6.j6(0));
        }
    }

    public bdc(Vector vector, Hashtable hashtable) {
        Enumeration keys;
        this.nw = new Hashtable();
        this.SI = new Vector();
        if (vector == null) {
            keys = hashtable.keys();
        } else {
            keys = vector.elements();
        }
        while (keys.hasMoreElements()) {
            this.SI.addElement(bag.j6(keys.nextElement()));
        }
        Enumeration elements = this.SI.elements();
        while (elements.hasMoreElements()) {
            ayq j6 = bag.j6(elements.nextElement());
            this.nw.put(j6, (bdb) hashtable.get(j6));
        }
    }

    public Enumeration FH() {
        return this.SI.elements();
    }

    public bdb j6(bag bag) {
        return (bdb) this.nw.get(bag);
    }

    public ayv w_() {
        ayi ayi = new ayi();
        Enumeration elements = this.SI.elements();
        while (elements.hasMoreElements()) {
            ayh ayh = (ayq) elements.nextElement();
            bdb bdb = (bdb) this.nw.get(ayh);
            ayi ayi2 = new ayi();
            ayi2.j6(ayh);
            if (bdb.j6()) {
                ayi2.j6(new azv(true));
            }
            ayi2.j6(bdb.DW());
            ayi.j6(new bal(ayi2));
        }
        return new bal(ayi);
    }
}
