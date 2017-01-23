package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@eh
@TargetApi(14)
public class af implements ActivityLifecycleCallbacks {
    private Context DW;
    private final Object FH;
    private Activity j6;

    private void j6(Activity activity) {
        synchronized (this.FH) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.j6 = activity;
            }
        }
    }

    public Context DW() {
        return this.DW;
    }

    public Activity j6() {
        return this.j6;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.FH) {
            if (this.j6 == null) {
                return;
            }
            if (this.j6.equals(activity)) {
                this.j6 = null;
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        j6(activity);
    }

    public void onActivityResumed(Activity activity) {
        j6(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        j6(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
