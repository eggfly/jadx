package android.support.v4.app;

import android.os.Build.VERSION;

public class AppOpsManagerCompat {
    private static final AppOpsManagerImpl f57a;

    private static class AppOpsManagerImpl {
        private AppOpsManagerImpl() {
        }
    }

    private static class AppOpsManager23 extends AppOpsManagerImpl {
        private AppOpsManager23() {
            super();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f57a = new AppOpsManager23();
        } else {
            f57a = new AppOpsManagerImpl();
        }
    }
}
