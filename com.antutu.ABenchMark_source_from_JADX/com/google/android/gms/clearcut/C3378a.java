package com.google.android.gms.clearcut;

import android.content.Context;

/* renamed from: com.google.android.gms.clearcut.a */
public class C3378a {
    public static final C3378a f11783a;
    private static int f11784b;

    static {
        f11784b = -1;
        f11783a = new C3378a();
    }

    protected C3378a() {
    }

    public int m13919a(Context context) {
        if (f11784b < 0) {
            f11784b = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f11784b;
    }
}
