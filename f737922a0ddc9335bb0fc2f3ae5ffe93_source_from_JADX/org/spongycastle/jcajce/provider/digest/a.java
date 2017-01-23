package org.spongycastle.jcajce.provider.digest;

import ben;
import java.security.MessageDigest;

public class a extends MessageDigest {
    protected ben j6;

    protected a(ben ben) {
        super(ben.j6());
        this.j6 = ben;
    }

    public void engineReset() {
        this.j6.FH();
    }

    public void engineUpdate(byte b) {
        this.j6.j6(b);
    }

    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.j6.j6(bArr, i, i2);
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.j6.DW()];
        this.j6.j6(bArr, 0);
        return bArr;
    }
}
