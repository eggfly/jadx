package groovyjarjarantlr;

public class ANTLRHashString {
    private char[] DW;
    private int FH;
    private CharScanner Hw;
    private String j6;

    public ANTLRHashString(CharScanner charScanner) {
        this.Hw = charScanner;
    }

    public ANTLRHashString(String str, CharScanner charScanner) {
        this.Hw = charScanner;
        j6(str);
    }

    private final char j6(int i) {
        return this.j6 != null ? this.j6.charAt(i) : this.DW[i];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ANTLRHashString) && !(obj instanceof String)) {
            return false;
        }
        if (obj instanceof String) {
            obj = new ANTLRHashString((String) obj, this.Hw);
        } else {
            ANTLRHashString aNTLRHashString = (ANTLRHashString) obj;
        }
        int j6 = j6();
        if (obj.j6() != j6) {
            return false;
        }
        int i;
        if (this.Hw.FH()) {
            for (i = 0; i < j6; i++) {
                if (j6(i) != obj.j6(i)) {
                    return false;
                }
            }
        } else {
            for (i = 0; i < j6; i++) {
                if (this.Hw.Hw(j6(i)) != this.Hw.Hw(obj.j6(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int j6 = j6();
        int i2;
        int j62;
        if (this.Hw.FH()) {
            i2 = 0;
            while (i2 < j6) {
                j62 = j6(i2) + (i * 151);
                i2++;
                i = j62;
            }
        } else {
            i2 = 0;
            while (i2 < j6) {
                j62 = this.Hw.Hw(j6(i2)) + (i * 151);
                i2++;
                i = j62;
            }
        }
        return i;
    }

    private final int j6() {
        return this.j6 != null ? this.j6.length() : this.FH;
    }

    public void j6(char[] cArr, int i) {
        this.DW = cArr;
        this.FH = i;
        this.j6 = null;
    }

    public void j6(String str) {
        this.j6 = str;
        this.DW = null;
    }
}
