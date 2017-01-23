package com.miui.support.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;

public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuBuilder f2831d;
    private MenuItemImpl f2832e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f2831d = menuBuilder;
        this.f2832e = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f2831d.setQwertyMode(z);
    }

    public boolean m4583a() {
        return this.f2831d.m4425a();
    }

    public boolean m4585b() {
        return this.f2831d.m4432b();
    }

    public Menu m4589q() {
        return this.f2831d;
    }

    public MenuItem getItem() {
        return this.f2832e;
    }

    public void m4582a(Callback callback) {
        this.f2831d.m4420a(callback);
    }

    public MenuBuilder m4588n() {
        return this.f2831d;
    }

    public boolean m4584a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.m4427a(menuBuilder, menuItem) || this.f2831d.m4427a(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f2832e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f2832e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m4414a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m4414a(m4436d().getResources().getDrawable(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m4416a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m4416a(m4436d().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m4415a(view);
        return this;
    }

    public void clearHeader() {
    }

    public boolean m4586c(MenuItemImpl menuItemImpl) {
        return this.f2831d.m4435c(menuItemImpl);
    }

    public boolean m4587d(MenuItemImpl menuItemImpl) {
        return this.f2831d.m4438d(menuItemImpl);
    }
}
