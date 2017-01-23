package com.miui.support.internal.view;

import android.content.Context;
import android.view.ActionMode.Callback;
import android.view.View;
import com.miui.support.internal.widget.ActionBarContextView;
import com.miui.support.internal.widget.ActionModeView;
import com.miui.support.view.ActionModeAnimationListener;
import com.miui.support.view.EditActionMode;

public class EditActionModeImpl extends ActionModeImpl implements EditActionMode {
    public EditActionModeImpl(Context context, Callback callback) {
        super(context, callback);
    }

    public void setTitle(CharSequence charSequence) {
        ((ActionBarContextView) this.b.get()).setTitle(charSequence);
    }

    public void setTitle(int i) {
        setTitle(this.a.getResources().getString(i));
    }

    public CharSequence getTitle() {
        return ((ActionBarContextView) this.b.get()).getTitle();
    }

    public void m4287a(int i, CharSequence charSequence) {
        ((ActionBarContextView) this.b.get()).m4642a(i, charSequence);
    }

    public void m4286a(int i, int i2) {
        m4287a(i, this.a.getResources().getString(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setSubtitle(int i) {
    }

    public void setCustomView(View view) {
    }

    public void m4288a(ActionModeAnimationListener actionModeAnimationListener) {
        ((ActionModeView) this.b.get()).m4631a(actionModeAnimationListener);
    }
}
