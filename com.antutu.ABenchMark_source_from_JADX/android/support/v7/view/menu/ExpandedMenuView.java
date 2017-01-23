package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0447f.C0438b;
import android.support.v7.widget.bh;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0438b, C0439m, OnItemClickListener {
    private static final int[] f1148a;
    private C0447f f1149b;
    private int f1150c;

    static {
        f1148a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bh a = bh.m2502a(context, attributeSet, f1148a, i, 0);
        if (a.m2517f(0)) {
            setBackgroundDrawable(a.m2505a(0));
        }
        if (a.m2517f(1)) {
            setDivider(a.m2505a(1));
        }
        a.m2506a();
    }

    public void m1325a(C0447f c0447f) {
        this.f1149b = c0447f;
    }

    public boolean m1326a(C0450h c0450h) {
        return this.f1149b.m1403a((MenuItem) c0450h, 0);
    }

    public int getWindowAnimations() {
        return this.f1150c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m1326a((C0450h) getAdapter().getItem(i));
    }
}
