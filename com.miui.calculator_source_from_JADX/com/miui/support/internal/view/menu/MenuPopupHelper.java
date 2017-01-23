package com.miui.support.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.view.menu.MenuPresenter.Callback;
import com.miui.support.internal.view.menu.MenuView.ItemView;
import com.miui.support.widget.ListPopupWindow;
import java.util.ArrayList;

public class MenuPopupHelper implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener, MenuPresenter {
    private static final int f2616a;
    boolean f2617b;
    private Context f2618c;
    private LayoutInflater f2619d;
    private ListPopupWindow f2620e;
    private MenuBuilder f2621f;
    private int f2622g;
    private View f2623h;
    private boolean f2624i;
    private ViewTreeObserver f2625j;
    private MenuAdapter f2626k;
    private Callback f2627l;
    private ViewGroup f2628m;
    private int f2629n;
    private int f2630o;

    private class MenuAdapter extends BaseAdapter {
        final /* synthetic */ MenuPopupHelper f2754a;
        private MenuBuilder f2755b;
        private int f2756c;

        public /* synthetic */ Object getItem(int i) {
            return m4505a(i);
        }

        public MenuAdapter(MenuPopupHelper menuPopupHelper, MenuBuilder menuBuilder) {
            this.f2754a = menuPopupHelper;
            this.f2756c = -1;
            this.f2755b = menuBuilder;
            m4506a();
        }

        public int getCount() {
            ArrayList j = this.f2754a.f2624i ? this.f2755b.m4445j() : this.f2755b.m4443h();
            if (this.f2756c < 0) {
                return j.size();
            }
            return j.size() - 1;
        }

        public MenuItemImpl m4505a(int i) {
            ArrayList j = this.f2754a.f2624i ? this.f2755b.m4445j() : this.f2755b.m4443h();
            if (this.f2756c >= 0 && i >= this.f2756c) {
                i++;
            }
            return (MenuItemImpl) j.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f2754a.f2619d.inflate(this.f2754a.f2630o, viewGroup, false);
            } else {
                inflate = view;
            }
            ItemView itemView = (ItemView) inflate;
            if (this.f2754a.f2617b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            itemView.m4289a(m4505a(i), 0);
            return inflate;
        }

        void m4506a() {
            MenuItemImpl p = this.f2754a.f2621f.m4451p();
            if (p != null) {
                ArrayList j = this.f2754a.f2621f.m4445j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (((MenuItemImpl) j.get(i)) == p) {
                        this.f2756c = i;
                        return;
                    }
                }
            }
            this.f2756c = -1;
        }

        public void notifyDataSetChanged() {
            m4506a();
            super.notifyDataSetChanged();
        }
    }

    static {
        f2616a = C0264R.layout.popup_menu_item_layout;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z) {
        this.f2630o = f2616a;
        this.f2618c = context;
        this.f2619d = LayoutInflater.from(context);
        this.f2621f = menuBuilder;
        this.f2624i = z;
        Resources resources = context.getResources();
        this.f2622g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0264R.dimen.config_prefDialogWidth));
        this.f2623h = view;
        menuBuilder.m4422a((MenuPresenter) this);
    }

    public void m4329b(boolean z) {
        this.f2617b = z;
    }

    public void m4321a(int i) {
        this.f2630o = i;
    }

    public void m4332c() {
        if (!m4326a()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m4326a() {
        boolean z = false;
        this.f2620e = new ListPopupWindow(this.f2618c, null, 16843520);
        this.f2620e.m4519a((OnDismissListener) this);
        this.f2620e.m4517a((OnItemClickListener) this);
        this.f2620e.m4515a(this.f2629n);
        this.f2626k = new MenuAdapter(this, this.f2621f);
        this.f2620e.m4518a(this.f2626k);
        this.f2620e.m4523b(true);
        View view = this.f2623h;
        if (view == null) {
            return false;
        }
        if (this.f2625j == null) {
            z = true;
        }
        this.f2625j = view.getViewTreeObserver();
        if (z) {
            this.f2625j.addOnGlobalLayoutListener(this);
        }
        this.f2620e.m4516a(view);
        this.f2620e.m4525c(Math.min(m4316a(this.f2626k), this.f2622g));
        this.f2620e.m4527d(2);
        this.f2620e.m4524c();
        this.f2620e.m4529f().setOnKeyListener(this);
        return true;
    }

    public void m4325a(boolean z) {
        if (m4330b()) {
            this.f2620e.m4520a(z);
        }
    }

    public void onDismiss() {
        this.f2620e = null;
        this.f2621f.close();
        if (this.f2625j != null) {
            if (!this.f2625j.isAlive()) {
                this.f2625j = this.f2623h.getViewTreeObserver();
            }
            this.f2625j.removeOnGlobalLayoutListener(this);
            this.f2625j = null;
        }
    }

    public boolean m4330b() {
        return this.f2620e != null && this.f2620e.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MenuAdapter menuAdapter = this.f2626k;
        menuAdapter.f2755b.m4426a(menuAdapter.m4505a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m4325a(false);
        return true;
    }

    private int m4316a(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2622g, Integer.MIN_VALUE);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(this.f2622g, Integer.MIN_VALUE);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.f2628m == null) {
                this.f2628m = new FrameLayout(this.f2618c);
            }
            view = listAdapter.getView(i, view2, this.f2628m);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m4330b()) {
            View view = this.f2623h;
            if (view == null || !view.isShown()) {
                m4325a(false);
            } else if (m4330b()) {
                this.f2620e.m4525c(Math.min(m4316a(this.f2626k), this.f2622g));
                this.f2620e.m4524c();
            }
        }
    }

    public void m4322a(Context context, MenuBuilder menuBuilder) {
    }

    public void m4333d(boolean z) {
        if (this.f2626k != null) {
            this.f2626k.notifyDataSetChanged();
        }
    }

    public void m4324a(Callback callback) {
        this.f2627l = callback;
    }

    public boolean m4328a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            boolean z;
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f2618c, subMenuBuilder, this.f2623h, false);
            menuPopupHelper.m4324a(this.f2627l);
            int size = subMenuBuilder.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = subMenuBuilder.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            menuPopupHelper.m4329b(z);
            if (menuPopupHelper.m4326a()) {
                if (this.f2627l == null) {
                    return true;
                }
                this.f2627l.m3613b(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    public void m4323a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f2621f) {
            m4325a(true);
            if (this.f2627l != null) {
                this.f2627l.m3612b(menuBuilder, z);
            }
        }
    }

    public boolean m4334e() {
        return false;
    }

    public boolean m4327a(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean m4331b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }
}
