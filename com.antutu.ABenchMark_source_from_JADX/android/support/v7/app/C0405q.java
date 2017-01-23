package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.C0355a.C0353b;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0380i;
import android.support.v7.view.menu.C0441l.C0342a;
import android.support.v7.view.menu.C0446e;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0399c;
import android.support.v7.widget.ai;
import android.support.v7.widget.bi;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import com.antutu.redacc.C1692R;
import java.util.ArrayList;
import org.android.spdy.TnetStatusCode;

/* renamed from: android.support.v7.app.q */
class C0405q extends C0355a {
    private ai f994a;
    private boolean f995b;
    private Callback f996c;
    private boolean f997d;
    private boolean f998e;
    private ArrayList<C0353b> f999f;
    private C0446e f1000g;
    private final Runnable f1001h;
    private final C0399c f1002i;

    /* renamed from: android.support.v7.app.q.1 */
    class C03981 implements Runnable {
        final /* synthetic */ C0405q f987a;

        C03981(C0405q c0405q) {
            this.f987a = c0405q;
        }

        public void run() {
            this.f987a.m1133j();
        }
    }

    /* renamed from: android.support.v7.app.q.2 */
    class C04002 implements C0399c {
        final /* synthetic */ C0405q f988a;

        C04002(C0405q c0405q) {
            this.f988a = c0405q;
        }

        public boolean m1101a(MenuItem menuItem) {
            return this.f988a.f996c.onMenuItemSelected(0, menuItem);
        }
    }

    /* renamed from: android.support.v7.app.q.a */
    private final class C0401a implements C0342a {
        final /* synthetic */ C0405q f989a;
        private boolean f990b;

        private C0401a(C0405q c0405q) {
            this.f989a = c0405q;
        }

        public void m1102a(C0447f c0447f, boolean z) {
            if (!this.f990b) {
                this.f990b = true;
                this.f989a.f994a.m2259n();
                if (this.f989a.f996c != null) {
                    this.f989a.f996c.onPanelClosed(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
                }
                this.f990b = false;
            }
        }

        public boolean m1103a(C0447f c0447f) {
            if (this.f989a.f996c == null) {
                return false;
            }
            this.f989a.f996c.onMenuOpened(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
            return true;
        }
    }

    /* renamed from: android.support.v7.app.q.b */
    private final class C0402b implements C0351a {
        final /* synthetic */ C0405q f991a;

        private C0402b(C0405q c0405q) {
            this.f991a = c0405q;
        }

        public void m1104a(C0447f c0447f) {
            if (this.f991a.f996c == null) {
                return;
            }
            if (this.f991a.f994a.m2254i()) {
                this.f991a.f996c.onPanelClosed(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
            } else if (this.f991a.f996c.onPreparePanel(0, null, c0447f)) {
                this.f991a.f996c.onMenuOpened(C1692R.styleable.AppCompatTheme_ratingBarStyleSmall, c0447f);
            }
        }

        public boolean m1105a(C0447f c0447f, MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v7.app.q.c */
    private final class C0403c implements C0342a {
        final /* synthetic */ C0405q f992a;

        private C0403c(C0405q c0405q) {
            this.f992a = c0405q;
        }

        public void m1106a(C0447f c0447f, boolean z) {
            if (this.f992a.f996c != null) {
                this.f992a.f996c.onPanelClosed(0, c0447f);
            }
        }

        public boolean m1107a(C0447f c0447f) {
            if (c0447f == null && this.f992a.f996c != null) {
                this.f992a.f996c.onMenuOpened(0, c0447f);
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.app.q.d */
    private class C0404d extends C0380i {
        final /* synthetic */ C0405q f993a;

        public C0404d(C0405q c0405q, Callback callback) {
            this.f993a = c0405q;
            super(callback);
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    Menu r = this.f993a.f994a.m2263r();
                    if (onPreparePanel(i, null, r) && onMenuOpened(i, r)) {
                        return this.f993a.m1109a(r);
                    }
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.f993a.f995b) {
                this.f993a.f994a.m2258m();
                this.f993a.f995b = true;
            }
            return onPreparePanel;
        }
    }

    public C0405q(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f999f = new ArrayList();
        this.f1001h = new C03981(this);
        this.f1002i = new C04002(this);
        this.f994a = new bi(toolbar, false);
        this.f996c = new C0404d(this, callback);
        this.f994a.m2240a(this.f996c);
        toolbar.setOnMenuItemClickListener(this.f1002i);
        this.f994a.m2241a(charSequence);
    }

    private View m1109a(Menu menu) {
        m1112b(menu);
        return (menu == null || this.f1000g == null || this.f1000g.m1369a().getCount() <= 0) ? null : (View) this.f1000g.m1368a(this.f994a.m2234a());
    }

    private void m1112b(Menu menu) {
        if (this.f1000g == null && (menu instanceof C0447f)) {
            C0447f c0447f = (C0447f) menu;
            Context b = this.f994a.m2243b();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0417R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0417R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0417R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1000g = new C0446e(contextThemeWrapper, C0417R.layout.abc_list_menu_item_layout);
            this.f1000g.m1372a(new C0403c());
            c0447f.m1397a(this.f1000g);
        }
    }

    private Menu m1115k() {
        if (!this.f997d) {
            this.f994a.m2237a(new C0401a(), new C0402b());
            this.f997d = true;
        }
        return this.f994a.m2263r();
    }

    public int m1116a() {
        return this.f994a.m2260o();
    }

    public void m1117a(float f) {
        ViewCompat.setElevation(this.f994a.m2234a(), f);
    }

    public void m1118a(int i) {
        this.f994a.m2249d(i);
    }

    public void m1119a(Configuration configuration) {
        super.m993a(configuration);
    }

    public void m1120a(CharSequence charSequence) {
        this.f994a.m2241a(charSequence);
    }

    public void m1121a(boolean z) {
    }

    public boolean m1122a(int i, KeyEvent keyEvent) {
        Menu k = m1115k();
        if (k != null) {
            k.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            k.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public boolean m1123b() {
        return this.f994a.m2262q() == 0;
    }

    public Context m1124c() {
        return this.f994a.m2243b();
    }

    public void m1125c(boolean z) {
    }

    public void m1126d(boolean z) {
    }

    public void m1127e(boolean z) {
        if (z != this.f998e) {
            this.f998e = z;
            int size = this.f999f.size();
            for (int i = 0; i < size; i++) {
                ((C0353b) this.f999f.get(i)).m983a(z);
            }
        }
    }

    public boolean m1128e() {
        this.f994a.m2234a().removeCallbacks(this.f1001h);
        ViewCompat.postOnAnimation(this.f994a.m2234a(), this.f1001h);
        return true;
    }

    public boolean m1129f() {
        if (!this.f994a.m2247c()) {
            return false;
        }
        this.f994a.m2248d();
        return true;
    }

    public boolean m1130g() {
        ViewGroup a = this.f994a.m2234a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    void m1131h() {
        this.f994a.m2234a().removeCallbacks(this.f1001h);
    }

    public Callback m1132i() {
        return this.f996c;
    }

    void m1133j() {
        Menu k = m1115k();
        C0447f c0447f = k instanceof C0447f ? (C0447f) k : null;
        if (c0447f != null) {
            c0447f.m1419g();
        }
        try {
            k.clear();
            if (!(this.f996c.onCreatePanelMenu(0, k) && this.f996c.onPreparePanel(0, null, k))) {
                k.clear();
            }
            if (c0447f != null) {
                c0447f.m1420h();
            }
        } catch (Throwable th) {
            if (c0447f != null) {
                c0447f.m1420h();
            }
        }
    }
}
