package com.antutu.benchmark;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.ModelFields;
import java.net.URLEncoder;

/* renamed from: com.antutu.benchmark.e */
public class C1497e extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(ModelFields.REFERRER);
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) && stringExtra != null) {
            Intent intent2 = new Intent(context, TrackReferrerService.class);
            intent2.putExtra(ModelFields.REFERRER, URLEncoder.encode(stringExtra));
            context.startService(intent2);
        }
    }
}
