package com.miui.support.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.widget.ViewDragHelper;
import com.miui.support.internal.widget.ViewDragHelper.Callback;
import com.miui.support.util.ViewUtils;

public class NavigationLayout extends ViewGroup {
    private boolean f4209A;
    private final ViewDragHelper f4210a;
    private int f4211b;
    private boolean f4212c;
    private int f4213d;
    private View f4214e;
    private View f4215f;
    private Rect f4216g;
    private WidthDescription f4217h;
    private WidthDescription f4218i;
    private Drawable f4219j;
    private int f4220k;
    private Drawable f4221l;
    private float f4222m;
    private float f4223n;
    private boolean f4224o;
    private int f4225p;
    private Paint f4226q;
    private NavigationListener f4227r;
    private boolean f4228s;
    private int f4229t;
    private Runnable f4230u;
    private float f4231v;
    private float f4232w;
    private ValueAnimator f4233x;
    private AnimatorUpdateListener f4234y;
    private View f4235z;

    /* renamed from: com.miui.support.widget.NavigationLayout.1 */
    class C04931 implements Runnable {
        final /* synthetic */ NavigationLayout f4201a;

        C04931(NavigationLayout navigationLayout) {
            this.f4201a = navigationLayout;
        }

        public void run() {
            int i = 0;
            View a = this.f4201a.f4214e;
            int a2 = this.f4201a.f4210a.m4972a();
            if (this.f4201a.f4209A) {
                if (a != null) {
                    i = this.f4201a.getWidth();
                }
                a2 = i - a2;
            } else {
                if (a != null) {
                    i = -a.getWidth();
                }
                a2 = i + a2;
            }
            if (a != null && a.getLeft() < a2 && this.f4201a.getDrawerLockMode() == 0) {
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                this.f4201a.f4210a.m4978a(a, a2, a.getTop());
                layoutParams.f4204b = true;
                this.f4201a.invalidate();
                this.f4201a.m5903c();
            }
        }
    }

    /* renamed from: com.miui.support.widget.NavigationLayout.2 */
    class C04942 implements AnimatorUpdateListener {
        final /* synthetic */ NavigationLayout f4202a;

        C04942(NavigationLayout navigationLayout) {
            this.f4202a = navigationLayout;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f4202a.f4235z != null) {
                this.f4202a.f4232w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f4202a.postInvalidateOnAnimation(this.f4202a.f4235z.getLeft(), this.f4202a.f4235z.getTop(), this.f4202a.f4235z.getRight(), this.f4202a.f4235z.getBottom());
            }
        }
    }

    protected static class LayoutParams extends MarginLayoutParams {
        float f4203a;
        boolean f4204b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface NavigationListener {
        void m5878a();

        void m5879a(float f);

        void m5880a(int i);

        void m5881a(boolean z);

        void m5882b();
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        float f4205a;

        /* renamed from: com.miui.support.widget.NavigationLayout.SavedState.1 */
        final class C04951 implements Creator<SavedState> {
            C04951() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5883a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5884a(i);
            }

            public SavedState m5883a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m5884a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C04951();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4205a = parcel.readFloat();
        }

        private SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f4205a);
        }
    }

    private class ViewDragCallback extends Callback {
        final /* synthetic */ NavigationLayout f4206a;

        private ViewDragCallback(NavigationLayout navigationLayout) {
            this.f4206a = navigationLayout;
        }

        public boolean m5893b(View view, int i) {
            return view == this.f4206a.f4214e && this.f4206a.getDrawerLockMode() == 0;
        }

        public int m5885a(View view) {
            return view == this.f4206a.f4214e ? this.f4206a.f4214e.getWidth() : 0;
        }

        public void m5891a(View view, int i, int i2, int i3, int i4) {
            if (view == this.f4206a.f4214e) {
                int width = this.f4206a.f4214e.getWidth();
                this.f4206a.setNavigationOffset(((float) (this.f4206a.f4209A ? this.f4206a.getWidth() - i : i + width)) / ((float) width));
                this.f4206a.invalidate();
            }
        }

        public void m5890a(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f4204b = false;
        }

        public void m5889a(View view, float f, float f2) {
            Object obj = null;
            float f3 = this.f4206a.getNavigationOffset();
            int width = view.getWidth();
            int width2 = this.f4206a.f4209A ? this.f4206a.getWidth() - width : 0;
            width = this.f4206a.f4209A ? this.f4206a.getWidth() : -width;
            if (this.f4206a.f4209A) {
                if (f < 0.0f) {
                    obj = 1;
                }
            } else if (f > 0.0f) {
                int i = 1;
            }
            if (obj != null || (f == 0.0f && f3 > 0.5f)) {
                width = width2;
            }
            this.f4206a.f4210a.m4976a(width, view.getTop());
            this.f4206a.invalidate();
        }

        public int m5886a(View view, int i, int i2) {
            int width = this.f4206a.f4209A ? this.f4206a.getWidth() - view.getWidth() : -view.getWidth();
            return Math.max(width, Math.min(i, view.getWidth() + width));
        }

        public void m5888a(int i, int i2) {
            this.f4206a.postDelayed(this.f4206a.f4230u, 150);
        }

        public void m5892b(int i, int i2) {
            if (this.f4206a.getDrawerLockMode() == 0) {
                this.f4206a.f4210a.m4975a(this.f4206a.f4214e, i2);
                this.f4206a.removeCallbacks(this.f4206a.f4230u);
            }
        }

        public void m5887a(int i) {
            if (this.f4206a.f4227r != null) {
                if (i == 0) {
                    if (this.f4206a.m5915a()) {
                        this.f4206a.f4227r.m5878a();
                    } else {
                        this.f4206a.f4227r.m5882b();
                    }
                }
                this.f4206a.f4227r.m5880a(i);
            }
        }
    }

    private static class WidthDescription {
        public int f4207a;
        public float f4208b;

        private WidthDescription() {
        }

        static WidthDescription m5894a(TypedValue typedValue, Resources resources) {
            WidthDescription widthDescription = new WidthDescription();
            if (typedValue == null) {
                widthDescription.f4207a = 1;
                widthDescription.f4208b = 0.3f;
            } else {
                if (typedValue.type == 6) {
                    widthDescription.f4207a = 1;
                    widthDescription.f4208b = TypedValue.complexToFloat(typedValue.data);
                } else if (typedValue.type == 4) {
                    widthDescription.f4207a = 1;
                    widthDescription.f4208b = typedValue.getFloat();
                } else if (typedValue.type == 5) {
                    widthDescription.f4207a = 0;
                    widthDescription.f4208b = (float) TypedValue.complexToDimensionPixelSize(typedValue.data, resources.getDisplayMetrics());
                }
                return widthDescription;
            }
            widthDescription.f4207a = 1;
            widthDescription.f4208b = 0.3f;
            return widthDescription;
        }
    }

    public NavigationLayout(Context context) {
        this(context, null);
    }

    public NavigationLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0234R.attr.navigationLayoutStyle);
    }

    public NavigationLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4216g = new Rect();
        this.f4225p = -856295433;
        this.f4226q = new Paint();
        this.f4228s = true;
        this.f4229t = 0;
        this.f4230u = new C04931(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.NavigationLayout, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0234R.styleable.NavigationLayout_navigationDivider);
        if (drawable != null) {
            setDivider(drawable);
        }
        drawable = obtainStyledAttributes.getDrawable(C0234R.styleable.NavigationLayout_navigationShadow);
        if (drawable != null) {
            setNavigationShadow(drawable);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0234R.styleable.NavigationLayout_navigationDividerWidth, 0);
        if (dimensionPixelSize != 0) {
            setDividerWidth(dimensionPixelSize);
        }
        this.f4225p = obtainStyledAttributes.getColor(C0234R.styleable.NavigationLayout_navigationScrimColor, -856295433);
        this.f4211b = obtainStyledAttributes.getInt(C0234R.styleable.NavigationLayout_drawerEnabledOrientation, 0);
        this.f4217h = WidthDescription.m5894a(obtainStyledAttributes.peekValue(C0234R.styleable.NavigationLayout_portraitNavigationWidth), getResources());
        this.f4218i = WidthDescription.m5894a(obtainStyledAttributes.peekValue(C0234R.styleable.NavigationLayout_landscapeNavigationWidth), getResources());
        this.f4213d = obtainStyledAttributes.getInt(C0234R.styleable.NavigationLayout_drawerMode, 0);
        obtainStyledAttributes.recycle();
        this.f4210a = ViewDragHelper.m4955a((ViewGroup) this, 0.5f, new ViewDragCallback());
        this.f4210a.m4973a(getResources().getDisplayMetrics().density * 400.0f);
        setFocusableInTouchMode(true);
    }

    public void onRtlPropertiesChanged(int i) {
        int i2 = 1;
        this.f4209A = i == 1;
        ViewDragHelper viewDragHelper = this.f4210a;
        if (this.f4209A) {
            i2 = 2;
        }
        viewDragHelper.m4974a(i2);
    }

    public void setNavigationListener(NavigationListener navigationListener) {
        this.f4227r = navigationListener;
    }

    public int getDrawerEnabledOrientation() {
        return this.f4211b;
    }

    public void setDrawerEnabledOrientation(int i) {
        this.f4211b = i;
        requestLayout();
    }

    public void setNavigationShadow(Drawable drawable) {
        this.f4221l = drawable;
        invalidate();
    }

    public void setNavigationShadow(int i) {
        setNavigationShadow(getResources().getDrawable(i));
    }

    public void setDivider(Drawable drawable) {
        if (drawable != null) {
            this.f4220k = drawable.getIntrinsicHeight();
        } else {
            this.f4220k = 0;
        }
        this.f4219j = drawable;
        requestLayout();
        invalidate();
    }

    public int getDividerWidth() {
        return this.f4220k;
    }

    public void setDividerWidth(int i) {
        this.f4220k = i;
        requestLayout();
        invalidate();
    }

    private void m5898a(View view, boolean z) {
        float f = 1.0f;
        if (view.isEnabled() != z) {
            if (this.f4235z == null || this.f4235z == view || this.f4235z.isEnabled() || z) {
                view.setEnabled(z);
                if (this.f4233x != null) {
                    this.f4233x.cancel();
                    ValueAnimator valueAnimator = this.f4233x;
                    float[] fArr = new float[2];
                    fArr[0] = z ? 1.0f : 0.0f;
                    fArr[1] = z ? 0.0f : 1.0f;
                    valueAnimator.setFloatValues(fArr);
                } else {
                    float[] fArr2 = new float[2];
                    fArr2[0] = z ? 1.0f : 0.0f;
                    fArr2[1] = z ? 0.0f : 1.0f;
                    this.f4233x = ValueAnimator.ofFloat(fArr2);
                }
                this.f4235z = view;
                this.f4233x.setDuration(DeviceHelper.f2553e ? 500 : 0);
                this.f4233x.addUpdateListener(getScrimAnimatorListener());
                if (!z) {
                    f = 0.0f;
                }
                this.f4232w = f;
                this.f4233x.start();
            }
        }
    }

    public void setNavigationEanbled(boolean z) {
        m5898a(this.f4214e, z);
    }

    public void setContentEnabled(boolean z) {
        m5898a(this.f4215f, z);
    }

    public void setDrawerMode(int i) {
        this.f4213d = i;
        requestLayout();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!(this.f4235z == null || this.f4235z.isEnabled())) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int left = this.f4235z.getLeft();
            int right = this.f4235z.getRight();
            int top = this.f4235z.getTop();
            int bottom = this.f4235z.getBottom();
            if (left < x && x < right && top < y && y < bottom) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private AnimatorUpdateListener getScrimAnimatorListener() {
        if (this.f4234y == null) {
            this.f4234y = new C04942(this);
        }
        return this.f4234y;
    }

    private void m5900b() {
        if (this.f4215f == null) {
            this.f4215f = findViewById(C0234R.id.content);
            this.f4214e = findViewById(C0234R.id.navigation);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m5900b();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = false;
        this.f4228s = false;
        m5900b();
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        boolean z2 = getResources().getConfiguration().orientation == 2;
        WidthDescription widthDescription = z2 ? this.f4218i : this.f4217h;
        switch (widthDescription.f4207a) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                i3 = (int) widthDescription.f4208b;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                i3 = (int) (widthDescription.f4208b * ((float) size));
                break;
            default:
                i3 = 0;
                break;
        }
        measureChild(this.f4214e, MeasureSpec.makeMeasureSpec(i3, 1073741824), MeasureSpec.makeMeasureSpec(size2, 1073741824));
        if (this.f4213d == 2) {
            LayoutParams layoutParams = (LayoutParams) this.f4214e.getLayoutParams();
            if (layoutParams.f4203a > 0.5f) {
                size = this.f4214e.getMeasuredWidth();
            } else {
                size = 0;
            }
            this.f4215f.setAlpha(Math.abs(layoutParams.f4203a - 0.5f) / 0.5f);
            size2 = size;
        } else {
            size2 = 0;
        }
        if ((this.f4211b & 2) != 0 && z2) {
            measureChildWithMargins(this.f4215f, i, size2, i2, 0);
            z = true;
        } else if ((this.f4211b & 1) == 0 || z2) {
            measureChildWithMargins(this.f4215f, i, this.f4214e.getMeasuredWidth() + this.f4220k, i2, 0);
        } else {
            measureChildWithMargins(this.f4215f, i, size2, i2, 0);
            z = true;
        }
        if (this.f4212c != z) {
            this.f4212c = z;
            if (this.f4227r != null) {
                this.f4227r.m5881a(z);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (this.f4212c) {
            int measuredWidth = this.f4214e.getMeasuredWidth();
            LayoutParams layoutParams = (LayoutParams) this.f4214e.getLayoutParams();
            i5 = (int) (((float) (-measuredWidth)) + (((float) measuredWidth) * layoutParams.f4203a));
            ViewUtils.m5449a(this, this.f4214e, i5, i2, i5 + measuredWidth, i2 + this.f4214e.getMeasuredHeight());
            int measuredWidth2 = i + this.f4215f.getMeasuredWidth();
            if (this.f4213d == 1) {
                int i6 = (int) (((float) (-measuredWidth)) * layoutParams.f4203a);
                View view = this.f4215f;
                if (this.f4209A) {
                    i6 = 0 - i6;
                }
                view.setScrollX(i6);
                i5 = i;
            } else if (this.f4213d == 0) {
                this.f4215f.setScrollX(0);
                i5 = i;
            } else if (this.f4213d == 2) {
                measuredWidth2 = i3;
                i5 = (int) (((float) i) + (((float) measuredWidth) * layoutParams.f4203a));
            } else {
                i5 = i;
            }
            ViewUtils.m5449a(this, this.f4215f, i5, i2, measuredWidth2, i2 + this.f4215f.getMeasuredHeight());
            return;
        }
        ViewUtils.m5449a(this, this.f4214e, i, i2, i + this.f4214e.getMeasuredWidth(), i2 + this.f4214e.getMeasuredHeight());
        i5 = (this.f4214e.getMeasuredWidth() + i) + this.f4220k;
        ViewUtils.m5449a(this, this.f4215f, i5, i2, i5 + this.f4215f.getMeasuredWidth(), i2 + this.f4215f.getMeasuredHeight());
        this.f4215f.setScrollX(0);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f4212c) {
            m5897a(canvas);
            m5904c(canvas);
            return;
        }
        m5906d(canvas);
        m5901b(canvas);
    }

    public void setScrimColor(int i) {
        this.f4225p = i;
    }

    private void m5897a(Canvas canvas) {
        if (this.f4231v > 0.0f) {
            this.f4226q.setColor((((int) (((float) ((this.f4225p & -16777216) >>> 24)) * this.f4231v)) << 24) | (this.f4225p & 16777215));
            canvas.drawRect((float) (this.f4209A ? 0 : this.f4214e.getRight()), 0.0f, (float) (this.f4209A ? this.f4214e.getLeft() : getWidth()), (float) getHeight(), this.f4226q);
        }
    }

    private void m5901b(Canvas canvas) {
        if (this.f4232w > 0.0f && this.f4235z != null) {
            this.f4226q.setColor((((int) (((float) ((this.f4225p & -16777216) >>> 24)) * this.f4232w)) << 24) | (this.f4225p & 16777215));
            canvas.drawRect((float) this.f4235z.getLeft(), (float) this.f4235z.getTop(), (float) this.f4235z.getRight(), (float) this.f4235z.getBottom(), this.f4226q);
        }
    }

    private void m5904c(Canvas canvas) {
        if (this.f4221l != null) {
            int intrinsicWidth = this.f4221l.getIntrinsicWidth();
            int left = this.f4209A ? this.f4214e.getLeft() - intrinsicWidth : this.f4214e.getRight();
            this.f4221l.setBounds(left, this.f4214e.getTop(), intrinsicWidth + left, this.f4214e.getBottom());
            this.f4221l.draw(canvas);
        }
    }

    private void m5906d(Canvas canvas) {
        Rect rect = this.f4216g;
        int measuredWidth = this.f4214e.getMeasuredWidth();
        if (this.f4209A) {
            measuredWidth = (getWidth() - measuredWidth) - this.f4220k;
        }
        rect.set(measuredWidth, getPaddingTop(), this.f4220k + measuredWidth, getBottom() - getPaddingBottom());
        Drawable drawable = this.f4219j;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = r7.f4210a;
        r3 = r0.m4977a(r8);
        r0 = r7.f4212c;
        if (r0 == 0) goto L_0x0010;
    L_0x000c:
        r0 = r7.f4229t;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0014:
        return r2;
    L_0x0015:
        r0 = r8.getActionMasked();
        switch(r0) {
            case 0: goto L_0x002d;
            case 1: goto L_0x0062;
            case 2: goto L_0x0052;
            case 3: goto L_0x0062;
            default: goto L_0x001c;
        };
    L_0x001c:
        r0 = r2;
    L_0x001d:
        if (r3 != 0) goto L_0x002b;
    L_0x001f:
        if (r0 != 0) goto L_0x002b;
    L_0x0021:
        r0 = r7.m5908d();
        if (r0 != 0) goto L_0x002b;
    L_0x0027:
        r0 = r7.f4224o;
        if (r0 == 0) goto L_0x0014;
    L_0x002b:
        r2 = r1;
        goto L_0x0014;
    L_0x002d:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.f4222m = r0;
        r7.f4223n = r4;
        r5 = r7.getNavigationOffset();
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x0042:
        r5 = r7.f4210a;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.m4991e(r0, r4);
        r4 = r7.f4215f;
        if (r0 != r4) goto L_0x006d;
    L_0x004e:
        r0 = r1;
    L_0x004f:
        r7.f4224o = r2;
        goto L_0x001d;
    L_0x0052:
        r0 = r7.f4210a;
        r4 = 3;
        r0 = r0.m4989d(r4);
        if (r0 == 0) goto L_0x001c;
    L_0x005b:
        r0 = r7.f4230u;
        r7.removeCallbacks(r0);
        r0 = r2;
        goto L_0x001d;
    L_0x0062:
        r0 = r7.f4230u;
        r7.removeCallbacks(r0);
        r7.m5910e();
        r7.f4224o = r2;
        goto L_0x001c;
    L_0x006d:
        r0 = r2;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.widget.NavigationLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        this.f4210a.m4981b(motionEvent);
        if (!this.f4212c || this.f4229t != 0) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (actionMasked) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f4222m = x;
                this.f4223n = y;
                this.f4224o = false;
                return true;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                float f = x - this.f4222m;
                float f2 = y - this.f4223n;
                int b = this.f4210a.m4980b();
                View e = this.f4210a.m4991e((int) x, (int) y);
                if (e == null || e != this.f4215f || (f * f) + (f2 * f2) >= ((float) (b * b)) || !m5915a()) {
                    z = true;
                }
                removeCallbacks(this.f4230u);
                if (z) {
                    m5910e();
                    return true;
                } else if (this.f4229t != 0) {
                    return true;
                } else {
                    m5916b(true);
                    return true;
                }
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m5910e();
                this.f4224o = false;
                return true;
            default:
                return true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (!this.f4210a.m4992e(this.f4209A ? 2 : 1)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
        if (z) {
            m5910e();
        }
    }

    private void m5903c() {
        int i = 0;
        if (!this.f4224o) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.f4224o = true;
        }
    }

    private boolean m5908d() {
        return ((LayoutParams) this.f4214e.getLayoutParams()).f4204b;
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f4213d == 2) {
            this.f4231v = 0.0f;
        } else {
            this.f4231v = getNavigationOffset();
        }
        if (this.f4210a.m4979a(true)) {
            postInvalidateOnAnimation();
        }
    }

    private float getNavigationOffset() {
        return ((LayoutParams) this.f4214e.getLayoutParams()).f4203a;
    }

    private void setNavigationOffset(float f) {
        LayoutParams layoutParams = (LayoutParams) this.f4214e.getLayoutParams();
        if (f != layoutParams.f4203a) {
            layoutParams.f4203a = f;
            if (this.f4227r != null) {
                this.f4227r.m5879a(f);
            }
            if (this.f4213d == 0) {
                this.f4215f.setScrollX(0);
            } else if (this.f4213d == 1) {
                int width = this.f4214e.getWidth();
                View view = this.f4215f;
                if (!this.f4209A) {
                    width = -width;
                }
                view.setScrollX((int) (layoutParams.f4203a * ((float) width)));
            } else {
                requestLayout();
            }
        }
    }

    public void setDrawerLockMode(int i) {
        if (this.f4229t != i) {
            this.f4229t = i;
            if (i != 0) {
                this.f4210a.m4986c();
            }
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    m5916b(false);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    m5914a(false);
                default:
            }
        }
    }

    public int getDrawerLockMode() {
        return this.f4229t;
    }

    public void m5914a(boolean z) {
        if (this.f4228s) {
            z = false;
        }
        if (!z) {
            setNavigationOffset(1.0f);
            if (this.f4227r != null) {
                this.f4227r.m5878a();
            }
        } else if (this.f4212c) {
            this.f4210a.m4978a(this.f4214e, 0, this.f4214e.getTop());
        } else {
            return;
        }
        invalidate();
    }

    private void m5910e() {
        LayoutParams layoutParams = (LayoutParams) this.f4214e.getLayoutParams();
        if (layoutParams.f4204b) {
            layoutParams.f4204b = false;
            m5916b(true);
        }
    }

    public void m5916b(boolean z) {
        if (this.f4228s) {
            z = false;
        }
        if (!z) {
            setNavigationOffset(0.0f);
            if (this.f4227r != null) {
                this.f4227r.m5882b();
            }
        } else if (this.f4212c) {
            this.f4210a.m4978a(this.f4214e, this.f4209A ? getWidth() : -this.f4214e.getWidth(), this.f4214e.getTop());
        } else {
            return;
        }
        invalidate();
        removeCallbacks(this.f4230u);
    }

    public boolean m5915a() {
        return ((LayoutParams) this.f4214e.getLayoutParams()).f4203a == 1.0f;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (getDrawerLockMode() != 0 || !this.f4212c || keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        boolean a = m5915a();
        m5916b(true);
        return a;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(null);
        savedState.f4205a = getNavigationOffset();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setNavigationOffset(savedState.f4205a);
        if (savedState.f4205a >= 0.5f) {
            m5914a(false);
        } else {
            m5916b(false);
        }
    }
}
