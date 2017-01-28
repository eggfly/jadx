public class bew extends bes {
    private int DW;
    private int FH;
    private int Hw;
    private int Zo;
    private int j6;
    private int[] v5;

    public bew() {
        this.v5 = new int[16];
        FH();
    }

    public String j6() {
        return "MD5";
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
        return (i & i3) | ((i3 ^ -1) & i2);
    }

    private int FH(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    private int Hw(int i, int i2, int i3) {
        return ((i3 ^ -1) | i) ^ i2;
    }

    protected void v5() {
        int i = this.j6;
        int i2 = this.DW;
        int i3 = this.FH;
        int i4 = this.Hw;
        i = j6(((i + j6(i2, i3, i4)) + this.v5[0]) - 680876936, 7) + i2;
        i4 = j6(((i4 + j6(i, i2, i3)) + this.v5[1]) - 389564586, 12) + i;
        i3 = j6(((i3 + j6(i4, i, i2)) + this.v5[2]) + 606105819, 17) + i4;
        i2 = j6(((i2 + j6(i3, i4, i)) + this.v5[3]) - 1044525330, 22) + i3;
        i = j6(((i + j6(i2, i3, i4)) + this.v5[4]) - 176418897, 7) + i2;
        i4 = j6(((i4 + j6(i, i2, i3)) + this.v5[5]) + 1200080426, 12) + i;
        i3 = j6(((i3 + j6(i4, i, i2)) + this.v5[6]) - 1473231341, 17) + i4;
        i2 = j6(((i2 + j6(i3, i4, i)) + this.v5[7]) - 45705983, 22) + i3;
        i = j6(((i + j6(i2, i3, i4)) + this.v5[8]) + 1770035416, 7) + i2;
        i4 = j6(((i4 + j6(i, i2, i3)) + this.v5[9]) - 1958414417, 12) + i;
        i3 = j6(((i3 + j6(i4, i, i2)) + this.v5[10]) - 42063, 17) + i4;
        i2 = j6(((i2 + j6(i3, i4, i)) + this.v5[11]) - 1990404162, 22) + i3;
        i = j6(((i + j6(i2, i3, i4)) + this.v5[12]) + 1804603682, 7) + i2;
        i4 = j6(((i4 + j6(i, i2, i3)) + this.v5[13]) - 40341101, 12) + i;
        i3 = j6(((i3 + j6(i4, i, i2)) + this.v5[14]) - 1502002290, 17) + i4;
        i2 = j6(((i2 + j6(i3, i4, i)) + this.v5[15]) + 1236535329, 22) + i3;
        i = j6(((i + DW(i2, i3, i4)) + this.v5[1]) - 165796510, 5) + i2;
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[6]) - 1069501632, 9) + i;
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[11]) + 643717713, 14) + i4;
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[0]) - 373897302, 20) + i3;
        i = j6(((i + DW(i2, i3, i4)) + this.v5[5]) - 701558691, 5) + i2;
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[10]) + 38016083, 9) + i;
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[15]) - 660478335, 14) + i4;
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[4]) - 405537848, 20) + i3;
        i = j6(((i + DW(i2, i3, i4)) + this.v5[9]) + 568446438, 5) + i2;
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[14]) - 1019803690, 9) + i;
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[3]) - 187363961, 14) + i4;
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[8]) + 1163531501, 20) + i3;
        i = j6(((i + DW(i2, i3, i4)) + this.v5[13]) - 1444681467, 5) + i2;
        i4 = j6(((i4 + DW(i, i2, i3)) + this.v5[2]) - 51403784, 9) + i;
        i3 = j6(((i3 + DW(i4, i, i2)) + this.v5[7]) + 1735328473, 14) + i4;
        i2 = j6(((i2 + DW(i3, i4, i)) + this.v5[12]) - 1926607734, 20) + i3;
        i = j6(((i + FH(i2, i3, i4)) + this.v5[5]) - 378558, 4) + i2;
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[8]) - 2022574463, 11) + i;
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[11]) + 1839030562, 16) + i4;
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[14]) - 35309556, 23) + i3;
        i = j6(((i + FH(i2, i3, i4)) + this.v5[1]) - 1530992060, 4) + i2;
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[4]) + 1272893353, 11) + i;
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[7]) - 155497632, 16) + i4;
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[10]) - 1094730640, 23) + i3;
        i = j6(((i + FH(i2, i3, i4)) + this.v5[13]) + 681279174, 4) + i2;
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[0]) - 358537222, 11) + i;
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[3]) - 722521979, 16) + i4;
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[6]) + 76029189, 23) + i3;
        i = j6(((i + FH(i2, i3, i4)) + this.v5[9]) - 640364487, 4) + i2;
        i4 = j6(((i4 + FH(i, i2, i3)) + this.v5[12]) - 421815835, 11) + i;
        i3 = j6(((i3 + FH(i4, i, i2)) + this.v5[15]) + 530742520, 16) + i4;
        i2 = j6(((i2 + FH(i3, i4, i)) + this.v5[2]) - 995338651, 23) + i3;
        i = j6(((i + Hw(i2, i3, i4)) + this.v5[0]) - 198630844, 6) + i2;
        i4 = j6(((i4 + Hw(i, i2, i3)) + this.v5[7]) + 1126891415, 10) + i;
        i3 = j6(((i3 + Hw(i4, i, i2)) + this.v5[14]) - 1416354905, 15) + i4;
        i2 = j6(((i2 + Hw(i3, i4, i)) + this.v5[5]) - 57434055, 21) + i3;
        i = j6(((i + Hw(i2, i3, i4)) + this.v5[12]) + 1700485571, 6) + i2;
        i4 = j6(((i4 + Hw(i, i2, i3)) + this.v5[3]) - 1894986606, 10) + i;
        i3 = j6(((i3 + Hw(i4, i, i2)) + this.v5[10]) - 1051523, 15) + i4;
        i2 = j6(((i2 + Hw(i3, i4, i)) + this.v5[1]) - 2054922799, 21) + i3;
        i = j6(((i + Hw(i2, i3, i4)) + this.v5[8]) + 1873313359, 6) + i2;
        i4 = j6(((i4 + Hw(i, i2, i3)) + this.v5[15]) - 30611744, 10) + i;
        i3 = j6(((i3 + Hw(i4, i, i2)) + this.v5[6]) - 1560198380, 15) + i4;
        i2 = j6(((i2 + Hw(i3, i4, i)) + this.v5[13]) + 1309151649, 21) + i3;
        i = j6(((i + Hw(i2, i3, i4)) + this.v5[4]) - 145523070, 6) + i2;
        i4 = j6(((i4 + Hw(i, i2, i3)) + this.v5[11]) - 1120210379, 10) + i;
        i3 = j6(((i3 + Hw(i4, i, i2)) + this.v5[2]) + 718787259, 15) + i4;
        i2 = j6(((i2 + Hw(i3, i4, i)) + this.v5[9]) - 343485551, 21) + i3;
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
