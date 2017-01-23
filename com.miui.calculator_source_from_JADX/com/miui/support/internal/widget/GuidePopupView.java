package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.widget.GuidePopupWindow;

public class GuidePopupView extends FrameLayout implements OnTouchListener {
    private AnimatorListener f3137A;
    private int f3138B;
    private Context f3139a;
    private View f3140b;
    private LinearLayout f3141c;
    private LinearLayout f3142d;
    private int f3143e;
    private int f3144f;
    private boolean f3145g;
    private int f3146h;
    private GuidePopupWindow f3147i;
    private OnTouchListener f3148j;
    private ObjectAnimator f3149k;
    private boolean f3150l;
    private int f3151m;
    private int f3152n;
    private int f3153o;
    private int f3154p;
    private int f3155q;
    private float f3156r;
    private float f3157s;
    private float f3158t;
    private int f3159u;
    private int f3160v;
    private ColorStateList f3161w;
    private final Paint f3162x;
    private boolean f3163y;
    private AnimatorListener f3164z;

    /* renamed from: com.miui.support.internal.widget.GuidePopupView.1 */
    class C03901 extends AnimatorListenerAdapter {
        final /* synthetic */ GuidePopupView f3130a;
        private boolean f3131b;

        C03901(GuidePopupView guidePopupView) {
            this.f3130a = guidePopupView;
        }

        public void onAnimationStart(Animator animator) {
            this.f3131b = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3131b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3131b) {
                this.f3130a.f3149k = null;
            }
        }
    }

    /* renamed from: com.miui.support.internal.widget.GuidePopupView.2 */
    class C03912 extends AnimatorListenerAdapter {
        final /* synthetic */ GuidePopupView f3132a;
        private boolean f3133b;

        C03912(GuidePopupView guidePopupView) {
            this.f3132a = guidePopupView;
        }

        public void onAnimationStart(Animator animator) {
            this.f3133b = false;
            this.f3132a.f3150l = true;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3133b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3133b) {
                this.f3132a.f3150l = false;
                this.f3132a.f3149k = null;
                this.f3132a.f3147i.dismiss();
                this.f3132a.setArrowMode(-1);
            }
        }
    }

    /* renamed from: com.miui.support.internal.widget.GuidePopupView.3 */
    class C03923 implements OnPreDrawListener {
        final /* synthetic */ GuidePopupView f3134a;

        public boolean onPreDraw() {
            this.f3134a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f3134a.f3149k != null) {
                this.f3134a.f3149k.cancel();
            }
            this.f3134a.f3149k = ObjectAnimator.ofFloat(this.f3134a, View.ALPHA, new float[]{1.0f});
            this.f3134a.f3149k.setDuration(300);
            this.f3134a.f3149k.addListener(this.f3134a.f3164z);
            this.f3134a.f3149k.start();
            return true;
        }
    }

    class WrapperOnClickListener implements OnClickListener {
        public OnClickListener f3135a;
        final /* synthetic */ GuidePopupView f3136b;

        public void onClick(View view) {
            if (this.f3135a != null) {
                this.f3135a.onClick(view);
            }
            this.f3136b.f3147i.m5691a(true);
        }
    }

    public GuidePopupView(Context context) {
        this(context, null);
    }

    public GuidePopupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.guidePopupViewStyle);
    }

    public GuidePopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3145g = true;
        this.f3161w = null;
        this.f3162x = new Paint();
        this.f3164z = new C03901(this);
        this.f3137A = new C03912(this);
        this.f3138B = -1;
        this.f3139a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.GuidePopupView, i, 0);
        this.f3156r = obtainStyledAttributes.getDimension(C0264R.styleable.GuidePopupView_startPointRadius, 0.0f);
        this.f3157s = obtainStyledAttributes.getDimension(C0264R.styleable.GuidePopupView_lineLength, 0.0f);
        this.f3158t = obtainStyledAttributes.getDimension(C0264R.styleable.GuidePopupView_textCircleRadius, 0.0f);
        this.f3159u = obtainStyledAttributes.getColor(C0264R.styleable.GuidePopupView_android_colorBackground, 0);
        this.f3162x.setColor(obtainStyledAttributes.getColor(C0264R.styleable.GuidePopupView_paintColor, -1));
        this.f3160v = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.GuidePopupView_android_textSize, 15);
        this.f3161w = obtainStyledAttributes.getColorStateList(C0264R.styleable.GuidePopupView_android_textColor);
        obtainStyledAttributes.recycle();
        this.f3151m = (int) (this.f3157s + (this.f3158t * 2.5f));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3141c = (LinearLayout) findViewById(C0264R.id.text_group);
        this.f3142d = (LinearLayout) findViewById(C0264R.id.mirrored_text_group);
    }

    private void m4835a() {
        int i = 0;
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[]{this.f3153o, (height - this.f3153o) - this.f3155q, this.f3152n, (width - this.f3152n) - this.f3154p};
        int i2 = Integer.MIN_VALUE;
        int i3 = (this.f3154p / 2) + this.f3152n;
        int i4 = (this.f3155q / 2) + this.f3153o;
        int i5 = 0;
        while (i < 4) {
            if (iArr[i] >= this.f3151m) {
                i2 = i;
                break;
            }
            if (iArr[i] > i2) {
                i2 = iArr[i];
                i5 = i;
            }
            i++;
        }
        i2 = i5;
        switch (i2) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                if (((float) i3) >= this.f3158t) {
                    if (((float) (width - i3)) < this.f3158t) {
                        i2 = 5;
                        break;
                    }
                }
                i2 = 7;
                break;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                if (((float) i3) >= this.f3158t) {
                    if (((float) (width - i3)) < this.f3158t) {
                        i2 = 6;
                        break;
                    }
                }
                i2 = 4;
                break;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (((float) i4) >= this.f3158t) {
                    if (((float) (height - i4)) < this.f3158t) {
                        i2 = 5;
                        break;
                    }
                }
                i2 = 6;
                break;
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                if (((float) i4) >= this.f3158t) {
                    if (((float) (height - i4)) < this.f3158t) {
                        i2 = 7;
                        break;
                    }
                }
                i2 = 4;
                break;
                break;
        }
        setArrowMode(i2);
    }

    private void m4840b() {
        m4842c();
        m4836a(this.f3138B, this.f3141c, this.f3143e, this.f3144f);
        if (this.f3163y) {
            m4836a(getMirroredMode(), this.f3142d, -this.f3143e, -this.f3144f);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3154p == 0 || this.f3155q == 0) {
            setAnchor(this.f3140b);
        }
        int measuredWidth = this.f3141c.getMeasuredWidth();
        int measuredHeight = this.f3141c.getMeasuredHeight();
        this.f3158t = (float) Math.max(Math.sqrt(Math.pow((double) measuredHeight, 2.0d) + Math.pow((double) measuredWidth, 2.0d)) / 2.0d, (double) this.f3158t);
        if (this.f3163y) {
            measuredWidth = this.f3142d.getMeasuredWidth();
            measuredHeight = this.f3142d.getMeasuredHeight();
            this.f3158t = (float) Math.max(Math.sqrt(Math.pow((double) measuredHeight, 2.0d) + Math.pow((double) measuredWidth, 2.0d)) / 2.0d, (double) this.f3158t);
        }
        if (this.f3138B == -1) {
            m4835a();
        } else {
            m4840b();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.save();
        canvas.translate((float) this.f3152n, (float) this.f3153o);
        this.f3140b.setDrawingCacheEnabled(true);
        this.f3140b.buildDrawingCache();
        canvas.drawBitmap(this.f3140b.getDrawingCache(), 0.0f, 0.0f, null);
        this.f3140b.setDrawingCacheEnabled(false);
        canvas.restore();
        m4837a(canvas, this.f3138B, this.f3143e, this.f3144f);
        if (this.f3163y) {
            m4837a(canvas, getMirroredMode(), -this.f3143e, -this.f3144f);
        }
    }

    private void m4837a(Canvas canvas, int i, int i2, int i3) {
        float f;
        this.f3162x.setAntiAlias(true);
        this.f3162x.setStyle(Style.FILL);
        float f2 = (float) ((this.f3152n + (this.f3154p / 2)) + i2);
        float f3 = (float) ((this.f3153o + (this.f3155q / 2)) + i3);
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                f = 180.0f;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                f = 0.0f;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                f = 90.0f;
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                f = -90.0f;
                break;
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                f = -45.0f;
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                f = 135.0f;
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                f = 45.0f;
                break;
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                f = -135.0f;
                break;
            default:
                f = 0.0f;
                break;
        }
        canvas.save();
        canvas.rotate(f, f2, f3);
        canvas.translate(0.0f, (float) this.f3146h);
        int save = canvas.save();
        canvas.clipRect(f2 - 2.0f, f3, 2.0f + f2, f3 + this.f3156r, Op.DIFFERENCE);
        canvas.drawCircle(f2, f3, this.f3156r, this.f3162x);
        canvas.restoreToCount(save);
        this.f3162x.setStyle(Style.STROKE);
        this.f3162x.setStrokeWidth(4.0f);
        canvas.drawLine(f2, f3, f2, f3 + this.f3157s, this.f3162x);
        f = (this.f3157s + f3) + this.f3158t;
        this.f3162x.setStyle(Style.STROKE);
        this.f3162x.setStrokeWidth(4.0f);
        canvas.drawCircle(f2, f, this.f3158t, this.f3162x);
        canvas.restore();
    }

    private void m4836a(int i, LinearLayout linearLayout, int i2, int i3) {
        int i4 = 0;
        float f = this.f3158t + (((float) this.f3146h) + this.f3157s);
        int i5 = this.f3152n + (this.f3154p / 2);
        int i6 = this.f3153o + (this.f3155q / 2);
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                i5 -= linearLayout.getMeasuredWidth() / 2;
                i4 = (int) ((((float) i6) - f) - ((float) (linearLayout.getMeasuredHeight() / 2)));
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                i5 -= linearLayout.getMeasuredWidth() / 2;
                i4 = (int) ((((float) i6) + f) - ((float) (linearLayout.getMeasuredHeight() / 2)));
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                i5 = (int) ((((float) i5) - f) - ((float) (linearLayout.getMeasuredWidth() / 2)));
                i4 = i6 - (linearLayout.getMeasuredHeight() / 2);
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                i5 = (int) ((((float) i5) + f) - ((float) (linearLayout.getMeasuredWidth() / 2)));
                i4 = i6 - (linearLayout.getMeasuredHeight() / 2);
                break;
            default:
                i5 = 0;
                break;
        }
        i6 = (int) (((double) f) * Math.sin(0.7853981633974483d));
        int i7 = (int) (f - ((float) i6));
        switch (i) {
            case C0264R.styleable.Window_windowDisablePreview /*4*/:
                i5 += i6;
                i4 -= i7;
                break;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                i5 -= i6;
                i4 += i7;
                break;
            case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                i5 -= i6;
                i4 -= i7;
                break;
            case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                i5 += i6;
                i4 += i7;
                break;
        }
        i5 += i2;
        i4 += i3;
        linearLayout.layout(i5, i4, linearLayout.getMeasuredWidth() + i5, linearLayout.getMeasuredHeight() + i4);
    }

    private void m4842c() {
        if (this.f3145g) {
            int i = this.f3154p / 2;
            int i2 = this.f3155q / 2;
            int sqrt = (int) Math.sqrt(Math.pow((double) i, 2.0d) + Math.pow((double) i2, 2.0d));
            switch (this.f3138B) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    this.f3146h = i2;
                    return;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f3146h = i;
                    return;
                default:
                    this.f3146h = sqrt;
                    return;
            }
        }
        this.f3146h = 0;
    }

    private int getMirroredMode() {
        if (this.f3138B == -1) {
            return -1;
        }
        if (this.f3138B % 2 == 0) {
            return this.f3138B + 1;
        }
        return this.f3138B - 1;
    }

    public int getArrowMode() {
        return this.f3138B;
    }

    public void setArrowMode(int i) {
        this.f3138B = i;
    }

    public void setAnchor(View view) {
        this.f3140b = view;
        this.f3154p = this.f3140b.getWidth();
        this.f3155q = this.f3140b.getHeight();
        int[] iArr = new int[2];
        this.f3140b.getLocationInWindow(iArr);
        this.f3152n = iArr[0];
        this.f3153o = iArr[1];
    }

    public void setGuidePopupWindow(GuidePopupWindow guidePopupWindow) {
        this.f3147i = guidePopupWindow;
    }

    public int getColorBackground() {
        return this.f3159u;
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.f3148j = onTouchListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = new Rect(this.f3152n, this.f3153o, this.f3152n + this.f3140b.getWidth(), this.f3153o + this.f3140b.getHeight());
        if (motionEvent.getAction() == 0 && rect.contains(x, y)) {
            this.f3140b.callOnClick();
        } else {
            this.f3147i.m5691a(true);
        }
        return true;
    }
}
