package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.q */
class C0463q extends C0461o implements SubMenu {
    C0463q(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public SupportSubMenu m1501b() {
        return (SupportSubMenu) this.b;
    }

    public void clearHeader() {
        m1501b().clearHeader();
    }

    public MenuItem getItem() {
        return m1360a(m1501b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m1501b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m1501b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m1501b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m1501b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m1501b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m1501b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m1501b().setIcon(drawable);
        return this;
    }
}
