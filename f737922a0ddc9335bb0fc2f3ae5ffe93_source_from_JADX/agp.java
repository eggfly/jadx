import com.aide.uidesigner.ProxyTextView;

public final class agp implements Cloneable {
    private static final String[] et;
    private static final agp$a[] wc;
    int BT;
    int DW;
    int EQ;
    byte[] FH;
    int Hw;
    int I;
    int J0;
    byte[] J8;
    int KD;
    int Mr;
    int[] Mz;
    int OW;
    int P8;
    short[] QX;
    byte[] Qq;
    int SI;
    agw Sf;
    int U2;
    int VH;
    int Ws;
    int XG;
    short[] XL;
    int XX;
    int Zo;
    int a8;
    int aM;
    int aj;
    int br;
    int ca;
    short[] cb;
    int cn;
    short[] dx;
    agw ef;
    int ei;
    int er;
    short[] g3;
    int gW;
    byte gn;
    int j3;
    agx j6;
    agq jJ;
    int kQ;
    int lg;
    int lp;
    int nw;
    int rN;
    int ro;
    agw sG;
    short[] sh;
    int sy;
    int tp;
    byte u7;
    int v5;
    short[] vJ;
    int vy;
    int we;
    byte[] x9;
    short yO;
    int yS;

    static {
        wc = new agp$a[10];
        wc[0] = new agp$a(0, 0, 0, 0, 0);
        wc[1] = new agp$a(4, 4, 8, 4, 1);
        wc[2] = new agp$a(4, 5, 16, 8, 1);
        wc[3] = new agp$a(4, 6, 32, 32, 1);
        wc[4] = new agp$a(4, 4, 16, 16, 2);
        wc[5] = new agp$a(8, 16, 32, 32, 2);
        wc[6] = new agp$a(8, 16, 128, 128, 2);
        wc[7] = new agp$a(8, 32, 128, 256, 2);
        wc[8] = new agp$a(32, 128, 258, 1024, 2);
        wc[9] = new agp$a(32, 258, 258, 4096, 2);
        et = new String[]{"need dictionary", "stream end", "", "file error", "stream error", "data error", "insufficient memory", "buffer error", "incompatible version", ""};
    }

    agp(agx agx) {
        this.VH = 1;
        this.sG = new agw();
        this.ef = new agw();
        this.Sf = new agw();
        this.vJ = new short[16];
        this.g3 = new short[16];
        this.Mz = new int[573];
        this.x9 = new byte[573];
        this.jJ = null;
        this.j6 = agx;
        this.sh = new short[1146];
        this.cb = new short[122];
        this.dx = new short[78];
    }

    void j6() {
        this.Ws = this.EQ * 2;
        this.XL[this.j3 - 1] = (short) 0;
        for (int i = 0; i < this.j3 - 1; i++) {
            this.XL[i] = (short) 0;
        }
        this.nw = wc[this.SI].DW;
        this.ro = wc[this.SI].j6;
        this.cn = wc[this.SI].FH;
        this.ei = wc[this.SI].Hw;
        this.gW = 0;
        this.lg = 0;
        this.vy = 0;
        this.P8 = 2;
        this.rN = 2;
        this.yS = 0;
        this.aM = 0;
    }

    void DW() {
        this.sG.u7 = this.sh;
        this.sG.EQ = agv.FH;
        this.ef.u7 = this.cb;
        this.ef.EQ = agv.Hw;
        this.Sf.u7 = this.dx;
        this.Sf.EQ = agv.v5;
        this.yO = (short) 0;
        this.XG = 0;
        this.kQ = 8;
        FH();
    }

    void FH() {
        int i;
        for (i = 0; i < 286; i++) {
            this.sh[i * 2] = (short) 0;
        }
        for (i = 0; i < 30; i++) {
            this.cb[i * 2] = (short) 0;
        }
        for (i = 0; i < 19; i++) {
            this.dx[i * 2] = (short) 0;
        }
        this.sh[512] = (short) 1;
        this.br = 0;
        this.OW = 0;
        this.XX = 0;
        this.aj = 0;
    }

    void j6(short[] sArr, int i) {
        int i2 = this.Mz[i];
        int i3 = i << 1;
        while (i3 <= this.I) {
            int i4;
            if (i3 >= this.I || !j6(sArr, this.Mz[i3 + 1], this.Mz[i3], this.x9)) {
                i4 = i3;
            } else {
                i4 = i3 + 1;
            }
            if (j6(sArr, i2, this.Mz[i4], this.x9)) {
                break;
            }
            this.Mz[i] = this.Mz[i4];
            i3 = i4 << 1;
            i = i4;
        }
        this.Mz[i] = i2;
    }

    static boolean j6(short[] sArr, int i, int i2, byte[] bArr) {
        short s = sArr[i * 2];
        short s2 = sArr[i2 * 2];
        return s < s2 || (s == s2 && bArr[i] <= bArr[i2]);
    }

    void DW(short[] sArr, int i) {
        int i2;
        int i3;
        short s = (short) -1;
        short s2 = sArr[1];
        if (s2 == (short) 0) {
            i2 = 138;
            i3 = 3;
        } else {
            i3 = 4;
            i2 = 7;
        }
        sArr[((i + 1) * 2) + 1] = (short) -1;
        int i4 = 0;
        int i5 = 0;
        while (i5 <= i) {
            short s3 = sArr[((i5 + 1) * 2) + 1];
            i4++;
            if (i4 >= i2 || s2 != s3) {
                short[] sArr2;
                if (i4 < i3) {
                    sArr2 = this.dx;
                    i2 = s2 * 2;
                    sArr2[i2] = (short) (i4 + sArr2[i2]);
                } else if (s2 != (short) 0) {
                    if (s2 != s) {
                        sArr2 = this.dx;
                        i2 = s2 * 2;
                        sArr2[i2] = (short) (sArr2[i2] + 1);
                    }
                    sArr2 = this.dx;
                    sArr2[32] = (short) (sArr2[32] + 1);
                } else if (i4 <= 10) {
                    sArr2 = this.dx;
                    sArr2[34] = (short) (sArr2[34] + 1);
                } else {
                    sArr2 = this.dx;
                    sArr2[36] = (short) (sArr2[36] + 1);
                }
                if (s3 == (short) 0) {
                    i2 = 138;
                    i4 = 0;
                    s = s2;
                    i3 = 3;
                } else if (s2 == s3) {
                    i2 = 6;
                    i4 = 0;
                    s = s2;
                    i3 = 3;
                } else {
                    i3 = 4;
                    i2 = 7;
                    i4 = 0;
                    s = s2;
                }
            }
            i5++;
            s2 = s3;
        }
    }

    int Hw() {
        DW(this.sh, this.sG.tp);
        DW(this.cb, this.ef.tp);
        this.Sf.DW(this);
        int i = 18;
        while (i >= 3 && this.dx[(agw.Hw[i] * 2) + 1] == (short) 0) {
            i--;
        }
        this.OW += ((((i + 1) * 3) + 5) + 5) + 4;
        return i;
    }

    void j6(int i, int i2, int i3) {
        j6(i - 257, 5);
        j6(i2 - 1, 5);
        j6(i3 - 4, 4);
        for (int i4 = 0; i4 < i3; i4++) {
            j6(this.dx[(agw.Hw[i4] * 2) + 1], 3);
        }
        FH(this.sh, i - 1);
        FH(this.cb, i2 - 1);
    }

    void FH(short[] sArr, int i) {
        int i2;
        int i3;
        int i4 = -1;
        short s = sArr[1];
        if (s == (short) 0) {
            i2 = 3;
            i3 = 138;
        } else {
            i2 = 4;
            i3 = 7;
        }
        int i5 = i3;
        int i6 = 0;
        i3 = i2;
        i2 = 0;
        while (i6 <= i) {
            int i7;
            short s2 = sArr[((i6 + 1) * 2) + 1];
            i2++;
            if (i2 >= i5 || s != s2) {
                if (i2 < i3) {
                    do {
                        j6((int) s, this.dx);
                        i2--;
                    } while (i2 != 0);
                } else if (s != 0) {
                    if (s != i4) {
                        j6((int) s, this.dx);
                        i2--;
                    }
                    j6(16, this.dx);
                    j6(i2 - 3, 2);
                } else if (i2 <= 10) {
                    j6(17, this.dx);
                    j6(i2 - 3, 3);
                } else {
                    j6(18, this.dx);
                    j6(i2 - 11, 7);
                }
                if (s2 == (short) 0) {
                    i2 = 3;
                    i3 = 138;
                    i5 = 0;
                    i4 = s;
                } else if (s == s2) {
                    i3 = 6;
                    i5 = 0;
                    r8 = s;
                    i2 = 3;
                } else {
                    i2 = 4;
                    i3 = 7;
                    i5 = 0;
                    r8 = s;
                }
            } else {
                i7 = i3;
                i3 = i5;
                i5 = i2;
                i2 = i7;
            }
            i6++;
            s = s2;
            i7 = i5;
            i5 = i3;
            i3 = i2;
            i2 = i7;
        }
    }

    final void j6(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.FH, this.Zo, i2);
        this.Zo += i2;
    }

    final void j6(byte b) {
        byte[] bArr = this.FH;
        int i = this.Zo;
        this.Zo = i + 1;
        bArr[i] = b;
    }

    final void j6(int i) {
        j6((byte) i);
        j6((byte) (i >>> 8));
    }

    final void DW(int i) {
        j6((byte) (i >> 8));
        j6((byte) i);
    }

    final void j6(int i, short[] sArr) {
        int i2 = i * 2;
        j6(sArr[i2] & 65535, sArr[i2 + 1] & 65535);
    }

    void j6(int i, int i2) {
        if (this.XG > 16 - i2) {
            this.yO = (short) (this.yO | ((i << this.XG) & 65535));
            j6(this.yO);
            this.yO = (short) (i >>> (16 - this.XG));
            this.XG += i2 - 16;
            return;
        }
        this.yO = (short) (this.yO | ((i << this.XG) & 65535));
        this.XG += i2;
    }

    void v5() {
        j6(2, 3);
        j6(256, agv.j6);
        VH();
        if (((this.kQ + 1) + 10) - this.XG < 9) {
            j6(2, 3);
            j6(256, agv.j6);
            VH();
        }
        this.kQ = 7;
    }

    boolean DW(int i, int i2) {
        this.FH[this.lp + (this.aj * 2)] = (byte) (i >>> 8);
        this.FH[(this.lp + (this.aj * 2)) + 1] = (byte) i;
        this.Qq[this.aj] = (byte) i2;
        this.aj++;
        if (i == 0) {
            short[] sArr = this.sh;
            int i3 = i2 * 2;
            sArr[i3] = (short) (sArr[i3] + 1);
        } else {
            this.XX++;
            int i4 = i - 1;
            short[] sArr2 = this.sh;
            int i5 = ((agw.Zo[i2] + 256) + 1) * 2;
            sArr2[i5] = (short) (sArr2[i5] + 1);
            sArr2 = this.cb;
            i4 = agw.j6(i4) * 2;
            sArr2[i4] = (short) (sArr2[i4] + 1);
        }
        if ((this.aj & 8191) == 0 && this.SI > 2) {
            i3 = this.aj * 8;
            i5 = this.gW - this.lg;
            for (i4 = 0; i4 < 30; i4++) {
                i3 = (int) (((long) i3) + (((long) this.cb[i4 * 2]) * (5 + ((long) agw.DW[i4]))));
            }
            i4 = i3 >>> 3;
            if (this.XX < this.aj / 2 && i4 < i5 / 2) {
                return true;
            }
        }
        return this.aj == this.sy + -1;
    }

    void j6(short[] sArr, short[] sArr2) {
        int i = 0;
        if (this.aj != 0) {
            do {
                int i2 = ((this.FH[this.lp + (i * 2)] << 8) & 65280) | (this.FH[(this.lp + (i * 2)) + 1] & 255);
                int i3 = this.Qq[i] & 255;
                i++;
                if (i2 == 0) {
                    j6(i3, sArr);
                } else {
                    byte b = agw.Zo[i3];
                    j6((b + 256) + 1, sArr);
                    int i4 = agw.j6[b];
                    if (i4 != 0) {
                        j6(i3 - agw.VH[b], i4);
                    }
                    i2--;
                    i3 = agw.j6(i2);
                    j6(i3, sArr2);
                    int i5 = agw.DW[i3];
                    if (i5 != 0) {
                        j6(i2 - agw.gn[i3], i5);
                    }
                }
            } while (i < this.aj);
        }
        j6(256, sArr);
        this.kQ = sArr[513];
    }

    void Zo() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < 7) {
            i2 += this.sh[i3 * 2];
            i3++;
        }
        int i4 = 0;
        while (i3 < 128) {
            i4 += this.sh[i3 * 2];
            i3++;
        }
        while (i3 < 256) {
            i2 += this.sh[i3 * 2];
            i3++;
        }
        if (i2 <= (i4 >>> 2)) {
            i = 1;
        }
        this.gn = (byte) i;
    }

    void VH() {
        if (this.XG == 16) {
            j6(this.yO);
            this.yO = (short) 0;
            this.XG = 0;
        } else if (this.XG >= 8) {
            j6((byte) this.yO);
            this.yO = (short) (this.yO >>> 8);
            this.XG -= 8;
        }
    }

    void gn() {
        if (this.XG > 8) {
            j6(this.yO);
        } else if (this.XG > 0) {
            j6((byte) this.yO);
        }
        this.yO = (short) 0;
        this.XG = 0;
    }

    void j6(int i, int i2, boolean z) {
        gn();
        this.kQ = 8;
        if (z) {
            j6((short) i2);
            j6((short) (i2 ^ -1));
        }
        j6(this.J8, i, i2);
    }

    void j6(boolean z) {
        FH(this.lg >= 0 ? this.lg : -1, this.gW - this.lg, z);
        this.lg = this.gW;
        this.j6.DW();
    }

    int FH(int i) {
        boolean z;
        int i2 = 1;
        int i3 = 65535;
        if (65535 > this.Hw - 5) {
            i3 = this.Hw - 5;
        }
        while (true) {
            if (this.vy <= 1) {
                u7();
                if (this.vy != 0 || i != 0) {
                    if (this.vy == 0) {
                        break;
                    }
                }
                return 0;
            }
            this.gW += this.vy;
            this.vy = 0;
            int i4 = this.lg + i3;
            if (this.gW == 0 || this.gW >= i4) {
                this.vy = this.gW - i4;
                this.gW = i4;
                j6(false);
                if (this.j6.VH == 0) {
                    return 0;
                }
            }
            if (this.gW - this.lg >= this.EQ - 262) {
                j6(false);
                if (this.j6.VH == 0) {
                    return 0;
                }
            }
        }
        if (i == 4) {
            z = true;
        } else {
            z = false;
        }
        j6(z);
        if (this.j6.VH != 0) {
            if (i == 4) {
                i2 = 3;
            }
            return i2;
        } else if (i == 4) {
            return 2;
        } else {
            return 0;
        }
    }

    void DW(int i, int i2, boolean z) {
        j6((z ? 1 : 0) + 0, 3);
        j6(i, i2, true);
    }

    void FH(int i, int i2, boolean z) {
        int Hw;
        int i3;
        int i4;
        int i5 = 1;
        if (this.SI > 0) {
            if (this.gn == 2) {
                Zo();
            }
            this.sG.DW(this);
            this.ef.DW(this);
            Hw = Hw();
            i3 = ((this.OW + 3) + 7) >>> 3;
            i4 = ((this.br + 3) + 7) >>> 3;
            if (i4 <= i3) {
                i3 = i4;
            }
        } else {
            Hw = i2 + 5;
            i4 = Hw;
            i3 = Hw;
            Hw = 0;
        }
        if (i2 + 4 <= i3 && i != -1) {
            DW(i, i2, z);
        } else if (i4 == i3) {
            if (!z) {
                i5 = 0;
            }
            j6(i5 + 2, 3);
            j6(agv.j6, agv.DW);
        } else {
            if (!z) {
                i5 = 0;
            }
            j6(i5 + 4, 3);
            j6(this.sG.tp + 1, this.ef.tp + 1, Hw + 1);
            j6(this.sh, this.cb);
        }
        FH();
        if (z) {
            gn();
        }
    }

    void u7() {
        do {
            int i;
            int i2 = (this.Ws - this.vy) - this.gW;
            if (i2 == 0 && this.gW == 0 && this.vy == 0) {
                i = this.EQ;
            } else if (i2 == -1) {
                i = i2 - 1;
            } else if (this.gW >= (this.EQ + this.EQ) - 262) {
                int i3;
                System.arraycopy(this.J8, this.EQ, this.J8, 0, this.EQ);
                this.BT -= this.EQ;
                this.gW -= this.EQ;
                this.lg -= this.EQ;
                i = this.j3;
                int i4 = i;
                do {
                    i--;
                    i3 = this.XL[i] & 65535;
                    this.XL[i] = i3 >= this.EQ ? (short) (i3 - this.EQ) : (short) 0;
                    i4--;
                } while (i4 != 0);
                i = this.EQ;
                i4 = i;
                do {
                    short s;
                    i--;
                    i3 = this.QX[i] & 65535;
                    short[] sArr = this.QX;
                    if (i3 >= this.EQ) {
                        s = (short) (i3 - this.EQ);
                    } else {
                        s = (short) 0;
                    }
                    sArr[i] = s;
                    i4--;
                } while (i4 != 0);
                i = this.EQ + i2;
            } else {
                i = i2;
            }
            if (this.j6.FH != 0) {
                this.vy = this.j6.j6(this.J8, this.gW + this.vy, i) + this.vy;
                if (this.vy >= 3) {
                    this.aM = this.J8[this.gW] & 255;
                    this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 1] & 255)) & this.U2;
                }
                if (this.vy >= 262) {
                    return;
                }
            } else {
                return;
            }
        } while (this.j6.FH != 0);
    }

    int Hw(int i) {
        boolean DW;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            int i4;
            boolean z;
            if (this.vy < 262) {
                u7();
                if (this.vy >= 262 || i != 0) {
                    if (this.vy == 0) {
                        break;
                    }
                }
                return 0;
            }
            if (this.vy >= 3) {
                this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 2] & 255)) & this.U2;
                i4 = this.XL[this.aM] & 65535;
                this.QX[this.gW & this.J0] = this.XL[this.aM];
                this.XL[this.aM] = (short) this.gW;
            } else {
                i4 = i3;
            }
            if (!(((long) i4) == 0 || ((this.gW - i4) & 65535) > this.EQ - 262 || this.KD == 2)) {
                this.rN = Zo(i4);
            }
            boolean z2;
            if (this.rN >= 3) {
                DW = DW(this.gW - this.BT, this.rN - 3);
                this.vy -= this.rN;
                if (this.rN > this.nw || this.vy < 3) {
                    this.gW += this.rN;
                    this.rN = 0;
                    this.aM = this.J8[this.gW] & 255;
                    this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 1] & 255)) & this.U2;
                    z2 = DW;
                    i3 = i4;
                    z = z2;
                } else {
                    this.rN--;
                    int i5;
                    do {
                        this.gW++;
                        this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 2] & 255)) & this.U2;
                        i4 = this.XL[this.aM] & 65535;
                        this.QX[this.gW & this.J0] = this.XL[this.aM];
                        this.XL[this.aM] = (short) this.gW;
                        i5 = this.rN - 1;
                        this.rN = i5;
                    } while (i5 != 0);
                    this.gW++;
                    z2 = DW;
                    i3 = i4;
                    z = z2;
                }
            } else {
                DW = DW(0, this.J8[this.gW] & 255);
                this.vy--;
                this.gW++;
                z2 = DW;
                i3 = i4;
                z = z2;
            }
            if (z) {
                j6(false);
                if (this.j6.VH == 0) {
                    return 0;
                }
            }
        }
        if (i == 4) {
            DW = true;
        } else {
            DW = false;
        }
        j6(DW);
        if (this.j6.VH != 0) {
            if (i == 4) {
                i2 = 3;
            }
            return i2;
        } else if (i == 4) {
            return 2;
        } else {
            return 0;
        }
    }

    int v5(int i) {
        boolean z;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            if (this.vy < 262) {
                u7();
                if (this.vy >= 262 || i != 0) {
                    if (this.vy == 0) {
                        break;
                    }
                }
                return 0;
            }
            if (this.vy >= 3) {
                this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 2] & 255)) & this.U2;
                i3 = this.XL[this.aM] & 65535;
                this.QX[this.gW & this.J0] = this.XL[this.aM];
                this.XL[this.aM] = (short) this.gW;
            }
            this.P8 = this.rN;
            this.er = this.BT;
            this.rN = 2;
            if (i3 != 0 && this.P8 < this.nw && ((this.gW - i3) & 65535) <= this.EQ - 262) {
                if (this.KD != 2) {
                    this.rN = Zo(i3);
                }
                if (this.rN <= 5 && (this.KD == 1 || (this.rN == 3 && this.gW - this.BT > 4096))) {
                    this.rN = 2;
                }
            }
            if (this.P8 >= 3 && this.rN <= this.P8) {
                int i4 = (this.gW + this.vy) - 3;
                boolean DW = DW((this.gW - 1) - this.er, this.P8 - 3);
                this.vy -= this.P8 - 1;
                this.P8 -= 2;
                int i5;
                do {
                    i5 = this.gW + 1;
                    this.gW = i5;
                    if (i5 <= i4) {
                        this.aM = ((this.aM << this.a8) ^ (this.J8[this.gW + 2] & 255)) & this.U2;
                        i3 = this.XL[this.aM] & 65535;
                        this.QX[this.gW & this.J0] = this.XL[this.aM];
                        this.XL[this.aM] = (short) this.gW;
                    }
                    i5 = this.P8 - 1;
                    this.P8 = i5;
                } while (i5 != 0);
                this.yS = 0;
                this.rN = 2;
                this.gW++;
                if (DW) {
                    j6(false);
                    if (this.j6.VH == 0) {
                        return 0;
                    }
                } else {
                    continue;
                }
            } else if (this.yS != 0) {
                if (DW(0, this.J8[this.gW - 1] & 255)) {
                    j6(false);
                }
                this.gW++;
                this.vy--;
                if (this.j6.VH == 0) {
                    return 0;
                }
            } else {
                this.yS = 1;
                this.gW++;
                this.vy--;
            }
        }
        if (this.yS != 0) {
            DW(0, this.J8[this.gW - 1] & 255);
            this.yS = 0;
        }
        if (i == 4) {
            z = true;
        } else {
            z = false;
        }
        j6(z);
        if (this.j6.VH != 0) {
            if (i == 4) {
                i2 = 3;
            }
            return i2;
        } else if (i == 4) {
            return 2;
        } else {
            return 0;
        }
    }

    int Zo(int i) {
        int i2;
        byte b;
        int i3 = this.ei;
        int i4 = this.gW;
        int i5 = this.P8;
        int i6 = this.gW > this.EQ + -262 ? this.gW - (this.EQ - 262) : 0;
        int i7 = this.cn;
        int i8 = this.J0;
        int i9 = this.gW + 258;
        byte b2 = this.J8[(i4 + i5) - 1];
        byte b3 = this.J8[i4 + i5];
        if (this.P8 >= this.ro) {
            i3 >>= 2;
        }
        byte b4;
        if (i7 > this.vy) {
            b4 = b3;
            b3 = b2;
            i2 = this.vy;
            i7 = i5;
            i5 = i4;
            i4 = i3;
            b = b4;
        } else {
            b4 = b3;
            b3 = b2;
            i2 = i7;
            i7 = i5;
            i5 = i4;
            i4 = i3;
            b = b4;
        }
        do {
            if (this.J8[i + i7] == b && this.J8[(i + i7) - 1] == r2 && this.J8[i] == this.J8[i5]) {
                int i10 = i + 1;
                if (this.J8[i10] == this.J8[i5 + 1]) {
                    int i11 = i5 + 2;
                    i5 = i10 + 1;
                    do {
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                        i11++;
                        i5++;
                        if (this.J8[i11] != this.J8[i5]) {
                            break;
                        }
                    } while (i11 < i9);
                    i5 = 258 - (i9 - i11);
                    i11 = i9 - 258;
                    if (i5 > i7) {
                        this.BT = i;
                        if (i5 >= i2) {
                            i7 = i5;
                            break;
                        }
                        b3 = this.J8[(i11 + i5) - 1];
                        b = this.J8[i11 + i5];
                        i7 = i5;
                        i5 = i11;
                    } else {
                        i5 = i11;
                    }
                }
            }
            i = this.QX[i & i8] & 65535;
            if (i <= i6) {
                break;
            }
            i4--;
        } while (i4 != 0);
        return i7 <= this.vy ? i7 : this.vy;
    }

    int FH(int i, int i2) {
        return j6(i, 8, i2, 8, 0);
    }

    private int j6(int i, int i2, int i3, int i4, int i5) {
        int i6;
        this.j6.u7 = null;
        if (i == -1) {
            i = 6;
        }
        if (i3 < 0) {
            i6 = 0;
            i3 = -i3;
        } else if (i3 > 15) {
            i3 -= 16;
            this.j6.J0 = new agn();
            i6 = 2;
        } else {
            i6 = 1;
        }
        if (i4 < 1 || i4 > 9 || i2 != 8 || i3 < 9 || i3 > 15 || i < 0 || i > 9 || i5 < 0 || i5 > 2) {
            return -2;
        }
        this.j6.tp = this;
        this.VH = i6;
        this.we = i3;
        this.EQ = 1 << this.we;
        this.J0 = this.EQ - 1;
        this.Mr = i4 + 7;
        this.j3 = 1 << this.Mr;
        this.U2 = this.j3 - 1;
        this.a8 = ((this.Mr + 3) - 1) / 3;
        this.J8 = new byte[(this.EQ * 2)];
        this.QX = new short[this.EQ];
        this.XL = new short[this.j3];
        this.sy = 1 << (i4 + 6);
        this.FH = new byte[(this.sy * 3)];
        this.Hw = this.sy * 3;
        this.lp = this.sy;
        this.Qq = new byte[this.sy];
        this.SI = i;
        this.KD = i5;
        this.u7 = (byte) i2;
        return tp();
    }

    int tp() {
        agx agx = this.j6;
        this.j6.gn = 0;
        agx.Hw = 0;
        this.j6.u7 = null;
        this.j6.we = 2;
        this.Zo = 0;
        this.v5 = 0;
        if (this.VH < 0) {
            this.VH = -this.VH;
        }
        this.DW = this.VH == 0 ? ProxyTextView.INPUTTYPE_textPostalAddress : 42;
        this.j6.J0.j6();
        this.tp = 0;
        DW();
        j6();
        return 0;
    }

    int VH(int i) {
        if (i > 4 || i < 0) {
            return -2;
        }
        if (this.j6.v5 == null || ((this.j6.j6 == null && this.j6.FH != 0) || (this.DW == 666 && i != 4))) {
            this.j6.u7 = et[4];
            return -2;
        } else if (this.j6.VH == 0) {
            this.j6.u7 = et[7];
            return -5;
        } else {
            int i2;
            int i3 = this.tp;
            this.tp = i;
            if (this.DW == 42) {
                if (this.VH == 2) {
                    EQ().j6(this);
                    this.DW = ProxyTextView.INPUTTYPE_textPostalAddress;
                    this.j6.J0.j6();
                } else {
                    int i4 = (((this.we - 8) << 4) + 8) << 8;
                    i2 = ((this.SI - 1) & 255) >> 1;
                    if (i2 > 3) {
                        i2 = 3;
                    }
                    i2 = (i2 << 6) | i4;
                    if (this.gW != 0) {
                        i2 |= 32;
                    }
                    i2 += 31 - (i2 % 31);
                    this.DW = ProxyTextView.INPUTTYPE_textPostalAddress;
                    DW(i2);
                    if (this.gW != 0) {
                        long DW = this.j6.J0.DW();
                        DW((int) (DW >>> 16));
                        DW((int) (DW & 65535));
                    }
                    this.j6.J0.j6();
                }
            }
            if (this.Zo != 0) {
                this.j6.DW();
                if (this.j6.VH == 0) {
                    this.tp = -1;
                    return 0;
                }
            } else if (this.j6.FH == 0 && i <= i3 && i != 4) {
                this.j6.u7 = et[7];
                return -5;
            }
            if (this.DW != 666 || this.j6.FH == 0) {
                if (!(this.j6.FH == 0 && this.vy == 0 && (i == 0 || this.DW == 666))) {
                    switch (wc[this.SI].v5) {
                        case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                            i2 = FH(i);
                            break;
                        case ProxyTextView.TYPEFACE_SANS /*1*/:
                            i2 = Hw(i);
                            break;
                        case ProxyTextView.TYPEFACE_SERIF /*2*/:
                            i2 = v5(i);
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    if (i2 == 2 || i2 == 3) {
                        this.DW = 666;
                    }
                    if (i2 == 0 || i2 == 2) {
                        if (this.j6.VH != 0) {
                            return 0;
                        }
                        this.tp = -1;
                        return 0;
                    } else if (i2 == 1) {
                        if (i == 1) {
                            v5();
                        } else {
                            DW(0, 0, false);
                            if (i == 3) {
                                for (i2 = 0; i2 < this.j3; i2++) {
                                    this.XL[i2] = (short) 0;
                                }
                            }
                        }
                        this.j6.DW();
                        if (this.j6.VH == 0) {
                            this.tp = -1;
                            return 0;
                        }
                    }
                }
                if (i != 4) {
                    return 0;
                }
                if (this.VH <= 0) {
                    return 1;
                }
                long DW2;
                if (this.VH == 2) {
                    DW2 = this.j6.J0.DW();
                    j6((byte) ((int) (DW2 & 255)));
                    j6((byte) ((int) ((DW2 >> 8) & 255)));
                    j6((byte) ((int) ((DW2 >> 16) & 255)));
                    j6((byte) ((int) ((DW2 >> 24) & 255)));
                    j6((byte) ((int) (this.j6.Hw & 255)));
                    j6((byte) ((int) ((this.j6.Hw >> 8) & 255)));
                    j6((byte) ((int) ((this.j6.Hw >> 16) & 255)));
                    j6((byte) ((int) ((this.j6.Hw >> 24) & 255)));
                    EQ().j6(DW2);
                } else {
                    DW2 = this.j6.J0.DW();
                    DW((int) (DW2 >>> 16));
                    DW((int) (DW2 & 65535));
                }
                this.j6.DW();
                if (this.VH > 0) {
                    this.VH = -this.VH;
                }
                if (this.Zo == 0) {
                    return 1;
                }
                return 0;
            }
            this.j6.u7 = et[7];
            return -5;
        }
    }

    public Object clone() {
        agp agp = (agp) super.clone();
        agp.FH = j6(agp.FH);
        agp.lp = agp.lp;
        agp.Qq = j6(agp.Qq);
        agp.J8 = j6(agp.J8);
        agp.QX = j6(agp.QX);
        agp.XL = j6(agp.XL);
        agp.sh = j6(agp.sh);
        agp.cb = j6(agp.cb);
        agp.dx = j6(agp.dx);
        agp.vJ = j6(agp.vJ);
        agp.g3 = j6(agp.g3);
        agp.Mz = j6(agp.Mz);
        agp.x9 = j6(agp.x9);
        agp.sG.u7 = agp.sh;
        agp.ef.u7 = agp.cb;
        agp.Sf.u7 = agp.dx;
        if (agp.jJ != null) {
            agp.jJ = (agq) agp.jJ.clone();
        }
        return agp;
    }

    private byte[] j6(byte[] bArr) {
        Object obj = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj, 0, obj.length);
        return obj;
    }

    private short[] j6(short[] sArr) {
        Object obj = new short[sArr.length];
        System.arraycopy(sArr, 0, obj, 0, obj.length);
        return obj;
    }

    private int[] j6(int[] iArr) {
        Object obj = new int[iArr.length];
        System.arraycopy(iArr, 0, obj, 0, obj.length);
        return obj;
    }

    synchronized agq EQ() {
        if (this.jJ == null) {
            this.jJ = new agq();
        }
        return this.jJ;
    }
}
