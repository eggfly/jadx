package com.miui.support.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.util.AppConstants;

public class Rotation3DLayout extends FrameLayout {
    private static final float f4327a;
    private static final float[] f4328d;
    private float f4329b;
    private float f4330c;
    private int f4331e;
    private float[] f4332f;
    private float[] f4333g;
    private float[] f4334h;
    private long f4335i;
    private boolean f4336j;
    private boolean f4337k;
    private boolean f4338l;
    private boolean f4339m;
    private float f4340n;
    private float f4341o;
    private AnimatorSet f4342p;
    private Sensor f4343q;
    private SensorManager f4344r;
    private SensorEventListener f4345s;

    /* renamed from: com.miui.support.widget.Rotation3DLayout.1 */
    class C05011 implements AnimatorListener {
        final /* synthetic */ Rotation3DLayout f4322a;

        C05011(Rotation3DLayout rotation3DLayout) {
            this.f4322a = rotation3DLayout;
        }

        public void onAnimationStart(Animator animator) {
            this.f4322a.f4338l = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4322a.f4338l = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f4322a.f4338l = false;
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.miui.support.widget.Rotation3DLayout.2 */
    class C05022 implements AnimatorUpdateListener {
        final /* synthetic */ Rotation3DLayout f4323a;

        C05022(Rotation3DLayout rotation3DLayout) {
            this.f4323a = rotation3DLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4323a.m6012a(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* renamed from: com.miui.support.widget.Rotation3DLayout.3 */
    class C05033 implements AnimatorUpdateListener {
        final /* synthetic */ Rotation3DLayout f4324a;

        C05033(Rotation3DLayout rotation3DLayout) {
            this.f4324a = rotation3DLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4324a.m6017b(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* renamed from: com.miui.support.widget.Rotation3DLayout.4 */
    class C05044 implements SensorEventListener {
        final /* synthetic */ Rotation3DLayout f4325a;

        C05044(Rotation3DLayout rotation3DLayout) {
            this.f4325a = rotation3DLayout;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float f = sensorEvent.values[1];
            float f2 = sensorEvent.values[2];
            if (Math.abs(f) < 45.0f) {
                this.f4325a.f4340n = (f * this.f4325a.f4329b) / 45.0f;
                this.f4325a.setRotationX(this.f4325a.f4340n);
            }
            if (Math.abs(f2) < 45.0f) {
                this.f4325a.f4341o = (f2 * (-this.f4325a.f4329b)) / 45.0f;
                this.f4325a.setRotationY(this.f4325a.f4341o);
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public int f4326a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4326a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.Rotation3DLayout_Layout);
            this.f4326a = obtainStyledAttributes.getInt(C0264R.styleable.Rotation3DLayout_Layout_layout_zdistance, this.f4326a);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f4326a = 0;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4326a = 0;
        }
    }

    static {
        f4327a = m6008a(10.0f);
        f4328d = new float[]{1.0f, -0.5f, 0.25f, 0.0f};
    }

    public Rotation3DLayout(Context context) {
        this(context, null);
    }

    public Rotation3DLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Rotation3DLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4329b = 10.0f;
        this.f4330c = f4327a;
        this.f4331e = 300;
        this.f4332f = f4328d;
        this.f4333g = new float[f4328d.length];
        this.f4334h = new float[f4328d.length];
        this.f4335i = 0;
        this.f4336j = true;
        this.f4337k = false;
        this.f4338l = false;
        this.f4339m = false;
        this.f4345s = new C05044(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.Rotation3DLayout, i, 0);
        setMaxRotationDegree(obtainStyledAttributes.getFloat(C0264R.styleable.Rotation3DLayout_maxRotationDegree, this.f4329b));
        this.f4339m = obtainStyledAttributes.getBoolean(C0264R.styleable.Rotation3DLayout_autoGravityRotation, this.f4339m);
        obtainStyledAttributes.recycle();
    }

    public void m6020a() {
        if (this.f4344r == null) {
            this.f4344r = (SensorManager) getContext().getSystemService("sensor");
        }
        if (this.f4343q == null) {
            this.f4343q = this.f4344r.getDefaultSensor(3);
            this.f4344r.registerListener(this.f4345s, this.f4343q, 1);
        }
    }

    public void m6021b() {
        if (this.f4344r != null && this.f4343q != null) {
            this.f4344r.unregisterListener(this.f4345s, this.f4343q);
            this.f4343q = null;
            this.f4344r = null;
            m6022c();
        }
    }

    protected void m6022c() {
        if (this.f4342p == null) {
            this.f4342p = new AnimatorSet();
            this.f4342p.addListener(new C05011(this));
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setInterpolator(new DecelerateInterpolator(0.75f));
            valueAnimator.addUpdateListener(new C05022(this));
            valueAnimator.setDuration((long) this.f4331e);
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setInterpolator(new DecelerateInterpolator(0.75f));
            valueAnimator2.addUpdateListener(new C05033(this));
            valueAnimator2.setDuration((long) this.f4331e);
            this.f4342p.playTogether(new Animator[]{valueAnimator, valueAnimator2});
        }
        this.f4342p.cancel();
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        for (int i = 0; i < this.f4332f.length; i++) {
            this.f4333g[i] = this.f4340n + (this.f4332f[i] * rotationX);
            this.f4334h[i] = this.f4341o + (this.f4332f[i] * rotationY);
        }
        ((ValueAnimator) this.f4342p.getChildAnimations().get(0)).setFloatValues(this.f4333g);
        ((ValueAnimator) this.f4342p.getChildAnimations().get(1)).setFloatValues(this.f4334h);
        this.f4342p.start();
    }

    public void setResetAnimDuration(int i) {
        this.f4331e = i;
    }

    public void setResetBouncePatterns(float[] fArr) {
        if (fArr != null && fArr.length > 1) {
            this.f4332f = fArr;
            this.f4333g = new float[fArr.length];
            this.f4334h = new float[fArr.length];
        }
    }

    public void setMaxRotationDegree(float f) {
        this.f4329b = f;
        this.f4330c = m6008a(f);
    }

    public float getMaxRotationDegree() {
        return this.f4329b;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4336j) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4336j) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m6022c();
                this.f4337k = false;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (SystemClock.elapsedRealtime() - this.f4335i > ((long) ViewConfiguration.getTapTimeout())) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        if (motionEvent.getAction() == 0) {
            this.f4335i = SystemClock.elapsedRealtime();
        }
        float min = Math.min(Math.max(0.0f, motionEvent.getX()), (float) getWidth());
        float min2 = Math.min(Math.max(0.0f, motionEvent.getY()), (float) getHeight());
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (this.f4342p != null) {
            this.f4342p.cancel();
        }
        m6012a((((float) height) - min2) * this.f4330c, true);
        m6017b((min - ((float) width)) * this.f4330c, true);
        this.f4337k = true;
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setRotationX(float f) {
        m6012a(f, false);
    }

    public void setRotationY(float f) {
        m6017b(f, false);
    }

    private void m6012a(float f, boolean z) {
        float f2 = Math.abs(f) > this.f4329b ? f > 0.0f ? this.f4329b : -this.f4329b : f;
        if (f2 != getRotationX()) {
            if (z || !(this.f4337k || this.f4338l)) {
                super.setRotationX(f2);
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
        }
    }

    private void m6017b(float f, boolean z) {
        float f2 = Math.abs(f) > this.f4329b ? f > 0.0f ? this.f4329b : -this.f4329b : f;
        if (f2 != getRotationY()) {
            if (z || !(this.f4337k || this.f4338l)) {
                super.setRotationY(f2);
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            m6021b();
        } else if (this.f4339m) {
            m6020a();
        }
    }

    protected void finalize() {
        super.finalize();
        m6021b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                int i6;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.gravity;
                if (i7 == -1) {
                    i7 = 8388659;
                }
                int i8 = i7 & 112;
                switch (Gravity.getAbsoluteGravity(i7, 0) & 7) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        i6 = (((((paddingRight - paddingLeft) - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                        i6 = layoutParams.leftMargin + paddingLeft;
                        break;
                    case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                        i6 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i6 = layoutParams.leftMargin + paddingLeft;
                        break;
                }
                switch (i8) {
                    case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                        i7 = (((((paddingBottom - paddingTop) - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i7 = layoutParams.topMargin + paddingTop;
                        break;
                    case 80:
                        i7 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        break;
                    default:
                        i7 = layoutParams.topMargin + paddingTop;
                        break;
                }
                i6 += m6011a(layoutParams.f4326a, getRotationY());
                int a = i7 - m6011a(layoutParams.f4326a, getRotationX());
                if (z || i6 != childAt.getLeft() || a != childAt.getTop()) {
                    childAt.layout(i6, a, i6 + measuredWidth, a + measuredHeight);
                }
            }
        }
    }

    private int m6011a(int i, float f) {
        return (int) (Math.sin(Math.toRadians((double) f)) * ((double) i));
    }

    private static float m6008a(float f) {
        return f / (((float) AppConstants.m4227a().getResources().getDisplayMetrics().widthPixels) / 2.0f);
    }

    protected android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
