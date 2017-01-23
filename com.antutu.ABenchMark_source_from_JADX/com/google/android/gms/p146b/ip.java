package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.umeng.message.proguard.C4233j;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@gb
@TargetApi(11)
/* renamed from: com.google.android.gms.b.ip */
public class ip extends ij {
    public ip(ii iiVar, boolean z) {
        super(iiVar, z);
    }

    protected WebResourceResponse m13423a(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put(HttpRequest.f14569v, C2968s.m11525e().m13024a(context, str));
        hashMap.put(HttpRequest.f14556i, "max-stale=3600");
        String str3 = (String) new ho(context).m13150a(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", HttpRequest.f14548a, new ByteArrayInputStream(str3.getBytes(HttpRequest.f14548a)));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Exception e;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof ii) {
                ii iiVar = (ii) webView;
                iiVar.m13249l().m13298g();
                String str2 = iiVar.m13248k().f9329e ? (String) aq.f10266F.m11794c() : iiVar.m13253p() ? (String) aq.f10265E.m11794c() : (String) aq.f10264D.m11794c();
                hf.m12982e("shouldInterceptRequest(" + str2 + C4233j.f14397t);
                return m13423a(iiVar.getContext(), this.a.m13252o().f10081b, str2);
            }
            C2972b.m11583d("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, str);
        } catch (IOException e2) {
            e = e2;
            C2972b.m11583d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (ExecutionException e3) {
            e = e3;
            C2972b.m11583d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (InterruptedException e4) {
            e = e4;
            C2972b.m11583d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        } catch (TimeoutException e5) {
            e = e5;
            C2972b.m11583d("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
