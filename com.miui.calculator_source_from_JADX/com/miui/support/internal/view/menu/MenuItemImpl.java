package com.miui.support.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.internal.view.menu.MenuView.ItemView;

public final class MenuItemImpl implements MenuItem {
    private static String f2728w;
    private static String f2729x;
    private static String f2730y;
    private static String f2731z;
    private final int f2732a;
    private final int f2733b;
    private final int f2734c;
    private final int f2735d;
    private CharSequence f2736e;
    private CharSequence f2737f;
    private Intent f2738g;
    private char f2739h;
    private char f2740i;
    private Drawable f2741j;
    private int f2742k;
    private MenuBuilder f2743l;
    private SubMenuBuilder f2744m;
    private Runnable f2745n;
    private OnMenuItemClickListener f2746o;
    private int f2747p;
    private int f2748q;
    private View f2749r;
    private ActionProvider f2750s;
    private OnActionExpandListener f2751t;
    private boolean f2752u;
    private ContextMenuInfo f2753v;

    /* renamed from: com.miui.support.internal.view.menu.MenuItemImpl.1 */
    class C03611 implements VisibilityListener {
        final /* synthetic */ MenuItemImpl f2727a;

        public void onActionProviderVisibilityChanged(boolean z) {
            this.f2727a.f2743l.m4421a(this.f2727a);
        }
    }

    MenuItemImpl(MenuBuilder menuBuilder, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f2742k = 0;
        this.f2747p = 16;
        this.f2748q = 0;
        this.f2752u = false;
        this.f2743l = menuBuilder;
        this.f2732a = i2;
        this.f2733b = i;
        this.f2734c = i3;
        this.f2735d = i4;
        this.f2736e = charSequence;
        this.f2748q = i5;
    }

    public boolean m4488a() {
        if ((this.f2746o != null && this.f2746o.onMenuItemClick(this)) || this.f2743l.m4427a(this.f2743l.m4449n(), (MenuItem) this)) {
            return true;
        }
        if (this.f2745n != null) {
            this.f2745n.run();
            return true;
        }
        if (this.f2738g != null) {
            try {
                this.f2743l.m4436d().startActivity(this.f2738g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f2750s == null || !this.f2750s.onPerformDefaultAction()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f2747p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f2747p |= 16;
        } else {
            this.f2747p &= -17;
        }
        this.f2743l.m4431b(false);
        return this;
    }

    public int getGroupId() {
        return this.f2733b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f2732a;
    }

    public int getOrder() {
        return this.f2734c;
    }

    public int m4489b() {
        return this.f2735d;
    }

    public Intent getIntent() {
        return this.f2738g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2738g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f2740i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f2740i != c) {
            this.f2740i = Character.toLowerCase(c);
            this.f2743l.m4431b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f2739h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f2739h != c) {
            this.f2739h = c;
            this.f2743l.m4431b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f2739h = c;
        this.f2740i = Character.toLowerCase(c2);
        this.f2743l.m4431b(false);
        return this;
    }

    char m4491c() {
        return this.f2740i;
    }

    String m4493d() {
        char c = m4491c();
        if (c == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f2728w);
        switch (c) {
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                stringBuilder.append(f2730y);
                break;
            case C0264R.styleable.Window_windowMaxWidthMinor /*10*/:
                stringBuilder.append(f2729x);
                break;
            case ' ':
                stringBuilder.append(f2731z);
                break;
            default:
                stringBuilder.append(c);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m4496e() {
        return this.f2743l.m4432b() && m4491c() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f2744m;
    }

    public boolean hasSubMenu() {
        return this.f2744m != null;
    }

    void m4486a(SubMenuBuilder subMenuBuilder) {
        this.f2744m = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2736e;
    }

    CharSequence m4484a(ItemView itemView) {
        if (itemView == null || !itemView.m4290a()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f2736e = charSequence;
        this.f2743l.m4431b(false);
        if (this.f2744m != null) {
            this.f2744m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f2743l.m4436d().getString(i));
    }

    public CharSequence getTitleCondensed() {
        return this.f2737f != null ? this.f2737f : this.f2736e;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f2737f = charSequence;
        this.f2743l.m4431b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f2741j != null) {
            return this.f2741j;
        }
        if (this.f2742k == 0) {
            return null;
        }
        Drawable drawable = this.f2743l.m4434c().getDrawable(this.f2742k);
        this.f2742k = 0;
        this.f2741j = drawable;
        return drawable;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f2742k = 0;
        this.f2741j = drawable;
        this.f2743l.m4431b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f2741j = null;
        this.f2742k = i;
        this.f2743l.m4431b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f2747p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f2747p;
        this.f2747p = (z ? 1 : 0) | (this.f2747p & -2);
        if (i != this.f2747p) {
            this.f2743l.m4431b(false);
        }
        return this;
    }

    public void m4487a(boolean z) {
        this.f2747p = (z ? 4 : 0) | (this.f2747p & -5);
    }

    public boolean m4497f() {
        return (this.f2747p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f2747p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f2747p & 4) != 0) {
            this.f2743l.m4419a((MenuItem) this);
        } else {
            m4490b(z);
        }
        return this;
    }

    void m4490b(boolean z) {
        int i;
        int i2 = this.f2747p;
        int i3 = this.f2747p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f2747p = i | i3;
        if (i2 != this.f2747p) {
            this.f2743l.m4431b(false);
        }
    }

    public boolean isVisible() {
        if (this.f2750s == null || !this.f2750s.overridesItemVisibility()) {
            if ((this.f2747p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f2747p & 8) == 0 && this.f2750s.isVisible()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m4492c(boolean z) {
        int i = this.f2747p;
        this.f2747p = (z ? 0 : 8) | (this.f2747p & -9);
        if (i != this.f2747p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m4492c(z)) {
            this.f2743l.m4421a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2746o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f2736e.toString();
    }

    void m4485a(ContextMenuInfo contextMenuInfo) {
        this.f2753v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f2753v;
    }

    public boolean m4498g() {
        return this.f2743l.m4450o();
    }

    public boolean m4499h() {
        return (this.f2747p & 32) == 32;
    }

    public boolean m4500i() {
        return (this.f2748q & 1) == 1;
    }

    public boolean m4501j() {
        return (this.f2748q & 2) == 2;
    }

    public void m4494d(boolean z) {
        if (z) {
            this.f2747p |= 32;
        } else {
            this.f2747p &= -33;
        }
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f2748q = i;
                this.f2743l.m4429b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public MenuItem setActionView(View view) {
        this.f2749r = view;
        this.f2750s = null;
        if (view != null && view.getId() == -1 && this.f2732a > 0) {
            view.setId(this.f2732a);
        }
        this.f2743l.m4429b(this);
        return this;
    }

    public MenuItem setActionView(int i) {
        Context d = this.f2743l.m4436d();
        setActionView(LayoutInflater.from(d).inflate(i, new LinearLayout(d), false));
        return this;
    }

    public View getActionView() {
        if (this.f2749r != null) {
            return this.f2749r;
        }
        if (this.f2750s == null) {
            return null;
        }
        this.f2749r = this.f2750s.onCreateActionView(this);
        return this.f2749r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("Implementation should use setSupportActionProvider!");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("Implementation should use getSupportActionProvider!");
    }

    public ActionProvider m4502k() {
        return this.f2750s;
    }

    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return ((this.f2748q & 8) == 0 || this.f2749r == null || ((this.f2751t != null && !this.f2751t.onMenuItemActionExpand(this)) || !this.f2743l.m4435c(this))) ? false : true;
    }

    public boolean collapseActionView() {
        return (this.f2748q & 8) != 0 && (this.f2749r == null || ((this.f2751t == null || this.f2751t.onMenuItemActionCollapse(this)) && this.f2743l.m4438d(this)));
    }

    public boolean m4503l() {
        return ((this.f2748q & 8) == 0 || this.f2749r == null) ? false : true;
    }

    public void m4495e(boolean z) {
        this.f2752u = z;
        this.f2743l.m4431b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f2752u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("Implementation should use setSupportOnActionExpandListener!");
    }
}
