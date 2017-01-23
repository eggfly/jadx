package com.miui.support.internal.variable.v16;

import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;

public class Android_Content_SyncStatusInfo_class implements com.miui.support.internal.variable.Android_Content_SyncStatusInfo_class {
    private static final Class<?> CLASS;
    private static final Method GET_LAST_FAILURE_MESG_AS_INT;
    private static final Field INITIALIZE;
    private static final Field LAST_FAILURE_TIME;
    private static final Field LAST_SUCCESS_TIME;
    private static final Field PENDING;

    static {
        Class cls = null;
        try {
            cls = Class.forName(com.miui.support.internal.variable.Android_Content_SyncStatusInfo_class.NAME);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow(com.miui.support.internal.variable.Android_Content_SyncStatusInfo_class.NAME, e);
        }
        CLASS = cls;
        PENDING = Field.of(CLASS, "pending", Field.BOOLEAN_SIGNATURE_PRIMITIVE);
        INITIALIZE = Field.of(CLASS, "initialize", Field.BOOLEAN_SIGNATURE_PRIMITIVE);
        LAST_SUCCESS_TIME = Field.of(CLASS, "lastSuccessTime", Field.LONG_SIGNATURE_PRIMITIVE);
        LAST_FAILURE_TIME = Field.of(CLASS, "lastFailureTime", Field.LONG_SIGNATURE_PRIMITIVE);
        GET_LAST_FAILURE_MESG_AS_INT = Method.of(CLASS, "getLastFailureMesgAsInt", "(I)I");
    }

    public boolean getPending(Object obj) {
        try {
            return PENDING.getBoolean(obj);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.SyncStatusInfo.pending", e);
            return false;
        }
    }

    public boolean getInitialize(Object obj) {
        try {
            return INITIALIZE.getBoolean(obj);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.SyncStatusInfo.initialize", e);
            return false;
        }
    }

    public long getLastSuccessTime(Object obj) {
        try {
            return LAST_SUCCESS_TIME.getLong(obj);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.SyncStatusInfo.lastSuccessTime", e);
            return 0;
        }
    }

    public long getLastFailureTime(Object obj) {
        try {
            return LAST_FAILURE_TIME.getLong(obj);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.SyncStatusInfo.lastFailureTime", e);
            return 0;
        }
    }

    public int getLastFailureMesgAsInt(Object obj, int i) {
        try {
            i = GET_LAST_FAILURE_MESG_AS_INT.invokeInt(null, obj, Integer.valueOf(i));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.content.SyncStatusInfo.getLastFailureMesgAsInt", e);
        }
        return i;
    }
}
