package com.xiaomi.mistatistic.sdk;

import com.xiaomi.mistatistic.sdk.controller.C0555d.C0523a;
import com.xiaomi.mistatistic.sdk.controller.C0559f;

public class CustomSettings {
    private static boolean f4642a;
    private static boolean f4643b;
    private static boolean f4644c;
    private static boolean f4645d;
    private static boolean f4646e;

    /* renamed from: com.xiaomi.mistatistic.sdk.CustomSettings.a */
    static class C0524a implements C0523a {
        C0524a() {
        }

        public void m6251a() {
            new C0559f().m6390c(System.currentTimeMillis() + 1000);
        }
    }

    static {
        f4642a = false;
        f4643b = false;
        f4644c = true;
        f4645d = false;
        f4646e = false;
    }

    public static void m6252a(boolean z) {
        f4642a = z;
    }

    public static boolean m6253a() {
        return f4642a;
    }

    public static boolean m6254b() {
        return f4643b;
    }

    public static boolean m6255c() {
        return f4644c;
    }

    public static boolean m6256d() {
        return f4645d;
    }

    public static boolean m6257e() {
        return f4646e;
    }
}
