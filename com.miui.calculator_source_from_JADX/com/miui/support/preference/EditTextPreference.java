package com.miui.support.preference;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.miui.support.internal.C0264R;

public class EditTextPreference extends android.preference.EditTextPreference {
    private View f3503a;

    protected View onCreateDialogView() {
        View onCreateDialogView = super.onCreateDialogView();
        this.f3503a = onCreateDialogView;
        return onCreateDialogView;
    }

    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(C0264R.id.edittext_container);
        if (viewGroup != null) {
            viewGroup.addView(editText, -1, -2);
        }
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        Builder negativeButton = new PreferenceDialogBuilder(builder.getContext()).setTitle(getDialogTitle()).setPositiveButton(getPositiveButtonText(), this).setNegativeButton(getNegativeButtonText(), this);
        if (this.f3503a != null) {
            negativeButton.setView(this.f3503a);
        } else {
            negativeButton.setMessage(getDialogMessage());
        }
        PreferenceDialogBuilder.m5198a(this, negativeButton);
    }
}
