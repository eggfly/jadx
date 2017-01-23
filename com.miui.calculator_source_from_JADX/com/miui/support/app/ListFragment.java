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

public class ListFragment extends android.app.ListFragment implements IFragment {
    private FragmentDelegate f1921a;
    private boolean f1922b;
    private boolean f1923c;

    public ListFragment() {
        this.f1922b = true;
        this.f1923c = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1921a = new FragmentDelegate(this);
        this.f1921a.m3616a(bundle);
    }

    public void onStop() {
        super.onStop();
        this.f1921a.m3637h();
    }

    public void onResume() {
        super.onResume();
        this.f1921a.m3638i();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f1921a.m3818a(viewGroup, bundle);
    }

    public View getView() {
        return this.f1921a.m3831n();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1921a.m3615a(configuration);
    }

    public Context m3301a() {
        return this.f1921a.m3830m();
    }

    public void setHasOptionsMenu(boolean z) {
        super.setHasOptionsMenu(z);
        if (this.f1922b != z) {
            this.f1922b = z;
            if (!isHidden() && isAdded() && this.f1921a != null) {
                this.f1921a.m3826b();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (this.f1923c != z) {
            this.f1923c = z;
            if (!isHidden() && isAdded() && this.f1921a != null) {
                this.f1921a.m3826b();
            }
        }
    }

    public final void m3304a(ActionMode actionMode) {
    }

    public final void m3308b(ActionMode actionMode) {
    }

    public boolean m3306a(int i, Menu menu) {
        if (i == 0 && this.f1922b && this.f1923c && !isHidden() && isAdded()) {
            return m3307a(menu);
        }
        return false;
    }

    public void m3303a(int i, View view, Menu menu) {
        if (i == 0 && this.f1922b && this.f1923c && !isHidden() && isAdded()) {
            onPrepareOptionsMenu(menu);
        }
    }

    public boolean m3307a(Menu menu) {
        return true;
    }

    public View m3302a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!(z || this.f1921a == null)) {
            this.f1921a.m3826b();
        }
        m3305a(!z);
    }

    public void m3305a(boolean z) {
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1921a.m3627b(false);
    }
}
