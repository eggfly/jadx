package com.miui.support.internal.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.miui.support.internal.view.menu.MenuBuilder.ItemInvoker;

public final class ExpandedMenuView extends ListView implements OnItemClickListener, ItemInvoker, MenuView {
    private MenuBuilder f2697a;
    private int f2698b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
    }

    public void m4454a(MenuBuilder menuBuilder) {
        this.f2697a = menuBuilder;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean m4456a(MenuItemImpl menuItemImpl) {
        return this.f2697a.m4426a((MenuItem) menuItemImpl, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m4456a((MenuItemImpl) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f2698b;
    }

    public boolean m4455a(int i) {
        return false;
    }

    public boolean m4457c() {
        return false;
    }
}
