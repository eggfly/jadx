package com.baidu.mobads;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebView;

public class ac extends WebView {
    public ac(Context context) {
        super(context);
        m7201a();
    }

    private void m7201a() {
        try {
            if (Integer.parseInt(VERSION.SDK) >= 11) {
                Class.forName("android.webkit.WebView").getDeclaredMethod("removeJavascriptInterface", new Class[]{String.class}).invoke(this, new Object[]{"searchBoxJavaBridge_"});
            }
        } catch (Exception e) {
        }
    }
}
