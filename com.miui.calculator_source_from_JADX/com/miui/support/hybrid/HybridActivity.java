package com.miui.support.hybrid;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.app.Activity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.hybrid.HybridManager;
import java.util.HashSet;
import java.util.Set;

public class HybridActivity extends Activity {
    private Set<HybridView> f2022a;

    public HybridActivity() {
        this.f2022a = new HashSet();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m3494a());
        View findViewById = findViewById(C0264R.id.hybrid_view);
        if (findViewById != null && (findViewById instanceof HybridView)) {
            String str = null;
            if (bundle != null) {
                str = bundle.getString("com.miui.sdk.hybrid.extra.URL");
            }
            if (str == null) {
                Intent intent = getIntent();
                if (intent != null) {
                    str = intent.getStringExtra("com.miui.sdk.hybrid.extra.URL");
                }
            }
            m3495a((HybridView) findViewById, m3496b(), str);
        }
    }

    protected View m3494a() {
        return getLayoutInflater().inflate(C0264R.layout.hybrid_main, null);
    }

    protected int m3496b() {
        return 0;
    }

    protected final void m3495a(View view, int i, String str) {
        if (view instanceof HybridView) {
            HybridView hybridView = (HybridView) view;
            HybridManager hybridManager = new HybridManager(this, hybridView);
            hybridView.setHybridManager(hybridManager);
            this.f2022a.add(hybridView);
            hybridManager.m4039a(i, str);
            return;
        }
        throw new IllegalArgumentException("view being registered is not a hybrid view");
    }

    private void m3493c() {
        for (HybridView hybridView : this.f2022a) {
            if (hybridView != null) {
                if (hybridView.getParent() != null) {
                    ((ViewGroup) hybridView.getParent()).removeView(hybridView);
                }
                hybridView.m3519a();
            }
        }
        this.f2022a.clear();
    }

    protected void onStart() {
        super.onStart();
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4047d();
        }
    }

    protected void onResume() {
        super.onResume();
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4048e();
        }
    }

    protected void onPause() {
        super.onPause();
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4049f();
        }
    }

    protected void onStop() {
        super.onStop();
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4050g();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4051h();
        }
        m3493c();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (HybridView hybridManager : this.f2022a) {
            hybridManager.getHybridManager().m4038a(i, i2, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            for (HybridView hybridView : this.f2022a) {
                if (hybridView.m3523c() && !hybridView.getHybridManager().m4043a()) {
                    hybridView.m3524d();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
