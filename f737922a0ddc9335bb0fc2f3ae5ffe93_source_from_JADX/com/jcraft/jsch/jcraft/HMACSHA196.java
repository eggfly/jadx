package com.jcraft.jsch.jcraft;

public class HMACSHA196 extends HMACSHA1 {
    private final byte[] j6;

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i, int i2) {
        super.j6(bArr, i, i2);
    }

    public HMACSHA196() {
        this.j6 = new byte[20];
    }

    public int j6() {
        return 12;
    }

    public void j6(byte[] bArr, int i) {
        super.j6(this.j6, 0);
        System.arraycopy(this.j6, 0, bArr, i, 12);
    }
}
