package com.google.android.gms.p146b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.il */
class il extends FrameLayout implements ii {
    private final ii f11440a;
    private final ih f11441b;

    public il(ii iiVar) {
        super(iiVar.getContext());
        this.f11440a = iiVar;
        this.f11441b = new ih(iiVar.m13244g(), this, this);
        ij l = this.f11440a.m13249l();
        if (l != null) {
            l.m13284a((ii) this);
        }
        addView(this.f11440a.m13233b());
    }

    public OnClickListener m13301A() {
        return this.f11440a.m13219A();
    }

    public void m13302B() {
        this.f11441b.m13216b();
        this.f11440a.m13220B();
    }

    public void m13303C() {
        this.f11440a.m13221C();
    }

    public WebView m13304a() {
        return this.f11440a.m13222a();
    }

    public void m13305a(int i) {
        this.f11440a.m13223a(i);
    }

    public void m13306a(Context context) {
        this.f11440a.m13224a(context);
    }

    public void m13307a(Context context, AdSizeParcel adSizeParcel, az azVar) {
        this.f11440a.m13225a(context, adSizeParcel, azVar);
    }

    public void m13308a(AdSizeParcel adSizeParcel) {
        this.f11440a.m13226a(adSizeParcel);
    }

    public void m13309a(C2864d c2864d) {
        this.f11440a.m13227a(c2864d);
    }

    public void m13310a(C3364q c3364q, boolean z) {
        this.f11440a.m13218a(c3364q, z);
    }

    public void m13311a(String str) {
        this.f11440a.m13228a(str);
    }

    public void m13312a(String str, cb cbVar) {
        this.f11440a.m12202a(str, cbVar);
    }

    public void m13313a(String str, String str2) {
        this.f11440a.m13229a(str, str2);
    }

    public void m13314a(String str, Map<String, ?> map) {
        this.f11440a.m13230a(str, (Map) map);
    }

    public void m13315a(String str, JSONObject jSONObject) {
        this.f11440a.m13231a(str, jSONObject);
    }

    public void m13316a(boolean z) {
        this.f11440a.m13232a(z);
    }

    public View m13317b() {
        return this;
    }

    public void m13318b(int i) {
        this.f11440a.m13234b(i);
    }

    public void m13319b(C2864d c2864d) {
        this.f11440a.m13235b(c2864d);
    }

    public void m13320b(String str) {
        this.f11440a.m13236b(str);
    }

    public void m13321b(String str, cb cbVar) {
        this.f11440a.m12205b(str, cbVar);
    }

    public void m13322b(String str, JSONObject jSONObject) {
        this.f11440a.m12206b(str, jSONObject);
    }

    public void m13323b(boolean z) {
        this.f11440a.m13237b(z);
    }

    public void m13324c() {
        this.f11440a.m13238c();
    }

    public void m13325c(boolean z) {
        this.f11440a.m13239c(z);
    }

    public void m13326d() {
        this.f11440a.m13240d();
    }

    public void m13327d(boolean z) {
        this.f11440a.m13241d(z);
    }

    public void destroy() {
        this.f11440a.destroy();
    }

    public void m13328e() {
        this.f11440a.m13242e();
    }

    public Activity m13329f() {
        return this.f11440a.m13243f();
    }

    public Context m13330g() {
        return this.f11440a.m13244g();
    }

    public C2795e m13331h() {
        return this.f11440a.m13245h();
    }

    public C2864d m13332i() {
        return this.f11440a.m13246i();
    }

    public C2864d m13333j() {
        return this.f11440a.m13247j();
    }

    public AdSizeParcel m13334k() {
        return this.f11440a.m13248k();
    }

    public ij m13335l() {
        return this.f11440a.m13249l();
    }

    public void loadData(String str, String str2, String str3) {
        this.f11440a.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f11440a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.f11440a.loadUrl(str);
    }

    public boolean m13336m() {
        return this.f11440a.m13250m();
    }

    public C3326k m13337n() {
        return this.f11440a.m13251n();
    }

    public VersionInfoParcel m13338o() {
        return this.f11440a.m13252o();
    }

    public boolean m13339p() {
        return this.f11440a.m13253p();
    }

    public int m13340q() {
        return this.f11440a.m13254q();
    }

    public boolean m13341r() {
        return this.f11440a.m13255r();
    }

    public void m13342s() {
        this.f11441b.m13217c();
        this.f11440a.m13256s();
    }

    public void setBackgroundColor(int i) {
        this.f11440a.setBackgroundColor(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f11440a.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f11440a.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f11440a.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f11440a.setWebViewClient(webViewClient);
    }

    public void stopLoading() {
        this.f11440a.stopLoading();
    }

    public boolean m13343t() {
        return this.f11440a.m13257t();
    }

    public String m13344u() {
        return this.f11440a.m13258u();
    }

    public ih m13345v() {
        return this.f11441b;
    }

    public aw m13346w() {
        return this.f11440a.m13260w();
    }

    public ay m13347x() {
        return this.f11440a.m13261x();
    }

    public void m13348y() {
        this.f11440a.m13262y();
    }

    public void m13349z() {
        this.f11440a.m13263z();
    }
}
