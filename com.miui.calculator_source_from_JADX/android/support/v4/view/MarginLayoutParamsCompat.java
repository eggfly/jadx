package android.support.v4.view;

import android.os.Build.VERSION;

public class MarginLayoutParamsCompat {
    static final MarginLayoutParamsCompatImpl f776a;

    interface MarginLayoutParamsCompatImpl {
    }

    static class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplBase() {
        }
    }

    static class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompatImpl {
        MarginLayoutParamsCompatImplJbMr1() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f776a = new MarginLayoutParamsCompatImplJbMr1();
        } else {
            f776a = new MarginLayoutParamsCompatImplBase();
        }
    }
}
