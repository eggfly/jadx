package com.miui.support.internal.variable.hook.v16;

import android.widget.ListPopupWindow;
import android.widget.Spinner;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;
import com.miui.support.widget.ArrowPopupWindow;

public class Android_Widget_Spinner_class extends com.miui.support.internal.variable.hook.Android_Widget_Spinner_class {
    private static final Field mPopup;
    private static final Field mPopupWindow;

    static {
        mPopup = Field.of(Spinner.class, "mPopup", "Landroid/widget/Spinner$SpinnerPopup;");
        mPopupWindow = Field.of(ListPopupWindow.class, "mPopup", "Landroid/widget/PopupWindow;");
    }

    protected ArrowPopupWindow getArrowPopupWindow(Spinner spinner) {
        try {
            Object obj = mPopup.get(spinner);
            if (obj instanceof ListPopupWindow) {
                obj = mPopupWindow.get(obj);
                if (obj instanceof ArrowPopupWindow) {
                    return (ArrowPopupWindow) obj;
                }
            }
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("mPopup", e);
        }
        return null;
    }
}
