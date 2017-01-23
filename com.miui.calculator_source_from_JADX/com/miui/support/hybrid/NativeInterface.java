package com.miui.support.hybrid;

import android.app.Activity;
import com.miui.support.internal.hybrid.HybridManager;

public class NativeInterface {
    private HybridManager f2063a;

    public NativeInterface(HybridManager hybridManager) {
        this.f2063a = hybridManager;
    }

    public Activity m3544a() {
        return this.f2063a.m4044b();
    }

    public void m3545a(LifecycleListener lifecycleListener) {
        this.f2063a.m4040a(lifecycleListener);
    }

    public void m3546b(LifecycleListener lifecycleListener) {
        this.f2063a.m4045b(lifecycleListener);
    }
}
