package com.cmcm.p074a.p075a.p112a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;

/* renamed from: com.cmcm.a.a.a.g */
class C2113g implements Runnable {
    final /* synthetic */ C2112f f7429a;

    C2113g(C2112f c2112f) {
        this.f7429a = c2112f;
    }

    public void run() {
        try {
            String packageName = ((RunningTaskInfo) ((ActivityManager) C2126s.m8041c().getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
            if (this.f7429a.f7427d == null) {
                this.f7429a.f7427d = packageName;
                this.f7429a.f7428e.m7954a(null, packageName);
            } else if (!this.f7429a.f7427d.equals(packageName)) {
                this.f7429a.f7428e.m7954a(this.f7429a.f7427d, packageName);
                this.f7429a.f7427d = packageName;
            }
        } catch (Throwable th) {
            this.f7429a.m7959a();
        }
    }
}
