package android.support.v4.content;

import android.os.Build.VERSION;

public class IntentCompat {
    private static final IntentCompatImpl f424a;

    interface IntentCompatImpl {
    }

    static class IntentCompatImplBase implements IntentCompatImpl {
        IntentCompatImplBase() {
        }
    }

    static class IntentCompatImplHC extends IntentCompatImplBase {
        IntentCompatImplHC() {
        }
    }

    static class IntentCompatImplIcsMr1 extends IntentCompatImplHC {
        IntentCompatImplIcsMr1() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f424a = new IntentCompatImplIcsMr1();
        } else if (i >= 11) {
            f424a = new IntentCompatImplHC();
        } else {
            f424a = new IntentCompatImplBase();
        }
    }

    private IntentCompat() {
    }
}
