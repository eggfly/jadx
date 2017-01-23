package com.miui.support.internal.variable.v16;

import android.app.Application;
import com.miui.support.internal.variable.VariableExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class Android_App_ActivityThread_class implements com.miui.support.internal.variable.Android_App_ActivityThread_class {
    private Object mCurrentActivityThread;
    private Application mCurrentApplication;
    private Object mInitialLoadedApk;
    private String mInitialPackageName;

    public Android_App_ActivityThread_class() {
        this.mCurrentActivityThread = null;
        this.mCurrentApplication = null;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            this.mCurrentActivityThread = declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.ActivityThread.currentActivityThread", e);
        }
    }

    public Application currentApplication() {
        try {
            if (this.mCurrentApplication == null) {
                Method declaredMethod = this.mCurrentActivityThread.getClass().getDeclaredMethod("currentApplication", new Class[0]);
                declaredMethod.setAccessible(true);
                this.mCurrentApplication = (Application) declaredMethod.invoke(null, new Object[0]);
            }
            return this.mCurrentApplication;
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.ActivityThread.currentApplication", e);
            return null;
        }
    }

    public Object currentActivityThread() {
        return this.mCurrentActivityThread;
    }

    public String getInitialPackageName(Object obj) {
        try {
            if (this.mInitialPackageName == null) {
                Field declaredField = obj.getClass().getDeclaredField("mPackages");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(obj);
                this.mInitialPackageName = (String) map.keySet().iterator().next();
                this.mInitialLoadedApk = ((WeakReference) map.values().iterator().next()).get();
            }
            return this.mInitialPackageName;
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("android.app.ActivityThread.mPackages", e);
            return null;
        }
    }

    public Object getInitialLoadedApk(Object obj) {
        getInitialPackageName(obj);
        return this.mInitialLoadedApk;
    }
}
