package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.adapters.C2268b;
import com.facebook.ads.internal.adapters.C2310e;
import com.facebook.ads.internal.adapters.C2310e.C2266a;
import com.facebook.ads.internal.adapters.C2329n;
import com.facebook.ads.internal.adapters.C2331o;
import com.facebook.ads.internal.p123a.C2295a;
import com.facebook.ads.internal.p123a.C2296b;
import com.facebook.ads.internal.ssp.ANAdRenderer.Listener;
import com.facebook.ads.internal.util.C2486a;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2489b.C2487a;
import com.facebook.ads.internal.util.C2490c;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2499h;

/* renamed from: com.facebook.ads.internal.f.c */
public class C2450c extends C2421d {
    private static final String f8448a;
    private final C2329n f8449b;
    private final int f8450c;
    private final Listener f8451d;
    private C2331o f8452e;
    private C2310e f8453f;
    private long f8454g;
    private C2487a f8455h;

    /* renamed from: com.facebook.ads.internal.f.c.1 */
    class C24331 extends C2268b {
        final /* synthetic */ C2450c f8398a;

        C24331(C2450c c2450c) {
            this.f8398a = c2450c;
        }

        public void m9304d() {
            this.f8398a.f8451d.onAdImpression();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.2 */
    class C24342 extends C2266a {
        final /* synthetic */ C2450c f8399a;

        C24342(C2450c c2450c) {
            this.f8399a = c2450c;
        }

        public void m9305a() {
            this.f8399a.f8452e.m8719a();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.a */
    private class C2435a extends WebViewClient {
        final /* synthetic */ C2450c f8400a;

        private C2435a(C2450c c2450c) {
            this.f8400a = c2450c;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C2498g.m9480a()) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if ("fbad".equals(parse.getScheme()) && "close".equals(parse.getAuthority())) {
                this.f8400a.f8451d.onAdClose();
            } else {
                this.f8400a.f8451d.onAdClick();
                C2295a a = C2296b.m8708a(this.f8400a.getContext(), parse);
                if (a != null) {
                    try {
                        this.f8400a.f8455h = a.m8705a();
                        this.f8400a.f8454g = System.currentTimeMillis();
                        a.m8707b();
                    } catch (Throwable e) {
                        Log.e(C2450c.f8448a, "Error executing action", e);
                    }
                }
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.f.c.b */
    private class C2436b {
        final /* synthetic */ C2450c f8401a;
        private final String f8402b;

        private C2436b(C2450c c2450c) {
            this.f8401a = c2450c;
            this.f8402b = C2436b.class.getSimpleName();
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f8402b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C2498g.m9472a(C2486a.m9449a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!this.f8401a.m9268b()) {
                this.f8401a.m9344d();
                if (this.f8401a.f8453f != null) {
                    this.f8401a.f8453f.m8810a();
                }
            }
        }
    }

    static {
        f8448a = C2450c.class.getSimpleName();
    }

    public C2450c(Context context, C2329n c2329n, int i, Listener listener) {
        super(context);
        if (c2329n == null || listener == null) {
            throw new IllegalArgumentException();
        }
        this.f8449b = c2329n;
        this.f8450c = i;
        this.f8451d = listener;
        m9341c();
    }

    private void m9341c() {
        setWebViewClient(new C2435a());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        C2499h.m9494b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new C2436b(), "AdControl");
        this.f8452e = new C2331o(getContext(), this, new C24331(this));
        this.f8452e.m8956a(this.f8449b);
        this.f8453f = new C2310e(getContext(), this, this.f8450c, new C24342(this));
        this.f8453f.m8811a(this.f8449b.m8949g());
        this.f8453f.m8813b(this.f8449b.m8950h());
        this.f8453f.m8810a();
        loadDataWithBaseURL(C2499h.m9489a(), this.f8449b.m8942a(), "text/html", "utf-8", null);
    }

    private void m9344d() {
        this.f8452e.m8958c();
    }

    public void destroy() {
        if (this.f8453f != null) {
            this.f8453f.m8812b();
            this.f8453f = null;
        }
        C2499h.m9493a((WebView) this);
        super.destroy();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            if (this.f8454g > 0 && this.f8455h != null) {
                C2490c.m9456a(C2489b.m9451a(this.f8454g, this.f8455h, this.f8449b.m8948f()));
                this.f8454g = 0;
                this.f8455h = null;
            }
            if (this.f8453f != null) {
                this.f8453f.m8810a();
            }
        } else if (i == 8 && this.f8453f != null) {
            this.f8453f.m8812b();
        }
    }
}
