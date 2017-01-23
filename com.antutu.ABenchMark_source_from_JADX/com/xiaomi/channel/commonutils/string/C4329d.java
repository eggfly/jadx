package com.xiaomi.channel.commonutils.string;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import anet.channel.security.ISecurity;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* renamed from: com.xiaomi.channel.commonutils.string.d */
public class C4329d {
    public static String m17741a(int i) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".length())));
        }
        return stringBuffer.toString();
    }

    public static String m17742a(String str) {
        if (str == null) {
            return BuildConfig.FLAVOR;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(C4329d.m17747c(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    public static String m17743a(Collection<?> collection, String str) {
        return collection == null ? null : C4329d.m17744a(collection.iterator(), str);
    }

    public static String m17744a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return BuildConfig.FLAVOR;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            next = it.next();
            if (next != null) {
                stringBuffer.append(next);
            }
        }
        return stringBuffer.toString();
    }

    public static String m17745a(byte[] bArr) {
        String str = BuildConfig.FLAVOR;
        try {
            MessageDigest instance = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5);
            instance.update(bArr);
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            str = String.format("%1$032X", new Object[]{bigInteger});
        } catch (Exception e) {
        }
        return str.toLowerCase();
    }

    public static String m17746b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(C4329d.m17747c(str));
            BigInteger bigInteger = new BigInteger(1, instance.digest());
            return String.format("%1$032X", new Object[]{bigInteger});
        } catch (NoSuchAlgorithmException e) {
            return str;
        }
    }

    public static byte[] m17747c(String str) {
        try {
            return str.getBytes(HttpRequest.f14548a);
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }
}
