package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl f832a;

    interface ViewConfigurationVersionImpl {
        int m1508a(ViewConfiguration viewConfiguration);
    }

    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        public int m1509a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }
    }

    static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        public int m1510a(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatFroyo.m1512a(viewConfiguration);
        }
    }

    static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }
    }

    static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f832a = new IcsViewConfigurationVersionImpl();
        } else if (VERSION.SDK_INT >= 11) {
            f832a = new HoneycombViewConfigurationVersionImpl();
        } else if (VERSION.SDK_INT >= 8) {
            f832a = new FroyoViewConfigurationVersionImpl();
        } else {
            f832a = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int m1511a(ViewConfiguration viewConfiguration) {
        return f832a.m1508a(viewConfiguration);
    }
}
