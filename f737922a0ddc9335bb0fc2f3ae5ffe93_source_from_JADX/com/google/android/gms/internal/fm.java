package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@eh
class fm extends FrameLayout implements fj {
    private final fh DW;
    private final fj j6;

    public fm(fj fjVar) {
        super(fjVar.getContext());
        this.j6 = fjVar;
        this.DW = new fh(fjVar.gn(), this, this);
        fk J0 = this.j6.J0();
        if (J0 != null) {
            J0.j6((fj) this);
        }
        addView(this.j6.Hw());
    }

    public void DW() {
        this.j6.DW();
    }

    public void DW(int i) {
        this.j6.DW(i);
    }

    public void DW(c cVar) {
        this.j6.DW(cVar);
    }

    public void DW(boolean z) {
        this.j6.DW(z);
    }

    public c EQ() {
        return this.j6.EQ();
    }

    public WebView FH() {
        return this.j6.FH();
    }

    public void FH(boolean z) {
        this.j6.FH(z);
    }

    public View Hw() {
        return this;
    }

    public fk J0() {
        return this.j6.J0();
    }

    public boolean J8() {
        return this.j6.J8();
    }

    public boolean Mr() {
        return this.j6.Mr();
    }

    public VersionInfoParcel QX() {
        return this.j6.QX();
    }

    public fh U2() {
        return this.DW;
    }

    public Activity VH() {
        return this.j6.VH();
    }

    public y Ws() {
        return this.j6.Ws();
    }

    public boolean XL() {
        return this.j6.XL();
    }

    public void Zo() {
        this.j6.Zo();
    }

    public aw a8() {
        return this.j6.a8();
    }

    public boolean aM() {
        return this.j6.aM();
    }

    public void er() {
        this.j6.er();
    }

    public Context gn() {
        return this.j6.gn();
    }

    public void j3() {
        this.DW.FH();
        this.j6.j3();
    }

    public void j6() {
        this.j6.j6();
    }

    public void j6(int i) {
        this.j6.j6(i);
    }

    public void j6(Context context) {
        this.j6.j6(context);
    }

    public void j6(AdSizeParcel adSizeParcel) {
        this.j6.j6(adSizeParcel);
    }

    public void j6(c cVar) {
        this.j6.j6(cVar);
    }

    public void j6(fn fnVar) {
        this.j6.j6(fnVar);
    }

    public void j6(String str) {
        this.j6.j6(str);
    }

    public void j6(String str, by byVar) {
        this.j6.j6(str, byVar);
    }

    public void j6(String str, Map<String, ?> map) {
        this.j6.j6(str, map);
    }

    public void j6(String str, JSONObject jSONObject) {
        this.j6.j6(str, jSONObject);
    }

    public void j6(boolean z) {
        this.j6.j6(z);
    }

    public ax lg() {
        return this.j6.lg();
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.j6.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        this.j6.loadUrl(str);
    }

    public void onPause() {
        this.DW.DW();
        this.j6.onPause();
    }

    public void onResume() {
        this.j6.onResume();
    }

    public fn rN() {
        return this.j6.rN();
    }

    public void setBackgroundColor(int i) {
        this.j6.setBackgroundColor(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.j6.setOnClickListener(onClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.j6.setOnTouchListener(onTouchListener);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.j6.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.j6.setWebViewClient(webViewClient);
    }

    public c tp() {
        return this.j6.tp();
    }

    public a u7() {
        return this.j6.u7();
    }

    public void v5() {
        this.j6.v5();
    }

    public AdSizeParcel we() {
        return this.j6.we();
    }

    public void yS() {
        this.j6.yS();
    }
}
