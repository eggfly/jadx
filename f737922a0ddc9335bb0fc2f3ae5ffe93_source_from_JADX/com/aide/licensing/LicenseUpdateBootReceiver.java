package com.aide.licensing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io;

public class LicenseUpdateBootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        io.j6("Boot broadcast received.");
        LicenseUpdateAlarmReceiver.DW(context);
    }
}
