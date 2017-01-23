package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static int DW;
    private static final SparseArray<WakeLock> j6;

    static {
        j6 = new SparseArray();
        DW = 1;
    }

    public static ComponentName j6(Context context, Intent intent) {
        synchronized (j6) {
            int i = DW;
            DW++;
            if (DW <= 0) {
                DW = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            j6.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean j6(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (j6) {
            WakeLock wakeLock = (WakeLock) j6.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                j6.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
