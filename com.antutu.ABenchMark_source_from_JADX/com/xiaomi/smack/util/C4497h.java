package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.C4312f;
import com.xiaomi.channel.commonutils.misc.C4312f.C4311b;

/* renamed from: com.xiaomi.smack.util.h */
public class C4497h {
    private static C4312f f15466a;

    static {
        f15466a = new C4312f(true, 20);
    }

    public static void m18653a(C4311b c4311b) {
        f15466a.m17686a(c4311b);
    }

    public static void m18654a(C4311b c4311b, long j) {
        f15466a.m17687a(c4311b, j);
    }

    public static void m18655a(Runnable runnable) {
        f15466a.m17686a(new C4498i(runnable));
    }
}
