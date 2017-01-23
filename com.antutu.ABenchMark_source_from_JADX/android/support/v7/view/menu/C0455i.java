package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.view.C0423c;
import android.util.Log;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.view.menu.i */
public class C0455i extends C0444c<SupportMenuItem> implements MenuItem {
    private Method f1265c;

    /* renamed from: android.support.v7.view.menu.i.a */
    class C0451a extends ActionProvider {
        final android.view.ActionProvider f1260a;
        final /* synthetic */ C0455i f1261b;

        public C0451a(C0455i c0455i, Context context, android.view.ActionProvider actionProvider) {
            this.f1261b = c0455i;
            super(context);
            this.f1260a = actionProvider;
        }

        public boolean hasSubMenu() {
            return this.f1260a.hasSubMenu();
        }

        public View onCreateActionView() {
            return this.f1260a.onCreateActionView();
        }

        public boolean onPerformDefaultAction() {
            return this.f1260a.onPerformDefaultAction();
        }

        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f1260a.onPrepareSubMenu(this.f1261b.m1361a(subMenu));
        }
    }

    /* renamed from: android.support.v7.view.menu.i.b */
    static class C0452b extends FrameLayout implements C0423c {
        final CollapsibleActionView f1262a;

        C0452b(View view) {
            super(view.getContext());
            this.f1262a = (CollapsibleActionView) view;
            addView(view);
        }

        public void m1460a() {
            this.f1262a.onActionViewExpanded();
        }

        public void m1461b() {
            this.f1262a.onActionViewCollapsed();
        }

        View m1462c() {
            return (View) this.f1262a;
        }
    }

    /* renamed from: android.support.v7.view.menu.i.c */
    private class C0453c extends C0443d<OnActionExpandListener> implements MenuItemCompat.OnActionExpandListener {
        final /* synthetic */ C0455i f1263a;

        C0453c(C0455i c0455i, OnActionExpandListener onActionExpandListener) {
            this.f1263a = c0455i;
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1263a.m1360a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1263a.m1360a(menuItem));
        }
    }

    /* renamed from: android.support.v7.view.menu.i.d */
    private class C0454d extends C0443d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0455i f1264a;

        C0454d(C0455i c0455i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1264a = c0455i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1264a.m1360a(menuItem));
        }
    }

    C0455i(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    C0451a m1463a(android.view.ActionProvider actionProvider) {
        return new C0451a(this, this.a, actionProvider);
    }

    public void m1464a(boolean z) {
        try {
            if (this.f1265c == null) {
                this.f1265c = ((SupportMenuItem) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1265c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((SupportMenuItem) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((SupportMenuItem) this.b).expandActionView();
    }

    public android.view.ActionProvider getActionProvider() {
        ActionProvider supportActionProvider = ((SupportMenuItem) this.b).getSupportActionProvider();
        return supportActionProvider instanceof C0451a ? ((C0451a) supportActionProvider).f1260a : null;
    }

    public View getActionView() {
        View actionView = ((SupportMenuItem) this.b).getActionView();
        return actionView instanceof C0452b ? ((C0452b) actionView).m1462c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((SupportMenuItem) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((SupportMenuItem) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((SupportMenuItem) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((SupportMenuItem) this.b).getIntent();
    }

    public int getItemId() {
        return ((SupportMenuItem) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((SupportMenuItem) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((SupportMenuItem) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((SupportMenuItem) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m1361a(((SupportMenuItem) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((SupportMenuItem) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((SupportMenuItem) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((SupportMenuItem) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((SupportMenuItem) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((SupportMenuItem) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((SupportMenuItem) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((SupportMenuItem) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((SupportMenuItem) this.b).isVisible();
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        ((SupportMenuItem) this.b).setSupportActionProvider(actionProvider != null ? m1463a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((SupportMenuItem) this.b).setActionView(i);
        View actionView = ((SupportMenuItem) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((SupportMenuItem) this.b).setActionView(new C0452b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0452b(view);
        }
        ((SupportMenuItem) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((SupportMenuItem) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((SupportMenuItem) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((SupportMenuItem) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((SupportMenuItem) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((SupportMenuItem) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((SupportMenuItem) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((SupportMenuItem) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((SupportMenuItem) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((SupportMenuItem) this.b).setSupportOnActionExpandListener(onActionExpandListener != null ? new C0453c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((SupportMenuItem) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0454d(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((SupportMenuItem) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((SupportMenuItem) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((SupportMenuItem) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((SupportMenuItem) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((SupportMenuItem) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((SupportMenuItem) this.b).setVisible(z);
    }
}
