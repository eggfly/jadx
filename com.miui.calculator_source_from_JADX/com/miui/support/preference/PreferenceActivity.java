package com.miui.support.preference;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.miui.support.app.IActivity;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.ActivityDelegate;
import com.miui.support.internal.variable.Android_App_PreferenceActivity_class.Factory;
import com.miui.support.util.AttributeResolver;

public class PreferenceActivity extends android.preference.PreferenceActivity implements IActivity {
    private ActivityDelegate f1419a;

    public /* synthetic */ ActionBar getActionBar() {
        return m2689a();
    }

    public PreferenceActivity() {
        this.f1419a = new ActivityDelegate(this, android.preference.PreferenceActivity.class);
    }

    public com.miui.support.app.ActionBar m2689a() {
        return this.f1419a.m3629c();
    }

    public MenuInflater getMenuInflater() {
        return this.f1419a.m3631d();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1419a.m3703a(bundle);
        ListView listView = (ListView) findViewById(16908298);
        if (listView != null) {
            listView.setClipToPadding(false);
            listView.setPadding(0, 0, 0, (int) AttributeResolver.m5323d(this, C0264R.attr.preferenceScreenPaddingBottom));
            ViewGroup viewGroup = (ViewGroup) listView.getParent();
            if (viewGroup != null) {
                viewGroup.setPadding(0, 0, 0, 0);
            }
        }
        Factory.getInstance().get().onCreate(this, bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1419a.m3615a(configuration);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f1419a.m3712b(bundle);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f1419a.m3715c(bundle);
    }

    protected void onStop() {
        super.onStop();
        this.f1419a.m3719h();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f1419a.m3720i();
    }

    public View onCreatePanelView(int i) {
        if (i == 0) {
            return this.f1419a.m3714c(i);
        }
        return super.onCreatePanelView(i);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        this.f1419a.m3705a(charSequence);
    }

    public void invalidateOptionsMenu() {
        this.f1419a.m3711b();
    }

    public ActionMode startActionMode(Callback callback) {
        return this.f1419a.m3701a(callback);
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        return this.f1419a.m3710b(callback);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f1419a.m3704a(actionMode);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f1419a.m3713b(actionMode);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f1419a.m3706a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f1419a.m3708a(i, view, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.f1419a.m3707a(i, menuItem);
    }

    public void onBackPressed() {
        if (!this.f1419a.m3723o()) {
            super.onBackPressed();
        }
    }

    public void m2690c(int i) {
        this.f1419a.m3624b(i);
    }

    public int m2691f() {
        return this.f1419a.m3640k();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f1419a.m3627b(false);
    }
}
