package com.miui.support.preference;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.miui.support.app.IFragment;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.app.FragmentDelegate;
import com.miui.support.util.AttributeResolver;

public class PreferenceFragment extends android.preference.PreferenceFragment implements IFragment {
    private FragmentDelegate f3511a;
    private boolean f3512b;
    private boolean f3513c;

    public PreferenceFragment() {
        this.f3512b = true;
        this.f3513c = true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3511a = new FragmentDelegate(this);
        this.f3511a.m3616a(bundle);
    }

    public void onStop() {
        super.onStop();
        this.f3511a.m3637h();
    }

    public void onResume() {
        super.onResume();
        this.f3511a.m3638i();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a = this.f3511a.m3818a(viewGroup, bundle);
        ListView listView = (ListView) a.findViewById(16908298);
        if (listView != null) {
            listView.setClipToPadding(false);
            listView.setPadding(0, 0, 0, (int) AttributeResolver.m5323d(a.getContext(), C0264R.attr.preferenceScreenPaddingBottom));
        }
        return a;
    }

    public View getView() {
        return this.f3511a.m3831n();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3511a.m3615a(configuration);
    }

    public Context m5199a() {
        return this.f3511a.m3830m();
    }

    public void setHasOptionsMenu(boolean z) {
        super.setHasOptionsMenu(z);
        if (this.f3512b != z) {
            this.f3512b = z;
            if (!isHidden() && isAdded() && this.f3511a != null) {
                this.f3511a.m3826b();
            }
        }
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        if (this.f3513c != z) {
            this.f3513c = z;
            if (!isHidden() && isAdded() && this.f3511a != null) {
                this.f3511a.m3826b();
            }
        }
    }

    public final void m5202a(ActionMode actionMode) {
    }

    public final void m5206b(ActionMode actionMode) {
    }

    public boolean m5204a(int i, Menu menu) {
        if (i == 0 && this.f3512b && this.f3513c && !isHidden() && isAdded()) {
            return m5205a(menu);
        }
        return false;
    }

    public void m5201a(int i, View view, Menu menu) {
        if (i == 0 && this.f3512b && this.f3513c && !isHidden() && isAdded()) {
            onPrepareOptionsMenu(menu);
        }
    }

    public boolean m5205a(Menu menu) {
        return true;
    }

    public View m5200a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!(z || this.f3511a == null)) {
            this.f3511a.m3826b();
        }
        m5203a(!z);
    }

    public void m5203a(boolean z) {
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3511a.m3627b(false);
    }
}
