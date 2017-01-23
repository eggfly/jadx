public class yb {
    private final int[] DW;
    private final int[] FH;
    private final int[] Hw;
    private final int[] VH;
    private final int[] Zo;
    private final int j6;
    private final int[] v5;

    public yb(int i, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6) {
        this.j6 = i;
        this.DW = iArr;
        this.FH = iArr2;
        this.Hw = iArr3;
        this.v5 = iArr4;
        this.Zo = iArr5;
        this.VH = iArr6;
    }

    public void j6(yt$a yt_a) {
        int i;
        int i2 = 0;
        yt_a.v5(this.j6);
        yt_a.v5(this.DW.length);
        yt_a.v5(this.Hw.length);
        yt_a.v5(this.Zo.length);
        for (i = 0; i < this.DW.length; i++) {
            yt_a.v5(this.DW[i]);
            yt_a.v5(this.FH[i]);
        }
        for (i = 0; i < this.Hw.length; i++) {
            yt_a.v5(this.Hw[i]);
            yt_a.v5(this.v5[i]);
        }
        while (i2 < this.Zo.length) {
            yt_a.v5(this.Zo[i2]);
            yt_a.v5(this.VH[i2]);
            i2++;
        }
    }

    public int j6() {
        return this.j6;
    }

    public int[] DW() {
        return this.DW;
    }

    public int[] FH() {
        return this.FH;
    }

    public int[] Hw() {
        return this.Hw;
    }

    public int[] v5() {
        return this.v5;
    }

    public int[] Zo() {
        return this.Zo;
    }

    public int[] VH() {
        return this.VH;
    }
}
