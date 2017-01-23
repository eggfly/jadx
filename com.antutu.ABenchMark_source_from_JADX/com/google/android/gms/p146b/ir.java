package com.google.android.gms.p146b;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.common.internal.C3511t;
import java.net.URI;
import java.net.URISyntaxException;

@gb
/* renamed from: com.google.android.gms.b.ir */
public class ir extends WebViewClient {
    private final String f11485a;
    private boolean f11486b;
    private final ii f11487c;
    private final fn f11488d;

    public ir(fn fnVar, ii iiVar, String str) {
        this.f11485a = m13424b(str);
        this.f11486b = false;
        this.f11487c = iiVar;
        this.f11488d = fnVar;
    }

    private String m13424b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                C2972b.m11579b(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m13425a(String str) {
        Object b = m13424b(str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        try {
            URI uri = new URI(b);
            if ("passback".equals(uri.getScheme())) {
                C2972b.m11576a("Passback received");
                this.f11488d.m12730b();
                return true;
            } else if (TextUtils.isEmpty(this.f11485a)) {
                return false;
            } else {
                URI uri2 = new URI(this.f11485a);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!C3511t.m14579a(host, host2) || !C3511t.m14579a(path, path2)) {
                    return false;
                }
                C2972b.m11576a("Passback received");
                this.f11488d.m12730b();
                return true;
            }
        } catch (URISyntaxException e) {
            C2972b.m11579b(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        C2972b.m11576a("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (!m13425a(str)) {
            this.f11487c.m13249l().onLoadResource(this.f11487c.m13222a(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        C2972b.m11576a("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (!this.f11486b) {
            this.f11488d.m12727a();
            this.f11486b = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2972b.m11576a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!m13425a(str)) {
            return this.f11487c.m13249l().shouldOverrideUrlLoading(this.f11487c.m13222a(), str);
        }
        C2972b.m11576a("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
