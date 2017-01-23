import java.io.ByteArrayOutputStream;

public class azx extends ayv {
    private ayn DW;
    private ayv FH;
    private int Hw;
    private ayq j6;
    private ayv v5;

    public azx(ayi ayi) {
        int i = 0;
        ayv j6 = j6(ayi, 0);
        if (j6 instanceof ayq) {
            this.j6 = (ayq) j6;
            i = 1;
            j6 = j6(ayi, 1);
        }
        if (j6 instanceof ayn) {
            this.DW = (ayn) j6;
            i++;
            j6 = j6(ayi, i);
        }
        if (!(j6 instanceof baq)) {
            this.FH = j6;
            i++;
            j6 = j6(ayi, i);
        }
        if (ayi.j6() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (j6 instanceof baq) {
            baq baq = (baq) j6;
            j6(baq.FH());
            this.v5 = baq.EQ();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    private ayv j6(ayi ayi, int i) {
        if (ayi.j6() > i) {
            return ayi.j6(i).w_();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    public int hashCode() {
        int i = 0;
        if (this.j6 != null) {
            i = this.j6.hashCode();
        }
        if (this.DW != null) {
            i ^= this.DW.hashCode();
        }
        if (this.FH != null) {
            i ^= this.FH.hashCode();
        }
        return i ^ this.v5.hashCode();
    }

    boolean gn() {
        return true;
    }

    int u7() {
        return DW().length;
    }

    void j6(ayt ayt) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.j6 != null) {
            byteArrayOutputStream.write(this.j6.j6("DER"));
        }
        if (this.DW != null) {
            byteArrayOutputStream.write(this.DW.j6("DER"));
        }
        if (this.FH != null) {
            byteArrayOutputStream.write(this.FH.j6("DER"));
        }
        byteArrayOutputStream.write(new baq(true, this.Hw, this.v5).j6("DER"));
        ayt.j6(32, 8, byteArrayOutputStream.toByteArray());
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof azx)) {
            return false;
        }
        if (this == ayv) {
            return true;
        }
        azx azx = (azx) ayv;
        if (this.j6 != null && (azx.j6 == null || !azx.j6.equals(this.j6))) {
            return false;
        }
        if (this.DW != null && (azx.DW == null || !azx.DW.equals(this.DW))) {
            return false;
        }
        if (this.FH == null || (azx.FH != null && azx.FH.equals(this.FH))) {
            return this.v5.equals(azx.v5);
        }
        return false;
    }

    public ayv FH() {
        return this.FH;
    }

    public ayq Hw() {
        return this.j6;
    }

    public int v5() {
        return this.Hw;
    }

    public ayv tp() {
        return this.v5;
    }

    public ayn EQ() {
        return this.DW;
    }

    private void j6(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid encoding value: " + i);
        }
        this.Hw = i;
    }
}
