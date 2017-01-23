package com.miui.support.internal.app;

import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.view.PagerAdapter;
import java.util.ArrayList;

class DynamicFragmentPagerAdapter extends PagerAdapter {
    private Context f2233a;
    private FragmentManager f2234b;
    private ArrayList<FragmentInfo> f2235c;
    private FragmentTransaction f2236d;
    private Fragment f2237e;

    class FragmentInfo {
        String f2226a;
        Class<? extends Fragment> f2227b;
        Fragment f2228c;
        Bundle f2229d;
        Tab f2230e;
        boolean f2231f;
    }

    public void m3805a(ViewGroup viewGroup) {
    }

    public void m3806a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f2236d == null) {
            this.f2236d = this.f2234b.beginTransaction();
        }
        this.f2236d.detach((Fragment) obj);
    }

    public void m3811b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f2237e) {
            if (this.f2237e != null) {
                this.f2237e.setMenuVisibility(false);
                this.f2237e.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f2237e = fragment;
        }
    }

    public void m3810b(ViewGroup viewGroup) {
        if (this.f2236d != null) {
            this.f2236d.commitAllowingStateLoss();
            this.f2236d = null;
            this.f2234b.executePendingTransactions();
        }
    }

    public boolean m3808a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public Object m3804a(ViewGroup viewGroup, int i) {
        if (this.f2236d == null) {
            this.f2236d = this.f2234b.beginTransaction();
        }
        Fragment a = m3803a(i, true);
        if (a.getFragmentManager() != null) {
            this.f2236d.attach(a);
        } else {
            this.f2236d.add(viewGroup.getId(), a, ((FragmentInfo) this.f2235c.get(i)).f2226a);
        }
        if (a != this.f2237e) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    public int m3801a() {
        return this.f2235c.size();
    }

    public boolean m3807a(int i) {
        return ((FragmentInfo) this.f2235c.get(i)).f2231f;
    }

    public int m3802a(Object obj) {
        int size = this.f2235c.size();
        for (int i = 0; i < size; i++) {
            if (obj == ((FragmentInfo) this.f2235c.get(i)).f2228c) {
                return i;
            }
        }
        return -2;
    }

    Tab m3809b(int i) {
        return ((FragmentInfo) this.f2235c.get(i)).f2230e;
    }

    Fragment m3803a(int i, boolean z) {
        FragmentInfo fragmentInfo = (FragmentInfo) this.f2235c.get(i);
        if (fragmentInfo.f2228c == null) {
            fragmentInfo.f2228c = this.f2234b.findFragmentByTag(fragmentInfo.f2226a);
            if (fragmentInfo.f2228c == null && z) {
                fragmentInfo.f2228c = Fragment.instantiate(this.f2233a, fragmentInfo.f2227b.getName(), fragmentInfo.f2229d);
                fragmentInfo.f2227b = null;
                fragmentInfo.f2229d = null;
            }
        }
        return fragmentInfo.f2228c;
    }
}
