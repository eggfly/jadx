package com.miui.support.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar;
import com.miui.support.extension.ExtensionManager;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_View_Window_class.Factory;
import com.miui.support.internal.variable.Internal_Policy_Impl_PhoneWindow_class;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import com.miui.support.internal.view.menu.MenuPresenter;
import com.miui.support.internal.widget.ActionBarContainer;
import com.miui.support.internal.widget.ActionBarContextView;
import com.miui.support.internal.widget.ActionBarOverlayLayout;
import com.miui.support.internal.widget.ActionBarView;
import com.miui.support.reflect.Method;
import com.miui.support.util.AppConstants;
import com.miui.support.util.AttributeResolver;

public class ActivityDelegate extends ActionBarDelegateImpl implements Callback, MenuPresenter.Callback {
    private static final Method f2163k;
    private static final Method f2164l;
    private static final Method f2165m;
    private final Class<? extends Activity> f2166n;
    private ActionBarOverlayLayout f2167o;
    private ActionBarContainer f2168p;
    private final Runnable f2169q;

    /* renamed from: com.miui.support.internal.app.ActivityDelegate.1 */
    class C02711 implements Runnable {
        final /* synthetic */ ActivityDelegate f2162a;

        C02711(ActivityDelegate activityDelegate) {
            this.f2162a = activityDelegate;
        }

        public void run() {
            Menu j = this.f2162a.m3639j();
            if (!this.f2162a.m3641l() && this.f2162a.m3697b(0, j) && this.f2162a.m3699b(0, null, j)) {
                this.f2162a.m3619a((MenuBuilder) j);
            } else {
                this.f2162a.m3619a(null);
            }
        }
    }

    static {
        f2163k = Method.of(Activity.class, "onCreatePanelMenu", "(ILandroid/view/Menu;)Z");
        f2164l = Method.of(Activity.class, "onPreparePanel", "(ILandroid/view/View;Landroid/view/Menu;)Z");
        f2165m = Method.of(Activity.class, "onMenuItemSelected", "(ILandroid/view/MenuItem;)Z");
    }

    public ActivityDelegate(Activity activity, Class<? extends Activity> cls) {
        super(activity);
        this.f2169q = new C02711(this);
        this.f2166n = cls;
    }

    public static int m3693a(Window window) {
        int i;
        Context context = window.getContext();
        if (!AttributeResolver.m5319a(context, C0264R.attr.windowActionBar, false)) {
            i = C0264R.layout.screen_simple;
        } else if (AttributeResolver.m5319a(context, C0264R.attr.windowActionBarMovable, false)) {
            i = C0264R.layout.screen_action_bar_movable;
        } else {
            i = C0264R.layout.screen_action_bar;
        }
        int a = AttributeResolver.m5316a(context, C0234R.attr.startingWindowOverlay);
        if (a > 0 && m3700p() && m3694a(context)) {
            i = a;
        }
        if (!window.isFloating() && (window.getCallback() instanceof Dialog)) {
            Factory.getInstance().get().setTranslucentStatus(window, AttributeResolver.m5317a(context, C0264R.attr.windowTranslucentStatus, 0));
        }
        return i;
    }

    private static boolean m3700p() {
        return "android".equals(AppConstants.m4227a().getApplicationInfo().packageName);
    }

    private static boolean m3694a(Context context) {
        return AttributeResolver.m5319a(context, C0234R.attr.windowActionBar, true);
    }

    public void m3703a(Bundle bundle) {
        super.m3616a(bundle);
        m3722n();
        ExtensionManager.m3442a().m3444a("Activity", "onCreate", this.a, bundle);
    }

    public ActionBar m3702a() {
        return new ActionBarImpl(this.a);
    }

    public void m3719h() {
        m3627b(false);
        ActionBarImpl actionBarImpl = (ActionBarImpl) m3629c();
        if (actionBarImpl != null) {
            actionBarImpl.m3682g(false);
        }
    }

    public void m3720i() {
        ActionBarImpl actionBarImpl = (ActionBarImpl) m3629c();
        if (actionBarImpl != null) {
            actionBarImpl.m3682g(true);
        }
    }

    protected void m3722n() {
        if (!this.e) {
            this.e = true;
            Window window = this.a.getWindow();
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0234R.styleable.Window);
            if (obtainStyledAttributes.getInt(C0234R.styleable.Window_windowLayoutMode, 0) == 1) {
                this.a.getWindow().setGravity(80);
            }
            if (obtainStyledAttributes.hasValue(C0234R.styleable.Window_windowActionBar)) {
                if (obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowActionBar, false)) {
                    m3622a(8);
                }
                if (obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowActionBarOverlay, false)) {
                    m3622a(9);
                }
                m3624b(obtainStyledAttributes.getInt(C0264R.styleable.Window_windowTranslucentStatus, 0));
                Internal_Policy_Impl_PhoneWindow_class internal_Policy_Impl_PhoneWindow_class = Internal_Policy_Impl_PhoneWindow_class.Factory.getInstance().get();
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                internal_Policy_Impl_PhoneWindow_class.restoreLayoutInflater(window, internal_Policy_Impl_PhoneWindow_class.replaceLayoutInflater(window));
                View childAt = viewGroup.getChildAt(0);
                if (childAt instanceof ActionBarOverlayLayout) {
                    this.f2167o = (ActionBarOverlayLayout) childAt;
                } else {
                    View findViewById = childAt.findViewById(16908290);
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    viewGroup.removeAllViews();
                    View.inflate(this.a, m3693a(window), viewGroup);
                    this.f2167o = (ActionBarOverlayLayout) viewGroup.getChildAt(0);
                    View findViewById2 = this.f2167o.findViewById(16908290);
                    int indexOfChild = this.f2167o.indexOfChild(findViewById2);
                    this.f2167o.removeView(findViewById2);
                    this.f2167o.addView(findViewById, indexOfChild);
                    this.f2167o.setContentView(findViewById);
                }
                this.f2167o.setCallback(this.a);
                this.f2167o.setTranslucentStatus(m3640k());
                TypedArray obtainStyledAttributes2 = this.a.obtainStyledAttributes(null, C0264R.styleable.SwipeBack, C0234R.attr.swipeBackStyle, 0);
                boolean isFloating = window.isFloating();
                int i = C0234R.styleable.SwipeBack_swipeBackEnabled;
                if (VERSION.SDK_INT <= 19 || isFloating) {
                    isFloating = false;
                } else {
                    isFloating = true;
                }
                isFloating = obtainStyledAttributes2.getBoolean(i, isFloating);
                obtainStyledAttributes2.recycle();
                m3716c(isFloating);
                if (this.h) {
                    boolean z;
                    this.f2168p = (ActionBarContainer) this.f2167o.findViewById(C0264R.id.action_bar_container);
                    this.f2167o.setOverlayMode(this.i);
                    this.b = (ActionBarView) this.f2167o.findViewById(C0264R.id.action_bar);
                    this.b.setWindowCallback(this.a);
                    if (this.f) {
                        this.b.m4756f();
                    }
                    if (this.g) {
                        this.b.m4757g();
                    }
                    this.j = obtainStyledAttributes.getResourceId(C0264R.styleable.Window_immersionMenuLayout, 0);
                    if (m3641l()) {
                        this.b.m4749a(this.j, (ActionBarDelegateImpl) this);
                    }
                    if (this.b.getCustomNavigationView() != null) {
                        this.b.setDisplayOptions(this.b.getDisplayOptions() | 16);
                    }
                    boolean equals = "splitActionBarWhenNarrow".equals(m3633e());
                    if (equals) {
                        z = this.a.getResources().getBoolean(C0264R.bool.abc_split_action_bar_is_narrow);
                    } else {
                        z = obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowSplitActionBar, false);
                    }
                    ActionBarContainer actionBarContainer = (ActionBarContainer) this.f2167o.findViewById(C0264R.id.split_action_bar);
                    if (actionBarContainer != null) {
                        this.b.setSplitView(actionBarContainer);
                        this.b.setSplitActionBar(z);
                        this.b.setSplitWhenNarrow(equals);
                        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f2167o.findViewById(C0264R.id.action_context_bar);
                        actionBarContainer.setActionBarContextView(actionBarContextView);
                        actionBarContextView.setSplitView(actionBarContainer);
                        actionBarContextView.setSplitActionBar(z);
                        actionBarContextView.setSplitWhenNarrow(equals);
                    }
                    window.getDecorView().post(this.f2169q);
                }
                if (obtainStyledAttributes.getBoolean(C0264R.styleable.Window_immersionMenuEnabled, false)) {
                    m3621a(true);
                }
                obtainStyledAttributes.recycle();
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a miui theme (or descendant) with this activity.");
        }
    }

    public void m3705a(CharSequence charSequence) {
        if (this.b != null) {
            this.b.setWindowTitle(charSequence);
        }
    }

    public View m3714c(int i) {
        if (i == 0 && !m3641l()) {
            boolean z = true;
            MenuBuilder menuBuilder = this.c;
            if (this.d == null) {
                if (menuBuilder == null) {
                    menuBuilder = m3639j();
                    m3619a(menuBuilder);
                    menuBuilder.m4441f();
                    z = m3697b(0, (Menu) menuBuilder);
                }
                if (z) {
                    menuBuilder.m4441f();
                    z = m3699b(0, null, menuBuilder);
                }
            }
            if (z) {
                menuBuilder.m4442g();
            } else {
                m3619a(null);
            }
        }
        return null;
    }

    public boolean m3706a(int i, Menu menu) {
        return i != 0 && m3697b(i, menu);
    }

    public boolean m3708a(int i, View view, Menu menu) {
        return i != 0 && m3699b(i, view, menu);
    }

    public void m3712b(Bundle bundle) {
        if (this.f2168p != null) {
            SparseArray sparseArray = new SparseArray();
            this.f2168p.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("miui:ActionBar", sparseArray);
        }
    }

    public void m3715c(Bundle bundle) {
        if (this.f2168p != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("miui:ActionBar");
            if (sparseParcelableArray != null) {
                this.f2168p.restoreHierarchyState(sparseParcelableArray);
            }
        }
    }

    public boolean m3707a(int i, MenuItem menuItem) {
        if (!(m3698b(i, menuItem) || i != 0 || menuItem.getItemId() != 16908332 || m3629c() == null || (m3629c().getDisplayOptions() & 4) == 0)) {
            boolean onNavigateUp;
            if (this.a.getParent() == null) {
                onNavigateUp = this.a.onNavigateUp();
            } else {
                onNavigateUp = this.a.getParent().onNavigateUpFromChild(this.a);
            }
            if (!onNavigateUp) {
                this.a.finish();
            }
        }
        return true;
    }

    public boolean m3709a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.a.onMenuItemSelected(0, menuItem);
    }

    public void m3711b() {
        this.f2169q.run();
    }

    public ActionMode m3701a(ActionMode.Callback callback) {
        return this.f2167o.startActionMode(callback);
    }

    public ActionMode m3710b(ActionMode.Callback callback) {
        if (m3629c() != null) {
            return ((ActionBarImpl) m3629c()).m3661a(callback);
        }
        return null;
    }

    public void m3704a(ActionMode actionMode) {
        this.d = actionMode;
    }

    public void m3713b(ActionMode actionMode) {
        this.d = null;
    }

    public boolean m3723o() {
        if (this.d != null) {
            this.d.finish();
            return true;
        } else if (this.b == null || !this.b.m4762l()) {
            return false;
        } else {
            this.b.m4763m();
            return true;
        }
    }

    private boolean m3697b(int i, Menu menu) {
        return f2163k.invokeBoolean(this.f2166n, m3636g(), Integer.valueOf(i), menu);
    }

    private boolean m3699b(int i, View view, Menu menu) {
        return f2164l.invokeBoolean(this.f2166n, m3636g(), Integer.valueOf(i), view, menu);
    }

    private boolean m3698b(int i, MenuItem menuItem) {
        return f2165m.invokeBoolean(this.f2166n, m3636g(), Integer.valueOf(i), menuItem);
    }

    protected boolean m3717d(MenuBuilder menuBuilder) {
        return this.a.onCreateOptionsMenu(menuBuilder);
    }

    protected boolean m3718e(MenuBuilder menuBuilder) {
        return this.a.onPrepareOptionsMenu(menuBuilder);
    }

    public Context m3721m() {
        return this.a;
    }

    public void m3716c(boolean z) {
        if (!this.a.isTaskRoot()) {
            this.f2167o.setSwipeBackEnabled(z);
            if (z) {
                this.f2167o.setupSwipeBack(this.a);
            } else {
                this.f2167o.m4677a(this.a);
            }
        }
    }
}
