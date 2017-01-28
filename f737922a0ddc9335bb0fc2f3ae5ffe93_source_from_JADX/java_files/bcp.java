public class bcp extends ayp {
    private ayh DW;
    private boolean FH;
    private ayq j6;

    public static bcp j6(azc azc, boolean z) {
        return j6(ayw.j6(azc, z));
    }

    public static bcp j6(Object obj) {
        if (obj == null || (obj instanceof bcp)) {
            return (bcp) obj;
        }
        if (obj instanceof ayq) {
            return new bcp((ayq) obj);
        }
        if (obj instanceof String) {
            return new bcp((String) obj);
        }
        if ((obj instanceof ayw) || (obj instanceof ayx)) {
            return new bcp(ayw.j6(obj));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public bcp(ayq ayq) {
        this.FH = false;
        this.j6 = ayq;
    }

    public bcp(String str) {
        this.FH = false;
        this.j6 = new ayq(str);
    }

    public bcp(bag bag) {
        this.FH = false;
        this.j6 = new ayq(bag.FH());
    }

    public bcp(bag bag, ayh ayh) {
        this.FH = false;
        this.FH = true;
        this.j6 = new ayq(bag.FH());
        this.DW = ayh;
    }

    public bcp(ayq ayq, ayh ayh) {
        this.FH = false;
        this.FH = true;
        this.j6 = ayq;
        this.DW = ayh;
    }

    public bcp(ayw ayw) {
        this.FH = false;
        if (ayw.v5() < 1 || ayw.v5() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + ayw.v5());
        }
        this.j6 = bag.j6((Object) ayw.j6(0));
        if (ayw.v5() == 2) {
            this.FH = true;
            this.DW = ayw.j6(1);
            return;
        }
        this.DW = null;
    }

    public ayq FH() {
        return new ayq(this.j6.FH());
    }

    public ayq Hw() {
        return this.j6;
    }

    public ayh v5() {
        return this.DW;
    }

    public ayv w_() {
        ayi ayi = new ayi();
        ayi.j6(this.j6);
        if (this.FH) {
            if (this.DW != null) {
                ayi.j6(this.DW);
            } else {
                ayi.j6(bae.j6);
            }
        }
        return new bal(ayi);
    }
}
