public class aku extends avx {
    protected int DW;
    protected akt FH;
    protected akv Hw;
    private final akv J0;
    private final int J8;
    private final byte[] QX;
    private final int Ws;
    private int XL;
    protected final ako j6;

    public aku(ako ako) {
        this.j6 = ako;
        this.J0 = ako.j6(true);
        this.J8 = 0;
        this.Ws = this.J0.DW();
        this.QX = new byte[20];
        if (!u7()) {
            Ws();
        }
    }

    aku(aku aku, akv akv) {
        super(aku, aku.tp, aku.we + 1);
        this.j6 = aku.j6;
        this.J0 = akv;
        this.J8 = aku.DW;
        this.Ws = this.J8 + this.J0.DW();
        this.QX = aku.QX;
        this.DW = aku.DW;
        Ws();
    }

    public avx j6(any any) {
        if (this.Hw != null) {
            return new aku(this, this.Hw);
        }
        throw new alb(EQ(), "tree");
    }

    public avz FH() {
        Object obj = new byte[Math.max(this.we + 1, 128)];
        System.arraycopy(this.tp, 0, obj, 0, this.we);
        obj[this.we] = (byte) 47;
        return new avz(this, obj, this.we + 1);
    }

    public boolean Hw() {
        if (this.Hw != null) {
            return this.Hw.j6();
        }
        return this.FH != null;
    }

    public byte[] v5() {
        if (this.Hw != null) {
            return this.Hw.j6() ? this.QX : v5;
        } else {
            if (this.FH != null) {
                return this.FH.FH();
            }
            return v5;
        }
    }

    public int Zo() {
        if (this.Hw == null && this.FH != null) {
            return this.FH.Hw();
        }
        return 0;
    }

    public void VH() {
        if (!gn()) {
            this.DW = this.J8;
            if (!u7()) {
                Ws();
            }
        }
    }

    public boolean gn() {
        return this.DW == this.J8;
    }

    public boolean u7() {
        return this.DW == this.Ws;
    }

    public void j6(int i) {
        while (true) {
            i--;
            if (i >= 0) {
                if (this.Hw != null) {
                    this.DW += this.Hw.DW();
                } else {
                    this.DW++;
                }
                if (!u7()) {
                    Ws();
                } else {
                    return;
                }
            }
            return;
        }
    }

    public void DW(int i) {
        while (true) {
            i--;
            if (i >= 0) {
                if (this.Hw != null) {
                    this.XL--;
                }
                this.DW--;
                Ws();
                if (this.Hw != null) {
                    this.DW -= this.Hw.DW() - 1;
                }
            } else {
                return;
            }
        }
    }

    private void Ws() {
        this.FH = this.j6.DW(this.DW);
        byte[] bArr = this.FH.j6;
        if (this.XL != this.J0.FH()) {
            akv j6 = this.J0.j6(this.XL);
            if (j6.j6(bArr, this.EQ, bArr.length)) {
                this.Hw = j6;
                this.XL++;
                if (j6.j6()) {
                    j6.Hw().DW(this.QX, 0);
                }
                this.u7 = anl.j6.FH();
                this.tp = bArr;
                this.we = this.EQ + j6.v5();
                return;
            }
        }
        this.u7 = this.FH.u7();
        this.tp = bArr;
        this.we = bArr.length;
        this.Hw = null;
    }

    public akt tp() {
        return this.Hw == null ? this.FH : null;
    }
}
