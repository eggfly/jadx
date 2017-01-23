package com.miui.support.internal.variable.hook.v19;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;

public class Android_View_ViewGroup_class extends com.miui.support.internal.variable.hook.v16.Android_View_ViewGroup_class {
    protected static final int LAYOUT_MODE_UNDEFINED;
    protected static final int R_styleable_ViewGroup_layoutMode;
    protected static final Method setLayoutMode;

    static {
        R_styleable_ViewGroup_layoutMode = Field.of(com_android_internal_R_styleable, "ViewGroup_layoutMode", Field.INT_SIGNATURE_PRIMITIVE).getInt(null);
        LAYOUT_MODE_UNDEFINED = Field.of(ViewGroup.class, "LAYOUT_MODE_UNDEFINED", Field.INT_SIGNATURE_PRIMITIVE).getInt(null);
        setLayoutMode = Method.of(ViewGroup.class, "setLayoutMode", "(I)V");
    }

    protected void processAttribute(ViewGroup viewGroup, int i, TypedArray typedArray, Context context) {
        if (i == R_styleable_ViewGroup_layoutMode) {
            setLayoutMode.invoke(ViewGroup.class, viewGroup, Integer.valueOf(typedArray.getInt(i, LAYOUT_MODE_UNDEFINED)));
            return;
        }
        super.processAttribute(viewGroup, i, typedArray, context);
    }
}
