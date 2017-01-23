package android.support.v4.widget;

import android.os.Build.VERSION;

public final class CompoundButtonCompat {
    private static final CompoundButtonCompatImpl f1004a;

    interface CompoundButtonCompatImpl {
    }

    static class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
        }
    }

    static class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
        }
    }

    static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1004a = new Api23CompoundButtonImpl();
        } else if (i >= 21) {
            f1004a = new LollipopCompoundButtonImpl();
        } else {
            f1004a = new BaseCompoundButtonCompat();
        }
    }

    private CompoundButtonCompat() {
    }
}
