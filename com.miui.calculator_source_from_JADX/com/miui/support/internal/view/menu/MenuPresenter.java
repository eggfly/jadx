package com.miui.support.internal.view.menu;

import android.content.Context;

public interface MenuPresenter {

    public interface Callback {
        void m3612b(MenuBuilder menuBuilder, boolean z);

        boolean m3613b(MenuBuilder menuBuilder);
    }

    void m4309a(Context context, MenuBuilder menuBuilder);

    void m4310a(MenuBuilder menuBuilder, boolean z);

    boolean m4311a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    boolean m4312a(SubMenuBuilder subMenuBuilder);

    boolean m4313b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void m4314d(boolean z);

    boolean m4315e();
}
