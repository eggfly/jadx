package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.o */
class C0461o extends C0444c<SupportMenu> implements Menu {
    C0461o(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    public MenuItem add(int i) {
        return m1360a(((SupportMenu) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1360a(((SupportMenu) this.b).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1360a(((SupportMenu) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return m1360a(((SupportMenu) this.b).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((SupportMenu) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m1360a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return m1361a(((SupportMenu) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m1361a(((SupportMenu) this.b).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m1361a(((SupportMenu) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m1361a(((SupportMenu) this.b).addSubMenu(charSequence));
    }

    public void clear() {
        m1362a();
        ((SupportMenu) this.b).clear();
    }

    public void close() {
        ((SupportMenu) this.b).close();
    }

    public MenuItem findItem(int i) {
        return m1360a(((SupportMenu) this.b).findItem(i));
    }

    public MenuItem getItem(int i) {
        return m1360a(((SupportMenu) this.b).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((SupportMenu) this.b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.b).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.b).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        m1363a(i);
        ((SupportMenu) this.b).removeGroup(i);
    }

    public void removeItem(int i) {
        m1364b(i);
        ((SupportMenu) this.b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.b).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.b).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.b).setQwertyMode(z);
    }

    public int size() {
        return ((SupportMenu) this.b).size();
    }
}
