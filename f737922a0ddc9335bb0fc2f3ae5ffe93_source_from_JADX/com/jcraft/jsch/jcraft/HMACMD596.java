package com.jcraft.jsch.jcraft;

public class HMACMD596 extends HMACMD5 {
    private final byte[] j6;

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i, int i2) {
        super.j6(bArr, i, i2);
    }

    public HMACMD596() {
        this.j6 = new byte[16];
    }

    public int j6() {
        return 12;
    }

    public void j6(byte[] bArr, int i) {
        super.j6(this.j6, 0);
        System.arraycopy(this.j6, 0, bArr, i, 12);
    }
}
