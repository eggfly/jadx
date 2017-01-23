package com.aide.ui.views;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class DialogMenu implements Menu {
    private Context DW;
    private List<a> j6;

    public class a implements MenuItem {
        private CharSequence DW;
        private int FH;
        private int Hw;
        private SubMenu VH;
        private Drawable Zo;
        private boolean gn;
        final /* synthetic */ DialogMenu j6;
        private int tp;
        private boolean u7;
        private int v5;

        public a(DialogMenu dialogMenu, int i) {
            this.j6 = dialogMenu;
            this.DW = dialogMenu.j6().getResources().getString(i);
        }

        public a(DialogMenu dialogMenu, CharSequence charSequence) {
            this.j6 = dialogMenu;
            this.DW = charSequence.toString();
        }

        public a(DialogMenu dialogMenu, int i, int i2, int i3, CharSequence charSequence) {
            this.j6 = dialogMenu;
            this.Hw = i;
            this.FH = i2;
            this.v5 = i3;
            this.DW = charSequence.toString();
        }

        public a(DialogMenu dialogMenu, int i, int i2, int i3, int i4) {
            this.j6 = dialogMenu;
            this.Hw = i;
            this.FH = i2;
            this.v5 = i3;
            this.DW = dialogMenu.j6().getResources().getString(i4);
        }

        public int getItemId() {
            return this.FH;
        }

        public int getGroupId() {
            return this.Hw;
        }

        public int getOrder() {
            return this.v5;
        }

        public MenuItem setTitle(CharSequence charSequence) {
            this.DW = charSequence.toString();
            return this;
        }

        public MenuItem setTitle(int i) {
            this.DW = this.j6.j6().getResources().getString(i);
            return this;
        }

        public CharSequence getTitle() {
            return this.DW;
        }

        public MenuItem setTitleCondensed(CharSequence charSequence) {
            return this;
        }

        public CharSequence getTitleCondensed() {
            return "";
        }

        public MenuItem setIcon(Drawable drawable) {
            this.Zo = drawable;
            return this;
        }

        public MenuItem setIcon(int i) {
            this.tp = i;
            return this;
        }

        public Drawable getIcon() {
            return this.Zo;
        }

        public MenuItem setIntent(Intent intent) {
            return this;
        }

        public Intent getIntent() {
            return null;
        }

        public MenuItem setShortcut(char c, char c2) {
            return this;
        }

        public MenuItem setNumericShortcut(char c) {
            return this;
        }

        public char getNumericShortcut() {
            return '\u0000';
        }

        public MenuItem setAlphabeticShortcut(char c) {
            return this;
        }

        public char getAlphabeticShortcut() {
            return '\u0000';
        }

        public MenuItem setCheckable(boolean z) {
            return this;
        }

        public boolean isCheckable() {
            return false;
        }

        public MenuItem setChecked(boolean z) {
            return this;
        }

        public boolean isChecked() {
            return false;
        }

        public MenuItem setVisible(boolean z) {
            this.u7 = z;
            return this;
        }

        public boolean isVisible() {
            return this.u7;
        }

        public MenuItem setEnabled(boolean z) {
            this.gn = z;
            return this;
        }

        public boolean isEnabled() {
            return this.gn;
        }

        public void j6(SubMenu subMenu) {
            this.VH = subMenu;
        }

        public boolean hasSubMenu() {
            return this.VH != null;
        }

        public SubMenu getSubMenu() {
            return this.VH;
        }

        public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
            return this;
        }

        public ContextMenuInfo getMenuInfo() {
            return null;
        }

        public View getActionView() {
            return null;
        }

        public MenuItem setActionView(View view) {
            return null;
        }

        public MenuItem setActionView(int i) {
            return null;
        }

        public void setShowAsAction(int i) {
        }

        public MenuItem setShowAsActionFlags(int i) {
            return null;
        }

        public MenuItem setActionProvider(ActionProvider actionProvider) {
            return null;
        }

        public ActionProvider getActionProvider() {
            return null;
        }

        public boolean expandActionView() {
            return false;
        }

        public boolean collapseActionView() {
            return false;
        }

        public boolean isActionViewExpanded() {
            return false;
        }

        public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
            return null;
        }
    }

    private class b extends DialogMenu implements SubMenu {
        private a DW;
        final /* synthetic */ DialogMenu j6;

        public b(DialogMenu dialogMenu, Context context, DialogMenu dialogMenu2, a aVar) {
            this.j6 = dialogMenu;
            super(context);
            this.DW = aVar;
        }

        public SubMenu setHeaderTitle(int i) {
            return this;
        }

        public SubMenu setHeaderTitle(CharSequence charSequence) {
            return this;
        }

        public SubMenu setHeaderIcon(int i) {
            return this;
        }

        public SubMenu setHeaderIcon(Drawable drawable) {
            return this;
        }

        public SubMenu setHeaderView(View view) {
            return this;
        }

        public void clearHeader() {
        }

        public SubMenu setIcon(int i) {
            return this;
        }

        public SubMenu setIcon(Drawable drawable) {
            return this;
        }

        public MenuItem getItem() {
            return this.DW;
        }
    }

    public DialogMenu(Context context) {
        this.j6 = new ArrayList();
        this.DW = context;
    }

    public Context j6() {
        return this.DW;
    }

    public MenuItem add(CharSequence charSequence) {
        MenuItem aVar = new a(this, charSequence);
        this.j6.add(aVar);
        return aVar;
    }

    public MenuItem add(int i) {
        MenuItem aVar = new a(this, i);
        this.j6.add(aVar);
        return aVar;
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem aVar = new a(this, i, i2, i3, charSequence);
        this.j6.add(aVar);
        return aVar;
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        MenuItem aVar = new a(this, i, i2, i3, i4);
        this.j6.add(aVar);
        return aVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        a aVar = new a(this, charSequence);
        this.j6.add(aVar);
        SubMenu bVar = new b(this, this.DW, this, aVar);
        aVar.j6(bVar);
        return bVar;
    }

    public SubMenu addSubMenu(int i) {
        a aVar = new a(this, i);
        this.j6.add(aVar);
        SubMenu bVar = new b(this, this.DW, this, aVar);
        aVar.j6(bVar);
        return bVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        a aVar = new a(this, i, i2, i3, charSequence);
        this.j6.add(aVar);
        SubMenu bVar = new b(this, this.DW, this, aVar);
        aVar.j6(bVar);
        return bVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        a aVar = new a(this, i, i2, i3, i4);
        this.j6.add(aVar);
        SubMenu bVar = new b(this, this.DW, this, aVar);
        aVar.j6(bVar);
        return bVar;
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public void removeItem(int i) {
    }

    public void removeGroup(int i) {
    }

    public void clear() {
        this.j6.clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public void setGroupVisible(int i, boolean z) {
    }

    public void setGroupEnabled(int i, boolean z) {
    }

    public boolean hasVisibleItems() {
        return true;
    }

    public MenuItem findItem(int i) {
        return null;
    }

    public int size() {
        return this.j6.size();
    }

    public MenuItem getItem(int i) {
        return null;
    }

    public void close() {
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public void setQwertyMode(boolean z) {
    }
}
