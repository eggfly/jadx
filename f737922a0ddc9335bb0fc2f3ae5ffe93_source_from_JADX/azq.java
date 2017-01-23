import java.io.IOException;

public class azq implements azd {
    private int DW;
    private aza FH;
    private boolean j6;

    azq(boolean z, int i, aza aza) {
        this.j6 = z;
        this.DW = i;
        this.FH = aza;
    }

    public ayv v5() {
        return this.FH.j6(this.j6, this.DW);
    }

    public ayv w_() {
        try {
            return v5();
        } catch (IOException e) {
            throw new ayu(e.getMessage());
        }
    }
}
