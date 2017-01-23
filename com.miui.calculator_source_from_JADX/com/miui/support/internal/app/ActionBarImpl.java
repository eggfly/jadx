package com.miui.support.internal.app;

import android.app.ActionBar.LayoutParams;
import android.app.ActionBar.OnMenuVisibilityListener;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;
import com.miui.support.app.ActionBar;
import com.miui.support.app.IFragment;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.view.ActionBarPolicy;
import com.miui.support.internal.view.ActionModeImpl;
import com.miui.support.internal.view.ActionModeImpl.ActionModeCallback;
import com.miui.support.internal.view.EditActionModeImpl;
import com.miui.support.internal.view.SearchActionModeImpl;
import com.miui.support.internal.view.menu.PhoneActionMenuView;
import com.miui.support.internal.widget.ActionBarContainer;
import com.miui.support.internal.widget.ActionBarContextView;
import com.miui.support.internal.widget.ActionBarOverlayLayout;
import com.miui.support.internal.widget.ActionBarView;
import com.miui.support.internal.widget.ActionModeView;
import com.miui.support.internal.widget.ScrollingTabContainerView;
import com.miui.support.internal.widget.SearchActionModeView;
import com.miui.support.view.SearchActionMode;
import java.util.ArrayList;

public class ActionBarImpl extends ActionBar {
    private static TabListener f2125b;
    private boolean f2126A;
    private boolean f2127B;
    private boolean f2128C;
    private SearchActionModeView f2129D;
    private ActionModeCallback f2130E;
    ActionMode f2131a;
    private Context f2132c;
    private Context f2133d;
    private ActionBarOverlayLayout f2134e;
    private ActionBarContainer f2135f;
    private ActionBarView f2136g;
    private ActionBarContextView f2137h;
    private ActionBarContainer f2138i;
    private PhoneActionMenuView f2139j;
    private View f2140k;
    private OnClickListener f2141l;
    private ActionBarViewPagerController f2142m;
    private ScrollingTabContainerView f2143n;
    private ActionModeView f2144o;
    private ArrayList<TabImpl> f2145p;
    private TabImpl f2146q;
    private FragmentManager f2147r;
    private int f2148s;
    private boolean f2149t;
    private ArrayList<OnMenuVisibilityListener> f2150u;
    private int f2151v;
    private boolean f2152w;
    private int f2153x;
    private boolean f2154y;
    private boolean f2155z;

    /* renamed from: com.miui.support.internal.app.ActionBarImpl.1 */
    final class C02651 implements TabListener {
        C02651() {
        }

        public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
            TabImpl tabImpl = (TabImpl) tab;
            if (tabImpl.f2118c != null) {
                tabImpl.f2118c.onTabSelected(tab, fragmentTransaction);
            }
            if (tabImpl.f2117b != null) {
                tabImpl.f2117b.onTabSelected(tab, fragmentTransaction);
            }
        }

        public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
            TabImpl tabImpl = (TabImpl) tab;
            if (tabImpl.f2118c != null) {
                tabImpl.f2118c.onTabUnselected(tab, fragmentTransaction);
            }
            if (tabImpl.f2117b != null) {
                tabImpl.f2117b.onTabUnselected(tab, fragmentTransaction);
            }
        }

        public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
            TabImpl tabImpl = (TabImpl) tab;
            if (tabImpl.f2118c != null) {
                tabImpl.f2118c.onTabReselected(tab, fragmentTransaction);
            }
            if (tabImpl.f2117b != null) {
                tabImpl.f2117b.onTabReselected(tab, fragmentTransaction);
            }
        }
    }

    /* renamed from: com.miui.support.internal.app.ActionBarImpl.2 */
    class C02662 implements ActionModeCallback {
        final /* synthetic */ ActionBarImpl f2113a;

        C02662(ActionBarImpl actionBarImpl) {
            this.f2113a = actionBarImpl;
        }

        public void m3644a(ActionMode actionMode) {
            this.f2113a.m3677d(false);
            this.f2113a.f2131a = null;
        }
    }

    /* renamed from: com.miui.support.internal.app.ActionBarImpl.3 */
    class C02673 implements OnClickListener {
        final /* synthetic */ ActionBarImpl f2114a;

        C02673(ActionBarImpl actionBarImpl) {
            this.f2114a = actionBarImpl;
        }

        public void onClick(View view) {
            if (this.f2114a.f2139j != null && this.f2114a.f2139j.m4549e()) {
                this.f2114a.f2139j.getPresenter().m4386e(true);
            }
        }
    }

    /* renamed from: com.miui.support.internal.app.ActionBarImpl.4 */
    class C02684 implements OnClickListener {
        final /* synthetic */ ActionBarImpl f2115a;

        C02684(ActionBarImpl actionBarImpl) {
            this.f2115a = actionBarImpl;
        }

        public void onClick(View view) {
            if (this.f2115a.f2131a != null) {
                this.f2115a.f2131a.finish();
            }
        }
    }

    public class TabImpl extends Tab {
        final /* synthetic */ ActionBarImpl f2116a;
        private TabListener f2117b;
        private TabListener f2118c;
        private Object f2119d;
        private Drawable f2120e;
        private CharSequence f2121f;
        private CharSequence f2122g;
        private int f2123h;
        private View f2124i;

        public TabImpl(ActionBarImpl actionBarImpl) {
            this.f2116a = actionBarImpl;
            this.f2123h = -1;
        }

        public Object getTag() {
            return this.f2119d;
        }

        public Tab setTag(Object obj) {
            this.f2119d = obj;
            return this;
        }

        public TabListener m3647a() {
            return ActionBarImpl.f2125b;
        }

        public Tab setTabListener(TabListener tabListener) {
            this.f2117b = tabListener;
            return this;
        }

        public View getCustomView() {
            return this.f2124i;
        }

        public Tab setCustomView(View view) {
            this.f2124i = view;
            if (this.f2123h >= 0) {
                this.f2116a.f2143n.m4881d(this.f2123h);
            }
            return this;
        }

        public Tab setCustomView(int i) {
            return setCustomView(LayoutInflater.from(this.f2116a.getThemedContext()).inflate(i, null));
        }

        public Drawable getIcon() {
            return this.f2120e;
        }

        public int getPosition() {
            return this.f2123h;
        }

        public void m3648a(int i) {
            this.f2123h = i;
        }

        public CharSequence getText() {
            return this.f2121f;
        }

        public Tab setIcon(Drawable drawable) {
            this.f2120e = drawable;
            if (this.f2123h >= 0) {
                this.f2116a.f2143n.m4881d(this.f2123h);
            }
            return this;
        }

        public Tab setIcon(int i) {
            return setIcon(this.f2116a.f2132c.getResources().getDrawable(i));
        }

        public Tab setText(CharSequence charSequence) {
            this.f2121f = charSequence;
            if (this.f2123h >= 0) {
                this.f2116a.f2143n.m4881d(this.f2123h);
            }
            return this;
        }

        public Tab setText(int i) {
            return setText(this.f2116a.f2132c.getResources().getText(i));
        }

        public void select() {
            this.f2116a.selectTab(this);
        }

        public Tab setContentDescription(int i) {
            return setContentDescription(this.f2116a.f2132c.getResources().getText(i));
        }

        public Tab setContentDescription(CharSequence charSequence) {
            this.f2122g = charSequence;
            if (this.f2123h >= 0) {
                this.f2116a.f2143n.m4881d(this.f2123h);
            }
            return this;
        }

        public CharSequence getContentDescription() {
            return this.f2122g;
        }
    }

    static {
        f2125b = new C02651();
    }

    public ActionBarImpl(Activity activity) {
        this.f2145p = new ArrayList();
        this.f2148s = -1;
        this.f2150u = new ArrayList();
        this.f2153x = 0;
        this.f2127B = true;
        this.f2130E = new C02662(this);
        this.f2132c = activity;
        this.f2147r = activity.getFragmentManager();
        m3668a((ViewGroup) activity.getWindow().getDecorView().findViewById(C0264R.id.action_bar_overlay_layout));
        setTitle(activity.getTitle());
    }

    public ActionBarImpl(Fragment fragment) {
        this.f2145p = new ArrayList();
        this.f2148s = -1;
        this.f2150u = new ArrayList();
        this.f2153x = 0;
        this.f2127B = true;
        this.f2130E = new C02662(this);
        this.f2132c = ((IFragment) fragment).m3283a();
        this.f2147r = fragment.getFragmentManager();
        m3668a((ViewGroup) fragment.getView());
        Activity activity = fragment.getActivity();
        setTitle(activity != null ? activity.getTitle() : null);
    }

    public ActionBarImpl(Dialog dialog) {
        this.f2145p = new ArrayList();
        this.f2148s = -1;
        this.f2150u = new ArrayList();
        this.f2153x = 0;
        this.f2127B = true;
        this.f2130E = new C02662(this);
        this.f2132c = dialog.getContext();
        m3668a((ViewGroup) dialog.getWindow().getDecorView().findViewById(C0264R.id.action_bar_overlay_layout));
    }

    private static boolean m3651a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    protected void m3668a(ViewGroup viewGroup) {
        boolean z = false;
        this.f2134e = (ActionBarOverlayLayout) viewGroup;
        this.f2134e.setActionBar(this);
        this.f2136g = (ActionBarView) viewGroup.findViewById(C0264R.id.action_bar);
        this.f2137h = (ActionBarContextView) viewGroup.findViewById(C0264R.id.action_context_bar);
        this.f2135f = (ActionBarContainer) viewGroup.findViewById(C0264R.id.action_bar_container);
        this.f2138i = (ActionBarContainer) viewGroup.findViewById(C0264R.id.split_action_bar);
        this.f2140k = viewGroup.findViewById(C0264R.id.content_mask);
        if (this.f2140k != null) {
            this.f2141l = new C02673(this);
        }
        if (this.f2136g == null || this.f2137h == null || this.f2135f == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        boolean z2;
        this.f2151v = this.f2136g.m4760j() ? 1 : 0;
        if ((this.f2136g.getDisplayOptions() & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f2149t = true;
        }
        ActionBarPolicy a = ActionBarPolicy.m4264a(this.f2132c);
        if (a.m4271g() || z2) {
            z = true;
        }
        setHomeButtonEnabled(z);
        m3657h(a.m4268d());
    }

    public void m3667a(Configuration configuration) {
        m3657h(ActionBarPolicy.m4264a(this.f2132c).m4268d());
    }

    private void m3657h(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.f2152w = z;
        if (this.f2152w) {
            this.f2135f.setTabContainer(null);
            this.f2136g.setEmbeddedTabView(this.f2143n);
        } else {
            this.f2136g.setEmbeddedTabView(null);
            this.f2135f.setTabContainer(this.f2143n);
        }
        if (getNavigationMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f2143n != null) {
            if (z2) {
                this.f2143n.setVisibility(0);
            } else {
                this.f2143n.setVisibility(8);
            }
            this.f2143n.setEmbeded(this.f2152w);
        }
        ActionBarView actionBarView = this.f2136g;
        if (this.f2152w || !z2) {
            z3 = false;
        }
        actionBarView.setCollapsable(z3);
    }

    public void setCustomView(View view) {
        this.f2136g.setCustomNavigationView(view);
    }

    public void setCustomView(View view, LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.f2136g.setCustomNavigationView(view);
    }

    public void setIcon(int i) {
        this.f2136g.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.f2136g.setIcon(drawable);
    }

    public void setLogo(int i) {
        this.f2136g.setLogo(i);
    }

    public void setLogo(Drawable drawable) {
        this.f2136g.setLogo(drawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, OnNavigationListener onNavigationListener) {
        this.f2136g.setDropdownAdapter(spinnerAdapter);
        this.f2136g.setCallback(onNavigationListener);
    }

    public void setSelectedNavigationItem(int i) {
        switch (this.f2136g.getNavigationMode()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                this.f2136g.setDropdownSelectedPosition(i);
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                selectTab((Tab) this.f2145p.get(i));
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public int getSelectedNavigationIndex() {
        switch (this.f2136g.getNavigationMode()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                return this.f2136g.getDropdownSelectedPosition();
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                if (this.f2146q != null) {
                    return this.f2146q.getPosition();
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getNavigationItemCount() {
        switch (this.f2136g.getNavigationMode()) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                SpinnerAdapter dropdownAdapter = this.f2136g.getDropdownAdapter();
                return dropdownAdapter != null ? dropdownAdapter.getCount() : 0;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                return this.f2145p.size();
            default:
                return 0;
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f2136g.setTitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2136g.setSubtitle(charSequence);
    }

    public void setDisplayOptions(int i, int i2) {
        int displayOptions = this.f2136g.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.f2149t = true;
        }
        this.f2136g.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public void setDisplayUseLogoEnabled(boolean z) {
        setDisplayOptions(z ? 1 : 0, 1);
    }

    public void setDisplayShowHomeEnabled(boolean z) {
        setDisplayOptions(z ? 2 : 0, 2);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public void setDisplayShowTitleEnabled(boolean z) {
        setDisplayOptions(z ? 8 : 0, 8);
    }

    public void setDisplayShowCustomEnabled(boolean z) {
        setDisplayOptions(z ? 16 : 0, 16);
    }

    public void setHomeButtonEnabled(boolean z) {
        this.f2136g.setHomeButtonEnabled(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2135f.setPrimaryBackground(drawable);
    }

    public View getCustomView() {
        return this.f2136g.getCustomNavigationView();
    }

    public void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.f2136g, false));
    }

    public CharSequence getTitle() {
        return this.f2136g.getTitle();
    }

    public void setTitle(int i) {
        setTitle(this.f2132c.getString(i));
    }

    public CharSequence getSubtitle() {
        return this.f2136g.getSubtitle();
    }

    public void setSubtitle(int i) {
        setSubtitle(this.f2132c.getString(i));
    }

    public int getNavigationMode() {
        return this.f2136g.getNavigationMode();
    }

    public void setNavigationMode(int i) {
        boolean z = false;
        switch (this.f2136g.getNavigationMode()) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f2148s = getSelectedNavigationIndex();
                selectTab(null);
                this.f2143n.setVisibility(8);
                break;
        }
        this.f2136g.setNavigationMode(i);
        switch (i) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                m3656h();
                this.f2143n.setVisibility(0);
                if (this.f2148s != -1) {
                    setSelectedNavigationItem(this.f2148s);
                    this.f2148s = -1;
                    break;
                }
                break;
        }
        ActionBarView actionBarView = this.f2136g;
        if (i == 2 && !this.f2152w) {
            z = true;
        }
        actionBarView.setCollapsable(z);
    }

    public int getDisplayOptions() {
        return this.f2136g.getDisplayOptions();
    }

    public void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.f2149t = true;
        }
        this.f2136g.setDisplayOptions(i);
    }

    public Tab newTab() {
        return new TabImpl(this);
    }

    public void addTab(Tab tab) {
        addTab(tab, this.f2145p.isEmpty());
    }

    public void addTab(Tab tab, boolean z) {
        if (m3679e()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        m3666a(tab, z);
    }

    public void addTab(Tab tab, int i) {
        addTab(tab, i, this.f2145p.isEmpty());
    }

    public void addTab(Tab tab, int i, boolean z) {
        if (m3679e()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        m3665a(tab, i, z);
    }

    void m3666a(Tab tab, boolean z) {
        m3656h();
        this.f2143n.m4878a(tab, z);
        m3650a(tab, this.f2145p.size());
        if (z) {
            selectTab(tab);
        }
    }

    void m3665a(Tab tab, int i, boolean z) {
        m3656h();
        this.f2143n.m4877a(tab, i, z);
        m3650a(tab, i);
        if (z) {
            selectTab(tab);
        }
    }

    public void removeTab(Tab tab) {
        if (m3679e()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        m3664a(tab);
    }

    public void removeTabAt(int i) {
        if (m3679e()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        m3672b(i);
    }

    public void removeAllTabs() {
        if (m3679e()) {
            throw new IllegalStateException("Cannot add tab directly in fragment view pager mode!\n Please using addFragmentTab().");
        }
        m3662a();
    }

    void m3664a(Tab tab) {
        m3672b(tab.getPosition());
    }

    void m3672b(int i) {
        if (this.f2143n != null) {
            int position = this.f2146q != null ? this.f2146q.getPosition() : this.f2148s;
            this.f2143n.m4882e(i);
            TabImpl tabImpl = (TabImpl) this.f2145p.remove(i);
            if (tabImpl != null) {
                tabImpl.m3648a(-1);
            }
            int size = this.f2145p.size();
            for (int i2 = i; i2 < size; i2++) {
                ((TabImpl) this.f2145p.get(i2)).m3648a(i2);
            }
            if (position == i) {
                Tab tab;
                if (this.f2145p.isEmpty()) {
                    tab = null;
                } else {
                    tabImpl = (TabImpl) this.f2145p.get(Math.max(0, i - 1));
                }
                selectTab(tab);
            }
        }
    }

    void m3662a() {
        m3658i();
    }

    public void selectTab(Tab tab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i = tab.getPosition();
            }
            this.f2148s = i;
            return;
        }
        FragmentTransaction disallowAddToBackStack = this.f2147r.beginTransaction().disallowAddToBackStack();
        if (this.f2146q != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.f2143n;
            if (tab != null) {
                i = tab.getPosition();
            }
            scrollingTabContainerView.setTabSelected(i);
            if (this.f2146q != null) {
                this.f2146q.m3647a().onTabUnselected(this.f2146q, disallowAddToBackStack);
            }
            this.f2146q = (TabImpl) tab;
            if (this.f2146q != null) {
                this.f2146q.m3647a().onTabSelected(this.f2146q, disallowAddToBackStack);
            }
        } else if (this.f2146q != null) {
            this.f2146q.m3647a().onTabReselected(this.f2146q, disallowAddToBackStack);
            this.f2143n.m4880c(tab.getPosition());
        }
        if (!disallowAddToBackStack.isEmpty()) {
            disallowAddToBackStack.commit();
        }
    }

    public Tab getSelectedTab() {
        return this.f2146q;
    }

    public Tab getTabAt(int i) {
        return (Tab) this.f2145p.get(i);
    }

    public int getTabCount() {
        return this.f2145p.size();
    }

    public Context getThemedContext() {
        if (this.f2133d == null) {
            TypedValue typedValue = new TypedValue();
            this.f2132c.getTheme().resolveAttribute(16843671, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f2133d = new ContextThemeWrapper(this.f2132c, i);
            } else {
                this.f2133d = this.f2132c;
            }
        }
        return this.f2133d;
    }

    public int getHeight() {
        return this.f2135f.getHeight();
    }

    public void show() {
        if (this.f2154y) {
            this.f2154y = false;
            m3659i(false);
        }
    }

    void m3671b() {
        if (!this.f2126A) {
            this.f2126A = true;
            m3659i(false);
        }
    }

    public void hide() {
        if (!this.f2154y) {
            this.f2154y = true;
            m3659i(false);
        }
    }

    void m3674c() {
        if (this.f2126A) {
            this.f2126A = false;
            m3659i(false);
        }
    }

    public boolean isShowing() {
        return this.f2127B;
    }

    public void addOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f2150u.add(onMenuVisibilityListener);
    }

    public void removeOnMenuVisibilityListener(OnMenuVisibilityListener onMenuVisibilityListener) {
        this.f2150u.remove(onMenuVisibilityListener);
    }

    public ActionMode m3661a(Callback callback) {
        if (this.f2131a != null) {
            this.f2131a.finish();
        }
        ActionMode c = m3654c(callback);
        if (((this.f2144o instanceof SearchActionModeView) && (c instanceof SearchActionModeImpl)) || ((this.f2144o instanceof ActionBarContextView) && (c instanceof EditActionModeImpl))) {
            this.f2144o.m4633g();
            this.f2144o.m4634h();
        }
        this.f2144o = m3670b(callback);
        if (c instanceof ActionModeImpl) {
            ActionModeImpl actionModeImpl = (ActionModeImpl) c;
            actionModeImpl.m4277a(this.f2144o);
            actionModeImpl.m4276a(this.f2130E);
            if (actionModeImpl.m4280a()) {
                c.invalidate();
                this.f2144o.m4630a(c);
                m3677d(true);
                if (!(this.f2138i == null || this.f2151v != 1 || this.f2138i.getVisibility() == 0)) {
                    this.f2138i.setVisibility(0);
                }
                if (this.f2144o instanceof ActionBarContextView) {
                    ((ActionBarContextView) this.f2144o).sendAccessibilityEvent(32);
                }
                this.f2131a = c;
                return c;
            }
        }
        return null;
    }

    void m3677d(boolean z) {
        if (z) {
            m3671b();
        } else {
            m3674c();
        }
        this.f2144o.m4632b(z);
        if (this.f2143n != null && !this.f2136g.m4761k() && this.f2136g.m4764n()) {
            this.f2143n.setVisibility(z ? 8 : 0);
        }
    }

    private ActionMode m3654c(Callback callback) {
        if (callback instanceof SearchActionMode.Callback) {
            return new SearchActionModeImpl(this.f2132c, callback);
        }
        return new EditActionModeImpl(this.f2132c, callback);
    }

    public ActionModeView m3670b(Callback callback) {
        if (!(callback instanceof SearchActionMode.Callback)) {
            return this.f2137h;
        }
        if (this.f2129D == null) {
            this.f2129D = m3676d();
        }
        if (this.f2134e != this.f2129D.getParent()) {
            this.f2134e.addView(this.f2129D);
        }
        return this.f2129D;
    }

    public SearchActionModeView m3676d() {
        SearchActionModeView searchActionModeView = (SearchActionModeView) LayoutInflater.from(getThemedContext()).inflate(C0264R.layout.search_action_mode_view, this.f2134e, false);
        searchActionModeView.setOnBackClickListener(new C02684(this));
        Rect pendingInsets = this.f2135f.getPendingInsets();
        if (pendingInsets != null) {
            searchActionModeView.setStatusBarPaddingTop(pendingInsets.top);
        }
        return searchActionModeView;
    }

    public boolean m3679e() {
        return this.f2142m != null;
    }

    public void m3669a(boolean z) {
        this.f2136g.setProgressBarVisibility(z);
    }

    public void m3673b(boolean z) {
        this.f2136g.setProgressBarIndeterminateVisibility(z);
    }

    public void m3675c(boolean z) {
        this.f2136g.setProgressBarIndeterminate(z);
    }

    public void m3663a(int i) {
        this.f2136g.setProgress(i);
    }

    private void m3656h() {
        if (this.f2143n == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.f2132c);
            if (this.f2152w) {
                scrollingTabContainerView.setVisibility(0);
                this.f2136g.setEmbeddedTabView(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.f2135f.setTabContainer(scrollingTabContainerView);
            }
            scrollingTabContainerView.setEmbeded(this.f2152w);
            this.f2143n = scrollingTabContainerView;
        }
    }

    private void m3650a(Tab tab, int i) {
        TabImpl tabImpl = (TabImpl) tab;
        if (tabImpl.m3647a() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        tabImpl.m3648a(i);
        this.f2145p.add(i, tabImpl);
        int size = this.f2145p.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((TabImpl) this.f2145p.get(i2)).m3648a(i2);
        }
    }

    private void m3658i() {
        if (this.f2146q != null) {
            selectTab(null);
        }
        this.f2145p.clear();
        if (this.f2143n != null) {
            this.f2143n.m4873a();
        }
        this.f2148s = -1;
    }

    private void m3659i(boolean z) {
        if (m3651a(this.f2154y, this.f2155z, this.f2126A)) {
            if (!this.f2127B) {
                this.f2127B = true;
                m3678e(z);
            }
        } else if (this.f2127B) {
            this.f2127B = false;
            m3680f(z);
        }
    }

    public void m3678e(boolean z) {
        this.f2135f.clearAnimation();
        if (this.f2135f.getVisibility() != 0) {
            int i = (m3681f() || z) ? true : 0;
            if (i != 0) {
                this.f2135f.startAnimation(AnimationUtils.loadAnimation(this.f2132c, C0264R.anim.action_bar_slide_in_top));
            }
            this.f2135f.setVisibility(0);
            if (this.f2138i != null && this.f2138i.getVisibility() != 0) {
                if (i != 0) {
                    this.f2138i.startAnimation(AnimationUtils.loadAnimation(this.f2132c, C0264R.anim.action_bar_slide_in_bottom));
                }
                this.f2138i.setVisibility(0);
                m3660j(true);
            }
        }
    }

    public void m3680f(boolean z) {
        this.f2135f.clearAnimation();
        if (this.f2135f.getVisibility() != 8) {
            boolean z2 = m3681f() || z;
            if (z2) {
                this.f2135f.startAnimation(AnimationUtils.loadAnimation(this.f2132c, C0264R.anim.action_bar_slide_out_top));
            }
            this.f2135f.setVisibility(8);
            if (this.f2138i != null && this.f2138i.getVisibility() != 8) {
                if (z2) {
                    this.f2138i.startAnimation(AnimationUtils.loadAnimation(this.f2132c, C0264R.anim.action_bar_slide_out_bottom));
                }
                this.f2138i.setVisibility(8);
                m3660j(false);
            }
        }
    }

    boolean m3681f() {
        return this.f2128C;
    }

    public void m3682g(boolean z) {
        this.f2128C = z;
        if (!z) {
            this.f2135f.clearAnimation();
            if (this.f2138i != null) {
                this.f2138i.clearAnimation();
            }
        }
    }

    private void m3660j(boolean z) {
        if (this.f2138i.getChildCount() == 1 && (this.f2138i.getChildAt(0) instanceof PhoneActionMenuView)) {
            this.f2139j = (PhoneActionMenuView) this.f2138i.getChildAt(0);
            if (this.f2139j.m4549e() && this.f2140k != null) {
                if (z) {
                    this.f2134e.m4676a(this.f2141l).m4698a().start();
                } else {
                    this.f2134e.m4676a(null).m4699b().start();
                }
            }
        }
    }
}
