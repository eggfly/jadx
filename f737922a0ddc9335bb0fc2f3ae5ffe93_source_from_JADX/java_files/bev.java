public class bev extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    private int j6;
    private int[] v5;

    public bev() {
        this.v5 = new int[16];
        FH();
    }

    public String j6() {
        return "MD4";
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
        return (i & i2) | ((i ^ -1) & i3);
    }

    private int DW(int i, int i2, int i3) {
        return ((i & i2) | (i & i3)) | (i2 & i3);
    }

    private int FH(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    protected void v5() {
        int i = this.j6;
        int i2 = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        i = j6((i + j6(i2, i3, i4)) + this.v5[0], 3);
        i4 = j6((i4 + j6(i, i2, i3)) + this.v5[1], 7);
        i3 = j6((i3 + j6(i4, i, i2)) + this.v5[2], 11);
        i2 = j6((i2 + j6(i3, i4, i)) + this.v5[3], 19);
        i = j6((i + j6(i2, i3, i4)) + this.v5[4], 3);
        i4 = j6((i4 + j6(i, i2, i3)) + this.v5[5], 7);
        i3 = j6((i3 + j6(i4, i, i2)) + this.v5[6], 11);
        i2 = j6((i2 + j6(i3, i4, i)) + this.v5[7], 19);
        i = j6((i + j6(i2, i3, i4)) + this.v5[8], 3);
        i4 = j6((i4 + j6(i, i2, i3)) + this.v5[9], 7);
        i3 = j6((i3 + j6(i4, i, i2)) + this.v5[10], 11);
        i2 = j6((i2 + j6(i3, i4, i)) + this.v5[11], 19);
        i = j6((i + j6(i2, i3, i4)) + this.v5[12], 3);
        i4 = j6((i4 + j6(i, i2, i3)) + this.v5[13], 7);
        i3 = j6((i3 + j6(i4, i, i2)) + this.v5[14], 11);
        i2 = j6((i2 + j6(i3, i4, i)) + this.v5[15], 19);
        i = j6(((i + DW(i2, i3, i4)) + this.v5[0]) + 1518500249, 3);
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[4]) + 1518500249, 5);
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[8]) + 1518500249, 9);
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[12]) + 1518500249, 13);
        i = j6(((i + DW(i2, i3, i4)) + this.v5[1]) + 1518500249, 3);
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[5]) + 1518500249, 5);
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[9]) + 1518500249, 9);
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[13]) + 1518500249, 13);
        i = j6(((i + DW(i2, i3, i4)) + this.v5[2]) + 1518500249, 3);
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[6]) + 1518500249, 5);
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[10]) + 1518500249, 9);
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[14]) + 1518500249, 13);
        i = j6(((i + DW(i2, i3, i4)) + this.v5[3]) + 1518500249, 3);
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[7]) + 1518500249, 5);
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[11]) + 1518500249, 9);
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[15]) + 1518500249, 13);
        i = j6(((i + FH(i2, i3, i4)) + this.v5[0]) + 1859775393, 3);
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[8]) + 1859775393, 9);
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[4]) + 1859775393, 11);
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[12]) + 1859775393, 15);
        i = j6(((i + FH(i2, i3, i4)) + this.v5[2]) + 1859775393, 3);
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[10]) + 1859775393, 9);
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[6]) + 1859775393, 11);
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[14]) + 1859775393, 15);
        i = j6(((i + FH(i2, i3, i4)) + this.v5[1]) + 1859775393, 3);
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[9]) + 1859775393, 9);
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[5]) + 1859775393, 11);
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[13]) + 1859775393, 15);
        i = j6(((i + FH(i2, i3, i4)) + this.v5[3]) + 1859775393, 3);
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[11]) + 1859775393, 9);
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[7]) + 1859775393, 11);
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[15]) + 1859775393, 15);
        this.j6 = i + this.j6;
        this.DW += i2;
        this.FH += i3;
        this.Hw += i4;
        this.Zo = 0;
        for (i = 0; i != this.v5.length; i++) {
            this.v5[i] = 0;
        }
    }
}
