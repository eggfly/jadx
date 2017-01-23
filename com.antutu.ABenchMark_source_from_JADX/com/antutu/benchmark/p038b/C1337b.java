package com.antutu.benchmark.p038b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.C0377e;
import android.view.View;
import android.view.View.OnClickListener;
import com.antutu.ABenchMark.C1082R;
import com.antutu.redacc.C1692R;
import com.antutu.utils.Methods;
import com.antutu.utils.SmartBarUtils;
import com.antutu.utils.widget.SystemBarTintManager;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

/* renamed from: com.antutu.benchmark.b.b */
public class C1337b extends C0377e {
    protected OnClickListener mBackOnClickListener;

    /* renamed from: com.antutu.benchmark.b.b.1 */
    class C13361 implements OnClickListener {
        final /* synthetic */ C1337b f4601a;

        C13361(C1337b c1337b) {
            this.f4601a = c1337b;
        }

        public void onClick(View view) {
            this.f4601a.finishWithAnimation();
        }
    }

    public C1337b() {
        this.mBackOnClickListener = new C13361(this);
    }

    protected void finishWithAnimation() {
        finish();
        overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
    }

    public void flingOver() {
        finishWithAnimation();
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

    protected void startActivityWithAnimation(Intent intent) {
        startActivity(intent);
        overridePendingTransition(C1692R.anim.in_from_right, C1692R.anim.out_to_left);
    }
}
