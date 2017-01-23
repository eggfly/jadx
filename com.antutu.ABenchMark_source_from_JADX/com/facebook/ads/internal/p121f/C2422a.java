package com.facebook.ads.internal.p121f;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.C2472h;
import com.facebook.ads.internal.adapters.C2310e;
import com.facebook.ads.internal.adapters.C2310e.C2266a;
import com.facebook.ads.internal.util.C2486a;
import com.facebook.ads.internal.util.C2498g;
import com.facebook.ads.internal.util.C2499h;

/* renamed from: com.facebook.ads.internal.f.a */
public class C2422a extends C2421d {
    private static final String f8364a;
    private final C2318a f8365b;
    private C2310e f8366c;
    private final long f8367d;
    private boolean f8368e;
    private long f8369f;

    /* renamed from: com.facebook.ads.internal.f.a.a */
    public interface C2318a {
        void m8825a();

        void m8826a(int i);

        void m8827a(String str);

        void m8828b();
    }

    /* renamed from: com.facebook.ads.internal.f.a.1 */
    class C24141 extends C2266a {
        final /* synthetic */ C2318a f8352a;
        final /* synthetic */ C2422a f8353b;

        C24141(C2422a c2422a, C2318a c2318a) {
            this.f8353b = c2422a;
            this.f8352a = c2318a;
        }

        public void m9266a() {
            if (!this.f8353b.f8368e) {
                this.f8353b.f8369f = System.currentTimeMillis();
                this.f8353b.f8368e = true;
            }
            this.f8352a.m8828b();
        }
    }

    /* renamed from: com.facebook.ads.internal.f.a.b */
    private class C2415b extends WebViewClient {
        final /* synthetic */ C2422a f8354a;

        private C2415b(C2422a c2422a) {
            this.f8354a = c2422a;
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C2498g.m9480a()) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (System.currentTimeMillis() - this.f8354a.f8369f >= this.f8354a.f8367d) {
                this.f8354a.f8365b.m8827a(str);
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.f.a.c */
    public class C2416c {
        final /* synthetic */ C2422a f8355a;
        private final String f8356b;

        public C2416c(C2422a c2422a) {
            this.f8355a = c2422a;
            this.f8356b = C2416c.class.getSimpleName();
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f8356b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C2498g.m9472a(C2486a.m9449a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!this.f8355a.m9268b()) {
                this.f8355a.f8365b.m8825a();
                if (this.f8355a.f8366c != null) {
                    this.f8355a.f8366c.m8810a();
                }
            }
        }
    }

    static {
        f8364a = C2422a.class.getSimpleName();
    }

    public C2422a(Context context, C2318a c2318a, int i) {
        super(context);
        this.f8368e = false;
        this.f8369f = System.currentTimeMillis();
        this.f8365b = c2318a;
        setWebViewClient(new C2415b());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        C2499h.m9494b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new C2416c(this), "AdControl");
        this.f8367d = C2472h.m9401c(context);
        this.f8366c = new C2310e(getContext(), this, i, new C24141(this, c2318a));
    }

    public void m9276a(int i, int i2) {
        this.f8366c.m8811a(i);
        this.f8366c.m8813b(i2);
    }

    public void destroy() {
        if (this.f8366c != null) {
            this.f8366c.m8812b();
            this.f8366c = null;
        }
        C2499h.m9493a((WebView) this);
        super.destroy();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f8365b != null) {
            this.f8365b.m8826a(i);
        }
        if (i == 0) {
            if (this.f8366c != null) {
                this.f8366c.m8810a();
            }
        } else if (i == 8 && this.f8366c != null) {
            this.f8366c.m8812b();
        }
    }
}
