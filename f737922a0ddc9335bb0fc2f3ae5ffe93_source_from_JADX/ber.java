import java.lang.reflect.Array;

public class ber implements beo {
    private static final byte[] j3;
    short[] DW;
    private byte[] EQ;
    short[] FH;
    byte[] Hw;
    private byte[] J0;
    private int J8;
    private bek QX;
    byte[] VH;
    private long Ws;
    private byte[] XL;
    byte[] Zo;
    private byte[] aM;
    private byte[] gn;
    byte[] j6;
    private byte[] tp;
    private byte[] u7;
    byte[] v5;
    private byte[][] we;

    public ber() {
        this.gn = new byte[32];
        this.u7 = new byte[32];
        this.tp = new byte[32];
        this.EQ = new byte[32];
        this.we = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{4, 32});
        this.J0 = new byte[32];
        this.QX = new bff();
        this.aM = new byte[32];
        this.j6 = new byte[8];
        this.DW = new short[16];
        this.FH = new short[16];
        this.Hw = new byte[32];
        this.v5 = new byte[32];
        this.Zo = new byte[32];
        this.VH = new byte[32];
        this.XL = bff.j6("D-A");
        this.QX.j6(true, new bft(null, this.XL));
        FH();
    }

    public String j6() {
        return "GOST3411";
    }

    public int DW() {
        return 32;
    }

    public void j6(byte b) {
        byte[] bArr = this.J0;
        int i = this.J8;
        this.J8 = i + 1;
        bArr[i] = b;
        if (this.J8 == this.J0.length) {
            Hw(this.J0);
            DW(this.J0, 0);
            this.J8 = 0;
        }
        this.Ws++;
    }

    public void j6(byte[] bArr, int i, int i2) {
        while (this.J8 != 0 && i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.J0.length) {
            System.arraycopy(bArr, i, this.J0, 0, this.J0.length);
            Hw(this.J0);
            DW(this.J0, 0);
            i += this.J0.length;
            i2 -= this.J0.length;
            this.Ws += (long) this.J0.length;
        }
        while (i2 > 0) {
            j6(bArr[i]);
            i++;
            i2--;
        }
    }

    private byte[] j6(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.aM[i * 4] = bArr[i];
            this.aM[(i * 4) + 1] = bArr[i + 8];
            this.aM[(i * 4) + 2] = bArr[i + 16];
            this.aM[(i * 4) + 3] = bArr[i + 24];
        }
        return this.aM;
    }

    private byte[] DW(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.j6[i] = (byte) (bArr[i] ^ bArr[i + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.j6, 0, bArr, 24, 8);
        return bArr;
    }

    private void j6(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        this.QX.j6(true, new bfs(bArr));
        this.QX.j6(bArr3, i2, bArr2, i);
    }

    private void FH(byte[] bArr) {
        j6(bArr, this.DW);
        this.FH[15] = (short) (((((this.DW[0] ^ this.DW[1]) ^ this.DW[2]) ^ this.DW[3]) ^ this.DW[12]) ^ this.DW[15]);
        System.arraycopy(this.DW, 1, this.FH, 0, 15);
        j6(this.FH, bArr);
    }

    protected void DW(byte[] bArr, int i) {
        int i2;
        System.arraycopy(bArr, i, this.tp, 0, 32);
        System.arraycopy(this.gn, 0, this.v5, 0, 32);
        System.arraycopy(this.tp, 0, this.Zo, 0, 32);
        for (i2 = 0; i2 < 32; i2++) {
            this.VH[i2] = (byte) (this.v5[i2] ^ this.Zo[i2]);
        }
        j6(j6(this.VH), this.Hw, 0, this.gn, 0);
        for (int i3 = 1; i3 < 4; i3++) {
            byte[] DW = DW(this.v5);
            for (i2 = 0; i2 < 32; i2++) {
                this.v5[i2] = (byte) (DW[i2] ^ this.we[i3][i2]);
            }
            this.Zo = DW(DW(this.Zo));
            for (i2 = 0; i2 < 32; i2++) {
                this.VH[i2] = (byte) (this.v5[i2] ^ this.Zo[i2]);
            }
            j6(j6(this.VH), this.Hw, i3 * 8, this.gn, i3 * 8);
        }
        for (i2 = 0; i2 < 12; i2++) {
            FH(this.Hw);
        }
        for (i2 = 0; i2 < 32; i2++) {
            this.Hw[i2] = (byte) (this.Hw[i2] ^ this.tp[i2]);
        }
        FH(this.Hw);
        for (i2 = 0; i2 < 32; i2++) {
            this.Hw[i2] = (byte) (this.gn[i2] ^ this.Hw[i2]);
        }
        for (i2 = 0; i2 < 61; i2++) {
            FH(this.Hw);
        }
        System.arraycopy(this.Hw, 0, this.gn, 0, this.gn.length);
    }

    private void Hw() {
        bfu.DW(this.Ws * 8, this.u7, 0);
        while (this.J8 != 0) {
            j6((byte) 0);
        }
        DW(this.u7, 0);
        DW(this.EQ, 0);
    }

    public int j6(byte[] bArr, int i) {
        Hw();
        System.arraycopy(this.gn, 0, bArr, i, this.gn.length);
        FH();
        return 32;
    }

    static {
        byte[] bArr = new byte[32];
        bArr[1] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[5] = (byte) -1;
        bArr[7] = (byte) -1;
        bArr[8] = (byte) -1;
        bArr[10] = (byte) -1;
        bArr[12] = (byte) -1;
        bArr[14] = (byte) -1;
        bArr[17] = (byte) -1;
        bArr[18] = (byte) -1;
        bArr[20] = (byte) -1;
        bArr[23] = (byte) -1;
        bArr[24] = (byte) -1;
        bArr[28] = (byte) -1;
        bArr[29] = (byte) -1;
        bArr[31] = (byte) -1;
        j3 = bArr;
    }

    public void FH() {
        int i;
        this.Ws = 0;
        this.J8 = 0;
        for (i = 0; i < this.gn.length; i++) {
            this.gn[i] = (byte) 0;
        }
        for (i = 0; i < this.u7.length; i++) {
            this.u7[i] = (byte) 0;
        }
        for (i = 0; i < this.tp.length; i++) {
            this.tp[i] = (byte) 0;
        }
        for (i = 0; i < this.we[1].length; i++) {
            this.we[1][i] = (byte) 0;
        }
        for (i = 0; i < this.we[3].length; i++) {
            this.we[3][i] = (byte) 0;
        }
        for (i = 0; i < this.EQ.length; i++) {
            this.EQ[i] = (byte) 0;
        }
        for (i = 0; i < this.J0.length; i++) {
            this.J0[i] = (byte) 0;
        }
        System.arraycopy(j3, 0, this.we[2], 0, j3.length);
    }

    private void Hw(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i != this.EQ.length) {
            i2 += (this.EQ[i] & 255) + (bArr[i] & 255);
            this.EQ[i] = (byte) i2;
            i2 >>>= 8;
            i++;
        }
    }

    private void j6(byte[] bArr, short[] sArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            sArr[i] = (short) (((bArr[(i * 2) + 1] << 8) & 65280) | (bArr[i * 2] & 255));
        }
    }

    private void j6(short[] sArr, byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            bArr[(i * 2) + 1] = (byte) (sArr[i] >> 8);
            bArr[i * 2] = (byte) sArr[i];
        }
    }
}
