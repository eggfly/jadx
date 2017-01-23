package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.C0447f.C0351a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.p */
public class C0462p extends C0447f implements SubMenu {
    private C0447f f1289d;
    private C0450h f1290e;

    public C0462p(Context context, C0447f c0447f, C0450h c0450h) {
        super(context);
        this.f1289d = c0447f;
        this.f1290e = c0450h;
    }

    public String m1492a() {
        int itemId = this.f1290e != null ? this.f1290e.getItemId() : 0;
        return itemId == 0 ? null : super.m1393a() + ":" + itemId;
    }

    public void m1493a(C0351a c0351a) {
        this.f1289d.m1395a(c0351a);
    }

    boolean m1494a(C0447f c0447f, MenuItem menuItem) {
        return super.m1402a(c0447f, menuItem) || this.f1289d.m1402a(c0447f, menuItem);
    }

    public boolean m1495b() {
        return this.f1289d.m1410b();
    }

    public boolean m1496c() {
        return this.f1289d.m1413c();
    }

    public boolean m1497c(C0450h c0450h) {
        return this.f1289d.m1414c(c0450h);
    }

    public boolean m1498d(C0450h c0450h) {
        return this.f1289d.m1416d(c0450h);
    }

    public MenuItem getItem() {
        return this.f1290e;
    }

    public C0447f m1499p() {
        return this.f1289d;
    }

    public Menu m1500s() {
        return this.f1289d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m1388a(ContextCompat.getDrawable(m1417e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m1388a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m1390a(m1417e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m1390a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m1389a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1290e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1290e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1289d.setQwertyMode(z);
    }
}
