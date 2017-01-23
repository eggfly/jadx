package com.miui.support.internal.log.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.List;

public class DynamicDumpReceiver extends DumpReceiver {
    private static final Object f2536a;
    private static volatile boolean f2537b;
    private static boolean f2538c;

    static {
        f2536a = new Object();
    }

    public void onReceive(Context context, Intent intent) {
        if (!f2538c) {
            if (m4209b(context)) {
                Log.i("DynamicDumpReceiver", "Dynamic receiver removed");
                context.unregisterReceiver(this);
                return;
            }
            f2538c = true;
        }
        super.onReceive(context, intent);
    }

    public boolean m4210a(Context context) {
        if (!f2537b) {
            synchronized (f2536a) {
                if (f2537b) {
                } else {
                    context.registerReceiver(this, new IntentFilter("com.miui.core.intent.ACTION_DUMP_CACHED_LOG"));
                    f2537b = true;
                    Log.i("DynamicDumpReceiver", "Dynamic receiver registered");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean m4209b(Context context) {
        Intent intent = new Intent("com.miui.core.intent.ACTION_DUMP_CACHED_LOG");
        intent.setPackage(context.getPackageName());
        List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
            return false;
        }
        return true;
    }
}
