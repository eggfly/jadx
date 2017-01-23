import java.io.IOException;

public abstract class azc extends ayv implements azd {
    boolean DW;
    boolean FH;
    ayh Hw;
    int j6;

    public static azc j6(Object obj) {
        if (obj == null || (obj instanceof azc)) {
            return (azc) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return j6(ayv.j6((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public azc(boolean z, int i, ayh ayh) {
        this.DW = false;
        this.FH = true;
        this.Hw = null;
        if (ayh instanceof ayg) {
            this.FH = true;
        } else {
            this.FH = z;
        }
        this.j6 = i;
        if (this.FH) {
            this.Hw = ayh;
            return;
        }
        if (ayh.w_() instanceof ayy) {
            this.Hw = ayh;
        } else {
            this.Hw = ayh;
        }
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof azc)) {
            return false;
        }
        azc azc = (azc) ayv;
        if (this.j6 != azc.j6 || this.DW != azc.DW || this.FH != azc.FH) {
            return false;
        }
        if (this.Hw == null) {
            if (azc.Hw != null) {
                return false;
            }
        } else if (!this.Hw.w_().equals(azc.Hw.w_())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.j6;
        if (this.Hw != null) {
            return i ^ this.Hw.hashCode();
        }
        return i;
    }

    public int FH() {
        return this.j6;
    }

    public boolean Hw() {
        return this.FH;
    }

    public boolean tp() {
        return this.DW;
    }

    public ayv EQ() {
        if (this.Hw != null) {
            return this.Hw.w_();
        }
        return null;
    }

    public ayv v5() {
        return w_();
    }

    ayv Zo() {
        return new baq(this.FH, this.j6, this.Hw);
    }

    ayv VH() {
        return new bay(this.FH, this.j6, this.Hw);
    }

    public String toString() {
        return "[" + this.j6 + "]" + this.Hw;
    }
}
