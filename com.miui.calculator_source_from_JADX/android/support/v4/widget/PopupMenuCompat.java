package android.support.v4.widget;

import android.os.Build.VERSION;

public class PopupMenuCompat {
    static final PopupMenuImpl f1161a;

    interface PopupMenuImpl {
    }

    static class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }
    }

    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1161a = new KitKatPopupMenuImpl();
        } else {
            f1161a = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }
}
