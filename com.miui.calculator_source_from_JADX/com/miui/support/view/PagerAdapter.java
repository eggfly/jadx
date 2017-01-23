package com.miui.support.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    private DataSetObservable f2232a;

    public abstract int m3782a();

    public abstract boolean m3792a(int i);

    public abstract boolean m3793a(View view, Object obj);

    public PagerAdapter() {
        this.f2232a = new DataSetObservable();
    }

    public void m3790a(ViewGroup viewGroup) {
        m3788a((View) viewGroup);
    }

    public Object m3785a(ViewGroup viewGroup, int i) {
        return m3784a((View) viewGroup, i);
    }

    public void m3791a(ViewGroup viewGroup, int i, Object obj) {
        m3789a((View) viewGroup, i, obj);
    }

    public void m3799b(ViewGroup viewGroup, int i, Object obj) {
        m3797b((View) viewGroup, i, obj);
    }

    public void m3798b(ViewGroup viewGroup) {
        m3796b((View) viewGroup);
    }

    public void m3788a(View view) {
    }

    public Object m3784a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m3789a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m3797b(View view, int i, Object obj) {
    }

    public void m3796b(View view) {
    }

    public Parcelable m3794b() {
        return null;
    }

    public void m3787a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int m3783a(Object obj) {
        return -1;
    }

    void m3786a(DataSetObserver dataSetObserver) {
        this.f2232a.registerObserver(dataSetObserver);
    }

    void m3795b(DataSetObserver dataSetObserver) {
        this.f2232a.unregisterObserver(dataSetObserver);
    }

    public float m3800c(int i) {
        return 1.0f;
    }
}
