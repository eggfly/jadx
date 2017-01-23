package com.miui.support.internal.variable.hook.v16;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.miui.support.internal.variable.AlertControllerWrapper;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;

public class Android_App_AlertDialog_class extends com.miui.support.internal.variable.hook.Android_App_AlertDialog_class {
    private static final Field mAlertField;

    static {
        mAlertField = Field.of(AlertDialog.class, "mAlert", "Lcom/android/internal/app/AlertController;");
    }

    protected void handle() {
        handle_init_(0, null, null, 0, false);
        handle_init_(0, null, null, false, null);
    }

    public void buildProxy() {
        attachConstructor("(Landroid/content/Context;IZ)V");
        attachConstructor("(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V");
    }

    protected void handle_init_(long j, AlertDialog alertDialog, Context context, int i, boolean z) {
        original_init_(j, alertDialog, context, i, z);
        updateAlertField(alertDialog);
    }

    protected void original_init_(long j, AlertDialog alertDialog, Context context, int i, boolean z) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_App_AlertDialog_class.original_init_(long, AlertDialog, Context, int, boolean)");
    }

    protected void handle_init_(long j, AlertDialog alertDialog, Context context, boolean z, OnCancelListener onCancelListener) {
        original_init_(j, alertDialog, context, z, onCancelListener);
        updateAlertField(alertDialog);
    }

    protected void original_init_(long j, AlertDialog alertDialog, Context context, boolean z, OnCancelListener onCancelListener) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_App_AlertDialog_class.original_init_(long, AlertDialog, Context, boolean, OnCancelListener)");
    }

    private void updateAlertField(AlertDialog alertDialog) {
        try {
            mAlertField.set((Object) alertDialog, new AlertControllerWrapper(alertDialog.getContext(), alertDialog, alertDialog.getWindow()));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.AlertDialog.mAlert", e);
        }
    }
}
