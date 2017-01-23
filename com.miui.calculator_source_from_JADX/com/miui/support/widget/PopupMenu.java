package com.miui.support.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import com.miui.support.internal.view.menu.MenuPopupHelper;
import com.miui.support.internal.view.menu.MenuPresenter;

public class PopupMenu {
    private Context f4317a;
    private View f4318b;
    private OnMenuItemClickListener f4319c;
    private OnDismissListener f4320d;

    /* renamed from: com.miui.support.widget.PopupMenu.1 */
    class C04991 implements Callback {
        final /* synthetic */ PopupMenu f4315a;

        public boolean m5998a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.f4315a.m6006a(menuBuilder, menuItem);
        }

        public void m5999c(MenuBuilder menuBuilder) {
            this.f4315a.m6007b(menuBuilder);
        }
    }

    /* renamed from: com.miui.support.widget.PopupMenu.2 */
    class C05002 implements MenuPresenter.Callback {
        final /* synthetic */ PopupMenu f4316a;

        public void m6000b(MenuBuilder menuBuilder, boolean z) {
            this.f4316a.m6004a(menuBuilder, z);
        }

        public boolean m6001b(MenuBuilder menuBuilder) {
            return this.f4316a.m6005a(menuBuilder);
        }
    }

    public interface OnDismissListener {
        void m6002a(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean m6003a(MenuItem menuItem);
    }

    public boolean m6006a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f4319c != null) {
            return this.f4319c.m6003a(menuItem);
        }
        return false;
    }

    public void m6004a(MenuBuilder menuBuilder, boolean z) {
        if (this.f4320d != null) {
            this.f4320d.m6002a(this);
        }
    }

    public boolean m6005a(MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            return false;
        }
        if (!menuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.f4317a, menuBuilder, this.f4318b).m4332c();
        return true;
    }

    public void m6007b(MenuBuilder menuBuilder) {
    }
}
