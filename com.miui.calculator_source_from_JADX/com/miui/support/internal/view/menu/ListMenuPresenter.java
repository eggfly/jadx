package com.miui.support.internal.view.menu;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.menu.MenuPresenter.Callback;
import com.miui.support.internal.view.menu.MenuView.ItemView;
import java.util.ArrayList;

public class ListMenuPresenter implements OnItemClickListener, MenuPresenter {
    Context f2717a;
    LayoutInflater f2718b;
    MenuBuilder f2719c;
    ExpandedMenuView f2720d;
    int f2721e;
    int f2722f;
    int f2723g;
    MenuAdapter f2724h;
    private int f2725i;
    private Callback f2726j;

    private class MenuAdapter extends BaseAdapter {
        final /* synthetic */ ListMenuPresenter f2715a;
        private int f2716b;

        public /* synthetic */ Object getItem(int i) {
            return m4470a(i);
        }

        public MenuAdapter(ListMenuPresenter listMenuPresenter) {
            this.f2715a = listMenuPresenter;
            this.f2716b = -1;
            m4471a();
        }

        public int getCount() {
            int size = this.f2715a.f2719c.m4445j().size() - this.f2715a.f2725i;
            return this.f2716b < 0 ? size : size - 1;
        }

        public MenuItemImpl m4470a(int i) {
            ArrayList j = this.f2715a.f2719c.m4445j();
            int a = this.f2715a.f2725i + i;
            if (this.f2716b >= 0 && a >= this.f2716b) {
                a++;
            }
            return (MenuItemImpl) j.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f2715a.f2718b.inflate(this.f2715a.f2722f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((ItemView) inflate).m4289a(m4470a(i), 0);
            return inflate;
        }

        void m4471a() {
            MenuItemImpl p = this.f2715a.f2719c.m4451p();
            if (p != null) {
                ArrayList j = this.f2715a.f2719c.m4445j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) j.get(i)) == p) {
                        this.f2716b = i;
                        return;
                    }
                }
            }
            this.f2716b = -1;
        }

        public void notifyDataSetChanged() {
            m4471a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i, int i2) {
        this(i, i2, 0);
        this.f2717a = context;
        this.f2718b = LayoutInflater.from(this.f2717a);
    }

    public ListMenuPresenter(int i, int i2) {
        this(C0264R.layout.expanded_menu_layout, i, i2);
    }

    public ListMenuPresenter(int i, int i2, int i3) {
        this.f2722f = i2;
        this.f2723g = i;
        this.f2721e = i3;
    }

    public void m4475a(Context context, MenuBuilder menuBuilder) {
        if (this.f2721e != 0) {
            this.f2717a = new ContextThemeWrapper(context, this.f2721e);
            this.f2718b = LayoutInflater.from(this.f2717a);
        } else if (this.f2717a != null) {
            this.f2717a = context;
            if (this.f2718b == null) {
                this.f2718b = LayoutInflater.from(this.f2717a);
            }
        }
        if (this.f2719c != null) {
            this.f2719c.m4430b((MenuPresenter) this);
        }
        this.f2719c = menuBuilder;
        if (this.f2724h != null) {
            this.f2724h.notifyDataSetChanged();
        }
    }

    public MenuView m4474a(ViewGroup viewGroup) {
        if (this.f2724h == null) {
            this.f2724h = new MenuAdapter(this);
        }
        if (this.f2724h.isEmpty()) {
            return null;
        }
        if (this.f2720d == null) {
            this.f2720d = (ExpandedMenuView) this.f2718b.inflate(this.f2723g, viewGroup, false);
            this.f2720d.setAdapter(this.f2724h);
            this.f2720d.setOnItemClickListener(this);
        }
        return this.f2720d;
    }

    public ListAdapter m4473a() {
        if (this.f2724h == null) {
            this.f2724h = new MenuAdapter(this);
        }
        return this.f2724h;
    }

    public void m4481d(boolean z) {
        if (this.f2724h != null) {
            this.f2724h.notifyDataSetChanged();
        }
    }

    public void m4477a(Callback callback) {
        this.f2726j = callback;
    }

    public boolean m4479a(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).m4294a(null);
        if (this.f2726j != null) {
            this.f2726j.m3613b(subMenuBuilder);
        }
        return true;
    }

    public void m4476a(MenuBuilder menuBuilder, boolean z) {
        if (this.f2726j != null) {
            this.f2726j.m3612b(menuBuilder, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2719c.m4426a(this.f2724h.m4470a(i), 0);
    }

    public boolean m4482e() {
        return false;
    }

    public boolean m4478a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m4480b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }
}
