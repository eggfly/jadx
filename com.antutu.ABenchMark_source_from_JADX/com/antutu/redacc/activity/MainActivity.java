package com.antutu.redacc.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.antutu.redacc.C1692R;
import com.antutu.redacc.p067f.C1760q;
import com.antutu.redacc.p067f.C1762r;
import com.antutu.redacc.p069c.C1725b;
import com.antutu.redacc.p069c.C1728c;
import com.umeng.analytics.MobclickAgent;
import java.lang.reflect.Field;

public class MainActivity extends FragmentActivity {
    private SharedPreferences f6091a;

    /* renamed from: com.antutu.redacc.activity.MainActivity.1 */
    class C17091 extends Thread {
        final /* synthetic */ MainActivity f6090a;

        C17091(MainActivity mainActivity) {
            this.f6090a = mainActivity;
        }

        public void run() {
            try {
                C1762r.m6776e().m6807i();
            } catch (Exception e) {
            }
            super.run();
        }
    }

    public MainActivity() {
        this.f6091a = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1692R.layout.activity_main);
        C1762r.m6776e().m6785a((Context) this);
        C1760q.m6767a().m6768a(this);
        setTitle(C1692R.string.app_name_long);
        this.f6091a = PreferenceManager.getDefaultSharedPreferences(this);
        if (this.f6091a.getBoolean("show_tips", true)) {
            C1728c.m6692a(this);
        } else {
            String str = "root";
            if (this.f6091a.getString("work_mode", str).equals(str)) {
                C1762r.m6776e().m6794b(true);
                new C17091(this).start();
            } else {
                C1762r.m6776e().m6794b(false);
                if (!C1762r.m6776e().m6800d()) {
                    try {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1692R.layout.toast_view, null);
                        ((TextView) inflate.findViewById(C1692R.id.info)).setText(String.format(getString(C1692R.string.accessibility_enable), new Object[]{getString(C1692R.string.app_name)}));
                        C1762r.m6776e().m6786a(getApplicationContext(), inflate);
                        C1762r.m6776e().m6811m();
                    } catch (Exception e) {
                    }
                }
            }
        }
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(C1692R.id.container, new C1725b()).commit();
        }
        try {
            if (VERSION.SDK_INT < 19) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
                Field declaredField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    declaredField.setBoolean(viewConfiguration, false);
                }
            }
        } catch (Exception e2) {
        }
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
