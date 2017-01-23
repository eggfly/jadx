package com.taobao.accs.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

public class MsgDistributeService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            ALog.m16904i("MsgDistributeService", "onStartCommand", PushConsts.CMD_ACTION, intent.getAction());
            if (TextUtils.isEmpty(intent.getAction()) || !TextUtils.equals(intent.getAction(), Constants.ACTION_SEND)) {
                C4095e.m16711a(getApplicationContext(), intent);
                return 2;
            }
            ACCSManager.getManagerImpl(getApplicationContext()).sendRequest(getApplicationContext(), (AccsRequest) intent.getSerializableExtra(Constants.KEY_SEND_REQDATA), intent.getStringExtra(Constants.KEY_PACKAGE_NAME), false);
            return 2;
        } catch (Throwable th) {
            ALog.m16902e("MsgDistributeService", "onStartCommand", th, new Object[0]);
        }
    }
}
