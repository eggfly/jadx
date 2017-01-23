package com.miui.support.external;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContextWrapper;
import android.content.res.Configuration;

public abstract class ApplicationDelegate extends ContextWrapper implements ComponentCallbacks2 {
    private Application f1296a;

    public ApplicationDelegate() {
        super(null);
    }

    void m2545a(Application application) {
        this.f1296a = application;
        attachBaseContext(application);
    }

    public void m2544a() {
        this.f1296a.m2556c();
    }

    public void m2546b() {
        this.f1296a.m2557d();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f1296a.m2555a(configuration);
    }

    public void onLowMemory() {
        this.f1296a.m2558e();
    }

    public void onTrimMemory(int i) {
        this.f1296a.m2554a(i);
    }

    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f1296a.registerComponentCallbacks(componentCallbacks);
    }

    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.f1296a.unregisterComponentCallbacks(componentCallbacks);
    }
}
