package com.miui.support.internal.variable.v16;

import android.widget.PopupWindow;
import com.miui.support.internal.variable.VariableExceptionHandler;

public class Android_Widget_PopupWindow_class extends com.miui.support.internal.variable.Android_Widget_PopupWindow_class {
    public void setLayoutInScreenEnabled(PopupWindow popupWindow, boolean z) {
        if (setLayoutInScreenEnabled != null) {
            try {
                setLayoutInScreenEnabled.invoke(null, popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                VariableExceptionHandler.getInstance().onThrow("invoke setLayoutInScreenEnabled failed", e);
            }
        }
    }

    public void setLayoutInsetDecor(PopupWindow popupWindow, boolean z) {
        if (setLayoutInsetDecor != null) {
            try {
                setLayoutInsetDecor.invoke(null, popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                VariableExceptionHandler.getInstance().onThrow("invoke setLayoutInsetDecor failed", e);
            }
        }
    }

    public void setFitsSystemWindows(PopupWindow popupWindow) {
    }
}
