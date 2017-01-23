package com.dev.system.monitor;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import com.dev.system.monitor.SystemBarTintManager.SystemBarConfig;

public class AppInfo extends PreferenceActivity {

    /* renamed from: com.dev.system.monitor.AppInfo.1 */
    class C00871 implements OnPreferenceClickListener {
        C00871() {
        }

        public boolean onPreferenceClick(Preference preference) {
            AppInfo.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.dev.system.monitor")));
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.AppInfo.2 */
    class C00882 implements OnPreferenceClickListener {
        C00882() {
        }

        public boolean onPreferenceClick(Preference preference) {
            AppInfo.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/u/0/+danielecomi/about")));
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.AppInfo.3 */
    class C00893 implements OnPreferenceClickListener {
        C00893() {
        }

        public boolean onPreferenceClick(Preference preference) {
            AppInfo.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/daniele.comi.16")));
            return false;
        }
    }

    /* renamed from: com.dev.system.monitor.AppInfo.4 */
    class C00904 implements OnPreferenceClickListener {
        C00904() {
        }

        public boolean onPreferenceClick(Preference preference) {
            AppInfo.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/TheDeveloper01")));
            return false;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(8);
        getWindow().requestFeature(10);
        if (VERSION.SDK_INT >= 19) {
            getWindow().setFlags(67108864, 67108864);
            getWindow().setFlags(134217728, 134217728);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setTintStatusBarColor(Color.parseColor("#318CE7"));
            tintManager.setTintNavigationBarColor(Color.parseColor("#ff000000"));
        }
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#318CE7")));
        actionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#318CE7")));
        actionBar.setHomeButtonEnabled(true);
        if (VERSION.SDK_INT >= 19) {
            SystemBarConfig config = new SystemBarTintManager(this).getConfig();
            getListView().setPadding(20, config.getPixelInsetTop(true), 20, config.getPixelInsetBottom());
        }
        addPreferencesFromResource(C0133R.xml.settings);
        Preference appLink = findPreference("app");
        Preference gplus = findPreference("gplus");
        Preference facebook = findPreference("facebook");
        Preference twitter = findPreference("twitter");
        appLink.setOnPreferenceClickListener(new C00871());
        gplus.setOnPreferenceClickListener(new C00882());
        facebook.setOnPreferenceClickListener(new C00893());
        twitter.setOnPreferenceClickListener(new C00904());
    }
}
