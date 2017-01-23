package com.aide.ui.htmluidesigner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import com.aide.analytics.a;
import com.aide.analytics.b;
import com.aide.ui.h;

public class PhonegapDesignActivity extends Activity {
    private WebView j6;

    class 1 implements b {
        final /* synthetic */ PhonegapDesignActivity j6;

        1(PhonegapDesignActivity phonegapDesignActivity) {
            this.j6 = phonegapDesignActivity;
        }

        public boolean j6() {
            return h.DW(this.j6);
        }
    }

    public static void j6(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, PhonegapDesignActivity.class);
        intent.putExtra("EXTRA_URL", "file://" + str2);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        j6();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a.j6()) {
            a.j6((Context) this, new 1(this));
        }
        this.j6 = new WebView(this);
        this.j6.setInitialScale(100);
        this.j6.setVerticalScrollBarEnabled(false);
        this.j6.getSettings().setJavaScriptEnabled(true);
        this.j6.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.j6.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
        setContentView(this.j6);
        j6();
    }

    private void j6() {
        if ((getIntent().getFlags() & 1048576) == 0) {
            this.j6.clearCache(true);
            String string = getIntent().getExtras().getString("EXTRA_URL");
            if (string != null) {
                this.j6.loadUrl(string);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        a.j6((Activity) this, "PhoneGap Designer");
    }

    protected void onStop() {
        super.onStop();
        a.DW(this, "PhoneGap Designer");
    }
}
