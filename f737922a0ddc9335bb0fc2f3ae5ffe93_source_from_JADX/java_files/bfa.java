public class bfa extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int VH;
    private int[] Zo;
    private int j6;
    private int v5;

    public bfa() {
        this.Zo = new int[80];
        FH();
    }

    public bfa(bfa bfa) {
        super(bfa);
        this.Zo = new int[80];
        this.j6 = bfa.j6;
        this.DW = bfa.DW;
        this.FH = bfa.FH;
        this.Hw = bfa.Hw;
        this.v5 = bfa.v5;
        System.arraycopy(bfa.Zo, 0, this.Zo, 0, bfa.Zo.length);
        this.VH = bfa.VH;
    }

    public String j6() {
        return "SHA-1";
    }

    public int DW() {
        return 20;
    }

    protected void DW(byte[] bArr, int i) {
        int i2 = i + 1;
        i2++;
        this.Zo[this.VH] = (((bArr[i] << 24) | ((bArr[i2] & 255) << 16)) | ((bArr[i2] & 255) << 8)) | (bArr[i2 + 1] & 255);
        int i3 = this.VH + 1;
        this.VH = i3;
        if (i3 == 16) {
            v5();
        }
    }

    protected void j6(long j) {
        if (this.VH > 14) {
            v5();
        }
        this.Zo[14] = (int) (j >>> 32);
        this.Zo[15] = (int) (-1 & j);
    }

    public int j6(byte[] bArr, int i) {
        Hw();
        bfu.j6(this.j6, bArr, i);
        bfu.j6(this.DW, bArr, i + 4);
        bfu.j6(this.FH, bArr, i + 8);
        bfu.j6(this.Hw, bArr, i + 12);
        bfu.j6(this.v5, bArr, i + 16);
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

    private int j6(int i, int i2, int i3) {
        return (i & i2) | ((i ^ -1) & i3);
    }

    private int DW(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int FH(int i, int i2, int i3) {
        return ((i & i2) | (i & i3)) | (i2 & i3);
    }

    protected void v5() {
        int i;
        int i2;
        for (i = 16; i < 80; i++) {
            i2 = ((this.Zo[i - 3] ^ this.Zo[i - 8]) ^ this.Zo[i - 14]) ^ this.Zo[i - 16];
            this.Zo[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.j6;
        int i4 = this.DW;
        int i5 = this.FH;
        int i6 = this.Hw;
        int i7 = this.v5;
        i2 = 0;
        for (i = 0; i < 4; i++) {
            int i8 = i2 + 1;
            i2 = ((this.Zo[i2] + (((i3 << 5) | (i3 >>> 27)) + j6(i4, i5, i6))) + 1518500249) + i7;
            i4 = (i4 >>> 2) | (i4 << 30);
            int i9 = i8 + 1;
            i6 += ((((i2 << 5) | (i2 >>> 27)) + j6(i3, i4, i5)) + this.Zo[i8]) + 1518500249;
            i3 = (i3 >>> 2) | (i3 << 30);
            i8 = i9 + 1;
            i5 += ((((i6 << 5) | (i6 >>> 27)) + j6(i2, i3, i4)) + this.Zo[i9]) + 1518500249;
            i7 = (i2 << 30) | (i2 >>> 2);
            i9 = i8 + 1;
            i4 += ((((i5 << 5) | (i5 >>> 27)) + j6(i6, i7, i3)) + this.Zo[i8]) + 1518500249;
            i6 = (i6 >>> 2) | (i6 << 30);
            int j6 = j6(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i2 = i9 + 1;
            i3 += (j6 + this.Zo[i9]) + 1518500249;
            i5 = (i5 >>> 2) | (i5 << 30);
        }
        for (i = 0; i < 4; i++) {
            i8 = i2 + 1;
            i2 = ((this.Zo[i2] + (((i3 << 5) | (i3 >>> 27)) + DW(i4, i5, i6))) + 1859775393) + i7;
            i4 = (i4 >>> 2) | (i4 << 30);
            i9 = i8 + 1;
            i6 += ((((i2 << 5) | (i2 >>> 27)) + DW(i3, i4, i5)) + this.Zo[i8]) + 1859775393;
            i3 = (i3 >>> 2) | (i3 << 30);
            i8 = i9 + 1;
            i5 += ((((i6 << 5) | (i6 >>> 27)) + DW(i2, i3, i4)) + this.Zo[i9]) + 1859775393;
            i7 = (i2 << 30) | (i2 >>> 2);
            i9 = i8 + 1;
            i4 += ((((i5 << 5) | (i5 >>> 27)) + DW(i6, i7, i3)) + this.Zo[i8]) + 1859775393;
            i6 = (i6 >>> 2) | (i6 << 30);
            j6 = DW(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i2 = i9 + 1;
            i3 += (j6 + this.Zo[i9]) + 1859775393;
            i5 = (i5 >>> 2) | (i5 << 30);
        }
        for (i = 0; i < 4; i++) {
            i8 = i2 + 1;
            i2 = ((this.Zo[i2] + (((i3 << 5) | (i3 >>> 27)) + FH(i4, i5, i6))) - 1894007588) + i7;
            i4 = (i4 >>> 2) | (i4 << 30);
            i9 = i8 + 1;
            i6 += ((((i2 << 5) | (i2 >>> 27)) + FH(i3, i4, i5)) + this.Zo[i8]) - 1894007588;
            i3 = (i3 >>> 2) | (i3 << 30);
            i8 = i9 + 1;
            i5 += ((((i6 << 5) | (i6 >>> 27)) + FH(i2, i3, i4)) + this.Zo[i9]) - 1894007588;
            i7 = (i2 << 30) | (i2 >>> 2);
            i9 = i8 + 1;
            i4 += ((((i5 << 5) | (i5 >>> 27)) + FH(i6, i7, i3)) + this.Zo[i8]) - 1894007588;
            i6 = (i6 >>> 2) | (i6 << 30);
            j6 = FH(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i2 = i9 + 1;
            i3 += (j6 + this.Zo[i9]) - 1894007588;
            i5 = (i5 >>> 2) | (i5 << 30);
        }
        for (i = 0; i <= 3; i++) {
            i8 = i2 + 1;
            i2 = ((this.Zo[i2] + (((i3 << 5) | (i3 >>> 27)) + DW(i4, i5, i6))) - 899497514) + i7;
            i4 = (i4 >>> 2) | (i4 << 30);
            i9 = i8 + 1;
            i6 += ((((i2 << 5) | (i2 >>> 27)) + DW(i3, i4, i5)) + this.Zo[i8]) - 899497514;
            i3 = (i3 >>> 2) | (i3 << 30);
            i8 = i9 + 1;
            i5 += ((((i6 << 5) | (i6 >>> 27)) + DW(i2, i3, i4)) + this.Zo[i9]) - 899497514;
            i7 = (i2 << 30) | (i2 >>> 2);
            i9 = i8 + 1;
            i4 += ((((i5 << 5) | (i5 >>> 27)) + DW(i6, i7, i3)) + this.Zo[i8]) - 899497514;
            i6 = (i6 >>> 2) | (i6 << 30);
            j6 = DW(i5, i6, i7) + ((i4 << 5) | (i4 >>> 27));
            i2 = i9 + 1;
            i3 += (j6 + this.Zo[i9]) - 899497514;
            i5 = (i5 >>> 2) | (i5 << 30);
        }
        this.j6 += i3;
        this.DW += i4;
        this.FH += i5;
        this.Hw += i6;
        this.v5 += i7;
        this.VH = 0;
        for (i = 0; i < 16; i++) {
            this.Zo[i] = 0;
        }
    }
}
