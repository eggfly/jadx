package com.baidu.mobads.openad.p095b;

import android.webkit.CookieManager;

/* renamed from: com.baidu.mobads.openad.b.c */
final class C2008c implements Runnable {
    C2008c() {
    }

    public void run() {
        CookieManager.getInstance().removeExpiredCookie();
    }
}
