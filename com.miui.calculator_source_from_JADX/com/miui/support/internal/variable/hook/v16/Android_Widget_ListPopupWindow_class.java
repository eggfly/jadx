package com.miui.support.internal.variable.hook.v16;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.Spinner;
import com.miui.support.C0234R;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;
import com.miui.support.util.AttributeResolver;
import com.miui.support.widget.ArrowPopupWindow;

public class Android_Widget_ListPopupWindow_class extends com.miui.support.internal.variable.hook.Android_Widget_ListPopupWindow_class {
    private static final Field mDropDownHorizontalOffset;
    private static final Field mPopup;

    static {
        mPopup = Field.of(ListPopupWindow.class, "mPopup", "Landroid/widget/PopupWindow;");
        mDropDownHorizontalOffset = Field.of(ListPopupWindow.class, "mDropDownHorizontalOffset", Field.INT_SIGNATURE_PRIMITIVE);
    }

    protected void setPopupWindow(ListPopupWindow listPopupWindow, PopupWindow popupWindow) {
        mPopup.set((Object) listPopupWindow, (Object) popupWindow);
    }

    public void buildProxy() {
        attachConstructor("(Landroid/content/Context;Landroid/util/AttributeSet;II)V");
        attachMethod("show", "()V");
    }

    protected void handle() {
        handle_init_(0, null, null, null, 0, 0);
        handleShow(0, null);
    }

    protected void handle_init_(long j, ListPopupWindow listPopupWindow, Context context, AttributeSet attributeSet, int i, int i2) {
        if (DeviceHelper.f2555g) {
            if (AttributeResolver.m5316a(context, C0234R.attr.windowActionBar) >= 0) {
                if (!AttributeResolver.m5319a(context, C0264R.attr.hidePopupArrow, false)) {
                    original_init_(j, listPopupWindow, context, attributeSet, 0, 0);
                    try {
                        PopupWindow arrowPopupWindow = new ArrowPopupWindow(context, attributeSet, i, i2);
                        arrowPopupWindow.setInputMethodMode(1);
                        setPopupWindow(listPopupWindow, arrowPopupWindow);
                        return;
                    } catch (Throwable e) {
                        VariableExceptionHandler.getInstance().onThrow("ListPopupWindow constructor", e);
                        return;
                    }
                }
            }
        }
        original_init_(j, listPopupWindow, context, attributeSet, i, i2);
    }

    protected void handleShow(long j, ListPopupWindow listPopupWindow) {
        int i = mDropDownHorizontalOffset.getInt(listPopupWindow);
        Object obj = null;
        View anchorView = listPopupWindow.getAnchorView();
        if (!(i == 0 || anchorView == null || !(anchorView instanceof Spinner))) {
            obj = 1;
            mDropDownHorizontalOffset.set((Object) listPopupWindow, i - anchorView.getPaddingLeft());
        }
        originalShow(j, listPopupWindow);
        if (obj != null) {
            mDropDownHorizontalOffset.set((Object) listPopupWindow, i);
        }
    }

    protected void original_init_(long j, ListPopupWindow listPopupWindow, Context context, AttributeSet attributeSet, int i, int i2) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_ListPopupWindow_class.original_init_(long, ListPopupWindow, Context, AttributeSet, int, int)");
    }

    protected void originalShow(long j, ListPopupWindow listPopupWindow) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_Widget_ListPopupWindow_class.originalShow(long, ListPopupWindow)");
    }
}
