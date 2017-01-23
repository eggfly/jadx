package com.google.android.gms.p146b;

import anet.channel.security.ISecurity;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.gms.b.ad */
public abstract class ad {
    private static MessageDigest f10233b;
    protected Object f10234a;

    static {
        f10233b = null;
    }

    public ad() {
        this.f10234a = new Object();
    }

    protected MessageDigest m11752a() {
        MessageDigest messageDigest;
        synchronized (this.f10234a) {
            if (f10233b != null) {
                messageDigest = f10233b;
            } else {
                for (int i = 0; i < 2; i++) {
                    try {
                        f10233b = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
                    } catch (NoSuchAlgorithmException e) {
                    }
                }
                messageDigest = f10233b;
            }
        }
        return messageDigest;
    }

    abstract byte[] m11753a(String str);
}
