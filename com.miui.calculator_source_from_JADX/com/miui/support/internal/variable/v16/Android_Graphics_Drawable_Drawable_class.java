package com.miui.support.internal.variable.v16;

import android.graphics.drawable.Drawable;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_Graphics_Drawable_Drawable_class extends com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class {
    private static final Method getResolvedLayoutDirectionSelf;

    static {
        getResolvedLayoutDirectionSelf = Method.of(Drawable.class, "getResolvedLayoutDirectionSelf", "()I");
    }

    public int getLayoutDirection(Drawable drawable) {
        int i = 0;
        try {
            i = getResolvedLayoutDirectionSelf.invokeInt(null, drawable, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.Drawable.getResolvedLayoutDirectionSelf", e);
        }
        return i;
    }
}
