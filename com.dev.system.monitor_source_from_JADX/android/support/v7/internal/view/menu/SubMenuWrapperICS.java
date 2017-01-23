package android.support.v7.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class SubMenuWrapperICS extends MenuWrapperICS implements SupportSubMenu {
    SubMenuWrapperICS(SubMenu subMenu) {
        super(subMenu);
    }

    public SubMenu getWrappedObject() {
        return (SubMenu) this.mWrappedObject;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        ((SubMenu) this.mWrappedObject).setHeaderTitle(titleRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        ((SubMenu) this.mWrappedObject).setHeaderTitle(title);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        ((SubMenu) this.mWrappedObject).setHeaderIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        ((SubMenu) this.mWrappedObject).setHeaderIcon(icon);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        ((SubMenu) this.mWrappedObject).setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        ((SubMenu) this.mWrappedObject).clearHeader();
    }

    public SubMenu setIcon(int iconRes) {
        ((SubMenu) this.mWrappedObject).setIcon(iconRes);
        return this;
    }

    public SubMenu setIcon(Drawable icon) {
        ((SubMenu) this.mWrappedObject).setIcon(icon);
        return this;
    }

    public MenuItem getItem() {
        return getMenuItemWrapper(((SubMenu) this.mWrappedObject).getItem());
    }
}
