import java.util.Arrays;

public class atm$a extends atm {
    private char[] j6;

    public atm$a(String str, boolean z) {
        super(str, z);
    }

    public void DW() {
        if (this.j6 != null) {
            Arrays.fill(this.j6, '\u0000');
            this.j6 = null;
        }
    }

    public char[] FH() {
        return this.j6;
    }

    public void j6(char[] cArr) {
        DW();
        if (cArr != null) {
            this.j6 = new char[cArr.length];
            System.arraycopy(cArr, 0, this.j6, 0, cArr.length);
        }
    }
}
