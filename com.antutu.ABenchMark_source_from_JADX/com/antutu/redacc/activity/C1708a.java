package com.antutu.redacc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.antutu.redacc.C1692R;
import com.umeng.analytics.MobclickAgent;
import java.lang.ref.WeakReference;

/* renamed from: com.antutu.redacc.activity.a */
public class C1708a extends Activity {
    protected int f6062a;
    protected int f6063b;
    protected OnClickListener f6064c;
    protected OnClickListener f6065d;

    /* renamed from: com.antutu.redacc.activity.a.1 */
    class C17121 implements OnClickListener {
        final /* synthetic */ C1708a f6097a;

        C17121(C1708a c1708a) {
            this.f6097a = c1708a;
        }

        public void onClick(View view) {
            this.f6097a.m6618a();
        }
    }

    /* renamed from: com.antutu.redacc.activity.a.2 */
    class C17132 implements OnClickListener {
        final /* synthetic */ C1708a f6098a;

        C17132(C1708a c1708a) {
            this.f6098a = c1708a;
        }

        public void onClick(View view) {
            Intent putExtra;
            this.f6098a.finish();
            if (this.f6098a.f6062a == 1) {
                this.f6098a.overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
                putExtra = new Intent().setClassName("com.antutu.ABenchMark", "com.antutu.benchmark.activity.MainActivity").putExtra("ACTION_OPEN_MENU", true);
            } else {
                putExtra = this.f6098a.getPackageManager().getLaunchIntentForPackage("com.antutu.ABenchMark").putExtra("ACTION_OPEN_MENU", true);
            }
            this.f6098a.startActivity(putExtra);
        }
    }

    /* renamed from: com.antutu.redacc.activity.a.a */
    protected class C1714a extends Handler {
        final /* synthetic */ C1708a f6099a;
        private final WeakReference<C1708a> f6100b;

        public C1714a(C1708a c1708a, C1708a c1708a2) {
            this.f6099a = c1708a;
            this.f6100b = new WeakReference(c1708a2);
        }

        public void handleMessage(Message message) {
            if (((C1708a) this.f6100b.get()) != null) {
                this.f6099a.m6619a(message);
            }
        }
    }

    public C1708a() {
        this.f6062a = 0;
        this.f6063b = 0;
        this.f6064c = new C17121(this);
        this.f6065d = new C17132(this);
    }

    protected void m6618a() {
        finish();
        if (this.f6062a == 1) {
            overridePendingTransition(C1692R.anim.in_from_left, C1692R.anim.out_to_right);
            return;
        }
        try {
            startActivity(getPackageManager().getLaunchIntentForPackage("com.antutu.ABenchMark"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m6619a(Message message) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
}
