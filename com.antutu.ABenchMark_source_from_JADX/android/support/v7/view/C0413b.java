package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class C0413b {
    private Object f1019a;
    private boolean f1020b;

    /* renamed from: android.support.v7.view.b.a */
    public interface C0345a {
        void m851a(C0413b c0413b);

        boolean m852a(C0413b c0413b, Menu menu);

        boolean m853a(C0413b c0413b, MenuItem menuItem);

        boolean m854b(C0413b c0413b, Menu menu);
    }

    public abstract MenuInflater m1141a();

    public abstract void m1142a(int i);

    public abstract void m1143a(View view);

    public abstract void m1144a(CharSequence charSequence);

    public void m1145a(Object obj) {
        this.f1019a = obj;
    }

    public void m1146a(boolean z) {
        this.f1020b = z;
    }

    public abstract Menu m1147b();

    public abstract void m1148b(int i);

    public abstract void m1149b(CharSequence charSequence);

    public abstract void m1150c();

    public abstract void m1151d();

    public abstract CharSequence m1152f();

    public abstract CharSequence m1153g();

    public boolean m1154h() {
        return false;
    }

    public abstract View m1155i();

    public Object m1156j() {
        return this.f1019a;
    }

    public boolean m1157k() {
        return this.f1020b;
    }
}
