package com.google.android.gms.common;

import aeq$c;
import aft;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.zzol;

public class a extends i {
    private static final a FH;
    public static final int j6;

    static {
        FH = new a();
        j6 = i.DW;
    }

    a() {
    }

    public static a j6() {
        return FH;
    }

    public int DW(Context context) {
        return super.DW(context);
    }

    public int j6(Context context) {
        return super.j6(context);
    }

    public Dialog j6(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String Zo = k.Zo(activity);
        builder.setMessage(activity.getResources().getString(aeq$c.common_google_play_services_updating_text, new Object[]{Zo}));
        builder.setTitle(aeq$c.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        d.j6(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public PendingIntent j6(Context context, int i, int i2) {
        return super.j6(context, i, i2);
    }

    public PendingIntent j6(Context context, int i, int i2, String str) {
        return super.j6(context, i, i2, str);
    }

    public PendingIntent j6(Context context, ConnectionResult connectionResult) {
        if (connectionResult.j6()) {
            return connectionResult.Hw();
        }
        int FH = connectionResult.FH();
        if (aft.j6(context) && FH == 2) {
            FH = 42;
        }
        return j6(context, FH, 0);
    }

    public Intent j6(Context context, int i, String str) {
        return super.j6(context, i, str);
    }

    public zzol j6(Context context, com.google.android.gms.internal.zzol.a aVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver com_google_android_gms_internal_zzol = new zzol(aVar);
        context.registerReceiver(com_google_android_gms_internal_zzol, intentFilter);
        com_google_android_gms_internal_zzol.j6(context);
        if (j6(context, "com.google.android.gms")) {
            return com_google_android_gms_internal_zzol;
        }
        aVar.j6();
        com_google_android_gms_internal_zzol.j6();
        return null;
    }

    public void j6(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent j6 = j6(context, connectionResult);
        if (j6 != null) {
            d.j6(connectionResult.FH(), context, GoogleApiActivity.j6(context, j6, i));
        }
    }

    public final boolean j6(int i) {
        return super.j6(i);
    }

    public boolean j6(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return d.j6(i, activity, i2, onCancelListener);
    }

    public boolean j6(Activity activity, gy gyVar, int i, int i2, OnCancelListener onCancelListener) {
        Dialog j6 = d.j6(i, activity, p.j6(gyVar, j6((Context) activity, i, "d"), i2), onCancelListener);
        if (j6 == null) {
            return false;
        }
        d.j6(activity, onCancelListener, "GooglePlayServicesErrorDialog", j6);
        return true;
    }
}
