package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f447a;
    private static int f448b;

    static {
        f447a = new SparseArray();
        f448b = 1;
    }
}
