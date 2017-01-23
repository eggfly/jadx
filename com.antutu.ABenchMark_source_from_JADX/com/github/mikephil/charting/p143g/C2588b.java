package com.github.mikephil.charting.p143g;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.github.mikephil.charting.charts.C2543b;
import com.github.mikephil.charting.p142e.C2581c;

/* renamed from: com.github.mikephil.charting.g.b */
public abstract class C2588b<T extends C2543b<?>> extends SimpleOnGestureListener implements OnTouchListener {
    protected C2590a f8974a;
    protected int f8975b;
    protected C2581c f8976c;
    protected GestureDetector f8977d;
    protected T f8978e;

    /* renamed from: com.github.mikephil.charting.g.b.a */
    public enum C2590a {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public C2588b(T t) {
        this.f8974a = C2590a.NONE;
        this.f8975b = 0;
        this.f8978e = t;
        this.f8977d = new GestureDetector(t.getContext(), this);
    }

    protected static float m9902a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    public void m9903a(MotionEvent motionEvent) {
        C2591c onChartGestureListener = this.f8978e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9921a(motionEvent, this.f8974a);
        }
    }

    public void m9904a(C2581c c2581c) {
        this.f8976c = c2581c;
    }

    protected void m9905a(C2581c c2581c, MotionEvent motionEvent) {
        if (c2581c == null || c2581c.m9884a(this.f8976c)) {
            this.f8978e.m9649a(null);
            this.f8976c = null;
            return;
        }
        this.f8976c = c2581c;
        this.f8978e.m9649a(c2581c);
    }

    public void m9906b(MotionEvent motionEvent) {
        C2591c onChartGestureListener = this.f8978e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9924b(motionEvent, this.f8974a);
        }
    }
}
