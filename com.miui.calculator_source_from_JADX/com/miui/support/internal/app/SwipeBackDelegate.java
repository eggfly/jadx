package com.miui.support.internal.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.ViewUtils;
import com.miui.support.view.animation.CubicEaseOutInterpolator;

public class SwipeBackDelegate {
    private final int f2266a;
    private final int f2267b;
    private final int f2268c;
    private final int f2269d;
    private final int f2270e;
    private final int f2271f;
    private final int f2272g;
    private final int f2273h;
    private final float f2274i;
    private float f2275j;
    private Activity f2276k;
    private View f2277l;
    private SwipeBackDragHelper f2278m;
    private SwipeBackListener f2279n;
    private int f2280o;
    private int f2281p;
    private float f2282q;
    private Drawable f2283r;
    private Drawable f2284s;
    private ColorDrawable f2285t;
    private LayerDrawable f2286u;
    private float f2287v;

    private class SwipeBackDragHelper {
        final /* synthetic */ SwipeBackDelegate f2248a;
        private final int f2249b;
        private final int f2250c;
        private final int f2251d;
        private View f2252e;
        private int f2253f;
        private int f2254g;
        private int f2255h;
        private int f2256i;
        private float f2257j;
        private float f2258k;
        private float f2259l;
        private boolean f2260m;
        private boolean f2261n;
        private VelocityTracker f2262o;
        private float f2263p;
        private float f2264q;
        private Scroller f2265r;

        public SwipeBackDragHelper(SwipeBackDelegate swipeBackDelegate, Context context, View view) {
            this.f2248a = swipeBackDelegate;
            this.f2249b = 45;
            this.f2250c = 45;
            this.f2251d = 300;
            this.f2256i = -1;
            this.f2252e = view;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            float f = context.getResources().getDisplayMetrics().density;
            this.f2253f = (int) ((45.0f * f) + 0.5f);
            this.f2254g = (int) ((f * 45.0f) + 0.5f);
            this.f2255h = viewConfiguration.getScaledTouchSlop();
            this.f2263p = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2265r = new Scroller(context, new CubicEaseOutInterpolator());
        }

        public boolean m3840a(MotionEvent motionEvent) {
            motionEvent.offsetLocation(this.f2264q, 0.0f);
            if (!this.f2265r.isFinished()) {
                return true;
            }
            if (this.f2262o == null) {
                this.f2262o = VelocityTracker.obtain();
            }
            this.f2262o.addMovement(motionEvent);
            switch (motionEvent.getActionMasked()) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    m3835d();
                    this.f2257j = motionEvent.getRawX();
                    this.f2258k = motionEvent.getRawY();
                    if (m3833b(this.f2257j)) {
                        this.f2256i = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.f2248a.f2279n.m3844a();
                        if (this.f2248a.f2280o != 2) {
                            this.f2259l = ((float) this.f2252e.getWidth()) - this.f2257j;
                            break;
                        }
                        this.f2259l = this.f2257j;
                        break;
                    }
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    m3835d();
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (!(this.f2262o == null || this.f2261n)) {
                        if (motionEvent.findPointerIndex(this.f2256i) != -1) {
                            if (!m3833b(this.f2257j)) {
                                this.f2261n = true;
                                break;
                            }
                            m3838f(motionEvent);
                            break;
                        }
                        this.f2261n = true;
                        break;
                    }
            }
            if (this.f2261n || !this.f2260m) {
                return false;
            }
            return true;
        }

        public void m3841b(MotionEvent motionEvent) {
            motionEvent.offsetLocation(this.f2264q, 0.0f);
            if (m3833b(this.f2257j) && this.f2265r.isFinished()) {
                if (this.f2262o == null) {
                    this.f2262o = VelocityTracker.obtain();
                }
                this.f2262o.addMovement(motionEvent);
                switch (motionEvent.getActionMasked()) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                        m3834c(motionEvent);
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        m3838f(motionEvent);
                        if (!this.f2260m || !m3836d(motionEvent)) {
                            return;
                        }
                        if (this.f2248a.f2280o == 2) {
                            m3832a((float) m3837e(motionEvent));
                        } else if (this.f2248a.f2280o == 4) {
                            m3832a((float) (m3837e(motionEvent) - this.f2252e.getWidth()));
                        }
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        this.f2248a.f2279n.m3845b();
                        m3835d();
                    default:
                }
            }
        }

        private void m3834c(MotionEvent motionEvent) {
            if (m3836d(motionEvent)) {
                if (this.f2248a.f2287v >= this.f2248a.f2275j) {
                    this.f2265r.abortAnimation();
                    if (this.f2248a.f2280o == 2) {
                        this.f2265r.startScroll(m3837e(motionEvent), 0, (this.f2252e.getWidth() + this.f2254g) - m3837e(motionEvent), 0, 300);
                    } else {
                        this.f2265r.startScroll((m3837e(motionEvent) - this.f2252e.getWidth()) - this.f2254g, 0, -m3837e(motionEvent), 0, 300);
                    }
                } else {
                    this.f2265r.abortAnimation();
                    this.f2262o.computeCurrentVelocity(1000, this.f2263p);
                    this.f2265r.fling((int) motionEvent.getRawX(), 0, (int) this.f2262o.getXVelocity(), 0, 0, this.f2252e.getWidth(), 0, 0);
                    float finalX = (float) this.f2265r.getFinalX();
                    this.f2265r.abortAnimation();
                    if (this.f2248a.f2280o == 2) {
                        if (finalX / ((float) this.f2252e.getWidth()) >= this.f2248a.f2275j) {
                            this.f2265r.startScroll(m3837e(motionEvent), 0, (this.f2252e.getWidth() + this.f2254g) - m3837e(motionEvent), 0, 300);
                        } else {
                            this.f2265r.startScroll(m3837e(motionEvent), 0, -m3837e(motionEvent), 0);
                        }
                    } else if (1.0f - (finalX / ((float) this.f2252e.getWidth())) >= this.f2248a.f2275j) {
                        this.f2265r.startScroll((m3837e(motionEvent) - this.f2252e.getWidth()) - this.f2254g, 0, -m3837e(motionEvent), 0, 300);
                    } else {
                        this.f2265r.startScroll(m3837e(motionEvent) - this.f2252e.getWidth(), 0, this.f2252e.getWidth() - m3837e(motionEvent), 0);
                    }
                }
                this.f2252e.invalidate();
            }
        }

        private boolean m3836d(MotionEvent motionEvent) {
            return motionEvent.getPointerId(motionEvent.getActionIndex()) == this.f2256i;
        }

        private int m3837e(MotionEvent motionEvent) {
            int rawX;
            if (this.f2248a.f2280o == 2) {
                rawX = (int) (motionEvent.getRawX() - this.f2259l);
                if (rawX < 0) {
                    return 0;
                }
                return rawX;
            } else if (this.f2248a.f2280o != 4) {
                return (int) motionEvent.getRawX();
            } else {
                rawX = (int) (motionEvent.getRawX() + this.f2259l);
                if (rawX > this.f2252e.getWidth()) {
                    return this.f2252e.getWidth();
                }
                return rawX;
            }
        }

        private void m3835d() {
            if (this.f2262o != null) {
                this.f2262o.recycle();
            }
            this.f2262o = null;
            this.f2265r.abortAnimation();
            this.f2264q = 0.0f;
            this.f2256i = -1;
            this.f2257j = 0.0f;
            this.f2258k = 0.0f;
            this.f2259l = 0.0f;
            this.f2260m = false;
            this.f2261n = false;
        }

        private void m3838f(MotionEvent motionEvent) {
            boolean z = false;
            if (!this.f2260m) {
                float abs = Math.abs(motionEvent.getRawX() - this.f2257j);
                float abs2 = Math.abs(motionEvent.getRawY() - this.f2258k);
                if ((abs * abs) + (abs2 * abs2) > ((float) (this.f2255h * this.f2255h))) {
                    if (abs > ((float) (this.f2255h * 2)) && Math.abs(abs2) < Math.abs(abs)) {
                        z = true;
                    }
                    this.f2260m = z;
                    return;
                }
                this.f2260m = false;
            }
        }

        public void m3839a() {
            if (this.f2265r.getCurrX() == 0) {
                m3835d();
                this.f2248a.f2279n.m3845b();
            }
            m3832a((float) this.f2265r.getCurrX());
        }

        private void m3832a(float f) {
            this.f2264q = f;
            this.f2252e.setTranslationX(this.f2264q);
            this.f2252e.invalidate();
            this.f2248a.m3852c();
            this.f2248a.f2287v = Math.abs(this.f2252e.getX()) / ((float) this.f2252e.getWidth());
            if (this.f2248a.f2287v >= 1.0f && !this.f2248a.f2276k.isFinishing()) {
                m3835d();
                this.f2248a.f2276k.finish();
                this.f2248a.f2276k.overridePendingTransition(0, 0);
            }
        }

        private boolean m3833b(float f) {
            if (this.f2248a.f2280o == 2) {
                if (f <= ((float) this.f2253f)) {
                    return true;
                }
                return false;
            } else if (this.f2248a.f2280o != 4) {
                return false;
            } else {
                if (f < ((float) (this.f2252e.getWidth() - this.f2253f))) {
                    return false;
                }
                return true;
            }
        }

        public boolean m3842b() {
            return this.f2265r.computeScrollOffset();
        }

        public float m3843c() {
            return this.f2264q;
        }
    }

    public interface SwipeBackListener {
        void m3844a();

        void m3845b();
    }

    public SwipeBackDelegate(Activity activity, View view) {
        this.f2266a = -16777216;
        this.f2267b = 0;
        this.f2268c = 1;
        this.f2269d = 25;
        this.f2270e = 2;
        this.f2271f = 4;
        this.f2272g = 8;
        this.f2273h = 16;
        this.f2274i = 0.5f;
        this.f2275j = 0.5f;
        this.f2282q = 1.0f;
        this.f2277l = view;
        this.f2276k = activity;
        this.f2278m = new SwipeBackDragHelper(this, activity, this.f2277l);
        m3848a(8);
        this.f2285t = new ColorDrawable(-16777216);
        this.f2283r = this.f2276k.getResources().getDrawable(C0264R.drawable.swipe_back_shadow_left);
        this.f2284s = this.f2276k.getResources().getDrawable(C0264R.drawable.swipe_back_shadow_right);
        this.f2281p = this.f2283r.getIntrinsicWidth();
        m3850b();
    }

    private void m3848a(int i) {
        this.f2280o = i;
        switch (i) {
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                if (ViewUtils.m5451a()) {
                    this.f2280o = 4;
                } else {
                    this.f2280o = 2;
                }
            case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                if (ViewUtils.m5451a()) {
                    this.f2280o = 2;
                } else {
                    this.f2280o = 4;
                }
            default:
        }
    }

    public void m3857a(SwipeBackListener swipeBackListener) {
        this.f2279n = swipeBackListener;
    }

    private void m3850b() {
        if (this.f2280o == 2) {
            this.f2286u = new LayerDrawable(new Drawable[]{this.f2285t, this.f2283r});
        } else if (this.f2280o == 4) {
            this.f2286u = new LayerDrawable(new Drawable[]{this.f2285t, this.f2284s});
        }
    }

    public boolean m3858a(MotionEvent motionEvent) {
        return this.f2278m.m3840a(motionEvent);
    }

    public void m3859b(MotionEvent motionEvent) {
        this.f2278m.m3841b(motionEvent);
    }

    public void m3856a() {
        this.f2282q = 1.0f - this.f2287v;
        if (this.f2278m.m3842b()) {
            this.f2278m.m3839a();
        }
    }

    private void m3852c() {
        if (this.f2282q > 0.0f) {
            int c = (int) this.f2278m.m3843c();
            if (this.f2280o == 2) {
                this.f2286u.getDrawable(1).setBounds(c - this.f2281p, 0, c, this.f2277l.getHeight());
            } else if (this.f2280o == 4) {
                this.f2286u.getDrawable(1).setBounds(this.f2277l.getWidth() + c, 0, (c + this.f2277l.getWidth()) + this.f2281p, this.f2277l.getHeight());
            }
            this.f2286u.getDrawable(0).setAlpha((int) (25.0f * this.f2282q));
            this.f2276k.getWindow().getDecorView().setBackground(this.f2286u);
        }
    }
}
