package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.j;
import android.support.v4.app.n;
import com.google.android.gms.common.internal.b;

public class e extends j {
    private Dialog CU;
    private OnCancelListener Xa;

    public e() {
        this.CU = null;
        this.Xa = null;
    }

    public static e j6(Dialog dialog, OnCancelListener onCancelListener) {
        e eVar = new e();
        Dialog dialog2 = (Dialog) b.j6((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        eVar.CU = dialog2;
        if (onCancelListener != null) {
            eVar.Xa = onCancelListener;
        }
        return eVar;
    }

    public Dialog FH(Bundle bundle) {
        if (this.CU == null) {
            DW(false);
        }
        return this.CU;
    }

    public void j6(n nVar, String str) {
        super.j6(nVar, str);
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.Xa != null) {
            this.Xa.onCancel(dialogInterface);
        }
    }
}
