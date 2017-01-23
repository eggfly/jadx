public class bey extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int[] Zo;
    private int j6;
    private int v5;

    public bey() {
        this.Zo = new int[16];
        FH();
    }

    public String j6() {
        return "RIPEMD160";
    }

    public int DW() {
        return 20;
    }

    protected void DW(byte[] bArr, int i) {
        int[] iArr = this.Zo;
        int i2 = this.VH;
        this.VH = i2 + 1;
        iArr[i2] = (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16)) | ((bArr[i + 3] & 255) << 24);
        if (this.VH == 16) {
            v5();
        }
    }

    protected void j6(long j) {
        if (this.VH > 14) {
            v5();
        }
        this.Zo[14] = (int) (-1 & j);
        this.Zo[15] = (int) (j >>> 32);
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
        FH();
        return 20;
    }

    public void FH() {
        super.FH();
        this.j6 = 1732584193;
        this.DW = -271733879;
        this.FH = -1732584194;
        this.Hw = 271733878;
        this.v5 = -1009589776;
        this.VH = 0;
        for (int i = 0; i != this.Zo.length; i++) {
            this.Zo[i] = 0;
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

    private int v5(int i, int i2, int i3) {
        return ((i3 ^ -1) | i2) ^ i;
    }

    protected void v5() {
        int i = this.j6;
        int i2 = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        int i5 = this.v5;
        int j6 = j6((j6(i2, i3, i4) + i) + this.Zo[0], 11) + i5;
        int j62 = j6(i3, 10);
        int j63 = j6((j6(j6, i2, j62) + i5) + this.Zo[1], 14) + i4;
        int j64 = j6(i2, 10);
        int j65 = j6((j6(j63, j6, j64) + i4) + this.Zo[2], 15) + j62;
        j6 = j6(j6, 10);
        j62 = j6((j62 + j6(j65, j63, j6)) + this.Zo[3], 12) + j64;
        j63 = j6(j63, 10);
        j64 = j6((j64 + j6(j62, j65, j63)) + this.Zo[4], 5) + j6;
        j65 = j6(j65, 10);
        j6 = j6((j6 + j6(j64, j62, j65)) + this.Zo[5], 8) + j63;
        j62 = j6(j62, 10);
        j63 = j6((j63 + j6(j6, j64, j62)) + this.Zo[6], 7) + j65;
        j64 = j6(j64, 10);
        j65 = j6((j65 + j6(j63, j6, j64)) + this.Zo[7], 9) + j62;
        j6 = j6(j6, 10);
        j62 = j6((j62 + j6(j65, j63, j6)) + this.Zo[8], 11) + j64;
        j63 = j6(j63, 10);
        j64 = j6((j64 + j6(j62, j65, j63)) + this.Zo[9], 13) + j6;
        j65 = j6(j65, 10);
        j6 = j6((j6 + j6(j64, j62, j65)) + this.Zo[10], 14) + j63;
        j62 = j6(j62, 10);
        j63 = j6((j63 + j6(j6, j64, j62)) + this.Zo[11], 15) + j65;
        j64 = j6(j64, 10);
        j65 = j6((j65 + j6(j63, j6, j64)) + this.Zo[12], 6) + j62;
        j6 = j6(j6, 10);
        j62 = j6((j62 + j6(j65, j63, j6)) + this.Zo[13], 7) + j64;
        j63 = j6(j63, 10);
        j64 = j6((j64 + j6(j62, j65, j63)) + this.Zo[14], 9) + j6;
        j65 = j6(j65, 10);
        j6 = j6((j6 + j6(j64, j62, j65)) + this.Zo[15], 8) + j63;
        j62 = j6(j62, 10);
        i = j6(((i + v5(i2, i3, i4)) + this.Zo[5]) + 1352829926, 8) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + v5(i, i2, i3)) + this.Zo[14]) + 1352829926, 9) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + v5(i5, i, i2)) + this.Zo[7]) + 1352829926, 9) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + v5(i4, i5, i)) + this.Zo[0]) + 1352829926, 11) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + v5(i3, i4, i5)) + this.Zo[9]) + 1352829926, 13) + i;
        i4 = j6(i4, 10);
        i = j6(((i + v5(i2, i3, i4)) + this.Zo[2]) + 1352829926, 15) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + v5(i, i2, i3)) + this.Zo[11]) + 1352829926, 15) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + v5(i5, i, i2)) + this.Zo[4]) + 1352829926, 5) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + v5(i4, i5, i)) + this.Zo[13]) + 1352829926, 7) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + v5(i3, i4, i5)) + this.Zo[6]) + 1352829926, 7) + i;
        i4 = j6(i4, 10);
        i = j6(((i + v5(i2, i3, i4)) + this.Zo[15]) + 1352829926, 8) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + v5(i, i2, i3)) + this.Zo[8]) + 1352829926, 11) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + v5(i5, i, i2)) + this.Zo[1]) + 1352829926, 14) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + v5(i4, i5, i)) + this.Zo[10]) + 1352829926, 14) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + v5(i3, i4, i5)) + this.Zo[3]) + 1352829926, 12) + i;
        i4 = j6(i4, 10);
        i = j6(((i + v5(i2, i3, i4)) + this.Zo[12]) + 1352829926, 6) + i5;
        i3 = j6(i3, 10);
        j63 = j6(((j63 + DW(j6, j64, j62)) + this.Zo[7]) + 1518500249, 7) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + DW(j63, j6, j64)) + this.Zo[4]) + 1518500249, 6) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + DW(j65, j63, j6)) + this.Zo[13]) + 1518500249, 8) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + DW(j62, j65, j63)) + this.Zo[1]) + 1518500249, 13) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + DW(j64, j62, j65)) + this.Zo[10]) + 1518500249, 11) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + DW(j6, j64, j62)) + this.Zo[6]) + 1518500249, 9) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + DW(j63, j6, j64)) + this.Zo[15]) + 1518500249, 7) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + DW(j65, j63, j6)) + this.Zo[3]) + 1518500249, 15) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + DW(j62, j65, j63)) + this.Zo[12]) + 1518500249, 7) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + DW(j64, j62, j65)) + this.Zo[0]) + 1518500249, 12) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + DW(j6, j64, j62)) + this.Zo[9]) + 1518500249, 15) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + DW(j63, j6, j64)) + this.Zo[5]) + 1518500249, 9) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + DW(j65, j63, j6)) + this.Zo[2]) + 1518500249, 11) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + DW(j62, j65, j63)) + this.Zo[14]) + 1518500249, 7) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + DW(j64, j62, j65)) + this.Zo[11]) + 1518500249, 13) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + DW(j6, j64, j62)) + this.Zo[8]) + 1518500249, 12) + j65;
        j64 = j6(j64, 10);
        i5 = j6(((i5 + Hw(i, i2, i3)) + this.Zo[6]) + 1548603684, 9) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + Hw(i5, i, i2)) + this.Zo[11]) + 1548603684, 13) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + Hw(i4, i5, i)) + this.Zo[3]) + 1548603684, 15) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + Hw(i3, i4, i5)) + this.Zo[7]) + 1548603684, 7) + i;
        i4 = j6(i4, 10);
        i = j6(((i + Hw(i2, i3, i4)) + this.Zo[0]) + 1548603684, 12) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + Hw(i, i2, i3)) + this.Zo[13]) + 1548603684, 8) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + Hw(i5, i, i2)) + this.Zo[5]) + 1548603684, 9) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + Hw(i4, i5, i)) + this.Zo[10]) + 1548603684, 11) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + Hw(i3, i4, i5)) + this.Zo[14]) + 1548603684, 7) + i;
        i4 = j6(i4, 10);
        i = j6(((i + Hw(i2, i3, i4)) + this.Zo[15]) + 1548603684, 7) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + Hw(i, i2, i3)) + this.Zo[8]) + 1548603684, 12) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + Hw(i5, i, i2)) + this.Zo[12]) + 1548603684, 7) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + Hw(i4, i5, i)) + this.Zo[4]) + 1548603684, 6) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + Hw(i3, i4, i5)) + this.Zo[9]) + 1548603684, 15) + i;
        i4 = j6(i4, 10);
        i = j6(((i + Hw(i2, i3, i4)) + this.Zo[1]) + 1548603684, 13) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + Hw(i, i2, i3)) + this.Zo[2]) + 1548603684, 11) + i4;
        i2 = j6(i2, 10);
        j65 = j6(((j65 + FH(j63, j6, j64)) + this.Zo[3]) + 1859775393, 11) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + FH(j65, j63, j6)) + this.Zo[10]) + 1859775393, 13) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + FH(j62, j65, j63)) + this.Zo[14]) + 1859775393, 6) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + FH(j64, j62, j65)) + this.Zo[4]) + 1859775393, 7) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + FH(j6, j64, j62)) + this.Zo[9]) + 1859775393, 14) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + FH(j63, j6, j64)) + this.Zo[15]) + 1859775393, 9) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + FH(j65, j63, j6)) + this.Zo[8]) + 1859775393, 13) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + FH(j62, j65, j63)) + this.Zo[1]) + 1859775393, 15) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + FH(j64, j62, j65)) + this.Zo[2]) + 1859775393, 14) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + FH(j6, j64, j62)) + this.Zo[7]) + 1859775393, 8) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + FH(j63, j6, j64)) + this.Zo[0]) + 1859775393, 13) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + FH(j65, j63, j6)) + this.Zo[6]) + 1859775393, 6) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + FH(j62, j65, j63)) + this.Zo[13]) + 1859775393, 5) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + FH(j64, j62, j65)) + this.Zo[11]) + 1859775393, 12) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + FH(j6, j64, j62)) + this.Zo[5]) + 1859775393, 7) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + FH(j63, j6, j64)) + this.Zo[12]) + 1859775393, 5) + j62;
        j6 = j6(j6, 10);
        i4 = j6(((i4 + FH(i5, i, i2)) + this.Zo[15]) + 1836072691, 9) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + FH(i4, i5, i)) + this.Zo[5]) + 1836072691, 7) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + FH(i3, i4, i5)) + this.Zo[1]) + 1836072691, 15) + i;
        i4 = j6(i4, 10);
        i = j6(((i + FH(i2, i3, i4)) + this.Zo[3]) + 1836072691, 11) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + FH(i, i2, i3)) + this.Zo[7]) + 1836072691, 8) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + FH(i5, i, i2)) + this.Zo[14]) + 1836072691, 6) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + FH(i4, i5, i)) + this.Zo[6]) + 1836072691, 6) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + FH(i3, i4, i5)) + this.Zo[9]) + 1836072691, 14) + i;
        i4 = j6(i4, 10);
        i = j6(((i + FH(i2, i3, i4)) + this.Zo[11]) + 1836072691, 12) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + FH(i, i2, i3)) + this.Zo[8]) + 1836072691, 13) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + FH(i5, i, i2)) + this.Zo[12]) + 1836072691, 5) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + FH(i4, i5, i)) + this.Zo[2]) + 1836072691, 14) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + FH(i3, i4, i5)) + this.Zo[10]) + 1836072691, 13) + i;
        i4 = j6(i4, 10);
        i = j6(((i + FH(i2, i3, i4)) + this.Zo[0]) + 1836072691, 13) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + FH(i, i2, i3)) + this.Zo[4]) + 1836072691, 7) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + FH(i5, i, i2)) + this.Zo[13]) + 1836072691, 5) + i3;
        i = j6(i, 10);
        j62 = j6(((j62 + Hw(j65, j63, j6)) + this.Zo[1]) - 1894007588, 11) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + Hw(j62, j65, j63)) + this.Zo[9]) - 1894007588, 12) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + Hw(j64, j62, j65)) + this.Zo[11]) - 1894007588, 14) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + Hw(j6, j64, j62)) + this.Zo[10]) - 1894007588, 15) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + Hw(j63, j6, j64)) + this.Zo[0]) - 1894007588, 14) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + Hw(j65, j63, j6)) + this.Zo[8]) - 1894007588, 15) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + Hw(j62, j65, j63)) + this.Zo[12]) - 1894007588, 9) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + Hw(j64, j62, j65)) + this.Zo[4]) - 1894007588, 8) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + Hw(j6, j64, j62)) + this.Zo[13]) - 1894007588, 9) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + Hw(j63, j6, j64)) + this.Zo[3]) - 1894007588, 14) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + Hw(j65, j63, j6)) + this.Zo[7]) - 1894007588, 5) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + Hw(j62, j65, j63)) + this.Zo[15]) - 1894007588, 6) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + Hw(j64, j62, j65)) + this.Zo[14]) - 1894007588, 8) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + Hw(j6, j64, j62)) + this.Zo[5]) - 1894007588, 6) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + Hw(j63, j6, j64)) + this.Zo[6]) - 1894007588, 5) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + Hw(j65, j63, j6)) + this.Zo[2]) - 1894007588, 12) + j64;
        j63 = j6(j63, 10);
        i3 = j6(((i3 + DW(i4, i5, i)) + this.Zo[8]) + 2053994217, 15) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + DW(i3, i4, i5)) + this.Zo[6]) + 2053994217, 5) + i;
        i4 = j6(i4, 10);
        i = j6(((i + DW(i2, i3, i4)) + this.Zo[4]) + 2053994217, 8) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + DW(i, i2, i3)) + this.Zo[1]) + 2053994217, 11) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + DW(i5, i, i2)) + this.Zo[3]) + 2053994217, 14) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + DW(i4, i5, i)) + this.Zo[11]) + 2053994217, 14) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + DW(i3, i4, i5)) + this.Zo[15]) + 2053994217, 6) + i;
        i4 = j6(i4, 10);
        i = j6(((i + DW(i2, i3, i4)) + this.Zo[0]) + 2053994217, 14) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + DW(i, i2, i3)) + this.Zo[5]) + 2053994217, 6) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + DW(i5, i, i2)) + this.Zo[12]) + 2053994217, 9) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + DW(i4, i5, i)) + this.Zo[2]) + 2053994217, 12) + i2;
        i5 = j6(i5, 10);
        i2 = j6(((i2 + DW(i3, i4, i5)) + this.Zo[13]) + 2053994217, 9) + i;
        i4 = j6(i4, 10);
        i = j6(((i + DW(i2, i3, i4)) + this.Zo[9]) + 2053994217, 12) + i5;
        i3 = j6(i3, 10);
        i5 = j6(((i5 + DW(i, i2, i3)) + this.Zo[7]) + 2053994217, 5) + i4;
        i2 = j6(i2, 10);
        i4 = j6(((i4 + DW(i5, i, i2)) + this.Zo[10]) + 2053994217, 15) + i3;
        i = j6(i, 10);
        i3 = j6(((i3 + DW(i4, i5, i)) + this.Zo[14]) + 2053994217, 8) + i2;
        i5 = j6(i5, 10);
        j64 = j6(((j64 + v5(j62, j65, j63)) + this.Zo[4]) - 1454113458, 9) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + v5(j64, j62, j65)) + this.Zo[0]) - 1454113458, 15) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + v5(j6, j64, j62)) + this.Zo[5]) - 1454113458, 5) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + v5(j63, j6, j64)) + this.Zo[9]) - 1454113458, 11) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + v5(j65, j63, j6)) + this.Zo[7]) - 1454113458, 6) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + v5(j62, j65, j63)) + this.Zo[12]) - 1454113458, 8) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + v5(j64, j62, j65)) + this.Zo[2]) - 1454113458, 13) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + v5(j6, j64, j62)) + this.Zo[10]) - 1454113458, 12) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + v5(j63, j6, j64)) + this.Zo[14]) - 1454113458, 5) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + v5(j65, j63, j6)) + this.Zo[1]) - 1454113458, 12) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + v5(j62, j65, j63)) + this.Zo[3]) - 1454113458, 13) + j6;
        j65 = j6(j65, 10);
        j6 = j6(((j6 + v5(j64, j62, j65)) + this.Zo[8]) - 1454113458, 14) + j63;
        j62 = j6(j62, 10);
        j63 = j6(((j63 + v5(j6, j64, j62)) + this.Zo[11]) - 1454113458, 11) + j65;
        j64 = j6(j64, 10);
        j65 = j6(((j65 + v5(j63, j6, j64)) + this.Zo[6]) - 1454113458, 8) + j62;
        j6 = j6(j6, 10);
        j62 = j6(((j62 + v5(j65, j63, j6)) + this.Zo[15]) - 1454113458, 5) + j64;
        j63 = j6(j63, 10);
        j64 = j6(((j64 + v5(j62, j65, j63)) + this.Zo[13]) - 1454113458, 6) + j6;
        j65 = j6(j65, 10);
        i2 = j6((i2 + j6(i3, i4, i5)) + this.Zo[12], 8) + i;
        i4 = j6(i4, 10);
        i = j6((i + j6(i2, i3, i4)) + this.Zo[15], 5) + i5;
        i3 = j6(i3, 10);
        i5 = j6((i5 + j6(i, i2, i3)) + this.Zo[10], 12) + i4;
        i2 = j6(i2, 10);
        i4 = j6((i4 + j6(i5, i, i2)) + this.Zo[4], 9) + i3;
        i = j6(i, 10);
        i3 = j6((i3 + j6(i4, i5, i)) + this.Zo[1], 12) + i2;
        i5 = j6(i5, 10);
        i2 = j6((i2 + j6(i3, i4, i5)) + this.Zo[5], 5) + i;
        i4 = j6(i4, 10);
        i = j6((i + j6(i2, i3, i4)) + this.Zo[8], 14) + i5;
        i3 = j6(i3, 10);
        i5 = j6((i5 + j6(i, i2, i3)) + this.Zo[7], 6) + i4;
        i2 = j6(i2, 10);
        i4 = j6((i4 + j6(i5, i, i2)) + this.Zo[6], 8) + i3;
        i = j6(i, 10);
        i3 = j6((i3 + j6(i4, i5, i)) + this.Zo[2], 13) + i2;
        i5 = j6(i5, 10);
        i2 = j6((i2 + j6(i3, i4, i5)) + this.Zo[13], 6) + i;
        i4 = j6(i4, 10);
        i = j6((i + j6(i2, i3, i4)) + this.Zo[14], 5) + i5;
        i3 = j6(i3, 10);
        i5 = j6((i5 + j6(i, i2, i3)) + this.Zo[0], 15) + i4;
        i2 = j6(i2, 10);
        i4 = j6((i4 + j6(i5, i, i2)) + this.Zo[3], 13) + i3;
        i = j6(i, 10);
        i3 = j6((i3 + j6(i4, i5, i)) + this.Zo[9], 11) + i2;
        i5 = j6(i5, 10);
        i2 = j6((i2 + j6(i3, i4, i5)) + this.Zo[11], 11) + i;
        i4 = j6(i4, 10) + (j62 + this.DW);
        this.DW = i5 + (this.FH + j65);
        this.FH = i + (this.Hw + j63);
        this.Hw = (this.v5 + j6) + i2;
        this.v5 = (this.j6 + j64) + i3;
        this.j6 = i4;
        this.VH = 0;
        for (i = 0; i != this.Zo.length; i++) {
            this.Zo[i] = 0;
        }
    }
}
