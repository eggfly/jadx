package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.c */
abstract class C0444c<T> extends C0443d<T> {
    final Context f1190a;
    private Map<SupportMenuItem, MenuItem> f1191c;
    private Map<SupportSubMenu, SubMenu> f1192d;

    C0444c(Context context, T t) {
        super(t);
        this.f1190a = context;
    }

    final MenuItem m1360a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f1191c == null) {
            this.f1191c = new ArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f1191c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0460n.m1490a(this.f1190a, supportMenuItem);
        this.f1191c.put(supportMenuItem, menuItem2);
        return menuItem2;
    }

    final SubMenu m1361a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f1192d == null) {
            this.f1192d = new ArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f1192d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0460n.m1491a(this.f1190a, supportSubMenu);
        this.f1192d.put(supportSubMenu, subMenu2);
        return subMenu2;
    }

    final void m1362a() {
        if (this.f1191c != null) {
            this.f1191c.clear();
        }
        if (this.f1192d != null) {
            this.f1192d.clear();
        }
    }

    final void m1363a(int i) {
        if (this.f1191c != null) {
            Iterator it = this.f1191c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m1364b(int i) {
        if (this.f1191c != null) {
            Iterator it = this.f1191c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
