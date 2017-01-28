public class bez extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    private int j6;
    private int tp;
    private int[] u7;
    private int v5;

    public bez() {
        this.u7 = new int[16];
        FH();
    }

    public String j6() {
        return "RIPEMD256";
    }

    public int DW() {
        return 32;
    }

    protected void DW(byte[] bArr, int i) {
        int[] iArr = this.u7;
        int i2 = this.tp;
        this.tp = i2 + 1;
        iArr[i2] = (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
        if (this.tp == 16) {
            v5();
        }
    }

    protected void j6(long j) {
        if (this.tp > 14) {
            v5();
        }
        this.u7[14] = (int) (-1 & j);
        this.u7[15] = (int) (j >>> 32);
    }

    private void j6(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    public int j6(byte[] bArr, int i) {
        Hw();
        j6(this.j6, bArr, i);
        j6(this.DW, bArr, i + 4);
        j6(this.FH, bArr, i + 8);
        j6(this.Hw, bArr, i + 12);
        j6(this.v5, bArr, i + 16);
        j6(this.Zo, bArr, i + 20);
        j6(this.VH, bArr, i + 24);
        j6(this.gn, bArr, i + 28);
        FH();
        return 32;
    }

    public void FH() {
        super.FH();
        this.j6 = 1732584193;
        this.DW = -271733879;
        this.FH = -1732584194;
        this.Hw = 271733878;
        this.v5 = 1985229328;
        this.Zo = -19088744;
        this.VH = -1985229329;
        this.gn = 19088743;
        this.tp = 0;
        for (int i = 0; i != this.u7.length; i++) {
            this.u7[i] = 0;
        }
    }

    private int j6(int i, int i2) {
        return (i << i2) | (i >>> (32 - i2));
    }

    private int j6(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int DW(int i, int i2, int i3) {
        return (i & i2) | ((i ^ -1) & i3);
    }

    private int FH(int i, int i2, int i3) {
        return ((i2 ^ -1) | i) ^ i3;
    }

    private int Hw(int i, int i2, int i3) {
        return (i & i3) | ((i3 ^ -1) & i2);
    }

    private int j6(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6((j6(i2, i3, i4) + i) + i5, i6);
    }

    private int DW(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((DW(i2, i3, i4) + i) + i5) + 1518500249, i6);
    }

    private int FH(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((FH(i2, i3, i4) + i) + i5) + 1859775393, i6);
    }

    private int Hw(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((Hw(i2, i3, i4) + i) + i5) - 1894007588, i6);
    }

    private int v5(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6((j6(i2, i3, i4) + i) + i5, i6);
    }

    private int Zo(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((DW(i2, i3, i4) + i) + i5) + 1836072691, i6);
    }

    private int VH(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((FH(i2, i3, i4) + i) + i5) + 1548603684, i6);
    }

    private int gn(int i, int i2, int i3, int i4, int i5, int i6) {
        return j6(((Hw(i2, i3, i4) + i) + i5) + 1352829926, i6);
    }

    protected void v5() {
        int i = this.j6;
        int i2 = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        int i5 = this.v5;
        int i6 = this.Zo;
        int i7 = this.VH;
        int i8 = this.gn;
        int j6 = j6(i, i2, i3, i4, this.u7[0], 11);
        int j62 = j6(i4, j6, i2, i3, this.u7[1], 14);
        int j63 = j6(i3, j62, j6, i2, this.u7[2], 15);
        int j64 = j6(i2, j63, j62, j6, this.u7[3], 12);
        int j65 = j6(j6, j64, j63, j62, this.u7[4], 5);
        int j66 = j6(j62, j65, j64, j63, this.u7[5], 8);
        i2 = j6(j63, j66, j65, j64, this.u7[6], 7);
        int j67 = j6(j64, i2, j66, j65, this.u7[7], 9);
        int j68 = j6(j65, j67, i2, j66, this.u7[8], 11);
        j64 = j6(j66, j68, j67, i2, this.u7[9], 13);
        i2 = j6(i2, j64, j68, j67, this.u7[10], 14);
        j63 = j6(j67, i2, j64, j68, this.u7[11], 15);
        j68 = j6(j68, j63, i2, j64, this.u7[12], 6);
        i3 = j6(j64, j68, j63, i2, this.u7[13], 7);
        j62 = j6(i2, i3, j68, j63, this.u7[14], 9);
        j63 = j6(j63, j62, i3, j68, this.u7[15], 8);
        int gn = gn(i5, i6, i7, i8, this.u7[5], 8);
        int gn2 = gn(i8, gn, i6, i7, this.u7[14], 9);
        i5 = gn(i7, gn2, gn, i6, this.u7[7], 9);
        int gn3 = gn(i6, i5, gn2, gn, this.u7[0], 11);
        int gn4 = gn(gn, gn3, i5, gn2, this.u7[9], 13);
        i8 = gn(gn2, gn4, gn3, i5, this.u7[2], 15);
        int gn5 = gn(i5, i8, gn4, gn3, this.u7[11], 15);
        i6 = gn(gn3, gn5, i8, gn4, this.u7[4], 5);
        i7 = gn(gn4, i6, gn5, i8, this.u7[13], 7);
        gn2 = gn(i8, i7, i6, gn5, this.u7[6], 7);
        i5 = gn(gn5, gn2, i7, i6, this.u7[15], 8);
        int gn6 = gn(i6, i5, gn2, i7, this.u7[8], 11);
        gn4 = gn(i7, gn6, i5, gn2, this.u7[1], 14);
        i8 = gn(gn2, gn4, gn6, i5, this.u7[10], 14);
        int gn7 = gn(i5, i8, gn4, gn6, this.u7[3], 12);
        gn6 = gn(gn6, gn7, i8, gn4, this.u7[12], 6);
        i4 = DW(gn4, j63, j62, i3, this.u7[7], 7);
        gn = DW(i3, i4, j63, j62, this.u7[4], 6);
        int DW = DW(j62, gn, i4, j63, this.u7[13], 8);
        j63 = DW(j63, DW, gn, i4, this.u7[1], 13);
        gn3 = DW(i4, j63, DW, gn, this.u7[10], 11);
        int DW2 = DW(gn, gn3, j63, DW, this.u7[6], 9);
        j62 = DW(DW, DW2, gn3, j63, this.u7[15], 7);
        gn5 = DW(j63, j62, DW2, gn3, this.u7[3], 15);
        int DW3 = DW(gn3, gn5, j62, DW2, this.u7[12], 7);
        DW2 = DW(DW2, DW3, gn5, j62, this.u7[0], 12);
        DW = DW(j62, DW2, DW3, gn5, this.u7[9], 15);
        i2 = DW(gn5, DW, DW2, DW3, this.u7[5], 9);
        j63 = DW(DW3, i2, DW, DW2, this.u7[2], 11);
        DW2 = DW(DW2, j63, i2, DW, this.u7[14], 7);
        i3 = DW(DW, DW2, j63, i2, this.u7[11], 13);
        int DW4 = DW(i2, i3, DW2, j63, this.u7[8], 12);
        i7 = VH(j68, gn6, gn7, i8, this.u7[6], 9);
        j66 = VH(i8, i7, gn6, gn7, this.u7[11], 13);
        j68 = VH(gn7, j66, i7, gn6, this.u7[3], 15);
        gn6 = VH(gn6, j68, j66, i7, this.u7[7], 7);
        j65 = VH(i7, gn6, j68, j66, this.u7[0], 12);
        j67 = VH(j66, j65, gn6, j68, this.u7[13], 8);
        gn3 = VH(j68, j67, j65, gn6, this.u7[5], 9);
        j64 = VH(gn6, gn3, j67, j65, this.u7[10], 11);
        int VH = VH(j65, j64, gn3, j67, this.u7[14], 7);
        gn5 = VH(j67, VH, j64, gn3, this.u7[15], 7);
        j68 = VH(gn3, gn5, VH, j64, this.u7[8], 12);
        gn = VH(j64, j68, gn5, VH, this.u7[12], 7);
        gn2 = VH(VH, gn, j68, gn5, this.u7[4], 6);
        j67 = VH(gn5, gn2, gn, j68, this.u7[9], 15);
        gn3 = VH(j68, j67, gn2, gn, this.u7[1], 13);
        j62 = VH(gn, gn3, j67, gn2, this.u7[2], 11);
        DW3 = FH(j63, j62, i3, DW2, this.u7[3], 11);
        i4 = FH(DW2, DW3, j62, i3, this.u7[10], 13);
        j6 = FH(i3, i4, DW3, j62, this.u7[14], 6);
        int FH = FH(j62, j6, i4, DW3, this.u7[4], 7);
        j63 = FH(DW3, FH, j6, i4, this.u7[9], 14);
        DW2 = FH(i4, j63, FH, j6, this.u7[15], 9);
        int FH2 = FH(j6, DW2, j63, FH, this.u7[8], 13);
        j62 = FH(FH, FH2, DW2, j63, this.u7[1], 15);
        DW3 = FH(j63, j62, FH2, DW2, this.u7[2], 14);
        int FH3 = FH(DW2, DW3, j62, FH2, this.u7[7], 8);
        j6 = FH(FH2, FH3, DW3, j62, this.u7[0], 13);
        FH = FH(j62, j6, FH3, DW3, this.u7[6], 6);
        int FH4 = FH(DW3, FH, j6, FH3, this.u7[13], 5);
        DW2 = FH(FH3, FH4, FH, j6, this.u7[11], 12);
        FH2 = FH(j6, DW2, FH4, FH, this.u7[5], 7);
        int FH5 = FH(FH, FH2, DW2, FH4, this.u7[12], 5);
        VH = Zo(gn2, DW4, gn3, j67, this.u7[15], 9);
        gn5 = Zo(j67, VH, DW4, gn3, this.u7[5], 7);
        j68 = Zo(gn3, gn5, VH, DW4, this.u7[1], 15);
        gn = Zo(DW4, j68, gn5, VH, this.u7[3], 11);
        gn2 = Zo(VH, gn, j68, gn5, this.u7[7], 8);
        j67 = Zo(gn5, gn2, gn, j68, this.u7[14], 6);
        gn3 = Zo(j68, j67, gn2, gn, this.u7[6], 6);
        gn4 = Zo(gn, gn3, j67, gn2, this.u7[9], 14);
        VH = Zo(gn2, gn4, gn3, j67, this.u7[11], 12);
        gn5 = Zo(j67, VH, gn4, gn3, this.u7[8], 13);
        i6 = Zo(gn3, gn5, VH, gn4, this.u7[12], 5);
        gn = Zo(gn4, i6, gn5, VH, this.u7[2], 14);
        gn2 = Zo(VH, gn, i6, gn5, this.u7[10], 13);
        i5 = Zo(gn5, gn2, gn, i6, this.u7[0], 13);
        gn3 = Zo(i6, i5, gn2, gn, this.u7[4], 7);
        gn4 = Zo(gn, gn3, i5, gn2, this.u7[13], 5);
        i2 = Hw(FH4, FH5, gn3, DW2, this.u7[1], 11);
        j63 = Hw(DW2, i2, FH5, gn3, this.u7[9], 12);
        int Hw = Hw(gn3, j63, i2, FH5, this.u7[11], 14);
        i3 = Hw(FH5, Hw, j63, i2, this.u7[10], 15);
        j62 = Hw(i2, i3, Hw, j63, this.u7[0], 14);
        int Hw2 = Hw(j63, j62, i3, Hw, this.u7[8], 15);
        i4 = Hw(Hw, Hw2, j62, i3, this.u7[12], 9);
        j6 = Hw(i3, i4, Hw2, j62, this.u7[4], 8);
        int Hw3 = Hw(j62, j6, i4, Hw2, this.u7[13], 9);
        j63 = Hw(Hw2, Hw3, j6, i4, this.u7[3], 14);
        j66 = Hw(i4, j63, Hw3, j6, this.u7[7], 5);
        int Hw4 = Hw(j6, j66, j63, Hw3, this.u7[15], 6);
        j62 = Hw(Hw3, Hw4, j66, j63, this.u7[14], 8);
        j65 = Hw(j63, j62, Hw4, j66, this.u7[5], 6);
        int Hw5 = Hw(j66, j65, j62, Hw4, this.u7[6], 5);
        DW4 = Hw(Hw4, Hw5, j65, j62, this.u7[2], 12);
        i8 = v5(gn2, gn4, FH2, i5, this.u7[8], 15);
        FH3 = v5(i5, i8, gn4, FH2, this.u7[6], 5);
        i6 = v5(FH2, FH3, i8, gn4, this.u7[4], 8);
        i7 = v5(gn4, i6, FH3, i8, this.u7[1], 11);
        FH4 = v5(i8, i7, i6, FH3, this.u7[3], 14);
        i5 = v5(FH3, FH4, i7, i6, this.u7[11], 14);
        gn6 = v5(i6, i5, FH4, i7, this.u7[15], 6);
        FH5 = v5(i7, gn6, i5, FH4, this.u7[0], 14);
        i8 = v5(FH4, FH5, gn6, i5, this.u7[5], 6);
        gn7 = v5(i5, i8, FH5, gn6, this.u7[12], 9);
        i6 = v5(gn6, gn7, i8, FH5, this.u7[2], 12);
        i7 = v5(FH5, i6, gn7, i8, this.u7[13], 9);
        int v5 = v5(i8, i7, i6, gn7, this.u7[9], 12);
        i5 = v5(gn7, v5, i7, i6, this.u7[7], 5);
        gn6 = v5(i6, i5, v5, i7, this.u7[10], 15);
        i = v5(i7, gn6, i5, v5, this.u7[14], 8);
        this.j6 += j62;
        this.DW = DW4 + this.DW;
        this.FH += Hw5;
        this.Hw += i5;
        this.v5 += v5;
        this.Zo += i;
        this.VH += gn6;
        this.gn += j65;
        this.tp = 0;
        for (DW4 = 0; DW4 != this.u7.length; DW4++) {
            this.u7[DW4] = 0;
        }
    }
}
