package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class PullToRequestBaseAdapter extends BaseAdapter {
    private PullToRequestBaseListAdapter adapter;

    public PullToRequestBaseAdapter(PullToRequestBaseListAdapter pullToRequestBaseListAdapter) {
        this.adapter = pullToRequestBaseListAdapter;
    }

    public int getCount() {
        return this.adapter.getCount();
    }

    public Object getItem(int i) {
        return this.adapter.getItem(i);
    }

    public long getItemId(int i) {
        return this.adapter.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.adapter.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.adapter.getView(i, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.adapter.getViewTypeCount();
    }
}
