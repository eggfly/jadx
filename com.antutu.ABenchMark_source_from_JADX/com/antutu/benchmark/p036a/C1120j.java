package com.antutu.benchmark.p036a;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.antutu.utils.MLog;

/* renamed from: com.antutu.benchmark.a.j */
public abstract class C1120j extends PagerAdapter {
    private final FragmentManager f3774a;
    private FragmentTransaction f3775b;
    private Fragment f3776c;

    public C1120j(FragmentManager fragmentManager) {
        this.f3775b = null;
        this.f3776c = null;
        this.f3774a = fragmentManager;
    }

    private static String m4874a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public abstract Fragment m4875a(int i);

    public long m4876b(int i) {
        return (long) i;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f3775b == null) {
            this.f3775b = this.f3774a.beginTransaction();
        }
        MLog.m6874v("FragmentPagerAdapter", "Detaching item #" + m4876b(i) + ": f=" + obj + " v=" + ((Fragment) obj).getView());
        this.f3775b.detach((Fragment) obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.f3775b != null) {
            this.f3775b.commitAllowingStateLoss();
            this.f3775b = null;
            this.f3774a.executePendingTransactions();
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.f3775b == null) {
            this.f3775b = this.f3774a.beginTransaction();
        }
        long b = m4876b(i);
        Fragment a = m4875a(i);
        MLog.m6874v("FragmentPagerAdapter", "Adding item #" + b + ": f=" + a);
        this.f3775b.add(viewGroup.getId(), a, C1120j.m4874a(viewGroup.getId(), b));
        if (a != this.f3776c) {
            a.setMenuVisibility(false);
            a.setUserVisibleHint(false);
        }
        return a;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f3776c) {
            if (this.f3776c != null) {
                this.f3776c.setMenuVisibility(false);
                this.f3776c.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f3776c = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
    }
}
