package com.jcraft.jsch.jce;

import com.jcraft.jsch.MAC;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

abstract class HMAC implements MAC {
    protected int DW;
    protected String FH;
    private Mac Hw;
    protected String j6;
    private final byte[] v5;

    HMAC() {
        this.v5 = new byte[4];
    }

    public int j6() {
        return this.DW;
    }

    public void j6(byte[] bArr) {
        if (bArr.length > this.DW) {
            Object obj = new byte[this.DW];
            System.arraycopy(bArr, 0, obj, 0, this.DW);
            bArr = obj;
        }
        Key secretKeySpec = new SecretKeySpec(bArr, this.FH);
        this.Hw = Mac.getInstance(this.FH);
        this.Hw.init(secretKeySpec);
    }

    public void j6(int i) {
        this.v5[0] = (byte) (i >>> 24);
        this.v5[1] = (byte) (i >>> 16);
        this.v5[2] = (byte) (i >>> 8);
        this.v5[3] = (byte) i;
        j6(this.v5, 0, 4);
    }

    public void j6(byte[] bArr, int i, int i2) {
        this.Hw.update(bArr, i, i2);
    }

    public void j6(byte[] bArr, int i) {
        try {
            this.Hw.doFinal(bArr, i);
        } catch (ShortBufferException e) {
            System.err.println(e);
        }
    }
}
