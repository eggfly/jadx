package com.miui.calculator.cal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceGroup;
import android.util.Log;
import com.miui.calculator.common.utils.CalculatorUtils;
import com.miui.calculator.common.utils.StatisticUtils;
import com.miui.support.app.AlertDialog.Builder;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.preference.PreferenceActivity;
import com.xiaomi.market.sdk.UpdateResponse;
import com.xiaomi.market.sdk.XiaomiUpdateAgent;
import com.xiaomi.market.sdk.XiaomiUpdateListener;

public class CalSettingsActivity extends PreferenceActivity implements OnPreferenceClickListener {
    private Preference f1420a;
    private XiaomiUpdateListener f1421b;

    /* renamed from: com.miui.calculator.cal.CalSettingsActivity.1 */
    class C01541 implements XiaomiUpdateListener {
        final /* synthetic */ CalSettingsActivity f1416a;

        C01541(CalSettingsActivity calSettingsActivity) {
            this.f1416a = calSettingsActivity;
        }

        public void m2688a(int i, UpdateResponse updateResponse) {
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    if (this.f1416a.f1420a != null) {
                        this.f1416a.f1420a.setSummary(this.f1416a.getString(C0264R.string.preference_check_update_summary_current_version, new Object[]{StatisticUtils.f1556a}) + ", " + this.f1416a.getString(C0264R.string.preference_check_update_summary_new_version, new Object[]{updateResponse.f4603b}));
                    }
                default:
            }
        }
    }

    /* renamed from: com.miui.calculator.cal.CalSettingsActivity.2 */
    class C01552 implements OnClickListener {
        final /* synthetic */ String f1417a;
        final /* synthetic */ CalSettingsActivity f1418b;

        C01552(CalSettingsActivity calSettingsActivity, String str) {
            this.f1418b = calSettingsActivity;
            this.f1417a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CalculatorUtils.m2818a(this.f1418b.getApplicationContext(), this.f1417a);
        }
    }

    public CalSettingsActivity() {
        this.f1421b = new C01541(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getPreferenceManager() != null) {
            addPreferencesFromResource(C0264R.xml.cal_settings);
            Preference findPreference = findPreference("key_feedback");
            if (m2696b()) {
                ((PreferenceGroup) findPreference("about_calculator")).removePreference(findPreference);
            } else {
                findPreference.setOnPreferenceClickListener(this);
            }
            this.f1420a = findPreference("key_check_update");
            this.f1420a.setOnPreferenceClickListener(this);
            this.f1420a.setSummary(getString(C0264R.string.preference_check_update_summary_current_version, new Object[]{StatisticUtils.f1556a}));
            findPreference("key_follow_wechat").setOnPreferenceClickListener(this);
            findPreference("key_follow_weibo").setOnPreferenceClickListener(this);
            findPreference("key_follow_web").setOnPreferenceClickListener(this);
            m2695a(false);
        }
    }

    protected void onResume() {
        super.onResume();
        StatisticUtils.m2889a(getClass().getSimpleName());
    }

    protected void onPause() {
        super.onPause();
        StatisticUtils.m2897b(getClass().getSimpleName());
    }

    private void m2695a(boolean z) {
        XiaomiUpdateAgent.m6219a(z);
        XiaomiUpdateAgent.m6218a(z ? null : this.f1421b);
        XiaomiUpdateAgent.m6216a((Context) this);
    }

    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        StatisticUtils.m2903g(key);
        if ("key_check_update".equals(key)) {
            m2695a(true);
            return true;
        } else if ("key_feedback".equals(key)) {
            m2693a(C0264R.string.preference_alert_follow_qq_group, "523274279");
            return true;
        } else if ("key_follow_wechat".equals(key)) {
            m2693a(C0264R.string.preference_alert_follow_wechat, "MIUI");
            return true;
        } else if ("key_follow_weibo".equals(key)) {
            m2694a("http://weibo.com/miui");
            return true;
        } else if (!"key_follow_web".equals(key)) {
            return false;
        } else {
            m2694a("http://www.miui.com");
            return true;
        }
    }

    private void m2693a(int i, String str) {
        new Builder(this).m3269b(i).m3262a(C0264R.string.preference_alert_follow_wechat_button, new C01552(this, str)).m3268a().show();
    }

    private void m2694a(String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean m2696b() {
        boolean i = CalculatorUtils.m2830i();
        Log.i("CalSettingsActivity", "hideFeedBack:" + i);
        return i;
    }
}
