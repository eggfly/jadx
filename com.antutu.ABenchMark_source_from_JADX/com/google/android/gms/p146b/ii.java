package com.google.android.gms.p146b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.C2795e;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.C2864d;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@gb
/* renamed from: com.google.android.gms.b.ii */
public interface ii extends de, C3283r {
    OnClickListener m13219A();

    void m13220B();

    void m13221C();

    WebView m13222a();

    void m13223a(int i);

    void m13224a(Context context);

    void m13225a(Context context, AdSizeParcel adSizeParcel, az azVar);

    void m13226a(AdSizeParcel adSizeParcel);

    void m13227a(C2864d c2864d);

    void m13228a(String str);

    void m13229a(String str, String str2);

    void m13230a(String str, Map<String, ?> map);

    void m13231a(String str, JSONObject jSONObject);

    void m13232a(boolean z);

    View m13233b();

    void m13234b(int i);

    void m13235b(C2864d c2864d);

    void m13236b(String str);

    void m13237b(boolean z);

    void m13238c();

    void m13239c(boolean z);

    void m13240d();

    void m13241d(boolean z);

    void destroy();

    void m13242e();

    Activity m13243f();

    Context m13244g();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    C2795e m13245h();

    C2864d m13246i();

    C2864d m13247j();

    AdSizeParcel m13248k();

    ij m13249l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean m13250m();

    void measure(int i, int i2);

    C3326k m13251n();

    VersionInfoParcel m13252o();

    boolean m13253p();

    int m13254q();

    boolean m13255r();

    void m13256s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    boolean m13257t();

    String m13258u();

    ih m13259v();

    aw m13260w();

    ay m13261x();

    void m13262y();

    void m13263z();
}
