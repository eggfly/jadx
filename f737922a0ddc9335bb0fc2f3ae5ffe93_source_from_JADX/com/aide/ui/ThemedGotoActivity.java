package com.aide.ui;

import android.app.Activity;
import android.os.Bundle;

public class ThemedGotoActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (h.cn()) {
            setTheme(R.g.ActivityGotoThemeLight);
        } else {
            setTheme(R.g.ActivityGotoThemeDark);
        }
    }
}
