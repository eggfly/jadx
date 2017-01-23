package com.facebook.ads.internal.util;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import anet.channel.security.ISecurity;
import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.util.r */
public class C2510r {
    public static boolean m9516a(String str) {
        return str == null || str.length() <= 0;
    }

    public static String m9517b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(ISecurity.SIGN_ALGORITHM_MD5).digest(str.getBytes("utf-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & MotionEventCompat.ACTION_MASK) + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
