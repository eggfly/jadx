package com.p105c.p106a.p107a.p108a;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.c.a.a.a.c */
public class C2089c {
    public static byte[] m7805a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        int i2 = i >> 8;
        bArr[2] = (byte) (i2 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        i2 >>= 8;
        bArr[1] = (byte) (i2 % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        bArr[0] = (byte) ((i2 >> 8) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        return bArr;
    }
}
