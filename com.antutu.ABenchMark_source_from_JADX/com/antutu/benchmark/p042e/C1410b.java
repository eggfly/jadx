package com.antutu.benchmark.p042e;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.ABenchmarkApplication;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.utils.BackgroundApps;

/* renamed from: com.antutu.benchmark.e.b */
public class C1410b extends C1338c {
    private static BackgroundApps f4869d;
    FrameLayout f4870b;
    C1338c f4871c;

    static {
        f4869d = new BackgroundApps();
    }

    private void m5575c() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
        if (C1503b.m5915c().m5968u()) {
            if (!(this.f4871c instanceof C1430d)) {
                this.f4871c = new C1430d();
            }
        } else if (!(this.f4871c instanceof C1421c)) {
            this.f4871c = new C1421c();
        }
        beginTransaction.replace(C1082R.id.fl_bg, this.f4871c);
        beginTransaction.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    public void m5576a(Object obj) {
        m5575c();
        this.f4871c.m5396a(obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.home_page, null);
        this.f4870b = (FrameLayout) inflate.findViewById(C1082R.id.fl_bg);
        m5575c();
        if (f4869d == null) {
            f4869d = new BackgroundApps();
        }
        f4869d.checkRunningApps(ABenchmarkApplication.getContext());
        return inflate;
    }
}
