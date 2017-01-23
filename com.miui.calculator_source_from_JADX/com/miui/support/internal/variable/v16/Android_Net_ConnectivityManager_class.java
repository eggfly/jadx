package com.miui.support.internal.variable.v16;

import android.net.ConnectivityManager;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Method;

public class Android_Net_ConnectivityManager_class implements com.miui.support.internal.variable.Android_Net_ConnectivityManager_class {
    private static final Method isNetworkSupported;

    static {
        isNetworkSupported = Method.of(ConnectivityManager.class, "isNetworkSupported", "(I)Z");
    }

    public boolean isNetworkSupported(ConnectivityManager connectivityManager, int i) {
        boolean z = false;
        try {
            z = isNetworkSupported.invokeBoolean(null, connectivityManager, Integer.valueOf(i));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.os.Process.getTotalMemory", e);
        }
        return z;
    }
}
