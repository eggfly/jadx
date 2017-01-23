package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.b;

@TargetApi(11)
public class ErrorDialogFragment extends DialogFragment {
    private OnCancelListener DW;
    private Dialog j6;

    public ErrorDialogFragment() {
        this.j6 = null;
        this.DW = null;
    }

    public static ErrorDialogFragment j6(Dialog dialog, OnCancelListener onCancelListener) {
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        Dialog dialog2 = (Dialog) b.j6((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        errorDialogFragment.j6 = dialog2;
        if (onCancelListener != null) {
            errorDialogFragment.DW = onCancelListener;
        }
        return errorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.DW != null) {
            this.DW.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.j6 == null) {
            setShowsDialog(false);
        }
        return this.j6;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
