package android.support.v7.app;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;

/* renamed from: android.support.v7.app.b */
public class C0358b implements DrawerListener {
    private final C0356a f850a;
    private C0357b f851b;
    private boolean f852c;
    private final int f853d;
    private final int f854e;

    /* renamed from: android.support.v7.app.b.a */
    public interface C0356a {
        void m1008a(int i);
    }

    /* renamed from: android.support.v7.app.b.b */
    interface C0357b {
        void m1009a(float f);
    }

    void m1010a(int i) {
        this.f850a.m1008a(i);
    }

    public void onDrawerClosed(View view) {
        this.f851b.m1009a(0.0f);
        if (this.f852c) {
            m1010a(this.f853d);
        }
    }

    public void onDrawerOpened(View view) {
        this.f851b.m1009a(1.0f);
        if (this.f852c) {
            m1010a(this.f854e);
        }
    }

    public void onDrawerSlide(View view, float f) {
        this.f851b.m1009a(Math.min(1.0f, Math.max(0.0f, f)));
    }

    public void onDrawerStateChanged(int i) {
    }
}
