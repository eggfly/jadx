package com.google.analytics.tracking.android;

import android.app.IntentService;
import android.content.Intent;
import java.io.IOException;
import java.io.OutputStream;

public final class CampaignTrackingService extends IntentService {
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }

    public CampaignTrackingService(String str) {
        super(str);
    }

    protected void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(ModelFields.REFERRER);
        try {
            OutputStream openFileOutput = openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
        } catch (IOException e) {
            Log.m10257e("Error storing install campaign.");
        }
    }
}
