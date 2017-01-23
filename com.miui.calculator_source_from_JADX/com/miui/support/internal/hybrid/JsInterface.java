package com.miui.support.internal.hybrid;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsInterface {
    private HybridManager f2462a;

    public JsInterface(HybridManager hybridManager) {
        this.f2462a = hybridManager;
    }

    @JavascriptInterface
    public String config(String str) {
        String a = this.f2462a.m4035a(str);
        if (Log.isLoggable("hybrid", 3)) {
            Log.d("hybrid", "config response is " + a);
        }
        return a;
    }

    @JavascriptInterface
    public String lookup(String str, String str2) {
        String a = this.f2462a.m4036a(str, str2);
        if (Log.isLoggable("hybrid", 3)) {
            Log.d("hybrid", "lookup response is " + a);
        }
        return a;
    }

    @JavascriptInterface
    public String invoke(String str, String str2, String str3, String str4) {
        String a = this.f2462a.m4037a(str, str2, str3, str4);
        if (Log.isLoggable("hybrid", 3)) {
            Log.d("hybrid", "blocking response is " + a);
        }
        return a;
    }
}
