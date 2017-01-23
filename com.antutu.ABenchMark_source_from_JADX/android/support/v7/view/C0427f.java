package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.menu.C0460n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
/* renamed from: android.support.v7.view.f */
public class C0427f extends ActionMode {
    final Context f1077a;
    final C0413b f1078b;

    /* renamed from: android.support.v7.view.f.a */
    public static class C0426a implements C0345a {
        final Callback f1073a;
        final Context f1074b;
        final ArrayList<C0427f> f1075c;
        final SimpleArrayMap<Menu, Menu> f1076d;

        public C0426a(Context context, Callback callback) {
            this.f1074b = context;
            this.f1073a = callback;
            this.f1075c = new ArrayList();
            this.f1076d = new SimpleArrayMap();
        }

        private Menu m1258a(Menu menu) {
            Menu menu2 = (Menu) this.f1076d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0460n.m1489a(this.f1074b, (SupportMenu) menu);
            this.f1076d.put(menu, menu2);
            return menu2;
        }

        public void m1259a(C0413b c0413b) {
            this.f1073a.onDestroyActionMode(m1262b(c0413b));
        }

        public boolean m1260a(C0413b c0413b, Menu menu) {
            return this.f1073a.onCreateActionMode(m1262b(c0413b), m1258a(menu));
        }

        public boolean m1261a(C0413b c0413b, MenuItem menuItem) {
            return this.f1073a.onActionItemClicked(m1262b(c0413b), C0460n.m1490a(this.f1074b, (SupportMenuItem) menuItem));
        }

        public ActionMode m1262b(C0413b c0413b) {
            int size = this.f1075c.size();
            for (int i = 0; i < size; i++) {
                C0427f c0427f = (C0427f) this.f1075c.get(i);
                if (c0427f != null && c0427f.f1078b == c0413b) {
                    return c0427f;
                }
            }
            ActionMode c0427f2 = new C0427f(this.f1074b, c0413b);
            this.f1075c.add(c0427f2);
            return c0427f2;
        }

        public boolean m1263b(C0413b c0413b, Menu menu) {
            return this.f1073a.onPrepareActionMode(m1262b(c0413b), m1258a(menu));
        }
    }

    public C0427f(Context context, C0413b c0413b) {
        this.f1077a = context;
        this.f1078b = c0413b;
    }

    public void finish() {
        this.f1078b.m1150c();
    }

    public View getCustomView() {
        return this.f1078b.m1155i();
    }

    public Menu getMenu() {
        return C0460n.m1489a(this.f1077a, (SupportMenu) this.f1078b.m1147b());
    }

    public MenuInflater getMenuInflater() {
        return this.f1078b.m1141a();
    }

    public CharSequence getSubtitle() {
        return this.f1078b.m1153g();
    }

    public Object getTag() {
        return this.f1078b.m1156j();
    }

    public CharSequence getTitle() {
        return this.f1078b.m1152f();
    }

    public boolean getTitleOptionalHint() {
        return this.f1078b.m1157k();
    }

    public void invalidate() {
        this.f1078b.m1151d();
    }

    public boolean isTitleOptional() {
        return this.f1078b.m1154h();
    }

    public void setCustomView(View view) {
        this.f1078b.m1143a(view);
    }

    public void setSubtitle(int i) {
        this.f1078b.m1148b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1078b.m1144a(charSequence);
    }

    public void setTag(Object obj) {
        this.f1078b.m1145a(obj);
    }

    public void setTitle(int i) {
        this.f1078b.m1142a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1078b.m1149b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1078b.m1146a(z);
    }
}
