package com.jcraft.jsch.jcraft;

import java.security.MessageDigest;

class HMAC {
    private byte[] DW;
    private MessageDigest FH;
    private int Hw;
    private byte[] j6;
    private final byte[] v5;

    HMAC() {
        this.j6 = null;
        this.DW = null;
        this.FH = null;
        this.Hw = 0;
        this.v5 = new byte[4];
    }

    protected void j6(MessageDigest messageDigest) {
        this.FH = messageDigest;
        this.Hw = messageDigest.getDigestLength();
    }

    public int j6() {
        return this.Hw;
    }

    public void j6(byte[] bArr) {
        this.FH.reset();
        if (bArr.length > this.Hw) {
            Object obj = new byte[this.Hw];
            System.arraycopy(bArr, 0, obj, 0, this.Hw);
            bArr = obj;
        }
        if (bArr.length > 64) {
            this.FH.update(bArr, 0, bArr.length);
            bArr = this.FH.digest();
        }
        this.j6 = new byte[64];
        System.arraycopy(bArr, 0, this.j6, 0, bArr.length);
        this.DW = new byte[64];
        System.arraycopy(bArr, 0, this.DW, 0, bArr.length);
        for (int i = 0; i < 64; i++) {
            byte[] bArr2 = this.j6;
            bArr2[i] = (byte) (bArr2[i] ^ 54);
            bArr2 = this.DW;
            bArr2[i] = (byte) (bArr2[i] ^ 92);
        }
        this.FH.update(this.j6, 0, 64);
    }

    public void j6(int i) {
        this.v5[0] = (byte) (i >>> 24);
        this.v5[1] = (byte) (i >>> 16);
        this.v5[2] = (byte) (i >>> 8);
        this.v5[3] = (byte) i;
        j6(this.v5, 0, 4);
    }

    public void j6(byte[] bArr, int i, int i2) {
        this.FH.update(bArr, i, i2);
    }

    public void j6(byte[] bArr, int i) {
        byte[] digest = this.FH.digest();
        this.FH.update(this.DW, 0, 64);
        this.FH.update(digest, 0, this.Hw);
        try {
            this.FH.digest(bArr, i, this.Hw);
        } catch (Exception e) {
        }
        this.FH.update(this.j6, 0, 64);
    }
}
