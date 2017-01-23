package com.miui.support.util;

import android.app.Application;
import com.miui.support.internal.util.PackageConstants;
import com.miui.support.internal.variable.Android_App_ActivityThread_class.Factory;

public class AppConstants {
    public static Application m4227a() {
        if (PackageConstants.f2564a == null) {
            PackageConstants.f2564a = Factory.getInstance().get().currentApplication();
        }
        return PackageConstants.f2564a;
    }
}
