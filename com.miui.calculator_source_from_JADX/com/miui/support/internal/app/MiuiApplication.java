package com.miui.support.internal.app;

import android.app.Application;
import com.miui.support.core.SdkManager;

public class MiuiApplication extends Application {
    public MiuiApplication() {
        SdkManager.initialize(this, null);
    }

    public void onCreate() {
        super.onCreate();
        SdkManager.start(null);
    }
}
