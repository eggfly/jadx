package com.antutu.benchmark.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.utils.widget.SystemBarTintManager;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class MaterialRippleLayout extends FrameLayout {
    private C1634a f5816A;
    private C1635b f5817B;
    private boolean f5818C;
    private SimpleOnGestureListener f5819D;
    private Property<MaterialRippleLayout, Float> f5820E;
    private Property<MaterialRippleLayout, Integer> f5821F;
    private final Paint f5822a;
    private final Rect f5823b;
    private int f5824c;
    private boolean f5825d;
    private boolean f5826e;
    private int f5827f;
    private int f5828g;
    private int f5829h;
    private boolean f5830i;
    private int f5831j;
    private boolean f5832k;
    private Drawable f5833l;
    private boolean f5834m;
    private float f5835n;
    private float f5836o;
    private AdapterView f5837p;
    private View f5838q;
    private AnimatorSet f5839r;
    private ObjectAnimator f5840s;
    private Point f5841t;
    private Point f5842u;
    private int f5843v;
    private boolean f5844w;
    private boolean f5845x;
    private int f5846y;
    private GestureDetector f5847z;

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.1 */
    class C16291 implements Runnable {
        final /* synthetic */ MaterialRippleLayout f5807a;

        C16291(MaterialRippleLayout materialRippleLayout) {
            this.f5807a = materialRippleLayout;
        }

        public void run() {
            this.f5807a.f5838q.setPressed(false);
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.2 */
    class C16302 extends SimpleOnGestureListener {
        final /* synthetic */ MaterialRippleLayout f5808a;

        C16302(MaterialRippleLayout materialRippleLayout) {
            this.f5808a = materialRippleLayout;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f5808a.f5818C = false;
            return super.onDown(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            this.f5808a.f5818C = this.f5808a.f5838q.performLongClick();
            if (this.f5808a.f5818C) {
                if (this.f5808a.f5826e) {
                    this.f5808a.m6445a(null);
                }
                this.f5808a.m6443a();
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.3 */
    class C16313 extends AnimatorListenerAdapter {
        final /* synthetic */ Runnable f5809a;
        final /* synthetic */ MaterialRippleLayout f5810b;

        C16313(MaterialRippleLayout materialRippleLayout, Runnable runnable) {
            this.f5810b = materialRippleLayout;
            this.f5809a = runnable;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f5810b.f5832k) {
                this.f5810b.setRadius(0.0f);
                this.f5810b.setRippleAlpha(Integer.valueOf(this.f5810b.f5829h));
            }
            if (this.f5809a != null && this.f5810b.f5830i) {
                this.f5809a.run();
            }
            this.f5810b.f5838q.setPressed(false);
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.4 */
    class C16324 extends Property<MaterialRippleLayout, Float> {
        final /* synthetic */ MaterialRippleLayout f5811a;

        C16324(MaterialRippleLayout materialRippleLayout, Class cls, String str) {
            this.f5811a = materialRippleLayout;
            super(cls, str);
        }

        public Float m6436a(MaterialRippleLayout materialRippleLayout) {
            return Float.valueOf(materialRippleLayout.getRadius());
        }

        public void m6437a(MaterialRippleLayout materialRippleLayout, Float f) {
            materialRippleLayout.setRadius(f.floatValue());
        }

        public /* synthetic */ Object get(Object obj) {
            return m6436a((MaterialRippleLayout) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m6437a((MaterialRippleLayout) obj, (Float) obj2);
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.5 */
    class C16335 extends Property<MaterialRippleLayout, Integer> {
        final /* synthetic */ MaterialRippleLayout f5812a;

        C16335(MaterialRippleLayout materialRippleLayout, Class cls, String str) {
            this.f5812a = materialRippleLayout;
            super(cls, str);
        }

        public Integer m6438a(MaterialRippleLayout materialRippleLayout) {
            return Integer.valueOf(materialRippleLayout.getRippleAlpha());
        }

        public void m6439a(MaterialRippleLayout materialRippleLayout, Integer num) {
            materialRippleLayout.setRippleAlpha(num);
        }

        public /* synthetic */ Object get(Object obj) {
            return m6438a((MaterialRippleLayout) obj);
        }

        public /* synthetic */ void set(Object obj, Object obj2) {
            m6439a((MaterialRippleLayout) obj, (Integer) obj2);
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.a */
    private class C1634a implements Runnable {
        final /* synthetic */ MaterialRippleLayout f5813a;

        private C1634a(MaterialRippleLayout materialRippleLayout) {
            this.f5813a = materialRippleLayout;
        }

        private void m6440a(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(this.f5813a);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0;
            if (positionForView != -1) {
                adapterView.performItemClick(this.f5813a, positionForView, itemId);
            }
        }

        public void run() {
            if (!this.f5813a.f5818C) {
                if (this.f5813a.getParent() instanceof AdapterView) {
                    m6440a((AdapterView) this.f5813a.getParent());
                } else if (this.f5813a.f5834m) {
                    m6440a(this.f5813a.m6455e());
                } else {
                    this.f5813a.f5838q.performClick();
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.view.MaterialRippleLayout.b */
    private final class C1635b implements Runnable {
        final /* synthetic */ MaterialRippleLayout f5814a;
        private final MotionEvent f5815b;

        public C1635b(MaterialRippleLayout materialRippleLayout, MotionEvent motionEvent) {
            this.f5814a = materialRippleLayout;
            this.f5815b = motionEvent;
        }

        public void run() {
            this.f5814a.f5845x = false;
            this.f5814a.f5838q.setLongClickable(false);
            this.f5814a.f5838q.onTouchEvent(this.f5815b);
            this.f5814a.f5838q.setPressed(true);
            if (this.f5814a.f5826e) {
                this.f5814a.m6448b();
            }
        }
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5822a = new Paint(1);
        this.f5823b = new Rect();
        this.f5841t = new Point();
        this.f5842u = new Point();
        this.f5819D = new C16302(this);
        this.f5820E = new C16324(this, Float.class, "radius");
        this.f5821F = new C16335(this, Integer.class, "rippleAlpha");
        setWillNotDraw(false);
        this.f5847z = new GestureDetector(context, this.f5819D);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1082R.styleable.MaterialRippleLayout);
        this.f5824c = obtainStyledAttributes.getColor(0, SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.f5827f = obtainStyledAttributes.getDimensionPixelSize(1, (int) m6441a(getResources(), 35.0f));
        this.f5825d = obtainStyledAttributes.getBoolean(2, false);
        this.f5826e = obtainStyledAttributes.getBoolean(6, true);
        this.f5828g = obtainStyledAttributes.getInt(4, 350);
        this.f5829h = (int) (255.0f * obtainStyledAttributes.getFloat(3, 0.1f));
        this.f5830i = obtainStyledAttributes.getBoolean(8, true);
        this.f5831j = obtainStyledAttributes.getInteger(5, 75);
        this.f5833l = new ColorDrawable(obtainStyledAttributes.getColor(7, 0));
        this.f5832k = obtainStyledAttributes.getBoolean(9, false);
        this.f5834m = obtainStyledAttributes.getBoolean(10, false);
        this.f5835n = (float) obtainStyledAttributes.getDimensionPixelSize(11, 0);
        obtainStyledAttributes.recycle();
        this.f5822a.setColor(this.f5824c);
        this.f5822a.setAlpha(this.f5829h);
        m6462h();
    }

    static float m6441a(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    private void m6443a() {
        if (this.f5817B != null) {
            removeCallbacks(this.f5817B);
            this.f5845x = false;
        }
    }

    private void m6445a(Runnable runnable) {
        if (!this.f5844w) {
            float endRadius = getEndRadius();
            m6451c();
            this.f5839r = new AnimatorSet();
            this.f5839r.addListener(new C16313(this, runnable));
            Animator ofFloat = ObjectAnimator.ofFloat(this, this.f5820E, new float[]{this.f5836o, endRadius});
            ofFloat.setDuration((long) this.f5828g);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            Animator ofInt = ObjectAnimator.ofInt(this, this.f5821F, new int[]{this.f5829h, 0});
            ofInt.setDuration((long) this.f5831j);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.setStartDelay((long) ((this.f5828g - this.f5831j) - 50));
            if (this.f5832k) {
                this.f5839r.play(ofFloat);
            } else if (getRadius() > endRadius) {
                ofInt.setStartDelay(0);
                this.f5839r.play(ofInt);
            } else {
                this.f5839r.playTogether(new Animator[]{ofFloat, ofInt});
            }
            this.f5839r.start();
        }
    }

    private boolean m6446a(View view, int i, int i2) {
        int i3 = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            while (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return m6446a(childAt, i - rect.left, i2 - rect.top);
                }
                i3++;
            }
        } else if (view != this.f5838q) {
            return view.isEnabled() ? view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode() : false;
        }
        return view.isFocusableInTouchMode();
    }

    private void m6448b() {
        if (!this.f5844w) {
            if (this.f5840s != null) {
                this.f5840s.cancel();
            }
            float sqrt = (float) (Math.sqrt(Math.pow((double) getWidth(), 2.0d) + Math.pow((double) getHeight(), 2.0d)) * 1.2000000476837158d);
            this.f5840s = ObjectAnimator.ofFloat(this, this.f5820E, new float[]{(float) this.f5827f, sqrt}).setDuration(2500);
            this.f5840s.setInterpolator(new LinearInterpolator());
            this.f5840s.start();
        }
    }

    private void m6451c() {
        if (this.f5839r != null) {
            this.f5839r.cancel();
            this.f5839r.removeAllListeners();
        }
        if (this.f5840s != null) {
            this.f5840s.cancel();
        }
    }

    private boolean m6454d() {
        ViewParent parent = getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    private AdapterView m6455e() {
        if (this.f5837p != null) {
            return this.f5837p;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException e) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        this.f5837p = (AdapterView) parent;
        return this.f5837p;
    }

    private void m6458f() {
        if (this.f5834m) {
            this.f5846y = m6455e().getPositionForView(this);
        }
    }

    private boolean m6459g() {
        if (!this.f5834m) {
            return false;
        }
        int positionForView = m6455e().getPositionForView(this);
        boolean z = positionForView != this.f5846y;
        this.f5846y = positionForView;
        if (!z) {
            return z;
        }
        m6443a();
        m6451c();
        this.f5838q.setPressed(false);
        setRadius(0.0f);
        return z;
    }

    private float getEndRadius() {
        int width = getWidth();
        int height = getHeight();
        return ((float) Math.sqrt(Math.pow((double) (height / 2 > this.f5841t.y ? (float) (height - this.f5841t.y) : (float) this.f5841t.y), 2.0d) + Math.pow((double) (width / 2 > this.f5841t.x ? (float) (width - this.f5841t.x) : (float) this.f5841t.x), 2.0d))) * 1.2f;
    }

    private float getRadius() {
        return this.f5836o;
    }

    private void m6462h() {
        if (VERSION.SDK_INT > 17) {
            return;
        }
        if (this.f5835n != 0.0f) {
            this.f5843v = getLayerType();
            setLayerType(1, null);
            return;
        }
        setLayerType(this.f5843v, null);
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("MaterialRippleLayout can host only one child");
        }
        this.f5838q = view;
        super.addView(view, i, layoutParams);
    }

    public void draw(Canvas canvas) {
        boolean g = m6459g();
        if (this.f5825d) {
            if (!g) {
                this.f5833l.draw(canvas);
            }
            super.draw(canvas);
            if (!g) {
                if (this.f5835n != 0.0f) {
                    Path path = new Path();
                    path.addRoundRect(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.f5835n, this.f5835n, Direction.CW);
                    canvas.clipPath(path);
                }
                canvas.drawCircle((float) this.f5841t.x, (float) this.f5841t.y, this.f5836o, this.f5822a);
                return;
            }
            return;
        }
        if (!g) {
            this.f5833l.draw(canvas);
            canvas.drawCircle((float) this.f5841t.x, (float) this.f5841t.y, this.f5836o, this.f5822a);
        }
        super.draw(canvas);
    }

    public <T extends View> T getChildView() {
        return this.f5838q;
    }

    public int getRippleAlpha() {
        return this.f5822a.getAlpha();
    }

    public boolean isInEditMode() {
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !m6446a(this.f5838q, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f5823b.set(0, 0, i, i2);
        this.f5833l.setBounds(this.f5823b);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || !this.f5838q.isEnabled()) {
            return onTouchEvent;
        }
        onTouchEvent = this.f5823b.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (onTouchEvent) {
            this.f5842u.set(this.f5841t.x, this.f5841t.y);
            this.f5841t.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f5847z.onTouchEvent(motionEvent) || this.f5818C) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                m6458f();
                this.f5844w = false;
                this.f5817B = new C1635b(this, motionEvent);
                if (m6454d()) {
                    m6443a();
                    this.f5845x = true;
                    postDelayed(this.f5817B, (long) ViewConfiguration.getTapTimeout());
                    return true;
                }
                this.f5817B.run();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                this.f5816A = new C1634a();
                if (this.f5845x) {
                    this.f5838q.setPressed(true);
                    postDelayed(new C16291(this), (long) ViewConfiguration.getPressedStateDuration());
                }
                if (onTouchEvent) {
                    m6445a(this.f5816A);
                } else if (!this.f5826e) {
                    setRadius(0.0f);
                }
                if (!this.f5830i && onTouchEvent) {
                    this.f5816A.run();
                }
                m6443a();
                return true;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (this.f5826e) {
                    if (onTouchEvent && !this.f5844w) {
                        invalidate();
                    } else if (!onTouchEvent) {
                        m6445a(null);
                    }
                }
                if (onTouchEvent) {
                    return true;
                }
                m6443a();
                if (this.f5840s != null) {
                    this.f5840s.cancel();
                }
                this.f5838q.onTouchEvent(motionEvent);
                this.f5844w = true;
                return true;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                if (this.f5834m) {
                    this.f5841t.set(this.f5842u.x, this.f5842u.y);
                    this.f5842u = new Point();
                }
                this.f5838q.onTouchEvent(motionEvent);
                if (!this.f5826e) {
                    this.f5838q.setPressed(false);
                } else if (!this.f5845x) {
                    m6445a(null);
                }
                m6443a();
                return true;
            default:
                return true;
        }
    }

    public void setDefaultRippleAlpha(int i) {
        this.f5829h = i;
        this.f5822a.setAlpha(i);
        invalidate();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (this.f5838q == null) {
            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
        }
        this.f5838q.setOnClickListener(onClickListener);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.f5838q == null) {
            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
        }
        this.f5838q.setOnLongClickListener(onLongClickListener);
    }

    public void setRadius(float f) {
        this.f5836o = f;
        invalidate();
    }

    public void setRippleAlpha(Integer num) {
        this.f5822a.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleBackground(int i) {
        this.f5833l = new ColorDrawable(i);
        this.f5833l.setBounds(this.f5823b);
        invalidate();
    }

    public void setRippleColor(int i) {
        this.f5824c = i;
        this.f5822a.setColor(i);
        this.f5822a.setAlpha(this.f5829h);
        invalidate();
    }

    public void setRippleDelayClick(boolean z) {
        this.f5830i = z;
    }

    public void setRippleDiameter(int i) {
        this.f5827f = i;
    }

    public void setRippleDuration(int i) {
        this.f5828g = i;
    }

    public void setRippleFadeDuration(int i) {
        this.f5831j = i;
    }

    public void setRippleHover(boolean z) {
        this.f5826e = z;
    }

    public void setRippleInAdapter(boolean z) {
        this.f5834m = z;
    }

    public void setRippleOverlay(boolean z) {
        this.f5825d = z;
    }

    public void setRipplePersistent(boolean z) {
        this.f5832k = z;
    }

    public void setRippleRoundedCorners(int i) {
        this.f5835n = (float) i;
        m6462h();
    }
}
