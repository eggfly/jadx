public class bex extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    private int j6;
    private int[] v5;

    public bex() {
        this.v5 = new int[16];
        FH();
    }

    public String j6() {
        return "RIPEMD128";
    }

    public int DW() {
        return 16;
    }

    protected void DW(byte[] bArr, int i) {
        int[] iArr = this.v5;
        int i2 = this.Zo;
        this.Zo = i2 + 1;
        iArr[i2] = (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
        if (this.Zo == 16) {
            v5();
        }
    }

    protected void j6(long j) {
        if (this.Zo > 14) {
            v5();
        }
        this.v5[14] = (int) (-1 & j);
        this.v5[15] = (int) (j >>> 32);
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
        FH();
        return 16;
    }

    public void FH() {
        super.FH();
        this.j6 = 1732584193;
        this.DW = -271733879;
        this.FH = -1732584194;
        this.Hw = 271733878;
        this.Zo = 0;
        for (int i = 0; i != this.v5.length; i++) {
            this.v5[i] = 0;
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
        int j6 = j6(i, i2, i3, i4, this.v5[0], 11);
        int j62 = j6(i4, j6, i2, i3, this.v5[1], 14);
        int j63 = j6(i3, j62, j6, i2, this.v5[2], 15);
        int j64 = j6(i2, j63, j62, j6, this.v5[3], 12);
        int j65 = j6(j6, j64, j63, j62, this.v5[4], 5);
        int j66 = j6(j62, j65, j64, j63, this.v5[5], 8);
        int j67 = j6(j63, j66, j65, j64, this.v5[6], 7);
        int j68 = j6(j64, j67, j66, j65, this.v5[7], 9);
        int j69 = j6(j65, j68, j67, j66, this.v5[8], 11);
        j62 = j6(j66, j69, j68, j67, this.v5[9], 13);
        j63 = j6(j67, j62, j69, j68, this.v5[10], 14);
        int j610 = j6(j68, j63, j62, j69, this.v5[11], 15);
        j65 = j6(j69, j610, j63, j62, this.v5[12], 6);
        j66 = j6(j62, j65, j610, j63, this.v5[13], 7);
        int j611 = j6(j63, j66, j65, j610, this.v5[14], 9);
        j68 = j6(j610, j611, j66, j65, this.v5[15], 8);
        j69 = DW(j65, j68, j611, j66, this.v5[7], 7);
        int DW = DW(j66, j69, j68, j611, this.v5[4], 6);
        j63 = DW(j611, DW, j69, j68, this.v5[13], 8);
        j610 = DW(j68, j63, DW, j69, this.v5[1], 13);
        int DW2 = DW(j69, j610, j63, DW, this.v5[10], 11);
        j66 = DW(DW, DW2, j610, j63, this.v5[6], 9);
        j611 = DW(j63, j66, DW2, j610, this.v5[15], 7);
        int DW3 = DW(j610, j611, j66, DW2, this.v5[3], 15);
        j69 = DW(DW2, DW3, j611, j66, this.v5[12], 7);
        DW = DW(j66, j69, DW3, j611, this.v5[0], 12);
        int DW4 = DW(j611, DW, j69, DW3, this.v5[9], 15);
        j610 = DW(DW3, DW4, DW, j69, this.v5[5], 9);
        DW2 = DW(j69, j610, DW4, DW, this.v5[2], 11);
        int DW5 = DW(DW, DW2, j610, DW4, this.v5[14], 7);
        j611 = DW(DW4, DW5, DW2, j610, this.v5[11], 13);
        DW3 = DW(j610, j611, DW5, DW2, this.v5[8], 12);
        int FH = FH(DW2, DW3, j611, DW5, this.v5[3], 11);
        DW = FH(DW5, FH, DW3, j611, this.v5[10], 13);
        DW4 = FH(j611, DW, FH, DW3, this.v5[14], 6);
        int FH2 = FH(DW3, DW4, DW, FH, this.v5[4], 7);
        DW2 = FH(FH, FH2, DW4, DW, this.v5[9], 14);
        DW5 = FH(DW, DW2, FH2, DW4, this.v5[15], 9);
        int FH3 = FH(DW4, DW5, DW2, FH2, this.v5[8], 13);
        DW3 = FH(FH2, FH3, DW5, DW2, this.v5[1], 15);
        FH = FH(DW2, DW3, FH3, DW5, this.v5[2], 14);
        int FH4 = FH(DW5, FH, DW3, FH3, this.v5[7], 8);
        DW4 = FH(FH3, FH4, FH, DW3, this.v5[0], 13);
        FH2 = FH(DW3, DW4, FH4, FH, this.v5[6], 6);
        int FH5 = FH(FH, FH2, DW4, FH4, this.v5[13], 5);
        DW5 = FH(FH4, FH5, FH2, DW4, this.v5[11], 12);
        FH3 = FH(DW4, DW5, FH5, FH2, this.v5[5], 7);
        int FH6 = FH(FH2, FH3, DW5, FH5, this.v5[12], 5);
        FH = Hw(FH5, FH6, FH3, DW5, this.v5[1], 11);
        FH4 = Hw(DW5, FH, FH6, FH3, this.v5[9], 12);
        int Hw = Hw(FH3, FH4, FH, FH6, this.v5[11], 14);
        FH2 = Hw(FH6, Hw, FH4, FH, this.v5[10], 15);
        FH5 = Hw(FH, FH2, Hw, FH4, this.v5[0], 14);
        int Hw2 = Hw(FH4, FH5, FH2, Hw, this.v5[8], 15);
        FH3 = Hw(Hw, Hw2, FH5, FH2, this.v5[12], 9);
        FH6 = Hw(FH2, FH3, Hw2, FH5, this.v5[4], 8);
        int Hw3 = Hw(FH5, FH6, FH3, Hw2, this.v5[13], 9);
        FH4 = Hw(Hw2, Hw3, FH6, FH3, this.v5[3], 14);
        Hw = Hw(FH3, FH4, Hw3, FH6, this.v5[7], 5);
        int Hw4 = Hw(FH6, Hw, FH4, Hw3, this.v5[15], 6);
        FH5 = Hw(Hw3, Hw4, Hw, FH4, this.v5[14], 8);
        Hw2 = Hw(FH4, FH5, Hw4, Hw, this.v5[5], 6);
        int Hw5 = Hw(Hw, Hw2, FH5, Hw4, this.v5[6], 5);
        FH6 = Hw(Hw4, Hw5, Hw2, FH5, this.v5[2], 12);
        j6 = gn(i, i2, i3, i4, this.v5[5], 8);
        int gn = gn(i4, j6, i2, i3, this.v5[14], 9);
        int gn2 = gn(i3, gn, j6, i2, this.v5[7], 9);
        j62 = gn(i2, gn2, gn, j6, this.v5[0], 11);
        j67 = gn(j6, j62, gn2, gn, this.v5[9], 13);
        j64 = gn(gn, j67, j62, gn2, this.v5[2], 15);
        i2 = gn(gn2, j64, j67, j62, this.v5[11], 15);
        j68 = gn(j62, i2, j64, j67, this.v5[4], 5);
        j65 = gn(j67, j68, i2, j64, this.v5[13], 7);
        j62 = gn(j64, j65, j68, i2, this.v5[6], 7);
        i2 = gn(i2, j62, j65, j68, this.v5[15], 8);
        gn2 = gn(j68, i2, j62, j65, this.v5[8], 11);
        j65 = gn(j65, gn2, i2, j62, this.v5[1], 14);
        i3 = gn(j62, j65, gn2, i2, this.v5[10], 14);
        gn = gn(i2, i3, j65, gn2, this.v5[3], 12);
        j68 = gn(gn2, gn, i3, j65, this.v5[12], 6);
        i4 = VH(j65, j68, gn, i3, this.v5[6], 9);
        j6 = VH(i3, i4, j68, gn, this.v5[11], 13);
        j63 = VH(gn, j6, i4, j68, this.v5[3], 15);
        gn2 = VH(j68, j63, j6, i4, this.v5[7], 7);
        j64 = VH(i4, gn2, j63, j6, this.v5[0], 12);
        j66 = VH(j6, j64, gn2, j63, this.v5[13], 8);
        gn = VH(j63, j66, j64, gn2, this.v5[5], 9);
        j67 = VH(gn2, gn, j66, j64, this.v5[10], 11);
        j69 = VH(j64, j67, gn, j66, this.v5[14], 7);
        j6 = VH(j66, j69, j67, gn, this.v5[15], 7);
        j62 = VH(gn, j6, j69, j67, this.v5[8], 12);
        j610 = VH(j67, j62, j6, j69, this.v5[12], 7);
        j64 = VH(j69, j610, j62, j6, this.v5[4], 6);
        j65 = VH(j6, j64, j610, j62, this.v5[9], 15);
        j611 = VH(j62, j65, j64, j610, this.v5[1], 13);
        j67 = VH(j610, j611, j65, j64, this.v5[2], 11);
        j68 = Zo(j64, j67, j611, j65, this.v5[15], 9);
        DW = Zo(j65, j68, j67, j611, this.v5[5], 7);
        j62 = Zo(j611, DW, j68, j67, this.v5[1], 15);
        j63 = Zo(j67, j62, DW, j68, this.v5[3], 11);
        DW2 = Zo(j68, j63, j62, DW, this.v5[7], 8);
        j65 = Zo(DW, DW2, j63, j62, this.v5[14], 6);
        j66 = Zo(j62, j65, DW2, j63, this.v5[6], 6);
        DW3 = Zo(j63, j66, j65, DW2, this.v5[9], 14);
        j68 = Zo(DW2, DW3, j66, j65, this.v5[11], 12);
        j69 = Zo(j65, j68, DW3, j66, this.v5[8], 13);
        DW4 = Zo(j66, j69, j68, DW3, this.v5[12], 5);
        j63 = Zo(DW3, DW4, j69, j68, this.v5[2], 14);
        j610 = Zo(j68, j63, DW4, j69, this.v5[10], 13);
        DW5 = Zo(j69, j610, j63, DW4, this.v5[0], 13);
        j66 = Zo(DW4, DW5, j610, j63, this.v5[4], 7);
        j611 = Zo(j63, j66, DW5, j610, this.v5[13], 5);
        j68 = v5(j610, j611, j66, DW5, this.v5[8], 15);
        j69 = v5(DW5, j68, j611, j66, this.v5[6], 5);
        DW = v5(j66, j69, j68, j611, this.v5[4], 8);
        j63 = v5(j611, DW, j69, j68, this.v5[1], 11);
        j610 = v5(j68, j63, DW, j69, this.v5[3], 14);
        DW2 = v5(j69, j610, j63, DW, this.v5[11], 14);
        j66 = v5(DW, DW2, j610, j63, this.v5[15], 6);
        j611 = v5(j63, j66, DW2, j610, this.v5[0], 14);
        DW3 = v5(j610, j611, j66, DW2, this.v5[5], 6);
        j69 = v5(DW2, DW3, j611, j66, this.v5[12], 9);
        DW = v5(j66, j69, DW3, j611, this.v5[2], 12);
        DW4 = v5(j611, DW, j69, DW3, this.v5[13], 9);
        j610 = v5(DW3, DW4, DW, j69, this.v5[9], 12);
        DW2 = v5(j69, j610, DW4, DW, this.v5[7], 5);
        DW5 = v5(DW, DW2, j610, DW4, this.v5[10], 15);
        int v5 = v5(DW4, DW5, DW2, j610, this.v5[14], 8);
        i = (this.DW + Hw5) + DW2;
        this.DW = (this.FH + Hw2) + j610;
        this.FH = v5 + (this.Hw + FH5);
        this.Hw = (this.j6 + FH6) + DW5;
        this.j6 = i;
        this.Zo = 0;
        for (v5 = 0; v5 != this.v5.length; v5++) {
            this.v5[v5] = 0;
        }
    }
}
