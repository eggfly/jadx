package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

class al extends RelativeLayout {
    private C1910a f6699a;

    /* renamed from: com.baidu.mobads.al.a */
    public interface C1910a {
        @SuppressLint({"MissingSuperCall"})
        void m7202a();

        void m7203a(int i);

        void m7204a(int i, int i2);

        void m7205a(boolean z);

        boolean m7206a(int i, KeyEvent keyEvent);

        void m7207b();
    }

    public al(Context context) {
        super(context);
    }

    public void m7214a(C1910a c1910a) {
        this.f6699a = c1910a;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6699a != null) {
            this.f6699a.m7207b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6699a != null) {
            this.f6699a.m7202a();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f6699a != null) {
            return this.f6699a.m7206a(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f6699a != null) {
            this.f6699a.m7204a(getWidth(), getHeight());
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f6699a != null) {
            this.f6699a.m7205a(z);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f6699a != null) {
            this.f6699a.m7203a(i);
        }
    }
}
