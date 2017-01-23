package com.miui.support.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import com.miui.support.internal.app.FragmentDelegate;

public class Fragment extends android.app.Fragment implements IFragment {
    private FragmentDelegate f1917a;
    private boolean f1918b;
    private boolean f1919c;

    public Fragment() {
        this.f1918b = true;
        this.f1919c = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1917a = new FragmentDelegate(this);
        this.f1917a.m3616a(bundle);
    }

    public void onStop() {
        super.onStop();
        this.f1917a.m3637h();
    }

    public void onResume() {
        super.onResume();
        this.f1917a.m3638i();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1917a.m3818a(viewGroup, bundle);
    }

    public View getView() {
        return this.f1917a.m3831n();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1917a.m3615a(configuration);
    }

    public Context m3290a() {
        return this.f1917a.m3830m();
    }

    public void setHasOptionsMenu(boolean z) {
        super.setHasOptionsMenu(z);
        if (this.f1918b != z) {
            this.f1918b = z;
            if (this.f1918b && this.f1917a != null && !this.f1917a.m3641l() && !isHidden() && isAdded()) {
                this.f1917a.m3826b();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (this.f1919c != z) {
            this.f1919c = z;
            if (!isHidden() && isAdded() && this.f1917a != null) {
                this.f1917a.m3826b();
            }
        }
    }

    public final void m3293a(ActionMode actionMode) {
    }

    public final void m3297b(ActionMode actionMode) {
    }

    public boolean m3295a(int i, Menu menu) {
        if (i == 0 && this.f1918b && !this.f1917a.m3641l() && this.f1919c && !isHidden() && isAdded()) {
            return m3296a(menu);
        }
        return false;
    }

    public void m3292a(int i, View view, Menu menu) {
        if (i == 0 && this.f1918b && !this.f1917a.m3641l() && this.f1919c && !isHidden() && isAdded()) {
            onPrepareOptionsMenu(menu);
        }
    }

    public boolean m3296a(Menu menu) {
        return true;
    }

    public View m3291a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!(z || this.f1917a == null)) {
            this.f1917a.m3826b();
        }
        m3294a(!z);
    }

    public void m3294a(boolean z) {
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1917a.m3627b(false);
    }
}
