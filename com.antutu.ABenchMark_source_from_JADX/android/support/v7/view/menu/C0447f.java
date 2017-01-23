package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.C0417R;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import cn.sharesdk.framework.Platform;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.f */
public class C0447f implements SupportMenu {
    private static final int[] f1204d;
    CharSequence f1205a;
    Drawable f1206b;
    View f1207c;
    private final Context f1208e;
    private final Resources f1209f;
    private boolean f1210g;
    private boolean f1211h;
    private C0351a f1212i;
    private ArrayList<C0450h> f1213j;
    private ArrayList<C0450h> f1214k;
    private boolean f1215l;
    private ArrayList<C0450h> f1216m;
    private ArrayList<C0450h> f1217n;
    private boolean f1218o;
    private int f1219p;
    private ContextMenuInfo f1220q;
    private boolean f1221r;
    private boolean f1222s;
    private boolean f1223t;
    private boolean f1224u;
    private ArrayList<C0450h> f1225v;
    private CopyOnWriteArrayList<WeakReference<C0441l>> f1226w;
    private C0450h f1227x;
    private boolean f1228y;

    /* renamed from: android.support.v7.view.menu.f.a */
    public interface C0351a {
        void m912a(C0447f c0447f);

        boolean m913a(C0447f c0447f, MenuItem menuItem);
    }

    /* renamed from: android.support.v7.view.menu.f.b */
    public interface C0438b {
        boolean m1323a(C0450h c0450h);
    }

    static {
        f1204d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0447f(Context context) {
        this.f1219p = 0;
        this.f1221r = false;
        this.f1222s = false;
        this.f1223t = false;
        this.f1224u = false;
        this.f1225v = new ArrayList();
        this.f1226w = new CopyOnWriteArrayList();
        this.f1208e = context;
        this.f1209f = context.getResources();
        this.f1213j = new ArrayList();
        this.f1214k = new ArrayList();
        this.f1215l = true;
        this.f1216m = new ArrayList();
        this.f1217n = new ArrayList();
        this.f1218o = true;
        m1385e(true);
    }

    private static int m1378a(ArrayList<C0450h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0450h) arrayList.get(size)).m1443b() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0450h m1379a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0450h(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m1380a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m1415d();
        if (view != null) {
            this.f1207c = view;
            this.f1205a = null;
            this.f1206b = null;
        } else {
            if (i > 0) {
                this.f1205a = d.getText(i);
            } else if (charSequence != null) {
                this.f1205a = charSequence;
            }
            if (i2 > 0) {
                this.f1206b = ContextCompat.getDrawable(m1417e(), i2);
            } else if (drawable != null) {
                this.f1206b = drawable;
            }
            this.f1207c = null;
        }
        m1409b(false);
    }

    private void m1381a(int i, boolean z) {
        if (i >= 0 && i < this.f1213j.size()) {
            this.f1213j.remove(i);
            if (z) {
                m1409b(true);
            }
        }
    }

    private boolean m1382a(C0462p c0462p, C0441l c0441l) {
        boolean z = false;
        if (this.f1226w.isEmpty()) {
            return false;
        }
        if (c0441l != null) {
            z = c0441l.m1340a(c0462p);
        }
        Iterator it = this.f1226w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0441l c0441l2 = (C0441l) weakReference.get();
            if (c0441l2 == null) {
                this.f1226w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0441l2.m1340a(c0462p) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private static int m1383d(int i) {
        int i2 = (SupportMenu.CATEGORY_MASK & i) >> 16;
        if (i2 >= 0 && i2 < f1204d.length) {
            return (f1204d[i2] << 16) | (Platform.CUSTOMER_ACTION_MASK & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void m1384d(boolean z) {
        if (!this.f1226w.isEmpty()) {
            m1419g();
            Iterator it = this.f1226w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0441l c0441l = (C0441l) weakReference.get();
                if (c0441l == null) {
                    this.f1226w.remove(weakReference);
                } else {
                    c0441l.m1338a(z);
                }
            }
            m1420h();
        }
    }

    private void m1385e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1209f.getConfiguration().keyboard != 1 && this.f1209f.getBoolean(C0417R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1211h = z2;
    }

    public int m1386a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0450h) this.f1213j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0447f m1387a(int i) {
        this.f1219p = i;
        return this;
    }

    protected C0447f m1388a(Drawable drawable) {
        m1380a(0, null, 0, drawable, null);
        return this;
    }

    protected C0447f m1389a(View view) {
        m1380a(0, null, 0, null, view);
        return this;
    }

    protected C0447f m1390a(CharSequence charSequence) {
        m1380a(0, charSequence, 0, null, null);
        return this;
    }

    C0450h m1391a(int i, KeyEvent keyEvent) {
        List list = this.f1225v;
        list.clear();
        m1400a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0450h) list.get(0);
        }
        boolean b = m1410b();
        for (int i2 = 0; i2 < size; i2++) {
            C0450h c0450h = (C0450h) list.get(i2);
            char alphabeticShortcut = b ? c0450h.getAlphabeticShortcut() : c0450h.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0450h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0450h;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0450h;
            }
        }
        return null;
    }

    protected MenuItem m1392a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0447f.m1383d(i3);
        MenuItem a = m1379a(i, i2, i3, d, charSequence, this.f1219p);
        if (this.f1220q != null) {
            a.m1440a(this.f1220q);
        }
        this.f1213j.add(C0447f.m1378a(this.f1213j, d), a);
        m1409b(true);
        return a;
    }

    protected String m1393a() {
        return "android:menu:actionviewstates";
    }

    public void m1394a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View actionView = MenuItemCompat.getActionView(item);
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (MenuItemCompat.isActionViewExpanded(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0462p) item.getSubMenu()).m1394a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m1393a(), sparseArray);
        }
    }

    public void m1395a(C0351a c0351a) {
        this.f1212i = c0351a;
    }

    void m1396a(C0450h c0450h) {
        this.f1215l = true;
        m1409b(true);
    }

    public void m1397a(C0441l c0441l) {
        m1398a(c0441l, this.f1208e);
    }

    public void m1398a(C0441l c0441l, Context context) {
        this.f1226w.add(new WeakReference(c0441l));
        c0441l.m1336a(context, this);
        this.f1218o = true;
    }

    void m1399a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1213j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0450h) this.f1213j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m1452f() && menuItem2.isCheckable()) {
                menuItem2.m1445b(menuItem2 == menuItem);
            }
        }
    }

    void m1400a(List<C0450h> list, int i, KeyEvent keyEvent) {
        boolean b = m1410b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1213j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0450h c0450h = (C0450h) this.f1213j.get(i2);
                if (c0450h.hasSubMenu()) {
                    ((C0447f) c0450h.getSubMenu()).m1400a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0450h.getAlphabeticShortcut() : c0450h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0450h.isEnabled())) {
                    list.add(c0450h);
                }
            }
        }
    }

    public final void m1401a(boolean z) {
        if (!this.f1224u) {
            this.f1224u = true;
            Iterator it = this.f1226w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0441l c0441l = (C0441l) weakReference.get();
                if (c0441l == null) {
                    this.f1226w.remove(weakReference);
                } else {
                    c0441l.m1337a(this, z);
                }
            }
            this.f1224u = false;
        }
    }

    boolean m1402a(C0447f c0447f, MenuItem menuItem) {
        return this.f1212i != null && this.f1212i.m913a(c0447f, menuItem);
    }

    public boolean m1403a(MenuItem menuItem, int i) {
        return m1404a(menuItem, null, i);
    }

    public boolean m1404a(MenuItem menuItem, C0441l c0441l, int i) {
        C0450h c0450h = (C0450h) menuItem;
        if (c0450h == null || !c0450h.isEnabled()) {
            return false;
        }
        boolean a = c0450h.m1442a();
        ActionProvider supportActionProvider = c0450h.getSupportActionProvider();
        boolean z = supportActionProvider != null && supportActionProvider.hasSubMenu();
        boolean expandActionView;
        if (c0450h.m1459m()) {
            expandActionView = c0450h.expandActionView() | a;
            if (!expandActionView) {
                return expandActionView;
            }
            m1401a(true);
            return expandActionView;
        } else if (c0450h.hasSubMenu() || z) {
            m1401a(false);
            if (!c0450h.hasSubMenu()) {
                c0450h.m1439a(new C0462p(m1417e(), this, c0450h));
            }
            C0462p c0462p = (C0462p) c0450h.getSubMenu();
            if (z) {
                supportActionProvider.onPrepareSubMenu(c0462p);
            }
            expandActionView = m1382a(c0462p, c0441l) | a;
            if (expandActionView) {
                return expandActionView;
            }
            m1401a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m1401a(true);
            }
            return a;
        }
    }

    public MenuItem add(int i) {
        return m1392a(0, 0, 0, this.f1209f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1392a(i, i2, i3, this.f1209f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1392a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m1392a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1208e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1209f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1209f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0450h c0450h = (C0450h) m1392a(i, i2, i3, charSequence);
        C0462p c0462p = new C0462p(this.f1208e, this, c0450h);
        c0450h.m1439a(c0462p);
        return c0462p;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m1405b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0450h) this.f1213j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m1406b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m1393a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View actionView = MenuItemCompat.getActionView(item);
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0462p) item.getSubMenu()).m1406b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    MenuItemCompat.expandActionView(item);
                }
            }
        }
    }

    void m1407b(C0450h c0450h) {
        this.f1218o = true;
        m1409b(true);
    }

    public void m1408b(C0441l c0441l) {
        Iterator it = this.f1226w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0441l c0441l2 = (C0441l) weakReference.get();
            if (c0441l2 == null || c0441l2 == c0441l) {
                this.f1226w.remove(weakReference);
            }
        }
    }

    public void m1409b(boolean z) {
        if (this.f1221r) {
            this.f1222s = true;
            return;
        }
        if (z) {
            this.f1215l = true;
            this.f1218o = true;
        }
        m1384d(z);
    }

    boolean m1410b() {
        return this.f1210g;
    }

    public int m1411c(int i) {
        return m1386a(i, 0);
    }

    public void m1412c(boolean z) {
        this.f1228y = z;
    }

    public boolean m1413c() {
        return this.f1211h;
    }

    public boolean m1414c(C0450h c0450h) {
        boolean z = false;
        if (!this.f1226w.isEmpty()) {
            m1419g();
            Iterator it = this.f1226w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0441l c0441l = (C0441l) weakReference.get();
                if (c0441l == null) {
                    this.f1226w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0441l.m1339a(this, c0450h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1420h();
            if (z) {
                this.f1227x = c0450h;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1227x != null) {
            m1416d(this.f1227x);
        }
        this.f1213j.clear();
        m1409b(true);
    }

    public void clearHeader() {
        this.f1206b = null;
        this.f1205a = null;
        this.f1207c = null;
        m1409b(false);
    }

    public void close() {
        m1401a(true);
    }

    Resources m1415d() {
        return this.f1209f;
    }

    public boolean m1416d(C0450h c0450h) {
        boolean z = false;
        if (!this.f1226w.isEmpty() && this.f1227x == c0450h) {
            m1419g();
            Iterator it = this.f1226w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0441l c0441l = (C0441l) weakReference.get();
                if (c0441l == null) {
                    this.f1226w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0441l.m1342b(this, c0450h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m1420h();
            if (z) {
                this.f1227x = null;
            }
        }
        return z;
    }

    public Context m1417e() {
        return this.f1208e;
    }

    public void m1418f() {
        if (this.f1212i != null) {
            this.f1212i.m912a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0450h c0450h = (C0450h) this.f1213j.get(i2);
            if (c0450h.getItemId() == i) {
                return c0450h;
            }
            if (c0450h.hasSubMenu()) {
                MenuItem findItem = c0450h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m1419g() {
        if (!this.f1221r) {
            this.f1221r = true;
            this.f1222s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1213j.get(i);
    }

    public void m1420h() {
        this.f1221r = false;
        if (this.f1222s) {
            this.f1222s = false;
            m1409b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1228y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0450h) this.f1213j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<C0450h> m1421i() {
        if (!this.f1215l) {
            return this.f1214k;
        }
        this.f1214k.clear();
        int size = this.f1213j.size();
        for (int i = 0; i < size; i++) {
            C0450h c0450h = (C0450h) this.f1213j.get(i);
            if (c0450h.isVisible()) {
                this.f1214k.add(c0450h);
            }
        }
        this.f1215l = false;
        this.f1218o = true;
        return this.f1214k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1391a(i, keyEvent) != null;
    }

    public void m1422j() {
        ArrayList i = m1421i();
        if (this.f1218o) {
            Iterator it = this.f1226w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0441l c0441l = (C0441l) weakReference.get();
                if (c0441l == null) {
                    this.f1226w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0441l.m1341b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1216m.clear();
                this.f1217n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0450h c0450h = (C0450h) i.get(i4);
                    if (c0450h.m1455i()) {
                        this.f1216m.add(c0450h);
                    } else {
                        this.f1217n.add(c0450h);
                    }
                }
            } else {
                this.f1216m.clear();
                this.f1217n.clear();
                this.f1217n.addAll(m1421i());
            }
            this.f1218o = false;
        }
    }

    public ArrayList<C0450h> m1423k() {
        m1422j();
        return this.f1216m;
    }

    public ArrayList<C0450h> m1424l() {
        m1422j();
        return this.f1217n;
    }

    public CharSequence m1425m() {
        return this.f1205a;
    }

    public Drawable m1426n() {
        return this.f1206b;
    }

    public View m1427o() {
        return this.f1207c;
    }

    public C0447f m1428p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m1403a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m1391a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m1403a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m1401a(true);
        }
        return z;
    }

    boolean m1429q() {
        return this.f1223t;
    }

    public C0450h m1430r() {
        return this.f1227x;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m1411c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f1213j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f1213j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.view.menu.C0450h) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m1381a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m1409b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.f.removeGroup(int):void");
    }

    public void removeItem(int i) {
        m1381a(m1405b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1213j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0450h c0450h = (C0450h) this.f1213j.get(i2);
            if (c0450h.getGroupId() == i) {
                c0450h.m1441a(z2);
                c0450h.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1213j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0450h c0450h = (C0450h) this.f1213j.get(i2);
            if (c0450h.getGroupId() == i) {
                c0450h.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1213j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0450h c0450h = (C0450h) this.f1213j.get(i2);
            boolean z3 = (c0450h.getGroupId() == i && c0450h.m1447c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m1409b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1210g = z;
        m1409b(false);
    }

    public int size() {
        return this.f1213j.size();
    }
}
