package com.google.android.gms.p146b;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.android.gms.b.kf */
public class kf {
    private final byte[] f11610a;
    private int f11611b;
    private int f11612c;

    public kf(byte[] bArr) {
        int i;
        this.f11610a = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.f11610a[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.f11610a[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f11610a[i2];
            this.f11610a[i2] = this.f11610a[i];
            this.f11610a[i] = b;
        }
        this.f11611b = 0;
        this.f11612c = 0;
    }

    public void m13618a(byte[] bArr) {
        int i = this.f11611b;
        int i2 = this.f11612c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.f11610a[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f11610a[i];
            this.f11610a[i] = this.f11610a[i2];
            this.f11610a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f11610a[(this.f11610a[i] + this.f11610a[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.f11611b = i;
        this.f11612c = i2;
    }
}
