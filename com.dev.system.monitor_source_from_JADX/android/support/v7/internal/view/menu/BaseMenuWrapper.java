package android.support.v7.internal.view.menu;

import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;

abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    private HashMap<MenuItem, SupportMenuItem> mMenuItems;
    private HashMap<SubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(T object) {
        super(object);
    }

    final SupportMenuItem getMenuItemWrapper(MenuItem frameworkItem) {
        if (frameworkItem == null) {
            return null;
        }
        if (this.mMenuItems == null) {
            this.mMenuItems = new HashMap();
        }
        SupportMenuItem compatItem = (SupportMenuItem) this.mMenuItems.get(frameworkItem);
        if (compatItem != null) {
            return compatItem;
        }
        compatItem = MenuWrapperFactory.createSupportMenuItemWrapper(frameworkItem);
        this.mMenuItems.put(frameworkItem, compatItem);
        return compatItem;
    }

    final SubMenu getSubMenuWrapper(SubMenu frameworkSubMenu) {
        if (frameworkSubMenu == null) {
            return null;
        }
        if (this.mSubMenus == null) {
            this.mSubMenus = new HashMap();
        }
        SubMenu compatSubMenu = (SubMenu) this.mSubMenus.get(frameworkSubMenu);
        if (compatSubMenu != null) {
            return compatSubMenu;
        }
        compatSubMenu = MenuWrapperFactory.createSupportSubMenuWrapper(frameworkSubMenu);
        this.mSubMenus.put(frameworkSubMenu, compatSubMenu);
        return compatSubMenu;
    }

    final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    final void internalRemoveGroup(int groupId) {
        if (this.mMenuItems != null) {
            Iterator<MenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == ((MenuItem) iterator.next()).getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    final void internalRemoveItem(int id) {
        if (this.mMenuItems != null) {
            Iterator<MenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (id == ((MenuItem) iterator.next()).getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
