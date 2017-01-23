import java.io.File;

public class atz$a {
    String DW;
    int FH;
    File Hw;
    Boolean VH;
    String Zo;
    String gn;
    boolean j6;
    String v5;

    void j6(atz$a atz_a) {
        if (this.DW == null) {
            this.DW = atz_a.DW;
        }
        if (this.FH == 0) {
            this.FH = atz_a.FH;
        }
        if (this.Hw == null) {
            this.Hw = atz_a.Hw;
        }
        if (this.v5 == null) {
            this.v5 = atz_a.v5;
        }
        if (this.Zo == null) {
            this.Zo = atz_a.Zo;
        }
        if (this.VH == null) {
            this.VH = atz_a.VH;
        }
        if (this.gn == null) {
            this.gn = atz_a.gn;
        }
    }

    public String j6() {
        return this.gn;
    }

    public String DW() {
        return this.DW;
    }

    public int FH() {
        return this.FH;
    }

    public File Hw() {
        return this.Hw;
    }

    public String v5() {
        return this.v5;
    }

    public String Zo() {
        return this.Zo;
    }

    public boolean VH() {
        return this.VH != null && this.VH.booleanValue();
    }
}
