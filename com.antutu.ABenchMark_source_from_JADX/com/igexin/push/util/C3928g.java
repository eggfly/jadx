package com.igexin.push.util;

import android.content.Context;

/* renamed from: com.igexin.push.util.g */
final class C3928g implements Runnable {
    final /* synthetic */ Context f13196a;

    C3928g(Context context) {
        this.f13196a = context;
    }

    public void run() {
        C3926e.m16165b(this.f13196a, String.valueOf(System.currentTimeMillis()));
    }
}
