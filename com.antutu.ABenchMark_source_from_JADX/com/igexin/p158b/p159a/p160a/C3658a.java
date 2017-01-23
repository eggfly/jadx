package com.igexin.p158b.p159a.p160a;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.igexin.b.a.a.a */
public class C3658a {
    public static void m14932a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static boolean m14933a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
            return false;
        }
        length = 0;
        for (byte b : bArr) {
            if ((b & MotionEventCompat.ACTION_MASK) == 14) {
                length++;
                if (length > 3) {
                    return false;
                }
            }
        }
        return true;
    }

    public static byte[] m14934a(byte[] bArr, String str) {
        return C3658a.m14937c(bArr, str);
    }

    public static byte[] m14935a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (!C3658a.m14933a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        } else if (bArr.length < 1) {
            throw new IllegalArgumentException("data is fail!");
        } else {
            int i2;
            int[] iArr = new int[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
            for (i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = i2;
            }
            int i3 = 0;
            for (i2 = 0; i2 < iArr.length; i2++) {
                i3 = ((i3 + iArr[i2]) + (bArr2[i2 % bArr2.length] & MotionEventCompat.ACTION_MASK)) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                C3658a.m14932a(iArr, i2, i3);
            }
            byte[] bArr3 = new byte[bArr.length];
            i2 = 0;
            i3 = 0;
            while (i < bArr3.length) {
                i2 = (i2 + 1) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                i3 = (i3 + iArr[i2]) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
                C3658a.m14932a(iArr, i2, i3);
                bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[i3]) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY] ^ bArr[i]);
                i++;
            }
            return bArr3;
        }
    }

    public static byte[] m14936b(byte[] bArr, String str) {
        return C3658a.m14938d(bArr, str);
    }

    public static byte[] m14937c(byte[] bArr, String str) {
        return C3658a.m14935a(bArr, str.getBytes());
    }

    public static byte[] m14938d(byte[] bArr, String str) {
        return C3658a.m14935a(bArr, str.getBytes());
    }
}
