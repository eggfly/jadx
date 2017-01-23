package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@eh
@TargetApi(11)
public class fq extends fk {
    public fq(fj fjVar, boolean z) {
        super(fjVar, z);
    }

    protected WebResourceResponse j6(Context context, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", f.FH().j6(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzkg(context).j6(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Exception e;
        String valueOf;
        if (this.DW != null) {
            this.DW.DW(str);
        }
        String str2;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (webView instanceof fj) {
                fj fjVar = (fj) webView;
                fjVar.J0().Zo();
                str2 = fjVar.we().v5 ? (String) aq.SI.FH() : fjVar.XL() ? (String) aq.nw.FH() : (String) aq.ei.FH();
                eo.v5(new StringBuilder(String.valueOf(str2).length() + 24).append("shouldInterceptRequest(").append(str2).append(")").toString());
                return j6(fjVar.getContext(), this.j6.QX().DW, str2);
            }
            b.Hw("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, str);
        } catch (IOException e2) {
            e = e2;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            b.Hw(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (ExecutionException e3) {
            e = e3;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            b.Hw(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (InterruptedException e4) {
            e = e4;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            b.Hw(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        } catch (TimeoutException e5) {
            e = e5;
            str2 = "Could not fetch MRAID JS. ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            b.Hw(valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return super.shouldInterceptRequest(webView, str);
        }
    }
}
