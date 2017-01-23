package com.aide.licensing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import io;

public class LicenseUpdateService extends Service {
    private a j6;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        io.j6("License Update service: onStartCommand");
        this.j6 = new a();
        this.j6.j6((Context) this, true);
        this.j6.FH();
        return 1;
    }

    public void onDestroy() {
        io.j6("License Update service: onDestroy");
        this.j6.j6();
        this.j6 = null;
    }
}
