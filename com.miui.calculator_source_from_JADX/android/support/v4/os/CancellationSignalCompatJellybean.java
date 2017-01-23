package android.support.v4.os;

import android.os.CancellationSignal;

class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static Object m1005a() {
        return new CancellationSignal();
    }

    public static void m1006a(Object obj) {
        ((CancellationSignal) obj).cancel();
    }
}
