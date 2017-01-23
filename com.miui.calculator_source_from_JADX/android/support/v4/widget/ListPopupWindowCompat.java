package android.support.v4.widget;

import android.os.Build.VERSION;

public class ListPopupWindowCompat {
    static final ListPopupWindowImpl f1089a;

    interface ListPopupWindowImpl {
    }

    static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        BaseListPopupWindowImpl() {
        }
    }

    static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1089a = new KitKatListPopupWindowImpl();
        } else {
            f1089a = new BaseListPopupWindowImpl();
        }
    }

    private ListPopupWindowCompat() {
    }
}
