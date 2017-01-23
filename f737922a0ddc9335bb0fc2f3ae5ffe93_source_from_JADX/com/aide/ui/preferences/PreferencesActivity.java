package com.aide.ui.preferences;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceActivity.Header;
import com.aide.analytics.a;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.h;
import java.util.ArrayList;
import java.util.List;

public class PreferencesActivity extends PreferenceActivity {
    private List<Header> j6;

    public static void j6(Activity activity, int i) {
        Intent intent = new Intent(activity, PreferencesActivity.class);
        intent.putExtra("SHOW_PAGE", i);
        activity.startActivity(intent);
    }

    protected boolean isValidFragment(String str) {
        return true;
    }

    protected void onCreate(Bundle bundle) {
        if (h.cn()) {
            setTheme(R.g.ActivityPreferencesThemeLight);
        } else {
            setTheme(R.g.ActivityPreferencesThemeDark);
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("SHOW_PAGE", -1);
            if (intExtra >= 0 && this.j6 != null) {
                onHeaderClick((Header) this.j6.get(intExtra), intExtra);
            }
        }
        d.j6((Activity) this);
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    public void onBuildHeaders(List<Header> list) {
        List<Header> arrayList = new ArrayList();
        loadHeadersFromResource(2131034118, arrayList);
        for (Header header : arrayList) {
            if (j6(header.title)) {
                list.add(header);
            }
        }
        Header header2 = new Header();
        header2.title = "Legal";
        header2.summary = "Show legal information.";
        header2.intent = new Intent(this, AboutActivity.class);
        list.add(header2);
        this.j6 = list;
    }

    private boolean j6(CharSequence charSequence) {
        if (e.j6.equals("com.aide.web") && charSequence.equals("Build & Run")) {
            return false;
        }
        return true;
    }

    protected void onStart() {
        super.onStart();
        e.j6((Activity) this);
        a.j6((Activity) this, "Preferences");
    }

    protected void onStop() {
        super.onStop();
        e.DW((Activity) this);
        a.DW(this, "Preferences");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1194684) {
            e.cn().j6(intent);
        }
    }
}
