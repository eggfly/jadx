import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ayw extends ayv {
    protected Vector j6;

    public static ayw j6(Object obj) {
        if (obj == null || (obj instanceof ayw)) {
            return (ayw) obj;
        }
        if (obj instanceof ayx) {
            return j6(((ayx) obj).w_());
        }
        if (obj instanceof byte[]) {
            try {
                return j6(ayv.j6((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ayh) {
            ayv w_ = ((ayh) obj).w_();
            if (w_ instanceof ayw) {
                return (ayw) w_;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ayw j6(azc azc, boolean z) {
        if (z) {
            if (azc.Hw()) {
                return j6(azc.EQ().w_());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (azc.Hw()) {
            if (azc instanceof azp) {
                return new azl(azc.EQ());
            }
            return new baw(azc.EQ());
        } else if (azc.EQ() instanceof ayw) {
            return (ayw) azc.EQ();
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + azc.getClass().getName());
        }
    }

    protected ayw() {
        this.j6 = new Vector();
    }

    protected ayw(ayh ayh) {
        this.j6 = new Vector();
        this.j6.addElement(ayh);
    }

    protected ayw(ayi ayi) {
        this.j6 = new Vector();
        for (int i = 0; i != ayi.j6(); i++) {
            this.j6.addElement(ayi.j6(i));
        }
    }

    protected ayw(ayh[] ayhArr) {
        this.j6 = new Vector();
        for (int i = 0; i != ayhArr.length; i++) {
            this.j6.addElement(ayhArr[i]);
        }
    }

    public ayh[] FH() {
        ayh[] ayhArr = new ayh[v5()];
        for (int i = 0; i != v5(); i++) {
            ayhArr[i] = j6(i);
        }
        return ayhArr;
    }

    public Enumeration Hw() {
        return this.j6.elements();
    }

    public ayh j6(int i) {
        return (ayh) this.j6.elementAt(i);
    }

    public int v5() {
        return this.j6.size();
    }

    public int hashCode() {
        Enumeration Hw = Hw();
        int v5 = v5();
        while (Hw.hasMoreElements()) {
            v5 = (v5 * 17) ^ j6(Hw).hashCode();
        }
        return v5;
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof ayw)) {
            return false;
        }
        ayw ayw = (ayw) ayv;
        if (v5() != ayw.v5()) {
            return false;
        }
        Enumeration Hw = Hw();
        Enumeration Hw2 = ayw.Hw();
        while (Hw.hasMoreElements()) {
            ayh j6 = j6(Hw);
            ayh j62 = j6(Hw2);
            ayv w_ = j6.w_();
            ayv w_2 = j62.w_();
            if (w_ != w_2) {
                if (!w_.equals(w_2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private ayh j6(Enumeration enumeration) {
        return (ayh) enumeration.nextElement();
    }

    ayv Zo() {
        ayv bal = new bal();
        bal.j6 = this.j6;
        return bal;
    }

    ayv VH() {
        ayv baw = new baw();
        baw.j6 = this.j6;
        return baw;
    }

    boolean gn() {
        return true;
    }

    public String toString() {
        return this.j6.toString();
    }
}
