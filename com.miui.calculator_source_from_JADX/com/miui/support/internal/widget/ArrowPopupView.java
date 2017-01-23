package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.widget.ArrowPopupWindow;

public class ArrowPopupView extends FrameLayout implements OnTouchListener {
    private boolean f3053A;
    private int f3054B;
    private int f3055C;
    private int f3056D;
    private int f3057E;
    private int f3058F;
    private boolean f3059G;
    private int f3060H;
    private AnimatorListener f3061I;
    private AnimatorListener f3062J;
    private int f3063K;
    private float f3064L;
    private View f3065a;
    private ImageView f3066b;
    private FrameLayout f3067c;
    private LinearLayout f3068d;
    private LinearLayout f3069e;
    private TextView f3070f;
    private Button f3071g;
    private Button f3072h;
    private WrapperOnClickListener f3073i;
    private WrapperOnClickListener f3074j;
    private int f3075k;
    private int f3076l;
    private Drawable f3077m;
    private Drawable f3078n;
    private Drawable f3079o;
    private Drawable f3080p;
    private Drawable f3081q;
    private Drawable f3082r;
    private Drawable f3083s;
    private Drawable f3084t;
    private Drawable f3085u;
    private ArrowPopupWindow f3086v;
    private OnTouchListener f3087w;
    private Rect f3088x;
    private RectF f3089y;
    private AnimatorSet f3090z;

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.1 */
    class C03811 extends AnimatorListenerAdapter {
        final /* synthetic */ ArrowPopupView f3043a;
        private boolean f3044b;

        C03811(ArrowPopupView arrowPopupView) {
            this.f3043a = arrowPopupView;
        }

        public void onAnimationStart(Animator animator) {
            this.f3044b = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3044b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3044b) {
                this.f3043a.f3090z = null;
                if (this.f3043a.f3059G) {
                    this.f3043a.m4778f();
                }
            }
        }
    }

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.2 */
    class C03822 extends AnimatorListenerAdapter {
        final /* synthetic */ ArrowPopupView f3045a;
        private boolean f3046b;

        C03822(ArrowPopupView arrowPopupView) {
            this.f3045a = arrowPopupView;
        }

        public void onAnimationStart(Animator animator) {
            this.f3046b = false;
            this.f3045a.f3053A = true;
        }

        public void onAnimationCancel(Animator animator) {
            this.f3046b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f3046b) {
                this.f3045a.f3053A = false;
                this.f3045a.f3090z = null;
                this.f3045a.f3086v.dismiss();
                this.f3045a.setArrowMode(-1);
            }
        }
    }

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.3 */
    class C03833 implements OnPreDrawListener {
        final /* synthetic */ ArrowPopupView f3047a;

        C03833(ArrowPopupView arrowPopupView) {
            this.f3047a = arrowPopupView;
        }

        public boolean onPreDraw() {
            this.f3047a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f3047a.f3090z != null) {
                this.f3047a.f3090z.cancel();
            }
            this.f3047a.f3090z = new AnimatorSet();
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f3047a.getBackground(), "alpha", new int[]{0, 166});
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3047a.f3068d, View.ALPHA, new float[]{1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3047a.f3066b, View.ALPHA, new float[]{1.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f3047a, "RollingPercent", new float[]{1.0f});
            ofFloat3.setInterpolator(new DecelerateInterpolator(1.2f));
            if (DeviceHelper.f2553e) {
                ofInt.setDuration(300);
                ofFloat.setStartDelay(30);
                ofFloat.setDuration(100);
                ofFloat2.setStartDelay(30);
                ofFloat2.setDuration(100);
                ofFloat3.setStartDelay(30);
                ofFloat3.setDuration(400);
            } else {
                this.f3047a.f3090z.setDuration(0);
            }
            this.f3047a.f3090z.playTogether(new Animator[]{ofInt, ofFloat, ofFloat2, ofFloat3});
            this.f3047a.f3090z.addListener(this.f3047a.f3061I);
            this.f3047a.f3090z.start();
            return true;
        }
    }

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.4 */
    class C03844 extends AnimatorListenerAdapter {
        final /* synthetic */ ArrowPopupView f3048a;

        C03844(ArrowPopupView arrowPopupView) {
            this.f3048a = arrowPopupView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3048a.f3086v.dismiss();
        }
    }

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.5 */
    class C03855 extends AnimatorListenerAdapter {
        final /* synthetic */ ArrowPopupView f3049a;

        C03855(ArrowPopupView arrowPopupView) {
            this.f3049a = arrowPopupView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3049a.getBackground().setAlpha(0);
        }
    }

    /* renamed from: com.miui.support.internal.widget.ArrowPopupView.6 */
    class C03866 implements AnimatorUpdateListener {
        final /* synthetic */ ArrowPopupView f3050a;

        C03866(ArrowPopupView arrowPopupView) {
            this.f3050a = arrowPopupView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3050a.f3060H = ((Float) valueAnimator.getAnimatedValue()).intValue();
            int abs = Math.abs(this.f3050a.f3060H);
            this.f3050a.invalidate(this.f3050a.f3068d.getLeft() - abs, this.f3050a.f3068d.getTop() - abs, this.f3050a.f3068d.getRight() + abs, abs + this.f3050a.f3068d.getBottom());
        }
    }

    class WrapperOnClickListener implements OnClickListener {
        public OnClickListener f3051a;
        final /* synthetic */ ArrowPopupView f3052b;

        WrapperOnClickListener(ArrowPopupView arrowPopupView) {
            this.f3052b = arrowPopupView;
        }

        public void onClick(View view) {
            if (this.f3051a != null) {
                this.f3051a.onClick(view);
            }
            this.f3052b.f3086v.m5691a(true);
        }
    }

    public ArrowPopupView(Context context) {
        this(context, null);
    }

    public ArrowPopupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0264R.attr.arrowPopupViewStyle);
    }

    public ArrowPopupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3088x = new Rect();
        this.f3089y = new RectF();
        this.f3059G = false;
        this.f3061I = new C03811(this);
        this.f3062J = new C03822(this);
        this.f3063K = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.ArrowPopupView, i, 0);
        this.f3077m = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_contentBackground);
        this.f3078n = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_backgroundLeft);
        this.f3079o = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_backgroundRight);
        this.f3080p = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_titleBackground);
        this.f3081q = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_topArrow);
        this.f3082r = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_topArrowWithTitle);
        this.f3083s = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_bottomArrow);
        this.f3084t = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_rightArrow);
        this.f3085u = obtainStyledAttributes.getDrawable(C0264R.styleable.ArrowPopupView_leftArrow);
        obtainStyledAttributes.recycle();
        this.f3054B = context.getResources().getDimensionPixelOffset(C0264R.dimen.arrow_popup_window_min_border);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3066b = (ImageView) findViewById(C0264R.id.popup_arrow);
        this.f3067c = (FrameLayout) findViewById(16908290);
        this.f3068d = (LinearLayout) findViewById(C0264R.id.content_wrapper);
        this.f3068d.setBackground(this.f3077m);
        if (!(this.f3078n == null || this.f3079o == null)) {
            Rect rect = new Rect();
            this.f3078n.getPadding(rect);
            this.f3068d.setPadding(rect.top, rect.top, rect.top, rect.top);
        }
        this.f3069e = (LinearLayout) findViewById(C0264R.id.title_layout);
        this.f3069e.setBackground(this.f3080p);
        this.f3070f = (TextView) findViewById(16908310);
        this.f3071g = (Button) findViewById(16908314);
        this.f3072h = (Button) findViewById(16908313);
        this.f3073i = new WrapperOnClickListener(this);
        this.f3074j = new WrapperOnClickListener(this);
        this.f3071g.setOnClickListener(this.f3073i);
        this.f3072h.setOnClickListener(this.f3074j);
    }

    public void setContentView(View view) {
        m4784a(view, new LayoutParams(-2, -2));
    }

    public void m4784a(View view, LayoutParams layoutParams) {
        this.f3067c.removeAllViews();
        if (view != null) {
            this.f3067c.addView(view, layoutParams);
        }
    }

    public View getContentView() {
        if (this.f3067c.getChildCount() > 0) {
            return this.f3067c.getChildAt(0);
        }
        return null;
    }

    public void setContentView(int i) {
        setContentView(LayoutInflater.from(getContext()).inflate(i, null));
    }

    public void setTitle(CharSequence charSequence) {
        this.f3069e.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.f3070f.setText(charSequence);
    }

    public Button getPositiveButton() {
        return this.f3071g;
    }

    public Button getNegativeButton() {
        return this.f3072h;
    }

    private void m4772c() {
        if (this.f3063K == 0 || this.f3063K == 1) {
            m4774d();
        } else {
            m4776e();
        }
        View contentView = getContentView();
        if (contentView != null) {
            LayoutParams layoutParams = contentView.getLayoutParams();
            if (contentView.getMeasuredHeight() > this.f3068d.getMeasuredHeight() - this.f3069e.getMeasuredHeight()) {
                layoutParams.height = this.f3068d.getMeasuredHeight() - this.f3069e.getMeasuredHeight();
                contentView.setLayoutParams(layoutParams);
            } else if (contentView.getMeasuredWidth() > this.f3068d.getMeasuredWidth()) {
                layoutParams.width = this.f3068d.getMeasuredWidth();
                contentView.setLayoutParams(layoutParams);
            }
            if (layoutParams.height <= 0 || layoutParams.width <= 0) {
                Log.w("ArrowPopupView", "Invalid LayoutPrams of content view, please check the anchor view");
            }
        }
    }

    private void m4774d() {
        int measuredHeight;
        int width = this.f3065a.getWidth();
        int height = this.f3065a.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        int measuredWidth = this.f3068d.getMeasuredWidth() > this.f3068d.getMinimumWidth() ? this.f3068d.getMeasuredWidth() : this.f3068d.getMinimumWidth();
        if (this.f3068d.getMeasuredHeight() > this.f3068d.getMinimumHeight()) {
            measuredHeight = this.f3068d.getMeasuredHeight();
        } else {
            measuredHeight = this.f3068d.getMinimumHeight();
        }
        int measuredWidth2 = this.f3066b.getMeasuredWidth();
        int measuredHeight2 = this.f3066b.getMeasuredHeight();
        int[] iArr = new int[2];
        this.f3065a.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        getLocationInWindow(iArr);
        this.f3055C = ((width / 2) + i) - iArr[0];
        int i3 = width2 - this.f3055C;
        this.f3057E = (((width - measuredWidth2) / 2) + i) - iArr[0];
        this.f3056D = getTop() + this.f3076l;
        if (this.f3063K == 0) {
            this.f3056D += ((i2 - iArr[1]) - measuredHeight) + (this.f3068d.getPaddingBottom() - measuredHeight2);
            width = ((i2 - iArr[1]) - measuredHeight2) + this.f3076l;
        } else if (this.f3063K == 1) {
            this.f3056D += (((height + i2) - iArr[1]) - this.f3068d.getPaddingTop()) + measuredHeight2;
            width = this.f3056D;
        } else {
            width = 0;
        }
        height = measuredWidth / 2;
        int i4 = measuredWidth - height;
        if (this.f3055C >= height && i3 >= i4) {
            this.f3055C -= height;
        } else if (i3 < i4) {
            this.f3055C = width2 - measuredWidth;
        } else if (this.f3055C < height) {
            this.f3055C = 0;
        }
        this.f3055C += this.f3075k;
        this.f3057E += this.f3075k;
        this.f3068d.layout(Math.max(this.f3055C, 0), Math.max(this.f3056D, 0), Math.min(measuredWidth + this.f3055C, width2), Math.min(measuredHeight + this.f3056D, height2));
        this.f3066b.layout(this.f3057E, width, this.f3057E + measuredWidth2, width + measuredHeight2);
    }

    private void m4776e() {
        int measuredHeight;
        int[] iArr = new int[2];
        this.f3065a.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        getLocationInWindow(iArr);
        int width = this.f3065a.getWidth();
        int height = this.f3065a.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        int measuredWidth = this.f3068d.getMeasuredWidth() > this.f3068d.getMinimumWidth() ? this.f3068d.getMeasuredWidth() : this.f3068d.getMinimumWidth();
        if (this.f3068d.getMeasuredHeight() > this.f3068d.getMinimumHeight()) {
            measuredHeight = this.f3068d.getMeasuredHeight();
        } else {
            measuredHeight = this.f3068d.getMinimumHeight();
        }
        int measuredWidth2 = this.f3066b.getMeasuredWidth();
        int measuredHeight2 = this.f3066b.getMeasuredHeight();
        this.f3056D = ((height / 2) + i2) - iArr[1];
        int i3 = height2 - this.f3056D;
        this.f3058F = (i2 + ((height - measuredHeight2) / 2)) - iArr[1];
        height = measuredHeight / 2;
        int i4 = measuredHeight - height;
        this.f3055C = getLeft() + this.f3075k;
        i2 = 0;
        if (this.f3063K == 2) {
            this.f3055C += (((i - measuredWidth) + this.f3068d.getPaddingRight()) - measuredWidth2) - iArr[0];
            i2 = ((i - measuredWidth2) - iArr[0]) + this.f3075k;
        } else if (this.f3063K == 3) {
            this.f3055C += (((i + width) - this.f3068d.getPaddingLeft()) + measuredWidth2) - iArr[0];
            i2 = this.f3055C;
        }
        if (this.f3056D >= height && i3 >= i4) {
            this.f3056D = (this.f3056D - height) + this.f3076l;
        } else if (i3 < i4) {
            this.f3056D = (height2 - measuredHeight) + this.f3076l;
        } else if (this.f3056D < height) {
            this.f3056D = this.f3076l;
        }
        this.f3058F += this.f3076l;
        this.f3068d.layout(Math.max(this.f3055C, 0), Math.max(this.f3056D, 0), Math.min(measuredWidth + this.f3055C, width2), Math.min(measuredHeight + this.f3056D, height2));
        this.f3066b.layout(i2, this.f3058F, i2 + measuredWidth2, this.f3058F + measuredHeight2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3063K == -1) {
            m4780g();
        } else {
            m4772c();
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f3077m == null) {
            float f;
            int measuredWidth;
            int right;
            int width = this.f3055C + (this.f3068d.getWidth() / 2);
            int height = this.f3056D + (this.f3068d.getHeight() / 2);
            RectF rectF = this.f3089y;
            if (this.f3064L != 1.0f) {
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = (float) this.f3068d.getWidth();
                rectF.bottom = (float) this.f3068d.getHeight();
            }
            switch (this.f3063K) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    f = 180.0f;
                    measuredWidth = this.f3057E + (this.f3066b.getMeasuredWidth() / 2);
                    right = this.f3068d.getRight() - measuredWidth;
                    measuredWidth -= this.f3055C;
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    measuredWidth = this.f3057E + (this.f3066b.getMeasuredWidth() / 2);
                    right = measuredWidth - this.f3055C;
                    measuredWidth = this.f3068d.getRight() - measuredWidth;
                    f = 0.0f;
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    f = 90.0f;
                    measuredWidth = this.f3058F + (this.f3066b.getMeasuredHeight() / 2);
                    right = measuredWidth - this.f3056D;
                    measuredWidth = this.f3068d.getBottom() - measuredWidth;
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    f = -90.0f;
                    measuredWidth = this.f3058F + (this.f3066b.getMeasuredHeight() / 2);
                    right = this.f3068d.getBottom() - measuredWidth;
                    measuredWidth -= this.f3056D;
                    break;
                default:
                    measuredWidth = 0;
                    right = 0;
                    f = 0.0f;
                    break;
            }
            int save = canvas.save();
            canvas.rotate(f, (float) width, (float) height);
            switch (this.f3063K) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    canvas.translate((float) this.f3055C, (float) this.f3056D);
                    this.f3078n.setBounds(0, 0, right, this.f3068d.getHeight());
                    if (this.f3064L != 1.0f) {
                        rectF.bottom = (float) ((int) (((float) this.f3068d.getHeight()) * this.f3064L));
                        canvas.clipRect(rectF);
                    } else {
                        canvas.translate(0.0f, this.f3063K == 1 ? (float) this.f3060H : (float) (-this.f3060H));
                    }
                    this.f3078n.draw(canvas);
                    canvas.translate((float) right, 0.0f);
                    this.f3079o.setBounds(0, 0, measuredWidth, this.f3068d.getHeight());
                    this.f3079o.draw(canvas);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    canvas.translate((float) (width - (this.f3068d.getHeight() / 2)), (float) (height - (this.f3068d.getWidth() / 2)));
                    this.f3078n.setBounds(0, 0, right, this.f3068d.getWidth());
                    if (this.f3064L != 1.0f) {
                        rectF.bottom = (float) ((int) (((float) this.f3068d.getWidth()) * this.f3064L));
                        canvas.clipRect(rectF);
                    } else {
                        canvas.translate(0.0f, this.f3063K == 3 ? (float) this.f3060H : (float) (-this.f3060H));
                    }
                    this.f3078n.draw(canvas);
                    canvas.translate((float) right, 0.0f);
                    this.f3079o.setBounds(0, 0, measuredWidth, this.f3068d.getWidth());
                    this.f3079o.draw(canvas);
                    break;
            }
            canvas.restoreToCount(save);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f3064L != 1.0f) {
            RectF rectF = this.f3089y;
            rectF.left = (float) this.f3068d.getLeft();
            rectF.right = (float) this.f3068d.getRight();
            rectF.bottom = (float) this.f3068d.getBottom();
            rectF.top = (float) this.f3068d.getTop();
            float f = 1.0f - this.f3064L;
            switch (this.f3063K) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    rectF.top = (float) ((int) ((f * ((float) this.f3068d.getHeight())) + ((float) this.f3068d.getTop())));
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    rectF.bottom = (float) ((int) (((float) this.f3068d.getBottom()) - (f * ((float) this.f3068d.getHeight()))));
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    rectF.left = (float) ((int) ((f * ((float) this.f3068d.getWidth())) + ((float) this.f3068d.getLeft())));
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    rectF.right = (float) ((int) (((float) this.f3068d.getRight()) - (f * ((float) this.f3068d.getWidth()))));
                    break;
            }
            canvas.saveLayer(rectF, null, 31);
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    public float getRollingPercent() {
        return this.f3064L;
    }

    public void setRollingPercent(float f) {
        this.f3064L = f;
        postInvalidateOnAnimation();
    }

    public void m4782a() {
        getBackground().setAlpha(0);
        setRollingPercent(0.0f);
        this.f3068d.setAlpha(0.0f);
        invalidate();
        getViewTreeObserver().addOnPreDrawListener(new C03833(this));
    }

    public void m4786b() {
        if (!this.f3053A) {
            if (this.f3090z != null) {
                this.f3090z.cancel();
            }
            this.f3090z = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3068d, View.ALPHA, new float[]{0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3066b, View.ALPHA, new float[]{0.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "RollingPercent", new float[]{0.0f});
            if (DeviceHelper.f2553e) {
                ofFloat.setDuration(180);
                ofFloat2.setDuration(180);
                ofFloat3.setDuration(150);
            } else {
                this.f3090z.setDuration(0);
            }
            this.f3090z.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            this.f3090z.addListener(this.f3062J);
            this.f3090z.start();
        }
    }

    private void m4778f() {
        if (DeviceHelper.f2553e) {
            if (this.f3090z != null) {
                this.f3090z.cancel();
            }
            this.f3090z = new AnimatorSet();
            this.f3090z.addListener(new C03844(this));
            ObjectAnimator ofInt = ObjectAnimator.ofInt(getBackground(), "alpha", new int[]{166, 0});
            ofInt.addListener(new C03855(this));
            ofInt.setDuration(1900);
            float f = getContext().getResources().getDisplayMetrics().density * 4.0f;
            Property property = View.TRANSLATION_Y;
            switch (this.f3063K) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    f = -f;
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    f = -f;
                    property = View.TRANSLATION_X;
                    break;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    property = View.TRANSLATION_X;
                    break;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3068d, property, new float[]{0.0f, f, 0.0f});
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(1200);
            ofFloat.setRepeatCount(8);
            ofFloat.addUpdateListener(new C03866(this));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f3066b, property, new float[]{0.0f, f, 0.0f});
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.setDuration(1200);
            ofFloat2.setRepeatCount(8);
            this.f3090z.playTogether(new Animator[]{ofInt, ofFloat, ofFloat2});
            this.f3090z.start();
            return;
        }
        getBackground().setAlpha(0);
    }

    private void m4780g() {
        int i = 0;
        this.f3065a.getLocationInWindow(new int[2]);
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = this.f3068d.getMeasuredWidth();
        int measuredHeight = this.f3068d.getMeasuredHeight();
        int height2 = this.f3065a.getHeight();
        int width2 = this.f3065a.getWidth();
        int[] iArr = new int[]{r0[1] - measuredHeight, ((height - r0[1]) - height2) - measuredHeight, r0[0] - measuredWidth, ((width - r0[0]) - width2) - measuredWidth};
        int i2 = Integer.MIN_VALUE;
        width = 0;
        while (i < 4) {
            if (iArr[i] >= this.f3054B) {
                break;
            }
            if (iArr[i] > i2) {
                i2 = iArr[i];
                width = i;
            }
            i++;
        }
        i = width;
        setArrowMode(i);
    }

    public int getArrowMode() {
        return this.f3063K;
    }

    public void setArrowMode(int i) {
        this.f3063K = i;
        switch (i) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f3066b.setImageDrawable(this.f3083s);
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f3066b.setImageDrawable(this.f3069e.getVisibility() == 0 ? this.f3082r : this.f3081q);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f3066b.setImageDrawable(this.f3084t);
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f3066b.setImageDrawable(this.f3085u);
            default:
        }
    }

    public void setAnchor(View view) {
        this.f3065a = view;
    }

    public void m4783a(int i, int i2) {
        this.f3075k = i;
        this.f3076l = i2;
    }

    public void setArrowPopupWindow(ArrowPopupWindow arrowPopupWindow) {
        this.f3086v = arrowPopupWindow;
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.f3087w = onTouchListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = this.f3088x;
        this.f3068d.getHitRect(rect);
        if (motionEvent.getAction() == 0 && !rect.contains(x, y)) {
            this.f3086v.m5691a(true);
            return true;
        } else if (this.f3087w == null || !this.f3087w.onTouch(view, motionEvent)) {
            return false;
        } else {
            return true;
        }
    }

    public void m4785a(boolean z) {
        this.f3059G = z;
    }
}
