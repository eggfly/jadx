import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class afu {
    private static long DW;
    private static float FH;
    private static IntentFilter j6;

    static {
        j6 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        FH = Float.NaN;
    }

    public static synchronized float DW(Context context) {
        float f;
        synchronized (afu.class) {
            if (SystemClock.elapsedRealtime() - DW >= 60000 || Float.isNaN(FH)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, j6);
                if (registerReceiver != null) {
                    FH = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                DW = SystemClock.elapsedRealtime();
                f = FH;
            } else {
                f = FH;
            }
        }
        return f;
    }

    @TargetApi(20)
    public static int j6(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, j6);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (j6(powerManager) ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    @TargetApi(20)
    public static boolean j6(PowerManager powerManager) {
        return agb.gn() ? powerManager.isInteractive() : powerManager.isScreenOn();
    }
}
