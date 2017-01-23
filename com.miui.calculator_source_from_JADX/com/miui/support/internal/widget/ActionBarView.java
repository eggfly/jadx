package com.miui.support.internal.widget;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.ActionBarDelegateImpl;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.view.ActionBarPolicy;
import com.miui.support.internal.view.menu.ActionMenuItem;
import com.miui.support.internal.view.menu.ActionMenuPresenter;
import com.miui.support.internal.view.menu.ActionMenuView;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuItemImpl;
import com.miui.support.internal.view.menu.MenuPresenter;
import com.miui.support.internal.view.menu.SubMenuBuilder;
import com.miui.support.util.ViewUtils;

public class ActionBarView extends AbsActionBarView {
    private LinearLayout f2995A;
    private ScrollingTabContainerView f2996B;
    private View f2997C;
    private ProgressBar f2998D;
    private ProgressBar f2999E;
    private View f3000F;
    private View f3001G;
    private View f3002H;
    private int f3003I;
    private int f3004J;
    private int f3005K;
    private int f3006L;
    private boolean f3007M;
    private boolean f3008N;
    private boolean f3009O;
    private boolean f3010P;
    private MenuBuilder f3011Q;
    private ActionMenuItem f3012R;
    private SpinnerAdapter f3013S;
    private OnNavigationListener f3014T;
    private ExpandedActionViewMenuPresenter f3015U;
    private final OnItemSelectedListener f3016V;
    private final OnClickListener f3017W;
    private final OnClickListener aa;
    View f3018g;
    Callback f3019h;
    private int f3020i;
    private int f3021j;
    private CharSequence f3022k;
    private CharSequence f3023l;
    private int f3024m;
    private Drawable f3025n;
    private Drawable f3026o;
    private Context f3027p;
    private final int f3028q;
    private Drawable f3029r;
    private int f3030s;
    private HomeView f3031t;
    private HomeView f3032u;
    private LinearLayout f3033v;
    private TextView f3034w;
    private TextView f3035x;
    private View f3036y;
    private Spinner f3037z;

    /* renamed from: com.miui.support.internal.widget.ActionBarView.1 */
    class C03751 implements OnItemSelectedListener {
        final /* synthetic */ ActionBarView f2978a;

        C03751(ActionBarView actionBarView) {
            this.f2978a = actionBarView;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f2978a.f3014T != null) {
                this.f2978a.f3014T.onNavigationItemSelected(i, j);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarView.2 */
    class C03762 implements OnClickListener {
        final /* synthetic */ ActionBarView f2979a;

        C03762(ActionBarView actionBarView) {
            this.f2979a = actionBarView;
        }

        public void onClick(View view) {
            MenuItemImpl menuItemImpl = this.f2979a.f3015U.f2986b;
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarView.3 */
    class C03773 implements OnClickListener {
        final /* synthetic */ ActionBarView f2980a;

        C03773(ActionBarView actionBarView) {
            this.f2980a = actionBarView;
        }

        public void onClick(View view) {
            this.f2980a.f3019h.onMenuItemSelected(0, this.f2980a.f3012R);
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarView.4 */
    class C03784 implements OnClickListener {
        final /* synthetic */ ActionBarDelegateImpl f2981a;
        final /* synthetic */ View f2982b;
        final /* synthetic */ ActionBarView f2983c;

        C03784(ActionBarView actionBarView, ActionBarDelegateImpl actionBarDelegateImpl, View view) {
            this.f2983c = actionBarView;
            this.f2981a = actionBarDelegateImpl;
            this.f2982b = view;
        }

        public void onClick(View view) {
            this.f2981a.m3618a(this.f2982b, this.f2983c);
        }
    }

    /* renamed from: com.miui.support.internal.widget.ActionBarView.5 */
    class C03795 implements Runnable {
        final /* synthetic */ ActionBarView f2984a;

        C03795(ActionBarView actionBarView) {
            this.f2984a = actionBarView;
        }

        public void run() {
            if (this.f2984a.f3033v != null) {
                Rect rect = new Rect();
                this.f2984a.f3033v.getHitRect(rect);
                rect.left -= this.f2984a.getResources().getDimensionPixelSize(C0264R.dimen.action_bar_horizontal_padding);
                this.f2984a.setTouchDelegate(new TouchDelegate(rect, this.f2984a.f3033v));
            }
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuBuilder f2985a;
        MenuItemImpl f2986b;
        final /* synthetic */ ActionBarView f2987c;

        private ExpandedActionViewMenuPresenter(ActionBarView actionBarView) {
            this.f2987c = actionBarView;
        }

        public void m4706a(Context context, MenuBuilder menuBuilder) {
            if (!(this.f2985a == null || this.f2986b == null)) {
                this.f2985a.m4438d(this.f2986b);
            }
            this.f2985a = menuBuilder;
        }

        public void m4711d(boolean z) {
            Object obj = null;
            if (this.f2986b != null) {
                if (this.f2985a != null) {
                    int size = this.f2985a.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f2985a.getItem(i) == this.f2986b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    m4710b(this.f2985a, this.f2986b);
                }
            }
        }

        public boolean m4709a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void m4707a(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean m4712e() {
            return false;
        }

        public boolean m4708a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            this.f2987c.f3018g = menuItemImpl.getActionView();
            this.f2987c.m4746w();
            this.f2987c.f3032u.m4715a(this.f2987c.getIcon().getConstantState().newDrawable(this.f2987c.getResources()));
            this.f2986b = menuItemImpl;
            if (this.f2987c.f3018g.getParent() != this.f2987c) {
                this.f2987c.addView(this.f2987c.f3018g);
            }
            if (this.f2987c.f3032u.getParent() != this.f2987c) {
                this.f2987c.addView(this.f2987c.f3032u);
            }
            if (this.f2987c.f3031t != null) {
                this.f2987c.f3031t.setVisibility(8);
            }
            if (this.f2987c.f3033v != null) {
                this.f2987c.f3033v.setVisibility(8);
            }
            if (this.f2987c.f2996B != null) {
                this.f2987c.f2996B.setVisibility(8);
            }
            if (this.f2987c.f3037z != null) {
                this.f2987c.f3037z.setVisibility(8);
            }
            if (this.f2987c.f2997C != null) {
                this.f2987c.f2997C.setVisibility(8);
            }
            this.f2987c.requestLayout();
            menuItemImpl.m4495e(true);
            if (this.f2987c.f3018g instanceof CollapsibleActionView) {
                ((CollapsibleActionView) this.f2987c.f3018g).onActionViewExpanded();
            }
            return true;
        }

        public boolean m4710b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (this.f2987c.f3018g instanceof CollapsibleActionView) {
                ((CollapsibleActionView) this.f2987c.f3018g).onActionViewCollapsed();
            }
            this.f2987c.removeView(this.f2987c.f3018g);
            this.f2987c.removeView(this.f2987c.f3032u);
            this.f2987c.f3018g = null;
            if ((this.f2987c.f3021j & 2) != 0) {
                this.f2987c.f3031t.setVisibility(0);
            }
            if ((this.f2987c.f3021j & 8) != 0) {
                if (this.f2987c.f3033v == null) {
                    this.f2987c.m4739p();
                } else {
                    this.f2987c.f3033v.setVisibility(0);
                }
            }
            if (this.f2987c.f2996B != null && this.f2987c.f3020i == 2) {
                this.f2987c.f2996B.setVisibility(0);
            }
            if (this.f2987c.f3037z != null && this.f2987c.f3020i == 1) {
                this.f2987c.f3037z.setVisibility(0);
            }
            if (!(this.f2987c.f2997C == null || (this.f2987c.f3021j & 16) == 0)) {
                this.f2987c.f2997C.setVisibility(0);
            }
            this.f2987c.f3032u.m4715a(null);
            this.f2986b = null;
            this.f2987c.requestLayout();
            menuItemImpl.m4495e(false);
            return true;
        }
    }

    private static class HomeView extends FrameLayout {
        private ImageView f2988a;
        private ImageView f2989b;
        private int f2990c;
        private int f2991d;
        private Drawable f2992e;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void m4716a(boolean z) {
            this.f2988a.setVisibility(z ? 0 : 8);
        }

        public void m4715a(Drawable drawable) {
            this.f2989b.setImageDrawable(drawable);
        }

        public void m4717b(Drawable drawable) {
            ImageView imageView = this.f2988a;
            if (drawable == null) {
                drawable = this.f2992e;
            }
            imageView.setImageDrawable(drawable);
            this.f2991d = 0;
        }

        public void m4714a(int i) {
            this.f2991d = i;
            this.f2988a.setImageDrawable(i != 0 ? getResources().getDrawable(i) : null);
        }

        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            if (this.f2991d != 0) {
                m4714a(this.f2991d);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            CharSequence contentDescription = getContentDescription();
            if (!TextUtils.isEmpty(contentDescription)) {
                accessibilityEvent.getText().add(contentDescription);
            }
            return true;
        }

        protected void onFinishInflate() {
            this.f2988a = (ImageView) findViewById(C0264R.id.up);
            this.f2989b = (ImageView) findViewById(C0264R.id.home);
            this.f2992e = this.f2988a.getDrawable();
        }

        public int m4713a() {
            return 0;
        }

        protected void onMeasure(int i, int i2) {
            measureChildWithMargins(this.f2988a, i, 0, i2, 0);
            LayoutParams layoutParams = (LayoutParams) this.f2988a.getLayoutParams();
            this.f2990c = (layoutParams.leftMargin + this.f2988a.getMeasuredWidth()) + layoutParams.rightMargin;
            int i3 = this.f2988a.getVisibility() == 8 ? 0 : this.f2990c;
            int measuredHeight = (layoutParams.topMargin + this.f2988a.getMeasuredHeight()) + layoutParams.bottomMargin;
            measureChildWithMargins(this.f2989b, i, i3, i2, 0);
            layoutParams = (LayoutParams) this.f2989b.getLayoutParams();
            int measuredWidth = i3 + ((layoutParams.leftMargin + this.f2989b.getMeasuredWidth()) + layoutParams.rightMargin);
            measuredHeight = Math.max(measuredHeight, layoutParams.bottomMargin + (layoutParams.topMargin + this.f2989b.getMeasuredHeight()));
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            switch (mode) {
                case Integer.MIN_VALUE:
                    size = Math.min(measuredWidth, size);
                    break;
                case 1073741824:
                    break;
                default:
                    size = measuredWidth;
                    break;
            }
            switch (mode2) {
                case Integer.MIN_VALUE:
                    size2 = Math.min(measuredHeight, size2);
                    break;
                case 1073741824:
                    break;
                default:
                    size2 = measuredHeight;
                    break;
            }
            setMeasuredDimension(size, size2);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth;
            int i5;
            int i6 = 0;
            int i7 = (i4 - i2) / 2;
            boolean a = ViewUtils.m5452a((View) this);
            if (this.f2988a.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) this.f2988a.getLayoutParams();
                int measuredHeight = this.f2988a.getMeasuredHeight();
                measuredWidth = this.f2988a.getMeasuredWidth();
                i5 = i7 - (measuredHeight / 2);
                ViewUtils.m5449a(this, this.f2988a, 0, i5, measuredWidth, i5 + measuredHeight);
                i6 = (layoutParams.leftMargin + measuredWidth) + layoutParams.rightMargin;
                if (a) {
                    i3 -= i6;
                } else {
                    i += i6;
                }
            }
            LayoutParams layoutParams2 = (LayoutParams) this.f2989b.getLayoutParams();
            int measuredHeight2 = this.f2989b.getMeasuredHeight();
            measuredWidth = this.f2989b.getMeasuredWidth();
            i6 += Math.max(layoutParams2.getMarginStart(), ((i3 - i) / 2) - (measuredWidth / 2));
            i5 = Math.max(layoutParams2.topMargin, i7 - (measuredHeight2 / 2));
            ViewUtils.m5449a(this, this.f2989b, i6, i5, measuredWidth + i6, measuredHeight2 + i5);
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f2993a;
        boolean f2994b;

        /* renamed from: com.miui.support.internal.widget.ActionBarView.SavedState.1 */
        final class C03801 implements Creator<SavedState> {
            C03801() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4718a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4719a(i);
            }

            public SavedState m4718a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m4719a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f2993a = parcel.readInt();
            this.f2994b = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2993a);
            parcel.writeInt(this.f2994b ? 1 : 0);
        }

        static {
            CREATOR = new C03801();
        }
    }

    public /* bridge */ /* synthetic */ boolean m4751a() {
        return super.m4612a();
    }

    public /* bridge */ /* synthetic */ void m4752b() {
        super.m4614b();
    }

    public /* bridge */ /* synthetic */ boolean m4753c() {
        return super.m4616c();
    }

    public /* bridge */ /* synthetic */ boolean m4754d() {
        return super.m4617d();
    }

    public /* bridge */ /* synthetic */ boolean m4755e() {
        return super.m4618e();
    }

    public /* bridge */ /* synthetic */ ActionMenuView getActionMenuView() {
        return super.getActionMenuView();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ ActionMenuView getMenuView() {
        return super.getMenuView();
    }

    public /* bridge */ /* synthetic */ void setContentHeight(int i) {
        super.setContentHeight(i);
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer actionBarContainer) {
        super.setSplitView(actionBarContainer);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean z) {
        super.setSplitWhenNarrow(z);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3021j = -1;
        this.f3016V = new C03751(this);
        this.f3017W = new C03762(this);
        this.aa = new C03773(this);
        this.f3027p = context;
        setBackgroundResource(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0234R.styleable.ActionBar, 16843470, 0);
        this.f3020i = obtainStyledAttributes.getInt(C0234R.styleable.ActionBar_android_navigationMode, 0);
        this.f3022k = obtainStyledAttributes.getText(C0234R.styleable.ActionBar_android_title);
        this.f3023l = obtainStyledAttributes.getText(C0234R.styleable.ActionBar_android_subtitle);
        this.f3010P = obtainStyledAttributes.getBoolean(C0264R.styleable.ActionBar_titleCenter, false);
        this.f3026o = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_android_logo);
        this.f3025n = obtainStyledAttributes.getDrawable(C0234R.styleable.ActionBar_android_icon);
        LayoutInflater from = LayoutInflater.from(context);
        this.f3028q = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionBar_android_homeLayout, C0264R.layout.action_bar_home);
        this.f3005K = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionBar_android_titleTextStyle, 0);
        this.f3006L = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionBar_android_subtitleTextStyle, 0);
        this.f3003I = obtainStyledAttributes.getDimensionPixelOffset(C0234R.styleable.ActionBar_android_progressBarPadding, 0);
        this.f3004J = obtainStyledAttributes.getDimensionPixelOffset(C0234R.styleable.ActionBar_android_itemPadding, 0);
        setDisplayOptions(obtainStyledAttributes.getInt(C0234R.styleable.ActionBar_android_displayOptions, 0));
        int resourceId = obtainStyledAttributes.getResourceId(C0234R.styleable.ActionBar_android_customNavigationLayout, 0);
        if (resourceId != 0) {
            this.f2997C = from.inflate(resourceId, this, false);
            this.f3020i = 0;
        }
        this.f = obtainStyledAttributes.getLayoutDimension(C0234R.styleable.ActionBar_android_height, 0);
        obtainStyledAttributes.recycle();
        this.f3012R = new ActionMenuItem(context, 0, 16908332, 0, 0, this.f3022k);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3034w = null;
        this.f3035x = null;
        this.f3036y = null;
        if (this.f3033v != null && this.f3033v.getParent() == this) {
            removeView(this.f3033v);
        }
        this.f3033v = null;
        if ((this.f3021j & 8) != 0) {
            m4739p();
        }
        if (this.f2996B != null && this.f3008N) {
            ViewGroup.LayoutParams layoutParams = this.f2996B.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
        }
    }

    public void setWindowCallback(Callback callback) {
        this.f3019h = callback;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.m4386e(false);
            this.b.m4380b();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void m4756f() {
        this.f2998D = new ProgressBar(this.f3027p, null, C0234R.attr.actionBarProgressStyle);
        this.f2998D.setId(C0264R.id.progress_horizontal);
        this.f2998D.setMax(10000);
        this.f2998D.setVisibility(8);
        addView(this.f2998D);
    }

    public void m4757g() {
        this.f2999E = new ProgressBar(this.f3027p, null, C0234R.attr.actionBarIndeterminateProgressStyle);
        this.f2999E.setId(C0264R.id.progress_circular);
        this.f2999E.setVisibility(8);
        this.f2999E.setIndeterminate(true);
        addView(this.f2999E);
    }

    public void m4749a(int i, ActionBarDelegateImpl actionBarDelegateImpl) {
        if (i <= 0) {
            Log.w("ActionBarView", "Try to initialize invalid layout for immersion more button: " + i);
        } else if ((this.f3021j & 16) != 0) {
            Log.d("ActionBarView", "Don't show immersion menu button for custom action bar");
        } else if (this.f3021j == 0) {
            Log.d("ActionBarView", "Don't show immersion menu button for null display option");
        } else {
            this.f3000F = LayoutInflater.from(getContext()).inflate(i, this, false);
            addView(this.f3000F);
            View findViewById = this.f3000F.findViewById(C0264R.id.more);
            if (findViewById != null) {
                findViewById.setOnClickListener(new C03784(this, actionBarDelegateImpl, findViewById));
            }
        }
    }

    public boolean m4758h() {
        if (this.f3000F == null) {
            return false;
        }
        this.f3000F.setVisibility(0);
        return true;
    }

    public boolean m4759i() {
        if (this.f3000F == null) {
            return false;
        }
        this.f3000F.setVisibility(8);
        return true;
    }

    public void setSplitActionBar(boolean z) {
        if (this.d != z) {
            if (this.a != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.a);
                }
                if (z) {
                    if (this.c != null) {
                        this.c.addView(this.a);
                    }
                    this.a.getLayoutParams().width = -1;
                } else {
                    addView(this.a);
                    this.a.getLayoutParams().width = -2;
                }
                this.a.requestLayout();
            }
            if (this.c != null) {
                this.c.setVisibility(z ? 0 : 8);
            }
            if (this.b != null) {
                if (z) {
                    this.b.m4379b(false);
                    this.b.m4370a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                } else {
                    this.b.m4379b(getResources().getBoolean(C0264R.bool.abc_action_bar_expanded_action_views_exclusive));
                }
            }
            super.setSplitActionBar(z);
        }
    }

    public boolean m4760j() {
        return this.d;
    }

    public int m4747a(boolean z) {
        if (z) {
            if (this.c != null) {
                return this.c.getCollapsedHeight();
            }
            return 0;
        } else if (this.d) {
            return this.c.getHeight();
        } else {
            return 0;
        }
    }

    public boolean m4761k() {
        return this.f3008N;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f2996B != null) {
            removeView(this.f2996B);
        }
        this.f2996B = scrollingTabContainerView;
        this.f3008N = scrollingTabContainerView != null;
        if (this.f3008N && this.f3020i == 2) {
            addView(this.f2996B);
            ViewGroup.LayoutParams layoutParams = this.f2996B.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            m4740q();
        }
    }

    public void setCallback(OnNavigationListener onNavigationListener) {
        this.f3014T = onNavigationListener;
    }

    public void m4750a(Menu menu, MenuPresenter.Callback callback) {
        if (menu != this.f3011Q) {
            ActionMenuView actionMenuView;
            if (this.f3011Q != null) {
                this.f3011Q.m4430b(this.b);
                this.f3011Q.m4430b(this.f3015U);
            }
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            this.f3011Q = menuBuilder;
            if (this.a != null) {
                ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.a);
                }
            }
            if (this.b == null) {
                this.b = m4748a(callback);
                this.f3015U = m4765o();
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -1);
            ViewGroup viewGroup2;
            if (this.d) {
                this.b.m4379b(false);
                this.b.m4370a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                layoutParams.width = -1;
                layoutParams.height = -2;
                layoutParams.gravity = DeviceHelper.f2555g ? 17 : 80;
                m4724a(menuBuilder);
                actionMenuView = (ActionMenuView) this.b.m4369a((ViewGroup) this);
                if (this.c != null) {
                    viewGroup2 = (ViewGroup) actionMenuView.getParent();
                    if (!(viewGroup2 == null || viewGroup2 == this.c)) {
                        viewGroup2.removeView(actionMenuView);
                    }
                    actionMenuView.setVisibility(getAnimatedVisibility());
                    this.c.addView(actionMenuView, 0, layoutParams);
                    View findViewById = actionMenuView.findViewById(C0264R.id.expanded_menu);
                    if (findViewById != null) {
                        findViewById.requestLayout();
                    }
                } else {
                    actionMenuView.setLayoutParams(layoutParams);
                }
            } else {
                this.b.m4379b(getResources().getBoolean(C0264R.bool.abc_action_bar_expanded_action_views_exclusive));
                m4724a(menuBuilder);
                actionMenuView = (ActionMenuView) this.b.m4369a((ViewGroup) this);
                viewGroup2 = (ViewGroup) actionMenuView.getParent();
                if (!(viewGroup2 == null || viewGroup2 == this)) {
                    viewGroup2.removeView(actionMenuView);
                }
                addView(actionMenuView, layoutParams);
            }
            this.a = actionMenuView;
        }
    }

    private void m4724a(MenuBuilder menuBuilder) {
        if (menuBuilder != null) {
            menuBuilder.m4422a(this.b);
            menuBuilder.m4422a(this.f3015U);
        } else {
            this.b.m4371a(this.f3027p, null);
            this.f3015U.m4706a(this.f3027p, null);
        }
        this.b.m4383d(true);
        this.f3015U.m4711d(true);
    }

    public boolean m4762l() {
        return (this.f3015U == null || this.f3015U.f2986b == null) ? false : true;
    }

    public void m4763m() {
        MenuItemImpl menuItemImpl = this.f3015U == null ? null : this.f3015U.f2986b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void setCustomNavigationView(View view) {
        Object obj = (this.f3021j & 16) != 0 ? 1 : null;
        if (!(this.f2997C == null || obj == null)) {
            removeView(this.f2997C);
        }
        this.f2997C = view;
        if (this.f2997C != null && obj != null) {
            addView(this.f2997C);
        }
    }

    public void setStartView(View view) {
        if (this.f3001G != null) {
            removeView(this.f3001G);
        }
        this.f3001G = view;
        if (this.f3001G != null) {
            addView(this.f3001G);
        }
    }

    public void setEndView(View view) {
        if (this.f3002H != null) {
            removeView(this.f3002H);
        }
        this.f3002H = view;
        if (this.f3002H != null) {
            addView(this.f3002H);
        }
    }

    public CharSequence getTitle() {
        return this.f3022k;
    }

    public void setTitle(CharSequence charSequence) {
        this.f3007M = true;
        setTitleImpl(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f3007M) {
            setTitleImpl(charSequence);
        }
    }

    private void setTitleImpl(CharSequence charSequence) {
        int i = 0;
        this.f3022k = charSequence;
        if (this.f3034w != null) {
            this.f3034w.setText(charSequence);
            int i2 = (this.f3018g != null || (this.f3021j & 8) == 0 || (TextUtils.isEmpty(this.f3022k) && TextUtils.isEmpty(this.f3023l))) ? 0 : 1;
            LinearLayout linearLayout = this.f3033v;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
        if (this.f3012R != null) {
            this.f3012R.setTitle(charSequence);
        }
    }

    public CharSequence getSubtitle() {
        return this.f3023l;
    }

    public void setSubtitle(CharSequence charSequence) {
        int i = 0;
        this.f3023l = charSequence;
        if (this.f3035x != null) {
            int i2;
            this.f3035x.setText(charSequence);
            this.f3035x.setVisibility(charSequence != null ? 0 : 8);
            if (this.f3018g != null || (this.f3021j & 8) == 0 || (TextUtils.isEmpty(this.f3022k) && TextUtils.isEmpty(this.f3023l))) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            LinearLayout linearLayout = this.f3033v;
            if (i2 == 0) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void setHomeButtonEnabled(boolean z) {
        if (this.f3031t != null) {
            this.f3031t.setEnabled(z);
            this.f3031t.setFocusable(z);
            if (!z) {
                this.f3031t.setContentDescription(null);
            } else if ((this.f3021j & 4) != 0) {
                this.f3031t.setContentDescription(this.f3027p.getResources().getText(C0264R.string.abc_action_bar_up_description));
            } else {
                this.f3031t.setContentDescription(this.f3027p.getResources().getText(C0264R.string.abc_action_bar_home_description));
            }
        }
    }

    public void setDisplayOptions(int i) {
        int i2 = 8;
        int i3 = -1;
        boolean z = true;
        if (this.f3021j != -1) {
            i3 = this.f3021j ^ i;
        }
        this.f3021j = i;
        if ((i3 & 31) != 0) {
            boolean z2;
            boolean z3;
            if ((i & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int i4;
                m4745v();
                HomeView homeView = this.f3031t;
                if (this.f3018g == null) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                homeView.setVisibility(i4);
                if ((i3 & 4) != 0) {
                    if ((i & 4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    this.f3031t.m4716a(z3);
                    if (z3) {
                        setHomeButtonEnabled(true);
                    }
                }
                if ((i3 & 1) != 0) {
                    Drawable logo = getLogo();
                    z3 = (logo == null || (i & 1) == 0) ? false : true;
                    this.f3031t.m4715a(z3 ? logo : getIcon());
                }
            } else if (this.f3031t != null) {
                removeView(this.f3031t);
            }
            if ((i3 & 8) != 0) {
                if ((i & 8) != 0) {
                    m4739p();
                } else {
                    removeView(this.f3033v);
                }
            }
            if (!(this.f3033v == null || (i3 & 6) == 0)) {
                if ((this.f3021j & 4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                View view = this.f3036y;
                if (!z2) {
                    i2 = z3 ? 0 : 4;
                }
                view.setVisibility(i2);
                LinearLayout linearLayout = this.f3033v;
                if (z2 || !z3) {
                    z = false;
                }
                linearLayout.setEnabled(z);
            }
            if (!((i3 & 16) == 0 || this.f2997C == null)) {
                if ((i & 16) != 0) {
                    addView(this.f2997C);
                } else {
                    removeView(this.f2997C);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        if (this.f3031t == null) {
            return;
        }
        if (!this.f3031t.isEnabled()) {
            this.f3031t.setContentDescription(null);
        } else if ((i & 4) != 0) {
            this.f3031t.setContentDescription(this.f3027p.getResources().getText(C0264R.string.abc_action_bar_up_description));
        } else {
            this.f3031t.setContentDescription(this.f3027p.getResources().getText(C0264R.string.abc_action_bar_home_description));
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3025n = drawable;
        this.f3024m |= 1;
        if (drawable != null && (((this.f3021j & 1) == 0 || getLogo() == null) && this.f3031t != null)) {
            this.f3031t.m4715a(drawable);
        }
        if (this.f3018g != null) {
            this.f3032u.m4715a(this.f3025n.getConstantState().newDrawable(getResources()));
        }
    }

    public void setIcon(int i) {
        setIcon(this.f3027p.getResources().getDrawable(i));
    }

    public void setLogo(Drawable drawable) {
        this.f3026o = drawable;
        this.f3024m |= 2;
        if (drawable != null && (this.f3021j & 1) != 0 && this.f3031t != null) {
            this.f3031t.m4715a(drawable);
        }
    }

    public void setLogo(int i) {
        setLogo(this.f3027p.getResources().getDrawable(i));
    }

    public void setNavigationMode(int i) {
        int i2 = this.f3020i;
        if (i != i2) {
            switch (i2) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f2995A != null) {
                        removeView(this.f2995A);
                        break;
                    }
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (this.f2996B != null && this.f3008N) {
                        removeView(this.f2996B);
                        break;
                    }
            }
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f3037z == null) {
                        this.f3037z = new Spinner(this.f3027p, null, 16843479);
                        this.f2995A = (LinearLayout) LayoutInflater.from(this.f3027p).inflate(C0264R.layout.action_bar_view_list_nav_layout, null);
                        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams.gravity = 17;
                        this.f2995A.addView(this.f3037z, layoutParams);
                    }
                    if (this.f3037z.getAdapter() != this.f3013S) {
                        this.f3037z.setAdapter(this.f3013S);
                    }
                    this.f3037z.setOnItemSelectedListener(this.f3016V);
                    addView(this.f2995A);
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (this.f2996B != null && this.f3008N) {
                        addView(this.f2996B);
                        break;
                    }
            }
            this.f3020i = i;
            requestLayout();
        }
    }

    public void setDropdownAdapter(SpinnerAdapter spinnerAdapter) {
        this.f3013S = spinnerAdapter;
        if (this.f3037z != null) {
            this.f3037z.setAdapter(spinnerAdapter);
        }
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.f3013S;
    }

    public void setDropdownSelectedPosition(int i) {
        this.f3037z.setSelection(i);
    }

    public int getDropdownSelectedPosition() {
        return this.f3037z.getSelectedItemPosition();
    }

    public View getCustomNavigationView() {
        return this.f2997C;
    }

    public int getNavigationMode() {
        return this.f3020i;
    }

    public int getDisplayOptions() {
        return this.f3021j;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ActionBar.LayoutParams(8388627);
    }

    private void m4739p() {
        boolean z = true;
        if (this.f3033v == null) {
            boolean z2;
            this.f3033v = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0264R.layout.action_bar_title_item, this, false);
            this.f3034w = (TextView) this.f3033v.findViewById(C0264R.id.action_bar_title);
            this.f3035x = (TextView) this.f3033v.findViewById(C0264R.id.action_bar_subtitle);
            this.f3036y = this.f3033v.findViewById(C0264R.id.up);
            this.f3033v.setOnClickListener(this.aa);
            if (this.f3005K != 0) {
                this.f3034w.setTextAppearance(this.f3027p, this.f3005K);
            }
            if (this.f3022k != null) {
                this.f3034w.setText(this.f3022k);
            }
            if (this.f3006L != 0) {
                this.f3035x.setTextAppearance(this.f3027p, this.f3006L);
            }
            if (this.f3023l != null) {
                this.f3035x.setText(this.f3023l);
                this.f3035x.setVisibility(0);
            }
            boolean z3 = (this.f3021j & 4) != 0;
            if ((this.f3021j & 2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            View view = this.f3036y;
            int i = !z2 ? z3 ? 0 : 4 : 8;
            view.setVisibility(i);
            LinearLayout linearLayout = this.f3033v;
            if (!z3 || z2) {
                z = false;
            }
            linearLayout.setEnabled(z);
            m4740q();
        }
        addView(this.f3033v);
        post(new C03795(this));
        if (this.f3018g != null || (TextUtils.isEmpty(this.f3022k) && TextUtils.isEmpty(this.f3023l))) {
            this.f3033v.setVisibility(8);
        }
    }

    public void setCollapsable(boolean z) {
    }

    public boolean m4764n() {
        return this.f3009O;
    }

    private void m4740q() {
        int i = (m4761k() && ActionBarPolicy.m4264a(this.f3027p).m4269e()) ? 8 : 0;
        if (this.f3034w != null && this.f3034w.getVisibility() == 0) {
            this.f3034w.setVisibility(i);
        }
        if (this.f3035x != null && this.f3035x.getVisibility() == 0) {
            this.f3035x.setVisibility(i);
        }
    }

    private boolean m4741r() {
        if (this.f2997C == null || this.f2997C.getVisibility() != 0) {
            return true;
        }
        ViewGroup.LayoutParams layoutParams = this.f2997C.getLayoutParams();
        ActionBar.LayoutParams layoutParams2 = layoutParams instanceof ActionBar.LayoutParams ? (ActionBar.LayoutParams) layoutParams : null;
        boolean z = layoutParams2 == null ? false : m4720a(layoutParams2.gravity, ViewUtils.m5452a((View) this)) == 8388613;
        return z;
    }

    private boolean m4742s() {
        return this.f3010P && this.f3036y.getVisibility() != 0 && m4741r() && ((this.f3031t == null || this.f3031t.getVisibility() == 8) && !m4761k());
    }

    private boolean m4743t() {
        return (this.f3033v == null || this.f3033v.getVisibility() == 8 || (this.f3021j & 8) == 0) ? false : true;
    }

    private void m4744u() {
        int i;
        int i2 = 1;
        boolean s = m4742s();
        ViewGroup viewGroup = (ViewGroup) this.f3034w.getParent();
        if (viewGroup instanceof LinearLayout) {
            ((LinearLayout) viewGroup).setGravity((s ? 1 : 8388611) | 16);
        }
        TextView textView = this.f3034w;
        if (s) {
            i = 1;
        } else {
            i = 8388611;
        }
        textView.setGravity(i | 16);
        this.f3034w.setEllipsize(s ? TruncateAt.MIDDLE : TruncateAt.END);
        if (this.f3035x != null) {
            TextView textView2 = this.f3035x;
            if (!s) {
                i2 = 8388611;
            }
            textView2.setGravity(i2 | 16);
            this.f3035x.setEllipsize(s ? TruncateAt.MIDDLE : TruncateAt.END);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int childCount = getChildCount();
        int i4 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt.getVisibility() == 8 || (childAt == this.a && this.a.getChildCount() == 0))) {
                i4++;
            }
        }
        if (i4 == 0) {
            setMeasuredDimension(0, 0);
            this.f3009O = true;
            return;
        }
        int i5;
        HomeView homeView;
        int i6;
        View view;
        this.f3009O = false;
        int size = MeasureSpec.getSize(i);
        if (this.f > 0) {
            i5 = this.f;
        } else {
            i5 = MeasureSpec.getSize(i2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        i4 = getPaddingStart();
        i3 = getPaddingEnd();
        int i7 = i5 - paddingTop;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
        i4 = (size - i4) - i3;
        int i8 = i4 / 2;
        if (this.f3001G != null) {
            i4 = m4611a(this.f3001G, i4, makeMeasureSpec, 0);
        }
        if (this.f3002H != null) {
            i4 = m4611a(this.f3002H, i4, makeMeasureSpec, 0);
        }
        if (this.f3018g != null) {
            homeView = this.f3032u;
        } else {
            homeView = this.f3031t;
        }
        if (!(this.f3001G == null || homeView == null)) {
            homeView.setVisibility(8);
        }
        if (homeView == null || homeView.getVisibility() == 8) {
            i6 = i8;
        } else {
            ViewGroup.LayoutParams layoutParams = homeView.getLayoutParams();
            if (layoutParams.width < 0) {
                i6 = MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            } else {
                i6 = MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            homeView.measure(i6, MeasureSpec.makeMeasureSpec(i7, 1073741824));
            i6 = homeView.getMeasuredWidth() + homeView.m4713a();
            i3 = Math.max(0, i4 - i6);
            i6 = Math.max(0, i3 - i6);
            i4 = i3;
        }
        if (this.a != null && this.a.getParent() == this) {
            i4 = m4611a(this.a, i4, makeMeasureSpec, 0);
            i8 = Math.max(0, i8 - this.a.getMeasuredWidth());
        }
        if (!(this.f2999E == null || this.f2999E.getVisibility() == 8)) {
            i4 = m4611a(this.f2999E, i4, makeMeasureSpec, this.f3003I * 2);
            i8 = Math.max(0, (i8 - this.f2999E.getMeasuredWidth()) - (this.f3003I * 2));
        }
        if (this.f3000F == null || this.f3000F.getVisibility() == 8) {
            makeMeasureSpec = i4;
        } else {
            i4 = m4611a(this.f3000F, i4, makeMeasureSpec, 0);
            i8 = Math.max(0, i8 - this.f3000F.getMeasuredWidth());
            makeMeasureSpec = i4;
        }
        boolean t = m4743t();
        if (t) {
            m4744u();
        }
        if (this.f3018g != null) {
            view = this.f3018g;
        } else if ((this.f3021j & 16) == 0 || this.f2997C == null) {
            view = null;
        } else {
            view = this.f2997C;
        }
        if (!((this.f3001G == null && this.f3002H == null) || view == null)) {
            view.setVisibility(8);
        }
        if (!(view == null || view.getVisibility() == 8)) {
            ActionBar.LayoutParams layoutParams2;
            int min;
            ViewGroup.LayoutParams generateLayoutParams = generateLayoutParams(view.getLayoutParams());
            if (generateLayoutParams instanceof ActionBar.LayoutParams) {
                layoutParams2 = (ActionBar.LayoutParams) generateLayoutParams;
            } else {
                layoutParams2 = null;
            }
            int i9 = 0;
            i4 = 0;
            if (layoutParams2 != null) {
                i9 = layoutParams2.rightMargin + layoutParams2.leftMargin;
                i4 = layoutParams2.topMargin + layoutParams2.bottomMargin;
            }
            int i10 = this.f <= 0 ? Integer.MIN_VALUE : generateLayoutParams.height != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (generateLayoutParams.height >= 0) {
                min = Math.min(generateLayoutParams.height, i7);
            } else {
                min = i7;
            }
            int max = Math.max(0, min - i4);
            i4 = generateLayoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (generateLayoutParams.width >= 0) {
                min = Math.min(generateLayoutParams.width, makeMeasureSpec);
            } else {
                min = makeMeasureSpec;
            }
            min = Math.max(0, min - i9);
            if (((layoutParams2 != null ? layoutParams2.gravity : 8388627) & 8388615) == 1 && generateLayoutParams.width == -1) {
                i3 = Math.min(i6, i8) * 2;
            } else {
                i3 = min;
            }
            view.measure(MeasureSpec.makeMeasureSpec(i3, i4), MeasureSpec.makeMeasureSpec(max, i10));
            makeMeasureSpec -= view.getMeasuredWidth() + i9;
        }
        if (this.f3018g == null && t) {
            makeMeasureSpec = m4611a(this.f3033v, makeMeasureSpec, MeasureSpec.makeMeasureSpec(this.f, 1073741824), 0);
        }
        if (this.f3018g == null) {
            switch (this.f3020i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f2995A != null) {
                        this.f2995A.measure(MeasureSpec.makeMeasureSpec(Math.max(0, makeMeasureSpec - (t ? this.f3004J * 2 : this.f3004J)), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(i7, 1073741824));
                        break;
                    }
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    if (this.f2996B != null) {
                        this.f2996B.measure(MeasureSpec.makeMeasureSpec(Math.max(0, makeMeasureSpec - (t ? this.f3004J * 2 : this.f3004J)), this.f3027p.getResources().getInteger(C0264R.integer.action_bar_tab_layout_weight) == 0 ? Integer.MIN_VALUE : 1073741824), MeasureSpec.makeMeasureSpec(i7, 1073741824));
                        break;
                    }
                    break;
            }
        }
        if (this.f <= 0) {
            i3 = 0;
            i5 = 0;
            while (i5 < childCount) {
                i4 = getChildAt(i5).getMeasuredHeight() + paddingTop;
                if (i4 <= i3) {
                    i4 = i3;
                }
                i5++;
                i3 = i4;
            }
            setMeasuredDimension(size, i3);
        } else {
            setMeasuredDimension(size, i5);
        }
        if (this.f2998D != null && this.f2998D.getVisibility() != 8) {
            this.f2998D.measure(MeasureSpec.makeMeasureSpec(size - (this.f3003I * 2), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        boolean a = ViewUtils.m5452a((View) this);
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (paddingTop2 > 0) {
            int a2;
            int b;
            int measuredWidth;
            ViewGroup.LayoutParams layoutParams;
            int measuredWidth2;
            int i5;
            int i6;
            View view;
            View view2 = this.f3018g != null ? this.f3032u : this.f3031t;
            if (view2 != null && view2.getVisibility() != 8) {
                a2 = view2.m4713a();
                b = paddingStart + (m4613b(view2, paddingStart + a2, paddingTop, paddingTop2) + a2);
            } else if (this.f3001G != null) {
                b = paddingStart + m4613b(this.f3001G, paddingStart, paddingTop, paddingTop2);
            } else {
                b = paddingStart;
            }
            if (this.f3018g == null) {
                boolean t = m4743t();
                if (t) {
                    if (m4742s()) {
                        a2 = (getWidth() - this.f3034w.getMeasuredWidth()) / 2;
                        measuredWidth = this.f3036y.getMeasuredWidth();
                        layoutParams = this.f3036y.getLayoutParams();
                        if (layoutParams instanceof LinearLayout.LayoutParams) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                            measuredWidth = (layoutParams2.rightMargin + layoutParams2.leftMargin) + measuredWidth;
                        }
                        layoutParams = this.f3034w.getLayoutParams();
                        if (layoutParams instanceof LinearLayout.LayoutParams) {
                            measuredWidth += ((LinearLayout.LayoutParams) layoutParams).getMarginStart();
                        }
                        a2 -= measuredWidth;
                        measuredWidth2 = a2 + this.f3033v.getMeasuredWidth();
                        paddingStart = this.f3033v.getMeasuredHeight();
                        i5 = paddingTop + ((paddingTop2 - paddingStart) / 2);
                        ViewUtils.m5449a(this, this.f3033v, a2, i5, measuredWidth2, i5 + paddingStart);
                    } else {
                        b += m4613b(this.f3033v, b, paddingTop, paddingTop2);
                    }
                }
                switch (this.f3020i) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        if (this.f2995A != null) {
                            if (t) {
                                b += this.f3004J;
                            }
                            b += m4613b(this.f2995A, b, paddingTop, paddingTop2) + this.f3004J;
                            break;
                        }
                        break;
                    case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                        if (this.f2996B != null) {
                            if (t) {
                                b += this.f3004J;
                            }
                            a2 = this.f2996B.getMeasuredWidth();
                            measuredWidth2 = this.f2996B.getMeasuredHeight();
                            paddingStart = (getWidth() - a2) / 2;
                            measuredWidth = b > paddingStart ? b : paddingStart;
                            i5 = measuredWidth + a2;
                            paddingStart = 0;
                            if (this.f2997C != null) {
                                layoutParams = this.f2997C.getLayoutParams();
                                ActionBar.LayoutParams layoutParams3 = layoutParams instanceof ActionBar.LayoutParams ? (ActionBar.LayoutParams) layoutParams : null;
                                a2 = this.f2997C.getMeasuredWidth();
                                if (layoutParams3 != null) {
                                    paddingStart = (layoutParams3.rightMargin + layoutParams3.leftMargin) + a2;
                                } else {
                                    paddingStart = a2;
                                }
                            }
                            paddingStart = (getWidth() - getPaddingEnd()) - paddingStart;
                            if (i5 > paddingStart) {
                                if (paddingStart >= (measuredWidth + i5) / 2) {
                                    b = measuredWidth;
                                }
                                measuredWidth = paddingStart;
                                i5 = b;
                            } else {
                                i6 = i5;
                                i5 = measuredWidth;
                                measuredWidth = i6;
                            }
                            a2 = a ? getWidth() - measuredWidth : i5;
                            if (a) {
                                paddingStart = getWidth() - i5;
                            } else {
                                paddingStart = measuredWidth;
                            }
                            this.f2996B.layout(a2, paddingTop, paddingStart, measuredWidth2 + paddingTop);
                            b = measuredWidth;
                            break;
                        }
                        break;
                }
            }
            paddingStart = (i3 - i) - getPaddingEnd();
            if (this.a != null && this.a.getParent() == this) {
                m4615c(this.a, paddingStart, paddingTop, paddingTop2);
                paddingStart -= this.a.getMeasuredWidth();
            }
            if (this.f3002H != null) {
                m4615c(this.f3002H, paddingStart, paddingTop, paddingTop2);
                paddingStart -= this.f3002H.getMeasuredWidth();
            }
            if (!(this.f2999E == null || this.f2999E.getVisibility() == 8)) {
                m4615c(this.f2999E, paddingStart - this.f3003I, paddingTop, paddingTop2);
                paddingStart -= this.f2999E.getMeasuredWidth() - (this.f3003I * 2);
            }
            if (this.f3000F == null || this.f3000F.getVisibility() == 8) {
                measuredWidth = paddingStart;
            } else {
                m4615c(this.f3000F, paddingStart, paddingTop, paddingTop2);
                measuredWidth = paddingStart - this.f3000F.getMeasuredWidth();
            }
            if (this.f3018g != null) {
                view = this.f3018g;
            } else if ((this.f3021j & 16) == 0 || this.f2997C == null) {
                view = null;
            } else {
                view = this.f2997C;
            }
            if (!(view == null || view.getVisibility() == 8)) {
                int i7;
                layoutParams = view.getLayoutParams();
                ActionBar.LayoutParams layoutParams4 = layoutParams instanceof ActionBar.LayoutParams ? (ActionBar.LayoutParams) layoutParams : null;
                paddingStart = layoutParams4 != null ? layoutParams4.gravity : 8388627;
                paddingTop2 = view.getMeasuredWidth();
                if (layoutParams4 != null) {
                    b += layoutParams4.getMarginStart();
                    i5 = measuredWidth - layoutParams4.getMarginEnd();
                    a2 = layoutParams4.topMargin;
                    measuredWidth2 = layoutParams4.bottomMargin;
                    i7 = a2;
                    i6 = i5;
                    i5 = b;
                    b = i6;
                } else {
                    measuredWidth2 = 0;
                    i7 = 0;
                    i5 = b;
                    b = measuredWidth;
                }
                measuredWidth = 8388615 & paddingStart;
                if (measuredWidth == 1) {
                    a2 = (getWidth() - paddingTop2) / 2;
                    if (a2 < i5) {
                        measuredWidth = 8388611;
                    } else if (a2 + paddingTop2 > b) {
                        measuredWidth = 8388613;
                    }
                } else if (paddingStart == -1) {
                    measuredWidth = 8388611;
                }
                a2 = getPaddingStart();
                switch (m4720a(measuredWidth, a)) {
                    case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                        i5 = (getWidth() - paddingTop2) / 2;
                        break;
                    case 8388611:
                        break;
                    case 8388613:
                        i5 = b - paddingTop2;
                        break;
                    default:
                        i5 = a2;
                        break;
                }
                measuredWidth = paddingStart & 112;
                if (paddingStart == -1) {
                    measuredWidth = 16;
                }
                paddingStart = 0;
                switch (measuredWidth) {
                    case C0264R.styleable.Window_contentAutoFitSystemWindow /*16*/:
                        paddingStart = (((getHeight() - getPaddingBottom()) - getPaddingTop()) - view.getMeasuredHeight()) / 2;
                        break;
                    case 48:
                        paddingStart = getPaddingTop() + i7;
                        break;
                    case 80:
                        paddingStart = ((getHeight() - getPaddingBottom()) - view.getMeasuredHeight()) - measuredWidth2;
                        break;
                }
                measuredWidth2 = view.getMeasuredWidth();
                if (a) {
                    a2 = (getWidth() - i5) - measuredWidth2;
                } else {
                    a2 = i5;
                }
                view.layout(a2, paddingStart, a ? getWidth() - i5 : i5 + measuredWidth2, view.getMeasuredHeight() + paddingStart);
            }
            if (this.f2998D != null) {
                this.f2998D.bringToFront();
                paddingStart = this.f2998D.getMeasuredHeight() / 2;
                this.f2998D.layout(this.f3003I, -paddingStart, this.f3003I + this.f2998D.getMeasuredWidth(), paddingStart);
            }
            if (this.f3036y != null && this.f3036y.getVisibility() != 8) {
                a2 = this.f3036y.getHeight();
                int[] iArr = new int[2];
                this.f3034w.getLocationInWindow(iArr);
                if (this.f3034w.getVisibility() == 0) {
                    measuredWidth = this.f3034w.getHeight();
                } else {
                    measuredWidth = 0;
                }
                int[] iArr2 = new int[2];
                ((ViewGroup) this.f3036y.getParent()).getLocationInWindow(iArr2);
                paddingStart = (iArr[1] + ((measuredWidth - a2) / 2)) - iArr2[1];
                this.f3036y.setTop(paddingStart);
                this.f3036y.setBottom(paddingStart + a2);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ActionBar.LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        return layoutParams;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f3015U == null || this.f3015U.f2986b == null)) {
            savedState.f2993a = this.f3015U.f2986b.getItemId();
        }
        savedState.f2994b = m4754d();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!(savedState.f2993a == 0 || this.f3015U == null || this.f3011Q == null)) {
            MenuItem findItem = this.f3011Q.findItem(savedState.f2993a);
            if (findItem != null) {
                findItem.expandActionView();
            }
        }
        if (savedState.f2994b) {
            m4752b();
        }
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (this.f3031t != null) {
            this.f3031t.m4717b(drawable);
            return;
        }
        this.f3029r = drawable;
        this.f3030s = 0;
    }

    public void setHomeAsUpIndicator(int i) {
        if (this.f3031t != null) {
            this.f3031t.m4714a(i);
            return;
        }
        this.f3029r = null;
        this.f3030s = i;
    }

    protected ActionMenuPresenter m4748a(MenuPresenter.Callback callback) {
        ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f3027p, C0264R.layout.action_menu_layout, C0264R.layout.action_menu_item_layout, C0264R.layout.action_bar_expanded_menu_layout, C0264R.layout.action_bar_list_menu_item_layout);
        actionMenuPresenter.m4348a(callback);
        actionMenuPresenter.m4343a(C0264R.id.action_menu_presenter);
        return actionMenuPresenter;
    }

    protected ExpandedActionViewMenuPresenter m4765o() {
        return new ExpandedActionViewMenuPresenter();
    }

    public void setProgressBarVisibility(boolean z) {
        m4722a(z ? -1 : -2);
    }

    public void setProgressBarIndeterminateVisibility(boolean z) {
        m4722a(z ? -1 : -2);
    }

    public void setProgressBarIndeterminate(boolean z) {
        m4722a(z ? -3 : -4);
    }

    public void setProgress(int i) {
        m4722a(i + 0);
    }

    private void m4722a(int i) {
        ProgressBar circularProgressBar = getCircularProgressBar();
        ProgressBar horizontalProgressBar = getHorizontalProgressBar();
        if (i == -1) {
            if (horizontalProgressBar != null) {
                int i2 = (horizontalProgressBar.isIndeterminate() || horizontalProgressBar.getProgress() < 10000) ? 0 : 4;
                horizontalProgressBar.setVisibility(i2);
            }
            if (circularProgressBar != null) {
                circularProgressBar.setVisibility(0);
            }
        } else if (i == -2) {
            if (horizontalProgressBar != null) {
                horizontalProgressBar.setVisibility(8);
            }
            if (circularProgressBar != null) {
                circularProgressBar.setVisibility(8);
            }
        } else if (i == -3) {
            horizontalProgressBar.setIndeterminate(true);
        } else if (i == -4) {
            horizontalProgressBar.setIndeterminate(false);
        } else if (i >= 0 && i <= 10000) {
            horizontalProgressBar.setProgress(i + 0);
            if (i < 10000) {
                m4723a(horizontalProgressBar, circularProgressBar);
            } else {
                m4726b(horizontalProgressBar, circularProgressBar);
            }
        }
    }

    private void m4723a(ProgressBar progressBar, ProgressBar progressBar2) {
        if (progressBar2 != null && progressBar2.getVisibility() == 4) {
            progressBar2.setVisibility(0);
        }
        if (progressBar != null && progressBar.getProgress() < 10000) {
            progressBar.setVisibility(0);
        }
    }

    private void m4726b(ProgressBar progressBar, ProgressBar progressBar2) {
        if (progressBar2 != null && progressBar2.getVisibility() == 0) {
            progressBar2.setVisibility(4);
        }
        if (progressBar != null && progressBar.getVisibility() == 0) {
            progressBar.setVisibility(4);
        }
    }

    private ProgressBar getCircularProgressBar() {
        ProgressBar progressBar = this.f2999E;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        return progressBar;
    }

    private ProgressBar getHorizontalProgressBar() {
        ProgressBar progressBar = this.f2998D;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        return progressBar;
    }

    private Drawable getIcon() {
        if ((this.f3024m & 1) != 1) {
            if (this.f3027p instanceof Activity) {
                try {
                    this.f3025n = this.f3027p.getPackageManager().getActivityIcon(((Activity) this.f3027p).getComponentName());
                } catch (Throwable e) {
                    Log.e("ActionBarView", "Activity component name not found!", e);
                }
            }
            if (this.f3025n == null) {
                this.f3025n = this.f3027p.getApplicationInfo().loadIcon(this.f3027p.getPackageManager());
            }
            this.f3024m |= 1;
        }
        return this.f3025n;
    }

    private Drawable getLogo() {
        if ((this.f3024m & 2) != 2) {
            if (VERSION.SDK_INT >= 9) {
                if (this.f3027p instanceof Activity) {
                    try {
                        this.f3026o = this.f3027p.getPackageManager().getActivityLogo(((Activity) this.f3027p).getComponentName());
                    } catch (Throwable e) {
                        Log.e("ActionBarView", "Activity component name not found!", e);
                    }
                }
                if (this.f3026o == null) {
                    this.f3026o = this.f3027p.getApplicationInfo().loadLogo(this.f3027p.getPackageManager());
                }
            }
            this.f3024m |= 2;
        }
        return this.f3026o;
    }

    private void m4745v() {
        if (this.f3031t == null) {
            this.f3031t = (HomeView) LayoutInflater.from(this.f3027p).inflate(this.f3028q, this, false);
            this.f3031t.setOnClickListener(this.aa);
            this.f3031t.setClickable(true);
            this.f3031t.setFocusable(true);
            if (this.f3030s != 0) {
                this.f3031t.m4714a(this.f3030s);
                this.f3030s = 0;
            }
            if (this.f3029r != null) {
                this.f3031t.m4717b(this.f3029r);
                this.f3029r = null;
            }
            addView(this.f3031t);
        }
    }

    private void m4746w() {
        if (this.f3032u == null) {
            this.f3032u = (HomeView) LayoutInflater.from(this.f3027p).inflate(this.f3028q, this, false);
            this.f3032u.m4716a(true);
            this.f3032u.setOnClickListener(this.f3017W);
        }
    }

    private int m4720a(int i, boolean z) {
        int i2 = 8388611;
        int i3 = 8388615 & i;
        if ((8388608 & i3) == 0) {
            if (i3 == 3) {
                if (z) {
                    return 8388613;
                }
                return 8388611;
            } else if (i3 == 5) {
                if (!z) {
                    i2 = 8388613;
                }
                return i2;
            }
        }
        return i3;
    }
}
