package com.miui.support.internal.hybrid.provider;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.miui.support.internal.hybrid.webkit.WebkitFactoryProvider;

public class WebViewFactory {
    private static WebViewFactoryProvider f2489a;
    private static final Object f2490b;

    static {
        f2490b = new Object();
    }

    public static WebViewFactoryProvider m4134a(Context context) {
        WebViewFactoryProvider webViewFactoryProvider;
        synchronized (f2490b) {
            if (f2489a != null) {
                webViewFactoryProvider = f2489a;
            } else {
                String str = null;
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        str = bundle.getString("com.miui.sdk.hybrid.webview");
                    }
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (str != null) {
                    try {
                        f2489a = (WebViewFactoryProvider) Class.forName(str, false, context.getClassLoader()).newInstance();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (f2489a == null) {
                    f2489a = new WebkitFactoryProvider();
                }
                if (Log.isLoggable("hybrid", 3)) {
                    Log.d("hybrid", "loaded provider:" + f2489a);
                }
                webViewFactoryProvider = f2489a;
            }
        }
        return webViewFactoryProvider;
    }
}
