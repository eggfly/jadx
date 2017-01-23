package com.google.firebase.iid;

import agj;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver FH;
    private static final Object Hw;
    private static boolean v5;
    private boolean Zo;

    class 1 extends BroadcastReceiver {
        final /* synthetic */ FirebaseInstanceIdService DW;
        final /* synthetic */ int j6;

        1(FirebaseInstanceIdService firebaseInstanceIdService, int i) {
            this.DW = firebaseInstanceIdService;
            this.j6 = i;
        }

        public void onReceive(Context context, Intent intent) {
            if (FirebaseInstanceIdService.FH(context)) {
                if (this.DW.Zo) {
                    Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                }
                this.DW.getApplicationContext().unregisterReceiver(this);
                context.sendBroadcast(FirebaseInstanceIdService.FH(this.j6));
            }
        }
    }

    static {
        Hw = new Object();
        v5 = false;
    }

    public FirebaseInstanceIdService() {
        this.Zo = false;
    }

    private int DW(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private static Intent FH(int i) {
        Context j6 = agj.Hw().j6();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.DW(j6, intent);
    }

    private static boolean FH(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void Hw(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, FH(i * 2), 268435456));
    }

    private c j6(String str) {
        if (str == null) {
            return c.j6(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return c.j6(this, bundle);
    }

    static void j6(Context context) {
        synchronized (Hw) {
            if (!v5) {
                context.sendBroadcast(FH(0));
                v5 = true;
            }
        }
    }

    static void j6(Context context, FirebaseInstanceId firebaseInstanceId) {
        synchronized (Hw) {
            if (v5) {
                return;
            }
            if (firebaseInstanceId.v5() == null || firebaseInstanceId.VH().j6() != null) {
                j6(context);
            }
        }
    }

    private void j6(Intent intent, String str) {
        boolean FH = FH((Context) this);
        int DW = DW(intent, FH);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(DW).append("s").toString());
        synchronized (Hw) {
            Hw(DW);
            v5 = true;
        }
        if (!FH) {
            if (this.Zo) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (FH == null) {
                FH = new 1(this, DW);
            }
            getApplicationContext().registerReceiver(FH, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j6(android.content.Intent r9, boolean r10) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = Hw;
        monitor-enter(r3);
        r0 = 0;
        v5 = r0;	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r0 = com.google.firebase.iid.FirebaseInstanceId.j6();
        r4 = r0.VH();
        r3 = r0.v5();
        if (r3 != 0) goto L_0x004f;
    L_0x0017:
        r1 = r0.Zo();	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
        if (r1 == 0) goto L_0x0034;
    L_0x001d:
        r1 = r8.Zo;	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
        if (r1 == 0) goto L_0x002a;
    L_0x0021:
        r1 = "FirebaseInstanceId";
        r2 = "get master token succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
    L_0x002a:
        j6(r8, r0);	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
        r8.j6();	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
    L_0x0030:
        return;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        r0 = "returned token is null";
        r8.j6(r9, r0);	 Catch:{ IOException -> 0x003b, SecurityException -> 0x0044 }
        goto L_0x0030;
    L_0x003b:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.j6(r9, r0);
        goto L_0x0030;
    L_0x0044:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0030;
    L_0x004f:
        r0 = r4.j6();
        r3 = r0;
    L_0x0054:
        if (r3 == 0) goto L_0x00c2;
    L_0x0056:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0070;
    L_0x0061:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00a4 }
        switch(r7) {
            case 83: goto L_0x0079;
            case 84: goto L_0x006d;
            case 85: goto L_0x0084;
            default: goto L_0x006d;
        };
    L_0x006d:
        switch(r0) {
            case 0: goto L_0x008f;
            case 1: goto L_0x00ad;
            default: goto L_0x0070;
        };
    L_0x0070:
        r4.j6(r3);
        r0 = r4.j6();
        r3 = r0;
        goto L_0x0054;
    L_0x0079:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a4 }
        if (r5 == 0) goto L_0x006d;
    L_0x0082:
        r0 = r1;
        goto L_0x006d;
    L_0x0084:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a4 }
        if (r5 == 0) goto L_0x006d;
    L_0x008d:
        r0 = r2;
        goto L_0x006d;
    L_0x008f:
        r0 = com.google.firebase.iid.FirebaseInstanceId.j6();	 Catch:{ IOException -> 0x00a4 }
        r0.j6(r6);	 Catch:{ IOException -> 0x00a4 }
        r0 = r8.Zo;	 Catch:{ IOException -> 0x00a4 }
        if (r0 == 0) goto L_0x0070;
    L_0x009a:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a4 }
        goto L_0x0070;
    L_0x00a4:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.j6(r9, r0);
        goto L_0x0030;
    L_0x00ad:
        r0 = com.google.firebase.iid.FirebaseInstanceId.j6();	 Catch:{ IOException -> 0x00a4 }
        r0.DW(r6);	 Catch:{ IOException -> 0x00a4 }
        r0 = r8.Zo;	 Catch:{ IOException -> 0x00a4 }
        if (r0 == 0) goto L_0x0070;
    L_0x00b8:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a4 }
        goto L_0x0070;
    L_0x00c2:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.j6(android.content.Intent, boolean):void");
    }

    private String v5(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void DW(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x000a;
    L_0x0007:
        r0 = "";
    L_0x000a:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x001a;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r2;
    L_0x0013:
        switch(r0) {
            case 0: goto L_0x0025;
            default: goto L_0x0016;
        };
    L_0x0016:
        r4.Hw(r5);
    L_0x0019:
        return;
    L_0x001a:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0012;
    L_0x0023:
        r0 = r1;
        goto L_0x0013;
    L_0x0025:
        r4.j6(r5, r1);
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.DW(android.content.Intent):void");
    }

    protected Intent FH(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.j6();
    }

    public void Hw(Intent intent) {
        String v5 = v5(intent);
        c j6 = j6(v5);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.Zo) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(v5).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(v5).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzg FH = j6.FH();
            if (v5 == null) {
                v5 = "";
            }
            FH.v5(v5);
            j6.Hw().Hw(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            j6.FH().v5(v5);
            j6(intent, false);
        } else if ("RST".equals(stringExtra)) {
            j6.DW();
            j6(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!j6.FH().DW()) {
                j6.FH().FH();
                j6(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            j6.FH().v5(v5);
            j6(intent, false);
        } else if (!"PING".equals(stringExtra)) {
        }
    }

    protected int j6(Intent intent) {
        this.Zo = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.j6(intent);
        }
        String v5 = v5(intent);
        if (this.Zo) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(v5);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        j6(v5).Hw().Hw(intent);
        DW();
        return 2;
    }

    public void j6() {
    }
}
