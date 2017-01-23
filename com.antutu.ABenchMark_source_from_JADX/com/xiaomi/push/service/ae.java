package com.xiaomi.push.service;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.xiaomi.channel.commonutils.logger.C4302b;
import com.xiaomi.channel.commonutils.string.C4326a;

public class ae {
    private static int f15009a;
    private byte[] f15010b;
    private int f15011c;
    private int f15012d;
    private int f15013e;

    static {
        f15009a = 8;
    }

    public ae() {
        this.f15013e = -666;
        this.f15010b = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        this.f15012d = 0;
        this.f15011c = 0;
    }

    public static int m18119a(byte b) {
        return b >= null ? b : b + AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public static String m18120a(byte[] bArr, String str) {
        return String.valueOf(C4326a.m17734a(m18125a(bArr, str.getBytes())));
    }

    private void m18121a(int i, byte[] bArr, boolean z) {
        int i2 = 0;
        int length = bArr.length;
        for (int i3 = 0; i3 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i3++) {
            this.f15010b[i3] = (byte) i3;
        }
        this.f15012d = 0;
        this.f15011c = 0;
        while (this.f15011c < i) {
            this.f15012d = ((this.f15012d + m18119a(this.f15010b[this.f15011c])) + m18119a(bArr[this.f15011c % length])) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
            m18123a(this.f15010b, this.f15011c, this.f15012d);
            this.f15011c++;
        }
        if (i != AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
            this.f15013e = ((this.f15012d + m18119a(this.f15010b[i])) + m18119a(bArr[i % length])) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        }
        if (z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("S_").append(i - 1).append(":");
            while (i2 <= i) {
                stringBuilder.append(" ").append(m18119a(this.f15010b[i2]));
                i2++;
            }
            stringBuilder.append("   j_").append(i - 1).append("=").append(this.f15012d);
            stringBuilder.append("   j_").append(i).append("=").append(this.f15013e);
            stringBuilder.append("   S_").append(i - 1).append("[j_").append(i - 1).append("]=").append(m18119a(this.f15010b[this.f15012d]));
            stringBuilder.append("   S_").append(i - 1).append("[j_").append(i).append("]=").append(m18119a(this.f15010b[this.f15013e]));
            if (this.f15010b[1] != null) {
                stringBuilder.append("   S[1]!=0");
            }
            C4302b.m17649a(stringBuilder.toString());
        }
    }

    private void m18122a(byte[] bArr) {
        m18121a((int) AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, bArr, false);
    }

    private static void m18123a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] m18124a(String str, String str2) {
        int i = 0;
        byte[] a = C4326a.m17731a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[((a.length + 1) + bytes.length)];
        for (int i2 = 0; i2 < a.length; i2++) {
            bArr[i2] = a[i2];
        }
        bArr[a.length] = (byte) 95;
        while (i < bytes.length) {
            bArr[(a.length + 1) + i] = bytes[i];
            i++;
        }
        return bArr;
    }

    public static byte[] m18125a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ae aeVar = new ae();
        aeVar.m18122a(bArr);
        aeVar.m18126b();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ aeVar.m18128a());
        }
        return bArr3;
    }

    private void m18126b() {
        this.f15012d = 0;
        this.f15011c = 0;
    }

    public static byte[] m18127b(byte[] bArr, String str) {
        return m18125a(bArr, C4326a.m17731a(str));
    }

    byte m18128a() {
        this.f15011c = (this.f15011c + 1) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        this.f15012d = (this.f15012d + m18119a(this.f15010b[this.f15011c])) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        m18123a(this.f15010b, this.f15011c, this.f15012d);
        return this.f15010b[(m18119a(this.f15010b[this.f15011c]) + m18119a(this.f15010b[this.f15012d])) % AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
    }
}
