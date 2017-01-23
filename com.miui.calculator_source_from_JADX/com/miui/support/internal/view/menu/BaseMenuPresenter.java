package com.miui.support.internal.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.internal.view.menu.MenuPresenter.Callback;
import com.miui.support.internal.view.menu.MenuView.ItemView;
import java.util.Iterator;

public abstract class BaseMenuPresenter implements MenuPresenter {
    private Callback f2634a;
    private int f2635b;
    protected Context f2636c;
    protected Context f2637d;
    protected MenuBuilder f2638e;
    protected LayoutInflater f2639f;
    protected LayoutInflater f2640g;
    protected MenuView f2641h;
    private int f2642i;
    private int f2643j;

    public abstract void m4347a(MenuItemImpl menuItemImpl, ItemView itemView);

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.f2636c = context;
        this.f2639f = LayoutInflater.from(context);
        this.f2635b = i;
        this.f2642i = i2;
    }

    public void m4344a(Context context, MenuBuilder menuBuilder) {
        this.f2637d = context;
        this.f2640g = LayoutInflater.from(this.f2637d);
        this.f2638e = menuBuilder;
    }

    public MenuView m4342a(ViewGroup viewGroup) {
        if (this.f2641h == null) {
            this.f2641h = (MenuView) this.f2639f.inflate(this.f2635b, viewGroup, false);
            this.f2641h.m4390a(this.f2638e);
            m4354d(true);
        }
        return this.f2641h;
    }

    public void m4354d(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f2641h;
        if (viewGroup != null) {
            boolean z2;
            int i;
            if (this.f2641h.m4392c()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f2638e != null) {
                this.f2638e.m4444i();
                Iterator it = this.f2638e.m4443h().iterator();
                i = z2;
                while (it.hasNext()) {
                    int i2;
                    MenuItemImpl menuItemImpl = (MenuItemImpl) it.next();
                    if (m4349a(i, menuItemImpl)) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof ItemView ? ((ItemView) childAt).getItemData() : null;
                        View a = m4341a(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            a.setPressed(false);
                        }
                        if (a != childAt) {
                            m4345a(a, i);
                        }
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
            } else {
                boolean z3 = z2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!this.f2641h.m4391a(i)) {
                    i++;
                }
            }
        }
    }

    protected void m4345a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f2641h).addView(view, i);
    }

    public void m4348a(Callback callback) {
        this.f2634a = callback;
    }

    public ItemView m4352b(ViewGroup viewGroup) {
        return (ItemView) this.f2639f.inflate(this.f2642i, viewGroup, false);
    }

    public View m4341a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        ItemView itemView;
        if (view instanceof ItemView) {
            itemView = (ItemView) view;
        } else {
            itemView = m4352b(viewGroup);
        }
        m4347a(menuItemImpl, itemView);
        return (View) itemView;
    }

    public boolean m4349a(int i, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void m4346a(MenuBuilder menuBuilder, boolean z) {
        if (this.f2634a != null) {
            this.f2634a.m3612b(menuBuilder, z);
        }
    }

    public boolean m4351a(SubMenuBuilder subMenuBuilder) {
        return this.f2634a != null && this.f2634a.m3613b(subMenuBuilder);
    }

    public boolean m4355e() {
        return false;
    }

    public boolean m4350a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m4353b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void m4343a(int i) {
        this.f2643j = i;
    }
}
