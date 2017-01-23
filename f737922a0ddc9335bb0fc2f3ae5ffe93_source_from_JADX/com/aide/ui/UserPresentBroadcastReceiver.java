package com.aide.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.List;

public class UserPresentBroadcastReceiver extends BroadcastReceiver {
    private static List<i> j6;

    static {
        j6 = new ArrayList();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.USER_PRESENT")) {
            for (i j6 : j6) {
                j6.j6(context);
            }
            j6.clear();
        }
    }

    public static void j6(Context context, i iVar) {
        if (j6(context)) {
            iVar.j6(context);
        } else {
            j6.add(iVar);
        }
    }

    private static boolean j6(Context context) {
        if (VERSION.SDK_INT >= 20) {
            return ((PowerManager) context.getSystemService("power")).isInteractive();
        }
        return ((PowerManager) context.getSystemService("power")).isScreenOn();
    }
}
