package com.aide.common;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class l<T> extends BaseAdapter {
    private List<T> j6;

    public l() {
        this.j6 = new ArrayList();
    }

    public void j6(List<T> list) {
        this.j6 = list;
        notifyDataSetChanged();
    }

    public T j6(int i) {
        return this.j6.get(i);
    }

    public int getCount() {
        return this.j6.size();
    }

    public Object getItem(int i) {
        return this.j6.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
