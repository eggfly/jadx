package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.Hashon;
import com.taobao.accs.common.Constants;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;

/* renamed from: cn.sharesdk.sina.weibo.b */
public class C0999b extends C0920b {
    private boolean f3376d;

    /* renamed from: cn.sharesdk.sina.weibo.b.1 */
    class C09981 extends Thread {
        final /* synthetic */ Platform f3373a;
        final /* synthetic */ String f3374b;
        final /* synthetic */ C0999b f3375c;

        C09981(C0999b c0999b, Platform platform, String str) {
            this.f3375c = c0999b;
            this.f3373a = platform;
            this.f3374b = str;
        }

        public void run() {
            try {
                String a = C1003d.m4438a(this.f3373a).m4446a(this.f3373a.getContext(), this.f3374b);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
                return;
            }
            if (a == null) {
                this.f3375c.c.onError(new Throwable("Authorize token is empty"));
                return;
            }
            HashMap fromJson = new Hashon().fromJson(a);
            Bundle bundle = new Bundle();
            bundle.putString("uid", String.valueOf(fromJson.get("uid")));
            bundle.putString("remind_in", String.valueOf(fromJson.get("remind_in")));
            bundle.putString("expires_in", String.valueOf(fromJson.get("expires_in")));
            bundle.putString("access_token", String.valueOf(fromJson.get("access_token")));
            this.f3375c.c.onComplete(bundle);
        }
    }

    public C0999b(C0942e c0942e) {
        super(c0942e);
    }

    private void m4425a(Platform platform, String str) {
        new C09981(this, platform, str).start();
    }

    private Intent m4426b(String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", BuildConfig.FLAVOR);
        intent.setFlags(268435456);
        return intent;
    }

    protected void m4429a(String str) {
        if (!this.f3376d) {
            this.f3376d = true;
            Bundle urlToBundle = C4021R.urlToBundle(str);
            String string = urlToBundle.getString(C4233j.f14375B);
            String string2 = urlToBundle.getString("error_code");
            if (this.c == null) {
                return;
            }
            if (string == null && string2 == null) {
                Object string3 = urlToBundle.getString(Constants.KEY_HTTP_CODE);
                if (TextUtils.isEmpty(string3)) {
                    this.c.onError(new Throwable("Authorize code is empty"));
                }
                m4425a(this.a.m4117a().getPlatform(), string3);
            } else if (string.equals("access_denied")) {
                this.c.onCancel();
            } else {
                int i = 0;
                try {
                    i = C4021R.parseInt(string2);
                } catch (Throwable th) {
                    C0979d.m4390a().m4376d(th);
                }
                this.c.onError(new Throwable(string + " (" + i + C4233j.f14397t));
            }
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(this.b) && str.startsWith(this.b)) {
            webView.stopLoading();
            this.a.finish();
            m4429a(str);
        } else if (str.startsWith("sms:")) {
            String substring = str.substring(4);
            try {
                Intent b = m4426b(substring);
                b.setPackage("com.android.mms");
                webView.getContext().startActivity(b);
            } catch (Throwable th) {
                if (this.c != null) {
                    this.c.onError(th);
                }
            }
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty(this.b) && str.startsWith(this.b)) {
            webView.stopLoading();
            this.a.finish();
            m4429a(str);
            return true;
        } else if (!str.startsWith("sms:")) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            String substring = str.substring(4);
            try {
                Intent b = m4426b(substring);
                b.setPackage("com.android.mms");
                webView.getContext().startActivity(b);
                return true;
            } catch (Throwable th) {
                if (this.c == null) {
                    return true;
                }
                this.c.onError(th);
                return true;
            }
        }
    }
}
