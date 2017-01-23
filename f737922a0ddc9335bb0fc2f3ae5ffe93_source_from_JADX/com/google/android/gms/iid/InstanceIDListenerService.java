package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class InstanceIDListenerService extends Service {
    private static String VH;
    private static String Zo;
    private static String gn;
    static String j6;
    MessengerCompat DW;
    BroadcastReceiver FH;
    int Hw;
    int v5;

    class 1 extends Handler {
        final /* synthetic */ InstanceIDListenerService j6;

        1(InstanceIDListenerService instanceIDListenerService, Looper looper) {
            this.j6 = instanceIDListenerService;
            super(looper);
        }

        public void handleMessage(Message message) {
            this.j6.j6(message, MessengerCompat.j6(message));
        }
    }

    class 2 extends BroadcastReceiver {
        final /* synthetic */ InstanceIDListenerService j6;

        2(InstanceIDListenerService instanceIDListenerService) {
            this.j6 = instanceIDListenerService;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 46).append("Received GSF callback using dynamic receiver: ").append(valueOf).toString());
            }
            this.j6.j6(intent);
            this.j6.j6();
        }
    }

    static {
        j6 = "action";
        Zo = "google.com/iid";
        VH = "CMD";
        gn = "gcm.googleapis.com/refresh";
    }

    public InstanceIDListenerService() {
        this.DW = new MessengerCompat(new 1(this, Looper.getMainLooper()));
        this.FH = new 2(this);
    }

    static void j6(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(VH, "SYNC");
        context.startService(intent);
    }

    static void j6(Context context, zzd com_google_android_gms_iid_zzd) {
        com_google_android_gms_iid_zzd.DW();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(VH, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void j6(Message message, int i) {
        zzc.j6((Context) this);
        getPackageManager();
        if (i == zzc.FH || i == zzc.DW) {
            j6((Intent) message.obj);
            return;
        }
        int i2 = zzc.DW;
        Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + i2 + " appid=" + zzc.FH);
    }

    public void DW() {
    }

    void j6() {
        synchronized (this) {
            this.Hw--;
            if (this.Hw == 0) {
                stopSelf(this.v5);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                int i = this.Hw;
                Log.d("InstanceID", "Stop " + i + " " + this.v5);
            }
        }
    }

    void j6(int i) {
        synchronized (this) {
            this.Hw++;
            if (i > this.v5) {
                this.v5 = i;
            }
        }
    }

    public void j6(Intent intent) {
        a FH;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            FH = a.FH(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            FH = a.j6(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(VH);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID", new StringBuilder(((String.valueOf(stringExtra).length() + 18) + String.valueOf(stringExtra2).length()) + String.valueOf(valueOf).length()).append("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(valueOf).toString());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd FH2 = FH.FH();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                FH2.v5(stringExtra);
                FH.Hw().Hw(intent);
                return;
            } else if (gn.equals(intent.getStringExtra("from"))) {
                FH.FH().v5(stringExtra);
                j6(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                FH.DW();
                j6(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!FH.FH().j6()) {
                    FH.FH().DW();
                    j6(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                FH.FH().v5(stringExtra);
                j6(false);
                return;
            } else if (!"PING".equals(stringExtra2)) {
                return;
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            stringExtra2 = "InstanceID";
            String str = "Register result in service ";
            stringExtra = String.valueOf(stringExtra);
            Log.d(stringExtra2, stringExtra.length() != 0 ? str.concat(stringExtra) : new String(str));
        }
        FH.Hw().Hw(intent);
    }

    public void j6(boolean z) {
        DW();
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.DW.j6();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.FH, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.FH);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        j6(i2);
        if (intent == null) {
            j6();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                j6(intent);
            }
            j6();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.j6(intent);
            }
            return 2;
        } finally {
            j6();
        }
    }
}
