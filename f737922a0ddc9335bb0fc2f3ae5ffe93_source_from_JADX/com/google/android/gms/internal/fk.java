package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.f;
import com.google.android.gms.ads.internal.overlay.m;
import com.google.android.gms.ads.internal.zze;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@eh
public class fk extends WebViewClient {
    private static final String[] FH;
    private static final String[] Hw;
    protected ek DW;
    private b EQ;
    private bz J0;
    private cb J8;
    private dh Mr;
    private boolean QX;
    private dn U2;
    private com.google.android.gms.ads.internal.client.a VH;
    private boolean Ws;
    private m XL;
    private final Object Zo;
    private boolean a8;
    private final dl aM;
    private int er;
    private f gn;
    private zze j3;
    protected fj j6;
    private boolean lg;
    private boolean rN;
    private bv tp;
    private a u7;
    private final HashMap<String, List<by>> v5;
    private boolean we;

    public interface a {
        void j6(fj fjVar, boolean z);
    }

    class 1 implements Runnable {
        final /* synthetic */ fk j6;

        public void run() {
            if (this.j6.DW != null) {
                this.j6.DW.j6(this.j6.j6.Hw());
            }
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ fk j6;

        2(fk fkVar) {
            this.j6 = fkVar;
        }

        public void run() {
            this.j6.j6.er();
            com.google.android.gms.ads.internal.overlay.c tp = this.j6.j6.tp();
            if (tp != null) {
                tp.J0();
            }
            if (this.j6.EQ != null) {
                this.j6.EQ.j6();
                this.j6.EQ = null;
            }
        }
    }

    public interface b {
        void j6();
    }

    private static class c implements f {
        private f DW;
        private fj j6;

        public c(fj fjVar, f fVar) {
            this.j6 = fjVar;
            this.DW = fVar;
        }

        public void DW() {
        }

        public void FH() {
        }

        public void Hw() {
            this.DW.Hw();
            this.j6.Zo();
        }

        public void j6() {
            this.DW.j6();
            this.j6.v5();
        }
    }

    private class d implements by {
        final /* synthetic */ fk j6;

        private d(fk fkVar) {
            this.j6 = fkVar;
        }

        public void j6(fj fjVar, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.j6.VH();
            } else if (map.keySet().contains("stop")) {
                this.j6.gn();
            } else if (map.keySet().contains("cancel")) {
                this.j6.u7();
            }
        }
    }

    static {
        FH = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
        Hw = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    }

    public fk(fj fjVar, boolean z) {
        this(fjVar, z, new dl(fjVar, fjVar.gn(), new zzcm(fjVar.getContext())), null);
    }

    fk(fj fjVar, boolean z, dl dlVar, dh dhVar) {
        this.v5 = new HashMap();
        this.Zo = new Object();
        this.we = false;
        this.j6 = fjVar;
        this.Ws = z;
        this.aM = dlVar;
        this.Mr = dhVar;
    }

    private static boolean DW(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void VH() {
        synchronized (this.Zo) {
            this.QX = true;
        }
        this.er++;
        Hw();
    }

    private void gn() {
        this.er--;
        Hw();
    }

    private String j6(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private void j6(Context context, String str, String str2, String str3) {
        if (((Boolean) aq.qp.FH()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", j6(str3));
            com.google.android.gms.ads.internal.f.FH().j6(context, this.j6.QX().DW, "gmob-apps", bundle, true);
        }
    }

    private void u7() {
        this.rN = true;
        Hw();
    }

    public void DW(String str, by byVar) {
        synchronized (this.Zo) {
            List list = (List) this.v5.get(str);
            if (list == null) {
                return;
            }
            list.remove(byVar);
        }
    }

    public boolean DW() {
        boolean z;
        synchronized (this.Zo) {
            z = this.Ws;
        }
        return z;
    }

    public void FH() {
        synchronized (this.Zo) {
            eo.v5("Loading blank page in WebView, 2...");
            this.a8 = true;
            this.j6.j6("about:blank");
        }
    }

    public final void Hw() {
        if (this.u7 != null && ((this.lg && this.er <= 0) || this.rN)) {
            this.u7.j6(this.j6, !this.rN);
            this.u7 = null;
        }
        this.j6.yS();
    }

    public final void Zo() {
        synchronized (this.Zo) {
            this.we = false;
            this.Ws = true;
            com.google.android.gms.ads.internal.f.FH().j6(new 2(this));
        }
    }

    public zze j6() {
        return this.j3;
    }

    public void j6(int i, int i2) {
        if (this.Mr != null) {
            this.Mr.FH(i, i2);
        }
    }

    public void j6(Uri uri) {
        String path = uri.getPath();
        List<by> list = (List) this.v5.get(path);
        if (list != null) {
            Map j6 = com.google.android.gms.ads.internal.f.FH().j6(uri);
            if (com.google.android.gms.ads.internal.util.client.b.j6(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                eo.v5(path.length() != 0 ? str.concat(path) : new String(str));
                for (String path2 : j6.keySet()) {
                    str = (String) j6.get(path2);
                    eo.v5(new StringBuilder((String.valueOf(path2).length() + 4) + String.valueOf(str).length()).append("  ").append(path2).append(": ").append(str).toString());
                }
            }
            for (by j62 : list) {
                j62.j6(this.j6, j6);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        eo.v5(new StringBuilder(String.valueOf(valueOf).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf).toString());
    }

    public void j6(com.google.android.gms.ads.internal.client.a aVar, f fVar, bv bvVar, m mVar, boolean z, bz bzVar, cb cbVar, zze com_google_android_gms_ads_internal_zze, dn dnVar, ek ekVar) {
        if (com_google_android_gms_ads_internal_zze == null) {
            com_google_android_gms_ads_internal_zze = new zze(this.j6.getContext());
        }
        this.Mr = new dh(this.j6, dnVar);
        this.DW = ekVar;
        j6("/appEvent", new bu(bvVar));
        j6("/backButton", bx.EQ);
        j6("/refresh", bx.we);
        j6("/canOpenURLs", bx.DW);
        j6("/canOpenIntents", bx.FH);
        j6("/click", bx.Hw);
        j6("/close", bx.v5);
        j6("/customClose", bx.VH);
        j6("/instrument", bx.QX);
        j6("/delayPageLoaded", new d());
        j6("/httpTrack", bx.gn);
        j6("/log", bx.u7);
        j6("/mraid", new cc(com_google_android_gms_ads_internal_zze, this.Mr));
        j6("/mraidLoaded", this.aM);
        j6("/open", new cd(bzVar, com_google_android_gms_ads_internal_zze, this.Mr));
        j6("/precache", bx.Ws);
        j6("/touch", bx.tp);
        j6("/video", bx.J0);
        j6("/videoMeta", bx.J8);
        j6("/appStreaming", bx.Zo);
        if (cbVar != null) {
            j6("/setInterstitialProperties", new ca(cbVar));
        }
        this.VH = aVar;
        this.gn = fVar;
        this.tp = bvVar;
        this.J0 = bzVar;
        this.XL = mVar;
        this.j3 = com_google_android_gms_ads_internal_zze;
        this.U2 = dnVar;
        this.J8 = cbVar;
        j6(z);
    }

    public final void j6(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        f fVar = null;
        boolean XL = this.j6.XL();
        com.google.android.gms.ads.internal.client.a aVar = (!XL || this.j6.we().v5) ? this.VH : null;
        if (!XL) {
            fVar = this.gn;
        }
        j6(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, aVar, fVar, this.XL, this.j6.QX()));
    }

    public void j6(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean DW = this.Mr != null ? this.Mr.DW() : false;
        com.google.android.gms.ads.internal.overlay.d DW2 = com.google.android.gms.ads.internal.f.DW();
        Context context = this.j6.getContext();
        if (!DW) {
            z = true;
        }
        DW2.j6(context, adOverlayInfoParcel, z);
        if (this.DW != null) {
            String str = adOverlayInfoParcel.J0;
            if (str == null && adOverlayInfoParcel.DW != null) {
                str = adOverlayInfoParcel.DW.FH;
            }
            this.DW.j6(str);
        }
    }

    public void j6(fj fjVar) {
        this.j6 = fjVar;
    }

    public void j6(a aVar) {
        this.u7 = aVar;
    }

    public void j6(String str, by byVar) {
        synchronized (this.Zo) {
            List list = (List) this.v5.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.v5.put(str, list);
            }
            list.add(byVar);
        }
    }

    public void j6(boolean z) {
        this.we = z;
    }

    public final void j6(boolean z, int i) {
        com.google.android.gms.ads.internal.client.a aVar = (!this.j6.XL() || this.j6.we().v5) ? this.VH : null;
        j6(new AdOverlayInfoParcel(aVar, this.gn, this.XL, this.j6, z, i, this.j6.QX()));
    }

    public final void j6(boolean z, int i, String str) {
        f fVar = null;
        boolean XL = this.j6.XL();
        com.google.android.gms.ads.internal.client.a aVar = (!XL || this.j6.we().v5) ? this.VH : null;
        if (!XL) {
            fVar = new c(this.j6, this.gn);
        }
        j6(new AdOverlayInfoParcel(aVar, fVar, this.tp, this.XL, this.j6, z, i, str, this.j6.QX(), this.J0));
    }

    public final void j6(boolean z, int i, String str, String str2) {
        boolean XL = this.j6.XL();
        com.google.android.gms.ads.internal.client.a aVar = (!XL || this.j6.we().v5) ? this.VH : null;
        j6(new AdOverlayInfoParcel(aVar, XL ? null : new c(this.j6, this.gn), this.tp, this.XL, this.j6, z, i, str, str2, this.j6.QX(), this.J0));
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        eo.v5(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            j6(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.Zo) {
            if (this.a8) {
                eo.v5("Blank page loaded, 1...");
                this.j6.j3();
                return;
            }
            this.lg = true;
            Hw();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String valueOf = (i >= 0 || (-i) - 1 >= FH.length) ? String.valueOf(i) : FH[(-i) - 1];
        j6(this.j6.getContext(), "http_err", valueOf, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= Hw.length) ? String.valueOf(primaryError) : Hw[primaryError];
            j6(this.j6.getContext(), "ssl_err", valueOf, com.google.android.gms.ads.internal.f.v5().j6(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case ProxyTextView.INPUTTYPE_textPassword /*129*/:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = "AdWebView shouldOverrideUrlLoading: ";
        String valueOf = String.valueOf(str);
        eo.v5(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            j6(parse);
        } else if (this.we && webView == this.j6.FH() && DW(parse)) {
            if (this.VH != null && ((Boolean) aq.sy.FH()).booleanValue()) {
                this.VH.v5();
                if (this.DW != null) {
                    this.DW.j6(str);
                }
                this.VH = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (this.j6.FH().willNotDraw()) {
            str2 = "AdWebView unable to handle URL: ";
            valueOf = String.valueOf(str);
            com.google.android.gms.ads.internal.util.client.b.Hw(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            Uri uri;
            try {
                y Ws = this.j6.Ws();
                if (Ws != null && Ws.DW(parse)) {
                    parse = Ws.j6(parse, this.j6.getContext());
                }
                uri = parse;
            } catch (z e) {
                String str3 = "Unable to append parameter to URL: ";
                str2 = String.valueOf(str);
                com.google.android.gms.ads.internal.util.client.b.Hw(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                uri = parse;
            }
            if (this.j3 == null || this.j3.j6()) {
                j6(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.j3.j6(str);
            }
        }
        return true;
    }

    public final void v5() {
        if (this.DW != null) {
            this.DW.j6();
            this.DW = null;
        }
        synchronized (this.Zo) {
            this.v5.clear();
            this.VH = null;
            this.gn = null;
            this.u7 = null;
            this.tp = null;
            this.we = false;
            this.Ws = false;
            this.QX = false;
            this.J0 = null;
            this.XL = null;
            this.EQ = null;
            if (this.Mr != null) {
                this.Mr.j6(true);
                this.Mr = null;
            }
        }
    }
}
