public class abo extends acd {
    private int DW;
    private adg j6;

    public abo(int i) {
        this.j6 = new adg(i);
    }

    public int j6() {
        return this.DW;
    }

    public zw j6(zw zwVar) {
        if (zwVar == null) {
            return null;
        }
        int DW;
        try {
            DW = this.j6.DW(zwVar.VH());
        } catch (IndexOutOfBoundsException e) {
            DW = -1;
        }
        if (DW >= 0) {
            return zwVar.DW(DW);
        }
        throw new RuntimeException("no mapping specified for register");
    }

    public int j6(int i) {
        if (i >= this.j6.DW()) {
            return -1;
        }
        return this.j6.DW(i);
    }

    public void j6(int i, int i2, int i3) {
        if (i >= this.j6.DW()) {
            for (int DW = i - this.j6.DW(); DW >= 0; DW--) {
                this.j6.FH(-1);
            }
        }
        this.j6.DW(i, i2);
        if (this.DW < i2 + i3) {
            this.DW = i2 + i3;
        }
    }
}
