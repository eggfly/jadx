package com.jcraft.jsch;

public class Buffer {
    byte[] DW;
    int FH;
    int Hw;
    final byte[] j6;

    public Buffer(int i) {
        this.j6 = new byte[4];
        this.DW = new byte[i];
        this.FH = 0;
        this.Hw = 0;
    }

    public Buffer(byte[] bArr) {
        this.j6 = new byte[4];
        this.DW = bArr;
        this.FH = 0;
        this.Hw = 0;
    }

    public Buffer() {
        this(20480);
    }

    public void j6(byte b) {
        byte[] bArr = this.DW;
        int i = this.FH;
        this.FH = i + 1;
        bArr[i] = b;
    }

    public void j6(byte[] bArr) {
        j6(bArr, 0, bArr.length);
    }

    public void j6(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.DW, this.FH, i2);
        this.FH += i2;
    }

    public void DW(byte[] bArr) {
        DW(bArr, 0, bArr.length);
    }

    public void DW(byte[] bArr, int i, int i2) {
        j6(i2);
        j6(bArr, i, i2);
    }

    public void j6(int i) {
        this.j6[0] = (byte) (i >>> 24);
        this.j6[1] = (byte) (i >>> 16);
        this.j6[2] = (byte) (i >>> 8);
        this.j6[3] = (byte) i;
        System.arraycopy(this.j6, 0, this.DW, this.FH, 4);
        this.FH += 4;
    }

    public void j6(long j) {
        this.j6[0] = (byte) ((int) (j >>> 56));
        this.j6[1] = (byte) ((int) (j >>> 48));
        this.j6[2] = (byte) ((int) (j >>> 40));
        this.j6[3] = (byte) ((int) (j >>> 32));
        System.arraycopy(this.j6, 0, this.DW, this.FH, 4);
        this.j6[0] = (byte) ((int) (j >>> 24));
        this.j6[1] = (byte) ((int) (j >>> 16));
        this.j6[2] = (byte) ((int) (j >>> 8));
        this.j6[3] = (byte) ((int) j);
        System.arraycopy(this.j6, 0, this.DW, this.FH + 4, 4);
        this.FH += 8;
    }

    void DW(int i) {
        this.FH += i;
    }

    public void FH(byte[] bArr) {
        int length = bArr.length;
        if ((bArr[0] & 128) != 0) {
            j6(length + 1);
            j6((byte) 0);
        } else {
            j6(length);
        }
        j6(bArr);
    }

    public int j6() {
        return this.FH - this.Hw;
    }

    public int DW() {
        return this.Hw;
    }

    public void FH(int i) {
        this.Hw = i;
    }

    public long FH() {
        return ((((long) Hw()) & 4294967295L) << 32) | (((long) Hw()) & 4294967295L);
    }

    public int Hw() {
        return ((Zo() << 16) & -65536) | (Zo() & 65535);
    }

    public long v5() {
        return (((((((long) VH()) << 8) & 65280) | ((long) (VH() & 255))) << 16) & -65536) | ((((((long) VH()) << 8) & 65280) | ((long) (VH() & 255))) & 65535);
    }

    int Zo() {
        return ((VH() << 8) & 65280) | (VH() & 255);
    }

    public int VH() {
        byte[] bArr = this.DW;
        int i = this.Hw;
        this.Hw = i + 1;
        return bArr[i] & 255;
    }

    public void Hw(byte[] bArr) {
        FH(bArr, 0, bArr.length);
    }

    void FH(byte[] bArr, int i, int i2) {
        System.arraycopy(this.DW, this.Hw, bArr, i, i2);
        this.Hw += i2;
    }

    public int Hw(int i) {
        int i2 = this.Hw;
        this.Hw += i;
        return i2;
    }

    public byte[] gn() {
        int Hw = Hw();
        if (Hw < 0 || Hw > 8192) {
            Hw = 8192;
        }
        byte[] bArr = new byte[Hw];
        FH(bArr, 0, Hw);
        return bArr;
    }

    public byte[] u7() {
        int Hw = (Hw() + 7) / 8;
        Object obj = new byte[Hw];
        FH(obj, 0, Hw);
        if ((obj[0] & 128) == 0) {
            return obj;
        }
        Object obj2 = new byte[(obj.length + 1)];
        obj2[0] = null;
        System.arraycopy(obj, 0, obj2, 1, obj.length);
        return obj2;
    }

    public byte[] tp() {
        int Hw = Hw();
        if (Hw < 0 || Hw > 262144) {
            Hw = 262144;
        }
        byte[] bArr = new byte[Hw];
        FH(bArr, 0, Hw);
        return bArr;
    }

    byte[] j6(int[] iArr, int[] iArr2) {
        int Hw = Hw();
        iArr[0] = Hw(Hw);
        iArr2[0] = Hw;
        return this.DW;
    }

    public void EQ() {
        this.FH = 0;
        this.Hw = 0;
    }

    public void we() {
        if (this.Hw != 0) {
            System.arraycopy(this.DW, this.Hw, this.DW, 0, this.FH - this.Hw);
            this.FH -= this.Hw;
            this.Hw = 0;
        }
    }

    void J0() {
        this.Hw = 0;
    }

    byte J8() {
        return this.DW[5];
    }

    void v5(int i) {
        int i2 = (this.FH + i) + 84;
        if (this.DW.length < i2) {
            int length = this.DW.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            Object obj = new byte[i2];
            System.arraycopy(this.DW, 0, obj, 0, this.FH);
            this.DW = obj;
        }
    }

    byte[][] j6(int i, String str) {
        byte[][] bArr = new byte[i][];
        for (int i2 = 0; i2 < i; i2++) {
            int Hw = Hw();
            if (j6() < Hw) {
                throw new JSchException(str);
            }
            bArr[i2] = new byte[Hw];
            Hw(bArr[i2]);
        }
        return bArr;
    }

    static Buffer j6(byte[][] bArr) {
        int i = 0;
        int length = bArr.length * 4;
        for (byte[] length2 : bArr) {
            length += length2.length;
        }
        Buffer buffer = new Buffer(length);
        while (i < bArr.length) {
            buffer.DW(bArr[i]);
            i++;
        }
        return buffer;
    }
}
