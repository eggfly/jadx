package com.jcraft.jsch.jcraft;

import com.jcraft.jsch.MAC;
import java.security.MessageDigest;

public class HMACSHA1 extends HMAC implements MAC {
    public /* bridge */ /* synthetic */ int j6() {
        return super.j6();
    }

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i) {
        super.j6(bArr, i);
    }

    public /* bridge */ /* synthetic */ void j6(byte[] bArr, int i, int i2) {
        super.j6(bArr, i, i2);
    }

    public HMACSHA1() {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            System.err.println(e);
        }
        j6(messageDigest);
    }
}
