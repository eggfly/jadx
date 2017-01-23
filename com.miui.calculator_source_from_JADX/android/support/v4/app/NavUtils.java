package android.support.v4.app;

import android.os.Build.VERSION;

public class NavUtils {
    private static final NavUtilsImpl f324a;

    interface NavUtilsImpl {
    }

    static class NavUtilsImplBase implements NavUtilsImpl {
        NavUtilsImplBase() {
        }
    }

    static class NavUtilsImplJB extends NavUtilsImplBase {
        NavUtilsImplJB() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f324a = new NavUtilsImplJB();
        } else {
            f324a = new NavUtilsImplBase();
        }
    }

    private NavUtils() {
    }
}
