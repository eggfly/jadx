package com.antutu.benchmark.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.antutu.benchmark.service.BenchmarkMainService;
import com.antutu.utils.MLog;
import com.igexin.sdk.PushConsts;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class KeepAliveReceiver extends BroadcastReceiver {
    private static final String f5598a;
    private static volatile KeepAliveReceiver f5599b;

    static {
        f5598a = KeepAliveReceiver.class.getSimpleName();
        f5599b = null;
    }

    public KeepAliveReceiver(Context context) {
        m6314d(context);
        m6315b(context);
    }

    public static KeepAliveReceiver m6313a(Context context) {
        if (f5599b == null) {
            synchronized (KeepAliveReceiver.class) {
                if (f5599b == null) {
                    f5599b = new KeepAliveReceiver(context);
                }
            }
        }
        return f5599b;
    }

    private void m6314d(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(Integer.MAX_VALUE);
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_TO_BOOT);
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        context.getApplicationContext().registerReceiver(this, intentFilter);
    }

    public void m6315b(Context context) {
        PendingIntent service = PendingIntent.getService(context, 69, BenchmarkMainService.m6350b(context), 134217728);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM);
        if (VERSION.SDK_INT >= 19) {
            alarmManager.cancel(service);
            alarmManager.setExact(0, System.currentTimeMillis() + 600000, service);
            return;
        }
        alarmManager.cancel(service);
        alarmManager.setRepeating(0, System.currentTimeMillis() + 600000, 600000, service);
    }

    public void m6316c(Context context) {
        context.getApplicationContext().unregisterReceiver(this);
        if (f5599b != null) {
            f5599b = null;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            MLog.m6871i(f5598a, " " + intent.getAction());
            String action = intent.getAction();
            int i = -1;
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        i = 3;
                        break;
                    }
                    break;
                case -1538406691:
                    if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                        i = 5;
                        break;
                    }
                    break;
                case -1172645946:
                    if (action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                        i = 4;
                        break;
                    }
                    break;
                case 798292259:
                    if (action.equals(PushConsts.ACTION_BROADCAST_TO_BOOT)) {
                        i = 1;
                        break;
                    }
                    break;
                case 823795052:
                    if (action.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                        i = 0;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                    MLog.m6871i(f5598a, "user present");
                    context.startService(BenchmarkMainService.m6362g(context));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                    MLog.m6871i(f5598a, "boot completed");
                    context.startService(BenchmarkMainService.m6364h(context));
                    break;
                case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                    MLog.m6871i(f5598a, "power connected");
                    context.startService(BenchmarkMainService.m6365i(context));
                    break;
                case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                    MLog.m6871i(f5598a, "power disconnected");
                    context.startService(BenchmarkMainService.m6366j(context));
                    break;
                case SpdyProtocol.QUIC /*4*/:
                    context.startService(BenchmarkMainService.m6360f(context));
                    MLog.m6871i(f5598a, "net connectivity");
                    break;
                case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                    Intent k = BenchmarkMainService.m6367k(context);
                    k.putExtra("temperature", intent.getIntExtra("temperature", 0));
                    k.putExtra("level", intent.getIntExtra("level", 0));
                    k.putExtra("scale", intent.getIntExtra("scale", 0));
                    k.putExtra("health", intent.getIntExtra("health", 2));
                    context.startService(k);
                    MLog.m6871i(f5598a, "Battery Changed");
                    break;
            }
            m6315b(context);
        }
    }
}
