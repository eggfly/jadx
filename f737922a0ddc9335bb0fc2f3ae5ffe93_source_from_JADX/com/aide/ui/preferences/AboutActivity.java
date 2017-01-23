package com.aide.ui.preferences;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.aide.analytics.a;
import com.aide.ui.R;

public class AboutActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.c.about);
        ((WebView) findViewById(R.b.aboutWebView)).loadUrl("file:///android_asset/license.html");
    }

    protected void onStart() {
        super.onStart();
        a.j6((Activity) this, "About");
    }

    protected void onStop() {
        super.onStop();
        a.DW(this, "About");
    }
}
