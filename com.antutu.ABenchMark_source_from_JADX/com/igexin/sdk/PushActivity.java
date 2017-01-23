package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.sdk.p186a.C3939a;

public class PushActivity extends Activity {
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityConfigurationChanged(this, configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return C3939a.m16217a().m16220b() != null ? C3939a.m16217a().m16220b().onActivityCreateOptionsMenu(this, menu) : true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityDestroy(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (C3939a.m16217a().m16220b() == null || !C3939a.m16217a().m16220b().onActivityKeyDown(this, i, keyEvent)) ? super.onKeyDown(i, keyEvent) : true;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityNewIntent(this, intent);
        }
    }

    protected void onPause() {
        super.onPause();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityPause(this);
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityRestart(this);
        }
    }

    protected void onResume() {
        super.onResume();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityResume(this);
        }
    }

    protected void onStart() {
        super.onStart();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityStart(this, getIntent());
        }
    }

    protected void onStop() {
        super.onStop();
        if (C3939a.m16217a().m16220b() != null) {
            C3939a.m16217a().m16220b().onActivityStop(this);
        }
    }
}
