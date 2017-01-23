package com.jcraft.jsch.jce;

import com.jcraft.jsch.HASH;
import java.security.MessageDigest;

public class SHA256 implements HASH {
    MessageDigest j6;

    public int DW() {
        return 32;
    }

    public void j6() {
        try {
            this.j6 = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void j6(byte[] bArr, int i, int i2) {
        this.j6.update(bArr, i, i2);
    }

    public byte[] FH() {
        return this.j6.digest();
    }
}
