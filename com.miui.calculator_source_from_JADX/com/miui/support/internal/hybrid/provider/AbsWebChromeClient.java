package com.miui.support.internal.hybrid.provider;

import android.net.Uri;
import com.miui.support.hybrid.GeolocationPermissions.Callback;
import com.miui.support.hybrid.HybridChromeClient;
import com.miui.support.hybrid.HybridView;
import com.miui.support.hybrid.JsResult;
import com.miui.support.hybrid.ValueCallback;

public abstract class AbsWebChromeClient {
    protected HybridChromeClient f2483a;
    protected HybridView f2484b;

    public AbsWebChromeClient(HybridChromeClient hybridChromeClient, HybridView hybridView) {
        this.f2483a = hybridChromeClient;
        this.f2484b = hybridView;
    }

    public Object m4101a() {
        return null;
    }

    public boolean m4106a(HybridView hybridView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean m4107b(HybridView hybridView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public void m4102a(HybridView hybridView, int i) {
    }

    public void m4105a(String str, Callback callback) {
    }

    public void m4103a(HybridView hybridView, String str) {
    }

    public void m4104a(ValueCallback<Uri> valueCallback, String str, String str2) {
    }
}
