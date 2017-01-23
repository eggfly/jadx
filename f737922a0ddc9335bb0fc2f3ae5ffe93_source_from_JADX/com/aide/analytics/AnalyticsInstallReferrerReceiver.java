package com.aide.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

public class AnalyticsInstallReferrerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            new CampaignTrackingReceiver().onReceive(context, intent);
        } catch (Throwable th) {
            Log.e("aideanalytics", "Exception while notifying GA install receiver", th);
        }
        String string = intent.getExtras().getString("referrer");
        Log.d("aideanalytics", "Installation broadcast received with refererrer " + string);
        File dir = context.getDir("installreferrerdata", 0);
        if (string != null) {
            File file = new File(dir, "tmp-" + UUID.randomUUID().toString());
            File file2 = new File(dir, UUID.randomUUID().toString());
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.write(string);
                fileWriter.close();
                file.renameTo(file2);
            } catch (Throwable th2) {
                Log.e("aideanalytics", "Writing referrer file failed", th2);
            } catch (Throwable th3) {
                fileWriter.close();
            }
        }
    }
}
