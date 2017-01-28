import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ayy extends ayv {
    private boolean DW;
    private Vector j6;

    public static ayy j6(Object obj) {
        if (obj == null || (obj instanceof ayy)) {
            return (ayy) obj;
        }
        if (obj instanceof ayz) {
            return j6(((ayz) obj).w_());
        }
        if (obj instanceof byte[]) {
            try {
                return j6(ayv.j6((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ayh) {
            ayv w_ = ((ayh) obj).w_();
            if (w_ instanceof ayy) {
                return (ayy) w_;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ayy j6(azc azc, boolean z) {
        if (z) {
            if (azc.Hw()) {
                return (ayy) azc.EQ();
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (azc.Hw()) {
            if (azc instanceof azp) {
                return new azn(azc.EQ());
            }
            return new bax(azc.EQ());
        } else if (azc.EQ() instanceof ayy) {
            return (ayy) azc.EQ();
        } else {
            ayi ayi = new ayi();
            if (azc.EQ() instanceof ayw) {
                ayw ayw = (ayw) azc.EQ();
                if (azc instanceof azp) {
                    return new azn(ayw.FH());
                }
                return new bax(ayw.FH());
            }
            throw new IllegalArgumentException("unknown object in getInstance: " + azc.getClass().getName());
        }
    }

    protected ayy() {
        this.j6 = new Vector();
        this.DW = false;
    }

    protected ayy(ayh ayh) {
        this.j6 = new Vector();
        this.DW = false;
        this.j6.addElement(ayh);
    }

    protected ayy(ayi ayi, boolean z) {
        int i = 0;
        this.j6 = new Vector();
        this.DW = false;
        while (i != ayi.j6()) {
            this.j6.addElement(ayi.j6(i));
            i++;
        }
        if (z) {
            v5();
        }
    }

    protected ayy(ayh[] ayhArr, boolean z) {
        int i = 0;
        this.j6 = new Vector();
        this.DW = false;
        while (i != ayhArr.length) {
            this.j6.addElement(ayhArr[i]);
            i++;
        }
        if (z) {
            v5();
        }
    }

    public Enumeration FH() {
        return this.j6.elements();
    }

    public ayh j6(int i) {
        return (ayh) this.j6.elementAt(i);
    }

    public int Hw() {
        return this.j6.size();
    }

    public int hashCode() {
        Enumeration FH = FH();
        int Hw = Hw();
        while (FH.hasMoreElements()) {
            Hw = (Hw * 17) ^ j6(FH).hashCode();
        }
        return Hw;
    }

    ayv Zo() {
        if (this.DW) {
            ayv ban = new ban();
            ban.j6 = this.j6;
            return ban;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.j6.size(); i++) {
            vector.addElement(this.j6.elementAt(i));
        }
        ban = new ban();
        ban.j6 = vector;
        ban.v5();
        return ban;
    }

    ayv VH() {
        ayv bax = new bax();
        bax.j6 = this.j6;
        return bax;
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof ayy)) {
            return false;
        }
        ayy ayy = (ayy) ayv;
        if (Hw() != ayy.Hw()) {
            return false;
        }
        Enumeration FH = FH();
        Enumeration FH2 = ayy.FH();
        while (FH.hasMoreElements()) {
            ayh j6 = j6(FH);
            ayh j62 = j6(FH2);
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
        ayh ayh = (ayh) enumeration.nextElement();
        if (ayh == null) {
            return bae.j6;
        }
        return ayh;
    }

    private boolean j6(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        int i = 0;
        while (i != min) {
            if (bArr[i] == bArr2[i]) {
                i++;
            } else if ((bArr[i] & 255) >= (bArr2[i] & 255)) {
                return false;
            } else {
                return true;
            }
        }
        if (min == bArr.length) {
            return true;
        }
        return false;
    }

    private byte[] j6(ayh ayh) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ayt(byteArrayOutputStream).j6(ayh);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    protected void v5() {
        if (!this.DW) {
            this.DW = true;
            if (this.j6.size() > 1) {
                int size = this.j6.size() - 1;
                boolean z = true;
                while (z) {
                    byte[] j6 = j6((ayh) this.j6.elementAt(0));
                    int i = 0;
                    int i2 = 0;
                    z = false;
                    while (i2 != size) {
                        int i3;
                        boolean z2;
                        byte[] j62 = j6((ayh) this.j6.elementAt(i2 + 1));
                        if (j6(j6, j62)) {
                            i3 = i;
                            z2 = z;
                        } else {
                            Object elementAt = this.j6.elementAt(i2);
                            this.j6.setElementAt(this.j6.elementAt(i2 + 1), i2);
                            this.j6.setElementAt(elementAt, i2 + 1);
                            j62 = j6;
                            z2 = true;
                            i3 = i2;
                        }
                        i2++;
                        z = z2;
                        i = i3;
                        j6 = j62;
                    }
                    size = i;
                }
            }
        }
    }

    boolean gn() {
        return true;
    }

    public String toString() {
        return this.j6.toString();
    }
}
