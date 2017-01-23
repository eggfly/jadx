package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ActionProvider.VisibilityListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.view.menu.C0439m.C0436a;
import android.support.v7.widget.C0616l;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.xiaomi.pushsdk.BuildConfig;
import org.android.agoo.common.C4574a;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.view.menu.h */
public final class C0450h implements SupportMenuItem {
    private static String f1234w;
    private static String f1235x;
    private static String f1236y;
    private static String f1237z;
    private final int f1238a;
    private final int f1239b;
    private final int f1240c;
    private final int f1241d;
    private CharSequence f1242e;
    private CharSequence f1243f;
    private Intent f1244g;
    private char f1245h;
    private char f1246i;
    private Drawable f1247j;
    private int f1248k;
    private C0447f f1249l;
    private C0462p f1250m;
    private Runnable f1251n;
    private OnMenuItemClickListener f1252o;
    private int f1253p;
    private int f1254q;
    private View f1255r;
    private ActionProvider f1256s;
    private OnActionExpandListener f1257t;
    private boolean f1258u;
    private ContextMenuInfo f1259v;

    /* renamed from: android.support.v7.view.menu.h.1 */
    class C04491 implements VisibilityListener {
        final /* synthetic */ C0450h f1233a;

        C04491(C0450h c0450h) {
            this.f1233a = c0450h;
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            this.f1233a.f1249l.m1396a(this.f1233a);
        }
    }

    C0450h(C0447f c0447f, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1248k = 0;
        this.f1253p = 16;
        this.f1254q = 0;
        this.f1258u = false;
        this.f1249l = c0447f;
        this.f1238a = i2;
        this.f1239b = i;
        this.f1240c = i3;
        this.f1241d = i4;
        this.f1242e = charSequence;
        this.f1254q = i5;
    }

    public SupportMenuItem m1436a(int i) {
        Context e = this.f1249l.m1417e();
        m1437a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public SupportMenuItem m1437a(View view) {
        this.f1255r = view;
        this.f1256s = null;
        if (view != null && view.getId() == -1 && this.f1238a > 0) {
            view.setId(this.f1238a);
        }
        this.f1249l.m1407b(this);
        return this;
    }

    CharSequence m1438a(C0436a c0436a) {
        return (c0436a == null || !c0436a.m1311a()) ? getTitle() : getTitleCondensed();
    }

    public void m1439a(C0462p c0462p) {
        this.f1250m = c0462p;
        c0462p.setHeaderTitle(getTitle());
    }

    void m1440a(ContextMenuInfo contextMenuInfo) {
        this.f1259v = contextMenuInfo;
    }

    public void m1441a(boolean z) {
        this.f1253p = (z ? 4 : 0) | (this.f1253p & -5);
    }

    public boolean m1442a() {
        if ((this.f1252o != null && this.f1252o.onMenuItemClick(this)) || this.f1249l.m1402a(this.f1249l.m1428p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1251n != null) {
            this.f1251n.run();
            return true;
        }
        if (this.f1244g != null) {
            try {
                this.f1249l.m1417e().startActivity(this.f1244g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1256s != null && this.f1256s.onPerformDefaultAction();
    }

    public int m1443b() {
        return this.f1241d;
    }

    public SupportMenuItem m1444b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m1445b(boolean z) {
        int i = this.f1253p;
        this.f1253p = (z ? 2 : 0) | (this.f1253p & -3);
        if (i != this.f1253p) {
            this.f1249l.m1409b(false);
        }
    }

    char m1446c() {
        return this.f1249l.m1410b() ? this.f1246i : this.f1245h;
    }

    boolean m1447c(boolean z) {
        int i = this.f1253p;
        this.f1253p = (z ? 0 : 8) | (this.f1253p & -9);
        return i != this.f1253p;
    }

    public boolean collapseActionView() {
        return (this.f1254q & 8) == 0 ? false : this.f1255r == null ? true : (this.f1257t == null || this.f1257t.onMenuItemActionCollapse(this)) ? this.f1249l.m1416d(this) : false;
    }

    String m1448d() {
        char c = m1446c();
        if (c == '\u0000') {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder(f1234w);
        switch (c) {
            case SpdyProtocol.PUBKEY_SEQ_ADASH /*8*/:
                stringBuilder.append(f1236y);
                break;
            case SpdyProtocol.PUBKEY_SEQ_OPEN /*10*/:
                stringBuilder.append(f1235x);
                break;
            case C4574a.ORDERED /*32*/:
                stringBuilder.append(f1237z);
                break;
            default:
                stringBuilder.append(c);
                break;
        }
        return stringBuilder.toString();
    }

    public void m1449d(boolean z) {
        if (z) {
            this.f1253p |= 32;
        } else {
            this.f1253p &= -33;
        }
    }

    public void m1450e(boolean z) {
        this.f1258u = z;
        this.f1249l.m1409b(false);
    }

    boolean m1451e() {
        return this.f1249l.m1413c() && m1446c() != '\u0000';
    }

    public boolean expandActionView() {
        return !m1459m() ? false : (this.f1257t == null || this.f1257t.onMenuItemActionExpand(this)) ? this.f1249l.m1414c(this) : false;
    }

    public boolean m1452f() {
        return (this.f1253p & 4) != 0;
    }

    public void m1453g() {
        this.f1249l.m1407b(this);
    }

    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1255r != null) {
            return this.f1255r;
        }
        if (this.f1256s == null) {
            return null;
        }
        this.f1255r = this.f1256s.onCreateActionView(this);
        return this.f1255r;
    }

    public char getAlphabeticShortcut() {
        return this.f1246i;
    }

    public int getGroupId() {
        return this.f1239b;
    }

    public Drawable getIcon() {
        if (this.f1247j != null) {
            return this.f1247j;
        }
        if (this.f1248k == 0) {
            return null;
        }
        Drawable a = C0616l.m2672a().m2695a(this.f1249l.m1417e(), this.f1248k);
        this.f1248k = 0;
        this.f1247j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f1244g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1238a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1259v;
    }

    public char getNumericShortcut() {
        return this.f1245h;
    }

    public int getOrder() {
        return this.f1240c;
    }

    public SubMenu getSubMenu() {
        return this.f1250m;
    }

    public ActionProvider getSupportActionProvider() {
        return this.f1256s;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1242e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1243f != null ? this.f1243f : this.f1242e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public boolean m1454h() {
        return this.f1249l.m1429q();
    }

    public boolean hasSubMenu() {
        return this.f1250m != null;
    }

    public boolean m1455i() {
        return (this.f1253p & 32) == 32;
    }

    public boolean isActionViewExpanded() {
        return this.f1258u;
    }

    public boolean isCheckable() {
        return (this.f1253p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1253p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1253p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1256s == null || !this.f1256s.overridesItemVisibility()) ? (this.f1253p & 8) == 0 : (this.f1253p & 8) == 0 && this.f1256s.isVisible();
    }

    public boolean m1456j() {
        return (this.f1254q & 1) == 1;
    }

    public boolean m1457k() {
        return (this.f1254q & 2) == 2;
    }

    public boolean m1458l() {
        return (this.f1254q & 4) == 4;
    }

    public boolean m1459m() {
        if ((this.f1254q & 8) == 0) {
            return false;
        }
        if (this.f1255r == null && this.f1256s != null) {
            this.f1255r = this.f1256s.onCreateActionView(this);
        }
        return this.f1255r != null;
    }

    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m1436a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m1437a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1246i != c) {
            this.f1246i = Character.toLowerCase(c);
            this.f1249l.m1409b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1253p;
        this.f1253p = (z ? 1 : 0) | (this.f1253p & -2);
        if (i != this.f1253p) {
            this.f1249l.m1409b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1253p & 4) != 0) {
            this.f1249l.m1399a((MenuItem) this);
        } else {
            m1445b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1253p |= 16;
        } else {
            this.f1253p &= -17;
        }
        this.f1249l.m1409b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1247j = null;
        this.f1248k = i;
        this.f1249l.m1409b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1248k = 0;
        this.f1247j = drawable;
        this.f1249l.m1409b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1244g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1245h != c) {
            this.f1245h = c;
            this.f1249l.m1409b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1252o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1245h = c;
        this.f1246i = Character.toLowerCase(c2);
        this.f1249l.m1409b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                this.f1254q = i;
                this.f1249l.m1407b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m1444b(i);
    }

    public SupportMenuItem setSupportActionProvider(ActionProvider actionProvider) {
        if (this.f1256s != null) {
            this.f1256s.reset();
        }
        this.f1255r = null;
        this.f1256s = actionProvider;
        this.f1249l.m1409b(true);
        if (this.f1256s != null) {
            this.f1256s.setVisibilityListener(new C04491(this));
        }
        return this;
    }

    public SupportMenuItem setSupportOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f1257t = onActionExpandListener;
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1249l.m1417e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1242e = charSequence;
        this.f1249l.m1409b(false);
        if (this.f1250m != null) {
            this.f1250m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1243f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1242e;
        }
        this.f1249l.m1409b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m1447c(z)) {
            this.f1249l.m1396a(this);
        }
        return this;
    }

    public String toString() {
        return this.f1242e != null ? this.f1242e.toString() : null;
    }
}
