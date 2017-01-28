public class bac extends ayv implements azb {
    private byte[] j6;

    bac(byte[] bArr) {
        this.j6 = bArr;
    }

    public bac(String str) {
        this(str, false);
    }

    public bac(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("string cannot be null");
        } else if (!z || DW(str)) {
            this.j6 = bhl.FH(str);
        } else {
            throw new IllegalArgumentException("string contains illegal characters");
        }
    }

    public String j6() {
        return bhl.DW(this.j6);
    }

    public String toString() {
        return j6();
    }

    boolean gn() {
        return false;
    }

    int u7() {
        return (bbg.j6(this.j6.length) + 1) + this.j6.length;
    }

    void j6(ayt ayt) {
        ayt.j6(22, this.j6);
    }

    public int hashCode() {
        return bhf.j6(this.j6);
    }

    boolean j6(ayv ayv) {
        if (!(ayv instanceof bac)) {
            return false;
        }
        return bhf.j6(this.j6, ((bac) ayv).j6);
    }

    public static boolean DW(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) > '\u007f') {
                return false;
            }
        }
        return true;
    }
}
