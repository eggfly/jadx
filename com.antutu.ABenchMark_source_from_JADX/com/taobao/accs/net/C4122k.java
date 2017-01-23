package com.taobao.accs.net;

import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;

/* renamed from: com.taobao.accs.net.k */
class C4122k implements Runnable {
    final /* synthetic */ C4120i f13789a;

    C4122k(C4120i c4120i) {
        this.f13789a = c4120i;
    }

    public void run() {
        try {
            if (this.f13789a.b != null) {
                Object appkey = UtilityImpl.getAppkey(this.f13789a.b);
                Object ttId = UtilityImpl.getTtId(this.f13789a.b);
                String appSecret = GlobalClientInfo.getInstance(this.f13789a.b).getAppSecret();
                if (!TextUtils.isEmpty(appkey) && !TextUtils.isEmpty(ttId)) {
                    ALog.m16904i("InAppConnection", "mTryStartServiceRunable bindapp", new Object[0]);
                    ACCSManager.bindApp(this.f13789a.b, appkey, appSecret, ttId, GlobalClientInfo.getInstance(this.f13789a.b).getAppReceiver());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
