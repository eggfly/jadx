package com.google.android.gms.p146b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.C2968s;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C2784w;
import com.google.android.gms.ads.internal.util.client.C2972b;
import java.util.Map;
import java.util.Set;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

@gb
/* renamed from: com.google.android.gms.b.el */
public class el extends eq {
    static final Set<String> f10772a;
    private String f10773b;
    private boolean f10774c;
    private int f10775d;
    private int f10776e;
    private int f10777f;
    private int f10778g;
    private int f10779h;
    private int f10780i;
    private final Object f10781j;
    private final ii f10782k;
    private final Activity f10783l;
    private AdSizeParcel f10784m;
    private ImageView f10785n;
    private LinearLayout f10786o;
    private er f10787p;
    private PopupWindow f10788q;
    private RelativeLayout f10789r;
    private ViewGroup f10790s;

    /* renamed from: com.google.android.gms.b.el.1 */
    class C31671 implements OnClickListener {
        final /* synthetic */ el f10771a;

        C31671(el elVar) {
            this.f10771a = elVar;
        }

        public void onClick(View view) {
            this.f10771a.m12603a(true);
        }
    }

    static {
        f10772a = jh.m13552a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public el(ii iiVar, er erVar) {
        super(iiVar, "resize");
        this.f10773b = "top-right";
        this.f10774c = true;
        this.f10775d = 0;
        this.f10776e = 0;
        this.f10777f = -1;
        this.f10778g = 0;
        this.f10779h = 0;
        this.f10780i = -1;
        this.f10781j = new Object();
        this.f10782k = iiVar;
        this.f10783l = iiVar.m13243f();
        this.f10787p = erVar;
    }

    private void m12598b(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f10780i = C2968s.m11525e().m13051b((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f10777f = C2968s.m11525e().m13051b((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f10778g = C2968s.m11525e().m13051b((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f10779h = C2968s.m11525e().m13051b((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f10774c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f10773b = str;
        }
    }

    private int[] m12599d() {
        if (!m12608c()) {
            return null;
        }
        if (this.f10774c) {
            return new int[]{this.f10775d + this.f10778g, this.f10776e + this.f10779h};
        }
        int[] b = C2968s.m11525e().m13057b(this.f10783l);
        int[] d = C2968s.m11525e().m13065d(this.f10783l);
        int i = b[0];
        int i2 = this.f10775d + this.f10778g;
        int i3 = this.f10776e + this.f10779h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f10780i + i2 > i) {
            i2 = i - this.f10780i;
        }
        if (i3 < d[0]) {
            i3 = d[0];
        } else if (this.f10777f + i3 > d[1]) {
            i3 = d[1] - this.f10777f;
        }
        return new int[]{i2, i3};
    }

    void m12600a(int i, int i2) {
        if (this.f10787p != null) {
            this.f10787p.m10760a(i, i2, this.f10780i, this.f10777f);
        }
    }

    public void m12601a(int i, int i2, boolean z) {
        synchronized (this.f10781j) {
            this.f10775d = i;
            this.f10776e = i2;
            if (this.f10788q != null && z) {
                int[] d = m12599d();
                if (d != null) {
                    this.f10788q.update(C2784w.m10741a().m11560a(this.f10783l, d[0]), C2784w.m10741a().m11560a(this.f10783l, d[1]), this.f10788q.getWidth(), this.f10788q.getHeight());
                    m12605b(d[0], d[1]);
                } else {
                    m12603a(true);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m12602a(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
        r12 = this;
        r4 = -1;
        r5 = 1;
        r3 = 0;
        r6 = r12.f10781j;
        monitor-enter(r6);
        r1 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0011;
    L_0x000a:
        r1 = "Not an activity context. Cannot resize.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
    L_0x0010:
        return;
    L_0x0011:
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m13248k();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0023;
    L_0x0019:
        r1 = "Webview is not yet available, size is not set.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0020:
        r1 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        throw r1;
    L_0x0023:
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m13248k();	 Catch:{ all -> 0x0020 }
        r1 = r1.f9329e;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0034;
    L_0x002d:
        r1 = "Is interstitial. Cannot resize an interstitial.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0034:
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m13253p();	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0043;
    L_0x003c:
        r1 = "Cannot resize an expanded banner.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0043:
        r12.m12598b(r13);	 Catch:{ all -> 0x0020 }
        r1 = r12.m12604a();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0053;
    L_0x004c:
        r1 = "Invalid width and height options. Cannot resize.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0053:
        r1 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r7 = r1.getWindow();	 Catch:{ all -> 0x0020 }
        if (r7 == 0) goto L_0x0061;
    L_0x005b:
        r1 = r7.getDecorView();	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x0068;
    L_0x0061:
        r1 = "Activity context is not ready, cannot get window or decor view.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0068:
        r8 = r12.m12599d();	 Catch:{ all -> 0x0020 }
        if (r8 != 0) goto L_0x0075;
    L_0x006e:
        r1 = "Resize location out of screen or close button is not visible.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x0075:
        r1 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r9 = r12.f10780i;	 Catch:{ all -> 0x0020 }
        r9 = r1.m11560a(r2, r9);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r10 = r12.f10777f;	 Catch:{ all -> 0x0020 }
        r10 = r1.m11560a(r2, r10);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m13233b();	 Catch:{ all -> 0x0020 }
        r2 = r1.getParent();	 Catch:{ all -> 0x0020 }
        if (r2 == 0) goto L_0x01d5;
    L_0x0099:
        r1 = r2 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x01d5;
    L_0x009d:
        r0 = r2;
        r0 = (android.view.ViewGroup) r0;	 Catch:{ all -> 0x0020 }
        r1 = r0;
        r11 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r11 = r11.m13233b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r11);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10788q;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01ce;
    L_0x00ae:
        r2 = (android.view.ViewGroup) r2;	 Catch:{ all -> 0x0020 }
        r12.f10790s = r2;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C2968s.m11525e();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m13233b();	 Catch:{ all -> 0x0020 }
        r1 = r1.m13019a(r2);	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.ImageView;	 Catch:{ all -> 0x0020 }
        r11 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r2.<init>(r11);	 Catch:{ all -> 0x0020 }
        r12.f10785n = r2;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10785n;	 Catch:{ all -> 0x0020 }
        r2.setImageBitmap(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r1 = r1.m13248k();	 Catch:{ all -> 0x0020 }
        r12.f10784m = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10790s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10785n;	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
    L_0x00dd:
        r1 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f10789r = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r2 = 0;
        r1.setBackgroundColor(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r2 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0020 }
        r2.<init>(r9, r10);	 Catch:{ all -> 0x0020 }
        r1.setLayoutParams(r2);	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.C2968s.m11525e();	 Catch:{ all -> 0x0020 }
        r2 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r11 = 0;
        r1 = r1.m13021a(r2, r9, r10, r11);	 Catch:{ all -> 0x0020 }
        r12.f10788q = r1;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10788q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setOutsideTouchable(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10788q;	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r1.setTouchable(r2);	 Catch:{ all -> 0x0020 }
        r2 = r12.f10788q;	 Catch:{ all -> 0x0020 }
        r1 = r12.f10774c;	 Catch:{ all -> 0x0020 }
        if (r1 != 0) goto L_0x01dd;
    L_0x0115:
        r1 = r5;
    L_0x0116:
        r2.setClippingEnabled(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m13233b();	 Catch:{ all -> 0x0020 }
        r9 = -1;
        r10 = -1;
        r1.addView(r2, r9, r10);	 Catch:{ all -> 0x0020 }
        r1 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r1.<init>(r2);	 Catch:{ all -> 0x0020 }
        r12.f10786o = r1;	 Catch:{ all -> 0x0020 }
        r2 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0020 }
        r1 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ all -> 0x0020 }
        r9 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r10 = 50;
        r1 = r1.m11560a(r9, r10);	 Catch:{ all -> 0x0020 }
        r9 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ all -> 0x0020 }
        r10 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r11 = 50;
        r9 = r9.m11560a(r10, r11);	 Catch:{ all -> 0x0020 }
        r2.<init>(r1, r9);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10773b;	 Catch:{ all -> 0x0020 }
        r9 = r1.hashCode();	 Catch:{ all -> 0x0020 }
        switch(r9) {
            case -1364013995: goto L_0x01f6;
            case -1012429441: goto L_0x01e0;
            case -655373719: goto L_0x0201;
            case 1163912186: goto L_0x0217;
            case 1288627767: goto L_0x020c;
            case 1755462605: goto L_0x01eb;
            default: goto L_0x0155;
        };	 Catch:{ all -> 0x0020 }
    L_0x0155:
        r1 = r4;
    L_0x0156:
        switch(r1) {
            case 0: goto L_0x0222;
            case 1: goto L_0x022e;
            case 2: goto L_0x023a;
            case 3: goto L_0x0241;
            case 4: goto L_0x024d;
            case 5: goto L_0x0259;
            default: goto L_0x0159;
        };	 Catch:{ all -> 0x0020 }
    L_0x0159:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
    L_0x0163:
        r1 = r12.f10786o;	 Catch:{ all -> 0x0020 }
        r3 = new com.google.android.gms.b.el$1;	 Catch:{ all -> 0x0020 }
        r3.<init>(r12);	 Catch:{ all -> 0x0020 }
        r1.setOnClickListener(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10786o;	 Catch:{ all -> 0x0020 }
        r3 = "Close button";
        r1.setContentDescription(r3);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r3 = r12.f10786o;	 Catch:{ all -> 0x0020 }
        r1.addView(r3, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10788q;	 Catch:{ RuntimeException -> 0x0265 }
        r2 = r7.getDecorView();	 Catch:{ RuntimeException -> 0x0265 }
        r3 = 0;
        r4 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r12.f10783l;	 Catch:{ RuntimeException -> 0x0265 }
        r7 = 0;
        r7 = r8[r7];	 Catch:{ RuntimeException -> 0x0265 }
        r4 = r4.m11560a(r5, r7);	 Catch:{ RuntimeException -> 0x0265 }
        r5 = com.google.android.gms.ads.internal.client.C2784w.m10741a();	 Catch:{ RuntimeException -> 0x0265 }
        r7 = r12.f10783l;	 Catch:{ RuntimeException -> 0x0265 }
        r9 = 1;
        r9 = r8[r9];	 Catch:{ RuntimeException -> 0x0265 }
        r5 = r5.m11560a(r7, r9);	 Catch:{ RuntimeException -> 0x0265 }
        r1.showAtLocation(r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0265 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m12600a(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel;	 Catch:{ all -> 0x0020 }
        r3 = r12.f10783l;	 Catch:{ all -> 0x0020 }
        r4 = new com.google.android.gms.ads.d;	 Catch:{ all -> 0x0020 }
        r5 = r12.f10780i;	 Catch:{ all -> 0x0020 }
        r7 = r12.f10777f;	 Catch:{ all -> 0x0020 }
        r4.<init>(r5, r7);	 Catch:{ all -> 0x0020 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0020 }
        r1.m13226a(r2);	 Catch:{ all -> 0x0020 }
        r1 = 0;
        r1 = r8[r1];	 Catch:{ all -> 0x0020 }
        r2 = 1;
        r2 = r8[r2];	 Catch:{ all -> 0x0020 }
        r12.m12605b(r1, r2);	 Catch:{ all -> 0x0020 }
        r1 = "resized";
        r12.m12591d(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01ce:
        r1 = r12.f10788q;	 Catch:{ all -> 0x0020 }
        r1.dismiss();	 Catch:{ all -> 0x0020 }
        goto L_0x00dd;
    L_0x01d5:
        r1 = "Webview is detached, probably in the middle of a resize or expand.";
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
    L_0x01dd:
        r1 = r3;
        goto L_0x0116;
    L_0x01e0:
        r5 = "top-left";
        r1 = r1.equals(r5);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01e8:
        r1 = r3;
        goto L_0x0156;
    L_0x01eb:
        r3 = "top-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01f3:
        r1 = r5;
        goto L_0x0156;
    L_0x01f6:
        r3 = "center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x01fe:
        r1 = 2;
        goto L_0x0156;
    L_0x0201:
        r3 = "bottom-left";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0209:
        r1 = 3;
        goto L_0x0156;
    L_0x020c:
        r3 = "bottom-center";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x0214:
        r1 = 4;
        goto L_0x0156;
    L_0x0217:
        r3 = "bottom-right";
        r1 = r1.equals(r3);	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x0155;
    L_0x021f:
        r1 = 5;
        goto L_0x0156;
    L_0x0222:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x022e:
        r1 = 10;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x023a:
        r1 = 13;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0241:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 9;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x024d:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 14;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0259:
        r1 = 12;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        r1 = 11;
        r2.addRule(r1);	 Catch:{ all -> 0x0020 }
        goto L_0x0163;
    L_0x0265:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0020 }
        r2.<init>();	 Catch:{ all -> 0x0020 }
        r3 = "Cannot show popup window: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0020 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0020 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0020 }
        r1 = r1.toString();	 Catch:{ all -> 0x0020 }
        r12.m12589b(r1);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10789r;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m13233b();	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10790s;	 Catch:{ all -> 0x0020 }
        if (r1 == 0) goto L_0x02a8;
    L_0x028f:
        r1 = r12.f10790s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10785n;	 Catch:{ all -> 0x0020 }
        r1.removeView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10790s;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = r2.m13233b();	 Catch:{ all -> 0x0020 }
        r1.addView(r2);	 Catch:{ all -> 0x0020 }
        r1 = r12.f10782k;	 Catch:{ all -> 0x0020 }
        r2 = r12.f10784m;	 Catch:{ all -> 0x0020 }
        r1.m13226a(r2);	 Catch:{ all -> 0x0020 }
    L_0x02a8:
        monitor-exit(r6);	 Catch:{ all -> 0x0020 }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.el.a(java.util.Map):void");
    }

    public void m12603a(boolean z) {
        synchronized (this.f10781j) {
            if (this.f10788q != null) {
                this.f10788q.dismiss();
                this.f10789r.removeView(this.f10782k.m13233b());
                if (this.f10790s != null) {
                    this.f10790s.removeView(this.f10785n);
                    this.f10790s.addView(this.f10782k.m13233b());
                    this.f10782k.m13226a(this.f10784m);
                }
                if (z) {
                    m12591d("default");
                    if (this.f10787p != null) {
                        this.f10787p.m10759B();
                    }
                }
                this.f10788q = null;
                this.f10789r = null;
                this.f10790s = null;
                this.f10786o = null;
            }
        }
    }

    boolean m12604a() {
        return this.f10780i > -1 && this.f10777f > -1;
    }

    void m12605b(int i, int i2) {
        m12586a(i, i2 - C2968s.m11525e().m13065d(this.f10783l)[0], this.f10780i, this.f10777f);
    }

    public boolean m12606b() {
        boolean z;
        synchronized (this.f10781j) {
            z = this.f10788q != null;
        }
        return z;
    }

    public void m12607c(int i, int i2) {
        this.f10775d = i;
        this.f10776e = i2;
    }

    boolean m12608c() {
        int[] b = C2968s.m11525e().m13057b(this.f10783l);
        int[] d = C2968s.m11525e().m13065d(this.f10783l);
        int i = b[0];
        int i2 = b[1];
        if (this.f10780i < 50 || this.f10780i > i) {
            C2972b.m11583d("Width is too small or too large.");
            return false;
        } else if (this.f10777f < 50 || this.f10777f > i2) {
            C2972b.m11583d("Height is too small or too large.");
            return false;
        } else if (this.f10777f == i2 && this.f10780i == i) {
            C2972b.m11583d("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f10774c) {
                int i3;
                String str = this.f10773b;
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
                    case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                        i3 = this.f10778g + this.f10775d;
                        i2 = this.f10776e + this.f10779h;
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                        i3 = ((this.f10775d + this.f10778g) + (this.f10780i / 2)) - 25;
                        i2 = this.f10776e + this.f10779h;
                        break;
                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                        i3 = ((this.f10775d + this.f10778g) + (this.f10780i / 2)) - 25;
                        i2 = ((this.f10776e + this.f10779h) + (this.f10777f / 2)) - 25;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                        i3 = this.f10778g + this.f10775d;
                        i2 = ((this.f10776e + this.f10779h) + this.f10777f) - 50;
                        break;
                    case SpdyProtocol.QUIC /*4*/:
                        i3 = ((this.f10775d + this.f10778g) + (this.f10780i / 2)) - 25;
                        i2 = ((this.f10776e + this.f10779h) + this.f10777f) - 50;
                        break;
                    case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                        i3 = ((this.f10775d + this.f10778g) + this.f10780i) - 50;
                        i2 = ((this.f10776e + this.f10779h) + this.f10777f) - 50;
                        break;
                    default:
                        i3 = ((this.f10775d + this.f10778g) + this.f10780i) - 50;
                        i2 = this.f10776e + this.f10779h;
                        break;
                }
                if (i3 < 0 || i3 + 50 > i || r2 < d[0] || r2 + 50 > d[1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
