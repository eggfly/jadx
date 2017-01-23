package com.google.android.gms.internal;

import agb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.w;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@eh
class zzle extends WebView implements OnGlobalLayoutListener, DownloadListener, fj {
    private int BT;
    private final zza DW;
    private boolean EQ;
    private final Object FH;
    private final y Hw;
    private boolean J0;
    private boolean J8;
    private boolean Mr;
    private int P8;
    private int QX;
    private final WindowManager SI;
    private aw U2;
    private final a VH;
    private Boolean Ws;
    private boolean XL;
    private final e Zo;
    private aw a8;
    private String aM;
    private int ei;
    private WeakReference<OnClickListener> er;
    private ez gW;
    private fk gn;
    private fn j3;
    boolean j6;
    private aw lg;
    private Map<String, ci> nw;
    private ax rN;
    private AdSizeParcel tp;
    private c u7;
    private final VersionInfoParcel v5;
    private int vy;
    private boolean we;
    private c yS;

    class 1 implements Runnable {
        final /* synthetic */ zzle j6;

        1(zzle com_google_android_gms_internal_zzle) {
            this.j6 = com_google_android_gms_internal_zzle;
        }

        public void run() {
            super.destroy();
        }
    }

    @eh
    public static class zza extends MutableContextWrapper {
        private Context DW;
        private Context FH;
        private Activity j6;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Context DW() {
            return this.FH;
        }

        public Object getSystemService(String str) {
            return this.FH.getSystemService(str);
        }

        public Activity j6() {
            return this.j6;
        }

        public void setBaseContext(Context context) {
            this.DW = context.getApplicationContext();
            this.j6 = context instanceof Activity ? (Activity) context : null;
            this.FH = context;
            super.setBaseContext(this.DW);
        }

        public void startActivity(Intent intent) {
            if (this.j6 != null) {
                this.j6.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.DW.startActivity(intent);
        }
    }

    protected zzle(zza com_google_android_gms_internal_zzle_zza, AdSizeParcel adSizeParcel, boolean z, boolean z2, y yVar, VersionInfoParcel versionInfoParcel, ay ayVar, e eVar, a aVar) {
        super(com_google_android_gms_internal_zzle_zza);
        this.FH = new Object();
        this.XL = true;
        this.j6 = false;
        this.aM = "";
        this.BT = -1;
        this.vy = -1;
        this.P8 = -1;
        this.ei = -1;
        this.DW = com_google_android_gms_internal_zzle_zza;
        this.tp = adSizeParcel;
        this.J0 = z;
        this.QX = -1;
        this.Hw = yVar;
        this.v5 = versionInfoParcel;
        this.Zo = eVar;
        this.VH = aVar;
        this.SI = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        f.FH().j6((Context) com_google_android_gms_internal_zzle_zza, versionInfoParcel.DW, settings);
        f.v5().j6(getContext(), settings);
        setDownloadListener(this);
        ei();
        if (agb.v5()) {
            addJavascriptInterface(new fo(this), "googleAdsJsInterface");
        }
        if (agb.j6()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.gW = new ez(this.DW.j6(), this, this, null);
        j6(ayVar);
    }

    private void Hw(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        j6("onAdVisibilityChanged", hashMap);
    }

    private void KD() {
        synchronized (this.FH) {
            this.nw = null;
        }
    }

    private void P8() {
        at.j6(this.rN.j6(), this.U2, "aeh");
    }

    private void SI() {
        synchronized (this.FH) {
            if (this.J8) {
                f.v5().j6((View) this);
            }
            this.J8 = false;
        }
    }

    private void ei() {
        synchronized (this.FH) {
            if (this.J0 || this.tp.v5) {
                if (VERSION.SDK_INT < 14) {
                    b.j6("Disabling hardware acceleration on an overlay.");
                    nw();
                } else {
                    b.j6("Enabling hardware acceleration on an overlay.");
                    SI();
                }
            } else if (VERSION.SDK_INT < 18) {
                b.j6("Disabling hardware acceleration on an AdView.");
                nw();
            } else {
                b.j6("Enabling hardware acceleration on an AdView.");
                SI();
            }
        }
    }

    static zzle j6(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, y yVar, VersionInfoParcel versionInfoParcel, ay ayVar, e eVar, a aVar) {
        return new zzle(new zza(context), adSizeParcel, z, z2, yVar, versionInfoParcel, ayVar, eVar, aVar);
    }

    private void j6(ay ayVar) {
        ro();
        this.rN = new ax(new ay(true, "make_wv", this.tp.DW));
        this.rN.j6().j6(ayVar);
        this.a8 = at.j6(this.rN.j6());
        this.rN.j6("native:view_create", this.a8);
        this.lg = null;
        this.U2 = null;
    }

    private void nw() {
        synchronized (this.FH) {
            if (!this.J8) {
                f.v5().DW((View) this);
            }
            this.J8 = true;
        }
    }

    private void ro() {
        if (this.rN != null) {
            ay j6 = this.rN.j6();
            if (j6 != null && f.Zo().j6() != null) {
                f.Zo().j6().j6(j6);
            }
        }
    }

    private void vy() {
        synchronized (this.FH) {
            this.Ws = f.Zo().FH();
            if (this.Ws == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    j6(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    j6(Boolean.valueOf(false));
                }
            }
        }
    }

    Boolean BT() {
        Boolean bool;
        synchronized (this.FH) {
            bool = this.Ws;
        }
        return bool;
    }

    public void DW() {
        synchronized (this.FH) {
            this.j6 = false;
            if (this.Zo != null) {
                this.Zo.DW();
            }
        }
    }

    public void DW(int i) {
        synchronized (this.FH) {
            this.QX = i;
            if (this.u7 != null) {
                this.u7.j6(this.QX);
            }
        }
    }

    public void DW(c cVar) {
        synchronized (this.FH) {
            this.yS = cVar;
        }
    }

    protected void DW(String str) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    public void DW(boolean z) {
        synchronized (this.FH) {
            if (this.u7 != null) {
                this.u7.j6(this.gn.DW(), z);
            } else {
                this.EQ = z;
            }
        }
    }

    public c EQ() {
        c cVar;
        synchronized (this.FH) {
            cVar = this.yS;
        }
        return cVar;
    }

    public WebView FH() {
        return this;
    }

    protected void FH(String str) {
        if (agb.VH()) {
            if (BT() == null) {
                vy();
            }
            if (BT().booleanValue()) {
                j6(str, null);
                return;
            }
            String str2 = "javascript:";
            String valueOf = String.valueOf(str);
            DW(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return;
        }
        str2 = "javascript:";
        valueOf = String.valueOf(str);
        DW(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    public void FH(boolean z) {
        synchronized (this.FH) {
            this.XL = z;
        }
    }

    public View Hw() {
        return this;
    }

    public fk J0() {
        return this.gn;
    }

    public boolean J8() {
        boolean z;
        synchronized (this.FH) {
            z = this.EQ;
        }
        return z;
    }

    public boolean Mr() {
        boolean z;
        synchronized (this.FH) {
            at.j6(this.rN.j6(), this.U2, "aebb");
            z = this.XL;
        }
        return z;
    }

    public VersionInfoParcel QX() {
        return this.v5;
    }

    public fh U2() {
        return null;
    }

    public Activity VH() {
        return this.DW.j6();
    }

    public y Ws() {
        return this.Hw;
    }

    public boolean XL() {
        boolean z;
        synchronized (this.FH) {
            z = this.J0;
        }
        return z;
    }

    public void Zo() {
        if (this.U2 == null) {
            at.j6(this.rN.j6(), this.lg, "aes");
            this.U2 = at.j6(this.rN.j6());
            this.rN.j6("native:view_show", this.U2);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.v5.DW);
        j6("onshow", hashMap);
    }

    public aw a8() {
        return this.lg;
    }

    public boolean aM() {
        boolean z;
        synchronized (this.FH) {
            z = this.we;
        }
        return z;
    }

    public void destroy() {
        synchronized (this.FH) {
            ro();
            this.gW.DW();
            if (this.u7 != null) {
                this.u7.j6();
                this.u7.EQ();
                this.u7 = null;
            }
            this.gn.v5();
            if (this.we) {
                return;
            }
            f.EQ().j6((fj) this);
            KD();
            this.we = true;
            eo.v5("Initiating WebView self destruct sequence in 3...");
            this.gn.FH();
        }
    }

    public void er() {
        this.gW.j6();
    }

    @TargetApi(19)
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
                return;
            }
            super.evaluateJavascript(str, valueCallback);
        }
    }

    protected void finalize() {
        synchronized (this.FH) {
            if (!this.we) {
                this.gn.v5();
                f.EQ().j6((fj) this);
                KD();
            }
        }
        super.finalize();
    }

    public boolean gW() {
        if (!J0().DW()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics j6 = f.FH().j6(this.SI);
        int DW = w.j6().DW(j6, j6.widthPixels);
        int DW2 = w.j6().DW(j6, j6.heightPixels);
        Activity VH = VH();
        if (VH == null || VH.getWindow() == null) {
            i = DW2;
            i2 = DW;
        } else {
            int[] j62 = f.FH().j6(VH);
            i2 = w.j6().DW(j6, j62[0]);
            i = w.j6().DW(j6, j62[1]);
        }
        if (this.vy == DW && this.BT == DW2 && this.P8 == i2 && this.ei == i) {
            return false;
        }
        boolean z = (this.vy == DW && this.BT == DW2) ? false : true;
        this.vy = DW;
        this.BT = DW2;
        this.P8 = i2;
        this.ei = i;
        new dm(this).j6(DW, DW2, i2, i, j6.density, this.SI.getDefaultDisplay().getRotation());
        return z;
    }

    public Context gn() {
        return this.DW.DW();
    }

    public void j3() {
        synchronized (this.FH) {
            eo.v5("Destroying WebView!");
            et.j6.post(new 1(this));
        }
    }

    public void j6() {
        synchronized (this.FH) {
            this.j6 = true;
            if (this.Zo != null) {
                this.Zo.j6();
            }
        }
    }

    public void j6(int i) {
        P8();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.v5.DW);
        j6("onhide", hashMap);
    }

    public void j6(Context context) {
        this.DW.setBaseContext(context);
        this.gW.j6(this.DW.j6());
    }

    public void j6(AdSizeParcel adSizeParcel) {
        synchronized (this.FH) {
            this.tp = adSizeParcel;
            requestLayout();
        }
    }

    public void j6(c cVar) {
        synchronized (this.FH) {
            this.u7 = cVar;
        }
    }

    public void j6(fn fnVar) {
        synchronized (this.FH) {
            if (this.j3 != null) {
                b.DW("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.j3 = fnVar;
        }
    }

    void j6(Boolean bool) {
        synchronized (this.FH) {
            this.Ws = bool;
        }
        f.Zo().j6(bool);
    }

    public void j6(String str) {
        synchronized (this.FH) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                b.Hw(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    @TargetApi(19)
    protected void j6(String str, ValueCallback<String> valueCallback) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void j6(String str, by byVar) {
        if (this.gn != null) {
            this.gn.DW(str, byVar);
        }
    }

    public void j6(String str, Map<String, ?> map) {
        try {
            j6(str, f.FH().j6((Map) map));
        } catch (JSONException e) {
            b.Hw("Could not convert parameters to JSON.");
        }
    }

    public void j6(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        String str2 = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        eo.v5(jSONObject2.length() != 0 ? str2.concat(jSONObject2) : new String(str2));
        FH(stringBuilder.toString());
    }

    public void j6(boolean z) {
        synchronized (this.FH) {
            this.J0 = z;
            ei();
        }
    }

    public ax lg() {
        return this.rN;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.FH) {
            if (aM()) {
                b.Hw("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    b.Hw(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        synchronized (this.FH) {
            super.onAttachedToWindow();
            if (!aM()) {
                this.gW.FH();
            }
            Hw(this.Mr);
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.FH) {
            if (!aM()) {
                this.gW.Hw();
            }
            super.onDetachedFromWindow();
        }
        Hw(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            f.FH().j6(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            b.j6(new StringBuilder((String.valueOf(str).length() + 51) + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (!aM()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean gW = gW();
        c tp = tp();
        if (tp != null && gW) {
            tp.Ws();
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = Integer.MAX_VALUE;
        synchronized (this.FH) {
            if (aM()) {
                setMeasuredDimension(0, 0);
            } else if (isInEditMode() || this.J0 || this.tp.u7 || this.tp.tp) {
                super.onMeasure(i, i2);
            } else if (this.tp.v5) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.SI.getDefaultDisplay().getMetrics(displayMetrics);
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                int mode = MeasureSpec.getMode(i);
                int size = MeasureSpec.getSize(i);
                int mode2 = MeasureSpec.getMode(i2);
                int size2 = MeasureSpec.getSize(i2);
                mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i3 = size2;
                }
                if (this.tp.VH > mode || this.tp.Hw > r0) {
                    float f = this.DW.getResources().getDisplayMetrics().density;
                    mode2 = (int) (((float) this.tp.Hw) / f);
                    size = (int) (((float) size) / f);
                    b.Hw("Not enough space to show ad. Needs " + ((int) (((float) this.tp.VH) / f)) + "x" + mode2 + " dp, but only has " + size + "x" + ((int) (((float) size2) / f)) + " dp.");
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                } else {
                    if (getVisibility() != 8) {
                        setVisibility(0);
                    }
                    setMeasuredDimension(this.tp.VH, this.tp.Hw);
                }
            }
        }
    }

    public void onPause() {
        if (!aM()) {
            try {
                if (agb.j6()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                b.DW("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!aM()) {
            try {
                if (agb.j6()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                b.DW("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hw != null) {
            this.Hw.j6(motionEvent);
        }
        return aM() ? false : super.onTouchEvent(motionEvent);
    }

    public fn rN() {
        fn fnVar;
        synchronized (this.FH) {
            fnVar = this.j3;
        }
        return fnVar;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.er = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof fk) {
            this.gn = (fk) webViewClient;
        }
    }

    public void stopLoading() {
        if (!aM()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                b.DW("Could not stop loading webview.", e);
            }
        }
    }

    public c tp() {
        c cVar;
        synchronized (this.FH) {
            cVar = this.u7;
        }
        return cVar;
    }

    public a u7() {
        return this.VH;
    }

    public void v5() {
        P8();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.v5.DW);
        j6("onhide", hashMap);
    }

    public AdSizeParcel we() {
        AdSizeParcel adSizeParcel;
        synchronized (this.FH) {
            adSizeParcel = this.tp;
        }
        return adSizeParcel;
    }

    public void yS() {
        if (this.lg == null) {
            this.lg = at.j6(this.rN.j6());
            this.rN.j6("native:view_load", this.lg);
        }
    }
}
