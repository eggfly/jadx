package com.aide.ui.preferences;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class KeyBindingsPreferencesFragment extends Fragment {

    class 1 implements Runnable {
        final /* synthetic */ KeyBindingsPreferencesFragment j6;

        1(KeyBindingsPreferencesFragment keyBindingsPreferencesFragment) {
            this.j6 = keyBindingsPreferencesFragment;
        }

        public void run() {
            e.BT().DW();
            View view = this.j6.getView();
            if (view instanceof KeyBindingsView) {
                ((KeyBindingsView) view).j6();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.d.keybindings_options_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.b.keybindingsMenuDefault) {
            return super.onOptionsItemSelected(menuItem);
        }
        m.DW(getActivity(), "Reset Keybindings", "Really restore default keybindings? All changes will be lost.", new 1(this), null);
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return new KeyBindingsView(viewGroup.getContext());
    }
}
