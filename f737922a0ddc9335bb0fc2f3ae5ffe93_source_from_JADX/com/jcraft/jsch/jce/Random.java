package com.jcraft.jsch.jce;

import java.security.SecureRandom;

public class Random implements com.jcraft.jsch.Random {
    private SecureRandom DW;
    private byte[] j6;

    public Random() {
        this.j6 = new byte[16];
        this.DW = null;
        this.DW = new SecureRandom();
    }

    public void j6(byte[] bArr, int i, int i2) {
        if (i2 > this.j6.length) {
            this.j6 = new byte[i2];
        }
        this.DW.nextBytes(this.j6);
        System.arraycopy(this.j6, 0, bArr, i, i2);
    }
}
