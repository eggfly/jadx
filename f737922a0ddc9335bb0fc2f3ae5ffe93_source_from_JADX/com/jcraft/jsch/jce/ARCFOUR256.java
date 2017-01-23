package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

public class ARCFOUR256 implements Cipher {
    private javax.crypto.Cipher j6;

    public int j6() {
        return 8;
    }

    public int DW() {
        return 32;
    }

    public void j6(int i, byte[] bArr, byte[] bArr2) {
        int i2 = 1;
        if (bArr.length > 32) {
            Object obj = new byte[32];
            System.arraycopy(bArr, 0, obj, 0, obj.length);
            bArr = obj;
        }
        try {
            this.j6 = javax.crypto.Cipher.getInstance("RC4");
            Key secretKeySpec = new SecretKeySpec(bArr, "RC4");
            synchronized (javax.crypto.Cipher.class) {
                javax.crypto.Cipher cipher = this.j6;
                if (i != 0) {
                    i2 = 2;
                }
                cipher.init(i2, secretKeySpec);
            }
            byte[] bArr3 = new byte[1];
            for (int i3 = 0; i3 < 1536; i3++) {
                this.j6.update(bArr3, 0, 1, bArr3, 0);
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
