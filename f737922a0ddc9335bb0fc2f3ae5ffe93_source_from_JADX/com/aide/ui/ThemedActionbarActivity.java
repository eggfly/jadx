package com.aide.ui;

import android.app.Activity;
import android.os.Bundle;

public class ThemedActionbarActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (h.cn()) {
            setTheme(R.g.ActivityActionbarThemeLight);
        } else {
            setTheme(R.g.ActivityActionbarThemeDark);
        }
    }
}
