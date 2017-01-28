import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class bct extends ayp {
    private Vector DW;
    private Hashtable j6;

    public static bct j6(Object obj) {
        if (obj instanceof bct) {
            return (bct) obj;
        }
        if (obj != null) {
            return new bct(ayw.j6(obj));
        }
        return null;
    }

    private bct(ayw ayw) {
        this.j6 = new Hashtable();
        this.DW = new Vector();
        Enumeration Hw = ayw.Hw();
        while (Hw.hasMoreElements()) {
            ayw j6 = ayw.j6(Hw.nextElement());
            if (j6.v5() == 3) {
                this.j6.put(j6.j6(0), new bcs(bag.j6((Object) j6.j6(0)), azv.j6((Object) j6.j6(1)), ayr.j6(j6.j6(2))));
            } else if (j6.v5() == 2) {
                this.j6.put(j6.j6(0), new bcs(bag.j6((Object) j6.j6(0)), false, ayr.j6(j6.j6(1))));
            } else {
                throw new IllegalArgumentException("Bad sequence size: " + j6.v5());
            }
            this.DW.addElement(j6.j6(0));
        }
    }

    public bcs j6(ayq ayq) {
        return (bcs) this.j6.get(ayq);
    }

    public ayv w_() {
        ayi ayi = new ayi();
        Enumeration elements = this.DW.elements();
        while (elements.hasMoreElements()) {
            ayh ayh = (ayq) elements.nextElement();
            bcs bcs = (bcs) this.j6.get(ayh);
            ayi ayi2 = new ayi();
            ayi2.j6(ayh);
            if (bcs.j6()) {
                ayi2.j6(azv.j6(true));
            }
            ayi2.j6(bcs.DW());
            ayi.j6(new bal(ayi2));
        }
        return new bal(ayi);
    }
}
