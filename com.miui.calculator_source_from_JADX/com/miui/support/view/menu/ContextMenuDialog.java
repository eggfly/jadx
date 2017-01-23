package com.miui.support.view.menu;

import android.view.MenuItem;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import java.util.List;

public class ContextMenuDialog {
    private final List<Runnable> f3937a;

    /* renamed from: com.miui.support.view.menu.ContextMenuDialog.1 */
    class C04511 implements Callback {
        final /* synthetic */ ContextMenuDialog f3936a;

        public boolean m5665a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ((Runnable) this.f3936a.f3937a.get(menuItem.getItemId())).run();
            return true;
        }

        public void m5666c(MenuBuilder menuBuilder) {
        }
    }

    private static class ContextMenuBuilder extends MenuBuilder {
    }
}
