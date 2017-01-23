package com.miui.support.internal.variable.v23;

import android.view.View;
import android.widget.PopupWindow;
import com.miui.support.internal.C0264R;
import com.miui.support.reflect.Field;
import com.miui.support.util.AttributeResolver;

public class Android_Widget_PopupWindow_class extends com.miui.support.internal.variable.v16.Android_Widget_PopupWindow_class {
    private static final Field mBackgroundViewField;
    private static final Field mDecorViewField;
    private static final Field mLayoutInsetDecorField;

    static {
        mBackgroundViewField = Field.of(PopupWindow.class, "mBackgroundView", "Landroid/view/View;");
        mDecorViewField = Field.of(PopupWindow.class, "mDecorView", "Landroid/widget/PopupWindow$PopupDecorView;");
        mLayoutInsetDecorField = Field.of(PopupWindow.class, "mLayoutInsetDecor", Field.BOOLEAN_SIGNATURE_PRIMITIVE);
    }

    public void setFitsSystemWindows(PopupWindow popupWindow) {
        boolean z = true;
        int a = AttributeResolver.m5317a(popupWindow.getContentView().getContext(), C0264R.attr.windowTranslucentStatus, 1);
        boolean z2 = mLayoutInsetDecorField.getBoolean(popupWindow);
        View view = (View) mBackgroundViewField.get(popupWindow);
        if (a != 0 && z2 && view != null) {
            View view2 = (View) mDecorViewField.get(popupWindow);
            if (z2) {
                z = false;
            }
            view2.setFitsSystemWindows(z);
            view.setFitsSystemWindows(z2);
        }
    }
}
