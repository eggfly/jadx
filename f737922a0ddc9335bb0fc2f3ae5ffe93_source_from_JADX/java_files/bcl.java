import java.util.Enumeration;

public class bcl extends ayp implements ayg {
    private static bcm j6;
    private boolean DW;
    private int FH;
    private bcm Hw;
    private bck[] v5;

    static {
        j6 = bcn.j6;
    }

    public static bcl j6(Object obj) {
        if (obj instanceof bcl) {
            return (bcl) obj;
        }
        if (obj != null) {
            return new bcl(ayw.j6(obj));
        }
        return null;
    }

    private bcl(ayw ayw) {
        this(j6, ayw);
    }

    private bcl(bcm bcm, ayw ayw) {
        this.Hw = bcm;
        this.v5 = new bck[ayw.v5()];
        int i = 0;
        Enumeration Hw = ayw.Hw();
        while (Hw.hasMoreElements()) {
            int i2 = i + 1;
            this.v5[i] = bck.j6(Hw.nextElement());
            i = i2;
        }
    }

    public bck[] FH() {
        Object obj = new bck[this.v5.length];
        System.arraycopy(this.v5, 0, obj, 0, obj.length);
        return obj;
    }

    public ayv w_() {
        return new bal(this.v5);
    }

    public int hashCode() {
        if (this.DW) {
            return this.FH;
        }
        this.DW = true;
        this.FH = this.Hw.j6(this);
        return this.FH;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bcl) && !(obj instanceof ayw)) {
            return false;
        }
        if (w_().equals(((ayh) obj).w_())) {
            return true;
        }
        try {
            return this.Hw.j6(this, new bcl(ayw.j6(((ayh) obj).w_())));
        } catch (Exception e) {
            return false;
        }
    }

    public String toString() {
        return this.Hw.DW(this);
    }
}
