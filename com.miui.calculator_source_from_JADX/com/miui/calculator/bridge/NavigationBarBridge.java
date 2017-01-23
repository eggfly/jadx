package com.miui.calculator.bridge;

import android.app.Activity;
import android.os.Build.VERSION;

public class NavigationBarBridge {
    public static void m2614a(Activity activity, int i) {
        if (VERSION.SDK_INT >= 21) {
            activity.getWindow().setNavigationBarColor(activity.getResources().getColor(i));
        }
    }
}
