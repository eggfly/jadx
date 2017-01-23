package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.app.C0358b.C0356a;
import android.support.v7.view.C0413b;
import android.support.v7.view.C0413b.C0345a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bj;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import org.android.spdy.SpdyProtocol;

/* renamed from: android.support.v7.app.e */
public class C0377e extends FragmentActivity implements SupportParentable, C0374f {
    private C0349g mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private int mThemeId;

    public C0377e() {
        this.mThemeId = 0;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().m881b(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (KeyEventCompat.hasModifiers(keyEvent, SpdyProtocol.SLIGHTSSL_0_RTT_MODE) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0355a supportActionBar = getSupportActionBar();
                if (supportActionBar != null && supportActionBar.m998b() && supportActionBar.m1006g()) {
                    this.mEatKeyUpEvent = true;
                    return true;
                }
            } else if (action == 1 && this.mEatKeyUpEvent) {
                this.mEatKeyUpEvent = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return getDelegate().m871a(i);
    }

    public C0349g getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0349g.m864a((Activity) this, (C0374f) this);
        }
        return this.mDelegate;
    }

    public C0356a getDrawerToggleDelegate() {
        return getDelegate().m888g();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().m878b();
    }

    public Resources getResources() {
        if (this.mResources == null && bj.m2567a()) {
            this.mResources = new bj(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    public C0355a getSupportActionBar() {
        return getDelegate().m869a();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().m886e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().m872a(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    protected void onCreate(Bundle bundle) {
        C0349g delegate = getDelegate();
        delegate.m889h();
        delegate.m873a(bundle);
        if (delegate.m890i() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        getDelegate().m887f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0355a supportActionBar = getSupportActionBar();
        return (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.m989a() & 4) == 0) ? false : onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().m880b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        getDelegate().m885d();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().m883c(bundle);
    }

    protected void onStop() {
        super.onStop();
        getDelegate().m882c();
    }

    public void onSupportActionModeFinished(C0413b c0413b) {
    }

    public void onSupportActionModeStarted(C0413b c0413b) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder create = TaskStackBuilder.create(this);
            onCreateSupportNavigateUpTaskStack(create);
            onPrepareSupportNavigateUpTaskStack(create);
            create.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().m877a(charSequence);
    }

    public C0413b onWindowStartingSupportActionMode(C0345a c0345a) {
        return null;
    }

    public void setContentView(int i) {
        getDelegate().m879b(i);
    }

    public void setContentView(View view) {
        getDelegate().m875a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().m876a(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().m874a(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    public C0413b startSupportActionMode(C0345a c0345a) {
        return getDelegate().m870a(c0345a);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().m886e();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().m884c(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }
}
