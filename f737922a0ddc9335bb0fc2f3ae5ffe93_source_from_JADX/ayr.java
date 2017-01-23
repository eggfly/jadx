import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ayr extends ayv implements ays {
    byte[] j6;

    public static ayr j6(Object obj) {
        if (obj == null || (obj instanceof ayr)) {
            return (ayr) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return j6(ayv.j6((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ayh) {
            ayv w_ = ((ayh) obj).w_();
            if (w_ instanceof ayr) {
                return (ayr) w_;
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public ayr(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("string cannot be null");
        }
        this.j6 = bArr;
    }

    public InputStream FH() {
        return new ByteArrayInputStream(this.j6);
    }

    public byte[] Hw() {
        return this.j6;
    }

    public int hashCode() {
        return bhf.j6(Hw());
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof ayr)) {
            return false;
        }
        return bhf.j6(this.j6, ((ayr) ayv).j6);
    }

    public ayv v5() {
        return w_();
    }

    ayv Zo() {
        return new bah(this.j6);
    }

    ayv VH() {
        return new bah(this.j6);
    }

    public String toString() {
        return "#" + new String(bhn.j6(this.j6));
    }
}
