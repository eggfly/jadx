package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import r;

public class l {
    private final m<?> j6;

    public static final l j6(m<?> mVar) {
        return new l(mVar);
    }

    private l(m<?> mVar) {
        this.j6 = mVar;
    }

    public n j6() {
        return this.j6.u7();
    }

    public int DW() {
        List list = this.j6.Hw.Zo;
        return list == null ? 0 : list.size();
    }

    public List<Fragment> j6(List<Fragment> list) {
        if (this.j6.Hw.Zo == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList(DW());
        }
        list.addAll(this.j6.Hw.Zo);
        return list;
    }

    public void j6(Fragment fragment) {
        this.j6.Hw.j6(this.j6, this.j6, fragment);
    }

    public View j6(View view, String str, Context context, AttributeSet attributeSet) {
        return this.j6.Hw.j6(view, str, context, attributeSet);
    }

    public void FH() {
        this.j6.Hw.tp();
    }

    public Parcelable Hw() {
        return this.j6.Hw.u7();
    }

    public void j6(Parcelable parcelable, List<Fragment> list) {
        this.j6.Hw.j6(parcelable, (List) list);
    }

    public List<Fragment> v5() {
        return this.j6.Hw.gn();
    }

    public void Zo() {
        this.j6.Hw.EQ();
    }

    public void VH() {
        this.j6.Hw.we();
    }

    public void gn() {
        this.j6.Hw.J0();
    }

    public void u7() {
        this.j6.Hw.J8();
    }

    public void tp() {
        this.j6.Hw.Ws();
    }

    public void EQ() {
        this.j6.Hw.QX();
    }

    public void we() {
        this.j6.Hw.XL();
    }

    public void J0() {
        this.j6.Hw.j3();
    }

    public void j6(Configuration configuration) {
        this.j6.Hw.j6(configuration);
    }

    public void J8() {
        this.j6.Hw.Mr();
    }

    public boolean j6(Menu menu, MenuInflater menuInflater) {
        return this.j6.Hw.j6(menu, menuInflater);
    }

    public boolean j6(Menu menu) {
        return this.j6.Hw.j6(menu);
    }

    public boolean j6(MenuItem menuItem) {
        return this.j6.Hw.j6(menuItem);
    }

    public boolean DW(MenuItem menuItem) {
        return this.j6.Hw.DW(menuItem);
    }

    public void DW(Menu menu) {
        this.j6.Hw.DW(menu);
    }

    public boolean Ws() {
        return this.j6.Hw.Zo();
    }

    public void QX() {
        this.j6.tp();
    }

    public void j6(boolean z) {
        this.j6.j6(z);
    }

    public void XL() {
        this.j6.EQ();
    }

    public void aM() {
        this.j6.we();
    }

    public r<String, t> j3() {
        return this.j6.J0();
    }

    public void j6(r<String, t> rVar) {
        this.j6.j6((r) rVar);
    }

    public void j6(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.j6.DW(str, fileDescriptor, printWriter, strArr);
    }
}
