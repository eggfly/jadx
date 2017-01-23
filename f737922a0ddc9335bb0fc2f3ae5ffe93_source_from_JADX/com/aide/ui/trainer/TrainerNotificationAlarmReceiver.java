package com.aide.ui.trainer;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.aide.ui.MainActivity;

public class TrainerNotificationAlarmReceiver extends BroadcastReceiver {
    public static void j6(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, TrainerNotificationAlarmReceiver.class), 134217728));
    }

    public static void j6(Context context, long j, int i, int i2, String str, String str2, String str3) {
        Intent intent = new Intent(context, TrainerNotificationAlarmReceiver.class);
        intent.putExtra("EXTRA_AFTER", j);
        intent.putExtra("EXTRA_REPEAT", i);
        intent.putExtra("EXTRA_MSG", str);
        intent.putExtra("EXTRA_TEXT", str3);
        intent.putExtra("EXTRA_TITLE", str2);
        intent.putExtra("EXTRA_ICON", i2);
        ((AlarmManager) context.getSystemService("alarm")).set(1, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("EXTRA_AFTER", 0);
        int intExtra = intent.getIntExtra("EXTRA_REPEAT", 0);
        String stringExtra = intent.getStringExtra("EXTRA_MSG");
        String stringExtra2 = intent.getStringExtra("EXTRA_TITLE");
        String stringExtra3 = intent.getStringExtra("EXTRA_TEXT");
        int intExtra2 = intent.getIntExtra("EXTRA_ICON", 0);
        int i = intExtra - 1;
        if (i > 0) {
            j6(context, longExtra, i, intExtra2, stringExtra, stringExtra2, stringExtra3);
        }
        j6(context, intExtra2, stringExtra, stringExtra2, stringExtra3);
    }

    private void j6(Context context, int i, String str, String str2, String str3) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        long currentTimeMillis = System.currentTimeMillis();
        notificationManager.notify(654805548, new Builder(context).j6(currentTimeMillis).FH((CharSequence) str).j6(i).j6((CharSequence) str2).DW((CharSequence) str3).j6(MainActivity.DW(context)).j6(true).FH(1).j6());
    }
}
