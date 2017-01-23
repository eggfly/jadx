package com.jcraft.jsch.jce;

public class HMACSHA196 extends HMACSHA1 {
    private final byte[] Hw;

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i, int i2) {
        super.j6(bArr, i, i2);
    }

    public HMACSHA196() {
        this.Hw = new byte[20];
        this.j6 = "hmac-sha1-96";
    }

    public int j6() {
        return 12;
    }

    public void j6(byte[] bArr, int i) {
        super.j6(this.Hw, 0);
        System.arraycopy(this.Hw, 0, bArr, i, 12);
    }
}
