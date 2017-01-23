package com.miui.support.internal.view.menu;

import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;

public interface MenuView {

    public interface ItemView {
        void m4289a(MenuItemImpl menuItemImpl, int i);

        boolean m4290a();

        MenuItemImpl getItemData();

        void setItemInvoker(ItemInvoker itemInvoker);
    }

    void m4390a(MenuBuilder menuBuilder);

    boolean m4391a(int i);

    boolean m4392c();
}
