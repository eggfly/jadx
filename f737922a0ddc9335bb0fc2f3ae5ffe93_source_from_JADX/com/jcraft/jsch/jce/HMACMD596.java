package com.jcraft.jsch.jce;

public class HMACMD596 extends HMACMD5 {
    private final byte[] Hw;

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i, int i2) {
        super.j6(bArr, i, i2);
    }

    public HMACMD596() {
        this.Hw = new byte[16];
        this.j6 = "hmac-md5-96";
    }

    public int j6() {
        return 12;
    }

    public void j6(byte[] bArr, int i) {
        super.j6(this.Hw, 0);
        System.arraycopy(this.Hw, 0, bArr, i, 12);
    }
}
