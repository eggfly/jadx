package com.antutu.benchmark.p038b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.antutu.benchmark.model.C1539q;
import com.antutu.benchmark.p036a.C1120j;
import java.util.List;

/* renamed from: com.antutu.benchmark.b.e */
public class C1340e extends C1120j implements OnPageChangeListener {
    private List<C1539q> f4604a;

    public C1340e(FragmentManager fragmentManager, List<C1539q> list) {
        super(fragmentManager);
        this.f4604a = list;
    }

    public Fragment m5399a(int i) {
        Fragment fragment = ((C1539q) this.f4604a.get(i)).f5358a;
        fragment.setArguments(((C1539q) this.f4604a.get(i)).f5359b);
        return fragment;
    }

    public int getCount() {
        return this.f4604a.size();
    }

    public CharSequence getPageTitle(int i) {
        return ((C1539q) this.f4604a.get(i)).f5360c;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }
}
