package com.facebook.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.C2409e;
import java.lang.reflect.Constructor;

/* renamed from: com.facebook.ads.internal.util.h */
public class C2499h {
    private static String f8587a;

    static {
        f8587a = null;
    }

    public static String m9489a() {
        if (C2510r.m9516a(AdSettings.getUrlPrefix())) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", new Object[]{AdSettings.getUrlPrefix()});
    }

    @TargetApi(17)
    private static String m9490a(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }

    public static String m9491a(Context context, C2409e c2409e) {
        if (c2409e == C2409e.NATIVE_250 || c2409e == C2409e.NATIVE_UNKNOWN || c2409e == null) {
            return System.getProperty("http.agent");
        }
        if (f8587a == null) {
            if (VERSION.SDK_INT >= 17) {
                try {
                    f8587a = C2499h.m9490a(context);
                    return f8587a;
                } catch (Exception e) {
                }
            }
            try {
                f8587a = C2499h.m9492a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f8587a = C2499h.m9492a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f8587a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
        }
        return f8587a;
    }

    private static String m9492a(Context context, String str, String str2) {
        Class cls = Class.forName(str);
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            String str3 = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
            return str3;
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    public static void m9493a(WebView webView) {
        webView.loadUrl("about:blank");
        webView.clearCache(true);
        if (VERSION.SDK_INT > 11) {
            webView.onPause();
            return;
        }
        try {
            WebView.class.getMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
        }
    }

    @TargetApi(21)
    public static void m9494b(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod("setMixedContentMode", new Class[0]).invoke(settings, new Object[]{Integer.valueOf(0)});
        } catch (Exception e) {
        }
    }
}
