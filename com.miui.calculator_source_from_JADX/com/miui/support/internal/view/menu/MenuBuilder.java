package com.miui.support.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.miui.support.internal.C0264R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder implements Menu {
    private static final int[] f2673d;
    CharSequence f2674a;
    Drawable f2675b;
    View f2676c;
    private final Context f2677e;
    private final Resources f2678f;
    private boolean f2679g;
    private boolean f2680h;
    private Callback f2681i;
    private ArrayList<MenuItemImpl> f2682j;
    private ArrayList<MenuItemImpl> f2683k;
    private boolean f2684l;
    private ArrayList<MenuItemImpl> f2685m;
    private ArrayList<MenuItemImpl> f2686n;
    private boolean f2687o;
    private int f2688p;
    private ContextMenuInfo f2689q;
    private boolean f2690r;
    private boolean f2691s;
    private boolean f2692t;
    private boolean f2693u;
    private ArrayList<MenuItemImpl> f2694v;
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> f2695w;
    private MenuItemImpl f2696x;

    public interface Callback {
        boolean m3610a(MenuBuilder menuBuilder, MenuItem menuItem);

        void m3611c(MenuBuilder menuBuilder);
    }

    public interface ItemInvoker {
        boolean m4389a(MenuItemImpl menuItemImpl);
    }

    static {
        f2673d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public MenuBuilder(Context context) {
        this.f2688p = 0;
        this.f2690r = false;
        this.f2691s = false;
        this.f2692t = false;
        this.f2693u = false;
        this.f2694v = new ArrayList();
        this.f2695w = new CopyOnWriteArrayList();
        this.f2677e = context;
        this.f2678f = context.getResources();
        this.f2682j = new ArrayList();
        this.f2683k = new ArrayList();
        this.f2684l = true;
        this.f2685m = new ArrayList();
        this.f2686n = new ArrayList();
        this.f2687o = true;
        m4410d(true);
    }

    public MenuBuilder m4413a(int i) {
        this.f2688p = i;
        return this;
    }

    public void m4422a(MenuPresenter menuPresenter) {
        this.f2695w.add(new WeakReference(menuPresenter));
        menuPresenter.m4309a(this.f2677e, this);
        this.f2687o = true;
    }

    public void m4430b(MenuPresenter menuPresenter) {
        Iterator it = this.f2695w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) weakReference.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.f2695w.remove(weakReference);
            }
        }
    }

    private void m4409c(boolean z) {
        if (!this.f2695w.isEmpty()) {
            m4441f();
            Iterator it = this.f2695w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f2695w.remove(weakReference);
                } else {
                    menuPresenter.m4314d(z);
                }
            }
            m4442g();
        }
    }

    private boolean m4408a(SubMenuBuilder subMenuBuilder) {
        if (this.f2695w.isEmpty()) {
            return false;
        }
        Iterator it = this.f2695w.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            WeakReference weakReference = (WeakReference) it.next();
            MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
            if (menuPresenter == null) {
                this.f2695w.remove(weakReference);
                z2 = z;
            } else if (z) {
                z2 = z;
            } else {
                z2 = menuPresenter.m4312a(subMenuBuilder);
            }
            z = z2;
        }
        return z;
    }

    public void m4420a(Callback callback) {
        this.f2681i = callback;
    }

    private MenuItem m4405a(int i, int i2, int i3, CharSequence charSequence) {
        int f = m4411f(i3);
        MenuItem menuItemImpl = new MenuItemImpl(this, i, i2, i3, f, charSequence, this.f2688p);
        if (this.f2689q != null) {
            menuItemImpl.m4485a(this.f2689q);
        }
        this.f2682j.add(m4404a(this.f2682j, f), menuItemImpl);
        m4431b(true);
        return menuItemImpl;
    }

    public MenuItem add(CharSequence charSequence) {
        return m4405a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m4405a(0, 0, 0, this.f2678f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m4405a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m4405a(i, i2, i3, this.f2678f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f2678f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) m4405a(i, i2, i3, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f2677e, this, menuItemImpl);
        menuItemImpl.m4486a(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f2678f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f2677e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m4407a(m4428b(i), true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m4433c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f2682j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f2682j;
        r0 = r0.get(r3);
        r0 = (com.miui.support.internal.view.menu.MenuItemImpl) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m4407a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m4431b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.view.menu.MenuBuilder.removeGroup(int):void");
    }

    private void m4407a(int i, boolean z) {
        if (i >= 0 && i < this.f2682j.size()) {
            this.f2682j.remove(i);
            if (z) {
                m4431b(true);
            }
        }
    }

    public void clear() {
        if (this.f2696x != null) {
            m4438d(this.f2696x);
        }
        this.f2682j.clear();
        m4431b(true);
    }

    void m4419a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        Iterator it = this.f2682j.iterator();
        while (it.hasNext()) {
            MenuItem menuItem2 = (MenuItemImpl) it.next();
            if (menuItem2.getGroupId() == groupId && menuItem2.m4497f() && menuItem2.isCheckable()) {
                menuItem2.m4490b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        Iterator it = this.f2682j.iterator();
        while (it.hasNext()) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.m4487a(z2);
                menuItemImpl.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        Iterator it = this.f2682j.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            boolean z3;
            MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
            if (menuItemImpl.getGroupId() == i && menuItemImpl.m4492c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            z2 = z3;
        }
        if (z2) {
            m4431b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        Iterator it = this.f2682j.iterator();
        while (it.hasNext()) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
            if (menuItemImpl.getGroupId() == i) {
                menuItemImpl.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((MenuItemImpl) this.f2682j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.f2682j.get(i2);
            if (menuItemImpl.getItemId() == i) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu()) {
                MenuItem findItem = menuItemImpl.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m4428b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((MenuItemImpl) this.f2682j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m4433c(int i) {
        return m4412a(i, 0);
    }

    public int m4412a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((MenuItemImpl) this.f2682j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f2682j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f2682j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m4417a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f2679g = z;
        m4431b(false);
    }

    private static int m4411f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f2673d.length) {
            return (f2673d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean m4425a() {
        return this.f2679g;
    }

    private void m4410d(boolean z) {
        boolean z2 = true;
        if (!(z && this.f2678f.getConfiguration().keyboard != 1 && this.f2678f.getBoolean(C0264R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f2680h = z2;
    }

    public boolean m4432b() {
        return this.f2680h;
    }

    Resources m4434c() {
        return this.f2678f;
    }

    public Context m4436d() {
        return this.f2677e;
    }

    boolean m4427a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f2681i != null && this.f2681i.m3610a(menuBuilder, menuItem);
    }

    public void m4440e() {
        if (this.f2681i != null) {
            this.f2681i.m3611c(this);
        }
    }

    private static int m4404a(ArrayList<MenuItemImpl> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((MenuItemImpl) arrayList.get(size)).m4489b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m4417a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m4426a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m4424a(true);
        }
        return z;
    }

    void m4423a(List<MenuItemImpl> list, int i, KeyEvent keyEvent) {
        boolean a = m4425a();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            Iterator it = this.f2682j.iterator();
            while (it.hasNext()) {
                char alphabeticShortcut;
                MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).m4423a(list, i, keyEvent);
                }
                if (a) {
                    alphabeticShortcut = menuItemImpl.getAlphabeticShortcut();
                } else {
                    alphabeticShortcut = menuItemImpl.getNumericShortcut();
                }
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000') {
                    if ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (a && alphabeticShortcut == '\b' && i == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    MenuItemImpl m4417a(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f2694v;
        arrayList.clear();
        m4423a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        if (arrayList.size() == 1) {
            return (MenuItemImpl) arrayList.get(0);
        }
        boolean a = m4425a();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            char alphabeticShortcut;
            MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
            if (a) {
                alphabeticShortcut = menuItemImpl.getAlphabeticShortcut();
            } else {
                alphabeticShortcut = menuItemImpl.getNumericShortcut();
            }
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return menuItemImpl;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return menuItemImpl;
            }
            if (a && alphabeticShortcut == '\b' && i == 67) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m4426a(findItem(i), i2);
    }

    public boolean m4426a(MenuItem menuItem, int i) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean z;
        boolean a = menuItemImpl.m4488a();
        ActionProvider k = menuItemImpl.m4502k();
        if (k == null || !k.hasSubMenu()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (menuItemImpl.m4503l()) {
            expandActionView = menuItemImpl.expandActionView() | a;
            if (!expandActionView) {
                return expandActionView;
            }
            m4424a(true);
            return expandActionView;
        } else if (menuItemImpl.hasSubMenu() || z) {
            m4424a(false);
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.m4486a(new SubMenuBuilder(m4436d(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z) {
                k.onPrepareSubMenu(subMenuBuilder);
            }
            expandActionView = m4408a(subMenuBuilder) | a;
            if (expandActionView) {
                return expandActionView;
            }
            m4424a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m4424a(true);
            }
            return a;
        }
    }

    final void m4424a(boolean z) {
        if (!this.f2693u) {
            this.f2693u = true;
            Iterator it = this.f2695w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f2695w.remove(weakReference);
                } else {
                    menuPresenter.m4310a(this, z);
                }
            }
            this.f2693u = false;
        }
    }

    public void close() {
        m4424a(true);
    }

    void m4431b(boolean z) {
        if (this.f2690r) {
            this.f2691s = true;
            return;
        }
        if (z) {
            this.f2684l = true;
            this.f2687o = true;
        }
        m4409c(z);
    }

    public void m4441f() {
        if (!this.f2690r) {
            this.f2690r = true;
            this.f2691s = false;
        }
    }

    public void m4442g() {
        this.f2690r = false;
        if (this.f2691s) {
            this.f2691s = false;
            m4431b(true);
        }
    }

    void m4421a(MenuItemImpl menuItemImpl) {
        this.f2684l = true;
        m4431b(true);
    }

    void m4429b(MenuItemImpl menuItemImpl) {
        this.f2687o = true;
        m4431b(true);
    }

    public ArrayList<MenuItemImpl> m4443h() {
        if (!this.f2684l) {
            return this.f2683k;
        }
        this.f2683k.clear();
        Iterator it = this.f2682j.iterator();
        while (it.hasNext()) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
            if (menuItemImpl.isVisible()) {
                this.f2683k.add(menuItemImpl);
            }
        }
        this.f2684l = false;
        this.f2687o = true;
        return this.f2683k;
    }

    public void m4444i() {
        if (this.f2687o) {
            Iterator it = this.f2695w.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f2695w.remove(weakReference);
                    i2 = i;
                } else {
                    i2 = menuPresenter.m4315e() | i;
                }
                i = i2;
            }
            if (i != 0) {
                this.f2685m.clear();
                this.f2686n.clear();
                Iterator it2 = m4443h().iterator();
                while (it2.hasNext()) {
                    MenuItemImpl menuItemImpl = (MenuItemImpl) it2.next();
                    if (menuItemImpl.m4499h()) {
                        this.f2685m.add(menuItemImpl);
                    } else {
                        this.f2686n.add(menuItemImpl);
                    }
                }
            } else {
                this.f2685m.clear();
                this.f2686n.clear();
                this.f2686n.addAll(m4443h());
            }
            this.f2687o = false;
        }
    }

    public ArrayList<MenuItemImpl> m4445j() {
        m4444i();
        return this.f2686n;
    }

    public void clearHeader() {
        this.f2675b = null;
        this.f2674a = null;
        this.f2676c = null;
        m4431b(false);
    }

    private void m4406a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources c = m4434c();
        if (view != null) {
            this.f2676c = view;
            this.f2674a = null;
            this.f2675b = null;
        } else {
            if (i > 0) {
                this.f2674a = c.getText(i);
            } else if (charSequence != null) {
                this.f2674a = charSequence;
            }
            if (i2 > 0) {
                this.f2675b = c.getDrawable(i2);
            } else if (drawable != null) {
                this.f2675b = drawable;
            }
            this.f2676c = null;
        }
        m4431b(false);
    }

    protected MenuBuilder m4416a(CharSequence charSequence) {
        m4406a(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder m4437d(int i) {
        m4406a(i, null, 0, null, null);
        return this;
    }

    protected MenuBuilder m4414a(Drawable drawable) {
        m4406a(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder m4439e(int i) {
        m4406a(0, null, i, null, null);
        return this;
    }

    protected MenuBuilder m4415a(View view) {
        m4406a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m4446k() {
        return this.f2674a;
    }

    public Drawable m4447l() {
        return this.f2675b;
    }

    public View m4448m() {
        return this.f2676c;
    }

    public MenuBuilder m4449n() {
        return this;
    }

    public void m4418a(ContextMenuInfo contextMenuInfo) {
        this.f2689q = contextMenuInfo;
    }

    boolean m4450o() {
        return this.f2692t;
    }

    public boolean m4435c(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f2695w.isEmpty()) {
            m4441f();
            Iterator it = this.f2695w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f2695w.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.m4311a(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m4442g();
            if (z) {
                this.f2696x = menuItemImpl;
            }
        }
        return z;
    }

    public boolean m4438d(MenuItemImpl menuItemImpl) {
        boolean z = false;
        if (!this.f2695w.isEmpty() && this.f2696x == menuItemImpl) {
            m4441f();
            Iterator it = this.f2695w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                MenuPresenter menuPresenter = (MenuPresenter) weakReference.get();
                if (menuPresenter == null) {
                    this.f2695w.remove(weakReference);
                    z = z2;
                } else {
                    z = menuPresenter.m4313b(this, menuItemImpl);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m4442g();
            if (z) {
                this.f2696x = null;
            }
        }
        return z;
    }

    public MenuItemImpl m4451p() {
        return this.f2696x;
    }
}
