package com.miui.support.internal.variable.v16;

import android.view.Window;
import com.miui.support.internal.variable.VariableExceptionHandler;

public class Android_View_Window_class extends com.miui.support.internal.variable.Android_View_Window_class {
    private static final int EXTRA_FLAG_STATUS_BAR_DARK_MODE = 16;
    private static final int EXTRA_FLAG_STATUS_BAR_TRANSPARENT = 1;
    private static final int EXTRA_FLAG_STATUS_BAR_TRANSPARENT_MASK = 17;

    public boolean setTranslucentStatus(Window window, int i) {
        int i2 = EXTRA_FLAG_STATUS_BAR_TRANSPARENT_MASK;
        boolean z = true;
        if (setExtraFlags == null) {
            return false;
        }
        if (i == 0) {
            try {
                setExtraFlags.invoke(null, window, Integer.valueOf(0), Integer.valueOf(EXTRA_FLAG_STATUS_BAR_TRANSPARENT_MASK));
            } catch (Throwable e) {
                VariableExceptionHandler.getInstance().onThrow("clearExtraFlags failed", e);
                z = false;
            }
        } else {
            if (i != EXTRA_FLAG_STATUS_BAR_TRANSPARENT) {
                i2 = EXTRA_FLAG_STATUS_BAR_TRANSPARENT;
            }
            try {
                setExtraFlags.invoke(null, window, Integer.valueOf(i2), Integer.valueOf(EXTRA_FLAG_STATUS_BAR_TRANSPARENT_MASK));
            } catch (Throwable e2) {
                VariableExceptionHandler.getInstance().onThrow("addExtraFlags failed", e2);
                z = false;
            }
        }
        return z;
    }
}
