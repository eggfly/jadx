package com.jcraft.jsch.jce;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class SignatureRSA implements com.jcraft.jsch.SignatureRSA {
    KeyFactory DW;
    Signature j6;

    public void j6() {
        this.j6 = Signature.getInstance("SHA1withRSA");
        this.DW = KeyFactory.getInstance("RSA");
    }

    public void j6(byte[] bArr, byte[] bArr2) {
        this.j6.initVerify(this.DW.generatePublic(new RSAPublicKeySpec(new BigInteger(bArr2), new BigInteger(bArr))));
    }

    public void DW(byte[] bArr, byte[] bArr2) {
        this.j6.initSign(this.DW.generatePrivate(new RSAPrivateKeySpec(new BigInteger(bArr2), new BigInteger(bArr))));
    }

    public byte[] DW() {
        return this.j6.sign();
    }

    public void j6(byte[] bArr) {
        this.j6.update(bArr);
    }

    public boolean DW(byte[] bArr) {
        if (bArr[0] == null && bArr[1] == null && bArr[2] == null) {
            int i = (((((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255)) + 4;
            int i2 = i + 1;
            int i3 = i2 + 1;
            i = ((bArr[i] << 24) & -16777216) | ((bArr[i2] << 16) & 16711680);
            i2 = i3 + 1;
            i |= (bArr[i3] << 8) & 65280;
            i3 = i2 + 1;
            i2 = (bArr[i2] & 255) | i;
            Object obj = new byte[i2];
            System.arraycopy(bArr, i3, obj, 0, i2);
            bArr = obj;
        }
        return this.j6.verify(bArr);
    }
}
