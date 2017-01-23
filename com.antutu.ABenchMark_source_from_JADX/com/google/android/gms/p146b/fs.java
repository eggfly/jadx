package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.C2972b;
import com.google.android.gms.p146b.fq.C2732a;
import com.google.android.gms.p146b.gx.C3232a;

@gb
@TargetApi(19)
/* renamed from: com.google.android.gms.b.fs */
public class fs extends fr {
    private Object f10946g;
    private PopupWindow f10947h;
    private boolean f10948i;

    fs(Context context, C3232a c3232a, ii iiVar, C2732a c2732a) {
        super(context, c3232a, iiVar, c2732a);
        this.f10946g = new Object();
        this.f10948i = false;
    }

    private void m12744g() {
        synchronized (this.f10946g) {
            this.f10948i = true;
            if ((this.b instanceof Activity) && ((Activity) this.b).isDestroyed()) {
                this.f10947h = null;
            }
            if (this.f10947h != null) {
                if (this.f10947h.isShowing()) {
                    this.f10947h.dismiss();
                }
                this.f10947h = null;
            }
        }
    }

    protected void m12745a(int i) {
        m12744g();
        super.m12712a(i);
    }

    public void m12746d() {
        m12744g();
        super.m12716d();
    }

    protected void m12747f() {
        Window window = this.b instanceof Activity ? ((Activity) this.b).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.b).isDestroyed()) {
            View frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.c.m13233b(), -1, -1);
            synchronized (this.f10946g) {
                if (this.f10948i) {
                    return;
                }
                this.f10947h = new PopupWindow(frameLayout, 1, 1, false);
                this.f10947h.setOutsideTouchable(true);
                this.f10947h.setClippingEnabled(false);
                C2972b.m11576a("Displaying the 1x1 popup off the screen.");
                try {
                    this.f10947h.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.f10947h = null;
                }
            }
        }
    }
}
