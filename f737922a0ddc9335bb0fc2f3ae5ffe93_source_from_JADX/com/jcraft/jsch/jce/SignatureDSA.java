package com.jcraft.jsch.jce;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;

public class SignatureDSA implements com.jcraft.jsch.SignatureDSA {
    KeyFactory DW;
    Signature j6;

    public void j6() {
        this.j6 = Signature.getInstance("SHA1withDSA");
        this.DW = KeyFactory.getInstance("DSA");
    }

    public void j6(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.j6.initVerify(this.DW.generatePublic(new DSAPublicKeySpec(new BigInteger(bArr), new BigInteger(bArr2), new BigInteger(bArr3), new BigInteger(bArr4))));
    }

    public void DW(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.j6.initSign(this.DW.generatePrivate(new DSAPrivateKeySpec(new BigInteger(bArr), new BigInteger(bArr2), new BigInteger(bArr3), new BigInteger(bArr4))));
    }

    public byte[] DW() {
        int i = 1;
        int i2 = 20;
        Object sign = this.j6.sign();
        int i3 = sign[3] & 255;
        Object obj = new byte[i3];
        System.arraycopy(sign, 4, obj, 0, obj.length);
        i3 = (i3 + 4) + 1;
        Object obj2 = new byte[(sign[i3] & 255)];
        System.arraycopy(sign, i3 + 1, obj2, 0, obj2.length);
        Object obj3 = new byte[40];
        System.arraycopy(obj, obj.length > 20 ? 1 : 0, obj3, obj.length > 20 ? 0 : 20 - obj.length, obj.length > 20 ? 20 : obj.length);
        if (obj2.length <= 20) {
            i = 0;
        }
        int length = obj2.length > 20 ? 20 : 40 - obj2.length;
        if (obj2.length <= 20) {
            i2 = obj2.length;
        }
        System.arraycopy(obj2, i, obj3, length, i2);
        return obj3;
    }

    public void j6(byte[] bArr) {
        this.j6.update(bArr);
    }

    public boolean DW(byte[] bArr) {
        int i;
        int i2;
        if (bArr[0] == null && bArr[1] == null && bArr[2] == null) {
            i = (((((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680)) | ((bArr[2] << 8) & 65280)) | (bArr[3] & 255)) + 4;
            i2 = i + 1;
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
        i = (bArr[0] & 128) != 0 ? 1 : 0;
        if ((bArr[20] & 128) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        Object obj2 = new byte[(((bArr.length + 6) + i) + i2)];
        obj2[0] = (byte) 48;
        obj2[1] = (byte) 44;
        obj2[1] = (byte) (obj2[1] + i);
        obj2[1] = (byte) (obj2[1] + i2);
        obj2[2] = 2;
        obj2[3] = 20;
        obj2[3] = (byte) (obj2[3] + i);
        System.arraycopy(bArr, 0, obj2, i + 4, 20);
        obj2[obj2[3] + 4] = 2;
        obj2[obj2[3] + 5] = 20;
        i = obj2[3] + 5;
        obj2[i] = (byte) (obj2[i] + i2);
        System.arraycopy(bArr, 20, obj2, (obj2[3] + 6) + i2, 20);
        return this.j6.verify(obj2);
    }
}
