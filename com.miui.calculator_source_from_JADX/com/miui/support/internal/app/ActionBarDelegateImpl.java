package com.miui.support.internal.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.app.ActionBar;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_View_Window_class.Factory;
import com.miui.support.internal.view.menu.ImmersionMenuPopupWindow;
import com.miui.support.internal.view.menu.MenuBuilder;
import com.miui.support.internal.view.menu.MenuBuilder.Callback;
import com.miui.support.internal.view.menu.MenuPresenter;
import com.miui.support.internal.view.menu.PadImmersionMenuPopupWindow;
import com.miui.support.internal.view.menu.PhoneImmersionMenuPopupWindow;
import com.miui.support.internal.widget.ActionBarView;

public abstract class ActionBarDelegateImpl implements ActionBarDelegate, Callback, MenuPresenter.Callback {
    final Activity f2097a;
    protected ActionBarView f2098b;
    protected MenuBuilder f2099c;
    protected ActionMode f2100d;
    protected boolean f2101e;
    protected boolean f2102f;
    protected boolean f2103g;
    boolean f2104h;
    boolean f2105i;
    protected int f2106j;
    private ActionBar f2107k;
    private MenuInflater f2108l;
    private int f2109m;
    private ImmersionMenuPopupWindow f2110n;
    private boolean f2111o;
    private MenuBuilder f2112p;

    protected abstract boolean m3632d(MenuBuilder menuBuilder);

    protected abstract boolean m3634e(MenuBuilder menuBuilder);

    public abstract Context m3642m();

    ActionBarDelegateImpl(Activity activity) {
        this.f2109m = 0;
        this.f2097a = activity;
    }

    public final ActionBar m3629c() {
        if (!this.f2104h && !this.f2105i) {
            this.f2107k = null;
        } else if (this.f2107k == null) {
            this.f2107k = m3607a();
        }
        return this.f2107k;
    }

    public MenuInflater m3631d() {
        if (this.f2108l == null) {
            ActionBar c = m3629c();
            if (c != null) {
                this.f2108l = new MenuInflater(c.getThemedContext());
            } else {
                this.f2108l = new MenuInflater(this.f2097a);
            }
        }
        return this.f2108l;
    }

    public void m3616a(Bundle bundle) {
    }

    protected final String m3633e() {
        String str = null;
        try {
            ActivityInfo activityInfo = this.f2097a.getPackageManager().getActivityInfo(this.f2097a.getComponentName(), 128);
            if (activityInfo.metaData != null) {
                str = activityInfo.metaData.getString("android.support.UI_OPTIONS");
            }
        } catch (NameNotFoundException e) {
            Log.e("ActionBarDelegate", "getUiOptionsFromMetadata: Activity '" + this.f2097a.getClass().getSimpleName() + "' not in manifest");
        }
        return str;
    }

    protected final Context m3635f() {
        Context context = this.f2097a;
        ActionBar c = m3629c();
        if (c != null) {
            return c.getThemedContext();
        }
        return context;
    }

    public Activity m3636g() {
        return this.f2097a;
    }

    public void m3615a(Configuration configuration) {
        if (this.f2104h && this.f2101e) {
            ((ActionBarImpl) m3629c()).m3667a(configuration);
        }
    }

    public void m3637h() {
        m3627b(false);
        if (this.f2104h && this.f2101e) {
            ActionBarImpl actionBarImpl = (ActionBarImpl) m3629c();
            if (actionBarImpl != null) {
                actionBarImpl.m3682g(false);
            }
        }
    }

    public void m3638i() {
        if (this.f2104h && this.f2101e) {
            ActionBarImpl actionBarImpl = (ActionBarImpl) m3629c();
            if (actionBarImpl != null) {
                actionBarImpl.m3682g(true);
            }
        }
    }

    public boolean m3622a(int i) {
        switch (i) {
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                this.f2102f = true;
                return true;
            case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                this.f2103g = true;
                return true;
            case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                this.f2104h = true;
                return true;
            case C0264R.styleable.Window_windowFixedHeightMajor /*9*/:
                this.f2105i = true;
                return true;
            default:
                return this.f2097a.requestWindowFeature(i);
        }
    }

    public ActionMode m3614a(ActionMode.Callback callback) {
        return null;
    }

    public ActionMode m3623b(ActionMode.Callback callback) {
        return null;
    }

    public void m3617a(ActionMode actionMode) {
    }

    public void m3625b(ActionMode actionMode) {
    }

    protected void m3620a(MenuBuilder menuBuilder, boolean z) {
        if (this.f2098b == null || !this.f2098b.m4755e()) {
            menuBuilder.close();
        } else if (this.f2098b.m4754d() && z) {
            this.f2098b.m4753c();
        } else if (this.f2098b.getVisibility() == 0) {
            this.f2098b.m4751a();
        }
    }

    protected void m3619a(MenuBuilder menuBuilder) {
        if (menuBuilder != this.f2099c) {
            this.f2099c = menuBuilder;
            if (this.f2098b != null) {
                this.f2098b.m4750a((Menu) menuBuilder, (MenuPresenter.Callback) this);
            }
        }
    }

    protected MenuBuilder m3639j() {
        MenuBuilder menuBuilder = new MenuBuilder(m3635f());
        menuBuilder.m4420a((Callback) this);
        return menuBuilder;
    }

    public void m3626b(MenuBuilder menuBuilder, boolean z) {
        this.f2097a.closeOptionsMenu();
    }

    public boolean m3628b(MenuBuilder menuBuilder) {
        return false;
    }

    public void m3630c(MenuBuilder menuBuilder) {
        m3620a(menuBuilder, true);
    }

    public void m3624b(int i) {
        int integer = this.f2097a.getResources().getInteger(C0264R.integer.window_translucent_status);
        if (integer >= 0 && integer <= 2) {
            i = integer;
        }
        if (this.f2109m != i && Factory.getInstance().get().setTranslucentStatus(this.f2097a.getWindow(), i)) {
            this.f2109m = i;
        }
    }

    public int m3640k() {
        return this.f2109m;
    }

    public void m3621a(boolean z) {
        this.f2111o = z;
        if (this.f2101e && this.f2104h) {
            if (!z) {
                this.f2098b.m4759i();
            } else if (!this.f2098b.m4758h()) {
                this.f2098b.m4749a(this.f2106j, this);
            }
            m3609b();
        }
    }

    public boolean m3641l() {
        return this.f2111o;
    }

    public void m3618a(View view, ViewGroup viewGroup) {
        if (!this.f2111o) {
            Log.w("ActionBarDelegate", "Try to show immersion menu when immersion menu disabled");
        } else if (view == null) {
            throw new IllegalArgumentException("You must specify a valid anchor view");
        } else {
            if (this.f2112p == null) {
                this.f2112p = m3639j();
                m3632d(this.f2112p);
            }
            if (m3634e(this.f2112p) && this.f2112p.hasVisibleItems()) {
                if (this.f2110n != null) {
                    this.f2110n.m4461a(this.f2112p);
                } else if (DeviceHelper.f2555g) {
                    this.f2110n = new PadImmersionMenuPopupWindow(this, this.f2112p);
                } else {
                    this.f2110n = new PhoneImmersionMenuPopupWindow(this, this.f2112p);
                }
                if (!this.f2110n.isShowing()) {
                    this.f2110n.m4462a(view, viewGroup);
                }
            }
        }
    }

    public void m3627b(boolean z) {
        if (this.f2110n != null) {
            this.f2110n.m4463a(z);
        }
    }
}
