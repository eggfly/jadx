package com.miui.support.internal.hybrid.webkit;

import android.net.Uri;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.miui.support.hybrid.GeolocationPermissions;
import com.miui.support.hybrid.HybridChromeClient;
import com.miui.support.hybrid.HybridView;
import com.miui.support.internal.hybrid.provider.AbsWebChromeClient;

public class WebChromeClient extends AbsWebChromeClient {

    class InternalWebChromeClient extends android.webkit.WebChromeClient {
        final /* synthetic */ WebChromeClient f2495a;

        InternalWebChromeClient(WebChromeClient webChromeClient) {
            this.f2495a = webChromeClient;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f2495a.m4151a(this.f2495a.b, str, str2, new JsResult(jsResult));
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return this.f2495a.m4152b(this.f2495a.b, str, str2, new JsResult(jsResult));
        }

        public void onProgressChanged(WebView webView, int i) {
            this.f2495a.m4147a(this.f2495a.b, i);
        }

        public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
            this.f2495a.m4150a(str, new GeolocationPermissionsCallback(callback));
        }

        public void onReceivedTitle(WebView webView, String str) {
            this.f2495a.m4148a(this.f2495a.b, str);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            this.f2495a.m4149a(new ValueCallback(valueCallback), str, str2);
        }
    }

    public WebChromeClient(HybridChromeClient hybridChromeClient, HybridView hybridView) {
        super(hybridChromeClient, hybridView);
    }

    public Object m4146a() {
        return new InternalWebChromeClient(this);
    }

    public boolean m4151a(HybridView hybridView, String str, String str2, com.miui.support.hybrid.JsResult jsResult) {
        return this.a.m3502a(hybridView, str, str2, jsResult);
    }

    public boolean m4152b(HybridView hybridView, String str, String str2, com.miui.support.hybrid.JsResult jsResult) {
        return this.a.m3503b(hybridView, str, str2, jsResult);
    }

    public void m4147a(HybridView hybridView, int i) {
        this.a.m3497a(hybridView, i);
    }

    public void m4150a(String str, GeolocationPermissions.Callback callback) {
        this.a.m3501a(str, callback);
    }

    public void m4148a(HybridView hybridView, String str) {
        this.a.m3498a(hybridView, str);
    }

    public void m4149a(com.miui.support.hybrid.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.a.m3499a(valueCallback, str, str2);
    }
}
