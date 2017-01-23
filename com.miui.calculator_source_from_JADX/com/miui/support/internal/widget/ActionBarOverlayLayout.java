package com.miui.support.internal.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar;
import com.miui.support.app.OnStatusBarChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.SwipeBackDelegate;
import com.miui.support.internal.app.SwipeBackDelegate.SwipeBackListener;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_App_Activity_class.Factory;
import com.miui.support.internal.view.menu.ContextMenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuDialogHelper;
import com.miui.support.internal.view.menu.MenuPresenter;
import com.miui.support.util.AttributeResolver;
import com.miui.support.view.SearchActionMode;

public class ActionBarOverlayLayout extends FrameLayout {
    private Rect f2908A;
    private Rect f2909B;
    private Rect f2910C;
    private Rect f2911D;
    private Rect f2912E;
    private ContextMenuBuilder f2913F;
    private MenuDialogHelper f2914G;
    private ContextMenuCallback f2915H;
    private OnStatusBarChangeListener f2916I;
    private SwipeBackDelegate f2917J;
    private boolean f2918K;
    protected ActionBarView f2919a;
    protected ActionBarContainer f2920b;
    protected View f2921c;
    private ActionBar f2922d;
    private ActionBarContainer f2923e;
    private ActionBarContextView f2924f;
    private View f2925g;
    private ActionMode f2926h;
    private Callback f2927i;
    private boolean f2928j;
    private boolean f2929k;
    private boolean f2930l;
    private boolean f2931m;
    private Drawable f2932n;
    private int f2933o;
    private Paint f2934p;
    private Bitmap f2935q;
    private Bitmap f2936r;
    private Bitmap f2937s;
    private Bitmap f2938t;
    private TypedValue f2939u;
    private TypedValue f2940v;
    private TypedValue f2941w;
    private TypedValue f2942x;
    private boolean f2943y;
    private Rect f2944z;

    /* renamed from: com.miui.support.internal.widget.ActionBarOverlayLayout.1 */
    class C03741 implements SwipeBackListener {
        final /* synthetic */ Activity f2967a;
        final /* synthetic */ ActionBarOverlayLayout f2968b;

        C03741(ActionBarOverlayLayout actionBarOverlayLayout, Activity activity) {
            this.f2968b = actionBarOverlayLayout;
            this.f2967a = activity;
        }

        public void m4696a() {
            Factory.getInstance().get().convertToTranslucent(this.f2967a);
        }

        public void m4697b() {
            Factory.getInstance().get().convertFromTranslucent(this.f2967a);
        }
    }

    private class ActionModeCallbackWrapper implements ActionMode.Callback {
        final /* synthetic */ ActionBarOverlayLayout f2969a;
        private ActionMode.Callback f2970b;

        public ActionModeCallbackWrapper(ActionBarOverlayLayout actionBarOverlayLayout, ActionMode.Callback callback) {
            this.f2969a = actionBarOverlayLayout;
            this.f2970b = callback;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f2970b.onCreateActionMode(actionMode, menu);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f2970b.onPrepareActionMode(actionMode, menu);
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f2970b.onActionItemClicked(actionMode, menuItem);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.f2970b.onDestroyActionMode(actionMode);
            if (this.f2969a.getCallback() != null) {
                this.f2969a.getCallback().onActionModeFinished(actionMode);
            }
            this.f2969a.f2926h = null;
        }
    }

    public class ContentMaskAnimator implements AnimatorListener {
        final /* synthetic */ ActionBarOverlayLayout f2971a;
        private ObjectAnimator f2972b;
        private ObjectAnimator f2973c;
        private OnClickListener f2974d;

        private ContentMaskAnimator(ActionBarOverlayLayout actionBarOverlayLayout, OnClickListener onClickListener) {
            this.f2971a = actionBarOverlayLayout;
            this.f2974d = onClickListener;
            this.f2972b = ObjectAnimator.ofFloat(actionBarOverlayLayout.f2925g, "alpha", new float[]{0.0f, 1.0f});
            this.f2972b.addListener(this);
            this.f2973c = ObjectAnimator.ofFloat(actionBarOverlayLayout.f2925g, "alpha", new float[]{1.0f, 0.0f});
            this.f2973c.addListener(this);
            if (!DeviceHelper.f2553e) {
                this.f2972b.setDuration(0);
                this.f2973c.setDuration(0);
            }
        }

        public Animator m4698a() {
            return this.f2972b;
        }

        public Animator m4699b() {
            return this.f2973c;
        }

        public void onAnimationStart(Animator animator) {
            if (animator == this.f2972b) {
                this.f2971a.f2925g.setVisibility(0);
                this.f2971a.f2925g.bringToFront();
                this.f2971a.f2923e.bringToFront();
                this.f2971a.f2925g.setOnClickListener(this.f2974d);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f2971a.f2925g.getAlpha() == 0.0f) {
                this.f2971a.f2923e.bringToFront();
                this.f2971a.f2925g.setOnClickListener(null);
                this.f2971a.f2925g.setVisibility(8);
            }
        }

        public void onAnimationCancel(Animator animator) {
            if (animator == this.f2973c) {
                this.f2971a.f2923e.bringToFront();
                this.f2971a.f2925g.setOnClickListener(null);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    private class ContextMenuCallback implements MenuBuilder.Callback, MenuPresenter.Callback {
        final /* synthetic */ ActionBarOverlayLayout f2975a;
        private MenuDialogHelper f2976b;

        private ContextMenuCallback(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f2975a = actionBarOverlayLayout;
        }

        public void m4701a(MenuBuilder menuBuilder) {
            if (m4700a() != null) {
                m4700a().onPanelClosed(6, menuBuilder.m4449n());
            }
        }

        Activity m4700a() {
            Context context = this.f2975a.getRootView().getContext();
            return context instanceof Activity ? (Activity) context : null;
        }

        public void m4703b(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder.m4449n() != menuBuilder) {
                m4701a(menuBuilder);
            }
            if (z) {
                if (m4700a() != null) {
                    m4700a().onPanelClosed(6, menuBuilder);
                }
                this.f2975a.m4674h();
                if (this.f2976b != null) {
                    this.f2976b.m4293a();
                    this.f2976b = null;
                }
            }
        }

        public boolean m4704b(MenuBuilder menuBuilder) {
            if (menuBuilder == null) {
                return false;
            }
            menuBuilder.m4420a((MenuBuilder.Callback) this);
            this.f2976b = new MenuDialogHelper(menuBuilder);
            this.f2976b.m4294a(null);
            return true;
        }

        public boolean m4702a(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (m4700a() != null) {
                return m4700a().onMenuItemSelected(6, menuItem);
            }
            return false;
        }

        public void m4705c(MenuBuilder menuBuilder) {
        }
    }

    private class SearchActionModeCallbackWrapper extends ActionModeCallbackWrapper implements SearchActionMode.Callback {
        final /* synthetic */ ActionBarOverlayLayout f2977b;

        public SearchActionModeCallbackWrapper(ActionBarOverlayLayout actionBarOverlayLayout, ActionMode.Callback callback) {
            this.f2977b = actionBarOverlayLayout;
            super(actionBarOverlayLayout, callback);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2929k = true;
        this.f2944z = new Rect();
        this.f2908A = new Rect();
        this.f2909B = new Rect();
        this.f2910C = new Rect();
        this.f2911D = new Rect();
        this.f2912E = new Rect();
        this.f2915H = new ContextMenuCallback();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.Window, i, 0);
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedWidthMajor)) {
            this.f2939u = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedWidthMajor, this.f2939u);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedWidthMinor)) {
            this.f2940v = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedWidthMinor, this.f2940v);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedHeightMajor)) {
            this.f2941w = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedHeightMajor, this.f2941w);
        }
        if (obtainStyledAttributes.hasValue(C0264R.styleable.Window_windowFixedHeightMinor)) {
            this.f2942x = new TypedValue();
            obtainStyledAttributes.getValue(C0264R.styleable.Window_windowFixedHeightMinor, this.f2942x);
        }
        this.f2931m = obtainStyledAttributes.getBoolean(C0234R.styleable.Window_contentAutoFitSystemWindow, false);
        if (this.f2931m) {
            this.f2932n = obtainStyledAttributes.getDrawable(C0234R.styleable.Window_contentHeaderBackground);
        }
        obtainStyledAttributes.recycle();
    }

    public void setupSwipeBack(Activity activity) {
        if (this.f2917J == null) {
            this.f2917J = new SwipeBackDelegate(activity, this);
        }
        activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setBackground(AttributeResolver.m5320b(activity, 16842836));
        setSwipeBackListener(new C03741(this, activity));
    }

    public void m4677a(Activity activity) {
        this.f2917J = null;
        activity.getWindow().setBackgroundDrawable(AttributeResolver.m5320b(activity, 16842836));
        setBackground(null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (m4673e() && m4678f()) {
            super.setBackgroundDrawable(AttributeResolver.m5320b(getContext(), 16842836));
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    public boolean showContextMenuForChild(View view) {
        if (this.f2913F == null) {
            this.f2913F = new ContextMenuBuilder(getContext());
            this.f2913F.m4420a(this.f2915H);
        } else {
            this.f2913F.clear();
        }
        this.f2914G = this.f2913F.m4453a(view, view.getWindowToken());
        if (this.f2914G == null) {
            return super.showContextMenuForChild(view);
        }
        this.f2914G.m4295a(this.f2915H);
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        boolean z = true;
        if (this.f2916I != null) {
            this.f2916I.m3309a(rect.top);
        }
        this.f2910C.set(rect);
        if (!m4678f()) {
            this.f2910C.bottom = 0;
        }
        if (this.f2920b != null) {
            if (m4679g()) {
                this.f2920b.setPendingInsets(rect);
            }
            View view = this.f2920b;
            Rect rect2 = this.f2910C;
            boolean z2 = m4678f() && !m4679g();
            a = m4666a(view, rect2, true, z2, false, true);
        } else {
            a = false;
        }
        if (this.f2923e != null) {
            a |= m4666a(this.f2923e, this.f2910C, true, false, true, true);
        }
        m4663a(this.f2910C, this.f2944z);
        if (this.f2908A.equals(this.f2944z)) {
            z = a;
        } else {
            this.f2908A.set(this.f2944z);
        }
        if (z) {
            requestLayout();
        }
        return m4678f();
    }

    private void m4663a(Rect rect, Rect rect2) {
        boolean f = m4678f();
        boolean g = m4679g();
        rect2.set(rect);
        if ((!f || g) && !this.f2931m) {
            rect2.top = 0;
        }
    }

    private boolean m4666a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestFitSystemWindows();
    }

    public void requestFitSystemWindows() {
        super.requestFitSystemWindows();
        this.f2930l = true;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        m4669b();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        LayoutParams layoutParams;
        int i5;
        int a = m4659a(i);
        int b = m4667b(i2);
        View view = this.f2921c;
        View view2 = this.f2925g;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < getChildCount()) {
            int i10;
            View childAt = getChildAt(i6);
            if (childAt == view || childAt == view2) {
                i3 = i7;
                i4 = i8;
                i10 = i9;
            } else if (childAt.getVisibility() == 8) {
                i3 = i7;
                i4 = i8;
                i10 = i9;
            } else {
                measureChildWithMargins(childAt, a, 0, b, 0);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                i8 = Math.max(i8, (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
                i5 = i9;
                i9 = Math.max(i5, layoutParams.bottomMargin + (childAt.getMeasuredHeight() + layoutParams.topMargin));
                i3 = combineMeasuredStates(i7, childAt.getMeasuredState());
                i4 = i8;
                i10 = i9;
            }
            i6++;
            i7 = i3;
            i8 = i4;
            i9 = i10;
        }
        if (this.f2920b == null || this.f2920b.getVisibility() != 0) {
            i3 = 0;
        } else {
            i3 = this.f2920b.getMeasuredHeight();
        }
        if (this.f2919a == null || !this.f2919a.m4760j()) {
            i4 = 0;
        } else {
            i4 = getBottomInset();
        }
        if (m4679g() && this.f2931m) {
            if (this.f2932n != null) {
                this.f2932n.setBounds(0, 0, getRight() - getLeft(), this.f2944z.top);
            } else {
                ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
                if (viewGroup != null && viewGroup.getChildCount() == 1) {
                    View childAt2 = viewGroup.getChildAt(0);
                    if (i3 <= 0) {
                        childAt2.setPadding(childAt2.getPaddingLeft(), this.f2910C.top, childAt2.getPaddingRight(), childAt2.getPaddingBottom());
                    } else {
                        childAt2.setPadding(childAt2.getPaddingLeft(), 0, childAt2.getPaddingRight(), childAt2.getPaddingBottom());
                    }
                }
            }
        }
        this.f2912E.set(this.f2910C);
        this.f2909B.set(this.f2944z);
        if (m4679g() && i3 > 0) {
            this.f2909B.top = 0;
        }
        if ((m4671c() || m4672d()) && i4 == 0) {
            this.f2909B.bottom = 0;
        }
        Rect rect;
        if (this.f2928j) {
            if (!m4679g()) {
                rect = this.f2912E;
                rect.top = i3 + rect.top;
            } else if (i3 > 0) {
                this.f2912E.top = i3;
            }
            rect = this.f2912E;
            rect.bottom += i4;
        } else {
            rect = this.f2909B;
            rect.top = i3 + rect.top;
            rect = this.f2909B;
            rect.bottom += i4;
        }
        m4666a(view, this.f2909B, true, true, true, true);
        if (!this.f2911D.equals(this.f2912E) || this.f2930l) {
            this.f2911D.set(this.f2912E);
            super.fitSystemWindows(this.f2912E);
            this.f2930l = false;
        }
        measureChildWithMargins(view, a, 0, b, 0);
        layoutParams = (LayoutParams) view.getLayoutParams();
        i6 = Math.max(i8, (view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i5 = i9;
        int max = Math.max(i5, layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = combineMeasuredStates(i7, view.getMeasuredState());
        if (view2 != null && view2.getVisibility() == 0) {
            measureChildWithMargins(view2, a, 0, b, 0);
        }
        setMeasuredDimension(resolveSizeAndState(Math.max((getPaddingLeft() + getPaddingRight()) + i6, getSuggestedMinimumWidth()), a, combineMeasuredStates), resolveSizeAndState(Math.max((getPaddingTop() + getPaddingBottom()) + max, getSuggestedMinimumHeight()), b, combineMeasuredStates << 16));
        this.f2943y = m4664a();
        if (this.f2943y && this.f2934p == null) {
            this.f2934p = new Paint();
            this.f2934p.setAntiAlias(true);
            this.f2934p.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
            Resources resources = getResources();
            this.f2935q = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_1);
            this.f2936r = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_2);
            this.f2937s = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_3);
            this.f2938t = BitmapFactory.decodeResource(resources, C0264R.drawable.popup_mask_4);
        }
    }

    private int m4659a(int i) {
        int i2 = 0;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            return i;
        }
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        TypedValue typedValue = (displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : 0) != 0 ? this.f2940v : this.f2939u;
        if (typedValue == null || typedValue.type == 0) {
            return i;
        }
        if (typedValue.type == 5) {
            i2 = (int) typedValue.getDimension(displayMetrics);
        } else if (typedValue.type == 6) {
            i2 = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
        }
        if (i2 > 0) {
            return MeasureSpec.makeMeasureSpec(Math.min(i2, size), 1073741824);
        }
        return i;
    }

    private int m4667b(int i) {
        int i2 = 0;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            return i;
        }
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        TypedValue typedValue = (displayMetrics.widthPixels < displayMetrics.heightPixels ? 1 : 0) != 0 ? this.f2941w : this.f2942x;
        if (typedValue == null || typedValue.type == 0) {
            return i;
        }
        if (typedValue.type == 5) {
            i2 = (int) typedValue.getDimension(displayMetrics);
        } else if (typedValue.type == 6) {
            i2 = (int) typedValue.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
        }
        if (i2 > 0) {
            return MeasureSpec.makeMeasureSpec(Math.min(i2, size), 1073741824);
        }
        return i;
    }

    public void computeScroll() {
        if (m4673e()) {
            this.f2917J.m3856a();
        } else {
            super.computeScroll();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.f2931m && this.f2932n != null) {
            this.f2932n.setBounds(0, 0, getRight() - getLeft(), this.f2944z.top);
            this.f2932n.draw(canvas);
        }
        if (this.f2943y) {
            canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            super.dispatchDraw(canvas);
            canvas.drawBitmap(this.f2935q, 0.0f, 0.0f, this.f2934p);
            canvas.drawBitmap(this.f2936r, (float) (getWidth() - this.f2936r.getWidth()), 0.0f, this.f2934p);
            canvas.drawBitmap(this.f2937s, 0.0f, (float) (getHeight() - this.f2937s.getHeight()), this.f2934p);
            canvas.drawBitmap(this.f2938t, (float) (getWidth() - this.f2938t.getWidth()), (float) (getHeight() - this.f2938t.getHeight()), this.f2934p);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    private boolean m4664a() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (iArr[0] == 0 || iArr[1] == 0 || iArr[0] + getMeasuredWidth() == displayMetrics.widthPixels || iArr[1] + getMeasuredHeight() == displayMetrics.heightPixels) {
            return false;
        }
        return true;
    }

    protected int getBottomInset() {
        return this.f2923e != null ? this.f2923e.getInsetHeight() : 0;
    }

    public ActionBar getActionBar() {
        return this.f2922d;
    }

    public void setActionBar(ActionBar actionBar) {
        this.f2922d = actionBar;
    }

    public void setOverlayMode(boolean z) {
        this.f2928j = z;
    }

    public View getContentView() {
        return this.f2921c;
    }

    public ContentMaskAnimator m4676a(OnClickListener onClickListener) {
        return new ContentMaskAnimator(onClickListener, null);
    }

    public ActionBarView getActionBarView() {
        return this.f2919a;
    }

    public Callback getCallback() {
        return this.f2927i;
    }

    public void setCallback(Callback callback) {
        this.f2927i = callback;
    }

    public void setTranslucentStatus(int i) {
        if (this.f2933o != i) {
            this.f2933o = i;
            requestFitSystemWindows();
        }
    }

    public void setContentView(View view) {
        this.f2921c = view;
    }

    private void m4669b() {
        if (this.f2921c == null) {
            this.f2921c = findViewById(16908290);
            this.f2925g = findViewById(C0264R.id.content_mask);
            if (DeviceHelper.f2560l && this.f2925g != null) {
                this.f2925g.setBackground(getContext().getResources().getDrawable(C0264R.drawable.window_content_mask_oled));
            }
            this.f2920b = (ActionBarContainer) findViewById(C0264R.id.action_bar_container);
            if (this.f2920b != null) {
                this.f2924f = (ActionBarContextView) this.f2920b.findViewById(C0264R.id.action_context_bar);
                this.f2919a = (ActionBarView) this.f2920b.findViewById(C0264R.id.action_bar);
            }
            this.f2923e = (ActionBarContainer) findViewById(C0264R.id.split_action_bar);
        }
    }

    public boolean m4678f() {
        return this.f2929k;
    }

    public boolean m4679g() {
        int windowSystemUiVisibility = getWindowSystemUiVisibility();
        boolean z = (windowSystemUiVisibility & 256) != 0;
        boolean z2;
        if ((windowSystemUiVisibility & 1024) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z3;
        if (this.f2933o != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((z && r0) || r3) {
            return true;
        }
        return false;
    }

    private boolean m4671c() {
        int windowSystemUiVisibility = getWindowSystemUiVisibility();
        boolean z = (windowSystemUiVisibility & 512) != 0;
        boolean z2;
        if ((windowSystemUiVisibility & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r2) {
            return true;
        }
        return false;
    }

    private boolean m4672d() {
        return (getWindowSystemUiVisibility() & 512) != 0;
    }

    public void setRootSubDecor(boolean z) {
        this.f2929k = z;
    }

    public void setSwipeBackListener(SwipeBackListener swipeBackListener) {
        this.f2917J.m3857a(swipeBackListener);
    }

    public void setSwipeBackEnabled(boolean z) {
        this.f2918K = z;
    }

    private boolean m4673e() {
        return this.f2918K && this.f2917J != null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (m4673e()) {
            return this.f2917J.m3858a(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m4673e()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f2917J.m3859b(motionEvent);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (!m4665a(keyEvent)) {
            return false;
        }
        if (this.f2926h != null) {
            if (this.f2924f != null && this.f2924f.m4650c()) {
                return true;
            }
            this.f2926h.finish();
            this.f2926h = null;
            return true;
        } else if (this.f2919a == null || !this.f2919a.m4753c()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m4665a(KeyEvent keyEvent) {
        return keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return m4675a(view, callback);
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode actionMode = null;
        if (this.f2926h != null) {
            this.f2926h.finish();
        }
        this.f2926h = null;
        if (getCallback() != null) {
            actionMode = getCallback().onWindowStartingActionMode(m4662a(callback));
        }
        if (actionMode != null) {
            this.f2926h = actionMode;
        }
        if (!(this.f2926h == null || getCallback() == null)) {
            getCallback().onActionModeStarted(this.f2926h);
        }
        return this.f2926h;
    }

    public ActionMode m4675a(View view, ActionMode.Callback callback) {
        if (!(view instanceof ActionBarOverlayLayout)) {
            return startActionMode(callback);
        }
        if (this.f2926h != null) {
            this.f2926h.finish();
        }
        this.f2926h = view.startActionMode(m4662a(callback));
        return this.f2926h;
    }

    private ActionModeCallbackWrapper m4662a(ActionMode.Callback callback) {
        if (callback instanceof SearchActionMode.Callback) {
            return new SearchActionModeCallbackWrapper(this, callback);
        }
        return new ActionModeCallbackWrapper(this, callback);
    }

    private void m4674h() {
        if (this.f2914G != null) {
            this.f2914G.m4293a();
            this.f2913F = null;
        }
    }

    public void setOnStatusBarChangeListener(OnStatusBarChangeListener onStatusBarChangeListener) {
        this.f2916I = onStatusBarChangeListener;
    }
}
