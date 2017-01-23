package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.internal.aq;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.zzkd;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Future;

@eh
public class c extends com.google.android.gms.internal.dp.a implements p {
    static final int j6;
    AdOverlayInfoParcel DW;
    b EQ;
    fj FH;
    c Hw;
    int J0;
    j J8;
    private boolean QX;
    FrameLayout VH;
    private final Activity Ws;
    private boolean XL;
    boolean Zo;
    private boolean aM;
    CustomViewCallback gn;
    boolean tp;
    boolean u7;
    l v5;
    boolean we;

    class 1 implements com.google.android.gms.internal.fk.a {
        final /* synthetic */ c j6;

        1(c cVar) {
            this.j6 = cVar;
        }

        public void j6(fj fjVar, boolean z) {
            fjVar.Zo();
        }
    }

    @eh
    private static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    @eh
    static class b extends RelativeLayout {
        boolean DW;
        zzkd j6;

        public b(Context context, String str) {
            super(context);
            this.j6 = new zzkd(context, str);
        }

        void j6() {
            this.DW = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!this.DW) {
                this.j6.j6(motionEvent);
            }
            return false;
        }
    }

    @eh
    public static class c {
        public final LayoutParams DW;
        public final ViewGroup FH;
        public final Context Hw;
        public final int j6;

        public c(fj fjVar) {
            this.DW = fjVar.getLayoutParams();
            ViewParent parent = fjVar.getParent();
            this.Hw = fjVar.gn();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new a("Could not get the parent of the WebView for an overlay.");
            }
            this.FH = (ViewGroup) parent;
            this.j6 = this.FH.indexOfChild(fjVar.Hw());
            this.FH.removeView(fjVar.Hw());
            fjVar.j6(true);
        }
    }

    @eh
    private class d extends en {
        final /* synthetic */ c j6;

        class 1 implements Runnable {
            final /* synthetic */ d DW;
            final /* synthetic */ Drawable j6;

            1(d dVar, Drawable drawable) {
                this.DW = dVar;
                this.j6 = drawable;
            }

            public void run() {
                this.DW.j6.Ws.getWindow().setBackgroundDrawable(this.j6);
            }
        }

        private d(c cVar) {
            this.j6 = cVar;
        }

        public void j6() {
            Bitmap j6 = f.tp().j6(Integer.valueOf(this.j6.DW.XL.VH));
            if (j6 != null) {
                et.j6.post(new 1(this, f.v5().j6(this.j6.Ws, j6, this.j6.DW.XL.v5, this.j6.DW.XL.Zo)));
            }
        }
    }

    static {
        j6 = Color.argb(0, 0, 0, 0);
    }

    public void DW() {
        if (this.DW != null && this.Zo) {
            j6(this.DW.EQ);
        }
        if (this.VH != null) {
            this.Ws.setContentView(this.EQ);
            we();
            this.VH.removeAllViews();
            this.VH = null;
        }
        if (this.gn != null) {
            this.gn.onCustomViewHidden();
            this.gn = null;
        }
        this.Zo = false;
    }

    protected void DW(int i) {
        this.FH.j6(i);
    }

    public void DW(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.u7);
    }

    protected void DW(boolean z) {
        if (!this.QX) {
            this.Ws.requestWindowFeature(1);
        }
        Window window = this.Ws.getWindow();
        if (window == null) {
            throw new a("Invalid activity, no window available.");
        }
        if (!this.tp || (this.DW.XL != null && this.DW.XL.FH)) {
            window.setFlags(1024, 1024);
        }
        boolean DW = this.DW.v5.J0().DW();
        this.we = false;
        if (DW) {
            if (this.DW.EQ == f.v5().j6()) {
                this.we = this.Ws.getResources().getConfiguration().orientation == 1;
            } else if (this.DW.EQ == f.v5().DW()) {
                this.we = this.Ws.getResources().getConfiguration().orientation == 2;
            }
        }
        com.google.android.gms.ads.internal.util.client.b.j6("Delay onShow to next orientation change: " + this.we);
        j6(this.DW.EQ);
        if (f.v5().j6(window)) {
            com.google.android.gms.ads.internal.util.client.b.j6("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.tp) {
            this.EQ.setBackgroundColor(j6);
        } else {
            this.EQ.setBackgroundColor(-16777216);
        }
        this.Ws.setContentView(this.EQ);
        we();
        if (z) {
            this.FH = f.Hw().j6(this.Ws, this.DW.v5.we(), true, DW, null, this.DW.J8, null, null, this.DW.v5.u7());
            this.FH.J0().j6(null, null, this.DW.Zo, this.DW.tp, true, this.DW.Ws, null, this.DW.v5.J0().j6(), null, null);
            this.FH.J0().j6(new 1(this));
            if (this.DW.J0 != null) {
                this.FH.loadUrl(this.DW.J0);
            } else if (this.DW.u7 != null) {
                this.FH.loadDataWithBaseURL(this.DW.VH, this.DW.u7, "text/html", "UTF-8", null);
            } else {
                throw new a("No URL or HTML to display in ad overlay.");
            }
            if (this.DW.v5 != null) {
                this.DW.v5.DW(this);
            }
        } else {
            this.FH = this.DW.v5;
            this.FH.j6(this.Ws);
        }
        this.FH.j6(this);
        ViewParent parent = this.FH.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.FH.Hw());
        }
        if (this.tp) {
            this.FH.setBackgroundColor(j6);
        }
        this.EQ.addView(this.FH.Hw(), -1, -1);
        if (!(z || this.we)) {
            QX();
        }
        j6(DW);
        if (this.FH.J8()) {
            j6(DW, true);
        }
        com.google.android.gms.ads.internal.a u7 = this.FH.u7();
        k kVar = u7 != null ? u7.FH : null;
        if (kVar != null) {
            this.J8 = kVar.j6(this.Ws, this.FH, this.EQ);
        } else {
            com.google.android.gms.ads.internal.util.client.b.Hw("Appstreaming controller is null.");
        }
    }

    public void EQ() {
        if (this.FH != null) {
            this.EQ.removeView(this.FH.Hw());
        }
        J8();
    }

    public void FH() {
        this.J0 = 1;
        this.Ws.finish();
    }

    public void Hw() {
        this.J0 = 0;
    }

    public void J0() {
        this.EQ.removeView(this.v5);
        j6(true);
    }

    protected void J8() {
        if (this.Ws.isFinishing() && !this.XL) {
            this.XL = true;
            if (this.FH != null) {
                DW(this.J0);
                this.EQ.removeView(this.FH.Hw());
                if (this.Hw != null) {
                    this.FH.j6(this.Hw.Hw);
                    this.FH.j6(false);
                    this.Hw.FH.addView(this.FH.Hw(), this.Hw.j6, this.Hw.DW);
                    this.Hw = null;
                } else if (this.Ws.getApplicationContext() != null) {
                    this.FH.j6(this.Ws.getApplicationContext());
                }
                this.FH = null;
            }
            if (!(this.DW == null || this.DW.Hw == null)) {
                this.DW.Hw.j6();
            }
            this.J8.FH();
        }
    }

    protected void QX() {
        this.FH.Zo();
    }

    public void VH() {
    }

    public void Ws() {
        if (this.we) {
            this.we = false;
            QX();
        }
    }

    public void XL() {
        this.EQ.j6();
    }

    public void Zo() {
    }

    public void gn() {
        if (this.DW != null && this.DW.we == 4) {
            if (this.u7) {
                this.J0 = 3;
                this.Ws.finish();
            } else {
                this.u7 = true;
            }
        }
        if (this.DW.Hw != null) {
            this.DW.Hw.FH();
        }
        if (this.FH == null || this.FH.aM()) {
            com.google.android.gms.ads.internal.util.client.b.Hw("The webview does not exit. Ignoring action.");
        } else {
            f.v5().DW(this.FH);
        }
        this.J8.DW();
    }

    public void j6() {
        this.J0 = 2;
        this.Ws.finish();
    }

    public void j6(int i) {
        this.Ws.setRequestedOrientation(i);
    }

    public void j6(int i, int i2, Intent intent) {
    }

    public void j6(Bundle bundle) {
        boolean z = false;
        this.Ws.requestWindowFeature(1);
        if (bundle != null) {
            z = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.u7 = z;
        try {
            this.DW = AdOverlayInfoParcel.j6(this.Ws.getIntent());
            if (this.DW == null) {
                throw new a("Could not get info for ad overlay.");
            }
            if (this.DW.J8.Hw > 7500000) {
                this.J0 = 3;
            }
            if (this.Ws.getIntent() != null) {
                this.aM = this.Ws.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.DW.XL != null) {
                this.tp = this.DW.XL.DW;
            } else {
                this.tp = false;
            }
            if (((Boolean) aq.ys.FH()).booleanValue() && this.tp && this.DW.XL.VH != -1) {
                Future future = (Future) new d().FH();
            }
            if (bundle == null) {
                if (this.DW.Hw != null && this.aM) {
                    this.DW.Hw.Hw();
                }
                if (!(this.DW.we == 1 || this.DW.FH == null)) {
                    this.DW.FH.v5();
                }
            }
            this.EQ = new b(this.Ws, this.DW.QX);
            this.EQ.setId(1000);
            switch (this.DW.we) {
                case ProxyTextView.TYPEFACE_SANS /*1*/:
                    DW(false);
                case ProxyTextView.TYPEFACE_SERIF /*2*/:
                    this.Hw = new c(this.DW.v5);
                    DW(false);
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    DW(true);
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    if (this.u7) {
                        this.J0 = 3;
                        this.Ws.finish();
                    } else if (!f.j6().j6(this.Ws, this.DW.DW, this.DW.tp)) {
                        this.J0 = 3;
                        this.Ws.finish();
                    }
                default:
                    throw new a("Could not determine ad overlay type.");
            }
        } catch (a e) {
            com.google.android.gms.ads.internal.util.client.b.Hw(e.getMessage());
            this.J0 = 3;
            this.Ws.finish();
        }
    }

    public void j6(View view, CustomViewCallback customViewCallback) {
        this.VH = new FrameLayout(this.Ws);
        this.VH.setBackgroundColor(-16777216);
        this.VH.addView(view, -1, -1);
        this.Ws.setContentView(this.VH);
        we();
        this.gn = customViewCallback;
        this.Zo = true;
    }

    public void j6(fj fjVar, Map<String, String> map) {
        this.J8.j6(fjVar, map);
    }

    public void j6(boolean z) {
        this.v5 = new l(this.Ws, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.v5.j6(z, this.DW.gn);
        this.EQ.addView(this.v5, layoutParams);
    }

    public void j6(boolean z, boolean z2) {
        if (this.v5 != null) {
            this.v5.j6(z, z2);
        }
    }

    public void tp() {
        J8();
    }

    public void u7() {
        this.J8.j6();
        DW();
        if (this.DW.Hw != null) {
            this.DW.Hw.DW();
        }
        if (this.FH != null && (!this.Ws.isFinishing() || this.Hw == null)) {
            f.v5().j6(this.FH);
        }
        J8();
    }

    public boolean v5() {
        boolean z = true;
        this.J0 = 0;
        if (this.FH != null) {
            if (!(this.FH.Mr() && this.J8.Hw())) {
                z = false;
            }
            if (!z) {
                this.FH.j6("onbackblocked", Collections.emptyMap());
            }
        }
        return z;
    }

    public void we() {
        this.QX = true;
    }
}
