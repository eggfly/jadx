class qp$b {
    private final byte[] DW;
    private final int FH;
    private final byte[] j6;

    public qp$b(byte[] bArr) {
        int i = 0;
        this.j6 = new byte[256];
        this.DW = new byte[256];
        if (bArr.length < 1 || bArr.length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        this.FH = bArr.length;
        for (i2 = 0; i2 < 256; i2++) {
            this.j6[i2] = (byte) i2;
            this.DW[i2] = bArr[i2 % this.FH];
        }
        i2 = 0;
        while (i < 256) {
            i2 = ((i2 + this.j6[i]) + this.DW[i]) & 255;
            byte b = this.j6[i2];
            this.j6[i2] = this.j6[i];
            this.j6[i] = b;
            i++;
        }
    }

    public byte[] j6(byte[] bArr) {
        int i = 0;
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length) {
            i3 = (i3 + 1) & 255;
            i2 = (i2 + this.j6[i3]) & 255;
            byte b = this.j6[i2];
            this.j6[i2] = this.j6[i3];
            this.j6[i3] = b;
            bArr2[i] = (byte) (this.j6[(this.j6[i3] + this.j6[i2]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr2;
    }

    public byte[] DW(byte[] bArr) {
        return j6(bArr);
    }
}
