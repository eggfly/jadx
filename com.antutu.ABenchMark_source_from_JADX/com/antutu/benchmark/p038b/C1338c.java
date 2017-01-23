package com.antutu.benchmark.p038b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.antutu.benchmark.p038b.C1341f.C1196a;
import com.antutu.redacc.C1692R;
import com.umeng.analytics.MobclickAgent;

/* renamed from: com.antutu.benchmark.b.c */
public class C1338c extends Fragment implements C1196a {
    protected Activity f4602a;

    public void m5394a() {
    }

    protected void m5395a(Intent intent) {
        startActivity(intent);
        this.f4602a.overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
    }

    public void m5396a(Object obj) {
    }

    public void m5397b() {
    }

    public void m5398g() {
        if (this.f4602a != null) {
            this.f4602a.finish();
            this.f4602a.overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4602a = getActivity();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
    }
}
