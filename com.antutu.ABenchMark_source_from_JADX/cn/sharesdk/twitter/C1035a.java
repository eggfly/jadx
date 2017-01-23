package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.C4021R;

/* renamed from: cn.sharesdk.twitter.a */
public class C1035a extends C0920b {
    private boolean f3486d;

    /* renamed from: cn.sharesdk.twitter.a.1 */
    class C10331 extends Thread {
        final /* synthetic */ String f3482a;
        final /* synthetic */ C1035a f3483b;

        C10331(C1035a c1035a, String str) {
            this.f3483b = c1035a;
            this.f3482a = str;
        }

        public void run() {
            try {
                this.f3483b.m4600a(this.f3482a);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    /* renamed from: cn.sharesdk.twitter.a.2 */
    class C10342 extends Thread {
        final /* synthetic */ String f3484a;
        final /* synthetic */ C1035a f3485b;

        C10342(C1035a c1035a, String str) {
            this.f3485b = c1035a;
            this.f3484a = str;
        }

        public void run() {
            try {
                this.f3485b.m4600a(this.f3484a);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    public C1035a(C0942e c0942e) {
        super(c0942e);
    }

    public void m4600a(String str) {
        if (!this.f3486d) {
            this.f3486d = true;
            String a = C1036b.m4601a(this.a.m4117a().getPlatform()).m4602a(str);
            if (a != null && a.length() > 0) {
                String[] split = a.split("&");
                Bundle bundle = new Bundle();
                for (String str2 : split) {
                    if (str2 != null) {
                        String[] split2 = str2.split("=");
                        if (split2.length >= 2) {
                            bundle.putString(split2[0], split2[1]);
                        }
                    }
                }
                if (bundle == null || bundle.size() <= 0) {
                    if (this.c != null) {
                        this.c.onError(new Throwable());
                    }
                } else if (this.c != null) {
                    this.c.onComplete(bundle);
                }
            } else if (this.c != null) {
                this.c.onError(new Throwable());
            }
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.b != null && str.startsWith(this.b)) {
            webView.stopLoading();
            this.a.finish();
            new C10342(this, String.valueOf(C4021R.urlToBundle(str).get("oauth_verifier"))).start();
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.b == null || !str.startsWith(this.b)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView.stopLoading();
        this.a.finish();
        new C10331(this, String.valueOf(C4021R.urlToBundle(str).get("oauth_verifier"))).start();
        return true;
    }
}
