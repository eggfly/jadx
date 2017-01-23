package cn.sharesdk.tencent.qzone;

import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.C0920b;
import cn.sharesdk.framework.authorize.C0942e;
import cn.sharesdk.framework.utils.C0979d;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;

/* renamed from: cn.sharesdk.tencent.qzone.a */
public class C1024a extends C0920b {

    /* renamed from: cn.sharesdk.tencent.qzone.a.1 */
    class C10231 extends Thread {
        final /* synthetic */ String f3452a;
        final /* synthetic */ C1024a f3453b;

        C10231(C1024a c1024a, String str) {
            this.f3453b = c1024a;
            this.f3452a = str;
        }

        public void run() {
            try {
                this.f3453b.m4558a(this.f3452a);
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
    }

    public C1024a(C0942e c0942e) {
        super(c0942e);
    }

    private void m4557a(HashMap<String, String> hashMap) {
        String str = (String) hashMap.get("access_token");
        String str2 = (String) hashMap.get("expires_in");
        String str3 = (String) hashMap.get(C4233j.f14375B);
        String str4 = (String) hashMap.get("error_description");
        String str5 = (String) hashMap.get("pf");
        String str6 = (String) hashMap.get("pfkey");
        String str7 = (String) hashMap.get("pay_token");
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap e = C1026b.m4559a(this.a.m4117a().getPlatform()).m4574e(str);
                if (e == null || e.size() <= 0) {
                    if (this.c != null) {
                        this.c.onError(new Throwable());
                    }
                } else if (e.containsKey("openid")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", str);
                    bundle.putString("open_id", String.valueOf(e.get("openid")));
                    bundle.putString("expires_in", str2);
                    bundle.putString("pf", str5);
                    bundle.putString("pfkey", str6);
                    bundle.putString("pay_token", str7);
                    if (this.c != null) {
                        this.c.onComplete(bundle);
                    }
                } else if (this.c != null) {
                    this.c.onError(new Throwable());
                }
            } catch (Throwable th) {
                if (this.c != null) {
                    this.c.onError(th);
                }
            }
        } else if (TextUtils.isEmpty(str3)) {
            this.c.onError(new Throwable());
        } else {
            str = str4 + " (" + str3 + C4233j.f14397t;
            if (this.c != null) {
                this.c.onError(new Throwable(str));
            }
        }
    }

    protected void m4558a(String str) {
        if (str.startsWith(this.b)) {
            str = str.substring(str.indexOf(35) + 1);
        }
        String[] split = str.split("&");
        HashMap hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=");
            if (split3.length < 2) {
                hashMap.put(URLDecoder.decode(split3[0]), BuildConfig.FLAVOR);
            } else {
                hashMap.put(URLDecoder.decode(split3[0]), URLDecoder.decode(split3[1] == null ? BuildConfig.FLAVOR : split3[1]));
            }
        }
        m4557a(hashMap);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            Method method = sslErrorHandler.getClass().getMethod("proceed", new Class[0]);
            method.setAccessible(true);
            method.invoke(sslErrorHandler, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.b)) {
            webView.setVisibility(4);
            webView.stopLoading();
            this.a.finish();
            new C10231(this, str).start();
        } else {
            webView.loadUrl(str);
        }
        return true;
    }
}
