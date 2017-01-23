package com.antutu.redacc.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1760q;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.service.OptimizeService;

public class OptimizeActivity extends Activity {
    private BroadcastReceiver f6095a;
    private View f6096b;

    /* renamed from: com.antutu.redacc.activity.OptimizeActivity.1 */
    class C17101 extends Thread {
        final /* synthetic */ boolean f6092a;
        final /* synthetic */ OptimizeActivity f6093b;

        C17101(OptimizeActivity optimizeActivity, boolean z) {
            this.f6093b = optimizeActivity;
            this.f6092a = z;
        }

        public void run() {
            try {
                if (this.f6092a) {
                    C1762r.m6776e().m6807i();
                }
                OptimizeService.m6820a(this.f6093b.getApplicationContext());
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.antutu.redacc.activity.OptimizeActivity.2 */
    class C17112 extends BroadcastReceiver {
        final /* synthetic */ OptimizeActivity f6094a;

        C17112(OptimizeActivity optimizeActivity) {
            this.f6094a = optimizeActivity;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("MSG_BR_ON_OPT_FINISH")) {
                    this.f6094a.finish();
                }
            } catch (Exception e) {
            }
        }
    }

    public OptimizeActivity() {
        this.f6095a = null;
        this.f6096b = null;
    }

    private void m6659a() {
        try {
            this.f6095a = new C17112(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("MSG_BR_ON_OPT_FINISH");
            registerReceiver(this.f6095a, intentFilter);
        } catch (Exception e) {
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1692R.layout.float_view_icon);
        C1760q.m6767a().m6768a(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getBoolean("show_tips", true)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }
        boolean equals = defaultSharedPreferences.getString("work_mode", "root").equals("root");
        m6659a();
        if (!(equals || C1762r.m6776e().m6800d())) {
            try {
                this.f6096b = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1692R.layout.toast_view, null);
                ((TextView) this.f6096b.findViewById(C1692R.id.info)).setText(String.format(getString(C1692R.string.accessibility_enable), new Object[]{getString(C1692R.string.app_name)}));
                C1762r.m6776e().m6786a(getApplicationContext(), this.f6096b);
                finish();
                return;
            } catch (Exception e) {
            }
        }
        new C17101(this, equals).start();
        try {
            if (getIntent().getIntExtra("form", 0) != 1) {
            }
        } catch (Exception e2) {
        }
    }

    protected void onDestroy() {
        try {
            if (this.f6095a != null) {
                unregisterReceiver(this.f6095a);
            }
            this.f6095a = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        super.onPause();
        finish();
    }

    protected void onResume() {
        super.onResume();
    }
}
