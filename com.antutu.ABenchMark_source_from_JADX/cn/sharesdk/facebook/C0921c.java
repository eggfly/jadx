package cn.sharesdk.facebook;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.C4021R;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: cn.sharesdk.facebook.c */
public class C0921c extends C0920b {

    /* renamed from: cn.sharesdk.facebook.c.1 */
    class C09181 implements Runnable {
        final /* synthetic */ C0921c f3135a;

        C09181(C0921c c0921c) {
            this.f3135a = c0921c;
        }

        public void run() {
            this.f3135a.a.finish();
        }
    }

    public C0921c(C0942e c0942e) {
        super(c0942e);
    }

    protected void m4043a(String str) {
        Bundle urlToBundle = C4021R.urlToBundle(str);
        String string = urlToBundle.getString("error_message");
        if (!(string == null || this.c == null)) {
            string = "error_message ==>>" + string + "\n" + "error_code ==>>" + urlToBundle.getString("error_code");
            this.c.onError(new Throwable(str));
        }
        if (string == null) {
            String string2 = urlToBundle.getString("access_token");
            string = urlToBundle.containsKey("expires_in") ? urlToBundle.getString("expires_in") : "-1";
            if (this.c != null) {
                int parseInt;
                urlToBundle = new Bundle();
                urlToBundle.putString("oauth_token", string2);
                urlToBundle.putString("oauth_token_secret", BuildConfig.FLAVOR);
                try {
                    parseInt = C4021R.parseInt(string);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                    parseInt = -1;
                }
                urlToBundle.putInt("oauth_token_expires", parseInt);
                this.c.onComplete(urlToBundle);
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(this.b)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView.stopLoading();
        webView.postDelayed(new C09181(this), 500);
        m4043a(str);
        return true;
    }
}
