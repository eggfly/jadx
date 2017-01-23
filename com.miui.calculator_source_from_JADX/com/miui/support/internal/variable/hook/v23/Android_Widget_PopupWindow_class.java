package com.miui.support.internal.variable.hook.v23;

import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.miui.support.internal.variable.Android_Widget_PopupWindow_class.Factory;

public class Android_Widget_PopupWindow_class extends com.miui.support.internal.variable.hook.v21.Android_Widget_PopupWindow_class {
    protected static final com.miui.support.internal.variable.Android_Widget_PopupWindow_class POPUP_WINDOW_CLASS;

    static {
        POPUP_WINDOW_CLASS = Factory.getInstance().get();
    }

    protected void handleInvokePopup(long j, PopupWindow popupWindow, LayoutParams layoutParams) {
        super.handleInvokePopup(j, popupWindow, layoutParams);
        POPUP_WINDOW_CLASS.setFitsSystemWindows(popupWindow);
    }
}
