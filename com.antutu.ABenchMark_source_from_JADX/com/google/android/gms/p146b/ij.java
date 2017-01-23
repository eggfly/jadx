package com.google.android.gms.p146b;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import anet.channel.util.HttpConstant;
import com.antutu.redacc.C1692R;
import com.google.android.gms.ads.internal.C2798f;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.C2646a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C2730p;
import com.google.android.gms.ads.internal.overlay.C2735g;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.overlay.C2865e;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.C4103b;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.android.spdy.SpdyProtocol;

@gb
/* renamed from: com.google.android.gms.b.ij */
public class ij extends WebViewClient {
    private static final String[] f11416b;
    private static final String[] f11417c;
    protected ii f11418a;
    private final HashMap<String, List<cb>> f11419d;
    private final Object f11420e;
    private C2646a f11421f;
    private C2735g f11422g;
    private C2813a f11423h;
    private bx f11424i;
    private C2823b f11425j;
    private boolean f11426k;
    private cd f11427l;
    private cf f11428m;
    private boolean f11429n;
    private boolean f11430o;
    private C2730p f11431p;
    private final ep f11432q;
    private C2798f f11433r;
    private el f11434s;
    private er f11435t;
    private boolean f11436u;
    private boolean f11437v;
    private boolean f11438w;
    private int f11439x;

    /* renamed from: com.google.android.gms.b.ij.a */
    public interface C2813a {
        void m10895a(ii iiVar, boolean z);
    }

    /* renamed from: com.google.android.gms.b.ij.b */
    public interface C2823b {
        void m10917a();
    }

    /* renamed from: com.google.android.gms.b.ij.1 */
    class C32841 implements Runnable {
        final /* synthetic */ ij f11412a;

        C32841(ij ijVar) {
            this.f11412a = ijVar;
        }

        public void run() {
            this.f11412a.f11418a.m13262y();
            C2864d i = this.f11412a.f11418a.m13246i();
            if (i != null) {
                i.m11118m();
            }
            if (this.f11412a.f11425j != null) {
                this.f11412a.f11425j.m10917a();
                this.f11412a.f11425j = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.b.ij.c */
    private static class C3285c implements C2735g {
        private ii f11413a;
        private C2735g f11414b;

        public C3285c(ii iiVar, C2735g c2735g) {
            this.f11413a = iiVar;
            this.f11414b = c2735g;
        }

        public void m13264g() {
        }

        public void g_() {
            this.f11414b.g_();
            this.f11413a.m13238c();
        }

        public void h_() {
            this.f11414b.h_();
            this.f11413a.m13240d();
        }

        public void i_() {
        }
    }

    /* renamed from: com.google.android.gms.b.ij.d */
    private class C3286d implements cb {
        final /* synthetic */ ij f11415a;

        private C3286d(ij ijVar) {
            this.f11415a = ijVar;
        }

        public void m13265a(ii iiVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.f11415a.m13274h();
            } else if (map.keySet().contains("stop")) {
                this.f11415a.m13275i();
            } else if (map.keySet().contains("cancel")) {
                this.f11415a.m13276j();
            }
        }
    }

    static {
        f11416b = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        f11417c = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public ij(ii iiVar, boolean z) {
        this(iiVar, z, new ep(iiVar, iiVar.m13244g(), new ai(iiVar.getContext())), null);
    }

    ij(ii iiVar, boolean z, ep epVar, el elVar) {
        this.f11419d = new HashMap();
        this.f11420e = new Object();
        this.f11426k = false;
        this.f11418a = iiVar;
        this.f11429n = z;
        this.f11432q = epVar;
        this.f11434s = elVar;
    }

    private String m13267a(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : BuildConfig.FLAVOR;
    }

    private void m13268a(Context context, String str, String str2, String str3) {
        if (((Boolean) aq.ao.m11794c()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompatApi21.CATEGORY_ERROR, str);
            bundle.putString(Constants.KEY_HTTP_CODE, str2);
            bundle.putString(C4103b.ELECTION_KEY_HOST, m13267a(str3));
            C2968s.m11525e().m13036a(context, this.f11418a.m13252o().f10081b, "gmob-apps", bundle, true);
        }
    }

    private static boolean m13271b(Uri uri) {
        String scheme = uri.getScheme();
        return HttpConstant.HTTP.equalsIgnoreCase(scheme) || HttpConstant.HTTPS.equalsIgnoreCase(scheme);
    }

    private void m13274h() {
        synchronized (this.f11420e) {
            this.f11430o = true;
        }
        this.f11439x++;
        m13296e();
    }

    private void m13275i() {
        this.f11439x--;
        m13296e();
    }

    private void m13276j() {
        this.f11438w = true;
        m13296e();
    }

    public C2798f m13277a() {
        return this.f11433r;
    }

    public void m13278a(int i, int i2) {
        if (this.f11434s != null) {
            this.f11434s.m12607c(i, i2);
        }
    }

    public void m13279a(int i, int i2, boolean z) {
        this.f11432q.m12630a(i, i2);
        if (this.f11434s != null) {
            this.f11434s.m12601a(i, i2, z);
        }
    }

    public void m13280a(Uri uri) {
        String path = uri.getPath();
        List<cb> list = (List) this.f11419d.get(path);
        if (list != null) {
            Map a = C2968s.m11525e().m13028a(uri);
            if (C2972b.m11578a(2)) {
                hf.m12982e("Received GMSG: " + path);
                for (String path2 : a.keySet()) {
                    hf.m12982e("  " + path2 + ": " + ((String) a.get(path2)));
                }
            }
            for (cb a2 : list) {
                a2.m10754a(this.f11418a, a);
            }
            return;
        }
        hf.m12982e("No GMSG handler found for GMSG: " + uri);
    }

    public void m13281a(C2646a c2646a, C2735g c2735g, bx bxVar, C2730p c2730p, boolean z, cd cdVar, cf cfVar, C2798f c2798f, er erVar) {
        if (c2798f == null) {
            c2798f = new C2798f(false);
        }
        this.f11434s = new el(this.f11418a, erVar);
        m13287a("/appEvent", new bw(bxVar));
        m13287a("/backButton", ca.f10410k);
        m13287a("/canOpenURLs", ca.f10401b);
        m13287a("/canOpenIntents", ca.f10402c);
        m13287a("/click", ca.f10403d);
        m13287a("/close", ca.f10404e);
        m13287a("/customClose", ca.f10406g);
        m13287a("/instrument", ca.f10413n);
        m13287a("/delayPageLoaded", new C3286d());
        m13287a("/httpTrack", ca.f10407h);
        m13287a("/log", ca.f10408i);
        m13287a("/mraid", new ch(c2798f, this.f11434s));
        m13287a("/mraidLoaded", this.f11432q);
        m13287a("/open", new ci(cdVar, c2798f, this.f11434s));
        m13287a("/precache", ca.f10412m);
        m13287a("/touch", ca.f10409j);
        m13287a("/video", ca.f10411l);
        m13287a("/appStreaming", ca.f10405f);
        if (cfVar != null) {
            m13287a("/setInterstitialProperties", new ce(cfVar));
        }
        this.f11421f = c2646a;
        this.f11422g = c2735g;
        this.f11424i = bxVar;
        this.f11427l = cdVar;
        this.f11431p = c2730p;
        this.f11433r = c2798f;
        this.f11435t = erVar;
        this.f11428m = cfVar;
        m13288a(z);
    }

    public final void m13282a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        C2735g c2735g = null;
        boolean p = this.f11418a.m13253p();
        C2646a c2646a = (!p || this.f11418a.m13248k().f9329e) ? this.f11421f : null;
        if (!p) {
            c2735g = this.f11422g;
        }
        m13283a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, c2646a, c2735g, this.f11431p, this.f11418a.m13252o()));
    }

    public void m13283a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f11434s != null ? this.f11434s.m12606b() : false;
        C2865e c = C2968s.m11523c();
        Context context = this.f11418a.getContext();
        if (!b) {
            z = true;
        }
        c.m11123a(context, adOverlayInfoParcel, z);
    }

    public void m13284a(ii iiVar) {
        this.f11418a = iiVar;
    }

    public void m13285a(C2813a c2813a) {
        this.f11423h = c2813a;
    }

    public void m13286a(C2823b c2823b) {
        this.f11425j = c2823b;
    }

    public void m13287a(String str, cb cbVar) {
        synchronized (this.f11420e) {
            List list = (List) this.f11419d.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f11419d.put(str, list);
            }
            list.add(cbVar);
        }
    }

    public void m13288a(boolean z) {
        this.f11426k = z;
    }

    public final void m13289a(boolean z, int i) {
        C2646a c2646a = (!this.f11418a.m13253p() || this.f11418a.m13248k().f9329e) ? this.f11421f : null;
        m13283a(new AdOverlayInfoParcel(c2646a, this.f11422g, this.f11431p, this.f11418a, z, i, this.f11418a.m13252o()));
    }

    public final void m13290a(boolean z, int i, String str) {
        C2735g c2735g = null;
        boolean p = this.f11418a.m13253p();
        C2646a c2646a = (!p || this.f11418a.m13248k().f9329e) ? this.f11421f : null;
        if (!p) {
            c2735g = new C3285c(this.f11418a, this.f11422g);
        }
        m13283a(new AdOverlayInfoParcel(c2646a, c2735g, this.f11424i, this.f11431p, this.f11418a, z, i, str, this.f11418a.m13252o(), this.f11427l));
    }

    public final void m13291a(boolean z, int i, String str, String str2) {
        boolean p = this.f11418a.m13253p();
        C2646a c2646a = (!p || this.f11418a.m13248k().f9329e) ? this.f11421f : null;
        m13283a(new AdOverlayInfoParcel(c2646a, p ? null : new C3285c(this.f11418a, this.f11422g), this.f11424i, this.f11431p, this.f11418a, z, i, str, str2, this.f11418a.m13252o(), this.f11427l));
    }

    public void m13292b(String str, cb cbVar) {
        synchronized (this.f11420e) {
            List list = (List) this.f11419d.get(str);
            if (list == null) {
                return;
            }
            list.remove(cbVar);
        }
    }

    public boolean m13293b() {
        boolean z;
        synchronized (this.f11420e) {
            z = this.f11429n;
        }
        return z;
    }

    public boolean m13294c() {
        boolean z;
        synchronized (this.f11420e) {
            z = this.f11430o;
        }
        return z;
    }

    public void m13295d() {
        synchronized (this.f11420e) {
            hf.m12982e("Loading blank page in WebView, 2...");
            this.f11436u = true;
            this.f11418a.m13228a("about:blank");
        }
    }

    public final void m13296e() {
        if (this.f11423h != null && ((this.f11437v && this.f11439x <= 0) || this.f11438w)) {
            this.f11423h.m10895a(this.f11418a, !this.f11438w);
            this.f11423h = null;
        }
        this.f11418a.m13263z();
    }

    public final void m13297f() {
        synchronized (this.f11420e) {
            this.f11419d.clear();
            this.f11421f = null;
            this.f11422g = null;
            this.f11423h = null;
            this.f11424i = null;
            this.f11426k = false;
            this.f11429n = false;
            this.f11430o = false;
            this.f11427l = null;
            this.f11431p = null;
            this.f11425j = null;
            if (this.f11434s != null) {
                this.f11434s.m12603a(true);
                this.f11434s = null;
            }
        }
    }

    public final void m13298g() {
        synchronized (this.f11420e) {
            this.f11426k = false;
            this.f11429n = true;
            hj.m13012a(new C32841(this));
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        hf.m12982e("Loading resource: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m13280a(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.f11420e) {
            if (this.f11436u) {
                hf.m12982e("Blank page loaded, 1...");
                this.f11418a.m13256s();
                return;
            }
            this.f11437v = true;
            m13296e();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= f11416b.length) ? String.valueOf(i) : f11416b[(-i) - 1];
        m13268a(this.f11418a.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f11417c.length) ? String.valueOf(primaryError) : f11417c[primaryError];
            m13268a(this.f11418a.getContext(), "ssl_err", valueOf, C2968s.m11527g().m13079a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case C1692R.styleable.AppCompatTheme_panelMenuListWidth /*79*/:
            case C1692R.styleable.AppCompatTheme_colorControlNormal /*85*/:
            case C1692R.styleable.AppCompatTheme_colorControlActivated /*86*/:
            case C1692R.styleable.AppCompatTheme_colorControlHighlight /*87*/:
            case C1692R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
            case C1692R.styleable.AppCompatTheme_colorSwitchThumbNormal /*89*/:
            case C1692R.styleable.AppCompatTheme_controlBackground /*90*/:
            case C1692R.styleable.AppCompatTheme_alertDialogStyle /*91*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case SpdyProtocol.SLIGHTSSLV2 /*128*/:
            case 129:
            case SpdyProtocol.CDN /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        hf.m12982e("AdWebView shouldOverrideUrlLoading: " + str);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m13280a(parse);
        } else if (this.f11426k && webView == this.f11418a.m13222a() && ij.m13271b(parse)) {
            if (this.f11421f != null && ((Boolean) aq.f10283W.m11794c()).booleanValue()) {
                this.f11421f.m10223a();
                this.f11421f = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.f11418a.m13222a().willNotDraw()) {
            C2972b.m11583d("AdWebView unable to handle URL: " + str);
        } else {
            Uri uri;
            try {
                C3326k n = this.f11418a.m13251n();
                if (n != null && n.m13589b(parse)) {
                    parse = n.m13585a(parse, this.f11418a.getContext());
                }
                uri = parse;
            } catch (C3348l e) {
                C2972b.m11583d("Unable to append parameter to URL: " + str);
                uri = parse;
            }
            if (this.f11433r == null || this.f11433r.m10777b()) {
                m13282a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.f11433r.m10776a(str);
            }
        }
        return true;
    }
}
