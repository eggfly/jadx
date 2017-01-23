package com.antutu.benchmark.p038b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1341f.C1196a;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Methods;
import com.antutu.utils.SmartBarUtils;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

/* renamed from: com.antutu.benchmark.b.d */
public class C1220d extends FragmentActivity implements C1196a {
    protected OnClickListener f4108a;

    /* renamed from: com.antutu.benchmark.b.d.1 */
    class C13391 implements OnClickListener {
        final /* synthetic */ C1220d f4603a;

        C13391(C1220d c1220d) {
            this.f4603a = c1220d;
        }

        public void onClick(View view) {
            this.f4603a.m5009a();
        }
    }

    public C1220d() {
        this.f4108a = new C13391(this);
    }

    protected void m5009a() {
        finish();
        overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
    }

    public void m5010g() {
        m5009a();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (VERSION.SDK_INT > 10) {
                SmartBarUtils.InitActionBar(this, C1082R.drawable.main_title_icon_back);
            }
        } catch (Exception e) {
        }
        PushAgent.getInstance(this).onAppStart();
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }

    protected void onStart() {
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        int color = getResources().getColor(C1082R.color.top_test_bg);
        systemBarTintManager.setStatusBarTintColor(Color.argb(153, Color.red(color), Color.green(color), Color.blue(color)));
        super.onStart();
    }

    public void startActivity(Intent intent) {
        try {
            super.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            if ("android.intent.action.SENDTO".equals(intent.getAction())) {
                Methods.showToast((Context) this, (int) C1082R.string.no_email_app, 1500);
            }
        } catch (Exception e2) {
        }
    }
}
