package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.aide.uidesigner.ProxyTextView;
import java.util.LinkedList;
import java.util.Queue;

public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver {
    private static final Queue<Intent> DW;
    private static final Queue<Intent> j6;

    static {
        j6 = new LinkedList();
        DW = new LinkedList();
    }

    public static Intent DW(Context context, Intent intent) {
        return DW(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    private static Intent DW(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    private static int FH(Context context, Intent intent) {
        Hw(context, intent);
        try {
            ComponentName j6;
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                j6 = WakefulBroadcastReceiver.j6(context, intent);
            } else {
                j6 = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (j6 != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        }
    }

    private static void Hw(Context context, Intent intent) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            return;
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
            String valueOf = String.valueOf(serviceInfo.packageName);
            String valueOf2 = String.valueOf(serviceInfo.name);
            Log.e("FirebaseInstanceId", new StringBuilder((String.valueOf(valueOf).length() + 94) + String.valueOf(valueOf2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(valueOf).append("/").append(valueOf2).toString());
            return;
        }
        valueOf2 = serviceInfo.name;
        if (valueOf2.startsWith(".")) {
            String valueOf3 = String.valueOf(context.getPackageName());
            valueOf2 = String.valueOf(valueOf2);
            valueOf2 = valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3);
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            String str = "Restricting intent to a specific service: ";
            valueOf3 = String.valueOf(valueOf2);
            Log.d(valueOf, valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str));
        }
        intent.setClassName(context.getPackageName(), valueOf2);
    }

    static int j6(Context context, String str, Intent intent) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    obj = null;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case ProxyTextView.TYPEFACE_NORMAL /*0*/:
                j6.offer(intent);
                break;
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                DW.offer(intent);
                break;
            default:
                String str2 = "FirebaseInstanceId";
                String str3 = "Unknown service action: ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return FH(context, intent2);
    }

    public static Intent j6() {
        return (Intent) j6.poll();
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = (Intent) intent.getParcelableExtra("wrapped_intent");
            if (intent2 == null) {
                Log.w("FirebaseInstanceId", "Missing wrapped intent");
            } else {
                j6(context, intent.getAction(), intent2);
            }
        }
    }
}
