package com.miui.support.internal.variable.hook.v21;

import android.content.Context;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.miui.support.internal.C0264R;
import com.miui.support.reflect.Field;
import com.miui.support.util.AttributeResolver;

public class Android_Widget_PopupWindow_class extends com.miui.support.internal.variable.hook.Android_Widget_PopupWindow_class {
    private static final int EXTRA_FLAG_STATUS_BAR_DARK_MODE = 16;
    private static final int FLAG_TRANSLUCENT_STATUS = 67108864;
    private static Field mExtraFlags;

    public void buildProxy() {
        attachMethod("invokePopup", "(Landroid/view/WindowManager$LayoutParams;)V");
        try {
            mExtraFlags = Field.of(LayoutParams.class, "extraFlags", Field.INT_SIGNATURE_PRIMITIVE);
        } catch (Exception e) {
            mExtraFlags = null;
        }
    }

    protected void handle() {
        handleInvokePopup(0, null, null);
    }

    protected void handleInvokePopup(long j, PopupWindow popupWindow, LayoutParams layoutParams) {
        if (layoutParams.x == 0 && layoutParams.y == 0 && layoutParams.width == -1 && layoutParams.height == -1) {
            Context context = popupWindow.getContentView().getContext();
            if (AttributeResolver.m5319a(context, 16843277, false)) {
                layoutParams.flags |= 1024;
            } else if (mExtraFlags != null) {
                layoutParams.flags |= FLAG_TRANSLUCENT_STATUS;
                if (AttributeResolver.m5317a(context, C0264R.attr.windowTranslucentStatus, 1) == 1) {
                    mExtraFlags.set((Object) layoutParams, ((Integer) mExtraFlags.get(layoutParams)).intValue() | EXTRA_FLAG_STATUS_BAR_DARK_MODE);
                }
            }
        }
        originalInvokePopup(j, popupWindow, layoutParams);
    }

    protected void originalInvokePopup(long j, PopupWindow popupWindow, LayoutParams layoutParams) {
        throw new IllegalStateException("com.miui.internal.variable.v21.Android_Widget_PopupWindow_class.originalInvokePopup(long, PopupWindow, WindowManager.LayoutParams)");
    }
}
