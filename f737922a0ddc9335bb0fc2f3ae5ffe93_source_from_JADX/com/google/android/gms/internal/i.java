package com.google.android.gms.internal;

import agj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class i implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final i j6;
    private final AtomicBoolean DW;
    private boolean FH;

    static {
        j6 = new i();
    }

    private i() {
        this.DW = new AtomicBoolean();
    }

    public static void j6(Application application) {
        application.registerActivityLifecycleCallbacks(j6);
        application.registerComponentCallbacks(j6);
        j6.FH = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.DW.compareAndSet(true, false)) {
            agj.j6(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.DW.compareAndSet(true, false)) {
            agj.j6(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.DW.compareAndSet(false, true)) {
            agj.j6(true);
        }
    }
}
