package com.aide.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.support.multidex.MultiDexApplication;
import com.appfour.common.gcm.b;
import com.appfour.common.gcm.c;
import com.appfour.common.gcm.d;

public class AIDEApplication extends MultiDexApplication {

    class 1 implements c {
        final /* synthetic */ AIDEApplication j6;

        1(AIDEApplication aIDEApplication) {
            this.j6 = aIDEApplication;
        }

        public void j6(d dVar) {
            MainActivity.j6(this.j6, dVar);
        }
    }

    public void onCreate() {
        super.onCreate();
        e.j6(getPackageName());
        if (j6()) {
            b.j6((Context) this, new 1(this));
            if (e.j6.equals("com.aide.ui")) {
                com.aide.ui.marketing.b.j6(this, 43453, R.drawable.ic_launcher, "New version of AIDE installed", "Check out what's new!", MainActivity.Zo((Context) this));
            } else if (e.j6.equals("com.aide.web")) {
                com.aide.ui.marketing.b.j6(this, 43453, R.drawable.ic_launcher_web, "New version of AIDE Web installed", "Check out what's new!", MainActivity.Zo((Context) this));
            }
        }
    }

    private boolean j6() {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return !runningAppProcessInfo.processName.contains(":");
            }
        }
        return true;
    }
}
