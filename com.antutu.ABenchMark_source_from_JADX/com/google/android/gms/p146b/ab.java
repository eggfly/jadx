package com.google.android.gms.p146b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@gb
@TargetApi(14)
/* renamed from: com.google.android.gms.b.ab */
public class ab implements ActivityLifecycleCallbacks {
    private Activity f10207a;
    private Context f10208b;
    private final Object f10209c;

    public ab(Application application, Activity activity) {
        this.f10209c = new Object();
        application.registerActivityLifecycleCallbacks(this);
        m11734a(activity);
        this.f10208b = application.getApplicationContext();
    }

    private void m11734a(Activity activity) {
        synchronized (this.f10209c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f10207a = activity;
            }
        }
    }

    public Activity m11735a() {
        return this.f10207a;
    }

    public Context m11736b() {
        return this.f10208b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.f10209c) {
            if (this.f10207a == null) {
                return;
            }
            if (this.f10207a.equals(activity)) {
                this.f10207a = null;
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        m11734a(activity);
    }

    public void onActivityResumed(Activity activity) {
        m11734a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        m11734a(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
