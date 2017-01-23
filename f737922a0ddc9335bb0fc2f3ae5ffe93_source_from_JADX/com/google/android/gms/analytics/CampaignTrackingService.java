package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.v;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.hy;

public class CampaignTrackingService extends Service {
    private static Boolean DW;
    private Handler j6;

    class 1 implements Runnable {
        final /* synthetic */ Handler DW;
        final /* synthetic */ int FH;
        final /* synthetic */ CampaignTrackingService Hw;
        final /* synthetic */ g j6;

        1(CampaignTrackingService campaignTrackingService, g gVar, Handler handler, int i) {
            this.Hw = campaignTrackingService;
            this.j6 = gVar;
            this.DW = handler;
            this.FH = i;
        }

        public void run() {
            this.Hw.j6(this.j6, this.DW, this.FH);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ Handler DW;
        final /* synthetic */ int FH;
        final /* synthetic */ CampaignTrackingService Hw;
        final /* synthetic */ g j6;

        2(CampaignTrackingService campaignTrackingService, g gVar, Handler handler, int i) {
            this.Hw = campaignTrackingService;
            this.j6 = gVar;
            this.DW = handler;
            this.FH = i;
        }

        public void run() {
            this.Hw.j6(this.j6, this.DW, this.FH);
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ g DW;
        final /* synthetic */ CampaignTrackingService FH;
        final /* synthetic */ int j6;

        3(CampaignTrackingService campaignTrackingService, int i, g gVar) {
            this.FH = campaignTrackingService;
            this.j6 = i;
            this.DW = gVar;
        }

        public void run() {
            boolean stopSelfResult = this.FH.stopSelfResult(this.j6);
            if (stopSelfResult) {
                this.DW.j6("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
            }
        }
    }

    private Handler DW() {
        Handler handler = this.j6;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.j6 = handler;
        return handler;
    }

    private void j6() {
        try {
            synchronized (CampaignTrackingReceiver.j6) {
                hy hyVar = CampaignTrackingReceiver.DW;
                if (hyVar != null && hyVar.DW()) {
                    hyVar.j6();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean j6(Context context) {
        b.j6((Object) context);
        if (DW != null) {
            return DW.booleanValue();
        }
        boolean j6 = p.j6(context, "com.google.android.gms.analytics.CampaignTrackingService");
        DW = Boolean.valueOf(j6);
        return j6;
    }

    protected void j6(g gVar, Handler handler, int i) {
        handler.post(new 3(this, i, gVar));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        v.j6((Context) this).Zo().DW("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        v.j6((Context) this).Zo().DW("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        j6();
        v j6 = v.j6((Context) this);
        g Zo = j6.Zo();
        String str = null;
        if (j6.v5().j6()) {
            Zo.Zo("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler DW = DW();
        if (TextUtils.isEmpty(str)) {
            if (!j6.v5().j6()) {
                Zo.v5("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            j6.gn().j6(new 1(this, Zo, DW, i2));
        } else {
            int v5 = j6.v5().v5();
            if (str.length() > v5) {
                Zo.FH("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(v5));
                str = str.substring(0, v5);
            }
            Zo.j6("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            j6.u7().j6(str, new 2(this, Zo, DW, i2));
        }
        return 2;
    }
}
