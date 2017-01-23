package com.miui.support.internal.variable.v21;

import android.app.Activity;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_App_Activity_class extends com.miui.support.internal.variable.v16.Android_App_Activity_class {
    private static final Method getActivityOptions;

    static {
        getActivityOptions = Method.of(Activity.class, "getActivityOptions", "()Landroid/app/ActivityOptions;");
    }

    public void convertToTranslucent(Activity activity) {
        try {
            if (convertToTranslucent == null) {
                convertToTranslucent = Method.of(Activity.class, "convertToTranslucent", "(Landroid/app/Activity$TranslucentConversionListener;Landroid/app/ActivityOptions;)Z");
            }
            Object invokeObject = getActivityOptions.invokeObject(null, activity, new Object[0]);
            convertToTranslucent.invoke(null, activity, null, invokeObject);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.Activity.convertToTranslucent", e);
        }
    }
}
