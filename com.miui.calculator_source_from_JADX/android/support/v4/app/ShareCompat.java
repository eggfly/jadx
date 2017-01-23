package android.support.v4.app;

import android.os.Build.VERSION;

public class ShareCompat {
    private static ShareCompatImpl f377a;

    public static class IntentBuilder {
    }

    public static class IntentReader {
    }

    interface ShareCompatImpl {
    }

    static class ShareCompatImplBase implements ShareCompatImpl {
        ShareCompatImplBase() {
        }
    }

    static class ShareCompatImplICS extends ShareCompatImplBase {
        ShareCompatImplICS() {
        }
    }

    static class ShareCompatImplJB extends ShareCompatImplICS {
        ShareCompatImplJB() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f377a = new ShareCompatImplJB();
        } else if (VERSION.SDK_INT >= 14) {
            f377a = new ShareCompatImplICS();
        } else {
            f377a = new ShareCompatImplBase();
        }
    }
}
