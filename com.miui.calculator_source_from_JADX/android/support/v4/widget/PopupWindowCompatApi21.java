package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class PopupWindowCompatApi21 {
    private static Field f1163a;

    PopupWindowCompatApi21() {
    }

    static {
        try {
            f1163a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1163a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }
}
