package com.dev.system.monitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    public int getCount() {
        return this.navDrawerItems.size();
    }

    public Object getItem(int position) {
        return this.navDrawerItems.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0133R.layout.drawer_list_item, null);
        }
        TextView txtTitle = (TextView) convertView.findViewById(C0133R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(C0133R.id.counter);
        ((ImageView) convertView.findViewById(C0133R.id.icon)).setImageResource(((NavDrawerItem) this.navDrawerItems.get(position)).getIcon());
        txtTitle.setText(((NavDrawerItem) this.navDrawerItems.get(position)).getTitle());
        if (((NavDrawerItem) this.navDrawerItems.get(position)).getCounterVisibility()) {
            txtCount.setText(((NavDrawerItem) this.navDrawerItems.get(position)).getCount());
        } else {
            txtCount.setVisibility(8);
        }
        return convertView;
    }
}
