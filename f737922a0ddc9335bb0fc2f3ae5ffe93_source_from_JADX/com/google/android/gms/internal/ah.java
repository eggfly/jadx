package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@eh
public abstract class ah {
    private static MessageDigest DW;
    protected Object j6;

    static {
        DW = null;
    }

    public ah() {
        this.j6 = new Object();
    }

    protected MessageDigest j6() {
        MessageDigest messageDigest;
        synchronized (this.j6) {
            if (DW != null) {
                messageDigest = DW;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        DW = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = DW;
            }
        }
        return messageDigest;
    }

    abstract byte[] j6(String str);
}
