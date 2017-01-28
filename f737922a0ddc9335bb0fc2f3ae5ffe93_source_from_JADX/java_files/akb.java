import org.eclipse.jgit.JGitText;

final class akb<S extends akh> {
    private final ajy<S> DW;
    private int[] EQ;
    private final ajx<S> FH;
    private final ajx<S> Hw;
    private ajv J0;
    private int J8;
    private final int VH;
    private boolean Ws;
    private final int[] Zo;
    private long[] gn;
    private final int j6;
    private int[] tp;
    private int u7;
    private final ajv v5;
    private int we;

    akb(int i, ajy<S> ajy_S, ajx<S> ajx_S, ajx<S> ajx_S2, ajv ajv) {
        this.j6 = i;
        this.DW = ajy_S;
        this.FH = ajx_S;
        this.Hw = ajx_S2;
        this.v5 = ajv;
        if (this.v5.DW >= 268435455) {
            throw new IllegalArgumentException(JGitText.j6().sequenceTooLargeForDiffAlgorithm);
        }
        int VH = ajv.VH();
        int DW = DW(VH);
        this.Zo = new int[(1 << DW)];
        this.VH = 32 - DW;
        this.we = ajv.j6;
        this.gn = new long[Math.max(4, VH >>> 3)];
        this.tp = new int[VH];
        this.EQ = new int[VH];
    }

    ajv j6() {
        if (!DW()) {
            return null;
        }
        this.J0 = new ajv(0, 0);
        this.J8 = this.j6 + 1;
        int i = this.v5.FH;
        while (i < this.v5.Hw) {
            i = j6(i);
        }
        ajv ajv = (!this.Ws || this.j6 >= this.J8) ? this.J0 : null;
        return ajv;
    }

    private boolean DW() {
        for (int i = this.v5.DW - 1; this.v5.j6 <= i; i--) {
            int j6 = j6(this.FH, i);
            int i2 = this.Zo[j6];
            int i3 = 0;
            while (i2 != 0) {
                int FH;
                long j = this.gn[i2];
                if (this.DW.j6(this.FH, DW(j), this.FH, i)) {
                    FH = FH(j) + 1;
                    if (255 < FH) {
                        FH = 255;
                    }
                    this.gn[i2] = j6(j6(j), i, FH);
                    this.tp[i - this.we] = DW(j);
                    this.EQ[i - this.we] = i2;
                } else {
                    i3++;
                    i2 = j6(j);
                }
            }
            if (i3 == this.j6) {
                return false;
            }
            FH = this.u7 + 1;
            this.u7 = FH;
            if (FH == this.gn.length) {
                Object obj = new long[Math.min(this.gn.length << 1, this.v5.VH() + 1)];
                System.arraycopy(this.gn, 0, obj, 0, this.gn.length);
                this.gn = obj;
            }
            this.gn[FH] = j6(this.Zo[j6], i, 1);
            this.EQ[i - this.we] = FH;
            this.Zo[j6] = FH;
        }
        return true;
    }

    private int j6(int i) {
        int i2 = i + 1;
        int i3 = this.Zo[j6(this.Hw, i)];
        while (i3 != 0) {
            long j = this.gn[i3];
            if (FH(j) <= this.J8) {
                i3 = DW(j);
                if (this.DW.j6(this.FH, i3, this.Hw, i)) {
                    this.Ws = true;
                    while (true) {
                        int i4 = this.tp[i3 - this.we];
                        int i5 = i3 + 1;
                        int i6 = i + 1;
                        int i7 = i3;
                        i3 = FH(j);
                        int i8 = i;
                        while (this.v5.j6 < i7 && this.v5.FH < i8 && this.DW.j6(this.FH, i7 - 1, this.Hw, i8 - 1)) {
                            i7--;
                            i8--;
                            if (1 < i3) {
                                i3 = Math.min(i3, FH(this.gn[this.EQ[i7 - this.we]]));
                            }
                        }
                        while (i5 < this.v5.DW && i6 < this.v5.Hw && this.DW.j6(this.FH, i5, this.Hw, i6)) {
                            if (1 < i3) {
                                i3 = Math.min(i3, FH(this.gn[this.EQ[i5 - this.we]]));
                            }
                            i5++;
                            i6++;
                        }
                        if (i2 < i6) {
                            i2 = i6;
                        }
                        if (this.J0.VH() < i5 - i7 || i3 < this.J8) {
                            this.J0.j6 = i7;
                            this.J0.FH = i8;
                            this.J0.DW = i5;
                            this.J0.Hw = i6;
                            this.J8 = i3;
                        }
                        if (i4 == 0) {
                            break;
                        }
                        i3 = i4;
                        while (i3 < i5) {
                            i3 = this.tp[i3 - this.we];
                            if (i3 == 0) {
                                break;
                            }
                        }
                    }
                }
            } else if (!this.Ws) {
                this.Ws = this.DW.j6(this.FH, DW(j), this.Hw, i);
            }
            i3 = j6(j);
        }
        return i2;
    }

    private int j6(ajx<S> ajx_S, int i) {
        return (this.DW.j6((ajx) ajx_S, i) * -1640562687) >>> this.VH;
    }

    private static long j6(int i, int i2, int i3) {
        return ((((long) i) << 36) | (((long) i2) << 8)) | ((long) i3);
    }

    private static int j6(long j) {
        return (int) (j >>> 36);
    }

    private static int DW(long j) {
        return ((int) (j >>> 8)) & 268435455;
    }

    private static int FH(long j) {
        return ((int) j) & 255;
    }

    private static int DW(int i) {
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        if ((1 << numberOfLeadingZeros) < i) {
            return numberOfLeadingZeros + 1;
        }
        return numberOfLeadingZeros;
    }
}
