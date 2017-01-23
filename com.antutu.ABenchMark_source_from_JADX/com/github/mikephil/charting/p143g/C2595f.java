package com.github.mikephil.charting.p143g;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.C2548d;
import com.github.mikephil.charting.charts.C2551e;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p143g.C2588b.C2590a;
import com.github.mikephil.charting.p145i.C2620f;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.github.mikephil.charting.g.f */
public class C2595f extends C2588b<C2548d<?>> {
    private PointF f9005f;
    private float f9006g;
    private ArrayList<C2594a> f9007h;
    private long f9008i;
    private float f9009j;

    /* renamed from: com.github.mikephil.charting.g.f.a */
    private class C2594a {
        public long f9002a;
        public float f9003b;
        final /* synthetic */ C2595f f9004c;

        public C2594a(C2595f c2595f, long j, float f) {
            this.f9004c = c2595f;
            this.f9002a = j;
            this.f9003b = f;
        }
    }

    public C2595f(C2548d<?> c2548d) {
        super(c2548d);
        this.f9005f = new PointF();
        this.f9006g = 0.0f;
        this.f9007h = new ArrayList();
        this.f9008i = 0;
        this.f9009j = 0.0f;
    }

    private void m9928c() {
        this.f9007h.clear();
    }

    private void m9929c(float f, float f2) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f9007h.add(new C2594a(this, currentAnimationTimeMillis, ((C2548d) this.e).m9702a(f, f2)));
        for (int size = this.f9007h.size(); size - 2 > 0 && currentAnimationTimeMillis - ((C2594a) this.f9007h.get(0)).f9002a > 1000; size--) {
            this.f9007h.remove(0);
        }
    }

    private float m9930d() {
        if (this.f9007h.isEmpty()) {
            return 0.0f;
        }
        C2594a c2594a = (C2594a) this.f9007h.get(0);
        C2594a c2594a2 = (C2594a) this.f9007h.get(this.f9007h.size() - 1);
        C2594a c2594a3 = c2594a;
        for (int size = this.f9007h.size() - 1; size >= 0; size--) {
            c2594a3 = (C2594a) this.f9007h.get(size);
            if (c2594a3.f9003b != c2594a2.f9003b) {
                break;
            }
        }
        float f = ((float) (c2594a2.f9002a - c2594a.f9002a)) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        Object obj = c2594a2.f9003b >= c2594a3.f9003b ? 1 : null;
        Object obj2 = ((double) Math.abs(c2594a2.f9003b - c2594a3.f9003b)) > 270.0d ? obj == null ? 1 : null : obj;
        if (((double) (c2594a2.f9003b - c2594a.f9003b)) > 180.0d) {
            c2594a.f9003b = (float) (((double) c2594a.f9003b) + 360.0d);
        } else if (((double) (c2594a.f9003b - c2594a2.f9003b)) > 180.0d) {
            c2594a2.f9003b = (float) (((double) c2594a2.f9003b) + 360.0d);
        }
        float abs = Math.abs((c2594a2.f9003b - c2594a.f9003b) / f);
        return obj2 == null ? -abs : abs;
    }

    public void m9931a() {
        this.f9009j = 0.0f;
    }

    public void m9932a(float f, float f2) {
        this.f9006g = ((C2548d) this.e).m9702a(f, f2) - ((C2548d) this.e).getRawRotationAngle();
    }

    public void m9933b() {
        if (this.f9009j != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9009j = ((C2548d) this.e).getDragDecelerationFrictionCoef() * this.f9009j;
            ((C2548d) this.e).setRotationAngle(((C2548d) this.e).getRotationAngle() + ((((float) (currentAnimationTimeMillis - this.f9008i)) / 1000.0f) * this.f9009j));
            this.f9008i = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f9009j)) >= 0.001d) {
                C2620f.m10063a(this.e);
            } else {
                m9931a();
            }
        }
    }

    public void m9934b(float f, float f2) {
        ((C2548d) this.e).setRotationAngle(((C2548d) this.e).m9702a(f, f2) - this.f9006g);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.a = C2590a.LONG_PRESS;
        C2591c onChartGestureListener = ((C2548d) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9918a(motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i = 0;
        this.a = C2590a.SINGLE_TAP;
        C2591c onChartGestureListener = ((C2548d) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9925c(motionEvent);
        }
        if (!((C2548d) this.e).m9659t()) {
            return false;
        }
        float b = ((C2548d) this.e).m9706b(motionEvent.getX(), motionEvent.getY());
        if (b > ((C2548d) this.e).getRadius()) {
            if (this.c == null) {
                ((C2548d) this.e).m9651a(null);
            } else {
                ((C2548d) this.e).m9649a(null);
            }
            this.c = null;
        } else {
            float a = ((C2548d) this.e).m9702a(motionEvent.getX(), motionEvent.getY());
            if (this.e instanceof PieChart) {
                a /= ((C2548d) this.e).getAnimator().m9540a();
            }
            int a2 = ((C2548d) this.e).m9703a(a);
            if (a2 < 0) {
                ((C2548d) this.e).m9651a(null);
                this.c = null;
            } else {
                List b2 = ((C2548d) this.e).m9707b(a2);
                if (this.e instanceof C2551e) {
                    i = C2620f.m10057a(b2, b / ((C2551e) this.e).getFactor(), null);
                }
                if (i < 0) {
                    ((C2548d) this.e).m9651a(null);
                    this.c = null;
                } else {
                    m9905a(new C2581c(a2, i), motionEvent);
                }
            }
        }
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.d.onTouchEvent(motionEvent) && ((C2548d) this.e).m9711j()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m9903a(motionEvent);
                    m9931a();
                    m9928c();
                    if (((C2548d) this.e).m9661v()) {
                        m9929c(x, y);
                    }
                    m9932a(x, y);
                    this.f9005f.x = x;
                    this.f9005f.y = y;
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    if (((C2548d) this.e).m9661v()) {
                        m9931a();
                        m9929c(x, y);
                        this.f9009j = m9930d();
                        if (this.f9009j != 0.0f) {
                            this.f9008i = AnimationUtils.currentAnimationTimeMillis();
                            C2620f.m10063a(this.e);
                        }
                    }
                    ((C2548d) this.e).m9664y();
                    this.b = 0;
                    m9906b(motionEvent);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (((C2548d) this.e).m9661v()) {
                        m9929c(x, y);
                    }
                    if (this.b == 0 && C2588b.m9902a(x, this.f9005f.x, y, this.f9005f.y) > C2620f.m10053a(8.0f)) {
                        this.a = C2590a.ROTATE;
                        this.b = 6;
                        ((C2548d) this.e).m9663x();
                    } else if (this.b == 6) {
                        m9934b(x, y);
                        ((C2548d) this.e).invalidate();
                    }
                    m9906b(motionEvent);
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
