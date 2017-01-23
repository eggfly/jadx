package com.miui.support.external;

import android.util.Log;

class SdkEntranceHelper implements SdkConstants {
    SdkEntranceHelper() {
    }

    public static Class<?> m3446a() {
        Class<?> cls;
        try {
            cls = Class.forName("com.miui.support.core.SdkManager");
        } catch (ClassNotFoundException e) {
            try {
                cls = Class.forName("com.miui.support.internal.core.SdkManager");
                Log.w("miuisdk", "using legacy sdk");
            } catch (ClassNotFoundException e2) {
                Log.e("miuisdk", "no sdk found");
                throw e2;
            }
        }
        return cls;
    }
}
