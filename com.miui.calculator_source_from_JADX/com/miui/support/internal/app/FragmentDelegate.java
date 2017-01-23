package com.miui.support.internal.app;

import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window.Callback;
import com.miui.support.C0234R;
import com.miui.support.app.ActionBar;
import com.miui.support.app.IFragment;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.SimpleWindowCallback;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.widget.ActionBarContainer;
import com.miui.support.internal.widget.ActionBarContextView;
import com.miui.support.internal.widget.ActionBarOverlayLayout;
import com.miui.support.internal.widget.ActionBarView;
import com.miui.support.util.AttributeResolver;

public class FragmentDelegate extends ActionBarDelegateImpl {
    private Fragment f2240k;
    private View f2241l;
    private int f2242m;
    private Context f2243n;
    private MenuBuilder f2244o;
    private byte f2245p;
    private final Runnable f2246q;
    private final Callback f2247r;

    /* renamed from: com.miui.support.internal.app.FragmentDelegate.1 */
    class C02791 implements Runnable {
        final /* synthetic */ FragmentDelegate f2238a;

        C02791(FragmentDelegate fragmentDelegate) {
            this.f2238a = fragmentDelegate;
        }

        public void run() {
            boolean z = true;
            if ((this.f2238a.f2245p & 1) == 1) {
                this.f2238a.f2244o = null;
            }
            if (this.f2238a.f2244o == null) {
                this.f2238a.f2244o = this.f2238a.m3639j();
                z = this.f2238a.m3821a(0, this.f2238a.f2244o);
            }
            if (z) {
                z = this.f2238a.m3823a(0, null, this.f2238a.f2244o);
            }
            if (z) {
                this.f2238a.m3619a(this.f2238a.f2244o);
            } else {
                this.f2238a.m3619a(null);
                this.f2238a.f2244o = null;
            }
            this.f2238a.f2245p = (byte) (this.f2238a.f2245p & -18);
        }
    }

    /* renamed from: com.miui.support.internal.app.FragmentDelegate.2 */
    class C02802 extends SimpleWindowCallback {
        final /* synthetic */ FragmentDelegate f2239a;

        C02802(FragmentDelegate fragmentDelegate) {
            this.f2239a = fragmentDelegate;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f2239a.m3825b(callback);
        }

        public void onActionModeStarted(ActionMode actionMode) {
            ((IFragment) this.f2239a.f2240k).m3286a(actionMode);
        }

        public void onActionModeFinished(ActionMode actionMode) {
            ((IFragment) this.f2239a.f2240k).m3289b(actionMode);
        }

        public boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.f2239a.m3822a(i, menuItem);
        }
    }

    public FragmentDelegate(Fragment fragment) {
        super(fragment.getActivity());
        this.f2246q = new C02791(this);
        this.f2247r = new C02802(this);
        this.f2240k = fragment;
    }

    public ActionBar m3819a() {
        return new ActionBarImpl(this.f2240k);
    }

    public View m3818a(ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = m3830m().obtainStyledAttributes(C0234R.styleable.Window);
        if (obtainStyledAttributes.hasValue(C0234R.styleable.Window_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowActionBar, false)) {
                m3622a(8);
            }
            if (obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowActionBarOverlay, false)) {
                m3622a(9);
            }
            m3624b(obtainStyledAttributes.getInt(C0264R.styleable.Window_windowTranslucentStatus, 0));
            m3621a(obtainStyledAttributes.getBoolean(C0264R.styleable.Window_immersionMenuEnabled, false));
            this.j = obtainStyledAttributes.getResourceId(C0264R.styleable.Window_immersionMenuLayout, 0);
            obtainStyledAttributes.recycle();
            LayoutInflater from = LayoutInflater.from(m3830m());
            if (this.h) {
                m3820a(m3830m(), viewGroup, from);
                ViewParent viewParent = (ViewGroup) this.f2241l.findViewById(16908290);
                View a = ((IFragment) this.f2240k).m3284a(from, (ViewGroup) viewParent, bundle);
                if (!(a == null || a.getParent() == viewParent)) {
                    if (a.getParent() != null) {
                        ((ViewGroup) a.getParent()).removeView(a);
                    }
                    viewParent.removeAllViews();
                    viewParent.addView(a);
                }
            } else {
                this.f2241l = ((IFragment) this.f2240k).m3284a(from, viewGroup, bundle);
            }
            return this.f2241l;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a miui theme (or descendant) with this fragment.");
    }

    final void m3820a(Context context, ViewGroup viewGroup, LayoutInflater layoutInflater) {
        if (!this.e) {
            boolean z;
            this.e = true;
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) layoutInflater.inflate(C0264R.layout.screen_action_bar, viewGroup, false);
            actionBarOverlayLayout.setCallback(this.f2247r);
            actionBarOverlayLayout.setRootSubDecor(false);
            actionBarOverlayLayout.setOverlayMode(this.i);
            actionBarOverlayLayout.setTranslucentStatus(m3640k());
            if (this.f2242m != 0) {
                actionBarOverlayLayout.setBackground(AttributeResolver.m5320b(context, 16842836));
            }
            this.b = (ActionBarView) actionBarOverlayLayout.findViewById(C0264R.id.action_bar);
            this.b.setWindowCallback(this.f2247r);
            if (this.f) {
                this.b.m4756f();
            }
            if (this.g) {
                this.b.m4757g();
            }
            if (m3641l()) {
                this.b.m4749a(this.j, (ActionBarDelegateImpl) this);
            }
            boolean equals = "splitActionBarWhenNarrow".equals(m3633e());
            if (equals) {
                z = context.getResources().getBoolean(C0264R.bool.abc_split_action_bar_is_narrow);
            } else {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C0234R.styleable.Window);
                boolean z2 = obtainStyledAttributes.getBoolean(C0234R.styleable.Window_windowSplitActionBar, false);
                obtainStyledAttributes.recycle();
                z = z2;
            }
            ActionBarContainer actionBarContainer = (ActionBarContainer) actionBarOverlayLayout.findViewById(C0264R.id.split_action_bar);
            if (actionBarContainer != null) {
                this.b.setSplitView(actionBarContainer);
                this.b.setSplitActionBar(z);
                this.b.setSplitWhenNarrow(equals);
                ActionBarContextView actionBarContextView = (ActionBarContextView) actionBarOverlayLayout.findViewById(C0264R.id.action_context_bar);
                actionBarContainer.setActionBarContextView(actionBarContextView);
                actionBarContextView.setSplitView(actionBarContainer);
                actionBarContextView.setSplitActionBar(z);
                actionBarContextView.setSplitWhenNarrow(equals);
            }
            m3827c(1);
            m3826b();
            this.f2241l = actionBarOverlayLayout;
        } else if (this.f2241l.getParent() != null && (this.f2241l.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup2 = (ViewGroup) this.f2241l.getParent();
            if (viewGroup2.getChildCount() == 0) {
                viewGroup2.endViewTransition(this.f2241l);
            }
        }
    }

    public View m3831n() {
        return this.f2241l;
    }

    public boolean m3821a(int i, Menu menu) {
        if (i == 0) {
            return ((IFragment) this.f2240k).m3287a(i, menu);
        }
        return false;
    }

    public boolean m3822a(int i, MenuItem menuItem) {
        if (i == 0) {
            return this.f2240k.onOptionsItemSelected(menuItem);
        }
        return false;
    }

    public boolean m3823a(int i, View view, Menu menu) {
        if (i != 0) {
            return false;
        }
        ((IFragment) this.f2240k).m3285a(i, null, menu);
        return true;
    }

    public boolean m3824a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return m3822a(0, menuItem);
    }

    public void m3826b() {
        if ((this.f2245p & 16) == 0) {
            this.f2245p = (byte) (this.f2245p | 16);
            this.f2240k.getActivity().getWindow().getDecorView().post(this.f2246q);
        }
    }

    public void m3827c(int i) {
        this.f2245p = (byte) (this.f2245p | (i & 1));
    }

    public ActionMode m3817a(ActionMode.Callback callback) {
        return this.f2241l.startActionMode(callback);
    }

    public ActionMode m3825b(ActionMode.Callback callback) {
        if (m3629c() != null) {
            return ((ActionBarImpl) m3629c()).m3661a(callback);
        }
        return null;
    }

    public Context m3830m() {
        if (this.f2243n == null) {
            this.f2243n = this.a;
            if (this.f2242m != 0) {
                this.f2243n = new ContextThemeWrapper(this.f2243n, this.f2242m);
            }
        }
        return this.f2243n;
    }

    protected boolean m3828d(MenuBuilder menuBuilder) {
        if (this.f2240k instanceof IFragment) {
            return ((IFragment) this.f2240k).m3288a((Menu) menuBuilder);
        }
        return false;
    }

    protected boolean m3829e(MenuBuilder menuBuilder) {
        if (!(this.f2240k instanceof IFragment)) {
            return false;
        }
        this.f2240k.onPrepareOptionsMenu(menuBuilder);
        return true;
    }
}
