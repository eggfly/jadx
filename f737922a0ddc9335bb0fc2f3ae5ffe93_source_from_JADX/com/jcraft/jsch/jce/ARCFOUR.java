package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

public class ARCFOUR implements Cipher {
    private javax.crypto.Cipher j6;

    public int j6() {
        return 8;
    }

    public int DW() {
        return 16;
    }

    public void j6(int i, byte[] bArr, byte[] bArr2) {
        String str = "NoPadding";
        if (bArr.length > 16) {
            Object obj = new byte[16];
            System.arraycopy(bArr, 0, obj, 0, obj.length);
            bArr = obj;
        }
        try {
            this.j6 = javax.crypto.Cipher.getInstance("RC4");
            Key secretKeySpec = new SecretKeySpec(bArr, "RC4");
            synchronized (javax.crypto.Cipher.class) {
                int i2;
                javax.crypto.Cipher cipher = this.j6;
                if (i == 0) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                cipher.init(i2, secretKeySpec);
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
