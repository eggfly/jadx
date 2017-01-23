package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    protected Class<? extends CampaignTrackingService> j6() {
        return InstallReferrerService.class;
    }

    protected void j6(Context context, String str) {
        q.j6(str);
        q.j6(context, str);
    }
}
