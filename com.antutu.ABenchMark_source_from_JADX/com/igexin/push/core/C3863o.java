package com.igexin.push.core;

import com.igexin.push.config.C3753l;
import com.igexin.sdk.aidl.C3864a;

/* renamed from: com.igexin.push.core.o */
public class C3863o {
    private static String f13007a;
    private static C3864a f13008b;

    static {
        f13007a = C3753l.f12646a;
    }

    public static C3864a m15907a() {
        if (f13008b == null) {
            f13008b = new C3865p();
        }
        return f13008b;
    }
}
