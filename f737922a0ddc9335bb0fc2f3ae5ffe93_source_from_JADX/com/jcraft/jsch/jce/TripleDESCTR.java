package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class TripleDESCTR implements Cipher {
    private javax.crypto.Cipher j6;

    public int j6() {
        return 8;
    }

    public int DW() {
        return 24;
    }

    public void j6(int i, byte[] bArr, byte[] bArr2) {
        String str = "NoPadding";
        if (bArr2.length > 8) {
            Object obj = new byte[8];
            System.arraycopy(bArr2, 0, obj, 0, obj.length);
            bArr2 = obj;
        }
        if (bArr.length > 24) {
            obj = new byte[24];
            System.arraycopy(bArr, 0, obj, 0, obj.length);
            bArr = obj;
        }
        try {
            this.j6 = javax.crypto.Cipher.getInstance("DESede/CTR/" + str);
            Key generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr));
            synchronized (javax.crypto.Cipher.class) {
                int i2;
                javax.crypto.Cipher cipher = this.j6;
                if (i == 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                cipher.init(i2, generateSecret, new IvParameterSpec(bArr2));
            }
        } catch (Exception e) {
            this.j6 = null;
            throw e;
        }
    }

    public void j6(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.j6.update(bArr, i, i2, bArr2, i3);
    }

    public boolean FH() {
        return false;
    }
}
