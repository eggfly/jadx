package com.appfour.common.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        WakefulBroadcastReceiver.j6(context, intent.setComponent(new ComponentName(context.getPackageName(), GcmIntentService.class.getName())));
        setResultCode(-1);
    }
}
