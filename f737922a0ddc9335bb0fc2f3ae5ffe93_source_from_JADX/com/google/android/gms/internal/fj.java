package com.google.android.gms.internal;

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
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

@eh
public interface fj extends e, cn {
    void DW(int i);

    void DW(c cVar);

    void DW(boolean z);

    c EQ();

    WebView FH();

    void FH(boolean z);

    View Hw();

    fk J0();

    boolean J8();

    boolean Mr();

    VersionInfoParcel QX();

    fh U2();

    Activity VH();

    y Ws();

    boolean XL();

    void Zo();

    aw a8();

    boolean aM();

    void er();

    Context getContext();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    Context gn();

    void j3();

    void j6(int i);

    void j6(Context context);

    void j6(AdSizeParcel adSizeParcel);

    void j6(c cVar);

    void j6(fn fnVar);

    void j6(String str);

    void j6(String str, Map<String, ?> map);

    void j6(boolean z);

    ax lg();

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    fn rN();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    c tp();

    a u7();

    void v5();

    AdSizeParcel we();

    void yS();
}
