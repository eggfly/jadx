package com.google.android.gms.internal;

import java.security.MessageDigest;

@eh
public class ak extends ah {
    private MessageDigest DW;

    byte[] DW(int i) {
        int i2 = (65535 & i) ^ ((-65536 & i) >> 16);
        return new byte[]{(byte) i2, (byte) (i2 >> 8)};
    }

    byte j6(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    public byte[] j6(String str) {
        byte[] bArr;
        int i = 4;
        byte[] j6 = j6(str.split(" "));
        this.DW = j6();
        synchronized (this.j6) {
            if (this.DW == null) {
                bArr = new byte[0];
            } else {
                this.DW.reset();
                this.DW.update(j6);
                Object digest = this.DW.digest();
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }

    byte[] j6(String[] strArr) {
        int i = 0;
        if (strArr.length == 1) {
            return aj.DW(aj.j6(strArr[0]));
        }
        if (strArr.length < 5) {
            byte[] bArr = new byte[(strArr.length * 2)];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] DW = DW(aj.j6(strArr[i2]));
                bArr[i2 * 2] = DW[0];
                bArr[(i2 * 2) + 1] = DW[1];
            }
            return bArr;
        }
        byte[] bArr2 = new byte[strArr.length];
        while (i < strArr.length) {
            bArr2[i] = j6(aj.j6(strArr[i]));
            i++;
        }
        return bArr2;
    }
}
