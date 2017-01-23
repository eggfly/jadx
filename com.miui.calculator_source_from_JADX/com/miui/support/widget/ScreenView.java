package com.miui.support.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.variable.Android_View_View_class;
import com.miui.support.internal.variable.Android_View_View_class.Factory;
import java.security.InvalidParameterException;

public class ScreenView extends ViewGroup {
    private static final Android_View_View_class f4366g;
    private static final LayoutParams f4367h;
    private static final float f4368i;
    private int f4369A;
    private int f4370B;
    private int f4371C;
    private int f4372D;
    private int f4373E;
    private int f4374F;
    private int f4375G;
    private float f4376H;
    private boolean f4377I;
    private Scroller f4378J;
    private float f4379K;
    private int f4380L;
    private ScaleGestureDetector f4381M;
    private int f4382N;
    private boolean f4383O;
    private boolean f4384P;
    private boolean f4385Q;
    private int f4386R;
    private int f4387S;
    private int f4388T;
    private float f4389U;
    private float f4390V;
    private float f4391W;
    protected int f4392a;
    private int aa;
    private ScreenViewOvershootInterpolator ab;
    private int ac;
    private float ad;
    private SnapScreenOnceNotification ae;
    private GestureVelocityTracker af;
    protected int f4393b;
    protected int f4394c;
    protected int f4395d;
    protected float f4396e;
    protected float f4397f;
    private final float f4398j;
    private boolean f4399k;
    private int f4400l;
    private int f4401m;
    private int f4402n;
    private int f4403o;
    private int f4404p;
    private int f4405q;
    private ArrowIndicator f4406r;
    private ArrowIndicator f4407s;
    private SeekBarIndicator f4408t;
    private SlideBar f4409u;
    private boolean f4410v;
    private Runnable f4411w;
    private int f4412x;
    private int f4413y;
    private int f4414z;

    /* renamed from: com.miui.support.widget.ScreenView.1 */
    class C05051 implements Runnable {
        final /* synthetic */ ScreenView f4346a;

        C05051(ScreenView screenView) {
            this.f4346a = screenView;
        }

        public void run() {
            this.f4346a.m6054d();
        }
    }

    /* renamed from: com.miui.support.widget.ScreenView.2 */
    class C05062 extends AnimatorListenerAdapter {
        final /* synthetic */ ScreenView f4347a;

        C05062(ScreenView screenView) {
            this.f4347a = screenView;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4347a.f4409u.setVisibility(4);
        }
    }

    private interface Indicator {
    }

    private class ArrowIndicator extends ImageView implements Indicator {
        final /* synthetic */ ScreenView f4348a;

        public ArrowIndicator(ScreenView screenView, Context context) {
            this.f4348a = screenView;
            super(context);
        }
    }

    private class GestureVelocityTracker {
        final /* synthetic */ ScreenView f4349a;
        private VelocityTracker f4350b;
        private int f4351c;
        private float f4352d;
        private float f4353e;
        private float f4354f;

        private GestureVelocityTracker(ScreenView screenView) {
            this.f4349a = screenView;
            this.f4351c = -1;
            this.f4352d = -1.0f;
            this.f4353e = -1.0f;
            this.f4354f = -1.0f;
        }

        public void m6026a() {
            if (this.f4350b != null) {
                this.f4350b.recycle();
                this.f4350b = null;
            }
            m6023b();
        }

        public void m6028a(MotionEvent motionEvent) {
            if (this.f4350b == null) {
                this.f4350b = VelocityTracker.obtain();
            }
            this.f4350b.addMovement(motionEvent);
            float x = motionEvent.getX();
            if (this.f4351c != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f4351c);
                if (findPointerIndex != -1) {
                    x = motionEvent.getX(findPointerIndex);
                } else {
                    this.f4351c = -1;
                }
            }
            if (this.f4352d < 0.0f) {
                this.f4352d = x;
            } else if (this.f4354f < 0.0f) {
                this.f4354f = x;
            } else {
                if (this.f4353e < 0.0f) {
                    if (((this.f4354f > this.f4352d && x < this.f4354f) || (this.f4354f < this.f4352d && x > this.f4354f)) && Math.abs(x - this.f4352d) > 3.0f) {
                        this.f4353e = this.f4354f;
                    }
                } else if (this.f4353e != this.f4354f && (((this.f4354f > this.f4353e && x < this.f4354f) || (this.f4354f < this.f4353e && x > this.f4354f)) && Math.abs(x - this.f4353e) > 3.0f)) {
                    this.f4352d = this.f4353e;
                    this.f4353e = this.f4354f;
                }
                this.f4354f = x;
            }
        }

        private void m6023b() {
            this.f4351c = -1;
            float f = (float) -1;
            this.f4352d = f;
            this.f4353e = f;
            this.f4354f = f;
        }

        public void m6027a(int i) {
            if (this.f4350b == null) {
                this.f4350b = VelocityTracker.obtain();
            } else {
                this.f4350b.clear();
            }
            m6023b();
            this.f4351c = i;
        }

        public float m6024a(int i, int i2, int i3) {
            this.f4350b.computeCurrentVelocity(i, (float) i2);
            return this.f4350b.getXVelocity(i3);
        }

        public int m6025a(float f) {
            if (f <= 300.0f) {
                return 4;
            }
            if (this.f4353e < 0.0f) {
                if (this.f4354f > this.f4352d) {
                    return 1;
                }
                return 2;
            } else if (this.f4354f < this.f4353e) {
                if (this.f4349a.getScrollX() < this.f4349a.getCurrentScreen().getLeft()) {
                    return 3;
                }
                return 2;
            } else if (this.f4354f <= this.f4353e) {
                return 3;
            } else {
                if (this.f4349a.getScrollX() > this.f4349a.getCurrentScreen().getLeft()) {
                    return 3;
                }
                return 1;
            }
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f4355a;

        /* renamed from: com.miui.support.widget.ScreenView.SavedState.1 */
        final class C05071 implements Creator<SavedState> {
            C05071() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m6029a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m6030a(i);
            }

            public SavedState m6029a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m6030a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C05071();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f4355a = -1;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4355a = -1;
            this.f4355a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4355a);
        }
    }

    private class ScaleDetectorListener implements OnScaleGestureListener {
        final /* synthetic */ ScreenView f4356a;

        private ScaleDetectorListener(ScreenView screenView) {
            this.f4356a = screenView;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return this.f4356a.f4382N == 0;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            this.f4356a.m6063a();
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (this.f4356a.f4382N == 0 && (((float) scaleGestureDetector.getTimeDelta()) > 200.0f || scaleFactor < 0.95f || scaleFactor > 1.0526316f)) {
                this.f4356a.m6039a(null, 4);
            }
            if (scaleFactor < 0.8f) {
                this.f4356a.m6068a(scaleGestureDetector);
                return true;
            } else if (scaleFactor <= 1.2f) {
                return false;
            } else {
                this.f4356a.m6074b(scaleGestureDetector);
                return true;
            }
        }
    }

    private class ScreenViewOvershootInterpolator implements Interpolator {
        final /* synthetic */ ScreenView f4357a;
        private float f4358b;

        public ScreenViewOvershootInterpolator(ScreenView screenView) {
            this.f4357a = screenView;
            this.f4358b = screenView.ad;
        }

        public void m6033a(int i, int i2) {
            float c;
            if (i > 0) {
                c = this.f4357a.ad / ((float) i);
            } else {
                c = this.f4357a.ad;
            }
            this.f4358b = c;
        }

        public void m6032a() {
            this.f4358b = 0.0f;
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (((f2 * (this.f4358b + 1.0f)) + this.f4358b) * (f2 * f2)) + 1.0f;
        }
    }

    private class SeekBarIndicator extends LinearLayout implements Indicator {
        final /* synthetic */ ScreenView f4359a;

        public SeekBarIndicator(ScreenView screenView, Context context) {
            this.f4359a = screenView;
            super(context);
        }
    }

    private class SlideBar extends FrameLayout implements Indicator {
        final /* synthetic */ ScreenView f4360a;
        private Bitmap f4361b;
        private NinePatch f4362c;
        private Rect f4363d;
        private Rect f4364e;

        public SlideBar(ScreenView screenView, Context context, int i, int i2) {
            this.f4360a = screenView;
            super(context);
            this.f4363d = new Rect();
            this.f4364e = new Rect();
            this.f4361b = BitmapFactory.decodeResource(getResources(), i);
            if (this.f4361b != null) {
                byte[] ninePatchChunk = this.f4361b.getNinePatchChunk();
                if (ninePatchChunk != null) {
                    this.f4362c = new NinePatch(this.f4361b, ninePatchChunk, null);
                    View frameLayout = new FrameLayout(getContext());
                    frameLayout.setBackgroundResource(i2);
                    addView(frameLayout, new FrameLayout.LayoutParams(-1, -2, 80));
                    this.f4364e.left = frameLayout.getPaddingLeft();
                    this.f4364e.top = frameLayout.getPaddingTop();
                    this.f4364e.right = frameLayout.getPaddingRight();
                    this.f4364e.bottom = frameLayout.getPaddingBottom();
                    this.f4363d.top = this.f4364e.top;
                    this.f4363d.bottom = this.f4363d.top + this.f4361b.getHeight();
                }
            }
        }

        protected int getSuggestedMinimumHeight() {
            return Math.max(this.f4361b.getHeight(), super.getSuggestedMinimumHeight());
        }

        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            if (this.f4362c != null) {
                this.f4362c.draw(canvas, this.f4363d);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f4362c != null) {
                this.f4363d.bottom = (i4 - i2) - this.f4364e.bottom;
                this.f4363d.top = this.f4363d.bottom - this.f4362c.getHeight();
            }
        }

        public void m6035a(int i, int i2) {
            this.f4363d.left = this.f4364e.left + i;
            this.f4363d.right = this.f4364e.left + i2;
        }

        public int m6034a() {
            return (getMeasuredWidth() - this.f4364e.left) - this.f4364e.right;
        }
    }

    private class SliderTouchListener implements OnTouchListener {
        final /* synthetic */ ScreenView f4365a;

        private SliderTouchListener(ScreenView screenView) {
            this.f4365a = screenView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int width = view.getWidth();
            float max = Math.max(0.0f, Math.min(motionEvent.getX(), (float) (width - 1)));
            int screenCount = this.f4365a.getScreenCount();
            int floor = (int) Math.floor((double) ((((float) screenCount) * max) / ((float) width)));
            switch (motionEvent.getAction()) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    if (!this.f4365a.f4378J.isFinished()) {
                        this.f4365a.f4378J.abortAnimation();
                    }
                    this.f4365a.m6039a(motionEvent, 3);
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    this.f4365a.m6073b(floor);
                    this.f4365a.m6047b(this.f4365a.f4395d, this.f4365a.f4373E);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    this.f4365a.setCurrentScreenInner(floor);
                    this.f4365a.scrollTo((int) (((max * ((float) (screenCount * this.f4365a.f4394c))) / ((float) width)) - ((float) (this.f4365a.f4394c / 2))), 0);
                    break;
            }
            return true;
        }
    }

    public interface SnapScreenOnceNotification {
        void m6036a(ScreenView screenView);

        void m6037b(ScreenView screenView);
    }

    static {
        f4366g = Factory.getInstance().get();
        f4367h = new LayoutParams(-1, -1, 1.0f);
        f4368i = (float) (0.016d / Math.log(0.75d));
    }

    public ScreenView(Context context) {
        super(context);
        this.f4398j = Resources.getSystem().getDisplayMetrics().density * 1280.0f;
        this.f4399k = true;
        this.f4401m = C0264R.drawable.screen_view_arrow_left;
        this.f4402n = C0264R.drawable.screen_view_arrow_left_gray;
        this.f4403o = C0264R.drawable.screen_view_arrow_right;
        this.f4404p = C0264R.drawable.screen_view_arrow_right_gray;
        this.f4405q = C0264R.drawable.screen_view_seek_point_selector;
        this.f4411w = new C05051(this);
        this.f4393b = 1;
        this.f4370B = 0;
        this.f4373E = -1;
        this.f4376H = 0.33333334f;
        this.f4379K = 0.5f;
        this.f4380L = 0;
        this.f4382N = 0;
        this.f4385Q = true;
        this.f4388T = -1;
        this.f4391W = 0.5f;
        this.aa = 300;
        this.ac = 0;
        this.ad = 1.3f;
        this.af = new GestureVelocityTracker();
        m6046b();
    }

    public ScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4398j = Resources.getSystem().getDisplayMetrics().density * 1280.0f;
        this.f4399k = true;
        this.f4401m = C0264R.drawable.screen_view_arrow_left;
        this.f4402n = C0264R.drawable.screen_view_arrow_left_gray;
        this.f4403o = C0264R.drawable.screen_view_arrow_right;
        this.f4404p = C0264R.drawable.screen_view_arrow_right_gray;
        this.f4405q = C0264R.drawable.screen_view_seek_point_selector;
        this.f4411w = new C05051(this);
        this.f4393b = 1;
        this.f4370B = 0;
        this.f4373E = -1;
        this.f4376H = 0.33333334f;
        this.f4379K = 0.5f;
        this.f4380L = 0;
        this.f4382N = 0;
        this.f4385Q = true;
        this.f4388T = -1;
        this.f4391W = 0.5f;
        this.aa = 300;
        this.ac = 0;
        this.ad = 1.3f;
        this.af = new GestureVelocityTracker();
        m6046b();
    }

    public void setOvershootTension(float f) {
        this.ad = f;
        if (this.ab != null) {
            this.ab.f4358b = f;
        }
    }

    public void setTouchSlop(int i) {
        this.f4386R = i;
    }

    public void setConfirmHorizontalScrollRatio(float f) {
        this.f4391W = f;
    }

    public void setScreenSnapDuration(int i) {
        this.aa = i;
    }

    public void setMaximumSnapVelocity(int i) {
        this.f4387S = i;
    }

    public void setScrollWholeScreen(boolean z) {
        this.f4377I = z;
    }

    private void m6046b() {
        setAlwaysDrawnWithCacheEnabled(true);
        setClipToPadding(true);
        this.ab = new ScreenViewOvershootInterpolator(this);
        this.f4378J = new Scroller(getContext(), this.ab);
        setCurrentScreenInner(0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f4386R = viewConfiguration.getScaledTouchSlop();
        setMaximumSnapVelocity(viewConfiguration.getScaledMaximumFlingVelocity());
        this.f4381M = new ScaleGestureDetector(getContext(), new ScaleDetectorListener());
    }

    public void setArrowIndicatorMarginRect(Rect rect) {
        if (rect != null) {
            FrameLayout.LayoutParams layoutParams;
            FrameLayout.LayoutParams layoutParams2;
            if (this.f4406r == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2, 19);
                this.f4406r = new ArrowIndicator(this, getContext());
                this.f4406r.setImageResource(this.f4401m);
                m6071a(this.f4406r, layoutParams);
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 21);
                this.f4407s = new ArrowIndicator(this, getContext());
                this.f4407s.setImageResource(this.f4403o);
                m6071a(this.f4407s, layoutParams2);
            } else {
                layoutParams = (FrameLayout.LayoutParams) this.f4406r.getLayoutParams();
                layoutParams2 = (FrameLayout.LayoutParams) this.f4407s.getLayoutParams();
            }
            layoutParams.setMargins(rect.left, rect.top, 0, rect.bottom);
            layoutParams2.setMargins(0, rect.top, rect.right, rect.bottom);
        } else if (this.f4406r != null) {
            m6069a(this.f4406r);
            m6069a(this.f4407s);
            this.f4406r = null;
            this.f4407s = null;
        }
    }

    public void setSeekPointResource(int i) {
        this.f4405q = i;
    }

    public void setSeekBarPosition(FrameLayout.LayoutParams layoutParams) {
        int i = 0;
        if (layoutParams != null) {
            if (this.f4408t == null) {
                this.f4408t = new SeekBarIndicator(this, getContext());
                this.f4408t.setGravity(16);
                this.f4408t.setAnimationCacheEnabled(false);
                while (i < getChildCount()) {
                    this.f4408t.addView(m6062g(), f4367h);
                    i++;
                }
                m6071a(this.f4408t, layoutParams);
                return;
            }
            this.f4408t.setLayoutParams(layoutParams);
        } else if (this.f4408t != null) {
            m6069a(this.f4408t);
            this.f4408t = null;
        }
    }

    public void setSlideBarPosition(FrameLayout.LayoutParams layoutParams) {
        m6072a(layoutParams, C0264R.drawable.screen_view_slide_bar, C0264R.drawable.screen_view_slide_bar_bg, false);
    }

    public void m6072a(FrameLayout.LayoutParams layoutParams, int i, int i2, boolean z) {
        this.f4410v = z;
        if (layoutParams != null) {
            if (this.f4409u == null) {
                this.f4409u = new SlideBar(this, getContext(), i, i2);
                this.f4409u.setOnTouchListener(new SliderTouchListener());
                this.f4409u.setAnimationCacheEnabled(false);
                m6071a(this.f4409u, layoutParams);
                return;
            }
            this.f4409u.setLayoutParams(layoutParams);
        } else if (this.f4409u != null) {
            m6069a(this.f4409u);
            this.f4409u = null;
        }
    }

    private void m6051c() {
        if (this.f4409u != null && this.f4410v) {
            removeCallbacks(this.f4411w);
            this.f4409u.animate().cancel();
            this.f4409u.setAlpha(1.0f);
            this.f4409u.setVisibility(0);
            if (this.f4382N == 0) {
                postDelayed(this.f4411w, 1000);
            }
        }
    }

    private void m6054d() {
        if (this.f4410v) {
            this.f4409u.animate().setDuration(DeviceHelper.f2553e ? 500 : 0).alpha(0.0f).setListener(new C05062(this));
        }
    }

    public void setIndicatorBarVisibility(int i) {
        setSeekBarVisibility(i);
        setSlideBarVisibility(i);
    }

    public void setSeekBarVisibility(int i) {
        if (this.f4408t != null) {
            this.f4408t.setVisibility(i);
        }
    }

    public void setSlideBarVisibility(int i) {
        if (this.f4409u != null) {
            this.f4409u.setVisibility(i);
        }
    }

    public void setScreenPadding(Rect rect) {
        if (rect == null) {
            throw new InvalidParameterException("The padding parameter can not be null.");
        }
        this.f4412x = rect.top;
        this.f4413y = rect.bottom;
        setPadding(rect.left, 0, rect.right, 0);
    }

    public void setScreenAlignment(int i) {
        this.f4414z = i;
    }

    public void setScreenOffset(int i) {
        this.f4392a = i;
        this.f4414z = 0;
        requestLayout();
    }

    private void m6057e() {
        switch (this.f4414z) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f4369A = this.f4392a;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f4369A = 0;
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f4369A = (this.f4370B - this.f4394c) / 2;
                break;
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                this.f4369A = this.f4370B - this.f4394c;
                break;
        }
        this.f4369A += getPaddingLeft();
    }

    private void m6038a(int i, boolean z) {
        if (getWidth() > 0) {
            int screenCount = getScreenCount();
            int width = getWidth();
            int height = getHeight();
            for (int i2 = 0; i2 < this.f4400l; i2++) {
                int i3;
                View childAt = getChildAt(i2 + screenCount);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.gravity;
                if (i4 != -1) {
                    int i5 = i4 & 112;
                    switch (Gravity.getAbsoluteGravity(i4, getLayoutDirection()) & 7) {
                        case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                            i4 = (((width - measuredWidth) / 2) + layoutParams.leftMargin) - layoutParams.rightMargin;
                            break;
                        case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                            i4 = layoutParams.leftMargin;
                            break;
                        case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                            i4 = (width - measuredWidth) - layoutParams.rightMargin;
                            break;
                        default:
                            i4 = layoutParams.leftMargin;
                            break;
                    }
                    switch (i5) {
                        case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                            i3 = (((height - measuredHeight) / 2) + layoutParams.topMargin) - layoutParams.bottomMargin;
                            break;
                        case 48:
                            i3 = layoutParams.topMargin;
                            break;
                        case 80:
                            i3 = (height - measuredHeight) - layoutParams.bottomMargin;
                            break;
                        default:
                            i3 = layoutParams.topMargin;
                            break;
                    }
                }
                i3 = 0;
                i4 = 0;
                if (z || childAt.getHeight() <= 0 || childAt.getWidth() <= 0) {
                    childAt.layout(i4, i3, measuredWidth + i4, measuredHeight + i3);
                } else {
                    childAt.setTranslationX((float) i);
                }
            }
        }
    }

    private void m6055d(int i) {
        int screenCount = getScreenCount();
        if (this.f4409u != null && screenCount > 0) {
            int a = this.f4409u.m6034a();
            int max = Math.max((a / screenCount) * this.f4393b, 48);
            screenCount *= this.f4394c;
            screenCount = screenCount <= a ? 0 : ((a - max) * i) / (screenCount - a);
            this.f4409u.m6035a(screenCount, max + screenCount);
            if (isHardwareAccelerated()) {
                this.f4409u.invalidate();
            }
        }
    }

    private void m6058e(int i) {
        if (this.f4406r != null) {
            this.f4406r.setImageResource(i <= 0 ? this.f4402n : this.f4401m);
            this.f4407s.setImageResource(i >= ((getScreenCount() * this.f4394c) - this.f4370B) - this.f4369A ? this.f4404p : this.f4403o);
        }
    }

    public void setOverScrollRatio(float f) {
        this.f4376H = f;
        m6060f();
    }

    public void setVisibleExtentionRatio(float f) {
        this.f4379K = f;
    }

    private void m6060f() {
        this.f4375G = ((int) (((float) (-this.f4394c)) * this.f4376H)) - this.f4369A;
        if (this.f4377I) {
            this.f4374F = (int) (((float) (((getScreenCount() - 1) / this.f4393b) * this.f4370B)) + (((float) this.f4394c) * this.f4376H));
        } else {
            this.f4374F = ((int) ((((float) this.f4394c) * (((float) getScreenCount()) + this.f4376H)) - ((float) this.f4370B))) + this.f4369A;
        }
    }

    public void m6064a(int i) {
        if (this.f4377I) {
            i -= i % this.f4393b;
        }
        measure(this.f4371C, this.f4372D);
        scrollTo((this.f4394c * i) - this.f4369A, 0);
    }

    public void scrollTo(int i, int i2) {
        this.f4390V = (float) Math.max(this.f4375G, Math.min(i, this.f4374F));
        this.f4389U = ((float) System.nanoTime()) / 1.0E9f;
        super.scrollTo((int) this.f4390V, i2);
    }

    public void computeScroll() {
        if (this.f4378J.computeScrollOffset()) {
            this.f4390V = (float) this.f4378J.getCurrX();
            f4366g.setScrollXDirectly(this, (int) this.f4390V);
            this.f4389U = ((float) System.nanoTime()) / 1.0E9f;
            f4366g.setScrollYDirectly(this, this.f4378J.getCurrY());
            postInvalidateOnAnimation();
        } else if (this.f4373E != -1) {
            setCurrentScreenInner(Math.max(0, Math.min(this.f4373E, getScreenCount() - 1)));
            this.f4373E = -1;
            if (this.ae != null) {
                this.ae.m6037b(this);
                this.ae = null;
            }
        } else if (this.f4382N == 1) {
            float nanoTime = ((float) System.nanoTime()) / 1.0E9f;
            float scrollX = this.f4390V - ((float) getScrollX());
            f4366g.setScrollXDirectly(this, (int) ((((float) Math.exp((double) ((nanoTime - this.f4389U) / f4368i))) * scrollX) + ((float) getScrollX())));
            this.f4389U = nanoTime;
            if (scrollX > 1.0f || scrollX < -1.0f) {
                postInvalidate();
            }
        }
        m6038a(getScrollX(), false);
        m6055d(getScrollX());
        m6058e(getScrollX());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        computeScroll();
        m6051c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            m6051c();
        }
        super.setVisibility(i);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        this.f4371C = i;
        this.f4372D = i2;
        int screenCount = getScreenCount();
        int i4 = 0;
        int i5 = 0;
        for (i3 = 0; i3 < this.f4400l; i3++) {
            View childAt = getChildAt(i3 + screenCount);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i2, ((getPaddingTop() + this.f4412x) + getPaddingBottom()) + this.f4413y, layoutParams.height));
            i4 = Math.max(i4, childAt.getMeasuredWidth());
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        int i6 = 0;
        int i7 = 0;
        for (i3 = 0; i3 < screenCount; i3++) {
            View childAt2 = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
            childAt2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams2.width), getChildMeasureSpec(i2, ((getPaddingTop() + this.f4412x) + getPaddingBottom()) + this.f4413y, layoutParams2.height));
            i6 = Math.max(i6, childAt2.getMeasuredWidth());
            i7 = Math.max(i7, childAt2.getMeasuredHeight());
        }
        i3 = Math.max(i6, i4);
        setMeasuredDimension(resolveSize(i3 + (getPaddingLeft() + getPaddingRight()), i), resolveSize(Math.max(i7, i5) + (((getPaddingTop() + this.f4412x) + getPaddingBottom()) + this.f4413y), i2));
        if (screenCount > 0) {
            this.f4394c = i6;
            this.f4370B = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
            m6057e();
            if (this.f4394c > 0) {
                this.f4393b = Math.max(1, (this.f4370B + ((int) (((float) this.f4394c) * this.f4379K))) / this.f4394c);
            }
            setOverScrollRatio(this.f4376H);
        }
        if (this.f4399k && this.f4393b > 0) {
            this.f4399k = false;
            setHorizontalScrollBarEnabled(false);
            setCurrentScreen(this.f4395d);
            setHorizontalScrollBarEnabled(true);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        m6038a(getScrollX(), true);
        int screenCount = getScreenCount();
        for (int i6 = 0; i6 < screenCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                childAt.layout(i5, getPaddingTop() + this.f4412x, childAt.getMeasuredWidth() + i5, (getPaddingTop() + this.f4412x) + childAt.getMeasuredHeight());
                i5 += childAt.getMeasuredWidth();
            }
        }
        if (this.f4377I && this.f4395d % this.f4393b > 0) {
            setCurrentScreen(this.f4395d - (this.f4395d % this.f4393b));
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m6052c(view);
        return super.drawChild(canvas, view, j);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= getScreenCount()) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        if (indexOfChild == this.f4395d && this.f4378J.isFinished()) {
            return false;
        }
        m6073b(indexOfChild);
        return true;
    }

    public boolean dispatchUnhandledMove(View view, int i) {
        if (i == 17) {
            if (this.f4395d > 0) {
                m6073b(this.f4395d - 1);
                return true;
            }
        } else if (i == 66 && this.f4395d < getScreenCount() - 1) {
            m6073b(this.f4395d + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    protected int getTouchState() {
        return this.f4382N;
    }

    private void m6039a(MotionEvent motionEvent, int i) {
        this.f4382N = i;
        getParent().requestDisallowInterceptTouchEvent(this.f4382N != 0);
        if (this.f4382N == 0) {
            this.f4388T = -1;
            this.f4385Q = false;
            this.af.m6026a();
        } else {
            if (motionEvent != null) {
                this.f4388T = motionEvent.getPointerId(0);
                this.f4396e = motionEvent.getX(motionEvent.findPointerIndex(this.f4388T));
            }
            if (this.f4385Q) {
                this.f4385Q = false;
                View childAt = getChildAt(this.f4395d);
                if (childAt != null) {
                    childAt.cancelLongPress();
                }
            }
            if (this.f4382N == 1) {
                this.f4390V = (float) getScrollX();
                this.f4389U = ((float) System.nanoTime()) / 1.0E9f;
            }
        }
        m6051c();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                motionEvent.setAction(3);
                this.f4381M.onTouchEvent(motionEvent);
                motionEvent.setAction(0);
                this.f4384P = false;
                this.f4383O = false;
                this.f4396e = motionEvent.getX();
                this.f4397f = motionEvent.getY();
                if (!this.f4378J.isFinished()) {
                    this.f4378J.abortAnimation();
                    m6039a(motionEvent, 1);
                    break;
                }
                this.f4385Q = true;
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m6039a(motionEvent, 0);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                m6048b(motionEvent);
                if (this.f4382N == 0 && m6044a(motionEvent)) {
                    m6039a(motionEvent, 1);
                    break;
                }
        }
        if (2 != (motionEvent.getAction() & 255)) {
            m6048b(motionEvent);
        }
        if (this.f4384P || (this.f4382N != 0 && this.f4382N != 3)) {
            return true;
        }
        return false;
    }

    private boolean m6044a(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - this.f4396e);
        if (abs <= Math.abs(motionEvent.getY(0) - this.f4397f) * this.f4391W || abs <= ((float) (this.f4386R * motionEvent.getPointerCount()))) {
            return false;
        }
        return true;
    }

    private void m6048b(MotionEvent motionEvent) {
        this.af.m6028a(motionEvent);
        if (this.f4382N == 0 || 4 == this.f4382N) {
            this.f4381M.onTouchEvent(motionEvent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4384P) {
            if (this.f4383O) {
                m6048b(motionEvent);
            }
            int findPointerIndex;
            switch (motionEvent.getAction() & 255) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    if (this.f4382N == 1) {
                        m6061f(this.f4388T);
                    }
                    m6039a(motionEvent, 0);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (this.f4382N == 0 && m6044a(motionEvent)) {
                        m6039a(motionEvent, 1);
                    }
                    if (this.f4382N == 1) {
                        findPointerIndex = motionEvent.findPointerIndex(this.f4388T);
                        if (findPointerIndex == -1) {
                            m6039a(motionEvent, 1);
                            findPointerIndex = motionEvent.findPointerIndex(this.f4388T);
                        }
                        float x = motionEvent.getX(findPointerIndex);
                        float f = this.f4396e - x;
                        this.f4396e = x;
                        if (f == 0.0f) {
                            awakenScrollBars();
                            break;
                        }
                        scrollTo(Math.round(this.f4390V + f), 0);
                        break;
                    }
                    break;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    findPointerIndex = (motionEvent.getAction() & 65280) >> 8;
                    if (motionEvent.getPointerId(findPointerIndex) == this.f4388T) {
                        if (findPointerIndex == 0) {
                            findPointerIndex = 1;
                        } else {
                            findPointerIndex = 0;
                        }
                        this.f4396e = motionEvent.getX(findPointerIndex);
                        this.f4388T = motionEvent.getPointerId(findPointerIndex);
                        this.af.m6027a(this.f4388T);
                        break;
                    }
                    break;
            }
            this.f4383O = true;
        }
        return true;
    }

    private void m6061f(int i) {
        if (this.f4394c > 0 && getCurrentScreen() != null) {
            int a = (int) this.af.m6024a(1000, this.f4387S, i);
            m6065a(a, this.af.m6025a((float) Math.abs(a)));
        }
    }

    protected void m6065a(int i, int i2) {
        if (i2 == 1 && this.f4395d > 0) {
            m6066a(this.f4395d - this.f4393b, i, true);
        } else if (i2 == 2 && this.f4395d < getScreenCount() - 1) {
            m6066a(this.f4395d + this.f4393b, i, true);
        } else if (i2 == 3) {
            m6066a(this.f4395d, i, true);
        } else {
            int i3;
            int i4 = this.f4394c;
            if (this.f4377I) {
                i3 = this.f4393b;
            } else {
                i3 = 1;
            }
            m6066a((((i3 * i4) >> 1) + getScrollX()) / this.f4394c, 0, true);
        }
    }

    public void m6073b(int i) {
        m6066a(i, 0, false);
    }

    protected void m6067a(int i, int i2, boolean z, SnapScreenOnceNotification snapScreenOnceNotification) {
        if (this.f4370B > 0) {
            if (this.f4377I) {
                this.f4373E = Math.max(0, Math.min(i, getScreenCount() - 1));
                this.f4373E -= this.f4373E % this.f4393b;
            } else {
                this.f4373E = Math.max(0, Math.min(i, getScreenCount() - this.f4393b));
            }
            int max = Math.max(1, Math.abs(this.f4373E - this.f4395d));
            if (!this.f4378J.isFinished()) {
                if (this.ae != null) {
                    this.ae.m6036a(this);
                }
                this.f4378J.abortAnimation();
            }
            this.ae = snapScreenOnceNotification;
            int abs = Math.abs(i2);
            if (z) {
                this.ab.m6033a(max, abs);
            } else {
                this.ab.m6032a();
            }
            int scrollX = ((this.f4373E * this.f4394c) - this.f4369A) - getScrollX();
            if (scrollX != 0) {
                int abs2 = (Math.abs(scrollX) * this.aa) / this.f4370B;
                if (abs > 0) {
                    abs2 += (int) ((((float) abs2) / (((float) abs) / 2500.0f)) * 0.4f);
                }
                int max2 = Math.max(this.aa, abs2);
                if (max <= 1) {
                    max2 = Math.min(max2, this.aa * 2);
                }
                this.f4378J.startScroll(getScrollX(), 0, scrollX, 0, max2);
                invalidate();
            }
        }
    }

    protected void m6066a(int i, int i2, boolean z) {
        m6067a(i, i2, z, null);
    }

    public final int getScreenCount() {
        return this.f4380L;
    }

    public int getCurrentScreenIndex() {
        if (this.f4373E != -1) {
            return this.f4373E;
        }
        return this.f4395d;
    }

    public View getCurrentScreen() {
        return m6076c(this.f4395d);
    }

    public void setCurrentScreen(int i) {
        int max;
        if (this.f4377I) {
            max = Math.max(0, Math.min(i, getScreenCount() - 1));
            max -= max % this.f4393b;
        } else {
            max = Math.max(0, Math.min(i, getScreenCount() - this.f4393b));
        }
        setCurrentScreenInner(max);
        if (!this.f4399k) {
            if (!this.f4378J.isFinished()) {
                this.f4378J.abortAnimation();
            }
            m6064a(this.f4395d);
            invalidate();
        }
    }

    private void setCurrentScreenInner(int i) {
        m6047b(this.f4395d, i);
        this.f4395d = i;
        this.f4373E = -1;
    }

    public View m6076c(int i) {
        if (i < 0 || i >= getScreenCount()) {
            return null;
        }
        return getChildAt(i);
    }

    public int getVisibleRange() {
        return this.f4393b;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        int screenCount = getScreenCount();
        if (i >= 0) {
            screenCount = Math.min(i, screenCount);
        }
        if (this.f4408t != null) {
            this.f4408t.addView(m6062g(), screenCount, f4367h);
        }
        this.f4380L++;
        m6060f();
        super.addView(view, screenCount, layoutParams);
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("ScreenView doesn't support remove view directly.");
    }

    public void removeViewInLayout(View view) {
        throw new UnsupportedOperationException("ScreenView doesn't support remove view directly.");
    }

    public void removeViewsInLayout(int i, int i2) {
        throw new UnsupportedOperationException("ScreenView doesn't support remove view directly.");
    }

    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("ScreenView doesn't support remove view directly.");
    }

    public void removeViews(int i, int i2) {
        throw new UnsupportedOperationException("ScreenView doesn't support remove view directly.");
    }

    public void removeAllViewsInLayout() {
        this.f4400l = 0;
        this.f4380L = 0;
        super.removeAllViewsInLayout();
    }

    protected void m6071a(View view, FrameLayout.LayoutParams layoutParams) {
        this.f4400l++;
        super.addView(view, -1, layoutParams);
    }

    protected void m6069a(View view) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild < getScreenCount()) {
            throw new InvalidParameterException("The view passed through the parameter must be indicator.");
        }
        this.f4400l--;
        super.removeViewAt(indexOfChild);
    }

    public void setAllowLongPress(boolean z) {
        this.f4385Q = z;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        int screenCount = getScreenCount();
        for (int i = 0; i < screenCount; i++) {
            getChildAt(i).setOnLongClickListener(onLongClickListener);
        }
    }

    private ImageView m6062g() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(this.f4405q);
        return imageView;
    }

    private void m6047b(int i, int i2) {
        int i3 = 0;
        if (this.f4408t != null) {
            int screenCount = getScreenCount();
            int i4 = 0;
            while (i4 < this.f4393b && i + i4 < screenCount) {
                this.f4408t.getChildAt(i + i4).setSelected(false);
                i4++;
            }
            while (i3 < this.f4393b && i2 + i3 < screenCount) {
                this.f4408t.getChildAt(i2 + i3).setSelected(true);
                i3++;
            }
        }
    }

    public int getScreenTransitionType() {
        return this.ac;
    }

    public void setScreenTransitionType(int i) {
        if (i != this.ac) {
            this.ac = i;
            switch (this.ac) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    setOvershootTension(1.3f);
                    setScreenSnapDuration(300);
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    setOvershootTension(0.0f);
                    setScreenSnapDuration(270);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    setOvershootTension(1.3f);
                    setScreenSnapDuration(300);
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    setOvershootTension(0.0f);
                    setScreenSnapDuration(330);
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    setOvershootTension(0.0f);
                    setScreenSnapDuration(330);
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    setOvershootTension(0.0f);
                    setScreenSnapDuration(270);
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    setOvershootTension(1.3f);
                    setScreenSnapDuration(330);
                default:
            }
        }
    }

    protected void m6075b(View view) {
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setRotation(0.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        m6049b(view, this.f4398j);
    }

    private void m6052c(View view) {
        if (!(view instanceof Indicator)) {
            float measuredWidth = (float) view.getMeasuredWidth();
            float measuredHeight = (float) view.getMeasuredHeight();
            float f = measuredWidth / 2.0f;
            float f2 = measuredHeight / 2.0f;
            float measuredWidth2 = ((((((float) getMeasuredWidth()) / 2.0f) + ((float) getScrollX())) - ((float) view.getLeft())) - f) / measuredWidth;
            switch (this.ac) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    m6075b(view);
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    m6075b(view);
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (measuredWidth2 == 0.0f || Math.abs(measuredWidth2) > 1.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(((1.0f - Math.abs(measuredWidth2)) * 0.7f) + 0.3f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    view.setPivotX(0.0f);
                    view.setPivotY(0.0f);
                    view.setRotation(0.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(0.0f);
                    m6049b(view, this.f4398j);
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    if (measuredWidth2 == 0.0f || Math.abs(measuredWidth2) > 1.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    view.setPivotX(f);
                    view.setPivotY(measuredHeight);
                    view.setRotation((-measuredWidth2) * 30.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(0.0f);
                    m6049b(view, this.f4398j);
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    if (measuredWidth2 == 0.0f || Math.abs(measuredWidth2) > 1.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    if (measuredWidth2 < 0.0f) {
                        measuredWidth = 0.0f;
                    }
                    view.setPivotX(measuredWidth);
                    view.setPivotY(f2);
                    view.setRotation(0.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(-90.0f * measuredWidth2);
                    m6049b(view, 5000.0f);
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    if (measuredWidth2 == 0.0f || Math.abs(measuredWidth2) > 1.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(1.0f - Math.abs(measuredWidth2));
                    view.setTranslationY(0.0f);
                    view.setTranslationX((measuredWidth * measuredWidth2) - ((measuredWidth * Math.abs(measuredWidth2)) * 0.3f));
                    measuredWidth = (0.3f * measuredWidth2) + 1.0f;
                    view.setScaleX(measuredWidth);
                    view.setScaleY(measuredWidth);
                    view.setPivotX(0.0f);
                    view.setPivotY(f2);
                    view.setRotation(0.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(45.0f * (-measuredWidth2));
                    m6049b(view, 5000.0f);
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    if (measuredWidth2 <= 0.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(1.0f - measuredWidth2);
                    measuredWidth2 = ((1.0f - measuredWidth2) * 0.4f) + 0.6f;
                    view.setTranslationX((measuredWidth * (1.0f - measuredWidth2)) * 3.0f);
                    view.setTranslationY(((1.0f - measuredWidth2) * measuredHeight) * 0.5f);
                    view.setScaleX(measuredWidth2);
                    view.setScaleY(measuredWidth2);
                    view.setPivotX(0.0f);
                    view.setPivotY(0.0f);
                    view.setRotation(0.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(0.0f);
                    m6049b(view, this.f4398j);
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    if (measuredWidth2 == 0.0f || Math.abs(measuredWidth2) > 1.0f) {
                        m6075b(view);
                        return;
                    }
                    view.setAlpha(1.0f - Math.abs(measuredWidth2));
                    view.setTranslationX(measuredWidth * measuredWidth2);
                    view.setTranslationY(0.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    view.setPivotX(f);
                    view.setPivotY(f2);
                    view.setRotation(0.0f);
                    view.setRotationX(0.0f);
                    view.setRotationY(90.0f * (-measuredWidth2));
                    m6049b(view, 5000.0f);
                case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                    m6070a(view, measuredWidth2);
                default:
            }
        }
    }

    protected void m6070a(View view, float f) {
    }

    protected void m6068a(ScaleGestureDetector scaleGestureDetector) {
    }

    protected void m6074b(ScaleGestureDetector scaleGestureDetector) {
    }

    protected void m6063a() {
        this.f4384P = true;
        m6039a(null, 0);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4355a = this.f4395d;
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f4355a != -1) {
            setCurrentScreen(savedState.f4355a);
        }
    }

    private void m6049b(View view, float f) {
        if (view.getCameraDistance() != f) {
            view.setCameraDistance(f);
        }
    }
}
