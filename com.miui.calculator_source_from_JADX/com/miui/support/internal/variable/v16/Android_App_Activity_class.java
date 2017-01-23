package com.miui.support.internal.variable.v16;

import android.app.Activity;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_App_Activity_class extends com.miui.support.internal.variable.Android_App_Activity_class {
    protected static Method convertFromTranslucent;
    protected static Method convertToTranslucent;

    public void convertFromTranslucent(Activity activity) {
        try {
            if (convertFromTranslucent == null) {
                convertFromTranslucent = Method.of(Activity.class, "convertFromTranslucent", "()V");
            }
            convertFromTranslucent.invoke(null, activity, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.Activity.convertFromTranslucent", e);
        }
    }

    public void convertToTranslucent(Activity activity) {
        try {
            if (convertToTranslucent == null) {
                convertToTranslucent = Method.of(Activity.class, "convertToTranslucent", "(Landroid/app/Activity$TranslucentConversionListener;)V");
            }
            convertToTranslucent.invoke(null, activity, null);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.Activity.convertToTranslucent", e);
        }
    }
}
