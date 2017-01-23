package com.miui.support.widget;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;

public class GuidePopupWindow extends ArrowPopupWindow {
    private LinearLayout f4171b;
    private int f4172c;
    private Context f4173d;

    /* renamed from: com.miui.support.widget.GuidePopupWindow.1 */
    class C04851 implements Runnable {
        final /* synthetic */ GuidePopupWindow f4170a;

        public void run() {
            this.f4170a.m5691a(true);
        }
    }

    protected void m5872c() {
        super.m5693c();
        this.f4172c = 5000;
        setFocusable(true);
        this.f4171b = (LinearLayout) m5871b().inflate(C0264R.layout.guide_popup_content_view, null, false);
        setContentView(this.f4171b);
        this.a.m4785a(true);
    }

    protected LayoutInflater m5871b() {
        if (this.f4173d == null) {
            this.f4173d = new ContextThemeWrapper(m5688a(), C0264R.style.Theme_Light_Guide);
        }
        return LayoutInflater.from(this.f4173d);
    }
}
