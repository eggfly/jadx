package com.miui.support.internal.hybrid.webkit;

import android.content.Context;
import com.miui.support.hybrid.HybridChromeClient;
import com.miui.support.hybrid.HybridView;
import com.miui.support.hybrid.HybridViewClient;
import com.miui.support.internal.hybrid.provider.AbsWebChromeClient;
import com.miui.support.internal.hybrid.provider.AbsWebView;
import com.miui.support.internal.hybrid.provider.AbsWebViewClient;
import com.miui.support.internal.hybrid.provider.WebViewFactoryProvider;

public class WebkitFactoryProvider extends WebViewFactoryProvider {
    public AbsWebView m4190a(Context context, HybridView hybridView) {
        return new WebView(context, hybridView);
    }

    public AbsWebViewClient m4191a(HybridViewClient hybridViewClient, HybridView hybridView) {
        return new WebViewClient(hybridViewClient, hybridView);
    }

    public AbsWebChromeClient m4189a(HybridChromeClient hybridChromeClient, HybridView hybridView) {
        return new WebChromeClient(hybridChromeClient, hybridView);
    }
}
