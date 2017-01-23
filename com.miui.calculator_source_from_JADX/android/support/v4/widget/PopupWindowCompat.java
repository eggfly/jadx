package android.support.v4.widget;

import android.os.Build.VERSION;

public class PopupWindowCompat {
    static final PopupWindowImpl f1162a;

    interface PopupWindowImpl {
    }

    static class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }
    }

    static class GingerbreadPopupWindowImpl extends BasePopupWindowImpl {
        GingerbreadPopupWindowImpl() {
        }
    }

    static class KitKatPopupWindowImpl extends GingerbreadPopupWindowImpl {
        KitKatPopupWindowImpl() {
        }
    }

    static class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
        Api21PopupWindowImpl() {
        }
    }

    static class Api23PopupWindowImpl extends Api21PopupWindowImpl {
        Api23PopupWindowImpl() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1162a = new Api23PopupWindowImpl();
        } else if (i >= 21) {
            f1162a = new Api21PopupWindowImpl();
        } else if (i >= 19) {
            f1162a = new KitKatPopupWindowImpl();
        } else if (i >= 9) {
            f1162a = new GingerbreadPopupWindowImpl();
        } else {
            f1162a = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
    }
}
