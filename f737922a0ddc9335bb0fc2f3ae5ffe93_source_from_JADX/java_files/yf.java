public final class yf {
    private final yf$a[] DW;
    private final yf$b[] FH;
    private final yf$b[] Hw;
    private final yf$a[] j6;

    public yf(yf$a[] yf_aArr, yf$a[] yf_aArr2, yf$b[] yf_bArr, yf$b[] yf_bArr2) {
        this.j6 = yf_aArr;
        this.DW = yf_aArr2;
        this.FH = yf_bArr;
        this.Hw = yf_bArr2;
    }

    public yf$a[] j6() {
        return this.j6;
    }

    public yf$a[] DW() {
        return this.DW;
    }

    public yf$b[] FH() {
        return this.FH;
    }

    public yf$b[] Hw() {
        return this.Hw;
    }

    public yf$b[] v5() {
        Object obj = new yf$b[(this.FH.length + this.Hw.length)];
        System.arraycopy(this.FH, 0, obj, 0, this.FH.length);
        System.arraycopy(this.Hw, 0, obj, this.FH.length, this.Hw.length);
        return obj;
    }

    public void j6(yt$a yt_a) {
        yt_a.Zo(this.j6.length);
        yt_a.Zo(this.DW.length);
        yt_a.Zo(this.FH.length);
        yt_a.Zo(this.Hw.length);
        j6(yt_a, this.j6);
        j6(yt_a, this.DW);
        j6(yt_a, this.FH);
        j6(yt_a, this.Hw);
    }

    private void j6(yt$a yt_a, yf$a[] yf_aArr) {
        int i = 0;
        int length = yf_aArr.length;
        int i2 = 0;
        while (i < length) {
            yf$a yf_a = yf_aArr[i];
            int j6 = yf_a.j6();
            yt_a.Zo(j6 - i2);
            yt_a.Zo(yf_a.DW());
            i++;
            i2 = j6;
        }
    }

    private void j6(yt$a yt_a, yf$b[] yf_bArr) {
        int i = 0;
        int length = yf_bArr.length;
        int i2 = 0;
        while (i < length) {
            yf$b yf_b = yf_bArr[i];
            int j6 = yf_b.j6();
            yt_a.Zo(j6 - i2);
            yt_a.Zo(yf_b.DW());
            yt_a.Zo(yf_b.FH());
            i++;
            i2 = j6;
        }
    }
}
