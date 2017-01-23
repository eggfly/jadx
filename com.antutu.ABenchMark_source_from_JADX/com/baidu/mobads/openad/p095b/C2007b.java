package com.baidu.mobads.openad.p095b;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.mobads.openad.p096e.C2021a;

/* renamed from: com.baidu.mobads.openad.b.b */
public class C2007b implements C2006a {
    public static Context f6988a;

    public C2007b() {
        Class.forName("android.webkit.CookieManager", true, C2021a.class.getClassLoader());
    }

    public static void m7486a(Context context) {
        if (f6988a == null) {
            f6988a = context;
            CookieSyncManager.createInstance(f6988a);
            if (VERSION.SDK_INT < 21) {
                new Thread(new C2008c()).start();
            }
        }
    }

    public String m7487a(String str) {
        return CookieManager.getInstance().getCookie(str);
    }

    public void m7488a() {
        CookieManager.getInstance().removeExpiredCookie();
    }

    public void m7489a(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }
}
