package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.view.menu.C0447f;
import android.support.v7.view.menu.C0447f.C0351a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.e */
public class C0425e extends C0413b implements C0351a {
    private Context f1066a;
    private ActionBarContextView f1067b;
    private C0345a f1068c;
    private WeakReference<View> f1069d;
    private boolean f1070e;
    private boolean f1071f;
    private C0447f f1072g;

    public C0425e(Context context, ActionBarContextView actionBarContextView, C0345a c0345a, boolean z) {
        this.f1066a = context;
        this.f1067b = actionBarContextView;
        this.f1068c = c0345a;
        this.f1072g = new C0447f(actionBarContextView.getContext()).m1387a(1);
        this.f1072g.m1395a((C0351a) this);
        this.f1071f = z;
    }

    public MenuInflater m1242a() {
        return new C0430g(this.f1067b.getContext());
    }

    public void m1243a(int i) {
        m1251b(this.f1066a.getString(i));
    }

    public void m1244a(C0447f c0447f) {
        m1253d();
        this.f1067b.m1514a();
    }

    public void m1245a(View view) {
        this.f1067b.setCustomView(view);
        this.f1069d = view != null ? new WeakReference(view) : null;
    }

    public void m1246a(CharSequence charSequence) {
        this.f1067b.setSubtitle(charSequence);
    }

    public void m1247a(boolean z) {
        super.m1146a(z);
        this.f1067b.setTitleOptional(z);
    }

    public boolean m1248a(C0447f c0447f, MenuItem menuItem) {
        return this.f1068c.m853a((C0413b) this, menuItem);
    }

    public Menu m1249b() {
        return this.f1072g;
    }

    public void m1250b(int i) {
        m1246a(this.f1066a.getString(i));
    }

    public void m1251b(CharSequence charSequence) {
        this.f1067b.setTitle(charSequence);
    }

    public void m1252c() {
        if (!this.f1070e) {
            this.f1070e = true;
            this.f1067b.sendAccessibilityEvent(32);
            this.f1068c.m851a(this);
        }
    }

    public void m1253d() {
        this.f1068c.m854b(this, this.f1072g);
    }

    public CharSequence m1254f() {
        return this.f1067b.getTitle();
    }

    public CharSequence m1255g() {
        return this.f1067b.getSubtitle();
    }

    public boolean m1256h() {
        return this.f1067b.m1517d();
    }

    public View m1257i() {
        return this.f1069d != null ? (View) this.f1069d.get() : null;
    }
}
