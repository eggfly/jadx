package android.support.v4.graphics;

import android.os.Build.VERSION;

public class BitmapCompat {
    static final BitmapImpl f449a;

    interface BitmapImpl {
    }

    static class BaseBitmapImpl implements BitmapImpl {
        BaseBitmapImpl() {
        }
    }

    static class HcMr1BitmapCompatImpl extends BaseBitmapImpl {
        HcMr1BitmapCompatImpl() {
        }
    }

    static class JbMr2BitmapCompatImpl extends HcMr1BitmapCompatImpl {
        JbMr2BitmapCompatImpl() {
        }
    }

    static class KitKatBitmapCompatImpl extends JbMr2BitmapCompatImpl {
        KitKatBitmapCompatImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 19) {
            f449a = new KitKatBitmapCompatImpl();
        } else if (i >= 18) {
            f449a = new JbMr2BitmapCompatImpl();
        } else if (i >= 12) {
            f449a = new HcMr1BitmapCompatImpl();
        } else {
            f449a = new BaseBitmapImpl();
        }
    }
}
