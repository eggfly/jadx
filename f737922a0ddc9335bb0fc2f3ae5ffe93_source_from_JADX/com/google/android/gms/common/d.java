package com.google.android.gms.common;

import aeq$b;
import aeq$c;
import aft;
import agb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.TypedValue;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.p;

public final class d extends k {
    @Deprecated
    public static final int j6;

    static {
        j6 = k.DW;
    }

    @Deprecated
    public static int j6(Context context) {
        return k.DW(context);
    }

    @TargetApi(14)
    public static Dialog j6(int i, Activity activity, p pVar, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (aft.j6((Context) activity) && i == 2) {
            i = 42;
        }
        if (j6(activity, i)) {
            i = 18;
        }
        if (agb.FH()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(o.j6(activity, i, k.Zo(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence FH = o.FH(activity, i);
        if (FH != null) {
            builder.setPositiveButton(FH, pVar);
        }
        FH = o.j6(activity, i);
        if (FH != null) {
            builder.setTitle(FH);
        }
        return builder.create();
    }

    static void j6(int i, Context context, PendingIntent pendingIntent) {
        j6(i, context, null, pendingIntent);
    }

    @TargetApi(20)
    private static void j6(int i, Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        int i2;
        Resources resources = context.getResources();
        String Zo = k.Zo(context);
        CharSequence DW = o.DW(context, i);
        if (DW == null) {
            DW = resources.getString(aeq$c.common_google_play_services_notification_ticker);
        }
        CharSequence DW2 = o.DW(context, i, Zo);
        if (aft.j6(context)) {
            b.j6(agb.Hw());
            build = new Notification.Builder(context).setSmallIcon(aeq$b.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(new StringBuilder((String.valueOf(DW).length() + 1) + String.valueOf(DW2).length()).append(DW).append(" ").append(DW2).toString())).addAction(aeq$b.common_full_open_on_phone, resources.getString(aeq$c.common_open_on_phone), pendingIntent).build();
        } else {
            CharSequence string = resources.getString(aeq$c.common_google_play_services_notification_ticker);
            if (agb.j6()) {
                Notification build2;
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(DW).setContentText(DW2).setContentIntent(pendingIntent).setTicker(string).setAutoCancel(true);
                if (agb.gn()) {
                    autoCancel.setLocalOnly(true);
                }
                if (agb.Hw()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(DW2));
                    build2 = autoCancel.build();
                } else {
                    build2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    build2.extras.putBoolean("android.support.localOnly", true);
                }
                build = build2;
            } else {
                build = new NotificationCompat.Builder(context).j6(17301642).FH(string).j6(System.currentTimeMillis()).j6(true).j6(pendingIntent).j6(DW).DW(DW2).j6();
            }
        }
        if (k.j6(i)) {
            Zo.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    @TargetApi(11)
    public static void j6(Activity activity, OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            e.j6(dialog, onCancelListener).j6(((FragmentActivity) activity).Zo(), str);
        } else if (agb.j6()) {
            ErrorDialogFragment.j6(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    @Deprecated
    public static boolean j6(int i, Activity activity, int i2, OnCancelListener onCancelListener) {
        return j6(i, activity, null, i2, onCancelListener);
    }

    public static boolean j6(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Intent j6 = a.j6().j6((Context) activity, i, "d");
        Dialog j62 = j6(i, activity, fragment == null ? p.j6(activity, j6, i2) : p.j6(fragment, j6, i2), onCancelListener);
        if (j62 == null) {
            return false;
        }
        j6(activity, onCancelListener, "GooglePlayServicesErrorDialog", j62);
        return true;
    }

    @Deprecated
    public static boolean j6(Context context, int i) {
        return k.FH(context, i);
    }
}
