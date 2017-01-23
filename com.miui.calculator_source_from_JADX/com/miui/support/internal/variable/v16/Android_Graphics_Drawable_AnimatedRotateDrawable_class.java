package com.miui.support.internal.variable.v16;

import android.graphics.drawable.Drawable;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class.Factory;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_Graphics_Drawable_AnimatedRotateDrawable_class extends com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class {
    private static final Class<?> CLASS;
    private static final Method setFramesCount;
    private static final Method setFramesDuration;
    private static final Method start;
    private static final Method stop;

    static {
        Class cls = null;
        try {
            cls = Class.forName(com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow(com.miui.support.internal.variable.Android_Graphics_Drawable_AnimatedRotateDrawable_class.NAME, e);
        }
        CLASS = cls;
        setFramesCount = Method.of(CLASS, "setFramesCount", "(I)V");
        setFramesDuration = Method.of(CLASS, "setFramesDuration", "(I)V");
        start = Method.of(CLASS, "start", "()V");
        stop = Method.of(CLASS, "stop", "()V");
    }

    public void setFramesCount(Drawable drawable, int i) {
        try {
            setFramesCount.invoke(null, drawable, Integer.valueOf(i));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.AnimatedRotateDrawable.setFramesCount", e);
        }
    }

    public void setFramesDuration(Drawable drawable, int i) {
        try {
            setFramesDuration.invoke(null, drawable, Integer.valueOf(i));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.AnimatedRotateDrawable.setFramesDuration", e);
        }
    }

    public void start(Drawable drawable) {
        try {
            start.invoke(null, drawable, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.AnimatedRotateDrawable.start", e);
        }
    }

    public void stop(Drawable drawable) {
        try {
            stop.invoke(null, drawable, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.graphics.drawable.AnimatedRotateDrawable.stop", e);
        }
    }

    public int getLayoutDirection(Drawable drawable) {
        return Factory.getInstance().get().getLayoutDirection(drawable);
    }
}
