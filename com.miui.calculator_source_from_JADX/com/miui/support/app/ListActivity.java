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

public class ListActivity extends android.app.ListActivity implements IActivity {
    private ActivityDelegate f1920a;

    public /* synthetic */ ActionBar getActionBar() {
        return m3298a();
    }

    public ListActivity() {
        this.f1920a = new ActivityDelegate(this, android.app.ListActivity.class);
    }

    public ActionBar m3298a() {
        return this.f1920a.m3629c();
    }

    public MenuInflater getMenuInflater() {
        return this.f1920a.m3631d();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1920a.m3703a(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1920a.m3615a(configuration);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f1920a.m3712b(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f1920a.m3715c(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.f1920a.m3719h();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f1920a.m3720i();
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            return this.f1920a.m3714c(i);
        }
        return super.onCreatePanelView(i);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f1920a.m3705a(charSequence);
    }

    public void invalidateOptionsMenu() {
        this.f1920a.m3711b();
    }

    public ActionMode startActionMode(Callback callback) {
        return this.f1920a.m3701a(callback);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        return this.f1920a.m3710b(callback);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1920a.m3704a(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1920a.m3713b(actionMode);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f1920a.m3706a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f1920a.m3708a(i, view, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f1920a.m3707a(i, menuItem);
    }

    public void onBackPressed() {
        if (!this.f1920a.m3723o()) {
            super.onBackPressed();
        }
    }

    public void m3299c(int i) {
        this.f1920a.m3624b(i);
    }

    public int m3300f() {
        return this.f1920a.m3640k();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f1920a.m3627b(false);
    }
}
