package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
    private final FragmentHostCallback<?> f198a;

    public static final FragmentController m270a(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f198a = fragmentHostCallback;
    }

    public FragmentManager m271a() {
        return this.f198a.m244i();
    }

    public int m283b() {
        List list = this.f198a.f179d.f221f;
        return list == null ? 0 : list.size();
    }

    public List<Fragment> m273a(List<Fragment> list) {
        if (this.f198a.f179d.f221f == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList(m283b());
        }
        list.addAll(this.f198a.f179d.f221f);
        return list;
    }

    public void m276a(Fragment fragment) {
        this.f198a.f179d.m338a(this.f198a, this.f198a, fragment);
    }

    public View m272a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f198a.f179d.m325a(view, str, context, attributeSet);
    }

    public void m286c() {
        this.f198a.f179d.m365i();
    }

    public Parcelable m287d() {
        return this.f198a.f179d.m364h();
    }

    public void m275a(Parcelable parcelable, List<Fragment> list) {
        this.f198a.f179d.m333a(parcelable, (List) list);
    }

    public List<Fragment> m288e() {
        return this.f198a.f179d.m363g();
    }

    public void m289f() {
        this.f198a.f179d.m366j();
    }

    public void m290g() {
        this.f198a.f179d.m367k();
    }

    public void m291h() {
        this.f198a.f179d.m368l();
    }

    public void m292i() {
        this.f198a.f179d.m369m();
    }

    public void m293j() {
        this.f198a.f179d.m370n();
    }

    public void m294k() {
        this.f198a.f179d.m371o();
    }

    public void m295l() {
        this.f198a.f179d.m372p();
    }

    public void m296m() {
        this.f198a.f179d.m374r();
    }

    public void m274a(Configuration configuration) {
        this.f198a.f179d.m331a(configuration);
    }

    public void m297n() {
        this.f198a.f179d.m375s();
    }

    public boolean m281a(Menu menu, MenuInflater menuInflater) {
        return this.f198a.f179d.m343a(menu, menuInflater);
    }

    public boolean m280a(Menu menu) {
        return this.f198a.f179d.m342a(menu);
    }

    public boolean m282a(MenuItem menuItem) {
        return this.f198a.f179d.m344a(menuItem);
    }

    public boolean m285b(MenuItem menuItem) {
        return this.f198a.f179d.m351b(menuItem);
    }

    public void m284b(Menu menu) {
        this.f198a.f179d.m349b(menu);
    }

    public boolean m298o() {
        return this.f198a.f179d.m360e();
    }

    public void m299p() {
        this.f198a.m245j();
    }

    public void m279a(boolean z) {
        this.f198a.m232a(z);
    }

    public void m300q() {
        this.f198a.m246k();
    }

    public void m301r() {
        this.f198a.m247l();
    }

    public SimpleArrayMap<String, LoaderManager> m302s() {
        return this.f198a.m248m();
    }

    public void m277a(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        this.f198a.m229a((SimpleArrayMap) simpleArrayMap);
    }

    public void m278a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f198a.m237b(str, fileDescriptor, printWriter, strArr);
    }
}
