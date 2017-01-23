package com.google.android.gms.internal;

import afr;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.aide.uidesigner.ProxyTextView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.f;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Map;
import java.util.Set;

@eh
public class dh extends dm {
    static final Set<String> j6;
    private String DW;
    private final fj EQ;
    private boolean FH;
    private int Hw;
    private AdSizeParcel J0;
    private ImageView J8;
    private dn QX;
    private int VH;
    private LinearLayout Ws;
    private PopupWindow XL;
    private int Zo;
    private RelativeLayout aM;
    private int gn;
    private ViewGroup j3;
    private final Object tp;
    private int u7;
    private int v5;
    private final Activity we;

    class 1 implements OnClickListener {
        final /* synthetic */ dh j6;

        1(dh dhVar) {
            this.j6 = dhVar;
        }

        public void onClick(View view) {
            this.j6.j6(true);
        }
    }

    static {
        j6 = afr.j6("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public dh(fj fjVar, dn dnVar) {
        super(fjVar, "resize");
        this.DW = "top-right";
        this.FH = true;
        this.Hw = 0;
        this.v5 = 0;
        this.Zo = -1;
        this.VH = 0;
        this.gn = 0;
        this.u7 = -1;
        this.tp = new Object();
        this.EQ = fjVar;
        this.we = fjVar.VH();
        this.QX = dnVar;
    }

    private void DW(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.u7 = f.FH().j6((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.Zo = f.FH().j6((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.VH = f.FH().j6((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.gn = f.FH().j6((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.FH = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.DW = str;
        }
    }

    private int[] Hw() {
        if (!FH()) {
            return null;
        }
        if (this.FH) {
            return new int[]{this.Hw + this.VH, this.v5 + this.gn};
        }
        int[] DW = f.FH().DW(this.we);
        int[] Hw = f.FH().Hw(this.we);
        int i = DW[0];
        int i2 = this.Hw + this.VH;
        int i3 = this.v5 + this.gn;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.u7 + i2 > i) {
            i2 = i - this.u7;
        }
        if (i3 < Hw[0]) {
            i3 = Hw[0];
        } else if (this.Zo + i3 > Hw[1]) {
            i3 = Hw[1] - this.Zo;
        }
        return new int[]{i2, i3};
    }

    void DW(int i, int i2) {
        j6(i, i2 - f.FH().Hw(this.we)[0], this.u7, this.Zo);
    }

    public boolean DW() {
        boolean z;
        synchronized (this.tp) {
            z = this.XL != null;
        }
        return z;
    }

    public void FH(int i, int i2) {
        this.Hw = i;
        this.v5 = i2;
    }

    boolean FH() {
        int[] DW = f.FH().DW(this.we);
        int[] Hw = f.FH().Hw(this.we);
        int i = DW[0];
        int i2 = DW[1];
        if (this.u7 < 50 || this.u7 > i) {
            b.Hw("Width is too small or too large.");
            return false;
        } else if (this.Zo < 50 || this.Zo > i2) {
            b.Hw("Height is too small or too large.");
            return false;
        } else if (this.Zo == i2 && this.u7 == i) {
            b.Hw("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.FH) {
                int i3;
                String str = this.DW;
                boolean z = true;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            z = false;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                        i3 = this.VH + this.Hw;
                        i2 = this.v5 + this.gn;
                        break;
                    case ProxyTextView.TYPEFACE_SANS /*1*/:
                        i3 = ((this.Hw + this.VH) + (this.u7 / 2)) - 25;
                        i2 = this.v5 + this.gn;
                        break;
                    case ProxyTextView.TYPEFACE_SERIF /*2*/:
                        i3 = ((this.Hw + this.VH) + (this.u7 / 2)) - 25;
                        i2 = ((this.v5 + this.gn) + (this.Zo / 2)) - 25;
                        break;
                    case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                        i3 = this.VH + this.Hw;
                        i2 = ((this.v5 + this.gn) + this.Zo) - 50;
                        break;
                    case ProxyTextView.INPUTTYPE_datetime /*4*/:
                        i3 = ((this.Hw + this.VH) + (this.u7 / 2)) - 25;
                        i2 = ((this.v5 + this.gn) + this.Zo) - 50;
                        break;
                    case true:
                        i3 = ((this.Hw + this.VH) + this.u7) - 50;
                        i2 = ((this.v5 + this.gn) + this.Zo) - 50;
                        break;
                    default:
                        i3 = ((this.Hw + this.VH) + this.u7) - 50;
                        i2 = this.v5 + this.gn;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < Hw[0] || r2 + 50 > Hw[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    void j6(int i, int i2) {
        if (this.QX != null) {
            this.QX.j6(i, i2, this.u7, this.Zo);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j6(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.tp;
        monitor-enter(r6);
        r1 = r12.we;	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x0012;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
    L_0x0011:
        return;
    L_0x0012:
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r1 = r1.we();	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x0025;
    L_0x001a:
        r1 = "Webview is not yet available, size is not set.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x0022:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        throw r1;
    L_0x0025:
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r1 = r1.we();	 Catch:{ all -> 0x0022 }
        r1 = r1.v5;	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x0037;
    L_0x002f:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x0037:
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r1 = r1.XL();	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x0047;
    L_0x003f:
        r1 = "Cannot resize an expanded banner.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x0047:
        r12.DW(r13);	 Catch:{ all -> 0x0022 }
        r1 = r12.j6();	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x0058;
    L_0x0050:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x0058:
        r1 = r12.we;	 Catch:{ all -> 0x0022 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0022 }
        if (r7 == 0) goto L_0x0066;
    L_0x0060:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x006e;
    L_0x0066:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x006e:
        r8 = r12.Hw();	 Catch:{ all -> 0x0022 }
        if (r8 != 0) goto L_0x007c;
    L_0x0074:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x007c:
        r1 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ all -> 0x0022 }
        r2 = r12.we;	 Catch:{ all -> 0x0022 }
        r9 = r12.u7;	 Catch:{ all -> 0x0022 }
        r9 = r1.j6(r2, r9);	 Catch:{ all -> 0x0022 }
        r1 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ all -> 0x0022 }
        r2 = r12.we;	 Catch:{ all -> 0x0022 }
        r10 = r12.Zo;	 Catch:{ all -> 0x0022 }
        r10 = r1.j6(r2, r10);	 Catch:{ all -> 0x0022 }
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r1 = r1.Hw();	 Catch:{ all -> 0x0022 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0022 }
        if (r2 == 0) goto L_0x01de;
    L_0x00a0:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x01de;
    L_0x00a4:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0022 }
        r1 = r0;
        r11 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r11 = r11.Hw();	 Catch:{ all -> 0x0022 }
        r1.removeView(r11);	 Catch:{ all -> 0x0022 }
        r1 = r12.XL;	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x01d7;
    L_0x00b5:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0022 }
        r12.j3 = r2;	 Catch:{ all -> 0x0022 }
        r1 = com.google.android.gms.ads.internal.f.FH();	 Catch:{ all -> 0x0022 }
        r2 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = r2.Hw();	 Catch:{ all -> 0x0022 }
        r1 = r1.j6(r2);	 Catch:{ all -> 0x0022 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0022 }
        r11 = r12.we;	 Catch:{ all -> 0x0022 }
        r2.<init>(r11);	 Catch:{ all -> 0x0022 }
        r12.J8 = r2;	 Catch:{ all -> 0x0022 }
        r2 = r12.J8;	 Catch:{ all -> 0x0022 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0022 }
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r1 = r1.we();	 Catch:{ all -> 0x0022 }
        r12.J0 = r1;	 Catch:{ all -> 0x0022 }
        r1 = r12.j3;	 Catch:{ all -> 0x0022 }
        r2 = r12.J8;	 Catch:{ all -> 0x0022 }
        r1.addView(r2);	 Catch:{ all -> 0x0022 }
    L_0x00e4:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0022 }
        r2 = r12.we;	 Catch:{ all -> 0x0022 }
        r1.<init>(r2);	 Catch:{ all -> 0x0022 }
        r12.aM = r1;	 Catch:{ all -> 0x0022 }
        r1 = r12.aM;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.aM;	 Catch:{ all -> 0x0022 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0022 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0022 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0022 }
        r1 = com.google.android.gms.ads.internal.f.FH();	 Catch:{ all -> 0x0022 }
        r2 = r12.aM;	 Catch:{ all -> 0x0022 }
        r11 = 0;
        r1 = r1.j6(r2, r9, r10, r11);	 Catch:{ all -> 0x0022 }
        r12.XL = r1;	 Catch:{ all -> 0x0022 }
        r1 = r12.XL;	 Catch:{ all -> 0x0022 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.XL;	 Catch:{ all -> 0x0022 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0022 }
        r2 = r12.XL;	 Catch:{ all -> 0x0022 }
        r1 = r12.FH;	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x01e7;
    L_0x011c:
        r1 = r5;
    L_0x011d:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0022 }
        r1 = r12.aM;	 Catch:{ all -> 0x0022 }
        r2 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = r2.Hw();	 Catch:{ all -> 0x0022 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0022 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0022 }
        r2 = r12.we;	 Catch:{ all -> 0x0022 }
        r1.<init>(r2);	 Catch:{ all -> 0x0022 }
        r12.Ws = r1;	 Catch:{ all -> 0x0022 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0022 }
        r1 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ all -> 0x0022 }
        r9 = r12.we;	 Catch:{ all -> 0x0022 }
        r10 = 50;
        r1 = r1.j6(r9, r10);	 Catch:{ all -> 0x0022 }
        r9 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ all -> 0x0022 }
        r10 = r12.we;	 Catch:{ all -> 0x0022 }
        r11 = 50;
        r9 = r9.j6(r10, r11);	 Catch:{ all -> 0x0022 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0022 }
        r1 = r12.DW;	 Catch:{ all -> 0x0022 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0022 }
        switch(r9) {
            case -1364013995: goto L_0x0202;
            case -1012429441: goto L_0x01ea;
            case -655373719: goto L_0x020e;
            case 1163912186: goto L_0x0226;
            case 1288627767: goto L_0x021a;
            case 1755462605: goto L_0x01f6;
            default: goto L_0x015c;
        };	 Catch:{ all -> 0x0022 }
    L_0x015c:
        r1 = r4;
    L_0x015d:
        switch(r1) {
            case 0: goto L_0x0232;
            case 1: goto L_0x023e;
            case 2: goto L_0x024a;
            case 3: goto L_0x0251;
            case 4: goto L_0x025d;
            case 5: goto L_0x0269;
            default: goto L_0x0160;
        };	 Catch:{ all -> 0x0022 }
    L_0x0160:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
    L_0x016a:
        r1 = r12.Ws;	 Catch:{ all -> 0x0022 }
        r3 = new com.google.android.gms.internal.dh$1;	 Catch:{ all -> 0x0022 }
        r3.<init>(r12);	 Catch:{ all -> 0x0022 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0022 }
        r1 = r12.Ws;	 Catch:{ all -> 0x0022 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0022 }
        r1 = r12.aM;	 Catch:{ all -> 0x0022 }
        r3 = r12.Ws;	 Catch:{ all -> 0x0022 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.XL;	 Catch:{ RuntimeException -> 0x0275 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0275 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ RuntimeException -> 0x0275 }
        r5 = r12.we;	 Catch:{ RuntimeException -> 0x0275 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0275 }
        r4 = r4.j6(r5, r7);	 Catch:{ RuntimeException -> 0x0275 }
        r5 = com.google.android.gms.ads.internal.client.w.j6();	 Catch:{ RuntimeException -> 0x0275 }
        r7 = r12.we;	 Catch:{ RuntimeException -> 0x0275 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0275 }
        r5 = r5.j6(r7, r9);	 Catch:{ RuntimeException -> 0x0275 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0275 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0022 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0022 }
        r12.j6(r1, r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0022 }
        r3 = r12.we;	 Catch:{ all -> 0x0022 }
        r4 = new com.google.android.gms.ads.d;	 Catch:{ all -> 0x0022 }
        r5 = r12.u7;	 Catch:{ all -> 0x0022 }
        r7 = r12.Zo;	 Catch:{ all -> 0x0022 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0022 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0022 }
        r1.j6(r2);	 Catch:{ all -> 0x0022 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0022 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0022 }
        r12.DW(r1, r2);	 Catch:{ all -> 0x0022 }
        r1 = "resized";
        r12.Hw(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x01d7:
        r1 = r12.XL;	 Catch:{ all -> 0x0022 }
        r1.dismiss();	 Catch:{ all -> 0x0022 }
        goto L_0x00e4;
    L_0x01de:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x01e7:
        r1 = r3;
        goto L_0x011d;
    L_0x01ea:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x01f3:
        r1 = r3;
        goto L_0x015d;
    L_0x01f6:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x01ff:
        r1 = r5;
        goto L_0x015d;
    L_0x0202:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x020b:
        r1 = 2;
        goto L_0x015d;
    L_0x020e:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x0217:
        r1 = 3;
        goto L_0x015d;
    L_0x021a:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x0223:
        r1 = 4;
        goto L_0x015d;
    L_0x0226:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x015c;
    L_0x022f:
        r1 = 5;
        goto L_0x015d;
    L_0x0232:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x023e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x024a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x0251:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x025d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x0269:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x016a;
    L_0x0275:
        r1 = move-exception;
        r2 = "Cannot show popup window: ";
        r1 = r1.getMessage();	 Catch:{ all -> 0x0022 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x0022 }
        r3 = r1.length();	 Catch:{ all -> 0x0022 }
        if (r3 == 0) goto L_0x02b9;
    L_0x0287:
        r1 = r2.concat(r1);	 Catch:{ all -> 0x0022 }
    L_0x028b:
        r12.DW(r1);	 Catch:{ all -> 0x0022 }
        r1 = r12.aM;	 Catch:{ all -> 0x0022 }
        r2 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = r2.Hw();	 Catch:{ all -> 0x0022 }
        r1.removeView(r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.j3;	 Catch:{ all -> 0x0022 }
        if (r1 == 0) goto L_0x02b6;
    L_0x029d:
        r1 = r12.j3;	 Catch:{ all -> 0x0022 }
        r2 = r12.J8;	 Catch:{ all -> 0x0022 }
        r1.removeView(r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.j3;	 Catch:{ all -> 0x0022 }
        r2 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = r2.Hw();	 Catch:{ all -> 0x0022 }
        r1.addView(r2);	 Catch:{ all -> 0x0022 }
        r1 = r12.EQ;	 Catch:{ all -> 0x0022 }
        r2 = r12.J0;	 Catch:{ all -> 0x0022 }
        r1.j6(r2);	 Catch:{ all -> 0x0022 }
    L_0x02b6:
        monitor-exit(r6);	 Catch:{ all -> 0x0022 }
        goto L_0x0011;
    L_0x02b9:
        r1 = new java.lang.String;	 Catch:{ all -> 0x0022 }
        r1.<init>(r2);	 Catch:{ all -> 0x0022 }
        goto L_0x028b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dh.j6(java.util.Map):void");
    }

    public void j6(boolean z) {
        synchronized (this.tp) {
            if (this.XL != null) {
                this.XL.dismiss();
                this.aM.removeView(this.EQ.Hw());
                if (this.j3 != null) {
                    this.j3.removeView(this.J8);
                    this.j3.addView(this.EQ.Hw());
                    this.EQ.j6(this.J0);
                }
                if (z) {
                    Hw("default");
                    if (this.QX != null) {
                        this.QX.j6();
                    }
                }
                this.XL = null;
                this.aM = null;
                this.j3 = null;
                this.Ws = null;
            }
        }
    }

    boolean j6() {
        return this.u7 > -1 && this.Zo > -1;
    }
}
