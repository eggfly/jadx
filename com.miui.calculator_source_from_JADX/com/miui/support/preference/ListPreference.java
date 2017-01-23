package com.miui.support.preference;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.miui.support.reflect.Field;

public class ListPreference extends android.preference.ListPreference {
    private static final Field f3505a;

    /* renamed from: com.miui.support.preference.ListPreference.1 */
    class C04131 implements OnClickListener {
        final /* synthetic */ ListPreference f3504a;

        C04131(ListPreference listPreference) {
            this.f3504a = listPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ListPreference.f3505a.set(this.f3504a, i);
            this.f3504a.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    static {
        f3505a = Field.of(android.preference.ListPreference.class, "mClickedDialogEntryIndex", Field.INT_SIGNATURE_PRIMITIVE);
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);
        PreferenceDialogBuilder.m5198a(this, new PreferenceDialogBuilder(builder.getContext()).setTitle(getDialogTitle()).setPositiveButton(null, null).setNegativeButton(getNegativeButtonText(), this).setSingleChoiceItems(getEntries(), findIndexOfValue(getValue()), new C04131(this)));
    }
}
