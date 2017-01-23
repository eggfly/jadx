package com.taobao.accs.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p193d.C4091a;
import com.taobao.accs.utl.ALog;

public class BaseService extends Service {
    private static final String TAG = "BaseService";
    IBaseService mBaseService;

    public BaseService() {
        this.mBaseService = null;
    }

    public IBinder onBind(Intent intent) {
        ALog.m16901d(TAG, "onBind:" + intent, new Object[0]);
        return this.mBaseService.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        try {
            this.mBaseService = (IBaseService) C4091a.m16693a().m16696a(getApplicationContext()).loadClass(Constants.SERVICE_IMPL_NAME).getDeclaredConstructor(new Class[]{Service.class}).newInstance(new Object[]{this});
            if (this.mBaseService == null) {
                try {
                    this.mBaseService = (IBaseService) Class.forName(Constants.SERVICE_IMPL_NAME).getDeclaredConstructor(new Class[]{Service.class}).newInstance(new Object[]{this});
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        ALog.m16901d(TAG, "onCreate", new Object[0]);
        if (this.mBaseService != null) {
            this.mBaseService.onCreate();
        } else {
            ALog.m16903e(TAG, "cann't start ServiceImpl!", new Object[0]);
        }
    }

    public void onDestroy() {
        if (this.mBaseService != null) {
            this.mBaseService.onDestroy();
            this.mBaseService = null;
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mBaseService != null) {
            return this.mBaseService.onStartCommand(intent, i, i2);
        }
        ALog.m16903e(TAG, "onStartCommand mBaseService null", new Object[0]);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        return this.mBaseService.onUnbind(intent);
    }
}
