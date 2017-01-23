package com.miui.support.preference;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.preference.DialogPreference;
import com.android.internal.app.AlertController.AlertParams;
import com.miui.support.internal.variable.AlertControllerWrapper;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;

class PreferenceDialogBuilder extends Builder {
    private static final Field f3506a;
    private static final Field f3507b;
    private static final Field f3508d;
    private static final Method f3509e;
    private AlertParams f3510c;

    static class PreferenceDialog extends AlertDialog {
        PreferenceDialog(Context context, int i) {
            super(context, i);
            PreferenceDialogBuilder.f3506a.set((Object) this, new AlertControllerWrapper(context, this, getWindow()));
        }
    }

    static {
        f3506a = Field.of(AlertDialog.class, "mAlert", "Lcom/android/internal/app/AlertController;");
        f3507b = Field.of(DialogPreference.class, "mBuilder", "Landroid/app/AlertDialog$Builder;");
        f3508d = Field.of(Builder.class, "P", "Lcom/android/internal/app/AlertController$AlertParams;");
        f3509e = Method.of(AlertParams.class, "apply", "(Lcom/android/internal/app/AlertController;)V");
    }

    public PreferenceDialogBuilder(Context context) {
        super(context);
        this.f3510c = new AlertControllerWrapper.AlertParams(context);
        f3508d.set((Object) this, this.f3510c);
    }

    public AlertDialog create() {
        AlertDialog preferenceDialog = new PreferenceDialog(getContext(), 0);
        f3509e.invoke(null, f3508d.get(this), f3506a.get(preferenceDialog));
        return preferenceDialog;
    }

    static void m5198a(DialogPreference dialogPreference, Builder builder) {
        f3507b.set((Object) dialogPreference, (Object) builder);
    }
}
