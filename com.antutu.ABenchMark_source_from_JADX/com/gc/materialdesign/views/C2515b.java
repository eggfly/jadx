package com.gc.materialdesign.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* renamed from: com.gc.materialdesign.views.b */
public class C2515b extends RelativeLayout {
    final int f8628o;
    int f8629p;
    public boolean f8630q;
    boolean f8631r;

    public C2515b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8628o = Color.parseColor("#E2E2E2");
        this.f8630q = false;
        this.f8631r = false;
    }

    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.f8631r = false;
    }

    protected void onAnimationStart() {
        super.onAnimationStart();
        this.f8631r = true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8631r) {
            invalidate();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setBackgroundColor(this.f8629p);
        } else {
            setBackgroundColor(this.f8628o);
        }
        invalidate();
    }
}
