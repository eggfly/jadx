public class azv extends ayv {
    public static final ayf DW;
    private static final byte[] FH;
    private static final byte[] Hw;
    public static final ayf j6;
    private byte[] v5;

    static {
        FH = new byte[]{(byte) -1};
        Hw = new byte[1];
        j6 = new ayf(false);
        DW = new ayf(true);
    }

    public static ayf j6(Object obj) {
        if (obj == null || (obj instanceof ayf)) {
            return (ayf) obj;
        }
        if (obj instanceof azv) {
            return ((azv) obj).FH() ? DW : j6;
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
    }

    public static ayf j6(boolean z) {
        return z ? DW : j6;
    }

    azv(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == null) {
            this.v5 = Hw;
        } else if (bArr[0] == 255) {
            this.v5 = FH;
        } else {
            this.v5 = bhf.DW(bArr);
        }
    }

    public azv(boolean z) {
        this.v5 = z ? FH : Hw;
    }

    public boolean FH() {
        return this.v5[0] != null;
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return 3;
    }

    void j6(ayt ayt) {
        ayt.j6(1, this.v5);
    }

    protected boolean j6(ayv ayv) {
        if (ayv != null && (ayv instanceof azv) && this.v5[0] == ((azv) ayv).v5[0]) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.v5[0];
    }

    public String toString() {
        return this.v5[0] != null ? "TRUE" : "FALSE";
    }

    static ayf DW(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == null) {
            return j6;
        } else {
            if (bArr[0] == 255) {
                return DW;
            }
            return new ayf(bArr);
        }
    }
}
