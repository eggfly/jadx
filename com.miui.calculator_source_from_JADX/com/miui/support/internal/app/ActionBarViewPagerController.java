package com.miui.support.internal.app;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import com.miui.support.app.ActionBar.FragmentViewPagerChangeListener;
import com.miui.support.view.ViewPager;
import com.miui.support.view.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ActionBarViewPagerController {
    private ActionBarImpl f2158a;
    private ViewPager f2159b;
    private DynamicFragmentPagerAdapter f2160c;
    private ArrayList<FragmentViewPagerChangeListener> f2161d;

    /* renamed from: com.miui.support.internal.app.ActionBarViewPagerController.1 */
    class C02691 implements TabListener {
        final /* synthetic */ ActionBarViewPagerController f2156a;

        public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
        }

        public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
            int a = this.f2156a.f2160c.m3801a();
            for (int i = 0; i < a; i++) {
                if (this.f2156a.f2160c.m3809b(i) == tab) {
                    this.f2156a.f2159b.m5648a(i, true);
                    return;
                }
            }
        }

        public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
        }
    }

    /* renamed from: com.miui.support.internal.app.ActionBarViewPagerController.2 */
    class C02702 implements OnPageChangeListener {
        final /* synthetic */ ActionBarViewPagerController f2157a;

        public void m3687a(int i, float f, int i2) {
            boolean a = this.f2157a.f2160c.m3807a(i);
            boolean z = i + 1 < this.f2157a.f2160c.m3801a() && this.f2157a.f2160c.m3807a(i + 1);
            if (this.f2157a.f2161d != null) {
                Iterator it = this.f2157a.f2161d.iterator();
                while (it.hasNext()) {
                    ((FragmentViewPagerChangeListener) it.next()).m3249a(i, f, a, z);
                }
            }
        }

        public void m3686a(int i) {
            this.f2157a.f2158a.setSelectedNavigationItem(i);
            this.f2157a.f2160c.m3811b(this.f2157a.f2159b, i, this.f2157a.f2160c.m3803a(i, true));
            if (this.f2157a.f2161d != null) {
                Iterator it = this.f2157a.f2161d.iterator();
                while (it.hasNext()) {
                    ((FragmentViewPagerChangeListener) it.next()).m3248a(i);
                }
            }
        }

        public void m3688b(int i) {
            if (this.f2157a.f2161d != null) {
                Iterator it = this.f2157a.f2161d.iterator();
                while (it.hasNext()) {
                    ((FragmentViewPagerChangeListener) it.next()).m3250b(i);
                }
            }
        }
    }

    class ActionMenuChangeAnimatorObject {
    }
}
