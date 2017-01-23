package com.miui.support.internal.variable.v17;

import android.graphics.drawable.Drawable;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_Graphics_Drawable_Drawable_class extends com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class {
    private static final Method getLayoutDirection;

    static {
        getLayoutDirection = Method.of(Drawable.class, "getLayoutDirection", "()I");
    }

    public int getLayoutDirection(Drawable drawable) {
        int i = 0;
        try {
            i = getLayoutDirection.invokeInt(null, drawable, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.Drawable.getLayoutDirection", e);
        }
        return i;
    }
}
