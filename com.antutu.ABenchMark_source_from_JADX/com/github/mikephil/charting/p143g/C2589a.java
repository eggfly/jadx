package com.github.mikephil.charting.p143g;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.facebook.ads.AdError;
import com.github.mikephil.charting.charts.C2545a;
import com.github.mikephil.charting.charts.C2550c;
import com.github.mikephil.charting.data.C2561b;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.p139f.p141b.C2563d;
import com.github.mikephil.charting.p139f.p141b.C2566b;
import com.github.mikephil.charting.p142e.C2581c;
import com.github.mikephil.charting.p143g.C2588b.C2590a;
import com.github.mikephil.charting.p145i.C2620f;
import com.github.mikephil.charting.p145i.C2621g;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: com.github.mikephil.charting.g.a */
public class C2589a extends C2588b<C2545a<? extends C2561b<? extends C2566b<? extends Entry>>>> {
    private Matrix f8979f;
    private Matrix f8980g;
    private PointF f8981h;
    private PointF f8982i;
    private float f8983j;
    private float f8984k;
    private float f8985l;
    private C2563d f8986m;
    private VelocityTracker f8987n;
    private long f8988o;
    private PointF f8989p;
    private PointF f8990q;

    public C2589a(C2545a<? extends C2561b<? extends C2566b<? extends Entry>>> c2545a, Matrix matrix) {
        super(c2545a);
        this.f8979f = new Matrix();
        this.f8980g = new Matrix();
        this.f8981h = new PointF();
        this.f8982i = new PointF();
        this.f8983j = 1.0f;
        this.f8984k = 1.0f;
        this.f8985l = 1.0f;
        this.f8988o = 0;
        this.f8989p = new PointF();
        this.f8990q = new PointF();
        this.f8979f = matrix;
    }

    private static void m9907a(PointF pointF, MotionEvent motionEvent) {
        pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
    }

    private void m9908c(MotionEvent motionEvent) {
        this.f8980g.set(this.f8979f);
        this.f8981h.set(motionEvent.getX(), motionEvent.getY());
        this.f8986m = ((C2545a) this.e).m9674b(motionEvent.getX(), motionEvent.getY());
    }

    private void m9909d(MotionEvent motionEvent) {
        float x;
        float y;
        this.a = C2590a.DRAG;
        this.f8979f.set(this.f8980g);
        C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
        if (!((C2545a) this.e).m9690s() || this.f8986m == null || !((C2545a) this.e).m9673b(this.f8986m.m9791l()).m9642w()) {
            x = motionEvent.getX() - this.f8981h.x;
            y = motionEvent.getY() - this.f8981h.y;
        } else if (this.e instanceof C2550c) {
            x = -(motionEvent.getX() - this.f8981h.x);
            y = motionEvent.getY() - this.f8981h.y;
        } else {
            x = motionEvent.getX() - this.f8981h.x;
            y = -(motionEvent.getY() - this.f8981h.y);
        }
        this.f8979f.postTranslate(x, y);
        if (onChartGestureListener != null) {
            onChartGestureListener.m9923b(motionEvent, x, y);
        }
    }

    private void m9910e(MotionEvent motionEvent) {
        Object obj = 1;
        if (motionEvent.getPointerCount() >= 2) {
            C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
            float g = C2589a.m9912g(motionEvent);
            if (g > 10.0f) {
                PointF a = m9915a(this.f8982i.x, this.f8982i.y);
                float f;
                if (this.b == 4) {
                    this.a = C2590a.PINCH_ZOOM;
                    f = g / this.f8985l;
                    if (f >= 1.0f) {
                        obj = null;
                    }
                    boolean v = obj != null ? ((C2545a) this.e).getViewPortHandler().m10113v() : ((C2545a) this.e).getViewPortHandler().m10114w();
                    float f2 = ((C2545a) this.e).m9684m() ? f : 1.0f;
                    if (!((C2545a) this.e).m9685n()) {
                        f = 1.0f;
                    }
                    if (((C2545a) this.e).m9685n() || v) {
                        this.f8979f.set(this.f8980g);
                        this.f8979f.postScale(f2, f, a.x, a.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.m9919a(motionEvent, f2, f);
                        }
                    }
                } else if (this.b == 2 && ((C2545a) this.e).m9684m()) {
                    this.a = C2590a.X_ZOOM;
                    f = C2589a.m9913h(motionEvent) / this.f8983j;
                    if (((f > 1.0f ? 1 : (f == 1.0f ? 0 : -1)) < 0 ? 1 : null) != null ? ((C2545a) this.e).getViewPortHandler().m10113v() : ((C2545a) this.e).getViewPortHandler().m10114w()) {
                        this.f8979f.set(this.f8980g);
                        this.f8979f.postScale(f, 1.0f, a.x, a.y);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.m9919a(motionEvent, f, 1.0f);
                        }
                    }
                } else if (this.b == 3 && ((C2545a) this.e).m9685n()) {
                    this.a = C2590a.Y_ZOOM;
                    g = C2589a.m9914i(motionEvent) / this.f8984k;
                    this.f8979f.set(this.f8980g);
                    this.f8979f.postScale(1.0f, g, a.x, a.y);
                    if (onChartGestureListener != null) {
                        onChartGestureListener.m9919a(motionEvent, 1.0f, g);
                    }
                }
            }
        }
    }

    private void m9911f(MotionEvent motionEvent) {
        C2581c a = ((C2545a) this.e).m9667a(motionEvent.getX(), motionEvent.getY());
        if (a != null && !a.m9884a(this.c)) {
            this.c = a;
            ((C2545a) this.e).m9649a(a);
        }
    }

    private static float m9912g(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private static float m9913h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float m9914i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public PointF m9915a(float f, float f2) {
        C2621g viewPortHandler = ((C2545a) this.e).getViewPortHandler();
        float a = f - viewPortHandler.m10076a();
        float f3 = (((C2545a) this.e).m9690s() && this.f8986m != null && ((C2545a) this.e).m9676c(this.f8986m.m9791l())) ? -(f2 - viewPortHandler.m10086c()) : -((((float) ((C2545a) this.e).getMeasuredHeight()) - f2) - viewPortHandler.m10088d());
        return new PointF(a, f3);
    }

    public void m9916a() {
        this.f8990q = new PointF(0.0f, 0.0f);
    }

    public void m9917b() {
        if (this.f8990q.x != 0.0f || this.f8990q.y != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            PointF pointF = this.f8990q;
            pointF.x = ((C2545a) this.e).getDragDecelerationFrictionCoef() * pointF.x;
            pointF = this.f8990q;
            pointF.y = ((C2545a) this.e).getDragDecelerationFrictionCoef() * pointF.y;
            float f = ((float) (currentAnimationTimeMillis - this.f8988o)) / 1000.0f;
            float f2 = this.f8990q.x * f;
            f *= this.f8990q.y;
            PointF pointF2 = this.f8989p;
            pointF2.x = f2 + pointF2.x;
            pointF = this.f8989p;
            pointF.y = f + pointF.y;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, this.f8989p.x, this.f8989p.y, 0);
            m9909d(obtain);
            obtain.recycle();
            this.f8979f = ((C2545a) this.e).getViewPortHandler().m10077a(this.f8979f, this.e, false);
            this.f8988o = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f8990q.x)) >= 0.01d || ((double) Math.abs(this.f8990q.y)) >= 0.01d) {
                C2620f.m10063a(this.e);
                return;
            }
            ((C2545a) this.e).m9680i();
            ((C2545a) this.e).postInvalidate();
            m9916a();
        }
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f = 1.4f;
        this.a = C2590a.DOUBLE_TAP;
        C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9922b(motionEvent);
        }
        if (((C2545a) this.e).m9686o()) {
            PointF a = m9915a(motionEvent.getX(), motionEvent.getY());
            C2545a c2545a = (C2545a) this.e;
            float f2 = ((C2545a) this.e).m9684m() ? 1.4f : 1.0f;
            if (!((C2545a) this.e).m9685n()) {
                f = 1.0f;
            }
            c2545a.m9670a(f2, f, a.x, a.y);
            if (((C2545a) this.e).m9662w()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a.x + ", y: " + a.y);
            }
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.a = C2590a.FLING;
        C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9920a(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.a = C2590a.LONG_PRESS;
        C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9918a(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.a = C2590a.SINGLE_TAP;
        C2591c onChartGestureListener = ((C2545a) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.m9925c(motionEvent);
        }
        if (!((C2545a) this.e).m9659t()) {
            return false;
        }
        m9905a(((C2545a) this.e).m9667a(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f8987n == null) {
            this.f8987n = VelocityTracker.obtain();
        }
        this.f8987n.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && this.f8987n != null) {
            this.f8987n.recycle();
            this.f8987n = null;
        }
        if (this.b == 0) {
            this.d.onTouchEvent(motionEvent);
        }
        if (((C2545a) this.e).m9683l() || ((C2545a) this.e).m9684m() || ((C2545a) this.e).m9685n()) {
            switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    m9903a(motionEvent);
                    m9916a();
                    m9908c(motionEvent);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    VelocityTracker velocityTracker = this.f8987n;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(AdError.NETWORK_ERROR_CODE, (float) C2620f.m10069b());
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if ((Math.abs(xVelocity) > ((float) C2620f.m10055a()) || Math.abs(yVelocity) > ((float) C2620f.m10055a())) && this.b == 1 && ((C2545a) this.e).m9661v()) {
                        m9916a();
                        this.f8988o = AnimationUtils.currentAnimationTimeMillis();
                        this.f8989p = new PointF(motionEvent.getX(), motionEvent.getY());
                        this.f8990q = new PointF(xVelocity, yVelocity);
                        C2620f.m10063a(this.e);
                    }
                    if (this.b == 2 || this.b == 3 || this.b == 4 || this.b == 5) {
                        ((C2545a) this.e).m9680i();
                        ((C2545a) this.e).postInvalidate();
                    }
                    this.b = 0;
                    ((C2545a) this.e).m9664y();
                    if (this.f8987n != null) {
                        this.f8987n.recycle();
                        this.f8987n = null;
                    }
                    m9906b(motionEvent);
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    if (this.b != 1) {
                        if (this.b != 2 && this.b != 3 && this.b != 4) {
                            if (this.b == 0 && Math.abs(C2588b.m9902a(motionEvent.getX(), this.f8981h.x, motionEvent.getY(), this.f8981h.y)) > 5.0f) {
                                if (!((C2545a) this.e).m9689r()) {
                                    if (((C2545a) this.e).m9683l()) {
                                        this.a = C2590a.DRAG;
                                        this.b = 1;
                                        break;
                                    }
                                } else if (!((C2545a) this.e).m9687p() && ((C2545a) this.e).m9683l()) {
                                    this.b = 1;
                                    break;
                                } else {
                                    this.a = C2590a.DRAG;
                                    if (((C2545a) this.e).m9682k()) {
                                        m9911f(motionEvent);
                                        break;
                                    }
                                }
                            }
                        }
                        ((C2545a) this.e).m9663x();
                        if (((C2545a) this.e).m9684m() || ((C2545a) this.e).m9685n()) {
                            m9910e(motionEvent);
                            break;
                        }
                    }
                    ((C2545a) this.e).m9663x();
                    m9909d(motionEvent);
                    break;
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    this.b = 0;
                    m9906b(motionEvent);
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    if (motionEvent.getPointerCount() >= 2) {
                        ((C2545a) this.e).m9663x();
                        m9908c(motionEvent);
                        this.f8983j = C2589a.m9913h(motionEvent);
                        this.f8984k = C2589a.m9914i(motionEvent);
                        this.f8985l = C2589a.m9912g(motionEvent);
                        if (this.f8985l > 10.0f) {
                            if (((C2545a) this.e).m9688q()) {
                                this.b = 4;
                            } else if (this.f8983j > this.f8984k) {
                                this.b = 2;
                            } else {
                                this.b = 3;
                            }
                        }
                        C2589a.m9907a(this.f8982i, motionEvent);
                        break;
                    }
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ARUP /*6*/:
                    C2620f.m10062a(motionEvent, this.f8987n);
                    this.b = 5;
                    break;
            }
            this.f8979f = ((C2545a) this.e).getViewPortHandler().m10077a(this.f8979f, this.e, true);
        }
        return true;
    }
}
