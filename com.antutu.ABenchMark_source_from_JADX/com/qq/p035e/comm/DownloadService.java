package com.qq.p035e.comm;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.qq.p035e.comm.managers.GDTADManager;
import com.qq.p035e.comm.pi.SVSD;
import com.qq.p035e.comm.util.GDTLogger;
import com.qq.p035e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.DownloadService */
public class DownloadService extends Service {
    private SVSD f13443a;

    private boolean m16533a(String str) {
        if (this.f13443a == null) {
            try {
                if (GDTADManager.getInstance().initWith(getApplicationContext(), str)) {
                    this.f13443a = GDTADManager.getInstance().getPM().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f13443a.onCreate();
                } else {
                    GDTLogger.report("Init GDTADManager fail in DownloadService.oncreate");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f13443a != null;
    }

    public IBinder onBind(Intent intent) {
        GDTLogger.m16599d("DownloadService.onBind");
        if (this.f13443a != null) {
            return this.f13443a.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.m16599d("DownloadService.onBind,appID=" + stringExtra);
        return (StringUtil.isEmpty(stringExtra) || !m16533a(stringExtra)) ? null : this.f13443a.onBind(intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f13443a != null) {
            this.f13443a.onConfigurationChanged(configuration);
        }
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        if (this.f13443a != null) {
            this.f13443a.onDestroy();
        }
    }

    public void onLowMemory() {
        if (this.f13443a != null) {
            this.f13443a.onLowMemory();
        }
    }

    public void onRebind(Intent intent) {
        if (this.f13443a != null) {
            this.f13443a.onRebind(intent);
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        if (!StringUtil.isEmpty(stringExtra) && m16533a(stringExtra)) {
            return this.f13443a.onStartCommand(intent, i, i2);
        }
        GDTLogger.m16603w("Failto Start new download Service");
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        if (this.f13443a != null) {
            this.f13443a.onTaskRemoved(intent);
        }
    }

    public void onTrimMemory(int i) {
        if (this.f13443a != null) {
            this.f13443a.onTrimMemory(i);
        }
    }

    public boolean onUnbind(Intent intent) {
        return this.f13443a != null ? this.f13443a.onUnbind(intent) : super.onUnbind(intent);
    }
}
