package com.antutu.benchmark.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class KeyboardLayout extends LinearLayout {
    private boolean f5802a;
    private boolean f5803b;
    private int f5804c;
    private C1445a f5805d;

    /* renamed from: com.antutu.benchmark.view.KeyboardLayout.a */
    public interface C1445a {
        void m5678a(int i);
    }

    public KeyboardLayout(Context context) {
        super(context);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeyboardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f5802a) {
            this.f5804c = this.f5804c < i4 ? i4 : this.f5804c;
        } else {
            this.f5802a = true;
            this.f5804c = i4;
            if (this.f5805d != null) {
                this.f5805d.m5678a(-1);
            }
        }
        if (this.f5802a && this.f5804c > i4) {
            this.f5803b = true;
            if (this.f5805d != null) {
                this.f5805d.m5678a(-3);
            }
        }
        if (this.f5802a && this.f5803b && this.f5804c == i4) {
            this.f5803b = false;
            if (this.f5805d != null) {
                this.f5805d.m5678a(-2);
            }
        }
    }

    public void setOnkbdStateListener(C1445a c1445a) {
        this.f5805d = c1445a;
    }
}
