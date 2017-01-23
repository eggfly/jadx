package com.miui.support.internal.variable;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public class VariableExceptionHandler {
    private static final String TAG = "ExceptionHandler";

    private static class Holder {
        static final VariableExceptionHandler INSTANCE;

        private Holder() {
        }

        static {
            INSTANCE = new VariableExceptionHandler();
        }
    }

    public static VariableExceptionHandler getInstance() {
        return Holder.INSTANCE;
    }

    public void onThrow(String str, Throwable th) {
        String str2;
        if (th instanceof InvocationTargetException) {
            th = th.getCause();
        }
        Log.e(TAG, "Something thrown - " + str, th);
        if (str == null || str.length() == 0) {
            str2 = "Something thrown when using version/device dependent code";
        } else {
            str2 = "Something thrown when using version/device dependent code - " + str;
        }
        throw new RuntimeException(str2 + " - " + th.getMessage(), th);
    }
}
