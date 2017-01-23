package com.miui.support.app;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.miui.support.internal.app.ActivityDelegate;

public class Activity extends android.app.Activity implements IActivity {
    private ActivityDelegate f1371a;

    public /* synthetic */ ActionBar getActionBar() {
        return m2626e();
    }

    public Activity() {
        this.f1371a = new ActivityDelegate(this, android.app.Activity.class);
    }

    public ActionBar m2626e() {
        return this.f1371a.m3629c();
    }

    public MenuInflater getMenuInflater() {
        return this.f1371a.m3631d();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1371a.m3703a(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1371a.m3615a(configuration);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f1371a.m3712b(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f1371a.m3715c(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.f1371a.m3719h();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f1371a.m3720i();
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            return this.f1371a.m3714c(i);
        }
        return super.onCreatePanelView(i);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f1371a.m3705a(charSequence);
    }

    public void invalidateOptionsMenu() {
        this.f1371a.m3711b();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f1371a.m3706a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f1371a.m3708a(i, view, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f1371a.m3707a(i, menuItem);
    }

    public ActionMode startActionMode(Callback callback) {
        return this.f1371a.m3701a(callback);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        return this.f1371a.m3710b(callback);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1371a.m3704a(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1371a.m3713b(actionMode);
    }

    public void onBackPressed() {
        if (!this.f1371a.m3723o()) {
            super.onBackPressed();
        }
    }

    public void m2625c(int i) {
        this.f1371a.m3624b(i);
    }

    public int m2627f() {
        return this.f1371a.m3640k();
    }
}
