package com.miui.support.hybrid;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.app.Fragment;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.hybrid.HybridManager;
import java.util.HashSet;
import java.util.Set;

public class HybridFragment extends Fragment {
    private Set<HybridView> f2042a;

    public HybridFragment() {
        this.f2042a = new HashSet();
    }

    public View m3508a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return m3510b();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(C0264R.id.hybrid_view);
        if (findViewById != null && (findViewById instanceof HybridView)) {
            String str = null;
            if (bundle != null) {
                str = bundle.getString("com.miui.sdk.hybrid.extra.URL");
            }
            if (str == null) {
                Intent intent = getActivity().getIntent();
                if (intent != null) {
                    str = intent.getStringExtra("com.miui.sdk.hybrid.extra.URL");
                }
            }
            m3509a((HybridView) findViewById, m3511c(), str);
        }
    }

    protected View m3510b() {
        return getActivity().getLayoutInflater().inflate(C0264R.layout.hybrid_main, null);
    }

    protected int m3511c() {
        return 0;
    }

    protected final void m3509a(View view, int i, String str) {
        if (view instanceof HybridView) {
            HybridView hybridView = (HybridView) view;
            HybridManager hybridManager = new HybridManager(getActivity(), hybridView);
            hybridView.setHybridManager(hybridManager);
            this.f2042a.add(hybridView);
            hybridManager.m4039a(i, str);
            return;
        }
        throw new IllegalArgumentException("view being registered is not a hybrid view");
    }

    private void m3507d() {
        for (HybridView hybridView : this.f2042a) {
            if (hybridView != null) {
                if (hybridView.getParent() != null) {
                    ((ViewGroup) hybridView.getParent()).removeView(hybridView);
                }
                hybridView.m3519a();
            }
        }
        this.f2042a.clear();
    }

    public void onStart() {
        super.onStart();
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4047d();
        }
    }

    public void onResume() {
        super.onResume();
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4048e();
        }
    }

    public void onPause() {
        super.onPause();
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4049f();
        }
    }

    public void onStop() {
        super.onStop();
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4050g();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4051h();
        }
        m3507d();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (HybridView hybridManager : this.f2042a) {
            hybridManager.getHybridManager().m4038a(i, i2, intent);
        }
    }
}
