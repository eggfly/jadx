package com.miui.support.internal.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.miui.support.internal.C0264R;
import java.util.ArrayList;

public class ImmersionMenuAdapter extends BaseAdapter {
    private LayoutInflater f2699a;
    private ArrayList<MenuItem> f2700b;

    public /* synthetic */ Object getItem(int i) {
        return m4459a(i);
    }

    ImmersionMenuAdapter(Context context, Menu menu) {
        this.f2699a = LayoutInflater.from(context);
        this.f2700b = new ArrayList();
        m4458a(menu, this.f2700b);
    }

    private void m4458a(Menu menu, ArrayList<MenuItem> arrayList) {
        arrayList.clear();
        if (menu != null) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = menu.getItem(i);
                if (item.isVisible()) {
                    arrayList.add(item);
                }
            }
        }
    }

    public int getCount() {
        return this.f2700b.size();
    }

    public MenuItem m4459a(int i) {
        return (MenuItem) this.f2700b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2699a.inflate(C0264R.layout.immersion_popup_menu_item, viewGroup, false);
            view.setTag((TextView) view.findViewById(16908308));
        }
        ((TextView) view.getTag()).setText(m4459a(i).getTitle());
        return view;
    }

    public void m4460a(Menu menu) {
        m4458a(menu, this.f2700b);
        notifyDataSetChanged();
    }
}
