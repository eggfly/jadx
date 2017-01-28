public class awb extends awc {
    private static final int FH;
    private boolean Hw;
    private avx v5;

    static {
        FH = anl.j6.FH();
    }

    public awb(aoh aoh) {
        this(aoh.v5());
    }

    public awb(any any) {
        super(any);
    }

    avx j6() {
        while (true) {
            avx XL = XL();
            if (this.Hw) {
                return XL;
            }
            if (!FH(XL)) {
                return v5(XL);
            }
            if (!Hw(XL)) {
                return XL;
            }
            for (avx avx : this.j6) {
                if (avx.VH == XL) {
                    avx.j6(1);
                    avx.VH = null;
                }
            }
        }
    }

    private avx XL() {
        this.Hw = true;
        avx avx = this.j6[0];
        int i = 0;
        while (avx.u7()) {
            i++;
            if (i >= this.j6.length) {
                break;
            }
            avx = this.j6[i];
        }
        if (avx.u7()) {
            return avx;
        }
        avx.VH = avx;
        int i2 = i;
        avx avx2 = avx;
        boolean z = false;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= this.j6.length) {
                break;
            }
            avx avx3 = this.j6[i3];
            if (avx3.u7()) {
                i2 = i3;
            } else {
                int j6 = avx3.j6(avx2);
                if (j6 < 0) {
                    if (this.Hw && FH(avx2) && !FH(avx3) && j6(avx2, avx3)) {
                        avx3.VH = avx2;
                        z = true;
                        i2 = i3;
                    } else {
                        this.Hw = false;
                        avx3.VH = avx3;
                        avx2 = avx3;
                        i2 = i3;
                    }
                } else if (j6 == 0) {
                    avx3.VH = avx2;
                    i2 = i3;
                } else if (this.Hw && FH(avx3) && !FH(avx2) && j6(avx3, avx2)) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        avx avx4 = this.j6[i4];
                        if (avx4.VH == avx2) {
                            avx4.VH = avx3;
                        }
                    }
                    avx3.VH = avx3;
                    z = true;
                    avx2 = avx3;
                    i2 = i3;
                } else {
                    this.Hw = false;
                    i2 = i3;
                }
            }
        }
        if (z && this.Hw && this.v5 == null) {
            this.v5 = avx2;
        }
        return avx2;
    }

    private static boolean j6(avx avx, avx avx2) {
        return avx.j6(avx2, FH) == 0;
    }

    private static boolean FH(avx avx) {
        return anl.j6.DW(avx.u7);
    }

    private boolean Hw(avx avx) {
        for (avx avx2 : this.j6) {
            if (!(avx2.VH == avx || avx2.gn())) {
                int i = 0;
                do {
                    i++;
                    avx2.DW(1);
                    int j6 = avx2.j6(avx, 0);
                    if (j6 != 0) {
                        if (j6 < 0) {
                            break;
                        }
                    } else {
                        avx2.j6(i);
                        return true;
                    }
                } while (!avx2.gn());
                avx2.j6(i);
            }
        }
        return false;
    }

    private avx v5(avx avx) {
        avx avx2 = null;
        for (avx avx3 : this.j6) {
            if (!(avx3.VH == avx || avx3.u7())) {
                do {
                    int j6 = avx3.j6(avx, FH);
                    if (j6 < 0) {
                        avx3.gn++;
                        avx3.j6(1);
                    } else if (j6 == 0) {
                        avx3.VH = avx;
                        avx2 = avx3;
                    } else if (avx3.gn != 0) {
                        avx3.DW(avx3.gn);
                        avx3.gn = 0;
                    }
                } while (!avx3.u7());
                avx3.DW(avx3.gn);
                avx3.gn = 0;
            }
        }
        if (avx2 == null) {
            return avx;
        }
        for (avx avx4 : this.j6) {
            if (avx4.VH == avx) {
                avx4.VH = avx2;
            }
        }
        if (this.v5 != null) {
            return avx2;
        }
        this.v5 = avx2;
        return avx2;
    }

    void DW() {
        avx avx = this.DW;
        for (avx avx2 : this.j6) {
            if (avx2.VH == avx) {
                if (avx2.gn == 0) {
                    avx2.j6(1);
                } else {
                    avx2.DW(avx2.gn);
                    avx2.gn = 0;
                }
                avx2.VH = null;
            }
        }
        if (avx == this.v5) {
            this.v5 = null;
        }
    }

    void FH() {
        avx avx = this.DW;
        for (avx avx2 : this.j6) {
            if (avx2.VH == avx) {
                if (avx2.gn == 0) {
                    avx2.j6();
                } else {
                    avx2.DW(avx2.gn);
                    avx2.gn = 0;
                }
                avx2.VH = null;
            }
        }
        if (avx == this.v5) {
            this.v5 = null;
        }
    }

    public boolean Hw() {
        return this.v5 != null;
    }
}
