package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.C0919d;

/* renamed from: cn.sharesdk.framework.authorize.b */
public abstract class C0920b extends C0919d {
    protected C0942e f3136a;
    protected String f3137b;
    protected AuthorizeListener f3138c;

    public C0920b(C0942e c0942e) {
        this.f3136a = c0942e;
        AuthorizeHelper a = c0942e.m4117a();
        this.f3137b = a.getRedirectUri();
        this.f3138c = a.getAuthorizeListener();
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        webView.stopLoading();
        AuthorizeListener authorizeListener = this.f3136a.m4117a().getAuthorizeListener();
        this.f3136a.finish();
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable(str + " (" + i + "): " + str2));
        }
    }
}
