public class bfc extends bes {
    static final int[] j6;
    private int DW;
    private int EQ;
    private int FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    private int[] tp;
    private int u7;
    private int v5;

    public bfc() {
        this.tp = new int[64];
        FH();
    }

    public String j6() {
        return "SHA-256";
    }

    public int DW() {
        return 32;
    }

    protected void DW(byte[] bArr, int i) {
        int i2 = i + 1;
        i2++;
        this.tp[this.EQ] = (((bArr[i] << 24) | ((bArr[i2] & 255) << 16)) | ((bArr[i2] & 255) << 8)) | (bArr[i2 + 1] & 255);
        int i3 = this.EQ + 1;
        this.EQ = i3;
        if (i3 == 16) {
            v5();
        }
    }

    protected void j6(long j) {
        if (this.EQ > 14) {
            v5();
        }
        this.tp[14] = (int) (j >>> 32);
        this.tp[15] = (int) (-1 & j);
    }

    public int j6(byte[] bArr, int i) {
        Hw();
        bfu.j6(this.DW, bArr, i);
        bfu.j6(this.FH, bArr, i + 4);
        bfu.j6(this.Hw, bArr, i + 8);
        bfu.j6(this.v5, bArr, i + 12);
        bfu.j6(this.Zo, bArr, i + 16);
        bfu.j6(this.VH, bArr, i + 20);
        bfu.j6(this.gn, bArr, i + 24);
        bfu.j6(this.u7, bArr, i + 28);
        FH();
        return 32;
    }

    public void FH() {
        super.FH();
        this.DW = 1779033703;
        this.FH = -1150833019;
        this.Hw = 1013904242;
        this.v5 = -1521486534;
        this.Zo = 1359893119;
        this.VH = -1694144372;
        this.gn = 528734635;
        this.u7 = 1541459225;
        this.EQ = 0;
        for (int i = 0; i != this.tp.length; i++) {
            this.tp[i] = 0;
        }
    }

    protected void v5() {
        int i;
        for (i = 16; i <= 63; i++) {
            this.tp[i] = ((Hw(this.tp[i - 2]) + this.tp[i - 7]) + FH(this.tp[i - 15])) + this.tp[i - 16];
        }
        int i2 = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        int i5 = this.v5;
        int i6 = this.Zo;
        int i7 = this.VH;
        int i8 = this.gn;
        int i9 = i3;
        int i10 = i2;
        i3 = i5;
        i2 = i4;
        i5 = i7;
        i4 = i6;
        i7 = this.u7;
        i6 = i8;
        i8 = 0;
        for (i = 0; i < 8; i++) {
            i7 += ((DW(i4) + j6(i4, i5, i6)) + j6[i8]) + this.tp[i8];
            i3 += i7;
            i7 += j6(i10) + DW(i10, i9, i2);
            i8++;
            i6 += ((DW(i3) + j6(i3, i4, i5)) + j6[i8]) + this.tp[i8];
            i2 += i6;
            i6 += j6(i7) + DW(i7, i10, i9);
            i8++;
            i5 += ((DW(i2) + j6(i2, i3, i4)) + j6[i8]) + this.tp[i8];
            i9 += i5;
            i5 += j6(i6) + DW(i6, i7, i10);
            i8++;
            i4 += ((DW(i9) + j6(i9, i2, i3)) + j6[i8]) + this.tp[i8];
            i10 += i4;
            i4 += j6(i5) + DW(i5, i6, i7);
            i8++;
            i3 += ((DW(i10) + j6(i10, i9, i2)) + j6[i8]) + this.tp[i8];
            i7 += i3;
            i3 += j6(i4) + DW(i4, i5, i6);
            i8++;
            i2 += ((DW(i7) + j6(i7, i10, i9)) + j6[i8]) + this.tp[i8];
            i6 += i2;
            i2 += j6(i3) + DW(i3, i4, i5);
            i8++;
            i9 += ((DW(i6) + j6(i6, i7, i10)) + j6[i8]) + this.tp[i8];
            i5 += i9;
            i9 += j6(i2) + DW(i2, i3, i4);
            i8++;
            i10 += ((DW(i5) + j6(i5, i6, i7)) + j6[i8]) + this.tp[i8];
            i4 += i10;
            i10 += j6(i9) + DW(i9, i2, i3);
            i8++;
        }
        this.DW += i10;
        this.FH += i9;
        this.Hw += i2;
        this.v5 += i3;
        this.Zo += i4;
        this.VH += i5;
        this.gn += i6;
        this.u7 += i7;
        this.EQ = 0;
        for (i = 0; i < 16; i++) {
            this.tp[i] = 0;
        }
    }

    private int j6(int i, int i2, int i3) {
        return (i & i2) ^ ((i ^ -1) & i3);
    }

    private int DW(int i, int i2, int i3) {
        return ((i & i2) ^ (i & i3)) ^ (i2 & i3);
    }

    private int j6(int i) {
        return (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19))) ^ ((i >>> 22) | (i << 10));
    }

    private int DW(int i) {
        return (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21))) ^ ((i >>> 25) | (i << 7));
    }

    private int FH(int i) {
        return (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14))) ^ (i >>> 3);
    }

    private int Hw(int i) {
        return (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13))) ^ (i >>> 10);
    }

    static {
        j6 = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    }
}
