package com.igexin.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.igexin.sdk.PushConsts;

public class DownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null && networkInfo.isConnected()) {
                    context.startService(new Intent(context, DownloadService.class));
                }
            } else if (intent.getAction().equals("android.intent.action.GTDOWNLOAD_WAKEUP")) {
                context.startService(new Intent(context, DownloadService.class));
            }
        } catch (Exception e) {
        }
    }
}
