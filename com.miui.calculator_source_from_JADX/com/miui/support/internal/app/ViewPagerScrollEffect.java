package com.miui.support.internal.app;

import android.app.Fragment;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.app.ActionBar.FragmentViewPagerChangeListener;
import com.miui.support.util.ViewUtils;
import com.miui.support.view.ViewPager;
import java.util.ArrayList;
import java.util.Iterator;

class ViewPagerScrollEffect implements FragmentViewPagerChangeListener {
    Rect f2288a;
    ArrayList<View> f2289b;
    int f2290c;
    boolean f2291d;
    int f2292e;
    int f2293f;
    ViewGroup f2294g;
    ViewPager f2295h;
    DynamicFragmentPagerAdapter f2296i;

    public void m3862a(int i, float f, boolean z, boolean z2) {
        boolean z3 = true;
        if (f == 0.0f) {
            this.f2290c = i;
            this.f2291d = true;
            if (this.f2294g != null) {
                m3863a(this.f2294g);
            }
        }
        if (this.f2292e != i) {
            if (this.f2290c < i) {
                this.f2290c = i;
            } else if (this.f2290c > i + 1) {
                this.f2290c = i + 1;
            }
            this.f2292e = i;
            this.f2291d = true;
            if (this.f2294g != null) {
                m3863a(this.f2294g);
            }
        }
        if (f > 0.0f) {
            float f2;
            if (this.f2291d) {
                this.f2291d = false;
                if (this.f2290c != i || i >= this.f2296i.m3801a() - 1) {
                    this.f2293f = i;
                } else {
                    this.f2293f = i + 1;
                }
                Fragment a = this.f2296i.m3803a(this.f2293f, false);
                this.f2294g = null;
                if (!(a == null || a.getView() == null)) {
                    View findViewById = a.getView().findViewById(16908298);
                    if (findViewById instanceof ViewGroup) {
                        this.f2294g = (ViewGroup) findViewById;
                    }
                }
            }
            if (this.f2293f == i) {
                f2 = 1.0f - f;
            } else {
                f2 = f;
            }
            if (this.f2294g != null) {
                ViewGroup viewGroup = this.f2294g;
                int width = this.f2294g.getWidth();
                int height = this.f2294g.getHeight();
                if (this.f2293f == i) {
                    z3 = false;
                }
                m3864a(viewGroup, width, height, f2, z3);
            }
        }
    }

    public void m3861a(int i) {
    }

    public void m3867b(int i) {
        if (i == 0) {
            this.f2290c = this.f2295h.getCurrentItem();
            this.f2291d = true;
            if (this.f2294g != null) {
                m3863a(this.f2294g);
            }
        }
    }

    void m3865a(ViewGroup viewGroup, ArrayList<View> arrayList) {
        m3866a((ArrayList) arrayList, viewGroup);
        arrayList.clear();
        ViewUtils.m5448a((View) viewGroup, this.f2288a);
        if (!this.f2288a.isEmpty()) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() != 8 || childAt.getHeight() > 0) {
                    arrayList.add(childAt);
                }
            }
        }
    }

    void m3866a(ArrayList<View> arrayList, ViewGroup viewGroup) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (viewGroup.indexOfChild(view) == -1 && view.getTranslationX() != 0.0f) {
                view.setTranslationX(0.0f);
            }
        }
    }

    void m3863a(ViewGroup viewGroup) {
        m3865a(viewGroup, this.f2289b);
        if (!this.f2289b.isEmpty()) {
            Iterator it = this.f2289b.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setTranslationX(0.0f);
            }
        }
    }

    void m3864a(ViewGroup viewGroup, int i, int i2, float f, boolean z) {
        int i3 = 0;
        m3865a(viewGroup, this.f2289b);
        if (!this.f2289b.isEmpty()) {
            int top = ((View) this.f2289b.get(0)).getTop();
            Iterator it = this.f2289b.iterator();
            int i4 = Integer.MAX_VALUE;
            while (it.hasNext()) {
                View view = (View) it.next();
                if (i4 != view.getTop()) {
                    i4 = view.getTop();
                    i3 = m3860a(i4 - top, i, i2, f);
                    if (!z) {
                        i3 = -i3;
                    }
                }
                view.setTranslationX((float) i3);
            }
        }
    }

    int m3860a(int i, int i2, int i3, float f) {
        int i4;
        if (i < i3) {
            i4 = (i * i2) / i3;
        } else {
            i4 = i2;
        }
        float f2 = ((float) i4) + ((0.1f - ((f * f) / 0.9f)) * ((float) i2));
        return f2 > 0.0f ? (int) f2 : 0;
    }
}
