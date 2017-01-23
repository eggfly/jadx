package com.aide.licensing;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io;

public class LicenseUpdateAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        io.j6("Timer broadcast received.");
        context.startService(new Intent(context, LicenseUpdateService.class));
    }

    public static void j6(Context context) {
        j6(context, 3600000, true);
    }

    public static void DW(Context context) {
        j6(context, 120000, false);
    }

    private static void j6(Context context, int i, boolean z) {
        a aVar = new a();
        aVar.j6(context, true);
        if (aVar.DW()) {
            io.j6("Restarting timer.");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, LicenseUpdateAlarmReceiver.class), 0);
            if (z) {
                alarmManager.setInexactRepeating(0, System.currentTimeMillis() + ((long) i), 3600000, broadcast);
            } else {
                alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), 3600000, broadcast);
            }
        }
    }
}
