import com.aide.uidesigner.ProxyTextView;

public class fn extends es {
    public fn(by byVar, bu buVar, bt btVar, bl blVar) {
        super(byVar, buVar, btVar, blVar, 100, 0);
    }

    private void VH() {
        while (this.VH == 3) {
            Hw();
        }
    }

    private int j6(int... iArr) {
        int i = 0;
        while (true) {
            int i2 = this.VH;
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return i;
                }
            }
            if (i2 == 3) {
                Hw();
            } else {
                DW();
                i++;
            }
        }
    }

    protected void Zo() {
        int i = 0;
        while (this.VH != 0) {
            try {
                VH();
                if (this.VH == 23) {
                    gn();
                } else {
                    tp();
                }
                i++;
            } catch (es$a e) {
                this.XL = this.XL;
            }
        }
        FH(100, i);
    }

    private void gn() {
        int i = 4;
        DW();
        VH();
        u7();
        if (this.VH != 76) {
            throw new es$a();
        }
        DW();
        while (this.VH != 0 && this.VH != 64) {
            int i2 = this.XL;
            try {
                VH();
                tp();
                i++;
            } catch (es$a e) {
                this.XL = i2;
            }
        }
        if (this.VH == 64) {
            DW();
        } else {
            FH(64);
        }
        FH(120, i);
    }

    private void u7() {
        FH(121, j6(76, 64, 0));
    }

    private void tp() {
        J8();
        if (this.VH != 76) {
            throw new es$a();
        }
        DW();
        VH();
        EQ();
        if (this.VH == 64) {
            DW();
        } else {
            FH(64);
        }
        VH();
        FH(110, 4);
    }

    private void EQ() {
        int i = 0;
        while (this.VH != 64 && this.VH != 0) {
            we();
            i++;
            VH();
        }
        FH(112, i);
    }

    private void we() {
        if (this.VH == 2 && Zo(1) == 74) {
            DW();
            DW();
            J0();
            if (this.VH == 77) {
                DW();
            } else {
                FH(77);
            }
            FH(ProxyTextView.INPUTTYPE_textPostalAddress, 4);
            return;
        }
        Hw();
        throw new es$a();
    }

    private void J0() {
        FH(200, j6(77, 76, 64, 0));
    }

    private void J8() {
        int i = 1;
        Ws();
        VH();
        while (this.VH == 68) {
            DW();
            VH();
            Ws();
            i += 2;
        }
        FH(111, i);
    }

    private void Ws() {
        int i = 0;
        while (this.VH != 68 && this.VH != 76 && this.VH != 0) {
            if (this.VH == 75 && Zo(1) == 2) {
                DW();
                DW();
                FH(151, 2);
                i++;
            } else if (this.VH != 3) {
                DW();
                i++;
            } else {
                Hw();
            }
        }
        if (i != 1 || FH() != 151) {
            FH(150, i);
        }
    }
}
