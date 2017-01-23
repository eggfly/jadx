package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.v;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static hy DW;
    static Boolean FH;
    static Object j6;

    static {
        j6 = new Object();
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (FH != null) {
            return FH.booleanValue();
        }
        boolean j6 = p.j6(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        FH = Boolean.valueOf(j6);
        return j6;
    }

    protected Class<? extends CampaignTrackingService> j6() {
        return CampaignTrackingService.class;
    }

    protected void j6(Context context, String str) {
    }

    public void onReceive(Context context, Intent intent) {
        v j6 = v.j6(context);
        g Zo = j6.Zo();
        if (intent == null) {
            Zo.v5("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        Zo.j6("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            Zo.v5("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean j62 = CampaignTrackingService.j6(context);
        if (!j62) {
            Zo.v5("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        j6(context, stringExtra);
        if (j6.v5().j6()) {
            Zo.Zo("Received unexpected installation campaign on package side");
            return;
        }
        Object j63 = j6();
        b.j6(j63);
        Intent intent2 = new Intent(context, j63);
        intent2.putExtra("referrer", stringExtra);
        synchronized (j6) {
            context.startService(intent2);
            if (j62) {
                try {
                    if (DW == null) {
                        DW = new hy(context, 1, "Analytics campaign WakeLock");
                        DW.j6(false);
                    }
                    DW.j6(1000);
                } catch (SecurityException e) {
                    Zo.v5("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }
}
