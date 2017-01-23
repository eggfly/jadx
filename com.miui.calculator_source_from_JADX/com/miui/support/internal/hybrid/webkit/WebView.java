package com.miui.support.internal.hybrid.webkit;

import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.miui.support.hybrid.HybridSettings;
import com.miui.support.hybrid.HybridView;
import com.miui.support.internal.hybrid.provider.AbsWebChromeClient;
import com.miui.support.internal.hybrid.provider.AbsWebView;
import com.miui.support.internal.hybrid.provider.AbsWebViewClient;

public class WebView extends AbsWebView {
    protected android.webkit.WebView f2497c;

    public WebView(Context context, HybridView hybridView) {
        super(context, hybridView);
        this.f2497c = new android.webkit.WebView(this.a);
    }

    public View m4156a() {
        return this.f2497c;
    }

    public void m4159a(AbsWebViewClient absWebViewClient) {
        this.f2497c.setWebViewClient((WebViewClient) absWebViewClient.m4126a());
    }

    public void m4158a(AbsWebChromeClient absWebChromeClient) {
        this.f2497c.setWebChromeClient((WebChromeClient) absWebChromeClient.m4101a());
    }

    public void m4161a(String str) {
        this.f2497c.loadUrl(str);
    }

    public void m4160a(Object obj, String str) {
        this.f2497c.addJavascriptInterface(obj, str);
    }

    public HybridSettings m4162b() {
        return new WebSettings(this.f2497c.getSettings());
    }

    public void m4163c() {
        this.f2497c.destroy();
    }

    public void m4164d() {
        this.f2497c.reload();
    }

    public boolean m4165e() {
        return this.f2497c.canGoBack();
    }

    public boolean m4166f() {
        return this.f2497c.canGoForward();
    }

    public void m4167g() {
        this.f2497c.goBack();
    }

    public String m4168h() {
        return this.f2497c.getUrl();
    }

    public String m4169i() {
        return this.f2497c.getTitle();
    }

    public int m4170j() {
        return this.f2497c.getContentHeight();
    }

    public float m4171k() {
        return this.f2497c.getScale();
    }

    public Context m4172l() {
        return this.f2497c.getContext();
    }

    public void m4157a(int i) {
        this.f2497c.setVisibility(i);
    }

    public View m4173m() {
        return this.f2497c.getRootView();
    }
}
