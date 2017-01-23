package com.miui.support.internal.variable.v16;

import android.os.Process;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_Os_Process_class implements com.miui.support.internal.variable.Android_Os_Process_class {
    private static final Method getFreeMemory;
    private static final Method getTotalMemory;

    static {
        getTotalMemory = Method.of(Process.class, "getTotalMemory", "()J");
        getFreeMemory = Method.of(Process.class, "getFreeMemory", "()J");
    }

    public long getTotalMemory() {
        try {
            return getTotalMemory.invokeLong(null, null, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.os.Process.getTotalMemory", e);
            return 0;
        }
    }

    public long getFreeMemory() {
        try {
            return getFreeMemory.invokeLong(null, null, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.os.Process.getFreeMemory", e);
            return 0;
        }
    }
}
